package com.mysticsbiomes.common.block;

import com.mysticsbiomes.common.block.grower.MysticTreeGrower;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SaplingBlock;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

public class MysticSaplingBlock extends SaplingBlock {

    public MysticSaplingBlock(MysticTreeGrower grower, AbstractBlock.Settings properties) {
        super(grower, properties);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView level, BlockPos pos) {
        return super.canPlaceAt(state, level, pos);
    }

}