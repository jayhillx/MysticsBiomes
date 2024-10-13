package com.mysticsbiomes.client.entity.renderer;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.entity.model.ButterflyModel;
import com.mysticsbiomes.client.entity.model.layer.MysticModelLayers;
import com.mysticsbiomes.common.entity.animal.Butterfly;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.HashMap;
import java.util.Map;

@Environment(EnvType.CLIENT)
public class ButterflyRenderer extends MobEntityRenderer<Butterfly, ButterflyModel<Butterfly>> {
    private static final Map<Integer, Map<Integer, Identifier>> TEXTURES = Util.make(new HashMap<>(), (map) -> {
        for (Butterfly.Type type : Butterfly.Type.values()) {
            map.put(type.getId(), variant(type.asString()));
        }
    });

    public ButterflyRenderer(EntityRendererFactory.Context context) {
        super(context, new ButterflyModel<>(context.getPart(MysticModelLayers.BUTTERFLY)), 0.4F);
    }

    @Override
    public Identifier getTexture(Butterfly butterfly) {
        Map<Integer, Identifier> texture = TEXTURES.get(butterfly.getVariant().getId());
        return butterfly.hasVisibleNectar() ? texture.get(2) : texture.get(1);
    }

    public static Map<Integer, Identifier> variant(String type) {
        Map<Integer, Identifier> map = new HashMap<>();
        map.put(1, MysticsBiomes.modLoc("textures/entity/butterfly/" + type + ".png"));
        map.put(2, MysticsBiomes.modLoc("textures/entity/butterfly/" + type + "_nectar.png"));
        return map;
    }

}