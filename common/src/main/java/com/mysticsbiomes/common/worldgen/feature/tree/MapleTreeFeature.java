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

public class MapleTreeFeature extends MysticTreeFeature {

    public MapleTreeFeature(Codec<MysticTreeConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean placeTree(WorldGenLevel level, RandomSource random, BlockPos initialPos, BiConsumer<BlockPos, BlockState> trunkSetter, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, MysticTreeConfiguration config) {
        setDirtAt(level, random, initialPos.below(), config, trunkSetter);

        int trunkHeight = config.trunkShape.getTrunkHeight(random);
        for (int currentY = 0; currentY <= trunkHeight; currentY++) {
            this.placeLog(level, random, initialPos.above(currentY), config, Direction.Axis.Y, trunkSetter);
        }

        this.placeBlobFoliage(level, random, initialPos.above(trunkHeight - 3), config, foliageSetter, 2, 6);

        List<Direction> directions = new ArrayList<>(Arrays.asList(Direction.Plane.HORIZONTAL.stream().toArray(Direction[]::new)));
        Collections.shuffle(directions, new Random(random.nextLong()));

        int branchCount = random.nextIntBetweenInclusive(3, 4);
        int minBranchY = trunkHeight / 2;
        int maxBranchY = minBranchY + 2;
        for (int i = 0; i < branchCount; i++) {
            int branchY = minBranchY + random.nextInt(maxBranchY - minBranchY);
            int branchLength = 2 + random.nextInt(1);
            this.generateBranch(level, random, initialPos.above(branchY), config, directions.get(i), trunkSetter, foliageSetter, branchLength);
        }
        return true;
    }

    protected void generateBranch(LevelAccessor level, RandomSource random, BlockPos pos, MysticTreeConfiguration config, Direction direction, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, int branchLength) {
        BlockPos.MutableBlockPos mutablePos = pos.mutable();

        boolean isDiagonal = random.nextBoolean();
        int interval = Math.max(1, branchLength / 3);

        for (int length = 0; length <= branchLength; length++) {
            mutablePos.move(direction);

            if (isDiagonal) { /// 50% chance to make the branch move off diagonally.
                Direction diagonal = Direction.Plane.HORIZONTAL.stream().filter(d -> d != direction && d != direction.getOpposite()).findAny().orElse(direction);
                this.placeLogWithSurroundingLeaves(level, random, mutablePos, config, diagonal.getAxis(), branchSetter, foliageSetter, 0);
                mutablePos.move(diagonal);
            }

            this.placeLogWithSurroundingLeaves(level, random, mutablePos, config, direction.getAxis(), branchSetter, foliageSetter, 0);

            if (length % interval == 0 && length != 0) {
                if (length == branchLength) return; /// stop the process if the current length reaches the max length.
                mutablePos.move(Direction.UP);
                this.placeLogWithSurroundingLeaves(level, random, mutablePos, config, Direction.Axis.Y, branchSetter, foliageSetter, 0);
            }
        }
    }

    protected void placeBlobFoliage(LevelAccessor level, RandomSource random, BlockPos pos, MysticTreeConfiguration config, BiConsumer<BlockPos, BlockState> foliageSetter, int foliageRadius, int foliageHeight) {
        for (int radius = 0; radius <= foliageRadius; radius++) {
            for (int height = 0; height <= foliageHeight; height++) {
                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    BlockPos currentPos = pos.above(height);

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

                        if (random.nextInt(3) == 0) {
                            this.placeLeaves(level, random, currentPos.relative(direction, radius + 1), config, foliageSetter);
                        }
                    }
                }
            }
        }
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int x, int y, int z, int radius, boolean doubleTrunk) {
        return false;
    }

}