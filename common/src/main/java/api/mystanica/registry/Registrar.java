/*
 * Copyright (c) 2026, Mystanica
 *
 * All rights reserved.
 */
package api.mystanica.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public abstract class Registrar<T> {
    /// this will get assigned in the constructor in a given mod loader.
    public static Factory FACTORY;
    /// ALL the registries that are used and to be registered.
    protected static final List<Registrar<?>> REGISTRIES = new ArrayList<>();
    protected final ResourceKey<? extends Registry<T>> registryKey;
    protected final String modId;
    /// the entries in a given registry. (i.e. "mysticsbiomes:block/strawberry_planks")
    protected final Map<ResourceLocation, Registration<? extends T>> entries = new LinkedHashMap<>();

    protected Registrar(ResourceKey<? extends Registry<T>> registryKey, String modId) {
        this.registryKey = registryKey;
        this.modId = modId;
    }

    public static <T> Registrar<T> create(ResourceKey<? extends Registry<T>> registryKey, String modId) {
        Registrar<T> registrar = FACTORY.create(registryKey, modId);
        REGISTRIES.add(registrar);
        return registrar;
    }

    /**
     * this is immediately called in the constructor, directly after {@linkplain Registrar#FACTORY} is assigned.
     */
    public static void applyAll() {
        for (Registrar<?> registrar : REGISTRIES) {
            registrar.apply();
        }
    }

    public abstract void apply();

    /**
     * this registers the entry under a provided registrar, being {@link T}
     *
     * @param name the name of what the registry entry will be.
     * @param supplier a supplier of the object that will be registered.
     * @param <I> the type of object being registered. (i.e. Block or EntityType<?>)
     * @return the RegistryEntry for the object being registered.
     */
    public <I extends T> RegistryEntry<I> register(String name, Supplier<? extends I> supplier) {
        ResourceLocation id = new ResourceLocation(this.modId, name);
        RegistryEntry<I> entry = new RegistryEntry<>(id);
        this.entries.put(id, new Registration<>(supplier, entry));
        return entry;
    }

    protected final Map<ResourceLocation, Registration<? extends T>> getEntries() {
        return this.entries;
    }

    protected record Registration<T>(Supplier<? extends T> supplier, RegistryEntry<T> entry) {}

    public interface Factory {
        /**
         * @return is overridden by a given loader since they handle registries differently.
         */
        <T> Registrar<T> create(ResourceKey<? extends Registry<T>> key, String modId);
    }

}