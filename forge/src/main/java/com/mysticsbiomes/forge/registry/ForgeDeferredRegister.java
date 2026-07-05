package com.mysticsbiomes.forge.registry;

import com.mysticsbiomes.core.registry.DeferredRegister;
import com.mysticsbiomes.core.registry.RegistryObject;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;

import java.util.function.Supplier;

public class ForgeDeferredRegister<T> extends DeferredRegister<T> {
    private final net.minecraftforge.registries.DeferredRegister<T> inner;

    public ForgeDeferredRegister(ResourceKey<? extends Registry<T>> registryKey, String modId) {
        super(registryKey, modId);
        this.inner = net.minecraftforge.registries.DeferredRegister.create(registryKey, modId);
    }

    @Override
    public <I extends T> RegistryObject<I> register(String name, Supplier<I> supplier) {
        var obj = this.inner.register(name, supplier);
        return new RegistryObject<>(ResourceLocation.fromNamespaceAndPath(this.modId, name), obj);
    }

    @Override
    public void register() {}

    public void attach(IEventBus bus) {
        this.inner.register(bus);
    }

}