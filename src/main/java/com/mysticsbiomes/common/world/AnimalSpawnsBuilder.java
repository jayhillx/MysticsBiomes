package com.mysticsbiomes.common.world;

import com.mysticsbiomes.init.MysticConfig;
import com.mysticsbiomes.init.MysticEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class AnimalSpawnsBuilder {

    public static void addBiomeSpawns() {
        BiomeModifications.addSpawn(context -> {
            RegistryKey<Biome> biomeKey = context.getBiomeRegistryEntry().getKey().orElseThrow();

            for (String biomeIdentifier : MysticConfig.INSTANCE.rainbowChickenBiomeSpawns) {
                Identifier biomeLocation = Identifier.tryParse(biomeIdentifier);
                if (biomeLocation != null && (biomeKey.getValue().equals(biomeLocation) || isBiomeTag(biomeLocation))) {
                    return true;
                }
            }
            return false;
        }, SpawnGroup.CREATURE, MysticEntities.RAINBOW_CHICKEN, MysticConfig.INSTANCE.rainbowChickenSpawnChance, 2, 3);
    }

    private static boolean isBiomeTag(Identifier location) {
        return location != null && location.getPath().startsWith("tag/biomes");
    }

}