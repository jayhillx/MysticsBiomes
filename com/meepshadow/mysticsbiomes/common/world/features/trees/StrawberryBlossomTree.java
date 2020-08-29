package com.meepshadow.mysticsbiomes.common.world.features.trees;

import com.meepshadow.mysticsbiomes.init.ModBlock;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;

import java.util.Random;

public class StrawberryBlossomTree extends Tree {

    public static final TreeFeatureConfig STRAWBERRY_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlock.STRAWBERRRY_LOG.get().getDefaultState()), new SimpleBlockStateProvider(ModBlock.STRAWBERRY_BLOSSOMS.get().getDefaultState()), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable)ModBlock.STRAWBERRY_BLOSSOM_SAPLING.get()).build();

    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
        return Feature.NORMAL_TREE.withConfiguration(STRAWBERRY_TREE_CONFIG);
    }
}
