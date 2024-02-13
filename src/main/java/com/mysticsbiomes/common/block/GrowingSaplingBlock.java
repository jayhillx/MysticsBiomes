package com.mysticsbiomes.common.block;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import javax.annotation.Nonnull;

/**
 * Combined sapling block and its tree grower. Hopefully trees will grow what they're supposed to. (oopsies)
 */
public class GrowingSaplingBlock extends SaplingBlock {

    public GrowingSaplingBlock(TreeGrower grower, Properties properties) {
        super(grower, properties);
    }

    public static class TreeGrower extends AbstractTreeGrower {
        final Holder<? extends ConfiguredFeature<?, ?>> feature;

        public TreeGrower(Holder<? extends ConfiguredFeature<?, ?>> feature) {
            this.feature = feature;
        }

        protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(@Nonnull RandomSource source, boolean fancy) {
            return this.feature;
        }
    }

}