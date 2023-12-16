package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.entity.MysticBoat;
import com.mysticsbiomes.common.item.MysticBlockItem;
import com.mysticsbiomes.common.item.MysticBoatItem;
import com.mysticsbiomes.common.item.GlassJarItem;
import com.mysticsbiomes.common.item.StrawberryJamItem;
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

    // strawberry fields
    public static final RegistryObject<Item> STRAWBERRY_BLOSSOMS = ITEMS.register("strawberry_blossoms", () -> new MysticBlockItem(MysticBlocks.STRAWBERRY_BLOSSOMS));
    public static final RegistryObject<Item> STRAWBERRY_SAPLING = ITEMS.register("strawberry_sapling", () -> new MysticBlockItem(MysticBlocks.STRAWBERRY_SAPLING));

    public static final RegistryObject<Item> STRAWBERRY_LOG = ITEMS.register("strawberry_log", () -> new MysticBlockItem(MysticBlocks.STRAWBERRY_LOG));
    public static final RegistryObject<Item> STRIPPED_STRAWBERRY_LOG = ITEMS.register("stripped_strawberry_log", () -> new MysticBlockItem(MysticBlocks.STRIPPED_STRAWBERRY_LOG));
    public static final RegistryObject<Item> STRAWBERRY_WOOD = ITEMS.register("strawberry_wood", () -> new MysticBlockItem(MysticBlocks.STRAWBERRY_WOOD));
    public static final RegistryObject<Item> STRIPPED_STRAWBERRY_WOOD = ITEMS.register("stripped_strawberry_wood", () -> new MysticBlockItem(MysticBlocks.STRIPPED_STRAWBERRY_WOOD));
    public static final RegistryObject<Item> STRAWBERRY_PLANKS = ITEMS.register("strawberry_planks", () -> new MysticBlockItem(MysticBlocks.STRAWBERRY_PLANKS));
    public static final RegistryObject<Item> STRAWBERRY_STAIRS = ITEMS.register("strawberry_stairs", () -> new MysticBlockItem(MysticBlocks.STRAWBERRY_STAIRS));
    public static final RegistryObject<Item> STRAWBERRY_SLAB = ITEMS.register("strawberry_slab", () -> new MysticBlockItem(MysticBlocks.STRAWBERRY_SLAB));
    public static final RegistryObject<Item> STRAWBERRY_FENCE = ITEMS.register("strawberry_fence", () -> new MysticBlockItem(MysticBlocks.STRAWBERRY_FENCE));
    public static final RegistryObject<Item> STRAWBERRY_FENCE_GATE = ITEMS.register("strawberry_fence_gate", () -> new MysticBlockItem(MysticBlocks.STRAWBERRY_FENCE_GATE));
    public static final RegistryObject<Item> STRAWBERRY_BUTTON = ITEMS.register("strawberry_button", () -> new MysticBlockItem(MysticBlocks.STRAWBERRY_BUTTON));
    public static final RegistryObject<Item> STRAWBERRY_PRESSURE_PLATE = ITEMS.register("strawberry_pressure_plate", () -> new MysticBlockItem(MysticBlocks.STRAWBERRY_PRESSURE_PLATE));
    public static final RegistryObject<Item> STRAWBERRY_TRAPDOOR = ITEMS.register("strawberry_trapdoor", () -> new MysticBlockItem(MysticBlocks.STRAWBERRY_TRAPDOOR));
    public static final RegistryObject<Item> STRAWBERRY_DOOR = ITEMS.register("strawberry_door", () -> new MysticBlockItem(MysticBlocks.STRAWBERRY_DOOR));
    public static final RegistryObject<Item> STRAWBERRY_SIGN = ITEMS.register("strawberry_sign", () -> new SignItem((new Item.Properties()).stacksTo(16), MysticBlocks.STRAWBERRY_SIGN.get(), MysticBlocks.STRAWBERRY_WALL_SIGN.get()));
    public static final RegistryObject<Item> STRAWBERRY_HANGING_SIGN = ITEMS.register("strawberry_hanging_sign", () -> new HangingSignItem(MysticBlocks.STRAWBERRY_HANGING_SIGN.get(), MysticBlocks.STRAWBERRY_WALL_HANGING_SIGN.get(), (new Item.Properties()).stacksTo(16)));
    public static final RegistryObject<Item> STRAWBERRY_BOAT = ITEMS.register("strawberry_boat", () -> new MysticBoatItem(false, MysticBoat.Type.STRAWBERRY, (new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> STRAWBERRY_CHEST_BOAT = ITEMS.register("strawberry_chest_boat", () -> new MysticBoatItem(true, MysticBoat.Type.STRAWBERRY, (new Item.Properties()).stacksTo(1)));

    // bamboo blossom forest
    public static final RegistryObject<Item> PINK_CHERRY_BLOSSOMS = ITEMS.register("pink_cherry_blossoms", () -> new MysticBlockItem(MysticBlocks.PINK_CHERRY_BLOSSOMS));
    public static final RegistryObject<Item> PINK_CHERRY_BLOSSOM_SAPLING = ITEMS.register("pink_cherry_blossom_sapling", () -> new MysticBlockItem(MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING));
    public static final RegistryObject<Item> WHITE_CHERRY_BLOSSOMS = ITEMS.register("white_cherry_blossoms", () -> new MysticBlockItem(MysticBlocks.WHITE_CHERRY_BLOSSOMS));
    public static final RegistryObject<Item> WHITE_CHERRY_BLOSSOM_SAPLING = ITEMS.register("white_cherry_blossom_sapling", () -> new MysticBlockItem(MysticBlocks.WHITE_CHERRY_BLOSSOM_SAPLING));

    public static final RegistryObject<Item> CHERRY_LOG = ITEMS.register("cherry_log", () -> new MysticBlockItem(MysticBlocks.CHERRY_LOG));
    public static final RegistryObject<Item> STRIPPED_CHERRY_LOG = ITEMS.register("stripped_cherry_log", () -> new MysticBlockItem(MysticBlocks.STRIPPED_CHERRY_LOG));
    public static final RegistryObject<Item> CHERRY_WOOD = ITEMS.register("cherry_wood", () -> new MysticBlockItem(MysticBlocks.CHERRY_WOOD));
    public static final RegistryObject<Item> STRIPPED_CHERRY_WOOD = ITEMS.register("stripped_cherry_wood", () -> new MysticBlockItem(MysticBlocks.STRIPPED_CHERRY_WOOD));
    public static final RegistryObject<Item> CHERRY_PLANKS = ITEMS.register("cherry_planks", () -> new MysticBlockItem(MysticBlocks.CHERRY_PLANKS));
    public static final RegistryObject<Item> CHERRY_STAIRS = ITEMS.register("cherry_stairs", () -> new MysticBlockItem(MysticBlocks.CHERRY_STAIRS));
    public static final RegistryObject<Item> CHERRY_SLAB = ITEMS.register("cherry_slab", () -> new MysticBlockItem(MysticBlocks.CHERRY_SLAB));
    public static final RegistryObject<Item> CHERRY_FENCE = ITEMS.register("cherry_fence", () -> new MysticBlockItem(MysticBlocks.CHERRY_FENCE));
    public static final RegistryObject<Item> CHERRY_FENCE_GATE = ITEMS.register("cherry_fence_gate", () -> new MysticBlockItem(MysticBlocks.CHERRY_FENCE_GATE));
    public static final RegistryObject<Item> CHERRY_BUTTON = ITEMS.register("cherry_button", () -> new MysticBlockItem(MysticBlocks.CHERRY_BUTTON));
    public static final RegistryObject<Item> CHERRY_PRESSURE_PLATE = ITEMS.register("cherry_pressure_plate", () -> new MysticBlockItem(MysticBlocks.CHERRY_PRESSURE_PLATE));
    public static final RegistryObject<Item> CHERRY_TRAPDOOR = ITEMS.register("cherry_trapdoor", () -> new MysticBlockItem(MysticBlocks.CHERRY_TRAPDOOR));
    public static final RegistryObject<Item> CHERRY_DOOR = ITEMS.register("cherry_door", () -> new MysticBlockItem(MysticBlocks.CHERRY_DOOR));
    public static final RegistryObject<Item> CHERRY_SIGN = ITEMS.register("cherry_sign", () -> new SignItem((new Item.Properties()).stacksTo(16), MysticBlocks.CHERRY_SIGN.get(), MysticBlocks.CHERRY_WALL_SIGN.get()));
    public static final RegistryObject<Item> CHERRY_HANGING_SIGN = ITEMS.register("cherry_hanging_sign", () -> new HangingSignItem(MysticBlocks.CHERRY_HANGING_SIGN.get(), MysticBlocks.CHERRY_WALL_HANGING_SIGN.get(), (new Item.Properties()).stacksTo(16)));
    public static final RegistryObject<Item> CHERRY_BOAT = ITEMS.register("cherry_boat", () -> new MysticBoatItem(false, MysticBoat.Type.CHERRY, (new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> CHERRY_CHEST_BOAT = ITEMS.register("cherry_chest_boat", () -> new MysticBoatItem(true, MysticBoat.Type.CHERRY, (new Item.Properties()).stacksTo(1)));

    // autumnal grove
    public static final RegistryObject<Item> MAPLE_LEAVES = ITEMS.register("maple_leaves", () -> new MysticBlockItem(MysticBlocks.MAPLE_LEAVES));
    public static final RegistryObject<Item> MAPLE_SAPLING = ITEMS.register("maple_sapling", () -> new MysticBlockItem(MysticBlocks.MAPLE_SAPLING));
    public static final RegistryObject<Item> ORANGE_MAPLE_LEAVES = ITEMS.register("orange_maple_leaves", () -> new MysticBlockItem(MysticBlocks.ORANGE_MAPLE_LEAVES));
    public static final RegistryObject<Item> ORANGE_MAPLE_SAPLING = ITEMS.register("orange_maple_sapling", () -> new MysticBlockItem(MysticBlocks.ORANGE_MAPLE_SAPLING));
    public static final RegistryObject<Item> YELLOW_MAPLE_LEAVES = ITEMS.register("yellow_maple_leaves", () -> new MysticBlockItem(MysticBlocks.YELLOW_MAPLE_LEAVES));
    public static final RegistryObject<Item> YELLOW_MAPLE_SAPLING = ITEMS.register("yellow_maple_sapling", () -> new MysticBlockItem(MysticBlocks.YELLOW_MAPLE_SAPLING));

    public static final RegistryObject<Item> MAPLE_LOG = ITEMS.register("maple_log", () -> new MysticBlockItem(MysticBlocks.MAPLE_LOG));
    public static final RegistryObject<Item> WHITE_MAPLE_LOG = ITEMS.register("white_maple_log", () -> new MysticBlockItem(MysticBlocks.WHITE_MAPLE_LOG));
    public static final RegistryObject<Item> STRIPPED_MAPLE_LOG = ITEMS.register("stripped_maple_log", () -> new MysticBlockItem(MysticBlocks.STRIPPED_MAPLE_LOG));
    public static final RegistryObject<Item> MAPLE_WOOD = ITEMS.register("maple_wood", () -> new MysticBlockItem(MysticBlocks.MAPLE_WOOD));
    public static final RegistryObject<Item> WHITE_MAPLE_WOOD = ITEMS.register("white_maple_wood", () -> new MysticBlockItem(MysticBlocks.WHITE_MAPLE_WOOD));
    public static final RegistryObject<Item> STRIPPED_MAPLE_WOOD = ITEMS.register("stripped_maple_wood", () -> new MysticBlockItem(MysticBlocks.STRIPPED_MAPLE_WOOD));
    public static final RegistryObject<Item> MAPLE_PLANKS = ITEMS.register("maple_planks", () -> new MysticBlockItem(MysticBlocks.MAPLE_PLANKS));
    public static final RegistryObject<Item> MAPLE_STAIRS = ITEMS.register("maple_stairs", () -> new MysticBlockItem(MysticBlocks.MAPLE_STAIRS));
    public static final RegistryObject<Item> MAPLE_SLAB = ITEMS.register("maple_slab", () -> new MysticBlockItem(MysticBlocks.MAPLE_SLAB));
    public static final RegistryObject<Item> MAPLE_FENCE = ITEMS.register("maple_fence", () -> new MysticBlockItem(MysticBlocks.MAPLE_FENCE));
    public static final RegistryObject<Item> MAPLE_FENCE_GATE = ITEMS.register("maple_fence_gate", () -> new MysticBlockItem(MysticBlocks.MAPLE_FENCE_GATE));
    public static final RegistryObject<Item> MAPLE_BUTTON = ITEMS.register("maple_button", () -> new MysticBlockItem(MysticBlocks.MAPLE_BUTTON));
    public static final RegistryObject<Item> MAPLE_PRESSURE_PLATE = ITEMS.register("maple_pressure_plate", () -> new MysticBlockItem(MysticBlocks.MAPLE_PRESSURE_PLATE));
    public static final RegistryObject<Item> MAPLE_TRAPDOOR = ITEMS.register("maple_trapdoor", () -> new MysticBlockItem(MysticBlocks.MAPLE_TRAPDOOR));
    public static final RegistryObject<Item> MAPLE_DOOR = ITEMS.register("maple_door", () -> new MysticBlockItem(MysticBlocks.MAPLE_DOOR));
    public static final RegistryObject<Item> MAPLE_SIGN = ITEMS.register("maple_sign", () -> new SignItem((new Item.Properties()).stacksTo(16), MysticBlocks.MAPLE_SIGN.get(), MysticBlocks.MAPLE_WALL_SIGN.get()));
    public static final RegistryObject<Item> MAPLE_HANGING_SIGN = ITEMS.register("maple_hanging_sign", () -> new HangingSignItem(MysticBlocks.MAPLE_HANGING_SIGN.get(), MysticBlocks.MAPLE_WALL_HANGING_SIGN.get(), (new Item.Properties()).stacksTo(16)));
    public static final RegistryObject<Item> MAPLE_BOAT = ITEMS.register("maple_boat", () -> new MysticBoatItem(false, MysticBoat.Type.MAPLE, (new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> MAPLE_CHEST_BOAT = ITEMS.register("maple_chest_boat", () -> new MysticBoatItem(true, MysticBoat.Type.MAPLE, (new Item.Properties()).stacksTo(1)));

    public static final RegistryObject<Item> MAPLE_LEAF_PILE = ITEMS.register("maple_leaf_pile", () -> new MysticBlockItem(MysticBlocks.MAPLE_LEAF_PILE));
    public static final RegistryObject<Item> ORANGE_MAPLE_LEAF_PILE = ITEMS.register("orange_maple_leaf_pile", () -> new MysticBlockItem(MysticBlocks.ORANGE_MAPLE_LEAF_PILE));
    public static final RegistryObject<Item> YELLOW_MAPLE_LEAF_PILE = ITEMS.register("yellow_maple_leaf_pile", () -> new MysticBlockItem(MysticBlocks.YELLOW_MAPLE_LEAF_PILE));

    // lavender meadow
    public static final RegistryObject<Item> JACARANDA_BLOSSOMS = ITEMS.register("jacaranda_blossoms", () -> new MysticBlockItem(MysticBlocks.JACARANDA_BLOSSOMS));
    public static final RegistryObject<Item> JACARANDA_LEAVES = ITEMS.register("jacaranda_leaves", () -> new MysticBlockItem(MysticBlocks.JACARANDA_LEAVES));
    public static final RegistryObject<Item> JACARANDA_SAPLING = ITEMS.register("jacaranda_sapling", () -> new MysticBlockItem(MysticBlocks.JACARANDA_SAPLING));

    public static final RegistryObject<Item> JACARANDA_LOG = ITEMS.register("jacaranda_log", () -> new MysticBlockItem(MysticBlocks.JACARANDA_LOG));
    public static final RegistryObject<Item> STRIPPED_JACARANDA_LOG = ITEMS.register("stripped_jacaranda_log", () -> new MysticBlockItem(MysticBlocks.STRIPPED_JACARANDA_LOG));
    public static final RegistryObject<Item> JACARANDA_WOOD = ITEMS.register("jacaranda_wood", () -> new MysticBlockItem(MysticBlocks.JACARANDA_WOOD));
    public static final RegistryObject<Item> STRIPPED_JACARANDA_WOOD = ITEMS.register("stripped_jacaranda_wood", () -> new MysticBlockItem(MysticBlocks.STRIPPED_JACARANDA_WOOD));
    public static final RegistryObject<Item> JACARANDA_PLANKS = ITEMS.register("jacaranda_planks", () -> new MysticBlockItem(MysticBlocks.JACARANDA_PLANKS));
    public static final RegistryObject<Item> JACARANDA_STAIRS = ITEMS.register("jacaranda_stairs", () -> new MysticBlockItem(MysticBlocks.JACARANDA_STAIRS));
    public static final RegistryObject<Item> JACARANDA_SLAB = ITEMS.register("jacaranda_slab", () -> new MysticBlockItem(MysticBlocks.JACARANDA_SLAB));
    public static final RegistryObject<Item> JACARANDA_FENCE = ITEMS.register("jacaranda_fence", () -> new MysticBlockItem(MysticBlocks.JACARANDA_FENCE));
    public static final RegistryObject<Item> JACARANDA_FENCE_GATE = ITEMS.register("jacaranda_fence_gate", () -> new MysticBlockItem(MysticBlocks.JACARANDA_FENCE_GATE));
    public static final RegistryObject<Item> JACARANDA_BUTTON = ITEMS.register("jacaranda_button", () -> new MysticBlockItem(MysticBlocks.JACARANDA_BUTTON));
    public static final RegistryObject<Item> JACARANDA_PRESSURE_PLATE = ITEMS.register("jacaranda_pressure_plate", () -> new MysticBlockItem(MysticBlocks.JACARANDA_PRESSURE_PLATE));
    public static final RegistryObject<Item> JACARANDA_TRAPDOOR = ITEMS.register("jacaranda_trapdoor", () -> new MysticBlockItem(MysticBlocks.JACARANDA_TRAPDOOR));
    public static final RegistryObject<Item> JACARANDA_DOOR = ITEMS.register("jacaranda_door", () -> new MysticBlockItem(MysticBlocks.JACARANDA_DOOR));
    public static final RegistryObject<Item> JACARANDA_SIGN = ITEMS.register("jacaranda_sign", () -> new SignItem((new Item.Properties()).stacksTo(16), MysticBlocks.JACARANDA_SIGN.get(), MysticBlocks.JACARANDA_WALL_SIGN.get()));
    public static final RegistryObject<Item> JACARANDA_HANGING_SIGN = ITEMS.register("jacaranda_hanging_sign", () -> new HangingSignItem(MysticBlocks.JACARANDA_HANGING_SIGN.get(), MysticBlocks.JACARANDA_WALL_HANGING_SIGN.get(), (new Item.Properties()).stacksTo(16)));
    public static final RegistryObject<Item> JACARANDA_BOAT = ITEMS.register("jacaranda_boat", () -> new MysticBoatItem(false, MysticBoat.Type.JACARANDA, (new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> JACARANDA_CHEST_BOAT = ITEMS.register("jacaranda_chest_boat", () -> new MysticBoatItem(true, MysticBoat.Type.JACARANDA, (new Item.Properties()).stacksTo(1)));

    public static final RegistryObject<Item> BUTTERFLY_NEST = ITEMS.register("butterfly_nest", () -> new MysticBlockItem(MysticBlocks.BUTTERFLY_NEST));
    public static final RegistryObject<Item> CHRYSALIS = ITEMS.register("chrysalis", () -> new MysticBlockItem(MysticBlocks.CHRYSALIS));

    public static final RegistryObject<Item> SPICED_PUMPKIN = ITEMS.register("spiced_pumpkin", () -> new MysticBlockItem(MysticBlocks.SPICED_PUMPKIN));
    public static final RegistryObject<Item> CARVED_SPICED_PUMPKIN = ITEMS.register("carved_spiced_pumpkin", () -> new MysticBlockItem(MysticBlocks.CARVED_SPICED_PUMPKIN));
    public static final RegistryObject<Item> SPICED_JACK_O_LANTERN = ITEMS.register("spiced_jack_o_lantern", () -> new MysticBlockItem(MysticBlocks.SPICED_JACK_O_LANTERN));
    public static final RegistryObject<Item> SPICED_PUMPKIN_SEEDS = ITEMS.register("spiced_pumpkin_seeds", () -> new ItemNameBlockItem(MysticBlocks.SPICED_PUMPKIN_STEM.get(), new Item.Properties()));

    public static final RegistryObject<Item> BUDDING_PEONY_LEAVES = ITEMS.register("budding_peony_leaves", () -> new MysticBlockItem(MysticBlocks.BUDDING_PEONY_LEAVES));
    public static final RegistryObject<Item> PEONY_LEAVES = ITEMS.register("peony_leaves", () -> new MysticBlockItem(MysticBlocks.PEONY_LEAVES));
    public static final RegistryObject<Item> PEONY_BUSH = ITEMS.register("peony_bush", () -> new MysticBlockItem(MysticBlocks.PEONY_BUSH));

    public static final RegistryObject<Item> LAVENDER = ITEMS.register("lavender", () -> new MysticBlockItem(MysticBlocks.LAVENDER));

    public static final RegistryObject<Item> GLASS_JAR = ITEMS.register("glass_jar", () -> new GlassJarItem(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> STRAWBERRY_JAM = ITEMS.register("strawberry_jam", () -> new StrawberryJamItem(new Item.Properties().stacksTo(16).craftRemainder(GLASS_JAR.get()).food(new FoodProperties.Builder().nutrition(2).fast().build())));
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry", () -> new ItemNameBlockItem(MysticBlocks.STRAWBERRY_BUSH.get(), (new Item.Properties().food(new FoodProperties.Builder().nutrition(2).fast().build()))));
    public static final RegistryObject<Item> SWEET_STRAWBERRY = ITEMS.register("sweet_strawberry", () -> new ItemNameBlockItem(MysticBlocks.STRAWBERRY_BUSH.get(), (new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(1.2F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F).build()))));
    public static final RegistryObject<Item> STRAWBERRY_CAKE = ITEMS.register("strawberry_cake", () -> new BlockItem(MysticBlocks.STRAWBERRY_CAKE.get(), (new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> STRAWBERRY_MILK_BUCKET = ITEMS.register("strawberry_milk_bucket", () -> new MilkBucketItem((new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> STRAWBERRY_ICE_CREAM = ITEMS.register("strawberry_ice_cream", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PUMPKIN_ICE_CREAM = ITEMS.register("pumpkin_ice_cream", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PUMPKIN_COOKIE = ITEMS.register("pumpkin_cookie", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STRAWBERRY_COW_SPAWN_EGG = ITEMS.register("strawberry_cow_spawn_egg", () -> new ForgeSpawnEggItem(MysticEntities.STRAWBERRY_COW, 16773110, 16297913, new Item.Properties()));
    public static final RegistryObject<Item> RED_PANDA_SPAWN_EGG = ITEMS.register("red_panda_spawn_egg", () -> new ForgeSpawnEggItem(MysticEntities.RED_PANDA, 15170875, 9839122, new Item.Properties()));
    public static final RegistryObject<Item> BUTTERFLY_SPAWN_EGG = ITEMS.register("butterfly_spawn_egg", () -> new ForgeSpawnEggItem(MysticEntities.BUTTERFLY, 1662039, 1031848, new Item.Properties()));
    public static final RegistryObject<Item> CATERPILLAR_SPAWN_EGG = ITEMS.register("caterpillar_spawn_egg", () -> new ForgeSpawnEggItem(MysticEntities.CATERPILLAR, 11921522, 9945732, new Item.Properties()));

}