package com.mysticsbiomes.common.block.state;

import com.mysticsbiomes.MysticsBiomes;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static net.minecraft.world.level.block.state.properties.WoodType.register;

public class MysticBlockSetTypes {

    public static final BlockSetType STRAWBERRY = BlockSetType.register(new BlockSetType(MysticsBiomes.modId + ":strawberry"));
    public static final BlockSetType CHERRY = BlockSetType.register(new BlockSetType(MysticsBiomes.modId + ":cherry"));
    public static final BlockSetType JACARANDA = BlockSetType.register(new BlockSetType(MysticsBiomes.modId + ":jacaranda"));
    public static final BlockSetType MAPLE = BlockSetType.register(new BlockSetType(MysticsBiomes.modId + ":maple"));

}