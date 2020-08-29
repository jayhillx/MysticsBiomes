package com.meepshadow.mysticsbiomes.common.world.features;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;

public class VanillaFeatures {

    public static final BlockState OAK_LOG = Blocks.OAK_LOG.getDefaultState();
    public static final BlockState OAK_LEAVES = Blocks.OAK_LEAVES.getDefaultState();
    public static final BlockState BIRCH_LOG = Blocks.BIRCH_LOG.getDefaultState();
    public static final BlockState BIRCH_LEAVES = Blocks.BIRCH_LEAVES.getDefaultState();

    public static final TreeFeatureConfig OAK_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable)Blocks.OAK_SAPLING).build();
    public static final TreeFeatureConfig FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(0, 0))).decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).setSapling((net.minecraftforge.common.IPlantable)Blocks.OAK_SAPLING).build();
    public static final TreeFeatureConfig BIRCH_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BIRCH_LOG), new SimpleBlockStateProvider(BIRCH_LEAVES), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable)Blocks.BIRCH_SAPLING).build();
    public static final TreeFeatureConfig FANCY_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(0, 0))).setSapling((net.minecraftforge.common.IPlantable)Blocks.OAK_SAPLING).build();
}
