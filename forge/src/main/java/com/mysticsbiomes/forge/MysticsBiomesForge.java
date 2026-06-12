package com.mysticsbiomes.forge;

import com.mysticsbiomes.MysticsBiomes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(value = MysticsBiomes.modId)
public class MysticsBiomesForge {

    public MysticsBiomesForge(FMLJavaModLoadingContext context) {
        IEventBus bus = context.getModEventBus();
        bus.addListener(this::commonSetup);

        MysticsBiomes.init();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            MysticsBiomes.setupTerraBlender();
        });
    }
    
}