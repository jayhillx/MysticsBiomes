package com.mysticsbiomes.client.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.entity.renderer.layer.RedPandaHeldItemLayer;
import com.mysticsbiomes.common.entity.animal.RedPanda;
import net.minecraft.client.model.FoxModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RedPandaRenderer extends MobRenderer<RedPanda, FoxModel<RedPanda>> {
    private static final ResourceLocation RED_PANDA_TEXTURE = MysticsBiomes.modLoc("textures/entity/red_panda/red_panda.png");
    private static final ResourceLocation RED_PANDA_SLEEP_TEXTURE = MysticsBiomes.modLoc("textures/entity/red_panda/red_panda_sleep.png");

    public RedPandaRenderer(EntityRendererProvider.Context context) {
        super(context, new FoxModel<>(context.bakeLayer(ModelLayers.FOX)), 0.4F);
        this.addLayer(new RedPandaHeldItemLayer(this, context.getItemInHandRenderer()));
    }

    protected void setupRotations(RedPanda entity, PoseStack stack, float x, float y, float z) {
        super.setupRotations(entity, stack, x, y, z);
        if (entity.isPouncing() || entity.isFaceplanted()) {
            float f = -Mth.lerp(z, entity.xRotO, entity.getXRot());
            stack.mulPose(Axis.XP.rotationDegrees(f));
        }
    }

    public ResourceLocation getTextureLocation(RedPanda entity) {
        return entity.isSleeping() ? RED_PANDA_SLEEP_TEXTURE : RED_PANDA_TEXTURE;
    }

}