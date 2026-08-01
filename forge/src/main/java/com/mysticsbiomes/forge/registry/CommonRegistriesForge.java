package com.mysticsbiomes.forge.registry;

import api.mystanica.registration.EntityAttributeRegistry;
import api.mystanica.registration.EntitySpawnPlacementRegistry;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.handler.CraftingHandler;
import com.mysticsbiomes.init.MysticEntities;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MysticsBiomes.modId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonRegistriesForge {

    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        MysticEntities.registerEntityAttributes(new EntityAttributeRegistry((entity, attributes) -> {
            event.put(entity, attributes.get().build());
        }));
    }

    @SubscribeEvent
    public static void registerEntitySpawnPlacements(SpawnPlacementRegisterEvent event) {
        MysticEntities.registerEntitySpawnPlacements(new EntitySpawnPlacementRegistry(placement -> {
            registerSpawnPlacement(event, placement);
        }));
    }

    private static <T extends Mob> void registerSpawnPlacement(SpawnPlacementRegisterEvent event, EntitySpawnPlacementRegistry.Builder<T> placement) {
        event.register(
                placement.entity(),
                placement.placementType(),
                placement.heightmap(),
                placement.predicate(),
                SpawnPlacementRegisterEvent.Operation.REPLACE
        );
    }

    @SubscribeEvent
    public void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
        if (event.getEntity() instanceof ServerPlayer serverPlayer) {
            CraftingHandler.onItemCrafted(serverPlayer, event.getCrafting());
        }
    }

}