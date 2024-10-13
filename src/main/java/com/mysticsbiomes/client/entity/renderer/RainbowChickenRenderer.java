package com.mysticsbiomes.client.entity.renderer;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.entity.model.layer.MysticModelLayers;
import com.mysticsbiomes.common.entity.animal.RainbowChicken;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.ChickenEntityModel;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;

import java.util.HashMap;
import java.util.Map;

@Environment(EnvType.CLIENT)
public class RainbowChickenRenderer extends MobEntityRenderer<RainbowChicken, ChickenEntityModel<RainbowChicken>> {
    private static final Map<Integer, Identifier> TEXTURES = Util.make(new HashMap<>(), (map) -> {
        for (RainbowChicken.Type type : RainbowChicken.Type.values()) {
            map.put(type.getId(), MysticsBiomes.modLoc("textures/entity/rainbow_chickens/" + type.asString() + "_chicken.png"));
        }
    });

    public RainbowChickenRenderer(EntityRendererFactory.Context context) {
        super(context, new ChickenEntityModel<>(context.getPart(MysticModelLayers.RAINBOW_CHICKEN)), 0.3F);
    }

    @Override
    public Identifier getTexture(RainbowChicken chicken) {
        return TEXTURES.get(chicken.getVariant().getId());
    }

    @Override
    protected float getAnimationProgress(RainbowChicken chicken, float ticks) {
        float f = MathHelper.lerp(ticks, chicken.oFlap, chicken.flap);
        float f1 = MathHelper.lerp(ticks, chicken.oFlapSpeed, chicken.flapSpeed);
        return (MathHelper.sin(f) + 1.0F) * f1;
    }

}