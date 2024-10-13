package com.mysticsbiomes.common.world.feature;

import com.mysticsbiomes.common.block.StrawberryBushBlock;
import com.mysticsbiomes.common.world.placement.MysticTreePlacements;
import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticFeatures;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.BiasedToBottomIntProvider;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

import java.util.List;

import static com.mysticsbiomes.init.MysticFeatures.Configured.*;

public class MysticVegetationFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_GRASS_LIGHT = createKey("patch_grass_light");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_GRASS_DENSE = createKey("patch_grass_dense");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_DESERT_GRASS = createKey("patch_desert_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_SEA_OATS = createKey("patch_sea_oats");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_FERN = createKey("patch_fern");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_LARGE_FERN = createKey("patch_large_fern");

    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_GRASSY_LUSH_SAND = createKey("patch_grassy_lush_sand");

    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_STRAWBERRY_BUSH = createKey("patch_strawberry_bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_SPRING_BAMBOO = createKey("patch_spring_bamboo");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_SAGUARO_CACTUS = createKey("patch_saguaro_cactus");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_PUMPKINS = createKey("patch_pumpkins");

    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_PINK_TULIP = createKey("flower_pink_tulip");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_WHITE_TULIP = createKey("flower_white_tulip");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_ALLIUM = createKey("flower_allium");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_LILAC = createKey("flower_lilac");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_LAVENDER = createKey("flower_lavender");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_MILKWEED = createKey("flower_milkweed");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_WILDFLOWER = createKey("flower_wildflower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_PITCHER_PLANT = createKey("flower_pitcher_plant");

    public static final RegistryKey<ConfiguredFeature<?, ?>> TREES_CHERRY_BLOSSOM = createKey("trees_cherry_blossom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TREES_MAPLE = createKey("trees_maple");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BUSH_PEONY = createKey("bush_peony");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RegistryEntryLookup<PlacedFeature> getter = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        RegistryEntry<PlacedFeature> PINK_CHERRY_TREE_CHECKED = getter.getOrThrow(MysticTreePlacements.PINK_CHERRY_TREE_CHECKED);
        RegistryEntry<PlacedFeature> WHITE_CHERRY_TREE_CHECKED = getter.getOrThrow(MysticTreePlacements.WHITE_CHERRY_TREE_CHECKED);
        RegistryEntry<PlacedFeature> MAPLE_TREE_CHECKED = getter.getOrThrow(MysticTreePlacements.MAPLE_TREE_CHECKED);
        RegistryEntry<PlacedFeature> ORANGE_MAPLE_TREE_CHECKED = getter.getOrThrow(MysticTreePlacements.ORANGE_MAPLE_TREE_CHECKED);
        RegistryEntry<PlacedFeature> YELLOW_MAPLE_TREE_CHECKED = getter.getOrThrow(MysticTreePlacements.YELLOW_MAPLE_TREE_CHECKED);
        RegistryEntry<PlacedFeature> PEONY_BUSH_CHECKED = getter.getOrThrow(MysticTreePlacements.PEONY_BUSH_CHECKED);

        register(context, PATCH_GRASS_LIGHT, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.GRASS)), List.of(Blocks.GRASS_BLOCK, MysticBlocks.GRASSY_LUSH_SAND)));
        register(context, PATCH_GRASS_DENSE, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.GRASS)), List.of(Blocks.GRASS_BLOCK, MysticBlocks.GRASSY_LUSH_SAND)));
        DataPool.Builder<BlockState> builder = DataPool.builder();
        for (int i = 2; i <= 5; ++i) {
            builder.add(MysticBlocks.STRAWBERRY_BUSH.getDefaultState().with(StrawberryBushBlock.AGE, i), 1);
        }
        register(context, PATCH_STRAWBERRY_BUSH, Feature.RANDOM_PATCH, createSimpleRandomPatch(300, 9, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(builder)))));
        register(context, PATCH_SPRING_BAMBOO, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(MysticFeatures.SPRING_BAMBOO, new ProbabilityConfig(1.0F), List.of(Blocks.GRASS_BLOCK, Blocks.PODZOL), 222));
        register(context, PATCH_PUMPKINS, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(DataPool.<BlockState>builder().add(Blocks.PUMPKIN.getDefaultState(), 3).add(Blocks.JACK_O_LANTERN.getDefaultState(), 1))), List.of(Blocks.GRASS_BLOCK)));
        register(context, PATCH_SAGUARO_CACTUS, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(1, 1, 0, PlacedFeatures.createEntry(MysticFeatures.SAGUARO_CACTUS, BlockColumnFeatureConfig.create(BiasedToBottomIntProvider.create(5, 6), BlockStateProvider.of(MysticBlocks.SAGUARO_CACTUS)), BlockPredicate.allOf(BlockPredicate.IS_AIR, BlockPredicate.wouldSurvive(MysticBlocks.SAGUARO_CACTUS.getDefaultState(), BlockPos.ZERO)))));
        register(context, PATCH_DESERT_GRASS, Feature.RANDOM_PATCH, createFilteredSimpleRandomPatch(48, 9, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(MysticBlocks.DESERT_GRASS))), MysticBlocks.LUSH_SAND));
        register(context, PATCH_SEA_OATS, Feature.RANDOM_PATCH, createSimpleRandomPatch(64, 7, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(MysticBlocks.SEA_OATS)))));
        register(context, PATCH_FERN, Feature.RANDOM_PATCH, createSimpleRandomPatch(64, 7, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.FERN)))));
        register(context, PATCH_LARGE_FERN, Feature.RANDOM_PATCH, createSimpleRandomPatch(64, 7, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.LARGE_FERN)))));

        register(context, PATCH_GRASSY_LUSH_SAND, Feature.VEGETATION_PATCH, new VegetationPatchFeatureConfig(BlockTags.SAND, BlockStateProvider.of(MysticBlocks.GRASSY_LUSH_SAND), PlacedFeatures.createEntry(context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE).getOrThrow(PATCH_GRASS_LIGHT)), VerticalSurfaceType.FLOOR, ConstantIntProvider.create(1), 0.0F, 5, 0.6F, UniformIntProvider.create(1, 2), 0.75F));

        register(context, FLOWER_PINK_TULIP, Feature.FLOWER, createSimpleRandomPatch(64, 7, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.PINK_TULIP)))));
        register(context, FLOWER_WHITE_TULIP, Feature.FLOWER, createSimpleRandomPatch(64, 7, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.WHITE_TULIP)))));
        register(context, FLOWER_ALLIUM, Feature.FLOWER, createSimpleRandomPatch(64, 7, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.ALLIUM)))));
        register(context, FLOWER_LILAC, Feature.FLOWER, createSimpleRandomPatch(64, 7, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.LILAC)))));
        register(context, FLOWER_LAVENDER, Feature.FLOWER, new RandomPatchFeatureConfig(128, 9, 7, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(MysticBlocks.LAVENDER)))));
        register(context, FLOWER_WILDFLOWER, Feature.FLOWER, createFilteredSimpleRandomPatch(48, 7, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(MysticBlocks.WILDFLOWER))), MysticBlocks.LUSH_SAND));
        register(context, FLOWER_MILKWEED, Feature.FLOWER, createSimpleRandomPatch(64, 7, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(MysticBlocks.MILKWEED)))));
        register(context, FLOWER_PITCHER_PLANT, Feature.FLOWER, createSimpleRandomPatch(64, 5, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.PITCHER_PLANT)))));

        register(context, TREES_CHERRY_BLOSSOM, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(1, 1, 0, PlacedFeatures.createEntry(Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(new RandomFeatureEntry(PINK_CHERRY_TREE_CHECKED, 0.2F), new RandomFeatureEntry(WHITE_CHERRY_TREE_CHECKED, 0.5F)), PINK_CHERRY_TREE_CHECKED), BlockPredicate.allOf(BlockPredicate.IS_AIR, BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), Blocks.GRASS_BLOCK)))));
        register(context, TREES_MAPLE, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(1, 1, 0, PlacedFeatures.createEntry(Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(new RandomFeatureEntry(MAPLE_TREE_CHECKED, 0.2F), new RandomFeatureEntry(ORANGE_MAPLE_TREE_CHECKED, 0.2F), new RandomFeatureEntry(YELLOW_MAPLE_TREE_CHECKED, 0.3F)), ORANGE_MAPLE_TREE_CHECKED), BlockPredicate.allOf(BlockPredicate.IS_AIR, BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), Blocks.GRASS_BLOCK)))));
        register(context, BUSH_PEONY, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(1, 1, 0, PlacedFeatures.createEntry(Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(), PEONY_BUSH_CHECKED), BlockPredicate.allOf(BlockPredicate.IS_AIR, BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), Blocks.GRASS_BLOCK)))));
    }

    private static RandomPatchFeatureConfig createSimpleRandomPatch(int tries, int xzSpread, RegistryEntry<PlacedFeature> placement) {
        return new RandomPatchFeatureConfig(tries, xzSpread, 2, placement);
    }

    private static RandomPatchFeatureConfig createFilteredSimpleRandomPatch(int tries, int xzSpread, RegistryEntry<PlacedFeature> placement, Block... blocks) {
        return ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(tries, xzSpread, 2, placement), List.of(blocks), tries);
    }

}