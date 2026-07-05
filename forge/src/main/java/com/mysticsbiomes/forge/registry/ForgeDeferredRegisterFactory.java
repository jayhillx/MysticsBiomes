package com.mysticsbiomes.forge.registry;

import com.mysticsbiomes.core.registry.DeferredRegister;
import com.mysticsbiomes.core.registry.DeferredRegisterFactory;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.eventbus.api.IEventBus;

import java.util.ArrayList;
import java.util.List;

public class ForgeDeferredRegisterFactory implements DeferredRegisterFactory {
    private final List<ForgeDeferredRegister<?>> registers = new ArrayList<>();

    @Override
    public <T> DeferredRegister<T> create(ResourceKey<? extends Registry<T>> key, String modId) {
        ForgeDeferredRegister<T> reg = new ForgeDeferredRegister<>(key, modId);
        this.registers.add(reg);
        return reg;
    }

    public void attachAll(IEventBus bus) {
        for (ForgeDeferredRegister<?> register : this.registers) {
            register.attach(bus);
        }
    }

}