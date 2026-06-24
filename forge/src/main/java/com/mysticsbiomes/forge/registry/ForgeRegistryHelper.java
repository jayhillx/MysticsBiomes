package com.mysticsbiomes.forge.registry;

import com.mysticsbiomes.core.registry.RegistryHelper;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ForgeRegistryHelper implements RegistryHelper {
    private final Map<ResourceKey<?>, DeferredRegister<?>> registers = new HashMap<>();
    private final String modid;

    public ForgeRegistryHelper(String modid) {
        this.modid = modid;
    }

    @Override
    public <T> Supplier<T> register(Registry<T> registry, String name, Supplier<T> entry) {
        ResourceKey<?> key = registry.key();
        return this.getRegister(key).register(name, entry);
    }

    @SuppressWarnings("unchecked")
    private <T> DeferredRegister<T> getRegister(ResourceKey<?> key) {
        return (DeferredRegister<T>) this.registers.computeIfAbsent(key, k -> DeferredRegister.create((ResourceKey)key, this.modid));
    }

    public void attachToModEventBus(IEventBus bus) {
        this.registers.values().forEach(r -> r.register(bus));
    }

}