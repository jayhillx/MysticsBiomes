package com.mysticsbiomes;

import com.mysticsbiomes.init.MysticClient;
import com.mysticsbiomes.init.*;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class MysticsBiomes {
    public static final String modId = "mysticsbiomes";

    public static ResourceLocation modLoc(String path) {
        return new ResourceLocation(modId, path);
    }

    public static void init() {
        MysticBlocks.init();
        MysticBlockEntities.init();
        MysticEntities.init();
        MysticFeatures.init();
        MysticItems.init();
        MysticParticles.init();
        MysticPoiTypes.init();
        MysticSounds.init();
        MysticTabs.init();
    }

    public static void setupCommon() {
        MysticCompat.registerFlammables();
        MysticCompat.registerCompostables();
        MysticCompat.registerStrippables();

        MysticCriteriaTriggers.registerCriteriaTriggers();
    }

    public static void setupClient() {
        MysticClient.registerRenderLayers();
        MysticClient.registerWoodTypes();
    }

    public static void setupTerraBlender() {
        MysticBiomes.registerRegionProvider();
        MysticBiomes.registerSurfaceRules();
    }

    public static <T> List<T> getEntriesFromRegistry(Registry<T> registry) {
        return registry.stream().filter(entry -> {
            ResourceLocation key = registry.getKey(entry);
            return key != null && key.getNamespace().equals(modId);
        }).toList();
    }

}