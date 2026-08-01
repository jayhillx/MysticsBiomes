package com.mysticsbiomes.client.entity.model;

import com.mysticsbiomes.client.entity.animation.MysticAnimations;
import com.mysticsbiomes.common.entity.animal.Butterfly;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class ButterflyModel<T extends Butterfly> extends HierarchicalModel<T> {
    private final ModelPart root;

    public ButterflyModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.5F, 21.0F, 0.5F));
        PartDefinition bodyRoot = root.addOrReplaceChild("body_root", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, -1.5F));
        bodyRoot.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-1.5F, -3.5F, -0.5F, 2.0F, 7.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 0.5F, 1.5F, 1.5708F, 0.0F, 0.0F));
        PartDefinition antennae = bodyRoot.addOrReplaceChild("antennae", CubeListBuilder.create(), PartPose.offset(-0.5F, -0.5F, -2.0F));
        antennae.addOrReplaceChild("antennae_r1", CubeListBuilder.create().texOffs(1, 11).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        bodyRoot.addOrReplaceChild("back_legs", CubeListBuilder.create().texOffs(6, 11).mirror().addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F).mirror(false), PartPose.offset(-0.5F, 1.0F, 1.0F));
        bodyRoot.addOrReplaceChild("front_legs", CubeListBuilder.create().texOffs(6, 11).mirror().addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F).mirror(false), PartPose.offset(-0.5F, 1.0F, -0.5F));
        PartDefinition leftWing = root.addOrReplaceChild("left_wing", CubeListBuilder.create(), PartPose.offset(0.5F, 0.0F, -0.5F));
        PartDefinition leftFrontwingRoot = leftWing.addOrReplaceChild("left_frontwing_root", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        leftFrontwingRoot.addOrReplaceChild("left_frontwing_inner_r1", CubeListBuilder.create().texOffs(9, 6).mirror().addBox(-4.0F, 0.0F, -6.0F, 4.0F, 0.0F, 6.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.1416F));
        leftFrontwingRoot.addOrReplaceChild("left_frontwing_outer", CubeListBuilder.create().texOffs(17, 6).addBox(0.0F, 0.0F, -4.0F, 4.0F, 0.0F, 6.0F), PartPose.offset(4.0F, 0.0F, -2.0F));
        PartDefinition leftHindwingRoot = leftWing.addOrReplaceChild("left_hindwing_root", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        leftHindwingRoot.addOrReplaceChild("left_hindwing_inner_r1", CubeListBuilder.create().texOffs(10, 0).mirror().addBox(-3.0F, 0.0F, 0.0F, 3.0F, 0.0F, 6.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.1416F));
        leftHindwingRoot.addOrReplaceChild("left_hindwing_outer", CubeListBuilder.create().texOffs(16, 0).addBox(0.0F, 0.0F, -2.0F, 3.0F, 0.0F, 6.0F), PartPose.offset(3.0F, 0.0F, 2.0F));
        PartDefinition rightWing = root.addOrReplaceChild("right_wing", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, 0.0F, -0.5F, 0.0F, 0.0F, -3.1416F));
        PartDefinition rightFrontwingRoot = rightWing.addOrReplaceChild("right_frontwing_root", CubeListBuilder.create().texOffs(9, 6).addBox(0.0F, 0.0F, -6.0F, 4.0F, 0.0F, 6.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition rightFrontwingOuter = rightFrontwingRoot.addOrReplaceChild("right_frontwing_outer", CubeListBuilder.create(), PartPose.offset(4.0F, 0.0F, -2.0F));
        rightFrontwingOuter.addOrReplaceChild("right_frontwing_outer_r1", CubeListBuilder.create().texOffs(17, 6).mirror().addBox(-4.0F, 0.0F, -4.0F, 4.0F, 0.0F, 6.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.1416F));
        PartDefinition rightHindwingRoot = rightWing.addOrReplaceChild("right_hindwing_root", CubeListBuilder.create().texOffs(10, 0).addBox(0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 6.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition rightHindwingOuter = rightHindwingRoot.addOrReplaceChild("right_hindwing_outer", CubeListBuilder.create(), PartPose.offset(3.0F, 0.0F, 2.0F));
        rightHindwingOuter.addOrReplaceChild("right_hindwing_outer_r1", CubeListBuilder.create().texOffs(16, 0).mirror().addBox(-3.0F, 0.0F, -2.0F, 3.0F, 0.0F, 6.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.1416F));
        return LayerDefinition.create(meshdefinition, 32, 24);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animate(entity.flyingAnimationState, MysticAnimations.BUTTERFLY_FLYING, ageInTicks);
        this.animate(entity.pollinatingAnimationState, MysticAnimations.BUTTERFLY_POLLINATING, ageInTicks);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

}