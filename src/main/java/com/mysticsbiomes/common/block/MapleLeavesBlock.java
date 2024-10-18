package com.mysticsbiomes.common.block;

import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticParticles;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ParticleUtil;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class MapleLeavesBlock extends MysticLeavesBlock {

    public MapleLeavesBlock(BlockSoundGroup soundType) {
        super(soundType);
    }

    @Override
    public void randomDisplayTick(BlockState state, World level, BlockPos pos, Random random) {
        super.randomDisplayTick(state, level, pos, random);
        BlockPos belowPos = pos.down();
        BlockState belowState = level.getBlockState(belowPos);

        if (!isFaceFullSquare(belowState.getCollisionShape(level, belowPos), Direction.UP)) {
            if (random.nextInt(82) == 0) {
                if (this == MysticBlocks.MAPLE_LEAVES) {
                    ParticleUtil.spawnParticle(level, pos, random, MysticParticles.MAPLE_LEAF);
                } else if (this == MysticBlocks.ORANGE_MAPLE_LEAVES) {
                    ParticleUtil.spawnParticle(level, pos, random, MysticParticles.ORANGE_MAPLE_LEAF);
                } else if (this == MysticBlocks.YELLOW_MAPLE_LEAVES) {
                    ParticleUtil.spawnParticle(level, pos, random, MysticParticles.YELLOW_MAPLE_LEAF);
                }
            }

            if (random.nextInt(3000) == 0) {
                ParticleUtil.spawnParticle(level, pos, random, MysticParticles.ACORN);
            }
        }
    }

}