package com.mysticsbiomes.common.entity;

import net.minecraft.util.StringRepresentable;

public interface EntityStates<T extends Enum<T> & EntityStates<T>> extends StringRepresentable {

    int id();

    /**
     * how long the animation is before it will move to the main state animation.
     * maybe make it so this here can also determine whether an animal can move? or some definition of "isInTransition"
     */
    int animationDuration();

    /**
     * if it doesn't have one it will just return null, and be the only state.
     *
     * @return the state that would follow up this state.
     */
    default T nextState() {
        return null;
    }

    /**
     * declare if the animation tied to the state should loop or not.
     * when true then the switch to the next state will need to be manually done.
     */
    boolean shouldLoop();

}