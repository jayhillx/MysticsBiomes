package com.mysticsbiomes.forge.registry;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.core.registry.RegistryObject;
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
    private final String modId;

    public ForgeRegistryHelper(String modId) {
        this.modId = modId;
    }

    @Override
    public <R, T extends R> RegistryObject<T> register(Registry<R> registry, String name, Supplier<T> entry) {
        DeferredRegister<R> register = this.getRegister(registry.key());
        return new RegistryObject<>(MysticsBiomes.modLoc(name), register.register(name, entry));
    }

    @SuppressWarnings("unchecked")
    private <T> DeferredRegister<T> getRegister(ResourceKey<?> key) {
        return (DeferredRegister<T>) this.registers.computeIfAbsent(key, k -> DeferredRegister.create((ResourceKey)key, this.modId));
    }

    public void attachToModEventBus(IEventBus bus) {
        this.registers.values().forEach(r -> r.register(bus));
    }

}