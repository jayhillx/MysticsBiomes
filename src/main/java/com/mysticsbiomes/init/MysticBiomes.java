package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.biome.MysticBiomeProvider;
import com.mysticsbiomes.common.biome.OverworldBiomes;
import com.mysticsbiomes.common.world.MysticSurfaceRules;
import net.minecraft.registry.*;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.PlacedFeature;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

public class MysticBiomes {

    public static final RegistryKey<Biome> STRAWBERRY_FIELDS = registerBiome("strawberry_fields");
    public static final RegistryKey<Biome> LAVENDER_MEADOW = registerBiome("lavender_meadow");
    public static final RegistryKey<Biome> BAMBOO_BLOSSOM_FOREST = registerBiome("bamboo_blossom_forest");
    public static final RegistryKey<Biome> AUTUMNAL_GROVE = registerBiome("autumnal_grove");
    public static final RegistryKey<Biome> LUSH_OASIS = registerBiome("lush_oasis");
    public static final RegistryKey<Biome> LAGOON = registerBiome("lagoon");
    public static final RegistryKey<Biome> TROPICS = registerBiome("tropics");

    private static RegistryKey<Biome> registerBiome(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, MysticsBiomes.modLoc(name));
    }

    public static void registerRegionProvider() {
        Regions.register(new MysticBiomeProvider(6));
    }

    public static void registerSurfaceRules() {
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MysticsBiomes.modId, MysticSurfaceRules.overworld());
    }

    public static void registerBiomes() {

    }

    public static void bootstrap(Registerable<Biome> context) {
        RegistryEntryLookup<ConfiguredCarver<?>> carver = context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);
        RegistryEntryLookup<PlacedFeature> placed = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        context.register(STRAWBERRY_FIELDS, OverworldBiomes.strawberryFields(placed, carver));
        context.register(LAVENDER_MEADOW, OverworldBiomes.lavenderMeadow(placed, carver));
        context.register(BAMBOO_BLOSSOM_FOREST, OverworldBiomes.bambooBlossomForest(placed, carver));
        context.register(AUTUMNAL_GROVE, OverworldBiomes.autumnalGrove(placed, carver));
        context.register(LUSH_OASIS, OverworldBiomes.lushOasis(placed, carver));
        context.register(LAGOON, OverworldBiomes.lagoon(placed, carver));
        context.register(TROPICS, OverworldBiomes.tropics(placed, carver));
    }

}