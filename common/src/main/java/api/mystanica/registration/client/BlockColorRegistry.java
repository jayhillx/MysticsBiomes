/*
 * Copyright (c) 2026, Mystanica
 *
 * All rights reserved.
 */
package api.mystanica.registration.client;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.world.level.block.Block;

import java.util.function.BiConsumer;

public class BlockColorRegistry {
    private final BiConsumer<BlockColor, Block[]> registry;

    public BlockColorRegistry(BiConsumer<BlockColor, Block[]> registry) {
        this.registry = registry;
    }

    public void accept(BlockColor color, Block... blocks) {
        this.registry.accept(color, blocks);
    }

}