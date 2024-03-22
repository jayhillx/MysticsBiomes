package com.mysticsbiomes.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PricklyPearBlock extends CactusBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_15;
    public static final EnumProperty<BranchShape> ATTACHMENT = EnumProperty.create("shape", BranchShape.class);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public PricklyPearBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(ATTACHMENT, BranchShape.BASE).setValue(FACING, Direction.NORTH));
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockState relativeState = level.getBlockState(pos.relative(direction));
            if (!relativeState.isAir()) {
                return relativeState.getBlock() instanceof PricklyPearBlock && relativeState.getValue(ATTACHMENT) == BranchShape.BASE;
            }
        }

        BlockState belowState = level.getBlockState(pos.below());
        return belowState.is(this) || belowState.is(BlockTags.SAND);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource source) {
        if (state.getValue(ATTACHMENT) == BranchShape.BASE) {
            super.randomTick(state, level, pos, source);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState oppositeFace = context.getLevel().getBlockState(context.getClickedPos().relative(context.getClickedFace().getOpposite()));

        if (oppositeFace.is(this)) {
            if (oppositeFace.getValue(ATTACHMENT) == BranchShape.BASE && context.getClickedFace() == Direction.UP) {
                return this.defaultBlockState().setValue(ATTACHMENT, BranchShape.BASE);
            } else if (oppositeFace.getValue(ATTACHMENT) == BranchShape.BASE && context.getClickedFace().getAxis().isHorizontal()) {
                return this.defaultBlockState().setValue(ATTACHMENT, BranchShape.BRANCH_BASE).setValue(FACING, context.getClickedFace().getOpposite());
            } else if (oppositeFace.getValue(ATTACHMENT).ordinal() >= BranchShape.BRANCH_BASE.ordinal() && context.getClickedFace() == Direction.UP) {
                return this.defaultBlockState().setValue(ATTACHMENT, BranchShape.TOP_ARM);
            }
        }
        return this.defaultBlockState();
    }

    @Override
    public BlockState updateShape(BlockState state1, Direction direction, BlockState state2, LevelAccessor level, BlockPos pos, BlockPos pos1) {
        BlockState state = level.getBlockState(pos);
        BlockState aboveState = level.getBlockState(pos.above());

        if (state.getBlock() instanceof PricklyPearBlock && aboveState.getBlock() instanceof PricklyPearBlock) {
            if (state.getValue(ATTACHMENT) == BranchShape.BRANCH_BASE) {
                return state1.setValue(ATTACHMENT, BranchShape.BRANCH_BASE_UPWARD);
            } else if (state.getValue(ATTACHMENT) == BranchShape.TOP_ARM && aboveState.getValue(ATTACHMENT) == BranchShape.TOP_ARM) {
                return state1.setValue(ATTACHMENT, BranchShape.BRANCH_ARM);
            }
        }
        return state1;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return getShape(state, getter, pos, context);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return getShape(state);
    }

    private VoxelShape getShape(BlockState state) {
        if (state.getValue(ATTACHMENT) == BranchShape.BRANCH_BASE) {
            return switch (state.getValue(FACING)) {
                case NORTH -> Block.box(3.0D, 2.0D, 0.0D, 13.0D, 12.0D, 13.0D);
                case SOUTH -> Block.box(3.0D, 2.0D, 3.0D, 13.0D, 12.0D, 16.0D);
                case WEST -> Block.box(0.0D, 2.0D, 3.0D, 13.0D, 12.0D, 13.0D);
                default -> Block.box(3.0D, 2.0D, 3.0D, 16.0D, 12.0D, 13.0D);
            };
        } else if (state.getValue(ATTACHMENT) == BranchShape.BRANCH_BASE_UPWARD) {
            return Block.box(3.0D, 2.0D, 3.0D, 13.0D, 16.0D, 13.0D);
        } else if (state.getValue(ATTACHMENT) == BranchShape.BRANCH_ARM) {
            return Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
        } else if (state.getValue(ATTACHMENT) == BranchShape.TOP_ARM) {
            return Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
        } else {
            return Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE, ATTACHMENT, FACING);
    }

    public enum BranchShape implements StringRepresentable {
        BASE("base"),
        BRANCH_BASE("branch_base"),
        BRANCH_BASE_UPWARD("branch_base_upward"),
        BRANCH_ARM("branch_arm"),
        TOP_ARM("top_arm");

        private final String name;

        BranchShape(String name) {
            this.name = name;
        }

        public String getSerializedName() {
            return this.name;
        }
    }

}