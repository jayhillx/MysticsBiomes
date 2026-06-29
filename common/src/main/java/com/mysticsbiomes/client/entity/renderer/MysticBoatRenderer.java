package com.mysticsbiomes.client.entity.renderer;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Axis;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.entity.vehicle.MysticBoat;
import com.mysticsbiomes.common.entity.vehicle.MysticChestBoat;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.vehicle.Boat;
import org.joml.Quaternionf;

import java.util.Map;
import java.util.stream.Stream;

public class MysticBoatRenderer extends EntityRenderer<Boat> {
    private final Map<MysticBoat.Type, Pair<ResourceLocation, ListModel<Boat>>> boatResources;

    public MysticBoatRenderer(EntityRendererProvider.Context context, boolean hasChest) {
        super(context);
        this.shadowRadius = 0.8F;
        this.boatResources = Stream.of(MysticBoat.Type.values()).collect(ImmutableMap.toImmutableMap((type) -> type, (type) -> {
            return Pair.of(MysticsBiomes.modLoc(getTextureLocation(type, hasChest)), this.createBoatModel(context, type, hasChest));
        }));
    }

    @Override
    public ResourceLocation getTextureLocation(Boat boat) {
        return this.getModelWithLocation(boat).getFirst();
    }

    public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
        if (boat instanceof MysticChestBoat chestBoat) {
            return this.boatResources.get(chestBoat.getModel());
        } else {
            return this.boatResources.get(((MysticBoat)boat).getModel());
        }
    }

    private ListModel<Boat> createBoatModel(EntityRendererProvider.Context context, MysticBoat.Type type, boolean hasChest) {
        ModelLayerLocation location = hasChest ? createChestBoatModelName(type) : createBoatModelName(type);
        ModelPart baked = context.bakeLayer(location);
        ///if (type == MysticBoat.Type.SPRING) {
        ///    return hasChest ? new ChestRaftModel(baked) : new RaftModel(baked);
        ///} else {
        ///    return hasChest ? new ChestBoatModel(baked) : new BoatModel(baked);
        ///}
        return hasChest ? new ChestBoatModel(baked) : new BoatModel(baked);
    }

    private static String getTextureLocation(MysticBoat.Type type, boolean hasChest) {
        return hasChest ? "textures/entity/boats/chest/" + type.getName() + ".png" : "textures/entity/boats/" + type.getName() + ".png";
    }

    public static ModelLayerLocation createBoatModelName(MysticBoat.Type type) {
        return createLocation("boats/" + type.getName());
    }

    public static ModelLayerLocation createChestBoatModelName(MysticBoat.Type type) {
        return createLocation("boats/chest/" + type.getName());
    }

    private static ModelLayerLocation createLocation(String name) {
        return new ModelLayerLocation(MysticsBiomes.modLoc(name), "main");
    }

    @Override
    public void render(Boat boat, float f, float g, PoseStack stack, MultiBufferSource source, int i) {
        if (boat instanceof MysticBoat || boat instanceof MysticChestBoat) {
            stack.pushPose();
            stack.translate(0.0F, 0.375F, 0.0F);
            stack.mulPose(Axis.YP.rotationDegrees(180.0F - f));
            float h = boat.getHurtTime() - g;
            float j = boat.getDamage() - g;
            if (j < 0.0F) {
                j = 0.0F;
            }

            if (h > 0.0F) {
                stack.mulPose(Axis.XP.rotationDegrees(Mth.sin(h) * h * j / 10.0F * boat.getHurtDir()));
            }

            float angle = boat.getBubbleAngle(g);
            if (!Mth.equal(angle, 0.0F)) {
                stack.mulPose(new Quaternionf().setAngleAxis(angle * (float) (Math.PI / 180.0), 1.0F, 0.0F, 1.0F));
            }

            MysticBoat.Type type;
            if (boat instanceof MysticChestBoat chestBoat) {
                type = chestBoat.getModel();
            } else {
                type = ((MysticBoat)boat).getModel();
            }

            Pair<ResourceLocation, ListModel<Boat>> pair = this.boatResources.get(type);
            ListModel<Boat> list = pair.getSecond();
            stack.scale(-1.0F, -1.0F, 1.0F);
            stack.mulPose(Axis.YP.rotationDegrees(90.0F));
            list.setupAnim(boat, g, 0.0F, -0.1F, 0.0F, 0.0F);
            list.renderToBuffer(stack, source.getBuffer(list.renderType(pair.getFirst())), i, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

            if (!boat.isUnderWater()) {
                if (list instanceof WaterPatchModel model) {
                    model.waterPatch().render(stack, source.getBuffer(RenderType.waterMask()), i, OverlayTexture.NO_OVERLAY);
                }
            }

            stack.popPose();
            super.render(boat, f, g, stack, source, i);
        } else {
            super.render(boat, f, g, stack, source, i);
        }
    }

}