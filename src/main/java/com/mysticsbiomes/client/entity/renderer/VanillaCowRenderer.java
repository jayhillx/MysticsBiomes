package com.mysticsbiomes.client.entity.renderer;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.entity.model.layer.MysticModelLayers;
import com.mysticsbiomes.common.entity.animal.VanillaCow;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class VanillaCowRenderer extends MobEntityRenderer<VanillaCow, CowEntityModel<VanillaCow>> {

    public VanillaCowRenderer(EntityRendererFactory.Context context) {
        super(context, new CowEntityModel<>(context.getPart(MysticModelLayers.VANILLA_COW)), 0.7F);
    }

    @Override
    public Identifier getTexture(VanillaCow cow) {
        return MysticsBiomes.modLoc("textures/entity/cows/vanilla_cow.png");
    }

}