package com.meepshadow.mysticsbiomes.core.registry;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class ModFeatures {

    //Trees
    public static final TreeFeatureConfig ETHEREAL_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.ETHEREAL_LOG.get().getDefaultState()), new SimpleBlockStateProvider(ModBlocks.ETHEREAL_LEAVES.get().getDefaultState()), new AcaciaFoliagePlacer(2, 0))).baseHeight(5).heightRandA(2).heightRandB(2).trunkHeight(0).ignoreVines().setSapling((net.minecraftforge.common.IPlantable) ModBlocks.ETHEREAL_SAPLING.get()).build();
    public static final TreeFeatureConfig LAVENDER_BLOSSOM_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.LAVENDER_LOG.get().getDefaultState()), new SimpleBlockStateProvider(ModBlocks.LAVENDER_BLOSSOM_LEAVES.get().getDefaultState()), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((IPlantable) ModBlocks.LAVENDER_BLOSSOM_SAPLING.get()).build();
    public static final TreeFeatureConfig SWEET_BLOSSOM_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.STRAWBERRRY_LOG.get().getDefaultState()), new SimpleBlockStateProvider(ModBlocks.SWEET_BLOSSOM_LEAVES.get().getDefaultState()), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((IPlantable) ModBlocks.SWEET_BLOSSOM_SAPLING.get()).build();
    public static final TreeFeatureConfig STRAWBERRY_BLOSSOM_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.STRAWBERRRY_LOG.get().getDefaultState()), new SimpleBlockStateProvider(ModBlocks.STRAWBERRY_BLOSSOM_LEAVES.get().getDefaultState()), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((IPlantable) ModBlocks.STRAWBERRY_BLOSSOM_SAPLING.get()).build();

    //Big Trees
    public static final TreeFeatureConfig FANCY_LAVENDER_BLOSSOM_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.LAVENDER_LOG.get().getDefaultState()), new SimpleBlockStateProvider(ModBlocks.LAVENDER_BLOSSOM_LEAVES.get().getDefaultState()), new BlobFoliagePlacer(0, 0))).setSapling((IPlantable) ModBlocks.LAVENDER_BLOSSOM_SAPLING.get()).build();
    public static final TreeFeatureConfig FANCY_SWEET_BLOSSOM_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.STRAWBERRRY_LOG.get().getDefaultState()), new SimpleBlockStateProvider(ModBlocks.SWEET_BLOSSOM_LEAVES.get().getDefaultState()), new BlobFoliagePlacer(0, 0))).setSapling((IPlantable) ModBlocks.SWEET_BLOSSOM_SAPLING.get()).build();
    public static final TreeFeatureConfig FANCY_STRAWBERRY_BLOSSOM_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.STRAWBERRRY_LOG.get().getDefaultState()), new SimpleBlockStateProvider(ModBlocks.STRAWBERRY_BLOSSOM_LEAVES.get().getDefaultState()), new BlobFoliagePlacer(0, 0))).setSapling((IPlantable) ModBlocks.STRAWBERRY_BLOSSOM_SAPLING.get()).build();

    //Mushrooms
    public static final BigMushroomFeatureConfig BIG_ORB_MUSHROOM_CONFIG = new BigMushroomFeatureConfig(new SimpleBlockStateProvider(ModBlocks.ORB_MUSHROOM_BLOCK.get().getDefaultState()), new SimpleBlockStateProvider(Blocks.MUSHROOM_STEM.getDefaultState()), 2);

    //Plants
    public static final BlockState STRAWBERRY_BUSH = ModBlocks.STRAWBERRY_BUSH.get().getDefaultState();
    public static final BlockClusterFeatureConfig STRAWBERRY_BUSH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(STRAWBERRY_BUSH), new SimpleBlockPlacer())).tries(32).build();

    //Flowers
    public static final BlockState LAVENDER = ModBlocks.LAVENDER.get().getDefaultState();
    public static final BlockState WHITE_DAISY_BUSH = ModBlocks.WHITE_DAISY_BUSH.get().getDefaultState();
    public static final BlockState PINK_DAISY_BUSH = ModBlocks.PINK_DAISY_BUSH.get().getDefaultState();
    public static final BlockState ORB_MUSHROOM = ModBlocks.ORB_MUSHROOM.get().getDefaultState();
    public static final BlockClusterFeatureConfig LAVENDER_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(LAVENDER), new SimpleBlockPlacer())).tries(16).build();
    public static final BlockClusterFeatureConfig WHITE_DAISY_BUSH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(WHITE_DAISY_BUSH), new SimpleBlockPlacer())).tries(16).build();
    public static final BlockClusterFeatureConfig PINK_DAISY_BUSH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PINK_DAISY_BUSH), new SimpleBlockPlacer())).tries(16).build();
    public static final BlockClusterFeatureConfig ORB_MUSHROOM_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ORB_MUSHROOM), new SimpleBlockPlacer())).tries(4).build();

}
