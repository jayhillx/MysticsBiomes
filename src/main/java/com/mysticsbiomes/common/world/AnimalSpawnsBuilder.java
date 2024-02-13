package com.mysticsbiomes.common.world;

import com.mojang.serialization.Codec;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.init.MysticConfig;
import com.mysticsbiomes.init.MysticEntities;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AnimalSpawnsBuilder implements BiomeModifier {
    private static final RegistryObject<Codec<? extends BiomeModifier>> SERIALIZER = RegistryObject.create(MysticsBiomes.modLoc("animal_spawns"), ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, MysticsBiomes.modId);

    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase == Phase.ADD) {
            addAnimalSpawns(biome, builder);
        }
    }

    public Codec<? extends BiomeModifier> codec() {
        return SERIALIZER.get();
    }

    public static Codec<AnimalSpawnsBuilder> makeCodec() {
        return Codec.unit(AnimalSpawnsBuilder::new);
    }

    public static void addAnimalSpawns(Holder<Biome> biome, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        for (String biomeIdentifier : MysticConfig.COMMON.rainbowChickenBiomeSpawns.get()) {
            ResourceLocation biomeLocation = ResourceLocation.tryParse(biomeIdentifier);

            if (biome.is(biomeLocation) || isBiomeTag(biomeLocation)) {
                builder.getMobSpawnSettings().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(MysticEntities.RAINBOW_CHICKEN.get(), 6, 2, 3));
            }
        }
    }

    private static boolean isBiomeTag(ResourceLocation location) {
        return location != null && location.getPath().startsWith("tag/biomes");
    }

}