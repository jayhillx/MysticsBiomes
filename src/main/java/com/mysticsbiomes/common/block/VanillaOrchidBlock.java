package com.mysticsbiomes.common.block;

import com.mysticsbiomes.init.MysticItems;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class VanillaOrchidBlock extends HorizontalFacingBlock implements Fertilizable {
    public static final EnumProperty<Shape> SHAPE = EnumProperty.of("shape", Shape.class);
    public static final BooleanProperty VANILLA = BooleanProperty.of("vanilla");

    public VanillaOrchidBlock(AbstractBlock.Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(SHAPE, Shape.MIDDLE).with(VANILLA, false));
    }

    @Override
    public ItemStack getPickStack(BlockView getter, BlockPos pos, BlockState state) {
        return new ItemStack(MysticItems.VANILLA_BEANS);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView getter, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
            case EAST -> Block.createCuboidShape(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
            case SOUTH -> Block.createCuboidShape(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
            case WEST -> Block.createCuboidShape(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
        };
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        int height;
        for (height = 1; level.getBlockState(pos.down(height)).isOf(this); ++height) {}

        BlockPos validPos = pos.offset(state.get(FACING).getOpposite());
        BlockState validState = level.getBlockState(validPos);
        if (!validState.isAir() && validState.isIn(BlockTags.JUNGLE_LOGS)) {
            if (level.isAir(pos.up()) && level.isInBuildLimit(pos)) {
                if (height < 5) {
                    if (random.nextInt(7) == 1) {
                        level.setBlockState(pos.up(), state);
                    }
                }
            }
        }

        if (!state.canPlaceAt(level, pos)) {
            level.breakBlock(pos, true);
        }

        if (state.get(SHAPE) != Shape.TOP && !state.get(VANILLA)) {
            int speed;
            if (level.getBlockState(pos.down()).getBlock() instanceof VanillaOrchidBlock && level.getBlockState(pos.down()).get(VANILLA)) {
                speed = 24;
            } else {
                speed = 12;
            }

            if (random.nextInt(speed) == 0) {
                level.setBlockState(pos, state.with(VANILLA, true));
            }
        }
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView level, BlockPos pos) {
        BlockState relativePos = level.getBlockState(pos.offset(state.get(FACING)));
        return relativePos.isIn(BlockTags.LOGS) && !relativePos.isAir();
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState state1, WorldAccess level, BlockPos pos, BlockPos pos1) {
        BlockState aboveState = level.getBlockState(pos.up());
        BlockState belowState = level.getBlockState(pos.down());
        if (!(aboveState.getBlock() instanceof VanillaOrchidBlock) && belowState.getBlock() instanceof VanillaOrchidBlock) {
            state = state.with(SHAPE, Shape.TOP).with(VANILLA, false);
        }

        if (aboveState.getBlock() instanceof VanillaOrchidBlock && belowState.getBlock() instanceof VanillaOrchidBlock) {
            state = state.with(SHAPE, Shape.MIDDLE);
        }

        if (aboveState.getBlock() instanceof VanillaOrchidBlock && !(belowState.getBlock() instanceof VanillaOrchidBlock)) {
            state = state.with(SHAPE, Shape.BOTTOM);
        }
        return state;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockState state = this.getDefaultState();
        WorldView level = context.getWorld();
        BlockPos clickedPos = context.getBlockPos();

        for (Direction direction : context.getPlacementDirections()) {
            if (direction.getAxis().isHorizontal()) {
                state = state.with(FACING, direction);

                if (state.canPlaceAt(level, clickedPos)) {
                    return state;
                }
            }
        }
        return super.getPlacementState(context);
    }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult result) {
        if (state.get(VANILLA)) {
            dropStack(level, pos, new ItemStack(MysticItems.VANILLA_BEANS, 1));
            level.setBlockState(pos, state.with(VANILLA, false), 2);
            level.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            return ActionResult.success(level.isClient);
        }
        return ActionResult.PASS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, SHAPE, VANILLA);
    }

    @Override
    public boolean isFertilizable(WorldView level, BlockPos pos, BlockState state, boolean valid) {
        return !state.get(VANILLA);
    }

    @Override
    public boolean canGrow(World level, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld level, Random random, BlockPos pos, BlockState state) {
        if (state.get(SHAPE) == Shape.TOP) {
            level.setBlockState(pos.up(), state, 2);
        } else {
            level.setBlockState(pos, state.with(VANILLA, true), 2);
        }
    }

    public enum Shape implements StringIdentifiable {
        TOP("top"),
        MIDDLE("middle"),
        BOTTOM("bottom");

        private final String name;

        Shape(String name) {
            this.name = name;
        }

        @Override
        public String asString() {
            return this.name;
        }
    }

}