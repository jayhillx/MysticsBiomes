package com.mysticsbiomes.client.entity.renderer;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.entity.model.CaterpillarModel;
import com.mysticsbiomes.client.entity.model.layer.MysticModelLayers;
import com.mysticsbiomes.common.entity.animal.Caterpillar;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CaterpillarRenderer extends MobRenderer<Caterpillar, CaterpillarModel<Caterpillar>> {
    private static final ResourceLocation TEXTURE = MysticsBiomes.modLoc("textures/entity/caterpillar/caterpillar.png");

    public CaterpillarRenderer(EntityRendererProvider.Context context) {
        super(context, new CaterpillarModel<>(context.bakeLayer(MysticModelLayers.CATERPILLAR)), 0.4F);
    }

    @Override
    public ResourceLocation getTextureLocation(Caterpillar caterpillar) {
        return TEXTURE;
    }

}