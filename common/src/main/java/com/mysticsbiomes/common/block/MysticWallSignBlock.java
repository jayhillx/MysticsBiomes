package com.mysticsbiomes.common.block;

import com.mysticsbiomes.common.block.entity.MysticSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class MysticWallSignBlock extends WallSignBlock {

    public MysticWallSignBlock(WoodType woodType, Properties properties) {
        super(properties, woodType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MysticSignBlockEntity(pos, state);
    }

}