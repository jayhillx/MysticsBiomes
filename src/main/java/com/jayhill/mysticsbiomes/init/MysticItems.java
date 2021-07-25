package com.jayhill.mysticsbiomes.init;

import com.jayhill.mysticsbiomes.MysticsBiomes;
import com.jayhill.mysticsbiomes.common.block.utils.BlockItemUtils;
import net.minecraft.entity.EntityType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MysticItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MysticsBiomes.MOD_ID);

    /** Strawberry Fields */
    private static final RegistryObject<Item> STRAWBERRY_BLOSSOM_LEAVES = ITEMS.register("strawberry_blossom_leaves", () -> new BlockItemUtils(MysticBlocks.STRAWBERRY_BLOSSOM_LEAVES.get()));
    private static final RegistryObject<Item> STRAWBERRY_BLOSSOM_SAPLING = ITEMS.register("strawberry_blossom_sapling", () -> new BlockItemUtils(MysticBlocks.STRAWBERRY_BLOSSOM_SAPLING.get()));
    private static final RegistryObject<Item> SWEET_BLOSSOM_LEAVES = ITEMS.register("sweet_blossom_leaves", () -> new BlockItemUtils(MysticBlocks.SWEET_BLOSSOM_LEAVES.get()));
    private static final RegistryObject<Item> SWEET_BLOSSOM_SAPLING = ITEMS.register("sweet_blossom_sapling", () -> new BlockItemUtils(MysticBlocks.SWEET_BLOSSOM_SAPLING.get()));
    private static final RegistryObject<Item> STRAWBERRY_PLANKS = ITEMS.register("strawberry_planks", () -> new BlockItemUtils(MysticBlocks.STRAWBERRY_PLANKS.get()));
    private static final RegistryObject<Item> STRAWBERRY_STAIRS = ITEMS.register("strawberry_stairs", () -> new BlockItemUtils(MysticBlocks.STRAWBERRY_STAIRS.get()));
    private static final RegistryObject<Item> STRAWBERRY_SLAB = ITEMS.register("strawberry_slab", () -> new BlockItemUtils(MysticBlocks.STRAWBERRY_SLAB.get()));
    private static final RegistryObject<Item> STRAWBERRY_FENCE = ITEMS.register("strawberry_fence", () -> new BlockItemUtils(MysticBlocks.STRAWBERRY_FENCE.get()));
    private static final RegistryObject<Item> STRAWBERRY_FENCE_GATE = ITEMS.register("strawberry_fence_gate", () -> new BlockItemUtils(MysticBlocks.STRAWBERRY_FENCE_GATE.get()));
    private static final RegistryObject<Item> STRAWBERRY_DOOR = ITEMS.register("strawberry_door", () -> new BlockItemUtils(MysticBlocks.STRAWBERRY_DOOR.get()));
    private static final RegistryObject<Item> STRAWBERRY_TRAPDOOR = ITEMS.register("strawberry_trapdoor", () -> new BlockItemUtils(MysticBlocks.STRAWBERRY_TRAPDOOR.get()));
    private static final RegistryObject<Item> STRIPPED_STRAWBERRY_LOG = ITEMS.register("stripped_strawberry_log", () -> new BlockItemUtils(MysticBlocks.STRIPPED_STRAWBERRY_LOG.get()));
    private static final RegistryObject<Item> STRIPPED_STRAWBERRY_WOOD = ITEMS.register("stripped_strawberry_wood", () -> new BlockItemUtils(MysticBlocks.STRIPPED_STRAWBERRY_WOOD.get()));
    private static final RegistryObject<Item> STRAWBERRY_LOG = ITEMS.register("strawberry_log", () -> new BlockItemUtils(MysticBlocks.STRAWBERRY_LOG.get()));
    private static final RegistryObject<Item> STRAWBERRY_WOOD = ITEMS.register("strawberry_wood", () -> new BlockItemUtils(MysticBlocks.STRAWBERRY_WOOD.get()));

    /** Food */
    public static final RegistryObject<Item> STRAWBERRY_MILK_BUCKET = ITEMS.register("strawberry_milk_bucket", () -> new MilkBucketItem((new Item.Properties()).maxStackSize(1).group(MysticsBiomes.TAB)));
    public static final RegistryObject<Item> STRAWBERRY_CAKE = ITEMS.register("strawberry_cake", () -> new BlockItem(MysticBlocks.STRAWBERRY_CAKE.get(), (new Item.Properties()).maxStackSize(1).group(MysticsBiomes.TAB)));
    public static final RegistryObject<Item> STRAWBERRIES = ITEMS.register("strawberries", () -> new BlockNamedItem(MysticBlocks.STRAWBERRY_BUSH.get(), (new Item.Properties()).group(MysticsBiomes.TAB).food(MysticFoods.STRAWBERRIES)));
    public static final RegistryObject<Item> SWEET_STRAWBERRIES = ITEMS.register("sweet_strawberries", () -> new Item((new Item.Properties()).group(MysticsBiomes.TAB).food(MysticFoods.SWEET_STRAWBERRIES)));

    public static final RegistryObject<Item> STRAWBERRY_COW_SPAWN_EGG = ITEMS.register("strawberry_cow_spawn_egg", () -> new SpawnEggItem(MysticEntities.STRAWBERRY_COW.get(), 4470310, 10592673, (new Item.Properties()).group(MysticsBiomes.TAB)));

    /** Food in Items class for simplicity :) */
    private static class MysticFoods {
        public static final Food STRAWBERRIES = (new Food.Builder()).hunger(4).saturation(0.3F).build();
        public static final Food SWEET_STRAWBERRIES = (new Food.Builder()).hunger(6).saturation(0.8F).build();
    }

}