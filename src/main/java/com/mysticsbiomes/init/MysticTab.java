package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

public class MysticTab {

    public static final ItemGroup TAB = Registry.register(Registries.ITEM_GROUP, MysticsBiomes.modLoc("tab"), ItemGroup.create(ItemGroup.Row.TOP, 0).displayName(Text.translatable("itemGroup.mysticsbiomes.tab")).icon(() -> new ItemStack(Items.LILAC)).entries((context, entries) -> {
        entries.add(MysticItems.LUSH_SAND);
        entries.add(MysticItems.GRASSY_LUSH_SAND);
        entries.add(MysticItems.LUSH_SANDSTONE);
        entries.add(MysticItems.LUSH_SANDSTONE_STAIRS);
        entries.add(MysticItems.LUSH_SANDSTONE_SLAB);
        entries.add(MysticItems.LUSH_SANDSTONE_WALL);
        entries.add(MysticItems.CHISELED_LUSH_SANDSTONE);
        entries.add(MysticItems.CUT_LUSH_SANDSTONE);
        entries.add(MysticItems.CUT_LUSH_SANDSTONE_SLAB);
        entries.add(MysticItems.SMOOTH_LUSH_SANDSTONE);
        entries.add(MysticItems.SMOOTH_LUSH_SANDSTONE_STAIRS);
        entries.add(MysticItems.SMOOTH_LUSH_SANDSTONE_SLAB);

        entries.add(MysticItems.STRAWBERRY_BLOSSOMS);
        entries.add(MysticItems.STRAWBERRY_SAPLING);
        entries.add(MysticItems.STRAWBERRY_LOG);
        entries.add(MysticItems.STRIPPED_STRAWBERRY_LOG);
        entries.add(MysticItems.STRAWBERRY_WOOD);
        entries.add(MysticItems.STRIPPED_STRAWBERRY_WOOD);
        entries.add(MysticItems.STRAWBERRY_PLANKS);
        entries.add(MysticItems.STRAWBERRY_STAIRS);
        entries.add(MysticItems.STRAWBERRY_SLAB);
        entries.add(MysticItems.STRAWBERRY_FENCE);
        entries.add(MysticItems.STRAWBERRY_FENCE_GATE);
        entries.add(MysticItems.STRAWBERRY_BUTTON);
        entries.add(MysticItems.STRAWBERRY_PRESSURE_PLATE);
        entries.add(MysticItems.STRAWBERRY_TRAPDOOR);
        entries.add(MysticItems.STRAWBERRY_DOOR);
        entries.add(MysticItems.STRAWBERRY_SIGN);
        entries.add(MysticItems.STRAWBERRY_HANGING_SIGN);
        entries.add(MysticItems.STRAWBERRY_BOAT);
        entries.add(MysticItems.STRAWBERRY_CHEST_BOAT);

        entries.add(MysticItems.PINK_CHERRY_BLOSSOMS);
        entries.add(MysticItems.PINK_CHERRY_BLOSSOM_SAPLING);
        entries.add(MysticItems.WHITE_CHERRY_BLOSSOMS);
        entries.add(MysticItems.WHITE_CHERRY_BLOSSOM_SAPLING);
        entries.add(MysticItems.CHERRY_LOG);
        entries.add(MysticItems.STRIPPED_CHERRY_LOG);
        entries.add(MysticItems.CHERRY_WOOD);
        entries.add(MysticItems.STRIPPED_CHERRY_WOOD);
        entries.add(MysticItems.CHERRY_PLANKS);
        entries.add(MysticItems.CHERRY_STAIRS);
        entries.add(MysticItems.CHERRY_SLAB);
        entries.add(MysticItems.CHERRY_FENCE);
        entries.add(MysticItems.CHERRY_FENCE_GATE);
        entries.add(MysticItems.CHERRY_BUTTON);
        entries.add(MysticItems.CHERRY_PRESSURE_PLATE);
        entries.add(MysticItems.CHERRY_TRAPDOOR);
        entries.add(MysticItems.CHERRY_DOOR);
        entries.add(MysticItems.CHERRY_SIGN);
        entries.add(MysticItems.CHERRY_HANGING_SIGN);
        entries.add(MysticItems.CHERRY_BOAT);
        entries.add(MysticItems.CHERRY_CHEST_BOAT);

        entries.add(MysticItems.PEACH_LEAVES);
        entries.add(MysticItems.PEACH_SAPLING);
        entries.add(MysticItems.PEACH_LOG);
        entries.add(MysticItems.STRIPPED_PEACH_LOG);
        entries.add(MysticItems.PEACH_WOOD);
        entries.add(MysticItems.STRIPPED_PEACH_WOOD);
        entries.add(MysticItems.PEACH_PLANKS);
        entries.add(MysticItems.PEACH_STAIRS);
        entries.add(MysticItems.PEACH_SLAB);
        entries.add(MysticItems.PEACH_FENCE);
        entries.add(MysticItems.PEACH_FENCE_GATE);
        entries.add(MysticItems.PEACH_BUTTON);
        entries.add(MysticItems.PEACH_PRESSURE_PLATE);
        entries.add(MysticItems.PEACH_TRAPDOOR);
        entries.add(MysticItems.PEACH_DOOR);
        entries.add(MysticItems.PEACH_SIGN);
        entries.add(MysticItems.PEACH_HANGING_SIGN);
        entries.add(MysticItems.PEACH_BOAT);
        entries.add(MysticItems.PEACH_CHEST_BOAT);

        entries.add(MysticItems.MAPLE_LEAVES);
        entries.add(MysticItems.MAPLE_LEAF_PILE);
        entries.add(MysticItems.MAPLE_SAPLING);
        entries.add(MysticItems.ORANGE_MAPLE_LEAVES);
        entries.add(MysticItems.ORANGE_MAPLE_LEAF_PILE);
        entries.add(MysticItems.ORANGE_MAPLE_SAPLING);
        entries.add(MysticItems.YELLOW_MAPLE_LEAVES);
        entries.add(MysticItems.YELLOW_MAPLE_LEAF_PILE);
        entries.add(MysticItems.YELLOW_MAPLE_SAPLING);
        entries.add(MysticItems.MAPLE_LOG);
        entries.add(MysticItems.WHITE_MAPLE_LOG);
        entries.add(MysticItems.STRIPPED_MAPLE_LOG);
        entries.add(MysticItems.MAPLE_WOOD);
        entries.add(MysticItems.WHITE_MAPLE_WOOD);
        entries.add(MysticItems.STRIPPED_MAPLE_WOOD);
        entries.add(MysticItems.MAPLE_PLANKS);
        entries.add(MysticItems.MAPLE_STAIRS);
        entries.add(MysticItems.MAPLE_SLAB);
        entries.add(MysticItems.MAPLE_FENCE);
        entries.add(MysticItems.MAPLE_FENCE_GATE);
        entries.add(MysticItems.MAPLE_BUTTON);
        entries.add(MysticItems.MAPLE_PRESSURE_PLATE);
        entries.add(MysticItems.MAPLE_TRAPDOOR);
        entries.add(MysticItems.MAPLE_DOOR);
        entries.add(MysticItems.MAPLE_SIGN);
        entries.add(MysticItems.MAPLE_HANGING_SIGN);
        entries.add(MysticItems.MAPLE_BOAT);
        entries.add(MysticItems.MAPLE_CHEST_BOAT);

        entries.add(MysticItems.SEA_SHRUB_LEAVES);
        entries.add(MysticItems.SEA_SHRUB);
        entries.add(MysticItems.SEA_FOAM_LOG);
        entries.add(MysticItems.STRIPPED_SEA_FOAM_LOG);
        entries.add(MysticItems.SEA_FOAM_WOOD);
        entries.add(MysticItems.STRIPPED_SEA_FOAM_WOOD);
        entries.add(MysticItems.SEA_FOAM_PLANKS);
        entries.add(MysticItems.SEA_FOAM_STAIRS);
        entries.add(MysticItems.SEA_FOAM_SLAB);
        entries.add(MysticItems.SEA_FOAM_FENCE);
        entries.add(MysticItems.SEA_FOAM_FENCE_GATE);
        entries.add(MysticItems.SEA_FOAM_BUTTON);
        entries.add(MysticItems.SEA_FOAM_PRESSURE_PLATE);
        entries.add(MysticItems.SEA_FOAM_TRAPDOOR);
        entries.add(MysticItems.SEA_FOAM_DOOR);
        entries.add(MysticItems.SEA_FOAM_SIGN);
        entries.add(MysticItems.SEA_FOAM_HANGING_SIGN);
        entries.add(MysticItems.SEA_FOAM_BOAT);
        entries.add(MysticItems.SEA_FOAM_CHEST_BOAT);

        entries.add(MysticItems.TROPICAL_LEAVES);
        entries.add(MysticItems.TROPICAL_SAPLING);
        entries.add(MysticItems.TROPICAL_LOG);
        entries.add(MysticItems.STRIPPED_TROPICAL_LOG);
        entries.add(MysticItems.TROPICAL_WOOD);
        entries.add(MysticItems.STRIPPED_TROPICAL_WOOD);
        entries.add(MysticItems.TROPICAL_PLANKS);
        entries.add(MysticItems.TROPICAL_STAIRS);
        entries.add(MysticItems.TROPICAL_SLAB);
        entries.add(MysticItems.TROPICAL_FENCE);
        entries.add(MysticItems.TROPICAL_FENCE_GATE);
        entries.add(MysticItems.TROPICAL_BUTTON);
        entries.add(MysticItems.TROPICAL_PRESSURE_PLATE);
        entries.add(MysticItems.TROPICAL_TRAPDOOR);
        entries.add(MysticItems.TROPICAL_DOOR);
        entries.add(MysticItems.TROPICAL_SIGN);
        entries.add(MysticItems.TROPICAL_HANGING_SIGN);
        entries.add(MysticItems.TROPICAL_BOAT);
        entries.add(MysticItems.TROPICAL_CHEST_BOAT);

        entries.add(MysticItems.JACARANDA_BLOSSOMS);
        entries.add(MysticItems.JACARANDA_LEAVES);
        entries.add(MysticItems.JACARANDA_SAPLING);
        entries.add(MysticItems.JACARANDA_LOG);
        entries.add(MysticItems.STRIPPED_JACARANDA_LOG);
        entries.add(MysticItems.JACARANDA_WOOD);
        entries.add(MysticItems.STRIPPED_JACARANDA_WOOD);
        entries.add(MysticItems.JACARANDA_PLANKS);
        entries.add(MysticItems.JACARANDA_STAIRS);
        entries.add(MysticItems.JACARANDA_SLAB);
        entries.add(MysticItems.JACARANDA_FENCE);
        entries.add(MysticItems.JACARANDA_FENCE_GATE);
        entries.add(MysticItems.JACARANDA_BUTTON);
        entries.add(MysticItems.JACARANDA_PRESSURE_PLATE);
        entries.add(MysticItems.JACARANDA_TRAPDOOR);
        entries.add(MysticItems.JACARANDA_DOOR);
        entries.add(MysticItems.JACARANDA_SIGN);
        entries.add(MysticItems.JACARANDA_HANGING_SIGN);
        entries.add(MysticItems.JACARANDA_BOAT);
        entries.add(MysticItems.JACARANDA_CHEST_BOAT);

        entries.add(MysticItems.PEONY_LEAVES);
        entries.add(MysticItems.BUDDING_PEONY_LEAVES);
        entries.add(MysticItems.PEONY_BUSH);
        entries.add(MysticItems.HYDRANGEA_LEAVES);
        entries.add(MysticItems.HYDRANGEA_BUSH);
        entries.add(MysticItems.LAVENDER);
        entries.add(MysticItems.WILDFLOWER);
        entries.add(MysticItems.MILKWEED);
        entries.add(MysticItems.SEA_OATS);
        entries.add(MysticItems.DESERT_GRASS);
        entries.add(MysticItems.SAGUARO_BLOSSOM);
        entries.add(MysticItems.SAGUARO_CACTUS);
        entries.add(MysticItems.SPRING_BAMBOO);
        entries.add(MysticItems.BUNDLED_SPRING_BAMBOO);

        entries.add(MysticItems.BUTTERFLY_NEST);
        entries.add(MysticItems.GLASS_JAR);
        entries.add(MysticItems.BLUE_BUTTERFLY_IN_JAR);
        entries.add(MysticItems.CYAN_BUTTERFLY_IN_JAR);
        entries.add(MysticItems.ORANGE_BUTTERFLY_IN_JAR);
        entries.add(MysticItems.PINK_BUTTERFLY_IN_JAR);
        entries.add(MysticItems.LILAC_BUTTERFLY_IN_JAR);
        entries.add(MysticItems.PURPLE_BUTTERFLY_IN_JAR);

        entries.add(MysticItems.STRAWBERRY);
        entries.add(MysticItems.SWEET_STRAWBERRY);
        entries.add(MysticItems.CHERRIES);
        entries.add(MysticItems.PEACH);
        entries.add(MysticItems.VANILLA_BEANS);

        entries.add(MysticItems.STRAWBERRY_JAM);
        entries.add(MysticItems.CHERRY_JAM);
        entries.add(MysticItems.PEACH_JAM);

        entries.add(MysticItems.STRAWBERRY_CAKE);
        entries.add(MysticItems.VANILLA_CAKE);
        entries.add(MysticItems.CHOCOLATE_CAKE);
        entries.add(MysticItems.PINK_FROSTED_CAKE);
        entries.add(MysticItems.ORANGE_FROSTED_CAKE);
        entries.add(MysticItems.YELLOW_FROSTED_CAKE);
        entries.add(MysticItems.LIME_FROSTED_CAKE);
        entries.add(MysticItems.CYAN_FROSTED_CAKE);
        entries.add(MysticItems.PURPLE_FROSTED_CAKE);
        entries.add(MysticItems.CHERRY_PIE);
        entries.add(MysticItems.PEACH_PIE);

        entries.add(MysticItems.STRAWBERRY_MILK_BUCKET);
        entries.add(MysticItems.VANILLA_MILK_BUCKET);
        entries.add(MysticItems.CHOCOLATE_MILK_BUCKET);

        entries.add(MysticItems.PINK_EGG);
        entries.add(MysticItems.ORANGE_EGG);
        entries.add(MysticItems.YELLOW_EGG);
        entries.add(MysticItems.LIME_EGG);
        entries.add(MysticItems.CYAN_EGG);
        entries.add(MysticItems.PURPLE_EGG);

        entries.add(MysticItems.STRAWBERRY_COW_SPAWN_EGG);
        entries.add(MysticItems.VANILLA_COW_SPAWN_EGG);
        entries.add(MysticItems.CHOCOLATE_COW_SPAWN_EGG);
        entries.add(MysticItems.RAINBOW_CHICKEN_SPAWN_EGG);
        entries.add(MysticItems.RED_PANDA_SPAWN_EGG);
        entries.add(MysticItems.SEA_OTTER_SPAWN_EGG);
        entries.add(MysticItems.BUTTERFLY_SPAWN_EGG);
    }).build());

    public static void registerItemGroup() {
        MysticsBiomes.LOGGER.info("mystic's biomes ~ registering creative tab");
    }

}