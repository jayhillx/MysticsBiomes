package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.worldgen.biome.MysticBiomeProvider;
import com.mysticsbiomes.common.worldgen.biome.OverworldBiomes;
import com.mysticsbiomes.common.worldgen.surface.MysticSurfaceRules;
import com.mysticsbiomes.config.MysticConfigs;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

public class MysticBiomes {

    public static final ResourceKey<Biome> STRAWBERRY_FIELDS = createKey("strawberry_fields");
    public static final ResourceKey<Biome> LAVENDER_MEADOW = createKey("lavender_meadow");
    public static final ResourceKey<Biome> BAMBOO_BLOSSOM_FOREST = createKey("bamboo_blossom_forest");
    public static final ResourceKey<Biome> AUTUMNAL_GROVE = createKey("autumnal_grove");
    public static final ResourceKey<Biome> LUSH_OASIS = createKey("lush_oasis");
    public static final ResourceKey<Biome> LAGOON = createKey("lagoon");
    public static final ResourceKey<Biome> TROPICS = createKey("tropics");

    private static ResourceKey<Biome> createKey(String path) {
        return ResourceKey.create(Registries.BIOME, MysticsBiomes.modLoc(path));
    }

    public static void bootstrap(BootstapContext<Biome> context) {
        HolderGetter<PlacedFeature> feature = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> carver = context.lookup(Registries.CONFIGURED_CARVER);

        context.register(STRAWBERRY_FIELDS, OverworldBiomes.strawberryFields(feature, carver));
        context.register(LAVENDER_MEADOW, OverworldBiomes.lavenderMeadow(feature, carver));
        context.register(BAMBOO_BLOSSOM_FOREST, OverworldBiomes.bambooBlossomForest(feature, carver));
        context.register(AUTUMNAL_GROVE, OverworldBiomes.autumnalGrove(feature, carver));
        context.register(LUSH_OASIS, OverworldBiomes.lushOasis(feature, carver));
        context.register(LAGOON, OverworldBiomes.lagoon(feature, carver));
        context.register(TROPICS, OverworldBiomes.tropics(feature, carver));
    }

    public static void registerRegionProvider() {
        Regions.register(new MysticBiomeProvider(MysticConfigs.INSTANCE.biomeRegionWeight));
    }

    public static void registerSurfaceRules() {
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MysticsBiomes.modId, MysticSurfaceRules.mysticRules());
    }

}