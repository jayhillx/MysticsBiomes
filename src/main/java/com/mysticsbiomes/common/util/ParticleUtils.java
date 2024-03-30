package com.mysticsbiomes.common.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;

public class ParticleUtils {

    public static void spawnParticleBelow(Level level, BlockPos pos, RandomSource random, ParticleOptions options) {
        double d0 = (double)pos.getX() + random.nextDouble();
        double d1 = (double)pos.getY() - 0.05D;
        double d2 = (double)pos.getZ() + random.nextDouble();
        level.addParticle(options, d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }

}