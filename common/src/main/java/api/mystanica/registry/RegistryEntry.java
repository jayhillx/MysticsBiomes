/*
 * Copyright (c) 2026, Mystanica
 *
 * All rights reserved.
 */
package api.mystanica.registry;

import net.minecraft.resources.ResourceLocation;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * This class is essentially a registry object simplified that functions cross-platform.
 *
 * @param <T> of type like Block or BlockEntityType<>.
 */
public final class RegistryEntry<T> implements Supplier<T> {
    private final ResourceLocation id;
    private T value;

    public RegistryEntry(ResourceLocation id) {
        this.id = Objects.requireNonNull(id, "RegistryEntry id cannot be null.");
    }

    public ResourceLocation getId() {
        return this.id;
    }

    /**
     * @return the registered value.
     * @throws IllegalStateException if this registry entry has not been bound yet.
     */
    @Override
    public T get() {
        if (!this.isBound()) {
            throw new IllegalStateException("RegistryEntry '" + this.id + "' has not been initialized yet.");
        }

        return this.value;
    }

    /**
     * this registry entry needs to be bound to properly be registered.
     * @throws IllegalStateException if this registry entry has already been bound.
     */
    public void bind(T value) {
        Objects.requireNonNull(value, "Cannot bind registry entry '" + this.id + "' to null");

        if (this.isBound()) {
            throw new IllegalStateException("RegistryEntry '" + this.id + "' has already been initialized." +
                    "\nExisting value: " + this.value.getClass().getName() +
                    "\nAttempted value: " + value.getClass().getName());
        }

        this.value = value;
    }

    public boolean isBound() {
        return this.value != null;
    }

}