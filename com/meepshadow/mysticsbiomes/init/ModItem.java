package com.meepshadow.mysticsbiomes.init;

import com.meepshadow.mysticsbiomes.core.MysticsBiomes;
import com.meepshadow.mysticsbiomes.common.block.BlockItemBase;
import com.meepshadow.mysticsbiomes.common.item.ItemBase;
import com.meepshadow.mysticsbiomes.common.item.armor.ModArmorMaterial;
import com.meepshadow.mysticsbiomes.common.item.tools.ModItemTier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItem {

    @SuppressWarnings("deprecation")
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MysticsBiomes.MOD_ID);

    // Block Items
    public static final RegistryObject<Item> STRAWBERRY_BLOSSOMS = ITEMS.register("strawberry_blossoms", () -> new BlockItemBase(ModBlock.STRAWBERRY_BLOSSOMS.get()));
    public static final RegistryObject<Item> SWEET_BLOSSOMS = ITEMS.register("sweet_blossoms", () -> new BlockItemBase(ModBlock.SWEET_BLOSSOMS.get()));
    public static final RegistryObject<Item> LAVENDER_BLOSSOMS = ITEMS.register("lavender_blossoms", () -> new BlockItemBase(ModBlock.LAVENDER_BLOSSOMS.get()));
    public static final RegistryObject<Item> WISP_BLOSSOMS = ITEMS.register("wisp_blossoms", () -> new BlockItemBase(ModBlock.WISP_BLOSSOMS.get()));
    public static final RegistryObject<Item> FROSTED_LEAVES = ITEMS.register("frosted_leaves", () -> new BlockItemBase(ModBlock.FROSTED_LEAVES.get()));
    public static final RegistryObject<Item> TROPICAL_LEAVES = ITEMS.register("tropical_leaves", () -> new BlockItemBase(ModBlock.TROPICAL_LEAVES.get()));
    public static final RegistryObject<Item> SEAFOAM_LEAVES = ITEMS.register("seafoam_leaves", () -> new BlockItemBase(ModBlock.SEAFOAM_LEAVES.get()));
    public static final RegistryObject<Item> EVERGREEN_LEAVES = ITEMS.register("evergreen_leaves", () -> new BlockItemBase(ModBlock.EVERGREEN_LEAVES.get()));
    public static final RegistryObject<Item> DANDELION_LEAVES = ITEMS.register("dandelion_leaves", () -> new BlockItemBase(ModBlock.DANDELION_LEAVES.get()));

    public static final RegistryObject<Item> STRAWBERRY_BLOSSOM_SAPLING = ITEMS.register("strawberry_blossom_sapling", () -> new BlockItemBase(ModBlock.STRAWBERRY_BLOSSOM_SAPLING.get()));
    public static final RegistryObject<Item> SWEET_BLOSSOM_SAPLING = ITEMS.register("sweet_blossom_sapling", () -> new BlockItemBase(ModBlock.SWEET_BLOSSOM_SAPLING.get()));
    public static final RegistryObject<Item> LAVENDER_BLOSSOM_SAPLING = ITEMS.register("lavender_blossom_sapling", () -> new BlockItemBase(ModBlock.LAVENDER_BLOSSOM_SAPLING.get()));
    public static final RegistryObject<Item> WISP_BLOSSOM_SAPLING = ITEMS.register("wisp_blossom_sapling", () -> new BlockItemBase(ModBlock.WISP_BLOSSOM_SAPLING.get()));
    public static final RegistryObject<Item> FROSTED_SAPLING = ITEMS.register("frosted_sapling", () -> new BlockItemBase(ModBlock.FROSTED_SAPLING.get()));
    public static final RegistryObject<Item> TROPICAL_SAPLING = ITEMS.register("tropical_sapling", () -> new BlockItemBase(ModBlock.TROPICAL_SAPLING.get()));
    public static final RegistryObject<Item> SEAFOAM_SAPLING = ITEMS.register("seafoam_sapling", () -> new BlockItemBase(ModBlock.SEAFOAM_SAPLING.get()));
    public static final RegistryObject<Item> EVERGREEN_SAPLING = ITEMS.register("evergreen_sapling", () -> new BlockItemBase(ModBlock.EVERGREEN_SAPLING.get()));
    public static final RegistryObject<Item> DANDELION_SAPLING = ITEMS.register("dandelion_sapling", () -> new BlockItemBase(ModBlock.DANDELION_SAPLING.get()));

    public static final RegistryObject<Item> STRAWBERRRY_LOG = ITEMS.register("strawberrry_log", () -> new BlockItemBase(ModBlock.STRAWBERRRY_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_STRAWBERRY_LOG = ITEMS.register("stripped_strawberry_log", () -> new BlockItemBase(ModBlock.STRIPPED_STRAWBERRY_LOG.get()));
    public static final RegistryObject<Item> STRAWBERRY_PLANKS = ITEMS.register("strawberry_planks", () -> new BlockItemBase(ModBlock.STRAWBERRY_PLANKS.get()));
    public static final RegistryObject<Item> STRAWBERRY_STAIRS = ITEMS.register("strawberry_stairs", () -> new BlockItemBase(ModBlock.STRAWBERRY_STAIRS.get()));
    public static final RegistryObject<Item> STRAWBERRY_SLAB = ITEMS.register("strawberry_slab", () -> new BlockItemBase(ModBlock.STRAWBERRY_SLAB.get()));
    public static final RegistryObject<Item> STRAWBERRY_FENCE = ITEMS.register("strawberry_fence", () -> new BlockItemBase(ModBlock.STRAWBERRY_FENCE.get()));
    public static final RegistryObject<Item> STRAWBERRY_FENCE_GATE = ITEMS.register("strawberry_fence_gate", () -> new BlockItemBase(ModBlock.STRAWBERRY_FENCE_GATE.get()));
    public static final RegistryObject<Item> STRAWBERRY_DOOR = ITEMS.register("strawberry_door", () -> new TallBlockItem(ModBlock.STRAWBERRY_DOOR.get(), (new Item.Properties()).group(MysticsBiomes.TAB)));
    public static final RegistryObject<Item> STRAWBERRY_TRAPDOOR = ITEMS.register("strawberry_trapdoor", () -> new BlockItem(ModBlock.STRAWBERRY_TRAPDOOR.get(), (new Item.Properties()).group(MysticsBiomes.TAB)));

    public static final RegistryObject<Item> SWEET_LOG = ITEMS.register("sweet_log", () -> new BlockItemBase(ModBlock.SWEET_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_SWEET_LOG = ITEMS.register("stripped_sweet_log", () -> new BlockItemBase(ModBlock.STRIPPED_SWEET_LOG.get()));
    public static final RegistryObject<Item> SWEET_PLANKS = ITEMS.register("sweet_planks", () -> new BlockItemBase(ModBlock.SWEET_PLANKS.get()));
    public static final RegistryObject<Item> SWEET_STAIRS = ITEMS.register("sweet_stairs", () -> new BlockItemBase(ModBlock.SWEET_STAIRS.get()));
    public static final RegistryObject<Item> SWEET_SLAB = ITEMS.register("sweet_slab", () -> new BlockItemBase(ModBlock.SWEET_SLAB.get()));
    public static final RegistryObject<Item> SWEET_FENCE = ITEMS.register("sweet_fence", () -> new BlockItemBase(ModBlock.SWEET_FENCE.get()));
    public static final RegistryObject<Item> SWEET_FENCE_GATE = ITEMS.register("sweet_fence_gate", () -> new BlockItemBase(ModBlock.SWEET_FENCE_GATE.get()));
    public static final RegistryObject<Item> SWEET_DOOR = ITEMS.register("sweet_door", () -> new TallBlockItem(ModBlock.SWEET_DOOR.get(), (new Item.Properties()).group(MysticsBiomes.TAB)));
    public static final RegistryObject<Item> SWEET_TRAPDOOR = ITEMS.register("sweet_trapdoor", () -> new BlockItem(ModBlock.SWEET_TRAPDOOR.get(), (new Item.Properties()).group(MysticsBiomes.TAB)));

    public static final RegistryObject<Item> LAVENDER_LOG = ITEMS.register("lavender_log", () -> new BlockItemBase(ModBlock.LAVENDER_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_LAVENDER_LOG = ITEMS.register("stripped_lavender_log", () -> new BlockItemBase(ModBlock.STRIPPED_LAVENDER_LOG.get()));
    public static final RegistryObject<Item> LAVENDER_PLANKS = ITEMS.register("lavender_planks", () -> new BlockItemBase(ModBlock.LAVENDER_PLANKS.get()));
    public static final RegistryObject<Item> LAVENDER_STAIRS = ITEMS.register("lavender_stairs", () -> new BlockItemBase(ModBlock.LAVENDER_STAIRS.get()));
    public static final RegistryObject<Item> LAVENDER_SLAB = ITEMS.register("lavender_slab", () -> new BlockItemBase(ModBlock.LAVENDER_SLAB.get()));
    public static final RegistryObject<Item> LAVENDER_FENCE = ITEMS.register("lavender_fence", () -> new BlockItemBase(ModBlock.LAVENDER_FENCE.get()));
    public static final RegistryObject<Item> LAVENDER_FENCE_GATE = ITEMS.register("lavender_fence_gate", () -> new BlockItemBase(ModBlock.LAVENDER_FENCE_GATE.get()));
    public static final RegistryObject<Item> LAVENDER_DOOR = ITEMS.register("lavender_door", () -> new TallBlockItem(ModBlock.LAVENDER_DOOR.get(), (new Item.Properties()).group(MysticsBiomes.TAB)));
    public static final RegistryObject<Item> LAVENDER_TRAPDOOR = ITEMS.register("lavender_trapdoor", () -> new BlockItem(ModBlock.LAVENDER_TRAPDOOR.get(), (new Item.Properties()).group(MysticsBiomes.TAB)));

    public static final RegistryObject<Item> WISP_LOG = ITEMS.register("wisp_log", () -> new BlockItemBase(ModBlock.WISP_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_WISP_LOG = ITEMS.register("stripped_wisp_log", () -> new BlockItemBase(ModBlock.STRIPPED_WISP_LOG.get()));
    public static final RegistryObject<Item> WISP_PLANKS = ITEMS.register("wisp_planks", () -> new BlockItemBase(ModBlock.WISP_PLANKS.get()));
    public static final RegistryObject<Item> WISP_STAIRS = ITEMS.register("wisp_stairs", () -> new BlockItemBase(ModBlock.WISP_STAIRS.get()));
    public static final RegistryObject<Item> WISP_SLAB = ITEMS.register("wisp_slab", () -> new BlockItemBase(ModBlock.WISP_SLAB.get()));
    public static final RegistryObject<Item> WISP_FENCE = ITEMS.register("wisp_fence", () -> new BlockItemBase(ModBlock.WISP_FENCE.get()));
    public static final RegistryObject<Item> WISP_FENCE_GATE = ITEMS.register("wisp_fence_gate", () -> new BlockItemBase(ModBlock.WISP_FENCE_GATE.get()));
    public static final RegistryObject<Item> WISP_DOOR = ITEMS.register("wisp_door", () -> new TallBlockItem(ModBlock.WISP_DOOR.get(), (new Item.Properties()).group(MysticsBiomes.TAB)));
    public static final RegistryObject<Item> WISP_TRAPDOOR = ITEMS.register("wisp_trapdoor", () -> new BlockItem(ModBlock.WISP_TRAPDOOR.get(), (new Item.Properties()).group(MysticsBiomes.TAB)));

    public static final RegistryObject<Item> FROSTED_LOG = ITEMS.register("frosted_log", () -> new BlockItemBase(ModBlock.FROSTED_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_FROSTED_LOG = ITEMS.register("stripped_frosted_log", () -> new BlockItemBase(ModBlock.STRIPPED_FROSTED_LOG.get()));
    public static final RegistryObject<Item> FROSTED_PLANKS = ITEMS.register("frosted_planks", () -> new BlockItemBase(ModBlock.FROSTED_PLANKS.get()));
    public static final RegistryObject<Item> FROSTED_STAIRS = ITEMS.register("frosted_stairs", () -> new BlockItemBase(ModBlock.FROSTED_STAIRS.get()));
    public static final RegistryObject<Item> FROSTED_SLAB = ITEMS.register("frosted_slab", () -> new BlockItemBase(ModBlock.FROSTED_SLAB.get()));
    public static final RegistryObject<Item> FROSTED_FENCE = ITEMS.register("frosted_fence", () -> new BlockItemBase(ModBlock.FROSTED_FENCE.get()));
    public static final RegistryObject<Item> FROSTED_FENCE_GATE = ITEMS.register("frosted_fence_gate", () -> new BlockItemBase(ModBlock.FROSTED_FENCE_GATE.get()));
    public static final RegistryObject<Item> FROSTED_DOOR = ITEMS.register("frosted_door", () -> new TallBlockItem(ModBlock.FROSTED_DOOR.get(), (new Item.Properties()).group(MysticsBiomes.TAB)));
    public static final RegistryObject<Item> FROSTED_TRAPDOOR = ITEMS.register("frosted_trapdoor", () -> new BlockItem(ModBlock.FROSTED_TRAPDOOR.get(), (new Item.Properties()).group(MysticsBiomes.TAB)));

    public static final RegistryObject<Item> TROPICAL_LOG = ITEMS.register("tropical_log", () -> new BlockItemBase(ModBlock.TROPICAL_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_TROPICAL_LOG = ITEMS.register("stripped_tropical_log", () -> new BlockItemBase(ModBlock.STRIPPED_TROPICAL_LOG.get()));
    public static final RegistryObject<Item> TROPICAL_PLANKS = ITEMS.register("tropical_planks", () -> new BlockItemBase(ModBlock.TROPICAL_PLANKS.get()));
    public static final RegistryObject<Item> TROPICAL_STAIRS = ITEMS.register("tropical_stairs", () -> new BlockItemBase(ModBlock.TROPICAL_STAIRS.get()));
    public static final RegistryObject<Item> TROPICAL_SLAB = ITEMS.register("tropical_slab", () -> new BlockItemBase(ModBlock.TROPICAL_SLAB.get()));
    public static final RegistryObject<Item> TROPICAL_FENCE = ITEMS.register("tropical_fence", () -> new BlockItemBase(ModBlock.TROPICAL_FENCE.get()));
    public static final RegistryObject<Item> TROPICAL_FENCE_GATE = ITEMS.register("tropical_fence_gate", () -> new BlockItemBase(ModBlock.TROPICAL_FENCE_GATE.get()));
    public static final RegistryObject<Item> TROPICAL_DOOR = ITEMS.register("tropical_door", () -> new TallBlockItem(ModBlock.TROPICAL_DOOR.get(), (new Item.Properties()).group(MysticsBiomes.TAB)));
    public static final RegistryObject<Item> TROPICAL_TRAPDOOR = ITEMS.register("tropical_trapdoor", () -> new BlockItem(ModBlock.TROPICAL_TRAPDOOR.get(), (new Item.Properties()).group(MysticsBiomes.TAB)));

    public static final RegistryObject<Item> SEAFOAM_LOG = ITEMS.register("seafoam_log", () -> new BlockItemBase(ModBlock.SEAFOAM_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_SEAFOAM_LOG = ITEMS.register("stripped_seafoam_log", () -> new BlockItemBase(ModBlock.STRIPPED_SEAFOAM_LOG.get()));
    public static final RegistryObject<Item> SEAFOAM_PLANKS = ITEMS.register("seafoam_planks", () -> new BlockItemBase(ModBlock.SEAFOAM_PLANKS.get()));
    public static final RegistryObject<Item> SEAFOAM_STAIRS = ITEMS.register("seafoam_stairs", () -> new BlockItemBase(ModBlock.SEAFOAM_STAIRS.get()));
    public static final RegistryObject<Item> SEAFOAM_SLAB = ITEMS.register("seafoam_slab", () -> new BlockItemBase(ModBlock.SEAFOAM_SLAB.get()));
    public static final RegistryObject<Item> SEAFOAM_FENCE = ITEMS.register("seafoam_fence", () -> new BlockItemBase(ModBlock.SEAFOAM_FENCE.get()));
    public static final RegistryObject<Item> SEAFOAM_FENCE_GATE = ITEMS.register("seafoam_fence_gate", () -> new BlockItemBase(ModBlock.SEAFOAM_FENCE_GATE.get()));
    public static final RegistryObject<Item> SEAFOAM_DOOR = ITEMS.register("seafoam_door", () -> new TallBlockItem(ModBlock.SEAFOAM_DOOR.get(), (new Item.Properties()).group(MysticsBiomes.TAB)));
    public static final RegistryObject<Item> SEAFOAM_TRAPDOOR = ITEMS.register("seafoam_trapdoor", () -> new BlockItem(ModBlock.SEAFOAM_TRAPDOOR.get(), (new Item.Properties()).group(MysticsBiomes.TAB)));

    public static final RegistryObject<Item> EVERGREEN_LOG = ITEMS.register("evergreen_log", () -> new BlockItemBase(ModBlock.EVERGREEN_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_EVERGREEN_LOG = ITEMS.register("stripped_evergreen_log", () -> new BlockItemBase(ModBlock.STRIPPED_EVERGREEN_LOG.get()));
    public static final RegistryObject<Item> EVERGREEN_PLANKS = ITEMS.register("evergreen_planks", () -> new BlockItemBase(ModBlock.EVERGREEN_PLANKS.get()));
    public static final RegistryObject<Item> EVERGREEN_STAIRS = ITEMS.register("evergreen_stairs", () -> new BlockItemBase(ModBlock.EVERGREEN_STAIRS.get()));
    public static final RegistryObject<Item> EVERGREEN_SLAB = ITEMS.register("evergreen_slab", () -> new BlockItemBase(ModBlock.EVERGREEN_SLAB.get()));
    public static final RegistryObject<Item> EVERGREEN_FENCE = ITEMS.register("evergreen_fence", () -> new BlockItemBase(ModBlock.EVERGREEN_FENCE.get()));
    public static final RegistryObject<Item> EVERGREEN_FENCE_GATE = ITEMS.register("evergreen_fence_gate", () -> new BlockItemBase(ModBlock.EVERGREEN_FENCE_GATE.get()));
    public static final RegistryObject<Item> EVERGREEN_DOOR = ITEMS.register("evergreen_door", () -> new TallBlockItem(ModBlock.EVERGREEN_DOOR.get(), (new Item.Properties()).group(MysticsBiomes.TAB)));
    public static final RegistryObject<Item> EVERGREEN_TRAPDOOR = ITEMS.register("evergreen_trapdoor", () -> new BlockItem(ModBlock.EVERGREEN_TRAPDOOR.get(), (new Item.Properties()).group(MysticsBiomes.TAB)));

    public static final RegistryObject<Item> DANDELION_LOG = ITEMS.register("dandelion_log", () -> new BlockItemBase(ModBlock.DANDELION_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_DANDELION_LOG = ITEMS.register("stripped_dandelion_log", () -> new BlockItemBase(ModBlock.STRIPPED_DANDELION_LOG.get()));
    public static final RegistryObject<Item> DANDELION_PLANKS = ITEMS.register("dandelion_planks", () -> new BlockItemBase(ModBlock.DANDELION_PLANKS.get()));
    public static final RegistryObject<Item> DANDELION_STAIRS = ITEMS.register("dandelion_stairs", () -> new BlockItemBase(ModBlock.DANDELION_STAIRS.get()));
    public static final RegistryObject<Item> DANDELION_SLAB = ITEMS.register("dandelion_slab", () -> new BlockItemBase(ModBlock.DANDELION_SLAB.get()));
    public static final RegistryObject<Item> DANDELION_FENCE = ITEMS.register("dandelion_fence", () -> new BlockItemBase(ModBlock.DANDELION_FENCE.get()));
    public static final RegistryObject<Item> DANDELION_FENCE_GATE = ITEMS.register("dandelion_fence_gate", () -> new BlockItemBase(ModBlock.DANDELION_FENCE_GATE.get()));
    public static final RegistryObject<Item> DANDELION_DOOR = ITEMS.register("dandelion_door", () -> new TallBlockItem(ModBlock.DANDELION_DOOR.get(), (new Item.Properties()).group(MysticsBiomes.TAB)));
    public static final RegistryObject<Item> DANDELION_TRAPDOOR = ITEMS.register("dandelion_trapdoor", () -> new BlockItem(ModBlock.DANDELION_TRAPDOOR.get(), (new Item.Properties()).group(MysticsBiomes.TAB)));
    
    public static final RegistryObject<Item> SERENE_CRYSTAL_ORE = ITEMS.register("serene_crystal_ore", () -> new BlockItemBase(ModBlock.SERENE_CRYSTAL_ORE.get()));
    public static final RegistryObject<Item> SWEET_CRYSTAL_ORE = ITEMS.register("sweet_crystal_ore", () -> new BlockItemBase(ModBlock.SWEET_CRYSTAL_ORE.get()));
    public static final RegistryObject<Item> SERENE_CRYSTAL_BLOCK = ITEMS.register("serene_crystal_block", () -> new BlockItemBase(ModBlock.SERENE_CRYSTAL_BLOCK.get()));
    public static final RegistryObject<Item> SWEET_CRYSTAL_BLOCK = ITEMS.register("sweet_crystal_block", () -> new BlockItemBase(ModBlock.SWEET_CRYSTAL_BLOCK.get()));

    public static final RegistryObject<Item> FLOWERING_MOSSY_COBBLESTONE = ITEMS.register("flowering_mossy_cobblestone", () -> new BlockItemBase(ModBlock.FLOWERING_MOSSY_COBBLESTONE.get()));
    
    public static final RegistryObject<Item> LAVENDER = ITEMS.register("lavender", () -> new BlockItemBase(ModBlock.LAVENDER.get()));
    public static final RegistryObject<Item> PASSION_ROSE = ITEMS.register("passion_rose", () -> new BlockItemBase(ModBlock.PASSION_ROSE.get()));
    public static final RegistryObject<Item> FLOWERING_VINES = ITEMS.register("flowering_vines", () -> new BlockItemBase(ModBlock.FLOWERING_VINES.get()));

    // Items
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry", () -> new BlockNamedItem(ModBlock.STRAWBERRY_BUSH.get(), (new Item.Properties()).group(MysticsBiomes.TAB).food(ModFood.STRAWBERRY)));
    public static final RegistryObject<Item> SWEET_STRAWBERRY = ITEMS.register("sweet_strawberry", () -> new BlockNamedItem(ModBlock.SWEET_STRAWBERRY_BUSH.get(), (new Item.Properties()).group(MysticsBiomes.TAB).food(ModFood.SWEET_STRAWBERRY)));
    public static final RegistryObject<Item> SERENE_CRYSTAL = ITEMS.register("serene_crystal", ItemBase::new);
    public static final RegistryObject<Item> SWEET_CRYSTAL = ITEMS.register("sweet_crystal", ItemBase::new);
    
    // Tools
    public static final RegistryObject<SwordItem> SERENE_CRYSTAL_SWORD = ITEMS.register("serene_crystal_sword", () -> new SwordItem(ModItemTier.SERENE_CRYSTAL, 5, -2.4F, new Item.Properties().group(MysticsBiomes.TAB)));
    public static final RegistryObject<PickaxeItem> SERENE_CRYSTAL_PICKAXE = ITEMS.register("serene_crystal_pickaxe", () -> new PickaxeItem(ModItemTier.SERENE_CRYSTAL, 1, -2.8F, new Item.Properties().group(MysticsBiomes.TAB)));
    public static final RegistryObject<AxeItem> SERENE_CRYSTAL_AXE = ITEMS.register("serene_crystal_axe", () -> new AxeItem(ModItemTier.SERENE_CRYSTAL, 5.0F, -3.0F, new Item.Properties().group(MysticsBiomes.TAB)));
    public static final RegistryObject<ShovelItem> SERENE_CRYSTAL_SHOVEL = ITEMS.register("serene_crystal_shovel", () -> new ShovelItem(ModItemTier.SERENE_CRYSTAL, 1.5F, -3.0F, new Item.Properties().group(MysticsBiomes.TAB)));
    public static final RegistryObject<HoeItem> SERENE_CRYSTAL_HOE = ITEMS.register("serene_crystal_hoe", () -> new HoeItem(ModItemTier.SERENE_CRYSTAL, -2.4F, new Item.Properties().group(MysticsBiomes.TAB)));
    public static final RegistryObject<SwordItem> SWEET_CRYSTAL_SWORD = ITEMS.register("sweet_crystal_sword", () -> new SwordItem(ModItemTier.SWEET_CRYSTAL, 5, -2.4F, new Item.Properties().group(MysticsBiomes.TAB)));
    public static final RegistryObject<PickaxeItem> SWEET_CRYSTAL_PICKAXE = ITEMS.register("sweet_crystal_pickaxe", () -> new PickaxeItem(ModItemTier.SWEET_CRYSTAL, 1, -2.8F, new Item.Properties().group(MysticsBiomes.TAB)));
    public static final RegistryObject<AxeItem> SWEET_CRYSTAL_AXE = ITEMS.register("sweet_crystal_axe", () -> new AxeItem(ModItemTier.SWEET_CRYSTAL, 5.0F, -3.0F, new Item.Properties().group(MysticsBiomes.TAB)));
    public static final RegistryObject<ShovelItem> SWEET_CRYSTAL_SHOVEL = ITEMS.register("sweet_crystal_shovel", () -> new ShovelItem(ModItemTier.SWEET_CRYSTAL, 1.5F, -3.0F, new Item.Properties().group(MysticsBiomes.TAB)));
    public static final RegistryObject<HoeItem> SWEET_CRYSTAL_HOE = ITEMS.register("sweet_crystal_hoe", () -> new HoeItem(ModItemTier.SWEET_CRYSTAL, -2.4F, new Item.Properties().group(MysticsBiomes.TAB)));

    // Armor
    public static final RegistryObject<ArmorItem> SERENE_CRYSTAL_HELMET = ITEMS.register("serene_crystal_helmet", () -> new ArmorItem(ModArmorMaterial.SERENE_CRYSTAL, EquipmentSlotType.HEAD, new Item.Properties().group(MysticsBiomes.TAB)));
    public static final RegistryObject<ArmorItem> SERENE_CRYSTAL_CHESTPLATE = ITEMS.register("serene_crystal_chestplate", () -> new ArmorItem(ModArmorMaterial.SERENE_CRYSTAL, EquipmentSlotType.CHEST, new Item.Properties().group(MysticsBiomes.TAB)));
    public static final RegistryObject<ArmorItem> SERENE_CRYSTAL_LEGGINGS = ITEMS.register("serene_crystal_leggings", () -> new ArmorItem(ModArmorMaterial.SERENE_CRYSTAL, EquipmentSlotType.LEGS, new Item.Properties().group(MysticsBiomes.TAB)));
    public static final RegistryObject<ArmorItem> SERENE_CRYSTAL_BOOTS = ITEMS.register("serene_crystal_boots", () -> new ArmorItem(ModArmorMaterial.SERENE_CRYSTAL, EquipmentSlotType.FEET, new Item.Properties().group(MysticsBiomes.TAB)));
    public static final RegistryObject<ArmorItem> SWEET_CRYSTAL_HELMET = ITEMS.register("sweet_crystal_helmet", () -> new ArmorItem(ModArmorMaterial.SWEET_CRYSTAL, EquipmentSlotType.HEAD, new Item.Properties().group(MysticsBiomes.TAB)));
    public static final RegistryObject<ArmorItem> SWEET_CRYSTAL_CHESTPLATE = ITEMS.register("sweet_crystal_chestplate", () -> new ArmorItem(ModArmorMaterial.SWEET_CRYSTAL, EquipmentSlotType.CHEST, new Item.Properties().group(MysticsBiomes.TAB)));
    public static final RegistryObject<ArmorItem> SWEET_CRYSTAL_LEGGINGS = ITEMS.register("sweet_crystal_leggings", () -> new ArmorItem(ModArmorMaterial.SWEET_CRYSTAL, EquipmentSlotType.LEGS, new Item.Properties().group(MysticsBiomes.TAB)));
    public static final RegistryObject<ArmorItem> SWEET_CRYSTAL_BOOTS = ITEMS.register("sweet_crystal_boots", () -> new ArmorItem(ModArmorMaterial.SWEET_CRYSTAL, EquipmentSlotType.FEET, new Item.Properties().group(MysticsBiomes.TAB)));

}
