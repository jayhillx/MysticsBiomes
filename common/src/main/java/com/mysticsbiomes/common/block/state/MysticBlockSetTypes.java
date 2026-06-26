package com.mysticsbiomes.common.block.state;

import com.mysticsbiomes.MysticsBiomes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class MysticBlockSetTypes {

    public static final BlockSetType STRAWBERRY = register("strawberry");
    public static final BlockSetType BLACK_CHERRY = register("black_cherry", SoundType.CHERRY_WOOD, SoundEvents.CHERRY_WOOD_DOOR_CLOSE, SoundEvents.CHERRY_WOOD_DOOR_OPEN, SoundEvents.CHERRY_WOOD_TRAPDOOR_CLOSE, SoundEvents.CHERRY_WOOD_TRAPDOOR_OPEN, SoundEvents.CHERRY_WOOD_PRESSURE_PLATE_CLICK_OFF, SoundEvents.CHERRY_WOOD_PRESSURE_PLATE_CLICK_ON, SoundEvents.CHERRY_WOOD_BUTTON_CLICK_OFF, SoundEvents.CHERRY_WOOD_BUTTON_CLICK_ON);
    public static final BlockSetType LAVENDER = register("lavender");
    public static final BlockSetType VANILLA = register("vanilla");
    public static final BlockSetType PEACH = register("peach");
    public static final BlockSetType MAPLE = register("maple");
    public static final BlockSetType SPRING = register("spring", SoundType.BAMBOO_WOOD, SoundEvents.BAMBOO_WOOD_DOOR_CLOSE, SoundEvents.BAMBOO_WOOD_DOOR_OPEN, SoundEvents.BAMBOO_WOOD_TRAPDOOR_CLOSE, SoundEvents.BAMBOO_WOOD_TRAPDOOR_OPEN, SoundEvents.BAMBOO_WOOD_PRESSURE_PLATE_CLICK_OFF, SoundEvents.BAMBOO_WOOD_PRESSURE_PLATE_CLICK_ON, SoundEvents.BAMBOO_WOOD_BUTTON_CLICK_OFF, SoundEvents.BAMBOO_WOOD_BUTTON_CLICK_ON);
    public static final BlockSetType SEA_FOAM = register("sea_foam");
    public static final BlockSetType TROPICAL = register("tropical");

    private static BlockSetType register(String name) {
        return BlockSetType.register(new BlockSetType(MysticsBiomes.modId + ":" + name));
    }

    private static BlockSetType register(String name, SoundType type, SoundEvent doorClose, SoundEvent doorOpen, SoundEvent trapDoorClose, SoundEvent trapDoorOpen, SoundEvent pressurePlateOff, SoundEvent pressurePlateOn, SoundEvent buttonOff, SoundEvent buttonOn) {
        return BlockSetType.register(new BlockSetType(MysticsBiomes.modId + ":" + name, true, type, doorClose, doorOpen, trapDoorClose, trapDoorOpen, pressurePlateOff, pressurePlateOn, buttonOff, buttonOn));
    }
    
}