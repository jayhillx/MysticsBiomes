package com.meepshadow.mysticsbiomes.core.other;

import com.meepshadow.mysticsbiomes.client.entity.render.StrawberryCowRenderer;
import com.meepshadow.mysticsbiomes.common.util.DataUtils;
import com.meepshadow.mysticsbiomes.core.registry.ModBlocks;
import com.meepshadow.mysticsbiomes.core.registry.ModEntities;
import com.meepshadow.mysticsbiomes.core.registry.ModItems;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class VanillaCompatibility {
    public static void setupVanillaCompatibility() {
        DataUtils.registerFlammable(ModBlocks.ETHEREAL_LEAVES.get(), 30, 60);
        DataUtils.registerFlammable(ModBlocks.ETHEREAL_LEAF_CARPET.get(), 30, 60);
        DataUtils.registerFlammable(ModBlocks.STRIPPED_ETHEREAL_LOG.get(), 5, 5);
        DataUtils.registerFlammable(ModBlocks.ETHEREAL_LOG.get(), 5, 5);
        DataUtils.registerFlammable(ModBlocks.STRIPPED_ETHEREAL_WOOD.get(), 5, 5);
        DataUtils.registerFlammable(ModBlocks.ETHEREAL_WOOD.get(), 5, 5);
        DataUtils.registerFlammable(ModBlocks.ETHEREAL_PLANKS.get(), 5, 20);
        DataUtils.registerFlammable(ModBlocks.ETHEREAL_SLAB.get(), 5, 20);
        DataUtils.registerFlammable(ModBlocks.ETHEREAL_STAIRS.get(), 5, 20);
        DataUtils.registerFlammable(ModBlocks.ETHEREAL_FENCE.get(), 5, 20);
        DataUtils.registerFlammable(ModBlocks.ETHEREAL_FENCE_GATE.get(), 5, 20);
        
        DataUtils.registerFlammable(ModBlocks.LAVENDER_BLOSSOM_LEAVES.get(), 30, 60);
        DataUtils.registerFlammable(ModBlocks.LAVENDER_BLOSSOM_LEAF_CARPET.get(), 30, 60);
        DataUtils.registerFlammable(ModBlocks.STRIPPED_LAVENDER_LOG.get(), 5, 5);
        DataUtils.registerFlammable(ModBlocks.LAVENDER_LOG.get(), 5, 5);
        DataUtils.registerFlammable(ModBlocks.STRIPPED_LAVENDER_WOOD.get(), 5, 5);
        DataUtils.registerFlammable(ModBlocks.LAVENDER_WOOD.get(), 5, 5);
        DataUtils.registerFlammable(ModBlocks.LAVENDER_PLANKS.get(), 5, 20);
        DataUtils.registerFlammable(ModBlocks.LAVENDER_SLAB.get(), 5, 20);
        DataUtils.registerFlammable(ModBlocks.LAVENDER_STAIRS.get(), 5, 20);
        DataUtils.registerFlammable(ModBlocks.LAVENDER_FENCE.get(), 5, 20);
        DataUtils.registerFlammable(ModBlocks.LAVENDER_FENCE_GATE.get(), 5, 20);

        DataUtils.registerFlammable(ModBlocks.STRAWBERRY_BLOSSOM_LEAVES.get(), 30, 60);
        DataUtils.registerFlammable(ModBlocks.SWEET_BLOSSOM_LEAVES.get(), 30, 60);
        DataUtils.registerFlammable(ModBlocks.STRAWBERRY_BLOSSOM_LEAF_CARPET.get(), 30, 60);
        DataUtils.registerFlammable(ModBlocks.SWEET_BLOSSOM_LEAF_CARPET.get(), 30, 60);
        DataUtils.registerFlammable(ModBlocks.STRIPPED_STRAWBERRY_LOG.get(), 5, 5);
        DataUtils.registerFlammable(ModBlocks.STRAWBERRRY_LOG.get(), 5, 5);
        DataUtils.registerFlammable(ModBlocks.STRIPPED_STRAWBERRY_WOOD.get(), 5, 5);
        DataUtils.registerFlammable(ModBlocks.STRAWBERRY_WOOD.get(), 5, 5);
        DataUtils.registerFlammable(ModBlocks.STRAWBERRY_PLANKS.get(), 5, 20);
        DataUtils.registerFlammable(ModBlocks.STRAWBERRY_SLAB.get(), 5, 20);
        DataUtils.registerFlammable(ModBlocks.STRAWBERRY_STAIRS.get(), 5, 20);
        DataUtils.registerFlammable(ModBlocks.STRAWBERRY_FENCE.get(), 5, 20);
        DataUtils.registerFlammable(ModBlocks.STRAWBERRY_FENCE_GATE.get(), 5, 20);

        DataUtils.registerFlammable(ModBlocks.STRAWBERRY_BUSH.get(), 60, 100);
        DataUtils.registerFlammable(ModBlocks.STRAWBERRY_FLOWER.get(), 60, 100);
        DataUtils.registerFlammable(ModBlocks.LAVENDER.get(), 60, 100);
        DataUtils.registerFlammable(ModBlocks.WHITE_DAISY_BUSH.get(), 60, 100);
        DataUtils.registerFlammable(ModBlocks.PINK_DAISY_BUSH.get(), 60, 100);
    }

    public static void setupVanillaCompatibilityClient() {
        RenderTypeLookup.setRenderLayer(ModBlocks.ETHEREAL_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.ETHEREAL_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.LAVENDER_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.LAVENDER_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.STRAWBERRY_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.STRAWBERRY_TRAPDOOR.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.ETHEREAL_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.LAVENDER_BLOSSOM_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SWEET_BLOSSOM_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.STRAWBERRY_BLOSSOM_LEAVES.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.ETHEREAL_LEAF_CARPET.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.LAVENDER_BLOSSOM_LEAF_CARPET.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SWEET_BLOSSOM_LEAF_CARPET.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.STRAWBERRY_BLOSSOM_LEAF_CARPET.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.ETHEREAL_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.LAVENDER_BLOSSOM_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SWEET_BLOSSOM_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.STRAWBERRY_BLOSSOM_SAPLING.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_ETHEREAL_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_LAVENDER_BLOSSOM_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_SWEET_BLOSSOM_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_STRAWBERRY_BLOSSOM_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_STRAWBERRY_BUSH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_LAVENDER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_WHITE_DAISY_BUSH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_PINK_DAISY_BUSH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_ORB_MUSHROOM.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.STRAWBERRY_BUSH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.STRAWBERRY_FLOWER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.LAVENDER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.WHITE_DAISY_BUSH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.PINK_DAISY_BUSH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.ORB_MUSHROOM.get(), RenderType.getCutout());

        RenderingRegistry.registerEntityRenderingHandler(ModEntities.STRAWBERRY_COW.get(), StrawberryCowRenderer::new);
    }

    public static void registerCompostables() {
        DataUtils.registerCompostable(1.00F, ModItems.ORB_MUSHROOM.get());
        DataUtils.registerCompostable(0.75F, ModItems.STRAWBERRIES.get());
        DataUtils.registerCompostable(0.35F, ModBlocks.STRAWBERRY_FLOWER.get());
        DataUtils.registerCompostable(0.35F, ModBlocks.LAVENDER.get());
        DataUtils.registerCompostable(0.35F, ModBlocks.WHITE_DAISY_BUSH.get());
        DataUtils.registerCompostable(0.35F, ModBlocks.PINK_DAISY_BUSH.get());
        DataUtils.registerCompostable(0.35F, ModBlocks.ETHEREAL_SAPLING.get());
        DataUtils.registerCompostable(0.35F, ModBlocks.LAVENDER_BLOSSOM_SAPLING.get());
        DataUtils.registerCompostable(0.35F, ModBlocks.SWEET_BLOSSOM_SAPLING.get());
        DataUtils.registerCompostable(0.35F, ModBlocks.STRAWBERRY_BLOSSOM_SAPLING.get());
        DataUtils.registerCompostable(0.35F, ModBlocks.ETHEREAL_LEAVES.get());
        DataUtils.registerCompostable(0.35F, ModBlocks.LAVENDER_BLOSSOM_LEAVES.get());
        DataUtils.registerCompostable(0.35F, ModBlocks.SWEET_BLOSSOM_LEAVES.get());
        DataUtils.registerCompostable(0.35F, ModBlocks.STRAWBERRY_BLOSSOM_LEAVES.get());
        DataUtils.registerCompostable(0.35F, ModBlocks.ETHEREAL_LEAF_CARPET.get());
        DataUtils.registerCompostable(0.35F, ModBlocks.LAVENDER_BLOSSOM_LEAF_CARPET.get());
        DataUtils.registerCompostable(0.35F, ModBlocks.SWEET_BLOSSOM_LEAF_CARPET.get());
        DataUtils.registerCompostable(0.35F, ModBlocks.STRAWBERRY_BLOSSOM_LEAF_CARPET.get());
    }
}
