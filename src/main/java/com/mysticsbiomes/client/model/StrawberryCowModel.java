package com.mysticsbiomes.client.model;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.entity.animal.StrawberryCow;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StrawberryCowModel<T extends StrawberryCow> extends QuadrupedModel<T> {
    public static final ModelLayerLocation LAYER = new ModelLayerLocation(MysticsBiomes.modLoc("strawberry_cow"), "main");

    public StrawberryCowModel(ModelPart part) {
        super(part, false, 10.0F, 4.0F, 2.0F, 2.0F, 24);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition part = mesh.getRoot();
        
        part.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F).texOffs(22, 0).addBox("right_horn", -5.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F).texOffs(22, 0).addBox("left_horn", 4.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F), PartPose.offset(0.0F, 4.0F, -8.0F));
        part.getChild("head").addOrReplaceChild("flowerX", CubeListBuilder.create().texOffs(0, 33).addBox(-4.0F, -7.0F, 0.0F, 8.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(-2.0F, -4.0F, -3.0F, 0.0F, -0.7854F, 0.0F));
        part.getChild("head").getChild("flowerX").addOrReplaceChild("flowerY", CubeListBuilder.create().texOffs(0, 33).addBox(-4.0F, -7.0F, 0.0F, 8.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        part.addOrReplaceChild("body", CubeListBuilder.create().texOffs(18, 4).addBox(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F).texOffs(52, 0).addBox(-2.0F, 2.0F, -8.0F, 4.0F, 6.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 2.0F, ((float)Math.PI / 2F), 0.0F, 0.0F));
        CubeListBuilder builder = CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F);
        part.addOrReplaceChild("right_hind_leg", builder, PartPose.offset(-4.0F, 12.0F, 7.0F));
        part.addOrReplaceChild("left_hind_leg", builder, PartPose.offset(4.0F, 12.0F, 7.0F));
        part.addOrReplaceChild("right_front_leg", builder, PartPose.offset(-4.0F, 12.0F, -6.0F));
        part.addOrReplaceChild("left_front_leg", builder, PartPose.offset(4.0F, 12.0F, -6.0F));

        return LayerDefinition.create(mesh, 64, 48);
    }

}