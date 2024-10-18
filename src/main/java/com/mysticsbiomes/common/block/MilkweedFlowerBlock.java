package com.mysticsbiomes.common.block;

import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class MilkweedFlowerBlock extends TallFlowerBlock {

    public MilkweedFlowerBlock(AbstractBlock.Settings properties) {
        super(properties);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        Vec3d vec3 = state.getModelOffset(level, pos);
        if (state.get(HALF) == DoubleBlockHalf.UPPER) {
            return Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 8.0D, 14.0D).offset(vec3.x, vec3.y, vec3.z);
        }
        return Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D).offset(vec3.x, vec3.y, vec3.z);
    }

    @Override
    protected boolean canPlantOnTop(BlockState state, BlockView level, BlockPos pos) {
        return state.isIn(BlockTags.SAND) || state.isIn(BlockTags.DIRT) || state.isOf(Blocks.FARMLAND);
    }

}