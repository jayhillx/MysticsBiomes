package com.mysticsbiomes.common.block;

import com.mysticsbiomes.common.block.property.GrowthSpeedTierProperty;
import com.mysticsbiomes.init.MysticBlocks;
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
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WildStrawberryBushBlock extends BushBlock implements BonemealableBlock {
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 5);
    public static final BooleanProperty CUT = BooleanProperty.create("cropped");
    public static final EnumProperty<GrowthSpeedTierProperty> SPEED = EnumProperty.create("speed", GrowthSpeedTierProperty.class);
    protected static final VoxelShape SPROUT_SHAPE = Block.box(4.0D, 0.0D, 4.0D, 13.0D, 4.0D, 13.0D);
    protected static final VoxelShape FLOWER_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 5.0D, 13.0D);
    protected static final VoxelShape GROWN_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 7.0D, 14.0D);

    public WildStrawberryBushBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(AGE, 0)
                .setValue(CUT, false)
                .setValue(SPEED, GrowthSpeedTierProperty.TIER_3)
        );
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        return new ItemStack(MysticItems.STRAWBERRY.get());
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        BlockState belowState = level.getBlockState(pos.below());
        if (belowState.is(Blocks.FARMLAND) || belowState.getBlock() instanceof FarmBlock) {
            return MysticBlocks.STRAWBERRY_BUSH.get().getStateForPlacement(context);
        }

        return this.defaultBlockState().setValue(SPEED, this.getGrowthTier(level, pos));
    }

    protected GrowthSpeedTierProperty getGrowthTier(Level level, BlockPos pos) {
        return GrowthSpeedTierProperty.fromTemperature(this.getTemperature(level, pos));
    }

    /**
     * calculates the growth speed of the plant based on environmental factors.
     * @return the tick chance the plant will grow.
     */
    protected float calculateGrowthSpeed(Level level, BlockPos pos) {
        float temperature = this.getTemperature(level, pos);
        float lightAmount = this.getLightFactor(level, pos);

        return temperature + lightAmount; /// light level will act like a boost.
    }

    protected float getTemperature(Level level, BlockPos pos) {
        float temperature = level.getBiome(pos).value().getBaseTemperature();
        return Mth.clamp(temperature, 0.0F, 2.0F);
    }

    protected float getLightFactor(Level level, BlockPos pos) {
        int light = level.getRawBrightness(pos, 0);
        return 0.5F + (light / 15.0F);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(AGE) < 5 && !state.getValue(CUT);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isLoaded(pos)) return;

        GrowthSpeedTierProperty speedTier = this.getGrowthTier(level, pos);
        if (state.getValue(SPEED) != speedTier) {
            state = state.setValue(SPEED, speedTier);
        }

        float growChance = speedTier.growthChance();
        this.onGrow(state, level, pos, random, growChance);
    }

    protected void onGrow(BlockState state, ServerLevel level, BlockPos pos, RandomSource random, float growthSpeed) {
        if (state.getValue(AGE) < 5) {
            if (random.nextFloat() == growthSpeed) {
                state = state.setValue(AGE, state.getValue(AGE) + 1);
            }

            level.setBlock(pos, state, 2 | 11);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(state));
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.getOffset(level, pos);
        return this.getShape(state).move(offset.x, offset.y, offset.z);
    }

    protected VoxelShape getShape(BlockState state) {
        VoxelShape shape;
        if (state.getValue(AGE) < 2) {
            shape = SPROUT_SHAPE;
        } else if (state.getValue(AGE) == 2) {
            shape = FLOWER_SHAPE;
        } else {
            shape = GROWN_SHAPE;
        }

        return shape;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        ItemStack stack = player.getUseItem();

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
            int amount = 1 + level.random.nextInt(3);
            popResource(level, pos, new ItemStack(MysticItems.STRAWBERRY.get(), amount));

            level.setBlock(pos, state.setValue(AGE, 2), 3);
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return InteractionResult.PASS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE, CUT, SPEED);
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
        level.setBlock(pos, state.setValue(AGE, age), 3);
    }

}