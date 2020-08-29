package com.meepshadow.mysticsbiomes.common.world.features;

import com.meepshadow.mysticsbiomes.init.ModBlock;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;

public class StrawberryBushes {

    private static final BlockState STRAWBERRY_BUSH = ModBlock.STRAWBERRY_BUSH.get().getDefaultState();
    private static final BlockState SWEET_STRAWBERRY_BUSH = ModBlock.SWEET_STRAWBERRY_BUSH.get().getDefaultState();

    public static final BlockClusterFeatureConfig STRAWBERRY_BUSH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(STRAWBERRY_BUSH), new SimpleBlockPlacer())).tries(16).build();
    public static final BlockClusterFeatureConfig SWEET_STRAWBERRY_BUSH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(SWEET_STRAWBERRY_BUSH), new SimpleBlockPlacer())).tries(16).build();


}
