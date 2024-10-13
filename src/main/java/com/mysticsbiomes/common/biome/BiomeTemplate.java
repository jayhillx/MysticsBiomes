package com.mysticsbiomes.common.biome;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

public interface BiomeTemplate {

    static Biome biome(boolean hasPrecipitation, float temperature, float downfall, int waterColor, int waterFogColor, int fogColor, SpawnSettings.Builder mobSpawns, GenerationSettings.Builder generation) {
        return (new Biome.Builder()).precipitation(hasPrecipitation).temperature(temperature).downfall(downfall).effects((new BiomeEffects.Builder()).waterColor(waterColor).waterFogColor(waterFogColor).fogColor(fogColor).skyColor(calculateSkyColor(temperature)).build()).spawnSettings(mobSpawns.build()).generationSettings(generation.build()).build();
    }

    static Biome biome(boolean hasPrecipitation, float temperature, float downfall, int waterColor, int waterFogColor, int fogColor, int grassColor, int foliageColor, SpawnSettings.Builder mobSpawns, GenerationSettings.Builder generation) {
        return (new Biome.Builder()).precipitation(hasPrecipitation).temperature(temperature).downfall(downfall).effects((new BiomeEffects.Builder()).waterColor(waterColor).waterFogColor(waterFogColor).fogColor(fogColor).grassColor(grassColor).foliageColor(foliageColor).skyColor(calculateSkyColor(temperature)).build()).spawnSettings(mobSpawns.build()).generationSettings(generation.build()).build();
    }

    static int calculateSkyColor(float temperature) {
        float $$1 = temperature / 3.0F;
        $$1 = MathHelper.clamp($$1, -1.0F, 1.0F);

        return MathHelper.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }

    static void defaultBiomeFeatures(GenerationSettings.LookupBackedBuilder biomeBuilder) {
        DefaultBiomeFeatures.addLandCarvers(biomeBuilder);
        DefaultBiomeFeatures.addAmethystGeodes(biomeBuilder);
        DefaultBiomeFeatures.addDungeons(biomeBuilder);
        DefaultBiomeFeatures.addMineables(biomeBuilder);
        DefaultBiomeFeatures.addSprings(biomeBuilder);
        DefaultBiomeFeatures.addFrozenTopLayer(biomeBuilder);

        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        DefaultBiomeFeatures.addDefaultDisks(biomeBuilder);
    }

    static void commonSpawns(SpawnSettings.Builder builder) {
        DefaultBiomeFeatures.addCaveMobs(builder);
        monsters(builder, 95, 5, 100, false);
    }

    static void monsters(SpawnSettings.Builder builder, int zombieWeight, int zombieVillagerWeight, int skeletonWeight, boolean drownedInsteadZombies) {
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SPIDER, 100, 4, 4));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(drownedInsteadZombies ? EntityType.DROWNED : EntityType.ZOMBIE, zombieWeight, 4, 4));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE_VILLAGER, zombieVillagerWeight, 1, 1));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SKELETON, skeletonWeight, 4, 4));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.CREEPER, 100, 4, 4));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SLIME, 100, 4, 4));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.WITCH, 5, 1, 1));
    }

}