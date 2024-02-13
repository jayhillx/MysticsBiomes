package com.mysticsbiomes.common.item;

import com.mysticsbiomes.init.MysticItems;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class MysticBlockItem extends BlockItem {

    public MysticBlockItem(Supplier<Block> block) {
        super(block.get(), new Properties().tab(TAB));
    }

    public static final CreativeModeTab TAB = new CreativeModeTab("itemGroup.mysticsbiomes.tab") {
        @Override
        @Nonnull
        public ItemStack makeIcon() {
            return Items.LILAC.getDefaultInstance();
        }

        @Override
        public void fillItemList(@Nonnull NonNullList<ItemStack> stacks) {
            stacks.add(itemStack(MysticItems.STRAWBERRY_BLOSSOMS));
            stacks.add(itemStack(MysticItems.STRAWBERRY_SAPLING));
            stacks.add(itemStack(MysticItems.STRAWBERRY_LOG));
            stacks.add(itemStack(MysticItems.STRIPPED_STRAWBERRY_LOG));
            stacks.add(itemStack(MysticItems.STRAWBERRY_WOOD));
            stacks.add(itemStack(MysticItems.STRIPPED_STRAWBERRY_WOOD));
            stacks.add(itemStack(MysticItems.STRAWBERRY_PLANKS));
            stacks.add(itemStack(MysticItems.STRAWBERRY_STAIRS));
            stacks.add(itemStack(MysticItems.STRAWBERRY_SLAB));
            stacks.add(itemStack(MysticItems.STRAWBERRY_FENCE));
            stacks.add(itemStack(MysticItems.STRAWBERRY_FENCE_GATE));
            stacks.add(itemStack(MysticItems.STRAWBERRY_BUTTON));
            stacks.add(itemStack(MysticItems.STRAWBERRY_PRESSURE_PLATE));
            stacks.add(itemStack(MysticItems.STRAWBERRY_TRAPDOOR));
            stacks.add(itemStack(MysticItems.STRAWBERRY_DOOR));
            stacks.add(itemStack(MysticItems.STRAWBERRY_SIGN));
            stacks.add(itemStack(MysticItems.STRAWBERRY_BOAT));

            stacks.add(itemStack(MysticItems.PINK_CHERRY_BLOSSOMS));
            stacks.add(itemStack(MysticItems.PINK_CHERRY_BLOSSOM_SAPLING));
            stacks.add(itemStack(MysticItems.WHITE_CHERRY_BLOSSOMS));
            stacks.add(itemStack(MysticItems.WHITE_CHERRY_BLOSSOM_SAPLING));
            stacks.add(itemStack(MysticItems.CHERRY_LOG));
            stacks.add(itemStack(MysticItems.STRIPPED_CHERRY_LOG));
            stacks.add(itemStack(MysticItems.CHERRY_WOOD));
            stacks.add(itemStack(MysticItems.STRIPPED_CHERRY_WOOD));
            stacks.add(itemStack(MysticItems.CHERRY_PLANKS));
            stacks.add(itemStack(MysticItems.CHERRY_STAIRS));
            stacks.add(itemStack(MysticItems.CHERRY_SLAB));
            stacks.add(itemStack(MysticItems.CHERRY_FENCE));
            stacks.add(itemStack(MysticItems.CHERRY_FENCE_GATE));
            stacks.add(itemStack(MysticItems.CHERRY_BUTTON));
            stacks.add(itemStack(MysticItems.CHERRY_PRESSURE_PLATE));
            stacks.add(itemStack(MysticItems.CHERRY_TRAPDOOR));
            stacks.add(itemStack(MysticItems.CHERRY_DOOR));
            stacks.add(itemStack(MysticItems.CHERRY_SIGN));
            stacks.add(itemStack(MysticItems.CHERRY_BOAT));

            stacks.add(itemStack(MysticItems.MAPLE_LEAVES));
            stacks.add(itemStack(MysticItems.MAPLE_LEAF_PILE));
            stacks.add(itemStack(MysticItems.MAPLE_SAPLING));
            stacks.add(itemStack(MysticItems.ORANGE_MAPLE_LEAVES));
            stacks.add(itemStack(MysticItems.ORANGE_MAPLE_LEAF_PILE));
            stacks.add(itemStack(MysticItems.ORANGE_MAPLE_SAPLING));
            stacks.add(itemStack(MysticItems.YELLOW_MAPLE_LEAVES));
            stacks.add(itemStack(MysticItems.YELLOW_MAPLE_LEAF_PILE));
            stacks.add(itemStack(MysticItems.YELLOW_MAPLE_SAPLING));
            stacks.add(itemStack(MysticItems.MAPLE_LOG));
            stacks.add(itemStack(MysticItems.WHITE_MAPLE_LOG));
            stacks.add(itemStack(MysticItems.STRIPPED_MAPLE_LOG));
            stacks.add(itemStack(MysticItems.MAPLE_WOOD));
            stacks.add(itemStack(MysticItems.WHITE_MAPLE_WOOD));
            stacks.add(itemStack(MysticItems.STRIPPED_MAPLE_WOOD));
            stacks.add(itemStack(MysticItems.MAPLE_PLANKS));
            stacks.add(itemStack(MysticItems.MAPLE_STAIRS));
            stacks.add(itemStack(MysticItems.MAPLE_SLAB));
            stacks.add(itemStack(MysticItems.MAPLE_FENCE));
            stacks.add(itemStack(MysticItems.MAPLE_FENCE_GATE));
            stacks.add(itemStack(MysticItems.MAPLE_BUTTON));
            stacks.add(itemStack(MysticItems.MAPLE_PRESSURE_PLATE));
            stacks.add(itemStack(MysticItems.MAPLE_TRAPDOOR));
            stacks.add(itemStack(MysticItems.MAPLE_DOOR));
            stacks.add(itemStack(MysticItems.MAPLE_SIGN));
            stacks.add(itemStack(MysticItems.MAPLE_BOAT));

            stacks.add(itemStack(MysticItems.JACARANDA_BLOSSOMS));
            stacks.add(itemStack(MysticItems.JACARANDA_LEAVES));
            stacks.add(itemStack(MysticItems.JACARANDA_SAPLING));
            stacks.add(itemStack(MysticItems.JACARANDA_LOG));
            stacks.add(itemStack(MysticItems.STRIPPED_JACARANDA_LOG));
            stacks.add(itemStack(MysticItems.JACARANDA_WOOD));
            stacks.add(itemStack(MysticItems.STRIPPED_JACARANDA_WOOD));
            stacks.add(itemStack(MysticItems.JACARANDA_PLANKS));
            stacks.add(itemStack(MysticItems.JACARANDA_STAIRS));
            stacks.add(itemStack(MysticItems.JACARANDA_SLAB));
            stacks.add(itemStack(MysticItems.JACARANDA_FENCE));
            stacks.add(itemStack(MysticItems.JACARANDA_FENCE_GATE));
            stacks.add(itemStack(MysticItems.JACARANDA_BUTTON));
            stacks.add(itemStack(MysticItems.JACARANDA_PRESSURE_PLATE));
            stacks.add(itemStack(MysticItems.JACARANDA_TRAPDOOR));
            stacks.add(itemStack(MysticItems.JACARANDA_DOOR));
            stacks.add(itemStack(MysticItems.JACARANDA_SIGN));
            stacks.add(itemStack(MysticItems.JACARANDA_BOAT));

            stacks.add(itemStack(MysticItems.SPRING_BAMBOO));

            stacks.add(itemStack(MysticItems.BUDDING_PEONY_LEAVES));
            stacks.add(itemStack(MysticItems.PEONY_LEAVES));
            stacks.add(itemStack(MysticItems.PEONY_BUSH));
            stacks.add(itemStack(MysticItems.LAVENDER));

            stacks.add(itemStack(MysticItems.BUTTERFLY_NEST));

            stacks.add(itemStack(MysticItems.GLASS_JAR));
            stacks.add(itemStack(MysticItems.ORANGE_BUTTERFLY_JAR));
            stacks.add(itemStack(MysticItems.BLUE_BUTTERFLY_JAR));
            stacks.add(itemStack(MysticItems.CYAN_BUTTERFLY_JAR));
            stacks.add(itemStack(MysticItems.LILAC_BUTTERFLY_JAR));
            stacks.add(itemStack(MysticItems.PINK_BUTTERFLY_JAR));
            stacks.add(itemStack(MysticItems.PURPLE_BUTTERFLY_JAR));
            stacks.add(itemStack(MysticItems.WHITE_BUTTERFLY_JAR));

            stacks.add(itemStack(MysticItems.STRAWBERRY));
            stacks.add(itemStack(MysticItems.SWEET_STRAWBERRY));
            stacks.add(itemStack(MysticItems.STRAWBERRY_CAKE));
            stacks.add(itemStack(MysticItems.PINK_FROSTED_CAKE));
            stacks.add(itemStack(MysticItems.ORANGE_FROSTED_CAKE));
            stacks.add(itemStack(MysticItems.YELLOW_FROSTED_CAKE));
            stacks.add(itemStack(MysticItems.LIME_FROSTED_CAKE));
            stacks.add(itemStack(MysticItems.CYAN_FROSTED_CAKE));
            stacks.add(itemStack(MysticItems.PURPLE_FROSTED_CAKE));
            stacks.add(itemStack(MysticItems.PUMPKIN_COOKIE));
            stacks.add(itemStack(MysticItems.PUMPKIN_ICE_CREAM));
            stacks.add(itemStack(MysticItems.STRAWBERRY_ICE_CREAM));
            stacks.add(itemStack(MysticItems.STRAWBERRY_MILK_BUCKET));

            stacks.add(itemStack(MysticItems.PINK_EGG));
            stacks.add(itemStack(MysticItems.ORANGE_EGG));
            stacks.add(itemStack(MysticItems.YELLOW_EGG));
            stacks.add(itemStack(MysticItems.LIME_EGG));
            stacks.add(itemStack(MysticItems.CYAN_EGG));
            stacks.add(itemStack(MysticItems.PURPLE_EGG));

            stacks.add(itemStack(MysticItems.STRAWBERRY_COW_SPAWN_EGG));
            stacks.add(itemStack(MysticItems.RAINBOW_CHICKEN_SPAWN_EGG));
            stacks.add(itemStack(MysticItems.RED_PANDA_SPAWN_EGG));
            stacks.add(itemStack(MysticItems.BUTTERFLY_SPAWN_EGG));
        }
    };

    private static ItemStack itemStack(Supplier<Item> supplier) {
        return supplier.get().getDefaultInstance();
    }
    
}