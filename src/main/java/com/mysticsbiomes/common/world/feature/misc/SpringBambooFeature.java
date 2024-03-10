package com.mysticsbiomes.common.world.feature.misc;

import com.mojang.serialization.Codec;
import com.mysticsbiomes.common.block.SpringBambooStalkBlock;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BambooLeaves;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;

public class SpringBambooFeature extends Feature<ProbabilityFeatureConfiguration> {
    private static final BlockState SPRING_BAMBOO_TRUNK = MysticBlocks.SPRING_BAMBOO.get().defaultBlockState().setValue(SpringBambooStalkBlock.AGE, 1).setValue(SpringBambooStalkBlock.LEAVES, BambooLeaves.NONE).setValue(SpringBambooStalkBlock.STAGE, 0);
    private static final BlockState SPRING_BAMBOO_FINAL_LARGE = SPRING_BAMBOO_TRUNK.setValue(SpringBambooStalkBlock.LEAVES, BambooLeaves.LARGE).setValue(SpringBambooStalkBlock.STAGE, 1);
    private static final BlockState SPRING_BAMBOO_TOP_LARGE = SPRING_BAMBOO_TRUNK.setValue(SpringBambooStalkBlock.LEAVES, BambooLeaves.LARGE);
    private static final BlockState SPRING_BAMBOO_TOP_SMALL = SPRING_BAMBOO_TRUNK.setValue(SpringBambooStalkBlock.LEAVES, BambooLeaves.SMALL);

    public SpringBambooFeature(Codec<ProbabilityFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<ProbabilityFeatureConfiguration> context) {
        int i = 0;
        BlockPos pos = context.origin();
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        ProbabilityFeatureConfiguration probabilityfeatureconfiguration = context.config();
        BlockPos.MutableBlockPos mutablePos = pos.mutable();
        BlockPos.MutableBlockPos mutablePos1 = pos.mutable();

        if (level.isEmptyBlock(mutablePos)) {
            if (MysticBlocks.SPRING_BAMBOO.get().defaultBlockState().canSurvive(level, mutablePos)) {
                int j = random.nextInt(12) + 5;
                int k;
                if (random.nextFloat() < probabilityfeatureconfiguration.probability) {
                    k = random.nextInt(4) + 1;

                    for (int l = pos.getX() - k; l <= pos.getX() + k; ++l) {
                        for (int i1 = pos.getZ() - k; i1 <= pos.getZ() + k; ++i1) {
                            int j1 = l - pos.getX();
                            int k1 = i1 - pos.getZ();
                            if (j1 * j1 + k1 * k1 <= k * k) {
                                mutablePos1.set(l, level.getHeight(Heightmap.Types.WORLD_SURFACE, l, i1) - 1, i1);
                                if (isDirt(level.getBlockState(mutablePos1))) {
                                    level.setBlock(mutablePos1, Blocks.PODZOL.defaultBlockState(), 2);
                                }
                            }
                        }
                    }
                }

                for (k = 0; k < j && level.isEmptyBlock(mutablePos); ++k) {
                    level.setBlock(mutablePos, SPRING_BAMBOO_TRUNK, 2);
                    mutablePos.move(Direction.UP, 1);
                }

                if (mutablePos.getY() - pos.getY() >= 3) {
                    level.setBlock(mutablePos, SPRING_BAMBOO_FINAL_LARGE, 2);
                    level.setBlock(mutablePos.move(Direction.DOWN, 1), SPRING_BAMBOO_TOP_LARGE, 2);
                    level.setBlock(mutablePos.move(Direction.DOWN, 1), SPRING_BAMBOO_TOP_SMALL, 2);
                }
            }
            ++i;
        }
        return i > 0;
    }

}