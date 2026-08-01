package com.mysticsbiomes.common.worldgen.feature;

import com.mysticsbiomes.common.block.StrawberryBushBlock;
import com.mysticsbiomes.common.worldgen.placement.MysticTreePlacements;
import com.mysticsbiomes.common.worldgen.placement.MysticVegetationPlacements;
import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticFeatures;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

import static com.mysticsbiomes.init.MysticFeatures.Configured.createKey;

public class MysticVegetationFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GRASS_LIGHT = createKey("patch_grass_light");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GRASS_DENSE = createKey("patch_grass_dense");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_WILD_STRAWBERRY_BUSH = createKey("patch_strawberry_bush");
    ///public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_PINK_DAISIES = createKey("flower_pink_daisies");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_PINK_TULIP = createKey("flower_pink_tulip");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_WHITE_TULIP = createKey("flower_white_tulip");

    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_LAVENDER = createKey("flower_lavender");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_TALL_LAVENDER = createKey("flower_tall_lavender");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_CHERRY = createKey("trees_cherry");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SPRING_BAMBOO = createKey("patch_spring_bamboo");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_LILAC = createKey("flower_lilac");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MAPLE = createKey("trees_maple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_PUMPKINS = createKey("patch_pumpkins");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_ASTER = createKey("flower_aster");
    ///public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_GOLDENROD = createKey("flower_goldenrod");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GRASSY_LUSH_SAND = createKey("patch_grassy_lush_sand");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VEGETATION_GRASSY_LUSH_SAND = createKey("vegetation_grassy_lush_sand");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_LUSH_SAND = createKey("patch_lush_sand");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VEGETATION_LUSH_SAND = createKey("vegetation_lush_sand");
    ///public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DESERT_SHRUB = createKey("patch_desert_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DESERT_GRASS = createKey("patch_desert_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_TALL_DESERT_GRASS = createKey("patch_tall_desert_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_DESERT_LILY = createKey("flower_desert_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_WILDFLOWER = createKey("flower_wildflower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SAGUARO_CACTUS = createKey("patch_saguaro_cactus");
    ///public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_PRICKLY_CACTUS = createKey("patch_prickly_cactus");

    ///public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SEA_FOAM = createKey("patch_sea_foam");
    ///public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BEACH_SHRUB = createKey("patch_beach_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BEACH_GRASS = createKey("patch_beach_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_TALL_BEACH_GRASS = createKey("patch_tall_beach_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SEA_OATS = createKey("patch_sea_oats");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_SEA_THRIFT = createKey("flower_sea_thrift");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_MILKWEED = createKey("flower_milkweed");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_TROPICS = createKey("trees_tropics");
    ///public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_JUNGLE_SHRUB = createKey("patch_jungle_shrub");
    ///public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_JUNGLE_GRASS = createKey("patch_jungle_grass");
    ///public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_TALL_JUNGLE_GRASS = createKey("patch_tall_jungle_grass");
    ///public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BANANA_LEAF_PLANT = createKey("patch_banana_leaf_plant");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_FERN = createKey("patch_fern");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_LARGE_FERN = createKey("patch_large_fern");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_PITCHER_PLANT = createKey("flower_pitcher_plant");
    ///public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_HIBISCUS = createKey("flower_hibiscus");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<PlacedFeature> getter = context.lookup(Registries.PLACED_FEATURE);
        Holder<PlacedFeature> PINK_CHERRY_TREE_CHECKED = getter.getOrThrow(MysticTreePlacements.PINK_CHERRY_TREE_CHECKED);
        Holder<PlacedFeature> WHITE_CHERRY_TREE_CHECKED = getter.getOrThrow(MysticTreePlacements.WHITE_CHERRY_TREE_CHECKED);
        Holder<PlacedFeature> MAPLE_TREE_CHECKED = getter.getOrThrow(MysticTreePlacements.MAPLE_TREE_CHECKED);
        Holder<PlacedFeature> ORANGE_MAPLE_TREE_CHECKED = getter.getOrThrow(MysticTreePlacements.ORANGE_MAPLE_TREE_CHECKED);
        Holder<PlacedFeature> YELLOW_MAPLE_TREE_CHECKED = getter.getOrThrow(MysticTreePlacements.YELLOW_MAPLE_TREE_CHECKED);
        Holder<PlacedFeature> TROPICAL_TREE_CHECKED = getter.getOrThrow(MysticTreePlacements.TROPICAL_TREE_CHECKED);
        Holder<PlacedFeature> LARGE_TROPICAL_TREE_CHECKED = getter.getOrThrow(MysticTreePlacements.LARGE_TROPICAL_TREE_CHECKED);
        Holder<PlacedFeature> VANILLA_TREE_CHECKED = getter.getOrThrow(MysticTreePlacements.VANILLA_TREE_CHECKED);

        FeatureUtils.register(context, PATCH_GRASS_LIGHT, Feature.RANDOM_PATCH, simplePatch(48, 7, BlockStateProvider.simple(Blocks.GRASS), List.of(Blocks.GRASS_BLOCK, MysticBlocks.GRASSY_LUSH_SAND.get())));
        FeatureUtils.register(context, PATCH_GRASS_DENSE, Feature.RANDOM_PATCH, simplePatch(128, 7, BlockStateProvider.simple(Blocks.GRASS), List.of(Blocks.GRASS_BLOCK, MysticBlocks.GRASSY_LUSH_SAND.get())));

        /// strawberry fields
        SimpleWeightedRandomList.Builder<BlockState> builder = SimpleWeightedRandomList.builder();
        for (int i = 1; i <= 5; ++i) {
            builder.add(MysticBlocks.WILD_STRAWBERRY_BUSH.get().defaultBlockState().setValue(StrawberryBushBlock.AGE, i), 1);
        }
        FeatureUtils.register(context, PATCH_WILD_STRAWBERRY_BUSH, Feature.RANDOM_PATCH, simplePatch(48, 7, new WeightedStateProvider(builder)));
        ///FeatureUtils.register(context, FLOWER_PINK_DAISIES, Feature.FLOWER, flowerPatch(16, 5, MysticBlocks.PINK_DAISIES.get()));
        FeatureUtils.register(context, FLOWER_PINK_TULIP, Feature.FLOWER, flowerPatch(16, 5, Blocks.PINK_TULIP));
        FeatureUtils.register(context, FLOWER_WHITE_TULIP, Feature.FLOWER, flowerPatch(16, 5, Blocks.WHITE_TULIP));

        /// lavender meadow
        FeatureUtils.register(context, FLOWER_LAVENDER, Feature.FLOWER, flowerPatch(32, 9, MysticBlocks.LAVENDER.get()));
        FeatureUtils.register(context, FLOWER_TALL_LAVENDER, Feature.FLOWER, flowerPatch(18, 9, MysticBlocks.TALL_LAVENDER.get()));

        /// bamboo blossom forest
        FeatureUtils.register(context, TREES_CHERRY, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PINK_CHERRY_TREE_CHECKED, 0.2F), new WeightedPlacedFeature(WHITE_CHERRY_TREE_CHECKED, 0.5F)), PINK_CHERRY_TREE_CHECKED));
        FeatureUtils.register(context, PATCH_SPRING_BAMBOO, Feature.RANDOM_PATCH, bambooPatch());
        FeatureUtils.register(context, FLOWER_LILAC, Feature.FLOWER, flowerPatch(12, 7, Blocks.LILAC));

        /// autumnal grove
        FeatureUtils.register(context, TREES_MAPLE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(MAPLE_TREE_CHECKED, 0.3F), new WeightedPlacedFeature(ORANGE_MAPLE_TREE_CHECKED, 0.2F), new WeightedPlacedFeature(YELLOW_MAPLE_TREE_CHECKED, 0.3F)), ORANGE_MAPLE_TREE_CHECKED));
        SimpleWeightedRandomList.Builder<BlockState> pumpkins = SimpleWeightedRandomList.builder();
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            pumpkins.add(Blocks.PUMPKIN.defaultBlockState(), 3);
            pumpkins.add(Blocks.JACK_O_LANTERN.defaultBlockState().setValue(CarvedPumpkinBlock.FACING, direction), 2);
        }
        FeatureUtils.register(context, PATCH_PUMPKINS, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(pumpkins)), List.of(Blocks.GRASS_BLOCK)));
        FeatureUtils.register(context, FLOWER_ASTER, Feature.FLOWER, flowerPatch(22, 5, MysticBlocks.ASTER.get()));
        ///FeatureUtils.register(context, FLOWER_GOLDENROD, Feature.FLOWER, flowerPatch(22, 5, MysticBlocks.GOLDENROD.get()));

        /// lush oasis
        FeatureUtils.register(context, PATCH_GRASSY_LUSH_SAND, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(
                BlockTags.SAND,
                BlockStateProvider.simple(MysticBlocks.GRASSY_LUSH_SAND.get()),
                PlacementUtils.inlinePlaced(context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(VEGETATION_GRASSY_LUSH_SAND)),
                CaveSurface.FLOOR,
                ConstantInt.of(1),
                0.0F,
                5,
                0.6F,
                UniformInt.of(1, 2),
                0.75F
        ));
        FeatureUtils.register(context, VEGETATION_GRASSY_LUSH_SAND, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(getter.getOrThrow(MysticVegetationPlacements.PATCH_GRASS_LIGHT), 0.4F),
                new WeightedPlacedFeature(getter.getOrThrow(MysticVegetationPlacements.FLOWER_DESERT_LILY), 0.4F)),
                getter.getOrThrow(MysticVegetationPlacements.PATCH_GRASS_LIGHT)
        ));
        FeatureUtils.register(context, PATCH_LUSH_SAND, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(
                BlockTags.SAND,                                                                                              /// replaceable
                BlockStateProvider.simple(MysticBlocks.LUSH_SAND.get()),                                                     /// groundState
                PlacementUtils.inlinePlaced(context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(VEGETATION_LUSH_SAND)), /// vegetationFeature
                CaveSurface.FLOOR,                                                                                           /// surface
                ConstantInt.of(1),                                                                                      /// depth
                0.0F,                                                                                                        /// extraBottomBlockChance
                5,                                                                                                           /// verticalRange
                0.6F,                                                                                                        /// vegetationChance
                UniformInt.of(1, 2),                                                                                         /// xzRadius
                0.75F                                                                                                        /// extraEdgeColumnChance
        ));
        FeatureUtils.register(context, VEGETATION_LUSH_SAND, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                ///new WeightedPlacedFeature(getter.getOrThrow(MysticVegetationPlacements.PATCH_DESERT_SHRUB), 0.2F),
                new WeightedPlacedFeature(getter.getOrThrow(MysticVegetationPlacements.PATCH_DESERT_GRASS), 0.3F),
                new WeightedPlacedFeature(getter.getOrThrow(MysticVegetationPlacements.PATCH_TALL_DESERT_GRASS), 0.2F),
                new WeightedPlacedFeature(getter.getOrThrow(MysticVegetationPlacements.FLOWER_WILDFLOWER), 0.2F)),
                getter.getOrThrow(MysticVegetationPlacements.PATCH_DESERT_GRASS)
        ));
        ///FeatureUtils.register(context, PATCH_DESERT_SHRUB, Feature.RANDOM_PATCH, flowerPatch(48, 9, MysticBlocks.DESERT_SHRUB.get(), MysticBlocks.GRASSY_LUSH_SAND.get()));
        FeatureUtils.register(context, PATCH_DESERT_GRASS, Feature.RANDOM_PATCH, flowerPatch(48, 9, MysticBlocks.DESERT_GRASS.get(), MysticBlocks.LUSH_SAND.get()));
        FeatureUtils.register(context, PATCH_TALL_DESERT_GRASS, Feature.RANDOM_PATCH, flowerPatch(12, 9, MysticBlocks.TALL_DESERT_GRASS.get(), MysticBlocks.LUSH_SAND.get()));
        FeatureUtils.register(context, FLOWER_DESERT_LILY, Feature.FLOWER, flowerPatch(12, 7, MysticBlocks.DESERT_LILY.get(), MysticBlocks.LUSH_SAND.get()));
        FeatureUtils.register(context, FLOWER_WILDFLOWER, Feature.FLOWER, flowerPatch(48, 7, MysticBlocks.WILDFLOWER.get(), MysticBlocks.LUSH_SAND.get()));
        FeatureUtils.register(context, PATCH_SAGUARO_CACTUS, MysticFeatures.SAGUARO_CACTUS.get());
        ///FeatureUtils.register(context, PATCH_PRICKLY_CACTUS, MysticFeatures.PRICKLY_CACTUS.get());
        
        /// lagoon
        ///FeatureUtils.register(context, PATCH_BEACH_SHRUB, Feature.RANDOM_PATCH, flowerPatch(12, 5, MysticBlocks.BEACH_SHRUB.get(), Blocks.SAND));
        FeatureUtils.register(context, PATCH_BEACH_GRASS, Feature.RANDOM_PATCH, flowerPatch(12, 5, MysticBlocks.BEACH_GRASS.get(), Blocks.SAND));
        FeatureUtils.register(context, PATCH_TALL_BEACH_GRASS, Feature.RANDOM_PATCH, flowerPatch(12, 5, MysticBlocks.TALL_BEACH_GRASS.get(), Blocks.SAND));
        FeatureUtils.register(context, PATCH_SEA_OATS, MysticFeatures.SEA_OATS.get(), flowerPatch(64, 6, MysticBlocks.SEA_OATS.get(), Blocks.SAND));
        FeatureUtils.register(context, FLOWER_SEA_THRIFT, Feature.FLOWER, flowerPatch(48, 3, MysticBlocks.SEA_THRIFT.get(), Blocks.SAND));
        FeatureUtils.register(context, FLOWER_MILKWEED, Feature.FLOWER, flowerPatch(48, 3, MysticBlocks.MILKWEED.get(), Blocks.SAND));
        
        /// tropics
        FeatureUtils.register(context, TREES_TROPICS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TROPICAL_TREE_CHECKED, 0.4F), new WeightedPlacedFeature(LARGE_TROPICAL_TREE_CHECKED, 0.4F), new WeightedPlacedFeature(VANILLA_TREE_CHECKED, 0.3F)), TROPICAL_TREE_CHECKED));
        ///FeatureUtils.register(context, PATCH_JUNGLE_SHRUB, Feature.RANDOM_PATCH, flowerPatch(12, 5, MysticBlocks.JUNGLE_SHRUB.get()));
        ///FeatureUtils.register(context, PATCH_JUNGLE_GRASS, Feature.RANDOM_PATCH, flowerPatch(12, 5, MysticBlocks.JUNGLE_GRASS.get()));
        ///FeatureUtils.register(context, PATCH_TALL_JUNGLE_GRASS, Feature.RANDOM_PATCH, flowerPatch(12, 5, MysticBlocks.TALL_JUNGLE_GRASS.get()));
        FeatureUtils.register(context, PATCH_FERN, Feature.RANDOM_PATCH, flowerPatch(Blocks.FERN));
        FeatureUtils.register(context, PATCH_LARGE_FERN, Feature.RANDOM_PATCH, flowerPatch(Blocks.LARGE_FERN));
        FeatureUtils.register(context, FLOWER_PITCHER_PLANT, Feature.FLOWER, flowerPatch(48, 5, Blocks.PITCHER_PLANT));
        ///FeatureUtils.register(context, FLOWER_HIBISCUS, Feature.FLOWER, flowerPatch(MysticBlocks.HIBISCUS.get()));
    }

    private static RandomPatchConfiguration flowerPatch(Block block) {
        return simplePatch(48, 7, BlockStateProvider.simple(block));
    }

    private static RandomPatchConfiguration flowerPatch(int tries, int xzSpread, Block block, Block... blocks) {
        return simplePatch(tries, xzSpread, BlockStateProvider.simple(block), List.of(blocks));
    }

    private static RandomPatchConfiguration simplePatch(int tries, int xzSpread, BlockStateProvider provider) {
        return simplePatch(tries, xzSpread, provider, List.of());
    }

    private static RandomPatchConfiguration simplePatch(int tries, int xzSpread, BlockStateProvider provider, List<Block> list) {
        return FeatureUtils.simplePatchConfiguration(Feature.RANDOM_PATCH, new RandomPatchConfiguration(tries, xzSpread, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(provider))), list, tries);
    }

    private static RandomPatchConfiguration bambooPatch() {
        return FeatureUtils.simplePatchConfiguration(MysticFeatures.SPRING_BAMBOO.get(), new ProbabilityFeatureConfiguration(1.0F), List.of(Blocks.GRASS_BLOCK, Blocks.PODZOL), 222);
    }

}