package com.meepshadow.mysticsbiomes.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ModPlanks extends Block {

    public ModPlanks() {
        super(Properties.create(Material.WOOD)
                .hardnessAndResistance(2.0f, 3.0f)
                .sound(SoundType.WOOD)
                .harvestLevel(0)
                .harvestTool(ToolType.AXE));
    }
}
