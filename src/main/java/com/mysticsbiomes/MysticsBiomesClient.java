package com.mysticsbiomes;

import com.mysticsbiomes.init.MysticEntities;
import com.mysticsbiomes.init.MysticVanillaCompat;
import net.fabricmc.api.ClientModInitializer;

public class MysticsBiomesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        //MysticVanillaCompat.registerFlammables();
        MysticVanillaCompat.registerCompostables();
        MysticVanillaCompat.registerStrippables();
        MysticEntities.registerEntityRenderers();
        MysticEntities.registerEntityModels();
    }

}