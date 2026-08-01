package com.mysticsbiomes.common.item;

import com.mysticsbiomes.common.entity.vehicle.MysticBoat;
import api.mystanica.registry.RegistryEntry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;

public interface ItemTemplate {

    static Item blockItem(RegistryEntry<Block> block) {
        return new MysticBlockItem(block, new Item.Properties());
    }

    static Item itemBlockItem(RegistryEntry<Block> block, Item.Properties properties) {
        return new MysticItemBlockItem(block, properties);
    }

    static Item signItem(RegistryEntry<Block> signBlock, RegistryEntry<Block> wallSignBlock) {
        return new SignItem(new Item.Properties().stacksTo(16), signBlock.get(), wallSignBlock.get());
    }

    static Item hangingSignItem(RegistryEntry<Block> signBlock, RegistryEntry<Block> wallSignBlock) {
        return new HangingSignItem(signBlock.get(), wallSignBlock.get(), new Item.Properties().stacksTo(16));
    }

    static Item boatItem(MysticBoat.Type type) {
        return new MysticBoatItem(false, type, new Item.Properties().stacksTo(1));
    }

    static Item chestBoatItem(MysticBoat.Type type) {
        return new MysticBoatItem(true, type, new Item.Properties().stacksTo(1));
    }

    static Item cakeItem(RegistryEntry<Block> block) {
        return new MysticItemBlockItem(block, new Item.Properties().stacksTo(1));
    }

    static Item spawnEggItem(RegistryEntry<? extends EntityType<? extends Mob>> entity, int backgroundColor, int dotColor) {
        return new MysticSpawnEggItem(entity, backgroundColor, dotColor, new Item.Properties());
    }

}