package com.mysticsbiomes.client.entity.renderer;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.entity.MysticBoat;
import com.mysticsbiomes.common.entity.MysticChestBoat;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.*;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.Identifier;

import java.util.Map;
import java.util.stream.Stream;

public class MysticBoatRenderer extends BoatEntityRenderer {
    private final Map<MysticBoat.Type, Pair<Identifier, CompositeEntityModel<BoatEntity>>> boatResources;

    public MysticBoatRenderer(EntityRendererFactory.Context context, boolean hasChest) {
        super(context, false);
        this.boatResources = Stream.of(MysticBoat.Type.values()).collect(ImmutableMap.toImmutableMap((key) -> key, (model) -> Pair.of(MysticsBiomes.modLoc(getTextureLocation(model, hasChest)), this.createBoatModel(context, model, hasChest))));
    }

    @Override
    public Identifier getTexture(BoatEntity boat) {
        if (boat instanceof MysticChestBoat chestBoat) {
            return this.boatResources.get((chestBoat).getModel()).getFirst();
        } else {
            return this.boatResources.get(((MysticBoat)boat).getModel()).getFirst();
        }
    }

    private static String getTextureLocation(MysticBoat.Type type, boolean hasChest) {
        return hasChest ? "textures/entity/boats/chest/" + type.getName() + ".png" : "textures/entity/boats/" + type.getName() + ".png";
    }

    private static EntityModelLayer createLocation(String name) {
        return new EntityModelLayer(MysticsBiomes.modLoc(name), "main");
    }

    public static EntityModelLayer createBoatModelName(MysticBoat.Type type) {
        return createLocation("boats/" + type.getName());
    }

    public static EntityModelLayer createChestBoatModelName(MysticBoat.Type type) {
        return createLocation("boats/chest/" + type.getName());
    }

    private BoatEntityModel createBoatModel(EntityRendererFactory.Context context, MysticBoat.Type type, boolean hasChest) {
        EntityModelLayer location = hasChest ? createChestBoatModelName(type) : createBoatModelName(type);
        ModelPart baked = context.getPart(location);
        return hasChest ? new ChestBoatEntityModel(baked) : new BoatEntityModel(baked);
    }

}