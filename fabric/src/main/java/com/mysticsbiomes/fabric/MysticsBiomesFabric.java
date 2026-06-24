package com.mysticsbiomes.fabric;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.fabric.registry.FabricRegistryHelper;
import net.fabricmc.api.ModInitializer;
import terrablender.api.TerraBlenderApi;

public class MysticsBiomesFabric implements ModInitializer, TerraBlenderApi {

    @Override
    public void onInitialize() {
        MysticsBiomes.REGISTRY = new FabricRegistryHelper(MysticsBiomes.modId);
        MysticsBiomes.init();
    }

    @Override
    public void onTerraBlenderInitialized() {
        MysticsBiomes.setupTerraBlender();
    }

}