package com.mysticsbiomes.common.block;

import com.mysticsbiomes.init.MysticItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * when placed on a moisturized farmland block with perfect condition, it will have a 25% chance to
 */
public class StrawberryBushBlock extends BushBlock implements BonemealableBlock {
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 5);
    public static final IntegerProperty SPEED = IntegerProperty.create("growth_speed", 0, 300);
    public static final BooleanProperty CUT = BooleanProperty.create("cropped");
    public static final BooleanProperty CONDITION = BooleanProperty.create("perfect_condition");
    public static final BooleanProperty MODIFIED = BooleanProperty.create("modified");
    public static final BooleanProperty SWEET = BooleanProperty.create("sweet");
    public static final VoxelShape SPROUT_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 5.0D, 13.0D);
    public static final VoxelShape FLOWER_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 7.0D, 13.0D);
    public static final VoxelShape FULL_GROWN_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 11.0D, 14.0D);

    public StrawberryBushBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(SPEED, 150).setValue(CUT, false).setValue(CONDITION, false).setValue(MODIFIED, false).setValue(SWEET, false));
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter getter, BlockPos pos, BlockState state) {
        return new ItemStack(MysticItems.STRAWBERRY.get());
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = this.defaultBlockState();

        int speed = (int)this.calculateGrowthSpeed(level, pos);
        state = state.setValue(SPEED, speed);

        if (speed <= 100) {
            state = state.setValue(CONDITION, true);
        }

        return state;
    }
    
    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(AGE) < 5 && !state.getValue(CUT);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isLoaded(pos)) return;

        if (state.getValue(AGE) < 5 && level.getRawBrightness(pos, 0) >= 4) {
            if (random.nextInt() == 0) {
                state = state.setValue(AGE, state.getValue(AGE) + 1);
            }

            level.setBlock(pos, state, 2 | 11);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(state));
        }
    }

    /**
     * calculates the growth speed of the plant based on environmental factors.
     *
     * speed is determined by the biomes current temperature. if it is too cold, the plant does not grow at all unless it's indoors.
     * plant grows faster if planted on fertile farmland.
     *
     * @return the tick chance the plant will grow.
     */
    private float calculateGrowthSpeed(Level level, BlockPos pos) {
        float temperature = level.getBiome(pos).value().getBaseTemperature();
        float speed = (int)(100.0F / (temperature / 0.95F));

        BlockPos belowPos = pos.below();
        BlockState belowState = level.getBlockState(belowPos);
        boolean fertile = this.isOnFarmland(belowState);
        speed = fertile ? speed * 0.75F : speed;
        return Mth.clamp(speed, 0, 300);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        VoxelShape shape;
        if (state.getValue(AGE) < 2) {
            shape = SPROUT_SHAPE;
        } else if (state.getValue(AGE) == 2) {
            shape = FLOWER_SHAPE;
        } else {
            shape = FULL_GROWN_SHAPE;
        }

        Vec3 offset = state.getOffset(getter, pos);
        return shape.move(offset.x, offset.y, offset.z);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        ItemStack stack = player.getUseItem();

        /// cut the plant to prevent it from growing.
        if (stack.is(Items.SHEARS) && !state.getValue(CUT)) {
            if (player instanceof ServerPlayer serverPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, pos, stack);
            }

            stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));
            level.setBlock(pos, state.setValue(CUT, true), 11);
            level.playSound(player, pos, SoundEvents.GROWING_PLANT_CROP, SoundSource.BLOCKS, 1.0F, 1.0F);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        if (state.getValue(AGE) == 5) {
            /// 50% chance to drop a sweet strawberry even if it's perfect condition and sweet.
            if (this.isOnFarmland(level.getBlockState(pos.below())) && state.getValue(CONDITION) && state.getValue(SWEET) && level.random.nextFloat() < 0.5D) {
                popResource(level, pos, new ItemStack(MysticItems.SWEET_STRAWBERRY.get(), 1));
            }

            popResource(level, pos, new ItemStack(MysticItems.STRAWBERRY.get(), 1 + level.random.nextInt(3)));
            level.setBlock(pos, state.setValue(AGE, 2), 2);
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return InteractionResult.PASS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE).add(SPEED).add(CUT).add(CONDITION).add(MODIFIED).add(SWEET);
    }

    private boolean isOnFarmland(BlockState state) {
        return state.is(Blocks.FARMLAND) && state.getValue(FarmBlock.MOISTURE) > 0;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean valid) {
        return state.getValue(AGE) < 5;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        int age = Math.min(5, state.getValue(AGE) + 1);
        /// set the plant to modified, preventing the plant from naturally producing a sweet strawberry.
        level.setBlock(pos, state.setValue(AGE, age).setValue(MODIFIED, true).setValue(CONDITION, false), 5);
    }

}