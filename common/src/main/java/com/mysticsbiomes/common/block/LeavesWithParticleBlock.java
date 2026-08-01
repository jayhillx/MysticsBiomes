package com.mysticsbiomes.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public abstract class LeavesWithParticleBlock extends LeavesBlock {
    protected final Supplier<SimpleParticleType> particleType;

    public LeavesWithParticleBlock(Supplier<SimpleParticleType> particleType, Properties properties) {
        super(properties);
        this.particleType = particleType;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);
        /// inject given behavior by the class extending this one.
        this.particleBehavior(state, level, pos, random);
    }

    abstract void particleBehavior(BlockState state, Level level, BlockPos pos, RandomSource random);

}