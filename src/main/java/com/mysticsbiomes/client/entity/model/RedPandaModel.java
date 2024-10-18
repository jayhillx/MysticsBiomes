package com.mysticsbiomes.client.entity.model;

import com.google.common.collect.ImmutableList;
import com.mysticsbiomes.client.entity.animation.RedPandaAnimation;
import com.mysticsbiomes.common.entity.animal.RedPanda;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public class RedPandaModel<T extends RedPanda> extends SinglePartEntityModel<T> {
    private final ModelPart root;
    public final ModelPart head;
    private final ModelPart headStanding;
    private final ModelPart body;
    private final ModelPart rightFrontLeg;
    private final ModelPart leftFrontLeg;
    private final ModelPart rightHindLeg;
    private final ModelPart leftHindLeg;

    public RedPandaModel(ModelPart root) {
        this.root = root.getChild("root");
        this.head = this.root.getChild("head");
        this.headStanding = this.root.getChild("head_standing");
        this.body = this.root.getChild("body");
        this.rightFrontLeg = this.root.getChild("right_front_leg");
        this.leftFrontLeg = this.root.getChild("left_front_leg");
        this.rightHindLeg = this.root.getChild("right_hind_leg");
        this.leftHindLeg = this.root.getChild("left_hind_leg");
    }

    public static TexturedModelData createBodyLayer() {
        ModelData mesh = new ModelData();
        ModelPartData ModelPartData = mesh.getRoot();
        ModelPartData root = ModelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        ModelPartData head = root.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-3.5F, -3.0F, -5.0F, 7.0F, 6.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -6.0F, -3.0F));
        head.addChild("right_ear", ModelPartBuilder.create().uv(27, 6).mirrored().cuboid(-1.0F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-3.5F, -2.5F, -1.5F));
        head.addChild("left_ear", ModelPartBuilder.create().uv(27, 6).cuboid(-2.0F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(3.5F, -2.5F, -1.5F));
        head.addChild("snout", ModelPartBuilder.create().uv(27, 0).cuboid(-2.0F, -1.5F, -2.0F, 4.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.5F, -5.0F));
        ModelPartData head_standing = root.addChild("head_standing", ModelPartBuilder.create().uv(0, 0).cuboid(-3.5F, -6.0F, -2.5F, 7.0F, 6.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, -5.5F));
        head_standing.addChild("right_ear2", ModelPartBuilder.create().uv(27, 6).mirrored().cuboid(-1.0F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-3.5F, -5.5F, 1.0F));
        head_standing.addChild("left_ear2", ModelPartBuilder.create().uv(27, 6).cuboid(-2.0F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(3.5F, -5.5F, 1.0F));
        head_standing.addChild("snout2", ModelPartBuilder.create().uv(27, 0).cuboid(-2.0F, -1.5F, -2.0F, 4.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.5F, -2.5F));
        ModelPartData body = root.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -6.0F, 2.0F));
        body.addChild("body_r1", ModelPartBuilder.create().uv(0, 16).cuboid(-3.0F, -5.0F, -3.0F, 6.0F, 10.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        ModelPartData tail = body.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 5.0F));
        tail.addChild("tail_r1", ModelPartBuilder.create().uv(27, 17).cuboid(-2.5F, 0.0F, -2.5F, 5.0F, 9.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        root.addChild("right_front_leg", ModelPartBuilder.create().uv(40, 1).mirrored().cuboid(-0.99F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-2.0F, -4.0F, -2.0F));
        root.addChild("left_front_leg", ModelPartBuilder.create().uv(40, 1).cuboid(-1.01F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -4.0F, -2.0F));
        root.addChild("right_hind_leg", ModelPartBuilder.create().uv(40, 1).mirrored().cuboid(-0.99F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-2.0F, -4.0F, 5.0F));
        root.addChild("left_hind_leg", ModelPartBuilder.create().uv(40, 1).cuboid(-1.01F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -4.0F, 5.0F));
        return TexturedModelData.of(mesh, 48, 32);
    }

    @Override
    public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.head.pitch = headPitch * (float) (Math.PI / 180.0);
        this.head.yaw = headYaw * (float) (Math.PI / 180.0);
        this.headStanding.pitch = headPitch * ((float)Math.PI / 180F);
        this.headStanding.yaw = headYaw * ((float)Math.PI / 180F);
        this.head.visible = !entity.isEating();
        this.headStanding.visible = entity.isEating();

        this.updateAnimation(entity.idleAnimationState, RedPandaAnimation.RED_PANDA_IDLE, ageInTicks);
        this.updateAnimation(entity.sleepingAnimationState, RedPandaAnimation.RED_PANDA_SLEEP, ageInTicks);
        this.updateAnimation(entity.eatAnimationState, RedPandaAnimation.RED_PANDA_EAT, ageInTicks);

        if (!entity.isSleeping() && !entity.isEating()) {
            if (entity.isSprinting()) {
                this.animateMovement(RedPandaAnimation.RED_PANDA_SPRINT, limbSwing, limbSwingAmount, 6.5F, 2.5F);
            } else {
                this.animateMovement(RedPandaAnimation.RED_PANDA_WALK, limbSwing, limbSwingAmount, 10.0F, 8.5F);
            }
        }
    }

    @Override
    public void render(MatrixStack stack, VertexConsumer consumer, int light, int overlay, float r, float g, float b, float a) {
        if (this.child) {
            stack.push();
            float f1;
            f1 = 1.5F / 2.0F;
            stack.scale(f1, f1, f1);

            stack.translate(0.0F, 2.15F, 1.0F / 16.0F);
            this.headParts().forEach((part) -> part.render(stack, consumer, light, overlay, r, g, b, a));
            stack.pop();
            stack.push();
            f1 = 1.0F / 2.0F;
            stack.scale(f1, f1, f1);
            stack.translate(0.0F, 3.0F, 0.0F);
            this.bodyParts().forEach((part) -> part.render(stack, consumer, light, overlay, r, g, b, a));
            stack.pop();
        } else {
            super.render(stack, consumer, light, overlay, r, g, b, a);
        }
    }

    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of(this.head);
    }

    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(this.body, this.rightFrontLeg, this.leftFrontLeg, this.rightHindLeg, this.leftHindLeg);
    }

    @Override
    public ModelPart getPart() {
        return this.root;
    }

}