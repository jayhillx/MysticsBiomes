package com.mysticsbiomes.client.entity.renderer;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.entity.model.MysticCowModel;
import com.mysticsbiomes.client.entity.model.layer.MysticModelLayers;
import com.mysticsbiomes.common.entity.animal.AnimalVariants;
import com.mysticsbiomes.common.entity.animal.StrawberryCow;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class StrawberryCowRenderer extends MobRenderer<StrawberryCow, MysticCowModel<StrawberryCow>> {
    private static final Map<AnimalVariants, ResourceLocation> TEXTURES = Util.make(new HashMap<>(), (map) -> {
        map.put(AnimalVariants.STANDARD, MysticsBiomes.modLoc("textures/entity/cows/strawberry/strawberry_cow.png"));
        map.put(AnimalVariants.VARIANT, MysticsBiomes.modLoc("textures/entity/cows/strawberry/strawberry_cow_variant.png"));
    });

    public StrawberryCowRenderer(EntityRendererProvider.Context context) {
        super(context, new MysticCowModel<>(context.bakeLayer(MysticModelLayers.STRAWBERRY_COW)), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(StrawberryCow cow) {
        return TEXTURES.get(cow.getVariant());
    }

}