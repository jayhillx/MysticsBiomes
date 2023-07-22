package com.mysticsbiomes.common.biome;

import com.mysticsbiomes.common.worldgen.placement.MysticTreePlacements;
import com.mysticsbiomes.common.worldgen.placement.MysticVegetationPlacements;
import com.mysticsbiomes.init.MysticEntities;
import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import static com.mysticsbiomes.common.biome.IBiomeTemplate.biome;
import static com.mysticsbiomes.common.biome.IBiomeTemplate.defaultBiomeFeatures;

public class OverworldBiomes {

    public static Biome strawberryFields(HolderGetter<PlacedFeature> feature, HolderGetter<ConfiguredWorldCarver<?>> carver) {
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(feature, carver);

        BiomeDefaultFeatures.commonSpawns(mobBuilder);
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(MysticEntities.STRAWBERRY_COW.get(), 16, 2, 4)).addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 6, 2, 3));

        IBiomeTemplate.defaultBiomeFeatures(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticTreePlacements.TREE_STRAWBERRY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PLANT_STRAWBERRY_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_PINK_TULIP);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_WHITE_TULIP);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_LIGHT_GRASS);

        return IBiomeTemplate.biome(0.95F, 0.5F, 4159204, 329011, 12638463, mobBuilder, biomeBuilder);
    }

    public static Biome bambooBlossomForest(HolderGetter<PlacedFeature> feature, HolderGetter<ConfiguredWorldCarver<?>> carver) {
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(feature, carver);

        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(MysticEntities.RED_PANDA.get(), 8, 2, 4));
        BiomeDefaultFeatures.commonSpawns(mobBuilder);

        defaultBiomeFeatures(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticTreePlacements.BUSH_PEONY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticTreePlacements.TREE_PINK_CHERRY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticTreePlacements.TREE_WHITE_CHERRY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_LILAC);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_LIGHT_GRASS);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.BAMBOO_LIGHT);

        return biome(0.6F, 0.4F, 4159204, 329011, 12638463, mobBuilder, biomeBuilder);
    }

    public static Biome lavenderMeadow(HolderGetter<PlacedFeature> feature, HolderGetter<ConfiguredWorldCarver<?>> carver) {
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(feature, carver);

        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4)).addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 6, 2, 3));
        BiomeDefaultFeatures.caveSpawns(mobBuilder);
        BiomeDefaultFeatures.monsters(mobBuilder, 55, 5, 30, false);

        defaultBiomeFeatures(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticTreePlacements.TREE_JACARANDA);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_LAVENDER);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_LIGHT_GRASS);

        return biome(0.5F, 0.8F, 4159204, 329011, 12638463, mobBuilder, biomeBuilder);
    }

}