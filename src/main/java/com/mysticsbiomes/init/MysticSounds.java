package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MysticSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, MysticsBiomes.modId);

    public static final RegistryObject<SoundEvent> BUTTERFLY_NEST_ENTER = SOUNDS.register("block.butterfly_nest.enter", () -> SoundEvent.createVariableRangeEvent(MysticsBiomes.modLoc("block.butterfly_nest.enter")));
    public static final RegistryObject<SoundEvent> BUTTERFLY_NEST_EXIT = SOUNDS.register("block.butterfly_nest.exit", () -> SoundEvent.createVariableRangeEvent(MysticsBiomes.modLoc("block.butterfly_nest.exit")));

}