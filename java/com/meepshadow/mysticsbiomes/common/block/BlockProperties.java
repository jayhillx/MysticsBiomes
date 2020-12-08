package com.meepshadow.mysticsbiomes.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class BlockProperties {

    //Ethereal
    public static Block.Properties ETHEREAL_LOG(boolean stripped) {
        MaterialColor color = stripped ? MaterialColor.CYAN : MaterialColor.CYAN;
        return Block.Properties.create(Material.WOOD, color).hardnessAndResistance(2.0F).sound(SoundType.WOOD);
    }
    public static Block.Properties ETHEREAL_WOOD(boolean stripped) {
        MaterialColor color = stripped ? MaterialColor.CYAN : MaterialColor.CYAN;
        return Block.Properties.create(Material.WOOD, color).hardnessAndResistance(2.0F).sound(SoundType.WOOD);
    }
    public static Block.Properties ETHEREAL_PLANKS = Block.Properties.create(Material.WOOD, MaterialColor.CYAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD);

    //Lavender
    public static Block.Properties LAVENDER_LOG(boolean stripped) {
        MaterialColor color = stripped ? MaterialColor.PURPLE : MaterialColor.PURPLE;
        return Block.Properties.create(Material.WOOD, color).hardnessAndResistance(2.0F).sound(SoundType.WOOD);
    }
    public static Block.Properties LAVENDER_WOOD(boolean stripped) {
        MaterialColor color = stripped ? MaterialColor.PURPLE : MaterialColor.PURPLE;
        return Block.Properties.create(Material.WOOD, color).hardnessAndResistance(2.0F).sound(SoundType.WOOD);
    }
    public static Block.Properties LAVENDER_PLANKS = Block.Properties.create(Material.WOOD, MaterialColor.PURPLE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD);

    //Strawberry
    public static Block.Properties STRAWBERRRY_LOG(boolean stripped) {
        MaterialColor color = stripped ? MaterialColor.PINK : MaterialColor.PINK;
        return Block.Properties.create(Material.WOOD, color).hardnessAndResistance(2.0F).sound(SoundType.WOOD);
    }
    public static Block.Properties STRAWBERRY_WOOD(boolean stripped) {
        MaterialColor color = stripped ? MaterialColor.PINK : MaterialColor.PINK;
        return Block.Properties.create(Material.WOOD, color).hardnessAndResistance(2.0F).sound(SoundType.WOOD);
    }
    public static Block.Properties STRAWBERRY_PLANKS = Block.Properties.create(Material.WOOD, MaterialColor.PINK).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD);
    
    //Leaves
    public static Block.Properties LAVENDER_BLOSSOM_LEAVES(MaterialColor color) {
        return Block.Properties.create(Material.LEAVES, color).notSolid().hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT);
    }
    public static Block.Properties SWEET_BLOSSOM_LEAVES(MaterialColor color) {
        return Block.Properties.create(Material.LEAVES, color).notSolid().hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT);
    }
    public static Block.Properties STRAWBERRY_BLOSSOM_LEAVES(MaterialColor color) {
        return Block.Properties.create(Material.LEAVES, color).notSolid().hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT);
    }
    public static Block.Properties ETHEREAL_LEAVES(MaterialColor color) {
        return Block.Properties.create(Material.LEAVES, color).notSolid().hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT);
    }
}