package com.mysticsbiomes.common.block;

import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class SaguaroBlossomBlock extends PlantBlock {

    public SaguaroBlossomBlock(AbstractBlock.Settings properties) {
        super(properties);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView level, BlockPos pos) {
        BlockState belowState = level.getBlockState(pos.down());
        return belowState.isOf(MysticBlocks.SAGUARO_CACTUS); // && belowState.getValue(SaguaroCactusBlock.ATTACHMENT) != SaguaroCactusBlock.BranchShape.BASE_BRANCH;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView getter, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
    }

}