/*
 * Copyright (c) 2026, Mystanica
 *
 * All rights reserved.
 */
package api.mystanica.registration;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;

public class EntitySpawnPlacementRegistry {
    private final Registry registry;

    public EntitySpawnPlacementRegistry(Registry registry) {
        this.registry = registry;
    }

    public <T extends Mob> void accept(EntityType<T> entity, SpawnPlacements.Type placementType, Heightmap.Types heightmap, SpawnPlacements.SpawnPredicate<T> predicate) {
        this.registry.register(new Builder<>(entity, placementType, heightmap, predicate));
    }

    @FunctionalInterface
    public interface Registry {
        void register(Builder<?> placement);
    }

    public record Builder<T extends Mob>(EntityType<T> entity,
                                         SpawnPlacements.Type placementType,
                                         Heightmap.Types heightmap,
                                         SpawnPlacements.SpawnPredicate<T> predicate) {
    }

}