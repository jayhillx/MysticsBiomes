package com.meepshadow.mysticsbiomes.init;

import com.meepshadow.mysticsbiomes.common.biome.overworld.*;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = "mysticsbiomes", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBiome {
    @SuppressWarnings("deprecation")
    public static final DeferredRegister<Biome> BIOMES =  new DeferredRegister<>(ForgeRegistries.BIOMES, "mysticsbiomes");

    public static final RegistryObject<Biome> BLOSSOM_FOREST = BIOMES.register("blossom_forest", BlossomForestBiome::new);
    public static final RegistryObject<Biome> STRAWBERRY_FIELDS = BIOMES.register("strawberry_fields", StrawberryFieldsBiome::new);
    public static final RegistryObject<Biome> LAVENDER_MEADOW = BIOMES.register("lavender_meadow", LavenderMeadowBiome::new);
    public static final RegistryObject<Biome> DANDELION_MEADOW = BIOMES.register("dandelion_meadow", DandelionMeadowBiome::new);
    public static final RegistryObject<Biome> TROPICS = BIOMES.register("tropics", TropicsBiome::new);

    public static void registerBiomesToDictionary() {
        BiomeDictionary.addTypes(BLOSSOM_FOREST.get(), BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(BLOSSOM_FOREST.get(), 2));
        BiomeDictionary.addTypes(STRAWBERRY_FIELDS.get(), BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.OVERWORLD);
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(STRAWBERRY_FIELDS.get(), 2));
        BiomeDictionary.addTypes(LAVENDER_MEADOW.get(), BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(LAVENDER_MEADOW.get(), 2));
        BiomeDictionary.addTypes(DANDELION_MEADOW.get(), BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(DANDELION_MEADOW.get(), 2));
        BiomeDictionary.addTypes(TROPICS.get(), BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.OVERWORLD);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(TROPICS.get(), 2));

    }
}
