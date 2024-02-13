package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.world.feature.decorator.ButterflyNestDecorator;
import com.mysticsbiomes.common.world.feature.foliage.CherryFoliagePlacer;
import com.mysticsbiomes.common.world.feature.misc.SpringBambooFeature;
import com.mysticsbiomes.common.world.feature.trunk.CherryTrunkPlacer;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class MysticFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registry.FEATURE_REGISTRY, MysticsBiomes.modId);
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, MysticsBiomes.modId);
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, MysticsBiomes.modId);
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = DeferredRegister.create(Registry.TREE_DECORATOR_TYPE_REGISTRY, MysticsBiomes.modId);
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS = DeferredRegister.create(Registry.TRUNK_PLACER_TYPES.key(), MysticsBiomes.modId);
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(Registry.FOLIAGE_PLACER_TYPE_REGISTRY, MysticsBiomes.modId);

    public static final RegistryObject<Feature<ProbabilityFeatureConfiguration>> SPRING_BAMBOO = FEATURES.register("spring_bamboo", () -> new SpringBambooFeature(ProbabilityFeatureConfiguration.CODEC));

    public static final RegistryObject<TreeDecoratorType<ButterflyNestDecorator>> BUTTERFLY_NEST = TREE_DECORATORS.register("butterfly_nest", () -> new TreeDecoratorType<>(ButterflyNestDecorator.CODEC));

    public static final RegistryObject<TrunkPlacerType<CherryTrunkPlacer>> CHERRY_TRUNK_PLACER = TRUNK_PLACERS.register("cherry_trunk_placer", () -> new TrunkPlacerType<>(CherryTrunkPlacer.CODEC));

    public static final RegistryObject<FoliagePlacerType<CherryFoliagePlacer>> CHERRY_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("cherry_foliage_placer", () -> new FoliagePlacerType<>(CherryFoliagePlacer.CODEC));

    public static class Configured {
        public static <FC extends FeatureConfiguration, F extends Feature<FC>> RegistryObject<ConfiguredFeature<FC, ?>> register(String name, F feature, Supplier<FC> configuredFeature) {
            return CONFIGURED_FEATURES.register(name, () -> new ConfiguredFeature<>(feature, configuredFeature.get()));
        }
    }

    public static class Placed {
        public static RegistryObject<PlacedFeature> register(String name, RegistryObject<? extends ConfiguredFeature<?, ?>> feature, Supplier<List<PlacementModifier>> modifiers) {
            return PLACED_FEATURES.register(name, () -> new PlacedFeature(Holder.hackyErase(feature.getHolder().orElseThrow()), List.copyOf(modifiers.get())));
        }

        public static RegistryObject<PlacedFeature> register(String name, RegistryObject<? extends ConfiguredFeature<?, ?>> feature) {
            return register(name, feature, List::of);
        }
    }

}