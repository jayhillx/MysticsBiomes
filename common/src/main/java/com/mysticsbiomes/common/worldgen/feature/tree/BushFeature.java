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

public class BushFeature extends MysticTreeFeature {

    public BushFeature(Codec<MysticTreeConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean placeTree(WorldGenLevel level, RandomSource random, BlockPos initialPos, BiConsumer<BlockPos, BlockState> trunkSetter, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, MysticTreeConfiguration config) {
        setDirtAt(level, random, initialPos.below(), config, trunkSetter);
        this.placeLog(level, random, initialPos, config, Direction.Axis.Y, trunkSetter);
        this.placeLeavesRow(level, random, initialPos, config, foliageSetter, 2, 1);
        return true;
    }

    protected void placeLeavesRow(LevelAccessor level, RandomSource random, BlockPos pos, MysticTreeConfiguration config, BiConsumer<BlockPos, BlockState> foliageSetter, int foliageRadius, int foliageHeight) {
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        for (int y = 0; y <= foliageHeight; y++) {
            int radius = foliageRadius - y;
            for (int x = -radius; x <= radius; x++) {
                for (int z = -radius; z <= radius; z++) {
                    if (!this.shouldSkipLocationSigned(random, x, y, z, radius, false)) {
                        mutablePos.setWithOffset(pos, x, y, z);
                        this.placeLeaves(level, random, mutablePos, config, foliageSetter);
                    }
                }
            }
        }
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int x, int y, int z, int radius, boolean doubleTrunk) {
        return x == radius && z == radius && random.nextInt(2) == 0;
    }

}