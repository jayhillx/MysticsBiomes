package com.jayhill.mysticsbiomes.init;

import com.jayhill.mysticsbiomes.MysticsBiomes;
import com.jayhill.mysticsbiomes.common.biome.overworld.StrawberryFieldsBiome;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.*;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class MysticBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, MysticsBiomes.MOD_ID);

    /** Biomes */
    public static final RegistryObject<Biome> STRAWBERRY_FIELDS = BIOMES.register("strawberry_fields", StrawberryFieldsBiome::makeStrawberryFieldsBiome);

    @SubscribeEvent
    public static void registerBiomes(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            setupBiome(STRAWBERRY_FIELDS.get(), BiomeManager.BiomeType.WARM, 3, Type.HOT, Type.PLAINS, Type.OVERWORLD);
        });
    }

    private static void setupBiome(final Biome biome, final BiomeManager.BiomeType biomeType, final int weight, final Type... types) {
        BiomeDictionary.addTypes(key(biome), types);
        BiomeManager.addBiome(biomeType, new BiomeManager.BiomeEntry(key(biome), weight));
    }

    private static RegistryKey<Biome> key(final Biome biome) {
        return RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome), "Biome registry name was null"));
    }

}