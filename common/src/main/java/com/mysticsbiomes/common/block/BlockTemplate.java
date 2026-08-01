package com.mysticsbiomes.common.block;

import api.mystanica.registry.RegistryEntry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
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

    static Block log(MapColor mapColor) {
        return log(mapColor, mapColor, SoundType.WOOD);
    }

    static Block log(MapColor mapColor, SoundType soundType) {
        return log(mapColor, mapColor, soundType);
    }

    static Block log(MapColor yColor, MapColor xzColor) {
        return new RotatedPillarBlock(logProperties(yColor, xzColor, SoundType.WOOD));
    }

    static Block log(MapColor yColor, MapColor xzColor, SoundType soundType) {
        return new RotatedPillarBlock(logProperties(yColor, xzColor, soundType));
    }

    static Block planks(MapColor mapColor) {
        return new Block(plankProperties(mapColor, SoundType.WOOD));
    }

    static Block planks(MapColor mapColor, SoundType soundType) {
        return new Block(plankProperties(mapColor, soundType));
    }

    static Block stairs(RegistryEntry<Block> baseBlock) {
        return new StairBlock(baseBlock.get().defaultBlockState(), copy(baseBlock));
    }

    static Block slab(RegistryEntry<Block> baseBlock) {
        return new SlabBlock(copy(baseBlock));
    }

    static Block woodenFence(RegistryEntry<Block> baseBlock) {
        return new FenceBlock(copy(baseBlock).forceSolidOn());
    }

    static Block woodenFenceGate(RegistryEntry<Block> baseBlock, WoodType woodType) {
        return new FenceGateBlock(copy(baseBlock).forceSolidOn(), woodType);
    }

    static Block woodenButton(BlockSetType setType) {
        return new ButtonBlock(buttonProperties(), setType, 30, true);
    }

    static Block woodenPressurePlate(RegistryEntry<Block> baseBlock, BlockSetType setType) {
        return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, pressurePlateProperties(baseBlock.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS), setType);
    }

    static Block woodenTrapdoor(RegistryEntry<Block> baseBlock, BlockSetType setType) {
        return new TrapDoorBlock(doorProperties(baseBlock.get().defaultMapColor()).isValidSpawn(BlockTemplate::never), setType);
    }

    static Block woodenDoor(RegistryEntry<Block> baseBlock, BlockSetType setType) {
        return new DoorBlock(doorProperties(baseBlock.get().defaultMapColor()).pushReaction(PushReaction.DESTROY), setType);
    }

    static Block sign(RegistryEntry<Block> block, WoodType woodType) {
        return new MysticStandingSignBlock(woodType, signProperties(block.get().defaultMapColor()));
    }

    static Block wallSign(RegistryEntry<Block> signBlock, WoodType woodType) {
        return new MysticWallSignBlock(woodType, copy(signBlock).dropsLike(signBlock.get()));
    }

    static Block hangingSign(RegistryEntry<Block> block, WoodType woodType) {
        return new MysticCeilingHangingSignBlock(woodType, signProperties(block.get().defaultMapColor()));
    }

    static Block wallHangingSign(RegistryEntry<Block> hangingSignBlock, WoodType woodType) {
        return new MysticWallHangingSignBlock(woodType, copy(hangingSignBlock).dropsLike(hangingSignBlock.get()));
    }

    static Block wall(RegistryEntry<Block> block) {
        return new WallBlock(copy(block).forceSolidOn());
    }

    static Block leaves(SoundType soundType) {
        return new LeavesBlock(leafProperties(soundType));
    }

    static Block leafPile(RegistryEntry<SimpleParticleType> particleType, MapColor mapColor) {
        return new MapleLeafPileBlock(
                particleType,
                BlockBehaviour.Properties.of()
                        .mapColor(mapColor)
                        .strength(0.1F)
                        .sound(SoundType.GRASS)
                        .noCollission()
                        .noOcclusion()
                        .replaceable()
                        .pushReaction(PushReaction.DESTROY)
        );
    }

    static Block leafLitter(MapColor mapColor) {
        return new MapleLeafLitterBlock(
                BlockBehaviour.Properties.of()
                        .mapColor(mapColor)
                        .instabreak()
                        .sound(SoundType.GRASS)
                        .noCollission()
                        .noOcclusion()
                        .replaceable()
                        .pushReaction(PushReaction.DESTROY)
        );
    }

    static Block sapling(AbstractTreeGrower grower) {
        return sapling(grower, SoundType.GRASS);
    }

    static Block sapling(AbstractTreeGrower grower, SoundType soundType) {
        return new SaplingBlock(
                grower,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.PLANT)
                        .sound(soundType)
                        .randomTicks()
                        .noCollission()
                        .instabreak()
                        .pushReaction(PushReaction.DESTROY)
        );
    }

    static Block shrub(AbstractTreeGrower grower) {
        return new MysticBushBlock(
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

    static Block bush(AbstractTreeGrower grower) {
        return new MysticBushBlock(
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

    static Block potted(RegistryEntry<Block> block) {
        return new FlowerPotBlock(
                block.get(),
                BlockBehaviour.Properties.of()
                        .instabreak()
                        .noOcclusion()
                        .pushReaction(PushReaction.DESTROY)
        );
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    static BlockBehaviour.Properties copy(Block block) {
        return BlockBehaviour.Properties.copy(block);
    }

    static BlockBehaviour.Properties copy(RegistryEntry<Block> block) {
        return BlockBehaviour.Properties.copy(block.get());
    }

    static BlockBehaviour.Properties sandProperties(MapColor mapColor) {
        return BlockBehaviour.Properties.of()
                .mapColor(mapColor)
                .strength(0.5F)
                .sound(SoundType.SAND)
                .instrument(NoteBlockInstrument.SNARE);
    }

    static BlockBehaviour.Properties sandstoneProperties(MapColor mapColor) {
        return BlockBehaviour.Properties.of()
                .mapColor(mapColor)
                .strength(0.8F)
                .instrument(NoteBlockInstrument.BASEDRUM)
                .requiresCorrectToolForDrops();
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

    static BlockBehaviour.Properties logProperties(MapColor yColor, MapColor xzColor, SoundType soundType) {
        return BlockBehaviour.Properties.of()
                .mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? yColor : xzColor)
                .sound(soundType)
                .strength(2.0F)
                .ignitedByLava()
                .instrument(NoteBlockInstrument.BASS);
    }

    static BlockBehaviour.Properties plankProperties(MapColor mapColor, SoundType soundType) {
        return BlockBehaviour.Properties.of()
                .mapColor(mapColor)
                .sound(soundType)
                .strength(2.0F, 3.0F)
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
                .instrument(NoteBlockInstrument.BASS)
                .pushReaction(PushReaction.DESTROY);
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

    static BlockBehaviour.Properties flowerProperties(MapColor mapColor) {
        return flowerProperties(mapColor, true);
    }

    /**
     * @param withOffset - decide whether the flower will have an offset or not.
     */
    static BlockBehaviour.Properties flowerProperties(MapColor mapColor, boolean withOffset) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of()
                .mapColor(mapColor)
                .sound(SoundType.GRASS)
                .instabreak()
                .noCollission()
                .pushReaction(PushReaction.DESTROY);

        if (withOffset) {
            properties.offsetType(BlockBehaviour.OffsetType.XZ);
        }

        return properties;
    }

    static BlockBehaviour.Properties bambooProperties(SoundType soundType) {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .randomTicks()
                .sound(soundType)
                .strength(1.0F)
                .noOcclusion()
                .dynamicShape()
                .forceSolidOn()
                .ignitedByLava()
                .offsetType(BlockBehaviour.OffsetType.XZ)
                .pushReaction(PushReaction.DESTROY);
    }

    static BlockBehaviour.Properties strawberryBushProperties() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .sound(SoundType.SWEET_BERRY_BUSH)
                .instabreak()
                .ignitedByLava()
                .noCollission()
                .pushReaction(PushReaction.DESTROY);
    }

    static BlockBehaviour.Properties cakeProperties() {
        return BlockBehaviour.Properties.of()
                .strength(0.5F)
                .sound(SoundType.WOOL)
                .forceSolidOn()
                .pushReaction(PushReaction.DESTROY);
    }

    static Boolean ocelotOrParrot(BlockState state, BlockGetter level, BlockPos pos, EntityType<?> entityType) {
        return entityType == EntityType.OCELOT || entityType == EntityType.PARROT;
    }

    static Boolean never(BlockState state, BlockGetter level, BlockPos pos, EntityType<?> entityType) {
        return false;
    }

    static boolean never(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return false;
    }

    static boolean always(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return true;
    }

}