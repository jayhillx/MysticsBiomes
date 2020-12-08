package com.meepshadow.mysticsbiomes.common.world.trees;

import java.util.Random;
import javax.annotation.Nullable;

import com.meepshadow.mysticsbiomes.core.registry.ModFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class EtherealTree extends Tree {

    @Nullable
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
        return Feature.ACACIA_TREE.withConfiguration(ModFeatures.ETHEREAL_TREE_CONFIG);
    }
}
