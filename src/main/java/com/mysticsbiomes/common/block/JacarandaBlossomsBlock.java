package com.mysticsbiomes.common.block;

import com.mysticsbiomes.init.MysticParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

public class JacarandaBlossomsBlock extends MysticLeavesBlock {

    public JacarandaBlossomsBlock(SoundType soundType) {
        super(soundType);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);
        BlockPos belowPos = pos.below();
        BlockState belowState = level.getBlockState(belowPos);

        if (random.nextInt(48) == 0) {
            if (!isFaceFull(belowState.getCollisionShape(level, belowPos), Direction.UP)) {
                ParticleUtils.spawnParticleBelow(level, pos, random, MysticParticles.FALLING_JACARANDA.get());
            }
        }
    }

}