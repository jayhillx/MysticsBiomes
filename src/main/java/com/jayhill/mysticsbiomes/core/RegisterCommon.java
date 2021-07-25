package com.jayhill.mysticsbiomes.core;

import com.jayhill.mysticsbiomes.common.block.utils.BlockDataUtils;
import com.jayhill.mysticsbiomes.init.MysticBlocks;
import com.jayhill.mysticsbiomes.init.MysticItems;

public class RegisterCommon {

    /** Compostables. */
    public static void registerCompostables() {
        BlockDataUtils.setCompostable(MysticItems.STRAWBERRIES.get(), 0.4F);
        BlockDataUtils.setCompostable(MysticItems.SWEET_STRAWBERRIES.get(), 0.9F);

        BlockDataUtils.setCompostable(MysticBlocks.STRAWBERRY_BLOSSOM_LEAVES.get(), 0.3F);
        BlockDataUtils.setCompostable(MysticBlocks.STRAWBERRY_BLOSSOM_SAPLING.get(), 0.3F);
        BlockDataUtils.setCompostable(MysticBlocks.SWEET_BLOSSOM_LEAVES.get(), 0.3F);
        BlockDataUtils.setCompostable(MysticBlocks.SWEET_BLOSSOM_SAPLING.get(), 0.3F);
    }

    /** Flammables. */
    public static void registerFlammables() {
        BlockDataUtils.setFlammable(MysticBlocks.STRAWBERRY_PLANKS.get(), 5, 20);
        BlockDataUtils.setFlammable(MysticBlocks.STRAWBERRY_STAIRS.get(), 5, 20);
        BlockDataUtils.setFlammable(MysticBlocks.STRAWBERRY_SLAB.get(), 5, 20);
        BlockDataUtils.setFlammable(MysticBlocks.STRAWBERRY_FENCE.get(), 5, 20);
        BlockDataUtils.setFlammable(MysticBlocks.STRAWBERRY_FENCE_GATE.get(), 5, 20);
        BlockDataUtils.setFlammable(MysticBlocks.STRAWBERRY_DOOR.get(), 5, 20);
        BlockDataUtils.setFlammable(MysticBlocks.STRAWBERRY_TRAPDOOR.get(), 5, 20);
        BlockDataUtils.setFlammable(MysticBlocks.STRIPPED_STRAWBERRY_LOG.get(), 5, 20);
        BlockDataUtils.setFlammable(MysticBlocks.STRIPPED_STRAWBERRY_WOOD.get(), 5, 20);
        BlockDataUtils.setFlammable(MysticBlocks.STRAWBERRY_LOG.get(), 5, 20);
        BlockDataUtils.setFlammable(MysticBlocks.STRAWBERRY_WOOD.get(), 5, 20);

        BlockDataUtils.setFlammable(MysticBlocks.STRAWBERRY_BLOSSOM_LEAVES.get(), 30, 60);
        BlockDataUtils.setFlammable(MysticBlocks.SWEET_BLOSSOM_LEAVES.get(), 30, 60);

        BlockDataUtils.setFlammable(MysticBlocks.STRAWBERRY_BUSH.get(), 60, 100);
    }

}