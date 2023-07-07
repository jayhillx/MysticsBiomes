package com.mysticsbiomes.common.util;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FireBlock;

public class BlockDataUtils {

    public static void flammable(Block block, int encouragement, int flammability) {
        FireBlock fire = (FireBlock)Blocks.FIRE;
        fire.setFlammable(block, encouragement, flammability);
    }

    public static void compostable(ItemLike item, float chance) {
        ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
    }

}