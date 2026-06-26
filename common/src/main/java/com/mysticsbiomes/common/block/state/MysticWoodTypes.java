package com.mysticsbiomes.common.block.state;

import com.mysticsbiomes.MysticsBiomes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class MysticWoodTypes {

    public static final WoodType STRAWBERRY = register("strawberry", MysticBlockSetTypes.STRAWBERRY);
    public static final WoodType BLACK_CHERRY = register("black_cherry", MysticBlockSetTypes.BLACK_CHERRY, SoundType.CHERRY_WOOD, SoundType.CHERRY_WOOD_HANGING_SIGN, SoundEvents.CHERRY_WOOD_FENCE_GATE_CLOSE, SoundEvents.CHERRY_WOOD_FENCE_GATE_OPEN);
    public static final WoodType LAVENDER = register("lavender", MysticBlockSetTypes.LAVENDER);
    public static final WoodType VANILLA = register("vanilla", MysticBlockSetTypes.VANILLA);
    public static final WoodType PEACH = register("peach", MysticBlockSetTypes.PEACH);
    public static final WoodType MAPLE = register("maple", MysticBlockSetTypes.MAPLE);
    public static final WoodType SPRING = register("spring", MysticBlockSetTypes.SPRING, SoundType.BAMBOO_WOOD, SoundType.BAMBOO_WOOD_HANGING_SIGN, SoundEvents.BAMBOO_WOOD_FENCE_GATE_CLOSE, SoundEvents.BAMBOO_WOOD_FENCE_GATE_OPEN);
    public static final WoodType SEA_FOAM = register("sea_foam", MysticBlockSetTypes.SEA_FOAM);
    public static final WoodType TROPICAL = register("tropical", MysticBlockSetTypes.TROPICAL);

    private static WoodType register(String name, BlockSetType type) {
        return WoodType.register(new WoodType(MysticsBiomes.modId + ":" + name, type));
    }

    private static WoodType register(String name, BlockSetType type, SoundType soundType, SoundType hangingSign, SoundEvent gateClose, SoundEvent gateOpen) {
        return WoodType.register(new WoodType(MysticsBiomes.modId + ":" + name, type, soundType, hangingSign, gateClose, gateOpen));
    }
    
}