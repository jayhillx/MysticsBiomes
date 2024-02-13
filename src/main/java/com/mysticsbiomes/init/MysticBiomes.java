package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.biome.MysticBiomeProvider;
import com.mysticsbiomes.common.biome.OverworldBiomes;
import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import terrablender.api.Regions;

public class MysticBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(Registry.BIOME_REGISTRY, MysticsBiomes.modId);

    public static final RegistryObject<Biome> STRAWBERRY_FIELDS = BIOMES.register("strawberry_fields", OverworldBiomes::strawberryFields);
    public static final RegistryObject<Biome> BAMBOO_BLOSSOM_FOREST = BIOMES.register("bamboo_blossom_forest", OverworldBiomes::bambooBlossomForest);
    public static final RegistryObject<Biome> LAVENDER_MEADOW = BIOMES.register("lavender_meadow", OverworldBiomes::lavenderMeadow);
    public static final RegistryObject<Biome> AUTUMNAL_GROVE = BIOMES.register("autumnal_grove", OverworldBiomes::autumnalGrove);

    public static void registerRegionProvider() {
        Regions.register(new MysticBiomeProvider(MysticConfig.COMMON.biomeRegionWeight.get()));
    }

}