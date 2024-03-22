package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.world.feature.MysticTreeFeatures;
import com.mysticsbiomes.common.world.feature.MysticVegetationFeatures;
import com.mysticsbiomes.common.world.feature.decorator.ButterflyNestDecorator;
import com.mysticsbiomes.common.world.feature.misc.PricklyPearFeature;
import com.mysticsbiomes.common.world.feature.misc.SpringBambooFeature;
import com.mysticsbiomes.common.world.feature.trunk.CherryTrunkPlacer;
import com.mysticsbiomes.common.world.placement.MysticTreePlacements;
import com.mysticsbiomes.common.world.placement.MysticVegetationPlacements;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MysticFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, MysticsBiomes.modId);
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = DeferredRegister.create(Registries.TREE_DECORATOR_TYPE, MysticsBiomes.modId);
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, MysticsBiomes.modId);

    public static final RegistryObject<Feature<ProbabilityFeatureConfiguration>> SPRING_BAMBOO = FEATURES.register("spring_bamboo", () -> new SpringBambooFeature(ProbabilityFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<BlockColumnConfiguration>> PRICKLY_PEAR = FEATURES.register("prickly_pear", PricklyPearFeature::new);

    public static final RegistryObject<TreeDecoratorType<ButterflyNestDecorator>> BUTTERFLY_NEST = TREE_DECORATORS.register("butterfly_nest", () -> new TreeDecoratorType<>(ButterflyNestDecorator.CODEC));

    public static final RegistryObject<TrunkPlacerType<CherryTrunkPlacer>> CHERRY_TRUNK_PLACER = TRUNK_PLACERS.register("cherry_trunk_placer", () -> new TrunkPlacerType<>(CherryTrunkPlacer.CODEC));

    public static class Configured {
        public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
            MysticTreeFeatures.bootstrap(context);
            MysticVegetationFeatures.bootstrap(context);
        }

        public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
            return ResourceKey.create(Registries.CONFIGURED_FEATURE, MysticsBiomes.modLoc(name));
        }
    }

    public static class Placed {
        public static void bootstrap(BootstapContext<PlacedFeature> context) {
            MysticTreePlacements.bootstrap(context);
            MysticVegetationPlacements.bootstrap(context);
        }

        public static ResourceKey<PlacedFeature> createKey(String name) {
            return ResourceKey.create(Registries.PLACED_FEATURE, MysticsBiomes.modLoc(name));
        }
    }

}