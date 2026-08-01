package com.mysticsbiomes.client.entity.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.entity.model.ButterflyModel;
import com.mysticsbiomes.common.entity.animal.Butterfly;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class NectarLayer extends RenderLayer<Butterfly, ButterflyModel<Butterfly>> {
    private static final ResourceLocation TEXTURE = MysticsBiomes.modLoc("textures/entity/butterfly/nectar_layer.png");

    public NectarLayer(RenderLayerParent<Butterfly, ButterflyModel<Butterfly>> parent) {
        super(parent);
    }

    @Override
    public void render(PoseStack stack, MultiBufferSource buffer, int packedLight, Butterfly entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.hasNectar()) {
            renderColoredCutoutModel(this.getParentModel(), TEXTURE, stack, buffer, packedLight, entity, 1.0F, 1.0F, 1.0F);
        }
    }

}