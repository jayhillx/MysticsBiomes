package com.mysticsbiomes.init;

import api.mystanica.registry.Registrar;
import com.mysticsbiomes.MysticsBiomes;
import api.mystanica.registry.RegistryEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public class MysticTabs {
    public static final Registrar<CreativeModeTab> TABS = Registrar.create(Registries.CREATIVE_MODE_TAB, MysticsBiomes.modId);

    public static final RegistryEntry<CreativeModeTab> TAB = TABS.register("tab", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .title(Component.translatable("itemGroup.mysticsbiomes"))
            .icon(() -> new ItemStack(MysticItems.LOGO.get()))
            .displayItems((parameters, vanillaOutput) -> {
                ItemOutput output = new ItemOutput(vanillaOutput);
                output.accept(MysticItems.GRASSY_LUSH_SAND);
                output.accept(MysticItems.LUSH_SAND);
                output.accept(MysticItems.LUSH_SANDSTONE);
                output.accept(MysticItems.LUSH_SANDSTONE_STAIRS);
                output.accept(MysticItems.LUSH_SANDSTONE_SLAB);
                output.accept(MysticItems.LUSH_SANDSTONE_WALL);
                output.accept(MysticItems.CHISELED_LUSH_SANDSTONE);
                output.accept(MysticItems.CUT_LUSH_SANDSTONE);
                output.accept(MysticItems.CUT_LUSH_SANDSTONE_SLAB);
                output.accept(MysticItems.SMOOTH_LUSH_SANDSTONE);
                output.accept(MysticItems.SMOOTH_LUSH_SANDSTONE_STAIRS);
                output.accept(MysticItems.SMOOTH_LUSH_SANDSTONE_SLAB);

                output.accept(MysticItems.STRAWBERRY_BLOSSOMS);
                output.accept(MysticItems.STRAWBERRY_BLOSSOM_SAPLING);
                output.accept(MysticItems.STRAWBERRY_LOG);
                output.accept(MysticItems.STRAWBERRY_WOOD);
                output.accept(MysticItems.STRIPPED_STRAWBERRY_LOG);
                output.accept(MysticItems.STRIPPED_STRAWBERRY_WOOD);
                output.accept(MysticItems.STRAWBERRY_PLANKS);
                output.accept(MysticItems.STRAWBERRY_STAIRS);
                output.accept(MysticItems.STRAWBERRY_SLAB);
                output.accept(MysticItems.STRAWBERRY_FENCE);
                output.accept(MysticItems.STRAWBERRY_FENCE_GATE);
                output.accept(MysticItems.STRAWBERRY_BUTTON);
                output.accept(MysticItems.STRAWBERRY_PRESSURE_PLATE);
                output.accept(MysticItems.STRAWBERRY_TRAPDOOR);
                output.accept(MysticItems.STRAWBERRY_DOOR);
                output.accept(MysticItems.STRAWBERRY_SIGN);
                output.accept(MysticItems.STRAWBERRY_HANGING_SIGN);
                output.accept(MysticItems.STRAWBERRY_BOAT);
                output.accept(MysticItems.STRAWBERRY_CHEST_BOAT);

                output.accept(MysticItems.PINK_CHERRY_BLOSSOMS);
                output.accept(MysticItems.PINK_CHERRY_BLOSSOM_SAPLING);
                output.accept(MysticItems.WHITE_CHERRY_BLOSSOMS);
                output.accept(MysticItems.WHITE_CHERRY_BLOSSOM_SAPLING);
                output.accept(MysticItems.BLACK_CHERRY_LOG);
                output.accept(MysticItems.BLACK_CHERRY_WOOD);
                output.accept(MysticItems.STRIPPED_BLACK_CHERRY_LOG);
                output.accept(MysticItems.STRIPPED_BLACK_CHERRY_WOOD);
                output.accept(MysticItems.BLACK_CHERRY_PLANKS);
                output.accept(MysticItems.BLACK_CHERRY_STAIRS);
                output.accept(MysticItems.BLACK_CHERRY_SLAB);
                output.accept(MysticItems.BLACK_CHERRY_FENCE);
                output.accept(MysticItems.BLACK_CHERRY_FENCE_GATE);
                output.accept(MysticItems.BLACK_CHERRY_BUTTON);
                output.accept(MysticItems.BLACK_CHERRY_PRESSURE_PLATE);
                output.accept(MysticItems.BLACK_CHERRY_TRAPDOOR);
                output.accept(MysticItems.BLACK_CHERRY_DOOR);
                output.accept(MysticItems.BLACK_CHERRY_SIGN);
                output.accept(MysticItems.BLACK_CHERRY_HANGING_SIGN);
                output.accept(MysticItems.BLACK_CHERRY_BOAT);
                output.accept(MysticItems.BLACK_CHERRY_CHEST_BOAT);

                output.accept(MysticItems.LAVENDER_BLOSSOMS);
                output.accept(MysticItems.LAVENDER_BLOSSOM_SAPLING);
                output.accept(MysticItems.LAVENDER_LOG);
                output.accept(MysticItems.LAVENDER_WOOD);
                output.accept(MysticItems.STRIPPED_LAVENDER_LOG);
                output.accept(MysticItems.STRIPPED_LAVENDER_WOOD);
                output.accept(MysticItems.LAVENDER_PLANKS);
                output.accept(MysticItems.LAVENDER_STAIRS);
                output.accept(MysticItems.LAVENDER_SLAB);
                output.accept(MysticItems.LAVENDER_FENCE);
                output.accept(MysticItems.LAVENDER_FENCE_GATE);
                output.accept(MysticItems.LAVENDER_BUTTON);
                output.accept(MysticItems.LAVENDER_PRESSURE_PLATE);
                output.accept(MysticItems.LAVENDER_TRAPDOOR);
                output.accept(MysticItems.LAVENDER_DOOR);
                output.accept(MysticItems.LAVENDER_SIGN);
                output.accept(MysticItems.LAVENDER_HANGING_SIGN);
                output.accept(MysticItems.LAVENDER_BOAT);
                output.accept(MysticItems.LAVENDER_CHEST_BOAT);

                output.accept(MysticItems.VANILLA_LEAVES);
                output.accept(MysticItems.VANILLA_SAPLING);
                output.accept(MysticItems.VANILLA_LOG);
                output.accept(MysticItems.VANILLA_WOOD);
                output.accept(MysticItems.STRIPPED_VANILLA_LOG);
                output.accept(MysticItems.STRIPPED_VANILLA_WOOD);
                output.accept(MysticItems.VANILLA_PLANKS);
                output.accept(MysticItems.VANILLA_STAIRS);
                output.accept(MysticItems.VANILLA_SLAB);
                output.accept(MysticItems.VANILLA_FENCE);
                output.accept(MysticItems.VANILLA_FENCE_GATE);
                output.accept(MysticItems.VANILLA_BUTTON);
                output.accept(MysticItems.VANILLA_PRESSURE_PLATE);
                output.accept(MysticItems.VANILLA_TRAPDOOR);
                output.accept(MysticItems.VANILLA_DOOR);
                output.accept(MysticItems.VANILLA_SIGN);
                output.accept(MysticItems.VANILLA_HANGING_SIGN);
                output.accept(MysticItems.VANILLA_BOAT);
                output.accept(MysticItems.VANILLA_CHEST_BOAT);

                output.accept(MysticItems.PEACH_LEAVES);
                output.accept(MysticItems.PEACH_SAPLING);
                output.accept(MysticItems.PEACH_LOG);
                output.accept(MysticItems.PEACH_WOOD);
                output.accept(MysticItems.STRIPPED_PEACH_LOG);
                output.accept(MysticItems.STRIPPED_PEACH_WOOD);
                output.accept(MysticItems.PEACH_PLANKS);
                output.accept(MysticItems.PEACH_STAIRS);
                output.accept(MysticItems.PEACH_SLAB);
                output.accept(MysticItems.PEACH_FENCE);
                output.accept(MysticItems.PEACH_FENCE_GATE);
                output.accept(MysticItems.PEACH_BUTTON);
                output.accept(MysticItems.PEACH_PRESSURE_PLATE);
                output.accept(MysticItems.PEACH_TRAPDOOR);
                output.accept(MysticItems.PEACH_DOOR);
                output.accept(MysticItems.PEACH_SIGN);
                output.accept(MysticItems.PEACH_HANGING_SIGN);
                output.accept(MysticItems.PEACH_BOAT);
                output.accept(MysticItems.PEACH_CHEST_BOAT);

                output.accept(MysticItems.MAPLE_LEAVES);
                output.accept(MysticItems.MAPLE_LEAF_PILE);
                output.accept(MysticItems.MAPLE_LEAF_LITTER);
                output.accept(MysticItems.MAPLE_SAPLING);
                output.accept(MysticItems.ORANGE_MAPLE_LEAVES);
                output.accept(MysticItems.ORANGE_MAPLE_LEAF_PILE);
                output.accept(MysticItems.ORANGE_MAPLE_LEAF_LITTER);
                output.accept(MysticItems.ORANGE_MAPLE_SAPLING);
                output.accept(MysticItems.YELLOW_MAPLE_LEAVES);
                output.accept(MysticItems.YELLOW_MAPLE_LEAF_PILE);
                output.accept(MysticItems.YELLOW_MAPLE_LEAF_LITTER);
                output.accept(MysticItems.YELLOW_MAPLE_SAPLING);
                output.accept(MysticItems.MAPLE_LOG);
                output.accept(MysticItems.MAPLE_WOOD);
                output.accept(MysticItems.WHITE_MAPLE_LOG);
                output.accept(MysticItems.WHITE_MAPLE_WOOD);
                output.accept(MysticItems.STRIPPED_MAPLE_LOG);
                output.accept(MysticItems.STRIPPED_MAPLE_WOOD);
                output.accept(MysticItems.MAPLE_PLANKS);
                output.accept(MysticItems.MAPLE_STAIRS);
                output.accept(MysticItems.MAPLE_SLAB);
                output.accept(MysticItems.MAPLE_FENCE);
                output.accept(MysticItems.MAPLE_FENCE_GATE);
                output.accept(MysticItems.MAPLE_BUTTON);
                output.accept(MysticItems.MAPLE_PRESSURE_PLATE);
                output.accept(MysticItems.MAPLE_TRAPDOOR);
                output.accept(MysticItems.MAPLE_DOOR);
                output.accept(MysticItems.MAPLE_SIGN);
                output.accept(MysticItems.MAPLE_HANGING_SIGN);
                output.accept(MysticItems.MAPLE_BOAT);
                output.accept(MysticItems.MAPLE_CHEST_BOAT);

                output.accept(MysticItems.SPRING_BAMBOO);
                output.accept(MysticItems.SPRING_BAMBOO_BLOCK);
                output.accept(MysticItems.STRIPPED_SPRING_BAMBOO_BLOCK);
                output.accept(MysticItems.SPRING_PLANKS);
                output.accept(MysticItems.SPRING_MOSAIC);
                output.accept(MysticItems.SPRING_STAIRS);
                output.accept(MysticItems.SPRING_MOSAIC_STAIRS);
                output.accept(MysticItems.SPRING_SLAB);
                output.accept(MysticItems.SPRING_MOSAIC_SLAB);
                output.accept(MysticItems.SPRING_FENCE);
                output.accept(MysticItems.SPRING_FENCE_GATE);
                output.accept(MysticItems.SPRING_BUTTON);
                output.accept(MysticItems.SPRING_PRESSURE_PLATE);
                output.accept(MysticItems.SPRING_TRAPDOOR);
                output.accept(MysticItems.SPRING_DOOR);
                output.accept(MysticItems.SPRING_SIGN);
                output.accept(MysticItems.SPRING_HANGING_SIGN);
                output.accept(MysticItems.SPRING_RAFT);
                output.accept(MysticItems.SPRING_CHEST_RAFT);

                output.accept(MysticItems.SEA_SHRUB_LEAVES);
                output.accept(MysticItems.SEA_SHRUB);
                output.accept(MysticItems.SEA_FOAM_LOG);
                output.accept(MysticItems.SEA_FOAM_WOOD);
                output.accept(MysticItems.STRIPPED_SEA_FOAM_LOG);
                output.accept(MysticItems.STRIPPED_SEA_FOAM_WOOD);
                output.accept(MysticItems.SEA_FOAM_PLANKS);
                output.accept(MysticItems.SEA_FOAM_STAIRS);
                output.accept(MysticItems.SEA_FOAM_SLAB);
                output.accept(MysticItems.SEA_FOAM_FENCE);
                output.accept(MysticItems.SEA_FOAM_FENCE_GATE);
                output.accept(MysticItems.SEA_FOAM_BUTTON);
                output.accept(MysticItems.SEA_FOAM_PRESSURE_PLATE);
                output.accept(MysticItems.SEA_FOAM_TRAPDOOR);
                output.accept(MysticItems.SEA_FOAM_DOOR);
                output.accept(MysticItems.SEA_FOAM_SIGN);
                output.accept(MysticItems.SEA_FOAM_HANGING_SIGN);
                output.accept(MysticItems.SEA_FOAM_BOAT);
                output.accept(MysticItems.SEA_FOAM_CHEST_BOAT);

                output.accept(MysticItems.TROPICAL_LEAVES);
                output.accept(MysticItems.TROPICAL_SAPLING);
                output.accept(MysticItems.TROPICAL_LOG);
                output.accept(MysticItems.TROPICAL_WOOD);
                output.accept(MysticItems.STRIPPED_TROPICAL_LOG);
                output.accept(MysticItems.STRIPPED_TROPICAL_WOOD);
                output.accept(MysticItems.TROPICAL_PLANKS);
                output.accept(MysticItems.TROPICAL_STAIRS);
                output.accept(MysticItems.TROPICAL_SLAB);
                output.accept(MysticItems.TROPICAL_FENCE);
                output.accept(MysticItems.TROPICAL_FENCE_GATE);
                output.accept(MysticItems.TROPICAL_BUTTON);
                output.accept(MysticItems.TROPICAL_PRESSURE_PLATE);
                output.accept(MysticItems.TROPICAL_TRAPDOOR);
                output.accept(MysticItems.TROPICAL_DOOR);
                output.accept(MysticItems.TROPICAL_SIGN);
                output.accept(MysticItems.TROPICAL_HANGING_SIGN);
                output.accept(MysticItems.TROPICAL_BOAT);
                output.accept(MysticItems.TROPICAL_CHEST_BOAT);

                output.accept(MysticItems.GLASS_JAR);
                output.accept(MysticItems.MONARCH_BUTTERFLY_IN_JAR);
                output.accept(MysticItems.MORPHO_BUTTERFLY_IN_JAR);
                output.accept(MysticItems.BLUE_BUTTERFLY_IN_JAR);
                output.accept(MysticItems.LUNA_MOTH_IN_JAR);
                output.accept(MysticItems.CATERPILLAR_IN_JAR);
                output.accept(MysticItems.BUTTERFLY_NEST);
                output.accept(MysticItems.CHRYSALIS);

                ///output.accept(MysticItems.BUTTERFLY_BUSH_LEAVES);
                ///output.accept(MysticItems.BUTTERFLY_BUSH);
                output.accept(MysticItems.PEONY_BUSH_LEAVES);
                output.accept(MysticItems.PEONY_BUSH);
                output.accept(MysticItems.HYDRANGEA_BUSH_LEAVES);
                output.accept(MysticItems.HYDRANGEA_BUSH);
                ///output.accept(MysticItems.PINK_DAISIES);
                ///output.accept(MysticItems.LAVENDER_BUDS);
                output.accept(MysticItems.LAVENDER);
                output.accept(MysticItems.TALL_LAVENDER);
                output.accept(MysticItems.ASTER);
                output.accept(MysticItems.GOLDENROD);
                output.accept(MysticItems.WILDFLOWER);
                output.accept(MysticItems.MILKWEED);
                output.accept(MysticItems.SEA_THRIFT);
                output.accept(MysticItems.SAGUARO_BLOSSOM);
                output.accept(MysticItems.SAGUARO_CACTUS);
                ///output.accept(MysticItems.PRICKLY_BLOSSOM);
                ///output.accept(MysticItems.PRICKLY_CACTUS);
                output.accept(MysticItems.DESERT_LILY);
                output.accept(MysticItems.DESERT_GRASS);
                output.accept(MysticItems.TALL_DESERT_GRASS);
                output.accept(MysticItems.BEACH_GRASS);
                output.accept(MysticItems.TALL_BEACH_GRASS);
                ///output.accept(MysticItems.JUNGLE_GRASS);
                ///output.accept(MysticItems.TALL_JUNGLE_GRASS);
                output.accept(MysticItems.SEA_OATS);

                output.accept(MysticItems.STRAWBERRY_MILK_BUCKET);
                output.accept(MysticItems.VANILLA_MILK_BUCKET);
                output.accept(MysticItems.CHOCOLATE_MILK_BUCKET);

                output.accept(MysticItems.STRAWBERRY);
                output.accept(MysticItems.SWEET_STRAWBERRY);
                output.accept(MysticItems.CHERRIES);
                output.accept(MysticItems.PEACH);
                output.accept(MysticItems.VANILLA_BEANS);

                output.accept(MysticItems.STRAWBERRY_CAKE);
                output.accept(MysticItems.SWEET_STRAWBERRY_CAKE);
                output.accept(MysticItems.VANILLA_CAKE);
                output.accept(MysticItems.CHOCOLATE_CAKE);
                output.accept(MysticItems.PINK_FROSTED_CAKE);
                output.accept(MysticItems.ORANGE_FROSTED_CAKE);
                output.accept(MysticItems.YELLOW_FROSTED_CAKE);
                output.accept(MysticItems.LIME_FROSTED_CAKE);
                output.accept(MysticItems.CYAN_FROSTED_CAKE);
                output.accept(MysticItems.PURPLE_FROSTED_CAKE);
                ///output.accept(MysticItems.RAINBOW_FROSTED_CAKE);
                output.accept(MysticItems.CHERRY_PIE);
                output.accept(MysticItems.PEACH_PIE);

                output.accept(MysticItems.PINK_EGG);
                output.accept(MysticItems.ORANGE_EGG);
                output.accept(MysticItems.YELLOW_EGG);
                output.accept(MysticItems.LIME_EGG);
                output.accept(MysticItems.CYAN_EGG);
                output.accept(MysticItems.PURPLE_EGG);
                ///output.accept(MysticItems.RAINBOW_EGG);
                output.accept(MysticItems.STRAWBERRY_COW_SPAWN_EGG);
                output.accept(MysticItems.VANILLA_COW_SPAWN_EGG);
                output.accept(MysticItems.CHOCOLATE_COW_SPAWN_EGG);
                output.accept(MysticItems.RAINBOW_CHICKEN_SPAWN_EGG);
                output.accept(MysticItems.RED_PANDA_SPAWN_EGG);
                output.accept(MysticItems.SEA_OTTER_SPAWN_EGG);
                output.accept(MysticItems.BUTTERFLY_SPAWN_EGG);
                output.accept(MysticItems.CATERPILLAR_SPAWN_EGG);
            }).build()
    );

    public record ItemOutput(CreativeModeTab.Output output) {
        public void accept(RegistryEntry<? extends ItemLike> item) {
            this.output.accept(item.get());
        }
    }

    public static void init() {
    }

}