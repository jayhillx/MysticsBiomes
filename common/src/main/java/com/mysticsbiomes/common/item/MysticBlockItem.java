package com.mysticsbiomes.common.item;

import api.mystanica.registry.RegistryEntry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class MysticBlockItem extends BlockItem {
    private final RegistryEntry<Block> block;

    public MysticBlockItem(RegistryEntry<Block> block, Properties properties) {
        super(null, properties);
        this.block = block;
    }

    @Override
    public Block getBlock() {
        return this.block.get();
    }

}