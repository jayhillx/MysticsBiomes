package com.mysticsbiomes.client.entity.model;

import com.mysticsbiomes.client.entity.animation.SeaOtterAnimation;
import com.mysticsbiomes.common.entity.animal.SeaOtter;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;

@Environment(EnvType.CLIENT)
public class SeaOtterModel<T extends SeaOtter> extends SinglePartEntityModel<T> {
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart head2;
    private final ModelPart body;
    private final ModelPart neck;

    public SeaOtterModel(ModelPart root) {
        this.root = root.getChild("root");
        this.head = this.root.getChild("head");
        this.head2 = this.root.getChild("head2");
        this.body = this.root.getChild("body");
        this.neck = this.body.getChild("neck");
    }

    public static TexturedModelData createBodyLayer() {
        ModelData mesh = new ModelData();
        ModelPartData root = mesh.getRoot().addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 18.5F, -0.1F));
        ModelPartData head = root.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -3.0F, -5.0F, 6.0F, 5.0F, 5.0F, new Dilation(0.0F)).uv(24, 6).cuboid(-2.0F, -1.0F, -6.0F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.5F, -4.9F));
        head.addChild("right_whiskers", ModelPartBuilder.create().uv(35, 6).mirrored().cuboid(-2.0F, -1.5F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-3.0F, 0.5F, -4.0F));
        head.addChild("left_whiskers", ModelPartBuilder.create().uv(35, 6).cuboid(0.0F, -1.5F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 0.5F, -4.0F));
        ModelPartData head2 = root.addChild("head2", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -5.0F, -2.5F, 6.0F, 5.0F, 5.0F, new Dilation(0.0F)).uv(24, 6).cuboid(-2.0F, -3.0F, -3.5F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.5F, -7.4F));
        head2.addChild("right_whiskers2", ModelPartBuilder.create().uv(35, 6).mirrored().cuboid(-2.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-3.0F, -1.0F, -1.5F));
        head2.addChild("left_whiskers2", ModelPartBuilder.create().uv(35, 6).cuboid(0.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -1.0F, -1.5F));
        ModelPartData body = root.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -0.5F, -4.9F));
        ModelPartData torso = body.addChild("torso", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        torso.addChild("torso_r1", ModelPartBuilder.create().uv(0, 16).cuboid(-3.0F, 0.0F, -3.5F, 6.0F, 11.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.5F, 0.0F, 1.5708F, 0.0F, 0.0F));
        ModelPartData neck = body.addChild("neck", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.5F, 2.5F));
        neck.addChild("neck_r1", ModelPartBuilder.create().uv(0, 16).cuboid(-3.0F, -2.5F, -2.5F, 6.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        body.addChild("right_front_leg", ModelPartBuilder.create().uv(25, 16).mirrored().cuboid(-1.0F, 0.0F, -0.9F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-1.9F, 2.0F, 1.0F));
        body.addChild("left_front_leg", ModelPartBuilder.create().uv(25, 16).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.9F, 2.0F, 1.1F));
        body.addChild("right_hind_leg", ModelPartBuilder.create().uv(24, 24).mirrored().cuboid(-1.5F, 0.0F, -1.0F, 3.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-2.5F, 2.0F, 9.0F));
        body.addChild("left_hind_leg", ModelPartBuilder.create().uv(24, 24).cuboid(-1.5F, 0.0F, -1.0F, 3.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(2.5F, 2.0F, 9.0F));
        ModelPartData tail = body.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -0.5F, 11.0F));
        tail.addChild("tail_r1", ModelPartBuilder.create().uv(36, 20).cuboid(-1.0F, 0.0F, -1.5F, 2.0F, 7.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        return TexturedModelData.of(mesh, 48, 32);
    }

    @Override
    public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.head.pivotX = headPitch * ((float)Math.PI / 180F);
        this.head.pivotY = headYaw * ((float)Math.PI / 180F);
        this.head2.pivotX = -this.head.pivotX;
        this.head2.pivotY = -this.head.pivotY;
        boolean flag = entity.isFloating();
        this.head.visible = !flag;
        this.head2.visible = flag;
        this.neck.visible = flag;

        this.updateAnimation(entity.startSwimmingAnimationState, SeaOtterAnimation.SEA_OTTER_SWIMMING_TRANSITION, ageInTicks, 1.0F);
        this.updateAnimation(entity.floatingAnimationState, SeaOtterAnimation.SEA_OTTER_FLOATING, ageInTicks, 1.0F);
        this.updateAnimation(entity.sitDownAnimationState, SeaOtterAnimation.SEA_OTTER_SIT_DOWN, ageInTicks, 1.0F);
        this.updateAnimation(entity.sitUpAnimationState, SeaOtterAnimation.SEA_OTTER_SIT_UP, ageInTicks, 1.0F);

        if (entity.isTouchingWater()) {
            if (!flag) {
                if (entity.isSubmergedInWater() && entity.getBlockPos().getY() < entity.getWorld().getSeaLevel()) {
                    this.body.setPivot(headPitch * ((float)Math.PI / 180F), headYaw * ((float)Math.PI / 180F), 0.0F);
                }
                this.animateMovement(SeaOtterAnimation.SEA_OTTER_SWIMMING, limbSwing, limbSwingAmount, 3.0F, 6.0F);
            }
        } else {
            this.animateMovement(SeaOtterAnimation.SEA_OTTER_WALKING, limbSwing, limbSwingAmount, 3.0F, 6.0F);
        }
    }

    @Override
    public ModelPart getPart() {
        return this.root;
    }

}