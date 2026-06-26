package com.mysticsbiomes.forge;

import com.google.common.collect.Sets;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.datagen.provider.MysticBlockLoot;
import com.mysticsbiomes.datagen.provider.tag.MysticBlockTags;
import com.mysticsbiomes.datagen.provider.tag.MysticItemTags;
import com.mysticsbiomes.forge.registry.ForgeRegistryHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod(MysticsBiomes.modId)
public class MysticsBiomesForge {

    public MysticsBiomesForge(FMLJavaModLoadingContext context) {
        IEventBus bus = context.getModEventBus();
        bus.addListener(this::commonSetup);
        bus.addListener(this::gatherData);

        MysticsBiomes.REGISTRY = new ForgeRegistryHelper(MysticsBiomes.modId);
        MysticsBiomes.init();
        ((ForgeRegistryHelper)MysticsBiomes.REGISTRY).attachToModEventBus(bus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            MysticsBiomes.setupTerraBlender();
        });
    }

    private void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();

        ///RegistrySetBuilder builder = new RegistrySetBuilder();
        ///generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(output, provider, builder, Set.of(MysticsBiomes.modId)));

        MysticBlockTags blockTags = new MysticBlockTags(output, provider);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new MysticItemTags(output, provider, blockTags.contentsGetter()));

        ///ExistingFileHelper debugHelper = new ExistingFileHelper(Set.of(), Set.of(), false, null, null);
        ///generator.addProvider(event.includeClient(), new MysticBlockModels(output, debugHelper));
        ///generator.addProvider(event.includeClient(), new MysticItemModels(output, debugHelper));
    }

}