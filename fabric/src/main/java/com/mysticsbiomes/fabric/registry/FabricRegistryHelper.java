package com.mysticsbiomes.fabric.registry;

import com.mysticsbiomes.core.registry.RegistryObject;
import com.mysticsbiomes.core.registry.RegistryHelper;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public class FabricRegistryHelper implements RegistryHelper {
    private final String modId;

    public FabricRegistryHelper(String modId) {
        this.modId = modId;
    }

    @Override
    public <R, T extends R> RegistryObject<T> register(Registry<R> registry, String name, Supplier<T> entry) {
        T value = entry.get();
        ResourceLocation id = new ResourceLocation(this.modId, name);
        Registry.register(registry, id, value);
        return new RegistryObject<>(id, () -> value);
    }

}