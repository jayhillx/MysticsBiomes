package com.mysticsbiomes.common.worldgen.feature.tree;

import com.mojang.serialization.Codec;
import com.mysticsbiomes.common.worldgen.feature.config.MysticTreeConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.*;
import java.util.function.BiConsumer;

public class CherryTreeFeature extends MysticTreeFeature {

    public CherryTreeFeature(Codec<MysticTreeConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean placeTree(WorldGenLevel level, RandomSource random, BlockPos initialPos, BiConsumer<BlockPos, BlockState> trunkSetter, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, MysticTreeConfiguration config) {
        setDirtAt(level, random, initialPos.below(), config, trunkSetter);

        int trunkHeight = config.trunkShape.getTrunkHeight(random);
        for (int currentY = 0; currentY <= trunkHeight; currentY++) {
            this.placeLog(level, random, initialPos.above(currentY), config, Direction.Axis.Y, trunkSetter);
        }

        this.placeBushyFoliage(level, random, initialPos.above(trunkHeight), config, foliageSetter, 2, 1);

        List<Direction> directions = new ArrayList<>(Arrays.asList(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST));
        Collections.shuffle(directions, new Random(random.nextLong()));

        int branchCount = random.nextIntBetweenInclusive(3, 4);
        for (int i = 0; i < branchCount; i++) {
            Direction direction = directions.get(i);
            int branchYStart = trunkHeight / 2 - random.nextIntBetweenInclusive(1, 2);
            int branchLength = 6 + random.nextInt(2);

            BlockPos branchPos = initialPos.above(branchYStart);
            if (this.canPlaceBranch(level, branchPos, direction, 1) && this.canGenerateBranch(level, branchPos, direction, branchLength)) {
                this.generateBranch(level, random, branchPos, config, direction, branchSetter, foliageSetter, branchYStart, branchLength);
            }
        }
        return !this.hasPodzolNearby(level, initialPos);
    }

    protected void generateBranch(LevelAccessor level, RandomSource random, BlockPos startPos, MysticTreeConfiguration config, Direction branchDirection, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, int branchYStart, int branchLength) {
        BlockPos.MutableBlockPos mutablePos = startPos.mutable();

        for (int i = 0; i < random.nextIntBetweenInclusive(0, 2); i++) {
            mutablePos.move(branchDirection);
            if (!level.getBlockState(mutablePos).isAir()) return;
            this.placeLog(level, random, mutablePos, config, branchDirection.getAxis(), branchSetter);
        }

        int steps = 0;
        while (steps <= branchLength) {
            int forwardInterval = 1 + Math.round((float) steps / branchLength * 2);
            int upwardInterval = 1 + Math.round((float) steps / branchLength * 2);

            for (int i = 0; i < forwardInterval && steps < branchLength; i++, steps++) {
                mutablePos.move(branchDirection);
                this.placeLog(level, random, mutablePos, config, branchDirection.getAxis(), branchSetter);
            }

            for (int i = 0; i < upwardInterval && steps < branchLength; i++, steps++) {
                mutablePos.move(Direction.UP);
                this.placeLog(level, random, mutablePos, config, Direction.Axis.Y, branchSetter);
            }

            if (steps == branchLength) {
                mutablePos.move(Direction.UP);
                this.placeLog(level, random, mutablePos, config, Direction.Axis.Y, branchSetter);
                this.placeBushyFoliage(level, random, mutablePos, config, foliageSetter, 2, 1);
                return;
            }
        }
    }
    
    @Override
    protected boolean shouldSkipLocation(RandomSource random, int x, int y, int z, int radius, boolean doubleTrunk) {
        return false;
    }

    private boolean hasPodzolNearby(LevelSimulatedReader level, BlockPos pos) {
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        int distance = 8;
        for (int xOffset = -distance; xOffset <= distance; xOffset++) {
            for (int zOffset = -distance; zOffset <= distance; zOffset++) {
                mutablePos.set(pos).move(xOffset, 0, zOffset);

                if (level.isStateAtPosition(mutablePos, state -> state.getBlock() == Blocks.PODZOL)) {
                    return true;
                }
            }
        }
        return false;
    }

}