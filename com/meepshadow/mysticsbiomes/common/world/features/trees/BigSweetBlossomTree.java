package com.meepshadow.mysticsbiomes.common.world.features.trees;

import com.meepshadow.mysticsbiomes.init.ModBlock;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;

import java.util.Random;

public class BigSweetBlossomTree extends Tree {

    public static final TreeFeatureConfig BIG_SWEET_BLOSSOM_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlock.SWEET_LOG.get().getDefaultState()), new SimpleBlockStateProvider(ModBlock.SWEET_BLOSSOMS.get().getDefaultState()), new BlobFoliagePlacer(0, 0))).setSapling((net.minecraftforge.common.IPlantable) ModBlock.SWEET_BLOSSOM_SAPLING.get()).build();

    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
        return Feature.FANCY_TREE.withConfiguration(BIG_SWEET_BLOSSOM_TREE_CONFIG);
    }
}
