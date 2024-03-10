package com.mysticsbiomes;

import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import com.mysticsbiomes.common.block.state.MysticWoodTypes;
import com.mysticsbiomes.init.MysticConfig;
import com.mysticsbiomes.data.provider.MysticBlockStatesProvider;
import com.mysticsbiomes.common.world.AnimalSpawnsBuilder;
import com.mysticsbiomes.data.provider.MysticLootTablesProvider;
import com.mysticsbiomes.init.*;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Mod("mysticsbiomes")
public class MysticsBiomes {
    public static final String modId = "mysticsbiomes";

    public static ResourceLocation modLoc(String path) {
        return new ResourceLocation(modId, path);
    }

    public MysticsBiomes() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::dataSetup);
        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);

        MysticBlocks.BLOCKS.register(bus);
        MysticBlockEntities.BLOCK_ENTITIES.register(bus);
        MysticEntities.ENTITIES.register(bus);
        MysticFeatures.FEATURES.register(bus);
        MysticFeatures.TREE_DECORATORS.register(bus);
        MysticFeatures.TRUNK_PLACERS.register(bus);
        MysticItems.ITEMS.register(bus);
        MysticParticles.PARTICLES.register(bus);
        MysticPoiTypes.POI_TYPES.register(bus);
        MysticSounds.SOUNDS.register(bus);
        MysticTab.CREATIVE_TABS.register(bus);

        DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, MysticsBiomes.modId);
        BIOME_MODIFIERS.register(bus);
        BIOME_MODIFIERS.register("animal_spawns", AnimalSpawnsBuilder::makeCodec);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MysticConfig.COMMON_SPEC);
    }

    private void dataSetup(final GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();

        RegistrySetBuilder builder = new RegistrySetBuilder();
        builder.add(Registries.CONFIGURED_FEATURE, MysticFeatures.Configured::bootstrap);
        builder.add(Registries.PLACED_FEATURE, MysticFeatures.Placed::bootstrap);
        builder.add(Registries.BIOME, MysticBiomes::bootstrap);
        generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(output, event.getLookupProvider(), builder, Set.of(MysticsBiomes.modId)));
        generator.addProvider(event.includeServer(), new LootTableProvider(output, Collections.unmodifiableSet(Sets.newHashSet()), List.of(new LootTableProvider.SubProviderEntry(MysticLootTablesProvider::new, LootContextParamSets.BLOCK))));
        generator.addProvider(event.includeClient(), new MysticBlockStatesProvider(output, helper));
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            MysticBiomes.registerRegionProvider();
            MysticBiomes.registerSurfaceRules();
            MysticVanillaCompat.registerFlammables();
            MysticVanillaCompat.registerCompostables();
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MysticVanillaCompat.registerRenderLayers();
            MysticWoodTypes.registerWoodTypes();
        });
    }

}