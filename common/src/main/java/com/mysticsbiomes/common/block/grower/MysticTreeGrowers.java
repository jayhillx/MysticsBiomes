package com.mysticsbiomes.common.block.grower;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class MysticTreeGrowers extends AbstractTreeGrower {
    private final ResourceKey<ConfiguredFeature<?, ?>> feature;

    public MysticTreeGrowers(ResourceKey<ConfiguredFeature<?, ?>> feature) {
        this.feature = feature;
    }

    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource source, boolean fancy) {
        return this.feature;
    }

}