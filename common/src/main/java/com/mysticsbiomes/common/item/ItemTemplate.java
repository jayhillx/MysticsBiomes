package com.mysticsbiomes.common.item;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public interface ItemTemplate {

    static BlockItem blockItem(Block block) {
        return new BlockItem(block, new Item.Properties());
    }

    static Item signItem(Block sign, Block wallSign) {
        return new SignItem(new Item.Properties().stacksTo(16), sign, wallSign);
    }

    static Item hangingSignItem(Block sign, Block wallSign) {
        return new HangingSignItem(sign, wallSign, new Item.Properties().stacksTo(16));
    }

    ///static Item boatItem(MysticBoat.Type type) {
    ///    return new MysticBoatItem(false, type, new Item.Properties().stacksTo(1));
    ///}

    ///static Item chestBoatItem(MysticBoat.Type type) {
    ///    return new MysticBoatItem(true, type, new Item.Properties().stacksTo(1));
    ///}

    static Item spawnEggItem(Supplier<? extends EntityType<? extends Mob>> entity, int backgroundColor, int dotColor) {
        return new SpawnEggItem(entity.get(), backgroundColor, dotColor, new Item.Properties());
    }

}