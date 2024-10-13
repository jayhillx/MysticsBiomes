package com.mysticsbiomes.client.entity.renderer;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.entity.model.SeaOtterModel;
import com.mysticsbiomes.client.entity.model.layer.MysticModelLayers;
import com.mysticsbiomes.common.entity.animal.SeaOtter;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SeaOtterRenderer extends MobEntityRenderer<SeaOtter, SeaOtterModel<SeaOtter>> {
    private static final Identifier TEXTURE = MysticsBiomes.modLoc("textures/entity/sea_otter/sea_otter.png");

    public SeaOtterRenderer(EntityRendererFactory.Context context) {
        super(context, new SeaOtterModel<>(context.getPart(MysticModelLayers.SEA_OTTER)), 0.4F);
    }

    @Override
    public Identifier getTexture(SeaOtter entity) {
        return TEXTURE;
    }

}