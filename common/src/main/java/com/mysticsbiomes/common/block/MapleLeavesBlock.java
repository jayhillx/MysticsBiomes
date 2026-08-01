package com.mysticsbiomes.common.block;

import com.mysticsbiomes.init.MysticParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class MapleLeavesBlock extends LeavesWithParticleBlock {

    public MapleLeavesBlock(Supplier<SimpleParticleType> particleType, Properties properties) {
        super(particleType, properties);
    }

    @Override
    public void particleBehavior(BlockState state, Level level, BlockPos pos, RandomSource random) {
        BlockPos belowPos = pos.below();
        BlockState belowState = level.getBlockState(belowPos);

        if (!isFaceFull(belowState.getCollisionShape(level, belowPos), Direction.UP)) {
            if (random.nextInt(32) == 0) {
                ParticleUtils.spawnParticleBelow(level, pos, random, this.particleType.get());
            }

            if (random.nextInt(3000) == 0) {
                ParticleUtils.spawnParticleBelow(level, pos, random, MysticParticles.ACORN.get());
            }
        }
    }

}