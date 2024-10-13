package com.mysticsbiomes.common.block;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class MapleLeafPileBlock extends Block {
    public static final IntProperty LAYERS = Properties.LAYERS;
    protected static final VoxelShape[] SHAPE_BY_LAYER = new VoxelShape[]{VoxelShapes.empty(), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};
    private final ParticleEffect particle;

    public MapleLeafPileBlock(ParticleEffect particleType, MapColor color) {
        super(AbstractBlock.Settings.create().mapColor(color).noCollision().nonOpaque().replaceable().strength(0.1F).sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY));
        this.particle = particleType;
    }

    @Override
    public void onEntityCollision(BlockState state, World level, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity) {
            if (state.get(LAYERS) > 1) {
                double d = 1 - (0.1D * (state.get(LAYERS) - 1));
                entity.slowMovement(state, new Vec3d(d, d, d));

                if (entity.prevY > entity.getY() + 0.25D) {
                    for (int i = 1; i < state.get(LAYERS); ++i) {
                        double d0 = (double)pos.getX() + level.getRandom().nextDouble() + 0.2D;
                        double d1 = (double)pos.getY() + 0.5D;
                        double d2 = (double)pos.getZ() + level.getRandom().nextDouble() + 0.2D;
                        level.addParticle(this.particle, d0, d1, d2, 0.0D, 0.0D, 0.0D);
                    }
                }
            }
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState state1, WorldAccess level, BlockPos pos, BlockPos pos1) {
        return !state.canPlaceAt(level, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, state1, level, pos, pos1);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockState state = context.getWorld().getBlockState(context.getBlockPos());
        if (state.isOf(this)) {
            int i = state.get(LAYERS);
            return state.with(LAYERS, Math.min(8, i + 1));
        } else {
            return super.getPlacementState(context);
        }
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        int i = state.get(LAYERS);
        if (context.getStack().isOf(this.asItem()) && i < 8) {
            if (context.canReplaceExisting()) {
                return context.getSide() == Direction.UP;
            } else {
                return true;
            }
        } else {
            return i == 1;
        }
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView level, BlockPos pos, NavigationType type) {
        if (type == NavigationType.LAND) {
            return state.get(LAYERS) < 5;
        } else {
            return false;
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        return SHAPE_BY_LAYER[state.get(LAYERS)];
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        return VoxelShapes.empty();
    }

    @Override
    public VoxelShape getSidesShape(BlockState state, BlockView level, BlockPos pos) {
        return SHAPE_BY_LAYER[state.get(LAYERS)];
    }

    @Override
    public VoxelShape getCameraCollisionShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        return SHAPE_BY_LAYER[state.get(LAYERS)];
    }

    @Override
    public VoxelShape getCullingShape(BlockState state, BlockView level, BlockPos pos) {
        return VoxelShapes.empty();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LAYERS);
    }

}