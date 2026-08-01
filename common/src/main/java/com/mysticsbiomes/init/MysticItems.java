package com.mysticsbiomes.init;

import api.mystanica.registry.Registrar;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.entity.vehicle.MysticBoat;
import com.mysticsbiomes.common.item.BugHabitatItem;
import com.mysticsbiomes.common.item.GlassJarItem;
import com.mysticsbiomes.common.item.MysticItemBlockItem;
import com.mysticsbiomes.common.item.RainbowEggItem;
import api.mystanica.registry.RegistryEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;

import java.util.function.Supplier;

import static com.mysticsbiomes.common.item.ItemTemplate.*;

public class MysticItems {
    public static final Registrar<Item> ITEMS = Registrar.create(Registries.ITEM, MysticsBiomes.modId);

    /// strawberry fields
    public static final RegistryEntry<Item> STRAWBERRY_BLOSSOMS = register("strawberry_blossoms", () -> blockItem(MysticBlocks.STRAWBERRY_BLOSSOMS));
    public static final RegistryEntry<Item> STRAWBERRY_BLOSSOM_SAPLING = register("strawberry_blossom_sapling", () -> blockItem(MysticBlocks.STRAWBERRY_BLOSSOM_SAPLING));
    public static final RegistryEntry<Item> STRAWBERRY_LOG = register("strawberry_log", () -> blockItem(MysticBlocks.STRAWBERRY_LOG));
    public static final RegistryEntry<Item> STRIPPED_STRAWBERRY_LOG = register("stripped_strawberry_log", () -> blockItem(MysticBlocks.STRIPPED_STRAWBERRY_LOG));
    public static final RegistryEntry<Item> STRAWBERRY_WOOD = register("strawberry_wood", () -> blockItem(MysticBlocks.STRAWBERRY_WOOD));
    public static final RegistryEntry<Item> STRIPPED_STRAWBERRY_WOOD = register("stripped_strawberry_wood", () -> blockItem(MysticBlocks.STRIPPED_STRAWBERRY_WOOD));
    public static final RegistryEntry<Item> STRAWBERRY_PLANKS = register("strawberry_planks", () -> blockItem(MysticBlocks.STRAWBERRY_PLANKS));
    public static final RegistryEntry<Item> STRAWBERRY_STAIRS = register("strawberry_stairs", () -> blockItem(MysticBlocks.STRAWBERRY_STAIRS));
    public static final RegistryEntry<Item> STRAWBERRY_SLAB = register("strawberry_slab", () -> blockItem(MysticBlocks.STRAWBERRY_SLAB));
    public static final RegistryEntry<Item> STRAWBERRY_FENCE = register("strawberry_fence", () -> blockItem(MysticBlocks.STRAWBERRY_FENCE));
    public static final RegistryEntry<Item> STRAWBERRY_FENCE_GATE = register("strawberry_fence_gate", () -> blockItem(MysticBlocks.STRAWBERRY_FENCE_GATE));
    public static final RegistryEntry<Item> STRAWBERRY_BUTTON = register("strawberry_button", () -> blockItem(MysticBlocks.STRAWBERRY_BUTTON));
    public static final RegistryEntry<Item> STRAWBERRY_PRESSURE_PLATE = register("strawberry_pressure_plate", () -> blockItem(MysticBlocks.STRAWBERRY_PRESSURE_PLATE));
    public static final RegistryEntry<Item> STRAWBERRY_TRAPDOOR = register("strawberry_trapdoor", () -> blockItem(MysticBlocks.STRAWBERRY_TRAPDOOR));
    public static final RegistryEntry<Item> STRAWBERRY_DOOR = register("strawberry_door", () -> blockItem(MysticBlocks.STRAWBERRY_DOOR));
    public static final RegistryEntry<Item> STRAWBERRY_SIGN = register("strawberry_sign", () -> signItem(MysticBlocks.STRAWBERRY_SIGN, MysticBlocks.STRAWBERRY_WALL_SIGN));
    public static final RegistryEntry<Item> STRAWBERRY_HANGING_SIGN = register("strawberry_hanging_sign", () -> hangingSignItem(MysticBlocks.STRAWBERRY_HANGING_SIGN, MysticBlocks.STRAWBERRY_WALL_HANGING_SIGN));
    public static final RegistryEntry<Item> STRAWBERRY_BOAT = register("strawberry_boat", () -> boatItem(MysticBoat.Type.STRAWBERRY));
    public static final RegistryEntry<Item> STRAWBERRY_CHEST_BOAT = register("strawberry_chest_boat", () -> chestBoatItem(MysticBoat.Type.STRAWBERRY));

    /// lavender meadow
    public static final RegistryEntry<Item> LAVENDER_BLOSSOMS = register("lavender_blossoms", () -> blockItem(MysticBlocks.LAVENDER_BLOSSOMS));
    public static final RegistryEntry<Item> LAVENDER_BLOSSOM_SAPLING = register("lavender_blossom_sapling", () -> blockItem(MysticBlocks.LAVENDER_BLOSSOM_SAPLING));
    public static final RegistryEntry<Item> LAVENDER_LOG = register("lavender_log", () -> blockItem(MysticBlocks.LAVENDER_LOG));
    public static final RegistryEntry<Item> STRIPPED_LAVENDER_LOG = register("stripped_lavender_log", () -> blockItem(MysticBlocks.STRIPPED_LAVENDER_LOG));
    public static final RegistryEntry<Item> LAVENDER_WOOD = register("lavender_wood", () -> blockItem(MysticBlocks.LAVENDER_WOOD));
    public static final RegistryEntry<Item> STRIPPED_LAVENDER_WOOD = register("stripped_lavender_wood", () -> blockItem(MysticBlocks.STRIPPED_LAVENDER_WOOD));
    public static final RegistryEntry<Item> LAVENDER_PLANKS = register("lavender_planks", () -> blockItem(MysticBlocks.LAVENDER_PLANKS));
    public static final RegistryEntry<Item> LAVENDER_STAIRS = register("lavender_stairs", () -> blockItem(MysticBlocks.LAVENDER_STAIRS));
    public static final RegistryEntry<Item> LAVENDER_SLAB = register("lavender_slab", () -> blockItem(MysticBlocks.LAVENDER_SLAB));
    public static final RegistryEntry<Item> LAVENDER_FENCE = register("lavender_fence", () -> blockItem(MysticBlocks.LAVENDER_FENCE));
    public static final RegistryEntry<Item> LAVENDER_FENCE_GATE = register("lavender_fence_gate", () -> blockItem(MysticBlocks.LAVENDER_FENCE_GATE));
    public static final RegistryEntry<Item> LAVENDER_BUTTON = register("lavender_button", () -> blockItem(MysticBlocks.LAVENDER_BUTTON));
    public static final RegistryEntry<Item> LAVENDER_PRESSURE_PLATE = register("lavender_pressure_plate", () -> blockItem(MysticBlocks.LAVENDER_PRESSURE_PLATE));
    public static final RegistryEntry<Item> LAVENDER_TRAPDOOR = register("lavender_trapdoor", () -> blockItem(MysticBlocks.LAVENDER_TRAPDOOR));
    public static final RegistryEntry<Item> LAVENDER_DOOR = register("lavender_door", () -> blockItem(MysticBlocks.LAVENDER_DOOR));
    public static final RegistryEntry<Item> LAVENDER_SIGN = register("lavender_sign", () -> signItem(MysticBlocks.LAVENDER_SIGN, MysticBlocks.LAVENDER_WALL_SIGN));
    public static final RegistryEntry<Item> LAVENDER_HANGING_SIGN = register("lavender_hanging_sign", () -> hangingSignItem(MysticBlocks.LAVENDER_HANGING_SIGN, MysticBlocks.LAVENDER_WALL_HANGING_SIGN));
    public static final RegistryEntry<Item> LAVENDER_BOAT = register("lavender_boat", () -> boatItem(MysticBoat.Type.LAVENDER));
    public static final RegistryEntry<Item> LAVENDER_CHEST_BOAT = register("lavender_chest_boat", () -> chestBoatItem(MysticBoat.Type.LAVENDER));

    /// bamboo blossom forest
    public static final RegistryEntry<Item> PINK_CHERRY_BLOSSOMS = register("pink_cherry_blossoms", () -> blockItem(MysticBlocks.PINK_CHERRY_BLOSSOMS));
    ///public static final RegistryEntry<Item> PINK_CHERRY_PETALS;
    public static final RegistryEntry<Item> PINK_CHERRY_BLOSSOM_SAPLING = register("pink_cherry_blossom_sapling", () -> blockItem(MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING));
    public static final RegistryEntry<Item> WHITE_CHERRY_BLOSSOMS = register("white_cherry_blossoms", () -> blockItem(MysticBlocks.WHITE_CHERRY_BLOSSOMS));
    ///public static final RegistryEntry<Item> WHITE_CHERRY_PETALS;
    public static final RegistryEntry<Item> WHITE_CHERRY_BLOSSOM_SAPLING = register("white_cherry_blossom_sapling", () -> blockItem(MysticBlocks.WHITE_CHERRY_BLOSSOM_SAPLING));
    public static final RegistryEntry<Item> BLACK_CHERRY_LOG = register("black_cherry_log", () -> blockItem(MysticBlocks.BLACK_CHERRY_LOG));
    public static final RegistryEntry<Item> STRIPPED_BLACK_CHERRY_LOG = register("stripped_black_cherry_log", () -> blockItem(MysticBlocks.STRIPPED_BLACK_CHERRY_LOG));
    public static final RegistryEntry<Item> BLACK_CHERRY_WOOD = register("black_cherry_wood", () -> blockItem(MysticBlocks.BLACK_CHERRY_WOOD));
    public static final RegistryEntry<Item> STRIPPED_BLACK_CHERRY_WOOD = register("stripped_black_cherry_wood", () -> blockItem(MysticBlocks.STRIPPED_BLACK_CHERRY_WOOD));
    public static final RegistryEntry<Item> BLACK_CHERRY_PLANKS = register("black_cherry_planks", () -> blockItem(MysticBlocks.BLACK_CHERRY_PLANKS));
    public static final RegistryEntry<Item> BLACK_CHERRY_STAIRS = register("black_cherry_stairs", () -> blockItem(MysticBlocks.BLACK_CHERRY_STAIRS));
    public static final RegistryEntry<Item> BLACK_CHERRY_SLAB = register("black_cherry_slab", () -> blockItem(MysticBlocks.BLACK_CHERRY_SLAB));
    public static final RegistryEntry<Item> BLACK_CHERRY_FENCE = register("black_cherry_fence", () -> blockItem(MysticBlocks.BLACK_CHERRY_FENCE));
    public static final RegistryEntry<Item> BLACK_CHERRY_FENCE_GATE = register("black_cherry_fence_gate", () -> blockItem(MysticBlocks.BLACK_CHERRY_FENCE_GATE));
    public static final RegistryEntry<Item> BLACK_CHERRY_BUTTON = register("black_cherry_button", () -> blockItem(MysticBlocks.BLACK_CHERRY_BUTTON));
    public static final RegistryEntry<Item> BLACK_CHERRY_PRESSURE_PLATE = register("black_cherry_pressure_plate", () -> blockItem(MysticBlocks.BLACK_CHERRY_PRESSURE_PLATE));
    public static final RegistryEntry<Item> BLACK_CHERRY_TRAPDOOR = register("black_cherry_trapdoor", () -> blockItem(MysticBlocks.BLACK_CHERRY_TRAPDOOR));
    public static final RegistryEntry<Item> BLACK_CHERRY_DOOR = register("black_cherry_door", () -> blockItem(MysticBlocks.BLACK_CHERRY_DOOR));
    public static final RegistryEntry<Item> BLACK_CHERRY_SIGN = register("black_cherry_sign", () -> signItem(MysticBlocks.BLACK_CHERRY_SIGN, MysticBlocks.BLACK_CHERRY_WALL_SIGN));
    public static final RegistryEntry<Item> BLACK_CHERRY_HANGING_SIGN = register("black_cherry_hanging_sign", () -> hangingSignItem(MysticBlocks.BLACK_CHERRY_HANGING_SIGN, MysticBlocks.BLACK_CHERRY_WALL_HANGING_SIGN));
    public static final RegistryEntry<Item> BLACK_CHERRY_BOAT = register("black_cherry_boat", () -> boatItem(MysticBoat.Type.BLACK_CHERRY));
    public static final RegistryEntry<Item> BLACK_CHERRY_CHEST_BOAT = register("black_cherry_chest_boat", () -> chestBoatItem(MysticBoat.Type.BLACK_CHERRY));

    public static final RegistryEntry<Item> SPRING_BAMBOO = register("spring_bamboo", () -> blockItem(MysticBlocks.SPRING_BAMBOO));
    public static final RegistryEntry<Item> SPRING_BAMBOO_BLOCK = register("spring_bamboo_block", () -> blockItem(MysticBlocks.SPRING_BAMBOO_BLOCK));
    public static final RegistryEntry<Item> STRIPPED_SPRING_BAMBOO_BLOCK = register("stripped_spring_bamboo_block", () -> blockItem(MysticBlocks.STRIPPED_SPRING_BAMBOO_BLOCK));
    public static final RegistryEntry<Item> SPRING_PLANKS = register("spring_planks", () -> blockItem(MysticBlocks.SPRING_PLANKS));
    public static final RegistryEntry<Item> SPRING_MOSAIC = register("spring_mosaic", () -> blockItem(MysticBlocks.SPRING_MOSAIC));
    public static final RegistryEntry<Item> SPRING_STAIRS = register("spring_stairs", () -> blockItem(MysticBlocks.SPRING_STAIRS));
    public static final RegistryEntry<Item> SPRING_MOSAIC_STAIRS = register("spring_mosaic_stairs", () -> blockItem(MysticBlocks.SPRING_MOSAIC_STAIRS));
    public static final RegistryEntry<Item> SPRING_SLAB = register("spring_slab", () -> blockItem(MysticBlocks.SPRING_SLAB));
    public static final RegistryEntry<Item> SPRING_MOSAIC_SLAB = register("spring_mosaic_slab", () -> blockItem(MysticBlocks.SPRING_MOSAIC_SLAB));
    public static final RegistryEntry<Item> SPRING_FENCE = register("spring_fence", () -> blockItem(MysticBlocks.SPRING_FENCE));
    public static final RegistryEntry<Item> SPRING_FENCE_GATE = register("spring_fence_gate", () -> blockItem(MysticBlocks.SPRING_FENCE_GATE));
    public static final RegistryEntry<Item> SPRING_BUTTON = register("spring_button", () -> blockItem(MysticBlocks.SPRING_BUTTON));
    public static final RegistryEntry<Item> SPRING_PRESSURE_PLATE = register("spring_pressure_plate", () -> blockItem(MysticBlocks.SPRING_PRESSURE_PLATE));
    public static final RegistryEntry<Item> SPRING_TRAPDOOR = register("spring_trapdoor", () -> blockItem(MysticBlocks.SPRING_TRAPDOOR));
    public static final RegistryEntry<Item> SPRING_DOOR = register("spring_door", () -> blockItem(MysticBlocks.SPRING_DOOR));
    public static final RegistryEntry<Item> SPRING_SIGN = register("spring_sign", () -> signItem(MysticBlocks.SPRING_SIGN, MysticBlocks.SPRING_WALL_SIGN));
    public static final RegistryEntry<Item> SPRING_HANGING_SIGN = register("spring_hanging_sign", () -> hangingSignItem(MysticBlocks.SPRING_HANGING_SIGN, MysticBlocks.SPRING_WALL_HANGING_SIGN));
    public static final RegistryEntry<Item> SPRING_RAFT = register("spring_raft", () -> boatItem(MysticBoat.Type.SPRING));
    public static final RegistryEntry<Item> SPRING_CHEST_RAFT = register("spring_chest_raft", () -> chestBoatItem(MysticBoat.Type.SPRING));

    /// autumnal grove
    public static final RegistryEntry<Item> MAPLE_LEAVES = register("maple_leaves", () -> blockItem(MysticBlocks.MAPLE_LEAVES));
    public static final RegistryEntry<Item> MAPLE_LEAF_PILE = register("maple_leaf_pile", () -> blockItem(MysticBlocks.MAPLE_LEAF_PILE));
    public static final RegistryEntry<Item> MAPLE_LEAF_LITTER = register("maple_leaf_litter", () -> blockItem(MysticBlocks.MAPLE_LEAF_LITTER));
    public static final RegistryEntry<Item> MAPLE_SAPLING = register("maple_sapling", () -> blockItem(MysticBlocks.MAPLE_SAPLING));
    ///public static final RegistryEntry<Item> SPICED_MAPLE_LEAVES = register("spiced_maple_leaves", () -> blockItem(MysticBlocks.SPICED_MAPLE_LEAVES));
    ///public static final RegistryEntry<Item> SPICED_MAPLE_LEAF_PILE = register("spiced_maple_leaf_pile", () -> blockItem(MysticBlocks.SPICED_MAPLE_LEAF_PILE));
    ///public static final RegistryEntry<Item> SPICED_MAPLE_LEAF_LITTER = register("spiced_maple_leaf_litter", () -> blockItem(MysticBlocks.SPICED_MAPLE_LEAF_LITTER));
    ///public static final RegistryEntry<Item> SPICED_MAPLE_SAPLING = register("spiced_maple_sapling", () -> blockItem(MysticBlocks.SPICED_MAPLE_SAPLING));
    public static final RegistryEntry<Item> ORANGE_MAPLE_LEAVES = register("orange_maple_leaves", () -> blockItem(MysticBlocks.ORANGE_MAPLE_LEAVES));
    public static final RegistryEntry<Item> ORANGE_MAPLE_LEAF_PILE = register("orange_maple_leaf_pile", () -> blockItem(MysticBlocks.ORANGE_MAPLE_LEAF_PILE));
    public static final RegistryEntry<Item> ORANGE_MAPLE_LEAF_LITTER = register("orange_maple_leaf_litter", () -> blockItem(MysticBlocks.ORANGE_MAPLE_LEAF_LITTER));
    public static final RegistryEntry<Item> ORANGE_MAPLE_SAPLING = register("orange_maple_sapling", () -> blockItem(MysticBlocks.ORANGE_MAPLE_SAPLING));
    public static final RegistryEntry<Item> YELLOW_MAPLE_LEAVES = register("yellow_maple_leaves", () -> blockItem(MysticBlocks.YELLOW_MAPLE_LEAVES));
    public static final RegistryEntry<Item> YELLOW_MAPLE_LEAF_PILE = register("yellow_maple_leaf_pile", () -> blockItem(MysticBlocks.YELLOW_MAPLE_LEAF_PILE));
    public static final RegistryEntry<Item> YELLOW_MAPLE_LEAF_LITTER = register("yellow_maple_leaf_litter", () -> blockItem(MysticBlocks.YELLOW_MAPLE_LEAF_LITTER));
    public static final RegistryEntry<Item> YELLOW_MAPLE_SAPLING = register("yellow_maple_sapling", () -> blockItem(MysticBlocks.YELLOW_MAPLE_SAPLING));
    public static final RegistryEntry<Item> MAPLE_LOG = register("maple_log", () -> blockItem(MysticBlocks.MAPLE_LOG));
    public static final RegistryEntry<Item> WHITE_MAPLE_LOG = register("white_maple_log", () -> blockItem(MysticBlocks.WHITE_MAPLE_LOG));
    public static final RegistryEntry<Item> STRIPPED_MAPLE_LOG = register("stripped_maple_log", () -> blockItem(MysticBlocks.STRIPPED_MAPLE_LOG));
    public static final RegistryEntry<Item> MAPLE_WOOD = register("maple_wood", () -> blockItem(MysticBlocks.MAPLE_WOOD));
    public static final RegistryEntry<Item> WHITE_MAPLE_WOOD = register("white_maple_wood", () -> blockItem(MysticBlocks.WHITE_MAPLE_WOOD));
    public static final RegistryEntry<Item> STRIPPED_MAPLE_WOOD = register("stripped_maple_wood", () -> blockItem(MysticBlocks.STRIPPED_MAPLE_WOOD));
    public static final RegistryEntry<Item> MAPLE_PLANKS = register("maple_planks", () -> blockItem(MysticBlocks.MAPLE_PLANKS));
    public static final RegistryEntry<Item> MAPLE_STAIRS = register("maple_stairs", () -> blockItem(MysticBlocks.MAPLE_STAIRS));
    public static final RegistryEntry<Item> MAPLE_SLAB = register("maple_slab", () -> blockItem(MysticBlocks.MAPLE_SLAB));
    public static final RegistryEntry<Item> MAPLE_FENCE = register("maple_fence", () -> blockItem(MysticBlocks.MAPLE_FENCE));
    public static final RegistryEntry<Item> MAPLE_FENCE_GATE = register("maple_fence_gate", () -> blockItem(MysticBlocks.MAPLE_FENCE_GATE));
    public static final RegistryEntry<Item> MAPLE_BUTTON = register("maple_button", () -> blockItem(MysticBlocks.MAPLE_BUTTON));
    public static final RegistryEntry<Item> MAPLE_PRESSURE_PLATE = register("maple_pressure_plate", () -> blockItem(MysticBlocks.MAPLE_PRESSURE_PLATE));
    public static final RegistryEntry<Item> MAPLE_TRAPDOOR = register("maple_trapdoor", () -> blockItem(MysticBlocks.MAPLE_TRAPDOOR));
    public static final RegistryEntry<Item> MAPLE_DOOR = register("maple_door", () -> blockItem(MysticBlocks.MAPLE_DOOR));
    public static final RegistryEntry<Item> MAPLE_SIGN = register("maple_sign", () -> signItem(MysticBlocks.MAPLE_SIGN, MysticBlocks.MAPLE_WALL_SIGN));
    public static final RegistryEntry<Item> MAPLE_HANGING_SIGN = register("maple_hanging_sign", () -> hangingSignItem(MysticBlocks.MAPLE_HANGING_SIGN, MysticBlocks.MAPLE_WALL_HANGING_SIGN));
    public static final RegistryEntry<Item> MAPLE_BOAT = register("maple_boat", () -> boatItem(MysticBoat.Type.MAPLE));
    public static final RegistryEntry<Item> MAPLE_CHEST_BOAT = register("maple_chest_boat", () -> chestBoatItem(MysticBoat.Type.MAPLE));

    /// lush oasis
    public static final RegistryEntry<Item> GRASSY_LUSH_SAND = register("grassy_lush_sand", () -> blockItem(MysticBlocks.GRASSY_LUSH_SAND));
    public static final RegistryEntry<Item> LUSH_SAND = register("lush_sand", () -> blockItem(MysticBlocks.LUSH_SAND));
    public static final RegistryEntry<Item> LUSH_SANDSTONE = register("lush_sandstone", () -> blockItem(MysticBlocks.LUSH_SANDSTONE));
    public static final RegistryEntry<Item> LUSH_SANDSTONE_STAIRS = register("lush_sandstone_stairs", () -> blockItem(MysticBlocks.LUSH_SANDSTONE_STAIRS));
    public static final RegistryEntry<Item> LUSH_SANDSTONE_SLAB = register("lush_sandstone_slab", () -> blockItem(MysticBlocks.LUSH_SANDSTONE_SLAB));
    public static final RegistryEntry<Item> LUSH_SANDSTONE_WALL = register("lush_sandstone_wall", () -> blockItem(MysticBlocks.LUSH_SANDSTONE_WALL));
    public static final RegistryEntry<Item> CHISELED_LUSH_SANDSTONE = register("chiseled_lush_sandstone", () -> blockItem(MysticBlocks.CHISELED_LUSH_SANDSTONE));
    public static final RegistryEntry<Item> CUT_LUSH_SANDSTONE = register("cut_lush_sandstone", () -> blockItem(MysticBlocks.CUT_LUSH_SANDSTONE));
    public static final RegistryEntry<Item> CUT_LUSH_SANDSTONE_SLAB = register("cut_lush_sandstone_slab", () -> blockItem(MysticBlocks.CUT_LUSH_SANDSTONE_SLAB));
    public static final RegistryEntry<Item> SMOOTH_LUSH_SANDSTONE = register("smooth_lush_sandstone", () -> blockItem(MysticBlocks.SMOOTH_LUSH_SANDSTONE));
    public static final RegistryEntry<Item> SMOOTH_LUSH_SANDSTONE_STAIRS = register("smooth_lush_sandstone_stairs", () -> blockItem(MysticBlocks.SMOOTH_LUSH_SANDSTONE_STAIRS));
    public static final RegistryEntry<Item> SMOOTH_LUSH_SANDSTONE_SLAB = register("smooth_lush_sandstone_slab", () -> blockItem(MysticBlocks.SMOOTH_LUSH_SANDSTONE_SLAB));

    public static final RegistryEntry<Item> PEACH_LEAVES = register("peach_leaves", () -> blockItem(MysticBlocks.PEACH_LEAVES));
    public static final RegistryEntry<Item> PEACH_SAPLING = register("peach_sapling", () -> blockItem(MysticBlocks.PEACH_SAPLING));
    public static final RegistryEntry<Item> PEACH_LOG = register("peach_log", () -> blockItem(MysticBlocks.PEACH_LOG));
    public static final RegistryEntry<Item> STRIPPED_PEACH_LOG = register("stripped_peach_log", () -> blockItem(MysticBlocks.STRIPPED_PEACH_LOG));
    public static final RegistryEntry<Item> PEACH_WOOD = register("peach_wood", () -> blockItem(MysticBlocks.PEACH_WOOD));
    public static final RegistryEntry<Item> STRIPPED_PEACH_WOOD = register("stripped_peach_wood", () -> blockItem(MysticBlocks.STRIPPED_PEACH_WOOD));
    public static final RegistryEntry<Item> PEACH_PLANKS = register("peach_planks", () -> blockItem(MysticBlocks.PEACH_PLANKS));
    public static final RegistryEntry<Item> PEACH_STAIRS = register("peach_stairs", () -> blockItem(MysticBlocks.PEACH_STAIRS));
    public static final RegistryEntry<Item> PEACH_SLAB = register("peach_slab", () -> blockItem(MysticBlocks.PEACH_SLAB));
    public static final RegistryEntry<Item> PEACH_FENCE = register("peach_fence", () -> blockItem(MysticBlocks.PEACH_FENCE));
    public static final RegistryEntry<Item> PEACH_FENCE_GATE = register("peach_fence_gate", () -> blockItem(MysticBlocks.PEACH_FENCE_GATE));
    public static final RegistryEntry<Item> PEACH_BUTTON = register("peach_button", () -> blockItem(MysticBlocks.PEACH_BUTTON));
    public static final RegistryEntry<Item> PEACH_PRESSURE_PLATE = register("peach_pressure_plate", () -> blockItem(MysticBlocks.PEACH_PRESSURE_PLATE));
    public static final RegistryEntry<Item> PEACH_TRAPDOOR = register("peach_trapdoor", () -> blockItem(MysticBlocks.PEACH_TRAPDOOR));
    public static final RegistryEntry<Item> PEACH_DOOR = register("peach_door", () -> blockItem(MysticBlocks.PEACH_DOOR));
    public static final RegistryEntry<Item> PEACH_SIGN = register("peach_sign", () -> signItem(MysticBlocks.PEACH_SIGN, MysticBlocks.PEACH_WALL_SIGN));
    public static final RegistryEntry<Item> PEACH_HANGING_SIGN = register("peach_hanging_sign", () -> hangingSignItem(MysticBlocks.PEACH_HANGING_SIGN, MysticBlocks.PEACH_WALL_HANGING_SIGN));
    public static final RegistryEntry<Item> PEACH_BOAT = register("peach_boat", () -> boatItem(MysticBoat.Type.PEACH));
    public static final RegistryEntry<Item> PEACH_CHEST_BOAT = register("peach_chest_boat", () -> chestBoatItem(MysticBoat.Type.PEACH));

    /// lagoon
    public static final RegistryEntry<Item> SEA_SHRUB_LEAVES = register("sea_shrub_leaves", () -> blockItem(MysticBlocks.SEA_SHRUB_LEAVES));
    public static final RegistryEntry<Item> SEA_SHRUB = register("sea_shrub", () -> blockItem(MysticBlocks.SEA_SHRUB));
    public static final RegistryEntry<Item> SEA_FOAM_LOG = register("sea_foam_log", () -> blockItem(MysticBlocks.SEA_FOAM_LOG));
    public static final RegistryEntry<Item> STRIPPED_SEA_FOAM_LOG = register("stripped_sea_foam_log", () -> blockItem(MysticBlocks.STRIPPED_SEA_FOAM_LOG));
    public static final RegistryEntry<Item> SEA_FOAM_WOOD = register("sea_foam_wood", () -> blockItem(MysticBlocks.SEA_FOAM_WOOD));
    public static final RegistryEntry<Item> STRIPPED_SEA_FOAM_WOOD = register("stripped_sea_foam_wood", () -> blockItem(MysticBlocks.STRIPPED_SEA_FOAM_WOOD));
    public static final RegistryEntry<Item> SEA_FOAM_PLANKS = register("sea_foam_planks", () -> blockItem(MysticBlocks.SEA_FOAM_PLANKS));
    public static final RegistryEntry<Item> SEA_FOAM_STAIRS = register("sea_foam_stairs", () -> blockItem(MysticBlocks.SEA_FOAM_STAIRS));
    public static final RegistryEntry<Item> SEA_FOAM_SLAB = register("sea_foam_slab", () -> blockItem(MysticBlocks.SEA_FOAM_SLAB));
    public static final RegistryEntry<Item> SEA_FOAM_FENCE = register("sea_foam_fence", () -> blockItem(MysticBlocks.SEA_FOAM_FENCE));
    public static final RegistryEntry<Item> SEA_FOAM_FENCE_GATE = register("sea_foam_fence_gate", () -> blockItem(MysticBlocks.SEA_FOAM_FENCE_GATE));
    public static final RegistryEntry<Item> SEA_FOAM_BUTTON = register("sea_foam_button", () -> blockItem(MysticBlocks.SEA_FOAM_BUTTON));
    public static final RegistryEntry<Item> SEA_FOAM_PRESSURE_PLATE = register("sea_foam_pressure_plate", () -> blockItem(MysticBlocks.SEA_FOAM_PRESSURE_PLATE));
    public static final RegistryEntry<Item> SEA_FOAM_TRAPDOOR = register("sea_foam_trapdoor", () -> blockItem(MysticBlocks.SEA_FOAM_TRAPDOOR));
    public static final RegistryEntry<Item> SEA_FOAM_DOOR = register("sea_foam_door", () -> blockItem(MysticBlocks.SEA_FOAM_DOOR));
    public static final RegistryEntry<Item> SEA_FOAM_SIGN = register("sea_foam_sign", () -> signItem(MysticBlocks.SEA_FOAM_SIGN, MysticBlocks.SEA_FOAM_WALL_SIGN));
    public static final RegistryEntry<Item> SEA_FOAM_HANGING_SIGN = register("sea_foam_hanging_sign", () -> hangingSignItem(MysticBlocks.SEA_FOAM_HANGING_SIGN, MysticBlocks.SEA_FOAM_WALL_HANGING_SIGN));
    public static final RegistryEntry<Item> SEA_FOAM_BOAT = register("sea_foam_boat", () -> boatItem(MysticBoat.Type.SEA_FOAM));
    public static final RegistryEntry<Item> SEA_FOAM_CHEST_BOAT = register("sea_foam_chest_boat", () -> chestBoatItem(MysticBoat.Type.SEA_FOAM));

    /// tropics
    public static final RegistryEntry<Item> TROPICAL_LEAVES = register("tropical_leaves", () -> blockItem(MysticBlocks.TROPICAL_LEAVES));
    public static final RegistryEntry<Item> TROPICAL_SAPLING = register("tropical_sapling", () -> blockItem(MysticBlocks.TROPICAL_SAPLING));
    public static final RegistryEntry<Item> TROPICAL_LOG = register("tropical_log", () -> blockItem(MysticBlocks.TROPICAL_LOG));
    public static final RegistryEntry<Item> STRIPPED_TROPICAL_LOG = register("stripped_tropical_log", () -> blockItem(MysticBlocks.STRIPPED_TROPICAL_LOG));
    public static final RegistryEntry<Item> TROPICAL_WOOD = register("tropical_wood", () -> blockItem(MysticBlocks.TROPICAL_WOOD));
    public static final RegistryEntry<Item> STRIPPED_TROPICAL_WOOD = register("stripped_tropical_wood", () -> blockItem(MysticBlocks.STRIPPED_TROPICAL_WOOD));
    public static final RegistryEntry<Item> TROPICAL_PLANKS = register("tropical_planks", () -> blockItem(MysticBlocks.TROPICAL_PLANKS));
    public static final RegistryEntry<Item> TROPICAL_STAIRS = register("tropical_stairs", () -> blockItem(MysticBlocks.TROPICAL_STAIRS));
    public static final RegistryEntry<Item> TROPICAL_SLAB = register("tropical_slab", () -> blockItem(MysticBlocks.TROPICAL_SLAB));
    public static final RegistryEntry<Item> TROPICAL_FENCE = register("tropical_fence", () -> blockItem(MysticBlocks.TROPICAL_FENCE));
    public static final RegistryEntry<Item> TROPICAL_FENCE_GATE = register("tropical_fence_gate", () -> blockItem(MysticBlocks.TROPICAL_FENCE_GATE));
    public static final RegistryEntry<Item> TROPICAL_BUTTON = register("tropical_button", () -> blockItem(MysticBlocks.TROPICAL_BUTTON));
    public static final RegistryEntry<Item> TROPICAL_PRESSURE_PLATE = register("tropical_pressure_plate", () -> blockItem(MysticBlocks.TROPICAL_PRESSURE_PLATE));
    public static final RegistryEntry<Item> TROPICAL_TRAPDOOR = register("tropical_trapdoor", () -> blockItem(MysticBlocks.TROPICAL_TRAPDOOR));
    public static final RegistryEntry<Item> TROPICAL_DOOR = register("tropical_door", () -> blockItem(MysticBlocks.TROPICAL_DOOR));
    public static final RegistryEntry<Item> TROPICAL_SIGN = register("tropical_sign", () -> signItem(MysticBlocks.TROPICAL_SIGN, MysticBlocks.TROPICAL_WALL_SIGN));
    public static final RegistryEntry<Item> TROPICAL_HANGING_SIGN = register("tropical_hanging_sign", () -> hangingSignItem(MysticBlocks.TROPICAL_HANGING_SIGN, MysticBlocks.TROPICAL_WALL_HANGING_SIGN));
    public static final RegistryEntry<Item> TROPICAL_BOAT = register("tropical_boat", () -> boatItem(MysticBoat.Type.TROPICAL));
    public static final RegistryEntry<Item> TROPICAL_CHEST_BOAT = register("tropical_chest_boat", () -> chestBoatItem(MysticBoat.Type.TROPICAL));

    public static final RegistryEntry<Item> VANILLA_LEAVES = register("vanilla_leaves", () -> blockItem(MysticBlocks.VANILLA_LEAVES));
    public static final RegistryEntry<Item> VANILLA_SAPLING = register("vanilla_sapling", () -> blockItem(MysticBlocks.VANILLA_SAPLING));
    public static final RegistryEntry<Item> VANILLA_LOG = register("vanilla_log", () -> blockItem(MysticBlocks.VANILLA_LOG));
    public static final RegistryEntry<Item> STRIPPED_VANILLA_LOG = register("stripped_vanilla_log", () -> blockItem(MysticBlocks.STRIPPED_VANILLA_LOG));
    public static final RegistryEntry<Item> VANILLA_WOOD = register("vanilla_wood", () -> blockItem(MysticBlocks.VANILLA_WOOD));
    public static final RegistryEntry<Item> STRIPPED_VANILLA_WOOD = register("stripped_vanilla_wood", () -> blockItem(MysticBlocks.STRIPPED_VANILLA_WOOD));
    public static final RegistryEntry<Item> VANILLA_PLANKS = register("vanilla_planks", () -> blockItem(MysticBlocks.VANILLA_PLANKS));
    public static final RegistryEntry<Item> VANILLA_STAIRS = register("vanilla_stairs", () -> blockItem(MysticBlocks.VANILLA_STAIRS));
    public static final RegistryEntry<Item> VANILLA_SLAB = register("vanilla_slab", () -> blockItem(MysticBlocks.VANILLA_SLAB));
    public static final RegistryEntry<Item> VANILLA_FENCE = register("vanilla_fence", () -> blockItem(MysticBlocks.VANILLA_FENCE));
    public static final RegistryEntry<Item> VANILLA_FENCE_GATE = register("vanilla_fence_gate", () -> blockItem(MysticBlocks.VANILLA_FENCE_GATE));
    public static final RegistryEntry<Item> VANILLA_BUTTON = register("vanilla_button", () -> blockItem(MysticBlocks.VANILLA_BUTTON));
    public static final RegistryEntry<Item> VANILLA_PRESSURE_PLATE = register("vanilla_pressure_plate", () -> blockItem(MysticBlocks.VANILLA_PRESSURE_PLATE));
    public static final RegistryEntry<Item> VANILLA_TRAPDOOR = register("vanilla_trapdoor", () -> blockItem(MysticBlocks.VANILLA_TRAPDOOR));
    public static final RegistryEntry<Item> VANILLA_DOOR = register("vanilla_door", () -> blockItem(MysticBlocks.VANILLA_DOOR));
    public static final RegistryEntry<Item> VANILLA_SIGN = register("vanilla_sign", () -> signItem(MysticBlocks.VANILLA_SIGN, MysticBlocks.VANILLA_WALL_SIGN));
    public static final RegistryEntry<Item> VANILLA_HANGING_SIGN = register("vanilla_hanging_sign", () -> hangingSignItem(MysticBlocks.VANILLA_HANGING_SIGN, MysticBlocks.VANILLA_WALL_HANGING_SIGN));
    public static final RegistryEntry<Item> VANILLA_BOAT = register("vanilla_boat", () -> boatItem(MysticBoat.Type.VANILLA));
    public static final RegistryEntry<Item> VANILLA_CHEST_BOAT = register("vanilla_chest_boat", () -> chestBoatItem(MysticBoat.Type.VANILLA));

    /** TODO: */
    ///public static final RegistryEntry<Item> PINK_DAISIES;
    public static final RegistryEntry<Item> STRAWBERRY = register("strawberry", () -> itemBlockItem(MysticBlocks.WILD_STRAWBERRY_BUSH, new Item.Properties().food(new FoodProperties.Builder().nutrition(2).fast().build())));
    public static final RegistryEntry<Item> SWEET_STRAWBERRY = register("sweet_strawberry", () -> itemBlockItem(MysticBlocks.WILD_STRAWBERRY_BUSH, new Item.Properties().rarity(Rarity.EPIC).food(new FoodProperties.Builder().nutrition(4).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.REGENERATION, 200, 1), 1.0F).build())));
    public static final RegistryEntry<Item> STRAWBERRY_CAKE = register("strawberry_cake", () -> cakeItem(MysticBlocks.STRAWBERRY_CAKE));
    public static final RegistryEntry<Item> SWEET_STRAWBERRY_CAKE = register("sweet_strawberry_cake", () -> new MysticItemBlockItem(MysticBlocks.SWEET_STRAWBERRY_CAKE, new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));
    public static final RegistryEntry<Item> STRAWBERRY_MILK_BUCKET = register("strawberry_milk_bucket", () -> new MilkBucketItem(new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryEntry<Item> STRAWBERRY_COW_SPAWN_EGG = register("strawberry_cow_spawn_egg", () -> spawnEggItem(MysticEntities.STRAWBERRY_COW, 16642812, 16756181));

    public static final RegistryEntry<Item> LAVENDER = register("lavender", () -> blockItem(MysticBlocks.LAVENDER));
    public static final RegistryEntry<Item> TALL_LAVENDER = register("tall_lavender", () -> blockItem(MysticBlocks.TALL_LAVENDER));
    ///public static final RegistryEntry<Item> LAVENDER_BUDS = register("lavender_buds", () -> new Item(new Item.Properties()));
    ///public static final RegistryEntry<Item> BUNDLED_LAVENDER_BUDS;
    ///public static final RegistryEntry<Item> BUTTERFLY_BUSH_LEAVES;
    ///public static final RegistryEntry<Item> BUTTERFLY_BUSH;
    public static final RegistryEntry<Item> BUTTERFLY_NEST = register("butterfly_nest", () -> blockItem(MysticBlocks.BUTTERFLY_NEST));
    public static final RegistryEntry<Item> BUTTERFLY_SPAWN_EGG = register("butterfly_spawn_egg", () -> spawnEggItem(MysticEntities.BUTTERFLY, 2710099, 3857605));
    public static final RegistryEntry<Item> CHRYSALIS = register("chrysalis", () -> blockItem(MysticBlocks.CHRYSALIS));
    public static final RegistryEntry<Item> CATERPILLAR_SPAWN_EGG = register("caterpillar_spawn_egg", () -> spawnEggItem(MysticEntities.CATERPILLAR, 11587158, 16553068));
    ///public static final RegistryEntry<Item> NECTAR;

    public static final RegistryEntry<Item> GLASS_JAR = register("glass_jar", () -> new GlassJarItem(MysticBlocks.GLASS_JAR, new Item.Properties()));
    public static final RegistryEntry<Item> MONARCH_BUTTERFLY_IN_JAR = register("glass_jar_monarch_butterfly", () -> new BugHabitatItem(BugHabitatItem.BugTypes.MONARCH));
    public static final RegistryEntry<Item> MORPHO_BUTTERFLY_IN_JAR = register("glass_jar_morpho_butterfly", () -> new BugHabitatItem(BugHabitatItem.BugTypes.MORPHO));
    public static final RegistryEntry<Item> BLUE_BUTTERFLY_IN_JAR = register("glass_jar_blue_butterfly", () -> new BugHabitatItem(BugHabitatItem.BugTypes.BLUE));
    public static final RegistryEntry<Item> LUNA_MOTH_IN_JAR = register("glass_jar_luna_moth", () -> new BugHabitatItem(BugHabitatItem.BugTypes.LUNA_MOTH));
    public static final RegistryEntry<Item> CATERPILLAR_IN_JAR = register("glass_jar_caterpillar", () -> new BugHabitatItem(BugHabitatItem.BugTypes.CATERPILLAR));

    public static final RegistryEntry<Item> CHERRIES = register("cherries", () -> itemBlockItem(MysticBlocks.CHERRY_PLANT, new Item.Properties().food(new FoodProperties.Builder().nutrition(4).fast().build())));
    public static final RegistryEntry<Item> CHERRY_PIE = register("cherry_pie", () -> cakeItem(MysticBlocks.CHERRY_PIE));
    public static final RegistryEntry<Item> PEONY_BUSH_LEAVES = register("peony_bush_leaves", () -> blockItem(MysticBlocks.PEONY_BUSH_LEAVES));
    public static final RegistryEntry<Item> PEONY_BUSH = register("peony_bush", () -> blockItem(MysticBlocks.PEONY_BUSH));
    public static final RegistryEntry<Item> RED_PANDA_SPAWN_EGG = register("red_panda_spawn_egg", () -> spawnEggItem(MysticEntities.STRAWBERRY_COW, 16760947, 13795386));

    ///public static final RegistryEntry<Item> MAPLE_SAP;
    ///public static final RegistryEntry<Item> MAPLE_SYRUP;
    ///public static final RegistryEntry<Item> MAPLE_PANCAKES;
    ///public static final RegistryEntry<Item> PUMPKIN_COOKIE;
    ///public static final RegistryEntry<Item> SPOOKY_COOKIE;
    public static final RegistryEntry<Item> ASTER = register("aster", () -> blockItem(MysticBlocks.ASTER));
    public static final RegistryEntry<Item> GOLDENROD = register("goldenrod", () -> blockItem(MysticBlocks.GOLDENROD));

    public static final RegistryEntry<Item> PEACH = register("peach", () -> itemBlockItem(MysticBlocks.PEACH_PLANT, new Item.Properties().food(new FoodProperties.Builder().nutrition(4).fast().build())));
    public static final RegistryEntry<Item> PEACH_PIE = register("peach_pie", () -> cakeItem(MysticBlocks.PEACH_PIE));
    ///public static final RegistryEntry<Item> DESERT_SHRUB;
    public static final RegistryEntry<Item> DESERT_GRASS = register("desert_grass", () -> blockItem(MysticBlocks.DESERT_GRASS));
    public static final RegistryEntry<Item> TALL_DESERT_GRASS = register("tall_desert_grass", () -> blockItem(MysticBlocks.TALL_DESERT_GRASS));
    public static final RegistryEntry<Item> DESERT_LILY = register("desert_lily", () -> blockItem(MysticBlocks.DESERT_LILY));
    public static final RegistryEntry<Item> WILDFLOWER = register("wildflower", () -> blockItem(MysticBlocks.WILDFLOWER));
    public static final RegistryEntry<Item> SAGUARO_CACTUS = register("saguaro_cactus", () -> blockItem(MysticBlocks.SAGUARO_CACTUS));
    public static final RegistryEntry<Item> SAGUARO_BLOSSOM = register("saguaro_blossom", () -> blockItem(MysticBlocks.SAGUARO_BLOSSOM));
    ///public static final RegistryEntry<Item> PRICKLY_CACTUS;
    ///public static final RegistryEntry<Item> PRICKLY_BLOSSOM;
    ///public static final RegistryEntry<Item> PRICKLY_PEAR;

    public static final RegistryEntry<Item> BEACH_GRASS = register("beach_grass", () -> blockItem(MysticBlocks.BEACH_GRASS));
    public static final RegistryEntry<Item> TALL_BEACH_GRASS = register("tall_beach_grass", () -> blockItem(MysticBlocks.TALL_BEACH_GRASS));
    public static final RegistryEntry<Item> MILKWEED = register("milkweed", () -> blockItem(MysticBlocks.MILKWEED));
    public static final RegistryEntry<Item> SEA_THRIFT = register("sea_thrift", () -> blockItem(MysticBlocks.SEA_THRIFT));
    public static final RegistryEntry<Item> SEA_OATS = register("sea_oats", () -> blockItem(MysticBlocks.SEA_OATS));
    ///public static final RegistryEntry<Item> SEA_FOAM_BUCKET;
    public static final RegistryEntry<Item> SEA_OTTER_SPAWN_EGG = register("sea_otter_spawn_egg", () -> spawnEggItem(MysticEntities.STRAWBERRY_COW, 5191718, 10980193));

    ///public static final RegistryEntry<Item> TROPICAL_VINES;
    ///public static final RegistryEntry<Item> JUNGLE_SHRUB;
    ///public static final RegistryEntry<Item> JUNGLE_GRASS;
    ///public static final RegistryEntry<Item> TALL_JUNGLE_GRASS;
    ///public static final RegistryEntry<Item> BANANA_LEAF_PLANT;
    public static final RegistryEntry<Item> HYDRANGEA_BUSH_LEAVES = register("hydrangea_bush_leaves", () -> blockItem(MysticBlocks.HYDRANGEA_BUSH_LEAVES));
    public static final RegistryEntry<Item> HYDRANGEA_BUSH = register("hydrangea_bush", () -> blockItem(MysticBlocks.HYDRANGEA_BUSH));
    public static final RegistryEntry<Item> HIBISCUS = register("hibiscus", () -> blockItem(MysticBlocks.HIBISCUS));
    public static final RegistryEntry<Item> VANILLA_BEANS = register("vanilla_beans", () -> itemBlockItem(MysticBlocks.VANILLA_ORCHID, new Item.Properties()));
    public static final RegistryEntry<Item> VANILLA_MILK_BUCKET = register("vanilla_milk_bucket", () -> new MilkBucketItem(new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryEntry<Item> VANILLA_CAKE = register("vanilla_cake", () -> cakeItem(MysticBlocks.VANILLA_CAKE));
    public static final RegistryEntry<Item> VANILLA_COW_SPAWN_EGG = register("vanilla_cow_spawn_egg", () -> spawnEggItem(MysticEntities.VANILLA_COW, 16775929, 15781816));
    public static final RegistryEntry<Item> CHOCOLATE_MILK_BUCKET = register("chocolate_milk_bucket", () -> new MilkBucketItem(new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryEntry<Item> CHOCOLATE_CAKE = register("chocolate_cake", () -> cakeItem(MysticBlocks.CHOCOLATE_CAKE));
    public static final RegistryEntry<Item> CHOCOLATE_COW_SPAWN_EGG = register("chocolate_cow_spawn_egg", () -> spawnEggItem(MysticEntities.CHOCOLATE_COW, 11697754, 7950915));

    public static final RegistryEntry<Item> PINK_FROSTED_CAKE = register("pink_frosted_cake", () -> cakeItem(MysticBlocks.PINK_FROSTED_CAKE));
    public static final RegistryEntry<Item> ORANGE_FROSTED_CAKE = register("orange_frosted_cake", () -> cakeItem(MysticBlocks.ORANGE_FROSTED_CAKE));
    public static final RegistryEntry<Item> YELLOW_FROSTED_CAKE = register("yellow_frosted_cake", () -> cakeItem(MysticBlocks.YELLOW_FROSTED_CAKE));
    public static final RegistryEntry<Item> LIME_FROSTED_CAKE = register("lime_frosted_cake", () -> cakeItem(MysticBlocks.LIME_FROSTED_CAKE));
    public static final RegistryEntry<Item> CYAN_FROSTED_CAKE = register("cyan_frosted_cake", () -> cakeItem(MysticBlocks.CYAN_FROSTED_CAKE));
    public static final RegistryEntry<Item> PURPLE_FROSTED_CAKE = register("purple_frosted_cake", () -> cakeItem(MysticBlocks.PURPLE_FROSTED_CAKE));
    ///public static final RegistryEntry<Item> RAINBOW_FROSTED_CAKE = register("rainbow_frosted_cake", () -> cakeItem(MysticBlocks.RAINBOW_FROSTED_CAKE));
    public static final RegistryEntry<Item> PINK_EGG = register("pink_egg", () -> new RainbowEggItem(new Item.Properties().stacksTo(16)));
    public static final RegistryEntry<Item> ORANGE_EGG = register("orange_egg", () -> new RainbowEggItem(new Item.Properties().stacksTo(16)));
    public static final RegistryEntry<Item> YELLOW_EGG = register("yellow_egg", () -> new RainbowEggItem(new Item.Properties().stacksTo(16)));
    public static final RegistryEntry<Item> LIME_EGG = register("lime_egg", () -> new RainbowEggItem(new Item.Properties().stacksTo(16)));
    public static final RegistryEntry<Item> CYAN_EGG = register("cyan_egg", () -> new RainbowEggItem(new Item.Properties().stacksTo(16)));
    public static final RegistryEntry<Item> PURPLE_EGG = register("purple_egg", () -> new RainbowEggItem(new Item.Properties().stacksTo(16)));
    ///public static final RegistryEntry<Item> RAINBOW_EGG = register("rainbow_egg", () -> new RainbowEggItem(new Item.Properties().stacksTo(16)));
    public static final RegistryEntry<Item> RAINBOW_CHICKEN_SPAWN_EGG = register("rainbow_chicken_spawn_egg", () -> spawnEggItem(MysticEntities.RAINBOW_CHICKEN, 7666652, 16706605));

    public static final RegistryEntry<Item> LOGO = register("logo", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryEntry<Item> FROSTED_CAKES = register("frosted_cakes", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryEntry<Item> NEAPOLITAN_CAKES = register("neapolitan_cakes", () -> new Item(new Item.Properties().stacksTo(1)));

    private static RegistryEntry<Item> register(String name, Supplier<Item> item) {
        return ITEMS.register(name, item);
    }

    public static void init() {
    }

}