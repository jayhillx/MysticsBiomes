package com.mysticsbiomes.client.entity.model;

import com.mysticsbiomes.common.entity.animal.AnimatedAnimal;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

public abstract class MysticAnimatedModel<T extends LivingEntity & AnimatedAnimal> extends HierarchicalModel<T> {

    /**
     * called in the setupAnim after all the animations are set up.
     */
    protected void lerpBones(T entity) {
        this.root().getAllParts().forEach(part -> {
            PartPose currentPose = PartPose.offsetAndRotation(part.x, part.y, part.z, part.xRot, part.yRot, part.zRot);
            PartPose targetPose = entity.getTargetPose().get(part.toString());
            if (targetPose == null || targetPose.x != currentPose.x || targetPose.y != currentPose.y || targetPose.z != currentPose.z || targetPose.xRot != currentPose.xRot || targetPose.yRot != currentPose.yRot || targetPose.zRot != currentPose.zRot) {
                entity.getTargetPose().put(part.toString(), currentPose);
            }
        });

        for (ModelPart part : this.root().getAllParts().toList()) {
            this.lerpPose(entity, part);
        }
    }

    /**
     * lerp each part to prevent limbs from snapping to a new position.
     * lower lerpFactor will be a smoother blend.
     *
     * @param part is applied to an iterated list of a models root children.
     */
    private void lerpPose(T entity, ModelPart part) {
        PartPose previous = entity.getPreviousPose().computeIfAbsent(part.toString(), p -> PartPose.ZERO);
        PartPose target = entity.getTargetPose().computeIfAbsent(part.toString(), p -> PartPose.offsetAndRotation(part.x, part.y, part.z, part.xRot, part.yRot, part.zRot));
        float lerpFactor = 0.05F;
        part.x = Mth.lerp(lerpFactor, previous.x, target.x);
        part.y = Mth.lerp(lerpFactor, previous.y, target.y);
        part.z = Mth.lerp(lerpFactor, previous.z, target.z);
        part.xRot = this.lerpAngle(lerpFactor, previous.xRot, target.xRot);
        part.yRot = this.lerpAngle(lerpFactor, previous.yRot, target.yRot);
        part.zRot = this.lerpAngle(lerpFactor, previous.zRot, target.zRot);
        entity.getPreviousPose().put(part.toString(), PartPose.offsetAndRotation(part.x, part.y, part.z, part.xRot, part.yRot, part.zRot));
    }

    private float lerpAngle(float factor, float start, float end) {
        float i = (float) (2 * Math.PI);
        float delta = (end - start) % (i);
        if (delta < -Math.PI) delta += i;
        if (delta > Math.PI) delta -= i;
        return start + factor * delta;
    }

}