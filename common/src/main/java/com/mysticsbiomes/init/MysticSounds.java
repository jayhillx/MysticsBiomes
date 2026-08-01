package com.mysticsbiomes.init;

import api.mystanica.registry.Registrar;
import com.mysticsbiomes.MysticsBiomes;
import api.mystanica.registry.RegistryEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;

public class MysticSounds {
    public static final Registrar<SoundEvent> SOUNDS = Registrar.create(Registries.SOUND_EVENT, MysticsBiomes.modId);

    public static final RegistryEntry<SoundEvent> RED_PANDA_AMBIENT = register("entity.red_panda.ambient");
    public static final RegistryEntry<SoundEvent> RED_PANDA_AMBIENT_AGGRESSIVE = register("entity.red_panda.ambient_aggressive");
    public static final RegistryEntry<SoundEvent> RED_PANDA_AMBIENT_GLOOMY = register("entity.red_panda.ambient_gloomy");
    public static final RegistryEntry<SoundEvent> RED_PANDA_STEP = register("entity.red_panda.step");
    public static final RegistryEntry<SoundEvent> RED_PANDA_HURT = register("entity.red_panda.hurt");
    public static final RegistryEntry<SoundEvent> RED_PANDA_DEATH = register("entity.red_panda.death");
    public static final RegistryEntry<SoundEvent> RED_PANDA_BITE = register("entity.red_panda.bite");
    public static final RegistryEntry<SoundEvent> RED_PANDA_SPIT = register("entity.red_panda.spit");
    public static final RegistryEntry<SoundEvent> RED_PANDA_SLEEP = register("entity.red_panda.sleep");
    public static final RegistryEntry<SoundEvent> RED_PANDA_SHAKE = register("entity.red_panda.shake");
    public static final RegistryEntry<SoundEvent> RED_PANDA_EAT = register("entity.red_panda.eat");
    public static final RegistryEntry<SoundEvent> RED_PANDA_PRE_SNEEZE = register("entity.red_panda.pre_sneeze");
    public static final RegistryEntry<SoundEvent> RED_PANDA_SNEEZE = register("entity.red_panda.sneeze");

    public static final RegistryEntry<SoundEvent> BUTTERFLY_NEST_ENTER = register("block.butterfly_nest.enter");
    public static final RegistryEntry<SoundEvent> BUTTERFLY_NEST_EXIT = register("block.butterfly_nest.exit");

    private static RegistryEntry<SoundEvent> register(String name) {
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(MysticsBiomes.modLoc(name)));
    }

    public static void init() {
    }

}