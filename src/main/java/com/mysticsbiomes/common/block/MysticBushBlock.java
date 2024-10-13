package com.mysticsbiomes.common.block;

import com.mysticsbiomes.common.block.grower.MysticTreeGrower;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.block.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class MysticBushBlock extends PlantBlock implements Fertilizable {
    private static final VoxelShape SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 8.0D, 10.0D));
    private final MysticTreeGrower TREE_GROWER;

    public MysticBushBlock(MysticTreeGrower grower, AbstractBlock.Settings properties) {
        super(properties);
        this.TREE_GROWER = grower;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView getter, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView level, BlockPos pos) {
        BlockState belowState = level.getBlockState(pos.down());
        return this == MysticBlocks.SEA_SHRUB ? belowState.isIn(BlockTags.SAND) || belowState.isIn(BlockTags.DIRT) : super.canPlaceAt(state, level, pos);
    }

    @Override
    public boolean isFertilizable(WorldView reader, BlockPos pos, BlockState state, boolean valid) {
        return reader.getFluidState(pos.up()).isEmpty();
    }

    @Override
    public boolean canGrow(World level, Random random, BlockPos pos, BlockState state) {
        return (double)level.random.nextFloat() < 0.45D;
    }

    @Override
    public void grow(ServerWorld level, Random random, BlockPos pos, BlockState state) {
        TREE_GROWER.generate(level, level.getChunkManager().getChunkGenerator(), pos, state, random);
    }

}