package com.mysticsbiomes.core.registry;

import net.minecraft.resources.ResourceLocation;

import java.util.Objects;
import java.util.function.Supplier;

public final class RegistryObject<T> {
    private final ResourceLocation location;
    private final Supplier<T> supplier;
    private T value;
    private boolean resolved = false;

    public RegistryObject(ResourceLocation location, Supplier<T> supplier) {
        this.location = location;
        this.supplier = supplier;
    }

    public T get() {
        if (!this.resolved) {
            System.out.println("Resolving " + this.location);
            this.value = Objects.requireNonNull(this.supplier.get(), "Failed to resolve registry object: " + this.location);
            this.resolved = true;
        }

        return this.value;
    }

    public ResourceLocation getLocation() {
        return this.location;
    }

}