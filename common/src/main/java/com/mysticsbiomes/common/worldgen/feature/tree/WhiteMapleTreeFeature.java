package com.mysticsbiomes.common.worldgen.feature.tree;

import com.mojang.serialization.Codec;
import com.mysticsbiomes.common.worldgen.feature.config.MysticTreeConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.BiConsumer;

public class WhiteMapleTreeFeature extends MapleTreeFeature {

    public WhiteMapleTreeFeature(Codec<MysticTreeConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean placeTree(WorldGenLevel level, RandomSource random, BlockPos initialPos, BiConsumer<BlockPos, BlockState> trunkSetter, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, MysticTreeConfiguration config) {
        setDirtAt(level, random, initialPos.below(), config, trunkSetter);

        int trunkHeight = config.trunkShape.getTrunkHeight(random) + 2;
        int minBranchY = trunkHeight / 2;
        int maxBranchY = trunkHeight - 3;

        for (int currentY = 0; currentY <= trunkHeight; currentY++) {
            this.placeLog(level, random, initialPos.above(currentY), config, Direction.Axis.Y, trunkSetter);

            /// small branches
            if (currentY < minBranchY && currentY > 2) {
                if (random.nextBoolean()) {
                    Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
                    BlockPos branchPos = initialPos.above(currentY).relative(direction);

                    if (this.canPlaceBranch(level, branchPos, direction, 1)) {
                        this.placeLog(level, random, branchPos, config, direction.getAxis(), branchSetter);
                        this.generateLeafShape(level, random, branchPos, config, direction, foliageSetter);
                    }
                }
            }
        }

        /// top foliage
        this.placeTopFoliage(level, random, initialPos.above(trunkHeight - 3), config, foliageSetter, 1, 5);

        /// branches
        int branchCount = random.nextIntBetweenInclusive(3, 4);
        for (int i = 0; i < branchCount; i++) {
            int branchY = minBranchY + random.nextInt(maxBranchY - minBranchY);
            int branchLength = 1 + random.nextInt(2);

            Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
            BlockPos branchPos = initialPos.above(branchY);
            if (this.canPlaceBranch(level, branchPos.relative(direction), direction, 1)) {
                this.generateBranch(level, random, branchPos, config, direction, trunkSetter, foliageSetter, branchLength);
            }
        }
        return true;
    }

    protected void generateBranch(LevelAccessor level, RandomSource random, BlockPos pos, MysticTreeConfiguration config, Direction direction, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, int branchLength) {
        this.generateLogWithSurroundingLeaves(level, random, pos.relative(direction), config, direction.getAxis(), branchSetter, foliageSetter);

        BlockPos.MutableBlockPos mutablePos = pos.mutable();
        int interval = Math.max(1, branchLength / 3);
        for (int length = 0; length <= branchLength; length++) {
            mutablePos.move(direction);
            this.placeLog(level, random, mutablePos, config, direction.getAxis(), branchSetter);

            if (length % interval == 0 && length != 0 ) {
                mutablePos.move(Direction.UP);
                this.generateLogWithSurroundingLeaves(level, random, mutablePos, config, Direction.Axis.Y, branchSetter, foliageSetter);

                if (length == branchLength) {
                    this.generateLeafShape(level, random, mutablePos, config, direction, foliageSetter);

                    if (random.nextDouble() > 0.33 && level.isEmptyBlock(mutablePos.below(2))) { /// add leaves underneath the blob of leaves.
                        for (Direction directions : Direction.Plane.HORIZONTAL) {
                            this.placeLeaves(level, random, mutablePos.below(2), config, foliageSetter);
                            this.placeLeaves(level, random, mutablePos.relative(directions).below(2), config, foliageSetter);
                            if (random.nextBoolean()) this.placeLeaves(level, random, mutablePos.below(3), config, foliageSetter);
                        }
                    }
                }
            }
        }
    }

    protected void generateLogWithSurroundingLeaves(LevelAccessor level, RandomSource random, BlockPos pos, MysticTreeConfiguration config, Direction.Axis axis, BiConsumer<BlockPos, BlockState> trunkSetter, BiConsumer<BlockPos, BlockState> foliageSetter) {
        this.placeLog(level, random, pos, config, axis, trunkSetter);
        this.placeLeaves(level, random, pos.above(), config, foliageSetter);

        for (Direction directions : Direction.Plane.HORIZONTAL) {
            this.placeLeaves(level, random, pos.relative(directions), config, foliageSetter);
        }
    }

    /// places the main blob of leaves at the end of the branch.
    protected void generateLeafShape(LevelAccessor level, RandomSource random, BlockPos pos, MysticTreeConfiguration config, Direction direction, BiConsumer<BlockPos, BlockState> foliageSetter) {
        for (Direction directions : Direction.Plane.HORIZONTAL) {
            BlockPos relativePos = pos.relative(directions);
            this.placeLeaves(level, random, relativePos, config, foliageSetter);
            this.placeLeaves(level, random, pos.above(), config, foliageSetter);
            this.placeLeaves(level, random, pos.relative(direction).above(), config, foliageSetter);
        }

        boolean flag = random.nextBoolean(); /// determines direction of the leaves being clockwise or counter.
        this.placeLeaves(level, random, pos.relative(flag ? direction.getClockWise() : direction.getCounterClockWise()).above(), config, foliageSetter);
        this.placeLeaves(level, random, pos.relative(direction).relative(flag ? direction.getClockWise() : direction.getCounterClockWise()), config, foliageSetter);
    }

    private void placeTopFoliage(LevelAccessor level, RandomSource random, BlockPos pos, MysticTreeConfiguration config, BiConsumer<BlockPos, BlockState> foliageSetter, int foliageRadius, int foliageHeight) {
        for (int radius = 0; radius <= foliageRadius; radius++) {
            for (int height = 0; height <= foliageHeight; height++) {
                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    BlockPos currentPos = pos.above(height);

                    this.placeLeaves(level, random, currentPos.above(), config, foliageSetter);

                    if (height == 1 || height == foliageHeight) {
                        this.placeLeaves(level, random, currentPos, config, foliageSetter);
                        this.placeLeaves(level, random, currentPos.relative(direction), config, foliageSetter);
                    }

                    if ((height == 2 || height == foliageHeight - 1) && radius <= 2) {
                        this.placeLeaves(level, random, currentPos.relative(direction, radius), config, foliageSetter);
                        if (radius == 1) this.placeLeaves(level, random, currentPos.relative(direction, radius).relative(direction.getClockWise()), config, foliageSetter);
                    }

                    if (height > 2 && height < foliageHeight - 1) {
                        BlockPos relativePos = currentPos.relative(direction, radius);
                        this.placeLeaves(level, random, relativePos, config, foliageSetter);
                        this.placeLeaves(level, random, relativePos.relative(direction.getClockWise()), config, foliageSetter);
                        this.placeLeaves(level, random, relativePos.relative(direction.getCounterClockWise()), config, foliageSetter);

                        this.placeLeaves(level, random, currentPos.relative(direction, radius + 1), config, foliageSetter);
                        if (random.nextBoolean()) {
                            this.placeLeaves(level, random, currentPos.relative(direction, radius + 1).below(), config, foliageSetter);
                        }
                    }
                }
            }
        }
    }

}