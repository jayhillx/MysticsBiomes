package com.mysticsbiomes.common.world.feature.misc;

import com.mysticsbiomes.common.block.SaguaroCactusBlock;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.BlockColumnFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class SaguaroCactusFeature extends Feature<BlockColumnFeatureConfig> {

    public SaguaroCactusFeature() {
        super(BlockColumnFeatureConfig.CODEC);
    }

    @Override
    public boolean generate(FeatureContext<BlockColumnFeatureConfig> context) {
        StructureWorldAccess level = context.getWorld();
        BlockColumnFeatureConfig configuration = context.getConfig();
        Random random = context.getRandom();

        int layers = configuration.layers().size();
        int[] heights = new int[layers];
        for (int i = 0; i < layers; ++i) {
            heights[i] = configuration.layers().get(i).height().get(random);
        }

        BlockPos.Mutable mutablePos = context.getOrigin().mutableCopy();
        for (int i = 0; i < layers; ++i) {
            int height = heights[i];
            if (height == 0) {
                continue;
            }

            for (int j = 0; j < height; ++j) {
                level.setBlockState(mutablePos, configuration.layers().get(i).state().get(random, mutablePos), 2 | 16);
                mutablePos.move(configuration.direction());
            }

            if (random.nextInt(2) == 0) {
                this.placeFlower(level, mutablePos);
            }

            for (int branchHeight = 0; branchHeight < 3; ++branchHeight) {
                Direction direction = Direction.Type.HORIZONTAL.random(random);
                this.placeBranch(level, mutablePos.move(direction).up().down(height), direction, height, random);
            }
        }
        return true;
    }

    private void placeBranch(StructureWorldAccess level, BlockPos pos, Direction direction, int height, Random random) {
        BlockState baseState = MysticBlocks.SAGUARO_CACTUS.getDefaultState().with(SaguaroCactusBlock.NATURAL, true).with(SaguaroCactusBlock.BRANCH, true).with(SaguaroCactusBlock.ATTACHMENT, SaguaroCactusBlock.BranchShape.BASE_BRANCH_UPWARD).with(SaguaroCactusBlock.FACING, direction.getOpposite());
        level.setBlockState(pos, updateState(level, pos, baseState), 2 | 16);

        BlockPos highestPos = pos.up();
        BlockState branchState = baseState.with(SaguaroCactusBlock.ATTACHMENT, SaguaroCactusBlock.BranchShape.BRANCH);

        int branchHeight = random.nextInt(height > 5 ? 3 : 2);
        for (int i = 1; i < branchHeight; i++) {
            level.setBlockState(highestPos, updateState(level, highestPos, branchState), 2 | 16);
            highestPos = highestPos.up();
        }

        level.setBlockState(highestPos, updateState(level, highestPos, branchState), 2 | 16);

        if (random.nextInt(2) == 0) {
            this.placeFlower(level, highestPos.up());
        }
    }

    private void placeFlower(StructureWorldAccess level, BlockPos pos) {
        level.setBlockState(pos, MysticBlocks.SAGUARO_BLOSSOM.getDefaultState(), 2 | 16);
    }

    private BlockState updateState(StructureWorldAccess level, BlockPos pos, BlockState state) {
        BlockState currentState = level.getBlockState(pos);
        if (currentState.getBlock() instanceof SaguaroCactusBlock) {
            state = state.with(SaguaroCactusBlock.AGE, currentState.get(SaguaroCactusBlock.AGE)).with(SaguaroCactusBlock.NATURAL, true).with(SaguaroCactusBlock.BRANCH, currentState.get(SaguaroCactusBlock.BRANCH));
        }
        return state;
    }

}