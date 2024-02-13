package com.mysticsbiomes.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public interface BlockTemplate {

    static MysticLogBlock log(Block block, MaterialColor yColor, MaterialColor xzColor) {
        return new MysticLogBlock(block, BlockBehaviour.Properties.of(Material.WOOD, (state) -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? yColor : xzColor).strength(2.0F).sound(SoundType.WOOD));
    }

    static RotatedPillarBlock strippedLog(MaterialColor color) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD).color(color).strength(2.0F).sound(SoundType.WOOD));
    }

    static Block planks(MaterialColor color) {
        return new Block(BlockBehaviour.Properties.of(Material.WOOD).color(color).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    }

    static StairBlock stairs(Block block) {
        return new StairBlock(block::defaultBlockState, BlockBehaviour.Properties.copy(block));
    }

    static SlabBlock slab(Block block) {
        return new SlabBlock(BlockBehaviour.Properties.copy(block));
    }

    static FenceBlock fence(Block block) {
        return new FenceBlock(BlockBehaviour.Properties.copy(block).noCollission());
    }

    static FenceGateBlock fenceGate(Block block) {
        return new FenceGateBlock(BlockBehaviour.Properties.copy(block));
    }

    static WoodButtonBlock button() {
        return new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD));
    }

    static PressurePlateBlock pressurePlate(Block block) {
        return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(block).noCollission().strength(0.5F));
    }

    static TrapDoorBlock trapdoor(Block block) {
        return new TrapDoorBlock(BlockBehaviour.Properties.copy(block).noOcclusion().strength(3.0F).isValidSpawn(BlockTemplate::never));
    }

    static DoorBlock door(Block block) {
        return new DoorBlock(BlockBehaviour.Properties.copy(block).noOcclusion().strength(3.0F));
    }

    static MysticStandingSignBlock sign(Block block, WoodType woodType) {
        return new MysticStandingSignBlock(BlockBehaviour.Properties.copy(block).noCollission().strength(1.0F), woodType);
    }

    static MysticWallSignBlock wallSign(Block block, WoodType woodType) {
        return new MysticWallSignBlock(BlockBehaviour.Properties.copy(block).lootFrom(() -> block), woodType);
    }

    static FlowerPotBlock potted(Block block) {
        return new FlowerPotBlock(block, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion());
    }

    static boolean never(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> entityType) {
        return false;
    }

    static boolean never(BlockState state, BlockGetter getter, BlockPos pos) {
        return false;
    }

}