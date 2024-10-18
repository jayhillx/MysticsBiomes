package com.mysticsbiomes.init;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysticsbiomes.MysticsBiomes;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MysticConfig {
    public static final MysticConfig INSTANCE = new MysticConfig();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final File CONFIG_FILE = new File(FabricLoader.getInstance().getConfigDir().toFile(), "mysticsbiomes-common.json");

    public int biomeRegionWeight = 4;
    public boolean enableStrawberryFields = true;
    public boolean enableLavenderMeadow = true;
    public boolean enableBambooBlossomForest = true;
    public boolean enableAutumnalGrove = true;
    public boolean enableLushOasis = true;
    public boolean enableLagoon = true;
    public boolean enableTropics = true;
    public List<String> rainbowChickenBiomeSpawns = Arrays.asList("minecraft:plains", "minecraft:forest", "minecraft:flower_forest");
    public int rainbowChickenSpawnChance = 6;

    public static void load() {
        if (CONFIG_FILE.exists()) {
            try (FileReader reader = new FileReader(CONFIG_FILE)) {
                MysticConfig config = GSON.fromJson(reader, MysticConfig.class);
                if (config != null) {
                    INSTANCE.biomeRegionWeight = config.biomeRegionWeight;
                    INSTANCE.enableStrawberryFields = config.enableStrawberryFields;
                    INSTANCE.enableLavenderMeadow = config.enableLavenderMeadow;
                    INSTANCE.enableBambooBlossomForest = config.enableBambooBlossomForest;
                    INSTANCE.enableAutumnalGrove = config.enableAutumnalGrove;
                    INSTANCE.enableLushOasis = config.enableLushOasis;
                    INSTANCE.enableLagoon = config.enableLagoon;
                    INSTANCE.enableTropics = config.enableTropics;
                    INSTANCE.rainbowChickenBiomeSpawns = config.rainbowChickenBiomeSpawns;
                    INSTANCE.rainbowChickenSpawnChance = config.rainbowChickenSpawnChance;
                }
            } catch (IOException e) {
                MysticsBiomes.LOGGER.error("Failed to load config", e);
            }
        } else {
            save();
        }
    }

    public static void save() {
        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            GSON.toJson(INSTANCE, writer);
        } catch (IOException e) {
            MysticsBiomes.LOGGER.error("Failed to save config", e);
        }
    }

}