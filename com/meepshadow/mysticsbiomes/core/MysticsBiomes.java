package com.meepshadow.mysticsbiomes.core;

import com.meepshadow.mysticsbiomes.init.ModBiome;
import com.meepshadow.mysticsbiomes.init.ModBlock;
import com.meepshadow.mysticsbiomes.init.ModItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("mysticsbiomes")
public class MysticsBiomes
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "mysticsbiomes";

    public MysticsBiomes() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        ModBlock.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModItem.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        ModBiome.BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) { }

    private void doClientStuff(final FMLClientSetupEvent event) { }

    public static final ItemGroup TAB = new ItemGroup("mysticsbiomesTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItem.STRAWBERRY.get());
        }
    };
}
