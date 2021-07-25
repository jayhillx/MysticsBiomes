package com.jayhill.mysticsbiomes.common.biome.overworld;

import com.jayhill.mysticsbiomes.common.world.MysticBiomeMaker;
import com.jayhill.mysticsbiomes.common.world.features.MysticBiomeFeatures;
import com.jayhill.mysticsbiomes.init.MysticEntities;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.*;
import net.minecraft.world.biome.BiomeGenerationSettings.*;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;

@SuppressWarnings("all")
public class StrawberryFieldsBiome {

    public static Biome makeStrawberryFieldsBiome() {
        MobSpawnInfo.Builder mobBuilder = new MobSpawnInfo.Builder();
        /** Creature & Monster Spawns. */
        mobBuilder.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(MysticEntities.STRAWBERRY_COW.get(), 10, 2, 4));
        MysticBiomeMaker.withHostileMobs(mobBuilder, 95, 5, 100);

        BiomeGenerationSettings.Builder biomeBuilder = (new Builder()).withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244178_j);
        /** Biome Features & Structures. */
        biomeBuilder.withStructure(StructureFeatures.VILLAGE_PLAINS);

        DefaultBiomeFeatures.withStrongholdAndMineshaft(biomeBuilder);
        DefaultBiomeFeatures.withMonsterRoom(biomeBuilder);
        DefaultBiomeFeatures.withFrozenTopLayer(biomeBuilder);
        DefaultBiomeFeatures.withCavesAndCanyons(biomeBuilder);
        DefaultBiomeFeatures.withLavaAndWaterLakes(biomeBuilder);
        DefaultBiomeFeatures.withLavaAndWaterSprings(biomeBuilder);

        DefaultBiomeFeatures.withDisks(biomeBuilder);
        DefaultBiomeFeatures.withCommonOverworldBlocks(biomeBuilder);
        DefaultBiomeFeatures.withOverworldOres(biomeBuilder);

        DefaultBiomeFeatures.withSimpleSeagrass(biomeBuilder);

        MysticBiomeFeatures.withStrawberryFieldsFeatures(biomeBuilder);
        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.PLAINS)
         // Temperature
        .depth(0.05F).scale(0.05F).temperature(1.0F).downfall(0.4F)
         // Effects & Generation
        .setEffects((new BiomeAmbience.Builder())
        .setWaterColor(2469016).setWaterFogColor(1276002).setFogColor(12183270).withSkyColor(7458755)
        .setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build()).withMobSpawnSettings(mobBuilder.copy()).withGenerationSettings(biomeBuilder.build()).build();
    }

}