package com.jayhill.mysticsbiomes.common.block.utils;

import com.jayhill.mysticsbiomes.MysticsBiomes;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class BlockItemUtils extends BlockItem {

    public BlockItemUtils(Block block) {
        super(block, new Properties().group(MysticsBiomes.TAB));
    }

}