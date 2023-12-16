package com.mysticsbiomes;

import com.mysticsbiomes.common.block.state.MysticWoodTypes;
import com.mysticsbiomes.client.renderer.item.MysticItemProperties;
import com.mysticsbiomes.init.*;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.Set;

@Mod("mysticsbiomes")
public class MysticsBiomes {
    public static final String modId = "mysticsbiomes";

    public static ResourceLocation modLoc(String path) {
        return new ResourceLocation(modId, path);
    }

    /** @param <T> given registry, i.e. Registries.BIOMES. */
    public static <T> ResourceKey<T> createKey(ResourceKey<Registry<T>> registry, String name) {
        return ResourceKey.create(registry, modLoc(name));
    }

    /**
     * Mystic's Biomes 3.1.5
     * - spiced pumpkin
     * - pumpkin cookie
     * - pumpkin ice cream
     * - strawberry ice cream
     * - dried lavender
     * - lavender buds
     * - bundled lavender buds
     * - re: caterpillar
     * - new butterfly model
     * - spring bamboo
     * - bundled spring bamboo
     * - re: red panda
     * - updated tree shapes
     * - fix leaf decay
     */
    public MysticsBiomes() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::dataSetup);
        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);

        MysticBlocks.BLOCKS.register(bus);
        MysticBlockEntities.BLOCK_ENTITIES.register(bus);
        MysticEntities.ENTITIES.register(bus);
        MysticFeatures.TreeDecorators.TREE_DECORATORS.register(bus);
        MysticItems.ITEMS.register(bus);
        MysticParticles.PARTICLES.register(bus);
        MysticPoiTypes.POI_TYPES.register(bus);
        MysticSounds.SOUNDS.register(bus);
        MysticTab.CREATIVE_TABS.register(bus);
    }

    private void dataSetup(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();

        RegistrySetBuilder builder = new RegistrySetBuilder();
        builder.add(Registries.CONFIGURED_FEATURE, MysticFeatures.Configured::bootstrap);
        builder.add(Registries.PLACED_FEATURE, MysticFeatures.Placed::bootstrap);
        builder.add(Registries.BIOME, MysticBiomes::bootstrap);
        generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(output, event.getLookupProvider(), builder, Set.of(MysticsBiomes.modId)));
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            MysticBiomes.registerRegionProvider();
            MysticVanillaCompat.Common.registerFlammables();
            MysticVanillaCompat.Common.registerCompostables();
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MysticItemProperties.registerItemProperties();

            MysticVanillaCompat.Client.registerRenderLayers();
            MysticWoodTypes.registerWoodTypes();
        });
    }

}