package com.mysticsbiomes.common.world.placement;

import com.mysticsbiomes.common.world.feature.MysticVegetationFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import static com.mysticsbiomes.MysticsBiomes.createKey;

public class MysticVegetationPlacements {

    public static final ResourceKey<PlacedFeature> PATCH_BAMBOO = createKey(Registries.PLACED_FEATURE, "patch_bamboo");
    public static final ResourceKey<PlacedFeature> PATCH_GRASS = createKey(Registries.PLACED_FEATURE, "patch_grass");
    public static final ResourceKey<PlacedFeature> PATCH_LIGHT_GRASS = createKey(Registries.PLACED_FEATURE, "patch_light_grass");
    public static final ResourceKey<PlacedFeature> PATCH_PUMPKIN = createKey(Registries.PLACED_FEATURE, "patch_pumpkin");

    public static final ResourceKey<PlacedFeature> PLANT_STRAWBERRY_BUSH = createKey(Registries.PLACED_FEATURE, "plant_strawberry_bush");

    public static final ResourceKey<PlacedFeature> FLOWER_PINK_TULIP = createKey(Registries.PLACED_FEATURE, "flower_pink_tulip");
    public static final ResourceKey<PlacedFeature> FLOWER_WHITE_TULIP = createKey(Registries.PLACED_FEATURE, "flower_white_tulip");
    public static final ResourceKey<PlacedFeature> FLOWER_LILAC = createKey(Registries.PLACED_FEATURE, "flower_lilac");
    public static final ResourceKey<PlacedFeature> FLOWER_LAVENDER = createKey(Registries.PLACED_FEATURE, "flower_lavender");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> getter = context.lookup(Registries.CONFIGURED_FEATURE);

        Holder<ConfiguredFeature<?, ?>> bamboo = getter.getOrThrow(MysticVegetationFeatures.BAMBOO);
        Holder<ConfiguredFeature<?, ?>> grass = getter.getOrThrow(MysticVegetationFeatures.GRASS);
        Holder<ConfiguredFeature<?, ?>> lightGrass = getter.getOrThrow(MysticVegetationFeatures.LIGHT_GRASS);
        Holder<ConfiguredFeature<?, ?>> pumpkin = getter.getOrThrow(MysticVegetationFeatures.PUMPKIN_PATCH);
        Holder<ConfiguredFeature<?, ?>> strawberryBush = getter.getOrThrow(MysticVegetationFeatures.STRAWBERRY_BUSH);
        Holder<ConfiguredFeature<?, ?>> pinkTulip = getter.getOrThrow(MysticVegetationFeatures.PINK_TULIP);
        Holder<ConfiguredFeature<?, ?>> whiteTulip = getter.getOrThrow(MysticVegetationFeatures.WHITE_TULIP);
        Holder<ConfiguredFeature<?, ?>> lilac = getter.getOrThrow(MysticVegetationFeatures.LILAC);
        Holder<ConfiguredFeature<?, ?>> lavender = getter.getOrThrow(MysticVegetationFeatures.LAVENDER);

        PlacementUtils.register(context, PATCH_BAMBOO, bamboo, NoiseBasedCountPlacement.of(158, 80.0D, 0.3D), RarityFilter.onAverageOnceEvery(64), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        PlacementUtils.register(context, PATCH_GRASS, grass, VegetationPlacements.worldSurfaceSquaredWithCount(128));
        PlacementUtils.register(context, PATCH_LIGHT_GRASS, lightGrass, VegetationPlacements.worldSurfaceSquaredWithCount(8));
        PlacementUtils.register(context, PATCH_PUMPKIN, pumpkin, RarityFilter.onAverageOnceEvery(6), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        PlacementUtils.register(context, PLANT_STRAWBERRY_BUSH, strawberryBush, RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

        PlacementUtils.register(context, FLOWER_PINK_TULIP, pinkTulip, RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        PlacementUtils.register(context, FLOWER_WHITE_TULIP, whiteTulip, RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        PlacementUtils.register(context, FLOWER_LILAC, lilac, RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        PlacementUtils.register(context, FLOWER_LAVENDER, lavender, VegetationPlacements.worldSurfaceSquaredWithCount(48));
    }

}