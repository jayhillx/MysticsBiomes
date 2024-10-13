package com.mysticsbiomes.common.block;

import com.mysticsbiomes.common.block.grower.MysticTreeGrower;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SaplingBlock;

public class MysticSaplingBlock extends SaplingBlock {

    public MysticSaplingBlock(MysticTreeGrower grower, AbstractBlock.Settings properties) {
        super(grower, properties);
    }

}