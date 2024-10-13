package com.mysticsbiomes.common.world.feature.misc;

import com.mojang.serialization.Codec;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

/**
 * places some leaf piles under some maple trees; may need adjusted due to potential lag spikes.
 */
public class MapleTreeFeature extends TreeFeature {

    public MapleTreeFeature(Codec<TreeFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<TreeFeatureConfig> context) {
        StructureWorldAccess level = context.getWorld();
        BlockPos pos = context.getOrigin();
        Random random = context.getRandom();

        boolean flag = super.generate(context);
        if (flag && random.nextInt(2) == 0) {
            BlockState leavesState = context.getConfig().foliageProvider.get(random, pos);
            BlockState state;
            if (leavesState == MysticBlocks.MAPLE_LEAVES.getDefaultState()) {
                state = MysticBlocks.MAPLE_LEAF_PILE.getDefaultState();
            } else if (leavesState == MysticBlocks.ORANGE_MAPLE_LEAVES.getDefaultState()) {
                state = MysticBlocks.ORANGE_MAPLE_LEAF_PILE.getDefaultState();
            } else if (leavesState == MysticBlocks.YELLOW_MAPLE_LEAVES.getDefaultState()) {
                state = MysticBlocks.YELLOW_MAPLE_LEAF_PILE.getDefaultState();
            } else {
                state = MysticBlocks.MAPLE_LEAF_PILE.getDefaultState();
            }

            for (int x = -3; x <= 3; ++x) {
                for (int z = -3; z <= 3; ++z) {
                    for (int y = -3; y <= 3; ++y) {
                        if (Math.abs(x) < 3 && Math.abs(z) < 3 && Math.abs(y) < 3) {
                            BlockPos offsetPos = pos.add(x, y, z);
                            if (random.nextInt(6) > 0 && level.isAir(offsetPos) && level.getBlockState(offsetPos.down()).getBlock() == Blocks.GRASS_BLOCK) {
                                level.setBlockState(offsetPos, state, 2);
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

}