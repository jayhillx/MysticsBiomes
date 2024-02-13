package com.mysticsbiomes.common.world.feature;

import com.mysticsbiomes.common.block.StrawberryBushBlock;
import com.mysticsbiomes.common.world.placement.MysticTreePlacements;
import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticFeatures;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
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
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static com.mysticsbiomes.init.MysticFeatures.Configured.register;

public class MysticVegetationFeatures {

    public static final RegistryObject<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_LIGHT_GRASS = register("patch_light_grass", Feature.RANDOM_PATCH, () -> FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.GRASS)), List.of(Blocks.GRASS_BLOCK)));
    public static final RegistryObject<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_STRAWBERRY_BUSH = register("patch_strawberry_bush", Feature.RANDOM_PATCH, () -> createSimpleRandomPatch(400, 9, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(strawberryBushBuilder())))));
    public static final RegistryObject<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_SPRING_BAMBOO = register("patch_spring_bamboo", Feature.RANDOM_PATCH, () -> FeatureUtils.simplePatchConfiguration(MysticFeatures.SPRING_BAMBOO.get(), new ProbabilityFeatureConfiguration(1.0F), List.of(Blocks.GRASS_BLOCK, Blocks.PODZOL), 222));
    public static final RegistryObject<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_PUMPKINS = register("patch_pumpkins", Feature.RANDOM_PATCH, () -> FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.PUMPKIN.defaultBlockState(), 3).add(Blocks.JACK_O_LANTERN.defaultBlockState(), 1))), List.of(Blocks.GRASS_BLOCK)));

    public static final RegistryObject<ConfiguredFeature<RandomPatchConfiguration, ?>> FLOWER_PINK_TULIP = register("flower_pink_tulip", Feature.FLOWER, () -> createSimpleRandomPatch(64, 7, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.PINK_TULIP)))));
    public static final RegistryObject<ConfiguredFeature<RandomPatchConfiguration, ?>> FLOWER_WHITE_TULIP = register("flower_white_tulip", Feature.FLOWER, () -> createSimpleRandomPatch(64, 7, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.WHITE_TULIP)))));
    public static final RegistryObject<ConfiguredFeature<RandomPatchConfiguration, ?>> FLOWER_LILAC = register("flower_lilac", Feature.FLOWER, () -> createSimpleRandomPatch(64, 7, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.LILAC)))));
    public static final RegistryObject<ConfiguredFeature<RandomPatchConfiguration, ?>> FLOWER_LAVENDER = register("flower_lavender", Feature.FLOWER, () -> new RandomPatchConfiguration(128, 9, 7, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(MysticBlocks.LAVENDER.get())))));

    public static final RegistryObject<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_CHERRY = register("trees_cherry", Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(MysticTreePlacements.PINK_CHERRY_TREE_CHECKED.getHolder().orElseThrow(), 0.2F), new WeightedPlacedFeature(MysticTreePlacements.WHITE_CHERRY_TREE_CHECKED.getHolder().orElseThrow(), 0.4F)), MysticTreePlacements.PINK_CHERRY_TREE_CHECKED.getHolder().orElseThrow()));
    public static final RegistryObject<ConfiguredFeature<RandomPatchConfiguration, ?>> BUSH_PEONY = register("bush_peony", Feature.RANDOM_PATCH, () -> new RandomPatchConfiguration(1, 1, 1, PlacementUtils.filtered(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(), MysticTreePlacements.PEONY_BUSH_CHECKED.getHolder().orElseThrow()), BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.GRASS_BLOCK)))));

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