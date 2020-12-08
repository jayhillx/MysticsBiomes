package com.meepshadow.mysticsbiomes.core;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.Pair;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class Config
{
    public static class Common
    {
        public final ForgeConfigSpec.ConfigValue<List<String>> strawberryCowBiomes;
        public final ForgeConfigSpec.ConfigValue<Integer> strawberryFieldWeight;
        public final ForgeConfigSpec.ConfigValue<Integer> lavenderMeadowWeight;
        public final ForgeConfigSpec.ConfigValue<Integer> etherealGrottoWeight;

        Common(ForgeConfigSpec.Builder builder)
        {
            builder.push("Biomes");
            strawberryFieldWeight = builder
                    .comment("The higher the number, the more common the biome is.")
                    .define("Strawberry Field Weight", 3);
            lavenderMeadowWeight = builder
                    .define("Lavender Meadow Weight", 2);
            etherealGrottoWeight = builder
                    .define("Lavender Meadow Weight", 1);
            builder.pop();
            builder.push("Entities");
            strawberryCowBiomes = builder
                    .comment("A list of biomes where strawberry cows can spawn.")
                    .define("Strawberry Cow Spawn Biomes", Lists.newArrayList());
            builder.pop();
        }
    }

    static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static
    {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }
}
