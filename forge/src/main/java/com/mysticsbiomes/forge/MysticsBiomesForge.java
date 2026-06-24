package com.mysticsbiomes.forge;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.forge.registry.ForgeRegistryHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MysticsBiomes.modId)
public class MysticsBiomesForge {

    public MysticsBiomesForge(FMLJavaModLoadingContext context) {
        IEventBus bus = context.getModEventBus();
        bus.addListener(this::commonSetup);

        MysticsBiomes.REGISTRY = new ForgeRegistryHelper(MysticsBiomes.modId);
        MysticsBiomes.init();
        ((ForgeRegistryHelper)MysticsBiomes.REGISTRY).attachToModEventBus(bus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            MysticsBiomes.setupTerraBlender();
        });
    }

}