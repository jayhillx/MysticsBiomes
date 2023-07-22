package com.mysticsbiomes.init;

import com.mysticsbiomes.common.biome.MysticBiomeProvider;
import com.mysticsbiomes.common.biome.OverworldBiomes;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import terrablender.api.Regions;

import static com.mysticsbiomes.MysticsBiomes.createKey;

public class MysticBiomes {

    public static final ResourceKey<Biome> STRAWBERRY_FIELDS = createKey(Registries.BIOME, "strawberry_fields");
    public static final ResourceKey<Biome> BAMBOO_BLOSSOM_FOREST = createKey(Registries.BIOME, "bamboo_blossom_forest");
    public static final ResourceKey<Biome> LAVENDER_MEADOW = createKey(Registries.BIOME, "lavender_meadow");

    public static void registerRegionProvider() {
        Regions.register(new MysticBiomeProvider(4));
    }

    public static void registerBiomes(BootstapContext<Biome> context) {
        HolderGetter<ConfiguredWorldCarver<?>> carver = context.lookup(Registries.CONFIGURED_CARVER);
        HolderGetter<PlacedFeature> placedFeature = context.lookup(Registries.PLACED_FEATURE);

        context.register(STRAWBERRY_FIELDS, OverworldBiomes.strawberryFields(placedFeature, carver));
        context.register(BAMBOO_BLOSSOM_FOREST, OverworldBiomes.bambooBlossomForest(placedFeature, carver));
        context.register(LAVENDER_MEADOW, OverworldBiomes.lavenderMeadow(placedFeature, carver));
    }

}