package com.mysticsbiomes.init;

import com.mysticsbiomes.common.block.state.MysticWoodTypes;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.WoodType;

public class MysticClient {

    public static void registerRenderLayers() {
        BlockEntityRenderers.register(MysticBlockEntities.SIGN.get(), SignRenderer::new);
        BlockEntityRenderers.register(MysticBlockEntities.HANGING_SIGN.get(), HangingSignRenderer::new);
    }

    public static void registerWoodTypes() {
        addWoodType(MysticWoodTypes.STRAWBERRY);
        addWoodType(MysticWoodTypes.BLACK_CHERRY);
        addWoodType(MysticWoodTypes.LAVENDER);
        addWoodType(MysticWoodTypes.VANILLA);
        addWoodType(MysticWoodTypes.PEACH);
        addWoodType(MysticWoodTypes.MAPLE);
        addWoodType(MysticWoodTypes.SPRING);
        addWoodType(MysticWoodTypes.SEA_FOAM);
        addWoodType(MysticWoodTypes.TROPICAL);
    }

    public static void addWoodType(WoodType woodType) {
        Sheets.SIGN_MATERIALS.put(woodType, createSignMaterial(woodType));
        Sheets.HANGING_SIGN_MATERIALS.put(woodType, createHangingSignMaterial(woodType));
    }

    private static Material createSignMaterial(WoodType woodType) {
        ResourceLocation location = new ResourceLocation(woodType.name());
        return new Material(Sheets.SIGN_SHEET, new ResourceLocation(location.getNamespace(), "entity/signs/" + location.getPath()));
    }

    private static Material createHangingSignMaterial(WoodType woodType) {
        ResourceLocation location = new ResourceLocation(woodType.name());
        return new Material(Sheets.SIGN_SHEET, new ResourceLocation(location.getNamespace(), "entity/signs/hanging/" + location.getPath()));
    }

}