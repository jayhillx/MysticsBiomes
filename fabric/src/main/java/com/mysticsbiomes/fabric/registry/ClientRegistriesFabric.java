package com.mysticsbiomes.fabric.registry;

import api.mystanica.registration.client.*;
import com.mysticsbiomes.init.MysticClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;

@Environment(EnvType.CLIENT)
public class ClientRegistriesFabric {

    public static void registerEntityModels() {
        MysticClient.registerEntityModels((layer, provider) -> {
            EntityModelLayerRegistry.registerModelLayer(layer, provider::create);
        });
    }

    public static void registerEntityRenderers() {
        MysticClient.registerEntityRenderers(new EntityRendererRegistry(net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry::register));
    }

    public static void registerBlockRenderLayers() {
        MysticClient.registerBlockRenderLayers(new BlockRenderLayerRegistry(BlockRenderLayerMap.INSTANCE::putBlock));
    }

    public static void registerBlockColors() {
        MysticClient.registerBlockColors(new BlockColorRegistry(ColorProviderRegistry.BLOCK::register));
    }

    public static void registerItemColors() {
        MysticClient.registerItemColors(new ItemColorRegistry(ColorProviderRegistry.ITEM::register));
    }

    public static void registerParticleTypes() {
        MysticClient.registerParticleTypes(new ParticleTypeRegistry(ClientRegistriesFabric::registerParticle));
    }

    private static <T extends ParticleOptions> void registerParticle(ParticleType<T> type, ParticleEngine.SpriteParticleRegistration<T> registration) {
        ParticleFactoryRegistry.getInstance().register(type, registration::create);
    }

}