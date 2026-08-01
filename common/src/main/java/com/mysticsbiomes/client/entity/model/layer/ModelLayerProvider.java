package com.mysticsbiomes.client.entity.model.layer;

import net.minecraft.client.model.geom.builders.LayerDefinition;

@FunctionalInterface
public interface ModelLayerProvider {
    LayerDefinition create();
}