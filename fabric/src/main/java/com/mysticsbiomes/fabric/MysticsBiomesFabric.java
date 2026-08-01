package com.mysticsbiomes.fabric;

import api.mystanica.registry.Registrar;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.config.MysticConfigs;
import com.mysticsbiomes.fabric.registry.ClientRegistriesFabric;
import com.mysticsbiomes.fabric.registry.CommonRegistriesFabric;
import com.mysticsbiomes.fabric.registry.MysticRegistryFabric;
import com.mysticsbiomes.init.MysticClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import terrablender.api.TerraBlenderApi;

public class MysticsBiomesFabric implements ModInitializer, ClientModInitializer, TerraBlenderApi {

    @Override
    public void onInitialize() {
        Registrar.FACTORY = new MysticRegistryFabric.Factory();
        MysticConfigs.INSTANCE = new MysticConfigs(FabricLoader.getInstance().getConfigDir().resolve(MysticsBiomes.modId + ".toml"));
        MysticsBiomes.init();
        Registrar.applyAll();

        this.onInitializeCommon();
    }

    public void onInitializeCommon() {
        MysticsBiomes.setupCommon();
        CommonRegistriesFabric.registerEntityAttributes();
        CommonRegistriesFabric.registerEntitySpawnPlacements();
    }

    @Override
    public void onInitializeClient() {
        MysticClient.registerRenderLayers();
        MysticClient.registerWoodTypes();
        ClientRegistriesFabric.registerEntityModels();
        ClientRegistriesFabric.registerEntityRenderers();
        ClientRegistriesFabric.registerBlockRenderLayers();
        ClientRegistriesFabric.registerBlockColors();
        ClientRegistriesFabric.registerItemColors();
        ClientRegistriesFabric.registerParticleTypes();
    }

    @Override
    public void onTerraBlenderInitialized() {
        MysticsBiomes.setupTerraBlender();
    }

}