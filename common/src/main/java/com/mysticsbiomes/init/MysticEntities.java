package com.mysticsbiomes.init;

import api.mystanica.registration.EntityAttributeRegistry;
import api.mystanica.registration.EntitySpawnPlacementRegistry;
import api.mystanica.registry.Registrar;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.entity.animal.*;
import com.mysticsbiomes.common.entity.vehicle.MysticBoat;
import com.mysticsbiomes.common.entity.vehicle.MysticChestBoat;
import api.mystanica.registry.RegistryEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.function.Supplier;

public class MysticEntities {
    public static final Registrar<EntityType<?>> ENTITIES = Registrar.create(Registries.ENTITY_TYPE, MysticsBiomes.modId);

    public static final RegistryEntry<EntityType<StrawberryCow>> STRAWBERRY_COW = register("strawberry_cow", () -> EntityType.Builder.of(StrawberryCow::new, MobCategory.CREATURE).sized(0.9F, 1.4F).clientTrackingRange(10));
    public static final RegistryEntry<EntityType<VanillaCow>> VANILLA_COW = register("vanilla_cow", () -> EntityType.Builder.of(VanillaCow::new, MobCategory.CREATURE).sized(0.9F, 1.4F).clientTrackingRange(10));
    public static final RegistryEntry<EntityType<ChocolateCow>> CHOCOLATE_COW = register("chocolate_cow", () -> EntityType.Builder.of(ChocolateCow::new, MobCategory.CREATURE).sized(0.9F, 1.4F).clientTrackingRange(10));
    public static final RegistryEntry<EntityType<RainbowChicken>> RAINBOW_CHICKEN = register("rainbow_chicken", () -> EntityType.Builder.of(RainbowChicken::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10));
    public static final RegistryEntry<EntityType<ThrownRainbowEgg>> RAINBOW_EGG = register("rainbow_egg", () -> EntityType.Builder.<ThrownRainbowEgg>of(ThrownRainbowEgg::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10));
    ///public static final RegistryEntry<EntityType<RedPanda>> RED_PANDA = register("red_panda", () -> EntityType.Builder.of(RedPanda::new, MobCategory.CREATURE).sized(0.5F, 0.6F).clientTrackingRange(10));
    ///public static final RegistryEntry<EntityType<SeaOtter>> SEA_OTTER = register("sea_otter", () -> EntityType.Builder.of(SeaOtter::new, MobCategory.CREATURE).sized(0.5F, 0.4F).clientTrackingRange(10));
    public static final RegistryEntry<EntityType<Butterfly>> BUTTERFLY = register("butterfly", () -> EntityType.Builder.of(Butterfly::new, MobCategory.CREATURE).sized(0.5F, 0.3F).clientTrackingRange(10));
    public static final RegistryEntry<EntityType<Caterpillar>> CATERPILLAR = register("caterpillar", () -> EntityType.Builder.of(Caterpillar::new, MobCategory.CREATURE).sized(0.5F, 0.3F).clientTrackingRange(10));

    /// misc.
    public static final RegistryEntry<EntityType<MysticBoat>> BOAT = register("boat", () -> EntityType.Builder.<MysticBoat>of(MysticBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));
    public static final RegistryEntry<EntityType<MysticChestBoat>> CHEST_BOAT = register("chest_boat", () -> EntityType.Builder.<MysticChestBoat>of(MysticChestBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));

    private static <T extends Entity> RegistryEntry<EntityType<T>> register(String name, Supplier<EntityType.Builder<T>> entity) {
        return ENTITIES.register(name, () -> entity.get().build(MysticsBiomes.modId + ":" + name));
    }

    public static void registerEntityAttributes(EntityAttributeRegistry registry) {
        registry.accept(MysticEntities.STRAWBERRY_COW.get(), StrawberryCow::createAttributes);
        registry.accept(MysticEntities.VANILLA_COW.get(), VanillaCow::createAttributes);
        registry.accept(MysticEntities.CHOCOLATE_COW.get(), ChocolateCow::createAttributes);
        registry.accept(MysticEntities.RAINBOW_CHICKEN.get(), RainbowChicken::createAttributes);
        ///registry.accept(MysticEntities.RED_PANDA.get(), RedPanda::createAttributes);
        ///registry.accept(MysticEntities.SEA_OTTER.get(), SeaOtter::createAttributes);
        registry.accept(MysticEntities.BUTTERFLY.get(), Butterfly::createAttributes);
        registry.accept(MysticEntities.CATERPILLAR.get(), Caterpillar::createAttributes);
    }

    public static void registerEntitySpawnPlacements(EntitySpawnPlacementRegistry event) {
        event.accept(MysticEntities.STRAWBERRY_COW.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        event.accept(MysticEntities.VANILLA_COW.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        event.accept(MysticEntities.CHOCOLATE_COW.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        event.accept(MysticEntities.RAINBOW_CHICKEN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        ///event.register(MysticEntities.RED_PANDA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        ///event.register(MysticEntities.SEA_OTTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        event.accept(MysticEntities.BUTTERFLY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        event.accept(MysticEntities.CATERPILLAR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
    }

    public static void init() {
    }

}