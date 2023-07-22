package com.mysticsbiomes;

import com.mysticsbiomes.common.block.state.MysticBlockTypes;
import com.mysticsbiomes.init.*;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
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

    /** @param <T> given registry, i.e. Registries.BIOMES. */
    public static <T> ResourceKey<T> createKey(ResourceKey<Registry<T>> registry, String name) {
        return ResourceKey.create(registry, modLoc(name));
    }

    public MysticsBiomes() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);

        MysticBlocks.BLOCKS.register(bus);
        MysticBlockEntities.BLOCK_ENTITIES.register(bus);
        MysticEntities.ENTITIES.register(bus);
        MysticItems.ITEMS.register(bus);
        MysticParticles.PARTICLES.register(bus);
        MysticTab.CREATIVE_TABS.register(bus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            MysticBiomes.registerRegionProvider();
            MysticVanillaCompat.Common.registerFlammables();
            MysticVanillaCompat.Common.registerCompostables();
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MysticVanillaCompat.Client.registerRenderLayers();
            MysticBlockTypes.Wood.registerWoodTypes();
        });
    }

}