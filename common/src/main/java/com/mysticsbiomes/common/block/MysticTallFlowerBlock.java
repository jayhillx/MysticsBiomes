package com.mysticsbiomes.common.block;

import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MysticTallFlowerBlock extends TallFlowerBlock {

    public MysticTallFlowerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.getOffset(getter, pos);
        return Block.box(2.0D, 0.0D, 2.0D, 14.0D, state.getValue(HALF) == DoubleBlockHalf.UPPER ? 6.0D : 16.0D, 14.0D).move(offset.x, offset.y, offset.z);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter getter, BlockPos pos) {
        if (this == MysticBlocks.DESERT_LILY.get()) {
            return super.mayPlaceOn(state, getter, pos) || state.is(BlockTags.SAND);
        }

        return super.mayPlaceOn(state, getter, pos);
    }

}