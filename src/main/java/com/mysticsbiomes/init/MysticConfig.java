package com.mysticsbiomes.init;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MysticConfig {
    private static final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
    public static final ForgeConfigSpec COMMON_SPEC = specPair.getRight();
    public static final Common COMMON = specPair.getLeft();

    public static class Common {
        public final ForgeConfigSpec.ConfigValue<Integer> biomeRegionWeight;
        public final ForgeConfigSpec.ConfigValue<Boolean> enableStrawberryFields;
        public final ForgeConfigSpec.ConfigValue<Boolean> enableLavenderMeadow;
        public final ForgeConfigSpec.ConfigValue<Boolean> enableBambooBlossomForest;
        public final ForgeConfigSpec.ConfigValue<Boolean> enableAutumnalGrove;
        public final ForgeConfigSpec.ConfigValue<Boolean> enableLushOasis;

        public ForgeConfigSpec.ConfigValue<List<String>> rainbowChickenBiomeSpawns;
        public final ForgeConfigSpec.ConfigValue<Integer> rainbowChickenSpawnChance;

        Common(ForgeConfigSpec.Builder builder) {
            builder.comment("Mystic's Biomes", "Common Config Center");
            builder.push("World Gen");
            this.biomeRegionWeight = builder.comment("The higher the number, the more common the biomes will be.", "Default: 4").define("Biome Region Weight", 4);
            this.enableStrawberryFields = builder.comment("Determines if each biome will generate or not.").define("Strawberry Fields", true);
            this.enableLavenderMeadow = builder.define("Lavender Meadow", true);
            this.enableBambooBlossomForest = builder.define("Bamboo Blossom Forest", true);
            this.enableAutumnalGrove = builder.define("Autumnal Grove", true);
            this.enableLushOasis = builder.define("Lush Oasis", true);
            builder.pop();
            builder.push("Animal Spawns");
            this.rainbowChickenBiomeSpawns = builder.comment("Biomes an animal can spawn in.", "Values can include modded biomes and biome tags. example: \"mysticsbiomes:strawberry_fields\"").define("Rainbow Chickens", new ArrayList<>(Arrays.asList("minecraft:plains", "minecraft:forest", "minecraft:flower_forest")));
            this.rainbowChickenSpawnChance = builder.comment("The chance an animal will spawn.", "The higher the number, the more common an animal will spawn.", "Default: 6").define("Rainbow Chicken Spawn Chance", 6);
            builder.pop();
        }
    }

}