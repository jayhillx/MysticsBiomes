package com.mysticsbiomes.common.block;

import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.Direction;

public interface BlockTemplate {

    static PillarBlock log(MapColor yColor, MapColor xzColor) {
        return new PillarBlock(AbstractBlock.Settings.create().mapColor((state) -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? yColor : xzColor).instrument(Instrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable());
    }

    static PillarBlock rotatedPillar(MapColor color) {
        return new PillarBlock(AbstractBlock.Settings.create().mapColor(color).instrument(Instrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable());
    }

    static Block planks(MapColor color) {
        return new Block(AbstractBlock.Settings.create().mapColor(color).instrument(Instrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable());
    }

    static StairsBlock stairs(Block block) {
        return new StairsBlock(block.getDefaultState(), AbstractBlock.Settings.copy(block));
    }

    static SlabBlock slab(Block block) {
        return new SlabBlock(AbstractBlock.Settings.copy(block));
    }

    static FenceBlock fence(Block block) {
        return new FenceBlock(AbstractBlock.Settings.copy(block).solid());
    }

    static FenceGateBlock fenceGate(Block block, WoodType woodType) {
        return new FenceGateBlock(AbstractBlock.Settings.copy(block).solid(), woodType);
    }

    static ButtonBlock button(BlockSetType setType) {
        return new ButtonBlock(AbstractBlock.Settings.create().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY), setType, 30, true);
    }

    static PressurePlateBlock pressurePlate(Block block, BlockSetType setType) {
        return new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, AbstractBlock.Settings.copy(block).solid().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY), setType);
    }

    static TrapdoorBlock trapdoor(Block block, BlockSetType setType) {
        return new TrapdoorBlock(AbstractBlock.Settings.copy(block).instrument(Instrument.BASS).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never).burnable(), setType);
    }

    static DoorBlock door(Block block, BlockSetType setType) {
        return new DoorBlock(AbstractBlock.Settings.copy(block).nonOpaque().strength(3.0F).pistonBehavior(PistonBehavior.DESTROY), setType);
    }

    static MysticStandingSignBlock sign(Block block, WoodType woodType) {
        return new MysticStandingSignBlock(AbstractBlock.Settings.copy(block).solid().noCollision().strength(1.0F), woodType);
    }

    static MysticWallSignBlock wallSign(Block block, WoodType woodType) {
        return new MysticWallSignBlock(AbstractBlock.Settings.copy(block).dropsLike(block), woodType);
    }

    static MysticCeilingHangingSignBlock hangingSign(Block block, WoodType woodType) {
        return new MysticCeilingHangingSignBlock(AbstractBlock.Settings.copy(block).solid().noCollision().strength(1.0F).burnable(), woodType);
    }

    static MysticWallHangingSignBlock wallHangingSign(Block block, WoodType woodType) {
        return new MysticWallHangingSignBlock(AbstractBlock.Settings.copy(block).dropsLike(block), woodType);
    }

}