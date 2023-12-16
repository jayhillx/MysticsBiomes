package com.mysticsbiomes.common.entity.ai.goal;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.Animal;

public class TravelToPosGoal extends Goal {
    private Animal animal;
    private BlockPos pos;

    public TravelToPosGoal(Animal animalIn, BlockPos posIn) {
        this.animal = animalIn;
        this.pos = posIn;

    }

    public boolean canUse() {
        return false;
    }

}