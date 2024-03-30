package com.mysticsbiomes;

import com.mojang.serialization.Codec;
import com.mysticsbiomes.common.block.state.MysticWoodTypes;
import com.mysticsbiomes.init.MysticConfig;
import com.mysticsbiomes.data.provider.MysticBlockStatesProvider;
import com.mysticsbiomes.common.world.AnimalSpawnsBuilder;
import com.mysticsbiomes.data.provider.MysticLootTablesProvider;
import com.mysticsbiomes.init.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
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

        MysticBiomes.BIOMES.register(bus);
        MysticBlocks.BLOCKS.register(bus);
        MysticBlockEntities.BLOCK_ENTITIES.register(bus);
        MysticEntities.ENTITIES.register(bus);
        MysticFeatures.FEATURES.register(bus);
        MysticFeatures.CONFIGURED_FEATURES.register(bus);
        MysticFeatures.PLACED_FEATURES.register(bus);
        MysticFeatures.TREE_DECORATORS.register(bus);
        MysticItems.ITEMS.register(bus);
        MysticParticles.PARTICLES.register(bus);
        MysticPoiTypes.POI_TYPES.register(bus);
        MysticSounds.SOUNDS.register(bus);

        DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, MysticsBiomes.modId);
        BIOME_MODIFIERS.register(bus);
        BIOME_MODIFIERS.register("animal_spawns", AnimalSpawnsBuilder::makeCodec);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MysticConfig.COMMON_SPEC);
    }

    private void dataSetup(final GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        generator.addProvider(event.includeServer(), new MysticLootTablesProvider(generator));
        generator.addProvider(event.includeClient(), new MysticBlockStatesProvider(generator, helper));
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