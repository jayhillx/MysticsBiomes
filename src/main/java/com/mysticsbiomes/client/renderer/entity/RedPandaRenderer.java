package com.mysticsbiomes.client.renderer.entity;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.model.entity.RedPandaModel;
import com.mysticsbiomes.client.model.entity.layer.MysticModelLayers;
import com.mysticsbiomes.common.animal.RedPanda;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RedPandaRenderer extends MobRenderer<RedPanda, RedPandaModel<RedPanda>> {
    private static final ResourceLocation NORMAL_TEXTURE = MysticsBiomes.modLoc("textures/entity/red_panda/normal.png");
    private static final ResourceLocation NORMAL_SLEEP_TEXTURE = MysticsBiomes.modLoc("textures/entity/red_panda/normal_sleep.png");

    public RedPandaRenderer(EntityRendererProvider.Context context) {
        super(context, new RedPandaModel<>(context.bakeLayer(MysticModelLayers.RED_PANDA)), 0.4F);
    }

    public ResourceLocation getTextureLocation(RedPanda entity) {
        return entity.isSleeping() ? NORMAL_SLEEP_TEXTURE : NORMAL_TEXTURE;
    }

}