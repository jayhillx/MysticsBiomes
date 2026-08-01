package com.mysticsbiomes.common.worldgen.biome;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Music;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import org.jetbrains.annotations.Nullable;

public interface BiomeTemplate {

    static Biome biome(boolean hasPrecipitation, float temperature, float downfall, int waterColor, int waterFogColor, int fogColor, int grassColor, int foliageColor, @Nullable Music music, MobSpawnSettings.Builder mobSpawns, BiomeGenerationSettings.Builder generation) {
        return (new Biome.BiomeBuilder())
                .hasPrecipitation(hasPrecipitation)
                .temperature(temperature)
                .downfall(downfall)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(waterColor)
                        .waterFogColor(waterFogColor)
                        .fogColor(fogColor)
                        .grassColorOverride(grassColor)
                        .foliageColorOverride(foliageColor)
                        .skyColor(calculateSkyColor(temperature))
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(music)
                        .build())
                .mobSpawnSettings(mobSpawns.build())
                .generationSettings(generation.build())
                .build();
    }

    static int calculateSkyColor(float temperature) {
        float i = temperature / 3.0F;
        i = Mth.clamp(i, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - i * 0.05F, 0.5F + i * 0.1F, 1.0F);
    }

    static void defaultBiomeFeatures(BiomeGenerationSettings.Builder biomeBuilder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(biomeBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSprings(biomeBuilder);
        BiomeDefaultFeatures.addSurfaceFreezing(biomeBuilder);

        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
    }

    static void spawn(MobSpawnSettings.Builder spawnBuilder, MobCategory category, EntityType<?> entityType, int weight, int minCount, int maxCount) {
        spawnBuilder.addSpawn(category, new MobSpawnSettings.SpawnerData(entityType, weight, minCount, maxCount));
    }

}