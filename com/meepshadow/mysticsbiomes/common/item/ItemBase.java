package com.meepshadow.mysticsbiomes.common.item;

import com.meepshadow.mysticsbiomes.core.MysticsBiomes;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    public ItemBase() {
        super(new Item.Properties().group(MysticsBiomes.TAB));
    }
}
