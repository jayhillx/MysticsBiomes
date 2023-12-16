package com.mysticsbiomes.client.renderer.entity;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.model.CaterpillarModel;
import com.mysticsbiomes.common.entity.animal.Caterpillar;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CaterpillarRenderer extends MobRenderer<Caterpillar, CaterpillarModel<Caterpillar>> {
    private static final ResourceLocation CATERPILLAR_TEXTURE = MysticsBiomes.modLoc("textures/entity/caterpillar.png");

    public CaterpillarRenderer(EntityRendererProvider.Context context) {
        super(context, new CaterpillarModel<>(context.bakeLayer(CaterpillarModel.LAYER)), 0.4F);
    }

    public ResourceLocation getTextureLocation(Caterpillar entity) {
        return CATERPILLAR_TEXTURE;
    }

}