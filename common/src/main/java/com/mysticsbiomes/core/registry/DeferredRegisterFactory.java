package com.mysticsbiomes.core.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

public interface DeferredRegisterFactory {

    <T> DeferredRegister<T> create(ResourceKey<? extends Registry<T>> key, String modId);

}