package com.meepshadow.mysticsbiomes.common.block;

import com.meepshadow.mysticsbiomes.common.util.ItemStackUtils;

import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.NonNullList;

public class ModStrippedLog extends RotatedPillarBlock {
    public ModStrippedLog(Properties properties) {
        super(properties);
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if(ItemStackUtils.isInGroup(this.asItem(), group)) {
            int targetIndex = ItemStackUtils.findIndexOfItem(Items.STRIPPED_DARK_OAK_LOG, items);
            if(targetIndex != -1) {
                items.add(targetIndex + 1, new ItemStack(this));
            } else {
                super.fillItemGroup(group, items);
            }
        }
    }
}
