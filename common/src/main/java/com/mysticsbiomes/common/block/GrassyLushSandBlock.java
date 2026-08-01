package com.mysticsbiomes.common.block;

import com.mysticsbiomes.common.worldgen.feature.MysticVegetationFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;

public class GrassyLushSandBlock extends LushSandBlock {

    public GrassyLushSandBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        level.registryAccess().registry(Registries.CONFIGURED_FEATURE).flatMap((features) -> {
            return features.getHolder(MysticVegetationFeatures.PATCH_GRASSY_LUSH_SAND);
        }).ifPresent((reference) -> {
            reference.value().place(level, level.getChunkSource().getGenerator(), random, pos.above());
        });
    }

}