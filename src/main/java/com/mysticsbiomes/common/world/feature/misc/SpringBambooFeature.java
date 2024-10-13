package com.mysticsbiomes.common.world.feature.misc;

import com.mojang.serialization.Codec;
import com.mysticsbiomes.common.block.SpringBambooStalkBlock;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.BambooLeaves;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class SpringBambooFeature extends Feature<ProbabilityConfig> {
    private static final BlockState SPRING_BAMBOO_TRUNK = MysticBlocks.SPRING_BAMBOO.getDefaultState().with(SpringBambooStalkBlock.AGE, 1).with(SpringBambooStalkBlock.LEAVES, BambooLeaves.NONE).with(SpringBambooStalkBlock.STAGE, 0);
    private static final BlockState SPRING_BAMBOO_FINAL_LARGE = SPRING_BAMBOO_TRUNK.with(SpringBambooStalkBlock.LEAVES, BambooLeaves.LARGE).with(SpringBambooStalkBlock.STAGE, 1);
    private static final BlockState SPRING_BAMBOO_TOP_LARGE = SPRING_BAMBOO_TRUNK.with(SpringBambooStalkBlock.LEAVES, BambooLeaves.LARGE);
    private static final BlockState SPRING_BAMBOO_TOP_SMALL = SPRING_BAMBOO_TRUNK.with(SpringBambooStalkBlock.LEAVES, BambooLeaves.SMALL);

    public SpringBambooFeature(Codec<ProbabilityConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<ProbabilityConfig> context) {
        int i = 0;
        BlockPos pos = context.getOrigin();
        StructureWorldAccess level = context.getWorld();
        Random random = context.getRandom();
        ProbabilityConfig config = context.getConfig();
        BlockPos.Mutable mutablePos = pos.mutableCopy();
        BlockPos.Mutable mutablePos1 = pos.mutableCopy();

        if (level.isAir(mutablePos)) {
            if (MysticBlocks.SPRING_BAMBOO.getDefaultState().canPlaceAt(level, mutablePos)) {
                int j = random.nextInt(12) + 5;
                int k;
                if (random.nextFloat() < config.probability) {
                    k = random.nextInt(4) + 1;

                    for (int l = pos.getX() - k; l <= pos.getX() + k; ++l) {
                        for (int i1 = pos.getZ() - k; i1 <= pos.getZ() + k; ++i1) {
                            int j1 = l - pos.getX();
                            int k1 = i1 - pos.getZ();
                            if (j1 * j1 + k1 * k1 <= k * k) {
                                mutablePos1.set(l, level.getTopY(Heightmap.Type.WORLD_SURFACE, l, i1) - 1, i1);
                                if (isSoil(level.getBlockState(mutablePos1))) {
                                    level.setBlockState(mutablePos1, Blocks.PODZOL.getDefaultState(), 2);
                                }
                            }
                        }
                    }
                }

                for (k = 0; k < j && level.isAir(mutablePos); ++k) {
                    level.setBlockState(mutablePos, SPRING_BAMBOO_TRUNK, 2);
                    mutablePos.move(Direction.UP, 1);
                }

                if (mutablePos.getY() - pos.getY() >= 3) {
                    level.setBlockState(mutablePos, SPRING_BAMBOO_FINAL_LARGE, 2);
                    level.setBlockState(mutablePos.move(Direction.DOWN, 1), SPRING_BAMBOO_TOP_LARGE, 2);
                    level.setBlockState(mutablePos.move(Direction.DOWN, 1), SPRING_BAMBOO_TOP_SMALL, 2);
                }
            }
            ++i;
        }
        return i > 0;
    }

}