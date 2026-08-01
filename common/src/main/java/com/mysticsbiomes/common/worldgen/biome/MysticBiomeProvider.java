package com.mysticsbiomes.common.worldgen.biome;

import com.mojang.datafixers.util.Pair;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.config.MysticConfigs;
import com.mysticsbiomes.init.MysticBiomes;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MysticBiomeProvider extends Region {
    private static final ResourceLocation BIOME_LOCATION = MysticsBiomes.modLoc("overworld_provider");

    public MysticBiomeProvider(int weight) {
        super(BIOME_LOCATION, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        MysticConfigs config = MysticConfigs.INSTANCE;

        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
            if (config.enableStrawberryFields) {
                ResourceKey<Biome> biome = biomeOrDefault(registry, Biomes.SUNFLOWER_PLAINS, biomesFromConfig(config.strawberryFieldsBiomeSpawns));
                builder.replaceBiome(biome, MysticBiomes.STRAWBERRY_FIELDS);
            }

            if (config.enableLavenderMeadow) {
                ResourceKey<Biome> biome = biomeOrDefault(registry, Biomes.MEADOW, biomesFromConfig(config.lavenderMeadowBiomeSpawns));
                builder.replaceBiome(biome, MysticBiomes.LAVENDER_MEADOW);
            }

            if (config.enableBambooBlossomForest) {
                ResourceKey<Biome> biome = biomeOrDefault(registry, Biomes.SNOWY_TAIGA, biomesFromConfig(config.bambooBlossomForestBiomeSpawns));
                builder.replaceBiome(biome, MysticBiomes.BAMBOO_BLOSSOM_FOREST);
            }

            if (config.enableAutumnalGrove) {
                ResourceKey<Biome> biome = biomeOrDefault(registry, Biomes.TAIGA, biomesFromConfig(config.autumnalGroveBiomeSpawns));
                builder.replaceBiome(biome, MysticBiomes.AUTUMNAL_GROVE);
            }

            if (config.enableLushOasis) {
                ResourceKey<Biome> biome = biomeOrDefault(registry, Biomes.DESERT, biomesFromConfig(config.lushOasisBiomeSpawns));
                builder.replaceBiome(biome, MysticBiomes.LUSH_OASIS);
            }

            if (config.enableLagoon) {
                ResourceKey<Biome> biome = biomeOrDefault(registry, Biomes.BEACH, biomesFromConfig(config.lagoonBiomeSpawns));
                builder.replaceBiome(biome, MysticBiomes.LAGOON);
            }

            if (config.enableTropics) {
                ResourceKey<Biome> biome = biomeOrDefault(registry, Biomes.JUNGLE, biomesFromConfig(config.tropicsBiomeSpawns));
                builder.replaceBiome(biome, MysticBiomes.TROPICS);
            }
        });
    }

    public static ResourceKey<Biome> biomeOrDefault(Registry<Biome> registry, ResourceKey<Biome> defaultBiome, List<ResourceKey<Biome>> biomes) {
        for (ResourceKey<Biome> key : biomes) {
            if (key == null) continue;
            if (!registry.containsKey(key.location())) continue;

            if (MysticConfigs.isBiomeEnabled(key) || key.location().getNamespace().equals("minecraft")) {
                return key;
            }
        }

        return defaultBiome;
    }

    public static List<ResourceKey<Biome>> biomesFromConfig(List<String> biomes) {
        List<ResourceKey<Biome>> result = new ArrayList<>();
        if (biomes == null) return result;

        for (String id : biomes) {
            ResourceLocation location = ResourceLocation.tryParse(id);
            if (location != null) {
                result.add(ResourceKey.create(Registries.BIOME, location));
            }
        }

        return result;
    }

}