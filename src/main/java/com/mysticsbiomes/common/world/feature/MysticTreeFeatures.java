package com.mysticsbiomes.common.world.feature;

import com.mysticsbiomes.common.world.feature.decorator.ButterflyNestDecorator;
import com.mysticsbiomes.common.world.feature.decorator.PeachFruitDecorator;
import com.mysticsbiomes.common.world.feature.decorator.VanillaOrchidDecorator;
import com.mysticsbiomes.common.world.feature.trunk.CherryTrunkPlacer;
import com.mysticsbiomes.common.world.feature.trunk.ShrubTrunkPlacer;
import com.mysticsbiomes.common.world.feature.trunk.TropicalTrunkPlacer;
import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticFeatures;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.state.property.Properties;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.intprovider.WeightedListIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.FeatureSize;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import java.util.List;

import static com.mysticsbiomes.init.MysticFeatures.Configured.*;

public class MysticTreeFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> STRAWBERRY_TREE = createKey("strawberry_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PINK_CHERRY_TREE = createKey("pink_cherry_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WHITE_CHERRY_TREE = createKey("white_cherry_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PEONY_BUSH = createKey("peony_bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PEACH_TREE = createKey("peach_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DESERT_SHRUB = createKey("desert_shrub");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MAPLE_TREE = createKey("maple_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_MAPLE_TREE = createKey("orange_maple_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> YELLOW_MAPLE_TREE = createKey("yellow_maple_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SEA_SHRUB = createKey("sea_shrub");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TROPICAL_TREE = createKey("tropical_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HYDRANGEA_BUSH = createKey("hydrangea_bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> JUNGLE_SHRUB = createKey("jungle_shrub");
    public static final RegistryKey<ConfiguredFeature<?, ?>> JACARANDA_TREE = createKey("jacaranda_tree");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, STRAWBERRY_TREE, Feature.TREE, bushyTree(MysticBlocks.STRAWBERRY_LOG, MysticBlocks.STRAWBERRY_BLOSSOMS, 9, 0, 164).build());
        register(context, PINK_CHERRY_TREE, Feature.TREE, cherryTree(MysticBlocks.PINK_CHERRY_BLOSSOMS).build());
        register(context, WHITE_CHERRY_TREE, Feature.TREE, cherryTree(MysticBlocks.WHITE_CHERRY_BLOSSOMS).build());
        register(context, PEONY_BUSH, Feature.TREE, bush(BlockStateProvider.of(Blocks.OAK_LOG), randomFoliage(MysticBlocks.BUDDING_PEONY_LEAVES, 4, MysticBlocks.PEONY_LEAVES, 4)).build());
        register(context, PEACH_TREE, Feature.TREE, bushyTree(MysticBlocks.PEACH_LOG, MysticBlocks.PEACH_LEAVES, 8, 0, 164).decorators(List.of(new PeachFruitDecorator(() -> MysticBlocks.PEACH_PLANT, 0.5F))).build());
        register(context, DESERT_SHRUB, Feature.TREE, shrub(BlockStateProvider.of(Blocks.ACACIA_LOG), BlockStateProvider.of(Blocks.ACACIA_LEAVES)).build());
        register(context, MAPLE_TREE, MysticFeatures.MAPLE_TREE, bushyTree(MysticBlocks.MAPLE_LOG, MysticBlocks.MAPLE_LEAVES, 10, 3, 164).build());
        register(context, ORANGE_MAPLE_TREE, MysticFeatures.MAPLE_TREE, bushyTree(MysticBlocks.MAPLE_LOG, MysticBlocks.ORANGE_MAPLE_LEAVES, 10, 3, 164).build());
        register(context, YELLOW_MAPLE_TREE, MysticFeatures.MAPLE_TREE, bushyTree(MysticBlocks.WHITE_MAPLE_LOG, MysticBlocks.YELLOW_MAPLE_LEAVES, 10, 3, 164).build());
        register(context, SEA_SHRUB, Feature.TREE, shrub(BlockStateProvider.of(MysticBlocks.SEA_FOAM_LOG), BlockStateProvider.of(MysticBlocks.SEA_SHRUB_LEAVES)).build());
        register(context, TROPICAL_TREE, Feature.TREE, new TreeFeatureConfig.Builder(BlockStateProvider.of(MysticBlocks.TROPICAL_LOG), new TropicalTrunkPlacer(6, 7, 0), BlockStateProvider.of(MysticBlocks.TROPICAL_LEAVES), new RandomSpreadFoliagePlacer(UniformIntProvider.create(3, 4), ConstantIntProvider.create(0), ConstantIntProvider.create(3), 200), new TwoLayersFeatureSize(1, 0, 1)).decorators(List.of(new VanillaOrchidDecorator(0.5F))).build());
        register(context, HYDRANGEA_BUSH, Feature.TREE, bush(BlockStateProvider.of(Blocks.OAK_LOG), BlockStateProvider.of(MysticBlocks.HYDRANGEA_LEAVES)).build());
        register(context, JUNGLE_SHRUB, Feature.TREE, shrub(BlockStateProvider.of(Blocks.JUNGLE_LOG), BlockStateProvider.of(Blocks.JUNGLE_LEAVES)).build());
        register(context, JACARANDA_TREE, Feature.TREE, base(BlockStateProvider.of(MysticBlocks.JACARANDA_LOG), new BendingTrunkPlacer(4, 2, 0, 2, UniformIntProvider.create(1, 1)), randomFoliage(MysticBlocks.JACARANDA_BLOSSOMS, 3, MysticBlocks.JACARANDA_LEAVES, 2), new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), ConstantIntProvider.create(3), 82)).decorators(List.of(new ButterflyNestDecorator(0.25F))).build());
    }

    private static TreeFeatureConfig.Builder bushyTree(Block log, Block leaves, int baseHeight, int heightRandomA, int foliageAttempts) {
        return new TreeFeatureConfig.Builder(BlockStateProvider.of(log), new LargeOakTrunkPlacer(baseHeight, heightRandomA, 0), BlockStateProvider.of(leaves.getDefaultState().with(Properties.PERSISTENT, true)), new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), ConstantIntProvider.create(3), foliageAttempts), new TwoLayersFeatureSize(1, 0, 1));
    }

    private static TreeFeatureConfig.Builder cherryTree(Block leaves) {
        return base(BlockStateProvider.of(MysticBlocks.CHERRY_LOG), new CherryTrunkPlacer(7, 3, 0, new WeightedListIntProvider(DataPool.<IntProvider>builder().add(ConstantIntProvider.create(2), 1).add(ConstantIntProvider.create(2), 1).add(ConstantIntProvider.create(3), 1).build()), UniformIntProvider.create(2, 3), UniformIntProvider.create(-4, -3), UniformIntProvider.create(-1, 0)), BlockStateProvider.of(leaves.getDefaultState().with(Properties.PERSISTENT, true)), new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), ConstantIntProvider.create(3), 164), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines();
    }

    private static TreeFeatureConfig.Builder bush(BlockStateProvider log, BlockStateProvider leaves) {
        return base(log, new StraightTrunkPlacer(1, 0, 0), leaves, new BushFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2));
    }

    private static TreeFeatureConfig.Builder shrub(BlockStateProvider log, BlockStateProvider leaves) {
        return base(log, new ShrubTrunkPlacer(1, 0, 0), leaves, new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), ConstantIntProvider.create(2), 112));
    }

    private static TreeFeatureConfig.Builder base(BlockStateProvider log, TrunkPlacer trunkPlacer, BlockStateProvider leaves, FoliagePlacer foliagePlacer) {
        return base(log, trunkPlacer, leaves, foliagePlacer, new TwoLayersFeatureSize(1, 0, 1));
    }

    private static TreeFeatureConfig.Builder base(BlockStateProvider log, TrunkPlacer trunkPlacer, BlockStateProvider leaves, FoliagePlacer foliagePlacer, FeatureSize size) {
        return new TreeFeatureConfig.Builder(log, trunkPlacer, leaves, foliagePlacer, size);
    }

    private static BlockStateProvider randomFoliage(Block leaves, int weight, Block leaves2, int weight2) {
        return new WeightedBlockStateProvider(DataPool.<BlockState>builder().add(leaves.getDefaultState().with(Properties.PERSISTENT, true), weight).add(leaves2.getDefaultState().with(Properties.PERSISTENT, true), weight2));
    }

}