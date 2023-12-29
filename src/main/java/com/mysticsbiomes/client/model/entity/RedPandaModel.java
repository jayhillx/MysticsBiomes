package com.mysticsbiomes.client.model.entity;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.entity.animal.RedPanda;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RedPandaModel<T extends RedPanda> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER = new ModelLayerLocation(new ResourceLocation(MysticsBiomes.modId, "red_panda"), "main");
    private final ModelPart root;

    public RedPandaModel(ModelPart part) {
        this.root = part.getChild("root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition part = mesh.getRoot();
        PartDefinition root = part.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
        root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(1, 5).addBox(-3.5F, -3.5F, -6.0F, 8.0F, 6.0F, 6.0F).texOffs(15, 1).addBox(-3.5F, -5.5F, -4.0F, 2.0F, 2.0F, 1.0F).texOffs(8, 1).addBox(2.5F, -5.5F, -4.0F, 2.0F, 2.0F, 1.0F).texOffs(8, 20).addBox(-1.5F, 0.5F, -7.0F, 4.0F, 2.0F, 1.0F), PartPose.offset(-0.5F, -6.0F, -3.0F));
        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(24, 17).addBox(-3.0F, -5.0F, -2.0F, 6.0F, 10.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -6.0F, 2.0F, 1.5708F, 0.0F, 0.0F));
        root.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(13, 25).addBox(-1.005F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offset(-2.0F, -6.0F, -1.0F));
        root.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(4, 25).addBox(-0.995F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offset(2.0F, -6.0F, -1.0F));
        root.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(13, 25).addBox(-1.005F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offset(-2.0F, -6.0F, 5.0F));
        root.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(4, 25).addBox(-0.995F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offset(2.0F, -6.0F, 5.0F));
        root.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(30, 0).addBox(-2.0F, -2.0F, -2.5F, 4.0F, 11.0F, 5.0F), PartPose.offsetAndRotation(0.0F, -7.0F, 7.0F, 1.5708F, 0.0F, 0.0F));
        return LayerDefinition.create(mesh, 64, 48);
    }

    public void setupAnim(T entity, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

    }

    @Override
    public ModelPart root() {
        return this.root;
    }

}