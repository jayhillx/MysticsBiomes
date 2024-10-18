package com.mysticsbiomes.common.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class MysticBlockItem extends BlockItem {

    public MysticBlockItem(Block block) {
        super(block, new FabricItemSettings());
    }

}