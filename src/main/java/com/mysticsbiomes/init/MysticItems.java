package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.entity.vehicle.Boat;
import com.mysticsbiomes.common.item.BoatItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MysticItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MysticsBiomes.modId);

    public static final RegistryObject<Item> STRAWBERRY_BLOSSOMS = ITEMS.register("strawberry_blossoms", () -> new BlockItem(MysticBlocks.STRAWBERRY_BLOSSOMS.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRAWBERRY_SAPLING = ITEMS.register("strawberry_sapling", () -> new BlockItem(MysticBlocks.STRAWBERRY_SAPLING.get(), new Item.Properties()));

    public static final RegistryObject<Item> STRAWBERRY_LOG = ITEMS.register("strawberry_log", () -> new BlockItem(MysticBlocks.STRAWBERRY_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_STRAWBERRY_LOG = ITEMS.register("stripped_strawberry_log", () -> new BlockItem(MysticBlocks.STRIPPED_STRAWBERRY_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRAWBERRY_WOOD = ITEMS.register("strawberry_wood", () -> new BlockItem(MysticBlocks.STRAWBERRY_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_STRAWBERRY_WOOD = ITEMS.register("stripped_strawberry_wood", () -> new BlockItem(MysticBlocks.STRIPPED_STRAWBERRY_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRAWBERRY_PLANKS = ITEMS.register("strawberry_planks", () -> new BlockItem(MysticBlocks.STRAWBERRY_PLANKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRAWBERRY_STAIRS = ITEMS.register("strawberry_stairs", () -> new BlockItem(MysticBlocks.STRAWBERRY_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRAWBERRY_SLAB = ITEMS.register("strawberry_slab", () -> new BlockItem(MysticBlocks.STRAWBERRY_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRAWBERRY_FENCE = ITEMS.register("strawberry_fence", () -> new BlockItem(MysticBlocks.STRAWBERRY_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRAWBERRY_FENCE_GATE = ITEMS.register("strawberry_fence_gate", () -> new BlockItem(MysticBlocks.STRAWBERRY_FENCE_GATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRAWBERRY_BUTTON = ITEMS.register("strawberry_button", () -> new BlockItem(MysticBlocks.STRAWBERRY_BUTTON.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRAWBERRY_PRESSURE_PLATE = ITEMS.register("strawberry_pressure_plate", () -> new BlockItem(MysticBlocks.STRAWBERRY_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRAWBERRY_TRAPDOOR = ITEMS.register("strawberry_trapdoor", () -> new BlockItem(MysticBlocks.STRAWBERRY_TRAPDOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRAWBERRY_DOOR = ITEMS.register("strawberry_door", () -> new BlockItem(MysticBlocks.STRAWBERRY_DOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRAWBERRY_SIGN = ITEMS.register("strawberry_sign", () -> new SignItem((new Item.Properties()).stacksTo(16), MysticBlocks.STRAWBERRY_SIGN.get(), MysticBlocks.STRAWBERRY_WALL_SIGN.get()));
    public static final RegistryObject<Item> STRAWBERRY_HANGING_SIGN = ITEMS.register("strawberry_hanging_sign", () -> new HangingSignItem(MysticBlocks.STRAWBERRY_HANGING_SIGN.get(), MysticBlocks.STRAWBERRY_WALL_HANGING_SIGN.get(), (new Item.Properties()).stacksTo(16)));
    public static final RegistryObject<Item> STRAWBERRY_BOAT = ITEMS.register("strawberry_boat", () -> new BoatItem(false, Boat.Type.STRAWBERRY, (new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> STRAWBERRY_CHEST_BOAT = ITEMS.register("strawberry_chest_boat", () -> new BoatItem(true, Boat.Type.STRAWBERRY, (new Item.Properties()).stacksTo(1)));

    public static final RegistryObject<Item> PINK_CHERRY_BLOSSOMS = ITEMS.register("pink_cherry_blossoms", () -> new BlockItem(MysticBlocks.PINK_CHERRY_BLOSSOMS.get(), new Item.Properties()));
    public static final RegistryObject<Item> PINK_CHERRY_BLOSSOM_SAPLING = ITEMS.register("pink_cherry_blossom_sapling", () -> new BlockItem(MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING.get(), new Item.Properties()));
    public static final RegistryObject<Item> WHITE_CHERRY_BLOSSOMS = ITEMS.register("white_cherry_blossoms", () -> new BlockItem(MysticBlocks.WHITE_CHERRY_BLOSSOMS.get(), new Item.Properties()));
    public static final RegistryObject<Item> WHITE_CHERRY_BLOSSOM_SAPLING = ITEMS.register("white_cherry_blossom_sapling", () -> new BlockItem(MysticBlocks.WHITE_CHERRY_BLOSSOM_SAPLING.get(), new Item.Properties()));

    public static final RegistryObject<Item> CHERRY_LOG = ITEMS.register("cherry_log", () -> new BlockItem(MysticBlocks.CHERRY_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_CHERRY_LOG = ITEMS.register("stripped_cherry_log", () -> new BlockItem(MysticBlocks.STRIPPED_CHERRY_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHERRY_WOOD = ITEMS.register("cherry_wood", () -> new BlockItem(MysticBlocks.CHERRY_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_CHERRY_WOOD = ITEMS.register("stripped_cherry_wood", () -> new BlockItem(MysticBlocks.STRIPPED_CHERRY_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHERRY_PLANKS = ITEMS.register("cherry_planks", () -> new BlockItem(MysticBlocks.CHERRY_PLANKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHERRY_STAIRS = ITEMS.register("cherry_stairs", () -> new BlockItem(MysticBlocks.CHERRY_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHERRY_SLAB = ITEMS.register("cherry_slab", () -> new BlockItem(MysticBlocks.CHERRY_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHERRY_FENCE = ITEMS.register("cherry_fence", () -> new BlockItem(MysticBlocks.CHERRY_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHERRY_FENCE_GATE = ITEMS.register("cherry_fence_gate", () -> new BlockItem(MysticBlocks.CHERRY_FENCE_GATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHERRY_BUTTON = ITEMS.register("cherry_button", () -> new BlockItem(MysticBlocks.CHERRY_BUTTON.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHERRY_PRESSURE_PLATE = ITEMS.register("cherry_pressure_plate", () -> new BlockItem(MysticBlocks.CHERRY_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHERRY_TRAPDOOR = ITEMS.register("cherry_trapdoor", () -> new BlockItem(MysticBlocks.CHERRY_TRAPDOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHERRY_DOOR = ITEMS.register("cherry_door", () -> new BlockItem(MysticBlocks.CHERRY_DOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHERRY_SIGN = ITEMS.register("cherry_sign", () -> new SignItem((new Item.Properties()).stacksTo(16), MysticBlocks.CHERRY_SIGN.get(), MysticBlocks.CHERRY_WALL_SIGN.get()));
    public static final RegistryObject<Item> CHERRY_HANGING_SIGN = ITEMS.register("cherry_hanging_sign", () -> new HangingSignItem(MysticBlocks.CHERRY_HANGING_SIGN.get(), MysticBlocks.CHERRY_WALL_HANGING_SIGN.get(), (new Item.Properties()).stacksTo(16)));
    public static final RegistryObject<Item> CHERRY_BOAT = ITEMS.register("cherry_boat", () -> new BoatItem(false, Boat.Type.CHERRY, (new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> CHERRY_CHEST_BOAT = ITEMS.register("cherry_chest_boat", () -> new BoatItem(true, Boat.Type.CHERRY, (new Item.Properties()).stacksTo(1)));

    public static final RegistryObject<Item> JACARANDA_BLOSSOMS = ITEMS.register("jacaranda_blossoms", () -> new BlockItem(MysticBlocks.JACARANDA_BLOSSOMS.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_LEAVES = ITEMS.register("jacaranda_leaves", () -> new BlockItem(MysticBlocks.JACARANDA_LEAVES.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_SAPLING = ITEMS.register("jacaranda_sapling", () -> new BlockItem(MysticBlocks.JACARANDA_SAPLING.get(), new Item.Properties()));

    public static final RegistryObject<Item> JACARANDA_LOG = ITEMS.register("jacaranda_log", () -> new BlockItem(MysticBlocks.JACARANDA_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_JACARANDA_LOG = ITEMS.register("stripped_jacaranda_log", () -> new BlockItem(MysticBlocks.STRIPPED_JACARANDA_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_WOOD = ITEMS.register("jacaranda_wood", () -> new BlockItem(MysticBlocks.JACARANDA_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_JACARANDA_WOOD = ITEMS.register("stripped_jacaranda_wood", () -> new BlockItem(MysticBlocks.STRIPPED_JACARANDA_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_PLANKS = ITEMS.register("jacaranda_planks", () -> new BlockItem(MysticBlocks.JACARANDA_PLANKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_STAIRS = ITEMS.register("jacaranda_stairs", () -> new BlockItem(MysticBlocks.JACARANDA_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_SLAB = ITEMS.register("jacaranda_slab", () -> new BlockItem(MysticBlocks.JACARANDA_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_FENCE = ITEMS.register("jacaranda_fence", () -> new BlockItem(MysticBlocks.JACARANDA_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_FENCE_GATE = ITEMS.register("jacaranda_fence_gate", () -> new BlockItem(MysticBlocks.JACARANDA_FENCE_GATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_BUTTON = ITEMS.register("jacaranda_button", () -> new BlockItem(MysticBlocks.JACARANDA_BUTTON.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_PRESSURE_PLATE = ITEMS.register("jacaranda_pressure_plate", () -> new BlockItem(MysticBlocks.JACARANDA_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_TRAPDOOR = ITEMS.register("jacaranda_trapdoor", () -> new BlockItem(MysticBlocks.JACARANDA_TRAPDOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_DOOR = ITEMS.register("jacaranda_door", () -> new BlockItem(MysticBlocks.JACARANDA_DOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_SIGN = ITEMS.register("jacaranda_sign", () -> new SignItem((new Item.Properties()).stacksTo(16), MysticBlocks.JACARANDA_SIGN.get(), MysticBlocks.JACARANDA_WALL_SIGN.get()));
    public static final RegistryObject<Item> JACARANDA_HANGING_SIGN = ITEMS.register("jacaranda_hanging_sign", () -> new HangingSignItem(MysticBlocks.JACARANDA_HANGING_SIGN.get(), MysticBlocks.JACARANDA_WALL_HANGING_SIGN.get(), (new Item.Properties()).stacksTo(16)));
    public static final RegistryObject<Item> JACARANDA_BOAT = ITEMS.register("jacaranda_boat", () -> new BoatItem(false, Boat.Type.JACARANDA, (new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> JACARANDA_CHEST_BOAT = ITEMS.register("jacaranda_chest_boat", () -> new BoatItem(true, Boat.Type.JACARANDA, (new Item.Properties()).stacksTo(1)));

    public static final RegistryObject<Item> BUDDING_PEONY_LEAVES = ITEMS.register("budding_peony_leaves", () -> new BlockItem(MysticBlocks.BUDDING_PEONY_LEAVES.get(), new Item.Properties()));
    public static final RegistryObject<Item> PEONY_LEAVES = ITEMS.register("peony_leaves", () -> new BlockItem(MysticBlocks.PEONY_LEAVES.get(), new Item.Properties()));
    public static final RegistryObject<Item> PEONY_BUSH = ITEMS.register("peony_bush", () -> new BlockItem(MysticBlocks.PEONY_BUSH.get(), new Item.Properties()));

    public static final RegistryObject<Item> LAVENDER = ITEMS.register("lavender", () -> new BlockItem(MysticBlocks.LAVENDER.get(), new Item.Properties()));

    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry", () -> new ItemNameBlockItem(MysticBlocks.STRAWBERRY_BUSH.get(), (new Item.Properties().food(new FoodProperties.Builder().nutrition(2).fast().build()))));
    public static final RegistryObject<Item> SWEET_STRAWBERRY = ITEMS.register("sweet_strawberry", () -> new ItemNameBlockItem(MysticBlocks.STRAWBERRY_BUSH.get(), (new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(1.2F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F).build()))));
    public static final RegistryObject<Item> STRAWBERRY_CAKE = ITEMS.register("strawberry_cake", () -> new BlockItem(MysticBlocks.STRAWBERRY_CAKE.get(), (new Item.Properties()).stacksTo(1)));
    //public static final RegistryObject<Item> STRAWBERRY_ICE_CREAM = ITEMS.register("strawberry_ice_cream", () -> new SuspiciousStewItem((new Item.Properties()).stacksTo(1).food(Foods.SUSPICIOUS_STEW)));
    public static final RegistryObject<Item> STRAWBERRY_MILK_BUCKET = ITEMS.register("strawberry_milk_bucket", () -> new MilkBucketItem((new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> STRAWBERRY_COW_SPAWN_EGG = ITEMS.register("strawberry_cow_spawn_egg", () -> new ForgeSpawnEggItem(MysticEntities.STRAWBERRY_COW, 16758197, 15198183, new Item.Properties()));
    public static final RegistryObject<Item> RED_PANDA_SPAWN_EGG = ITEMS.register("red_panda_spawn_egg", () -> new ForgeSpawnEggItem(MysticEntities.RED_PANDA, 15170875, 9839122, new Item.Properties()));

}