package com.mysticsbiomes.common.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class MysticBlockItem extends BlockItem {

    public MysticBlockItem(Supplier<Block> block) {
        super(block.get(), new Properties());
    }

}