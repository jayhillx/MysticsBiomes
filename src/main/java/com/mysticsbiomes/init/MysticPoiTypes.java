package com.mysticsbiomes.init;

import com.google.common.collect.ImmutableSet;
import com.mysticsbiomes.MysticsBiomes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MysticPoiTypes {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, MysticsBiomes.modId);

    public static final RegistryObject<PoiType> BUTTERFLY_NEST = POI_TYPES.register("butterfly_nest", () -> new PoiType(ImmutableSet.copyOf(MysticBlocks.BUTTERFLY_NEST.get().getStateDefinition().getPossibleStates()), 0, 1));

}