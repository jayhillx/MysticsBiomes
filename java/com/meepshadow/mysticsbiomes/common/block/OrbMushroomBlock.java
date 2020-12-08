package com.meepshadow.mysticsbiomes.common.block;

import java.util.Random;

import com.meepshadow.mysticsbiomes.core.registry.ModBlocks;
import com.meepshadow.mysticsbiomes.core.registry.ModFeatures;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.BigMushroomFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.server.ServerWorld;

public class OrbMushroomBlock extends BushBlock implements IGrowable {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D);

    public OrbMushroomBlock(Block.Properties properties) {
        super(properties);
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (rand.nextInt(25) == 0) {
            int i = 5;
            int j = 4;

            for(BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add(-4, -1, -4), pos.add(4, 1, 4))) {
                if (worldIn.getBlockState(blockpos).getBlock() == this) {
                    --i;
                    if (i <= 0) {
                        return;
                    }
                }
            }

            BlockPos blockpos1 = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);

            for(int k = 0; k < 4; ++k) {
                if (worldIn.isAirBlock(blockpos1) && state.isValidPosition(worldIn, blockpos1)) {
                    pos = blockpos1;
                }

                blockpos1 = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);
            }

            if (worldIn.isAirBlock(blockpos1) && state.isValidPosition(worldIn, blockpos1)) {
                worldIn.setBlockState(blockpos1, state, 2);
            }
        }

    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.isOpaqueCube(worldIn, pos);
    }

    public boolean func_226940_a_(ServerWorld p_226940_1_, BlockPos p_226940_2_, BlockState p_226940_3_, Random p_226940_4_) {
        p_226940_1_.removeBlock(p_226940_2_, false);
        ConfiguredFeature<BigMushroomFeatureConfig, ?> configuredfeature;
        if (this == ModBlocks.ORB_MUSHROOM.get()) {
            configuredfeature = Feature.HUGE_RED_MUSHROOM.withConfiguration(ModFeatures.BIG_ORB_MUSHROOM_CONFIG);
        } else {
            if (this != ModBlocks.ORB_MUSHROOM.get()) {
                p_226940_1_.setBlockState(p_226940_2_, p_226940_3_, 3);
                return false;
            }

            configuredfeature = Feature.HUGE_RED_MUSHROOM.withConfiguration(ModFeatures.BIG_ORB_MUSHROOM_CONFIG);
        }

        if (configuredfeature.place(p_226940_1_, p_226940_1_.getChunkProvider().getChunkGenerator(), p_226940_4_, p_226940_2_)) {
            return true;
        } else {
            p_226940_1_.setBlockState(p_226940_2_, p_226940_3_, 3);
            return false;
        }
    }

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return (double)rand.nextFloat() < 0.4D;
    }

    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        this.func_226940_a_(worldIn, pos, state, rand);
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean needsPostProcessing(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return true;
    }
}
