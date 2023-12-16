package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.model.ButterflyModel;
import com.mysticsbiomes.client.model.CaterpillarModel;
import com.mysticsbiomes.client.model.StrawberryCowModel;
import com.mysticsbiomes.client.model.layer.MysticModelLayers;
import com.mysticsbiomes.client.renderer.entity.*;
import com.mysticsbiomes.common.entity.MysticBoat;
import com.mysticsbiomes.common.entity.MysticChestBoat;
import com.mysticsbiomes.common.entity.animal.Butterfly;
import com.mysticsbiomes.common.entity.animal.RedPanda;
import com.mysticsbiomes.common.entity.animal.Caterpillar;
import com.mysticsbiomes.common.entity.animal.StrawberryCow;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = MysticsBiomes.modId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MysticEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, MysticsBiomes.modId);

    public static final RegistryObject<EntityType<StrawberryCow>> STRAWBERRY_COW = ENTITIES.register("strawberry_cow", () -> EntityType.Builder.of(StrawberryCow::new, MobCategory.CREATURE).sized(0.9F, 1.4F).clientTrackingRange(10).build(MysticsBiomes.modId + ":strawberry_cow"));
    public static final RegistryObject<EntityType<RedPanda>> RED_PANDA = ENTITIES.register("red_panda", () -> EntityType.Builder.of(RedPanda::new, MobCategory.CREATURE).sized(0.9F, 1.4F).clientTrackingRange(10).build(MysticsBiomes.modId + ":red_panda"));
    public static final RegistryObject<EntityType<Butterfly>> BUTTERFLY = ENTITIES.register("butterfly", () -> EntityType.Builder.of(Butterfly::new, MobCategory.CREATURE).sized(0.5F, 0.3F).clientTrackingRange(10).build(MysticsBiomes.modId + ":butterfly"));
    public static final RegistryObject<EntityType<Caterpillar>> CATERPILLAR = ENTITIES.register("caterpillar", () -> EntityType.Builder.of(Caterpillar::new, MobCategory.CREATURE).sized(0.4F, 0.2F).clientTrackingRange(10).build(MysticsBiomes.modId + ":caterpillar"));

    public static final RegistryObject<EntityType<MysticBoat>> BOAT = ENTITIES.register("boat", () -> EntityType.Builder.<MysticBoat>of(MysticBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build(MysticsBiomes.modId + ":boat"));
    public static final RegistryObject<EntityType<MysticChestBoat>> CHEST_BOAT = ENTITIES.register("chest_boat", () -> EntityType.Builder.<MysticChestBoat>of(MysticChestBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build(MysticsBiomes.modId + ":chest_boat"));

    @SubscribeEvent
    public static void registerEntities(EntityAttributeCreationEvent event) {
        event.put(STRAWBERRY_COW.get(), StrawberryCow.createAttributes().build());
        event.put(RED_PANDA.get(), RedPanda.createAttributes().build());
        event.put(BUTTERFLY.get(), Butterfly.createAttributes().build());
        event.put(CATERPILLAR.get(), Caterpillar.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerEntitySpawns(SpawnPlacementRegisterEvent event) {
        event.register(STRAWBERRY_COW.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(RED_PANDA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(BUTTERFLY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }

    @Mod.EventBusSubscriber(modid = MysticsBiomes.modId, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class Client {

        @SubscribeEvent
        public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(MysticModelLayers.STRAWBERRY_COW, StrawberryCowModel::createBodyLayer);
            event.registerLayerDefinition(MysticModelLayers.BUTTERFLY, ButterflyModel::createBodyLayer);
            event.registerLayerDefinition(MysticModelLayers.CATERPILLAR, CaterpillarModel::createBodyLayer);

            for (MysticBoat.Type type : MysticBoat.Type.values()) {
                event.registerLayerDefinition(MysticBoatRenderer.createBoatModelName(type), BoatModel::createBodyModel);
                event.registerLayerDefinition(MysticBoatRenderer.createChestBoatModelName(type), ChestBoatModel::createBodyModel);
            }
        }

        @SubscribeEvent
        public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(STRAWBERRY_COW.get(), StrawberryCowRenderer::new);
            event.registerEntityRenderer(RED_PANDA.get(), RedPandaRenderer::new);
            event.registerEntityRenderer(BUTTERFLY.get(), ButterflyRenderer::new);
            event.registerEntityRenderer(CATERPILLAR.get(), CaterpillarRenderer::new);

            EntityRenderers.register(BOAT.get(), context -> new MysticBoatRenderer(context, false));
            EntityRenderers.register(CHEST_BOAT.get(), context -> new MysticBoatRenderer(context, true));
        }
    }

}