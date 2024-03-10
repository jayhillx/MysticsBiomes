package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.util.BlockDataUtils;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class MysticVanillaCompat {

    public static void registerFlammables() {
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_BLOSSOMS.get(), 30, 60);
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_LOG.get(), 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRIPPED_STRAWBERRY_LOG.get(), 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_WOOD.get(), 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRIPPED_STRAWBERRY_WOOD.get(), 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_PLANKS.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_STAIRS.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_SLAB.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_FENCE.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_FENCE_GATE.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_BUTTON.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_PRESSURE_PLATE.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_TRAPDOOR.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_DOOR.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_BUSH.get(), 60, 100);

        BlockDataUtils.flammable(MysticBlocks.PINK_CHERRY_BLOSSOMS.get(), 30, 60);
        BlockDataUtils.flammable(MysticBlocks.WHITE_CHERRY_BLOSSOMS.get(), 30, 60);
        BlockDataUtils.flammable(MysticBlocks.CHERRY_LOG.get(), 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRIPPED_CHERRY_LOG.get(), 5, 5);
        BlockDataUtils.flammable(MysticBlocks.CHERRY_WOOD.get(), 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRIPPED_CHERRY_WOOD.get(), 5, 5);
        BlockDataUtils.flammable(MysticBlocks.CHERRY_PLANKS.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.CHERRY_STAIRS.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.CHERRY_SLAB.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.CHERRY_FENCE.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.CHERRY_FENCE_GATE.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.CHERRY_BUTTON.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.CHERRY_PRESSURE_PLATE.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.CHERRY_TRAPDOOR.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.CHERRY_DOOR.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.SPRING_BAMBOO.get(), 60, 60);
        BlockDataUtils.flammable(MysticBlocks.BUDDING_PEONY_LEAVES.get(), 30, 60);
        BlockDataUtils.flammable(MysticBlocks.PEONY_LEAVES.get(), 30, 60);
        BlockDataUtils.flammable(MysticBlocks.PEONY_BUSH.get(), 30, 60);

        BlockDataUtils.flammable(MysticBlocks.WILDFLOWER.get(), 60, 100);

        BlockDataUtils.flammable(MysticBlocks.MAPLE_LEAVES.get(), 30, 60);
        BlockDataUtils.flammable(MysticBlocks.MAPLE_LEAF_PILE.get(), 30, 60);
        BlockDataUtils.flammable(MysticBlocks.ORANGE_MAPLE_LEAVES.get(), 30, 60);
        BlockDataUtils.flammable(MysticBlocks.ORANGE_MAPLE_LEAF_PILE.get(), 30, 60);
        BlockDataUtils.flammable(MysticBlocks.YELLOW_MAPLE_LEAVES.get(), 30, 60);
        BlockDataUtils.flammable(MysticBlocks.YELLOW_MAPLE_LEAF_PILE.get(), 30, 60);
        BlockDataUtils.flammable(MysticBlocks.MAPLE_LOG.get(), 5, 5);
        BlockDataUtils.flammable(MysticBlocks.WHITE_MAPLE_LOG.get(), 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRIPPED_MAPLE_LOG.get(), 5, 5);
        BlockDataUtils.flammable(MysticBlocks.MAPLE_WOOD.get(), 5, 5);
        BlockDataUtils.flammable(MysticBlocks.WHITE_MAPLE_WOOD.get(), 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRIPPED_MAPLE_WOOD.get(), 5, 5);
        BlockDataUtils.flammable(MysticBlocks.MAPLE_PLANKS.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.MAPLE_STAIRS.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.MAPLE_SLAB.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.MAPLE_FENCE.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.MAPLE_FENCE_GATE.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.MAPLE_BUTTON.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.MAPLE_PRESSURE_PLATE.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.MAPLE_TRAPDOOR.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.MAPLE_DOOR.get(), 5, 20);

        BlockDataUtils.flammable(MysticBlocks.JACARANDA_BLOSSOMS.get(), 30, 60);
        BlockDataUtils.flammable(MysticBlocks.JACARANDA_LEAVES.get(), 30, 60);
        BlockDataUtils.flammable(MysticBlocks.JACARANDA_LOG.get(), 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRIPPED_JACARANDA_LOG.get(), 5, 5);
        BlockDataUtils.flammable(MysticBlocks.JACARANDA_WOOD.get(), 5, 5);
        BlockDataUtils.flammable(MysticBlocks.STRIPPED_JACARANDA_WOOD.get(), 5, 5);
        BlockDataUtils.flammable(MysticBlocks.JACARANDA_PLANKS.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.JACARANDA_STAIRS.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.JACARANDA_SLAB.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.JACARANDA_FENCE.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.JACARANDA_FENCE_GATE.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.JACARANDA_BUTTON.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.JACARANDA_PRESSURE_PLATE.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.JACARANDA_TRAPDOOR.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.JACARANDA_DOOR.get(), 5, 20);
        BlockDataUtils.flammable(MysticBlocks.LAVENDER.get(), 60, 100);
    }

    public static void registerCompostables() {
        // Leaves & Saplings 0.3 | Flower Leaves 0.6 | Flowers 0.65
        BlockDataUtils.compostable(MysticItems.STRAWBERRY_BLOSSOMS.get(), 0.6F);
        BlockDataUtils.compostable(MysticItems.STRAWBERRY_SAPLING.get(), 0.3F);
        BlockDataUtils.compostable(MysticItems.STRAWBERRY.get(), 0.4F);
        BlockDataUtils.compostable(MysticItems.SWEET_STRAWBERRY.get(), 1.0F);
        BlockDataUtils.compostable(MysticItems.STRAWBERRY_CAKE.get(), 1.0F);

        BlockDataUtils.compostable(MysticItems.PINK_CHERRY_BLOSSOMS.get(), 0.6F);
        BlockDataUtils.compostable(MysticItems.PINK_CHERRY_BLOSSOM_SAPLING.get(), 0.3F);
        BlockDataUtils.compostable(MysticItems.WHITE_CHERRY_BLOSSOMS.get(), 0.6F);
        BlockDataUtils.compostable(MysticItems.WHITE_CHERRY_BLOSSOM_SAPLING.get(), 0.3F);
        BlockDataUtils.compostable(MysticItems.BUDDING_PEONY_LEAVES.get(), 0.6F);
        BlockDataUtils.compostable(MysticItems.PEONY_LEAVES.get(), 0.3F);
        BlockDataUtils.compostable(MysticItems.PEONY_BUSH.get(), 0.65F);

        BlockDataUtils.compostable(MysticItems.MAPLE_LEAVES.get(), 0.6F);
        BlockDataUtils.compostable(MysticItems.MAPLE_LEAF_PILE.get(), 0.2F);
        BlockDataUtils.compostable(MysticItems.MAPLE_SAPLING.get(), 0.3F);
        BlockDataUtils.compostable(MysticItems.ORANGE_MAPLE_LEAVES.get(), 0.6F);
        BlockDataUtils.compostable(MysticItems.ORANGE_MAPLE_LEAF_PILE.get(), 0.2F);
        BlockDataUtils.compostable(MysticItems.ORANGE_MAPLE_SAPLING.get(), 0.3F);
        BlockDataUtils.compostable(MysticItems.YELLOW_MAPLE_LEAVES.get(), 0.6F);
        BlockDataUtils.compostable(MysticItems.YELLOW_MAPLE_LEAF_PILE.get(), 0.2F);
        BlockDataUtils.compostable(MysticItems.YELLOW_MAPLE_SAPLING.get(), 0.3F);
        BlockDataUtils.compostable(MysticItems.PUMPKIN_COOKIE.get(), 0.8F);

        BlockDataUtils.compostable(MysticItems.JACARANDA_BLOSSOMS.get(), 0.6F);
        BlockDataUtils.compostable(MysticItems.JACARANDA_SAPLING.get(), 0.3F);
        BlockDataUtils.compostable(MysticItems.LAVENDER.get(), 0.65F);

        BlockDataUtils.compostable(MysticItems.PINK_FROSTED_CAKE.get(), 1.0F);
        BlockDataUtils.compostable(MysticItems.ORANGE_FROSTED_CAKE.get(), 1.0F);
        BlockDataUtils.compostable(MysticItems.YELLOW_FROSTED_CAKE.get(), 1.0F);
        BlockDataUtils.compostable(MysticItems.LIME_FROSTED_CAKE.get(), 1.0F);
        BlockDataUtils.compostable(MysticItems.CYAN_FROSTED_CAKE.get(), 1.0F);
        BlockDataUtils.compostable(MysticItems.PURPLE_FROSTED_CAKE.get(), 1.0F);
    }

    /** Enqueued in {@link MysticsBiomes#clientSetup(FMLClientSetupEvent)} */
    public static void registerRenderLayers() {
        //RenderType cutoutMipped = RenderType.cutoutMipped();
        //RenderType cutout = RenderType.cutoutMipped();
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.STRAWBERRY_BLOSSOMS.get(), cutoutMipped);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.STRAWBERRY_SAPLING.get(), cutout);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.POTTED_STRAWBERRY_SAPLING.get(), cutout);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.STRAWBERRY_BUSH.get(), cutout);

        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.PINK_CHERRY_BLOSSOMS.get(), cutoutMipped);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING.get(), cutout);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.POTTED_PINK_CHERRY_BLOSSOM_SAPLING.get(), cutout);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.WHITE_CHERRY_BLOSSOMS.get(), cutoutMipped);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.WHITE_CHERRY_BLOSSOM_SAPLING.get(), cutout);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.POTTED_WHITE_CHERRY_BLOSSOM_SAPLING.get(), cutout);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.BUDDING_PEONY_LEAVES.get(), cutoutMipped);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.PEONY_LEAVES.get(), cutoutMipped);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.PEONY_BUSH.get(), cutoutMipped);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.POTTED_PEONY_BUSH.get(), cutout);

        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.CITRUS_LEAVES.get(), cutoutMipped);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.CITRUS_SAPLING.get(), cutout);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.POTTED_CITRUS_SAPLING.get(), cutout);

        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.MAPLE_LEAVES.get(), cutoutMipped);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.MAPLE_LEAF_PILE.get(), cutoutMipped);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.MAPLE_SAPLING.get(), cutout);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.POTTED_MAPLE_SAPLING.get(), cutout);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.ORANGE_MAPLE_LEAVES.get(), cutoutMipped);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.ORANGE_MAPLE_LEAF_PILE.get(), cutoutMipped);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.ORANGE_MAPLE_SAPLING.get(), cutout);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.POTTED_ORANGE_MAPLE_SAPLING.get(), cutout);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.YELLOW_MAPLE_LEAVES.get(), cutoutMipped);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.YELLOW_MAPLE_LEAF_PILE.get(), cutoutMipped);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.YELLOW_MAPLE_SAPLING.get(), cutout);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.POTTED_YELLOW_MAPLE_SAPLING.get(), cutout);

        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.JACARANDA_BLOSSOMS.get(), cutoutMipped);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.JACARANDA_LEAVES.get(), cutoutMipped);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.JACARANDA_SAPLING.get(), cutout);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.POTTED_JACARANDA_SAPLING.get(), cutout);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.LAVENDER.get(), cutout);
        //ItemBlockRenderTypes.setRenderLayer(MysticBlocks.POTTED_LAVENDER.get(), cutout);

        BlockEntityRenderers.register(MysticBlockEntities.SIGN.get(), SignRenderer::new);
        BlockEntityRenderers.register(MysticBlockEntities.HANGING_SIGN.get(), HangingSignRenderer::new);
    }

}