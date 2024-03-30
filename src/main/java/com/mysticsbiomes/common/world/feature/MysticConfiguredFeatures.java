package com.mysticsbiomes.common.world.feature;

import com.mysticsbiomes.common.block.StrawberryBushBlock;
import com.mysticsbiomes.common.world.feature.decorator.ButterflyNestDecorator;
import com.mysticsbiomes.common.world.placement.MysticPlacedFeatures;
import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.FeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BushFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static com.mysticsbiomes.init.MysticFeatures.Configured.*;

public class MysticConfiguredFeatures {

    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> STRAWBERRY_TREE = register("strawberry_tree", Feature.TREE, () -> bushyTree(MysticBlocks.STRAWBERRY_LOG.get(), MysticBlocks.STRAWBERRY_BLOSSOMS.get(), 8, 0, 82).build());
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> PINK_CHERRY_TREE = register("pink_cherry_tree", Feature.TREE, () -> bushyTree(MysticBlocks.CHERRY_LOG.get(), MysticBlocks.PINK_CHERRY_BLOSSOMS.get(), 12, 6, 164).build());
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> WHITE_CHERRY_TREE = register("white_cherry_tree", Feature.TREE, () -> bushyTree(MysticBlocks.CHERRY_LOG.get(), MysticBlocks.WHITE_CHERRY_BLOSSOMS.get(), 12, 6, 164).build());
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> PEONY_BUSH = register("peony_bush", Feature.TREE, () -> bush(BlockStateProvider.simple(Blocks.OAK_LOG), randomFoliage(MysticBlocks.BUDDING_PEONY_LEAVES.get(), 4, MysticBlocks.PEONY_LEAVES.get(), 4)).build());
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> CITRUS_TREE = register("citrus_tree", Feature.TREE, () -> bushyTree(MysticBlocks.CITRUS_LOG.get(), MysticBlocks.CITRUS_LEAVES.get(), 7, 0, 68).build());
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> MAPLE_TREE = register("maple_tree", Feature.TREE, () -> bushyTree(MysticBlocks.MAPLE_LOG.get(), MysticBlocks.MAPLE_LEAVES.get(), 9, 3, 74).build());
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> ORANGE_MAPLE_TREE = register("orange_maple_tree", Feature.TREE, () -> bushyTree(MysticBlocks.MAPLE_LOG.get(), MysticBlocks.ORANGE_MAPLE_LEAVES.get(), 9, 3, 74).build());
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> YELLOW_MAPLE_TREE = register("yellow_maple_tree", Feature.TREE, () -> bushyTree(MysticBlocks.WHITE_MAPLE_LOG.get(), MysticBlocks.YELLOW_MAPLE_LEAVES.get(), 9, 3, 74).build());
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> JACARANDA_TREE = register("jacaranda_tree", Feature.TREE, () -> base(BlockStateProvider.simple(MysticBlocks.JACARANDA_LOG.get()), new BendingTrunkPlacer(4, 2, 0, 2, UniformInt.of(1, 1)), randomFoliage(MysticBlocks.JACARANDA_BLOSSOMS.get(), 3, MysticBlocks.JACARANDA_LEAVES.get(), 2), new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(3), 82)).decorators(List.of(new ButterflyNestDecorator(0.25F))).build());

    private static TreeConfiguration.TreeConfigurationBuilder bushyTree(Block log, Block leaves, int baseHeight, int heightRandomA, int foliageAttempts) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(log), new FancyTrunkPlacer(baseHeight, heightRandomA, 0), BlockStateProvider.simple(leaves), new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(3), foliageAttempts), new TwoLayersFeatureSize(1, 0, 1));
    }

    private static TreeConfiguration.TreeConfigurationBuilder bush(BlockStateProvider log, BlockStateProvider leaves) {
        return base(log, new StraightTrunkPlacer(1, 0, 0), leaves, new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2));
    }

    private static TreeConfiguration.TreeConfigurationBuilder base(BlockStateProvider log, TrunkPlacer trunkPlacer, BlockStateProvider leaves, FoliagePlacer foliagePlacer) {
        return base(log, trunkPlacer, leaves, foliagePlacer, new TwoLayersFeatureSize(1, 0, 1));
    }

    private static TreeConfiguration.TreeConfigurationBuilder base(BlockStateProvider log, TrunkPlacer trunkPlacer, BlockStateProvider leaves, FoliagePlacer foliagePlacer, FeatureSize size) {
        return new TreeConfiguration.TreeConfigurationBuilder(log, trunkPlacer, leaves, foliagePlacer, size);
    }

    private static BlockStateProvider randomFoliage(Block leaves, int weight, Block leaves2, int weight2) {
        return new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(leaves.defaultBlockState(), weight).add(leaves2.defaultBlockState(), weight2));
    }

    public static final RegistryObject<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_GRASS = register("patch_grass", Feature.RANDOM_PATCH, () -> FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.GRASS)), List.of(Blocks.GRASS_BLOCK)));
    public static final RegistryObject<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_DESERT_GRASS = register("patch_desert_grass", Feature.RANDOM_PATCH, () -> createSimpleRandomPatch(96, 9, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(MysticBlocks.DESERT_GRASS.get())))));
    public static final RegistryObject<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_STRAWBERRY_BUSH = register("patch_strawberry_bush", Feature.RANDOM_PATCH, () -> createSimpleRandomPatch(400, 9, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(strawberryBushBuilder())))));
    public static final RegistryObject<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_SPRING_BAMBOO = register("patch_spring_bamboo", Feature.RANDOM_PATCH, () -> FeatureUtils.simplePatchConfiguration(MysticFeatures.SPRING_BAMBOO.get(), new ProbabilityFeatureConfiguration(1.0F), List.of(Blocks.GRASS_BLOCK, Blocks.PODZOL), 222));
    public static final RegistryObject<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_PUMPKINS = register("patch_pumpkins", Feature.RANDOM_PATCH, () -> FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.PUMPKIN.defaultBlockState(), 3).add(Blocks.JACK_O_LANTERN.defaultBlockState(), 1))), List.of(Blocks.GRASS_BLOCK)));
    public static final RegistryObject<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_PRICKLY_PEAR = register("patch_prickly_pear", Feature.RANDOM_PATCH, () -> new RandomPatchConfiguration(2, 12, 1, PlacementUtils.inlinePlaced(MysticFeatures.PRICKLY_PEAR.get(), BlockColumnConfiguration.simple(BiasedToBottomInt.of(4, 7), BlockStateProvider.simple(MysticBlocks.PRICKLY_PEAR.get())), BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.wouldSurvive(MysticBlocks.PRICKLY_PEAR.get().defaultBlockState(), BlockPos.ZERO))))));

    public static final RegistryObject<ConfiguredFeature<RandomPatchConfiguration, ?>> FLOWER_PINK_TULIP = register("flower_pink_tulip", Feature.FLOWER, () -> createSimpleRandomPatch(64, 7, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.PINK_TULIP)))));
    public static final RegistryObject<ConfiguredFeature<RandomPatchConfiguration, ?>> FLOWER_WHITE_TULIP = register("flower_white_tulip", Feature.FLOWER, () -> createSimpleRandomPatch(64, 7, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.WHITE_TULIP)))));
    public static final RegistryObject<ConfiguredFeature<RandomPatchConfiguration, ?>> FLOWER_LILAC = register("flower_lilac", Feature.FLOWER, () -> createSimpleRandomPatch(64, 7, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.LILAC)))));
    public static final RegistryObject<ConfiguredFeature<RandomPatchConfiguration, ?>> FLOWER_LAVENDER = register("flower_lavender", Feature.FLOWER, () -> new RandomPatchConfiguration(128, 9, 7, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(MysticBlocks.LAVENDER.get())))));
    public static final RegistryObject<ConfiguredFeature<RandomPatchConfiguration, ?>> FLOWER_WILDFLOWER = register("flower_wildflower", Feature.FLOWER, () -> createSimpleRandomPatch(72, 7, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(MysticBlocks.WILDFLOWER.get())))));

    public static final RegistryObject<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_CHERRY = register("trees_cherry", Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(MysticPlacedFeatures.PINK_CHERRY_TREE_CHECKED.getHolder().orElseThrow(), 0.2F), new WeightedPlacedFeature(MysticPlacedFeatures.WHITE_CHERRY_TREE_CHECKED.getHolder().orElseThrow(), 0.4F)), MysticPlacedFeatures.PINK_CHERRY_TREE_CHECKED.getHolder().orElseThrow()));

    public static final RegistryObject<ConfiguredFeature<RandomPatchConfiguration, ?>> BUSH_PEONY = register("bush_peony", Feature.RANDOM_PATCH, () -> new RandomPatchConfiguration(1, 1, 1, PlacementUtils.filtered(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(), MysticPlacedFeatures.PEONY_BUSH_CHECKED.getHolder().orElseThrow()), BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.GRASS_BLOCK)))));

    private static RandomPatchConfiguration createSimpleRandomPatch(int tries, int xzSpread, Holder<PlacedFeature> placement) {
        return new RandomPatchConfiguration(tries, xzSpread, 2, placement);
    }

    private static SimpleWeightedRandomList.Builder<BlockState> strawberryBushBuilder() {
        SimpleWeightedRandomList.Builder<BlockState> builder = SimpleWeightedRandomList.builder();
        for (int i = 2; i <= 5; ++i) {
            builder.add(MysticBlocks.STRAWBERRY_BUSH.get().defaultBlockState().setValue(StrawberryBushBlock.AGE, i), 1);
        }
        return builder;
    }

}