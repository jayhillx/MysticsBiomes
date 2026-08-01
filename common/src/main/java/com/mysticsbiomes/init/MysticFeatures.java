package com.mysticsbiomes.init;

import api.mystanica.registry.Registrar;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.worldgen.feature.MysticTreeFeatures;
import com.mysticsbiomes.common.worldgen.feature.MysticVegetationFeatures;
import com.mysticsbiomes.common.worldgen.feature.config.MysticTreeConfiguration;
import com.mysticsbiomes.common.worldgen.feature.decorator.ButterflyNestDecorator;
import com.mysticsbiomes.common.worldgen.feature.decorator.FallenLeavesDecorator;
import com.mysticsbiomes.common.worldgen.feature.decorator.FruitDecorator;
import com.mysticsbiomes.common.worldgen.feature.decorator.VanillaOrchidDecorator;
import com.mysticsbiomes.common.worldgen.feature.misc.SaguaroCactusFeature;
import com.mysticsbiomes.common.worldgen.feature.misc.SeaOatsFeature;
import com.mysticsbiomes.common.worldgen.feature.misc.SpringBambooFeature;
import com.mysticsbiomes.common.worldgen.feature.tree.*;
import com.mysticsbiomes.common.worldgen.placement.MysticTreePlacements;
import com.mysticsbiomes.common.worldgen.placement.MysticVegetationPlacements;
import api.mystanica.registry.RegistryEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class MysticFeatures {
    public static final Registrar<Feature<?>> FEATURES = Registrar.create(Registries.FEATURE, MysticsBiomes.modId);
    public static final Registrar<TreeDecoratorType<?>> TREE_DECORATORS = Registrar.create(Registries.TREE_DECORATOR_TYPE, MysticsBiomes.modId);

    /// features
    public static final RegistryEntry<Feature<ProbabilityFeatureConfiguration>> SPRING_BAMBOO = FEATURES.register("spring_bamboo", () -> new SpringBambooFeature(ProbabilityFeatureConfiguration.CODEC));
    public static final RegistryEntry<Feature<NoneFeatureConfiguration>> SAGUARO_CACTUS = FEATURES.register("saguaro_cactus", SaguaroCactusFeature::new);
    public static final RegistryEntry<Feature<RandomPatchConfiguration>> SEA_OATS = FEATURES.register("sea_oats", () -> new SeaOatsFeature(RandomPatchConfiguration.CODEC));

    /// trees
    public static final RegistryEntry<ShrubFeature> SHRUB = FEATURES.register("shrub", () -> new ShrubFeature(MysticTreeConfiguration.CODEC));
    public static final RegistryEntry<BushFeature> BUSH = FEATURES.register("bush", () -> new BushFeature(MysticTreeConfiguration.CODEC));
    public static final RegistryEntry<BushyTreeFeature> BUSHY_TREE = FEATURES.register("bushy_tree", () -> new BushyTreeFeature(MysticTreeConfiguration.CODEC));
    public static final RegistryEntry<CherryTreeFeature> BLACK_CHERRY_TREE = FEATURES.register("black_cherry_tree", () -> new CherryTreeFeature(MysticTreeConfiguration.CODEC));
    public static final RegistryEntry<PeachTreeFeature> PEACH_TREE = FEATURES.register("peach_tree", () -> new PeachTreeFeature(MysticTreeConfiguration.CODEC));
    public static final RegistryEntry<MapleTreeFeature> MAPLE_TREE = FEATURES.register("maple_tree", () -> new MapleTreeFeature(MysticTreeConfiguration.CODEC));
    public static final RegistryEntry<WhiteMapleTreeFeature> WHITE_MAPLE_TREE = FEATURES.register("white_maple_tree", () -> new WhiteMapleTreeFeature(MysticTreeConfiguration.CODEC));
    public static final RegistryEntry<TropicalTreeFeature> TROPICAL_TREE = FEATURES.register("tropical_tree", () -> new TropicalTreeFeature(MysticTreeConfiguration.CODEC));

    /// tree decorators
    public static final RegistryEntry<TreeDecoratorType<ButterflyNestDecorator>> BUTTERFLY_NEST = TREE_DECORATORS.register("butterfly_nest", () -> new TreeDecoratorType<>(ButterflyNestDecorator.CODEC));
    public static final RegistryEntry<TreeDecoratorType<FallenLeavesDecorator>> FALLEN_LEAVES = TREE_DECORATORS.register("fallen_leaves", () -> new TreeDecoratorType<>(FallenLeavesDecorator.CODEC));
    public static final RegistryEntry<TreeDecoratorType<FruitDecorator>> FRUIT = TREE_DECORATORS.register("fruit", () -> new TreeDecoratorType<>(FruitDecorator.CODEC));
    public static final RegistryEntry<TreeDecoratorType<VanillaOrchidDecorator>> VANILLA_ORCHID = TREE_DECORATORS.register("vanilla_orchid", () -> new TreeDecoratorType<>(VanillaOrchidDecorator.CODEC));

    public static class Configured {
        public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
            return ResourceKey.create(Registries.CONFIGURED_FEATURE, MysticsBiomes.modLoc(name));
        }

        public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
            MysticTreeFeatures.bootstrap(context);
            MysticVegetationFeatures.bootstrap(context);
        }
    }

    public static class Placed {
        public static ResourceKey<PlacedFeature> createKey(String name) {
            return ResourceKey.create(Registries.PLACED_FEATURE, MysticsBiomes.modLoc(name));
        }

        public static void bootstrap(BootstapContext<PlacedFeature> context) {
            MysticTreePlacements.bootstrap(context);
            MysticVegetationPlacements.bootstrap(context);
        }
    }

    public static void init() {
    }

}