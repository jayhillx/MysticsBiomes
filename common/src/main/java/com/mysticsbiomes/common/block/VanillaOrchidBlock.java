package com.mysticsbiomes.common.block;

import com.mysticsbiomes.init.MysticItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VanillaOrchidBlock extends HorizontalDirectionalBlock implements BonemealableBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_2;
    public static final EnumProperty<Shape> SHAPE = EnumProperty.create("shape", Shape.class);

    public VanillaOrchidBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(SHAPE, Shape.BASE).setValue(FACING, Direction.NORTH));
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        return new ItemStack(MysticItems.VANILLA_BEANS.get());
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = this.defaultBlockState();

        for (Direction direction : context.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                state = state.setValue(FACING, direction);

                if (state.canSurvive(context.getLevel(), context.getClickedPos())) {
                    return state;
                }
            }
        }

        return state;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState state1, LevelAccessor level, BlockPos pos, BlockPos pos1) {
        if (!state.canSurvive(level, pos)) {
            return Blocks.AIR.defaultBlockState();
        } else {
            boolean isAbove = level.getBlockState(pos.above()).is(this);
            boolean isBelow = level.getBlockState(pos.below()).is(this);
            if (!isAbove && !isBelow) {
                state = state.setValue(SHAPE, Shape.BASE);
            }

            if (!isAbove && isBelow) {
                state = state.setValue(SHAPE, Shape.TOP);
            }

            if (isAbove && isBelow) {
                state = state.setValue(SHAPE, Shape.MIDDLE);
            }

            if (isAbove && !isBelow) {
                state = state.setValue(SHAPE, Shape.BOTTOM);
            }

            return state;
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case EAST -> Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
            case SOUTH -> Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
            case WEST -> Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
            default -> Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
        };
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState relativePos = level.getBlockState(pos.relative(state.getValue(FACING)));
        return relativePos.is(BlockTags.LOGS);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(AGE) < 2;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isLoaded(pos)) return;

        int height = 0;
        while (height < 5 && level.getBlockState(pos.below(height)).is(this)) {
            height++;
        }

        if (this.canSurvive(state, level, pos.above())) {
            /// ensure the plant does not grow above the max world height.
            if (level.isEmptyBlock(pos.above()) && pos.above().getY() < level.getMaxBuildHeight() - 1) {
                if (random.nextInt(16) == 1) {
                    level.setBlockAndUpdate(pos.above(), state);
                }
            }
        }

        int age = state.getValue(AGE);
        if (age < 2 && random.nextInt(32) == 0) {
            level.setBlock(pos, state.setValue(AGE, age + 1), 2);
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (state.getValue(AGE) == 2) {
            popResource(level, pos, new ItemStack(MysticItems.VANILLA_BEANS.get(), 1));

            level.setBlock(pos, state.setValue(AGE, 0), 2);
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            return InteractionResult.sidedSuccess(level.isClientSide());
        }

        return InteractionResult.PASS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE, SHAPE, FACING);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean valid) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        if (state.getValue(SHAPE) == Shape.TOP && this.canSurvive(state, level, pos.above())) {
            level.setBlock(pos.above(), state, 2);
        } else {
            level.setBlock(pos, state.setValue(AGE, state.getValue(AGE) + 1), 2);
        }
    }

    public enum Shape implements StringRepresentable {
        BASE("base"),
        TOP("top"),
        MIDDLE("middle"),
        BOTTOM("bottom");

        private final String name;

        Shape(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }

}