package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MysticTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MysticsBiomes.modId);

    public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_TABS.register("tab", MysticTab::tab);

    private static CreativeModeTab tab() {
        return CreativeModeTab.builder().icon(Items.LILAC::getDefaultInstance).displayItems((parameters, output) -> {
            output.accept(MysticItems.STRAWBERRY_PLANKS.get());
        }).build();
    }

}