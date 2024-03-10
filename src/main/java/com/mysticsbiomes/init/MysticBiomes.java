package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.biome.MysticBiomeProvider;
import com.mysticsbiomes.common.biome.OverworldBiomes;
import com.mysticsbiomes.common.world.MysticSurfaceRules;
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

    public static void registerRegionProvider() {
        Regions.register(new MysticBiomeProvider(MysticConfig.COMMON.biomeRegionWeight.get()));
    }

    public static void registerSurfaceRules() {
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MysticsBiomes.modId, MysticSurfaceRules.overworld());
    }

    public static void bootstrap(BootstapContext<Biome> context) {
        HolderGetter<ConfiguredWorldCarver<?>> carver = context.lookup(Registries.CONFIGURED_CARVER);
        HolderGetter<PlacedFeature> placedFeature = context.lookup(Registries.PLACED_FEATURE);

        context.register(STRAWBERRY_FIELDS, OverworldBiomes.strawberryFields(placedFeature, carver));
        context.register(LAVENDER_MEADOW, OverworldBiomes.lavenderMeadow(placedFeature, carver));
        context.register(BAMBOO_BLOSSOM_FOREST, OverworldBiomes.bambooBlossomForest(placedFeature, carver));
        context.register(AUTUMNAL_GROVE, OverworldBiomes.autumnalGrove(placedFeature, carver));
        context.register(LUSH_OASIS, OverworldBiomes.lushOasis(placedFeature, carver));
    }

    private static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, MysticsBiomes.modLoc(name));
    }

}