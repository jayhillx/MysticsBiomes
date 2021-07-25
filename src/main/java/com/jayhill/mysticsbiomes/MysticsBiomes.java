package com.jayhill.mysticsbiomes;

import com.jayhill.mysticsbiomes.core.RegisterClient;
import com.jayhill.mysticsbiomes.core.RegisterCommon;
import com.jayhill.mysticsbiomes.init.*;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("mysticsbiomes")
public class MysticsBiomes {
    public static final String MOD_ID = "mysticsbiomes";

    public MysticsBiomes() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> eventBus.addListener(this::clientSetup));
        eventBus.addListener(EventPriority.LOWEST, this::commonSetup);

        MysticBiomes.BIOMES.register(eventBus);
        MysticBlocks.BLOCKS.register(eventBus);
        MysticItems.ITEMS.register(eventBus);
        MysticEntities.ENTITIES.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    /** Common */
    private void commonSetup(final FMLCommonSetupEvent event) {
        RegisterCommon.registerCompostables();
        RegisterCommon.registerFlammables();

        MysticBiomes.registerBiomes(event);

        MysticFeatures.registerFeatures();
        MysticEntities.registerEntities();
        MysticEntities.registerEntitySpawns();
    }

    /** Client */
    private void clientSetup(final FMLClientSetupEvent event) {
        RegisterClient.registerRenderLayers();

        MysticEntities.setupEntitiesClient();
    }

    public static final ItemGroup TAB = new ItemGroup("mysticsBiomes") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(MysticItems.SWEET_STRAWBERRIES.get());
        }
    };

}