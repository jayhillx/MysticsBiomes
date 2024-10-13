package com.mysticsbiomes.common.block;

import com.mysticsbiomes.init.MysticParticles;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ParticleUtil;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class MapleLeavesBlock extends MysticLeavesBlock {
    private final ParticleEffect particle;

    public MapleLeavesBlock(ParticleEffect particle, BlockSoundGroup soundType) {
        super(soundType);
        this.particle = particle;
    }

    @Override
    public void randomDisplayTick(BlockState state, World level, BlockPos pos, Random random) {
        super.randomDisplayTick(state, level, pos, random);
        BlockPos belowPos = pos.down();
        BlockState belowState = level.getBlockState(belowPos);

        if (!isFaceFullSquare(belowState.getCollisionShape(level, belowPos), Direction.UP)) {
            if (random.nextInt(82) == 0) {
                ParticleUtil.spawnParticle(level, pos, random, this.particle);
            }

            if (random.nextInt(3000) == 0) {
                ParticleUtil.spawnParticle(level, pos, random, MysticParticles.ACORN);
            }
        }
    }

}