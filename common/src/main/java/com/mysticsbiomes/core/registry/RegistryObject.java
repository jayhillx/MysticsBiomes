package com.mysticsbiomes.core.registry;

import net.minecraft.resources.ResourceLocation;

import java.util.Objects;
import java.util.function.Supplier;

public final class RegistryObject<T> {
    private final ResourceLocation location;
    private final Supplier<T> resolver;
    private T cached;
    private boolean resolved = false;

    public RegistryObject(ResourceLocation id, Supplier<T> resolver) {
        this.location = id;
        this.resolver = resolver;
    }

    public T get() {
        if (!this.resolved) {
            T value = this.resolver.get();
            this.cached = Objects.requireNonNull(value, "RegistryHandle failed to resolve: " + this.location);
            this.resolved = true;
        }
        return this.cached;
    }

    public ResourceLocation id() {
        return this.location;
    }

    public boolean isPresent() {
        try {
            this.get();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}