package com.mysticsbiomes.client.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mysticsbiomes.client.entity.animation.RainbowChickenAnimations;
import com.mysticsbiomes.common.entity.animal.RainbowChicken;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class RainbowChickenModel<T extends RainbowChicken> extends HierarchicalModel<T> {
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart leftWing;
    private final ModelPart rightWing;
    private final ModelPart tail;
    private final ModelPart leftLeg;
    private final ModelPart leftFoot;
    private final ModelPart rightLeg;
    private final ModelPart rightFoot;

    public RainbowChickenModel(ModelPart root) {
        this.root = root.getChild("root");
        this.head = this.root.getChild("head");
        this.body = this.root.getChild("body");
        this.leftWing = this.body.getChild("left_wing");
        this.rightWing = this.body.getChild("right_wing");
        this.tail = this.body.getChild("tail");
        this.leftLeg = this.root.getChild("left_leg");
        this.leftFoot = this.leftLeg.getChild("left_foot");
        this.rightLeg = this.root.getChild("right_leg");
        this.rightFoot = this.rightLeg.getChild("right_foot");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 18.0F, 0.0F));
        root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 6.0F, 3.0F).texOffs(15, 0).addBox(-2.0F, -3.0F, -4.0F, 4.0F, 2.0F, 2.0F).texOffs(15, 5).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, -2.0F, -3.0F));
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(0, 10).addBox(-3.0F, -4.0F, -3.0F, 6.0F, 8.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        PartDefinition leftWing = body.addOrReplaceChild("left_wing", CubeListBuilder.create(), PartPose.offset(3.0F, -3.0F, 0.0F));
        leftWing.addOrReplaceChild("left_wing_r1", CubeListBuilder.create().texOffs(0, 25).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
        PartDefinition rightWing = body.addOrReplaceChild("right_wing", CubeListBuilder.create(), PartPose.offset(-3.0F, -3.0F, 0.0F));
        rightWing.addOrReplaceChild("right_wing_r1", CubeListBuilder.create().texOffs(0, 25).mirror().addBox(-3.0F, 0.0F, -1.0F, 6.0F, 4.0F, 1.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(15, 25).addBox(-2.0F, -2.8335F, -0.0029F, 4.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -3.0F, 1.9755F, -1.0908F, 0.0F, 0.0F));
        PartDefinition leftLeg = root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.5F, 2.9F, 0.0F));
        leftLeg.addOrReplaceChild("left_leg_r1", CubeListBuilder.create().texOffs(25, 17).mirror().addBox(0.0F, -3.0F, -1.5F, 0.0F, 3.0F, 3.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 3.1416F));
        PartDefinition leftFoot = leftLeg.addOrReplaceChild("left_foot", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, 0.0F));
        leftFoot.addOrReplaceChild("left_foot_r1", CubeListBuilder.create().texOffs(22, 17).mirror().addBox(0.0F, 0.0F, -1.5F, 2.0F, 0.0F, 3.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 3.1416F));
        PartDefinition rightLeg = root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.5F, 2.9F, 0.0F));
        rightLeg.addOrReplaceChild("right_leg_r1", CubeListBuilder.create().texOffs(25, 17).mirror().addBox(0.0F, -3.0F, -1.5F, 0.0F, 3.0F, 3.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 3.1416F));
        PartDefinition rightFoot = rightLeg.addOrReplaceChild("right_foot", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, 0.0F));
        rightFoot.addOrReplaceChild("right_foot_r1", CubeListBuilder.create().texOffs(22, 17).mirror().addBox(0.0F, 0.0F, -1.5F, 2.0F, 0.0F, 3.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 3.1416F));
        return LayerDefinition.create(mesh, 32, 32);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.head.xRot = headPitch * (float) (Math.PI / 180.0);
        this.head.yRot = headYaw * (float) (Math.PI / 180.0);

        this.animate(entity.idleAnimationState, RainbowChickenAnimations.RAINBOW_CHICKEN_IDLING, ageInTicks);
        this.animate(entity.fallingAnimationState, RainbowChickenAnimations.RAINBOW_CHICKEN_FLOATING, ageInTicks);

        if (entity.onGround()) {
            if (entity.isSprinting()) {
                this.animateWalk(RainbowChickenAnimations.RAINBOW_CHICKEN_RUNNING, limbSwing, limbSwingAmount, 8.0F, 4.0F);
            } else {
                this.animateWalk(RainbowChickenAnimations.RAINBOW_CHICKEN_WALKING, limbSwing, limbSwingAmount, 12.0F, 10.0F);
            }
        }
    }

    @Override
    public void renderToBuffer(PoseStack stack, VertexConsumer vertex, int light, int overlay, float red, float blue, float green, float alpha) {
        if (this.young) {
            stack.pushPose();
            stack.translate(0.0F, 22.0F / 16.0F, 1.0F / 16.0F);
            this.headParts().forEach(part -> part.render(stack, vertex, light, overlay, red, blue, green, alpha));
            stack.popPose();
            stack.pushPose();
            float f1 = 1.0F / 2.0F;
            stack.scale(f1, f1, f1);
            stack.translate(0.0F, 42.0F / 16.0F, 0.0F);
            this.bodyParts().forEach(part -> part.render(stack, vertex, light, overlay, red, blue, green, alpha));
            stack.popPose();
        } else {
            super.renderToBuffer(stack, vertex, light, overlay, red, blue, green, alpha);
        }
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of(this.head);
    }

    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(this.body, this.tail, this.leftWing, this.rightWing, this.leftLeg, this.leftFoot, this.rightLeg, this.rightFoot);
    }

}