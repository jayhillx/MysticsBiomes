package com.meepshadow.mysticsbiomes.common.util.library;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class BlockProperties {
    public static Block.Properties DANDELION_LOG(boolean stripped) {
        MaterialColor color = stripped ? MaterialColor.YELLOW : MaterialColor.YELLOW;
        return Block.Properties.create(Material.WOOD, color).hardnessAndResistance(2.0F).sound(SoundType.WOOD);
    }
    public static Block.Properties EVERGREEN_LOG(boolean stripped) {
        MaterialColor color = stripped ? MaterialColor.LIME : MaterialColor.LIME;
        return Block.Properties.create(Material.WOOD, color).hardnessAndResistance(2.0F).sound(SoundType.WOOD);
    }
    public static Block.Properties SEAFOAM_LOG(boolean stripped) {
        MaterialColor color = stripped ? MaterialColor.CYAN : MaterialColor.CYAN;
        return Block.Properties.create(Material.WOOD, color).hardnessAndResistance(2.0F).sound(SoundType.WOOD);
    }
    public static Block.Properties WISP_LOG(boolean stripped) {
        MaterialColor color = stripped ? MaterialColor.PURPLE : MaterialColor.LIGHT_BLUE;
        return Block.Properties.create(Material.WOOD, color).hardnessAndResistance(2.0F).sound(SoundType.WOOD);
    }
    public static Block.Properties FROSTED_LOG(boolean stripped) {
        MaterialColor color = stripped ? MaterialColor.LIGHT_BLUE : MaterialColor.LIGHT_BLUE;
        return Block.Properties.create(Material.WOOD, color).hardnessAndResistance(2.0F).sound(SoundType.WOOD);
    }
    public static Block.Properties TROPICAL_LOG(boolean stripped) {
        MaterialColor color = stripped ? MaterialColor.BLUE : MaterialColor.BLUE;
        return Block.Properties.create(Material.WOOD, color).hardnessAndResistance(2.0F).sound(SoundType.WOOD);
    }
    public static Block.Properties STRAWBERRRY_LOG(boolean stripped) {
        MaterialColor color = stripped ? MaterialColor.PINK : MaterialColor.PINK;
        return Block.Properties.create(Material.WOOD, color).hardnessAndResistance(2.0F).sound(SoundType.WOOD);
    }
    public static Block.Properties SWEET_LOG(boolean stripped) {
        MaterialColor color = stripped ? MaterialColor.PINK : MaterialColor.PINK;
        return Block.Properties.create(Material.WOOD, color).hardnessAndResistance(2.0F).sound(SoundType.WOOD);
    }
    public static Block.Properties LAVENDER_LOG(boolean stripped) {
        MaterialColor color = stripped ? MaterialColor.PURPLE : MaterialColor.PURPLE;
        return Block.Properties.create(Material.WOOD, color).hardnessAndResistance(2.0F).sound(SoundType.WOOD);
    }
    public static Block.Properties MYSTIC_LOG(boolean stripped) {
        MaterialColor color = stripped ? MaterialColor.PURPLE : MaterialColor.PURPLE;
        return Block.Properties.create(Material.WOOD, color).hardnessAndResistance(2.0F).sound(SoundType.WOOD);
    }
}
