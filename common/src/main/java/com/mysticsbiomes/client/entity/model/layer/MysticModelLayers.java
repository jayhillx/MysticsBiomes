package com.mysticsbiomes.client.entity.model.layer;

import com.mysticsbiomes.MysticsBiomes;
import net.minecraft.client.model.geom.ModelLayerLocation;

public class MysticModelLayers {

    public static final ModelLayerLocation STRAWBERRY_COW = register("strawberry_cow");
    public static final ModelLayerLocation VANILLA_COW = register("vanilla_cow");
    public static final ModelLayerLocation CHOCOLATE_COW = register("chocolate_cow");
    public static final ModelLayerLocation RAINBOW_CHICKEN = register("rainbow_chicken");
    public static final ModelLayerLocation RED_PANDA = register("red_panda");
    public static final ModelLayerLocation SEA_OTTER = register("sea_otter");
    public static final ModelLayerLocation BUTTERFLY = register("butterfly");
    public static final ModelLayerLocation CATERPILLAR = register("caterpillar");

    private static ModelLayerLocation register(String path) {
        return new ModelLayerLocation(MysticsBiomes.modLoc(path), "main");
    }

}