package com.mysticsbiomes.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LavenderFlowerBlock extends BushBlock {
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D);

    public LavenderFlowerBlock(Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(reader, pos);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
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
    //        level.setBlock(pos, MysticBlocks.DRIED_LAVENDER.get().defaultBlockState(), 2);
    //        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(state));
    //        level.playSound(null, pos, SoundEvents.BIG_DRIPLEAF_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
    //    }
    //}

}