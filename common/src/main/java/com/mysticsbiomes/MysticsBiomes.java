package com.mysticsbiomes;

import com.mysticsbiomes.core.registry.RegistryHelper;
import com.mysticsbiomes.init.MysticBiomes;
import com.mysticsbiomes.init.MysticBlockEntities;
import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

import java.util.concurrent.CompletableFuture;

public class MysticsBiomes {
    public static final String modId = "mysticsbiomes";

    public static RegistryHelper REGISTRY;

    public static ResourceLocation modLoc(String path) {
        return new ResourceLocation(modId, path);
    }

    public static void init() {
        MysticBlocks.registerBlocks();
        MysticBlockEntities.registerBlockEntities();
        MysticItems.registerItems();
    }

    public static void setupTerraBlender() {
        ///MysticBiomes.registerRegionProvider();
    }

}