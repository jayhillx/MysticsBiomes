package com.mysticsbiomes.common.worldgen.placement;

import com.mysticsbiomes.common.worldgen.feature.MysticTreeFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.NoiseBasedCountPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import static com.mysticsbiomes.MysticsBiomes.createKey;

public class MysticTreePlacements {

    public static final ResourceKey<PlacedFeature> TREE_STRAWBERRY = createKey(Registries.PLACED_FEATURE, "tree_strawberry");
    public static final ResourceKey<PlacedFeature> TREE_PINK_CHERRY = createKey(Registries.PLACED_FEATURE, "tree_pink_cherry");
    public static final ResourceKey<PlacedFeature> TREE_WHITE_CHERRY = createKey(Registries.PLACED_FEATURE, "tree_white_cherry");
    public static final ResourceKey<PlacedFeature> TREE_JACARANDA = createKey(Registries.PLACED_FEATURE, "tree_jacaranda");

    public static final ResourceKey<PlacedFeature> BUSH_PEONY = createKey(Registries.PLACED_FEATURE, "bush_peony");

    public static void register(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> getter = context.lookup(Registries.CONFIGURED_FEATURE);

        Holder<ConfiguredFeature<?, ?>> strawberryHolder = getter.getOrThrow(MysticTreeFeatures.STRAWBERRY_TREE);
        Holder<ConfiguredFeature<?, ?>> pinkCherryHolder = getter.getOrThrow(MysticTreeFeatures.PINK_CHERRY_TREE);
        Holder<ConfiguredFeature<?, ?>> whiteCherryHolder = getter.getOrThrow(MysticTreeFeatures.WHITE_CHERRY_TREE);
        Holder<ConfiguredFeature<?, ?>> jacarandaHolder = getter.getOrThrow(MysticTreeFeatures.JACARANDA_TREE);
        Holder<ConfiguredFeature<?, ?>> peonyHolder = getter.getOrThrow(MysticTreeFeatures.PEONY_BUSH);

        PlacementUtils.register(context, TREE_STRAWBERRY, strawberryHolder, VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(3), Blocks.OAK_SAPLING));
        PlacementUtils.register(context, TREE_PINK_CHERRY, pinkCherryHolder, VegetationPlacements.treePlacement(NoiseBasedCountPlacement.of(4, 0.4D, 1), Blocks.OAK_SAPLING));
        PlacementUtils.register(context, TREE_WHITE_CHERRY, whiteCherryHolder, VegetationPlacements.treePlacement(NoiseBasedCountPlacement.of(4, 0.4D, 1), Blocks.OAK_SAPLING));
        PlacementUtils.register(context, TREE_JACARANDA, jacarandaHolder, VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(3), Blocks.OAK_SAPLING));

        PlacementUtils.register(context, BUSH_PEONY, peonyHolder, VegetationPlacements.treePlacement(NoiseBasedCountPlacement.of(9, 0.4D, 1), Blocks.OAK_SAPLING));
    }

}