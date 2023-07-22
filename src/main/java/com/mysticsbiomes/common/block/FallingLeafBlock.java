package com.mysticsbiomes.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Customizable leaves with specified decay distance, falling particles & leaf piles.
 */
public class FallingLeafBlock extends LeavesBlock {
    private final int decayDistance;
    private final ParticleOptions particle;

    /** @param decayDistance vanilla default is 7. */
    public FallingLeafBlock(ParticleOptions particle, int decayDistance, Properties properties) {
        super(properties);
        this.particle = particle;
        this.decayDistance = decayDistance;
    }

    public FallingLeafBlock(int decayDistance, Properties properties) {
        this(null, decayDistance, properties);
    }

    public FallingLeafBlock(Properties properties) {
        this(null, 7, properties);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);

        if (this.particle != null) {
            if (random.nextInt(48) == 0) {
                BlockPos belowPos = pos.below();

                if (level.isEmptyBlock(belowPos)) {
                    double d0 = random.nextGaussian() * 0.02D;
                    double d1 = random.nextGaussian() * 0.02D;
                    double d2 = random.nextGaussian() * 0.02D;

                    double d3 = (float)pos.getX() + random.nextFloat();
                    double d4 = (double)pos.getY() - 0.05D;
                    double d6 = (float)pos.getZ() + random.nextFloat();

                    level.addParticle(this.particle, d3, d4, d6, d0, d1, d2);
                }
            }
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.tick(state, level, pos, random);

        if (this.particle != null) {
            if (random.nextInt(82) == 0) {
                BlockPos belowPos = pos.below();

            }
        }
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!state.getValue(PERSISTENT) && state.getValue(DISTANCE) == this.decayDistance) {
            dropResources(state, level, pos);
            level.removeBlock(pos, false);
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(DISTANCE) == this.decayDistance && !state.getValue(PERSISTENT);
    }

}