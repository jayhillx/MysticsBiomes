package com.mysticsbiomes.common.block.grower;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class MysticTreeGrower extends SaplingGenerator {
    private final RegistryKey<ConfiguredFeature<?, ?>> feature;

    public MysticTreeGrower(RegistryKey<ConfiguredFeature<?, ?>> feature) {
        this.feature = feature;
    }

    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean fancy) {
        return this.feature;
    }

}