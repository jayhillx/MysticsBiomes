package com.mysticsbiomes.forge.registry;

import api.mystanica.registry.Registrar;
import com.mysticsbiomes.MysticsBiomes;
import api.mystanica.registry.RegistryEntry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;

@Mod.EventBusSubscriber(modid = MysticsBiomes.modId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MysticRegistryForge<T> extends Registrar<T> {

    public MysticRegistryForge(ResourceKey<? extends Registry<T>> registryKey, String modId) {
        super(registryKey, modId);
    }

    @Override
    public void apply() {
        /// done through the register event method below.
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void register(RegisterEvent event) {
        for (Registrar<?> registrar : Registrar.REGISTRIES) {
            if (registrar instanceof MysticRegistryForge<?> register) {
                register.registerEntries(event);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void registerEntries(RegisterEvent event) {
        if (!event.getRegistryKey().equals(this.registryKey)) {
            return;
        }

        for (var registration : this.getEntries().entrySet()) {
            var id = registration.getKey();
            var value = registration.getValue();

            T object = value.supplier().get();
            event.register(this.registryKey, id, () -> object);
            ((RegistryEntry<T>) value.entry()).bind(object);
        }
    }

    public static class Factory implements Registrar.Factory {
        @Override
        public <T> Registrar<T> create(ResourceKey<? extends Registry<T>> registryKey, String modId) {
            return new MysticRegistryForge<>(registryKey, modId);
        }
    }

}