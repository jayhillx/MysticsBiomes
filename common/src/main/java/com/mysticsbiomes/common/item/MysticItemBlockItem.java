package com.mysticsbiomes.common.item;

import api.mystanica.registry.RegistryEntry;
import net.minecraft.world.level.block.Block;

public class MysticItemBlockItem extends MysticBlockItem {

    public MysticItemBlockItem(RegistryEntry<Block> block, Properties properties) {
        super(block, properties);
    }

    @Override
    public String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }

}