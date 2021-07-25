package com.jayhill.mysticsbiomes.init;

import com.jayhill.mysticsbiomes.MysticsBiomes;
import com.jayhill.mysticsbiomes.client.StrawberryCowEntity;
import com.jayhill.mysticsbiomes.client.render.StrawberryCowRenderer;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MysticEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MysticsBiomes.MOD_ID);

    /** Strawberry Cow */
    public static final RegistryObject<EntityType<StrawberryCowEntity>> STRAWBERRY_COW = ENTITIES.register("strawberry_cow", () -> EntityType.Builder.create(StrawberryCowEntity::new, EntityClassification.CREATURE).size(0.9F, 1.4F).trackingRange(10).build(new ResourceLocation(MysticsBiomes.MOD_ID, "strawberry_cow").toString()));

    public static void registerEntities() {
        GlobalEntityTypeAttributes.put(STRAWBERRY_COW.get(), StrawberryCowEntity.registerAttributes().create());
    }

    public static void registerEntitySpawns() {
        EntitySpawnPlacementRegistry.register(STRAWBERRY_COW.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canAnimalSpawn);
    }

    public static void setupEntitiesClient() {
        RenderingRegistry.registerEntityRenderingHandler(STRAWBERRY_COW.get(), StrawberryCowRenderer::new);
    }
    
}