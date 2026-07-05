package com.mysticsbiomes.fabric.registry;

import com.mysticsbiomes.core.registry.DeferredRegister;
import com.mysticsbiomes.core.registry.DeferredRegisterFactory;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

public class FabricDeferredRegisterFactory implements DeferredRegisterFactory {

    @Override
    public <T> DeferredRegister<T> create(ResourceKey<? extends Registry<T>> key, String modId) {
        return new FabricDeferredRegister<>(key, modId);
    }

}