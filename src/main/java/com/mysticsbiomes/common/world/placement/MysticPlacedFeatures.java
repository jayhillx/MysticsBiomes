package com.mysticsbiomes.common.world.placement;

import com.mysticsbiomes.common.world.feature.MysticConfiguredFeatures;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collections;
import java.util.List;

import static com.mysticsbiomes.init.MysticFeatures.Placed.*;

public class MysticPlacedFeatures {

    public static final RegistryObject<PlacedFeature> STRAWBERRY_TREE_CHECKED = register("tree_strawberry_checked", MysticConfiguredFeatures.STRAWBERRY_TREE, () -> VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(3), MysticBlocks.STRAWBERRY_SAPLING.get()));
    public static final RegistryObject<PlacedFeature> PINK_CHERRY_TREE_CHECKED = register("tree_pink_cherry_checked", MysticConfiguredFeatures.PINK_CHERRY_TREE, () -> Collections.singletonList(PlacementUtils.filteredByBlockSurvival(MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING.get())));
    public static final RegistryObject<PlacedFeature> WHITE_CHERRY_TREE_CHECKED = register("tree_white_cherry_checked", MysticConfiguredFeatures.WHITE_CHERRY_TREE, () -> Collections.singletonList(PlacementUtils.filteredByBlockSurvival(MysticBlocks.WHITE_CHERRY_BLOSSOM_SAPLING.get())));
    public static final RegistryObject<PlacedFeature> PEONY_BUSH_CHECKED = register("bush_peony_checked", MysticConfiguredFeatures.PEONY_BUSH, () -> Collections.singletonList(PlacementUtils.filteredByBlockSurvival(MysticBlocks.PEONY_BUSH.get())));
    public static final RegistryObject<PlacedFeature> CITRUS_TREE_CHECKED = register("tree_citrus_checked", MysticConfiguredFeatures.CITRUS_TREE, () -> VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(2), MysticBlocks.CITRUS_SAPLING.get()));
    public static final RegistryObject<PlacedFeature> MAPLE_TREE_CHECKED = register("tree_maple_checked", MysticConfiguredFeatures.MAPLE_TREE, () -> VegetationPlacements.treePlacement(NoiseBasedCountPlacement.of(2, 0.4D, 1), MysticBlocks.MAPLE_SAPLING.get()));
    public static final RegistryObject<PlacedFeature> ORANGE_MAPLE_TREE_CHECKED = register("tree_orange_maple_checked", MysticConfiguredFeatures.ORANGE_MAPLE_TREE, () -> VegetationPlacements.treePlacement(NoiseBasedCountPlacement.of(5, 0.4D, 1), MysticBlocks.ORANGE_MAPLE_SAPLING.get()));
    public static final RegistryObject<PlacedFeature> YELLOW_MAPLE_TREE_CHECKED = register("tree_yellow_maple_checked", MysticConfiguredFeatures.YELLOW_MAPLE_TREE, () -> VegetationPlacements.treePlacement(NoiseBasedCountPlacement.of(4, 0.4D, 1), MysticBlocks.YELLOW_MAPLE_SAPLING.get()));
    public static final RegistryObject<PlacedFeature> JACARANDA_TREE_CHECKED = register("tree_jacaranda_checked", MysticConfiguredFeatures.JACARANDA_TREE, () -> VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(2), MysticBlocks.JACARANDA_SAPLING.get()));

    public static final RegistryObject<PlacedFeature> PATCH_GRASS = register("patch_grass", MysticConfiguredFeatures.PATCH_GRASS, () -> VegetationPlacements.worldSurfaceSquaredWithCount(8));
    public static final RegistryObject<PlacedFeature> PATCH_DESERT_GRASS = register("patch_desert_grass", MysticConfiguredFeatures.PATCH_DESERT_GRASS, () -> List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
    public static final RegistryObject<PlacedFeature> PATCH_STRAWBERRY_BUSH = register("patch_strawberry_bush", MysticConfiguredFeatures.PATCH_STRAWBERRY_BUSH, () -> List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
    public static final RegistryObject<PlacedFeature> PATCH_SPRING_BAMBOO = register("patch_spring_bamboo", MysticConfiguredFeatures.PATCH_SPRING_BAMBOO, () -> List.of(NoiseBasedCountPlacement.of(200, 120.0D, 0.4D), RarityFilter.onAverageOnceEvery(140), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
    public static final RegistryObject<PlacedFeature> PATCH_PUMPKINS = register("patch_pumpkins", MysticConfiguredFeatures.PATCH_PUMPKINS, () -> List.of(RarityFilter.onAverageOnceEvery(6), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final RegistryObject<PlacedFeature> PATCH_PRICKLY_PEAR = register("patch_prickly_pear", MysticConfiguredFeatures.PATCH_PRICKLY_PEAR, () -> List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

    public static final RegistryObject<PlacedFeature> FLOWER_PINK_TULIP = register("flower_pink_tulip", MysticConfiguredFeatures.FLOWER_PINK_TULIP, () -> List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
    public static final RegistryObject<PlacedFeature> FLOWER_WHITE_TULIP = register("flower_white_tulip", MysticConfiguredFeatures.FLOWER_WHITE_TULIP, () -> List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
    public static final RegistryObject<PlacedFeature> FLOWER_LILAC = register("flower_lilac", MysticConfiguredFeatures.FLOWER_LILAC, () -> List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
    public static final RegistryObject<PlacedFeature> FLOWER_LAVENDER = register("flower_lavender", MysticConfiguredFeatures.FLOWER_LAVENDER, () -> VegetationPlacements.worldSurfaceSquaredWithCount(48));
    public static final RegistryObject<PlacedFeature> FLOWER_WILDFLOWER = register("flower_wildflower", MysticConfiguredFeatures.FLOWER_WILDFLOWER, () -> List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

    public static final RegistryObject<PlacedFeature> TREES_CHERRY = register("trees_cherry", MysticConfiguredFeatures.TREES_CHERRY, () -> VegetationPlacements.treePlacement(NoiseBasedCountPlacement.of(4, 0.3D, 2), MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING.get())); // 5, 0.4D, 1

    public static final RegistryObject<PlacedFeature> BUSH_PEONY = register("bush_peony", MysticConfiguredFeatures.BUSH_PEONY, () -> VegetationPlacements.treePlacement(NoiseBasedCountPlacement.of(64, 0.2D, 1), MysticBlocks.PEONY_BUSH.get()));

}