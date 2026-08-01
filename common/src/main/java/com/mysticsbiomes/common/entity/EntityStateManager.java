package com.mysticsbiomes.common.entity;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;

import java.util.EnumMap;

/**
 * A universal way of sharing the same state driven code instead of copying it over and over again.
 *
 * @param <T> uses the given state of an entity.
 */
public class EntityStateManager<T extends Enum<T> & EntityStates<T>> {
    private final Entity entity;
    private final EntityDataAccessor<T> accessor;
    private final EnumMap<T, AnimationState> animations;
    protected long inStateTicks;

    public EntityStateManager(Entity entity, EntityDataAccessor<T> accessor, Class<T> states) {
        this.entity = entity;
        this.accessor = accessor;
        this.animations = new EnumMap<>(states);
        for (T state : states.getEnumConstants()) {
            this.animations.put(state, new AnimationState());
        }
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> accessor) {
        if (accessor.equals(this.accessor)) {
            this.inStateTicks = 0L;
        }
    }

    public T getState() {
        return this.entity.getEntityData().get(this.accessor);
    }

    public void trySwitchToState(T state) {
        if (this.getState() != state) {
            this.switchToState(state);
        }
    }

    public void switchToState(T state) {
        if (this.getState() != state) {
            this.entity.getEntityData().set(this.accessor, state);
            this.inStateTicks = 0L;
        }
    }

    public boolean isInProgress() {
        return this.inStateTicks >= this.getState().animationDuration();
    }

    public void tick() {
        this.inStateTicks++;

        T state = this.getState();
        if (!state.shouldLoop() && state.nextState() != null) {
            if (this.isInProgress()) {
                this.trySwitchToState(this.getState().nextState());
            }
        }

        if (this.entity.level().isClientSide()) {
            AnimationState animation = this.animations.get(this.getState());
            if (animation != null) {
                this.stopExcept(animation);
            }
        }
    }

    protected void stopExcept(AnimationState state) {
        if (!state.isStarted()) {
            state.start(this.entity.tickCount);

            for (AnimationState states : this.animations.values()) {
                if (states != state) {
                    states.stop();
                }
            }
        }
    }

    public AnimationState getAnimationFromState(T state) {
        return this.animations.get(state);
    }

}