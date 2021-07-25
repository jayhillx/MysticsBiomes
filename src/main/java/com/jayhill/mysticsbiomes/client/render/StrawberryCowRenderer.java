package com.jayhill.mysticsbiomes.client.render;

import com.google.common.collect.Maps;
import com.jayhill.mysticsbiomes.MysticsBiomes;
import com.jayhill.mysticsbiomes.client.StrawberryCowEntity;
import com.jayhill.mysticsbiomes.client.render.layer.FlowersLayer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.CowModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class StrawberryCowRenderer extends MobRenderer<StrawberryCowEntity, CowModel<StrawberryCowEntity>> {
    private static final Map<StrawberryCowEntity.Type, ResourceLocation> STRAWBERRY_COW_TEXTURES = Util.make(Maps.newHashMap(), (textures) -> {
        textures.put(StrawberryCowEntity.Type.PINK, new ResourceLocation(MysticsBiomes.MOD_ID, "textures/entity/cow/strawberry_cow.png"));
        textures.put(StrawberryCowEntity.Type.WHITE, new ResourceLocation(MysticsBiomes.MOD_ID,"textures/entity/cow/sweet_strawberry_cow.png"));
    });

    public StrawberryCowRenderer(EntityRendererManager render) {
        super(render, new CowModel<>(), 0.7F);
        this.addLayer(new FlowersLayer<>(this));
    }

    /** Returns the location of an entity's texture. */
    @Nonnull
    public ResourceLocation getEntityTexture(StrawberryCowEntity entity) {
        return STRAWBERRY_COW_TEXTURES.get(entity.getStrawberryCowType());
    }

}