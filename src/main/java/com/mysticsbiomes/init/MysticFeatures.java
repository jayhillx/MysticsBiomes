package com.mysticsbiomes.init;

import com.mysticsbiomes.common.worldgen.feature.MysticTreeFeatures;
import com.mysticsbiomes.common.worldgen.feature.MysticVegetationFeatures;
import com.mysticsbiomes.common.worldgen.placement.MysticTreePlacements;
import com.mysticsbiomes.common.worldgen.placement.MysticVegetationPlacements;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class MysticFeatures {

    /** Register the feature itself. */
    public static void registerConfiguredFeatures(BootstapContext<ConfiguredFeature<?, ?>> context) {
        MysticTreeFeatures.register(context);
        MysticVegetationFeatures.register(context);
    }

    /** Register the feature that will be placed in the world. */
    public static void registerPlacedFeatures(BootstapContext<PlacedFeature> context) {
        MysticTreePlacements.register(context);
        MysticVegetationPlacements.register(context);
    }

}