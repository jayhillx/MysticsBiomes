package com.mysticsbiomes.init;

import com.mysticsbiomes.common.block.util.BlockUtils;
import api.mystanica.registry.RegistryEntry;
import com.mysticsbiomes.datagen.MysticBlockFamilies;
import com.mysticsbiomes.datagen.MysticBlockFamily;
import net.minecraft.world.level.block.Block;

public class MysticCompat {

    public static void registerFlammables() {
        MysticBlockFamilies.getAllFamilies().forEach(MysticCompat::flammableWood);
        flammableLeaves(MysticBlocks.STRAWBERRY_BLOSSOMS);
        ///flammablePlants(MysticBlocks.PINK_DAISIES);
        flammablePlants(MysticBlocks.WILD_STRAWBERRY_BUSH);
        flammablePlants(MysticBlocks.STRAWBERRY_BUSH);
        flammableLeaves(MysticBlocks.LAVENDER_BLOSSOMS);
        flammablePlants(MysticBlocks.LAVENDER);
        flammablePlants(MysticBlocks.TALL_LAVENDER);
        ///flammableLeaves(MysticBlocks.BUTTERFLY_BUSH_LEAVES);
        ///flammablePlants(MysticBlocks.BUTTERFLY_BUSH);
        ///flammablePlants(MysticBlocks.BUTTERFLY_NEST);
        flammableLeaves(MysticBlocks.PINK_CHERRY_BLOSSOMS);
        flammableLeaves(MysticBlocks.WHITE_CHERRY_BLOSSOMS);
        BlockUtils.registerFlammable(MysticBlocks.SPRING_BAMBOO, 60, 60);
        flammableLeaves(MysticBlocks.PEONY_BUSH_LEAVES);
        flammablePlants(MysticBlocks.PEONY_BUSH);
        flammablePlants(MysticBlocks.CHERRY_PLANT);
        flammableLeaves(MysticBlocks.MAPLE_LEAVES);
        flammableLeaves(MysticBlocks.MAPLE_LEAF_PILE);
        flammableLeaves(MysticBlocks.MAPLE_LEAF_LITTER);
        flammableLeaves(MysticBlocks.ORANGE_MAPLE_LEAVES);
        flammableLeaves(MysticBlocks.ORANGE_MAPLE_LEAF_PILE);
        flammableLeaves(MysticBlocks.ORANGE_MAPLE_LEAF_LITTER);
        flammableLeaves(MysticBlocks.YELLOW_MAPLE_LEAVES);
        flammableLeaves(MysticBlocks.YELLOW_MAPLE_LEAF_PILE);
        flammableLeaves(MysticBlocks.YELLOW_MAPLE_LEAF_LITTER);
        flammablePlants(MysticBlocks.ASTER);
        flammablePlants(MysticBlocks.GOLDENROD);
        flammableLeaves(MysticBlocks.PEACH_LEAVES);
        flammablePlants(MysticBlocks.PEACH_PLANT);
        flammablePlants(MysticBlocks.DESERT_GRASS);
        flammablePlants(MysticBlocks.TALL_DESERT_GRASS);
        flammablePlants(MysticBlocks.DESERT_LILY);
        flammablePlants(MysticBlocks.WILDFLOWER);
        flammablePlants(MysticBlocks.SAGUARO_BLOSSOM);
        ///flammablePlants(MysticBlocks.PRICKLY_BLOSSOM);
        flammableLeaves(MysticBlocks.SEA_SHRUB_LEAVES);
        flammablePlants(MysticBlocks.SEA_SHRUB);
        flammablePlants(MysticBlocks.BEACH_GRASS);
        flammablePlants(MysticBlocks.TALL_BEACH_GRASS);
        flammablePlants(MysticBlocks.MILKWEED);
        flammablePlants(MysticBlocks.SEA_THRIFT);
        flammablePlants(MysticBlocks.SEA_OATS);
        flammableLeaves(MysticBlocks.TROPICAL_LEAVES);
        ///flammableLeaves(MysticBlocks.TROPICAL_VINES);
        flammableLeaves(MysticBlocks.VANILLA_LEAVES);
        ///flammablePlants(MysticBlocks.VANILLA_ORCHID);
        ///flammablePlants(MysticBlocks.JUNGLE_SHRUB);
        ///flammablePlants(MysticBlocks.JUNGLE_GRASS);
        ///flammablePlants(MysticBlocks.TALL_JUNGLE_GRASS);
        flammableLeaves(MysticBlocks.HYDRANGEA_BUSH_LEAVES);
        flammablePlants(MysticBlocks.HYDRANGEA_BUSH);
        flammablePlants(MysticBlocks.HIBISCUS);
    }

    private static void flammableWood(MysticBlockFamily family) {
        if (family.isFlammable()) {
            family.getVariants().forEach((variant, block) -> {
                switch (variant) {
                    case LOG, SECONDARY_LOG, STRIPPED_LOG, WOOD, SECONDARY_WOOD, STRIPPED_WOOD -> BlockUtils.registerFlammable(block, 5, 5);
                    case PLANKS, STAIRS, SLAB, FENCE, FENCE_GATE, BUTTON, PRESSURE_PLATE, TRAPDOOR, DOOR, SIGN -> BlockUtils.registerFlammable(block, 5, 20);
                }
            });
        }
    }

    private static void flammableLeaves(RegistryEntry<Block> block) {
        BlockUtils.registerFlammable(block, 30, 60);
    }

    private static void flammablePlants(RegistryEntry<Block> block) {
        BlockUtils.registerFlammable(block, 60, 100);
    }

    public static void registerCompostables() {
        BlockUtils.registerCompostable(MysticItems.STRAWBERRY_BLOSSOMS, 0.65F);
        BlockUtils.registerCompostable(MysticItems.STRAWBERRY_BLOSSOM_SAPLING, 0.3F);
        ///BlockUtils.compostable(MysticItems.PINK_DAISIES, 0.65F);
        BlockUtils.registerCompostable(MysticItems.STRAWBERRY, 0.65F);
        BlockUtils.registerCompostable(MysticItems.STRAWBERRY_CAKE, 2.0F);
        BlockUtils.registerCompostable(MysticItems.SWEET_STRAWBERRY, 3.0F);
        BlockUtils.registerCompostable(MysticItems.SWEET_STRAWBERRY_CAKE, 3.0F);
        BlockUtils.registerCompostable(MysticItems.LAVENDER_BLOSSOMS, 0.65F);
        BlockUtils.registerCompostable(MysticItems.LAVENDER_BLOSSOM_SAPLING, 0.3F);
        BlockUtils.registerCompostable(MysticItems.LAVENDER, 0.65F);
        BlockUtils.registerCompostable(MysticItems.TALL_LAVENDER, 0.65F);
        ///BlockUtils.compostable(MysticItems.BUTTERFLY_BUSH_LEAVES, 0.65F);
        ///BlockUtils.compostable(MysticItems.BUTTERFLY_BUSH, 0.3F);
        ///BlockUtils.compostable(MysticItems.LAVENDER_BUDS, 0.8F);
        BlockUtils.registerCompostable(MysticItems.PINK_CHERRY_BLOSSOMS, 0.65F);
        BlockUtils.registerCompostable(MysticItems.PINK_CHERRY_BLOSSOM_SAPLING, 0.3F);
        BlockUtils.registerCompostable(MysticItems.WHITE_CHERRY_BLOSSOMS, 0.65F);
        BlockUtils.registerCompostable(MysticItems.WHITE_CHERRY_BLOSSOM_SAPLING, 0.3F);
        BlockUtils.registerCompostable(MysticItems.PEONY_BUSH_LEAVES, 0.65F);
        BlockUtils.registerCompostable(MysticItems.PEONY_BUSH, 0.3F);
        BlockUtils.registerCompostable(MysticItems.CHERRIES, 0.3F);
        BlockUtils.registerCompostable(MysticItems.CHERRY_PIE, 1.0F);
        BlockUtils.registerCompostable(MysticItems.MAPLE_LEAVES, 0.3F);
        BlockUtils.registerCompostable(MysticItems.MAPLE_LEAF_PILE, 0.3F);
        BlockUtils.registerCompostable(MysticItems.MAPLE_LEAF_LITTER, 0.3F);
        BlockUtils.registerCompostable(MysticItems.MAPLE_SAPLING, 0.3F);
        BlockUtils.registerCompostable(MysticItems.ORANGE_MAPLE_LEAVES, 0.3F);
        BlockUtils.registerCompostable(MysticItems.ORANGE_MAPLE_LEAF_PILE, 0.3F);
        BlockUtils.registerCompostable(MysticItems.ORANGE_MAPLE_LEAF_LITTER, 0.3F);
        BlockUtils.registerCompostable(MysticItems.ORANGE_MAPLE_SAPLING, 0.3F);
        BlockUtils.registerCompostable(MysticItems.YELLOW_MAPLE_LEAVES, 0.3F);
        BlockUtils.registerCompostable(MysticItems.YELLOW_MAPLE_LEAF_PILE, 0.3F);
        BlockUtils.registerCompostable(MysticItems.YELLOW_MAPLE_LEAF_LITTER, 0.3F);
        BlockUtils.registerCompostable(MysticItems.YELLOW_MAPLE_SAPLING, 0.3F);
        BlockUtils.registerCompostable(MysticItems.ASTER, 0.65F);
        BlockUtils.registerCompostable(MysticItems.GOLDENROD, 0.65F);
        BlockUtils.registerCompostable(MysticItems.PEACH_LEAVES, 0.3F);
        BlockUtils.registerCompostable(MysticItems.PEACH_SAPLING, 0.3F);
        BlockUtils.registerCompostable(MysticItems.DESERT_GRASS, 0.3F);
        BlockUtils.registerCompostable(MysticItems.TALL_DESERT_GRASS, 0.3F);
        BlockUtils.registerCompostable(MysticItems.DESERT_LILY, 0.65F);
        BlockUtils.registerCompostable(MysticItems.WILDFLOWER, 0.65F);
        BlockUtils.registerCompostable(MysticItems.SAGUARO_CACTUS, 0.5F);
        BlockUtils.registerCompostable(MysticItems.SAGUARO_BLOSSOM, 0.65F);
        ///BlockUtils.compostable(MysticItems.PRICKLY_CACTUS, 0.5F);
        ///BlockUtils.compostable(MysticItems.PRICKLY_BLOSSOM, 0.65F);
        BlockUtils.registerCompostable(MysticItems.PEACH, 0.3F);
        BlockUtils.registerCompostable(MysticItems.PEACH_PIE, 1.0F);
        BlockUtils.registerCompostable(MysticItems.SEA_SHRUB_LEAVES, 0.3F);
        BlockUtils.registerCompostable(MysticItems.SEA_SHRUB, 0.3F);
        BlockUtils.registerCompostable(MysticItems.BEACH_GRASS, 0.3F);
        BlockUtils.registerCompostable(MysticItems.TALL_BEACH_GRASS, 0.3F);
        BlockUtils.registerCompostable(MysticItems.MILKWEED, 0.65F);
        BlockUtils.registerCompostable(MysticItems.SEA_THRIFT, 0.65F);
        BlockUtils.registerCompostable(MysticItems.SEA_OATS, 0.3F);
        BlockUtils.registerCompostable(MysticItems.TROPICAL_LEAVES, 0.3F);
        ///BlockUtils.compostable(MysticItems.TROPICAL_VINES, 0.5F);
        BlockUtils.registerCompostable(MysticItems.TROPICAL_SAPLING, 0.3F);
        BlockUtils.registerCompostable(MysticItems.VANILLA_LEAVES, 0.3F);
        ///BlockUtils.compostable(MysticItems.VANILLA_BEANS, 0.3F);
        BlockUtils.registerCompostable(MysticItems.VANILLA_CAKE, 2.0F);
        BlockUtils.registerCompostable(MysticItems.CHOCOLATE_CAKE, 2.0F);
        ///BlockUtils.compostable(MysticItems.JUNGLE_SHRUB, 0.3F);
        ///BlockUtils.compostable(MysticItems.JUNGLE_GRASS, 0.3F);
        ///BlockUtils.compostable(MysticItems.TALL_JUNGLE_GRASS, 0.3F);
        ///BlockUtils.compostable(MysticItems.BANANA_LEAF_PLANT, 0.65F);
        BlockUtils.registerCompostable(MysticItems.HYDRANGEA_BUSH_LEAVES, 0.65F);
        BlockUtils.registerCompostable(MysticItems.HYDRANGEA_BUSH, 0.3F);
        BlockUtils.registerCompostable(MysticItems.HIBISCUS, 0.65F);
        BlockUtils.registerCompostable(MysticItems.PINK_FROSTED_CAKE, 1.5F);
        BlockUtils.registerCompostable(MysticItems.ORANGE_FROSTED_CAKE, 1.5F);
        BlockUtils.registerCompostable(MysticItems.YELLOW_FROSTED_CAKE, 1.5F);
        BlockUtils.registerCompostable(MysticItems.LIME_FROSTED_CAKE, 1.5F);
        BlockUtils.registerCompostable(MysticItems.CYAN_FROSTED_CAKE, 1.5F);
        BlockUtils.registerCompostable(MysticItems.PURPLE_FROSTED_CAKE, 1.5F);
        ///BlockUtils.compostable(MysticItems.RAINBOW_FROSTED_CAKE, 2.0F);
    }

    public static void registerStrippables() {
        BlockUtils.registerStrippable(MysticBlocks.STRAWBERRY_LOG, MysticBlocks.STRIPPED_STRAWBERRY_LOG);
        BlockUtils.registerStrippable(MysticBlocks.STRAWBERRY_WOOD, MysticBlocks.STRIPPED_STRAWBERRY_WOOD);
        BlockUtils.registerStrippable(MysticBlocks.BLACK_CHERRY_LOG, MysticBlocks.STRIPPED_BLACK_CHERRY_LOG);
        BlockUtils.registerStrippable(MysticBlocks.BLACK_CHERRY_WOOD, MysticBlocks.STRIPPED_BLACK_CHERRY_WOOD);
        BlockUtils.registerStrippable(MysticBlocks.LAVENDER_LOG, MysticBlocks.STRIPPED_LAVENDER_LOG);
        BlockUtils.registerStrippable(MysticBlocks.LAVENDER_WOOD, MysticBlocks.STRIPPED_LAVENDER_WOOD);
        BlockUtils.registerStrippable(MysticBlocks.VANILLA_LOG, MysticBlocks.STRIPPED_VANILLA_LOG);
        BlockUtils.registerStrippable(MysticBlocks.VANILLA_WOOD, MysticBlocks.STRIPPED_VANILLA_WOOD);
        BlockUtils.registerStrippable(MysticBlocks.PEACH_LOG, MysticBlocks.STRIPPED_PEACH_LOG);
        BlockUtils.registerStrippable(MysticBlocks.PEACH_WOOD, MysticBlocks.STRIPPED_PEACH_WOOD);
        BlockUtils.registerStrippable(MysticBlocks.MAPLE_LOG, MysticBlocks.STRIPPED_MAPLE_LOG);
        BlockUtils.registerStrippable(MysticBlocks.MAPLE_WOOD, MysticBlocks.STRIPPED_MAPLE_WOOD);
        BlockUtils.registerStrippable(MysticBlocks.WHITE_MAPLE_LOG, MysticBlocks.STRIPPED_MAPLE_LOG);
        BlockUtils.registerStrippable(MysticBlocks.WHITE_MAPLE_WOOD, MysticBlocks.STRIPPED_MAPLE_WOOD);
        BlockUtils.registerStrippable(MysticBlocks.SPRING_BAMBOO_BLOCK, MysticBlocks.STRIPPED_SPRING_BAMBOO_BLOCK);
        BlockUtils.registerStrippable(MysticBlocks.SEA_FOAM_LOG, MysticBlocks.STRIPPED_SEA_FOAM_LOG);
        BlockUtils.registerStrippable(MysticBlocks.SEA_FOAM_WOOD, MysticBlocks.STRIPPED_SEA_FOAM_WOOD);
        BlockUtils.registerStrippable(MysticBlocks.TROPICAL_LOG, MysticBlocks.STRIPPED_TROPICAL_LOG);
        BlockUtils.registerStrippable(MysticBlocks.TROPICAL_WOOD, MysticBlocks.STRIPPED_TROPICAL_WOOD);
    }



}