package com.meepshadow.mysticsbiomes.core.registry;

import com.meepshadow.mysticsbiomes.common.block.BlockItemBase;
import com.meepshadow.mysticsbiomes.common.block.ModSpawnEgg;
import com.meepshadow.mysticsbiomes.core.MysticsBiomes;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MysticsBiomes.MOD_ID);

    public static final RegistryObject<Item> ETHEREAL_LEAVES = ITEMS.register("ethereal_leaves", () -> new BlockItemBase(ModBlocks.ETHEREAL_LEAVES.get()));
    public static final RegistryObject<Item> LAVENDER_BLOSSOM_LEAVES = ITEMS.register("lavender_blossom_leaves", () -> new BlockItemBase(ModBlocks.LAVENDER_BLOSSOM_LEAVES.get()));
    public static final RegistryObject<Item> SWEET_BLOSSOM_LEAVES = ITEMS.register("sweet_blossom_leaves", () -> new BlockItemBase(ModBlocks.SWEET_BLOSSOM_LEAVES.get()));
    public static final RegistryObject<Item> STRAWBERRY_BLOSSOM_LEAVES = ITEMS.register("strawberry_blossom_leaves", () -> new BlockItemBase(ModBlocks.STRAWBERRY_BLOSSOM_LEAVES.get()));

    public static final RegistryObject<Item> ETHEREAL_LOG = ITEMS.register("ethereal_log", () -> new BlockItemBase(ModBlocks.ETHEREAL_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_ETHEREAL_LOG = ITEMS.register("stripped_ethereal_log", () -> new BlockItemBase(ModBlocks.STRIPPED_ETHEREAL_LOG.get()));
    public static final RegistryObject<Item> ETHEREAL_WOOD = ITEMS.register("ethereal_wood", () -> new BlockItemBase(ModBlocks.ETHEREAL_WOOD.get()));
    public static final RegistryObject<Item> STRIPPED_ETHEREAL_WOOD = ITEMS.register("stripped_ethereal_wood", () -> new BlockItemBase(ModBlocks.STRIPPED_ETHEREAL_WOOD.get()));
    public static final RegistryObject<Item> ETHEREAL_PLANKS = ITEMS.register("ethereal_planks", () -> new BlockItemBase(ModBlocks.ETHEREAL_PLANKS.get()));
    public static final RegistryObject<Item> VERTICAL_ETHEREAL_PLANKS = ITEMS.register("vertical_ethereal_planks", () -> new BlockItemBase(ModBlocks.VERTICAL_ETHEREAL_PLANKS.get()));
    public static final RegistryObject<Item> ETHEREAL_SLAB = ITEMS.register("ethereal_slab", () -> new BlockItemBase(ModBlocks.ETHEREAL_SLAB.get()));
    public static final RegistryObject<Item> ETHEREAL_VERTICAL_SLAB = ITEMS.register("ethereal_vertical_slab", () -> new BlockItemBase(ModBlocks.ETHEREAL_VERTICAL_SLAB.get()));
    public static final RegistryObject<Item> ETHEREAL_STAIRS = ITEMS.register("ethereal_stairs", () -> new BlockItemBase(ModBlocks.ETHEREAL_STAIRS.get()));
    public static final RegistryObject<Item> ETHEREAL_FENCE = ITEMS.register("ethereal_fence", () -> new BlockItemBase(ModBlocks.ETHEREAL_FENCE.get()));
    public static final RegistryObject<Item> ETHEREAL_FENCE_GATE = ITEMS.register("ethereal_fence_gate", () -> new BlockItemBase(ModBlocks.ETHEREAL_FENCE_GATE.get()));
    public static final RegistryObject<Item> ETHEREAL_DOOR = ITEMS.register("ethereal_door", () -> new BlockItemBase(ModBlocks.ETHEREAL_DOOR.get()));
    public static final RegistryObject<Item> ETHEREAL_TRAPDOOR = ITEMS.register("ethereal_trapdoor", () -> new BlockItemBase(ModBlocks.ETHEREAL_TRAPDOOR.get()));

    public static final RegistryObject<Item> LAVENDER_LOG = ITEMS.register("lavender_log", () -> new BlockItemBase(ModBlocks.LAVENDER_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_LAVENDER_LOG = ITEMS.register("stripped_lavender_log", () -> new BlockItemBase(ModBlocks.STRIPPED_LAVENDER_LOG.get()));
    public static final RegistryObject<Item> LAVENDER_WOOD = ITEMS.register("lavender_wood", () -> new BlockItemBase(ModBlocks.LAVENDER_WOOD.get()));
    public static final RegistryObject<Item> STRIPPED_LAVENDER_WOOD = ITEMS.register("stripped_lavender_wood", () -> new BlockItemBase(ModBlocks.STRIPPED_LAVENDER_WOOD.get()));
    public static final RegistryObject<Item> LAVENDER_PLANKS = ITEMS.register("lavender_planks", () -> new BlockItemBase(ModBlocks.LAVENDER_PLANKS.get()));
    public static final RegistryObject<Item> VERTICAL_LAVENDER_PLANKS = ITEMS.register("vertical_lavender_planks", () -> new BlockItemBase(ModBlocks.VERTICAL_LAVENDER_PLANKS.get()));
    public static final RegistryObject<Item> LAVENDER_SLAB = ITEMS.register("lavender_slab", () -> new BlockItemBase(ModBlocks.LAVENDER_SLAB.get()));
    public static final RegistryObject<Item> LAVENDER_VERTICAL_SLAB = ITEMS.register("lavender_vertical_slab", () -> new BlockItemBase(ModBlocks.LAVENDER_VERTICAL_SLAB.get()));
    public static final RegistryObject<Item> LAVENDER_STAIRS = ITEMS.register("lavender_stairs", () -> new BlockItemBase(ModBlocks.LAVENDER_STAIRS.get()));
    public static final RegistryObject<Item> LAVENDER_FENCE = ITEMS.register("lavender_fence", () -> new BlockItemBase(ModBlocks.LAVENDER_FENCE.get()));
    public static final RegistryObject<Item> LAVENDER_FENCE_GATE = ITEMS.register("lavender_fence_gate", () -> new BlockItemBase(ModBlocks.LAVENDER_FENCE_GATE.get()));
    public static final RegistryObject<Item> LAVENDER_DOOR = ITEMS.register("lavender_door", () -> new BlockItemBase(ModBlocks.LAVENDER_DOOR.get()));
    public static final RegistryObject<Item> LAVENDER_TRAPDOOR = ITEMS.register("lavender_trapdoor", () -> new BlockItemBase(ModBlocks.LAVENDER_TRAPDOOR.get()));

    public static final RegistryObject<Item> STRAWBERRRY_LOG = ITEMS.register("strawberrry_log", () -> new BlockItemBase(ModBlocks.STRAWBERRRY_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_STRAWBERRY_LOG = ITEMS.register("stripped_strawberry_log", () -> new BlockItemBase(ModBlocks.STRIPPED_STRAWBERRY_LOG.get()));
    public static final RegistryObject<Item> STRAWBERRY_WOOD = ITEMS.register("strawberry_wood", () -> new BlockItemBase(ModBlocks.STRAWBERRY_WOOD.get()));
    public static final RegistryObject<Item> STRIPPED_STRAWBERRY_WOOD = ITEMS.register("stripped_strawberry_wood", () -> new BlockItemBase(ModBlocks.STRIPPED_STRAWBERRY_WOOD.get()));
    public static final RegistryObject<Item> STRAWBERRY_PLANKS = ITEMS.register("strawberry_planks", () -> new BlockItemBase(ModBlocks.STRAWBERRY_PLANKS.get()));
    public static final RegistryObject<Item> VERTICAL_STRAWBERRY_PLANKS = ITEMS.register("vertical_strawberry_planks", () -> new BlockItemBase(ModBlocks.VERTICAL_STRAWBERRY_PLANKS.get()));
    public static final RegistryObject<Item> STRAWBERRY_SLAB = ITEMS.register("strawberry_slab", () -> new BlockItemBase(ModBlocks.STRAWBERRY_SLAB.get()));
    public static final RegistryObject<Item> STRAWBERRY_VERTICAL_SLAB = ITEMS.register("strawberry_vertical_slab", () -> new BlockItemBase(ModBlocks.STRAWBERRY_VERTICAL_SLAB.get()));
    public static final RegistryObject<Item> STRAWBERRY_STAIRS = ITEMS.register("strawberry_stairs", () -> new BlockItemBase(ModBlocks.STRAWBERRY_STAIRS.get()));
    public static final RegistryObject<Item> STRAWBERRY_FENCE = ITEMS.register("strawberry_fence", () -> new BlockItemBase(ModBlocks.STRAWBERRY_FENCE.get()));
    public static final RegistryObject<Item> STRAWBERRY_FENCE_GATE = ITEMS.register("strawberry_fence_gate", () -> new BlockItemBase(ModBlocks.STRAWBERRY_FENCE_GATE.get()));
    public static final RegistryObject<Item> STRAWBERRY_DOOR = ITEMS.register("strawberry_door", () -> new BlockItemBase(ModBlocks.STRAWBERRY_DOOR.get()));
    public static final RegistryObject<Item> STRAWBERRY_TRAPDOOR = ITEMS.register("strawberry_trapdoor", () -> new BlockItemBase(ModBlocks.STRAWBERRY_TRAPDOOR.get()));

    public static final RegistryObject<Item> ORB_MUSHROOM_BLOCK = ITEMS.register("orb_mushroom_block", () -> new BlockItemBase(ModBlocks.ORB_MUSHROOM_BLOCK.get()));

    public static final RegistryObject<Item> STRAWBERRY_FLOWER = ITEMS.register("strawberry_flower", () -> new BlockItemBase(ModBlocks.STRAWBERRY_FLOWER.get()));
    public static final RegistryObject<Item> LAVENDER = ITEMS.register("lavender", () -> new BlockItemBase(ModBlocks.LAVENDER.get()));
    public static final RegistryObject<Item> WHITE_DAISY_BUSH = ITEMS.register("white_daisy_bush", () -> new BlockItemBase(ModBlocks.WHITE_DAISY_BUSH.get()));
    public static final RegistryObject<Item> PINK_DAISY_BUSH = ITEMS.register("pink_daisy_bush", () -> new BlockItemBase(ModBlocks.PINK_DAISY_BUSH.get()));
    public static final RegistryObject<Item> ORB_MUSHROOM = ITEMS.register("orb_mushroom", () -> new BlockItemBase(ModBlocks.ORB_MUSHROOM.get()));

    public static final RegistryObject<Item> STRAWBERRIES = ITEMS.register("strawberries", () -> new BlockNamedItem(ModBlocks.STRAWBERRY_BUSH.get(), (new Item.Properties()).food(ModFoods.STRAWBERRIES).group(MysticsBiomes.TAB)));
    public static final RegistryObject<Item> STRAWBERRY_MILK_BUCKET = ITEMS.register("strawberry_milk_bucket", () -> new MilkBucketItem((new Item.Properties()).containerItem(Items.BUCKET).maxStackSize(1).group(MysticsBiomes.TAB)));
    public static final RegistryObject<Item> STRAWBERRY_CAKE = ITEMS.register("strawberry_cake", (() -> new BlockItem(ModBlocks.STRAWBERRY_CAKE.get(), (new Item.Properties()).maxStackSize(1).group(MysticsBiomes.TAB))));

    public static final RegistryObject<Item> STRAWBERRY_COW_SPAWN_EGG = ITEMS.register("strawberry_cow_spawn_egg", () -> new ModSpawnEgg(ModEntities.STRAWBERRY_COW, 0xE088A7, 0xFEACC9, new Item.Properties().group(MysticsBiomes.TAB)));

    public static final RegistryObject<Item> ETHEREAL_SAPLING = ITEMS.register("ethereal_sapling", () -> new BlockItemBase(ModBlocks.ETHEREAL_SAPLING.get()));
    public static final RegistryObject<Item> LAVENDER_BLOSSOM_SAPLING = ITEMS.register("lavender_blossom_sapling", () -> new BlockItemBase(ModBlocks.LAVENDER_BLOSSOM_SAPLING.get()));
    public static final RegistryObject<Item> SWEET_BLOSSOM_SAPLING = ITEMS.register("sweet_blossom_sapling", () -> new BlockItemBase(ModBlocks.SWEET_BLOSSOM_SAPLING.get()));
    public static final RegistryObject<Item> STRAWBERRY_BLOSSOM_SAPLING = ITEMS.register("strawberry_blossom_sapling", () -> new BlockItemBase(ModBlocks.STRAWBERRY_BLOSSOM_SAPLING.get()));

    public static final RegistryObject<Item> ETHEREAL_LEAF_CARPET = ITEMS.register("ethereal_leaf_carpet", () -> new BlockItemBase(ModBlocks.ETHEREAL_LEAF_CARPET.get()));
    public static final RegistryObject<Item> LAVENDER_BLOSSOM_LEAF_CARPET = ITEMS.register("lavender_blossom_leaf_carpet", () -> new BlockItemBase(ModBlocks.LAVENDER_BLOSSOM_LEAF_CARPET.get()));
    public static final RegistryObject<Item> SWEET_BLOSSOM_LEAF_CARPET = ITEMS.register("sweet_blossom_leaf_carpet", () -> new BlockItemBase(ModBlocks.SWEET_BLOSSOM_LEAF_CARPET.get()));
    public static final RegistryObject<Item> STRAWBERRY_BLOSSOM_LEAF_CARPET = ITEMS.register("strawberry_blossom_leaf_carpet", () -> new BlockItemBase(ModBlocks.STRAWBERRY_BLOSSOM_LEAF_CARPET.get()));

    public static final RegistryObject<Item> MB_ICON = ITEMS.register("icon", () -> new Item(new Item.Properties()));
}
