package com.mysticsbiomes.init;

import com.mysticsbiomes.common.util.BlockDataUtils;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;

public class MysticVanillaCompat {

    public static void registerFlammables() {
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_BLOSSOMS, 30, 60);
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_LOG, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRIPPED_STRAWBERRY_LOG, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_WOOD, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRIPPED_STRAWBERRY_WOOD, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_PLANKS, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_STAIRS, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_SLAB, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_FENCE, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_FENCE_GATE, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_BUTTON, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_PRESSURE_PLATE, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_TRAPDOOR, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_DOOR, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_BUSH, 60, 100);

        BlockDataUtils.flammable(MysticBlocks.PINK_CHERRY_BLOSSOMS, 30, 60);
        BlockDataUtils.flammable(MysticBlocks.WHITE_CHERRY_BLOSSOMS, 30, 60);
        BlockDataUtils.flammable(MysticBlocks.CHERRY_LOG, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRIPPED_CHERRY_LOG, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.CHERRY_WOOD, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRIPPED_CHERRY_WOOD, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.CHERRY_PLANKS, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.CHERRY_STAIRS, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.CHERRY_SLAB, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.CHERRY_FENCE, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.CHERRY_FENCE_GATE, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.CHERRY_BUTTON, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.CHERRY_PRESSURE_PLATE, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.CHERRY_TRAPDOOR, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.CHERRY_DOOR, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.CHERRY_PLANT, 60, 100);
        BlockDataUtils.flammable(MysticBlocks.BUDDING_PEONY_LEAVES, 30, 60);
        BlockDataUtils.flammable(MysticBlocks.PEONY_LEAVES, 30, 60);
        BlockDataUtils.flammable(MysticBlocks.PEONY_BUSH, 30, 60);
        BlockDataUtils.flammable(MysticBlocks.SPRING_BAMBOO, 60, 60);
        BlockDataUtils.flammable(MysticBlocks.BUNDLED_SPRING_BAMBOO, 60, 60);

        BlockDataUtils.flammable(MysticBlocks.PEACH_LEAVES, 30, 60);
        BlockDataUtils.flammable(MysticBlocks.PEACH_LOG, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRIPPED_PEACH_LOG, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.PEACH_WOOD, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRIPPED_PEACH_WOOD, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.PEACH_PLANKS, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.PEACH_STAIRS, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.PEACH_SLAB, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.PEACH_FENCE, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.PEACH_FENCE_GATE, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.PEACH_BUTTON, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.PEACH_PRESSURE_PLATE, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.PEACH_TRAPDOOR, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.PEACH_DOOR, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.PEACH_PLANT, 60, 100);
        BlockDataUtils.flammable(MysticBlocks.SAGUARO_BLOSSOM, 60, 100);
        BlockDataUtils.flammable(MysticBlocks.DESERT_GRASS, 60, 100);
        BlockDataUtils.flammable(MysticBlocks.WILDFLOWER, 60, 100);

        BlockDataUtils.flammable(MysticBlocks.MAPLE_LEAVES, 30, 60);
        BlockDataUtils.flammable(MysticBlocks.MAPLE_LEAF_PILE, 30, 60);
        BlockDataUtils.flammable(MysticBlocks.ORANGE_MAPLE_LEAVES, 30, 60);
        BlockDataUtils.flammable(MysticBlocks.ORANGE_MAPLE_LEAF_PILE, 30, 60);
        BlockDataUtils.flammable(MysticBlocks.YELLOW_MAPLE_LEAVES, 30, 60);
        BlockDataUtils.flammable(MysticBlocks.YELLOW_MAPLE_LEAF_PILE, 30, 60);
        BlockDataUtils.flammable(MysticBlocks.MAPLE_LOG, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.WHITE_MAPLE_LOG, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRIPPED_MAPLE_LOG, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.MAPLE_WOOD, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.WHITE_MAPLE_WOOD, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRIPPED_MAPLE_WOOD, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.MAPLE_PLANKS, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.MAPLE_STAIRS, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.MAPLE_SLAB, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.MAPLE_FENCE, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.MAPLE_FENCE_GATE, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.MAPLE_BUTTON, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.MAPLE_PRESSURE_PLATE, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.MAPLE_TRAPDOOR, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.MAPLE_DOOR, 5, 20);

        BlockDataUtils.flammable(MysticBlocks.SEA_SHRUB_LEAVES, 30, 60);
        BlockDataUtils.flammable(MysticBlocks.SEA_SHRUB, 30, 60);
        BlockDataUtils.flammable(MysticBlocks.SEA_FOAM_LOG, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRIPPED_SEA_FOAM_LOG, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.SEA_FOAM_WOOD, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRIPPED_SEA_FOAM_WOOD, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.SEA_FOAM_PLANKS, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.SEA_FOAM_STAIRS, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.SEA_FOAM_SLAB, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.SEA_FOAM_FENCE, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.SEA_FOAM_FENCE_GATE, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.SEA_FOAM_BUTTON, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.SEA_FOAM_PRESSURE_PLATE, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.SEA_FOAM_TRAPDOOR, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.SEA_FOAM_DOOR, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.SEA_OATS, 60, 100);
        BlockDataUtils.flammable(MysticBlocks.MILKWEED, 60, 100);

        BlockDataUtils.flammable(MysticBlocks.TROPICAL_LEAVES, 30, 60);
        BlockDataUtils.flammable(MysticBlocks.TROPICAL_LOG, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRIPPED_TROPICAL_LOG, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.TROPICAL_WOOD, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRIPPED_TROPICAL_WOOD, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.TROPICAL_PLANKS, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.TROPICAL_STAIRS, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.TROPICAL_SLAB, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.TROPICAL_FENCE, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.TROPICAL_FENCE_GATE, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.TROPICAL_BUTTON, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.TROPICAL_PRESSURE_PLATE, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.TROPICAL_TRAPDOOR, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.TROPICAL_DOOR, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.HYDRANGEA_LEAVES, 30, 60);
        BlockDataUtils.flammable(MysticBlocks.HYDRANGEA_BUSH, 30, 60);

        BlockDataUtils.flammable(MysticBlocks.JACARANDA_BLOSSOMS, 30, 60);
        BlockDataUtils.flammable(MysticBlocks.JACARANDA_LEAVES, 30, 60);
        BlockDataUtils.flammable(MysticBlocks.JACARANDA_LOG, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRIPPED_JACARANDA_LOG, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.JACARANDA_WOOD, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRIPPED_JACARANDA_WOOD, 5, 5);
        BlockDataUtils.flammable(MysticBlocks.JACARANDA_PLANKS, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.JACARANDA_STAIRS, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.JACARANDA_SLAB, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.JACARANDA_FENCE, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.JACARANDA_FENCE_GATE, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.JACARANDA_BUTTON, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.JACARANDA_PRESSURE_PLATE, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.JACARANDA_TRAPDOOR, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.JACARANDA_DOOR, 5, 20);
        BlockDataUtils.flammable(MysticBlocks.LAVENDER, 60, 100);
    }

    public static void registerCompostables() {
        // Leaves & Saplings 0.3 | Flower Leaves 0.6 | Flowers 0.65
        BlockDataUtils.compostable(MysticItems.STRAWBERRY_BLOSSOMS, 0.6F);
        BlockDataUtils.compostable(MysticItems.STRAWBERRY_SAPLING, 0.3F);
        BlockDataUtils.compostable(MysticItems.STRAWBERRY, 0.4F);
        BlockDataUtils.compostable(MysticItems.SWEET_STRAWBERRY, 1.0F);
        BlockDataUtils.compostable(MysticItems.STRAWBERRY_CAKE, 2.0F);

        BlockDataUtils.compostable(MysticItems.PINK_CHERRY_BLOSSOMS, 0.6F);
        BlockDataUtils.compostable(MysticItems.PINK_CHERRY_BLOSSOM_SAPLING, 0.3F);
        BlockDataUtils.compostable(MysticItems.WHITE_CHERRY_BLOSSOMS, 0.6F);
        BlockDataUtils.compostable(MysticItems.WHITE_CHERRY_BLOSSOM_SAPLING, 0.3F);
        BlockDataUtils.compostable(MysticItems.BUDDING_PEONY_LEAVES, 0.6F);
        BlockDataUtils.compostable(MysticItems.PEONY_LEAVES, 0.3F);
        BlockDataUtils.compostable(MysticItems.PEONY_BUSH, 0.65F);
        BlockDataUtils.compostable(MysticItems.CHERRIES, 0.4F);
        BlockDataUtils.compostable(MysticItems.CHERRY_PIE, 2.0F);

        BlockDataUtils.compostable(MysticItems.PEACH_LEAVES, 0.6F);
        BlockDataUtils.compostable(MysticItems.PEACH_SAPLING, 0.3F);
        BlockDataUtils.compostable(MysticItems.DESERT_GRASS, 0.3F);
        BlockDataUtils.compostable(MysticItems.SAGUARO_BLOSSOM, 0.65F);
        BlockDataUtils.compostable(MysticItems.WILDFLOWER, 0.65F);
        BlockDataUtils.compostable(MysticItems.PEACH, 0.4F);
        BlockDataUtils.compostable(MysticItems.PEACH_PIE, 2.0F);

        BlockDataUtils.compostable(MysticItems.MAPLE_LEAVES, 0.3F);
        BlockDataUtils.compostable(MysticItems.MAPLE_LEAF_PILE, 0.2F);
        BlockDataUtils.compostable(MysticItems.MAPLE_SAPLING, 0.3F);
        BlockDataUtils.compostable(MysticItems.ORANGE_MAPLE_LEAVES, 0.3F);
        BlockDataUtils.compostable(MysticItems.ORANGE_MAPLE_LEAF_PILE, 0.2F);
        BlockDataUtils.compostable(MysticItems.ORANGE_MAPLE_SAPLING, 0.3F);
        BlockDataUtils.compostable(MysticItems.YELLOW_MAPLE_LEAVES, 0.3F);
        BlockDataUtils.compostable(MysticItems.YELLOW_MAPLE_LEAF_PILE, 0.2F);
        BlockDataUtils.compostable(MysticItems.YELLOW_MAPLE_SAPLING, 0.3F);

        BlockDataUtils.compostable(MysticItems.SEA_SHRUB_LEAVES, 0.3F);
        BlockDataUtils.compostable(MysticItems.SEA_SHRUB, 0.65F);
        BlockDataUtils.compostable(MysticItems.SEA_OATS, 0.65F);
        BlockDataUtils.compostable(MysticItems.MILKWEED, 0.65F);

        BlockDataUtils.compostable(MysticItems.TROPICAL_LEAVES, 0.3F);
        BlockDataUtils.compostable(MysticItems.TROPICAL_SAPLING, 0.3F);
        BlockDataUtils.compostable(MysticItems.HYDRANGEA_LEAVES, 0.6F);
        BlockDataUtils.compostable(MysticItems.HYDRANGEA_BUSH, 0.65F);
        BlockDataUtils.compostable(MysticItems.VANILLA_BEANS, 0.65F);
        BlockDataUtils.compostable(MysticItems.VANILLA_CAKE, 2.0F);
        BlockDataUtils.compostable(MysticItems.CHOCOLATE_CAKE, 2.0F);

        BlockDataUtils.compostable(MysticItems.JACARANDA_BLOSSOMS, 0.6F);
        BlockDataUtils.compostable(MysticItems.JACARANDA_LEAVES, 0.3F);
        BlockDataUtils.compostable(MysticItems.JACARANDA_SAPLING, 0.3F);
        BlockDataUtils.compostable(MysticItems.LAVENDER, 0.65F);

        BlockDataUtils.compostable(MysticItems.PINK_FROSTED_CAKE, 2.0F);
        BlockDataUtils.compostable(MysticItems.ORANGE_FROSTED_CAKE, 2.0F);
        BlockDataUtils.compostable(MysticItems.YELLOW_FROSTED_CAKE, 2.0F);
        BlockDataUtils.compostable(MysticItems.LIME_FROSTED_CAKE, 2.0F);
        BlockDataUtils.compostable(MysticItems.CYAN_FROSTED_CAKE, 2.0F);
        BlockDataUtils.compostable(MysticItems.PURPLE_FROSTED_CAKE, 2.0F);
    }

    public static void registerStrippables() {
        BlockDataUtils.strippable(MysticBlocks.STRAWBERRY_LOG, MysticBlocks.STRIPPED_STRAWBERRY_LOG);
        BlockDataUtils.strippable(MysticBlocks.STRAWBERRY_WOOD, MysticBlocks.STRIPPED_STRAWBERRY_WOOD);

        BlockDataUtils.strippable(MysticBlocks.CHERRY_LOG, MysticBlocks.STRIPPED_CHERRY_LOG);
        BlockDataUtils.strippable(MysticBlocks.CHERRY_WOOD, MysticBlocks.STRIPPED_CHERRY_WOOD);

        BlockDataUtils.strippable(MysticBlocks.PEACH_LOG, MysticBlocks.STRIPPED_PEACH_LOG);
        BlockDataUtils.strippable(MysticBlocks.PEACH_WOOD, MysticBlocks.STRIPPED_PEACH_WOOD);

        BlockDataUtils.strippable(MysticBlocks.MAPLE_LOG, MysticBlocks.STRIPPED_MAPLE_LOG);
        BlockDataUtils.strippable(MysticBlocks.WHITE_MAPLE_LOG, MysticBlocks.STRIPPED_MAPLE_LOG);
        BlockDataUtils.strippable(MysticBlocks.MAPLE_WOOD, MysticBlocks.STRIPPED_MAPLE_WOOD);

        BlockDataUtils.strippable(MysticBlocks.SEA_FOAM_LOG, MysticBlocks.STRIPPED_SEA_FOAM_LOG);
        BlockDataUtils.strippable(MysticBlocks.SEA_FOAM_WOOD, MysticBlocks.STRIPPED_SEA_FOAM_WOOD);

        BlockDataUtils.strippable(MysticBlocks.TROPICAL_LOG, MysticBlocks.STRIPPED_TROPICAL_LOG);
        BlockDataUtils.strippable(MysticBlocks.TROPICAL_WOOD, MysticBlocks.STRIPPED_TROPICAL_WOOD);

        BlockDataUtils.strippable(MysticBlocks.JACARANDA_LOG, MysticBlocks.STRIPPED_JACARANDA_LOG);
        BlockDataUtils.strippable(MysticBlocks.JACARANDA_WOOD, MysticBlocks.STRIPPED_JACARANDA_WOOD);
    }
    
    public static void registerRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.STRAWBERRY_BLOSSOMS, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.STRAWBERRY_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.STRAWBERRY_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.STRAWBERRY_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.STRAWBERRY_BUSH, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.PINK_CHERRY_BLOSSOMS, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.WHITE_CHERRY_BLOSSOMS, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.WHITE_CHERRY_BLOSSOM_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.CHERRY_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.CHERRY_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.CHERRY_PLANT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.CHERRY_PIE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.PEONY_LEAVES, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.BUDDING_PEONY_LEAVES, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.PEONY_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.SPRING_BAMBOO, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.SPRING_BAMBOO_SAPLING, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.PEACH_LEAVES, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.PEACH_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.PEACH_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.PEACH_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.PEACH_PLANT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.PEACH_PIE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.WILDFLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.DESERT_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.SAGUARO_BLOSSOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.SAGUARO_CACTUS, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.MAPLE_LEAVES, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.MAPLE_LEAF_PILE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.MAPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.ORANGE_MAPLE_LEAVES, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.ORANGE_MAPLE_LEAF_PILE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.ORANGE_MAPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.YELLOW_MAPLE_LEAVES, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.YELLOW_MAPLE_LEAF_PILE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.YELLOW_MAPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.MAPLE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.MAPLE_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.SEA_SHRUB_LEAVES, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.SEA_SHRUB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.SEA_FOAM_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.SEA_FOAM_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.SEA_OATS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.MILKWEED, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.TROPICAL_LEAVES, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.TROPICAL_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.TROPICAL_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.TROPICAL_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.HYDRANGEA_LEAVES, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.HYDRANGEA_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.VANILLA_ORCHID, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.JACARANDA_LEAVES, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.JACARANDA_BLOSSOMS, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.JACARANDA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.JACARANDA_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.JACARANDA_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.LAVENDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.BUTTERFLY_NEST, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.GLASS_JAR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.POTTED_STRAWBERRY_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.POTTED_PINK_CHERRY_BLOSSOM_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.POTTED_WHITE_CHERRY_BLOSSOM_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.POTTED_PEACH_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.POTTED_MAPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.POTTED_ORANGE_MAPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.POTTED_YELLOW_MAPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.POTTED_SEA_SHRUB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.POTTED_TROPICAL_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.POTTED_JACARANDA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.POTTED_PEONY_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.POTTED_HYDRANGEA_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.POTTED_LAVENDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.POTTED_WILDFLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.POTTED_SPRING_BAMBOO, RenderLayer.getCutout());

        BlockEntityRendererFactories.register(MysticBlockEntities.SIGN, SignBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(MysticBlockEntities.HANGING_SIGN, HangingSignBlockEntityRenderer::new);
    }

}