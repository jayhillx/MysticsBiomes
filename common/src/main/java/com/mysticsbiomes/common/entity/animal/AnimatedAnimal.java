package com.mysticsbiomes.common.entity.animal;

import net.minecraft.client.model.geom.PartPose;

import java.util.Map;

public interface AnimatedAnimal {

    Map<String, PartPose> getPreviousPose();

    Map<String, PartPose> getTargetPose();

}