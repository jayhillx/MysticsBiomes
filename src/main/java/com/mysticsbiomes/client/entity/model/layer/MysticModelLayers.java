package com.mysticsbiomes.client.entity.model.layer;

import com.mysticsbiomes.MysticsBiomes;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MysticModelLayers {

    public static final ModelLayerLocation STRAWBERRY_COW = register("strawberry_cow");
    public static final ModelLayerLocation RAINBOW_CHICKEN = register("rainbow_chicken");
    public static final ModelLayerLocation RED_PANDA = register("red_panda");
    public static final ModelLayerLocation BUTTERFLY = register("butterfly");

    private static ModelLayerLocation register(String path) {
        return new ModelLayerLocation(MysticsBiomes.modLoc(path), "main");
    }

}