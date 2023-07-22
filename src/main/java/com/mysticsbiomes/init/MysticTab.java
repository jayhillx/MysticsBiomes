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

    public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_TABS.register("tab", MysticTab::tab);

    private static CreativeModeTab tab() {
        return CreativeModeTab.builder().title(Component.translatable("itemGroup.mysticsbiomes.tab")).icon(Items.LILAC::getDefaultInstance).displayItems((parameters, output) -> {
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

            output.accept(MysticItems.BUDDING_PEONY_LEAVES.get());
            output.accept(MysticItems.PEONY_LEAVES.get());
            output.accept(MysticItems.PEONY_BUSH.get());

            output.accept(MysticItems.LAVENDER.get());

            // items
            output.accept(MysticItems.STRAWBERRY.get());
            output.accept(MysticItems.SWEET_STRAWBERRY.get());
            output.accept(MysticItems.STRAWBERRY_CAKE.get());
            //output.accept(MysticItems.STRAWBERRY_ICE_CREAM.get());
            output.accept(MysticItems.STRAWBERRY_MILK_BUCKET.get());
            output.accept(MysticItems.STRAWBERRY_COW_SPAWN_EGG.get());
            output.accept(MysticItems.RED_PANDA_SPAWN_EGG.get());
        }).build();
    }

}