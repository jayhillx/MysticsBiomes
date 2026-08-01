package com.mysticsbiomes.fabric.registry;

import api.mystanica.registration.EntityAttributeRegistry;
import api.mystanica.registration.EntitySpawnPlacementRegistry;
import com.mysticsbiomes.init.MysticEntities;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;

public class CommonRegistriesFabric {

    public static void registerEntityAttributes() {
        MysticEntities.registerEntityAttributes(new EntityAttributeRegistry((entity, attributes) -> {
            FabricDefaultAttributeRegistry.register(entity, attributes.get());
        }));
    }

    public static void registerEntitySpawnPlacements() {
        MysticEntities.registerEntitySpawnPlacements(new EntitySpawnPlacementRegistry(CommonRegistriesFabric::registerSpawnPlacement));
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static void registerSpawnPlacement(EntitySpawnPlacementRegistry.Builder<?> placement) {
        SpawnPlacements.register(
                (EntityType) placement.entity(),
                placement.placementType(),
                placement.heightmap(),
                (SpawnPlacements.SpawnPredicate) placement.predicate()
        );
    }

}