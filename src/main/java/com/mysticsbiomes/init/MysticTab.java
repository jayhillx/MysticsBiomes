package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

public class MysticTab {

    public static final ItemGroup TAB = Registry.register(Registries.ITEM_GROUP, MysticsBiomes.modLoc("mysticsbiomes"), FabricItemGroup.builder().displayName(Text.translatable("itemGroup.mysticsbiomes")).icon(() -> new ItemStack(Items.LILAC)).entries((context, entries) -> {
        entries.add(MysticBlocks.LUSH_SAND);
        entries.add(MysticBlocks.GRASSY_LUSH_SAND);
        entries.add(MysticBlocks.LUSH_SANDSTONE);
        entries.add(MysticBlocks.LUSH_SANDSTONE_STAIRS);
        entries.add(MysticBlocks.LUSH_SANDSTONE_SLAB);
        entries.add(MysticBlocks.LUSH_SANDSTONE_WALL);
        entries.add(MysticBlocks.CHISELED_LUSH_SANDSTONE);
        entries.add(MysticBlocks.CUT_LUSH_SANDSTONE);
        entries.add(MysticBlocks.CUT_LUSH_SANDSTONE_SLAB);
        entries.add(MysticBlocks.SMOOTH_LUSH_SANDSTONE);
        entries.add(MysticBlocks.SMOOTH_LUSH_SANDSTONE_STAIRS);
        entries.add(MysticBlocks.SMOOTH_LUSH_SANDSTONE_SLAB);

        entries.add(MysticBlocks.STRAWBERRY_BLOSSOMS);
        entries.add(MysticBlocks.STRAWBERRY_SAPLING);
        entries.add(MysticBlocks.STRAWBERRY_LOG);
        entries.add(MysticBlocks.STRIPPED_STRAWBERRY_LOG);
        entries.add(MysticBlocks.STRAWBERRY_WOOD);
        entries.add(MysticBlocks.STRIPPED_STRAWBERRY_WOOD);
        entries.add(MysticBlocks.STRAWBERRY_PLANKS);
        entries.add(MysticBlocks.STRAWBERRY_STAIRS);
        entries.add(MysticBlocks.STRAWBERRY_SLAB);
        entries.add(MysticBlocks.STRAWBERRY_FENCE);
        entries.add(MysticBlocks.STRAWBERRY_FENCE_GATE);
        entries.add(MysticBlocks.STRAWBERRY_BUTTON);
        entries.add(MysticBlocks.STRAWBERRY_PRESSURE_PLATE);
        entries.add(MysticBlocks.STRAWBERRY_TRAPDOOR);
        entries.add(MysticBlocks.STRAWBERRY_DOOR);
        entries.add(MysticItems.STRAWBERRY_SIGN);
        entries.add(MysticItems.STRAWBERRY_HANGING_SIGN);
        entries.add(MysticItems.STRAWBERRY_BOAT);
        entries.add(MysticItems.STRAWBERRY_CHEST_BOAT);

        entries.add(MysticBlocks.PINK_CHERRY_BLOSSOMS);
        entries.add(MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING);
        entries.add(MysticBlocks.WHITE_CHERRY_BLOSSOMS);
        entries.add(MysticBlocks.WHITE_CHERRY_BLOSSOM_SAPLING);
        entries.add(MysticBlocks.CHERRY_LOG);
        entries.add(MysticBlocks.STRIPPED_CHERRY_LOG);
        entries.add(MysticBlocks.CHERRY_WOOD);
        entries.add(MysticBlocks.STRIPPED_CHERRY_WOOD);
        entries.add(MysticBlocks.CHERRY_PLANKS);
        entries.add(MysticBlocks.CHERRY_STAIRS);
        entries.add(MysticBlocks.CHERRY_SLAB);
        entries.add(MysticBlocks.CHERRY_FENCE);
        entries.add(MysticBlocks.CHERRY_FENCE_GATE);
        entries.add(MysticBlocks.CHERRY_BUTTON);
        entries.add(MysticBlocks.CHERRY_PRESSURE_PLATE);
        entries.add(MysticBlocks.CHERRY_TRAPDOOR);
        entries.add(MysticBlocks.CHERRY_DOOR);
        entries.add(MysticItems.CHERRY_SIGN);
        entries.add(MysticItems.CHERRY_HANGING_SIGN);
        entries.add(MysticItems.CHERRY_BOAT);
        entries.add(MysticItems.CHERRY_CHEST_BOAT);

        entries.add(MysticBlocks.PEACH_LEAVES);
        entries.add(MysticBlocks.PEACH_SAPLING);
        entries.add(MysticBlocks.PEACH_LOG);
        entries.add(MysticBlocks.STRIPPED_PEACH_LOG);
        entries.add(MysticBlocks.PEACH_WOOD);
        entries.add(MysticBlocks.STRIPPED_PEACH_WOOD);
        entries.add(MysticBlocks.PEACH_PLANKS);
        entries.add(MysticBlocks.PEACH_STAIRS);
        entries.add(MysticBlocks.PEACH_SLAB);
        entries.add(MysticBlocks.PEACH_FENCE);
        entries.add(MysticBlocks.PEACH_FENCE_GATE);
        entries.add(MysticBlocks.PEACH_BUTTON);
        entries.add(MysticBlocks.PEACH_PRESSURE_PLATE);
        entries.add(MysticBlocks.PEACH_TRAPDOOR);
        entries.add(MysticBlocks.PEACH_DOOR);
        entries.add(MysticItems.PEACH_SIGN);
        entries.add(MysticItems.PEACH_HANGING_SIGN);
        entries.add(MysticItems.PEACH_BOAT);
        entries.add(MysticItems.PEACH_CHEST_BOAT);

        entries.add(MysticBlocks.MAPLE_LEAVES);
        entries.add(MysticBlocks.MAPLE_LEAF_PILE);
        entries.add(MysticBlocks.MAPLE_SAPLING);
        entries.add(MysticBlocks.ORANGE_MAPLE_LEAVES);
        entries.add(MysticBlocks.ORANGE_MAPLE_LEAF_PILE);
        entries.add(MysticBlocks.ORANGE_MAPLE_SAPLING);
        entries.add(MysticBlocks.YELLOW_MAPLE_LEAVES);
        entries.add(MysticBlocks.YELLOW_MAPLE_LEAF_PILE);
        entries.add(MysticBlocks.YELLOW_MAPLE_SAPLING);
        entries.add(MysticBlocks.MAPLE_LOG);
        entries.add(MysticBlocks.WHITE_MAPLE_LOG);
        entries.add(MysticBlocks.STRIPPED_MAPLE_LOG);
        entries.add(MysticBlocks.MAPLE_WOOD);
        entries.add(MysticBlocks.WHITE_MAPLE_WOOD);
        entries.add(MysticBlocks.STRIPPED_MAPLE_WOOD);
        entries.add(MysticBlocks.MAPLE_PLANKS);
        entries.add(MysticBlocks.MAPLE_STAIRS);
        entries.add(MysticBlocks.MAPLE_SLAB);
        entries.add(MysticBlocks.MAPLE_FENCE);
        entries.add(MysticBlocks.MAPLE_FENCE_GATE);
        entries.add(MysticBlocks.MAPLE_BUTTON);
        entries.add(MysticBlocks.MAPLE_PRESSURE_PLATE);
        entries.add(MysticBlocks.MAPLE_TRAPDOOR);
        entries.add(MysticBlocks.MAPLE_DOOR);
        entries.add(MysticItems.MAPLE_SIGN);
        entries.add(MysticItems.MAPLE_HANGING_SIGN);
        entries.add(MysticItems.MAPLE_BOAT);
        entries.add(MysticItems.MAPLE_CHEST_BOAT);

        entries.add(MysticBlocks.SEA_SHRUB_LEAVES);
        entries.add(MysticBlocks.SEA_SHRUB);
        entries.add(MysticBlocks.SEA_FOAM_LOG);
        entries.add(MysticBlocks.STRIPPED_SEA_FOAM_LOG);
        entries.add(MysticBlocks.SEA_FOAM_WOOD);
        entries.add(MysticBlocks.STRIPPED_SEA_FOAM_WOOD);
        entries.add(MysticBlocks.SEA_FOAM_PLANKS);
        entries.add(MysticBlocks.SEA_FOAM_STAIRS);
        entries.add(MysticBlocks.SEA_FOAM_SLAB);
        entries.add(MysticBlocks.SEA_FOAM_FENCE);
        entries.add(MysticBlocks.SEA_FOAM_FENCE_GATE);
        entries.add(MysticBlocks.SEA_FOAM_BUTTON);
        entries.add(MysticBlocks.SEA_FOAM_PRESSURE_PLATE);
        entries.add(MysticBlocks.SEA_FOAM_TRAPDOOR);
        entries.add(MysticBlocks.SEA_FOAM_DOOR);
        entries.add(MysticItems.SEA_FOAM_SIGN);
        entries.add(MysticItems.SEA_FOAM_HANGING_SIGN);
        entries.add(MysticItems.SEA_FOAM_BOAT);
        entries.add(MysticItems.SEA_FOAM_CHEST_BOAT);

        entries.add(MysticBlocks.TROPICAL_LEAVES);
        entries.add(MysticBlocks.TROPICAL_SAPLING);
        entries.add(MysticBlocks.TROPICAL_LOG);
        entries.add(MysticBlocks.STRIPPED_TROPICAL_LOG);
        entries.add(MysticBlocks.TROPICAL_WOOD);
        entries.add(MysticBlocks.STRIPPED_TROPICAL_WOOD);
        entries.add(MysticBlocks.TROPICAL_PLANKS);
        entries.add(MysticBlocks.TROPICAL_STAIRS);
        entries.add(MysticBlocks.TROPICAL_SLAB);
        entries.add(MysticBlocks.TROPICAL_FENCE);
        entries.add(MysticBlocks.TROPICAL_FENCE_GATE);
        entries.add(MysticBlocks.TROPICAL_BUTTON);
        entries.add(MysticBlocks.TROPICAL_PRESSURE_PLATE);
        entries.add(MysticBlocks.TROPICAL_TRAPDOOR);
        entries.add(MysticBlocks.TROPICAL_DOOR);
        entries.add(MysticItems.TROPICAL_SIGN);
        entries.add(MysticItems.TROPICAL_HANGING_SIGN);
        entries.add(MysticItems.TROPICAL_BOAT);
        entries.add(MysticItems.TROPICAL_CHEST_BOAT);

        entries.add(MysticBlocks.JACARANDA_BLOSSOMS);
        entries.add(MysticBlocks.JACARANDA_LEAVES);
        entries.add(MysticBlocks.JACARANDA_SAPLING);
        entries.add(MysticBlocks.JACARANDA_LOG);
        entries.add(MysticBlocks.STRIPPED_JACARANDA_LOG);
        entries.add(MysticBlocks.JACARANDA_WOOD);
        entries.add(MysticBlocks.STRIPPED_JACARANDA_WOOD);
        entries.add(MysticBlocks.JACARANDA_PLANKS);
        entries.add(MysticBlocks.JACARANDA_STAIRS);
        entries.add(MysticBlocks.JACARANDA_SLAB);
        entries.add(MysticBlocks.JACARANDA_FENCE);
        entries.add(MysticBlocks.JACARANDA_FENCE_GATE);
        entries.add(MysticBlocks.JACARANDA_BUTTON);
        entries.add(MysticBlocks.JACARANDA_PRESSURE_PLATE);
        entries.add(MysticBlocks.JACARANDA_TRAPDOOR);
        entries.add(MysticBlocks.JACARANDA_DOOR);
        entries.add(MysticItems.JACARANDA_SIGN);
        entries.add(MysticItems.JACARANDA_HANGING_SIGN);
        entries.add(MysticItems.JACARANDA_BOAT);
        entries.add(MysticItems.JACARANDA_CHEST_BOAT);

        entries.add(MysticBlocks.PEONY_LEAVES);
        entries.add(MysticBlocks.BUDDING_PEONY_LEAVES);
        entries.add(MysticBlocks.PEONY_BUSH);
        entries.add(MysticBlocks.HYDRANGEA_LEAVES);
        entries.add(MysticBlocks.HYDRANGEA_BUSH);
        entries.add(MysticBlocks.LAVENDER);
        entries.add(MysticBlocks.WILDFLOWER);
        entries.add(MysticBlocks.MILKWEED);
        entries.add(MysticBlocks.SEA_OATS);
        entries.add(MysticBlocks.DESERT_GRASS);
        entries.add(MysticBlocks.SAGUARO_BLOSSOM);
        entries.add(MysticBlocks.SAGUARO_CACTUS);
        entries.add(MysticItems.SPRING_BAMBOO);
        entries.add(MysticBlocks.BUNDLED_SPRING_BAMBOO);

        entries.add(MysticBlocks.BUTTERFLY_NEST);
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