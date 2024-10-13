package com.mysticsbiomes.client.entity.renderer.layer;

import com.mysticsbiomes.client.entity.model.RedPandaModel;
import com.mysticsbiomes.common.entity.animal.RedPanda;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class RedPandaHeldItemLayer extends FeatureRenderer<RedPanda, RedPandaModel<RedPanda>> {
    private final HeldItemRenderer itemInHandRenderer;

    public RedPandaHeldItemLayer(FeatureRendererContext<RedPanda, RedPandaModel<RedPanda>> parent, HeldItemRenderer renderer) {
        super(parent);
        this.itemInHandRenderer = renderer;
    }

    @Override
    public void render(MatrixStack stack, VertexConsumerProvider source, int lightLevel, RedPanda redPanda, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        boolean sleeping = redPanda.isSleeping();
        boolean baby = redPanda.isBaby();
        ItemStack itemStack = redPanda.getEquippedStack(EquipmentSlot.MAINHAND);

        if (redPanda.isEating()) {
            float f1 = 1.4F;
            if (redPanda.isEating()) {
                float rightFrontLegRotation = this.getContextModel().getPart().getChild("right_front_leg").pivotX;
                f1 -= 0.9F * MathHelper.sin(rightFrontLegRotation * 1.12F);
            }

            stack.push();
            stack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-15.0F));
            stack.translate(0.0F, f1 - 1.3F, -0.075F);
        } else {
            stack.push();
            stack.translate(0.0F, 1.35F, 0.0F);

            if (sleeping) {
                stack.translate(-0.45F, 0.0F, -0.75F);
            }

            if (baby) {
                stack.scale(0.75F, 0.75F, 0.75F);
                stack.translate(0.0F, 0.5F, 0.209375F);
            }

            stack.translate((this.getContextModel()).head.pivotX / 16.0F, (this.getContextModel()).head.pivotY / 16.0F, (this.getContextModel()).head.pivotZ / 16.0F);
            stack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(netHeadYaw));
            stack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(headPitch));
            if (baby) {
                if (sleeping) {
                    stack.translate(0.4F, 0.26F, 0.15F);
                } else {
                    stack.translate(0.06F, 0.26F, -0.5F);
                }
            } else if (sleeping) {
                stack.translate(0.46F, 0.26F, 0.22F);
            } else {
                stack.translate(0.06F, 0.27F, -0.5F);
            }

            stack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));
        }
        this.itemInHandRenderer.renderItem(redPanda, itemStack, ModelTransformationMode.GROUND, false, stack, source, lightLevel);
        stack.pop();
    }

}