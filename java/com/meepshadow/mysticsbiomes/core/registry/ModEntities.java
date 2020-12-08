package com.meepshadow.mysticsbiomes.core.registry;

import com.meepshadow.mysticsbiomes.client.entity.StrawberryCowEntity;
import com.meepshadow.mysticsbiomes.client.entity.render.StrawberryCowRenderer;
import com.meepshadow.mysticsbiomes.core.Config;
import com.meepshadow.mysticsbiomes.core.MysticsBiomes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities
{
    public static final DeferredRegister<EntityType<?>> ENTITIES = new DeferredRegister<>(ForgeRegistries.ENTITIES, MysticsBiomes.MOD_ID);

    public static final RegistryObject<EntityType<StrawberryCowEntity>> STRAWBERRY_COW = ENTITIES.register("strawberry_cow",
            () -> EntityType.Builder.create(StrawberryCowEntity::new, EntityClassification.CREATURE).size(0.9F, 1.4F).build(new ResourceLocation(MysticsBiomes.MOD_ID, "strawberry_cow").toString()));

    public static void setupEntitySpawns(Biome biome) {
        if (biome == ModBiomes.STRAWBERRY_FIELD.get()) {
            addEntitySpawn(biome, EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntities.STRAWBERRY_COW.get(), 12, 2, 4));
        }
        if (Config.COMMON.strawberryCowBiomes.get().contains(biome.getRegistryName().toString())) {
            addEntitySpawn(biome, EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntities.STRAWBERRY_COW.get(), 10, 2, 4));
        }
    }

    private static void addEntitySpawn(Biome biome, EntityClassification entityclassification, Biome.SpawnListEntry spawnlistentry) {
        biome.getSpawns(entityclassification).add(spawnlistentry);
    }

    @OnlyIn(Dist.CLIENT)
    public static void setupEntitiesClient() {
        RenderingRegistry.registerEntityRenderingHandler((EntityType<? extends StrawberryCowEntity>)STRAWBERRY_COW.get(), StrawberryCowRenderer::new);
    }
}
