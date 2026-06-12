package com.mysticsbiomes.fabric;

import com.mysticsbiomes.MysticsBiomes;
import net.fabricmc.api.ModInitializer;
import terrablender.api.TerraBlenderApi;

public class MysticsBiomesFabric implements ModInitializer, TerraBlenderApi {

    @Override
    public void onInitialize() {
        MysticsBiomes.init();
    }

    @Override
    public void onTerraBlenderInitialized() {
        MysticsBiomes.setupTerraBlender();
    }

}