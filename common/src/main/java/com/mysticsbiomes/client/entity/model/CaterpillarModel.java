package com.mysticsbiomes.client.entity.model;

import com.mysticsbiomes.client.entity.animation.MysticAnimations;
import com.mysticsbiomes.common.entity.animal.Caterpillar;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class CaterpillarModel<T extends Caterpillar> extends HierarchicalModel<T> {
    private final ModelPart root;

    public CaterpillarModel(ModelPart part) {
        this.root = part.getChild("root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -3.0F, -6.0F, 3.0F, 3.0F, 2.0F), PartPose.offset(-0.5F, 24.0F, 0.5F));
        PartDefinition frontRoot = root.addOrReplaceChild("front_root", CubeListBuilder.create(), PartPose.offset(0.5F, 0.0F, -4.0F));
        PartDefinition front = frontRoot.addOrReplaceChild("front", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        front.addOrReplaceChild("front_r1", CubeListBuilder.create().texOffs(0, 6).addBox(-1.5F, -3.0F, -3.0F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
        PartDefinition middleRoot = frontRoot.addOrReplaceChild("middle_root", CubeListBuilder.create(), PartPose.offset(0.0F, -3.0F, 3.0F));
        PartDefinition middle = middleRoot.addOrReplaceChild("middle", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        middle.addOrReplaceChild("middle_r1", CubeListBuilder.create().texOffs(0, 6).addBox(-1.0F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(-0.5F, 1.5F, 1.5F, -1.5708F, 0.0F, 0.0F));
        PartDefinition endRoot = middleRoot.addOrReplaceChild("end_root", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 3.0F));
        PartDefinition end = endRoot.addOrReplaceChild("end", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        end.addOrReplaceChild("end_r1", CubeListBuilder.create().texOffs(0, 6).addBox(-1.0F, -3.0F, -1.5F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(-0.5F, 1.5F, 0.0F, -1.5708F, 0.0F, 0.0F));
        PartDefinition antennae = root.addOrReplaceChild("antennae", CubeListBuilder.create(), PartPose.offset(0.5F, -3.0F, -6.0F));
        antennae.addOrReplaceChild("antennae_r1", CubeListBuilder.create().texOffs(12, 2).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -0.5F, -1.0F, 1.5708F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animateWalk(MysticAnimations.CATERPILLAR_MOVING, limbSwing, limbSwingAmount, 14.0F, 60.0F);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

}