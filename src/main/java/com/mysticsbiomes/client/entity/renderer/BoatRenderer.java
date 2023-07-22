package com.mysticsbiomes.client.entity.renderer;

import com.google.common.collect.ImmutableMap;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.entity.vehicle.Boat;
import com.mysticsbiomes.common.entity.vehicle.ChestBoat;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.stream.Stream;

public class BoatRenderer extends net.minecraft.client.renderer.entity.BoatRenderer {
    private final Map<Boat.Type, Pair<ResourceLocation, ListModel<net.minecraft.world.entity.vehicle.Boat>>> boatResources;

    public BoatRenderer(EntityRendererProvider.Context context, boolean hasChest) {
        super(context, false);
        this.boatResources = Stream.of(Boat.Type.values()).collect(ImmutableMap.toImmutableMap((key) -> key, (model) -> Pair.of(MysticsBiomes.modLoc(getTextureLocation(model, hasChest)), createBoatModel(context, model, hasChest))));
    }

    @Nonnull
    @Override
    public Pair<ResourceLocation, ListModel<net.minecraft.world.entity.vehicle.Boat>> getModelWithLocation(@Nonnull net.minecraft.world.entity.vehicle.Boat boat) {
        if (boat instanceof ChestBoat) {
            return this.boatResources.get(((ChestBoat)boat).getModel());
        } else {
            return this.boatResources.get(((Boat)boat).getModel());
        }
    }

    private static String getTextureLocation(Boat.Type type, boolean hasChest) {
        return hasChest ? "textures/entity/boats/chest/" + type.getName() + ".png" : "textures/entity/boats/" + type.getName() + ".png";
    }

    private static ModelLayerLocation createLocation(String name) {
        return new ModelLayerLocation(MysticsBiomes.modLoc(name), "main");
    }

    public static ModelLayerLocation createBoatModelName(Boat.Type type) {
        return createLocation("boats/" + type.getName());
    }

    public static ModelLayerLocation createChestBoatModelName(Boat.Type type) {
        return createLocation("boats/chest/" + type.getName());
    }

    private BoatModel createBoatModel(EntityRendererProvider.Context context, Boat.Type type, boolean hasChest) {
        ModelLayerLocation location = hasChest ? createChestBoatModelName(type) : createBoatModelName(type);
        ModelPart baked = context.bakeLayer(location);
        return hasChest ? new ChestBoatModel(baked) : new BoatModel(baked);
    }

}