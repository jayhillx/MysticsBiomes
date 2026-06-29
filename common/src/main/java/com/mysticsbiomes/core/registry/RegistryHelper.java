package com.mysticsbiomes.core.registry;

import net.minecraft.core.Registry;

import java.util.function.Supplier;

public interface RegistryHelper {

    <R, T extends R> RegistryObject<T> register(Registry<R> registry, String name, Supplier<T> entry);

}