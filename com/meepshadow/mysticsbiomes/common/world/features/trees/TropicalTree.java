package com.meepshadow.mysticsbiomes.common.world.features.trees;

import com.meepshadow.mysticsbiomes.init.ModBlock;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class TropicalTree extends Tree {

    public static final TreeFeatureConfig TROPICAL_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlock.TROPICAL_LOG.get().getDefaultState()), new SimpleBlockStateProvider(ModBlock.TROPICAL_LEAVES.get().getDefaultState()), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((IPlantable) ModBlock.TROPICAL_SAPLING.get()).build();

    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
        return Feature.NORMAL_TREE.withConfiguration(TROPICAL_TREE_CONFIG);
    }
}
