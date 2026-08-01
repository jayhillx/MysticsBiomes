package com.mysticsbiomes.client.entity.renderer;

import com.google.common.collect.Maps;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.entity.model.RainbowChickenModel;
import com.mysticsbiomes.client.entity.model.layer.MysticModelLayers;
import com.mysticsbiomes.common.entity.animal.RainbowChicken;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class RainbowChickenRenderer extends MobRenderer<RainbowChicken, RainbowChickenModel<RainbowChicken>> {
    private static final Map<Integer, ResourceLocation> TEXTURES = Util.make(Maps.newHashMap(), (map) -> {
        for (RainbowChicken.Color color : RainbowChicken.Color.values()) {
            map.put(color.getId(), MysticsBiomes.modLoc("textures/entity/chickens/" + color.getSerializedName() + "_chicken.png"));
        }
    });

    public RainbowChickenRenderer(EntityRendererProvider.Context context) {
        super(context, new RainbowChickenModel<>(context.bakeLayer(MysticModelLayers.RAINBOW_CHICKEN)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(RainbowChicken chicken) {
        return TEXTURES.get(chicken.getColor().getId());
    }

}