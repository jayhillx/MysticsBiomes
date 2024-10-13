package com.mysticsbiomes.common.block;

import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class LavenderFlowerBlock extends PlantBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D);

    public LavenderFlowerBlock(AbstractBlock.Settings properties) {
        super(properties);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        Vec3d vec3 = state.getModelOffset(level, pos);
        return SHAPE.offset(vec3.x, vec3.y, vec3.z);
    }

    //public boolean isRandomlyTicking(BlockState state) {
    //    return true;
    //}

    ///**
    // * Block itself in a biome with a temperature of 1.3 or higher will dry out.
    // * @param random has a 1 in 228 chance of happening when conditions are met.
    // */
    //public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
    //    float temperature = level.getBiome(pos).get().getBaseTemperature();

    //    if (temperature >= 1.0F) {
    //        level.setBlock(pos, MysticBlocks.DRIED_LAVENDER.get().getDefaultState(), 2);
    //        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(state));
    //        level.playSound(null, pos, SoundEvents.BIG_DRIPLEAF_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
    //    }
    //}

}