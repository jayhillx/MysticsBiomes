package com.mysticsbiomes.fabric.init;

import com.mysticsbiomes.client.entity.renderer.MysticBoatRenderer;
import com.mysticsbiomes.common.entity.vehicle.MysticBoat;
import com.mysticsbiomes.init.MysticEntities;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;

@Environment(EnvType.CLIENT)
public class MysticClientFabric {

    public static void registerEntityModels() {
        ///EntityModelLayerRegistry.registerModelLayer(MysticModelLayers.STRAWBERRY_COW, MysticCowModel::createBodyLayer);
        ///EntityModelLayerRegistry.registerModelLayer(MysticModelLayers.VANILLA_COW, MysticCowModel::createBodyLayer);
        ///EntityModelLayerRegistry.registerModelLayer(MysticModelLayers.CHOCOLATE_COW, MysticCowModel::createBodyLayer);
        ///EntityModelLayerRegistry.registerModelLayer(MysticModelLayers.RAINBOW_CHICKEN, RainbowChickenModel::createBodyLayer);
        ///EntityModelLayerRegistry.registerModelLayer(MysticModelLayers.RED_PANDA, RedPandaModel::createBodyLayer);
        ///EntityModelLayerRegistry.registerModelLayer(MysticModelLayers.SEA_OTTER, SeaOtterModel::createBodyLayer);
        ///EntityModelLayerRegistry.registerModelLayer(MysticModelLayers.BUTTERFLY, ButterflyModel::createBodyLayer);
        ///EntityModelLayerRegistry.registerModelLayer(MysticModelLayers.CATERPILLAR, CaterpillarModel::createBodyLayer);

        for (MysticBoat.Type type : MysticBoat.Type.values()) {
            ///if (type == MysticBoat.Type.SPRING) {
            ///    EntityModelLayerRegistry.registerModelLayer(MysticBoatRenderer.createBoatModelName(type), RaftModel::createBodyModel);
            ///    EntityModelLayerRegistry.registerModelLayer(MysticBoatRenderer.createChestBoatModelName(type), ChestRaftModel::createBodyModel);
            ///} else {
            ///    EntityModelLayerRegistry.registerModelLayer(MysticBoatRenderer.createBoatModelName(type), BoatModel::createBodyModel);
            ///    EntityModelLayerRegistry.registerModelLayer(MysticBoatRenderer.createChestBoatModelName(type), ChestBoatModel::createBodyModel);
            ///}
            EntityModelLayerRegistry.registerModelLayer(MysticBoatRenderer.createBoatModelName(type), BoatModel::createBodyModel);
            EntityModelLayerRegistry.registerModelLayer(MysticBoatRenderer.createChestBoatModelName(type), ChestBoatModel::createBodyModel);
        }
    }

    public static void registerEntityRenderers() {
        ///EntityRendererRegistry.register(MysticEntities.STRAWBERRY_COW, StrawberryCowRenderer::new);
        ///EntityRendererRegistry.register(MysticEntities.VANILLA_COW, VanillaCowRenderer::new);
        ///EntityRendererRegistry.register(MysticEntities.CHOCOLATE_COW, ChocolateCowRenderer::new);
        ///EntityRendererRegistry.register(MysticEntities.RAINBOW_CHICKEN, RainbowChickenRenderer::new);
        ///EntityRendererRegistry.register(MysticEntities.RED_PANDA, RedPandaRenderer::new);
        ///EntityRendererRegistry.register(MysticEntities.SEA_OTTER, SeaOtterRenderer::new);
        ///EntityRendererRegistry.register(MysticEntities.BUTTERFLY, ButterflyRenderer::new);
        ///EntityRendererRegistry.register(MysticEntities.CATERPILLAR, CaterpillarRenderer::new);
        ///EntityRendererRegistry.register(MysticEntities.RAINBOW_EGG, ThrownItemRenderer::new);

        EntityRendererRegistry.register(MysticEntities.BOAT.get(), context -> new MysticBoatRenderer(context, false));
        EntityRendererRegistry.register(MysticEntities.CHEST_BOAT.get(), context -> new MysticBoatRenderer(context, true));
    }

}