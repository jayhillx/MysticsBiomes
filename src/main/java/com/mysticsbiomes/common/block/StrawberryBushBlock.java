package com.mysticsbiomes.common.block;

import com.mysticsbiomes.init.MysticItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.Tags;

@SuppressWarnings("deprecation")
public class StrawberryBushBlock extends BushBlock implements BonemealableBlock {
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 6);
    public static final BooleanProperty CUT = BooleanProperty.create("cropped");
    private static final VoxelShape SEEDLING_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 5.0D, 13.0D);
    private static final VoxelShape FLOWERING_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 9.0D, 13.0D);
    private static final VoxelShape MATURE_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 11.0D, 14.0D);
    private boolean hasPerfectConditions;

    public StrawberryBushBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(CUT, false));
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        if (state.getValue(AGE) < 3) {
            return SEEDLING_SHAPE;
        } else {
            return state.getValue(AGE) < 5 ? FLOWERING_SHAPE : MATURE_SHAPE;
        }
    }

    public ItemStack getCloneItemStack(BlockGetter getter, BlockPos pos, BlockState state) {
        return new ItemStack(MysticItems.STRAWBERRY.get());
    }

    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(AGE) < 6 && !state.getValue(CUT);
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (state.getValue(AGE) < 6) {
            float f = this.getGrowthSpeed(level, pos);

            this.hasPerfectConditions = f <= 112 && level.getRawBrightness(pos.above(), 0) >= 7 && !this.hasPerfectConditions;
            if (ForgeHooks.onCropsGrowPre(level, pos, state, random.nextInt((int) f) == 0)) {
                level.setBlock(pos, state.setValue(AGE, state.getValue(AGE) + 1), 2);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(state));
                ForgeHooks.onCropsGrowPost(level, pos, state);
            }
        }
    }

    /**
     * This gets the number based from the biomes temperature and if it's on top of soil.
     */
    private float getGrowthSpeed(Level level, BlockPos pos) {
        float temperature = level.getBiome(pos).get().getBaseTemperature();
        float brightness = level.getRawBrightness(pos.above(), 0);
        float speed = 112;

        if (temperature < 0.95F && brightness >= 7) {
            speed = speed / temperature;
        } else if (temperature <= 0) {
            speed = 999999;
        }

        BlockState belowState = level.getBlockState(pos.below());
        boolean fertile = belowState.canSustainPlant(level, pos.below(), Direction.UP, this) && belowState.isFertile(level, pos);
        return fertile ? speed * 0.65F : speed;
    }

    /**
     * Crop the plant to keep its current state, or harvest it when it's at max age.
     */
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        ItemStack stack = player.getItemInHand(hand);
        if (stack.is(Tags.Items.SHEARS) && !state.getValue(CUT)) {
            if (player instanceof ServerPlayer serverPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, pos, stack);
            }

            level.setBlock(pos, state.setValue(CUT, Boolean.TRUE), 11);
            stack.hurtAndBreak(1, player, (blockState) -> blockState.broadcastBreakEvent(hand));
            level.playSound(player, pos, SoundEvents.GROWING_PLANT_CROP, SoundSource.BLOCKS, 1.0F, 1.0F);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        if (state.getValue(AGE) == 6) {
            if (this.hasPerfectConditions && level.random.nextInt(82) == 0) {
                popResource(level, pos, new ItemStack(MysticItems.SWEET_STRAWBERRY.get(), 1));
            }

            popResource(level, pos, new ItemStack(MysticItems.STRAWBERRY.get(), 1 + level.random.nextInt(3)));
            level.setBlock(pos, state.setValue(AGE, 2), 2);
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return super.use(state, level, pos, player, hand, result);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE).add(CUT);
    }

    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean valid) {
        return state.getValue(AGE) < 6;
    }

    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        int i = Math.min(6, state.getValue(AGE) + 1);
        level.setBlock(pos, state.setValue(AGE, i), 6);
        this.hasPerfectConditions = false;
    }

}