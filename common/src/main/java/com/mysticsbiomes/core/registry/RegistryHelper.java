package com.mysticsbiomes.core.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

import java.util.function.Supplier;

public interface RegistryHelper {

    <T> Supplier<T> register(Registry<T> registry, String name, Supplier<T> entry);

}