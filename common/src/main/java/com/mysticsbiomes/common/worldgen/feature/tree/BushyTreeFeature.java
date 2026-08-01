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

public class BushyTreeFeature extends MysticTreeFeature {

    public BushyTreeFeature(Codec<MysticTreeConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean placeTree(WorldGenLevel level, RandomSource random, BlockPos initialPos, BiConsumer<BlockPos, BlockState> trunkSetter, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, MysticTreeConfiguration config) {
        setDirtAt(level, random, initialPos.below(), config, trunkSetter);

        int trunkHeight = config.trunkShape.getTrunkHeight(random);
        for (int currentY = 0; currentY <= trunkHeight; currentY++) {
            this.placeLog(level, random, initialPos.above(currentY), config, Direction.Axis.Y, trunkSetter);
        }

        this.placeBushyFoliage(level, random, initialPos.above(trunkHeight), config, foliageSetter, 2, 2);

        Direction branchDirection = Direction.Plane.HORIZONTAL.getRandomDirection(random);
        int branchYStart = random.nextInt(1, 3);
        this.generateBranch(level, random, initialPos.above(branchYStart), config, branchDirection, branchSetter, foliageSetter, 3, false);

        if (random.nextBoolean()) {
            int midpointHeight = config.trunkShape.baseHeight + (config.trunkShape.randHeight / 2);
            if (trunkHeight >= midpointHeight) {
                int secondBranchYStart = random.nextInt(1, 3);
                this.generateBranch(level, random, initialPos.above(secondBranchYStart).relative(branchDirection), config, branchDirection.getOpposite(), branchSetter, foliageSetter, 2, random.nextBoolean());
            }
        }
        return true;
    }

    protected void generateBranch(LevelAccessor level, RandomSource random, BlockPos startPos, MysticTreeConfiguration config, Direction branchDirection, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, int branchLength, boolean diagonal) {
        BlockPos.MutableBlockPos mutablePos = startPos.mutable();

        if (random.nextBoolean()) {
            mutablePos.move(branchDirection);
            this.placeLog(level, random, mutablePos, config, branchDirection.getAxis(), branchSetter);
        }

        int steps = 0;
        while (steps <= branchLength) {
            int forwardInterval = 1;
            int upwardInterval = 1 + Math.round((float) steps / branchLength * 2);

            for (int i = 0; i < forwardInterval && steps < branchLength; i++, steps++) {
                mutablePos.move(branchDirection);

                final Direction diagonalDirection = branchDirection.getClockWise();
                if (diagonal) {
                    this.placeLog(level, random, mutablePos, config, branchDirection.getAxis(), branchSetter);
                    mutablePos.move(diagonalDirection);
                }
                this.placeLog(level, random, mutablePos, config, diagonal ? diagonalDirection.getAxis() : branchDirection.getAxis(), branchSetter);
            }

            for (int i = 0; i < upwardInterval; i++) {
                mutablePos.move(Direction.UP);
                this.placeLog(level, random, mutablePos, config, Direction.Axis.Y, branchSetter);
            }

            if (steps == branchLength) {
                this.placeBushyFoliage(level, random, mutablePos, config, foliageSetter, 2, 1);
                return;
            }
        }
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int x, int y, int z, int radius, boolean doubleTrunk) {
        return false;
    }

}