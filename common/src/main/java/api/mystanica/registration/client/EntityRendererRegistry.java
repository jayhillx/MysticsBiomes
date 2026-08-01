/*
 * Copyright (c) 2026, Mystanica
 *
 * All rights reserved.
 */
package api.mystanica.registration.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

public class EntityRendererRegistry {
    private final Registry registry;

    public EntityRendererRegistry(Registry registry) {
        this.registry = registry;
    }

    public <T extends Entity> void accept(EntityType<? extends T> entity, EntityRendererProvider<? super T> renderer) {
        this.registry.register(entity, renderer);
    }

    @FunctionalInterface
    public interface Registry {
        <T extends Entity> void register(EntityType<? extends T> entity, EntityRendererProvider<? super T> renderer);
    }

}