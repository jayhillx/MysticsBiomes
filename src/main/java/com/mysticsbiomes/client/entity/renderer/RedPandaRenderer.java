package com.mysticsbiomes.client.entity.renderer;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.entity.model.RedPandaModel;
import com.mysticsbiomes.client.entity.model.layer.MysticModelLayers;
import com.mysticsbiomes.client.entity.renderer.layer.RedPandaHeldItemLayer;
import com.mysticsbiomes.common.entity.animal.RedPanda;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class RedPandaRenderer extends MobEntityRenderer<RedPanda, RedPandaModel<RedPanda>> {
    private static final Identifier NORMAL_TEXTURE = MysticsBiomes.modLoc("textures/entity/red_panda/normal.png");
    private static final Identifier NORMAL_SLEEP_TEXTURE = MysticsBiomes.modLoc("textures/entity/red_panda/normal_sleep.png");

    public RedPandaRenderer(EntityRendererFactory.Context context) {
        super(context, new RedPandaModel<>(context.getPart(MysticModelLayers.RED_PANDA)), 0.4F);
        this.addFeature(new RedPandaHeldItemLayer(this, context.getHeldItemRenderer()));
    }

    @Override
    public Identifier getTexture(RedPanda entity) {
        return entity.isSleeping() ? NORMAL_SLEEP_TEXTURE : NORMAL_TEXTURE;
    }

}