package com.mysticsbiomes.common.worldgen.feature;

import com.mysticsbiomes.common.worldgen.feature.config.MysticTreeConfiguration;
import com.mysticsbiomes.common.worldgen.feature.decorator.ButterflyNestDecorator;
import com.mysticsbiomes.common.worldgen.feature.decorator.FallenLeavesDecorator;
import com.mysticsbiomes.common.worldgen.feature.decorator.FruitDecorator;
import com.mysticsbiomes.common.worldgen.feature.decorator.VanillaOrchidDecorator;
import com.mysticsbiomes.common.worldgen.feature.tree.provider.TrunkShapeProvider;
import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.CocoaDecorator;

import java.util.List;

import static com.mysticsbiomes.init.MysticFeatures.Configured.createKey;

public class MysticTreeFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> STRAWBERRY_TREE = createKey("strawberry_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_CHERRY_TREE = createKey("pink_cherry_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_CHERRY_TREE = createKey("white_cherry_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PEONY_BUSH = createKey("peony_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LAVENDER_TREE = createKey("lavender_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PEACH_TREE = createKey("peach_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DESERT_SHRUB = createKey("desert_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_TREE = createKey("maple_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_MAPLE_TREE = createKey("orange_maple_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_MAPLE_TREE = createKey("yellow_maple_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SEA_SHRUB = createKey("sea_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TROPICAL_TREE = createKey("tropical_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_TROPICAL_TREE = createKey("large_tropical_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VANILLA_TREE = createKey("vanilla_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HYDRANGEA_BUSH = createKey("hydrangea_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> JUNGLE_SHRUB = createKey("jungle_shrub");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context,
                STRAWBERRY_TREE,
                MysticFeatures.BUSHY_TREE.get(),
                new MysticTreeConfiguration.Builder(
                        provider(MysticBlocks.STRAWBERRY_LOG.get()),
                        new TrunkShapeProvider(7, 2),
                        provider(MysticBlocks.STRAWBERRY_BLOSSOMS.get())
                ).build()
        );
        FeatureUtils.register(context,
                PINK_CHERRY_TREE,
                MysticFeatures.BLACK_CHERRY_TREE.get(),
                new MysticTreeConfiguration.Builder(
                        provider(MysticBlocks.BLACK_CHERRY_LOG.get()),
                        new TrunkShapeProvider(10, 3),
                        provider(MysticBlocks.PINK_CHERRY_BLOSSOMS.get()),
                        new TwoLayersFeatureSize(2, 0, 2)
                ).build()
        );
        FeatureUtils.register(context,
                WHITE_CHERRY_TREE,
                MysticFeatures.BLACK_CHERRY_TREE.get(),
                new MysticTreeConfiguration.Builder(
                        provider(MysticBlocks.BLACK_CHERRY_LOG.get()),
                        new TrunkShapeProvider(10, 3),
                        provider(MysticBlocks.WHITE_CHERRY_BLOSSOMS.get()),
                        new TwoLayersFeatureSize(2, 0, 2)
                ).build()
        );
        FeatureUtils.register(context,
                PEONY_BUSH,
                MysticFeatures.BUSH.get(),
                new MysticTreeConfiguration.Builder(
                        BlockStateProvider.simple(Blocks.OAK_LOG),
                        new TrunkShapeProvider(1),
                        BlockStateProvider.simple(MysticBlocks.PEONY_BUSH_LEAVES.get())
                ).build()
        );
        FeatureUtils.register(context,
                LAVENDER_TREE,
                MysticFeatures.BUSHY_TREE.get(),
                new MysticTreeConfiguration.Builder(
                        provider(MysticBlocks.LAVENDER_LOG.get()),
                        new TrunkShapeProvider(7, 2),
                        provider(MysticBlocks.LAVENDER_BLOSSOMS.get())
                ).decorators(List.of(
                        new ButterflyNestDecorator(0.5D)
                )).build()
        );
        FeatureUtils.register(context,
                PEACH_TREE,
                MysticFeatures.PEACH_TREE.get(),
                new MysticTreeConfiguration.Builder(
                        provider(MysticBlocks.PEACH_LOG.get()),
                        new TrunkShapeProvider(6, 4),
                        provider(MysticBlocks.PEACH_LEAVES.get())
                ).decorators(List.of(
                        new FruitDecorator(provider(MysticBlocks.PEACH_PLANT.get()), 0.75D)
                )).build()
        );
        FeatureUtils.register(context,
                DESERT_SHRUB,
                MysticFeatures.BUSH.get(),
                new MysticTreeConfiguration.Builder(
                        BlockStateProvider.simple(Blocks.OAK_LOG),
                        new TrunkShapeProvider(1),
                        BlockStateProvider.simple(Blocks.ACACIA_LEAVES)
                ).build()
        );
        FeatureUtils.register(context,
                MAPLE_TREE,
                MysticFeatures.MAPLE_TREE.get(),
                new MysticTreeConfiguration.Builder(
                        provider(MysticBlocks.MAPLE_LOG.get()),
                        new TrunkShapeProvider(7, 4),
                        provider(MysticBlocks.MAPLE_LEAVES.get())
                ).decorators(List.of(
                        new FallenLeavesDecorator(provider(MysticBlocks.MAPLE_LEAF_PILE.get()), provider(MysticBlocks.MAPLE_LEAF_LITTER.get()), 0.7D)
                )).build()
        );
        FeatureUtils.register(context,
                ORANGE_MAPLE_TREE,
                MysticFeatures.MAPLE_TREE.get(),
                new MysticTreeConfiguration.Builder(
                        provider(MysticBlocks.MAPLE_LOG.get()),
                        new TrunkShapeProvider(7, 4),
                        provider(MysticBlocks.ORANGE_MAPLE_LEAVES.get())
                ).decorators(List.of(
                        new FallenLeavesDecorator(provider(MysticBlocks.ORANGE_MAPLE_LEAF_PILE.get()), provider(MysticBlocks.ORANGE_MAPLE_LEAF_LITTER.get()), 0.7D)
                )).build()
        );
        FeatureUtils.register(context,
                YELLOW_MAPLE_TREE,
                MysticFeatures.WHITE_MAPLE_TREE.get(),
                new MysticTreeConfiguration.Builder(
                        provider(MysticBlocks.WHITE_MAPLE_LOG.get()),
                        new TrunkShapeProvider(6, 3),
                        provider(MysticBlocks.YELLOW_MAPLE_LEAVES.get())
                ).decorators(List.of(
                        new FallenLeavesDecorator(provider(MysticBlocks.YELLOW_MAPLE_LEAF_PILE.get()), provider(MysticBlocks.YELLOW_MAPLE_LEAF_LITTER.get()), 0.7D)
                )).build()
        );
        FeatureUtils.register(context,
                SEA_SHRUB,
                MysticFeatures.SHRUB.get(),
                new MysticTreeConfiguration.Builder(
                        BlockStateProvider.simple(MysticBlocks.SEA_FOAM_LOG.get()),
                        new TrunkShapeProvider(1, 1),
                        BlockStateProvider.simple(MysticBlocks.SEA_SHRUB_LEAVES.get())
                ).build()
        );
        FeatureUtils.register(context,
                TROPICAL_TREE,
                MysticFeatures.TROPICAL_TREE.get(),
                new MysticTreeConfiguration.Builder(
                        BlockStateProvider.simple(MysticBlocks.TROPICAL_LOG.get()),
                        new TrunkShapeProvider(10, 4),
                        BlockStateProvider.simple(MysticBlocks.TROPICAL_LEAVES.get()),
                        new TwoLayersFeatureSize(1, 0, 2)
                ).decorators(List.of(
                        new CocoaDecorator(0.2F)
                )).build()
        );
        FeatureUtils.register(context,
                LARGE_TROPICAL_TREE,
                MysticFeatures.TROPICAL_TREE.get(),
                new MysticTreeConfiguration.Builder(
                        BlockStateProvider.simple(MysticBlocks.TROPICAL_LOG.get()),
                        new TrunkShapeProvider(15, 5, true),
                        BlockStateProvider.simple(MysticBlocks.TROPICAL_LEAVES.get()),
                        new TwoLayersFeatureSize(1, 1, 2)
                ).decorators(List.of(
                        new CocoaDecorator(0.2F)
                )).build()
        );
        FeatureUtils.register(context,
                VANILLA_TREE,
                MysticFeatures.BUSHY_TREE.get(),
                new MysticTreeConfiguration.Builder(
                        BlockStateProvider.simple(MysticBlocks.VANILLA_LOG.get()),
                        new TrunkShapeProvider(7, 3),
                        BlockStateProvider.simple(MysticBlocks.VANILLA_LEAVES.get())
                ).decorators(List.of(
                        new VanillaOrchidDecorator(0.75D)
                )).build()
        );
        FeatureUtils.register(context,
                HYDRANGEA_BUSH,
                MysticFeatures.BUSH.get(),
                new MysticTreeConfiguration.Builder(
                        BlockStateProvider.simple(Blocks.OAK_LOG),
                        new TrunkShapeProvider(1),
                        BlockStateProvider.simple(MysticBlocks.HYDRANGEA_BUSH_LEAVES.get())
                ).build()
        );
        FeatureUtils.register(context,
                JUNGLE_SHRUB,
                MysticFeatures.SHRUB.get(),
                new MysticTreeConfiguration.Builder(
                        BlockStateProvider.simple(Blocks.JUNGLE_WOOD),
                        new TrunkShapeProvider(1),
                        BlockStateProvider.simple(Blocks.JUNGLE_LEAVES)
                ).build()
        );
    }

    private static BlockStateProvider provider(Block block) {
        return BlockStateProvider.simple(block);
    }

    /// 2860080712079986177
}