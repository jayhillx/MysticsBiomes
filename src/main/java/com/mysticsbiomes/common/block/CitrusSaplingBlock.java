package com.mysticsbiomes.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;

public class CitrusSaplingBlock extends MysticSaplingBlock {

    public CitrusSaplingBlock(TreeGrower grower, Properties properties) {
        super(grower, properties);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState belowState = level.getBlockState(pos.below());
        return belowState.is(BlockTags.SAND);
    }

}