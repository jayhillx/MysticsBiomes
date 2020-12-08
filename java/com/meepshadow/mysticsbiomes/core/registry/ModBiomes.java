package com.meepshadow.mysticsbiomes.core.registry;

import com.meepshadow.mysticsbiomes.common.biome.EtherealGrottoBiome;
import com.meepshadow.mysticsbiomes.common.biome.LavenderMeadowBiome;
import com.meepshadow.mysticsbiomes.common.biome.StrawberryFieldBiome;
import com.meepshadow.mysticsbiomes.core.Config;
import com.meepshadow.mysticsbiomes.core.MysticsBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = MysticsBiomes.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES =  new DeferredRegister<>(ForgeRegistries.BIOMES, MysticsBiomes.MOD_ID);

    public static final RegistryObject<Biome> STRAWBERRY_FIELD = BIOMES.register("strawberry_field", StrawberryFieldBiome::new);
    public static final RegistryObject<Biome> LAVENDER_MEADOW = BIOMES.register("lavender_meadow", LavenderMeadowBiome::new);
    public static final RegistryObject<Biome> ETHEREAL_GROTTO = BIOMES.register("ethereal_grotto", EtherealGrottoBiome::new);

    public static void setupBiomes() {
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(STRAWBERRY_FIELD.get(), Config.COMMON.strawberryFieldWeight.get()));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(LAVENDER_MEADOW.get(), Config.COMMON.lavenderMeadowWeight.get()));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(ETHEREAL_GROTTO.get(), Config.COMMON.lavenderMeadowWeight.get()));

        BiomeDictionary.addTypes(STRAWBERRY_FIELD.get(), BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(LAVENDER_MEADOW.get(), BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(ETHEREAL_GROTTO.get(), BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
    }
}
