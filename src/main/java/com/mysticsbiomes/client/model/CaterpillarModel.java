package com.mysticsbiomes.client.model;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.animation.CaterpillarAnimation;
import com.mysticsbiomes.common.entity.animal.Caterpillar;
import net.minecraft.client.model.HierarchicalModel;
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
public class CaterpillarModel<T extends Caterpillar> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER = new ModelLayerLocation(MysticsBiomes.modLoc("caterpillar"), "main");

    private final ModelPart root;

    public CaterpillarModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        root.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
        root.getChild("root").addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        root.getChild("root").getChild("body").addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -4.5F, -1.5F, 3.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(-0.5F, -1.5F, 0.5F, 1.5708F, 0.0F, 0.0F));
        root.getChild("root").addOrReplaceChild("antennae", CubeListBuilder.create(), PartPose.offset(-0.5F, -2.0F, -4.0F));
        root.getChild("root").getChild("antennae").addOrReplaceChild("left_antennae_r1", CubeListBuilder.create().texOffs(0, 9).addBox(0.0F, -1.6888F, -1.8415F, 0.0F, 2.0F, 3.0F).texOffs(0, 9).addBox(-2.0F, -1.6888F, -1.8415F, 0.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));
        return LayerDefinition.create(mesh, 24, 16);
    }

    @Override
    public void setupAnim(T entity, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.animateWalk(CaterpillarAnimation.CATERPILLAR_MOVE, p_102619_ * 10, p_102620_ * 10, 2.0F, 2.5F);
        this.animate(entity.verticalState, CaterpillarAnimation.CATERPILLAR_VERTICAL, p_102621_);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

}