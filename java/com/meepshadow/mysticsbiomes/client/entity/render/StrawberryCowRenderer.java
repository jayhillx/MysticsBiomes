package com.meepshadow.mysticsbiomes.client.entity.render;

import com.google.common.collect.Maps;
import java.util.Map;

import com.meepshadow.mysticsbiomes.client.entity.StrawberryCowEntity;
import com.meepshadow.mysticsbiomes.core.MysticsBiomes;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.CowModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StrawberryCowRenderer extends MobRenderer<StrawberryCowEntity, CowModel<StrawberryCowEntity>> {
    private static final Map<StrawberryCowEntity.Type, ResourceLocation> field_217774_a = Util.make(Maps.newHashMap(), (p_217773_0_) -> {
        p_217773_0_.put(StrawberryCowEntity.Type.PINK, new ResourceLocation(MysticsBiomes.MOD_ID, "textures/entity/cow/strawberry_cow.png"));
        p_217773_0_.put(StrawberryCowEntity.Type.RED, new ResourceLocation(MysticsBiomes.MOD_ID, "textures/entity/cow/strawberry_cow.png"));
    });

    public StrawberryCowRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new CowModel<>(), 0.7F);
        this.addLayer(new StrawberryBushLayer<>(this));
    }

    public ResourceLocation getEntityTexture(StrawberryCowEntity entity) {
        return field_217774_a.get(entity.getStrawberryCowType());
    }
}
