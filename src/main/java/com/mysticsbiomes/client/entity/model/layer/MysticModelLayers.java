package com.mysticsbiomes.client.entity.model.layer;

import com.mysticsbiomes.MysticsBiomes;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.EntityModelLayer;

@Environment(EnvType.CLIENT)
public class MysticModelLayers {

    public static final EntityModelLayer STRAWBERRY_COW = register("strawberry_cow");
    public static final EntityModelLayer VANILLA_COW = register("vanilla_cow");
    public static final EntityModelLayer CHOCOLATE_COW = register("chocolate_cow");
    public static final EntityModelLayer RAINBOW_CHICKEN = register("rainbow_chicken");
    public static final EntityModelLayer RED_PANDA = register("red_panda");
    public static final EntityModelLayer SEA_OTTER = register("sea_otter");
    public static final EntityModelLayer BUTTERFLY = register("butterfly");

    private static EntityModelLayer register(String path) {
        return new EntityModelLayer(MysticsBiomes.modLoc(path), "main");
    }

}