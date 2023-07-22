package com.mysticsbiomes.client.entity.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.mysticsbiomes.common.entity.animal.RedPanda;
import net.minecraft.client.model.FoxModel;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RedPandaHeldItemLayer extends RenderLayer<RedPanda, FoxModel<RedPanda>> {
    private final ItemInHandRenderer itemInHandRenderer;

    public RedPandaHeldItemLayer(RenderLayerParent<RedPanda, FoxModel<RedPanda>> parent, ItemInHandRenderer renderer) {
        super(parent);
        this.itemInHandRenderer = renderer;
    }

    public void render(PoseStack stack, MultiBufferSource source, int i, RedPanda entity, float f, float f1, float f2, float z, float y, float x) {
        boolean flag = entity.isSleeping();
        boolean flag1 = entity.isBaby();
        stack.pushPose();
        if (flag1) {
            stack.scale(0.75F, 0.75F, 0.75F);
            stack.translate(0.0F, 0.5F, 0.209375F);
        }

        stack.translate((this.getParentModel()).head.x / 16.0F, (this.getParentModel()).head.y / 16.0F, (this.getParentModel()).head.z / 16.0F);
        float f0 = entity.getHeadRollAngle(f2);
        stack.mulPose(Axis.ZP.rotation(f0));
        stack.mulPose(Axis.YP.rotationDegrees(y));
        stack.mulPose(Axis.XP.rotationDegrees(x));
        if (entity.isBaby()) {
            if (flag) {
                stack.translate(0.4F, 0.26F, 0.15F);
            } else {
                stack.translate(0.06F, 0.26F, -0.5F);
            }
        } else if (flag) {
            stack.translate(0.46F, 0.26F, 0.22F);
        } else {
            stack.translate(0.06F, 0.27F, -0.5F);
        }

        stack.mulPose(Axis.XP.rotationDegrees(90.0F));
        if (flag) {
            stack.mulPose(Axis.ZP.rotationDegrees(90.0F));
        }

        ItemStack stack1 = entity.getItemBySlot(EquipmentSlot.MAINHAND);
        this.itemInHandRenderer.renderItem(entity, stack1, ItemDisplayContext.GROUND, false, stack, source, i);
        stack.popPose();
    }
    
}