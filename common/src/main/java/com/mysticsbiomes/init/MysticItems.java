package com.mysticsbiomes.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

import static com.mysticsbiomes.MysticsBiomes.REGISTRY;
import static com.mysticsbiomes.common.item.ItemTemplate.*;

public class MysticItems {

    public static Supplier<Item> STRAWBERRY_BLOSSOMS;
    public static Supplier<Item> STRAWBERRY_BLOSSOM_SAPLING;
    public static Supplier<Item> STRAWBERRY_LOG;
    public static Supplier<Item> STRIPPED_STRAWBERRY_LOG;
    public static Supplier<Item> STRAWBERRY_WOOD;
    public static Supplier<Item> STRIPPED_STRAWBERRY_WOOD;
    public static Supplier<Item> STRAWBERRY_PLANKS;
    public static Supplier<Item> STRAWBERRY_STAIRS;
    public static Supplier<Item> STRAWBERRY_SLAB;
    public static Supplier<Item> STRAWBERRY_FENCE;
    public static Supplier<Item> STRAWBERRY_FENCE_GATE;
    public static Supplier<Item> STRAWBERRY_BUTTON;
    public static Supplier<Item> STRAWBERRY_PRESSURE_PLATE;
    public static Supplier<Item> STRAWBERRY_TRAPDOOR;
    public static Supplier<Item> STRAWBERRY_DOOR;
    public static Supplier<Item> STRAWBERRY_SIGN;
    public static Supplier<Item> STRAWBERRY_HANGING_SIGN;
    ///public static Supplier<Item> STRAWBERRY_BOAT;
    ///public static Supplier<Item> STRAWBERRY_CHEST_BOAT;
    
    public static void registerItems() {
        STRAWBERRY_BLOSSOMS = register("strawberry_blossoms", () -> blockItem(MysticBlocks.STRAWBERRY_BLOSSOMS.get()));
        STRAWBERRY_BLOSSOM_SAPLING = register("strawberry_blossom_sapling", () -> blockItem(MysticBlocks.STRAWBERRY_BLOSSOM_SAPLING.get()));
        STRAWBERRY_LOG = register("strawberry_log", () -> blockItem(MysticBlocks.STRAWBERRY_LOG.get()));
        STRIPPED_STRAWBERRY_LOG = register("stripped_strawberry_log", () -> blockItem(MysticBlocks.STRIPPED_STRAWBERRY_LOG.get()));
        STRAWBERRY_WOOD = register("strawberry_wood", () -> blockItem(MysticBlocks.STRAWBERRY_WOOD.get()));
        STRIPPED_STRAWBERRY_WOOD = register("stripped_strawberry_wood", () -> blockItem(MysticBlocks.STRIPPED_STRAWBERRY_WOOD.get()));
        STRAWBERRY_PLANKS = register("strawberry_planks", () -> blockItem(MysticBlocks.STRAWBERRY_PLANKS.get()));
        STRAWBERRY_STAIRS = register("strawberry_stairs", () -> blockItem(MysticBlocks.STRAWBERRY_STAIRS.get()));
        STRAWBERRY_SLAB = register("strawberry_slab", () -> blockItem(MysticBlocks.STRAWBERRY_SLAB.get()));
        STRAWBERRY_FENCE = register("strawberry_fence", () -> blockItem(MysticBlocks.STRAWBERRY_FENCE.get()));
        STRAWBERRY_FENCE_GATE = register("strawberry_fence_gate", () -> blockItem(MysticBlocks.STRAWBERRY_FENCE_GATE.get()));
        STRAWBERRY_BUTTON = register("strawberry_button", () -> blockItem(MysticBlocks.STRAWBERRY_BUTTON.get()));
        STRAWBERRY_PRESSURE_PLATE = register("strawberry_pressure_plate", () -> blockItem(MysticBlocks.STRAWBERRY_PRESSURE_PLATE.get()));
        STRAWBERRY_TRAPDOOR = register("strawberry_trapdoor", () -> blockItem(MysticBlocks.STRAWBERRY_TRAPDOOR.get()));
        STRAWBERRY_DOOR = register("strawberry_door", () -> blockItem(MysticBlocks.STRAWBERRY_DOOR.get()));
        STRAWBERRY_SIGN = register("strawberry_sign", () -> signItem(MysticBlocks.STRAWBERRY_SIGN.get(), MysticBlocks.STRAWBERRY_WALL_SIGN.get()));
        STRAWBERRY_HANGING_SIGN = register("strawberry_hanging_sign", () -> hangingSignItem(MysticBlocks.STRAWBERRY_HANGING_SIGN.get(), MysticBlocks.STRAWBERRY_WALL_HANGING_SIGN.get()));
        ///STRAWBERRY_BOAT = register("strawberry_boat", () -> boatItem(MysticBoat.Type.STRAWBERRY));
        ///STRAWBERRY_CHEST_BOAT = register("strawberry_chest_boat", () -> chestBoatItem(MysticBoat.Type.STRAWBERRY));
    }

    private static Supplier<Item> register(String name, Supplier<Item> item) {
        return REGISTRY.register(BuiltInRegistries.ITEM, name, item);
    }

}