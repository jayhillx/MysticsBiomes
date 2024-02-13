package com.mysticsbiomes.common.world.feature;

import com.mysticsbiomes.common.world.feature.decorator.ButterflyNestDecorator;
import com.mysticsbiomes.common.world.feature.foliage.CherryFoliagePlacer;
import com.mysticsbiomes.common.world.feature.trunk.CherryTrunkPlacer;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.FeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BushFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.*;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static com.mysticsbiomes.init.MysticFeatures.Configured.register;

public class MysticTreeFeatures {

    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> STRAWBERRY_TREE = register("strawberry_tree", Feature.TREE, () -> bushyTree(MysticBlocks.STRAWBERRY_LOG.get(), MysticBlocks.STRAWBERRY_BLOSSOMS.get(), 8, 0, 82).build());
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> PINK_CHERRY_TREE = register("pink_cherry_tree", Feature.TREE, () -> cherryTree(MysticBlocks.PINK_CHERRY_BLOSSOMS.get()).build());
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> WHITE_CHERRY_TREE = register("white_cherry_tree", Feature.TREE, () -> cherryTree(MysticBlocks.WHITE_CHERRY_BLOSSOMS.get()).build());
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> PEONY_BUSH = register("peony_bush", Feature.TREE, () -> bush(randomFoliage(MysticBlocks.BUDDING_PEONY_LEAVES.get(), 4, MysticBlocks.PEONY_LEAVES.get(), 4)).build());
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> JACARANDA_TREE = register("jacaranda_tree", Feature.TREE, () -> base(BlockStateProvider.simple(MysticBlocks.JACARANDA_LOG.get()), new BendingTrunkPlacer(4, 2, 0, 2, UniformInt.of(1, 1)), randomFoliage(MysticBlocks.JACARANDA_BLOSSOMS.get(), 3, MysticBlocks.JACARANDA_LEAVES.get(), 2), new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(3), 82)).decorators(List.of(new ButterflyNestDecorator(0.25F))).build());
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> MAPLE_TREE = register("maple_tree", Feature.TREE, () -> bushyTree(MysticBlocks.MAPLE_LOG.get(), MysticBlocks.MAPLE_LEAVES.get(), 9, 3, 74).build());
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> ORANGE_MAPLE_TREE = register("orange_maple_tree", Feature.TREE, () -> bushyTree(MysticBlocks.MAPLE_LOG.get(), MysticBlocks.ORANGE_MAPLE_LEAVES.get(), 9, 3, 74).build());
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> YELLOW_MAPLE_TREE = register("yellow_maple_tree", Feature.TREE, () -> bushyTree(MysticBlocks.WHITE_MAPLE_LOG.get(), MysticBlocks.YELLOW_MAPLE_LEAVES.get(), 9, 3, 74).build());

    private static TreeConfiguration.TreeConfigurationBuilder bushyTree(Block log, Block leaves, int baseHeight, int heightRandomA, int foliageAttempts) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(log), new FancyTrunkPlacer(baseHeight, heightRandomA, 0), BlockStateProvider.simple(leaves), new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(3), foliageAttempts), new TwoLayersFeatureSize(1, 0, 1));
    }

    private static TreeConfiguration.TreeConfigurationBuilder cherryTree(Block leaves) {
        return base(BlockStateProvider.simple(MysticBlocks.CHERRY_LOG.get()), new CherryTrunkPlacer(8, 1, 0, new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder().add(ConstantInt.of(2), 1).add(ConstantInt.of(2), 1).add(ConstantInt.of(3), 1).build()), UniformInt.of(2, 3), UniformInt.of(-4, -3), UniformInt.of(-1, 0)), BlockStateProvider.simple(leaves), new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(6), 0.25F, 0.5F, 0.2F, 0.3F), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder bush(BlockStateProvider leaves) {
        return base(BlockStateProvider.simple(Blocks.OAK_LOG), new StraightTrunkPlacer(1, 0, 0), leaves, new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2));
    }

    private static TreeConfiguration.TreeConfigurationBuilder base(BlockStateProvider log, TrunkPlacer trunkPlacer, BlockStateProvider leaves, FoliagePlacer foliagePlacer) {
        return base(log, trunkPlacer, leaves, foliagePlacer, new TwoLayersFeatureSize(1, 0, 1));
    }

    private static TreeConfiguration.TreeConfigurationBuilder base(BlockStateProvider log, TrunkPlacer trunkPlacer, BlockStateProvider leaves, FoliagePlacer foliagePlacer, FeatureSize size) {
        return new TreeConfiguration.TreeConfigurationBuilder(log, trunkPlacer, leaves, foliagePlacer, size);
    }

    private static BlockStateProvider randomFoliage(Block leaves, int weight, Block leaves2, int weight2) {
        return new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(leaves.defaultBlockState(), weight).add(leaves2.defaultBlockState(), weight2));
    }

}