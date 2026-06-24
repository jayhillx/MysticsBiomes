package com.mysticsbiomes.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

import static com.mysticsbiomes.MysticsBiomes.REGISTRY;

public class MysticItems {

    public static Supplier<Item> STRAWBERRY_PLANKS;

    public static void registerItems() {
        STRAWBERRY_PLANKS = register("strawberry_planks", () -> new BlockItem(MysticBlocks.STRAWBERRY_PLANKS.get(), new Item.Properties()));
    }

    private static Supplier<Item> register(String name, Supplier<Item> item) {
        return REGISTRY.register(BuiltInRegistries.ITEM, name, item);
    }

}