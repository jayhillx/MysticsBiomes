package com.mysticsbiomes.config;

import api.mystanica.config.ConfigBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MysticConfigs extends ConfigBuilder {
    public static MysticConfigs INSTANCE;

    public Integer biomeRegionWeight;
    public Boolean enableStrawberryFields;
    public Boolean enableLavenderMeadow;
    public Boolean enableBambooBlossomForest;
    public Boolean enableAutumnalGrove;
    public Boolean enableLushOasis;
    public Boolean enableLagoon;
    public Boolean enableTropics;
    public List<String> strawberryFieldsBiomeSpawns;
    public List<String> lavenderMeadowBiomeSpawns;
    public List<String> bambooBlossomForestBiomeSpawns;
    public List<String> autumnalGroveBiomeSpawns;
    public List<String> lushOasisBiomeSpawns;
    public List<String> lagoonBiomeSpawns;
    public List<String> tropicsBiomeSpawns;
    public List<String> rainbowChickenBiomeSpawns;
    public Integer rainbowChickenSpawnChance;

    public MysticConfigs(Path path) {
        super(path);
    }

    @Override
    public void load() {
        this.section("biomeGen");
        this.config.setComment("biomeGen", "The higher the number, the more common the biomes will be.");
        this.biomeRegionWeight = this.get("biomeGen.biomeRegionWeight", 6);

        this.section("biomeToggles");
        this.config.setComment("biomeToggles", "Determine if a biome will generate or not.");
        this.enableStrawberryFields = this.get("biomeToggles.strawberryFields", true);
        this.enableLavenderMeadow = this.get("biomeToggles.lavenderMeadow", true);
        this.enableBambooBlossomForest = this.get("biomeToggles.bambooBlossomForest", true);
        this.enableAutumnalGrove = this.get("biomeToggles.autumnalGrove", true);
        this.enableLushOasis = this.get("biomeToggles.lushOasis", true);
        this.enableLagoon = this.get("biomeToggles.lagoon", true);
        this.enableTropics = this.get("biomeToggles.tropics", true);

        this.section("biomeSpawns");
        this.config.setComment("biomeSpawns", "List of the biomes each biome can replace.");
        this.config.setComment("biomeSpawns", "Whatever biomes are listed, the given biome will have a chance to spawn in place of that biome.");
        this.config.setComment("biomeSpawns", "Values can include modded biomes and biome tags. (i.e. \"mysticsbiomes:strawberry_fields\")");
        this.strawberryFieldsBiomeSpawns = this.get("biomeSpawns.strawberryFieldsSpawns", biomes("minecraft:sunflower_plains"));
        this.lavenderMeadowBiomeSpawns = this.get("biomeSpawns.lavenderMeadowSpawns", biomes("minecraft:meadow"));
        this.bambooBlossomForestBiomeSpawns = this.get("biomeSpawns.bambooBlossomForestSpawns", biomes("minecraft:snowy_taiga"));
        this.autumnalGroveBiomeSpawns = this.get("biomeSpawns.autumnalGroveSpawns", biomes("minecraft:taiga"));
        this.lushOasisBiomeSpawns = this.get("biomeSpawns.lushOasisSpawns", biomes("minecraft:desert"));
        this.lagoonBiomeSpawns = this.get("biomeSpawns.lagoonSpawns", biomes("minecraft:beach"));
        this.tropicsBiomeSpawns = this.get("biomeSpawns.tropicsSpawns", biomes("minecraft:jungle"));

        this.section("animalSpawns");
        this.config.setComment("animalSpawns", "Biomes an animal can spawn in.");
        this.config.setComment("animalSpawns", "Values can include modded biomes and biome tags. (i.e. \"mysticsbiomes:strawberry_fields\")");
        this.rainbowChickenBiomeSpawns = this.get("animalSpawns.rainbowChickens", biomes("minecraft:plains", "minecraft:forest", "minecraft:flower_forest"));

        this.section("animalSpawnChances");
        this.config.setComment("animalSpawnChances", "The chance an animal will spawn.");
        this.config.setComment("animalSpawnChances", "The higher the number, the more common the animal will spawn.");
        this.rainbowChickenSpawnChance = this.get("animalSpawnChances.rainbowChicken", 22);
    }

    private static List<String> biomes(String... biomes) {
        return new ArrayList<>(Arrays.asList(biomes));
    }
    
    public static boolean isBiomeEnabled(ResourceKey<Biome> key) {
        if (key == null) return false;

        return switch (key.location().getPath()) {
            case "strawberry_fields" -> INSTANCE.enableStrawberryFields;
            case "lavender_meadow" -> INSTANCE.enableLavenderMeadow;
            case "bamboo_blossom_forest" -> INSTANCE.enableBambooBlossomForest;
            case "autumnal_grove" -> INSTANCE.enableAutumnalGrove;
            case "lush_oasis" -> INSTANCE.enableLushOasis;
            case "lagoon" -> INSTANCE.enableLagoon;
            case "tropics" -> INSTANCE.enableTropics;
            default -> true;
        };
    }

}