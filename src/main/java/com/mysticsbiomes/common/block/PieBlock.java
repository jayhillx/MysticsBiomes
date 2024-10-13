package com.mysticsbiomes.common.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class PieBlock extends MysticCakeBlock {
    protected static final VoxelShape[] SHAPE_BY_BITE = new VoxelShape[]{Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D), Block.createCuboidShape(3.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D), Block.createCuboidShape(5.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D), Block.createCuboidShape(7.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D), Block.createCuboidShape(9.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D), Block.createCuboidShape(11.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D), Block.createCuboidShape(13.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D)};

    public PieBlock(AbstractBlock.Settings properties) {
        super(properties);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView getter, BlockPos pos, ShapeContext context) {
        return SHAPE_BY_BITE[state.get(BITES)];
    }

}