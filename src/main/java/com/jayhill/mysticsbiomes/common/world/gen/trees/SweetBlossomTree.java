package com.jayhill.mysticsbiomes.common.world.gen.trees;

import com.jayhill.mysticsbiomes.init.MysticFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Random;

public class SweetBlossomTree extends Tree {

    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random random, boolean largeHive) {
        if (random.nextInt(10) == 0) {
            return MysticFeatures.Configs.BIG_SWEET_TREE_CONFIG;
        } else {
            return MysticFeatures.Configs.SWEET_TREE_CONFIG;
        }
    }

}