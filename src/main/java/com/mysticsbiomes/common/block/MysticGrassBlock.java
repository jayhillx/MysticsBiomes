package com.mysticsbiomes.common.block;

import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.FernBlock;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

public class MysticGrassBlock extends FernBlock {

    public MysticGrassBlock(AbstractBlock.Settings properties) {
        super(properties);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView level, BlockPos pos) {
        return this == MysticBlocks.DESERT_GRASS ? level.getBlockState(pos.down()).isIn(BlockTags.SAND) : super.canPlaceAt(state, level, pos);
    }

}