package com.mysticsbiomes;

import com.mysticsbiomes.core.registry.RegistryHelper;
import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.resources.ResourceLocation;

public class MysticsBiomes {
    public static final String modId = "mysticsbiomes";

    public static RegistryHelper REGISTRY;

    public static ResourceLocation modLoc(String path) {
        return new ResourceLocation(modId, path);
    }

    public static void init() {
        MysticBlocks.registerBlocks();
        MysticItems.registerItems();
    }

    public static void setupTerraBlender() {

    }

}