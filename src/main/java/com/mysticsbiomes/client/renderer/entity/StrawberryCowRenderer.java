package com.mysticsbiomes.client.renderer.entity;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.model.entity.StrawberryCowModel;
import com.mysticsbiomes.common.entity.animal.StrawberryCow;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StrawberryCowRenderer extends MobRenderer<StrawberryCow, StrawberryCowModel<StrawberryCow>> {
    private static final ResourceLocation TEXTURE = MysticsBiomes.modLoc("textures/entity/strawberry_cow/normal.png");

    public StrawberryCowRenderer(EntityRendererProvider.Context context) {
        super(context, new StrawberryCowModel<>(context.bakeLayer(StrawberryCowModel.LAYER)), 0.7F);
    }

    public ResourceLocation getTextureLocation(StrawberryCow cow) {
        return TEXTURE;
    }

}