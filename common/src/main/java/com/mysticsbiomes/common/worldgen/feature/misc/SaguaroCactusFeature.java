package com.mysticsbiomes.common.worldgen.feature.misc;

import com.mysticsbiomes.common.block.SaguaroCactusBlock;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class SaguaroCactusFeature extends Feature<NoneFeatureConfiguration> {

    public SaguaroCactusFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        BlockPos initialPos = context.origin();
        BlockPos.MutableBlockPos mutablePos = initialPos.mutable();

        if (level.isEmptyBlock(initialPos) && level.getBlockState(initialPos.below()).is(BlockTags.SAND)) {
            int height = UniformInt.of(4, 5).sample(random);
            for (int i = 0; i <= height; i++) {
                ///level.setBlock(mutablePos, MysticBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SaguaroCactusBlock.TOP, i == height), 2 | 1);
                mutablePos.move(Direction.UP);
            }

            if (random.nextInt(2) == 0) {
                this.placeFlower(level, mutablePos);
            }

            int branchCount = UniformInt.of(1, 3).sample(random);
            for (int i = 0; i < branchCount; i++) {
                Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
                BlockPos branchPos = initialPos.above().relative(direction);
                if (level.getBlockState(branchPos).isAir()) {
                    this.placeBranch(level, random, branchPos, direction, height);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private void placeBranch(WorldGenLevel level, RandomSource random, BlockPos pos, Direction direction, int height) {
        BlockPos.MutableBlockPos mutablePos = pos.mutable();
        int branchHeight = height < 4 ? 2 : UniformInt.of(1, 2).sample(random);

        /// chance to move up one if the base height is higher than 4 blocks tall, and the branch height is 2 blocks.
        if (height > 4 && branchHeight == 2 && random.nextInt(4) == 0) {
            mutablePos.move(Direction.UP);
        }

        for (int i = 0; i <= branchHeight; i++) {
            ///level.setBlock(mutablePos, MysticBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SaguaroCactusBlock.SHAPE, i == 0 ? SaguaroCactusBlock.Shape.CURVED_BRANCH : SaguaroCactusBlock.Shape.BRANCH).setValue(SaguaroCactusBlock.FACING, direction).setValue(SaguaroCactusBlock.BRANCH, true).setValue(SaguaroCactusBlock.NATURAL, true).setValue(SaguaroCactusBlock.TOP, i == branchHeight), 2 | 1);
            mutablePos.move(Direction.UP);
        }

        if (random.nextInt(2) == 0) {
            this.placeFlower(level, mutablePos);
        }
    }

    private void placeFlower(WorldGenLevel level, BlockPos pos) {
        level.setBlock(pos, MysticBlocks.SAGUARO_BLOSSOM.get().defaultBlockState(), 3);
    }

}