package com.meepshadow.mysticsbiomes.common.world.features;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;

public class VanillaFlowers {

    private static final BlockState GRASS = Blocks.GRASS.getDefaultState();
    private static final BlockState DANDELION = Blocks.DANDELION.getDefaultState();
    private static final BlockState PINK_TULIP = Blocks.PINK_TULIP.getDefaultState();
    private static final BlockState OXEYE_DAISY = Blocks.OXEYE_DAISY.getDefaultState();
    private static final BlockState LILAC = Blocks.LILAC.getDefaultState();

    public static final BlockClusterFeatureConfig GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(GRASS), new SimpleBlockPlacer())).tries(16).build();
    public static final BlockClusterFeatureConfig DANDELION_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(DANDELION), new SimpleBlockPlacer())).tries(16).build();
    public static final BlockClusterFeatureConfig PINK_TULIP_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PINK_TULIP), new SimpleBlockPlacer())).tries(16).build();
    public static final BlockClusterFeatureConfig OXEYE_DAISY_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(OXEYE_DAISY), new SimpleBlockPlacer())).tries(8).build();
    public static final BlockClusterFeatureConfig LILAC_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(LILAC), new SimpleBlockPlacer())).tries(8).build();

}
