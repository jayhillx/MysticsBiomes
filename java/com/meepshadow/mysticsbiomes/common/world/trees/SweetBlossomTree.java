package com.meepshadow.mysticsbiomes.common.world.trees;

import com.meepshadow.mysticsbiomes.core.registry.ModFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class SweetBlossomTree extends Tree {

    @Nullable
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
        return randomIn.nextInt(10) == 0 ? Feature.FANCY_TREE.withConfiguration(p_225546_2_ ? ModFeatures.FANCY_SWEET_BLOSSOM_TREE_CONFIG : ModFeatures.FANCY_SWEET_BLOSSOM_TREE_CONFIG) : Feature.NORMAL_TREE.withConfiguration(p_225546_2_ ? ModFeatures.SWEET_BLOSSOM_TREE_CONFIG : ModFeatures.SWEET_BLOSSOM_TREE_CONFIG);
    }
}
