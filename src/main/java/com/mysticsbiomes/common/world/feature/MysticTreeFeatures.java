package com.mysticsbiomes.common.world.feature;

import com.mysticsbiomes.common.world.feature.decorator.ButterflyNestDecorator;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BushFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.List;

import static com.mysticsbiomes.MysticsBiomes.createKey;

public class MysticTreeFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> STRAWBERRY_TREE = createKey(Registries.CONFIGURED_FEATURE, "strawberry_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_CHERRY_TREE = createKey(Registries.CONFIGURED_FEATURE, "pink_cherry_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_CHERRY_TREE = createKey(Registries.CONFIGURED_FEATURE, "white_cherry_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> JACARANDA_TREE = createKey(Registries.CONFIGURED_FEATURE, "jacaranda_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_TREE = createKey(Registries.CONFIGURED_FEATURE, "maple_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_MAPLE_TREE = createKey(Registries.CONFIGURED_FEATURE, "orange_maple_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_MAPLE_TREE = createKey(Registries.CONFIGURED_FEATURE, "yellow_maple_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PEONY_BUSH = createKey(Registries.CONFIGURED_FEATURE, "peony_bush");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, STRAWBERRY_TREE, Feature.TREE, createBushyFoliage(MysticBlocks.STRAWBERRY_LOG.get(), MysticBlocks.STRAWBERRY_BLOSSOMS.get(), 8, 0, 82).build());
        FeatureUtils.register(context, PINK_CHERRY_TREE, Feature.TREE, createBushyFoliage(MysticBlocks.CHERRY_LOG.get(), MysticBlocks.PINK_CHERRY_BLOSSOMS.get(), 12, 6, 164).build());
        FeatureUtils.register(context, WHITE_CHERRY_TREE, Feature.TREE, createBushyFoliage(MysticBlocks.CHERRY_LOG.get(), MysticBlocks.WHITE_CHERRY_BLOSSOMS.get(), 12, 6, 164).build());
        FeatureUtils.register(context, JACARANDA_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(MysticBlocks.JACARANDA_LOG.get()), new BendingTrunkPlacer(4, 2, 0, 2, UniformInt.of(1, 1)), new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(MysticBlocks.JACARANDA_BLOSSOMS.get().defaultBlockState(), 3).add(MysticBlocks.JACARANDA_LEAVES.get().defaultBlockState(), 2)), new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(3), 82), new TwoLayersFeatureSize(1, 0, 1)).decorators(List.of(new ButterflyNestDecorator(0.5F))).build());
        FeatureUtils.register(context, MAPLE_TREE, Feature.TREE, createBushyFoliage(MysticBlocks.MAPLE_LOG.get(), MysticBlocks.MAPLE_LEAVES.get(), 9, 3, 74).build());
        FeatureUtils.register(context, ORANGE_MAPLE_TREE, Feature.TREE, createBushyFoliage(MysticBlocks.MAPLE_LOG.get(), MysticBlocks.ORANGE_MAPLE_LEAVES.get(), 9, 3, 74).build());
        FeatureUtils.register(context, YELLOW_MAPLE_TREE, Feature.TREE, createBushyFoliage(MysticBlocks.WHITE_MAPLE_LOG.get(), MysticBlocks.YELLOW_MAPLE_LEAVES.get(), 9, 3, 74).build());

        FeatureUtils.register(context, PEONY_BUSH, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG), new StraightTrunkPlacer(1, 0, 0), new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(MysticBlocks.BUDDING_PEONY_LEAVES.get().defaultBlockState(), 3).add(MysticBlocks.PEONY_LEAVES.get().defaultBlockState(), 3)), new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2), new TwoLayersFeatureSize(0, 0, 0)).build());
    }

    private static TreeConfiguration.TreeConfigurationBuilder createBushyFoliage(Block log, Block leaves, int baseHeight, int heightRandomA, int foliageAttempts) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(log), new FancyTrunkPlacer(baseHeight, heightRandomA, 0), BlockStateProvider.simple(leaves), new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(3), foliageAttempts), new TwoLayersFeatureSize(1, 0, 1));
    }

}