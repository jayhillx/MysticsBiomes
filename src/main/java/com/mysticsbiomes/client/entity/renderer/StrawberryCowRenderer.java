package com.mysticsbiomes.client.entity.renderer;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.entity.model.layer.MysticModelLayers;
import com.mysticsbiomes.common.entity.animal.StrawberryCow;
import net.minecraft.client.model.CowModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StrawberryCowRenderer extends MobRenderer<StrawberryCow, CowModel<StrawberryCow>> {
    private static final ResourceLocation TEXTURE = MysticsBiomes.modLoc("textures/entity/cows/strawberry_cow.png");

    public StrawberryCowRenderer(EntityRendererProvider.Context context) {
        super(context, new CowModel<>(context.bakeLayer(MysticModelLayers.STRAWBERRY_COW)), 0.7F);
    }

    public ResourceLocation getTextureLocation(StrawberryCow cow) {
        return TEXTURE;
    }

}