package com.mysticsbiomes.forge.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.entity.renderer.MysticBoatRenderer;
import com.mysticsbiomes.common.entity.vehicle.MysticBoat;
import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticEntities;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ChestRaftModel;
import net.minecraft.client.model.RaftModel;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MysticsBiomes.modId, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MysticClientForge {

    @SubscribeEvent
    public static void registerEntityModels(EntityRenderersEvent.RegisterLayerDefinitions event) {
        ///event.registerLayerDefinition(MysticModelLayers.STRAWBERRY_COW, MysticCowModel::createBodyLayer);
        ///event.registerLayerDefinition(MysticModelLayers.VANILLA_COW, MysticCowModel::createBodyLayer);
        ///event.registerLayerDefinition(MysticModelLayers.CHOCOLATE_COW, MysticCowModel::createBodyLayer);
        ///event.registerLayerDefinition(MysticModelLayers.RAINBOW_CHICKEN, RainbowChickenModel::createBodyLayer);
        ///event.registerLayerDefinition(MysticModelLayers.RED_PANDA, RedPandaModel::createBodyLayer);
        ///event.registerLayerDefinition(MysticModelLayers.SEA_OTTER, SeaOtterModel::createBodyLayer);
        ///event.registerLayerDefinition(MysticModelLayers.BUTTERFLY, ButterflyModel::createBodyLayer);
        ///event.registerLayerDefinition(MysticModelLayers.CATERPILLAR, CaterpillarModel::createBodyLayer);

        ///for (MysticBoat.Type type : MysticBoat.Type.values()) {
        ///    if (type == MysticBoat.Type.SPRING) {
        ///        event.registerLayerDefinition(MysticBoatRenderer.createBoatModelName(type), RaftModel::createBodyModel);
        ///        event.registerLayerDefinition(MysticBoatRenderer.createChestBoatModelName(type), ChestRaftModel::createBodyModel);
        ///    } else {
        ///        event.registerLayerDefinition(MysticBoatRenderer.createBoatModelName(type), BoatModel::createBodyModel);
        ///        event.registerLayerDefinition(MysticBoatRenderer.createChestBoatModelName(type), ChestBoatModel::createBodyModel);
        ///    }
        ///}
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        ///event.registerEntityRenderer(MysticEntities.STRAWBERRY_COW.get(), StrawberryCowRenderer::new);
        ///event.registerEntityRenderer(MysticEntities.VANILLA_COW.get(), VanillaCowRenderer::new);
        ///event.registerEntityRenderer(MysticEntities.CHOCOLATE_COW.get(), ChocolateCowRenderer::new);
        ///event.registerEntityRenderer(MysticEntities.RAINBOW_CHICKEN.get(), RainbowChickenRenderer::new);
        ///event.registerEntityRenderer(MysticEntities.RAINBOW_EGG.get(), ThrownItemRenderer::new);
        ///event.registerEntityRenderer(MysticEntities.RED_PANDA.get(), RedPandaRenderer::new);
        ///event.registerEntityRenderer(MysticEntities.SEA_OTTER.get(), SeaOtterRenderer::new);
        ///event.registerEntityRenderer(MysticEntities.BUTTERFLY.get(), ButterflyRenderer::new);
        ///event.registerEntityRenderer(MysticEntities.CATERPILLAR.get(), CaterpillarRenderer::new);

        ///event.registerEntityRenderer(MysticEntities.BOAT.get(), context -> new MysticBoatRenderer(context, false));
        ///event.registerEntityRenderer(MysticEntities.CHEST_BOAT.get(), context -> new MysticBoatRenderer(context, true));
    }

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        ///event.register((state, level, pos, tintIndex) -> tintIndex == 1 ? BiomeColors.getAverageFoliageColor(level, pos) : -1,
        ///        MysticBlocks.STRAWBERRY_BLOSSOMS.get()
        ///);
    }

}