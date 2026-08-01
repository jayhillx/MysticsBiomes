package com.mysticsbiomes.common.block.util;

import com.google.common.collect.Maps;
import api.mystanica.registry.RegistryEntry;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FireBlock;

public class BlockUtils {

    public static void registerFlammable(RegistryEntry<Block> block, int encouragement, int flammability) {
        FireBlock fire = (FireBlock) Blocks.FIRE;
        fire.setFlammable(block.get(), encouragement, flammability);
    }

    public static void registerCompostable(RegistryEntry<Item> item, float chance) {
        ComposterBlock.COMPOSTABLES.put(item.get(), chance);
    }

    public static void registerStrippable(RegistryEntry<Block> log, RegistryEntry<Block> stripped) {
        AxeItem.STRIPPABLES = Maps.newHashMap(AxeItem.STRIPPABLES);
        AxeItem.STRIPPABLES.put(log.get(), stripped.get());
    }

}