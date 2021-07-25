package com.jayhill.mysticsbiomes.common.block.utils;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.FireBlock;
import net.minecraft.util.IItemProvider;

public class BlockDataUtils {

    /** Sets Flammability. */
    public static void setFlammable(Block block, int encouragement, int flammability) {
        FireBlock fire = (FireBlock) Blocks.FIRE;
        fire.setFireInfo(block, encouragement, flammability);
    }

    /** Sets Compostable. */
    public static void setCompostable(IItemProvider item, float chance) {
        ComposterBlock.CHANCES.put(item.asItem(), chance);
    }

}