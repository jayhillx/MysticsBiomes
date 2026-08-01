package com.mysticsbiomes.common.worldgen.feature.tree.provider;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;

public class FoliageShapeProvider {
    public static final Codec<FoliageShapeProvider> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            IntProvider.codec(0, 16).fieldOf("foliage_radius").forGetter(config -> config.foliageRadius),
            IntProvider.codec(0, 16).fieldOf("foliage_height").forGetter(config -> config.foliageHeight)
    ).apply(instance, FoliageShapeProvider::new));
    public final IntProvider foliageRadius;
    public final IntProvider foliageHeight;

    public FoliageShapeProvider(IntProvider foliageRadius, IntProvider foliageHeight) {
        this.foliageRadius = foliageRadius;
        this.foliageHeight = foliageHeight;
    }

}