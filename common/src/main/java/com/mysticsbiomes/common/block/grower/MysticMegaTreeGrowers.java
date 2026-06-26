package com.mysticsbiomes.common.block.grower;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class MysticMegaTreeGrowers extends AbstractMegaTreeGrower {
    private final ResourceKey<ConfiguredFeature<?, ?>> feature;
    private final ResourceKey<ConfiguredFeature<?, ?>> megaFeature;

    public MysticMegaTreeGrowers(ResourceKey<ConfiguredFeature<?, ?>> feature, ResourceKey<ConfiguredFeature<?, ?>> megaFeature) {
        this.feature = feature;
        this.megaFeature = megaFeature;
    }

    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource source, boolean fancy) {
        return this.feature;
    }

    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource source) {
        return this.megaFeature;
    }

}