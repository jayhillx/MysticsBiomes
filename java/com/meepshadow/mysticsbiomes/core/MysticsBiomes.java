package com.meepshadow.mysticsbiomes.core;

import com.meepshadow.mysticsbiomes.core.other.VanillaCompatibility;
import com.meepshadow.mysticsbiomes.core.registry.ModBiomes;
import com.meepshadow.mysticsbiomes.core.registry.ModBlocks;
import com.meepshadow.mysticsbiomes.core.registry.ModEntities;
import com.meepshadow.mysticsbiomes.core.registry.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("mysticsbiomes")
public class MysticsBiomes
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "mysticsbiomes";

    public MysticsBiomes() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
            modEventBus.addListener(EventPriority.LOWEST, this::clientSetup);

        });
        modEventBus.addListener(EventPriority.LOWEST, this::commonSetup);

        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModEntities.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());

        ModBiomes.BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_SPEC);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        VanillaCompatibility.setupVanillaCompatibility();
        VanillaCompatibility.registerCompostables();
        ModBiomes.setupBiomes();
        for(Biome biome : ForgeRegistries.BIOMES.getValues())
        {
            ModEntities.setupEntitySpawns(biome);
        }
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        VanillaCompatibility.setupVanillaCompatibilityClient();
    }

    public static final ItemGroup TAB = new ItemGroup("mysticsbiomesTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.MB_ICON.get());
        }
    };
}
