package com.jayhill.mysticsbiomes.common.world.features;

import com.jayhill.mysticsbiomes.init.MysticFeatures;
import net.minecraft.world.biome.BiomeGenerationSettings.*;
import net.minecraft.world.gen.GenerationStage;

public class MysticBiomeFeatures {

    /** Strawberry Fields */
    public static void withStrawberryFieldsFeatures(Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MysticFeatures.STRAWBERRY_BLOSSOM_TREES);
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MysticFeatures.SWEET_BLOSSOM_TREES);
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MysticFeatures.SMALL_OAK_TREES);
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MysticFeatures.STRAWBERRY_BUSHES);
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MysticFeatures.GRASS);
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MysticFeatures.PINK_TULIPS);
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MysticFeatures.WHITE_TULIPS);
    }

}