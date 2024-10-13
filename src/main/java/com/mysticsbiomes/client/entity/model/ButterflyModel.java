package com.mysticsbiomes.client.entity.model;

import com.mysticsbiomes.client.entity.animation.ButterflyAnimation;
import com.mysticsbiomes.common.entity.animal.Butterfly;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;

@Environment(EnvType.CLIENT)
public class ButterflyModel<T extends Butterfly> extends SinglePartEntityModel<T> {
    private final ModelPart root;

    public ButterflyModel(ModelPart part) {
        this.root = part.getChild("root");
    }

    public static TexturedModelData createBodyLayer() {
        ModelData mesh = new ModelData();
        ModelPartData part = mesh.getRoot();

        ModelPartData root = part.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 20.5F, 0.5F));
        ModelPartData body = root.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        body.addChild("body_r1", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.5F, -3.0F, -1.5F, 3.0F, 7.0F, 3.0F).mirrored(false), ModelTransform.of(0.0F, 0.0F, -0.5F, 1.5708F, 0.0F, 0.0F));
        body.addChild("left_antennae", ModelPartBuilder.create().uv(6, 7).cuboid(0.0F, -1.5F, -3.0F, 0.0F, 2.0F, 3.0F), ModelTransform.pivot(0.5F, -1.0F, -3.5F));
        body.addChild("right_antennae", ModelPartBuilder.create().uv(6, 7).cuboid(0.0F, -1.5F, -3.0F, 0.0F, 2.0F, 3.0F), ModelTransform.pivot(-0.5F, -1.0F, -3.5F));
        body.addChild("front_legs", ModelPartBuilder.create().uv(0, 11).cuboid(-1.5F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F), ModelTransform.pivot(0.0F, 1.5F, -2.0F));
        body.addChild("middle_legs", ModelPartBuilder.create().uv(0, 11).cuboid(-1.5F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F), ModelTransform.pivot(0.0F, 1.5F, -0.25F));
        body.addChild("back_legs", ModelPartBuilder.create().uv(0, 11).cuboid(-1.5F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F), ModelTransform.pivot(0.0F, 1.5F, 1.5F));
        ModelPartData leftWing = root.addChild("left_wing", ModelPartBuilder.create(), ModelTransform.pivot(1.5F, -1.5F, -0.5F));
        leftWing.addChild("left_wing_inner", ModelPartBuilder.create().uv(1, 0).cuboid(0.0F, 0.0F, -6.0F, 3.0F, 0.0F, 12.0F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        leftWing.addChild("left_wing_outer", ModelPartBuilder.create().uv(7, 0).cuboid(0.0F, 0.0F, -6.0F, 4.0F, 0.0F, 12.0F), ModelTransform.pivot(3.0F, 0.0F, 0.0F));
        ModelPartData rightWing = root.addChild("right_wing", ModelPartBuilder.create(), ModelTransform.pivot(-1.5F, -1.5F, -0.5F));
        rightWing.addChild("right_wing_inner", ModelPartBuilder.create().uv(1, 0).mirrored().cuboid(-3.0F, 0.0F, -6.0F, 3.0F, 0.0F, 12.0F).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        rightWing.addChild("right_wing_outer", ModelPartBuilder.create().uv(7, 0).mirrored().cuboid(-4.0F, 0.0F, -6.0F, 4.0F, 0.0F, 12.0F).mirrored(false), ModelTransform.pivot(-3.0F, 0.0F, 0.0F));
        return TexturedModelData.of(mesh, 32, 24);
    }

    @Override
    public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        this.updateAnimation(entity.flyingAnimationState, ButterflyAnimation.BUTTERFLY_FLYING, ageInTicks);
    }

    @Override
    public ModelPart getPart() {
        return this.root;
    }
    
}