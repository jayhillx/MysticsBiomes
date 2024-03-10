package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MysticTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MysticsBiomes.modId);

    public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_TABS.register("tab", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.mysticsbiomes.tab")).icon(Items.LILAC::getDefaultInstance).displayItems((parameters, output) -> {
        output.accept(MysticItems.STRAWBERRY_BLOSSOMS.get());
        output.accept(MysticItems.STRAWBERRY_SAPLING.get());
        output.accept(MysticItems.STRAWBERRY_LOG.get());
        output.accept(MysticItems.STRIPPED_STRAWBERRY_LOG.get());
        output.accept(MysticItems.STRAWBERRY_WOOD.get());
        output.accept(MysticItems.STRIPPED_STRAWBERRY_WOOD.get());
        output.accept(MysticItems.STRAWBERRY_PLANKS.get());
        output.accept(MysticItems.STRAWBERRY_STAIRS.get());
        output.accept(MysticItems.STRAWBERRY_SLAB.get());
        output.accept(MysticItems.STRAWBERRY_FENCE.get());
        output.accept(MysticItems.STRAWBERRY_FENCE_GATE.get());
        output.accept(MysticItems.STRAWBERRY_BUTTON.get());
        output.accept(MysticItems.STRAWBERRY_PRESSURE_PLATE.get());
        output.accept(MysticItems.STRAWBERRY_TRAPDOOR.get());
        output.accept(MysticItems.STRAWBERRY_DOOR.get());
        output.accept(MysticItems.STRAWBERRY_SIGN.get());
        output.accept(MysticItems.STRAWBERRY_HANGING_SIGN.get());
        output.accept(MysticItems.STRAWBERRY_BOAT.get());
        output.accept(MysticItems.STRAWBERRY_CHEST_BOAT.get());

        output.accept(MysticItems.PINK_CHERRY_BLOSSOMS.get());
        output.accept(MysticItems.PINK_CHERRY_BLOSSOM_SAPLING.get());
        output.accept(MysticItems.WHITE_CHERRY_BLOSSOMS.get());
        output.accept(MysticItems.WHITE_CHERRY_BLOSSOM_SAPLING.get());
        output.accept(MysticItems.CHERRY_LOG.get());
        output.accept(MysticItems.STRIPPED_CHERRY_LOG.get());
        output.accept(MysticItems.CHERRY_WOOD.get());
        output.accept(MysticItems.STRIPPED_CHERRY_WOOD.get());
        output.accept(MysticItems.CHERRY_PLANKS.get());
        output.accept(MysticItems.CHERRY_STAIRS.get());
        output.accept(MysticItems.CHERRY_SLAB.get());
        output.accept(MysticItems.CHERRY_FENCE.get());
        output.accept(MysticItems.CHERRY_FENCE_GATE.get());
        output.accept(MysticItems.CHERRY_BUTTON.get());
        output.accept(MysticItems.CHERRY_PRESSURE_PLATE.get());
        output.accept(MysticItems.CHERRY_TRAPDOOR.get());
        output.accept(MysticItems.CHERRY_DOOR.get());
        output.accept(MysticItems.CHERRY_SIGN.get());
        output.accept(MysticItems.CHERRY_HANGING_SIGN.get());
        output.accept(MysticItems.CHERRY_BOAT.get());
        output.accept(MysticItems.CHERRY_CHEST_BOAT.get());

        output.accept(MysticItems.LUSH_SAND.get());
        output.accept(MysticItems.PINK_LUSH_SAND.get());

        output.accept(MysticItems.MAPLE_LEAVES.get());
        output.accept(MysticItems.MAPLE_LEAF_PILE.get());
        output.accept(MysticItems.MAPLE_SAPLING.get());
        output.accept(MysticItems.ORANGE_MAPLE_LEAVES.get());
        output.accept(MysticItems.ORANGE_MAPLE_LEAF_PILE.get());
        output.accept(MysticItems.ORANGE_MAPLE_SAPLING.get());
        output.accept(MysticItems.YELLOW_MAPLE_LEAVES.get());
        output.accept(MysticItems.YELLOW_MAPLE_LEAF_PILE.get());
        output.accept(MysticItems.YELLOW_MAPLE_SAPLING.get());
        output.accept(MysticItems.MAPLE_LOG.get());
        output.accept(MysticItems.WHITE_MAPLE_LOG.get());
        output.accept(MysticItems.STRIPPED_MAPLE_LOG.get());
        output.accept(MysticItems.MAPLE_WOOD.get());
        output.accept(MysticItems.WHITE_MAPLE_WOOD.get());
        output.accept(MysticItems.STRIPPED_MAPLE_WOOD.get());
        output.accept(MysticItems.MAPLE_PLANKS.get());
        output.accept(MysticItems.MAPLE_STAIRS.get());
        output.accept(MysticItems.MAPLE_SLAB.get());
        output.accept(MysticItems.MAPLE_FENCE.get());
        output.accept(MysticItems.MAPLE_FENCE_GATE.get());
        output.accept(MysticItems.MAPLE_BUTTON.get());
        output.accept(MysticItems.MAPLE_PRESSURE_PLATE.get());
        output.accept(MysticItems.MAPLE_TRAPDOOR.get());
        output.accept(MysticItems.MAPLE_DOOR.get());
        output.accept(MysticItems.MAPLE_SIGN.get());
        output.accept(MysticItems.MAPLE_HANGING_SIGN.get());
        output.accept(MysticItems.MAPLE_BOAT.get());
        output.accept(MysticItems.MAPLE_CHEST_BOAT.get());

        output.accept(MysticItems.JACARANDA_BLOSSOMS.get());
        output.accept(MysticItems.JACARANDA_LEAVES.get());
        output.accept(MysticItems.JACARANDA_SAPLING.get());
        output.accept(MysticItems.JACARANDA_LOG.get());
        output.accept(MysticItems.STRIPPED_JACARANDA_LOG.get());
        output.accept(MysticItems.JACARANDA_WOOD.get());
        output.accept(MysticItems.STRIPPED_JACARANDA_WOOD.get());
        output.accept(MysticItems.JACARANDA_PLANKS.get());
        output.accept(MysticItems.JACARANDA_STAIRS.get());
        output.accept(MysticItems.JACARANDA_SLAB.get());
        output.accept(MysticItems.JACARANDA_FENCE.get());
        output.accept(MysticItems.JACARANDA_FENCE_GATE.get());
        output.accept(MysticItems.JACARANDA_BUTTON.get());
        output.accept(MysticItems.JACARANDA_PRESSURE_PLATE.get());
        output.accept(MysticItems.JACARANDA_TRAPDOOR.get());
        output.accept(MysticItems.JACARANDA_DOOR.get());
        output.accept(MysticItems.JACARANDA_SIGN.get());
        output.accept(MysticItems.JACARANDA_HANGING_SIGN.get());
        output.accept(MysticItems.JACARANDA_BOAT.get());
        output.accept(MysticItems.JACARANDA_CHEST_BOAT.get());

        output.accept(MysticItems.BUTTERFLY_NEST.get());

        output.accept(MysticItems.SPRING_BAMBOO.get());
        output.accept(MysticItems.BUDDING_PEONY_LEAVES.get());
        output.accept(MysticItems.PEONY_LEAVES.get());
        output.accept(MysticItems.LAVENDER.get());
        output.accept(MysticItems.WILDFLOWER.get());

        output.accept(MysticItems.GLASS_JAR.get());
        output.accept(MysticItems.ORANGE_BUTTERFLY_IN_JAR.get());
        output.accept(MysticItems.BLUE_BUTTERFLY_IN_JAR.get());
        output.accept(MysticItems.CYAN_BUTTERFLY_IN_JAR.get());
        output.accept(MysticItems.LILAC_BUTTERFLY_IN_JAR.get());
        output.accept(MysticItems.PINK_BUTTERFLY_IN_JAR.get());
        output.accept(MysticItems.PURPLE_BUTTERFLY_IN_JAR.get());

        output.accept(MysticItems.STRAWBERRY.get());
        output.accept(MysticItems.SWEET_STRAWBERRY.get());
        output.accept(MysticItems.STRAWBERRY_CAKE.get());
        output.accept(MysticItems.PINK_FROSTED_CAKE.get());
        output.accept(MysticItems.ORANGE_FROSTED_CAKE.get());
        output.accept(MysticItems.YELLOW_FROSTED_CAKE.get());
        output.accept(MysticItems.LIME_FROSTED_CAKE.get());
        output.accept(MysticItems.CYAN_FROSTED_CAKE.get());
        output.accept(MysticItems.PURPLE_FROSTED_CAKE.get());
        output.accept(MysticItems.PUMPKIN_COOKIE.get());
        output.accept(MysticItems.PUMPKIN_ICE_CREAM.get());
        output.accept(MysticItems.STRAWBERRY_ICE_CREAM.get());
        output.accept(MysticItems.STRAWBERRY_MILK_BUCKET.get());
        output.accept(MysticItems.PINK_EGG.get());
        output.accept(MysticItems.ORANGE_EGG.get());
        output.accept(MysticItems.YELLOW_EGG.get());
        output.accept(MysticItems.LIME_EGG.get());
        output.accept(MysticItems.CYAN_EGG.get());
        output.accept(MysticItems.PURPLE_EGG.get());

        output.accept(MysticItems.STRAWBERRY_COW_SPAWN_EGG.get());
        output.accept(MysticItems.RAINBOW_CHICKEN_SPAWN_EGG.get());
        output.accept(MysticItems.RED_PANDA_SPAWN_EGG.get());
        output.accept(MysticItems.BUTTERFLY_SPAWN_EGG.get());
    }).build());

}