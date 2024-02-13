package com.mysticsbiomes.client.renderer.entity;

import com.google.common.collect.Maps;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.model.entity.ButterflyModel;
import com.mysticsbiomes.client.model.entity.layer.MysticModelLayers;
import com.mysticsbiomes.common.animal.Butterfly;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class ButterflyRenderer extends MobRenderer<Butterfly, ButterflyModel<Butterfly>> {
    private static final Map<Integer, Map<Integer, ResourceLocation>> TEXTURES = Util.make(Maps.newHashMap(), (map) -> {
        for (Butterfly.Type type : Butterfly.Type.values()) {
            map.put(type.getId(), variant(type.getSerializedName()));
        }
    });

    public ButterflyRenderer(EntityRendererProvider.Context context) {
        super(context, new ButterflyModel<>(context.bakeLayer(MysticModelLayers.BUTTERFLY)), 0.4F);
    }

    public ResourceLocation getTextureLocation(Butterfly butterfly) {
        Map<Integer, ResourceLocation> texture = TEXTURES.get(butterfly.getVariant().getId());
        return butterfly.hasVisibleNectar() ? texture.get(2) : texture.get(1);
    }

    public static Map<Integer, ResourceLocation> variant(String type) {
        Map<Integer, ResourceLocation> map = Maps.newHashMap();
        map.put(1, MysticsBiomes.modLoc("textures/entity/butterfly/" + type + ".png"));
        map.put(2, MysticsBiomes.modLoc("textures/entity/butterfly/" + type + "_nectar.png"));
        return map;
    }

}