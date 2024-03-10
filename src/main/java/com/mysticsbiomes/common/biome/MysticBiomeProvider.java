package com.mysticsbiomes.common.biome;

import com.mojang.datafixers.util.Pair;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.init.MysticBiomes;
import com.mysticsbiomes.init.MysticConfig;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class MysticBiomeProvider extends Region {
    private static final ResourceLocation BIOME_LOCATION = MysticsBiomes.modLoc("overworld_provider");

    public MysticBiomeProvider(int weight) {
        super(BIOME_LOCATION, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
            if (MysticConfig.COMMON.enableStrawberryFields.get()) {
                builder.replaceBiome(Biomes.SUNFLOWER_PLAINS, MysticBiomes.STRAWBERRY_FIELDS);
            }
            if (MysticConfig.COMMON.enableLavenderMeadow.get()) {
                builder.replaceBiome(Biomes.MEADOW, MysticBiomes.LAVENDER_MEADOW);
            }
            if (MysticConfig.COMMON.enableBambooBlossomForest.get()) {
                builder.replaceBiome(Biomes.SNOWY_PLAINS, MysticBiomes.BAMBOO_BLOSSOM_FOREST);
            }
            if (MysticConfig.COMMON.enableAutumnalGrove.get()) {
                builder.replaceBiome(Biomes.TAIGA, MysticBiomes.AUTUMNAL_GROVE);
            }

            builder.replaceBiome(Biomes.DESERT, MysticBiomes.LUSH_OASIS);
        });
    }

}