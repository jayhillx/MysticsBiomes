package com.mysticsbiomes.client.renderer.entity;

import com.google.common.collect.Maps;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.model.ButterflyModel;
import com.mysticsbiomes.client.model.layer.MysticModelLayers;
import com.mysticsbiomes.common.entity.animal.Butterfly;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class ButterflyRenderer extends MobRenderer<Butterfly, ButterflyModel<Butterfly>> {
    private static final Map<Integer, Map<Integer, ResourceLocation>> TEXTURE_BY_TYPE = Util.make(Maps.newHashMap(), (map) -> {
        for (Butterfly.Type type : Butterfly.Type.values()) {
            map.put(type.getId(), variant(type.getSerializedName()));
        }
    });

    public ButterflyRenderer(EntityRendererProvider.Context context) {
        super(context, new ButterflyModel<>(context.bakeLayer(MysticModelLayers.BUTTERFLY)), 0.4F);
    }

    public ResourceLocation getTextureLocation(Butterfly butterfly) {
        Map<Integer, ResourceLocation> base = TEXTURE_BY_TYPE.get(butterfly.getVariant().getId());
        if (butterfly.hasVisibleNectar()) {
            return butterfly.isFlying() ? base.get(3) : base.get(4);
        } else {
            return butterfly.isFlying() ? base.get(1) : base.get(2);
        }
    }

    /** @return a map containing the resource location to both flying and still textures. */
    public static Map<Integer, ResourceLocation> variant(String type) {
        Map<Integer, ResourceLocation> map = Maps.newHashMap();
        map.put(1, MysticsBiomes.modLoc("textures/entity/butterfly/" + type + ".png"));
        map.put(2, MysticsBiomes.modLoc("textures/entity/butterfly/" + type + "_still.png"));
        map.put(3, MysticsBiomes.modLoc("textures/entity/butterfly/" + type + "_nectar.png"));
        map.put(4, MysticsBiomes.modLoc("textures/entity/butterfly/" + type + "_still_nectar.png"));
        return map;
    }

}