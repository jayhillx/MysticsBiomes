package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.entity.MysticBoat;
import com.mysticsbiomes.common.entity.animal.Butterfly;
import com.mysticsbiomes.common.item.ButterflyJarItem;
import com.mysticsbiomes.common.item.JamItem;
import com.mysticsbiomes.common.item.MysticBoatItem;
import com.mysticsbiomes.common.item.MysticEggItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class MysticItems {

    public static final Item STRAWBERRY_SIGN = registerItem("strawberry_sign", new SignItem((new Item.Settings()).maxCount(16), MysticBlocks.STRAWBERRY_SIGN, MysticBlocks.STRAWBERRY_WALL_SIGN));
    public static final Item STRAWBERRY_HANGING_SIGN = registerItem("strawberry_hanging_sign", new HangingSignItem(MysticBlocks.STRAWBERRY_HANGING_SIGN, MysticBlocks.STRAWBERRY_WALL_HANGING_SIGN, (new Item.Settings()).maxCount(16)));
    public static final Item STRAWBERRY_BOAT = registerItem("strawberry_boat", new MysticBoatItem(false, MysticBoat.Type.STRAWBERRY, (new Item.Settings()).maxCount(1)));
    public static final Item STRAWBERRY_CHEST_BOAT = registerItem("strawberry_chest_boat", new MysticBoatItem(true, MysticBoat.Type.STRAWBERRY, (new Item.Settings()).maxCount(1)));

    public static final Item CHERRY_SIGN = registerItem("cherry_sign", new SignItem((new Item.Settings()).maxCount(16), MysticBlocks.CHERRY_SIGN, MysticBlocks.CHERRY_WALL_SIGN));
    public static final Item CHERRY_HANGING_SIGN = registerItem("cherry_hanging_sign", new HangingSignItem(MysticBlocks.CHERRY_HANGING_SIGN, MysticBlocks.CHERRY_WALL_HANGING_SIGN, (new Item.Settings()).maxCount(16)));
    public static final Item CHERRY_BOAT = registerItem("cherry_boat", new MysticBoatItem(false, MysticBoat.Type.CHERRY, (new Item.Settings()).maxCount(1)));
    public static final Item CHERRY_CHEST_BOAT = registerItem("cherry_chest_boat", new MysticBoatItem(true, MysticBoat.Type.CHERRY, (new Item.Settings()).maxCount(1)));

    public static final Item PEACH_SIGN = registerItem("peach_sign", new SignItem((new Item.Settings()).maxCount(16), MysticBlocks.PEACH_SIGN, MysticBlocks.PEACH_WALL_SIGN));
    public static final Item PEACH_HANGING_SIGN = registerItem("peach_hanging_sign", new HangingSignItem(MysticBlocks.PEACH_HANGING_SIGN, MysticBlocks.PEACH_WALL_HANGING_SIGN, (new Item.Settings()).maxCount(16)));
    public static final Item PEACH_BOAT = registerItem("peach_boat", new MysticBoatItem(false, MysticBoat.Type.PEACH, (new Item.Settings()).maxCount(1)));
    public static final Item PEACH_CHEST_BOAT = registerItem("peach_chest_boat", new MysticBoatItem(true, MysticBoat.Type.PEACH, (new Item.Settings()).maxCount(1)));

    public static final Item MAPLE_SIGN = registerItem("maple_sign", new SignItem((new Item.Settings()).maxCount(16), MysticBlocks.MAPLE_SIGN, MysticBlocks.MAPLE_WALL_SIGN));
    public static final Item MAPLE_HANGING_SIGN = registerItem("maple_hanging_sign", new HangingSignItem(MysticBlocks.MAPLE_HANGING_SIGN, MysticBlocks.MAPLE_WALL_HANGING_SIGN, (new Item.Settings()).maxCount(16)));
    public static final Item MAPLE_BOAT = registerItem("maple_boat", new MysticBoatItem(false, MysticBoat.Type.MAPLE, (new Item.Settings()).maxCount(1)));
    public static final Item MAPLE_CHEST_BOAT = registerItem("maple_chest_boat", new MysticBoatItem(true, MysticBoat.Type.MAPLE, (new Item.Settings()).maxCount(1)));

    public static final Item SEA_FOAM_SIGN = registerItem("sea_foam_sign", new SignItem((new Item.Settings()).maxCount(16), MysticBlocks.SEA_FOAM_SIGN, MysticBlocks.SEA_FOAM_WALL_SIGN));
    public static final Item SEA_FOAM_HANGING_SIGN = registerItem("sea_foam_hanging_sign", new HangingSignItem(MysticBlocks.SEA_FOAM_HANGING_SIGN, MysticBlocks.SEA_FOAM_WALL_HANGING_SIGN, (new Item.Settings()).maxCount(16)));
    public static final Item SEA_FOAM_BOAT = registerItem("sea_foam_boat", new MysticBoatItem(false, MysticBoat.Type.SEA_FOAM, (new Item.Settings()).maxCount(1)));
    public static final Item SEA_FOAM_CHEST_BOAT = registerItem("sea_foam_chest_boat", new MysticBoatItem(true, MysticBoat.Type.SEA_FOAM, (new Item.Settings()).maxCount(1)));

    public static final Item TROPICAL_SIGN = registerItem("tropical_sign", new SignItem((new Item.Settings()).maxCount(16), MysticBlocks.TROPICAL_SIGN, MysticBlocks.TROPICAL_WALL_SIGN));
    public static final Item TROPICAL_HANGING_SIGN = registerItem("tropical_hanging_sign", new HangingSignItem(MysticBlocks.TROPICAL_HANGING_SIGN, MysticBlocks.TROPICAL_WALL_HANGING_SIGN, (new Item.Settings()).maxCount(16)));
    public static final Item TROPICAL_BOAT = registerItem("tropical_boat", new MysticBoatItem(false, MysticBoat.Type.TROPICAL, (new Item.Settings()).maxCount(1)));
    public static final Item TROPICAL_CHEST_BOAT = registerItem("tropical_chest_boat", new MysticBoatItem(true, MysticBoat.Type.TROPICAL, (new Item.Settings()).maxCount(1)));

    public static final Item JACARANDA_SIGN = registerItem("jacaranda_sign", new SignItem((new Item.Settings()).maxCount(16), MysticBlocks.JACARANDA_SIGN, MysticBlocks.JACARANDA_WALL_SIGN));
    public static final Item JACARANDA_HANGING_SIGN = registerItem("jacaranda_hanging_sign", new HangingSignItem(MysticBlocks.JACARANDA_HANGING_SIGN, MysticBlocks.JACARANDA_WALL_HANGING_SIGN, (new Item.Settings()).maxCount(16)));
    public static final Item JACARANDA_BOAT = registerItem("jacaranda_boat", new MysticBoatItem(false, MysticBoat.Type.JACARANDA, (new Item.Settings()).maxCount(1)));
    public static final Item JACARANDA_CHEST_BOAT = registerItem("jacaranda_chest_boat", new MysticBoatItem(true, MysticBoat.Type.JACARANDA, (new Item.Settings()).maxCount(1)));

    public static final Item SPRING_BAMBOO = registerItem("spring_bamboo", new AliasedBlockItem(MysticBlocks.SPRING_BAMBOO, new Item.Settings()));

    public static final Item GLASS_JAR = registerItem("glass_jar", new AliasedBlockItem(MysticBlocks.GLASS_JAR, new Item.Settings().maxCount(16)));
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

    public static final Item STRAWBERRY_COW_SPAWN_EGG = registerItem("strawberry_cow_spawn_egg", new SpawnEggItem(MysticEntities.STRAWBERRY_COW, 16642812, 16756181, new Item.Settings()));
    public static final Item VANILLA_COW_SPAWN_EGG = registerItem("vanilla_cow_spawn_egg", new SpawnEggItem(MysticEntities.VANILLA_COW, 16775929, 15781816, new Item.Settings()));
    public static final Item CHOCOLATE_COW_SPAWN_EGG = registerItem("chocolate_cow_spawn_egg", new SpawnEggItem(MysticEntities.CHOCOLATE_COW, 11697754, 7950915, new Item.Settings()));
    public static final Item RAINBOW_CHICKEN_SPAWN_EGG = registerItem("rainbow_chicken_spawn_egg", new SpawnEggItem(MysticEntities.RAINBOW_CHICKEN, 7666652, 16577636, new Item.Settings()));
    public static final Item RED_PANDA_SPAWN_EGG = registerItem("red_panda_spawn_egg", new SpawnEggItem(MysticEntities.RED_PANDA, 16760947, 13795386, new Item.Settings()));
    public static final Item SEA_OTTER_SPAWN_EGG = registerItem("sea_otter_spawn_egg", new SpawnEggItem(MysticEntities.SEA_OTTER, 5191718, 10980193, new Item.Settings()));
    public static final Item BUTTERFLY_SPAWN_EGG = registerItem("butterfly_spawn_egg", new SpawnEggItem(MysticEntities.BUTTERFLY, 2710099, 3857605, new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, MysticsBiomes.modLoc(name), item);
    }

    private static void addItems(FabricItemGroupEntries entries) {
        entries.add(STRAWBERRY_SIGN);
        entries.add(STRAWBERRY_HANGING_SIGN);
        entries.add(STRAWBERRY_BOAT);
        entries.add(STRAWBERRY_CHEST_BOAT);
        entries.add(CHERRY_SIGN);
        entries.add(CHERRY_HANGING_SIGN);
        entries.add(CHERRY_BOAT);
        entries.add(CHERRY_CHEST_BOAT);
        entries.add(PEACH_SIGN);
        entries.add(PEACH_HANGING_SIGN);
        entries.add(PEACH_BOAT);
        entries.add(PEACH_CHEST_BOAT);
        entries.add(MAPLE_SIGN);
        entries.add(MAPLE_HANGING_SIGN);
        entries.add(MAPLE_BOAT);
        entries.add(MAPLE_CHEST_BOAT);
        entries.add(SEA_FOAM_SIGN);
        entries.add(SEA_FOAM_HANGING_SIGN);
        entries.add(SEA_FOAM_BOAT);
        entries.add(SEA_FOAM_CHEST_BOAT);
        entries.add(TROPICAL_SIGN);
        entries.add(TROPICAL_HANGING_SIGN);
        entries.add(TROPICAL_BOAT);
        entries.add(TROPICAL_CHEST_BOAT);
        entries.add(JACARANDA_SIGN);
        entries.add(JACARANDA_HANGING_SIGN);
        entries.add(JACARANDA_BOAT);
        entries.add(JACARANDA_CHEST_BOAT);
        entries.add(SPRING_BAMBOO);
        entries.add(GLASS_JAR);
        entries.add(ORANGE_BUTTERFLY_IN_JAR);
        entries.add(BLUE_BUTTERFLY_IN_JAR);
        entries.add(CYAN_BUTTERFLY_IN_JAR);
        entries.add(LILAC_BUTTERFLY_IN_JAR);
        entries.add(PINK_BUTTERFLY_IN_JAR);
        entries.add(PURPLE_BUTTERFLY_IN_JAR);
        entries.add(STRAWBERRY);
        entries.add(SWEET_STRAWBERRY);
        entries.add(CHERRIES);
        entries.add(PEACH);
        entries.add(VANILLA_BEANS);
        entries.add(STRAWBERRY_JAM);
        entries.add(CHERRY_JAM);
        entries.add(PEACH_JAM);
        entries.add(STRAWBERRY_MILK_BUCKET);
        entries.add(VANILLA_MILK_BUCKET);
        entries.add(CHOCOLATE_MILK_BUCKET);
        entries.add(STRAWBERRY_CAKE);
        entries.add(VANILLA_CAKE);
        entries.add(CHOCOLATE_CAKE);
        entries.add(PINK_FROSTED_CAKE);
        entries.add(ORANGE_FROSTED_CAKE);
        entries.add(YELLOW_FROSTED_CAKE);
        entries.add(LIME_FROSTED_CAKE);
        entries.add(CYAN_FROSTED_CAKE);
        entries.add(PURPLE_FROSTED_CAKE);
        entries.add(CHERRY_PIE);
        entries.add(PEACH_PIE);
        entries.add(PINK_EGG);
        entries.add(ORANGE_EGG);
        entries.add(YELLOW_EGG);
        entries.add(LIME_EGG);
        entries.add(CYAN_EGG);
        entries.add(PURPLE_EGG);
        entries.add(STRAWBERRY_COW_SPAWN_EGG);
        entries.add(VANILLA_COW_SPAWN_EGG);
        entries.add(CHOCOLATE_COW_SPAWN_EGG);
        entries.add(RAINBOW_CHICKEN_SPAWN_EGG);
        entries.add(RED_PANDA_SPAWN_EGG);
        entries.add(SEA_OTTER_SPAWN_EGG);
        entries.add(BUTTERFLY_SPAWN_EGG);
    }

    public static void registerItems() {
        MysticsBiomes.LOGGER.info("mystic's biomes ~ registering items");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(MysticItems::addItems);
    }

}