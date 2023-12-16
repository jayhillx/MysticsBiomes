package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.world.feature.MysticTreeFeatures;
import com.mysticsbiomes.common.world.feature.MysticVegetationFeatures;
import com.mysticsbiomes.common.world.feature.decorator.ButterflyNestDecorator;
import com.mysticsbiomes.common.world.placement.MysticTreePlacements;
import com.mysticsbiomes.common.world.placement.MysticVegetationPlacements;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MysticFeatures {

    public static class Configured {
        public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
            MysticTreeFeatures.bootstrap(context);
            MysticVegetationFeatures.bootstrap(context);
        }
    }

    public static class Placed {
        public static void bootstrap(BootstapContext<PlacedFeature> context) {
            MysticTreePlacements.bootstrap(context);
            MysticVegetationPlacements.bootstrap(context);
        }
    }

    public static class TreeDecorators {
        public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = DeferredRegister.create(Registries.TREE_DECORATOR_TYPE, MysticsBiomes.modId);

        public static final RegistryObject<TreeDecoratorType<ButterflyNestDecorator>> BUTTERFLY_NEST = TREE_DECORATORS.register("butterfly_nest", () -> new TreeDecoratorType<>(ButterflyNestDecorator.CODEC));
    }

}