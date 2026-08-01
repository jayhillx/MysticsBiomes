package com.mysticsbiomes.handler;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.init.MysticCriteriaTriggers;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CraftingHandler {

    public static void onItemCrafted(ServerPlayer player, ItemStack stack) {
        if (player.getServer() == null) return;

        Item item = stack.getItem();
        if (!(item == MysticItems.SWEET_STRAWBERRY_CAKE.get()) && !isNeapolitanCake(item) && !isFrostedCake(item)) return;

        ResourceLocation advancement = null;
        if (item == MysticItems.SWEET_STRAWBERRY_CAKE.get()) {
            advancement = MysticsBiomes.modLoc("mysticsbiomes/craft_sweet_strawberry_cake");
        } else if (isNeapolitanCake(item)) {
            advancement = MysticsBiomes.modLoc("mysticsbiomes/craft_neapolitan_cakes");
        } else if (isFrostedCake(item)) {
            advancement = MysticsBiomes.modLoc("mysticsbiomes/craft_frosted_cakes");
        }

        if (advancement != null) {
            Advancement holder = player.getServer().getAdvancements().getAdvancement(advancement);
            if (holder != null) {
                AdvancementProgress progress = player.getAdvancements().getOrStartProgress(holder);
                if (!progress.isDone()) {
                    MysticCriteriaTriggers.CRAFTED_ITEMS.trigger(player);
                }
            }
        }
    }

    private static boolean isNeapolitanCake(Item item) {
        return item == MysticItems.STRAWBERRY_CAKE.get()
                || item == MysticItems.VANILLA_CAKE.get()
                || item == MysticItems.CHOCOLATE_CAKE.get();
    }

    private static boolean isFrostedCake(Item item) {
        return item == MysticItems.PINK_FROSTED_CAKE.get()
                || item == MysticItems.ORANGE_FROSTED_CAKE.get()
                || item == MysticItems.YELLOW_FROSTED_CAKE.get()
                || item == MysticItems.LIME_FROSTED_CAKE.get()
                || item == MysticItems.CYAN_FROSTED_CAKE.get()
                || item == MysticItems.PURPLE_FROSTED_CAKE.get();
    }

}