package com.mysticsbiomes.fabric;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.fabric.init.MysticClientFabric;
import com.mysticsbiomes.fabric.registry.FabricRegistryHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import terrablender.api.TerraBlenderApi;

public class MysticsBiomesFabric implements ModInitializer, ClientModInitializer, TerraBlenderApi {

    @Override
    public void onInitialize() {
        MysticsBiomes.REGISTRY = new FabricRegistryHelper(MysticsBiomes.modId);
        MysticsBiomes.init();
        MysticsBiomes.setupCommon();
    }

    @Override
    public void onInitializeClient() {
        MysticsBiomes.setupClient();

        MysticClientFabric.registerEntityModels();
        MysticClientFabric.registerEntityRenderers();
    }

    @Override
    public void onTerraBlenderInitialized() {
        MysticsBiomes.setupTerraBlender();
    }

}