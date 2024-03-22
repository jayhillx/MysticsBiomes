package com.mysticsbiomes.common.world.feature.misc;

import com.mysticsbiomes.common.block.PricklyPearBlock;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;

public class PricklyPearFeature extends Feature<BlockColumnConfiguration> {

    public PricklyPearFeature() {
        super(BlockColumnConfiguration.CODEC);
    }

    public boolean place(FeaturePlaceContext<BlockColumnConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockColumnConfiguration configuration = context.config();
        RandomSource random = context.random();
        int layers = configuration.layers().size();
        int[] heights = new int[layers];

        for (int k = 0; k < layers; ++k) {
            heights[k] = configuration.layers().get(k).height().sample(random);
        }

        BlockPos.MutableBlockPos mutablePos = context.origin().mutable();
        Direction facingDirection = Direction.Plane.HORIZONTAL.getRandomDirection(random);
        BlockPos pricklyPos = mutablePos.immutable().relative(facingDirection).above();

        for (int k = 0; k < layers; ++k) {
            int height = heights[k];
            if (height == 0) {
                continue;
            }
            for (int j = 0; j < height; ++j) {
                level.setBlock(mutablePos, configuration.layers().get(k).state().getState(random, mutablePos), 2);
                mutablePos.move(configuration.direction());
            }
        }

        level.setBlock(pricklyPos, MysticBlocks.PRICKLY_PEAR.get().defaultBlockState().setValue(PricklyPearBlock.ATTACHMENT, PricklyPearBlock.BranchShape.BRANCH_BASE_UPWARD).setValue(PricklyPearBlock.FACING, facingDirection.getOpposite()), 2);

        int numBranches = random.nextInt(2);
        for (int i = 0; i < numBranches; i++) {
            BlockPos branchPos = pricklyPos.above().above(i);
            level.setBlock(branchPos, MysticBlocks.PRICKLY_PEAR.get().defaultBlockState().setValue(PricklyPearBlock.ATTACHMENT, PricklyPearBlock.BranchShape.BRANCH_ARM).setValue(PricklyPearBlock.FACING, facingDirection.getOpposite()), 2);
            if (i == numBranches - 1) {
                level.setBlock(branchPos.above(), MysticBlocks.PRICKLY_PEAR.get().defaultBlockState().setValue(PricklyPearBlock.ATTACHMENT, PricklyPearBlock.BranchShape.TOP_ARM).setValue(PricklyPearBlock.FACING, facingDirection.getOpposite()), 2);
            }
        }
        return true;
    }

}