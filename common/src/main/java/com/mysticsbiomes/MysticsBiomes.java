package com.mysticsbiomes;

import com.mysticsbiomes.core.registry.DeferredRegisterFactory;
import com.mysticsbiomes.init.*;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class MysticsBiomes {
    public static DeferredRegisterFactory REGISTRY_FACTORY;
    public static final String modId = "mysticsbiomes";

    public static ResourceLocation modLoc(String path) {
        return new ResourceLocation(modId, path);
    }

    public static void init() {
        MysticBlocks.init();
        MysticBlockEntities.init();
        MysticEntities.init();
        MysticItems.init();
        MysticTabs.init();
    }

    public static void setupCommon() {
        MysticCompat.registerFlammables();
        MysticCompat.registerCompostables();
        MysticCompat.registerStrippables();
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
        return registry.stream()
                .filter(entry -> modId.equals(registry.getKey(entry).getNamespace()))
                .toList();
    }

}