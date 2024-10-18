package com.mysticsbiomes.common.block;

import net.minecraft.block.BlockState;
import net.minecraft.client.util.ParticleUtil;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class BlossomLeavesBlock extends MysticLeavesBlock {
    private final Supplier<ParticleEffect> particle;

    public BlossomLeavesBlock(Supplier<ParticleEffect> particle, BlockSoundGroup soundType) {
        super(soundType);
        this.particle = particle;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);
        BlockPos belowPos = pos.down();
        BlockState belowState = world.getBlockState(belowPos);

        if (random.nextInt(48) == 0) {
            if (!isFaceFullSquare(belowState.getCollisionShape(world, belowPos), Direction.UP)) {
                if (this.particle != null) {
                    ParticleUtil.spawnParticle(world, pos, random, this.particle.get());
                }
            }
        }
    }

}