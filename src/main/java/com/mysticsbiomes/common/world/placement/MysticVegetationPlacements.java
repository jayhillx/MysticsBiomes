package com.mysticsbiomes.common.world.placement;

import com.mysticsbiomes.common.world.feature.MysticVegetationFeatures;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static com.mysticsbiomes.init.MysticFeatures.Placed.*;

public class MysticVegetationPlacements {

    public static final RegistryObject<PlacedFeature> PATCH_LIGHT_GRASS = register("patch_light_grass", MysticVegetationFeatures.PATCH_LIGHT_GRASS, () -> VegetationPlacements.worldSurfaceSquaredWithCount(8));
    public static final RegistryObject<PlacedFeature> PATCH_STRAWBERRY_BUSH = register("patch_strawberry_bush", MysticVegetationFeatures.PATCH_STRAWBERRY_BUSH, () -> List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
    public static final RegistryObject<PlacedFeature> PATCH_SPRING_BAMBOO = register("patch_spring_bamboo", MysticVegetationFeatures.PATCH_SPRING_BAMBOO, () -> List.of(NoiseBasedCountPlacement.of(200, 120.0D, 0.4D), RarityFilter.onAverageOnceEvery(140), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
    public static final RegistryObject<PlacedFeature> PATCH_PUMPKINS = register("patch_pumpkins", MysticVegetationFeatures.PATCH_PUMPKINS, () -> List.of(RarityFilter.onAverageOnceEvery(6), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

    public static final RegistryObject<PlacedFeature> FLOWER_PINK_TULIP = register("flower_pink_tulip", MysticVegetationFeatures.FLOWER_PINK_TULIP, () -> List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
    public static final RegistryObject<PlacedFeature> FLOWER_WHITE_TULIP = register("flower_white_tulip", MysticVegetationFeatures.FLOWER_WHITE_TULIP, () -> List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
    public static final RegistryObject<PlacedFeature> FLOWER_LILAC = register("flower_lilac", MysticVegetationFeatures.FLOWER_LILAC, () -> List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
    public static final RegistryObject<PlacedFeature> FLOWER_LAVENDER = register("flower_lavender", MysticVegetationFeatures.FLOWER_LAVENDER, () -> VegetationPlacements.worldSurfaceSquaredWithCount(48));

    public static final RegistryObject<PlacedFeature> TREES_CHERRY = register("trees_cherry", MysticVegetationFeatures.TREES_CHERRY, () -> VegetationPlacements.treePlacement(NoiseBasedCountPlacement.of(4, 0.3D, 2), MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING.get())); // 5, 0.4D, 1
    public static final RegistryObject<PlacedFeature> BUSH_PEONY = register("bush_peony", MysticVegetationFeatures.BUSH_PEONY, () -> VegetationPlacements.treePlacement(NoiseBasedCountPlacement.of(64, 0.2D, 1), MysticBlocks.PEONY_BUSH.get()));

}