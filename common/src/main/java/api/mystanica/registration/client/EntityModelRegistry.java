/*
 * Copyright (c) 2026, Mystanica
 *
 * All rights reserved.
 */
package api.mystanica.registration.client;

import com.mysticsbiomes.client.entity.model.layer.ModelLayerProvider;
import net.minecraft.client.model.geom.ModelLayerLocation;

import java.util.function.BiConsumer;

public class EntityModelRegistry {
    private final BiConsumer<ModelLayerLocation, ModelLayerProvider> registry;

    public EntityModelRegistry(BiConsumer<ModelLayerLocation, ModelLayerProvider> registry) {
        this.registry = registry;
    }

    public void accept(ModelLayerLocation layer, ModelLayerProvider definition) {
        this.registry.accept(layer, definition);
    }

}