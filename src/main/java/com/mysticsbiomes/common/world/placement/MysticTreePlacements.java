package com.mysticsbiomes.common.world.placement;

import com.mysticsbiomes.common.world.feature.MysticTreeFeatures;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.NoiseBasedCountPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collections;

import static com.mysticsbiomes.init.MysticFeatures.Placed.*;

public class MysticTreePlacements {

    public static final RegistryObject<PlacedFeature> STRAWBERRY_TREE_CHECKED = register("tree_strawberry_checked", MysticTreeFeatures.STRAWBERRY_TREE, () -> VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(3), MysticBlocks.STRAWBERRY_SAPLING.get()));
    public static final RegistryObject<PlacedFeature> PINK_CHERRY_TREE_CHECKED = register("tree_pink_cherry_checked", MysticTreeFeatures.PINK_CHERRY_TREE, () -> Collections.singletonList(PlacementUtils.filteredByBlockSurvival(MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING.get())));
    public static final RegistryObject<PlacedFeature> WHITE_CHERRY_TREE_CHECKED = register("tree_white_cherry_checked", MysticTreeFeatures.WHITE_CHERRY_TREE, () -> Collections.singletonList(PlacementUtils.filteredByBlockSurvival(MysticBlocks.WHITE_CHERRY_BLOSSOM_SAPLING.get())));
    public static final RegistryObject<PlacedFeature> PEONY_BUSH_CHECKED = register("bush_peony_checked", MysticTreeFeatures.PEONY_BUSH, () -> Collections.singletonList(PlacementUtils.filteredByBlockSurvival(MysticBlocks.PEONY_BUSH.get())));
    public static final RegistryObject<PlacedFeature> JACARANDA_TREE_CHECKED = register("tree_jacaranda_checked", MysticTreeFeatures.JACARANDA_TREE, () -> VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(2), MysticBlocks.JACARANDA_SAPLING.get()));
    public static final RegistryObject<PlacedFeature> MAPLE_TREE_CHECKED = register("tree_maple_checked", MysticTreeFeatures.MAPLE_TREE, () -> VegetationPlacements.treePlacement(NoiseBasedCountPlacement.of(2, 0.4D, 1), MysticBlocks.MAPLE_SAPLING.get()));
    public static final RegistryObject<PlacedFeature> ORANGE_MAPLE_TREE_CHECKED = register("tree_orange_maple_checked", MysticTreeFeatures.ORANGE_MAPLE_TREE, () -> VegetationPlacements.treePlacement(NoiseBasedCountPlacement.of(5, 0.4D, 1), MysticBlocks.ORANGE_MAPLE_SAPLING.get()));
    public static final RegistryObject<PlacedFeature> YELLOW_MAPLE_TREE_CHECKED = register("tree_yellow_maple_checked", MysticTreeFeatures.YELLOW_MAPLE_TREE, () -> VegetationPlacements.treePlacement(NoiseBasedCountPlacement.of(4, 0.4D, 1), MysticBlocks.YELLOW_MAPLE_SAPLING.get()));

}