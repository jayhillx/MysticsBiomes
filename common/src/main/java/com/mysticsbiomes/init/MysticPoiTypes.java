package com.mysticsbiomes.init;

import api.mystanica.registry.Registrar;
import com.google.common.collect.ImmutableSet;
import com.mysticsbiomes.MysticsBiomes;
import api.mystanica.registry.RegistryEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.village.poi.PoiType;

public class MysticPoiTypes {
    public static final Registrar<PoiType> POI_TYPES = Registrar.create(Registries.POINT_OF_INTEREST_TYPE, MysticsBiomes.modId);

    public static final RegistryEntry<PoiType> BUTTERFLY_NEST = POI_TYPES.register("butterfly_nest", () -> {
        return new PoiType(
                ImmutableSet.copyOf(MysticBlocks.BUTTERFLY_NEST.get().getStateDefinition().getPossibleStates()),
                0,  /// maxTickets
                1); /// validRange
    });

    public static void init() {
    }

}