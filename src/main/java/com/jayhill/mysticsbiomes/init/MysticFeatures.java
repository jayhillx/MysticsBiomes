package com.jayhill.mysticsbiomes.init;

import com.google.common.collect.ImmutableList;
import com.jayhill.mysticsbiomes.MysticsBiomes;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import java.util.OptionalInt;

public class MysticFeatures {

    /** Config Features. */
    public static class Configs {
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> STRAWBERRY_TREE_CONFIG = Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(MysticBlocks.STRAWBERRY_LOG.get().getDefaultState()), new SimpleBlockStateProvider(MysticBlocks.STRAWBERRY_BLOSSOM_LEAVES.get().getDefaultState()), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build());
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> SWEET_TREE_CONFIG = Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(MysticBlocks.STRAWBERRY_LOG.get().getDefaultState()), new SimpleBlockStateProvider(MysticBlocks.SWEET_BLOSSOM_LEAVES.get().getDefaultState()), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build());
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BIG_STRAWBERRY_TREE_CONFIG = Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(MysticBlocks.STRAWBERRY_LOG.get().getDefaultState()), new SimpleBlockStateProvider(MysticBlocks.STRAWBERRY_BLOSSOM_LEAVES.get().getDefaultState()), new FancyFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(4), 4), new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).setIgnoreVines().func_236702_a_(Heightmap.Type.MOTION_BLOCKING).build());
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BIG_SWEET_TREE_CONFIG = Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(MysticBlocks.STRAWBERRY_LOG.get().getDefaultState()), new SimpleBlockStateProvider(MysticBlocks.SWEET_BLOSSOM_LEAVES.get().getDefaultState()), new FancyFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(4), 4), new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).setIgnoreVines().func_236702_a_(Heightmap.Type.MOTION_BLOCKING).build());

        private static final ConfiguredFeature<BaseTreeFeatureConfig, ?> SMALL_OAK_TREES_CONFIG = Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()), new FancyFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(4), 4), new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).setIgnoreVines().func_236702_a_(Heightmap.Type.MOTION_BLOCKING).build());

        private static final ConfiguredFeature<BlockClusterFeatureConfig, ?> GRASS_PATCH_CONFIG = Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.GRASS.getDefaultState()), new SimpleBlockPlacer())).tries(32).build());
        private static final ConfiguredFeature<BlockClusterFeatureConfig, ?> PINK_TULIP_CONFIG = Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider()).addWeightedBlockstate(Blocks.PINK_TULIP.getDefaultState(), 8), SimpleBlockPlacer.PLACER)).tries(64).build());
        private static final ConfiguredFeature<BlockClusterFeatureConfig, ?> WHITE_TULIP_CONFIG = Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider()).addWeightedBlockstate(Blocks.WHITE_TULIP.getDefaultState(), 8), SimpleBlockPlacer.PLACER)).tries(64).build());

        private static final ConfiguredFeature<BlockClusterFeatureConfig, ?> STRAWBERRY_BUSH_CONFIG = Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(MysticBlocks.STRAWBERRY_BUSH.get().getDefaultState()), new SimpleBlockPlacer())).tries(72).build());
    }

     /** These are used in biome generation. */
    public static final ConfiguredFeature<?, ?> STRAWBERRY_BLOSSOM_TREES = Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Configs.BIG_STRAWBERRY_TREE_CONFIG.withChance(0.1F)), Feature.TREE.withConfiguration(Configs.STRAWBERRY_TREE_CONFIG.config))).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.4F, 1)));
    public static final ConfiguredFeature<?, ?> SWEET_BLOSSOM_TREES = Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Configs.BIG_SWEET_TREE_CONFIG.withChance(0.1F)), Feature.TREE.withConfiguration(Configs.SWEET_TREE_CONFIG.config))).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.4F, 1)));

    public static final ConfiguredFeature<?, ?> SMALL_OAK_TREES = Feature.TREE.withConfiguration(Configs.SMALL_OAK_TREES_CONFIG.getConfig()).withPlacement(Features.Placements.PATCH_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.3F, 1)));

    public static final ConfiguredFeature<?, ?> GRASS = Feature.RANDOM_PATCH.withConfiguration(Configs.GRASS_PATCH_CONFIG.getConfig()).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(32);
    public static final ConfiguredFeature<?, ?> PINK_TULIPS = Feature.FLOWER.withConfiguration(Configs.PINK_TULIP_CONFIG.getConfig()).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(6);
    public static final ConfiguredFeature<?, ?> WHITE_TULIPS = Feature.FLOWER.withConfiguration(Configs.WHITE_TULIP_CONFIG.getConfig()).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(6);

    public static final ConfiguredFeature<?, ?> STRAWBERRY_BUSHES = Feature.FLOWER.withConfiguration(Configs.STRAWBERRY_BUSH_CONFIG.getConfig()).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(64);

    /** Register Biome Features. */
    public static void registerFeatures() {
        register("strawberry_blossom_trees", STRAWBERRY_BLOSSOM_TREES);
        register("sweet_blossom_trees", SWEET_BLOSSOM_TREES);
        register("small_oak_trees", SMALL_OAK_TREES);
        register("grass", GRASS);
        register("pink_tulips", PINK_TULIPS);
        register("white_tulips", WHITE_TULIPS);
        register("strawberry_bushes", STRAWBERRY_BUSHES);
    }

    private static <FC extends IFeatureConfig> void register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(MysticsBiomes.MOD_ID, name), configuredFeature);
    }

}