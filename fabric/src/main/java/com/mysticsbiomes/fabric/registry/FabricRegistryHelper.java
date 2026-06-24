package com.mysticsbiomes.fabric.registry;

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
    public <T> Supplier<T> register(Registry<T> registry, String name, Supplier<T> entry) {
        T value = entry.get();
        Registry.register(registry, new ResourceLocation(this.modId, name), value);
        return () -> value;
    }

}