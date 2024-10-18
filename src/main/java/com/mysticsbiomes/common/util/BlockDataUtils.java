package com.mysticsbiomes.common.util;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.Item;

public class BlockDataUtils {

    public static void flammable(Block block, int encouragement, int flammability) {
        FlammableBlockRegistry.getDefaultInstance().add(block, encouragement, flammability);
    }

    public static void compostable(Item item, float chance) {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(item.asItem(), chance);
    }

    public static void strippable(Block wood, Block strippedWood) {
        StrippableBlockRegistry.register(wood, strippedWood);
    }

}