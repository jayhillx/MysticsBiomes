package com.mysticsbiomes.common.biome;

import com.mojang.datafixers.util.Pair;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.init.MysticBiomes;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class MysticBiomeProvider extends Region {
    private static final Identifier BIOME_LOCATION = MysticsBiomes.modLoc("overworld_provider");

    public MysticBiomeProvider(int weight) {
        super(BIOME_LOCATION, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
            builder.replaceBiome(BiomeKeys.SUNFLOWER_PLAINS, MysticBiomes.STRAWBERRY_FIELDS);
            builder.replaceBiome(BiomeKeys.MEADOW, MysticBiomes.LAVENDER_MEADOW);
            builder.replaceBiome(BiomeKeys.SNOWY_PLAINS, MysticBiomes.BAMBOO_BLOSSOM_FOREST);
            builder.replaceBiome(BiomeKeys.TAIGA, MysticBiomes.AUTUMNAL_GROVE);
            builder.replaceBiome(BiomeKeys.DESERT, MysticBiomes.LUSH_OASIS);
            builder.replaceBiome(BiomeKeys.BEACH, MysticBiomes.LAGOON);
            builder.replaceBiome(BiomeKeys.JUNGLE, MysticBiomes.TROPICS);
        });
    }

}