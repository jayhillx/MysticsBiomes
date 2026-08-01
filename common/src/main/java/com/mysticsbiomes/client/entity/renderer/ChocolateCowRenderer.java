package com.mysticsbiomes.client.entity.renderer;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.entity.model.MysticCowModel;
import com.mysticsbiomes.client.entity.model.layer.MysticModelLayers;
import com.mysticsbiomes.common.entity.animal.AnimalVariants;
import com.mysticsbiomes.common.entity.animal.ChocolateCow;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class ChocolateCowRenderer extends MobRenderer<ChocolateCow, MysticCowModel<ChocolateCow>> {
    private static final Map<AnimalVariants, ResourceLocation> TEXTURES = Util.make(new HashMap<>(), (map) -> {
        map.put(AnimalVariants.STANDARD, MysticsBiomes.modLoc("textures/entity/cows/chocolate/chocolate_cow.png"));
        map.put(AnimalVariants.VARIANT, MysticsBiomes.modLoc("textures/entity/cows/chocolate/chocolate_cow_variant.png"));
    });

    public ChocolateCowRenderer(EntityRendererProvider.Context context) {
        super(context, new MysticCowModel<>(context.bakeLayer(MysticModelLayers.CHOCOLATE_COW)), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(ChocolateCow cow) {
        return TEXTURES.get(cow.getVariant());
    }

}