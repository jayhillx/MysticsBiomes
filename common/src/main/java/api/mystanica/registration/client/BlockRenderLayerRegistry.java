/*
 * Copyright (c) 2026, Mystanica
 *
 * All rights reserved.
 */
package api.mystanica.registration.client;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;

import java.util.function.BiConsumer;

public class BlockRenderLayerRegistry {
    private final BiConsumer<Block, RenderType> registry;

    public BlockRenderLayerRegistry(BiConsumer<Block, RenderType> registry) {
        this.registry = registry;
    }

    public void accept(Block block, RenderType layer) {
        this.registry.accept(block, layer);
    }

}