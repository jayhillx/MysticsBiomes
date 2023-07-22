package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.entity.model.StrawberryCowModel;
import com.mysticsbiomes.client.entity.renderer.BoatRenderer;
import com.mysticsbiomes.client.entity.renderer.RedPandaRenderer;
import com.mysticsbiomes.client.entity.renderer.StrawberryCowRenderer;
import com.mysticsbiomes.common.entity.animal.RedPanda;
import com.mysticsbiomes.common.entity.vehicle.Boat;
import com.mysticsbiomes.common.entity.vehicle.ChestBoat;
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

    // Animals
    public static final RegistryObject<EntityType<StrawberryCow>> STRAWBERRY_COW = ENTITIES.register("strawberry_cow", () -> EntityType.Builder.of(StrawberryCow::new, MobCategory.CREATURE).sized(0.9F, 1.4F).clientTrackingRange(10).build(MysticsBiomes.modId + ":strawberry_cow"));
    public static final RegistryObject<EntityType<RedPanda>> RED_PANDA = ENTITIES.register("red_panda", () -> EntityType.Builder.of(RedPanda::new, MobCategory.CREATURE).sized(0.9F, 1.4F).clientTrackingRange(10).build(MysticsBiomes.modId + ":red_panda"));

    // Vehicles
    public static final RegistryObject<EntityType<Boat>> BOAT = ENTITIES.register("boat", () -> EntityType.Builder.<Boat>of(Boat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build(MysticsBiomes.modId + ":boat"));
    public static final RegistryObject<EntityType<ChestBoat>> CHEST_BOAT = ENTITIES.register("chest_boat", () -> EntityType.Builder.<ChestBoat>of(ChestBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build(MysticsBiomes.modId + ":chest_boat"));

    @SubscribeEvent
    public static void registerEntities(EntityAttributeCreationEvent event) {
        event.put(STRAWBERRY_COW.get(), StrawberryCow.createAttributes().build());
        event.put(RED_PANDA.get(), RedPanda.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerEntitySpawns(SpawnPlacementRegisterEvent event) {
        event.register(STRAWBERRY_COW.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(RED_PANDA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }

    /**
     * Client sided events & setups for entity renderers, layers, etc.
     */
    @Mod.EventBusSubscriber(modid = MysticsBiomes.modId, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class Client {

        @SubscribeEvent
        public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(StrawberryCowModel.LAYER, StrawberryCowModel::createBodyLayer);

            for (Boat.Type type : Boat.Type.values()) {
                event.registerLayerDefinition(BoatRenderer.createBoatModelName(type), BoatModel::createBodyModel);
                event.registerLayerDefinition(BoatRenderer.createChestBoatModelName(type), ChestBoatModel::createBodyModel);
            }
        }

        @SubscribeEvent
        public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(STRAWBERRY_COW.get(), StrawberryCowRenderer::new);
            event.registerEntityRenderer(RED_PANDA.get(), RedPandaRenderer::new);

            EntityRenderers.register(BOAT.get(), context -> new BoatRenderer(context, false));
            EntityRenderers.register(CHEST_BOAT.get(), context -> new BoatRenderer(context, true));
        }
    }

}