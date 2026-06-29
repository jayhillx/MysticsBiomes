package com.mysticsbiomes.init;

import com.mysticsbiomes.common.entity.vehicle.MysticBoat;
import com.mysticsbiomes.core.registry.RegistryObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

import static com.mysticsbiomes.MysticsBiomes.REGISTRY;
import static com.mysticsbiomes.common.item.ItemTemplate.*;

public class MysticItems {

    /// strawberry fields
    public static RegistryObject<Item> STRAWBERRY_BLOSSOMS;
    public static RegistryObject<Item> STRAWBERRY_BLOSSOM_SAPLING;
    public static RegistryObject<Item> STRAWBERRY_LOG;
    public static RegistryObject<Item> STRIPPED_STRAWBERRY_LOG;
    public static RegistryObject<Item> STRAWBERRY_WOOD;
    public static RegistryObject<Item> STRIPPED_STRAWBERRY_WOOD;
    public static RegistryObject<Item> STRAWBERRY_PLANKS;
    public static RegistryObject<Item> STRAWBERRY_STAIRS;
    public static RegistryObject<Item> STRAWBERRY_SLAB;
    public static RegistryObject<Item> STRAWBERRY_FENCE;
    public static RegistryObject<Item> STRAWBERRY_FENCE_GATE;
    public static RegistryObject<Item> STRAWBERRY_BUTTON;
    public static RegistryObject<Item> STRAWBERRY_PRESSURE_PLATE;
    public static RegistryObject<Item> STRAWBERRY_TRAPDOOR;
    public static RegistryObject<Item> STRAWBERRY_DOOR;
    public static RegistryObject<Item> STRAWBERRY_SIGN;
    public static RegistryObject<Item> STRAWBERRY_HANGING_SIGN;
    public static RegistryObject<Item> STRAWBERRY_BOAT;
    public static RegistryObject<Item> STRAWBERRY_CHEST_BOAT;

    ///public static RegistryObject<Item> PINK_DAISIES;
    ///public static RegistryObject<Item> STRAWBERRY;
    ///public static RegistryObject<Item> SWEET_STRAWBERRY;
    ///public static RegistryObject<Item> STRAWBERRY_CAKE;
    ///public static RegistryObject<Item> STRAWBERRY_MILK;
    ///public static RegistryObject<Item> STRAWBERRY_COW_SPAWN_EGG;

    /// lavender meadow
    public static RegistryObject<Item> LAVENDER_BLOSSOMS;
    public static RegistryObject<Item> LAVENDER_BLOSSOM_SAPLING;
    public static RegistryObject<Item> LAVENDER_LOG;
    public static RegistryObject<Item> STRIPPED_LAVENDER_LOG;
    public static RegistryObject<Item> LAVENDER_WOOD;
    public static RegistryObject<Item> STRIPPED_LAVENDER_WOOD;
    public static RegistryObject<Item> LAVENDER_PLANKS;
    public static RegistryObject<Item> LAVENDER_STAIRS;
    public static RegistryObject<Item> LAVENDER_SLAB;
    public static RegistryObject<Item> LAVENDER_FENCE;
    public static RegistryObject<Item> LAVENDER_FENCE_GATE;
    public static RegistryObject<Item> LAVENDER_BUTTON;
    public static RegistryObject<Item> LAVENDER_PRESSURE_PLATE;
    public static RegistryObject<Item> LAVENDER_TRAPDOOR;
    public static RegistryObject<Item> LAVENDER_DOOR;
    public static RegistryObject<Item> LAVENDER_SIGN;
    public static RegistryObject<Item> LAVENDER_HANGING_SIGN;
    public static RegistryObject<Item> LAVENDER_BOAT;
    public static RegistryObject<Item> LAVENDER_CHEST_BOAT;

    ///public static RegistryObject<Item> LAVENDER;
    ///public static RegistryObject<Item> TALL_LAVENDER;
    ///public static RegistryObject<Item> LAVENDER_BUDS;
    ///public static RegistryObject<Item> BUNDLED_LAVENDER_BUDS;
    ///public static RegistryObject<Item> BUTTERFLY_BUSH_LEAVES;
    ///public static RegistryObject<Item> BUTTERFLY_BUSH;
    ///public static RegistryObject<Item> BUTTERFLY_NEST;
    ///public static RegistryObject<Item> BUTTERFLY_SPAWN_EGG;
    ///public static RegistryObject<Item> CHRYSALIS;
    ///public static RegistryObject<Item> CATERPILLAR_SPAWN_EGG;
    ///public static RegistryObject<Item> NECTAR;

    /// bamboo blossom forest
    public static RegistryObject<Item> PINK_CHERRY_BLOSSOMS;
    ///public static RegistryObject<Item> PINK_CHERRY_PETALS;
    public static RegistryObject<Item> PINK_CHERRY_BLOSSOM_SAPLING;
    public static RegistryObject<Item> WHITE_CHERRY_BLOSSOMS;
    ///public static RegistryObject<Item> WHITE_CHERRY_PETALS;
    public static RegistryObject<Item> WHITE_CHERRY_BLOSSOM_SAPLING;
    public static RegistryObject<Item> BLACK_CHERRY_LOG;
    public static RegistryObject<Item> STRIPPED_BLACK_CHERRY_LOG;
    public static RegistryObject<Item> BLACK_CHERRY_WOOD;
    public static RegistryObject<Item> STRIPPED_BLACK_CHERRY_WOOD;
    public static RegistryObject<Item> BLACK_CHERRY_PLANKS;
    public static RegistryObject<Item> BLACK_CHERRY_STAIRS;
    public static RegistryObject<Item> BLACK_CHERRY_SLAB;
    public static RegistryObject<Item> BLACK_CHERRY_FENCE;
    public static RegistryObject<Item> BLACK_CHERRY_FENCE_GATE;
    public static RegistryObject<Item> BLACK_CHERRY_BUTTON;
    public static RegistryObject<Item> BLACK_CHERRY_PRESSURE_PLATE;
    public static RegistryObject<Item> BLACK_CHERRY_TRAPDOOR;
    public static RegistryObject<Item> BLACK_CHERRY_DOOR;
    public static RegistryObject<Item> BLACK_CHERRY_SIGN;
    public static RegistryObject<Item> BLACK_CHERRY_HANGING_SIGN;
    public static RegistryObject<Item> BLACK_CHERRY_BOAT;
    public static RegistryObject<Item> BLACK_CHERRY_CHEST_BOAT;

    ///public static RegistryObject<Item> SPRING_BAMBOO;
    ///public static RegistryObject<Item> STRIPPED_SPRING_BAMBOO;
    public static RegistryObject<Item> SPRING_BAMBOO_BLOCK;
    public static RegistryObject<Item> STRIPPED_SPRING_BAMBOO_BLOCK;
    public static RegistryObject<Item> SPRING_PLANKS;
    public static RegistryObject<Item> SPRING_MOSAIC;
    public static RegistryObject<Item> SPRING_STAIRS;
    public static RegistryObject<Item> SPRING_MOSAIC_STAIRS;
    public static RegistryObject<Item> SPRING_SLAB;
    public static RegistryObject<Item> SPRING_MOSAIC_SLAB;
    public static RegistryObject<Item> SPRING_FENCE;
    public static RegistryObject<Item> SPRING_FENCE_GATE;
    public static RegistryObject<Item> SPRING_BUTTON;
    public static RegistryObject<Item> SPRING_PRESSURE_PLATE;
    public static RegistryObject<Item> SPRING_TRAPDOOR;
    public static RegistryObject<Item> SPRING_DOOR;
    public static RegistryObject<Item> SPRING_SIGN;
    public static RegistryObject<Item> SPRING_HANGING_SIGN;
    public static RegistryObject<Item> SPRING_RAFT;
    public static RegistryObject<Item> SPRING_CHEST_RAFT;

    ///public static RegistryObject<Item> CHERRIES;
    ///public static RegistryObject<Item> CHERRY_PIE;
    ///public static RegistryObject<Item> PEONY_BUSH_LEAVES;
    ///public static RegistryObject<Item> PEONY_BUSH;

    /// autumnal grove
    public static RegistryObject<Item> MAPLE_LEAVES;
    ///public static RegistryObject<Item> MAPLE_LEAF_PILE;
    ///public static RegistryObject<Item> MAPLE_LEAF_LITTER;
    public static RegistryObject<Item> MAPLE_SAPLING;
    public static RegistryObject<Item> SPICED_MAPLE_LEAVES;
    ///public static RegistryObject<Item> SPICED_MAPLE_LEAF_PILE;
    ///public static RegistryObject<Item> SPICED_MAPLE_LEAF_LITTER;
    public static RegistryObject<Item> SPICED_MAPLE_SAPLING;
    public static RegistryObject<Item> ORANGE_MAPLE_LEAVES;
    ///public static RegistryObject<Item> ORANGE_MAPLE_LEAF_PILE;
    ///public static RegistryObject<Item> ORANGE_MAPLE_LEAF_LITTER;
    public static RegistryObject<Item> ORANGE_MAPLE_SAPLING;
    public static RegistryObject<Item> YELLOW_MAPLE_LEAVES;
    ///public static RegistryObject<Item> YELLOW_MAPLE_LEAF_PILE;
    ///public static RegistryObject<Item> YELLOW_MAPLE_LEAF_LITTER;
    public static RegistryObject<Item> YELLOW_MAPLE_SAPLING;
    public static RegistryObject<Item> MAPLE_LOG;
    public static RegistryObject<Item> WHITE_MAPLE_LOG;
    public static RegistryObject<Item> STRIPPED_MAPLE_LOG;
    public static RegistryObject<Item> MAPLE_WOOD;
    public static RegistryObject<Item> WHITE_MAPLE_WOOD;
    public static RegistryObject<Item> STRIPPED_MAPLE_WOOD;
    public static RegistryObject<Item> MAPLE_PLANKS;
    public static RegistryObject<Item> MAPLE_STAIRS;
    public static RegistryObject<Item> MAPLE_SLAB;
    public static RegistryObject<Item> MAPLE_FENCE;
    public static RegistryObject<Item> MAPLE_FENCE_GATE;
    public static RegistryObject<Item> MAPLE_BUTTON;
    public static RegistryObject<Item> MAPLE_PRESSURE_PLATE;
    public static RegistryObject<Item> MAPLE_TRAPDOOR;
    public static RegistryObject<Item> MAPLE_DOOR;
    public static RegistryObject<Item> MAPLE_SIGN;
    public static RegistryObject<Item> MAPLE_HANGING_SIGN;
    public static RegistryObject<Item> MAPLE_BOAT;
    public static RegistryObject<Item> MAPLE_CHEST_BOAT;

    ///public static RegistryObject<Item> MAPLE_SAP;
    ///public static RegistryObject<Item> MAPLE_SYRUP;
    ///public static RegistryObject<Item> MAPLE_PANCAKES;
    ///public static RegistryObject<Item> PUMPKIN_COOKIE;
    ///public static RegistryObject<Item> SPOOKY_COOKIE;
    ///public static RegistryObject<Item> ASTER;
    ///public static RegistryObject<Item> GOLDENROD;

    /// lush oasis
    public static RegistryObject<Item> GRASSY_LUSH_SAND;
    ///public static RegistryObject<Item> LUSH_GRASS;
    ///public static RegistryObject<Item> TALL_LUSH_GRASS;
    public static RegistryObject<Item> LUSH_SAND;
    public static RegistryObject<Item> LUSH_SANDSTONE;
    public static RegistryObject<Item> LUSH_SANDSTONE_STAIRS;
    public static RegistryObject<Item> LUSH_SANDSTONE_SLAB;
    public static RegistryObject<Item> LUSH_SANDSTONE_WALL;
    public static RegistryObject<Item> CHISELED_LUSH_SANDSTONE;
    public static RegistryObject<Item> CUT_LUSH_SANDSTONE;
    public static RegistryObject<Item> CUT_LUSH_SANDSTONE_SLAB;
    public static RegistryObject<Item> SMOOTH_LUSH_SANDSTONE;
    public static RegistryObject<Item> SMOOTH_LUSH_SANDSTONE_STAIRS;
    public static RegistryObject<Item> SMOOTH_LUSH_SANDSTONE_SLAB;

    public static RegistryObject<Item> PEACH_LEAVES;
    public static RegistryObject<Item> PEACH_SAPLING;
    public static RegistryObject<Item> PEACH_LOG;
    public static RegistryObject<Item> STRIPPED_PEACH_LOG;
    public static RegistryObject<Item> PEACH_WOOD;
    public static RegistryObject<Item> STRIPPED_PEACH_WOOD;
    public static RegistryObject<Item> PEACH_PLANKS;
    public static RegistryObject<Item> PEACH_STAIRS;
    public static RegistryObject<Item> PEACH_SLAB;
    public static RegistryObject<Item> PEACH_FENCE;
    public static RegistryObject<Item> PEACH_FENCE_GATE;
    public static RegistryObject<Item> PEACH_BUTTON;
    public static RegistryObject<Item> PEACH_PRESSURE_PLATE;
    public static RegistryObject<Item> PEACH_TRAPDOOR;
    public static RegistryObject<Item> PEACH_DOOR;
    public static RegistryObject<Item> PEACH_SIGN;
    public static RegistryObject<Item> PEACH_HANGING_SIGN;
    public static RegistryObject<Item> PEACH_BOAT;
    public static RegistryObject<Item> PEACH_CHEST_BOAT;

    ///public static RegistryObject<Item> PEACH_PLANT;
    ///public static RegistryObject<Item> PEACH_PIE;
    ///public static RegistryObject<Item> DESERT_SHRUB;
    ///public static RegistryObject<Item> DESERT_GRASS;
    ///public static RegistryObject<Item> TALL_DESERT_GRASS;
    ///public static RegistryObject<Item> DESERT_LILY;
    ///public static RegistryObject<Item> WILDFLOWER;
    ///public static RegistryObject<Item> SAGUARO_CACTUS;
    ///public static RegistryObject<Item> SAGUARO_BLOSSOM;
    ///public static RegistryObject<Item> PRICKLY_CACTUS;
    ///public static RegistryObject<Item> PRICKLY_BLOSSOM;
    ///public static RegistryObject<Item> PRICKLY_PEAR;

    /// lagoon
    public static RegistryObject<Item> SEA_SHRUB_LEAVES;
    public static RegistryObject<Item> SEA_SHRUB;
    public static RegistryObject<Item> SEA_FOAM_LOG;
    public static RegistryObject<Item> STRIPPED_SEA_FOAM_LOG;
    public static RegistryObject<Item> SEA_FOAM_WOOD;
    public static RegistryObject<Item> STRIPPED_SEA_FOAM_WOOD;
    public static RegistryObject<Item> SEA_FOAM_PLANKS;
    public static RegistryObject<Item> SEA_FOAM_STAIRS;
    public static RegistryObject<Item> SEA_FOAM_SLAB;
    public static RegistryObject<Item> SEA_FOAM_FENCE;
    public static RegistryObject<Item> SEA_FOAM_FENCE_GATE;
    public static RegistryObject<Item> SEA_FOAM_BUTTON;
    public static RegistryObject<Item> SEA_FOAM_PRESSURE_PLATE;
    public static RegistryObject<Item> SEA_FOAM_TRAPDOOR;
    public static RegistryObject<Item> SEA_FOAM_DOOR;
    public static RegistryObject<Item> SEA_FOAM_SIGN;
    public static RegistryObject<Item> SEA_FOAM_HANGING_SIGN;
    public static RegistryObject<Item> SEA_FOAM_BOAT;
    public static RegistryObject<Item> SEA_FOAM_CHEST_BOAT;

    ///public static RegistryObject<Item> BEACH_GRASS;
    ///public static RegistryObject<Item> TALL_BEACH_GRASS;
    ///public static RegistryObject<Item> MILKWEED;
    ///public static RegistryObject<Item> SEA_THRIFT;
    ///public static RegistryObject<Item> SEA_OATS;
    ///public static RegistryObject<Item> SEA_FOAM;
    ///public static RegistryObject<Item> SEA_FOAM_BUCKET;
    ///public static RegistryObject<Item> SEA_OTTER_SPAWN_EGG;

    /// tropics
    public static RegistryObject<Item> TROPICAL_LEAVES;
    public static RegistryObject<Item> TROPICAL_SAPLING;
    public static RegistryObject<Item> TROPICAL_LOG;
    public static RegistryObject<Item> STRIPPED_TROPICAL_LOG;
    public static RegistryObject<Item> TROPICAL_WOOD;
    public static RegistryObject<Item> STRIPPED_TROPICAL_WOOD;
    public static RegistryObject<Item> TROPICAL_PLANKS;
    public static RegistryObject<Item> TROPICAL_STAIRS;
    public static RegistryObject<Item> TROPICAL_SLAB;
    public static RegistryObject<Item> TROPICAL_FENCE;
    public static RegistryObject<Item> TROPICAL_FENCE_GATE;
    public static RegistryObject<Item> TROPICAL_BUTTON;
    public static RegistryObject<Item> TROPICAL_PRESSURE_PLATE;
    public static RegistryObject<Item> TROPICAL_TRAPDOOR;
    public static RegistryObject<Item> TROPICAL_DOOR;
    public static RegistryObject<Item> TROPICAL_SIGN;
    public static RegistryObject<Item> TROPICAL_HANGING_SIGN;
    public static RegistryObject<Item> TROPICAL_BOAT;
    public static RegistryObject<Item> TROPICAL_CHEST_BOAT;

    public static RegistryObject<Item> VANILLA_LEAVES;
    public static RegistryObject<Item> VANILLA_SAPLING;
    public static RegistryObject<Item> VANILLA_LOG;
    public static RegistryObject<Item> STRIPPED_VANILLA_LOG;
    public static RegistryObject<Item> VANILLA_WOOD;
    public static RegistryObject<Item> STRIPPED_VANILLA_WOOD;
    public static RegistryObject<Item> VANILLA_PLANKS;
    public static RegistryObject<Item> VANILLA_STAIRS;
    public static RegistryObject<Item> VANILLA_SLAB;
    public static RegistryObject<Item> VANILLA_FENCE;
    public static RegistryObject<Item> VANILLA_FENCE_GATE;
    public static RegistryObject<Item> VANILLA_BUTTON;
    public static RegistryObject<Item> VANILLA_PRESSURE_PLATE;
    public static RegistryObject<Item> VANILLA_TRAPDOOR;
    public static RegistryObject<Item> VANILLA_DOOR;
    public static RegistryObject<Item> VANILLA_SIGN;
    public static RegistryObject<Item> VANILLA_HANGING_SIGN;
    public static RegistryObject<Item> VANILLA_BOAT;
    public static RegistryObject<Item> VANILLA_CHEST_BOAT;

    ///public static RegistryObject<Item> TROPICAL_VINES;
    ///public static RegistryObject<Item> JUNGLE_SHRUB;
    ///public static RegistryObject<Item> JUNGLE_GRASS;
    ///public static RegistryObject<Item> TALL_JUNGLE_GRASS;
    ///public static RegistryObject<Item> BANANA_LEAF_PLANT;
    ///public static RegistryObject<Item> HYDRANGEA_BUSH_LEAVES;
    ///public static RegistryObject<Item> HYDRANGEA_BUSH;
    ///public static RegistryObject<Item> HIBISCUS;
    ///public static RegistryObject<Item> VANILLA_BEANS;
    ///public static RegistryObject<Item> VANILLA_MILK;
    ///public static RegistryObject<Item> VANILLA_CAKE;
    ///public static RegistryObject<Item> VANILLA_COW_SPAWN_EGG;
    ///public static RegistryObject<Item> CHOCOLATE_MILK;
    ///public static RegistryObject<Item> CHOCOLATE_CAKE;
    ///public static RegistryObject<Item> CHOCOLATE_COW_SPAWN_EGG;

    /// rainbow chickens
    ///public static RegistryObject<Item> PINK_FROSTED_CAKE;
    ///public static RegistryObject<Item> ORANGE_FROSTED_CAKE;
    ///public static RegistryObject<Item> YELLOW_FROSTED_CAKE;
    ///public static RegistryObject<Item> LIME_FROSTED_CAKE;
    ///public static RegistryObject<Item> CYAN_FROSTED_CAKE;
    ///public static RegistryObject<Item> PURPLE_FROSTED_CAKE;
    ///public static RegistryObject<Item> RAINBOW_FROSTED_CAKE;
    ///public static RegistryObject<Item> PINK_EGG;
    ///public static RegistryObject<Item> ORANGE_EGG;
    ///public static RegistryObject<Item> YELLOW_EGG;
    ///public static RegistryObject<Item> LIME_EGG;
    ///public static RegistryObject<Item> CYAN_EGG;
    ///public static RegistryObject<Item> PURPLE_EGG;
    ///public static RegistryObject<Item> RAINBOW_EGG;
    ///public static RegistryObject<Item> RAINBOW_CHICKEN_SPAWN_EGG;

    public static void registerItems() {
        /// strawberry fields
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
        STRAWBERRY_BOAT = register("strawberry_boat", () -> boatItem(MysticBoat.Type.STRAWBERRY));
        STRAWBERRY_CHEST_BOAT = register("strawberry_chest_boat", () -> chestBoatItem(MysticBoat.Type.STRAWBERRY));

        /// lavender meadow
        LAVENDER_BLOSSOMS = register("lavender_blossoms", () -> blockItem(MysticBlocks.LAVENDER_BLOSSOMS.get()));
        LAVENDER_BLOSSOM_SAPLING = register("lavender_blossom_sapling", () -> blockItem(MysticBlocks.LAVENDER_BLOSSOM_SAPLING.get()));
        LAVENDER_LOG = register("lavender_log", () -> blockItem(MysticBlocks.LAVENDER_LOG.get()));
        STRIPPED_LAVENDER_LOG = register("stripped_lavender_log", () -> blockItem(MysticBlocks.STRIPPED_LAVENDER_LOG.get()));
        LAVENDER_WOOD = register("lavender_wood", () -> blockItem(MysticBlocks.LAVENDER_WOOD.get()));
        STRIPPED_LAVENDER_WOOD = register("stripped_lavender_wood", () -> blockItem(MysticBlocks.STRIPPED_LAVENDER_WOOD.get()));
        LAVENDER_PLANKS = register("lavender_planks", () -> blockItem(MysticBlocks.LAVENDER_PLANKS.get()));
        LAVENDER_STAIRS = register("lavender_stairs", () -> blockItem(MysticBlocks.LAVENDER_STAIRS.get()));
        LAVENDER_SLAB = register("lavender_slab", () -> blockItem(MysticBlocks.LAVENDER_SLAB.get()));
        LAVENDER_FENCE = register("lavender_fence", () -> blockItem(MysticBlocks.LAVENDER_FENCE.get()));
        LAVENDER_FENCE_GATE = register("lavender_fence_gate", () -> blockItem(MysticBlocks.LAVENDER_FENCE_GATE.get()));
        LAVENDER_BUTTON = register("lavender_button", () -> blockItem(MysticBlocks.LAVENDER_BUTTON.get()));
        LAVENDER_PRESSURE_PLATE = register("lavender_pressure_plate", () -> blockItem(MysticBlocks.LAVENDER_PRESSURE_PLATE.get()));
        LAVENDER_TRAPDOOR = register("lavender_trapdoor", () -> blockItem(MysticBlocks.LAVENDER_TRAPDOOR.get()));
        LAVENDER_DOOR = register("lavender_door", () -> blockItem(MysticBlocks.LAVENDER_DOOR.get()));
        LAVENDER_SIGN = register("lavender_sign", () -> signItem(MysticBlocks.LAVENDER_SIGN.get(), MysticBlocks.LAVENDER_WALL_SIGN.get()));
        LAVENDER_HANGING_SIGN = register("lavender_hanging_sign", () -> hangingSignItem(MysticBlocks.LAVENDER_HANGING_SIGN.get(), MysticBlocks.LAVENDER_WALL_HANGING_SIGN.get()));
        LAVENDER_BOAT = register("lavender_boat", () -> boatItem(MysticBoat.Type.LAVENDER));
        LAVENDER_CHEST_BOAT = register("lavender_chest_boat", () -> chestBoatItem(MysticBoat.Type.LAVENDER));

        /// bamboo blossom forest
        PINK_CHERRY_BLOSSOMS = register("pink_cherry_blossoms", () -> blockItem(MysticBlocks.PINK_CHERRY_BLOSSOMS.get()));
        PINK_CHERRY_BLOSSOM_SAPLING = register("pink_cherry_blossom_sapling", () -> blockItem(MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING.get()));
        WHITE_CHERRY_BLOSSOMS = register("white_cherry_blossoms", () -> blockItem(MysticBlocks.WHITE_CHERRY_BLOSSOMS.get()));
        WHITE_CHERRY_BLOSSOM_SAPLING = register("white_cherry_blossom_sapling", () -> blockItem(MysticBlocks.WHITE_CHERRY_BLOSSOM_SAPLING.get()));
        BLACK_CHERRY_LOG = register("black_cherry_log", () -> blockItem(MysticBlocks.BLACK_CHERRY_LOG.get()));
        STRIPPED_BLACK_CHERRY_LOG = register("stripped_black_cherry_log", () -> blockItem(MysticBlocks.STRIPPED_BLACK_CHERRY_LOG.get()));
        BLACK_CHERRY_WOOD = register("black_cherry_wood", () -> blockItem(MysticBlocks.BLACK_CHERRY_WOOD.get()));
        STRIPPED_BLACK_CHERRY_WOOD = register("stripped_black_cherry_wood", () -> blockItem(MysticBlocks.STRIPPED_BLACK_CHERRY_WOOD.get()));
        BLACK_CHERRY_PLANKS = register("black_cherry_planks", () -> blockItem(MysticBlocks.BLACK_CHERRY_PLANKS.get()));
        BLACK_CHERRY_STAIRS = register("black_cherry_stairs", () -> blockItem(MysticBlocks.BLACK_CHERRY_STAIRS.get()));
        BLACK_CHERRY_SLAB = register("black_cherry_slab", () -> blockItem(MysticBlocks.BLACK_CHERRY_SLAB.get()));
        BLACK_CHERRY_FENCE = register("black_cherry_fence", () -> blockItem(MysticBlocks.BLACK_CHERRY_FENCE.get()));
        BLACK_CHERRY_FENCE_GATE = register("black_cherry_fence_gate", () -> blockItem(MysticBlocks.BLACK_CHERRY_FENCE_GATE.get()));
        BLACK_CHERRY_BUTTON = register("black_cherry_button", () -> blockItem(MysticBlocks.BLACK_CHERRY_BUTTON.get()));
        BLACK_CHERRY_PRESSURE_PLATE = register("black_cherry_pressure_plate", () -> blockItem(MysticBlocks.BLACK_CHERRY_PRESSURE_PLATE.get()));
        BLACK_CHERRY_TRAPDOOR = register("black_cherry_trapdoor", () -> blockItem(MysticBlocks.BLACK_CHERRY_TRAPDOOR.get()));
        BLACK_CHERRY_DOOR = register("black_cherry_door", () -> blockItem(MysticBlocks.BLACK_CHERRY_DOOR.get()));
        BLACK_CHERRY_SIGN = register("black_cherry_sign", () -> signItem(MysticBlocks.BLACK_CHERRY_SIGN.get(), MysticBlocks.BLACK_CHERRY_WALL_SIGN.get()));
        BLACK_CHERRY_HANGING_SIGN = register("black_cherry_hanging_sign", () -> hangingSignItem(MysticBlocks.BLACK_CHERRY_HANGING_SIGN.get(), MysticBlocks.BLACK_CHERRY_WALL_HANGING_SIGN.get()));
        BLACK_CHERRY_BOAT = register("black_cherry_boat", () -> boatItem(MysticBoat.Type.BLACK_CHERRY));
        BLACK_CHERRY_CHEST_BOAT = register("black_cherry_chest_boat", () -> chestBoatItem(MysticBoat.Type.BLACK_CHERRY));

        ///SPRING_BAMBOO = register("spring_bamboo", () -> blockItem(MysticBlocks.SPRING_BAMBOO.get()));
        ///STRIPPED_SPRING_BAMBOO = register("stripped_spring_bamboo", () -> blockItem(MysticBlocks.STRIPPED_SPRING_BAMBOO.get()));
        SPRING_BAMBOO_BLOCK = register("spring_bamboo_block", () -> blockItem(MysticBlocks.SPRING_BAMBOO_BLOCK.get()));
        STRIPPED_SPRING_BAMBOO_BLOCK = register("stripped_spring_bamboo_block", () -> blockItem(MysticBlocks.STRIPPED_SPRING_BAMBOO_BLOCK.get()));
        SPRING_PLANKS = register("spring_planks", () -> blockItem(MysticBlocks.SPRING_PLANKS.get()));
        SPRING_MOSAIC = register("spring_mosaic", () -> blockItem(MysticBlocks.SPRING_MOSAIC.get()));
        SPRING_STAIRS = register("spring_stairs", () -> blockItem(MysticBlocks.SPRING_STAIRS.get()));
        SPRING_MOSAIC_STAIRS = register("spring_mosaic_stairs", () -> blockItem(MysticBlocks.SPRING_MOSAIC_STAIRS.get()));
        SPRING_SLAB = register("spring_slab", () -> blockItem(MysticBlocks.SPRING_SLAB.get()));
        SPRING_MOSAIC_SLAB = register("spring_mosaic_slab", () -> blockItem(MysticBlocks.SPRING_MOSAIC_SLAB.get()));
        SPRING_FENCE = register("spring_fence", () -> blockItem(MysticBlocks.SPRING_FENCE.get()));
        SPRING_FENCE_GATE = register("spring_fence_gate", () -> blockItem(MysticBlocks.SPRING_FENCE_GATE.get()));
        SPRING_BUTTON = register("spring_button", () -> blockItem(MysticBlocks.SPRING_BUTTON.get()));
        SPRING_PRESSURE_PLATE = register("spring_pressure_plate", () -> blockItem(MysticBlocks.SPRING_PRESSURE_PLATE.get()));
        SPRING_TRAPDOOR = register("spring_trapdoor", () -> blockItem(MysticBlocks.SPRING_TRAPDOOR.get()));
        SPRING_DOOR = register("spring_door", () -> blockItem(MysticBlocks.SPRING_DOOR.get()));
        SPRING_SIGN = register("spring_sign", () -> signItem(MysticBlocks.SPRING_SIGN.get(), MysticBlocks.SPRING_WALL_SIGN.get()));
        SPRING_HANGING_SIGN = register("spring_hanging_sign", () -> hangingSignItem(MysticBlocks.SPRING_HANGING_SIGN.get(), MysticBlocks.SPRING_WALL_HANGING_SIGN.get()));
        SPRING_RAFT = register("spring_raft", () -> boatItem(MysticBoat.Type.SPRING));
        SPRING_CHEST_RAFT = register("spring_chest_raft", () -> chestBoatItem(MysticBoat.Type.SPRING));

        /// autumnal grove
        MAPLE_LEAVES = register("maple_leaves", () -> blockItem(MysticBlocks.MAPLE_LEAVES.get()));
        ///MAPLE_LEAF_PILE = register("maple_leaf_pile", () -> blockItem(MysticBlocks.MAPLE_LEAF_PILE.get()));
        ///MAPLE_LEAF_LITTER = register("maple_leaf_litter", () -> blockItem(MysticBlocks.MAPLE_LEAF_LITTER.get()));
        MAPLE_SAPLING = register("maple_sapling", () -> blockItem(MysticBlocks.MAPLE_SAPLING.get()));
        SPICED_MAPLE_LEAVES = register("spiced_maple_leaves", () -> blockItem(MysticBlocks.SPICED_MAPLE_LEAVES.get()));
        ///SPICED_MAPLE_LEAF_PILE = register("spiced_maple_leaf_pile", () -> blockItem(MysticBlocks.SPICED_MAPLE_LEAF_PILE.get()));
        ///SPICED_MAPLE_LEAF_LITTER = register("spiced_maple_leaf_litter", () -> blockItem(MysticBlocks.SPICED_MAPLE_LEAF_LITTER.get()));
        SPICED_MAPLE_SAPLING = register("spiced_maple_sapling", () -> blockItem(MysticBlocks.SPICED_MAPLE_SAPLING.get()));
        ORANGE_MAPLE_LEAVES = register("orange_maple_leaves", () -> blockItem(MysticBlocks.ORANGE_MAPLE_LEAVES.get()));
        ///ORANGE_MAPLE_LEAF_PILE = register("orange_maple_leaf_pile", () -> blockItem(MysticBlocks.ORANGE_MAPLE_LEAF_PILE.get()));
        ///ORANGE_MAPLE_LEAF_LITTER = register("orange_maple_leaf_litter", () -> blockItem(MysticBlocks.ORANGE_MAPLE_LEAF_LITTER.get()));
        ORANGE_MAPLE_SAPLING = register("orange_maple_sapling", () -> blockItem(MysticBlocks.ORANGE_MAPLE_SAPLING.get()));
        YELLOW_MAPLE_LEAVES = register("yellow_maple_leaves", () -> blockItem(MysticBlocks.YELLOW_MAPLE_LEAVES.get()));
        ///YELLOW_MAPLE_LEAF_PILE = register("yellow_maple_leaf_pile", () -> blockItem(MysticBlocks.YELLOW_MAPLE_LEAF_PILE.get()));
        ///YELLOW_MAPLE_LEAF_LITTER = register("yellow_maple_leaf_litter", () -> blockItem(MysticBlocks.YELLOW_MAPLE_LEAF_LITTER.get()));
        YELLOW_MAPLE_SAPLING = register("yellow_maple_sapling", () -> blockItem(MysticBlocks.YELLOW_MAPLE_SAPLING.get()));
        MAPLE_LOG = register("maple_log", () -> blockItem(MysticBlocks.MAPLE_LOG.get()));
        WHITE_MAPLE_LOG = register("white_maple_log", () -> blockItem(MysticBlocks.WHITE_MAPLE_LOG.get()));
        STRIPPED_MAPLE_LOG = register("stripped_maple_log", () -> blockItem(MysticBlocks.STRIPPED_MAPLE_LOG.get()));
        MAPLE_WOOD = register("maple_wood", () -> blockItem(MysticBlocks.MAPLE_WOOD.get()));
        WHITE_MAPLE_WOOD = register("white_maple_wood", () -> blockItem(MysticBlocks.WHITE_MAPLE_WOOD.get()));
        STRIPPED_MAPLE_WOOD = register("stripped_maple_wood", () -> blockItem(MysticBlocks.STRIPPED_MAPLE_WOOD.get()));
        MAPLE_PLANKS = register("maple_planks", () -> blockItem(MysticBlocks.MAPLE_PLANKS.get()));
        MAPLE_STAIRS = register("maple_stairs", () -> blockItem(MysticBlocks.MAPLE_STAIRS.get()));
        MAPLE_SLAB = register("maple_slab", () -> blockItem(MysticBlocks.MAPLE_SLAB.get()));
        MAPLE_FENCE = register("maple_fence", () -> blockItem(MysticBlocks.MAPLE_FENCE.get()));
        MAPLE_FENCE_GATE = register("maple_fence_gate", () -> blockItem(MysticBlocks.MAPLE_FENCE_GATE.get()));
        MAPLE_BUTTON = register("maple_button", () -> blockItem(MysticBlocks.MAPLE_BUTTON.get()));
        MAPLE_PRESSURE_PLATE = register("maple_pressure_plate", () -> blockItem(MysticBlocks.MAPLE_PRESSURE_PLATE.get()));
        MAPLE_TRAPDOOR = register("maple_trapdoor", () -> blockItem(MysticBlocks.MAPLE_TRAPDOOR.get()));
        MAPLE_DOOR = register("maple_door", () -> blockItem(MysticBlocks.MAPLE_DOOR.get()));
        MAPLE_SIGN = register("maple_sign", () -> signItem(MysticBlocks.MAPLE_SIGN.get(), MysticBlocks.MAPLE_WALL_SIGN.get()));
        MAPLE_HANGING_SIGN = register("maple_hanging_sign", () -> hangingSignItem(MysticBlocks.MAPLE_HANGING_SIGN.get(), MysticBlocks.MAPLE_WALL_HANGING_SIGN.get()));
        MAPLE_BOAT = register("maple_boat", () -> boatItem(MysticBoat.Type.MAPLE));
        MAPLE_CHEST_BOAT = register("maple_chest_boat", () -> chestBoatItem(MysticBoat.Type.MAPLE));

        /// lush oasis
        GRASSY_LUSH_SAND = register("grassy_lush_sand", () -> blockItem(MysticBlocks.GRASSY_LUSH_SAND.get()));
        LUSH_SAND = register("lush_sand", () -> blockItem(MysticBlocks.LUSH_SAND.get()));
        LUSH_SANDSTONE = register("lush_sandstone", () -> blockItem(MysticBlocks.LUSH_SANDSTONE.get()));
        LUSH_SANDSTONE_STAIRS = register("lush_sandstone_stairs", () -> blockItem(MysticBlocks.LUSH_SANDSTONE_STAIRS.get()));
        LUSH_SANDSTONE_SLAB = register("lush_sandstone_slab", () -> blockItem(MysticBlocks.LUSH_SANDSTONE_SLAB.get()));
        LUSH_SANDSTONE_WALL = register("lush_sandstone_wall", () -> blockItem(MysticBlocks.LUSH_SANDSTONE_WALL.get()));
        CHISELED_LUSH_SANDSTONE = register("chiseled_lush_sandstone", () -> blockItem(MysticBlocks.CHISELED_LUSH_SANDSTONE.get()));
        CUT_LUSH_SANDSTONE = register("cut_lush_sandstone", () -> blockItem(MysticBlocks.CUT_LUSH_SANDSTONE.get()));
        CUT_LUSH_SANDSTONE_SLAB = register("cut_lush_sandstone_slab", () -> blockItem(MysticBlocks.CUT_LUSH_SANDSTONE_SLAB.get()));
        SMOOTH_LUSH_SANDSTONE = register("smooth_lush_sandstone", () -> blockItem(MysticBlocks.SMOOTH_LUSH_SANDSTONE.get()));
        SMOOTH_LUSH_SANDSTONE_STAIRS = register("smooth_lush_sandstone_stairs", () -> blockItem(MysticBlocks.SMOOTH_LUSH_SANDSTONE_STAIRS.get()));
        SMOOTH_LUSH_SANDSTONE_SLAB = register("smooth_lush_sandstone_slab", () -> blockItem(MysticBlocks.SMOOTH_LUSH_SANDSTONE_SLAB.get()));

        PEACH_LEAVES = register("peach_leaves", () -> blockItem(MysticBlocks.PEACH_LEAVES.get()));
        PEACH_SAPLING = register("peach_sapling", () -> blockItem(MysticBlocks.PEACH_SAPLING.get()));
        PEACH_LOG = register("peach_log", () -> blockItem(MysticBlocks.PEACH_LOG.get()));
        STRIPPED_PEACH_LOG = register("stripped_peach_log", () -> blockItem(MysticBlocks.STRIPPED_PEACH_LOG.get()));
        PEACH_WOOD = register("peach_wood", () -> blockItem(MysticBlocks.PEACH_WOOD.get()));
        STRIPPED_PEACH_WOOD = register("stripped_peach_wood", () -> blockItem(MysticBlocks.STRIPPED_PEACH_WOOD.get()));
        PEACH_PLANKS = register("peach_planks", () -> blockItem(MysticBlocks.PEACH_PLANKS.get()));
        PEACH_STAIRS = register("peach_stairs", () -> blockItem(MysticBlocks.PEACH_STAIRS.get()));
        PEACH_SLAB = register("peach_slab", () -> blockItem(MysticBlocks.PEACH_SLAB.get()));
        PEACH_FENCE = register("peach_fence", () -> blockItem(MysticBlocks.PEACH_FENCE.get()));
        PEACH_FENCE_GATE = register("peach_fence_gate", () -> blockItem(MysticBlocks.PEACH_FENCE_GATE.get()));
        PEACH_BUTTON = register("peach_button", () -> blockItem(MysticBlocks.PEACH_BUTTON.get()));
        PEACH_PRESSURE_PLATE = register("peach_pressure_plate", () -> blockItem(MysticBlocks.PEACH_PRESSURE_PLATE.get()));
        PEACH_TRAPDOOR = register("peach_trapdoor", () -> blockItem(MysticBlocks.PEACH_TRAPDOOR.get()));
        PEACH_DOOR = register("peach_door", () -> blockItem(MysticBlocks.PEACH_DOOR.get()));
        PEACH_SIGN = register("peach_sign", () -> signItem(MysticBlocks.PEACH_SIGN.get(), MysticBlocks.PEACH_WALL_SIGN.get()));
        PEACH_HANGING_SIGN = register("peach_hanging_sign", () -> hangingSignItem(MysticBlocks.PEACH_HANGING_SIGN.get(), MysticBlocks.PEACH_WALL_HANGING_SIGN.get()));
        PEACH_BOAT = register("peach_boat", () -> boatItem(MysticBoat.Type.PEACH));
        PEACH_CHEST_BOAT = register("peach_chest_boat", () -> chestBoatItem(MysticBoat.Type.PEACH));

        /// lagoon
        SEA_SHRUB_LEAVES = register("sea_shrub_leaves", () -> blockItem(MysticBlocks.SEA_SHRUB_LEAVES.get()));
        SEA_SHRUB = register("sea_shrub", () -> blockItem(MysticBlocks.SEA_SHRUB.get()));
        SEA_FOAM_LOG = register("sea_foam_log", () -> blockItem(MysticBlocks.SEA_FOAM_LOG.get()));
        STRIPPED_SEA_FOAM_LOG = register("stripped_sea_foam_log", () -> blockItem(MysticBlocks.STRIPPED_SEA_FOAM_LOG.get()));
        SEA_FOAM_WOOD = register("sea_foam_wood", () -> blockItem(MysticBlocks.SEA_FOAM_WOOD.get()));
        STRIPPED_SEA_FOAM_WOOD = register("stripped_sea_foam_wood", () -> blockItem(MysticBlocks.STRIPPED_SEA_FOAM_WOOD.get()));
        SEA_FOAM_PLANKS = register("sea_foam_planks", () -> blockItem(MysticBlocks.SEA_FOAM_PLANKS.get()));
        SEA_FOAM_STAIRS = register("sea_foam_stairs", () -> blockItem(MysticBlocks.SEA_FOAM_STAIRS.get()));
        SEA_FOAM_SLAB = register("sea_foam_slab", () -> blockItem(MysticBlocks.SEA_FOAM_SLAB.get()));
        SEA_FOAM_FENCE = register("sea_foam_fence", () -> blockItem(MysticBlocks.SEA_FOAM_FENCE.get()));
        SEA_FOAM_FENCE_GATE = register("sea_foam_fence_gate", () -> blockItem(MysticBlocks.SEA_FOAM_FENCE_GATE.get()));
        SEA_FOAM_BUTTON = register("sea_foam_button", () -> blockItem(MysticBlocks.SEA_FOAM_BUTTON.get()));
        SEA_FOAM_PRESSURE_PLATE = register("sea_foam_pressure_plate", () -> blockItem(MysticBlocks.SEA_FOAM_PRESSURE_PLATE.get()));
        SEA_FOAM_TRAPDOOR = register("sea_foam_trapdoor", () -> blockItem(MysticBlocks.SEA_FOAM_TRAPDOOR.get()));
        SEA_FOAM_DOOR = register("sea_foam_door", () -> blockItem(MysticBlocks.SEA_FOAM_DOOR.get()));
        SEA_FOAM_SIGN = register("sea_foam_sign", () -> signItem(MysticBlocks.SEA_FOAM_SIGN.get(), MysticBlocks.SEA_FOAM_WALL_SIGN.get()));
        SEA_FOAM_HANGING_SIGN = register("sea_foam_hanging_sign", () -> hangingSignItem(MysticBlocks.SEA_FOAM_HANGING_SIGN.get(), MysticBlocks.SEA_FOAM_WALL_HANGING_SIGN.get()));
        SEA_FOAM_BOAT = register("sea_foam_boat", () -> boatItem(MysticBoat.Type.SEA_FOAM));
        SEA_FOAM_CHEST_BOAT = register("sea_foam_chest_boat", () -> chestBoatItem(MysticBoat.Type.SEA_FOAM));

        /// tropics
        TROPICAL_LEAVES = register("tropical_leaves", () -> blockItem(MysticBlocks.TROPICAL_LEAVES.get()));
        TROPICAL_SAPLING = register("tropical_sapling", () -> blockItem(MysticBlocks.TROPICAL_SAPLING.get()));
        TROPICAL_LOG = register("tropical_log", () -> blockItem(MysticBlocks.TROPICAL_LOG.get()));
        STRIPPED_TROPICAL_LOG = register("stripped_tropical_log", () -> blockItem(MysticBlocks.STRIPPED_TROPICAL_LOG.get()));
        TROPICAL_WOOD = register("tropical_wood", () -> blockItem(MysticBlocks.TROPICAL_WOOD.get()));
        STRIPPED_TROPICAL_WOOD = register("stripped_tropical_wood", () -> blockItem(MysticBlocks.STRIPPED_TROPICAL_WOOD.get()));
        TROPICAL_PLANKS = register("tropical_planks", () -> blockItem(MysticBlocks.TROPICAL_PLANKS.get()));
        TROPICAL_STAIRS = register("tropical_stairs", () -> blockItem(MysticBlocks.TROPICAL_STAIRS.get()));
        TROPICAL_SLAB = register("tropical_slab", () -> blockItem(MysticBlocks.TROPICAL_SLAB.get()));
        TROPICAL_FENCE = register("tropical_fence", () -> blockItem(MysticBlocks.TROPICAL_FENCE.get()));
        TROPICAL_FENCE_GATE = register("tropical_fence_gate", () -> blockItem(MysticBlocks.TROPICAL_FENCE_GATE.get()));
        TROPICAL_BUTTON = register("tropical_button", () -> blockItem(MysticBlocks.TROPICAL_BUTTON.get()));
        TROPICAL_PRESSURE_PLATE = register("tropical_pressure_plate", () -> blockItem(MysticBlocks.TROPICAL_PRESSURE_PLATE.get()));
        TROPICAL_TRAPDOOR = register("tropical_trapdoor", () -> blockItem(MysticBlocks.TROPICAL_TRAPDOOR.get()));
        TROPICAL_DOOR = register("tropical_door", () -> blockItem(MysticBlocks.TROPICAL_DOOR.get()));
        TROPICAL_SIGN = register("tropical_sign", () -> signItem(MysticBlocks.TROPICAL_SIGN.get(), MysticBlocks.TROPICAL_WALL_SIGN.get()));
        TROPICAL_HANGING_SIGN = register("tropical_hanging_sign", () -> hangingSignItem(MysticBlocks.TROPICAL_HANGING_SIGN.get(), MysticBlocks.TROPICAL_WALL_HANGING_SIGN.get()));
        TROPICAL_BOAT = register("tropical_boat", () -> boatItem(MysticBoat.Type.TROPICAL));
        TROPICAL_CHEST_BOAT = register("tropical_chest_boat", () -> chestBoatItem(MysticBoat.Type.TROPICAL));

        VANILLA_LEAVES = register("vanilla_leaves", () -> blockItem(MysticBlocks.VANILLA_LEAVES.get()));
        VANILLA_SAPLING = register("vanilla_sapling", () -> blockItem(MysticBlocks.VANILLA_SAPLING.get()));
        VANILLA_LOG = register("vanilla_log", () -> blockItem(MysticBlocks.VANILLA_LOG.get()));
        STRIPPED_VANILLA_LOG = register("stripped_vanilla_log", () -> blockItem(MysticBlocks.STRIPPED_VANILLA_LOG.get()));
        VANILLA_WOOD = register("vanilla_wood", () -> blockItem(MysticBlocks.VANILLA_WOOD.get()));
        STRIPPED_VANILLA_WOOD = register("stripped_vanilla_wood", () -> blockItem(MysticBlocks.STRIPPED_VANILLA_WOOD.get()));
        VANILLA_PLANKS = register("vanilla_planks", () -> blockItem(MysticBlocks.VANILLA_PLANKS.get()));
        VANILLA_STAIRS = register("vanilla_stairs", () -> blockItem(MysticBlocks.VANILLA_STAIRS.get()));
        VANILLA_SLAB = register("vanilla_slab", () -> blockItem(MysticBlocks.VANILLA_SLAB.get()));
        VANILLA_FENCE = register("vanilla_fence", () -> blockItem(MysticBlocks.VANILLA_FENCE.get()));
        VANILLA_FENCE_GATE = register("vanilla_fence_gate", () -> blockItem(MysticBlocks.VANILLA_FENCE_GATE.get()));
        VANILLA_BUTTON = register("vanilla_button", () -> blockItem(MysticBlocks.VANILLA_BUTTON.get()));
        VANILLA_PRESSURE_PLATE = register("vanilla_pressure_plate", () -> blockItem(MysticBlocks.VANILLA_PRESSURE_PLATE.get()));
        VANILLA_TRAPDOOR = register("vanilla_trapdoor", () -> blockItem(MysticBlocks.VANILLA_TRAPDOOR.get()));
        VANILLA_DOOR = register("vanilla_door", () -> blockItem(MysticBlocks.VANILLA_DOOR.get()));
        VANILLA_SIGN = register("vanilla_sign", () -> signItem(MysticBlocks.VANILLA_SIGN.get(), MysticBlocks.VANILLA_WALL_SIGN.get()));
        VANILLA_HANGING_SIGN = register("vanilla_hanging_sign", () -> hangingSignItem(MysticBlocks.VANILLA_HANGING_SIGN.get(), MysticBlocks.VANILLA_WALL_HANGING_SIGN.get()));
        VANILLA_BOAT = register("vanilla_boat", () -> boatItem(MysticBoat.Type.VANILLA));
        VANILLA_CHEST_BOAT = register("vanilla_chest_boat", () -> chestBoatItem(MysticBoat.Type.VANILLA));
    }

    private static RegistryObject<Item> register(String name, Supplier<Item> item) {
        return REGISTRY.register(BuiltInRegistries.ITEM, name, item);
    }

}