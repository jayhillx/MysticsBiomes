package com.mysticsbiomes.common.block;

import net.minecraft.block.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class SeaOatsBlock extends TallPlantBlock {

    public SeaOatsBlock(AbstractBlock.Settings properties) {
        super(properties);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView reader, BlockPos pos, ShapeContext context) {
        Vec3d vec3 = state.getModelOffset(reader, pos);
        return Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D).offset(vec3.x, vec3.y, vec3.z);
    }

    @Override
    protected boolean canPlantOnTop(BlockState state, BlockView level, BlockPos pos) {
        return state.isIn(BlockTags.SAND);
    }

}