package com.mysticsbiomes.common.biome;

import com.mysticsbiomes.common.world.placement.MysticTreePlacements;
import com.mysticsbiomes.common.world.placement.MysticVegetationPlacements;
import com.mysticsbiomes.init.MysticEntities;
import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class OverworldBiomes {

    public static Biome strawberryFields(HolderGetter<PlacedFeature> feature, HolderGetter<ConfiguredWorldCarver<?>> carver) {
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(feature, carver);

        BiomeDefaultFeatures.commonSpawns(mobBuilder);
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(MysticEntities.STRAWBERRY_COW.get(), 16, 2, 4)).addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 6, 2, 3));

        BiomeTemplate.defaultBiomeFeatures(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticTreePlacements.STRAWBERRY_TREE_CHECKED);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_STRAWBERRY_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_PINK_TULIP);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_WHITE_TULIP);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_GRASS);
        return BiomeTemplate.biome(true, 0.95F, 0.5F, 4159204, 329011, 12638463, mobBuilder, biomeBuilder);
    }

    public static Biome lavenderMeadow(HolderGetter<PlacedFeature> feature, HolderGetter<ConfiguredWorldCarver<?>> carver) {
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(feature, carver);

        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4)).addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 6, 2, 3));
        BiomeDefaultFeatures.caveSpawns(mobBuilder);

        BiomeTemplate.defaultBiomeFeatures(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticTreePlacements.JACARANDA_TREE_CHECKED);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_LAVENDER);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_GRASS);
        return BiomeTemplate.biome(true, 0.5F, 0.8F, 4159204, 329011, 12638463, mobBuilder, biomeBuilder);
    }

    public static Biome bambooBlossomForest(HolderGetter<PlacedFeature> feature, HolderGetter<ConfiguredWorldCarver<?>> carver) {
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(feature, carver);

        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(MysticEntities.RED_PANDA.get(), 12, 1, 2));
        BiomeDefaultFeatures.caveSpawns(mobBuilder);
        BiomeDefaultFeatures.monsters(mobBuilder, 6, 2, 6, false);

        BiomeTemplate.defaultBiomeFeatures(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_SPRING_BAMBOO);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.TREES_CHERRY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.BUSH_PEONY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_LILAC);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_GRASS);
        return BiomeTemplate.biome(true, 0.6F, 0.4F, 2057338, 15430, 12638463, mobBuilder, biomeBuilder);
    }

    public static Biome autumnalGrove(HolderGetter<PlacedFeature> feature, HolderGetter<ConfiguredWorldCarver<?>> carver) {
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(feature, carver);

        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 32, 2, 5));
        BiomeDefaultFeatures.caveSpawns(mobBuilder);
        BiomeDefaultFeatures.commonSpawns(mobBuilder);

        BiomeTemplate.defaultBiomeFeatures(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticTreePlacements.MAPLE_TREE_CHECKED);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticTreePlacements.ORANGE_MAPLE_TREE_CHECKED);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticTreePlacements.YELLOW_MAPLE_TREE_CHECKED);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_PUMPKINS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_GRASS);
        return BiomeTemplate.biome(true, 0.65F, 0.5F, 2919324, 339251, 12638463, 13614928, 12556084, mobBuilder, biomeBuilder);
    }

    public static Biome lushOasis(HolderGetter<PlacedFeature> feature, HolderGetter<ConfiguredWorldCarver<?>> carver) {
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(feature, carver);

        BiomeDefaultFeatures.caveSpawns(mobBuilder);
        BiomeDefaultFeatures.commonSpawns(mobBuilder);

        BiomeTemplate.defaultBiomeFeatures(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticTreePlacements.CITRUS_TREE_CHECKED);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_WILDFLOWER);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_DESERT_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_PRICKLY_PEAR);
        return BiomeTemplate.biome(false, 1.7F, 0.0F, 2919324, 339251, 12638463, mobBuilder, biomeBuilder);
    }

}