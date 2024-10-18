package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.entity.MysticBoat;
import com.mysticsbiomes.common.entity.animal.Butterfly;
import com.mysticsbiomes.common.item.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class MysticItems {

    /** strawberry fields */
    public static final Item STRAWBERRY_BLOSSOMS = registerItem("strawberry_blossoms", new MysticBlockItem(MysticBlocks.STRAWBERRY_BLOSSOMS));
    public static final Item STRAWBERRY_SAPLING = registerItem("strawberry_sapling", new MysticBlockItem(MysticBlocks.STRAWBERRY_SAPLING));
    public static final Item STRAWBERRY_LOG = registerItem("strawberry_log", new MysticBlockItem(MysticBlocks.STRAWBERRY_LOG));
    public static final Item STRIPPED_STRAWBERRY_LOG = registerItem("stripped_strawberry_log", new MysticBlockItem(MysticBlocks.STRIPPED_STRAWBERRY_LOG));
    public static final Item STRAWBERRY_WOOD = registerItem("strawberry_wood", new MysticBlockItem(MysticBlocks.STRAWBERRY_WOOD));
    public static final Item STRIPPED_STRAWBERRY_WOOD = registerItem("stripped_strawberry_wood", new MysticBlockItem(MysticBlocks.STRIPPED_STRAWBERRY_WOOD));
    public static final Item STRAWBERRY_PLANKS = registerItem("strawberry_planks", new MysticBlockItem(MysticBlocks.STRAWBERRY_PLANKS));
    public static final Item STRAWBERRY_STAIRS = registerItem("strawberry_stairs", new MysticBlockItem(MysticBlocks.STRAWBERRY_STAIRS));
    public static final Item STRAWBERRY_SLAB = registerItem("strawberry_slab", new MysticBlockItem(MysticBlocks.STRAWBERRY_SLAB));
    public static final Item STRAWBERRY_FENCE = registerItem("strawberry_fence", new MysticBlockItem(MysticBlocks.STRAWBERRY_FENCE));
    public static final Item STRAWBERRY_FENCE_GATE = registerItem("strawberry_fence_gate", new MysticBlockItem(MysticBlocks.STRAWBERRY_FENCE_GATE));
    public static final Item STRAWBERRY_BUTTON = registerItem("strawberry_button", new MysticBlockItem(MysticBlocks.STRAWBERRY_BUTTON));
    public static final Item STRAWBERRY_PRESSURE_PLATE = registerItem("strawberry_pressure_plate", new MysticBlockItem(MysticBlocks.STRAWBERRY_PRESSURE_PLATE));
    public static final Item STRAWBERRY_TRAPDOOR = registerItem("strawberry_trapdoor", new MysticBlockItem(MysticBlocks.STRAWBERRY_TRAPDOOR));
    public static final Item STRAWBERRY_DOOR = registerItem("strawberry_door", new MysticBlockItem(MysticBlocks.STRAWBERRY_DOOR));
    public static final Item STRAWBERRY_SIGN = registerItem("strawberry_sign", new SignItem((new Item.Settings()).maxCount(16), MysticBlocks.STRAWBERRY_SIGN, MysticBlocks.STRAWBERRY_WALL_SIGN));
    public static final Item STRAWBERRY_HANGING_SIGN = registerItem("strawberry_hanging_sign", new HangingSignItem(MysticBlocks.STRAWBERRY_HANGING_SIGN, MysticBlocks.STRAWBERRY_WALL_HANGING_SIGN, (new Item.Settings()).maxCount(16)));
    public static final Item STRAWBERRY_BOAT = registerItem("strawberry_boat", new MysticBoatItem(false, MysticBoat.Type.STRAWBERRY, (new Item.Settings()).maxCount(1)));
    public static final Item STRAWBERRY_CHEST_BOAT = registerItem("strawberry_chest_boat", new MysticBoatItem(true, MysticBoat.Type.STRAWBERRY, (new Item.Settings()).maxCount(1)));

    /** bamboo blossom forest */
    public static final Item PINK_CHERRY_BLOSSOMS = registerItem("pink_cherry_blossoms", new MysticBlockItem(MysticBlocks.PINK_CHERRY_BLOSSOMS));
    public static final Item PINK_CHERRY_BLOSSOM_SAPLING = registerItem("pink_cherry_blossom_sapling", new MysticBlockItem(MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING));
    public static final Item WHITE_CHERRY_BLOSSOMS = registerItem("white_cherry_blossoms", new MysticBlockItem(MysticBlocks.WHITE_CHERRY_BLOSSOMS));
    public static final Item WHITE_CHERRY_BLOSSOM_SAPLING = registerItem("white_cherry_blossom_sapling", new MysticBlockItem(MysticBlocks.WHITE_CHERRY_BLOSSOM_SAPLING));
    public static final Item CHERRY_LOG = registerItem("cherry_log", new MysticBlockItem(MysticBlocks.CHERRY_LOG));
    public static final Item STRIPPED_CHERRY_LOG = registerItem("stripped_cherry_log", new MysticBlockItem(MysticBlocks.STRIPPED_CHERRY_LOG));
    public static final Item CHERRY_WOOD = registerItem("cherry_wood", new MysticBlockItem(MysticBlocks.CHERRY_WOOD));
    public static final Item STRIPPED_CHERRY_WOOD = registerItem("stripped_cherry_wood", new MysticBlockItem(MysticBlocks.STRIPPED_CHERRY_WOOD));
    public static final Item CHERRY_PLANKS = registerItem("cherry_planks", new MysticBlockItem(MysticBlocks.CHERRY_PLANKS));
    public static final Item CHERRY_STAIRS = registerItem("cherry_stairs", new MysticBlockItem(MysticBlocks.CHERRY_STAIRS));
    public static final Item CHERRY_SLAB = registerItem("cherry_slab", new MysticBlockItem(MysticBlocks.CHERRY_SLAB));
    public static final Item CHERRY_FENCE = registerItem("cherry_fence", new MysticBlockItem(MysticBlocks.CHERRY_FENCE));
    public static final Item CHERRY_FENCE_GATE = registerItem("cherry_fence_gate", new MysticBlockItem(MysticBlocks.CHERRY_FENCE_GATE));
    public static final Item CHERRY_BUTTON = registerItem("cherry_button", new MysticBlockItem(MysticBlocks.CHERRY_BUTTON));
    public static final Item CHERRY_PRESSURE_PLATE = registerItem("cherry_pressure_plate", new MysticBlockItem(MysticBlocks.CHERRY_PRESSURE_PLATE));
    public static final Item CHERRY_TRAPDOOR = registerItem("cherry_trapdoor", new MysticBlockItem(MysticBlocks.CHERRY_TRAPDOOR));
    public static final Item CHERRY_DOOR = registerItem("cherry_door", new MysticBlockItem(MysticBlocks.CHERRY_DOOR));
    public static final Item CHERRY_SIGN = registerItem("cherry_sign", new SignItem((new Item.Settings()).maxCount(16), MysticBlocks.CHERRY_SIGN, MysticBlocks.CHERRY_WALL_SIGN));
    public static final Item CHERRY_HANGING_SIGN = registerItem("cherry_hanging_sign", new HangingSignItem(MysticBlocks.CHERRY_HANGING_SIGN, MysticBlocks.CHERRY_WALL_HANGING_SIGN, (new Item.Settings()).maxCount(16)));
    public static final Item CHERRY_BOAT = registerItem("cherry_boat", new MysticBoatItem(false, MysticBoat.Type.CHERRY, (new Item.Settings()).maxCount(1)));
    public static final Item CHERRY_CHEST_BOAT = registerItem("cherry_chest_boat", new MysticBoatItem(true, MysticBoat.Type.CHERRY, (new Item.Settings()).maxCount(1)));

    /** lush oasis */
    public static final Item LUSH_SAND = registerItem("lush_sand", new MysticBlockItem(MysticBlocks.LUSH_SAND));
    public static final Item GRASSY_LUSH_SAND = registerItem("grassy_lush_sand", new MysticBlockItem(MysticBlocks.GRASSY_LUSH_SAND));
    public static final Item LUSH_SANDSTONE = registerItem("lush_sandstone", new MysticBlockItem(MysticBlocks.LUSH_SANDSTONE));
    public static final Item LUSH_SANDSTONE_STAIRS = registerItem("lush_sandstone_stairs", new MysticBlockItem(MysticBlocks.LUSH_SANDSTONE_STAIRS));
    public static final Item LUSH_SANDSTONE_SLAB = registerItem("lush_sandstone_slab", new MysticBlockItem(MysticBlocks.LUSH_SANDSTONE_SLAB));
    public static final Item LUSH_SANDSTONE_WALL = registerItem("lush_sandstone_wall", new MysticBlockItem(MysticBlocks.LUSH_SANDSTONE_WALL));
    public static final Item CHISELED_LUSH_SANDSTONE = registerItem("chiseled_lush_sandstone", new MysticBlockItem(MysticBlocks.CHISELED_LUSH_SANDSTONE));
    public static final Item CUT_LUSH_SANDSTONE = registerItem("cut_lush_sandstone", new MysticBlockItem(MysticBlocks.CUT_LUSH_SANDSTONE));
    public static final Item CUT_LUSH_SANDSTONE_SLAB = registerItem("cut_lush_sandstone_slab", new MysticBlockItem(MysticBlocks.CUT_LUSH_SANDSTONE_SLAB));
    public static final Item SMOOTH_LUSH_SANDSTONE = registerItem("smooth_lush_sandstone", new MysticBlockItem(MysticBlocks.SMOOTH_LUSH_SANDSTONE));
    public static final Item SMOOTH_LUSH_SANDSTONE_STAIRS = registerItem("smooth_lush_sandstone_stairs", new MysticBlockItem(MysticBlocks.SMOOTH_LUSH_SANDSTONE_STAIRS));
    public static final Item SMOOTH_LUSH_SANDSTONE_SLAB = registerItem("smooth_lush_sandstone_slab", new MysticBlockItem(MysticBlocks.SMOOTH_LUSH_SANDSTONE_SLAB));

    public static final Item PEACH_LEAVES = registerItem("peach_leaves", new BlockItem(MysticBlocks.PEACH_LEAVES, new Item.Settings()));
    public static final Item PEACH_SAPLING = registerItem("peach_sapling", new MysticBlockItem(MysticBlocks.PEACH_SAPLING));
    public static final Item PEACH_LOG = registerItem("peach_log", new MysticBlockItem(MysticBlocks.PEACH_LOG));
    public static final Item STRIPPED_PEACH_LOG = registerItem("stripped_peach_log", new MysticBlockItem(MysticBlocks.STRIPPED_PEACH_LOG));
    public static final Item PEACH_WOOD = registerItem("peach_wood", new MysticBlockItem(MysticBlocks.PEACH_WOOD));
    public static final Item STRIPPED_PEACH_WOOD = registerItem("stripped_peach_wood", new MysticBlockItem(MysticBlocks.STRIPPED_PEACH_WOOD));
    public static final Item PEACH_PLANKS = registerItem("peach_planks", new MysticBlockItem(MysticBlocks.PEACH_PLANKS));
    public static final Item PEACH_STAIRS = registerItem("peach_stairs", new MysticBlockItem(MysticBlocks.PEACH_STAIRS));
    public static final Item PEACH_SLAB = registerItem("peach_slab", new MysticBlockItem(MysticBlocks.PEACH_SLAB));
    public static final Item PEACH_FENCE = registerItem("peach_fence", new MysticBlockItem(MysticBlocks.PEACH_FENCE));
    public static final Item PEACH_FENCE_GATE = registerItem("peach_fence_gate", new MysticBlockItem(MysticBlocks.PEACH_FENCE_GATE));
    public static final Item PEACH_BUTTON = registerItem("peach_button", new MysticBlockItem(MysticBlocks.PEACH_BUTTON));
    public static final Item PEACH_PRESSURE_PLATE = registerItem("peach_pressure_plate", new MysticBlockItem(MysticBlocks.PEACH_PRESSURE_PLATE));
    public static final Item PEACH_TRAPDOOR = registerItem("peach_trapdoor", new MysticBlockItem(MysticBlocks.PEACH_TRAPDOOR));
    public static final Item PEACH_DOOR = registerItem("peach_door", new MysticBlockItem(MysticBlocks.PEACH_DOOR));
    public static final Item PEACH_SIGN = registerItem("peach_sign", new SignItem((new Item.Settings()).maxCount(16), MysticBlocks.PEACH_SIGN, MysticBlocks.PEACH_WALL_SIGN));
    public static final Item PEACH_HANGING_SIGN = registerItem("peach_hanging_sign", new HangingSignItem(MysticBlocks.PEACH_HANGING_SIGN, MysticBlocks.PEACH_WALL_HANGING_SIGN, (new Item.Settings()).maxCount(16)));
    public static final Item PEACH_BOAT = registerItem("peach_boat", new MysticBoatItem(false, MysticBoat.Type.PEACH, (new Item.Settings()).maxCount(1)));
    public static final Item PEACH_CHEST_BOAT = registerItem("peach_chest_boat", new MysticBoatItem(true, MysticBoat.Type.PEACH, (new Item.Settings()).maxCount(1)));

    /** autumnal grove */
    public static final Item MAPLE_LEAVES = registerItem("maple_leaves", new MysticBlockItem(MysticBlocks.MAPLE_LEAVES));
    public static final Item MAPLE_LEAF_PILE = registerItem("maple_leaf_pile", new MysticBlockItem(MysticBlocks.MAPLE_LEAF_PILE));
    public static final Item MAPLE_SAPLING = registerItem("maple_sapling", new MysticBlockItem(MysticBlocks.MAPLE_SAPLING));
    public static final Item ORANGE_MAPLE_LEAVES = registerItem("orange_maple_leaves", new MysticBlockItem(MysticBlocks.ORANGE_MAPLE_LEAVES));
    public static final Item ORANGE_MAPLE_LEAF_PILE = registerItem("orange_maple_leaf_pile", new MysticBlockItem(MysticBlocks.ORANGE_MAPLE_LEAF_PILE));
    public static final Item ORANGE_MAPLE_SAPLING = registerItem("orange_maple_sapling", new MysticBlockItem(MysticBlocks.ORANGE_MAPLE_SAPLING));
    public static final Item YELLOW_MAPLE_LEAVES = registerItem("yellow_maple_leaves", new MysticBlockItem(MysticBlocks.YELLOW_MAPLE_LEAVES));
    public static final Item YELLOW_MAPLE_LEAF_PILE = registerItem("yellow_maple_leaf_pile", new MysticBlockItem(MysticBlocks.YELLOW_MAPLE_LEAF_PILE));
    public static final Item YELLOW_MAPLE_SAPLING = registerItem("yellow_maple_sapling", new MysticBlockItem(MysticBlocks.YELLOW_MAPLE_SAPLING));

    public static final Item MAPLE_LOG = registerItem("maple_log", new MysticBlockItem(MysticBlocks.MAPLE_LOG));
    public static final Item WHITE_MAPLE_LOG = registerItem("white_maple_log", new MysticBlockItem(MysticBlocks.WHITE_MAPLE_LOG));
    public static final Item STRIPPED_MAPLE_LOG = registerItem("stripped_maple_log", new MysticBlockItem(MysticBlocks.STRIPPED_MAPLE_LOG));
    public static final Item MAPLE_WOOD = registerItem("maple_wood", new MysticBlockItem(MysticBlocks.MAPLE_WOOD));
    public static final Item WHITE_MAPLE_WOOD = registerItem("white_maple_wood", new MysticBlockItem(MysticBlocks.WHITE_MAPLE_WOOD));
    public static final Item STRIPPED_MAPLE_WOOD = registerItem("stripped_maple_wood", new MysticBlockItem(MysticBlocks.STRIPPED_MAPLE_WOOD));
    public static final Item MAPLE_PLANKS = registerItem("maple_planks", new MysticBlockItem(MysticBlocks.MAPLE_PLANKS));
    public static final Item MAPLE_STAIRS = registerItem("maple_stairs", new MysticBlockItem(MysticBlocks.MAPLE_STAIRS));
    public static final Item MAPLE_SLAB = registerItem("maple_slab", new MysticBlockItem(MysticBlocks.MAPLE_SLAB));
    public static final Item MAPLE_FENCE = registerItem("maple_fence", new MysticBlockItem(MysticBlocks.MAPLE_FENCE));
    public static final Item MAPLE_FENCE_GATE = registerItem("maple_fence_gate", new MysticBlockItem(MysticBlocks.MAPLE_FENCE_GATE));
    public static final Item MAPLE_BUTTON = registerItem("maple_button", new MysticBlockItem(MysticBlocks.MAPLE_BUTTON));
    public static final Item MAPLE_PRESSURE_PLATE = registerItem("maple_pressure_plate", new MysticBlockItem(MysticBlocks.MAPLE_PRESSURE_PLATE));
    public static final Item MAPLE_TRAPDOOR = registerItem("maple_trapdoor", new MysticBlockItem(MysticBlocks.MAPLE_TRAPDOOR));
    public static final Item MAPLE_DOOR = registerItem("maple_door", new MysticBlockItem(MysticBlocks.MAPLE_DOOR));
    public static final Item MAPLE_SIGN = registerItem("maple_sign", new SignItem((new Item.Settings()).maxCount(16), MysticBlocks.MAPLE_SIGN, MysticBlocks.MAPLE_WALL_SIGN));
    public static final Item MAPLE_HANGING_SIGN = registerItem("maple_hanging_sign", new HangingSignItem(MysticBlocks.MAPLE_HANGING_SIGN, MysticBlocks.MAPLE_WALL_HANGING_SIGN, (new Item.Settings()).maxCount(16)));
    public static final Item MAPLE_BOAT = registerItem("maple_boat", new MysticBoatItem(false, MysticBoat.Type.MAPLE, (new Item.Settings()).maxCount(1)));
    public static final Item MAPLE_CHEST_BOAT = registerItem("maple_chest_boat", new MysticBoatItem(true, MysticBoat.Type.MAPLE, (new Item.Settings()).maxCount(1)));

    /** lagoon */
    public static final Item SEA_SHRUB_LEAVES = registerItem("sea_shrub_leaves", new MysticBlockItem(MysticBlocks.SEA_SHRUB_LEAVES));
    public static final Item SEA_SHRUB = registerItem("sea_shrub", new MysticBlockItem(MysticBlocks.SEA_SHRUB));
    public static final Item SEA_FOAM_LOG = registerItem("sea_foam_log", new MysticBlockItem(MysticBlocks.SEA_FOAM_LOG));
    public static final Item STRIPPED_SEA_FOAM_LOG = registerItem("stripped_sea_foam_log", new MysticBlockItem(MysticBlocks.STRIPPED_SEA_FOAM_LOG));
    public static final Item SEA_FOAM_WOOD = registerItem("sea_foam_wood", new MysticBlockItem(MysticBlocks.SEA_FOAM_WOOD));
    public static final Item STRIPPED_SEA_FOAM_WOOD = registerItem("stripped_sea_foam_wood", new MysticBlockItem(MysticBlocks.STRIPPED_SEA_FOAM_WOOD));
    public static final Item SEA_FOAM_PLANKS = registerItem("sea_foam_planks", new MysticBlockItem(MysticBlocks.SEA_FOAM_PLANKS));
    public static final Item SEA_FOAM_STAIRS = registerItem("sea_foam_stairs", new MysticBlockItem(MysticBlocks.SEA_FOAM_STAIRS));
    public static final Item SEA_FOAM_SLAB = registerItem("sea_foam_slab", new MysticBlockItem(MysticBlocks.SEA_FOAM_SLAB));
    public static final Item SEA_FOAM_FENCE = registerItem("sea_foam_fence", new MysticBlockItem(MysticBlocks.SEA_FOAM_FENCE));
    public static final Item SEA_FOAM_FENCE_GATE = registerItem("sea_foam_fence_gate", new MysticBlockItem(MysticBlocks.SEA_FOAM_FENCE_GATE));
    public static final Item SEA_FOAM_BUTTON = registerItem("sea_foam_button", new MysticBlockItem(MysticBlocks.SEA_FOAM_BUTTON));
    public static final Item SEA_FOAM_PRESSURE_PLATE = registerItem("sea_foam_pressure_plate", new MysticBlockItem(MysticBlocks.SEA_FOAM_PRESSURE_PLATE));
    public static final Item SEA_FOAM_TRAPDOOR = registerItem("sea_foam_trapdoor", new MysticBlockItem(MysticBlocks.SEA_FOAM_TRAPDOOR));
    public static final Item SEA_FOAM_DOOR = registerItem("sea_foam_door", new MysticBlockItem(MysticBlocks.SEA_FOAM_DOOR));
    public static final Item SEA_FOAM_SIGN = registerItem("sea_foam_sign", new SignItem((new Item.Settings()).maxCount(16), MysticBlocks.SEA_FOAM_SIGN, MysticBlocks.SEA_FOAM_WALL_SIGN));
    public static final Item SEA_FOAM_HANGING_SIGN = registerItem("sea_foam_hanging_sign", new HangingSignItem(MysticBlocks.SEA_FOAM_HANGING_SIGN, MysticBlocks.SEA_FOAM_WALL_HANGING_SIGN, (new Item.Settings()).maxCount(16)));
    public static final Item SEA_FOAM_BOAT = registerItem("sea_foam_boat", new MysticBoatItem(false, MysticBoat.Type.SEA_FOAM, (new Item.Settings()).maxCount(1)));
    public static final Item SEA_FOAM_CHEST_BOAT = registerItem("sea_foam_chest_boat", new MysticBoatItem(true, MysticBoat.Type.SEA_FOAM, (new Item.Settings()).maxCount(1)));

    /** tropics */
    public static final Item TROPICAL_LEAVES = registerItem("tropical_leaves", new MysticBlockItem(MysticBlocks.TROPICAL_LEAVES));
    public static final Item TROPICAL_SAPLING = registerItem("tropical_sapling", new MysticBlockItem(MysticBlocks.TROPICAL_SAPLING));
    public static final Item TROPICAL_LOG = registerItem("tropical_log", new MysticBlockItem(MysticBlocks.TROPICAL_LOG));
    public static final Item STRIPPED_TROPICAL_LOG = registerItem("stripped_tropical_log", new MysticBlockItem(MysticBlocks.STRIPPED_TROPICAL_LOG));
    public static final Item TROPICAL_WOOD = registerItem("tropical_wood", new MysticBlockItem(MysticBlocks.TROPICAL_WOOD));
    public static final Item STRIPPED_TROPICAL_WOOD = registerItem("stripped_tropical_wood", new MysticBlockItem(MysticBlocks.STRIPPED_TROPICAL_WOOD));
    public static final Item TROPICAL_PLANKS = registerItem("tropical_planks", new MysticBlockItem(MysticBlocks.TROPICAL_PLANKS));
    public static final Item TROPICAL_STAIRS = registerItem("tropical_stairs", new MysticBlockItem(MysticBlocks.TROPICAL_STAIRS));
    public static final Item TROPICAL_SLAB = registerItem("tropical_slab", new MysticBlockItem(MysticBlocks.TROPICAL_SLAB));
    public static final Item TROPICAL_FENCE = registerItem("tropical_fence", new MysticBlockItem(MysticBlocks.TROPICAL_FENCE));
    public static final Item TROPICAL_FENCE_GATE = registerItem("tropical_fence_gate", new MysticBlockItem(MysticBlocks.TROPICAL_FENCE_GATE));
    public static final Item TROPICAL_BUTTON = registerItem("tropical_button", new MysticBlockItem(MysticBlocks.TROPICAL_BUTTON));
    public static final Item TROPICAL_PRESSURE_PLATE = registerItem("tropical_pressure_plate", new MysticBlockItem(MysticBlocks.TROPICAL_PRESSURE_PLATE));
    public static final Item TROPICAL_TRAPDOOR = registerItem("tropical_trapdoor", new MysticBlockItem(MysticBlocks.TROPICAL_TRAPDOOR));
    public static final Item TROPICAL_DOOR = registerItem("tropical_door", new MysticBlockItem(MysticBlocks.TROPICAL_DOOR));
    public static final Item TROPICAL_SIGN = registerItem("tropical_sign", new SignItem((new Item.Settings()).maxCount(16), MysticBlocks.TROPICAL_SIGN, MysticBlocks.TROPICAL_WALL_SIGN));
    public static final Item TROPICAL_HANGING_SIGN = registerItem("tropical_hanging_sign", new HangingSignItem(MysticBlocks.TROPICAL_HANGING_SIGN, MysticBlocks.TROPICAL_WALL_HANGING_SIGN, (new Item.Settings()).maxCount(16)));
    public static final Item TROPICAL_BOAT = registerItem("tropical_boat", new MysticBoatItem(false, MysticBoat.Type.TROPICAL, (new Item.Settings()).maxCount(1)));
    public static final Item TROPICAL_CHEST_BOAT = registerItem("tropical_chest_boat", new MysticBoatItem(true, MysticBoat.Type.TROPICAL, (new Item.Settings()).maxCount(1)));

    /** lavender meadow */
    public static final Item JACARANDA_BLOSSOMS = registerItem("jacaranda_blossoms", new MysticBlockItem(MysticBlocks.JACARANDA_BLOSSOMS));
    public static final Item JACARANDA_LEAVES = registerItem("jacaranda_leaves", new MysticBlockItem(MysticBlocks.JACARANDA_LEAVES));
    public static final Item JACARANDA_SAPLING = registerItem("jacaranda_sapling", new MysticBlockItem(MysticBlocks.JACARANDA_SAPLING));
    public static final Item JACARANDA_LOG = registerItem("jacaranda_log", new MysticBlockItem(MysticBlocks.JACARANDA_LOG));
    public static final Item STRIPPED_JACARANDA_LOG = registerItem("stripped_jacaranda_log", new MysticBlockItem(MysticBlocks.STRIPPED_JACARANDA_LOG));
    public static final Item JACARANDA_WOOD = registerItem("jacaranda_wood", new MysticBlockItem(MysticBlocks.JACARANDA_WOOD));
    public static final Item STRIPPED_JACARANDA_WOOD = registerItem("stripped_jacaranda_wood", new MysticBlockItem(MysticBlocks.STRIPPED_JACARANDA_WOOD));
    public static final Item JACARANDA_PLANKS = registerItem("jacaranda_planks", new MysticBlockItem(MysticBlocks.JACARANDA_PLANKS));
    public static final Item JACARANDA_STAIRS = registerItem("jacaranda_stairs", new MysticBlockItem(MysticBlocks.JACARANDA_STAIRS));
    public static final Item JACARANDA_SLAB = registerItem("jacaranda_slab", new MysticBlockItem(MysticBlocks.JACARANDA_SLAB));
    public static final Item JACARANDA_FENCE = registerItem("jacaranda_fence", new MysticBlockItem(MysticBlocks.JACARANDA_FENCE));
    public static final Item JACARANDA_FENCE_GATE = registerItem("jacaranda_fence_gate", new MysticBlockItem(MysticBlocks.JACARANDA_FENCE_GATE));
    public static final Item JACARANDA_BUTTON = registerItem("jacaranda_button", new MysticBlockItem(MysticBlocks.JACARANDA_BUTTON));
    public static final Item JACARANDA_PRESSURE_PLATE = registerItem("jacaranda_pressure_plate", new MysticBlockItem(MysticBlocks.JACARANDA_PRESSURE_PLATE));
    public static final Item JACARANDA_TRAPDOOR = registerItem("jacaranda_trapdoor", new MysticBlockItem(MysticBlocks.JACARANDA_TRAPDOOR));
    public static final Item JACARANDA_DOOR = registerItem("jacaranda_door", new MysticBlockItem(MysticBlocks.JACARANDA_DOOR));
    public static final Item JACARANDA_SIGN = registerItem("jacaranda_sign", new SignItem((new Item.Settings()).maxCount(16), MysticBlocks.JACARANDA_SIGN, MysticBlocks.JACARANDA_WALL_SIGN));
    public static final Item JACARANDA_HANGING_SIGN = registerItem("jacaranda_hanging_sign", new HangingSignItem(MysticBlocks.JACARANDA_HANGING_SIGN, MysticBlocks.JACARANDA_WALL_HANGING_SIGN, (new Item.Settings()).maxCount(16)));
    public static final Item JACARANDA_BOAT = registerItem("jacaranda_boat", new MysticBoatItem(false, MysticBoat.Type.JACARANDA, (new Item.Settings()).maxCount(1)));
    public static final Item JACARANDA_CHEST_BOAT = registerItem("jacaranda_chest_boat", new MysticBoatItem(true, MysticBoat.Type.JACARANDA, (new Item.Settings()).maxCount(1)));

    /** plants & flowers */
    public static final Item PEONY_LEAVES = registerItem("peony_leaves", new MysticBlockItem(MysticBlocks.PEONY_LEAVES));
    public static final Item BUDDING_PEONY_LEAVES = registerItem("budding_peony_leaves", new MysticBlockItem(MysticBlocks.BUDDING_PEONY_LEAVES));
    public static final Item PEONY_BUSH = registerItem("peony_bush", new MysticBlockItem(MysticBlocks.PEONY_BUSH));
    public static final Item HYDRANGEA_LEAVES = registerItem("hydrangea_leaves", new MysticBlockItem(MysticBlocks.HYDRANGEA_LEAVES));
    public static final Item HYDRANGEA_BUSH = registerItem("hydrangea_bush", new MysticBlockItem(MysticBlocks.HYDRANGEA_BUSH));
    public static final Item LAVENDER = registerItem("lavender", new MysticBlockItem(MysticBlocks.LAVENDER));
    public static final Item WILDFLOWER = registerItem("wildflower", new MysticBlockItem(MysticBlocks.WILDFLOWER));
    public static final Item MILKWEED = registerItem("milkweed", new MysticBlockItem(MysticBlocks.MILKWEED));
    public static final Item SEA_OATS = registerItem("sea_oats", new MysticBlockItem(MysticBlocks.SEA_OATS));
    public static final Item DESERT_GRASS = registerItem("desert_grass", new MysticBlockItem(MysticBlocks.DESERT_GRASS));
    public static final Item SAGUARO_BLOSSOM = registerItem("saguaro_blossom", new MysticBlockItem(MysticBlocks.SAGUARO_BLOSSOM));
    public static final Item SAGUARO_CACTUS = registerItem("saguaro_cactus", new MysticBlockItem(MysticBlocks.SAGUARO_CACTUS));
    public static final Item SPRING_BAMBOO = registerItem("spring_bamboo", new MysticBlockItem(MysticBlocks.SPRING_BAMBOO));
    public static final Item BUNDLED_SPRING_BAMBOO = registerItem("bundled_spring_bamboo", new MysticBlockItem(MysticBlocks.BUNDLED_SPRING_BAMBOO));

    /** items & foods */
    public static final Item BUTTERFLY_NEST = registerItem("butterfly_nest", new MysticBlockItem(MysticBlocks.BUTTERFLY_NEST));
    public static final Item GLASS_JAR = registerItem("glass_jar", new GlassJarItem(MysticBlocks.GLASS_JAR, new Item.Settings().maxCount(16)));
    public static final Item ORANGE_BUTTERFLY_IN_JAR = registerItem("orange_butterfly_in_jar", new ButterflyJarItem(Butterfly.Type.TANGERINE));
    public static final Item BLUE_BUTTERFLY_IN_JAR = registerItem("blue_butterfly_in_jar", new ButterflyJarItem(Butterfly.Type.JELLY));
    public static final Item CYAN_BUTTERFLY_IN_JAR = registerItem("cyan_butterfly_in_jar", new ButterflyJarItem(Butterfly.Type.JULY));
    public static final Item LILAC_BUTTERFLY_IN_JAR = registerItem("lilac_butterfly_in_jar", new ButterflyJarItem(Butterfly.Type.CANDY));
    public static final Item PINK_BUTTERFLY_IN_JAR = registerItem("pink_butterfly_in_jar", new ButterflyJarItem(Butterfly.Type.VALENTINE));
    public static final Item PURPLE_BUTTERFLY_IN_JAR = registerItem("purple_butterfly_in_jar", new ButterflyJarItem(Butterfly.Type.MYSTIC));

    public static final Item STRAWBERRY = registerItem("strawberry", new AliasedBlockItem(MysticBlocks.STRAWBERRY_BUSH, new Item.Settings().food(new FoodComponent.Builder().hunger(2).snack().build())));
    public static final Item SWEET_STRAWBERRY = registerItem("sweet_strawberry", new AliasedBlockItem(MysticBlocks.STRAWBERRY_BUSH, new Item.Settings().food((new FoodComponent.Builder()).hunger(4).saturationModifier(1.2F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1), 1.0F).build())));
    public static final Item CHERRIES = registerItem("cherries", new AliasedBlockItem(MysticBlocks.CHERRY_PLANT, new Item.Settings().food(new FoodComponent.Builder().hunger(4).snack().build())));
    public static final Item PEACH = registerItem("peach", new AliasedBlockItem(MysticBlocks.PEACH_PLANT, new Item.Settings().food(new FoodComponent.Builder().hunger(4).snack().build())));
    public static final Item VANILLA_BEANS = registerItem("vanilla_beans", new AliasedBlockItem(MysticBlocks.VANILLA_ORCHID, new Item.Settings()));

    public static final Item STRAWBERRY_JAM = registerItem("strawberry_jam", new JamItem());
    public static final Item CHERRY_JAM = registerItem("cherry_jam", new JamItem());
    public static final Item PEACH_JAM = registerItem("peach_jam", new JamItem());

    public static final Item STRAWBERRY_MILK_BUCKET = registerItem("strawberry_milk_bucket", new MilkBucketItem((new Item.Settings()).recipeRemainder(Items.BUCKET).maxCount(1)));
    public static final Item VANILLA_MILK_BUCKET = registerItem("vanilla_milk_bucket", new MilkBucketItem((new Item.Settings()).recipeRemainder(Items.BUCKET).maxCount(1)));
    public static final Item CHOCOLATE_MILK_BUCKET = registerItem("chocolate_milk_bucket", new MilkBucketItem((new Item.Settings()).recipeRemainder(Items.BUCKET).maxCount(1)));

    public static final Item STRAWBERRY_CAKE = registerItem("strawberry_cake", new BlockItem(MysticBlocks.STRAWBERRY_CAKE, (new Item.Settings()).maxCount(1)));
    public static final Item VANILLA_CAKE = registerItem("vanilla_cake", new BlockItem(MysticBlocks.VANILLA_CAKE, (new Item.Settings()).maxCount(1)));
    public static final Item CHOCOLATE_CAKE = registerItem("chocolate_cake", new BlockItem(MysticBlocks.CHOCOLATE_CAKE, (new Item.Settings()).maxCount(1)));
    public static final Item PINK_FROSTED_CAKE = registerItem("pink_frosted_cake", new BlockItem(MysticBlocks.PINK_FROSTED_CAKE, (new Item.Settings()).maxCount(1)));
    public static final Item ORANGE_FROSTED_CAKE = registerItem("orange_frosted_cake", new BlockItem(MysticBlocks.ORANGE_FROSTED_CAKE, (new Item.Settings()).maxCount(1)));
    public static final Item YELLOW_FROSTED_CAKE = registerItem("yellow_frosted_cake", new BlockItem(MysticBlocks.YELLOW_FROSTED_CAKE, (new Item.Settings()).maxCount(1)));
    public static final Item LIME_FROSTED_CAKE = registerItem("lime_frosted_cake", new BlockItem(MysticBlocks.LIME_FROSTED_CAKE, (new Item.Settings()).maxCount(1)));
    public static final Item CYAN_FROSTED_CAKE = registerItem("cyan_frosted_cake", new BlockItem(MysticBlocks.CYAN_FROSTED_CAKE, (new Item.Settings()).maxCount(1)));
    public static final Item PURPLE_FROSTED_CAKE = registerItem("purple_frosted_cake", new BlockItem(MysticBlocks.PURPLE_FROSTED_CAKE, (new Item.Settings()).maxCount(1)));
    public static final Item CHERRY_PIE = registerItem("cherry_pie", new BlockItem(MysticBlocks.CHERRY_PIE, (new Item.Settings()).maxCount(1)));
    public static final Item PEACH_PIE = registerItem("peach_pie", new BlockItem(MysticBlocks.PEACH_PIE, (new Item.Settings()).maxCount(1)));

    public static final Item PINK_EGG = registerItem("pink_egg", new MysticEggItem(new Item.Settings().maxCount(16)));
    public static final Item ORANGE_EGG = registerItem("orange_egg", new MysticEggItem(new Item.Settings().maxCount(16)));
    public static final Item YELLOW_EGG = registerItem("yellow_egg", new MysticEggItem(new Item.Settings().maxCount(16)));
    public static final Item LIME_EGG = registerItem("lime_egg", new MysticEggItem(new Item.Settings().maxCount(16)));
    public static final Item CYAN_EGG = registerItem("cyan_egg", new MysticEggItem(new Item.Settings().maxCount(16)));
    public static final Item PURPLE_EGG = registerItem("purple_egg", new MysticEggItem(new Item.Settings().maxCount(16)));

    /** spawn eggs */
    public static final Item STRAWBERRY_COW_SPAWN_EGG = registerItem("strawberry_cow_spawn_egg", new SpawnEggItem(MysticEntities.STRAWBERRY_COW, 16642812, 16756181, new Item.Settings()));
    public static final Item VANILLA_COW_SPAWN_EGG = registerItem("vanilla_cow_spawn_egg", new SpawnEggItem(MysticEntities.VANILLA_COW, 16775929, 15781816, new Item.Settings()));
    public static final Item CHOCOLATE_COW_SPAWN_EGG = registerItem("chocolate_cow_spawn_egg", new SpawnEggItem(MysticEntities.CHOCOLATE_COW, 11697754, 7950915, new Item.Settings()));
    public static final Item RAINBOW_CHICKEN_SPAWN_EGG = registerItem("rainbow_chicken_spawn_egg", new SpawnEggItem(MysticEntities.RAINBOW_CHICKEN, 7666652, 16577636, new Item.Settings()));
    public static final Item RED_PANDA_SPAWN_EGG = registerItem("red_panda_spawn_egg", new SpawnEggItem(MysticEntities.RED_PANDA, 16760947, 13795386, new Item.Settings()));
    public static final Item SEA_OTTER_SPAWN_EGG = registerItem("sea_otter_spawn_egg", new SpawnEggItem(MysticEntities.SEA_OTTER, 5191718, 10980193, new Item.Settings()));
    public static final Item BUTTERFLY_SPAWN_EGG = registerItem("butterfly_spawn_egg", new SpawnEggItem(MysticEntities.BUTTERFLY, 2710099, 3857605, new Item.Settings()));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, MysticsBiomes.modLoc(name), item);
    }

    public static void registerItems() {
        MysticsBiomes.LOGGER.info("mystic's biomes ~ registering items");
    }

}