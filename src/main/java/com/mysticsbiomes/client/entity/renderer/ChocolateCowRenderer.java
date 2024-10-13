package com.mysticsbiomes.client.entity.renderer;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.entity.model.layer.MysticModelLayers;
import com.mysticsbiomes.common.entity.animal.ChocolateCow;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ChocolateCowRenderer extends MobEntityRenderer<ChocolateCow, CowEntityModel<ChocolateCow>> {

    public ChocolateCowRenderer(EntityRendererFactory.Context context) {
        super(context, new CowEntityModel<>(context.getPart(MysticModelLayers.CHOCOLATE_COW)), 0.7F);
    }

    @Override
    public Identifier getTexture(ChocolateCow cow) {
        return MysticsBiomes.modLoc("textures/entity/cows/chocolate_cow.png");
    }

}