package com.jayhill.mysticsbiomes.core;

import com.jayhill.mysticsbiomes.init.MysticBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class RegisterClient {

    /** Render Layers. */
    public static void registerRenderLayers() {
        RenderTypeLookup.setRenderLayer(MysticBlocks.STRAWBERRY_BLOSSOM_LEAVES.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(MysticBlocks.SWEET_BLOSSOM_LEAVES.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(MysticBlocks.STRAWBERRY_BLOSSOM_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(MysticBlocks.SWEET_BLOSSOM_SAPLING.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(MysticBlocks.STRAWBERRY_BUSH.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(MysticBlocks.STRAWBERRY_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(MysticBlocks.STRAWBERRY_TRAPDOOR.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(MysticBlocks.POTTED_STRAWBERRY_BLOSSOM_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(MysticBlocks.POTTED_SWEET_BLOSSOM_SAPLING.get(), RenderType.getCutout());
    }

}