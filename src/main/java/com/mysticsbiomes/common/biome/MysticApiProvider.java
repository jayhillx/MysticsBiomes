package com.mysticsbiomes.common.biome;

import com.mysticsbiomes.init.MysticBiomes;
import terrablender.api.TerraBlenderApi;

public class MysticApiProvider implements TerraBlenderApi {

    @Override
    public void onTerraBlenderInitialized() {
        MysticBiomes.registerRegionProvider();
        MysticBiomes.registerSurfaceRules();
    }

}