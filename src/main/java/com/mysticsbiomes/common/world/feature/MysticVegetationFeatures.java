package com.mysticsbiomes.common.world.feature;

import com.mysticsbiomes.common.block.StrawberryBushBlock;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

import static com.mysticsbiomes.MysticsBiomes.createKey;

public class MysticVegetationFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> BAMBOO = createKey(Registries.CONFIGURED_FEATURE, "bamboo");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GRASS = createKey(Registries.CONFIGURED_FEATURE, "grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIGHT_GRASS = createKey(Registries.CONFIGURED_FEATURE, "light_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PUMPKIN_PATCH = createKey(Registries.CONFIGURED_FEATURE, "pumpkin_patch");

    public static final ResourceKey<ConfiguredFeature<?, ?>> STRAWBERRY_BUSH = createKey(Registries.CONFIGURED_FEATURE, "strawberry_bush");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_TULIP = createKey(Registries.CONFIGURED_FEATURE, "pink_tulip");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_TULIP = createKey(Registries.CONFIGURED_FEATURE, "white_tulip");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LILAC = createKey(Registries.CONFIGURED_FEATURE, "lilac");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LAVENDER = createKey(Registries.CONFIGURED_FEATURE, "lavender");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, BAMBOO, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.BAMBOO, new ProbabilityFeatureConfiguration(0.7F), List.of(Blocks.GRASS_BLOCK, Blocks.PODZOL), 96));
        FeatureUtils.register(context, GRASS, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.RANDOM_PATCH, new RandomPatchConfiguration(222, 7, 7, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.GRASS))))));
        FeatureUtils.register(context, LIGHT_GRASS, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.GRASS)), List.of(Blocks.GRASS_BLOCK)));
        FeatureUtils.register(context, PUMPKIN_PATCH, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.PUMPKIN.defaultBlockState(), 3).add(Blocks.JACK_O_LANTERN.defaultBlockState(), 1))), List.of(Blocks.GRASS_BLOCK)));

        SimpleWeightedRandomList.Builder<BlockState> builder = SimpleWeightedRandomList.builder();
        for (int i = 2; i <= 5; ++i) {
            builder.add(MysticBlocks.STRAWBERRY_BUSH.get().defaultBlockState().setValue(StrawberryBushBlock.AGE, i), 1);
        }
        FeatureUtils.register(context, STRAWBERRY_BUSH, Feature.RANDOM_PATCH, createSimpleRandomPatch(400, 9, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(builder)))));

        FeatureUtils.register(context, PINK_TULIP, Feature.RANDOM_PATCH, createSimpleRandomPatch(64, 7, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.PINK_TULIP)))));
        FeatureUtils.register(context, WHITE_TULIP, Feature.RANDOM_PATCH, createSimpleRandomPatch(64, 7, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.WHITE_TULIP)))));
        FeatureUtils.register(context, LILAC, Feature.RANDOM_PATCH, createSimpleRandomPatch(64, 7, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.LILAC)))));
        FeatureUtils.register(context, LAVENDER, Feature.RANDOM_PATCH, new RandomPatchConfiguration(128, 9, 7, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(MysticBlocks.LAVENDER.get())))));
    }

    private static RandomPatchConfiguration createSimpleRandomPatch(int tries, int xzSpread, Holder<PlacedFeature> placement) {
        return new RandomPatchConfiguration(tries, xzSpread, 2, placement);
    }

}