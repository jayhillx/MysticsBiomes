package com.mysticsbiomes;

import com.mysticsbiomes.core.registry.RegistryHelper;
import com.mysticsbiomes.init.*;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class MysticsBiomes {
    public static RegistryHelper REGISTRY;
    public static final String modId = "mysticsbiomes";

    public static ResourceLocation modLoc(String path) {
        return new ResourceLocation(modId, path);
    }

    public static void init() {
        MysticBlocks.registerBlocks();
        MysticBlockEntities.registerBlockEntities();
        MysticEntities.registerEntities();
        MysticItems.registerItems();
        MysticTabs.registerCreativeTabs();
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