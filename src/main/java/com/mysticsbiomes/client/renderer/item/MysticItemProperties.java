package com.mysticsbiomes.client.renderer.item;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public class MysticItemProperties {

    private static int getCapturedBugType(ItemStack stack) {
        CompoundTag tag = stack.getTagElement("CapturedBug");
        return tag != null ? 1 + tag.getInt("Variant") : 0;
    }

    public static void registerItemProperties() {
        ItemProperties.register(MysticItems.GLASS_JAR.get(), MysticsBiomes.modLoc("variant"), (stack, level, entity, id) -> getCapturedBugType(stack));
    }

}