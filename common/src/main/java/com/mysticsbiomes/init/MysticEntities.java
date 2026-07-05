package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.entity.ThrownRainbowEgg;
import com.mysticsbiomes.common.entity.vehicle.MysticBoat;
import com.mysticsbiomes.common.entity.vehicle.MysticChestBoat;
import com.mysticsbiomes.core.registry.DeferredRegister;
import com.mysticsbiomes.core.registry.RegistryObject;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

import static com.mysticsbiomes.MysticsBiomes.REGISTRY_FACTORY;

public class MysticEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = REGISTRY_FACTORY.create(Registries.ENTITY_TYPE, MysticsBiomes.modId);

    ///public static final RegistryObject<EntityType<StrawberryCow>> STRAWBERRY_COW = register("strawberry_cow", () -> EntityType.Builder.of(StrawberryCow::new, MobCategory.CREATURE).sized(0.9F, 1.4F).clientTrackingRange(10));
    ///public static final RegistryObject<EntityType<VanillaCow>> VANILLA_COW = register("vanilla_cow", () -> EntityType.Builder.of(VanillaCow::new, MobCategory.CREATURE).sized(0.9F, 1.4F).clientTrackingRange(10));
    ///public static final RegistryObject<EntityType<ChocolateCow>> CHOCOLATE_COW = register("chocolate_cow", () -> EntityType.Builder.of(ChocolateCow::new, MobCategory.CREATURE).sized(0.9F, 1.4F).clientTrackingRange(10));
    ///public static final RegistryObject<EntityType<RainbowChicken>> RAINBOW_CHICKEN = register("rainbow_chicken", () -> EntityType.Builder.of(RainbowChicken::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10));
    public static final RegistryObject<EntityType<ThrownRainbowEgg>> RAINBOW_EGG = register("rainbow_egg", () -> EntityType.Builder.<ThrownRainbowEgg>of(ThrownRainbowEgg::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10));
    ///public static final RegistryObject<EntityType<RedPanda>> RED_PANDA = register("red_panda", () -> EntityType.Builder.of(RedPanda::new, MobCategory.CREATURE).sized(0.5F, 0.6F).clientTrackingRange(10));
    ///public static final RegistryObject<EntityType<SeaOtter>> SEA_OTTER = register("sea_otter", () -> EntityType.Builder.of(SeaOtter::new, MobCategory.CREATURE).sized(0.5F, 0.4F).clientTrackingRange(10));
    ///public static final RegistryObject<EntityType<Butterfly>> BUTTERFLY = register("butterfly", () -> EntityType.Builder.of(Butterfly::new, MobCategory.CREATURE).sized(0.5F, 0.3F).clientTrackingRange(10));
    ///public static final RegistryObject<EntityType<Caterpillar>> CATERPILLAR = register("caterpillar", () -> EntityType.Builder.of(Caterpillar::new, MobCategory.CREATURE).sized(0.5F, 0.3F).clientTrackingRange(10));

    /// misc.
    public static final RegistryObject<EntityType<MysticBoat>> BOAT = register("boat", () -> EntityType.Builder.<MysticBoat>of(MysticBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));
    public static final RegistryObject<EntityType<MysticChestBoat>> CHEST_BOAT = register("chest_boat", () -> EntityType.Builder.<MysticChestBoat>of(MysticChestBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, Supplier<EntityType.Builder<T>> entity) {
        return ENTITIES.register(name, () -> entity.get().build(MysticsBiomes.modId + ":" + name));
    }

    public static void init() {
    }

}