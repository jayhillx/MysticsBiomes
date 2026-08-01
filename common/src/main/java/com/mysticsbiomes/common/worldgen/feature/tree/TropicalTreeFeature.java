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

public class TropicalTreeFeature extends MysticTreeFeature {

    public TropicalTreeFeature(Codec<MysticTreeConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean placeTree(WorldGenLevel level, RandomSource random, BlockPos initialPos, BiConsumer<BlockPos, BlockState> trunkSetter, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, MysticTreeConfiguration config) {
        BlockPos belowPos = initialPos.below();
        setDirtAt(level, random, belowPos, config, trunkSetter);

        int trunkHeight = config.trunkShape.getTrunkHeight(random);
        int lowSectionEnd = Math.round(trunkHeight * 0.33F);
        int midSectionEnd = Math.round(trunkHeight * 0.66F);
        boolean doubleTrunk = trunkHeight > 15;
        for (int currentY = 0; currentY < trunkHeight; currentY++) {
            this.placeLog(level, random, initialPos.above(currentY), config, Direction.Axis.Y, branchSetter);

            if (doubleTrunk) {
                BlockPos[] positions = {initialPos.east(), initialPos.south().east(), initialPos.south()};
                for (BlockPos pos : positions) {
                    setDirtAt(level, random, pos.below(), config, trunkSetter);
                    this.placeLog(level, random, pos.above(currentY), config, Direction.Axis.Y, branchSetter);
                }
            }
        }

        Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
        this.generateSmallBranch(level, random, this.getBranchPos(initialPos.relative(direction.getClockWise()).above(random.nextInt(lowSectionEnd - 1, lowSectionEnd + 1) - 1), direction.getClockWise(), random, doubleTrunk), config, direction.getClockWise(), branchSetter, foliageSetter);
        this.generateSmallBranch(level, random, this.getBranchPos(initialPos.relative(direction.getCounterClockWise()).above(random.nextInt(lowSectionEnd - 1, lowSectionEnd + 1) - 1), direction.getCounterClockWise(), random, doubleTrunk), config, direction.getCounterClockWise(), branchSetter, foliageSetter);
        this.generateBranch(level, random, this.getBranchPos(initialPos.above(random.nextInt(lowSectionEnd - 1, lowSectionEnd + 1)), direction, random, doubleTrunk), config, direction, direction.getClockWise(), branchSetter, foliageSetter, 4, 0, random.nextBoolean(), doubleTrunk);
        this.generateBranch(level, random, this.getBranchPos(initialPos.above(random.nextInt(midSectionEnd - 1, midSectionEnd + 1) - 4), direction.getOpposite(), random, doubleTrunk), config, direction.getOpposite(), direction.getOpposite().getClockWise(), branchSetter, foliageSetter, 3, 0, random.nextBoolean(), doubleTrunk);

        this.placeBlobFoliage(level, random, initialPos.above(trunkHeight - 2), config, foliageSetter, 3, 2, doubleTrunk);
        return true;
    }

    /**
     * @param branchLength ------ only counts horizontal length,  not vertical.
     * @param branchDirection --- determines what direction the branch will face.
     * @param diagonalDirection - determines the direction the branch will face diagonally, making the branch face in between directions. (i.e. northeast)
     */
    protected void generateBranch(LevelAccessor level, RandomSource random, BlockPos startPos, MysticTreeConfiguration config, Direction branchDirection, Direction diagonalDirection, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, int branchLength, int branchHeight, boolean diagonal, boolean doubleTrunk) {
        BlockPos.MutableBlockPos mutablePos = startPos.mutable();

        for (int i = 0; i < random.nextInt(2); i++) {
            mutablePos.move(branchDirection);
            this.placeLog(level, random, mutablePos, config, branchDirection.getAxis(), branchSetter);
        }

        int steps = 0;
        while (steps <= branchLength) {
            int forwardInterval = diagonal ? 1 : (random.nextBoolean() ? 2 : 1);
            int upwardInterval = 1;

            for (int i = 0; i < forwardInterval && steps < branchLength; i++, steps++) {
                mutablePos.move(branchDirection);
                if (diagonal) {
                    this.placeLog(level, random, mutablePos, config, branchDirection.getAxis(), branchSetter);
                    mutablePos.move(diagonalDirection);
                }
                this.placeLog(level, random, mutablePos, config, diagonal ? diagonalDirection.getAxis() : branchDirection.getAxis(), branchSetter);
            }

            for (int i = 0; i < upwardInterval && steps < branchLength; i++, steps++) {
                mutablePos.move(Direction.UP);
                this.placeLog(level, random, mutablePos, config, Direction.Axis.Y, branchSetter);
            }

            if (steps == branchLength) {
                mutablePos.move(Direction.UP);
                this.placeLog(level, random, mutablePos, config, Direction.Axis.Y, branchSetter);
                this.placeBlobFoliage(level, random, mutablePos, config, foliageSetter, 1, 1, doubleTrunk);
                return;
            }
        }
    }

    protected void generateSmallBranch(LevelAccessor level, RandomSource random, BlockPos startPos, MysticTreeConfiguration config, Direction direction, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter) {
        this.placeLog(level, random, startPos, config, direction.getAxis(), branchSetter);
        this.placeLeafShape(level, random, startPos, config, direction, foliageSetter);
    }

    protected void placeBlobFoliage(LevelAccessor level, RandomSource random, BlockPos pos, MysticTreeConfiguration config, BiConsumer<BlockPos, BlockState> foliageSetter, int foliageRadius, int foliageHeight, boolean doubleTrunk) {
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        for (int y = 0; y <= foliageHeight; y++) {
            int radius = foliageRadius + 1 - y;
            int extraRange = doubleTrunk ? 1 : 0;
            for (int x = -radius; x <= radius + extraRange; x++) {
                for (int z = -radius; z <= radius + extraRange; z++) {
                    if (!this.shouldSkipLocationSigned(random, x, y, z, radius, doubleTrunk)) {
                        mutablePos.setWithOffset(pos, x, y, z);
                        this.placeLeaves(level, random, mutablePos, config, foliageSetter);
                        this.placeRandomLeaves(level, random, mutablePos, config, foliageSetter);
                    }
                }
            }
        }
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int x, int y, int z, int radius, boolean doubleTrunk) {
        return x + z >= 7 || (x * x + z * z > radius * radius);
    }

}