package com.mysticsbiomes.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class MapleLeavesBlock extends MysticLeavesBlock {
    private final Supplier<ParticleOptions> particle;

    public MapleLeavesBlock(Supplier<ParticleOptions> particleType, SoundType soundType) {
        super(soundType);
        this.particle = particleType;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);
        BlockPos belowPos = pos.below();
        BlockState belowState = level.getBlockState(belowPos);

        if (random.nextInt(48) == 0) {
            if (!isFaceFull(belowState.getCollisionShape(level, belowPos), Direction.UP)) {
                ParticleUtils.spawnParticleBelow(level, pos, random, this.particle.get());
            }
        }
    }

}