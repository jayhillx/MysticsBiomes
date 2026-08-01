package com.mysticsbiomes.common.worldgen.feature.tree;

import com.mojang.serialization.Codec;
import com.mysticsbiomes.common.worldgen.feature.config.MysticTreeConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;

import java.util.*;
import java.util.function.BiConsumer;

public class PeachTreeFeature extends MysticTreeFeature {

    public PeachTreeFeature(Codec<MysticTreeConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean placeTree(WorldGenLevel level, RandomSource random, BlockPos initialPos, BiConsumer<BlockPos, BlockState> trunkSetter, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, MysticTreeConfiguration config) {
        setDirtAt(level, random, initialPos.below(), config, trunkSetter);

        int trunkHeight = config.trunkShape.baseHeight + 2;
        for (int y = 0; y <= trunkHeight; y++) {
            this.placeLog(level, random, initialPos.above(y), config, Direction.Axis.Y, trunkSetter);
        }

        for (Direction direction : Direction.Plane.HORIZONTAL) {
            int branchCount = 2 + random.nextInt(3);
            for (int i = 0; i < branchCount; i++) {
                int branchYHeight = random.nextIntBetweenInclusive(5, trunkHeight - 1);
                BlockPos branchPos = initialPos.above(branchYHeight).relative(direction);

                if (random.nextDouble() < 0.7D && this.canPlaceBranch(level, branchPos, direction, 1)) {
                    this.generateSmallBranch(level, random, branchPos, config, direction, branchSetter, foliageSetter);
                }
            }
        }

        this.placeBlobFoliage(level, random, initialPos.above(trunkHeight), config, foliageSetter, 1);

        List<Direction> directions = new ArrayList<>(Arrays.asList(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST));
        Collections.shuffle(directions, new Random(random.nextLong()));

        Direction direction = directions.get(0);
        int branchLength = 7 + random.nextInt(2);
        this.generateBranch(level, random, initialPos.above(1 + random.nextInt(2)), config, direction, direction, branchSetter, foliageSetter, branchLength, false);
        this.generateBranch(level, random, initialPos.above(1 + random.nextInt(2)), config, direction.getClockWise(), direction, branchSetter, foliageSetter, branchLength, false);
        this.generateBranch(level, random, initialPos.above(1 + random.nextInt(2)), config, direction.getOpposite(), direction.getClockWise().getOpposite(), branchSetter, foliageSetter, branchLength, true);
        return true;
    }

    private void generateBranch(LevelAccessor level, RandomSource random, BlockPos startPos, MysticTreeConfiguration config, Direction branchDirection, Direction diagonalDirection, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, int branchLength, boolean moveDiagonally) {
        BlockPos.MutableBlockPos mutablePos = startPos.mutable();

        if (!moveDiagonally && random.nextBoolean()) {
            mutablePos.move(branchDirection);
            this.placeLog(level, random, mutablePos, config, branchDirection.getAxis(), branchSetter);
        }

        int steps = 0;
        while (steps <= branchLength) {
            int forwardInterval = 1;
            int upwardInterval = 1 + Math.round((float) steps / branchLength * 2);

            for (int i = 0; i < forwardInterval && steps <= branchLength; i++, steps++) {
                mutablePos.move(branchDirection);

                if (moveDiagonally) {
                    this.placeLog(level, random, mutablePos, config, branchDirection.getAxis(), branchSetter);
                    mutablePos.move(diagonalDirection);
                }
                this.placeLog(level, random, mutablePos, config, moveDiagonally ? diagonalDirection.getAxis() : branchDirection.getAxis(), branchSetter);
            }

            for (int i = 0; i < upwardInterval && steps <= branchLength; i++, steps++) {
                mutablePos.move(Direction.UP);

                if (random.nextDouble() < 0.8D) {
                    Direction direction = random.nextBoolean() ? branchDirection.getClockWise() : branchDirection.getCounterClockWise();
                    this.generateSmallBranch(level, random, mutablePos.relative(direction), config, direction, branchSetter, foliageSetter);
                }
                this.placeLog(level, random, mutablePos, config, Direction.Axis.Y, branchSetter);
            }

            if (steps >= branchLength) {
                this.placeLeafShape(level, random, mutablePos, config, branchDirection, foliageSetter);
                BlockPos relativePos = mutablePos.relative(branchDirection.getOpposite()).relative(branchDirection.getClockWise().getOpposite());
                this.placeLeaves(level, random, relativePos, config, foliageSetter);
                this.placeLeaves(level, random, relativePos.above(), config, foliageSetter);
                return;
            }
        }
    }

    private void generateSmallBranch(LevelAccessor level, RandomSource random, BlockPos startPos, MysticTreeConfiguration config, Direction direction, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter) {
        this.placeLog(level, random, startPos, config, direction.getAxis(), branchSetter);
        this.placeLeafShape(level, random, startPos, config, direction, foliageSetter);
        for (int i = 0; i < 1; i++) {
            this.placeLeaves(level, random, startPos.relative(direction.getOpposite()).relative(direction.getOpposite().getClockWise()).above(i), config, foliageSetter);
        }

        BlockPos belowBelowPos = startPos.below(2);
        if (level.isEmptyBlock(belowBelowPos) && level.isEmptyBlock(belowBelowPos.below())) {
            for (Direction directions : Direction.Plane.HORIZONTAL) {
                this.placeLeaves(level, random, belowBelowPos, config, foliageSetter);
                this.placeLeaves(level, random, belowBelowPos.relative(directions), config, foliageSetter);
            }
        }
    }

    private void placeBlobFoliage(LevelAccessor level, RandomSource random, BlockPos pos, MysticTreeConfiguration config, BiConsumer<BlockPos, BlockState> foliageSetter, int foliageRadius) {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            this.placeLeaves(level, random, pos.below().relative(direction), config, foliageSetter);
        }

        BlockPos.MutableBlockPos mutablePos = pos.mutable();
        int[][] topOffset = {{0, 1, 0}, {0, 1, -1}, {-1, 1, -1}, {1, 1, 0}, {1, 1, 1}, {-1, 1, 1}};
        for (int[] offset : topOffset) {
            mutablePos.setWithOffset(pos, offset[0], offset[1], offset[2]);
            this.placeLeaves(level, random, mutablePos, config, foliageSetter);
        }

        for (int x = -foliageRadius; x <= foliageRadius; x++) {
            for (int z = -foliageRadius; z <= foliageRadius; z++) {
                mutablePos.setWithOffset(pos, x, 0, z);
                this.placeLeaves(level, random, mutablePos, config, foliageSetter);
            }
        }
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int x, int y, int z, int radius, boolean doubleTrunk) {
        return false;
    }

}