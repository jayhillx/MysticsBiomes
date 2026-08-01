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

public class ShrubFeature extends MysticTreeFeature {

    public ShrubFeature(Codec<MysticTreeConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean placeTree(WorldGenLevel level, RandomSource random, BlockPos initialPos, BiConsumer<BlockPos, BlockState> trunkSetter, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, MysticTreeConfiguration config) {
        setDirtAt(level, random, initialPos.below(), config, trunkSetter);

        int height = config.trunkShape.getTrunkHeight(random);
        for (int currentY = 0; currentY < height; currentY++) {
            this.placeLog(level, random, initialPos.above(currentY), config, Direction.Axis.Y, trunkSetter);
        }

        this.placeFoliage(level, random, initialPos, config, foliageSetter, height, height == 2 ? 1 : 2);
        return true;
    }

    protected void placeFoliage(LevelAccessor level, RandomSource random, BlockPos pos, MysticTreeConfiguration config, BiConsumer<BlockPos, BlockState> foliageSetter, int foliageRadius, int foliageHeight) {
        BlockPos.MutableBlockPos mutablePos = pos.mutable();

        for (int y = 0; y <= foliageHeight; y++) {
            int radius = y > 0 ? foliageRadius - 1 : foliageRadius;

            for (int x = -radius; x <= radius; x++) {
                for (int z = -radius; z <= radius; z++) {
                    if (!this.shouldSkipLocationSigned(random, x, y, z, radius, false)) {
                        mutablePos.setWithOffset(pos, x, y, z);
                        this.placeLeaves(level, random, mutablePos, config, foliageSetter);
                        this.placeRandomLeaves(level, random, mutablePos, config, foliageSetter);

                        Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
                        this.placeLeafShape(level, random, mutablePos, config, direction, foliageSetter);
                        for (int i = 0; i < 1; i++) {
                            this.placeLeaves(level, random, mutablePos.relative(direction.getOpposite()).relative(direction.getOpposite().getClockWise()).above(i), config, foliageSetter);
                        }
                    }
                }
            }
        }
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int x, int y, int z, int radius, boolean doubleTrunk) {
        return x == radius && z == radius;
    }

}