package com.mysticsbiomes.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public interface BlockTemplate {

    static Block fromBlock(Block block) {
        return new Block(copy(block));
    }

    static Block log(MapColor mapColor) {
        return log(mapColor, mapColor);
    }

    static Block log(MapColor yColor, MapColor xzColor) {
        return new RotatedPillarBlock(logProperties(yColor, xzColor));
    }

    static Block planks(MapColor mapColor) {
        return new Block(BlockBehaviour.Properties.of()
                .mapColor(mapColor)
                .sound(SoundType.WOOD)
                .strength(2.0F, 3.0F)
                .ignitedByLava()
                .instrument(NoteBlockInstrument.BASS)
        );
    }

    static Block stairs(Block baseBlock) {
        return new StairBlock(baseBlock.defaultBlockState(), copy(baseBlock));
    }

    static Block slab(Block baseBlock) {
        return new SlabBlock(copy(baseBlock));
    }

    static Block fence(Block baseBlock) {
        return new FenceBlock(copy(baseBlock).forceSolidOn());
    }

    static Block fenceGate(Block baseBlock, WoodType woodType) {
        return new FenceGateBlock(copy(baseBlock).forceSolidOn(), woodType);
    }

    static Block button(BlockSetType setType) {
        return new ButtonBlock(buttonProperties(), setType, 30, true);
    }

    static Block pressurePlate(Block baseBlock, BlockSetType setType) {
        return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, pressurePlateProperties(baseBlock.defaultMapColor()).instrument(NoteBlockInstrument.BASS), setType);
    }

    static Block trapdoor(Block baseBlock, BlockSetType setType) {
        return new TrapDoorBlock(doorProperties(baseBlock.defaultMapColor()).isValidSpawn(BlockTemplate::never), setType);
    }

    static Block door(Block baseBlock, BlockSetType setType) {
        return new DoorBlock(doorProperties(baseBlock.defaultMapColor()).pushReaction(PushReaction.DESTROY), setType);
    }

    static Block sign(Block block, WoodType woodType) {
        return new MysticStandingSignBlock(woodType, signProperties(block.defaultMapColor()));
    }

    static Block wallSign(Block signBlock, WoodType woodType) {
        return new MysticWallSignBlock(woodType, copy(signBlock).dropsLike(signBlock));
    }

    static Block hangingSign(Block block, WoodType woodType) {
        return new MysticCeilingHangingSignBlock(woodType, signProperties(block.defaultMapColor()));
    }

    static Block wallHangingSign(Block hangingSignBlock, WoodType woodType) {
        return new MysticWallHangingSignBlock(woodType, copy(hangingSignBlock).dropsLike(hangingSignBlock));
    }

    static Block wall(Block block) {
        return new WallBlock(copy(block).forceSolidOn());
    }

    static Block sapling(AbstractTreeGrower grower) {
        return new SaplingBlock(
                grower,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.PLANT)
                        .sound(SoundType.GRASS)
                        .randomTicks()
                        .noCollission()
                        .instabreak()
                        .pushReaction(PushReaction.DESTROY)
        );
    }

    static Block shrub(AbstractTreeGrower grower) {
        return new SaplingBlock(
                grower,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.PLANT)
                        .sound(SoundType.AZALEA)
                        .noOcclusion()
                        .instabreak()
                        .forceSolidOff()
                        .pushReaction(PushReaction.DESTROY)
        );
    }

    static Block potted(Block block) {
        return new FlowerPotBlock(
                block,
                BlockBehaviour.Properties.of()
                        .instabreak()
                        .noOcclusion()
                        .pushReaction(PushReaction.DESTROY)
        );
    }

    static BlockBehaviour.Properties copy(Block block) {
        return BlockBehaviour.Properties.copy(block);
    }

    static BlockBehaviour.Properties leafProperties(SoundType soundType) {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .sound(soundType)
                .strength(0.2F)
                .ignitedByLava()
                .randomTicks()
                .noOcclusion()
                .isValidSpawn(BlockTemplate::ocelotOrParrot)
                .isViewBlocking(BlockTemplate::never)
                .isSuffocating(BlockTemplate::never)
                .isRedstoneConductor(BlockTemplate::never)
                .pushReaction(PushReaction.DESTROY);
    }

    static BlockBehaviour.Properties logProperties(MapColor yColor, MapColor xzColor) {
        return BlockBehaviour.Properties.of()
                .mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? yColor : xzColor)
                .sound(SoundType.WOOD)
                .strength(2.0F)
                .ignitedByLava()
                .instrument(NoteBlockInstrument.BASS);
    }

    static BlockBehaviour.Properties buttonProperties() {
        return BlockBehaviour.Properties.of()
                .strength(0.5F)
                .noCollission()
                .pushReaction(PushReaction.DESTROY);
    }

    static BlockBehaviour.Properties pressurePlateProperties(MapColor mapColor) {
        return BlockBehaviour.Properties.of()
                .mapColor(mapColor)
                .strength(0.5F)
                .noCollission()
                .forceSolidOn()
                .pushReaction(PushReaction.DESTROY);
    }

    static BlockBehaviour.Properties doorProperties(MapColor mapColor) {
        return BlockBehaviour.Properties.of()
                .mapColor(mapColor)
                .strength(3.0F)
                .noOcclusion()
                .ignitedByLava()
                .instrument(NoteBlockInstrument.BASS);
    }

    static BlockBehaviour.Properties signProperties(MapColor mapColor) {
        return BlockBehaviour.Properties.of()
                .mapColor(mapColor)
                .strength(1.0F)
                .noCollission()
                .forceSolidOn()
                .ignitedByLava()
                .instrument(NoteBlockInstrument.BASS);
    }

    static BlockBehaviour.Properties grassProperties() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.GRASS)
                .sound(SoundType.GRASS)
                .instabreak()
                .ignitedByLava()
                .replaceable()
                .noCollission()
                .offsetType(BlockBehaviour.OffsetType.XYZ)
                .pushReaction(PushReaction.DESTROY);
    }

    static BlockBehaviour.Properties flowerProperties() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .sound(SoundType.GRASS)
                .instabreak()
                .noCollission()
                .offsetType(BlockBehaviour.OffsetType.XZ)
                .pushReaction(PushReaction.DESTROY);
    }

    static Boolean ocelotOrParrot(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> entityType) {
        return entityType == EntityType.OCELOT || entityType == EntityType.PARROT;
    }

    static Boolean never(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> entityType) {
        return false;
    }

    static boolean never(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return false;
    }

    static boolean always(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return true;
    }

}