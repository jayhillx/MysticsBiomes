package com.mysticsbiomes.common.block;

import com.mysticsbiomes.common.block.entity.MysticSignBlockEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class MysticWallSignBlock extends WallSignBlock {

    public MysticWallSignBlock(AbstractBlock.Settings properties, WoodType type) {
        super(properties, type);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MysticSignBlockEntity(pos, state);
    }

}