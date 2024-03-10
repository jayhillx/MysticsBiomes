package com.mysticsbiomes.common.world.placement;

import com.mysticsbiomes.common.world.feature.MysticVegetationFeatures;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import static com.mysticsbiomes.init.MysticFeatures.Placed.createKey;

public class MysticVegetationPlacements {

    public static final ResourceKey<PlacedFeature> PATCH_LIGHT_GRASS = createKey("patch_light_grass");
    public static final ResourceKey<PlacedFeature> PATCH_STRAWBERRY_BUSH = createKey("patch_strawberry_bush");
    public static final ResourceKey<PlacedFeature> PATCH_SPRING_BAMBOO = createKey("patch_spring_bamboo");
    public static final ResourceKey<PlacedFeature> PATCH_PUMPKINS = createKey("patch_pumpkins");

    public static final ResourceKey<PlacedFeature> FLOWER_PINK_TULIP = createKey("flower_pink_tulip");
    public static final ResourceKey<PlacedFeature> FLOWER_WHITE_TULIP = createKey("flower_white_tulip");
    public static final ResourceKey<PlacedFeature> FLOWER_LILAC = createKey("flower_lilac");
    public static final ResourceKey<PlacedFeature> FLOWER_LAVENDER = createKey("flower_lavender");
    public static final ResourceKey<PlacedFeature> FLOWER_WILDFLOWER = createKey("flower_wildflower");

    public static final ResourceKey<PlacedFeature> TREES_CHERRY = createKey("trees_cherry");

    public static final ResourceKey<PlacedFeature> BUSH_PEONY = createKey("bush_peony");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> getter = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> PATCH_LIGHT_GRASS = getter.getOrThrow(MysticVegetationFeatures.PATCH_LIGHT_GRASS);
        Holder<ConfiguredFeature<?, ?>> PATCH_STRAWBERRY_BUSH = getter.getOrThrow(MysticVegetationFeatures.PATCH_STRAWBERRY_BUSH);
        Holder<ConfiguredFeature<?, ?>> PATCH_SPRING_BAMBOO = getter.getOrThrow(MysticVegetationFeatures.PATCH_SPRING_BAMBOO);
        Holder<ConfiguredFeature<?, ?>> PATCH_PUMPKINS = getter.getOrThrow(MysticVegetationFeatures.PATCH_PUMPKINS);
        Holder<ConfiguredFeature<?, ?>> FLOWER_PINK_TULIP = getter.getOrThrow(MysticVegetationFeatures.FLOWER_PINK_TULIP);
        Holder<ConfiguredFeature<?, ?>> FLOWER_WHITE_TULIP = getter.getOrThrow(MysticVegetationFeatures.FLOWER_WHITE_TULIP);
        Holder<ConfiguredFeature<?, ?>> FLOWER_LILAC = getter.getOrThrow(MysticVegetationFeatures.FLOWER_LILAC);
        Holder<ConfiguredFeature<?, ?>> FLOWER_LAVENDER = getter.getOrThrow(MysticVegetationFeatures.FLOWER_LAVENDER);
        Holder<ConfiguredFeature<?, ?>> FLOWER_WILDFLOWER = getter.getOrThrow(MysticVegetationFeatures.FLOWER_WILDFLOWER);
        Holder<ConfiguredFeature<?, ?>> TREES_CHERRY = getter.getOrThrow(MysticVegetationFeatures.TREES_CHERRY);
        Holder<ConfiguredFeature<?, ?>> BUSH_PEONY = getter.getOrThrow(MysticVegetationFeatures.BUSH_PEONY);

        PlacementUtils.register(context, MysticVegetationPlacements.PATCH_LIGHT_GRASS, PATCH_LIGHT_GRASS, VegetationPlacements.worldSurfaceSquaredWithCount(8));
        PlacementUtils.register(context, MysticVegetationPlacements.PATCH_STRAWBERRY_BUSH, PATCH_STRAWBERRY_BUSH, RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        PlacementUtils.register(context, MysticVegetationPlacements.PATCH_SPRING_BAMBOO, PATCH_SPRING_BAMBOO, NoiseBasedCountPlacement.of(200, 120.0D, 0.4D), RarityFilter.onAverageOnceEvery(140), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        PlacementUtils.register(context, MysticVegetationPlacements.PATCH_PUMPKINS, PATCH_PUMPKINS, RarityFilter.onAverageOnceEvery(6), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        PlacementUtils.register(context, MysticVegetationPlacements.FLOWER_PINK_TULIP, FLOWER_PINK_TULIP, RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        PlacementUtils.register(context, MysticVegetationPlacements.FLOWER_WHITE_TULIP, FLOWER_WHITE_TULIP, RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        PlacementUtils.register(context, MysticVegetationPlacements.FLOWER_LILAC, FLOWER_LILAC, RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        PlacementUtils.register(context, MysticVegetationPlacements.FLOWER_LAVENDER, FLOWER_LAVENDER, VegetationPlacements.worldSurfaceSquaredWithCount(48));
        PlacementUtils.register(context, MysticVegetationPlacements.FLOWER_WILDFLOWER, FLOWER_WILDFLOWER, RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

        PlacementUtils.register(context, MysticVegetationPlacements.TREES_CHERRY, TREES_CHERRY, VegetationPlacements.treePlacement(NoiseBasedCountPlacement.of(4, 0.3D, 2), MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING.get())); // 5, 0.4D, 1

        PlacementUtils.register(context, MysticVegetationPlacements.BUSH_PEONY, BUSH_PEONY, VegetationPlacements.treePlacement(NoiseBasedCountPlacement.of(64, 0.2D, 1), MysticBlocks.PEONY_BUSH.get()));
    }

}