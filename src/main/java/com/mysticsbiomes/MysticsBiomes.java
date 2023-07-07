package com.mysticsbiomes;

import com.mysticsbiomes.init.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("mysticsbiomes")
public class MysticsBiomes {
    public static final String modId = "mysticsbiomes";

    public static ResourceLocation modLoc(String path) {
        return new ResourceLocation(modId, path);
    }

    public MysticsBiomes() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);

        MysticBlocks.BLOCKS.register(bus);
        MysticBiomes.BIOMES.register(bus);
        MysticItems.ITEMS.register(bus);
        MysticTab.CREATIVE_TABS.register(bus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(MysticVanillaCompat.Common::registerFlammables);
    }

    private void clientSetup(final FMLClientSetupEvent event) {

    }

}