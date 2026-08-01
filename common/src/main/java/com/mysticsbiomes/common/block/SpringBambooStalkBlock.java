package com.mysticsbiomes.common.block;

import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SpringBambooStalkBlock extends Block implements BonemealableBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_2;
    public static final IntegerProperty STAGE = BlockStateProperties.STAGE;
    public static final BooleanProperty NATURAL = BooleanProperty.create("natural");
    public static final EnumProperty<BambooLeaves> LEAVES = BlockStateProperties.BAMBOO_LEAVES;
    protected static final VoxelShape SMALL_SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
    protected static final VoxelShape LARGE_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
    protected static final VoxelShape COLLISION_SHAPE = Block.box(6.5D, 0.0D, 6.5D, 9.5D, 16.0D, 9.5D);

    public SpringBambooStalkBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(STAGE, 0).setValue(NATURAL, false).setValue(LEAVES, BambooLeaves.NONE));
    }
    
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        VoxelShape shape = state.getValue(AGE) > 1 ? LARGE_SHAPE : SMALL_SHAPE;
        Vec3 offset = state.getOffset(level, pos);
        return shape.move(offset.x, offset.y, offset.z);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.getOffset(level, pos);
        return COLLISION_SHAPE.move(offset.x, offset.y, offset.z);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        LevelAccessor level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        if (!level.getFluidState(pos).isEmpty()) {
            return null;
        } else {
            BlockState belowState = level.getBlockState(pos.below());

            if (belowState.canSurvive(level, pos)) {
                if (belowState.is(MysticBlocks.SPRING_BAMBOO_SAPLING.get())) {
                    return this.defaultBlockState().setValue(AGE, 0);
                } else if (belowState.is(this)) {
                    return this.defaultBlockState().setValue(AGE, belowState.getValue(AGE) > 0 ? 1 : 0);
                } else {
                    BlockState aboveState = level.getBlockState(pos.above());
                    return aboveState.is(this) ? this.defaultBlockState().setValue(AGE, aboveState.getValue(AGE)) : MysticBlocks.SPRING_BAMBOO_SAPLING.get().defaultBlockState();
                }
            } else {
                return null;
            }
        }
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor level, BlockPos pos, BlockPos pos2) {
        if (!state.canSurvive(level, pos)) {
            level.scheduleTick(pos, this, 1);
        }

        if (direction == Direction.UP && state2.is(this) && state2.getValue(AGE) > state.getValue(AGE)) {
            level.setBlock(pos, state.cycle(AGE), 2);
        }

        return super.updateShape(state, direction, state2, level, pos, pos2);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(STAGE) == 0 && !state.getValue(NATURAL);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isLoaded(pos)) return;

        if (state.getValue(STAGE) == 0 && level.isEmptyBlock(pos.above()) && level.getRawBrightness(pos.above(), 0) >= 9) {
            int i = this.getHeightBelowUpToMax(level, pos) + 1;
            if (i < 16 && random.nextInt(3) == 0) {
                this.growBamboo(state, level, pos, random, i);
            }
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!state.canSurvive(level, pos)) {
            level.destroyBlock(pos, true);
        }
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState belowState = level.getBlockState(pos.below());
        return belowState.is(BlockTags.DIRT) || belowState.is(BlockTags.SAND) || belowState.is(MysticBlocks.SPRING_BAMBOO.get()) || belowState.is(MysticBlocks.SPRING_BAMBOO_SAPLING.get());
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter level, BlockPos pos) {
        return true;
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType BlockPathTypes) {
        return false;
    }

    @Override
    public boolean isCollisionShapeFullBlock(BlockState state, BlockGetter level, BlockPos pos) {
        return false;
    }

    @Override
    public float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        return player.getMainHandItem().getItem() instanceof SwordItem ? 1.0F : super.getDestroyProgress(state, player, level, pos);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE, STAGE, NATURAL, LEAVES);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean valid) {
        int above = this.getHeightAboveUpToMax(level, pos);
        int below = this.getHeightBelowUpToMax(level, pos);
        return above + below + 1 < 16 && level.getBlockState(pos.above(above)).getValue(STAGE) != 1;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource source, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        int above = this.getHeightAboveUpToMax(level, pos);
        int below = this.getHeightBelowUpToMax(level, pos);
        int height = above + below + 1;
        int count = 1 + random.nextInt(2);

        for (int step = 0; step < count; step++) {
            BlockPos abovePos = pos.above(above);
            BlockState aboveState = level.getBlockState(abovePos);
            if (height >= 16 || aboveState.getValue(STAGE) == 1 || !level.isEmptyBlock(abovePos.above())) {
                return;
            }

            this.growBamboo(aboveState, level, abovePos, random, height);
            ++above;
            ++height;
        }
    }

    protected void growBamboo(BlockState state, Level level, BlockPos pos, RandomSource random, int height) {
        BlockState belowState = level.getBlockState(pos.below());
        BlockState belowBelowState = level.getBlockState(pos.below().below());
        BambooLeaves leaves = BambooLeaves.NONE;
        if (height >= 1) {
            if (belowState.is(MysticBlocks.SPRING_BAMBOO.get()) && belowState.getValue(LEAVES) != BambooLeaves.NONE) {
                if (belowState.is(MysticBlocks.SPRING_BAMBOO.get()) && belowState.getValue(LEAVES) != BambooLeaves.NONE) {
                    leaves = BambooLeaves.LARGE;
                    if (belowBelowState.is(MysticBlocks.SPRING_BAMBOO.get())) {
                        level.setBlock(pos.below(), belowState.setValue(LEAVES, BambooLeaves.SMALL), 3);
                        level.setBlock(pos.below(2), belowBelowState.setValue(LEAVES, BambooLeaves.NONE), 3);
                    }
                }
            } else {
                leaves = BambooLeaves.SMALL;
            }
        }

        int age = state.getValue(AGE) != 1 && !belowBelowState.is(MysticBlocks.SPRING_BAMBOO.get()) ? 0 : 1;
        int stage = (height < 11 || !(random.nextFloat() < 0.25F)) && height != 15 ? 0 : 1;
        level.setBlock(pos.above(), this.defaultBlockState().setValue(AGE, age).setValue(LEAVES, leaves).setValue(STAGE, stage), 3);
    }

    protected int getHeightAboveUpToMax(BlockGetter level, BlockPos pos) {
        int i = 0;
        while (i < 16 && level.getBlockState(pos.above(i + 1)).is(MysticBlocks.SPRING_BAMBOO.get())) {
            i++;
        }

        return i;
    }

    protected int getHeightBelowUpToMax(BlockGetter level, BlockPos pos) {
        int i = 0;
        while (i < 16 && level.getBlockState(pos.below(i + 1)).is(MysticBlocks.SPRING_BAMBOO.get())) {
            i++;
        }

        return i;
    }

}