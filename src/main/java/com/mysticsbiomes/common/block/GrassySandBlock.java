package com.mysticsbiomes.common.block;

import com.mysticsbiomes.common.world.feature.MysticVegetationFeatures;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.SandBlock;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class GrassySandBlock extends SandBlock implements Fertilizable {

    public GrassySandBlock(AbstractBlock.Settings properties) {
        super(14729120, properties);
    }

    @Override
    public boolean isFertilizable(WorldView level, BlockPos pos, BlockState state, boolean valid) {
        return level.getBlockState(pos.up()).isAir();
    }

    @Override
    public boolean canGrow(World level, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld level, Random random, BlockPos pos, BlockState state) {
        level.getRegistryManager().getOptional(RegistryKeys.CONFIGURED_FEATURE).flatMap(registry -> registry.getEntry(MysticVegetationFeatures.PATCH_GRASSY_LUSH_SAND)).ifPresent(reference -> reference.value().generate(level, level.getChunkManager().getChunkGenerator(), random, pos.up()));
    }

}