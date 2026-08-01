package com.mysticsbiomes.common.worldgen.placement;

import com.mysticsbiomes.common.worldgen.feature.MysticVegetationFeatures;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mysticsbiomes.init.MysticFeatures.Placed.createKey;

public class MysticVegetationPlacements {

    public static final ResourceKey<PlacedFeature> PATCH_GRASS_LIGHT = createKey("patch_grass_light");
    public static final ResourceKey<PlacedFeature> PATCH_GRASS_DENSE = createKey("patch_grass_dense");

    public static final ResourceKey<PlacedFeature> PATCH_WILD_STRAWBERRY_BUSH = createKey("patch_wild_strawberry_bush");
    ///public static final ResourceKey<PlacedFeature> FLOWER_PINK_DAISIES = createKey("flower_pink_daisies");
    public static final ResourceKey<PlacedFeature> FLOWER_PINK_TULIP = createKey("flower_pink_tulip");
    public static final ResourceKey<PlacedFeature> FLOWER_WHITE_TULIP = createKey("flower_white_tulip");

    public static final ResourceKey<PlacedFeature> FLOWER_LAVENDER = createKey("flower_lavender");
    public static final ResourceKey<PlacedFeature> FLOWER_TALL_LAVENDER = createKey("flower_tall_lavender");

    public static final ResourceKey<PlacedFeature> TREES_CHERRY = createKey("trees_cherry");
    public static final ResourceKey<PlacedFeature> PATCH_SPRING_BAMBOO = createKey("patch_spring_bamboo");
    public static final ResourceKey<PlacedFeature> FLOWER_LILAC = createKey("flower_lilac");

    public static final ResourceKey<PlacedFeature> TREES_MAPLE = createKey("trees_maple");
    public static final ResourceKey<PlacedFeature> PATCH_PUMPKINS = createKey("patch_pumpkins");
    public static final ResourceKey<PlacedFeature> FLOWER_ASTER = createKey("flower_aster");
    ///public static final ResourceKey<PlacedFeature> FLOWER_GOLDENROD = createKey("flower_goldenrod");

    ///public static final ResourceKey<PlacedFeature> PATCH_DESERT_SHRUB = createKey("patch_desert_shrub");
    public static final ResourceKey<PlacedFeature> PATCH_DESERT_GRASS = createKey("patch_desert_grass");
    public static final ResourceKey<PlacedFeature> PATCH_TALL_DESERT_GRASS = createKey("patch_tall_desert_grass");
    public static final ResourceKey<PlacedFeature> FLOWER_DESERT_LILY = createKey("flower_desert_lily");
    public static final ResourceKey<PlacedFeature> FLOWER_WILDFLOWER = createKey("flower_wildflower");
    public static final ResourceKey<PlacedFeature> PATCH_SAGUARO_CACTUS = createKey("patch_saguaro_cactus");
    ///public static final ResourceKey<PlacedFeature> PATCH_PRICKLY_CACTUS = createKey("patch_prickly_cactus");

    ///public static final ResourceKey<PlacedFeature> PATCH_BEACH_SHRUB = createKey("patch_beach_shrub");
    public static final ResourceKey<PlacedFeature> PATCH_BEACH_GRASS = createKey("patch_beach_grass");
    public static final ResourceKey<PlacedFeature> PATCH_TALL_BEACH_GRASS = createKey("patch_tall_beach_grass");
    public static final ResourceKey<PlacedFeature> PATCH_SEA_OATS = createKey("patch_sea_oats");
    public static final ResourceKey<PlacedFeature> FLOWER_SEA_THRIFT = createKey("flower_sea_thrift");
    public static final ResourceKey<PlacedFeature> FLOWER_MILKWEED = createKey("flower_milkweed");
    ///public static final ResourceKey<PlacedFeature> PATCH_SEASHELLS = createKey("patch_seashells");

    public static final ResourceKey<PlacedFeature> TREES_TROPICS = createKey("trees_tropics");
    ///public static final ResourceKey<PlacedFeature> PATCH_JUNGLE_SHRUB = createKey("patch_jungle_shrub");
    ///public static final ResourceKey<PlacedFeature> PATCH_JUNGLE_GRASS = createKey("patch_jungle_grass");
    ///public static final ResourceKey<PlacedFeature> PATCH_TALL_JUNGLE_GRASS = createKey("patch_tall_jungle_grass");
    public static final ResourceKey<PlacedFeature> PATCH_FERN = createKey("patch_fern");
    public static final ResourceKey<PlacedFeature> PATCH_LARGE_FERN = createKey("patch_large_fern");
    public static final ResourceKey<PlacedFeature> FLOWER_PITCHER_PLANT = createKey("flower_pitcher_plant");
    ///public static final ResourceKey<PlacedFeature> FLOWER_HIBISCUS = createKey("flower_hibiscus");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> getter = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> PATCH_GRASS_LIGHT = getter.getOrThrow(MysticVegetationFeatures.PATCH_GRASS_LIGHT);
        Holder<ConfiguredFeature<?, ?>> PATCH_GRASS_DENSE = getter.getOrThrow(MysticVegetationFeatures.PATCH_GRASS_DENSE);

        Holder<ConfiguredFeature<?, ?>> PATCH_STRAWBERRY_BUSH = getter.getOrThrow(MysticVegetationFeatures.PATCH_WILD_STRAWBERRY_BUSH);
        ///Holder<ConfiguredFeature<?, ?>> FLOWER_PINK_DAISIES = getter.getOrThrow(MysticVegetationFeatures.FLOWER_PINK_DAISIES);
        Holder<ConfiguredFeature<?, ?>> FLOWER_PINK_TULIP = getter.getOrThrow(MysticVegetationFeatures.FLOWER_PINK_TULIP);
        Holder<ConfiguredFeature<?, ?>> FLOWER_WHITE_TULIP = getter.getOrThrow(MysticVegetationFeatures.FLOWER_WHITE_TULIP);

        Holder<ConfiguredFeature<?, ?>> FLOWER_LAVENDER = getter.getOrThrow(MysticVegetationFeatures.FLOWER_LAVENDER);
        Holder<ConfiguredFeature<?, ?>> FLOWER_TALL_LAVENDER = getter.getOrThrow(MysticVegetationFeatures.FLOWER_TALL_LAVENDER);

        Holder<ConfiguredFeature<?, ?>> TREES_CHERRY = getter.getOrThrow(MysticVegetationFeatures.TREES_CHERRY);
        Holder<ConfiguredFeature<?, ?>> PATCH_SPRING_BAMBOO = getter.getOrThrow(MysticVegetationFeatures.PATCH_SPRING_BAMBOO);
        Holder<ConfiguredFeature<?, ?>> FLOWER_LILAC = getter.getOrThrow(MysticVegetationFeatures.FLOWER_LILAC);

        Holder<ConfiguredFeature<?, ?>> TREES_MAPLE = getter.getOrThrow(MysticVegetationFeatures.TREES_MAPLE);
        Holder<ConfiguredFeature<?, ?>> PATCH_PUMPKINS = getter.getOrThrow(MysticVegetationFeatures.PATCH_PUMPKINS);
        Holder<ConfiguredFeature<?, ?>> FLOWER_ASTER = getter.getOrThrow(MysticVegetationFeatures.FLOWER_ASTER);
        ///Holder<ConfiguredFeature<?, ?>> FLOWER_GOLDENROD = getter.getOrThrow(MysticVegetationFeatures.FLOWER_GOLDENROD);
        
        ///Holder<ConfiguredFeature<?, ?>> PATCH_DESERT_SHRUB = getter.getOrThrow(MysticVegetationFeatures.PATCH_DESERT_SHRUB);
        Holder<ConfiguredFeature<?, ?>> PATCH_DESERT_GRASS = getter.getOrThrow(MysticVegetationFeatures.PATCH_DESERT_GRASS);
        Holder<ConfiguredFeature<?, ?>> PATCH_TALL_DESERT_GRASS = getter.getOrThrow(MysticVegetationFeatures.PATCH_TALL_DESERT_GRASS);
        Holder<ConfiguredFeature<?, ?>> FLOWER_DESERT_LILY = getter.getOrThrow(MysticVegetationFeatures.FLOWER_DESERT_LILY);
        Holder<ConfiguredFeature<?, ?>> FLOWER_WILDFLOWER = getter.getOrThrow(MysticVegetationFeatures.FLOWER_WILDFLOWER);
        Holder<ConfiguredFeature<?, ?>> PATCH_SAGUARO_CACTUS = getter.getOrThrow(MysticVegetationFeatures.PATCH_SAGUARO_CACTUS);
        ///Holder<ConfiguredFeature<?, ?>> PATCH_PRICKLY_CACTUS = getter.getOrThrow(MysticVegetationFeatures.PATCH_PRICKLY_CACTUS);

        ///Holder<ConfiguredFeature<?, ?>> PATCH_BEACH_SHRUB = getter.getOrThrow(MysticVegetationFeatures.PATCH_BEACH_SHRUB);
        Holder<ConfiguredFeature<?, ?>> PATCH_BEACH_GRASS = getter.getOrThrow(MysticVegetationFeatures.PATCH_BEACH_GRASS);
        Holder<ConfiguredFeature<?, ?>> PATCH_TALL_BEACH_GRASS = getter.getOrThrow(MysticVegetationFeatures.PATCH_TALL_BEACH_GRASS);
        Holder<ConfiguredFeature<?, ?>> PATCH_SEA_OATS = getter.getOrThrow(MysticVegetationFeatures.PATCH_SEA_OATS);
        Holder<ConfiguredFeature<?, ?>> FLOWER_SEA_THRIFT = getter.getOrThrow(MysticVegetationFeatures.FLOWER_SEA_THRIFT);
        Holder<ConfiguredFeature<?, ?>> FLOWER_MILKWEED = getter.getOrThrow(MysticVegetationFeatures.FLOWER_MILKWEED);
        ///Holder<ConfiguredFeature<?, ?>> PATCH_SEASHELLS = getter.getOrThrow(MysticVegetationFeatures.PATCH_SEASHELLS);

        Holder<ConfiguredFeature<?, ?>> TREES_TROPICS = getter.getOrThrow(MysticVegetationFeatures.TREES_TROPICS);
        ///Holder<ConfiguredFeature<?, ?>> PATCH_JUNGLE_SHRUB = getter.getOrThrow(MysticVegetationFeatures.PATCH_JUNGLE_SHRUB);
        ///Holder<ConfiguredFeature<?, ?>> PATCH_JUNGLE_GRASS = getter.getOrThrow(MysticVegetationFeatures.PATCH_JUNGLE_GRASS);
        ///Holder<ConfiguredFeature<?, ?>> PATCH_TALL_JUNGLE_GRASS = getter.getOrThrow(MysticVegetationFeatures.PATCH_TALL_JUNGLE_GRASS);
        Holder<ConfiguredFeature<?, ?>> PATCH_FERN = getter.getOrThrow(MysticVegetationFeatures.PATCH_FERN);
        Holder<ConfiguredFeature<?, ?>> PATCH_LARGE_FERN = getter.getOrThrow(MysticVegetationFeatures.PATCH_LARGE_FERN);
        Holder<ConfiguredFeature<?, ?>> FLOWER_PITCHER_PLANT = getter.getOrThrow(MysticVegetationFeatures.FLOWER_PITCHER_PLANT);
        ///Holder<ConfiguredFeature<?, ?>> FLOWER_HIBISCUS = getter.getOrThrow(MysticVegetationFeatures.FLOWER_HIBISCUS);

        PlacementUtils.register(context, MysticVegetationPlacements.PATCH_GRASS_LIGHT, PATCH_GRASS_LIGHT, VegetationPlacements.worldSurfaceSquaredWithCount(6));
        PlacementUtils.register(context, MysticVegetationPlacements.PATCH_GRASS_DENSE, PATCH_GRASS_DENSE, VegetationPlacements.worldSurfaceSquaredWithCount(22));

        PlacementUtils.register(context, MysticVegetationPlacements.PATCH_WILD_STRAWBERRY_BUSH, PATCH_STRAWBERRY_BUSH, basicPlacement(RarityFilter.onAverageOnceEvery(2)));
        PlacementUtils.register(context, MysticVegetationPlacements.FLOWER_PINK_TULIP, FLOWER_PINK_TULIP, basicPlacement(RarityFilter.onAverageOnceEvery(3)));
        PlacementUtils.register(context, MysticVegetationPlacements.FLOWER_WHITE_TULIP, FLOWER_WHITE_TULIP, basicPlacement(RarityFilter.onAverageOnceEvery(3)));

        PlacementUtils.register(context, MysticVegetationPlacements.FLOWER_LAVENDER, FLOWER_LAVENDER, VegetationPlacements.worldSurfaceSquaredWithCount(16));
        PlacementUtils.register(context, MysticVegetationPlacements.FLOWER_TALL_LAVENDER, FLOWER_TALL_LAVENDER, VegetationPlacements.worldSurfaceSquaredWithCount(16));

        PlacementUtils.register(context, MysticVegetationPlacements.TREES_CHERRY, TREES_CHERRY, VegetationPlacements.treePlacement(NoiseBasedCountPlacement.of(5, 0.2D, 1), MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING.get()));
        PlacementUtils.register(context, MysticVegetationPlacements.PATCH_SPRING_BAMBOO, PATCH_SPRING_BAMBOO, basicPlacement(NoiseBasedCountPlacement.of(200, 120.0D, 0.6D), RarityFilter.onAverageOnceEvery(222)));
        PlacementUtils.register(context, MysticVegetationPlacements.FLOWER_LILAC, FLOWER_LILAC, basicPlacement(RarityFilter.onAverageOnceEvery(2)));

        PlacementUtils.register(context, MysticVegetationPlacements.TREES_MAPLE, TREES_MAPLE, VegetationPlacements.treePlacement(NoiseBasedCountPlacement.of(8, 0.3D, 1), MysticBlocks.MAPLE_SAPLING.get()));
        PlacementUtils.register(context, MysticVegetationPlacements.PATCH_PUMPKINS, PATCH_PUMPKINS, basicPlacement(RarityFilter.onAverageOnceEvery(3)));
        PlacementUtils.register(context, MysticVegetationPlacements.FLOWER_ASTER, FLOWER_ASTER, basicPlacement(RarityFilter.onAverageOnceEvery(2)));
        ///PlacementUtils.register(context, MysticVegetationPlacements.FLOWER_GOLDENROD, FLOWER_GOLDENROD, basicPlacement(RarityFilter.onAverageOnceEvery(2)));

        PlacementUtils.register(context, MysticVegetationPlacements.PATCH_SAGUARO_CACTUS, PATCH_SAGUARO_CACTUS, basicPlacement(RarityFilter.onAverageOnceEvery(1)));
        PlacementUtils.register(context, MysticVegetationPlacements.PATCH_DESERT_GRASS, PATCH_DESERT_GRASS, basicPlacement(RarityFilter.onAverageOnceEvery(2)));
        PlacementUtils.register(context, MysticVegetationPlacements.PATCH_TALL_DESERT_GRASS, PATCH_TALL_DESERT_GRASS, basicPlacement(RarityFilter.onAverageOnceEvery(8)));
        PlacementUtils.register(context, MysticVegetationPlacements.FLOWER_DESERT_LILY, FLOWER_DESERT_LILY, basicPlacement(RarityFilter.onAverageOnceEvery(8)));
        PlacementUtils.register(context, MysticVegetationPlacements.FLOWER_WILDFLOWER, FLOWER_WILDFLOWER, basicPlacement(RarityFilter.onAverageOnceEvery(3)));

        PlacementUtils.register(context, MysticVegetationPlacements.PATCH_SEA_OATS, PATCH_SEA_OATS, basicPlacement(RarityFilter.onAverageOnceEvery(2)));
        PlacementUtils.register(context, MysticVegetationPlacements.PATCH_BEACH_GRASS, PATCH_BEACH_GRASS, basicPlacement(RarityFilter.onAverageOnceEvery(2)));
        PlacementUtils.register(context, MysticVegetationPlacements.PATCH_TALL_BEACH_GRASS, PATCH_TALL_BEACH_GRASS, basicPlacement(RarityFilter.onAverageOnceEvery(3)));
        PlacementUtils.register(context, MysticVegetationPlacements.FLOWER_MILKWEED, FLOWER_MILKWEED, basicPlacement(RarityFilter.onAverageOnceEvery(3)));
        PlacementUtils.register(context, MysticVegetationPlacements.FLOWER_SEA_THRIFT, FLOWER_SEA_THRIFT, basicPlacement(RarityFilter.onAverageOnceEvery(3)));

        PlacementUtils.register(context, MysticVegetationPlacements.TREES_TROPICS, TREES_TROPICS, VegetationPlacements.treePlacement(NoiseBasedCountPlacement.of(8, 0.3D, 1), MysticBlocks.TROPICAL_SAPLING.get()));
        PlacementUtils.register(context, MysticVegetationPlacements.PATCH_FERN, PATCH_FERN, basicPlacement(RarityFilter.onAverageOnceEvery(1)));
        PlacementUtils.register(context, MysticVegetationPlacements.PATCH_LARGE_FERN, PATCH_LARGE_FERN, basicPlacement(RarityFilter.onAverageOnceEvery(1)));
        PlacementUtils.register(context, MysticVegetationPlacements.FLOWER_PITCHER_PLANT, FLOWER_PITCHER_PLANT, basicPlacement(RarityFilter.onAverageOnceEvery(4)));
        ///PlacementUtils.register(context, MysticVegetationPlacements.FLOWER_HIBISCUS, FLOWER_HIBISCUS, basicPlacement(RarityFilter.onAverageOnceEvery(2)));
    }

    private static List<PlacementModifier> basicPlacement(PlacementModifier... modifiers) {
        List<PlacementModifier> list = new ArrayList<>(Arrays.asList(modifiers));
        list.add(InSquarePlacement.spread());
        list.add(PlacementUtils.HEIGHTMAP);
        list.add(BiomeFilter.biome());
        return list;
    }

}