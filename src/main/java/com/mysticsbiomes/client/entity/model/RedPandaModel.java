package com.mysticsbiomes.client.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mysticsbiomes.client.entity.animation.RedPandaAnimation;
import com.mysticsbiomes.common.entity.animal.RedPanda;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RedPandaModel<T extends RedPanda> extends HierarchicalModel<T> {
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

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition partdefinition = mesh.getRoot();
        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -3.0F, -5.0F, 7.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -3.0F));
        head.addOrReplaceChild("right_ear", CubeListBuilder.create().texOffs(27, 6).mirror().addBox(-1.0F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.5F, -2.5F, -1.5F));
        head.addOrReplaceChild("left_ear", CubeListBuilder.create().texOffs(27, 6).addBox(-2.0F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, -2.5F, -1.5F));
        head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(27, 0).addBox(-2.0F, -1.5F, -2.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, -5.0F));
        PartDefinition head_standing = root.addOrReplaceChild("head_standing", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -6.0F, -2.5F, 7.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -5.5F));
        head_standing.addOrReplaceChild("right_ear2", CubeListBuilder.create().texOffs(27, 6).mirror().addBox(-1.0F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.5F, -5.5F, 1.0F));
        head_standing.addOrReplaceChild("left_ear2", CubeListBuilder.create().texOffs(27, 6).addBox(-2.0F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, -5.5F, 1.0F));
        head_standing.addOrReplaceChild("snout2", CubeListBuilder.create().texOffs(27, 0).addBox(-2.0F, -1.5F, -2.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, -2.5F));
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -6.0F, 2.0F));
        body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(0, 16).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 5.0F));
        tail.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(27, 17).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        root.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(40, 1).mirror().addBox(-0.99F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -4.0F, -2.0F));
        root.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(40, 1).addBox(-1.01F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -4.0F, -2.0F));
        root.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(40, 1).mirror().addBox(-0.99F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -4.0F, 5.0F));
        root.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(40, 1).addBox(-1.01F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -4.0F, 5.0F));
        return LayerDefinition.create(mesh, 48, 32);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.head.xRot = headPitch * 0.017453292F;
        this.head.yRot = netHeadYaw * 0.017453292F;
        this.headStanding.xRot = headPitch * 0.017453292F;
        this.headStanding.yRot = netHeadYaw * 0.017453292F;
        this.headStanding.visible = false;

        this.animate(entity.idleAnimationState, RedPandaAnimation.RED_PANDA_IDLE, ageInTicks);
        this.animate(entity.sleepingAnimationState, RedPandaAnimation.RED_PANDA_SLEEP, ageInTicks);

        if (!entity.isSleeping()) {
            if (entity.isSprinting()) {
                this.animateWalk(RedPandaAnimation.RED_PANDA_SPRINT, limbSwing, limbSwingAmount, 6.5F, 2.5F);
            } else {
                this.animateWalk(RedPandaAnimation.RED_PANDA_WALK, limbSwing, limbSwingAmount, 10.0F, 8.5F);
            }
        }
    }

    @Override
    public void renderToBuffer(PoseStack stack, VertexConsumer consumer, int light, int overlay, float r, float g, float b, float a) {
        if (this.young) {
            stack.pushPose();
            float f1;
            f1 = 1.5F / 2.0F;
            stack.scale(f1, f1, f1);

            stack.translate(0.0F, 2.15F, 1.0F / 16.0F);
            this.headParts().forEach((part) -> part.render(stack, consumer, light, overlay, r, g, b, a));
            stack.popPose();
            stack.pushPose();
            f1 = 1.0F / 2.0F;
            stack.scale(f1, f1, f1);
            stack.translate(0.0F, 3.0F, 0.0F);
            this.bodyParts().forEach((part) -> part.render(stack, consumer, light, overlay, r, g, b, a));
            stack.popPose();
        } else {
            super.renderToBuffer(stack, consumer, light, overlay, r, g, b, a);
        }
    }

    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of(this.head);
    }

    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(this.body, this.rightFrontLeg, this.leftFrontLeg, this.rightHindLeg, this.leftHindLeg);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

}