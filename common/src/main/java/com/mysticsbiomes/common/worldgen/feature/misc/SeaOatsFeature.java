package com.mysticsbiomes.common.worldgen.feature.misc;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.RandomPatchFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;

public class SeaOatsFeature extends RandomPatchFeature {

    public SeaOatsFeature(Codec<RandomPatchConfiguration> codec) {
        super(codec);
    }

}