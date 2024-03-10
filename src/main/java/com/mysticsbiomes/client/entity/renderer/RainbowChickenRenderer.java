package com.mysticsbiomes.client.entity.renderer;

import com.google.common.collect.Maps;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.entity.model.layer.MysticModelLayers;
import com.mysticsbiomes.common.entity.animal.RainbowChicken;
import net.minecraft.Util;
import net.minecraft.client.model.ChickenModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class RainbowChickenRenderer extends MobRenderer<RainbowChicken, ChickenModel<RainbowChicken>> {
    private static final Map<Integer, ResourceLocation> TEXTURES = Util.make(Maps.newHashMap(), (map) -> {
        for (RainbowChicken.Type type : RainbowChicken.Type.values()) {
            map.put(type.getId(), MysticsBiomes.modLoc("textures/entity/rainbow_chicken/" + type.getSerializedName() + "_chicken.png"));
        }
    });

    public RainbowChickenRenderer(EntityRendererProvider.Context context) {
        super(context, new ChickenModel<>(context.bakeLayer(MysticModelLayers.RAINBOW_CHICKEN)), 0.3F);
    }

    public ResourceLocation getTextureLocation(RainbowChicken chicken) {
        return TEXTURES.get(chicken.getVariant().getId());
    }

    protected float getBob(RainbowChicken chicken, float ticks) {
        float f = Mth.lerp(ticks, chicken.oFlap, chicken.flap);
        float f1 = Mth.lerp(ticks, chicken.oFlapSpeed, chicken.flapSpeed);
        return (Mth.sin(f) + 1.0F) * f1;
    }

}