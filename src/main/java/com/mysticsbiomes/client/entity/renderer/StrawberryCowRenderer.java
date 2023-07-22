package com.mysticsbiomes.client.entity.renderer;

import com.google.common.collect.Maps;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.entity.model.StrawberryCowModel;
import com.mysticsbiomes.common.entity.animal.StrawberryCow;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class StrawberryCowRenderer extends MobRenderer<StrawberryCow, StrawberryCowModel<StrawberryCow>> {
    public static final Map<StrawberryCow.Type, ResourceLocation> TEXTURES = Util.make(Maps.newHashMap(), (map) -> {
        map.put(StrawberryCow.Type.NORMAL, MysticsBiomes.modLoc("textures/entity/strawberry_cow/normal.png"));
        map.put(StrawberryCow.Type.SWEET, MysticsBiomes.modLoc("textures/entity/strawberry_cow/sweet.png"));
    });

    public StrawberryCowRenderer(EntityRendererProvider.Context context) {
        super(context, new StrawberryCowModel<>(context.bakeLayer(StrawberryCowModel.LAYER)), 0.7F);
    }

    @Nonnull
    public ResourceLocation getTextureLocation(StrawberryCow cow) {
        return TEXTURES.get(cow.getVariant());
    }

}