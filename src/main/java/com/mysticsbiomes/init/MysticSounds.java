package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;

public class MysticSounds {

    public static final SoundEvent BUTTERFLY_NEST_ENTER = registerSound("block.butterfly_nest.enter", SoundEvent.of(MysticsBiomes.modLoc("block.butterfly_nest.enter")));
    public static final SoundEvent BUTTERFLY_NEST_EXIT = registerSound("block.butterfly_nest.exit", SoundEvent.of(MysticsBiomes.modLoc("block.butterfly_nest.exit")));

    private static SoundEvent registerSound(String name, SoundEvent sound) {
        return Registry.register(Registries.SOUND_EVENT, MysticsBiomes.modLoc(name), sound);
    }

}