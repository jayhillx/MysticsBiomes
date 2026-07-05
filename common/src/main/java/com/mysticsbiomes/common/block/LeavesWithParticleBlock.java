package com.mysticsbiomes.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

public abstract class LeavesWithParticleBlock extends LeavesBlock {

    public LeavesWithParticleBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);
        /// inject given behavior by the class extending this one.
        this.particleBehavior(state, level, pos, random);
    }

    abstract void particleBehavior(BlockState state, Level level, BlockPos pos, RandomSource random);

}