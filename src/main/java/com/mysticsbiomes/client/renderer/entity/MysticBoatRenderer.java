package com.mysticsbiomes.client.renderer.entity;

import com.google.common.collect.ImmutableMap;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.entity.MysticBoat;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;

import java.util.Map;
import java.util.stream.Stream;

public class MysticBoatRenderer extends BoatRenderer {
    private final Map<MysticBoat.Type, Pair<ResourceLocation, BoatModel>> boatResources;

    public MysticBoatRenderer(EntityRendererProvider.Context context, boolean hasChest) {
        super(context, false);
        this.boatResources = Stream.of(MysticBoat.Type.values()).collect(ImmutableMap.toImmutableMap((key) -> key, (model) -> Pair.of(MysticsBiomes.modLoc(getTextureLocation(model, hasChest)), this.createBoatModel(context, model, hasChest))));
    }

    @Override
    public Pair<ResourceLocation, BoatModel> getModelWithLocation(Boat boat) {
        return this.boatResources.get(boat.getBoatType());
    }

    private static String getTextureLocation(MysticBoat.Type type, boolean hasChest) {
        return hasChest ? "textures/entity/boats/chest/" + type.getName() + ".png" : "textures/entity/boats/" + type.getName() + ".png";
    }

    private static ModelLayerLocation createLocation(String name) {
        return new ModelLayerLocation(MysticsBiomes.modLoc(name), "main");
    }

    public static ModelLayerLocation createBoatModelName(MysticBoat.Type type) {
        return createLocation("boats/" + type.getName());
    }

    public static ModelLayerLocation createChestBoatModelName(MysticBoat.Type type) {
        return createLocation("boats/chest/" + type.getName());
    }

    private BoatModel createBoatModel(EntityRendererProvider.Context context, MysticBoat.Type type, boolean hasChest) {
        ModelLayerLocation location = hasChest ? createChestBoatModelName(type) : createBoatModelName(type);
        ModelPart baked = context.bakeLayer(location);
        return hasChest ? new BoatModel(baked, true) : new BoatModel(baked, false);
    }

}