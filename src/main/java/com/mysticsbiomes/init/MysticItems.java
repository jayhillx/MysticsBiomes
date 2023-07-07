package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MysticItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MysticsBiomes.modId);

    public static final RegistryObject<Item> STRAWBERRY_PLANKS = ITEMS.register("strawberry_planks", () -> new BlockItem(MysticBlocks.STRAWBERRY_PLANKS.get(), new Item.Properties()));

}