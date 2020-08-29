package com.meepshadow.mysticsbiomes.common.block;

import com.meepshadow.mysticsbiomes.core.MysticsBiomes;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BlockItemBase extends BlockItem {

    public BlockItemBase(Block block) {
        super(block, new Item.Properties().group(MysticsBiomes.TAB));
    }
}
