package com.mysticsbiomes.common.world.placement;

import com.mysticsbiomes.common.world.feature.MysticVegetationFeatures;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import static com.mysticsbiomes.init.MysticFeatures.Placed.createKey;

public class MysticVegetationPlacements {

    public static final RegistryKey<PlacedFeature> PATCH_GRASS_LIGHT = createKey("patch_grass_light");
    public static final RegistryKey<PlacedFeature> PATCH_GRASS_DENSE = createKey("patch_grass_dense");
    public static final RegistryKey<PlacedFeature> PATCH_DESERT_GRASS = createKey("patch_desert_grass");
    public static final RegistryKey<PlacedFeature> PATCH_SEA_OATS = createKey("patch_sea_oats");
    public static final RegistryKey<PlacedFeature> PATCH_FERN = createKey("patch_fern");
    public static final RegistryKey<PlacedFeature> PATCH_LARGE_FERN = createKey("patch_large_fern");

    public static final RegistryKey<PlacedFeature> PATCH_STRAWBERRY_BUSH = createKey("patch_strawberry_bush");
    public static final RegistryKey<PlacedFeature> PATCH_SPRING_BAMBOO = createKey("patch_spring_bamboo");
    public static final RegistryKey<PlacedFeature> PATCH_SAGUARO_CACTUS = createKey("patch_saguaro_cactus");
    public static final RegistryKey<PlacedFeature> PATCH_PUMPKINS = createKey("patch_pumpkins");

    public static final RegistryKey<PlacedFeature> FLOWER_PINK_TULIP = createKey("flower_pink_tulip");
    public static final RegistryKey<PlacedFeature> FLOWER_WHITE_TULIP = createKey("flower_white_tulip");
    public static final RegistryKey<PlacedFeature> FLOWER_ALLIUM = createKey("flower_allium");
    public static final RegistryKey<PlacedFeature> FLOWER_LILAC = createKey("flower_lilac");
    public static final RegistryKey<PlacedFeature> FLOWER_LAVENDER = createKey("flower_lavender");
    public static final RegistryKey<PlacedFeature> FLOWER_WILDFLOWER = createKey("flower_wildflower");
    public static final RegistryKey<PlacedFeature> FLOWER_MILKWEED = createKey("flower_milkweed");
    public static final RegistryKey<PlacedFeature> FLOWER_PITCHER_PLANT = createKey("flower_pitcher_plant");

    public static final RegistryKey<PlacedFeature> TREES_CHERRY_BLOSSOM = createKey("trees_cherry_blossom");
    public static final RegistryKey<PlacedFeature> TREES_MAPLE = createKey("trees_maple");
    public static final RegistryKey<PlacedFeature> BUSH_PEONY = createKey("bush_peony");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> getter = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        RegistryEntry<ConfiguredFeature<?, ?>> PATCH_GRASS_LIGHT = getter.getOrThrow(MysticVegetationFeatures.PATCH_GRASS_LIGHT);
        RegistryEntry<ConfiguredFeature<?, ?>> PATCH_GRASS_DENSE = getter.getOrThrow(MysticVegetationFeatures.PATCH_GRASS_DENSE);
        RegistryEntry<ConfiguredFeature<?, ?>> PATCH_DESERT_GRASS = getter.getOrThrow(MysticVegetationFeatures.PATCH_DESERT_GRASS);
        RegistryEntry<ConfiguredFeature<?, ?>> PATCH_SEA_OATS = getter.getOrThrow(MysticVegetationFeatures.PATCH_SEA_OATS);
        RegistryEntry<ConfiguredFeature<?, ?>> PATCH_FERN = getter.getOrThrow(MysticVegetationFeatures.PATCH_FERN);
        RegistryEntry<ConfiguredFeature<?, ?>> PATCH_LARGE_FERN = getter.getOrThrow(MysticVegetationFeatures.PATCH_LARGE_FERN);
        RegistryEntry<ConfiguredFeature<?, ?>> PATCH_STRAWBERRY_BUSH = getter.getOrThrow(MysticVegetationFeatures.PATCH_STRAWBERRY_BUSH);
        RegistryEntry<ConfiguredFeature<?, ?>> PATCH_SPRING_BAMBOO = getter.getOrThrow(MysticVegetationFeatures.PATCH_SPRING_BAMBOO);
        RegistryEntry<ConfiguredFeature<?, ?>> PATCH_SAGUARO_CACTUS = getter.getOrThrow(MysticVegetationFeatures.PATCH_SAGUARO_CACTUS);
        RegistryEntry<ConfiguredFeature<?, ?>> PATCH_PUMPKINS = getter.getOrThrow(MysticVegetationFeatures.PATCH_PUMPKINS);
        RegistryEntry<ConfiguredFeature<?, ?>> FLOWER_PINK_TULIP = getter.getOrThrow(MysticVegetationFeatures.FLOWER_PINK_TULIP);
        RegistryEntry<ConfiguredFeature<?, ?>> FLOWER_WHITE_TULIP = getter.getOrThrow(MysticVegetationFeatures.FLOWER_WHITE_TULIP);
        RegistryEntry<ConfiguredFeature<?, ?>> FLOWER_ALLIUM = getter.getOrThrow(MysticVegetationFeatures.FLOWER_ALLIUM);
        RegistryEntry<ConfiguredFeature<?, ?>> FLOWER_LILAC = getter.getOrThrow(MysticVegetationFeatures.FLOWER_LILAC);
        RegistryEntry<ConfiguredFeature<?, ?>> FLOWER_LAVENDER = getter.getOrThrow(MysticVegetationFeatures.FLOWER_LAVENDER);
        RegistryEntry<ConfiguredFeature<?, ?>> FLOWER_WILDFLOWER = getter.getOrThrow(MysticVegetationFeatures.FLOWER_WILDFLOWER);
        RegistryEntry<ConfiguredFeature<?, ?>> FLOWER_MILKWEED = getter.getOrThrow(MysticVegetationFeatures.FLOWER_MILKWEED);
        RegistryEntry<ConfiguredFeature<?, ?>> FLOWER_PITCHER_PLANT = getter.getOrThrow(MysticVegetationFeatures.FLOWER_PITCHER_PLANT);
        RegistryEntry<ConfiguredFeature<?, ?>> TREES_CHERRY_BLOSSOM = getter.getOrThrow(MysticVegetationFeatures.TREES_CHERRY_BLOSSOM);
        RegistryEntry<ConfiguredFeature<?, ?>> TREES_MAPLE = getter.getOrThrow(MysticVegetationFeatures.TREES_MAPLE);
        RegistryEntry<ConfiguredFeature<?, ?>> BUSH_PEONY = getter.getOrThrow(MysticVegetationFeatures.BUSH_PEONY);

        PlacedFeatures.register(context, MysticVegetationPlacements.PATCH_GRASS_LIGHT, PATCH_GRASS_LIGHT, VegetationPlacedFeatures.modifiers(8));
        PlacedFeatures.register(context, MysticVegetationPlacements.PATCH_GRASS_DENSE, PATCH_GRASS_DENSE, VegetationPlacedFeatures.modifiers(22));
        PlacedFeatures.register(context, MysticVegetationPlacements.PATCH_DESERT_GRASS, PATCH_DESERT_GRASS, RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        PlacedFeatures.register(context, MysticVegetationPlacements.PATCH_SEA_OATS, PATCH_SEA_OATS, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        PlacedFeatures.register(context, MysticVegetationPlacements.PATCH_FERN, PATCH_FERN, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        PlacedFeatures.register(context, MysticVegetationPlacements.PATCH_LARGE_FERN, PATCH_LARGE_FERN, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        PlacedFeatures.register(context, MysticVegetationPlacements.PATCH_STRAWBERRY_BUSH, PATCH_STRAWBERRY_BUSH, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        PlacedFeatures.register(context, MysticVegetationPlacements.PATCH_SPRING_BAMBOO, PATCH_SPRING_BAMBOO, NoiseBasedCountPlacementModifier.of(200, 120.0D, 0.6D), RarityFilterPlacementModifier.of(222), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        PlacedFeatures.register(context, MysticVegetationPlacements.PATCH_SAGUARO_CACTUS, PATCH_SAGUARO_CACTUS, RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        PlacedFeatures.register(context, MysticVegetationPlacements.PATCH_PUMPKINS, PATCH_PUMPKINS, RarityFilterPlacementModifier.of(5), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        PlacedFeatures.register(context, MysticVegetationPlacements.FLOWER_PINK_TULIP, FLOWER_PINK_TULIP, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        PlacedFeatures.register(context, MysticVegetationPlacements.FLOWER_WHITE_TULIP, FLOWER_WHITE_TULIP, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        PlacedFeatures.register(context, MysticVegetationPlacements.FLOWER_ALLIUM, FLOWER_ALLIUM, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        PlacedFeatures.register(context, MysticVegetationPlacements.FLOWER_LILAC, FLOWER_LILAC, RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        PlacedFeatures.register(context, MysticVegetationPlacements.FLOWER_LAVENDER, FLOWER_LAVENDER, VegetationPlacedFeatures.modifiers(48));
        PlacedFeatures.register(context, MysticVegetationPlacements.FLOWER_WILDFLOWER, FLOWER_WILDFLOWER, RarityFilterPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        PlacedFeatures.register(context, MysticVegetationPlacements.FLOWER_MILKWEED, FLOWER_MILKWEED, RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        PlacedFeatures.register(context, MysticVegetationPlacements.FLOWER_PITCHER_PLANT, FLOWER_PITCHER_PLANT, RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());

        PlacedFeatures.register(context, MysticVegetationPlacements.TREES_CHERRY_BLOSSOM, TREES_CHERRY_BLOSSOM, MysticTreePlacements.treePlacement(NoiseBasedCountPlacementModifier.of(10, 0.3D, 1), MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING)); // 5, 0.4D, 1
        PlacedFeatures.register(context, MysticVegetationPlacements.TREES_MAPLE, TREES_MAPLE, MysticTreePlacements.treePlacement(NoiseBasedCountPlacementModifier.of(8, 0.3D, 1), MysticBlocks.MAPLE_SAPLING));
        PlacedFeatures.register(context, MysticVegetationPlacements.BUSH_PEONY, BUSH_PEONY, MysticTreePlacements.treePlacement(NoiseBasedCountPlacementModifier.of(32, 0.2D, 1), MysticBlocks.PEONY_BUSH));
    }

}