package com.mysticsbiomes.fabric.registry;

import api.mystanica.registry.Registrar;
import api.mystanica.registry.RegistryEntry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;

public class MysticRegistryFabric<T> extends Registrar<T> {

    public MysticRegistryFabric(ResourceKey<? extends Registry<T>> registryKey, String modId) {
        super(registryKey, modId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void apply() {
        Registry<T> registry = (Registry<T>) BuiltInRegistries.REGISTRY.get(this.registryKey.location());

        for (var registration : this.getEntries().entrySet()) {
            var id = registration.getKey();
            var value = registration.getValue();

            T object = value.supplier().get();
            Registry.register(registry, id, object);
            ((RegistryEntry<T>) value.entry()).bind(object);
        }
    }

    public static class Factory implements Registrar.Factory {
        @Override
        public <T> Registrar<T> create(ResourceKey<? extends Registry<T>> key, String modId) {
            return new MysticRegistryFabric<>(key, modId);
        }
    }
    
}