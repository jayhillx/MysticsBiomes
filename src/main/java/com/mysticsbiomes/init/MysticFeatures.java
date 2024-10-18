package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.world.feature.MysticTreeFeatures;
import com.mysticsbiomes.common.world.feature.MysticVegetationFeatures;
import com.mysticsbiomes.common.world.feature.decorator.ButterflyNestDecorator;
import com.mysticsbiomes.common.world.feature.decorator.PeachFruitDecorator;
import com.mysticsbiomes.common.world.feature.decorator.VanillaOrchidDecorator;
import com.mysticsbiomes.common.world.feature.misc.MapleTreeFeature;
import com.mysticsbiomes.common.world.feature.misc.SaguaroCactusFeature;
import com.mysticsbiomes.common.world.feature.misc.SpringBambooFeature;
import com.mysticsbiomes.common.world.feature.trunk.CherryTrunkPlacer;
import com.mysticsbiomes.common.world.feature.trunk.TropicalTrunkPlacer;
import com.mysticsbiomes.common.world.placement.MysticTreePlacements;
import com.mysticsbiomes.common.world.placement.MysticVegetationPlacements;
import net.minecraft.registry.*;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class MysticFeatures {
    
    public static final Feature<ProbabilityConfig> SPRING_BAMBOO = Registry.register(Registries.FEATURE, MysticsBiomes.modLoc("spring_bamboo"), new SpringBambooFeature(ProbabilityConfig.CODEC));
    public static final Feature<BlockColumnFeatureConfig> SAGUARO_CACTUS = Registry.register(Registries.FEATURE, MysticsBiomes.modLoc("saguaro_cactus"), new SaguaroCactusFeature());
    public static final Feature<TreeFeatureConfig> MAPLE_TREE = Registry.register(Registries.FEATURE, MysticsBiomes.modLoc("maple_tree"), new MapleTreeFeature(TreeFeatureConfig.CODEC));

    public static final TreeDecoratorType<ButterflyNestDecorator> BUTTERFLY_NEST = Registry.register(Registries.TREE_DECORATOR_TYPE, MysticsBiomes.modLoc("butterfly_nest"), new TreeDecoratorType<>(ButterflyNestDecorator.CODEC));
    public static final TreeDecoratorType<PeachFruitDecorator> PEACHES = Registry.register(Registries.TREE_DECORATOR_TYPE, MysticsBiomes.modLoc("peaches"), new TreeDecoratorType<>(PeachFruitDecorator.CODEC));
    public static final TreeDecoratorType<VanillaOrchidDecorator> VANILLA_ORCHID = Registry.register(Registries.TREE_DECORATOR_TYPE, MysticsBiomes.modLoc("vanilla_orchid"), new TreeDecoratorType<>(VanillaOrchidDecorator.CODEC));

    public static final TrunkPlacerType<CherryTrunkPlacer> CHERRY_TRUNK_PLACER = Registry.register(Registries.TRUNK_PLACER_TYPE, MysticsBiomes.modLoc("cherry_trunk_placer"), new TrunkPlacerType<>(CherryTrunkPlacer.CODEC));
    public static final TrunkPlacerType<TropicalTrunkPlacer> TROPICAL_TRUNK_PLACER = Registry.register(Registries.TRUNK_PLACER_TYPE, MysticsBiomes.modLoc("tropical_trunk_placer"), new TrunkPlacerType<>(TropicalTrunkPlacer.CODEC));

    public static void registerFeatures() {
        MysticsBiomes.LOGGER.info("mystic's biomes ~ registering features");
    }

    public static class Configured {
        public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
            MysticTreeFeatures.bootstrap(context);
            MysticVegetationFeatures.bootstrap(context);
        }

        public static RegistryKey<ConfiguredFeature<?, ?>> createKey(String name) {
            return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, MysticsBiomes.modLoc(name));
        }

        public static void registerConfiguredFeatures() {
            MysticsBiomes.LOGGER.info("mystic's biomes ~ registering configured features");
        }

        public static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
            context.register(key, new ConfiguredFeature<>(feature, configuration));
        }
    }

    public static class Placed {
        public static void bootstrap(Registerable<PlacedFeature> context) {
            MysticTreePlacements.bootstrap(context);
            MysticVegetationPlacements.bootstrap(context);
        }

        public static void registerPlacedFeatures() {
            MysticsBiomes.LOGGER.info("mystic's biomes ~ registering placed features");
        }

        public static RegistryKey<PlacedFeature> createKey(String name) {
            return RegistryKey.of(RegistryKeys.PLACED_FEATURE, MysticsBiomes.modLoc(name));
        }
    }

}