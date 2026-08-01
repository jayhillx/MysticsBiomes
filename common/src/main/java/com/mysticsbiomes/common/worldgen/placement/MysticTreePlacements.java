package com.mysticsbiomes.common.worldgen.placement;

import com.google.common.collect.ImmutableList;
import com.mysticsbiomes.common.worldgen.feature.MysticTreeFeatures;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static com.mysticsbiomes.init.MysticFeatures.Placed.createKey;

public class MysticTreePlacements {

    public static final ResourceKey<PlacedFeature> STRAWBERRY_TREE_CHECKED = createKey("strawberry_tree_checked");
    public static final ResourceKey<PlacedFeature> PINK_CHERRY_TREE_CHECKED = createKey("pink_cherry_tree_checked");
    public static final ResourceKey<PlacedFeature> WHITE_CHERRY_TREE_CHECKED = createKey("white_cherry_tree_checked");
    public static final ResourceKey<PlacedFeature> PEONY_BUSH_CHECKED = createKey("peony_bush_checked");
    public static final ResourceKey<PlacedFeature> LAVENDER_TREE_CHECKED = createKey("lavender_tree_checked");
    public static final ResourceKey<PlacedFeature> PEACH_TREE_CHECKED = createKey("peach_tree_checked");
    public static final ResourceKey<PlacedFeature> DESERT_SHRUB_CHECKED = createKey("desert_shrub_checked");
    public static final ResourceKey<PlacedFeature> MAPLE_TREE_CHECKED = createKey("maple_tree_checked");
    public static final ResourceKey<PlacedFeature> ORANGE_MAPLE_TREE_CHECKED = createKey("orange_maple_tree_checked");
    public static final ResourceKey<PlacedFeature> YELLOW_MAPLE_TREE_CHECKED = createKey("yellow_maple_tree_checked");
    public static final ResourceKey<PlacedFeature> SEA_SHRUB_CHECKED = createKey("sea_shrub_checked");
    public static final ResourceKey<PlacedFeature> TROPICAL_TREE_CHECKED = createKey("tropical_tree_checked");
    public static final ResourceKey<PlacedFeature> LARGE_TROPICAL_TREE_CHECKED = createKey("large_tropical_tree_checked");
    public static final ResourceKey<PlacedFeature> VANILLA_TREE_CHECKED = createKey("vanilla_tree_checked");
    public static final ResourceKey<PlacedFeature> HYDRANGEA_BUSH_CHECKED = createKey("hydrangea_bush_checked");
    public static final ResourceKey<PlacedFeature> JUNGLE_SHRUB_CHECKED = createKey("jungle_shrub_checked");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> getter = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> STRAWBERRY_TREE = getter.getOrThrow(MysticTreeFeatures.STRAWBERRY_TREE);
        Holder<ConfiguredFeature<?, ?>> PINK_CHERRY_TREE = getter.getOrThrow(MysticTreeFeatures.PINK_CHERRY_TREE);
        Holder<ConfiguredFeature<?, ?>> WHITE_CHERRY_TREE = getter.getOrThrow(MysticTreeFeatures.WHITE_CHERRY_TREE);
        Holder<ConfiguredFeature<?, ?>> PEONY_BUSH = getter.getOrThrow(MysticTreeFeatures.PEONY_BUSH);
        Holder<ConfiguredFeature<?, ?>> LAVENDER_TREE = getter.getOrThrow(MysticTreeFeatures.LAVENDER_TREE);
        Holder<ConfiguredFeature<?, ?>> PEACH_TREE = getter.getOrThrow(MysticTreeFeatures.PEACH_TREE);
        Holder<ConfiguredFeature<?, ?>> DESERT_SHRUB = getter.getOrThrow(MysticTreeFeatures.DESERT_SHRUB);
        Holder<ConfiguredFeature<?, ?>> MAPLE_TREE = getter.getOrThrow(MysticTreeFeatures.MAPLE_TREE);
        Holder<ConfiguredFeature<?, ?>> ORANGE_MAPLE_TREE = getter.getOrThrow(MysticTreeFeatures.ORANGE_MAPLE_TREE);
        Holder<ConfiguredFeature<?, ?>> YELLOW_MAPLE_TREE = getter.getOrThrow(MysticTreeFeatures.YELLOW_MAPLE_TREE);
        Holder<ConfiguredFeature<?, ?>> SEA_SHRUB = getter.getOrThrow(MysticTreeFeatures.SEA_SHRUB);
        Holder<ConfiguredFeature<?, ?>> TROPICAL_TREE = getter.getOrThrow(MysticTreeFeatures.TROPICAL_TREE);
        Holder<ConfiguredFeature<?, ?>> LARGE_TROPICAL_TREE = getter.getOrThrow(MysticTreeFeatures.LARGE_TROPICAL_TREE);
        Holder<ConfiguredFeature<?, ?>> VANILLA_TREE = getter.getOrThrow(MysticTreeFeatures.VANILLA_TREE);
        Holder<ConfiguredFeature<?, ?>> HYDRANGEA_BUSH = getter.getOrThrow(MysticTreeFeatures.HYDRANGEA_BUSH);
        Holder<ConfiguredFeature<?, ?>> JUNGLE_SHRUB = getter.getOrThrow(MysticTreeFeatures.JUNGLE_SHRUB);

        PlacementUtils.register(context, STRAWBERRY_TREE_CHECKED, STRAWBERRY_TREE, VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(3), MysticBlocks.STRAWBERRY_BLOSSOM_SAPLING.get()));
        PlacementUtils.register(context, PINK_CHERRY_TREE_CHECKED, PINK_CHERRY_TREE, List.of(
                PlacementUtils.filteredByBlockSurvival(MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING.get()),
                BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE),
                BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.GRASS_BLOCK)))
        );
        PlacementUtils.register(context, WHITE_CHERRY_TREE_CHECKED, WHITE_CHERRY_TREE, List.of(
                PlacementUtils.filteredByBlockSurvival(MysticBlocks.WHITE_CHERRY_BLOSSOM_SAPLING.get()),
                BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE),
                BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.GRASS_BLOCK)))
        );
        PlacementUtils.register(context, PEONY_BUSH_CHECKED, PEONY_BUSH, treePlacement(PlacementUtils.countExtra(32, 0.2F, 1), MysticBlocks.PEONY_BUSH.get()).add(BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.GRASS_BLOCK))).build());
        PlacementUtils.register(context, LAVENDER_TREE_CHECKED, LAVENDER_TREE, VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(3), MysticBlocks.LAVENDER_BLOSSOM_SAPLING.get()));
        PlacementUtils.register(context, PEACH_TREE_CHECKED, PEACH_TREE, VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(2), MysticBlocks.PEACH_SAPLING.get()));
        PlacementUtils.register(context, DESERT_SHRUB_CHECKED, DESERT_SHRUB, VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1F, 1), MysticBlocks.PEACH_SAPLING.get()));
        PlacementUtils.register(context, MAPLE_TREE_CHECKED, MAPLE_TREE, PlacementUtils.filteredByBlockSurvival(MysticBlocks.MAPLE_SAPLING.get()));
        PlacementUtils.register(context, ORANGE_MAPLE_TREE_CHECKED, ORANGE_MAPLE_TREE, PlacementUtils.filteredByBlockSurvival(MysticBlocks.ORANGE_MAPLE_SAPLING.get()));
        PlacementUtils.register(context, YELLOW_MAPLE_TREE_CHECKED, YELLOW_MAPLE_TREE, PlacementUtils.filteredByBlockSurvival(MysticBlocks.YELLOW_MAPLE_SAPLING.get()));
        PlacementUtils.register(context, SEA_SHRUB_CHECKED, SEA_SHRUB, VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.2F, 1), MysticBlocks.SEA_SHRUB.get()));
        PlacementUtils.register(context, TROPICAL_TREE_CHECKED, TROPICAL_TREE, PlacementUtils.filteredByBlockSurvival(MysticBlocks.TROPICAL_SAPLING.get()));
        PlacementUtils.register(context, LARGE_TROPICAL_TREE_CHECKED, LARGE_TROPICAL_TREE, PlacementUtils.filteredByBlockSurvival(MysticBlocks.TROPICAL_SAPLING.get()));
        PlacementUtils.register(context, VANILLA_TREE_CHECKED, VANILLA_TREE, PlacementUtils.filteredByBlockSurvival(MysticBlocks.TROPICAL_SAPLING.get()));
        PlacementUtils.register(context, HYDRANGEA_BUSH_CHECKED, HYDRANGEA_BUSH, VegetationPlacements.treePlacement(PlacementUtils.countExtra(12, 0.1F, 1), MysticBlocks.HYDRANGEA_BUSH.get()));
        PlacementUtils.register(context, JUNGLE_SHRUB_CHECKED, JUNGLE_SHRUB, VegetationPlacements.treePlacement(PlacementUtils.countExtra(16, 0.1F, 1), MysticBlocks.HYDRANGEA_BUSH.get()));
    }

    private static ImmutableList.Builder<PlacementModifier> treePlacement(PlacementModifier modifier, Block block) {
        return treePlacementBase(modifier).add(BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(block.defaultBlockState(), BlockPos.ZERO)));
    }

    private static ImmutableList.Builder<PlacementModifier> treePlacementBase(PlacementModifier modifier) {
        return ImmutableList.<PlacementModifier>builder()
                .add(modifier)
                .add(InSquarePlacement.spread())
                .add(SurfaceWaterDepthFilter.forMaxDepth(0))
                .add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR)
                .add(BiomeFilter.biome());
    }

}