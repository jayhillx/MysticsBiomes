package com.mysticsbiomes.common.block.state;

import com.mysticsbiomes.MysticsBiomes;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;

public class MysticWoodTypes {

    public static final WoodType STRAWBERRY = register("strawberry", MysticBlockSetTypes.STRAWBERRY);
    public static final WoodType CHERRY = register("cherry", MysticBlockSetTypes.CHERRY);
    public static final WoodType PEACH = register("peach", MysticBlockSetTypes.PEACH);
    public static final WoodType MAPLE = register("maple", MysticBlockSetTypes.MAPLE);
    public static final WoodType SEA_FOAM = register("sea_foam", MysticBlockSetTypes.SEA_FOAM);
    public static final WoodType TROPICAL = register("tropical", MysticBlockSetTypes.TROPICAL);
    public static final WoodType JACARANDA = register("jacaranda", MysticBlockSetTypes.JACARANDA);

    private static WoodType register(String name, BlockSetType blockSet) {
        return new WoodType(MysticsBiomes.modId + ":" + name, blockSet);
    }

}