package com.mysticsbiomes.common.block;

import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class SaguaroCactusBlock extends CactusBlock {
    public static final IntProperty AGE = Properties.AGE_15;
    public static final EnumProperty<BranchShape> ATTACHMENT = EnumProperty.of("shape", BranchShape.class);
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final BooleanProperty BRANCH = BooleanProperty.of("branch");
    public static final BooleanProperty NATURAL = BooleanProperty.of("natural");
    public static final BooleanProperty CUT = BooleanProperty.of("cropped");
    public static final BooleanProperty TOP = BooleanProperty.of("top");

    public SaguaroCactusBlock(AbstractBlock.Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, 0).with(ATTACHMENT, BranchShape.BASE).with(FACING, Direction.NORTH).with(BRANCH, false).with(NATURAL, false).with(CUT, false).with(TOP, true));
    }

    @Override
    public void randomTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        BlockPos abovePos = pos.up();
        boolean hasBlossomAbove = level.getBlockState(abovePos).isOf(MysticBlocks.SAGUARO_BLOSSOM);

        if (!state.get(NATURAL) && !state.get(CUT) && (level.isAir(abovePos) || hasBlossomAbove)) {
            int height;
            for (height = 1; level.getBlockState(pos.down(height)).isOf(this); ++height) {}

            if (height < 5) {
                int age = state.get(AGE);
                if (age == 15) {
                    level.setBlockState(pos, state.with(AGE, 0), 4);

                    BlockState blockState = this.getDefaultState();
                    if (state.get(BRANCH)) {
                        if (height < 2) {
                            level.setBlockState(abovePos, blockState.with(ATTACHMENT, BranchShape.BRANCH).with(BRANCH, true));
                        }
                    } else {
                        level.setBlockState(abovePos, blockState.with(ATTACHMENT, BranchShape.BASE));

                        if (hasBlossomAbove) {
                            level.setBlockState(abovePos.up(), MysticBlocks.SAGUARO_BLOSSOM.getDefaultState());
                        }
                    }

                    if (height == 2 && !state.get(BRANCH)) {
                        for (Direction direction : Direction.Type.HORIZONTAL) {
                            if (random.nextInt(2) == 0) {
                                BlockPos branchPos = pos.offset(direction);
                                if (level.isAir(branchPos)) {
                                    level.setBlockState(branchPos, blockState.with(FACING, direction.getOpposite()).with(ATTACHMENT, BranchShape.BASE_BRANCH).with(BRANCH, true));
                                }
                            }
                        }
                    }

                    if (random.nextInt(8) == 0 && !hasBlossomAbove) {
                        level.setBlockState(abovePos, MysticBlocks.SAGUARO_BLOSSOM.getDefaultState());
                    }
                } else {
                    level.setBlockState(pos, state.with(AGE, age + 1), 4);
                }
            }
        }
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView level, BlockPos pos) {
        for (Direction direction : Direction.Type.HORIZONTAL) {
            BlockState relativeState = level.getBlockState(pos.offset(direction));
            if (relativeState.isSolid()) {
                if (relativeState.getBlock() instanceof SaguaroCactusBlock) {
                    if (!level.getBlockState(pos.down()).isAir() || state.get(ATTACHMENT) == BranchShape.BASE_BRANCH || state.get(ATTACHMENT) == BranchShape.BASE_BRANCH_UPWARD) {
                        return state.get(BRANCH) || (!state.get(BRANCH) && relativeState.get(BRANCH));
                    }
                }
            }
        }

        BlockState belowState = level.getBlockState(pos.down());
        if (state.get(BRANCH)) {
            BlockPos relativePos = pos.offset(state.get(FACING).getOpposite());
            BlockState relativeState = level.getBlockState(relativePos);

            if (relativeState.getBlock() instanceof SaguaroCactusBlock) {
                if (relativeState.get(ATTACHMENT) == BranchShape.BASE || relativeState.get(ATTACHMENT) == BranchShape.BASE_BRANCH_UPWARD) {
                    return true;
                }
            }

            if (belowState.getBlock() instanceof SaguaroCactusBlock) {
                BranchShape belowShape = belowState.get(ATTACHMENT);
                return belowShape == BranchShape.BRANCH || belowShape == BranchShape.BASE_BRANCH || belowShape == BranchShape.BASE_BRANCH_UPWARD;
            }
        }
        return belowState.isOf(this) || (!state.get(BRANCH) && belowState.isIn(BlockTags.SAND));
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState state2, WorldAccess level, BlockPos pos, BlockPos pos1) {
        if (state.getBlock() instanceof SaguaroCactusBlock) {
            if (state.get(ATTACHMENT) == BranchShape.BASE_BRANCH) {
                return state.with(ATTACHMENT, BranchShape.BASE_BRANCH_UPWARD);
            }
        }

        if (level.getBlockState(pos.up()).getBlock() instanceof SaguaroCactusBlock) {
            state = state.with(TOP, false);
        } else {
            state = state.with(TOP, true);
        }

        if (!state.canPlaceAt(level, pos)) {
            level.breakBlock(pos, true);
        }
        return state;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockState oppositeFace = context.getWorld().getBlockState(context.getBlockPos().offset(context.getSide().getOpposite()));
        BlockPos abovePos = context.getBlockPos().up();
        BlockState aboveState = context.getWorld().getBlockState(abovePos);

        boolean flag = !aboveState.isAir();
        BlockState state = this.getDefaultState().with(TOP, flag);
        if (oppositeFace.isOf(this)) {
            if (oppositeFace.get(ATTACHMENT) == BranchShape.BASE && context.getSide() == Direction.UP) {
                state = this.getDefaultState().with(ATTACHMENT, BranchShape.BASE).with(TOP, flag);
            }

            if (oppositeFace.get(ATTACHMENT) == BranchShape.BASE && context.getSide().getAxis().isHorizontal()) {
                state = this.getDefaultState().with(BRANCH, true).with(TOP, flag).with(ATTACHMENT, BranchShape.BASE_BRANCH).with(FACING, context.getSide().getOpposite());
            }

            if (oppositeFace.get(ATTACHMENT).ordinal() >= BranchShape.BASE_BRANCH.ordinal() && context.getSide() == Direction.UP) {
                state = this.getDefaultState().with(BRANCH, true).with(TOP, flag).with(ATTACHMENT, BranchShape.BRANCH).with(FACING, oppositeFace.get(FACING));
            }
        }
        return state;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView getter, BlockPos pos, ShapeContext context) {
        return this.getOutlineShape(state, getter, pos, context);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView getter, BlockPos pos, ShapeContext context) {
        if (state.get(ATTACHMENT) == BranchShape.BASE_BRANCH) {
            return switch (state.get(FACING)) {
                case NORTH -> Block.createCuboidShape(3.0D, 2.0D, -2.0D, 13.0D, 12.0D, 13.0D);
                case SOUTH -> Block.createCuboidShape(3.0D, 2.0D, 3.0D, 13.0D, 12.0D, 18.0D);
                case WEST -> Block.createCuboidShape(-2.0D, 2.0D, 3.0D, 13.0D, 12.0D, 13.0D);
                default -> Block.createCuboidShape(3.0D, 2.0D, 3.0D, 18.0D, 12.0D, 13.0D);
            };
        } else if (state.get(ATTACHMENT) == BranchShape.BASE_BRANCH_UPWARD) {
            return switch (state.get(FACING)) {
                case NORTH -> VoxelShapes.union(Block.createCuboidShape(3.0D, 2.0D, -2.0D, 13.0D, 12.0D, 13.0D), Block.createCuboidShape(3.0D, 2.0D, 3.0D, 13.0D, 16.0D, 13.0D));
                case SOUTH -> VoxelShapes.union(Block.createCuboidShape(3.0D, 2.0D, 3.0D, 13.0D, 12.0D, 18.0D), Block.createCuboidShape(3.0D, 2.0D, 3.0D, 13.0D, 16.0D, 13.0D));
                case WEST -> VoxelShapes.union(Block.createCuboidShape(-2.0D, 2.0D, 3.0D, 13.0D, 12.0D, 13.0D), Block.createCuboidShape(3.0D, 2.0D, 3.0D, 13.0D, 16.0D, 13.0D));
                default -> VoxelShapes.union(Block.createCuboidShape(3.0D, 2.0D, 3.0D, 18.0D, 12.0D, 13.0D), Block.createCuboidShape(3.0D, 2.0D, 3.0D, 13.0D, 16.0D, 13.0D));
            };
        } else if (state.get(ATTACHMENT) == BranchShape.BRANCH) {
            return Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
        } else {
            return Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult result) {
        ItemStack stack = player.getStackInHand(hand);

        if (stack.isOf(Items.SHEARS) && !state.get(CUT)) {
            level.setBlockState(pos, state.with(CUT, true), 11);
            if (!player.isCreative()) {
                stack.damage(1, player, (p) -> p.getStackInHand(hand));
            }

            level.playSound(player, pos, SoundEvents.BLOCK_GROWING_PLANT_CROP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return ActionResult.success(level.isClient);
        } else {
            return ActionResult.PASS;
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE, ATTACHMENT, FACING, BRANCH, NATURAL, CUT, TOP);
    }

    public enum BranchShape implements StringIdentifiable {
        BASE("base"),
        BASE_BRANCH("base_branch"),
        BASE_BRANCH_UPWARD("base_branch_upward"),
        BRANCH("branch");

        private final String name;

        BranchShape(String name) {
            this.name = name;
        }

        @Override
        public String asString() {
            return this.name;
        }
    }

}