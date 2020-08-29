package com.meepshadow.mysticsbiomes.common.world.features;

import com.meepshadow.mysticsbiomes.init.ModBlock;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;

public class LavenderFlowers {

    private static final BlockState LAVENDER = ModBlock.LAVENDER.get().getDefaultState();

    public static final BlockClusterFeatureConfig LAVENDER_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(LAVENDER), new SimpleBlockPlacer())).tries(16).build();

}
