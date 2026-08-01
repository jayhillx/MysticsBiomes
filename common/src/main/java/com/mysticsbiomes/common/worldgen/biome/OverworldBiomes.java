package com.mysticsbiomes.common.worldgen.biome;

import com.mysticsbiomes.common.worldgen.placement.MysticTreePlacements;
import com.mysticsbiomes.common.worldgen.placement.MysticVegetationPlacements;
import com.mysticsbiomes.init.MysticEntities;
import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class OverworldBiomes {

    public static Biome strawberryFields(HolderGetter<PlacedFeature> feature, HolderGetter<ConfiguredWorldCarver<?>> carver) {
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(feature, carver);

        BiomeDefaultFeatures.commonSpawns(mobBuilder);
        mobBuilder.addSpawn(MobCategory.CREATURE, new SpawnerData(MysticEntities.STRAWBERRY_COW.get(), 100, 2, 4));
        mobBuilder.addSpawn(MobCategory.CREATURE, new SpawnerData(EntityType.RABBIT, 12, 2, 3));

        BiomeTemplate.defaultBiomeFeatures(biomeBuilder);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticTreePlacements.STRAWBERRY_TREE_CHECKED);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_WILD_STRAWBERRY_BUSH);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_PINK_TULIP);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_WHITE_TULIP);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_GRASS_LIGHT);

        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FLOWER_FOREST);
        return BiomeTemplate.biome(true, 0.95F, 0.5F, 7719644, 3519407, 13299180, 12639073, 12113262, music, mobBuilder, biomeBuilder);
    }

    public static Biome lavenderMeadow(HolderGetter<PlacedFeature> feature, HolderGetter<ConfiguredWorldCarver<?>> carver) {
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(feature, carver);

        BiomeDefaultFeatures.caveSpawns(mobBuilder);
        mobBuilder.addSpawn(MobCategory.CREATURE, new SpawnerData(EntityType.GOAT, 8, 2, 4));
        mobBuilder.addSpawn(MobCategory.CREATURE, new SpawnerData(EntityType.RABBIT, 12, 2, 3));

        BiomeTemplate.defaultBiomeFeatures(biomeBuilder);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticTreePlacements.LAVENDER_TREE_CHECKED);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_LAVENDER);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_TALL_LAVENDER);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_GRASS_DENSE);

        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_MEADOW);
        return BiomeTemplate.biome(true, 0.5F, 0.8F, 7719644, 3519407, 13299180, 12379541, 10536833, music, mobBuilder, biomeBuilder);
    }

    public static Biome bambooBlossomForest(HolderGetter<PlacedFeature> feature, HolderGetter<ConfiguredWorldCarver<?>> carver) {
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(feature, carver);

        BiomeDefaultFeatures.caveSpawns(mobBuilder);
        BiomeDefaultFeatures.monsters(mobBuilder, 6, 2, 6, false);
        ///mobBuilder.addSpawn(MobCategory.CREATURE, new SpawnerData(MysticEntities.RED_PANDA.get(), 100, 1, 2));
        mobBuilder.addSpawn(MobCategory.CREATURE, new SpawnerData(EntityType.RABBIT, 12, 2, 3));

        BiomeTemplate.defaultBiomeFeatures(biomeBuilder);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_SPRING_BAMBOO);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.TREES_CHERRY);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticTreePlacements.PEONY_BUSH_CHECKED);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_LILAC);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_GRASS_LIGHT);

        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_CHERRY_GROVE);
        return BiomeTemplate.biome(true, 0.6F, 0.4F, 2057338, 15430, 12641779, 11055717, 11055717, music, mobBuilder, biomeBuilder);
    }

    public static Biome autumnalGrove(HolderGetter<PlacedFeature> feature, HolderGetter<ConfiguredWorldCarver<?>> carver) {
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(feature, carver);

        BiomeDefaultFeatures.commonSpawns(mobBuilder);
        mobBuilder.addSpawn(MobCategory.CREATURE, new SpawnerData(EntityType.FOX, 50, 2, 5));

        BiomeTemplate.defaultBiomeFeatures(biomeBuilder);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.TREES_MAPLE);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_ASTER);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_PUMPKINS);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_GRASS_LIGHT);

        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST);
        return BiomeTemplate.biome(true, 0.65F, 0.5F, 4950945, 1201990, 12377058, 13609797, 12081194, music, mobBuilder, biomeBuilder);
    }

    public static Biome lushOasis(HolderGetter<PlacedFeature> feature, HolderGetter<ConfiguredWorldCarver<?>> carver) {
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(feature, carver);

        BiomeDefaultFeatures.commonSpawns(mobBuilder);
        mobBuilder.addSpawn(MobCategory.CREATURE, new SpawnerData(EntityType.RABBIT, 30, 2, 3));

        BiomeTemplate.defaultBiomeFeatures(biomeBuilder);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticTreePlacements.PEACH_TREE_CHECKED);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticTreePlacements.DESERT_SHRUB_CHECKED);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_SAGUARO_CACTUS);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_GRASS_LIGHT);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_DESERT_GRASS);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_TALL_DESERT_GRASS);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_DESERT_LILY);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_WILDFLOWER);

        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DESERT);
        return BiomeTemplate.biome(false, 1.7F, 0.0F, 2924712, 2783844, 14672603, 12829791, 13683017, music, mobBuilder, biomeBuilder);
    }

    public static Biome lagoon(HolderGetter<PlacedFeature> feature, HolderGetter<ConfiguredWorldCarver<?>> carver) {
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(feature, carver);

        BiomeDefaultFeatures.commonSpawns(mobBuilder);
        ///mobBuilder.addSpawn(MobCategory.CREATURE, new SpawnerData(MysticEntities.SEA_OTTER.get(), 80, 1, 4));
        mobBuilder.addSpawn(MobCategory.WATER_AMBIENT, new SpawnerData(EntityType.TROPICAL_FISH, 25, 8, 8));
        mobBuilder.addSpawn(MobCategory.CREATURE, new SpawnerData(EntityType.TURTLE, 12, 1, 3));

        BiomeTemplate.defaultBiomeFeatures(biomeBuilder);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticTreePlacements.SEA_SHRUB_CHECKED);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_SEA_OATS);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_BEACH_GRASS);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_TALL_BEACH_GRASS);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_MILKWEED);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_SEA_THRIFT);

        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE);
        return BiomeTemplate.biome(true, 1.3F, 0.2F, 5358767, 3311472, 12641513, 12829791, 12829791, music, mobBuilder, biomeBuilder);
    }

    public static Biome tropics(HolderGetter<PlacedFeature> feature, HolderGetter<ConfiguredWorldCarver<?>> carver) {
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(feature, carver);

        BiomeDefaultFeatures.commonSpawns(mobBuilder);
        mobBuilder.addSpawn(MobCategory.CREATURE, new SpawnerData(MysticEntities.VANILLA_COW.get(), 60, 2, 4));
        mobBuilder.addSpawn(MobCategory.CREATURE, new SpawnerData(MysticEntities.CHOCOLATE_COW.get(), 60, 2, 4));
        mobBuilder.addSpawn(MobCategory.CREATURE, new SpawnerData(EntityType.PARROT, 40, 1, 3));
        
        BiomeTemplate.defaultBiomeFeatures(biomeBuilder);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.TREES_TROPICS);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticTreePlacements.HYDRANGEA_BUSH_CHECKED);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticTreePlacements.JUNGLE_SHRUB_CHECKED);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_GRASS_LIGHT);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_FERN);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.PATCH_LARGE_FERN);
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, MysticVegetationPlacements.FLOWER_PITCHER_PLANT);

        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE);
        return BiomeTemplate.biome(true, 1.0F, 0.2F, 4439232, 2135655, 12904405, 9285986, 8565096, music, mobBuilder, biomeBuilder);
    }

}