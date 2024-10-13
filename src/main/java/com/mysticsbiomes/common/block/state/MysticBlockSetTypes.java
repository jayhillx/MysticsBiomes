package com.mysticsbiomes.common.block.state;

import com.mysticsbiomes.MysticsBiomes;
import net.minecraft.block.BlockSetType;

public class MysticBlockSetTypes {

    public static final BlockSetType STRAWBERRY = register("strawberry");
    public static final BlockSetType CHERRY = register("cherry");
    public static final BlockSetType PEACH = register("peach");
    public static final BlockSetType MAPLE = register("maple");
    public static final BlockSetType SEA_FOAM = register("sea_foam");
    public static final BlockSetType TROPICAL = register("tropical");
    public static final BlockSetType JACARANDA = register("jacaranda");

    private static BlockSetType register(String name) {
        return new BlockSetType(MysticsBiomes.modId + ":" + name);
    }

}