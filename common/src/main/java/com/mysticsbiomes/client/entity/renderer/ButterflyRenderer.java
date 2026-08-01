package com.mysticsbiomes.client.entity.renderer;

import com.google.common.collect.Maps;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.entity.model.ButterflyModel;
import com.mysticsbiomes.client.entity.model.layer.MysticModelLayers;
import com.mysticsbiomes.client.entity.renderer.layer.NectarLayer;
import com.mysticsbiomes.common.entity.animal.Butterfly;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class ButterflyRenderer extends MobRenderer<Butterfly, ButterflyModel<Butterfly>> {
    private static final Map<Integer, ResourceLocation> TEXTURES = Util.make(Maps.newHashMap(), (map) -> {
        for (Butterfly.Type type : Butterfly.Type.values()) {
            map.put(type.getId(), MysticsBiomes.modLoc("textures/entity/butterfly/" + type.getSerializedName() + ".png"));
        }
    });

    public ButterflyRenderer(EntityRendererProvider.Context context) {
        super(context, new ButterflyModel<>(context.bakeLayer(MysticModelLayers.BUTTERFLY)), 0.4F);
        this.addLayer(new NectarLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Butterfly butterfly) {
        return TEXTURES.get(butterfly.getVariant().getId());
    }

}