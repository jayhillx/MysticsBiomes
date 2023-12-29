package com.mysticsbiomes.client.model.entity;

import com.mysticsbiomes.client.animation.ButterflyAnimation;
import com.mysticsbiomes.common.entity.animal.Butterfly;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ButterflyModel<T extends Butterfly> extends HierarchicalModel<T> {
    private final ModelPart root;

    public ButterflyModel(ModelPart part) {
        this.root = part.getChild("root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition part = mesh.getRoot();

        PartDefinition root = part.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 20.5F, 0.5F));
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.5F, -3.0F, -1.5F, 3.0F, 7.0F, 3.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -0.5F, 1.5708F, 0.0F, 0.0F));
        body.addOrReplaceChild("left_antennae", CubeListBuilder.create().texOffs(6, 7).addBox(0.0F, -1.5F, -3.0F, 0.0F, 2.0F, 3.0F), PartPose.offset(0.5F, -1.0F, -3.5F));
        body.addOrReplaceChild("right_antennae", CubeListBuilder.create().texOffs(6, 7).addBox(0.0F, -1.5F, -3.0F, 0.0F, 2.0F, 3.0F), PartPose.offset(-0.5F, -1.0F, -3.5F));
        body.addOrReplaceChild("front_legs", CubeListBuilder.create().texOffs(0, 11).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F), PartPose.offset(0.0F, 1.5F, -2.0F));
        body.addOrReplaceChild("middle_legs", CubeListBuilder.create().texOffs(0, 11).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F), PartPose.offset(0.0F, 1.5F, -0.25F));
        body.addOrReplaceChild("back_legs", CubeListBuilder.create().texOffs(0, 11).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F), PartPose.offset(0.0F, 1.5F, 1.5F));
        PartDefinition leftWing = root.addOrReplaceChild("left_wing", CubeListBuilder.create(), PartPose.offset(1.5F, -1.5F, -0.5F));
        leftWing.addOrReplaceChild("left_wing_inner", CubeListBuilder.create().texOffs(1, 0).addBox(0.0F, 0.0F, -6.0F, 3.0F, 0.0F, 12.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        leftWing.addOrReplaceChild("left_wing_outer", CubeListBuilder.create().texOffs(7, 0).addBox(0.0F, 0.0F, -6.0F, 4.0F, 0.0F, 12.0F), PartPose.offset(3.0F, 0.0F, 0.0F));
        PartDefinition rightWing = root.addOrReplaceChild("right_wing", CubeListBuilder.create(), PartPose.offset(-1.5F, -1.5F, -0.5F));
        rightWing.addOrReplaceChild("right_wing_inner", CubeListBuilder.create().texOffs(1, 0).mirror().addBox(-3.0F, 0.0F, -6.0F, 3.0F, 0.0F, 12.0F).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));
        rightWing.addOrReplaceChild("right_wing_outer", CubeListBuilder.create().texOffs(7, 0).mirror().addBox(-4.0F, 0.0F, -6.0F, 4.0F, 0.0F, 12.0F).mirror(false), PartPose.offset(-3.0F, 0.0F, 0.0F));
        return LayerDefinition.create(mesh, 32, 24);
    }

    @Override
    public void setupAnim(T entity, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.animate(entity.flyingAnimationState, ButterflyAnimation.BUTTERFLY_FLYING, p_102621_);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

}