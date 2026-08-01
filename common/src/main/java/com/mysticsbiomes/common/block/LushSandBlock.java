package com.mysticsbiomes.common.block;

import com.mysticsbiomes.common.worldgen.feature.MysticVegetationFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SandBlock;
import net.minecraft.world.level.block.state.BlockState;

public class LushSandBlock extends SandBlock implements BonemealableBlock {

    public LushSandBlock(Properties properties) {
        super(14729120, properties);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean valid) {
        return level.getBlockState(pos.above()).isAir();
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        level.registryAccess().registry(Registries.CONFIGURED_FEATURE).flatMap((features) -> {
            return features.getHolder(MysticVegetationFeatures.PATCH_LUSH_SAND);
        }).ifPresent((reference) -> {
            reference.value().place(level, level.getChunkSource().getGenerator(), random, pos.above());
        });
    }

}