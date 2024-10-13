package com.mysticsbiomes.common.world;

public class AnimalSpawnsBuilder {
    //private static final RegistryObject<Codec<? extends BiomeModifier>> SERIALIZER = RegistryObject.create(MysticsBiomes.modLoc("animal_spawns"), ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, MysticsBiomes.modId);
    //
    //public void modify(Holder<Biome> biome, Phase phase, ModifiableTestableWorld.Builder builder) {
    //    if (phase == Phase.ADD) {
    //        addAnimalSpawns(biome, builder);
    //    }
    //}
    //
    //public Codec<? extends BiomeModifier> codec() {
    //    return SERIALIZER.get();
    //}
    //
    //public static Codec<AnimalSpawnsBuilder> makeCodec() {
    //    return Codec.unit(AnimalSpawnsBuilder::new);
    //}
    //
    //public static void addAnimalSpawns(Holder<Biome> biome, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
    //    for (String biomeIdentifier : MysticConfig.COMMON.rainbowChickenBiomeSpawns.get()) {
    //        Identifier biomeLocation = Identifier.tryParse(biomeIdentifier);
    //
    //        if (biome.is(biomeLocation) || isBiomeTag(biomeLocation)) {
    //            builder.getMobSpawnSettings().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(MysticEntities.RAINBOW_CHICKEN.get(), MysticConfig.COMMON.rainbowChickenSpawnChance.get(), 2, 3));
    //        }
    //    }
    //}
    //
    //private static boolean isBiomeTag(Identifier location) {
    //    return location != null && location.getPath().startsWith("tag/biomes");
    //}

}