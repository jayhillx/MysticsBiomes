package com.mysticsbiomes.common.biome;

import com.mysticsbiomes.common.world.placement.MysticTreePlacements;
import com.mysticsbiomes.common.world.placement.MysticVegetationPlacements;
import com.mysticsbiomes.init.MysticEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;

public class OverworldBiomes {

    public static Biome strawberryFields(RegistryEntryLookup<PlacedFeature> feature, RegistryEntryLookup<ConfiguredCarver<?>> carver) {
        SpawnSettings.Builder mobBuilder = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder biomeBuilder = new GenerationSettings.LookupBackedBuilder(feature, carver);

        BiomeTemplate.commonSpawns(mobBuilder);
        mobBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(MysticEntities.STRAWBERRY_COW, 40, 2, 4));
        mobBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.RABBIT, 6, 2, 3));

        BiomeTemplate.defaultBiomeFeatures(biomeBuilder);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticTreePlacements.STRAWBERRY_TREE_CHECKED);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_STRAWBERRY_BUSH);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_PINK_TULIP);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_WHITE_TULIP);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_GRASS_LIGHT);
        return BiomeTemplate.biome(true, 0.95F, 0.5F,  1670562, 2119783, 12638463, 10536781, 10536781, mobBuilder, biomeBuilder);
    }

    public static Biome lavenderMeadow(RegistryEntryLookup<PlacedFeature> feature, RegistryEntryLookup<ConfiguredCarver<?>> carver) {
        SpawnSettings.Builder mobBuilder = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder biomeBuilder = new GenerationSettings.LookupBackedBuilder(feature, carver);

        mobBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.GOAT, 12, 4, 4));
        mobBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.RABBIT, 6, 2, 3));
        DefaultBiomeFeatures.addCaveMobs(mobBuilder);

        BiomeTemplate.defaultBiomeFeatures(biomeBuilder);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticTreePlacements.JACARANDA_TREE_CHECKED);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_LAVENDER);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_GRASS_DENSE);
        return BiomeTemplate.biome(true, 0.5F, 0.8F, 4159204, 329011, 12638463, mobBuilder, biomeBuilder);
    }

    public static Biome bambooBlossomForest(RegistryEntryLookup<PlacedFeature> feature, RegistryEntryLookup<ConfiguredCarver<?>> carver) {
        SpawnSettings.Builder mobBuilder = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder biomeBuilder = new GenerationSettings.LookupBackedBuilder(feature, carver);

        mobBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(MysticEntities.RED_PANDA, 80, 1, 2));
        mobBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.RABBIT, 6, 2, 3));
        DefaultBiomeFeatures.addCaveMobs(mobBuilder);
        BiomeTemplate.monsters(mobBuilder, 6, 2, 6, false);

        BiomeTemplate.defaultBiomeFeatures(biomeBuilder);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_SPRING_BAMBOO);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticVegetationPlacements.TREES_CHERRY_BLOSSOM);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticVegetationPlacements.BUSH_PEONY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_LILAC);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_GRASS_LIGHT);
        return BiomeTemplate.biome(true, 0.6F, 0.4F, 2057338, 15430, 12638463, mobBuilder, biomeBuilder);
    }

    public static Biome autumnalGrove(RegistryEntryLookup<PlacedFeature> feature, RegistryEntryLookup<ConfiguredCarver<?>> carver) {
        SpawnSettings.Builder mobBuilder = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder biomeBuilder = new GenerationSettings.LookupBackedBuilder(feature, carver);

        mobBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FOX, 50, 2, 5));
        DefaultBiomeFeatures.addBatsAndMonsters(mobBuilder);

        BiomeTemplate.defaultBiomeFeatures(biomeBuilder);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticVegetationPlacements.TREES_MAPLE);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_GRASS_LIGHT);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_PUMPKINS);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_ALLIUM);
        return BiomeTemplate.biome(true, 0.65F, 0.5F, 2919324, 339251, 12638463, 13614928, 12556084, mobBuilder, biomeBuilder);
    }

    public static Biome lushOasis(RegistryEntryLookup<PlacedFeature> feature, RegistryEntryLookup<ConfiguredCarver<?>> carver) {
        SpawnSettings.Builder mobBuilder = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder biomeBuilder = new GenerationSettings.LookupBackedBuilder(feature, carver);

        mobBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.RABBIT, 6, 2, 3));
        DefaultBiomeFeatures.addCaveMobs(mobBuilder);
        BiomeTemplate.commonSpawns(mobBuilder);

        BiomeTemplate.defaultBiomeFeatures(biomeBuilder);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticTreePlacements.PEACH_TREE_CHECKED);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticTreePlacements.DESERT_SHRUB_CHECKED);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_GRASS_LIGHT);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_DESERT_GRASS);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_SAGUARO_CACTUS);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_WILDFLOWER);
        return BiomeTemplate.biome(false, 1.7F, 0.0F, 2919324, 339251, 12638463, mobBuilder, biomeBuilder);
    }

    public static Biome lagoon(RegistryEntryLookup<PlacedFeature> feature, RegistryEntryLookup<ConfiguredCarver<?>> carver) {
        SpawnSettings.Builder mobBuilder = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder biomeBuilder = new GenerationSettings.LookupBackedBuilder(feature, carver);

        mobBuilder.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(MysticEntities.SEA_OTTER, 24, 2, 4));
        mobBuilder.spawn(SpawnGroup.WATER_AMBIENT, new SpawnSettings.SpawnEntry(EntityType.TROPICAL_FISH, 25, 8, 8));
        DefaultBiomeFeatures.addCaveMobs(mobBuilder);

        BiomeTemplate.defaultBiomeFeatures(biomeBuilder);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticTreePlacements.SEA_SHRUB_CHECKED);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_MILKWEED);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_SEA_OATS);
        return BiomeTemplate.biome(true, 1.3F, 0.2F, 3644352, 2119783, 12638463, mobBuilder, biomeBuilder);
    }

    public static Biome tropics(RegistryEntryLookup<PlacedFeature> feature, RegistryEntryLookup<ConfiguredCarver<?>> carver) {
        SpawnSettings.Builder mobBuilder = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder biomeBuilder = new GenerationSettings.LookupBackedBuilder(feature, carver);

        mobBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(MysticEntities.VANILLA_COW, 30, 2, 4));
        mobBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(MysticEntities.CHOCOLATE_COW, 30, 2, 4));
        mobBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.PARROT, 40, 1, 2));
        DefaultBiomeFeatures.addCaveMobs(mobBuilder);

        BiomeTemplate.defaultBiomeFeatures(biomeBuilder);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticTreePlacements.TROPICAL_TREE_CHECKED);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticTreePlacements.HYDRANGEA_BUSH_CHECKED);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticTreePlacements.JUNGLE_SHRUB_CHECKED);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_GRASS_DENSE);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_FERN);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_LARGE_FERN);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_PITCHER_PLANT);
        return BiomeTemplate.biome(true, 1.0F, 0.2F, 3644352, 2119783, 12638463, mobBuilder, biomeBuilder);
    }

}