package com.mysticsbiomes.client.entity.renderer;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.entity.model.layer.MysticModelLayers;
import com.mysticsbiomes.common.entity.animal.StrawberryCow;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.HashMap;
import java.util.Map;

@Environment(EnvType.CLIENT)
public class StrawberryCowRenderer extends MobEntityRenderer<StrawberryCow, CowEntityModel<StrawberryCow>> {
    private static final Map<StrawberryCow.Type, Identifier> TEXTURES = Util.make(new HashMap<>(), (map) -> {
        map.put(StrawberryCow.Type.PINK, MysticsBiomes.modLoc("textures/entity/cows/strawberry_cow.png"));
        map.put(StrawberryCow.Type.WHITE, MysticsBiomes.modLoc("textures/entity/cows/strawberry_cow_variant.png"));
    });

    public StrawberryCowRenderer(EntityRendererFactory.Context context) {
        super(context, new CowEntityModel<>(context.getPart(MysticModelLayers.STRAWBERRY_COW)), 0.7F);
    }

    @Override
    public Identifier getTexture(StrawberryCow strawberryCow) {
        return TEXTURES.get(strawberryCow.getVariant());
    }

}