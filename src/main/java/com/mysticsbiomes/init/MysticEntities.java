package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.entity.model.ButterflyModel;
import com.mysticsbiomes.client.entity.model.RedPandaModel;
import com.mysticsbiomes.client.entity.model.SeaOtterModel;
import com.mysticsbiomes.client.entity.model.layer.MysticModelLayers;
import com.mysticsbiomes.client.entity.renderer.*;
import com.mysticsbiomes.common.entity.MysticBoat;
import com.mysticsbiomes.common.entity.MysticChestBoat;
import com.mysticsbiomes.common.entity.MysticThrownEgg;
import com.mysticsbiomes.common.entity.animal.*;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.client.render.entity.model.ChickenEntityModel;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.Heightmap;

public class MysticEntities {
    
    public static final EntityType<StrawberryCow> STRAWBERRY_COW = registerEntity("strawberry_cow", EntityType.Builder.create(StrawberryCow::new, SpawnGroup.CREATURE).setDimensions(0.9F, 1.4F).maxTrackingRange(10).build("strawberry_cow"));
    public static final EntityType<VanillaCow> VANILLA_COW = registerEntity("vanilla_cow", EntityType.Builder.create(VanillaCow::new, SpawnGroup.CREATURE).setDimensions(0.9F, 1.4F).maxTrackingRange(10).build("vanilla_cow"));
    public static final EntityType<ChocolateCow> CHOCOLATE_COW = registerEntity("chocolate_cow", EntityType.Builder.create(ChocolateCow::new, SpawnGroup.CREATURE).setDimensions(0.9F, 1.4F).maxTrackingRange(10).build("chocolate_cow"));
    public static final EntityType<RainbowChicken> RAINBOW_CHICKEN = registerEntity("rainbow_chicken", EntityType.Builder.create(RainbowChicken::new, SpawnGroup.CREATURE).setDimensions(0.4F, 0.7F).maxTrackingRange(10).build("rainbow_chicken"));
    public static final EntityType<RedPanda> RED_PANDA = registerEntity("red_panda", EntityType.Builder.create(RedPanda::new, SpawnGroup.CREATURE).setDimensions(0.5F, 0.6F).maxTrackingRange(10).build("red_panda"));
    public static final EntityType<SeaOtter> SEA_OTTER = registerEntity("sea_otter", EntityType.Builder.create(SeaOtter::new, SpawnGroup.CREATURE).setDimensions(0.5F, 0.4F).maxTrackingRange(10).build("sea_otter"));
    public static final EntityType<Butterfly> BUTTERFLY = registerEntity("butterfly", EntityType.Builder.create(Butterfly::new, SpawnGroup.CREATURE).setDimensions(0.5F, 0.3F).maxTrackingRange(10).build("butterfly"));

    public static final EntityType<MysticThrownEgg> RAINBOW_EGG = registerEntity("rainbow_egg", EntityType.Builder.<MysticThrownEgg>create(MysticThrownEgg::new, SpawnGroup.MISC).setDimensions(0.25F, 0.25F).maxTrackingRange(4).trackingTickInterval(10).build("rainbow_egg"));
    public static final EntityType<MysticBoat> BOAT = registerEntity("boat", EntityType.Builder.<MysticBoat>create(MysticBoat::new, SpawnGroup.MISC).setDimensions(1.375F, 0.5625F).maxTrackingRange(10).build("boat"));
    public static final EntityType<MysticChestBoat> CHEST_BOAT = registerEntity("chest_boat", EntityType.Builder.<MysticChestBoat>create(MysticChestBoat::new, SpawnGroup.MISC).setDimensions(1.375F, 0.5625F).maxTrackingRange(10).build("chest_boat"));

    private static <T extends Entity> EntityType<T> registerEntity(String name, EntityType<T> entityType) {
        return Registry.register(Registries.ENTITY_TYPE, MysticsBiomes.modLoc(name), entityType);
    }

    public static void registerEntities() {
        FabricDefaultAttributeRegistry.register(STRAWBERRY_COW, StrawberryCow.createAttributes());
        FabricDefaultAttributeRegistry.register(VANILLA_COW, VanillaCow.createAttributes());
        FabricDefaultAttributeRegistry.register(CHOCOLATE_COW, ChocolateCow.createAttributes());
        FabricDefaultAttributeRegistry.register(RAINBOW_CHICKEN, RainbowChicken.createAttributes());
        FabricDefaultAttributeRegistry.register(RED_PANDA, RedPanda.createAttributes());
        FabricDefaultAttributeRegistry.register(SEA_OTTER, SeaOtter.createAttributes());
        FabricDefaultAttributeRegistry.register(BUTTERFLY, Butterfly.createAttributes());
        MysticsBiomes.LOGGER.info("mystic's biomes ~ registering animals & critters");
    }

    public static void registerEntitySpawns() {
        SpawnRestriction.register(STRAWBERRY_COW, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
        SpawnRestriction.register(VANILLA_COW, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
        SpawnRestriction.register(CHOCOLATE_COW, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
        SpawnRestriction.register(RAINBOW_CHICKEN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
        SpawnRestriction.register(RED_PANDA, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
        SpawnRestriction.register(SEA_OTTER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
        SpawnRestriction.register(BUTTERFLY, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
    }

    public static void registerEntityRenderers() {
        EntityRendererRegistry.register(STRAWBERRY_COW, StrawberryCowRenderer::new);
        EntityRendererRegistry.register(VANILLA_COW, VanillaCowRenderer::new);
        EntityRendererRegistry.register(CHOCOLATE_COW, ChocolateCowRenderer::new);
        EntityRendererRegistry.register(RAINBOW_CHICKEN, RainbowChickenRenderer::new);
        EntityRendererRegistry.register(RED_PANDA, RedPandaRenderer::new);
        EntityRendererRegistry.register(SEA_OTTER, SeaOtterRenderer::new);
        EntityRendererRegistry.register(BUTTERFLY, ButterflyRenderer::new);
    }

    public static void registerEntityModels() {
        EntityModelLayerRegistry.registerModelLayer(MysticModelLayers.STRAWBERRY_COW, CowEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MysticModelLayers.VANILLA_COW, CowEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MysticModelLayers.CHOCOLATE_COW, CowEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MysticModelLayers.RAINBOW_CHICKEN, ChickenEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MysticModelLayers.RED_PANDA, RedPandaModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(MysticModelLayers.SEA_OTTER, SeaOtterModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(MysticModelLayers.BUTTERFLY, ButterflyModel::createBodyLayer);
    }

}