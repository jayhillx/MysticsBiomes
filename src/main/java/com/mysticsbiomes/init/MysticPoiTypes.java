package com.mysticsbiomes.init;

import com.google.common.collect.ImmutableSet;
import com.mysticsbiomes.MysticsBiomes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.poi.PointOfInterestType;

public class MysticPoiTypes {

    public static final PointOfInterestType BUTTERFLY_NEST = Registry.register(Registries.POINT_OF_INTEREST_TYPE, MysticsBiomes.modLoc("butterfly_nest"), new PointOfInterestType(ImmutableSet.copyOf(MysticBlocks.BUTTERFLY_NEST.getStateManager().getStates()), 0, 1));

    public static void registerPoiTypes() {
        MysticsBiomes.LOGGER.info("mystic's biomes ~ registering poi types");
    }

}