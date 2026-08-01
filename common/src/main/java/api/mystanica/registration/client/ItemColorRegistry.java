/*
 * Copyright (c) 2026, Mystanica
 *
 * All rights reserved.
 */
package api.mystanica.registration.client;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.level.ItemLike;

import java.util.function.BiConsumer;

public class ItemColorRegistry {
    private final BiConsumer<ItemColor, ItemLike[]> registry;

    public ItemColorRegistry(BiConsumer<ItemColor, ItemLike[]> registry) {
        this.registry = registry;
    }

    public void accept(ItemColor color, ItemLike... items) {
        this.registry.accept(color, items);
    }

}