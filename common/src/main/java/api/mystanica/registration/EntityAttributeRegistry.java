/*
 * Copyright (c) 2026, Mystanica
 *
 * All rights reserved.
 */
package api.mystanica.registration;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class EntityAttributeRegistry {
    private final BiConsumer<EntityType<? extends LivingEntity>, Supplier<AttributeSupplier.Builder>> registry;

    public EntityAttributeRegistry(BiConsumer<EntityType<? extends LivingEntity>, Supplier<AttributeSupplier.Builder>> registry) {
        this.registry = registry;
    }

    public void accept(EntityType<? extends LivingEntity> entity, Supplier<AttributeSupplier.Builder> attributes) {
        this.registry.accept(entity, attributes);
    }

}