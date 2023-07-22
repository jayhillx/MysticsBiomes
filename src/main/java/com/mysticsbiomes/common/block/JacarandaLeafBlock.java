package com.mysticsbiomes.common.block;

import com.mysticsbiomes.init.MysticParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class JacarandaLeafBlock extends FallingLeafBlock {

    public JacarandaLeafBlock(Properties properties) {
        super(14, properties);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);

        if (random.nextInt(48) == 0) {
            BlockPos belowPos = pos.below();

            if (level.isEmptyBlock(belowPos)) {
                double d0 = random.nextGaussian() * 0.02D;
                double d1 = random.nextGaussian() * 0.02D;
                double d2 = random.nextGaussian() * 0.02D;

                double d3 = (float)pos.getX() + random.nextFloat();
                double d4 = (double)pos.getY() - 0.05D;
                double d6 = (float)pos.getZ() + random.nextFloat();

                level.addParticle(MysticParticles.FALLING_JACARANDA.get(), d3, d4, d6, d0, d1, d2);
            }
        }
    }

}