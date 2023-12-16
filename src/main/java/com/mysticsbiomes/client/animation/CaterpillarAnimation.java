package com.mysticsbiomes.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CaterpillarAnimation {

    public static final AnimationDefinition CATERPILLAR_MOVE = AnimationDefinition.Builder.withLength(1f).looping().addAnimation("body", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.4167667f, KeyframeAnimations.scaleVec(1f, 1f, 1.38f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.8343334f, KeyframeAnimations.scaleVec(1f, 1f, 0.95f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.CATMULLROM))).addAnimation("antennae", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.4583433f, KeyframeAnimations.posVec(0f, 0f, -2f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.8343334f, KeyframeAnimations.posVec(0f, 0f, -0.12f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM))).addAnimation("antennae", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.4583433f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM))).build();
    public static final AnimationDefinition CATERPILLAR_VERTICAL = AnimationDefinition.Builder.withLength(0f).addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-90f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();

}