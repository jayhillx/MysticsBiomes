package com.mysticsbiomes.common.worldgen.feature.misc;

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

    public SpringBambooFeature(Codec<ProbabilityFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<ProbabilityFeatureConfiguration> context) {
        int count = 0;
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        BlockPos initialPos = context.origin();
        BlockPos.MutableBlockPos bambooPos = initialPos.mutable();
        BlockPos.MutableBlockPos groundPos = initialPos.mutable();
        ProbabilityFeatureConfiguration config = context.config();

        if (level.isEmptyBlock(bambooPos)) {
            if (MysticBlocks.SPRING_BAMBOO.get().defaultBlockState().canSurvive(level, bambooPos)) {
                int height = random.nextInt(10) + 4;
                int radius;
                if (random.nextFloat() < config.probability) {
                    radius = random.nextInt(4) + 1;

                    for (int offsetX = initialPos.getX() - radius; offsetX <= initialPos.getX() + radius; offsetX++) {
                        for (int offsetZ = initialPos.getZ() - radius; offsetZ <= initialPos.getZ() + radius; offsetZ++) {
                            int dx = offsetX - initialPos.getX();
                            int dz = offsetZ - initialPos.getZ();
                            if (dx * dx + dz * dz <= radius * radius) {
                                groundPos.set(offsetX, level.getHeight(Heightmap.Types.WORLD_SURFACE, offsetX, offsetZ) - 1, offsetZ);
                                if (isDirt(level.getBlockState(groundPos))) {
                                    level.setBlock(groundPos, Blocks.PODZOL.defaultBlockState(), 2);
                                }
                            }
                        }
                    }
                }

                int age = height < 6 ? 0 : height > 6 && height < 10 ? 1 : 2;
                BlockState state = MysticBlocks.SPRING_BAMBOO.get().defaultBlockState().setValue(SpringBambooStalkBlock.AGE, age).setValue(SpringBambooStalkBlock.STAGE, 0).setValue(SpringBambooStalkBlock.LEAVES, BambooLeaves.NONE).setValue(SpringBambooStalkBlock.NATURAL, true);
                for (int i = 0; i < height && level.isEmptyBlock(bambooPos); i++) {
                    level.setBlock(bambooPos, state, 2);
                    if (level.isEmptyBlock(bambooPos)) continue;
                    bambooPos.move(Direction.UP, 1);
                }

                if (bambooPos.getY() - initialPos.getY() >= 3) {
                    level.setBlock(bambooPos, state.setValue(SpringBambooStalkBlock.LEAVES, BambooLeaves.LARGE).setValue(SpringBambooStalkBlock.STAGE, 1), 2);
                    level.setBlock(bambooPos.move(Direction.DOWN, 1), state.setValue(SpringBambooStalkBlock.LEAVES, BambooLeaves.LARGE), 2);
                    level.setBlock(bambooPos.move(Direction.DOWN, 1), state.setValue(SpringBambooStalkBlock.LEAVES, BambooLeaves.SMALL), 2);
                }
            }
            ++count;
        }
        return count > 0;
    }

}