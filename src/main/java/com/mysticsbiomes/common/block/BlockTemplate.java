package com.mysticsbiomes.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;

public interface BlockTemplate {

    static MysticLogBlock log(Supplier<Block> block, MapColor yColor, MapColor xzColor) {
        return new MysticLogBlock(block.get(), BlockBehaviour.Properties.of().mapColor((state) -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? yColor : xzColor).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava());
    }

    static RotatedPillarBlock rotatedPillar(MapColor color) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(color).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava());
    }

    static Block planks(MapColor color) {
        return new Block(BlockBehaviour.Properties.of().mapColor(color).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava());
    }

    static StairBlock stairs(Block block) {
        return new StairBlock(block::defaultBlockState, BlockBehaviour.Properties.copy(block));
    }

    static SlabBlock slab(Block block) {
        return new SlabBlock(BlockBehaviour.Properties.copy(block));
    }

    static FenceBlock fence(Block block) {
        return new FenceBlock(BlockBehaviour.Properties.copy(block).forceSolidOn());
    }

    static FenceGateBlock fenceGate(Block block, WoodType woodType) {
        return new FenceGateBlock(BlockBehaviour.Properties.copy(block).forceSolidOn(), woodType);
    }

    static ButtonBlock button(BlockSetType setType) {
        return new ButtonBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), setType, 30, true);
    }

    static PressurePlateBlock pressurePlate(Block block, BlockSetType setType) {
        return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(block).forceSolidOn().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), setType);
    }

    static TrapDoorBlock trapdoor(Block block, BlockSetType setType) {
        return new TrapDoorBlock(BlockBehaviour.Properties.copy(block).noOcclusion().strength(3.0F).isValidSpawn(BlockTemplate::never), setType);
    }

    static DoorBlock door(Block block, BlockSetType setType) {
        return new DoorBlock(BlockBehaviour.Properties.copy(block).noOcclusion().strength(3.0F).pushReaction(PushReaction.DESTROY), setType);
    }

    static MysticStandingSignBlock sign(Block block, WoodType woodType) {
        return new MysticStandingSignBlock(BlockBehaviour.Properties.copy(block).forceSolidOn().noCollission().strength(1.0F), woodType);
    }

    static MysticWallSignBlock wallSign(Block block, WoodType woodType) {
        return new MysticWallSignBlock(BlockBehaviour.Properties.copy(block).lootFrom(() -> block), woodType);
    }

    static MysticCeilingHangingSignBlock hangingSign(Block block, WoodType woodType) {
        return new MysticCeilingHangingSignBlock(BlockBehaviour.Properties.copy(block).forceSolidOn().noCollission().strength(1.0F).ignitedByLava(), woodType);
    }

    static MysticWallHangingSignBlock wallHangingSign(Block block, WoodType woodType) {
        return new MysticWallHangingSignBlock(BlockBehaviour.Properties.copy(block).lootFrom(() -> block), woodType);
    }

    static FlowerPotBlock potted(Block block) {
        return new FlowerPotBlock(block, BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));
    }

    static boolean never(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> entityType) {
        return false;
    }

    static boolean never(BlockState state, BlockGetter getter, BlockPos pos) {
        return false;
    }

}