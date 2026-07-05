package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.entity.vehicle.MysticBoat;
import com.mysticsbiomes.common.item.RainbowEggItem;
import com.mysticsbiomes.core.registry.DeferredRegister;
import com.mysticsbiomes.core.registry.RegistryObject;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;

import java.util.function.Supplier;

import static com.mysticsbiomes.MysticsBiomes.REGISTRY_FACTORY;
import static com.mysticsbiomes.common.item.ItemTemplate.*;

public class MysticItems {
    public static final DeferredRegister<Item> ITEMS = REGISTRY_FACTORY.create(Registries.ITEM, MysticsBiomes.modId);

    /// strawberry fields
    public static final RegistryObject<Item> STRAWBERRY_BLOSSOMS = register("strawberry_blossoms", () -> blockItem(MysticBlocks.STRAWBERRY_BLOSSOMS.get()));
    public static final RegistryObject<Item> STRAWBERRY_BLOSSOM_SAPLING = register("strawberry_blossom_sapling", () -> blockItem(MysticBlocks.STRAWBERRY_BLOSSOM_SAPLING.get()));
    public static final RegistryObject<Item> STRAWBERRY_LOG = register("strawberry_log", () -> blockItem(MysticBlocks.STRAWBERRY_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_STRAWBERRY_LOG = register("stripped_strawberry_log", () -> blockItem(MysticBlocks.STRIPPED_STRAWBERRY_LOG.get()));
    public static final RegistryObject<Item> STRAWBERRY_WOOD = register("strawberry_wood", () -> blockItem(MysticBlocks.STRAWBERRY_WOOD.get()));
    public static final RegistryObject<Item> STRIPPED_STRAWBERRY_WOOD = register("stripped_strawberry_wood", () -> blockItem(MysticBlocks.STRIPPED_STRAWBERRY_WOOD.get()));
    public static final RegistryObject<Item> STRAWBERRY_PLANKS = register("strawberry_planks", () -> blockItem(MysticBlocks.STRAWBERRY_PLANKS.get()));
    public static final RegistryObject<Item> STRAWBERRY_STAIRS = register("strawberry_stairs", () -> blockItem(MysticBlocks.STRAWBERRY_STAIRS.get()));
    public static final RegistryObject<Item> STRAWBERRY_SLAB = register("strawberry_slab", () -> blockItem(MysticBlocks.STRAWBERRY_SLAB.get()));
    public static final RegistryObject<Item> STRAWBERRY_FENCE = register("strawberry_fence", () -> blockItem(MysticBlocks.STRAWBERRY_FENCE.get()));
    public static final RegistryObject<Item> STRAWBERRY_FENCE_GATE = register("strawberry_fence_gate", () -> blockItem(MysticBlocks.STRAWBERRY_FENCE_GATE.get()));
    public static final RegistryObject<Item> STRAWBERRY_BUTTON = register("strawberry_button", () -> blockItem(MysticBlocks.STRAWBERRY_BUTTON.get()));
    public static final RegistryObject<Item> STRAWBERRY_PRESSURE_PLATE = register("strawberry_pressure_plate", () -> blockItem(MysticBlocks.STRAWBERRY_PRESSURE_PLATE.get()));
    public static final RegistryObject<Item> STRAWBERRY_TRAPDOOR = register("strawberry_trapdoor", () -> blockItem(MysticBlocks.STRAWBERRY_TRAPDOOR.get()));
    public static final RegistryObject<Item> STRAWBERRY_DOOR = register("strawberry_door", () -> blockItem(MysticBlocks.STRAWBERRY_DOOR.get()));
    public static final RegistryObject<Item> STRAWBERRY_SIGN = register("strawberry_sign", () -> signItem(MysticBlocks.STRAWBERRY_SIGN.get(), MysticBlocks.STRAWBERRY_WALL_SIGN.get()));
    public static final RegistryObject<Item> STRAWBERRY_HANGING_SIGN = register("strawberry_hanging_sign", () -> hangingSignItem(MysticBlocks.STRAWBERRY_HANGING_SIGN.get(), MysticBlocks.STRAWBERRY_WALL_HANGING_SIGN.get()));
    public static final RegistryObject<Item> STRAWBERRY_BOAT = register("strawberry_boat", () -> boatItem(MysticBoat.Type.STRAWBERRY));
    public static final RegistryObject<Item> STRAWBERRY_CHEST_BOAT = register("strawberry_chest_boat", () -> chestBoatItem(MysticBoat.Type.STRAWBERRY));

    ///public static final RegistryObject<Item> PINK_DAISIES;
    public static final RegistryObject<Item> STRAWBERRY = register("strawberry", () -> new ItemNameBlockItem(MysticBlocks.STRAWBERRY_BUSH.get(), new Item.Properties().food(new FoodProperties.Builder().nutrition(2).fast().build())));
    public static final RegistryObject<Item> SWEET_STRAWBERRY = register("sweet_strawberry", () -> new ItemNameBlockItem(MysticBlocks.STRAWBERRY_BUSH.get(), new Item.Properties().rarity(Rarity.EPIC).food(new FoodProperties.Builder().nutrition(4).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.REGENERATION, 200, 1), 1.0F).build())));
    public static final RegistryObject<Item> STRAWBERRY_CAKE = register("strawberry_cake", () -> new BlockItem(MysticBlocks.STRAWBERRY_CAKE.get(), new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SWEET_STRAWBERRY_CAKE = register("sweet_strawberry_cake", () -> new BlockItem(MysticBlocks.SWEET_STRAWBERRY_CAKE.get(), new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> STRAWBERRY_MILK_BUCKET = register("strawberry_milk_bucket", () -> new MilkBucketItem(new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    ///public static final RegistryObject<Item> STRAWBERRY_COW_SPAWN_EGG = register("strawberry_cow_spawn_egg", () -> new SpawnEggItem(MysticEntities.STRAWBERRY_COW.get(), 16642812, 16756181, new Item.Properties()));

    /// lavender meadow
    public static final RegistryObject<Item> LAVENDER_BLOSSOMS = register("lavender_blossoms", () -> blockItem(MysticBlocks.LAVENDER_BLOSSOMS.get()));
    public static final RegistryObject<Item> LAVENDER_BLOSSOM_SAPLING = register("lavender_blossom_sapling", () -> blockItem(MysticBlocks.LAVENDER_BLOSSOM_SAPLING.get()));
    public static final RegistryObject<Item> LAVENDER_LOG = register("lavender_log", () -> blockItem(MysticBlocks.LAVENDER_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_LAVENDER_LOG = register("stripped_lavender_log", () -> blockItem(MysticBlocks.STRIPPED_LAVENDER_LOG.get()));
    public static final RegistryObject<Item> LAVENDER_WOOD = register("lavender_wood", () -> blockItem(MysticBlocks.LAVENDER_WOOD.get()));
    public static final RegistryObject<Item> STRIPPED_LAVENDER_WOOD = register("stripped_lavender_wood", () -> blockItem(MysticBlocks.STRIPPED_LAVENDER_WOOD.get()));
    public static final RegistryObject<Item> LAVENDER_PLANKS = register("lavender_planks", () -> blockItem(MysticBlocks.LAVENDER_PLANKS.get()));
    public static final RegistryObject<Item> LAVENDER_STAIRS = register("lavender_stairs", () -> blockItem(MysticBlocks.LAVENDER_STAIRS.get()));
    public static final RegistryObject<Item> LAVENDER_SLAB = register("lavender_slab", () -> blockItem(MysticBlocks.LAVENDER_SLAB.get()));
    public static final RegistryObject<Item> LAVENDER_FENCE = register("lavender_fence", () -> blockItem(MysticBlocks.LAVENDER_FENCE.get()));
    public static final RegistryObject<Item> LAVENDER_FENCE_GATE = register("lavender_fence_gate", () -> blockItem(MysticBlocks.LAVENDER_FENCE_GATE.get()));
    public static final RegistryObject<Item> LAVENDER_BUTTON = register("lavender_button", () -> blockItem(MysticBlocks.LAVENDER_BUTTON.get()));
    public static final RegistryObject<Item> LAVENDER_PRESSURE_PLATE = register("lavender_pressure_plate", () -> blockItem(MysticBlocks.LAVENDER_PRESSURE_PLATE.get()));
    public static final RegistryObject<Item> LAVENDER_TRAPDOOR = register("lavender_trapdoor", () -> blockItem(MysticBlocks.LAVENDER_TRAPDOOR.get()));
    public static final RegistryObject<Item> LAVENDER_DOOR = register("lavender_door", () -> blockItem(MysticBlocks.LAVENDER_DOOR.get()));
    public static final RegistryObject<Item> LAVENDER_SIGN = register("lavender_sign", () -> signItem(MysticBlocks.LAVENDER_SIGN.get(), MysticBlocks.LAVENDER_WALL_SIGN.get()));
    public static final RegistryObject<Item> LAVENDER_HANGING_SIGN = register("lavender_hanging_sign", () -> hangingSignItem(MysticBlocks.LAVENDER_HANGING_SIGN.get(), MysticBlocks.LAVENDER_WALL_HANGING_SIGN.get()));
    public static final RegistryObject<Item> LAVENDER_BOAT = register("lavender_boat", () -> boatItem(MysticBoat.Type.LAVENDER));
    public static final RegistryObject<Item> LAVENDER_CHEST_BOAT = register("lavender_chest_boat", () -> chestBoatItem(MysticBoat.Type.LAVENDER));

    ///public static final RegistryObject<Item> LAVENDER;
    ///public static final RegistryObject<Item> TALL_LAVENDER;
    ///public static final RegistryObject<Item> LAVENDER_BUDS;
    ///public static final RegistryObject<Item> BUNDLED_LAVENDER_BUDS;
    ///public static final RegistryObject<Item> BUTTERFLY_BUSH_LEAVES;
    ///public static final RegistryObject<Item> BUTTERFLY_BUSH;
    ///public static final RegistryObject<Item> BUTTERFLY_NEST;
    ///public static final RegistryObject<Item> BUTTERFLY_SPAWN_EGG = register("butterfly_spawn_egg", () -> new SpawnEggItem(MysticEntities.BUTTERFLY.get(), 2710099, 3857605, new Item.Properties()));
    ///public static final RegistryObject<Item> CHRYSALIS;
    ///public static final RegistryObject<Item> CATERPILLAR_SPAWN_EGG = register("caterpillar_spawn_egg", () -> new SpawnEggItem(MysticEntities.CATERPILLAR.get(), 11587158, 16553068, new Item.Properties()));
    ///public static final RegistryObject<Item> NECTAR;

    ///public static final RegistryObject<Item> GLASS_JAR = register("glass_jar", () -> new GlassJarItem(MysticBlocks.GLASS_JAR.get(), new Item.Properties()));
    ///public static final RegistryObject<Item> MONARCH_BUTTERFLY_IN_JAR = register("glass_jar_monarch_butterfly", () -> new BugHabitatItem(BugHabitatItem.BugTypes.MONARCH));
    ///public static final RegistryObject<Item> MORPHO_BUTTERFLY_IN_JAR = register("glass_jar_morpho_butterfly", () -> new BugHabitatItem(BugHabitatItem.BugTypes.MORPHO));
    ///public static final RegistryObject<Item> LUNA_MOTH_IN_JAR = register("glass_jar_luna_moth", () -> new BugHabitatItem(BugHabitatItem.BugTypes.LUNA_MOTH));
    ///public static final RegistryObject<Item> CATERPILLAR_IN_JAR = register("glass_jar_caterpillar", () -> new BugHabitatItem(BugHabitatItem.BugTypes.CATERPILLAR));

    /// bamboo blossom forest
    public static final RegistryObject<Item> PINK_CHERRY_BLOSSOMS = register("pink_cherry_blossoms", () -> blockItem(MysticBlocks.PINK_CHERRY_BLOSSOMS.get()));
    ///public static final RegistryObject<Item> PINK_CHERRY_PETALS;
    public static final RegistryObject<Item> PINK_CHERRY_BLOSSOM_SAPLING = register("pink_cherry_blossom_sapling", () -> blockItem(MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING.get()));
    public static final RegistryObject<Item> WHITE_CHERRY_BLOSSOMS = register("white_cherry_blossoms", () -> blockItem(MysticBlocks.WHITE_CHERRY_BLOSSOMS.get()));
    ///public static final RegistryObject<Item> WHITE_CHERRY_PETALS;
    public static final RegistryObject<Item> WHITE_CHERRY_BLOSSOM_SAPLING = register("white_cherry_blossom_sapling", () -> blockItem(MysticBlocks.WHITE_CHERRY_BLOSSOM_SAPLING.get()));
    public static final RegistryObject<Item> BLACK_CHERRY_LOG = register("black_cherry_log", () -> blockItem(MysticBlocks.BLACK_CHERRY_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_BLACK_CHERRY_LOG = register("stripped_black_cherry_log", () -> blockItem(MysticBlocks.STRIPPED_BLACK_CHERRY_LOG.get()));
    public static final RegistryObject<Item> BLACK_CHERRY_WOOD = register("black_cherry_wood", () -> blockItem(MysticBlocks.BLACK_CHERRY_WOOD.get()));
    public static final RegistryObject<Item> STRIPPED_BLACK_CHERRY_WOOD = register("stripped_black_cherry_wood", () -> blockItem(MysticBlocks.STRIPPED_BLACK_CHERRY_WOOD.get()));
    public static final RegistryObject<Item> BLACK_CHERRY_PLANKS = register("black_cherry_planks", () -> blockItem(MysticBlocks.BLACK_CHERRY_PLANKS.get()));
    public static final RegistryObject<Item> BLACK_CHERRY_STAIRS = register("black_cherry_stairs", () -> blockItem(MysticBlocks.BLACK_CHERRY_STAIRS.get()));
    public static final RegistryObject<Item> BLACK_CHERRY_SLAB = register("black_cherry_slab", () -> blockItem(MysticBlocks.BLACK_CHERRY_SLAB.get()));
    public static final RegistryObject<Item> BLACK_CHERRY_FENCE = register("black_cherry_fence", () -> blockItem(MysticBlocks.BLACK_CHERRY_FENCE.get()));
    public static final RegistryObject<Item> BLACK_CHERRY_FENCE_GATE = register("black_cherry_fence_gate", () -> blockItem(MysticBlocks.BLACK_CHERRY_FENCE_GATE.get()));
    public static final RegistryObject<Item> BLACK_CHERRY_BUTTON = register("black_cherry_button", () -> blockItem(MysticBlocks.BLACK_CHERRY_BUTTON.get()));
    public static final RegistryObject<Item> BLACK_CHERRY_PRESSURE_PLATE = register("black_cherry_pressure_plate", () -> blockItem(MysticBlocks.BLACK_CHERRY_PRESSURE_PLATE.get()));
    public static final RegistryObject<Item> BLACK_CHERRY_TRAPDOOR = register("black_cherry_trapdoor", () -> blockItem(MysticBlocks.BLACK_CHERRY_TRAPDOOR.get()));
    public static final RegistryObject<Item> BLACK_CHERRY_DOOR = register("black_cherry_door", () -> blockItem(MysticBlocks.BLACK_CHERRY_DOOR.get()));
    public static final RegistryObject<Item> BLACK_CHERRY_SIGN = register("black_cherry_sign", () -> signItem(MysticBlocks.BLACK_CHERRY_SIGN.get(), MysticBlocks.BLACK_CHERRY_WALL_SIGN.get()));
    public static final RegistryObject<Item> BLACK_CHERRY_HANGING_SIGN = register("black_cherry_hanging_sign", () -> hangingSignItem(MysticBlocks.BLACK_CHERRY_HANGING_SIGN.get(), MysticBlocks.BLACK_CHERRY_WALL_HANGING_SIGN.get()));
    public static final RegistryObject<Item> BLACK_CHERRY_BOAT = register("black_cherry_boat", () -> boatItem(MysticBoat.Type.BLACK_CHERRY));
    public static final RegistryObject<Item> BLACK_CHERRY_CHEST_BOAT = register("black_cherry_chest_boat", () -> chestBoatItem(MysticBoat.Type.BLACK_CHERRY));

    ///public static final RegistryObject<Item> SPRING_BAMBOO = register("spring_bamboo", () -> blockItem(MysticBlocks.SPRING_BAMBOO.get()));
    ///public static final RegistryObject<Item> STRIPPED_SPRING_BAMBOO = register("stripped_spring_bamboo", () -> blockItem(MysticBlocks.STRIPPED_SPRING_BAMBOO.get()));
    public static final RegistryObject<Item> SPRING_BAMBOO_BLOCK = register("spring_bamboo_block", () -> blockItem(MysticBlocks.SPRING_BAMBOO_BLOCK.get()));
    public static final RegistryObject<Item> STRIPPED_SPRING_BAMBOO_BLOCK = register("stripped_spring_bamboo_block", () -> blockItem(MysticBlocks.STRIPPED_SPRING_BAMBOO_BLOCK.get()));
    public static final RegistryObject<Item> SPRING_PLANKS = register("spring_planks", () -> blockItem(MysticBlocks.SPRING_PLANKS.get()));
    public static final RegistryObject<Item> SPRING_MOSAIC = register("spring_mosaic", () -> blockItem(MysticBlocks.SPRING_MOSAIC.get()));
    public static final RegistryObject<Item> SPRING_STAIRS = register("spring_stairs", () -> blockItem(MysticBlocks.SPRING_STAIRS.get()));
    public static final RegistryObject<Item> SPRING_MOSAIC_STAIRS = register("spring_mosaic_stairs", () -> blockItem(MysticBlocks.SPRING_MOSAIC_STAIRS.get()));
    public static final RegistryObject<Item> SPRING_SLAB = register("spring_slab", () -> blockItem(MysticBlocks.SPRING_SLAB.get()));
    public static final RegistryObject<Item> SPRING_MOSAIC_SLAB = register("spring_mosaic_slab", () -> blockItem(MysticBlocks.SPRING_MOSAIC_SLAB.get()));
    public static final RegistryObject<Item> SPRING_FENCE = register("spring_fence", () -> blockItem(MysticBlocks.SPRING_FENCE.get()));
    public static final RegistryObject<Item> SPRING_FENCE_GATE = register("spring_fence_gate", () -> blockItem(MysticBlocks.SPRING_FENCE_GATE.get()));
    public static final RegistryObject<Item> SPRING_BUTTON = register("spring_button", () -> blockItem(MysticBlocks.SPRING_BUTTON.get()));
    public static final RegistryObject<Item> SPRING_PRESSURE_PLATE = register("spring_pressure_plate", () -> blockItem(MysticBlocks.SPRING_PRESSURE_PLATE.get()));
    public static final RegistryObject<Item> SPRING_TRAPDOOR = register("spring_trapdoor", () -> blockItem(MysticBlocks.SPRING_TRAPDOOR.get()));
    public static final RegistryObject<Item> SPRING_DOOR = register("spring_door", () -> blockItem(MysticBlocks.SPRING_DOOR.get()));
    public static final RegistryObject<Item> SPRING_SIGN = register("spring_sign", () -> signItem(MysticBlocks.SPRING_SIGN.get(), MysticBlocks.SPRING_WALL_SIGN.get()));
    public static final RegistryObject<Item> SPRING_HANGING_SIGN = register("spring_hanging_sign", () -> hangingSignItem(MysticBlocks.SPRING_HANGING_SIGN.get(), MysticBlocks.SPRING_WALL_HANGING_SIGN.get()));
    public static final RegistryObject<Item> SPRING_RAFT = register("spring_raft", () -> boatItem(MysticBoat.Type.SPRING));
    public static final RegistryObject<Item> SPRING_CHEST_RAFT = register("spring_chest_raft", () -> chestBoatItem(MysticBoat.Type.SPRING));

    ///public static final RegistryObject<Item> CHERRIES = register("cherries", () -> new ItemNameBlockItem(MysticBlocks.CHERRY_PLANT.get(), new Item.Properties().food(new FoodProperties.Builder().nutrition(4).fast().build())));
    ///public static final RegistryObject<Item> CHERRY_PIE = register("cherry_pie", () -> new BlockItem(MysticBlocks.CHERRY_PIE.get(), new Item.Properties().stacksTo(1)));
    ///public static final RegistryObject<Item> CHERRY_PLANT;
    ///public static final RegistryObject<Item> PEONY_BUSH_LEAVES = register("peony_bush_leaves", () -> blockItem(MysticBlocks.PEONY_BUSH_LEAVES.get()));
    ///public static final RegistryObject<Item> PEONY_BUSH = register("peony_bush", () -> blockItem(MysticBlocks.PEONY_BUSH.get()));
    ///public static final RegistryObject<Item> RED_PANDA_SPAWN_EGG = register("red_panda_spawn_egg", () -> new SpawnEggItem(MysticEntities.RED_PANDA.get(), 16760947, 13795386, new Item.Properties()));

    /// autumnal grove
    public static final RegistryObject<Item> MAPLE_LEAVES = register("maple_leaves", () -> blockItem(MysticBlocks.MAPLE_LEAVES.get()));
    ///public static final RegistryObject<Item> MAPLE_LEAF_PILE = register("maple_leaf_pile", () -> blockItem(MysticBlocks.MAPLE_LEAF_PILE.get()));
    ///public static final RegistryObject<Item> MAPLE_LEAF_LITTER = register("maple_leaf_litter", () -> blockItem(MysticBlocks.MAPLE_LEAF_LITTER.get()));
    public static final RegistryObject<Item> MAPLE_SAPLING = register("maple_sapling", () -> blockItem(MysticBlocks.MAPLE_SAPLING.get()));
    public static final RegistryObject<Item> SPICED_MAPLE_LEAVES = register("spiced_maple_leaves", () -> blockItem(MysticBlocks.SPICED_MAPLE_LEAVES.get()));
    ///public static final RegistryObject<Item> SPICED_MAPLE_LEAF_PILE = register("spiced_maple_leaf_pile", () -> blockItem(MysticBlocks.SPICED_MAPLE_LEAF_PILE.get()));
    ///public static final RegistryObject<Item> SPICED_MAPLE_LEAF_LITTER = register("spiced_maple_leaf_litter", () -> blockItem(MysticBlocks.SPICED_MAPLE_LEAF_LITTER.get()));
    public static final RegistryObject<Item> SPICED_MAPLE_SAPLING = register("spiced_maple_sapling", () -> blockItem(MysticBlocks.SPICED_MAPLE_SAPLING.get()));
    public static final RegistryObject<Item> ORANGE_MAPLE_LEAVES = register("orange_maple_leaves", () -> blockItem(MysticBlocks.ORANGE_MAPLE_LEAVES.get()));
    ///public static final RegistryObject<Item> ORANGE_MAPLE_LEAF_PILE = register("orange_maple_leaf_pile", () -> blockItem(MysticBlocks.ORANGE_MAPLE_LEAF_PILE.get()));
    ///public static final RegistryObject<Item> ORANGE_MAPLE_LEAF_LITTER = register("orange_maple_leaf_litter", () -> blockItem(MysticBlocks.ORANGE_MAPLE_LEAF_LITTER.get()));
    public static final RegistryObject<Item> ORANGE_MAPLE_SAPLING = register("orange_maple_sapling", () -> blockItem(MysticBlocks.ORANGE_MAPLE_SAPLING.get()));
    public static final RegistryObject<Item> YELLOW_MAPLE_LEAVES = register("yellow_maple_leaves", () -> blockItem(MysticBlocks.YELLOW_MAPLE_LEAVES.get()));
    ///public static final RegistryObject<Item> YELLOW_MAPLE_LEAF_PILE = register("yellow_maple_leaf_pile", () -> blockItem(MysticBlocks.YELLOW_MAPLE_LEAF_PILE.get()));
    ///public static final RegistryObject<Item> YELLOW_MAPLE_LEAF_LITTER = register("yellow_maple_leaf_litter", () -> blockItem(MysticBlocks.YELLOW_MAPLE_LEAF_LITTER.get()));
    public static final RegistryObject<Item> YELLOW_MAPLE_SAPLING = register("yellow_maple_sapling", () -> blockItem(MysticBlocks.YELLOW_MAPLE_SAPLING.get()));
    public static final RegistryObject<Item> MAPLE_LOG = register("maple_log", () -> blockItem(MysticBlocks.MAPLE_LOG.get()));
    public static final RegistryObject<Item> WHITE_MAPLE_LOG = register("white_maple_log", () -> blockItem(MysticBlocks.WHITE_MAPLE_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_MAPLE_LOG = register("stripped_maple_log", () -> blockItem(MysticBlocks.STRIPPED_MAPLE_LOG.get()));
    public static final RegistryObject<Item> MAPLE_WOOD = register("maple_wood", () -> blockItem(MysticBlocks.MAPLE_WOOD.get()));
    public static final RegistryObject<Item> WHITE_MAPLE_WOOD = register("white_maple_wood", () -> blockItem(MysticBlocks.WHITE_MAPLE_WOOD.get()));
    public static final RegistryObject<Item> STRIPPED_MAPLE_WOOD = register("stripped_maple_wood", () -> blockItem(MysticBlocks.STRIPPED_MAPLE_WOOD.get()));
    public static final RegistryObject<Item> MAPLE_PLANKS = register("maple_planks", () -> blockItem(MysticBlocks.MAPLE_PLANKS.get()));
    public static final RegistryObject<Item> MAPLE_STAIRS = register("maple_stairs", () -> blockItem(MysticBlocks.MAPLE_STAIRS.get()));
    public static final RegistryObject<Item> MAPLE_SLAB = register("maple_slab", () -> blockItem(MysticBlocks.MAPLE_SLAB.get()));
    public static final RegistryObject<Item> MAPLE_FENCE = register("maple_fence", () -> blockItem(MysticBlocks.MAPLE_FENCE.get()));
    public static final RegistryObject<Item> MAPLE_FENCE_GATE = register("maple_fence_gate", () -> blockItem(MysticBlocks.MAPLE_FENCE_GATE.get()));
    public static final RegistryObject<Item> MAPLE_BUTTON = register("maple_button", () -> blockItem(MysticBlocks.MAPLE_BUTTON.get()));
    public static final RegistryObject<Item> MAPLE_PRESSURE_PLATE = register("maple_pressure_plate", () -> blockItem(MysticBlocks.MAPLE_PRESSURE_PLATE.get()));
    public static final RegistryObject<Item> MAPLE_TRAPDOOR = register("maple_trapdoor", () -> blockItem(MysticBlocks.MAPLE_TRAPDOOR.get()));
    public static final RegistryObject<Item> MAPLE_DOOR = register("maple_door", () -> blockItem(MysticBlocks.MAPLE_DOOR.get()));
    public static final RegistryObject<Item> MAPLE_SIGN = register("maple_sign", () -> signItem(MysticBlocks.MAPLE_SIGN.get(), MysticBlocks.MAPLE_WALL_SIGN.get()));
    public static final RegistryObject<Item> MAPLE_HANGING_SIGN = register("maple_hanging_sign", () -> hangingSignItem(MysticBlocks.MAPLE_HANGING_SIGN.get(), MysticBlocks.MAPLE_WALL_HANGING_SIGN.get()));
    public static final RegistryObject<Item> MAPLE_BOAT = register("maple_boat", () -> boatItem(MysticBoat.Type.MAPLE));
    public static final RegistryObject<Item> MAPLE_CHEST_BOAT = register("maple_chest_boat", () -> chestBoatItem(MysticBoat.Type.MAPLE));

    ///public static final RegistryObject<Item> MAPLE_SAP;
    ///public static final RegistryObject<Item> MAPLE_SYRUP;
    ///public static final RegistryObject<Item> MAPLE_PANCAKES;
    ///public static final RegistryObject<Item> PUMPKIN_COOKIE;
    ///public static final RegistryObject<Item> SPOOKY_COOKIE;
    ///public static final RegistryObject<Item> ASTER;
    ///public static final RegistryObject<Item> GOLDENROD;

    /// lush oasis
    public static final RegistryObject<Item> GRASSY_LUSH_SAND = register("grassy_lush_sand", () -> blockItem(MysticBlocks.GRASSY_LUSH_SAND.get()));
    public static final RegistryObject<Item> LUSH_SAND = register("lush_sand", () -> blockItem(MysticBlocks.LUSH_SAND.get()));
    public static final RegistryObject<Item> LUSH_SANDSTONE = register("lush_sandstone", () -> blockItem(MysticBlocks.LUSH_SANDSTONE.get()));
    public static final RegistryObject<Item> LUSH_SANDSTONE_STAIRS = register("lush_sandstone_stairs", () -> blockItem(MysticBlocks.LUSH_SANDSTONE_STAIRS.get()));
    public static final RegistryObject<Item> LUSH_SANDSTONE_SLAB = register("lush_sandstone_slab", () -> blockItem(MysticBlocks.LUSH_SANDSTONE_SLAB.get()));
    public static final RegistryObject<Item> LUSH_SANDSTONE_WALL = register("lush_sandstone_wall", () -> blockItem(MysticBlocks.LUSH_SANDSTONE_WALL.get()));
    public static final RegistryObject<Item> CHISELED_LUSH_SANDSTONE = register("chiseled_lush_sandstone", () -> blockItem(MysticBlocks.CHISELED_LUSH_SANDSTONE.get()));
    public static final RegistryObject<Item> CUT_LUSH_SANDSTONE = register("cut_lush_sandstone", () -> blockItem(MysticBlocks.CUT_LUSH_SANDSTONE.get()));
    public static final RegistryObject<Item> CUT_LUSH_SANDSTONE_SLAB = register("cut_lush_sandstone_slab", () -> blockItem(MysticBlocks.CUT_LUSH_SANDSTONE_SLAB.get()));
    public static final RegistryObject<Item> SMOOTH_LUSH_SANDSTONE = register("smooth_lush_sandstone", () -> blockItem(MysticBlocks.SMOOTH_LUSH_SANDSTONE.get()));
    public static final RegistryObject<Item> SMOOTH_LUSH_SANDSTONE_STAIRS = register("smooth_lush_sandstone_stairs", () -> blockItem(MysticBlocks.SMOOTH_LUSH_SANDSTONE_STAIRS.get()));
    public static final RegistryObject<Item> SMOOTH_LUSH_SANDSTONE_SLAB = register("smooth_lush_sandstone_slab", () -> blockItem(MysticBlocks.SMOOTH_LUSH_SANDSTONE_SLAB.get()));

    public static final RegistryObject<Item> PEACH_LEAVES = register("peach_leaves", () -> blockItem(MysticBlocks.PEACH_LEAVES.get()));
    public static final RegistryObject<Item> PEACH_SAPLING = register("peach_sapling", () -> blockItem(MysticBlocks.PEACH_SAPLING.get()));
    public static final RegistryObject<Item> PEACH_LOG = register("peach_log", () -> blockItem(MysticBlocks.PEACH_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_PEACH_LOG = register("stripped_peach_log", () -> blockItem(MysticBlocks.STRIPPED_PEACH_LOG.get()));
    public static final RegistryObject<Item> PEACH_WOOD = register("peach_wood", () -> blockItem(MysticBlocks.PEACH_WOOD.get()));
    public static final RegistryObject<Item> STRIPPED_PEACH_WOOD = register("stripped_peach_wood", () -> blockItem(MysticBlocks.STRIPPED_PEACH_WOOD.get()));
    public static final RegistryObject<Item> PEACH_PLANKS = register("peach_planks", () -> blockItem(MysticBlocks.PEACH_PLANKS.get()));
    public static final RegistryObject<Item> PEACH_STAIRS = register("peach_stairs", () -> blockItem(MysticBlocks.PEACH_STAIRS.get()));
    public static final RegistryObject<Item> PEACH_SLAB = register("peach_slab", () -> blockItem(MysticBlocks.PEACH_SLAB.get()));
    public static final RegistryObject<Item> PEACH_FENCE = register("peach_fence", () -> blockItem(MysticBlocks.PEACH_FENCE.get()));
    public static final RegistryObject<Item> PEACH_FENCE_GATE = register("peach_fence_gate", () -> blockItem(MysticBlocks.PEACH_FENCE_GATE.get()));
    public static final RegistryObject<Item> PEACH_BUTTON = register("peach_button", () -> blockItem(MysticBlocks.PEACH_BUTTON.get()));
    public static final RegistryObject<Item> PEACH_PRESSURE_PLATE = register("peach_pressure_plate", () -> blockItem(MysticBlocks.PEACH_PRESSURE_PLATE.get()));
    public static final RegistryObject<Item> PEACH_TRAPDOOR = register("peach_trapdoor", () -> blockItem(MysticBlocks.PEACH_TRAPDOOR.get()));
    public static final RegistryObject<Item> PEACH_DOOR = register("peach_door", () -> blockItem(MysticBlocks.PEACH_DOOR.get()));
    public static final RegistryObject<Item> PEACH_SIGN = register("peach_sign", () -> signItem(MysticBlocks.PEACH_SIGN.get(), MysticBlocks.PEACH_WALL_SIGN.get()));
    public static final RegistryObject<Item> PEACH_HANGING_SIGN = register("peach_hanging_sign", () -> hangingSignItem(MysticBlocks.PEACH_HANGING_SIGN.get(), MysticBlocks.PEACH_WALL_HANGING_SIGN.get()));
    public static final RegistryObject<Item> PEACH_BOAT = register("peach_boat", () -> boatItem(MysticBoat.Type.PEACH));
    public static final RegistryObject<Item> PEACH_CHEST_BOAT = register("peach_chest_boat", () -> chestBoatItem(MysticBoat.Type.PEACH));

    ///public static final RegistryObject<Item> PEACH = register("peach", () -> new ItemNameBlockItem(MysticBlocks.PEACH_PLANT.get(), new Item.Properties().food(new FoodProperties.Builder().nutrition(4).fast().build())));
    ///public static final RegistryObject<Item> PEACH_PIE = register("peach_pie", () -> new BlockItem(MysticBlocks.PEACH_PIE.get(), new Item.Properties().stacksTo(1)));
    ///public static final RegistryObject<Item> PEACH_PLANT;
    ///public static final RegistryObject<Item> DESERT_SHRUB;
    ///public static final RegistryObject<Item> DESERT_GRASS;
    ///public static final RegistryObject<Item> TALL_DESERT_GRASS;
    ///public static final RegistryObject<Item> DESERT_LILY;
    ///public static final RegistryObject<Item> WILDFLOWER;
    ///public static final RegistryObject<Item> SAGUARO_CACTUS;
    ///public static final RegistryObject<Item> SAGUARO_BLOSSOM;
    ///public static final RegistryObject<Item> PRICKLY_CACTUS;
    ///public static final RegistryObject<Item> PRICKLY_BLOSSOM;
    ///public static final RegistryObject<Item> PRICKLY_PEAR;

    /// lagoon
    public static final RegistryObject<Item> SEA_SHRUB_LEAVES = register("sea_shrub_leaves", () -> blockItem(MysticBlocks.SEA_SHRUB_LEAVES.get()));
    public static final RegistryObject<Item> SEA_SHRUB = register("sea_shrub", () -> blockItem(MysticBlocks.SEA_SHRUB.get()));
    public static final RegistryObject<Item> SEA_FOAM_LOG = register("sea_foam_log", () -> blockItem(MysticBlocks.SEA_FOAM_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_SEA_FOAM_LOG = register("stripped_sea_foam_log", () -> blockItem(MysticBlocks.STRIPPED_SEA_FOAM_LOG.get()));
    public static final RegistryObject<Item> SEA_FOAM_WOOD = register("sea_foam_wood", () -> blockItem(MysticBlocks.SEA_FOAM_WOOD.get()));
    public static final RegistryObject<Item> STRIPPED_SEA_FOAM_WOOD = register("stripped_sea_foam_wood", () -> blockItem(MysticBlocks.STRIPPED_SEA_FOAM_WOOD.get()));
    public static final RegistryObject<Item> SEA_FOAM_PLANKS = register("sea_foam_planks", () -> blockItem(MysticBlocks.SEA_FOAM_PLANKS.get()));
    public static final RegistryObject<Item> SEA_FOAM_STAIRS = register("sea_foam_stairs", () -> blockItem(MysticBlocks.SEA_FOAM_STAIRS.get()));
    public static final RegistryObject<Item> SEA_FOAM_SLAB = register("sea_foam_slab", () -> blockItem(MysticBlocks.SEA_FOAM_SLAB.get()));
    public static final RegistryObject<Item> SEA_FOAM_FENCE = register("sea_foam_fence", () -> blockItem(MysticBlocks.SEA_FOAM_FENCE.get()));
    public static final RegistryObject<Item> SEA_FOAM_FENCE_GATE = register("sea_foam_fence_gate", () -> blockItem(MysticBlocks.SEA_FOAM_FENCE_GATE.get()));
    public static final RegistryObject<Item> SEA_FOAM_BUTTON = register("sea_foam_button", () -> blockItem(MysticBlocks.SEA_FOAM_BUTTON.get()));
    public static final RegistryObject<Item> SEA_FOAM_PRESSURE_PLATE = register("sea_foam_pressure_plate", () -> blockItem(MysticBlocks.SEA_FOAM_PRESSURE_PLATE.get()));
    public static final RegistryObject<Item> SEA_FOAM_TRAPDOOR = register("sea_foam_trapdoor", () -> blockItem(MysticBlocks.SEA_FOAM_TRAPDOOR.get()));
    public static final RegistryObject<Item> SEA_FOAM_DOOR = register("sea_foam_door", () -> blockItem(MysticBlocks.SEA_FOAM_DOOR.get()));
    public static final RegistryObject<Item> SEA_FOAM_SIGN = register("sea_foam_sign", () -> signItem(MysticBlocks.SEA_FOAM_SIGN.get(), MysticBlocks.SEA_FOAM_WALL_SIGN.get()));
    public static final RegistryObject<Item> SEA_FOAM_HANGING_SIGN = register("sea_foam_hanging_sign", () -> hangingSignItem(MysticBlocks.SEA_FOAM_HANGING_SIGN.get(), MysticBlocks.SEA_FOAM_WALL_HANGING_SIGN.get()));
    public static final RegistryObject<Item> SEA_FOAM_BOAT = register("sea_foam_boat", () -> boatItem(MysticBoat.Type.SEA_FOAM));
    public static final RegistryObject<Item> SEA_FOAM_CHEST_BOAT = register("sea_foam_chest_boat", () -> chestBoatItem(MysticBoat.Type.SEA_FOAM));

    ///public static final RegistryObject<Item> BEACH_GRASS;
    ///public static final RegistryObject<Item> TALL_BEACH_GRASS;
    ///public static final RegistryObject<Item> MILKWEED;
    ///public static final RegistryObject<Item> SEA_THRIFT;
    ///public static final RegistryObject<Item> SEA_OATS;
    ///public static final RegistryObject<Item> SEA_FOAM;
    ///public static final RegistryObject<Item> SEA_FOAM_BUCKET;
    ///public static final RegistryObject<Item> SEA_OTTER_SPAWN_EGG = register("sea_otter_spawn_egg", () -> new SpawnEggItem(MysticEntities.SEA_OTTER.get(), 5191718, 10980193, new Item.Properties()));

    /// tropics
    public static final RegistryObject<Item> TROPICAL_LEAVES = register("tropical_leaves", () -> blockItem(MysticBlocks.TROPICAL_LEAVES.get()));
    public static final RegistryObject<Item> TROPICAL_SAPLING = register("tropical_sapling", () -> blockItem(MysticBlocks.TROPICAL_SAPLING.get()));
    public static final RegistryObject<Item> TROPICAL_LOG = register("tropical_log", () -> blockItem(MysticBlocks.TROPICAL_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_TROPICAL_LOG = register("stripped_tropical_log", () -> blockItem(MysticBlocks.STRIPPED_TROPICAL_LOG.get()));
    public static final RegistryObject<Item> TROPICAL_WOOD = register("tropical_wood", () -> blockItem(MysticBlocks.TROPICAL_WOOD.get()));
    public static final RegistryObject<Item> STRIPPED_TROPICAL_WOOD = register("stripped_tropical_wood", () -> blockItem(MysticBlocks.STRIPPED_TROPICAL_WOOD.get()));
    public static final RegistryObject<Item> TROPICAL_PLANKS = register("tropical_planks", () -> blockItem(MysticBlocks.TROPICAL_PLANKS.get()));
    public static final RegistryObject<Item> TROPICAL_STAIRS = register("tropical_stairs", () -> blockItem(MysticBlocks.TROPICAL_STAIRS.get()));
    public static final RegistryObject<Item> TROPICAL_SLAB = register("tropical_slab", () -> blockItem(MysticBlocks.TROPICAL_SLAB.get()));
    public static final RegistryObject<Item> TROPICAL_FENCE = register("tropical_fence", () -> blockItem(MysticBlocks.TROPICAL_FENCE.get()));
    public static final RegistryObject<Item> TROPICAL_FENCE_GATE = register("tropical_fence_gate", () -> blockItem(MysticBlocks.TROPICAL_FENCE_GATE.get()));
    public static final RegistryObject<Item> TROPICAL_BUTTON = register("tropical_button", () -> blockItem(MysticBlocks.TROPICAL_BUTTON.get()));
    public static final RegistryObject<Item> TROPICAL_PRESSURE_PLATE = register("tropical_pressure_plate", () -> blockItem(MysticBlocks.TROPICAL_PRESSURE_PLATE.get()));
    public static final RegistryObject<Item> TROPICAL_TRAPDOOR = register("tropical_trapdoor", () -> blockItem(MysticBlocks.TROPICAL_TRAPDOOR.get()));
    public static final RegistryObject<Item> TROPICAL_DOOR = register("tropical_door", () -> blockItem(MysticBlocks.TROPICAL_DOOR.get()));
    public static final RegistryObject<Item> TROPICAL_SIGN = register("tropical_sign", () -> signItem(MysticBlocks.TROPICAL_SIGN.get(), MysticBlocks.TROPICAL_WALL_SIGN.get()));
    public static final RegistryObject<Item> TROPICAL_HANGING_SIGN = register("tropical_hanging_sign", () -> hangingSignItem(MysticBlocks.TROPICAL_HANGING_SIGN.get(), MysticBlocks.TROPICAL_WALL_HANGING_SIGN.get()));
    public static final RegistryObject<Item> TROPICAL_BOAT = register("tropical_boat", () -> boatItem(MysticBoat.Type.TROPICAL));
    public static final RegistryObject<Item> TROPICAL_CHEST_BOAT = register("tropical_chest_boat", () -> chestBoatItem(MysticBoat.Type.TROPICAL));

    public static final RegistryObject<Item> VANILLA_LEAVES = register("vanilla_leaves", () -> blockItem(MysticBlocks.VANILLA_LEAVES.get()));
    public static final RegistryObject<Item> VANILLA_SAPLING = register("vanilla_sapling", () -> blockItem(MysticBlocks.VANILLA_SAPLING.get()));
    public static final RegistryObject<Item> VANILLA_LOG = register("vanilla_log", () -> blockItem(MysticBlocks.VANILLA_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_VANILLA_LOG = register("stripped_vanilla_log", () -> blockItem(MysticBlocks.STRIPPED_VANILLA_LOG.get()));
    public static final RegistryObject<Item> VANILLA_WOOD = register("vanilla_wood", () -> blockItem(MysticBlocks.VANILLA_WOOD.get()));
    public static final RegistryObject<Item> STRIPPED_VANILLA_WOOD = register("stripped_vanilla_wood", () -> blockItem(MysticBlocks.STRIPPED_VANILLA_WOOD.get()));
    public static final RegistryObject<Item> VANILLA_PLANKS = register("vanilla_planks", () -> blockItem(MysticBlocks.VANILLA_PLANKS.get()));
    public static final RegistryObject<Item> VANILLA_STAIRS = register("vanilla_stairs", () -> blockItem(MysticBlocks.VANILLA_STAIRS.get()));
    public static final RegistryObject<Item> VANILLA_SLAB = register("vanilla_slab", () -> blockItem(MysticBlocks.VANILLA_SLAB.get()));
    public static final RegistryObject<Item> VANILLA_FENCE = register("vanilla_fence", () -> blockItem(MysticBlocks.VANILLA_FENCE.get()));
    public static final RegistryObject<Item> VANILLA_FENCE_GATE = register("vanilla_fence_gate", () -> blockItem(MysticBlocks.VANILLA_FENCE_GATE.get()));
    public static final RegistryObject<Item> VANILLA_BUTTON = register("vanilla_button", () -> blockItem(MysticBlocks.VANILLA_BUTTON.get()));
    public static final RegistryObject<Item> VANILLA_PRESSURE_PLATE = register("vanilla_pressure_plate", () -> blockItem(MysticBlocks.VANILLA_PRESSURE_PLATE.get()));
    public static final RegistryObject<Item> VANILLA_TRAPDOOR = register("vanilla_trapdoor", () -> blockItem(MysticBlocks.VANILLA_TRAPDOOR.get()));
    public static final RegistryObject<Item> VANILLA_DOOR = register("vanilla_door", () -> blockItem(MysticBlocks.VANILLA_DOOR.get()));
    public static final RegistryObject<Item> VANILLA_SIGN = register("vanilla_sign", () -> signItem(MysticBlocks.VANILLA_SIGN.get(), MysticBlocks.VANILLA_WALL_SIGN.get()));
    public static final RegistryObject<Item> VANILLA_HANGING_SIGN = register("vanilla_hanging_sign", () -> hangingSignItem(MysticBlocks.VANILLA_HANGING_SIGN.get(), MysticBlocks.VANILLA_WALL_HANGING_SIGN.get()));
    public static final RegistryObject<Item> VANILLA_BOAT = register("vanilla_boat", () -> boatItem(MysticBoat.Type.VANILLA));
    public static final RegistryObject<Item> VANILLA_CHEST_BOAT = register("vanilla_chest_boat", () -> chestBoatItem(MysticBoat.Type.VANILLA));

    ///public static final RegistryObject<Item> TROPICAL_VINES;
    ///public static final RegistryObject<Item> JUNGLE_SHRUB;
    ///public static final RegistryObject<Item> JUNGLE_GRASS;
    ///public static final RegistryObject<Item> TALL_JUNGLE_GRASS;
    ///public static final RegistryObject<Item> BANANA_LEAF_PLANT;
    ///public static final RegistryObject<Item> HYDRANGEA_BUSH_LEAVES;
    ///public static final RegistryObject<Item> HYDRANGEA_BUSH;
    ///public static final RegistryObject<Item> HIBISCUS;
    ///public static final RegistryObject<Item> VANILLA_BEANS = register("vanilla_beans", () -> new ItemNameBlockItem(MysticBlocks.VANILLA_ORCHID.get(), new Item.Properties()));
    public static final RegistryObject<Item> VANILLA_MILK_BUCKET = register("vanilla_milk_bucket", () -> new MilkBucketItem(new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> VANILLA_CAKE = register("vanilla_cake", () -> new BlockItem(MysticBlocks.VANILLA_CAKE.get(), new Item.Properties().stacksTo(1)));
    ///public static final RegistryObject<Item> VANILLA_COW_SPAWN_EGG = register("vanilla_cow_spawn_egg", () -> new SpawnEggItem(MysticEntities.VANILLA_COW.get(), 16775929, 15781816, new Item.Properties()));
    public static final RegistryObject<Item> CHOCOLATE_MILK_BUCKET = register("chocolate_milk_bucket", () -> new MilkBucketItem(new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> CHOCOLATE_CAKE = register("chocolate_cake", () -> new BlockItem(MysticBlocks.CHOCOLATE_CAKE.get(), new Item.Properties().stacksTo(1)));
    ///public static final RegistryObject<Item> CHOCOLATE_COW_SPAWN_EGG = register("chocolate_cow_spawn_egg", () -> new SpawnEggItem(MysticEntities.CHOCOLATE_COW.get(), 11697754, 7950915, new Item.Properties()));

    /// rainbow chickens
    public static final RegistryObject<Item> PINK_FROSTED_CAKE = register("pink_frosted_cake", () -> new BlockItem(MysticBlocks.PINK_FROSTED_CAKE.get(), new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ORANGE_FROSTED_CAKE = register("orange_frosted_cake", () -> new BlockItem(MysticBlocks.ORANGE_FROSTED_CAKE.get(), new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> YELLOW_FROSTED_CAKE = register("yellow_frosted_cake", () -> new BlockItem(MysticBlocks.YELLOW_FROSTED_CAKE.get(), new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> LIME_FROSTED_CAKE = register("lime_frosted_cake", () -> new BlockItem(MysticBlocks.LIME_FROSTED_CAKE.get(), new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> CYAN_FROSTED_CAKE = register("cyan_frosted_cake", () -> new BlockItem(MysticBlocks.CYAN_FROSTED_CAKE.get(), new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> PURPLE_FROSTED_CAKE = register("purple_frosted_cake", () -> new BlockItem(MysticBlocks.PURPLE_FROSTED_CAKE.get(), new Item.Properties().stacksTo(1)));
    ///public static final RegistryObject<Item> RAINBOW_FROSTED_CAKE = register("rainbow_frosted_cake", () -> new BlockItem(MysticBlocks.RAINBOW_FROSTED_CAKE.get(), new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> PINK_EGG = register("pink_egg", () -> new RainbowEggItem(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> ORANGE_EGG = register("orange_egg", () -> new RainbowEggItem(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> YELLOW_EGG = register("yellow_egg", () -> new RainbowEggItem(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> LIME_EGG = register("lime_egg", () -> new RainbowEggItem(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> CYAN_EGG = register("cyan_egg", () -> new RainbowEggItem(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> PURPLE_EGG = register("purple_egg", () -> new RainbowEggItem(new Item.Properties().stacksTo(16)));
    ///public static final RegistryObject<Item> RAINBOW_EGG = register("rainbow_egg", () -> new RainbowEggItem(new Item.Properties().stacksTo(16)));
    ///public static final RegistryObject<Item> RAINBOW_CHICKEN_SPAWN_EGG = register("rainbow_chicken_spawn_egg", () -> new SpawnEggItem(MysticEntities.RAINBOW_CHICKEN.get(), 7666652, 16706605, new Item.Properties()));

    private static RegistryObject<Item> register(String name, Supplier<Item> item) {
        return ITEMS.register(name, item);
    }

    public static void init() {
    }

}