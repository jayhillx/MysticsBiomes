package com.mysticsbiomes.core.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public abstract class DeferredRegister<T> {
    protected final ResourceKey<? extends Registry<T>> registryKey;
    protected final String modId;
    protected final Map<ResourceLocation, Supplier<? extends T>> entries = new LinkedHashMap<>();

    protected DeferredRegister(ResourceKey<? extends Registry<T>> registryKey, String modId) {
        this.registryKey = registryKey;
        this.modId = modId;
    }

    public abstract <I extends T> RegistryObject<I> register(String name, Supplier<I> supplier);

    public abstract void register();

}