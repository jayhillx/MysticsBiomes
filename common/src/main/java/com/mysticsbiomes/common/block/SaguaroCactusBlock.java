package com.mysticsbiomes.common.block;

import com.mysticsbiomes.common.block.util.VoxelShapeUtils;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Function;

public class SaguaroCactusBlock extends Block {
    private static final IntegerProperty AGE = BlockStateProperties.AGE_15;
    private static final BooleanProperty CUT = BooleanProperty.create("cropped");
    private static final BooleanProperty NATURAL = BooleanProperty.create("natural");
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<Shape> SHAPE = EnumProperty.create("shape", Shape.class);
    private static final VoxelShape TRUNK_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    private static final VoxelShape VERTICAL_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
    private static final Function<Direction, VoxelShape> HORIZONTAL_SHAPE = VoxelShapeUtils.createShapeRotator(
            Block.box(3.0D, 3.0D, 3.0D, 13.0D, 13.0D, 18.0D)
    );
    private static final Function<Direction, VoxelShape> CURVED_SHAPE = VoxelShapeUtils.createShapeRotator(
            Shapes.or(Block.box(3.0D, 3.0D, 3.0D, 13.0D, 13.0D, 18.0D), Block.box(3.0D, 3.0D, 3.0D, 13.0D, 16.0D, 13.0D)
    ));

    public SaguaroCactusBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(CUT, false).setValue(NATURAL, false).setValue(FACING, Direction.NORTH).setValue(SHAPE, Shape.TRUNK));
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(NATURAL) && !state.getValue(CUT);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isLoaded(pos) || !this.isRandomlyTicking(state)) return;

        int height = 0;
        while (height < 7 && level.getBlockState(pos.below(height)).is(this)) {
            height++;
        }

        BlockPos abovePos = pos.above();
        final boolean hasBlossomAbove = level.getBlockState(abovePos).is(MysticBlocks.SAGUARO_BLOSSOM.get());
        if (level.isEmptyBlock(abovePos) && abovePos.getY() < level.getMaxBuildHeight() - 1) {
            int age = state.getValue(AGE);
            if (age == 15) {
                level.setBlock(pos, state.setValue(AGE, 0), 4);
                if (state.getValue(SHAPE).isBranch()) {
                    if (height < 2) {
                        level.setBlockAndUpdate(abovePos, state.setValue(SHAPE, Shape.VERTICAL));
                    }
                } else {
                    level.setBlockAndUpdate(abovePos, state.setValue(SHAPE, Shape.TRUNK));

                    if (hasBlossomAbove) {
                        level.setBlockAndUpdate(abovePos.above(), MysticBlocks.SAGUARO_BLOSSOM.get().defaultBlockState());
                    }
                }

                if (height == 2 && !state.getValue(SHAPE).isBranch()) { /// chance for a branch to naturally grow the second level of the cactus.
                    for (Direction direction : Direction.Plane.HORIZONTAL) {
                        if (random.nextInt(2) == 0) {
                            BlockPos branchPos = pos.relative(direction);
                            if (level.isEmptyBlock(branchPos)) {
                                level.setBlockAndUpdate(branchPos, state.setValue(FACING, direction).setValue(SHAPE, Shape.VERTICAL));
                            }
                        }
                    }
                }

                if (random.nextInt(8) == 0 && !hasBlossomAbove) {
                    level.setBlockAndUpdate(abovePos, MysticBlocks.SAGUARO_BLOSSOM.get().defaultBlockState());
                }
            } else {
                level.setBlock(pos, state.setValue(AGE, age + 1), 4);
            }
        }
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState belowState = level.getBlockState(pos.below());
        boolean isBranch = state.getValue(SHAPE).isBranch();

        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockState relativeState = level.getBlockState(pos.relative(direction));

            if (relativeState.isSolid() && relativeState.getBlock() instanceof SaguaroCactusBlock) {
                if (!belowState.isAir() || state.getValue(SHAPE) == Shape.VERTICAL || state.getValue(SHAPE) == Shape.CURVED) {
                    return isBranch || relativeState.getValue(SHAPE).isBranch();
                }
            }
        }

        if (isBranch) {
            if (belowState.is(this) && belowState.getValue(SHAPE).isBranch()) {
                return !belowState.isAir();
            }
        }

        return belowState.is(this) || (!isBranch && belowState.is(BlockTags.SAND));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        Direction clickedFace = context.getClickedFace();
        BlockState clickState = level.getBlockState(context.getClickedPos().relative(clickedFace.getOpposite()));

        BlockState state = this.defaultBlockState();
        if (clickState.is(this)) {
            if (clickedFace.getAxis().isHorizontal() && clickState.getValue(SHAPE) == Shape.TRUNK) {
                if (clickedFace.getAxis().isHorizontal()) {
                    state = state.setValue(SHAPE, Shape.HORIZONTAL).setValue(FACING, clickedFace);
                }
            }

            if (clickedFace == Direction.UP) {
                state = state.setValue(SHAPE, clickState.getValue(SHAPE));
            }
        }

        return state;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor level, BlockPos pos, BlockPos pos1) {
        if (!state.canSurvive(level, pos)) {
            return Blocks.AIR.defaultBlockState();
        } else {
            BlockState aboveState = level.getBlockState(pos.above());

            if (aboveState.is(this) || aboveState.is(MysticBlocks.SAGUARO_BLOSSOM.get())) {
                if (state.getValue(SHAPE) == Shape.HORIZONTAL) {
                    state = state.setValue(SHAPE, Shape.CURVED);
                }
            } else {
                if (state.getValue(SHAPE) == Shape.CURVED) {
                    state = state.setValue(SHAPE, Shape.HORIZONTAL);
                }
            }

            return state;
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(SHAPE)) {
            case TRUNK -> TRUNK_SHAPE;
            case VERTICAL -> VERTICAL_SHAPE;
            case HORIZONTAL -> HORIZONTAL_SHAPE.apply(state.getValue(FACING));
            case CURVED -> CURVED_SHAPE.apply(state.getValue(FACING));
        };
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return this.getShape(state, level, pos, context);
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
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        entity.hurt(level.damageSources().cactus(), 1.0F);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE, CUT, NATURAL, FACING, SHAPE);
    }

    public enum Shape implements StringRepresentable {
        TRUNK("trunk", false),
        VERTICAL("vertical", true),
        HORIZONTAL("horizontal", true),
        CURVED("curved", true);

        private final String name;
        private final boolean branch;

        Shape(final String name, final boolean isBranch) {
            this.name = name;
            this.branch = isBranch;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }

        public boolean isBranch() {
            return this.branch;
        }
    }

}