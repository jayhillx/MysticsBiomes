package com.mysticsbiomes.forge.registry;

import api.mystanica.registration.client.BlockColorRegistry;
import api.mystanica.registration.client.EntityRendererRegistry;
import api.mystanica.registration.client.ItemColorRegistry;
import api.mystanica.registration.client.ParticleTypeRegistry;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.init.MysticClient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MysticsBiomes.modId, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientRegistriesForge {

    @SubscribeEvent
    public static void registerEntityModels(EntityRenderersEvent.RegisterLayerDefinitions event) {
        MysticClient.registerEntityModels((layer, provider) -> {
            event.registerLayerDefinition(layer, provider::create);
        });
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        MysticClient.registerEntityRenderers(new EntityRendererRegistry(event::registerEntityRenderer));
    }

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        MysticClient.registerBlockColors(new BlockColorRegistry(event::register));
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        MysticClient.registerItemColors(new ItemColorRegistry(event::register));
    }

    @SubscribeEvent
    public static void registerParticleTypes(RegisterParticleProvidersEvent event) {
        MysticClient.registerParticleTypes(new ParticleTypeRegistry(event::registerSpriteSet));
    }

}