package com.mysticsbiomes.client.entity.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ButterflyAnimation {

    public static final AnimationDefinition BUTTERFLY_FLYING = AnimationDefinition.Builder.withLength(1.25f).looping().addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0F, KeyframeAnimations.posVec(0F, 0.9F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.25F, KeyframeAnimations.posVec(0F, -0.8F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5F, KeyframeAnimations.posVec(0F, 1.5F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.625F, KeyframeAnimations.posVec(0F, 0.9F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.875F, KeyframeAnimations.posVec(0F, -0.8F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.125F, KeyframeAnimations.posVec(0F, 1.5F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.25F, KeyframeAnimations.posVec(0F, 0.9F, 0f), AnimationChannel.Interpolations.CATMULLROM))).addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0F, KeyframeAnimations.degreeVec(2.5F, 0F, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0F, KeyframeAnimations.degreeVec(5.02F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.125F, KeyframeAnimations.degreeVec(8.5F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.4167667F, KeyframeAnimations.degreeVec(-2.5F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.625F, KeyframeAnimations.degreeVec(5.02F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.75F, KeyframeAnimations.degreeVec(8.5F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.0416767F, KeyframeAnimations.degreeVec(-2.5F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.25F, KeyframeAnimations.degreeVec(5.02F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM))).addAnimation("left_wing", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0F, KeyframeAnimations.degreeVec(0F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.16766666F, KeyframeAnimations.degreeVec(15F, 0F, -85f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.4583433F, KeyframeAnimations.degreeVec(0F, 0F, 65f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.625F, KeyframeAnimations.degreeVec(0F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.7916766F, KeyframeAnimations.degreeVec(15F, 0F, -85f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.0834333F, KeyframeAnimations.degreeVec(0F, 0F, 65f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.25F, KeyframeAnimations.degreeVec(0F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM))).addAnimation("right_wing", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0F, KeyframeAnimations.degreeVec(0F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.16766666F, KeyframeAnimations.degreeVec(15F, 0F, 85f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.4583433F, KeyframeAnimations.degreeVec(0F, 0F, -65f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.625F, KeyframeAnimations.degreeVec(0F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.7916766F, KeyframeAnimations.degreeVec(15F, 0F, 85f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.0834333F, KeyframeAnimations.degreeVec(0F, 0F, -65f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.25F, KeyframeAnimations.degreeVec(0F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM))).addAnimation("left_wing_outer", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0F, KeyframeAnimations.degreeVec(0F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.125F, KeyframeAnimations.degreeVec(0F, 0F, 30f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.20834334F, KeyframeAnimations.degreeVec(0F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.2916767F, KeyframeAnimations.degreeVec(0F, 0F, -47.5f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.4167667F, KeyframeAnimations.degreeVec(0F, 0F, -12.5f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5416766F, KeyframeAnimations.degreeVec(0F, 0F, 22.5f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.625F, KeyframeAnimations.degreeVec(0F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.75F, KeyframeAnimations.degreeVec(0F, 0F, 27.5f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.8343334F, KeyframeAnimations.degreeVec(0F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.9167666F, KeyframeAnimations.degreeVec(0F, 0F, -47.5f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.0416767F, KeyframeAnimations.degreeVec(0F, 0F, -12.5f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.1676667F, KeyframeAnimations.degreeVec(0F, 0F, 22.5f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.25F, KeyframeAnimations.degreeVec(0F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM))).addAnimation("right_wing_outer", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0F, KeyframeAnimations.degreeVec(0F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.125F, KeyframeAnimations.degreeVec(0F, 0F, -27.5f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.20834334F, KeyframeAnimations.degreeVec(0F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.2916767F, KeyframeAnimations.degreeVec(0F, 0F, 47.5f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.4167667F, KeyframeAnimations.degreeVec(0F, 0F, 12.5f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5416766F, KeyframeAnimations.degreeVec(0F, 0F, -22.5f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.625F, KeyframeAnimations.degreeVec(0F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.75F, KeyframeAnimations.degreeVec(0F, 0F, -27.5f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.8343334F, KeyframeAnimations.degreeVec(0F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.9167666F, KeyframeAnimations.degreeVec(0F, 0F, 47.5f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.0416767F, KeyframeAnimations.degreeVec(0F, 0F, 12.5f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.1676667F, KeyframeAnimations.degreeVec(0F, 0F, -22.5f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.25F, KeyframeAnimations.degreeVec(0F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM))).addAnimation("left_antennae", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0F, KeyframeAnimations.degreeVec(-6.96F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.125F, KeyframeAnimations.degreeVec(-25F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.2916767F, KeyframeAnimations.degreeVec(7.5F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.4583433F, KeyframeAnimations.degreeVec(22.5F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.625F, KeyframeAnimations.degreeVec(-6.96F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.75F, KeyframeAnimations.degreeVec(-25F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.9167666F, KeyframeAnimations.degreeVec(7.5F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.0834333F, KeyframeAnimations.degreeVec(15F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.25F, KeyframeAnimations.degreeVec(-6.96F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM))).addAnimation("right_antennae", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0F, KeyframeAnimations.degreeVec(-6.96F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.125F, KeyframeAnimations.degreeVec(-25F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.2916767F, KeyframeAnimations.degreeVec(7.5F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.4583433F, KeyframeAnimations.degreeVec(22.5F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.625F, KeyframeAnimations.degreeVec(-6.96F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.75F, KeyframeAnimations.degreeVec(-25F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.9167666F, KeyframeAnimations.degreeVec(7.5F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.0834333F, KeyframeAnimations.degreeVec(15F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.25F, KeyframeAnimations.degreeVec(-6.96F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM))).addAnimation("front_legs", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0F, KeyframeAnimations.degreeVec(0F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.125F, KeyframeAnimations.degreeVec(27.5F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.20834334F, KeyframeAnimations.degreeVec(35F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5F, KeyframeAnimations.degreeVec(-15F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.625F, KeyframeAnimations.degreeVec(0F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.75F, KeyframeAnimations.degreeVec(27.5F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.8343334F, KeyframeAnimations.degreeVec(35F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.125F, KeyframeAnimations.degreeVec(-15F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.25F, KeyframeAnimations.degreeVec(0F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM))).addAnimation("middle_legs", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0F, KeyframeAnimations.degreeVec(0F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.125F, KeyframeAnimations.degreeVec(27.5F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.20834334F, KeyframeAnimations.degreeVec(35F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5F, KeyframeAnimations.degreeVec(-15F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.625F, KeyframeAnimations.degreeVec(0F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.75F, KeyframeAnimations.degreeVec(27.5F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.8343334F, KeyframeAnimations.degreeVec(35F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.125F, KeyframeAnimations.degreeVec(-15F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.25F, KeyframeAnimations.degreeVec(0F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM))).addAnimation("back_legs", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0F, KeyframeAnimations.degreeVec(0F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.125F, KeyframeAnimations.degreeVec(27.5F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.20834334F, KeyframeAnimations.degreeVec(35F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5F, KeyframeAnimations.degreeVec(-15F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.625F, KeyframeAnimations.degreeVec(0F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.75F, KeyframeAnimations.degreeVec(27.5F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.8343334F, KeyframeAnimations.degreeVec(35F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.125F, KeyframeAnimations.degreeVec(-15F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.25F, KeyframeAnimations.degreeVec(0F, 0F, 0f), AnimationChannel.Interpolations.CATMULLROM))).build();

}