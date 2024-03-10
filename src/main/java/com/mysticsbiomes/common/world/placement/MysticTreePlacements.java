package com.mysticsbiomes.common.world.placement;

import com.mysticsbiomes.common.world.feature.MysticTreeFeatures;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.NoiseBasedCountPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import static com.mysticsbiomes.init.MysticFeatures.Placed.createKey;

public class MysticTreePlacements {

    public static final ResourceKey<PlacedFeature> STRAWBERRY_TREE_CHECKED = createKey("tree_strawberry_checked");
    public static final ResourceKey<PlacedFeature> PINK_CHERRY_TREE_CHECKED = createKey("tree_pink_cherry_checked");
    public static final ResourceKey<PlacedFeature> WHITE_CHERRY_TREE_CHECKED = createKey("tree_white_cherry_checked");
    public static final ResourceKey<PlacedFeature> PEONY_BUSH_CHECKED = createKey("bush_peony_checked");
    public static final ResourceKey<PlacedFeature> JACARANDA_TREE_CHECKED = createKey("tree_jacaranda_checked");
    public static final ResourceKey<PlacedFeature> MAPLE_TREE_CHECKED = createKey("tree_maple_checked");
    public static final ResourceKey<PlacedFeature> ORANGE_MAPLE_TREE_CHECKED = createKey("tree_orange_maple_checked");
    public static final ResourceKey<PlacedFeature> YELLOW_MAPLE_TREE_CHECKED = createKey("tree_yellow_maple_checked");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> getter = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> STRAWBERRY_TREE = getter.getOrThrow(MysticTreeFeatures.STRAWBERRY_TREE);
        Holder<ConfiguredFeature<?, ?>> PINK_CHERRY_TREE = getter.getOrThrow(MysticTreeFeatures.PINK_CHERRY_TREE);
        Holder<ConfiguredFeature<?, ?>> WHITE_CHERRY_TREE = getter.getOrThrow(MysticTreeFeatures.WHITE_CHERRY_TREE);
        Holder<ConfiguredFeature<?, ?>> PEONY_BUSH = getter.getOrThrow(MysticTreeFeatures.PEONY_BUSH);
        Holder<ConfiguredFeature<?, ?>> JACARANDA_TREE = getter.getOrThrow(MysticTreeFeatures.JACARANDA_TREE);
        Holder<ConfiguredFeature<?, ?>> MAPLE_TREE = getter.getOrThrow(MysticTreeFeatures.MAPLE_TREE);
        Holder<ConfiguredFeature<?, ?>> ORANGE_MAPLE_TREE = getter.getOrThrow(MysticTreeFeatures.ORANGE_MAPLE_TREE);
        Holder<ConfiguredFeature<?, ?>> YELLOW_MAPLE_TREE = getter.getOrThrow(MysticTreeFeatures.YELLOW_MAPLE_TREE);

        PlacementUtils.register(context, STRAWBERRY_TREE_CHECKED, STRAWBERRY_TREE, VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(3), MysticBlocks.STRAWBERRY_SAPLING.get()));
        PlacementUtils.register(context, PINK_CHERRY_TREE_CHECKED, PINK_CHERRY_TREE, PlacementUtils.filteredByBlockSurvival(MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING.get()));
        PlacementUtils.register(context, WHITE_CHERRY_TREE_CHECKED, WHITE_CHERRY_TREE, PlacementUtils.filteredByBlockSurvival(MysticBlocks.WHITE_CHERRY_BLOSSOM_SAPLING.get()));
        PlacementUtils.register(context, PEONY_BUSH_CHECKED, PEONY_BUSH, PlacementUtils.filteredByBlockSurvival(MysticBlocks.PEONY_BUSH.get()));
        PlacementUtils.register(context, JACARANDA_TREE_CHECKED, JACARANDA_TREE, VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(2), MysticBlocks.JACARANDA_SAPLING.get()));
        PlacementUtils.register(context, MAPLE_TREE_CHECKED, MAPLE_TREE, VegetationPlacements.treePlacement(NoiseBasedCountPlacement.of(2, 0.4D, 1), MysticBlocks.MAPLE_SAPLING.get()));
        PlacementUtils.register(context, ORANGE_MAPLE_TREE_CHECKED, ORANGE_MAPLE_TREE, VegetationPlacements.treePlacement(NoiseBasedCountPlacement.of(5, 0.4D, 1), MysticBlocks.ORANGE_MAPLE_SAPLING.get()));
        PlacementUtils.register(context, YELLOW_MAPLE_TREE_CHECKED, YELLOW_MAPLE_TREE, VegetationPlacements.treePlacement(NoiseBasedCountPlacement.of(4, 0.4D, 1), MysticBlocks.YELLOW_MAPLE_SAPLING.get()));
    }

}