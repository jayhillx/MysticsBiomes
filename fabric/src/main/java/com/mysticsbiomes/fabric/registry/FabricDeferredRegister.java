package com.mysticsbiomes.fabric.registry;

import com.mysticsbiomes.core.registry.DeferredRegister;
import com.mysticsbiomes.core.registry.RegistryObject;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class FabricDeferredRegister<T> extends DeferredRegister<T> {
    private final List<Entry<T>> entries = new ArrayList<>();

    public FabricDeferredRegister(ResourceKey<? extends Registry<T>> key, String modId) {
        super(key, modId);
    }

    @Override
    public <I extends T> RegistryObject<I> register(String name, Supplier<I> supplier) {
        ResourceLocation id = new ResourceLocation(this.modId, name);
        this.entries.add(new Entry<>(name, supplier));

        return new RegistryObject<>(id, () -> {
            T value = supplier.get();
            Registry.register(getRegistry(), id, value);
            return (I) value;
        });
    }

    @Override
    public void register() {
        for (Entry<T> entry : this.entries) {
            ResourceLocation id = new ResourceLocation(this.modId, entry.name());
            Registry.register(getRegistry(), id, entry.supplier().get());
        }
    }

    @SuppressWarnings("unchecked")
    private Registry<T> getRegistry() {
        return (Registry<T>) BuiltInRegistries.REGISTRY.get(this.registryKey.location());
    }

    private record Entry<T>(String name, Supplier<? extends T> supplier) {}

}