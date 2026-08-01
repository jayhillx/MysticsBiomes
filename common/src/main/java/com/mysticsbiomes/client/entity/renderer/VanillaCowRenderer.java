package com.mysticsbiomes.client.entity.renderer;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.entity.model.MysticCowModel;
import com.mysticsbiomes.client.entity.model.layer.MysticModelLayers;
import com.mysticsbiomes.common.entity.animal.AnimalVariants;
import com.mysticsbiomes.common.entity.animal.VanillaCow;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class VanillaCowRenderer extends MobRenderer<VanillaCow, MysticCowModel<VanillaCow>> {
    private static final Map<AnimalVariants, ResourceLocation> TEXTURES = Util.make(new HashMap<>(), (map) -> {
        map.put(AnimalVariants.STANDARD, MysticsBiomes.modLoc("textures/entity/cows/vanilla/vanilla_cow.png"));
        map.put(AnimalVariants.VARIANT, MysticsBiomes.modLoc("textures/entity/cows/vanilla/vanilla_cow_variant.png"));
    });

    public VanillaCowRenderer(EntityRendererProvider.Context context) {
        super(context, new MysticCowModel<>(context.bakeLayer(MysticModelLayers.VANILLA_COW)), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(VanillaCow cow) {
        return TEXTURES.get(cow.getVariant());
    }

}