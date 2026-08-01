/*
 * Copyright (c) 2026, Mystanica
 *
 * All rights reserved.
 */
package api.mystanica.registration.client;

import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;

public class ParticleTypeRegistry {
    private final Registry registry;

    public ParticleTypeRegistry(Registry registry) {
        this.registry = registry;
    }

    public <T extends ParticleOptions> void accept(ParticleType<T> particleType, ParticleEngine.SpriteParticleRegistration<T> registration) {
        this.registry.register(particleType, registration);
    }

    @FunctionalInterface
    public interface Registry {
        <T extends ParticleOptions> void register(ParticleType<T> particleType, ParticleEngine.SpriteParticleRegistration<T> registration);
    }

}