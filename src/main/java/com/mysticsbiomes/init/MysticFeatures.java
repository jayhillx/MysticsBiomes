package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.world.feature.decorator.ButterflyNestDecorator;
import com.mysticsbiomes.common.world.feature.misc.PricklyPearFeature;
import com.mysticsbiomes.common.world.feature.misc.SpringBambooFeature;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
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

    public static final RegistryObject<Feature<ProbabilityFeatureConfiguration>> SPRING_BAMBOO = FEATURES.register("spring_bamboo", () -> new SpringBambooFeature(ProbabilityFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<BlockColumnConfiguration>> PRICKLY_PEAR = FEATURES.register("prickly_pear", PricklyPearFeature::new);

    public static final RegistryObject<TreeDecoratorType<ButterflyNestDecorator>> BUTTERFLY_NEST = TREE_DECORATORS.register("butterfly_nest", () -> new TreeDecoratorType<>(ButterflyNestDecorator.CODEC));

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