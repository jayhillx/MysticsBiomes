package com.mysticsbiomes.common.world.placement;

import com.mysticsbiomes.common.world.feature.MysticTreeFeatures;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.CountMultilayerPlacementModifier;

import static com.mysticsbiomes.init.MysticFeatures.Placed.createKey;

public class MysticTreePlacements {

    public static final RegistryKey<PlacedFeature> STRAWBERRY_TREE_CHECKED = createKey("strawberry_tree_checked");
    public static final RegistryKey<PlacedFeature> PINK_CHERRY_TREE_CHECKED = createKey("pink_cherry_tree_checked");
    public static final RegistryKey<PlacedFeature> WHITE_CHERRY_TREE_CHECKED = createKey("white_cherry_tree_checked");
    public static final RegistryKey<PlacedFeature> PEONY_BUSH_CHECKED = createKey("peony_bush_checked");
    public static final RegistryKey<PlacedFeature> PEACH_TREE_CHECKED = createKey("peach_tree_checked");
    public static final RegistryKey<PlacedFeature> DESERT_SHRUB_CHECKED = createKey("desert_shrub_checked");
    public static final RegistryKey<PlacedFeature> MAPLE_TREE_CHECKED = createKey("maple_tree_checked");
    public static final RegistryKey<PlacedFeature> ORANGE_MAPLE_TREE_CHECKED = createKey("orange_maple_tree_checked");
    public static final RegistryKey<PlacedFeature> YELLOW_MAPLE_TREE_CHECKED = createKey("yellow_maple_tree_checked");
    public static final RegistryKey<PlacedFeature> SEA_SHRUB_CHECKED = createKey("sea_shrub_checked");
    public static final RegistryKey<PlacedFeature> TROPICAL_TREE_CHECKED = createKey("tropical_tree_checked");
    public static final RegistryKey<PlacedFeature> HYDRANGEA_BUSH_CHECKED = createKey("hydrangea_bush_checked");
    public static final RegistryKey<PlacedFeature> JUNGLE_SHRUB_CHECKED = createKey("jungle_shrub_checked");
    public static final RegistryKey<PlacedFeature> JACARANDA_TREE_CHECKED = createKey("jacaranda_tree_checked");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> getter = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        RegistryEntry<ConfiguredFeature<?, ?>> STRAWBERRY_TREE = getter.getOrThrow(MysticTreeFeatures.STRAWBERRY_TREE);
        RegistryEntry<ConfiguredFeature<?, ?>> PINK_CHERRY_TREE = getter.getOrThrow(MysticTreeFeatures.PINK_CHERRY_TREE);
        RegistryEntry<ConfiguredFeature<?, ?>> WHITE_CHERRY_TREE = getter.getOrThrow(MysticTreeFeatures.WHITE_CHERRY_TREE);
        RegistryEntry<ConfiguredFeature<?, ?>> PEONY_BUSH = getter.getOrThrow(MysticTreeFeatures.PEONY_BUSH);
        RegistryEntry<ConfiguredFeature<?, ?>> PEACH_TREE = getter.getOrThrow(MysticTreeFeatures.PEACH_TREE);
        RegistryEntry<ConfiguredFeature<?, ?>> DESERT_SHRUB = getter.getOrThrow(MysticTreeFeatures.DESERT_SHRUB);
        RegistryEntry<ConfiguredFeature<?, ?>> MAPLE_TREE = getter.getOrThrow(MysticTreeFeatures.MAPLE_TREE);
        RegistryEntry<ConfiguredFeature<?, ?>> ORANGE_MAPLE_TREE = getter.getOrThrow(MysticTreeFeatures.ORANGE_MAPLE_TREE);
        RegistryEntry<ConfiguredFeature<?, ?>> YELLOW_MAPLE_TREE = getter.getOrThrow(MysticTreeFeatures.YELLOW_MAPLE_TREE);
        RegistryEntry<ConfiguredFeature<?, ?>> SEA_SHRUB = getter.getOrThrow(MysticTreeFeatures.SEA_SHRUB);
        RegistryEntry<ConfiguredFeature<?, ?>> TROPICAL_TREE = getter.getOrThrow(MysticTreeFeatures.TROPICAL_TREE);
        RegistryEntry<ConfiguredFeature<?, ?>> HYDRANGEA_BUSH = getter.getOrThrow(MysticTreeFeatures.HYDRANGEA_BUSH);
        RegistryEntry<ConfiguredFeature<?, ?>> JUNGLE_SHRUB = getter.getOrThrow(MysticTreeFeatures.JUNGLE_SHRUB);
        RegistryEntry<ConfiguredFeature<?, ?>> JACARANDA_TREE = getter.getOrThrow(MysticTreeFeatures.JACARANDA_TREE);

        PlacedFeatures.register(context, STRAWBERRY_TREE_CHECKED, STRAWBERRY_TREE, CountMultilayerPlacementModifier.of(3), PlacedFeatures.wouldSurvive(MysticBlocks.STRAWBERRY_SAPLING));
        PlacedFeatures.register(context, PINK_CHERRY_TREE_CHECKED, PINK_CHERRY_TREE, PlacedFeatures.wouldSurvive(MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING));
        PlacedFeatures.register(context, WHITE_CHERRY_TREE_CHECKED, WHITE_CHERRY_TREE, PlacedFeatures.wouldSurvive(MysticBlocks.WHITE_CHERRY_BLOSSOM_SAPLING));
        PlacedFeatures.register(context, PEONY_BUSH_CHECKED, PEONY_BUSH, PlacedFeatures.wouldSurvive(MysticBlocks.PEONY_BUSH));
        PlacedFeatures.register(context, PEACH_TREE_CHECKED, PEACH_TREE, CountMultilayerPlacementModifier.of(3), PlacedFeatures.wouldSurvive(MysticBlocks.PEACH_SAPLING));
        PlacedFeatures.register(context, DESERT_SHRUB_CHECKED, DESERT_SHRUB, PlacedFeatures.createCountExtraModifier(2, 0.1F, 1), PlacedFeatures.wouldSurvive(MysticBlocks.PEACH_SAPLING));
        PlacedFeatures.register(context, MAPLE_TREE_CHECKED, MAPLE_TREE, PlacedFeatures.wouldSurvive(MysticBlocks.MAPLE_SAPLING));
        PlacedFeatures.register(context, ORANGE_MAPLE_TREE_CHECKED, ORANGE_MAPLE_TREE, PlacedFeatures.wouldSurvive(MysticBlocks.ORANGE_MAPLE_SAPLING));
        PlacedFeatures.register(context, YELLOW_MAPLE_TREE_CHECKED, YELLOW_MAPLE_TREE, PlacedFeatures.wouldSurvive(MysticBlocks.YELLOW_MAPLE_SAPLING));
        PlacedFeatures.register(context, SEA_SHRUB_CHECKED, SEA_SHRUB, PlacedFeatures.createCountExtraModifier(3, 0.1F, 1), PlacedFeatures.wouldSurvive(MysticBlocks.SEA_SHRUB));
        PlacedFeatures.register(context, TROPICAL_TREE_CHECKED, TROPICAL_TREE, PlacedFeatures.createCountExtraModifier(7, 0.1F, 1), PlacedFeatures.wouldSurvive(MysticBlocks.TROPICAL_SAPLING));
        PlacedFeatures.register(context, HYDRANGEA_BUSH_CHECKED, HYDRANGEA_BUSH, PlacedFeatures.createCountExtraModifier(12, 0.1F, 1), PlacedFeatures.wouldSurvive(MysticBlocks.HYDRANGEA_BUSH));
        PlacedFeatures.register(context, JUNGLE_SHRUB_CHECKED, JUNGLE_SHRUB, PlacedFeatures.createCountExtraModifier(16, 0.1F, 1), PlacedFeatures.wouldSurvive(MysticBlocks.HYDRANGEA_BUSH));
        PlacedFeatures.register(context, JACARANDA_TREE_CHECKED, JACARANDA_TREE, CountMultilayerPlacementModifier.of(2), PlacedFeatures.wouldSurvive(MysticBlocks.JACARANDA_SAPLING));
    }

}