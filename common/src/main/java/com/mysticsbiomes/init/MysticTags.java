package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class MysticTags {

    public static class Blocks {
        public static final TagKey<Block> STRAWBERRY_LOGS = create("strawberry_logs");
        public static final TagKey<Block> BLACK_CHERRY_LOGS = create("black_cherry_logs");
        public static final TagKey<Block> LAVENDER_LOGS = create("lavender_logs");
        public static final TagKey<Block> VANILLA_LOGS = create("vanilla_logs");
        public static final TagKey<Block> PEACH_LOGS = create("peach_logs");
        public static final TagKey<Block> MAPLE_LOGS = create("maple_logs");
        public static final TagKey<Block> SPRING_LOGS = create("spring_logs");
        public static final TagKey<Block> SEA_FOAM_LOGS = create("sea_foam_logs");
        public static final TagKey<Block> TROPICAL_LOGS = create("tropical_logs");

        private static TagKey<Block> create(String name) {
            return TagKey.create(Registries.BLOCK, MysticsBiomes.modLoc(name));
        }
    }
    
    public static class Items {
        public static final TagKey<Item> STRAWBERRY_LOGS = create("strawberry_logs");
        public static final TagKey<Item> BLACK_CHERRY_LOGS = create("black_cherry_logs");
        public static final TagKey<Item> LAVENDER_LOGS = create("lavender_logs");
        public static final TagKey<Item> VANILLA_LOGS = create("vanilla_logs");
        public static final TagKey<Item> PEACH_LOGS = create("peach_logs");
        public static final TagKey<Item> MAPLE_LOGS = create("maple_logs");
        public static final TagKey<Item> SPRING_LOGS = create("spring_logs");
        public static final TagKey<Item> SEA_FOAM_LOGS = create("sea_foam_logs");
        public static final TagKey<Item> TROPICAL_LOGS = create("tropical_logs");

        private static TagKey<Item> create(String name) {
            return TagKey.create(Registries.ITEM, MysticsBiomes.modLoc(name));
        }
    }

}