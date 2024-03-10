package com.mysticsbiomes.common.world.feature;

import com.mysticsbiomes.common.block.StrawberryBushBlock;
import com.mysticsbiomes.common.world.placement.MysticTreePlacements;
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
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

import static com.mysticsbiomes.init.MysticFeatures.Configured.createKey;

public class MysticVegetationFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_LIGHT_GRASS = createKey("patch_light_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_STRAWBERRY_BUSH = createKey("patch_strawberry_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SPRING_BAMBOO = createKey("patch_spring_bamboo");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_PUMPKINS = createKey("patch_pumpkins");

    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_PINK_TULIP = createKey("flower_pink_tulip");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_WHITE_TULIP = createKey("flower_white_tulip");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_LILAC = createKey("flower_lilac");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_LAVENDER = createKey("flower_lavender");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_WILDFLOWER = createKey("flower_wildflower");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_CHERRY = createKey("trees_cherry");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BUSH_PEONY = createKey("bush_peony");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<PlacedFeature> getter = context.lookup(Registries.PLACED_FEATURE);
        Holder<PlacedFeature> PINK_CHERRY_TREE_CHECKED = getter.getOrThrow(MysticTreePlacements.PINK_CHERRY_TREE_CHECKED);
        Holder<PlacedFeature> WHITE_CHERRY_TREE_CHECKED = getter.getOrThrow(MysticTreePlacements.WHITE_CHERRY_TREE_CHECKED);
        Holder<PlacedFeature> PEONY_BUSH_CHECKED = getter.getOrThrow(MysticTreePlacements.PEONY_BUSH_CHECKED);

        FeatureUtils.register(context, PATCH_LIGHT_GRASS, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.GRASS)), List.of(Blocks.GRASS_BLOCK)));

        SimpleWeightedRandomList.Builder<BlockState> builder = SimpleWeightedRandomList.builder();
        for (int i = 2; i <= 5; ++i) {
            builder.add(MysticBlocks.STRAWBERRY_BUSH.get().defaultBlockState().setValue(StrawberryBushBlock.AGE, i), 1);
        }
        FeatureUtils.register(context, PATCH_STRAWBERRY_BUSH, Feature.RANDOM_PATCH, createSimpleRandomPatch(400, 9, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(builder)))));
        FeatureUtils.register(context, PATCH_SPRING_BAMBOO, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(MysticFeatures.SPRING_BAMBOO.get(), new ProbabilityFeatureConfiguration(1.0F), List.of(Blocks.GRASS_BLOCK, Blocks.PODZOL), 222));
        FeatureUtils.register(context, PATCH_PUMPKINS, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.PUMPKIN.defaultBlockState(), 3).add(Blocks.JACK_O_LANTERN.defaultBlockState(), 1))), List.of(Blocks.GRASS_BLOCK)));

        FeatureUtils.register(context, FLOWER_PINK_TULIP, Feature.FLOWER, createSimpleRandomPatch(64, 7, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.PINK_TULIP)))));
        FeatureUtils.register(context, FLOWER_WHITE_TULIP, Feature.FLOWER, createSimpleRandomPatch(64, 7, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.WHITE_TULIP)))));
        FeatureUtils.register(context, FLOWER_LILAC, Feature.FLOWER, createSimpleRandomPatch(64, 7, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.LILAC)))));
        FeatureUtils.register(context, FLOWER_LAVENDER, Feature.FLOWER, new RandomPatchConfiguration(128, 9, 7, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(MysticBlocks.LAVENDER.get())))));
        FeatureUtils.register(context, FLOWER_WILDFLOWER, Feature.FLOWER, createSimpleRandomPatch(64, 7, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(MysticBlocks.WILDFLOWER.get())))));

        FeatureUtils.register(context, TREES_CHERRY, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PINK_CHERRY_TREE_CHECKED, 0.2F), new WeightedPlacedFeature(WHITE_CHERRY_TREE_CHECKED, 0.4F)), PINK_CHERRY_TREE_CHECKED));

        FeatureUtils.register(context, BUSH_PEONY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(1, 1, 1, PlacementUtils.filtered(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(), PEONY_BUSH_CHECKED), BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.GRASS_BLOCK)))));
    }

    private static RandomPatchConfiguration createSimpleRandomPatch(int tries, int xzSpread, Holder<PlacedFeature> placement) {
        return new RandomPatchConfiguration(tries, xzSpread, 2, placement);
    }

}