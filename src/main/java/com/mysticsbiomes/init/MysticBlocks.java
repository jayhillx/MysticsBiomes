package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.block.*;
import com.mysticsbiomes.common.block.SignBlock;
import com.mysticsbiomes.common.block.state.MysticBlockTypes;
import com.mysticsbiomes.common.worldgen.feature.MysticTreeFeatures;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class MysticBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, MysticsBiomes.modId);

    // strawberry fields
    public static final RegistryObject<Block> STRAWBERRY_BLOSSOMS = BLOCKS.register("strawberry_blossoms", () -> new FallingLeafBlock(ParticleTypes.CHERRY_LEAVES, 14, BlockBehaviour.Properties.copy(Blocks.AZALEA_LEAVES)));
    public static final RegistryObject<Block> STRAWBERRY_SAPLING = BLOCKS.register("strawberry_sapling", () -> new GrowingSaplingBlock(new GrowingSaplingBlock.TreeGrower(MysticTreeFeatures.STRAWBERRY_TREE), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> STRIPPED_STRAWBERRY_LOG = BLOCKS.register("stripped_strawberry_log", () -> new RotatedPillarBlock(log(MapColor.COLOR_MAGENTA, MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> STRAWBERRY_LOG = BLOCKS.register("strawberry_log", () -> new LogBarkBlock(STRIPPED_STRAWBERRY_LOG.get(), log(MapColor.TERRACOTTA_PINK, MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> STRIPPED_STRAWBERRY_WOOD = BLOCKS.register("stripped_strawberry_wood", () -> new RotatedPillarBlock(log(MapColor.COLOR_PINK, MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> STRAWBERRY_WOOD = BLOCKS.register("strawberry_wood", () -> new LogBarkBlock(STRIPPED_STRAWBERRY_WOOD.get(), log(MapColor.TERRACOTTA_PINK, MapColor.TERRACOTTA_PINK)));
    public static final RegistryObject<Block> STRAWBERRY_PLANKS = BLOCKS.register("strawberry_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> STRAWBERRY_SLAB = BLOCKS.register("strawberry_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(STRAWBERRY_PLANKS.get())));
    public static final RegistryObject<Block> STRAWBERRY_STAIRS = BLOCKS.register("strawberry_stairs", () -> new StairBlock(() -> STRAWBERRY_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(STRAWBERRY_PLANKS.get())));
    public static final RegistryObject<Block> STRAWBERRY_FENCE = BLOCKS.register("strawberry_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(STRAWBERRY_PLANKS.get()).forceSolidOn()));
    public static final RegistryObject<Block> STRAWBERRY_FENCE_GATE = BLOCKS.register("strawberry_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(STRAWBERRY_PLANKS.get()).forceSolidOn(), MysticBlockTypes.Wood.STRAWBERRY));
    public static final RegistryObject<Block> STRAWBERRY_BUTTON = BLOCKS.register("strawberry_button", () -> new ButtonBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), MysticBlockTypes.Sets.STRAWBERRY, 30, true));
    public static final RegistryObject<Block> STRAWBERRY_PRESSURE_PLATE = BLOCKS.register("strawberry_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(STRAWBERRY_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY), MysticBlockTypes.Sets.STRAWBERRY));
    public static final RegistryObject<Block> STRAWBERRY_TRAPDOOR = BLOCKS.register("strawberry_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava(), MysticBlockTypes.Sets.STRAWBERRY));
    public static final RegistryObject<Block> STRAWBERRY_DOOR = BLOCKS.register("strawberry_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(STRAWBERRY_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY), MysticBlockTypes.Sets.STRAWBERRY));
    public static final RegistryObject<Block> STRAWBERRY_SIGN = BLOCKS.register("strawberry_sign", () -> new SignBlock.Standing(sign(), MysticBlockTypes.Wood.STRAWBERRY));
    public static final RegistryObject<Block> STRAWBERRY_WALL_SIGN = BLOCKS.register("strawberry_wall_sign", () -> new SignBlock.Wall(sign().lootFrom(STRAWBERRY_SIGN), MysticBlockTypes.Wood.STRAWBERRY));
    public static final RegistryObject<Block> STRAWBERRY_HANGING_SIGN = BLOCKS.register("strawberry_hanging_sign", () -> new SignBlock.Hanging.Ceiling(sign(), MysticBlockTypes.Wood.STRAWBERRY));
    public static final RegistryObject<Block> STRAWBERRY_WALL_HANGING_SIGN = BLOCKS.register("strawberry_wall_hanging_sign", () -> new SignBlock.Hanging.Wall(sign().lootFrom(STRAWBERRY_HANGING_SIGN), MysticBlockTypes.Wood.STRAWBERRY));

    public static final RegistryObject<Block> STRAWBERRY_BUSH = BLOCKS.register("strawberry_bush", () -> new StrawberryBushBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> STRAWBERRY_CAKE = BLOCKS.register("strawberry_cake", () -> new CakeBlock(BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> POTTED_STRAWBERRY_SAPLING = BLOCKS.register("potted_strawberry_sapling", () -> pottedPlant(STRAWBERRY_SAPLING));

    // bamboo blossom forest
    public static final RegistryObject<Block> PINK_CHERRY_BLOSSOMS = BLOCKS.register("pink_cherry_blossoms", () -> new FallingLeafBlock(ParticleTypes.CHERRY_LEAVES, 14, BlockBehaviour.Properties.copy(Blocks.CHERRY_LEAVES)));
    public static final RegistryObject<Block> PINK_CHERRY_BLOSSOM_SAPLING = BLOCKS.register("pink_cherry_blossom_sapling", () -> new GrowingSaplingBlock(new GrowingSaplingBlock.TreeGrower(MysticTreeFeatures.PINK_CHERRY_TREE), BlockBehaviour.Properties.copy(Blocks.CHERRY_SAPLING)));
    public static final RegistryObject<Block> WHITE_CHERRY_BLOSSOMS = BLOCKS.register("white_cherry_blossoms", () -> new FallingLeafBlock(ParticleTypes.CHERRY_LEAVES, 14, BlockBehaviour.Properties.copy(Blocks.CHERRY_LEAVES)));
    public static final RegistryObject<Block> WHITE_CHERRY_BLOSSOM_SAPLING = BLOCKS.register("white_cherry_blossom_sapling", () -> new GrowingSaplingBlock(new GrowingSaplingBlock.TreeGrower(MysticTreeFeatures.WHITE_CHERRY_TREE), BlockBehaviour.Properties.copy(Blocks.CHERRY_SAPLING)));

    public static final RegistryObject<Block> STRIPPED_CHERRY_LOG = BLOCKS.register("stripped_cherry_log", () -> new RotatedPillarBlock(log(MapColor.COLOR_MAGENTA, MapColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> CHERRY_LOG = BLOCKS.register("cherry_log", () -> new LogBarkBlock(STRIPPED_CHERRY_LOG.get(), log(MapColor.NETHER, MapColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> STRIPPED_CHERRY_WOOD = BLOCKS.register("stripped_cherry_wood", () -> new RotatedPillarBlock(log(MapColor.COLOR_MAGENTA, MapColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> CHERRY_WOOD = BLOCKS.register("cherry_wood", () -> new LogBarkBlock(STRIPPED_CHERRY_WOOD.get(), log(MapColor.NETHER, MapColor.NETHER)));
    public static final RegistryObject<Block> CHERRY_PLANKS = BLOCKS.register("cherry_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> CHERRY_SLAB = BLOCKS.register("cherry_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CHERRY_PLANKS.get())));
    public static final RegistryObject<Block> CHERRY_STAIRS = BLOCKS.register("cherry_stairs", () -> new StairBlock(() -> CHERRY_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(CHERRY_PLANKS.get())));
    public static final RegistryObject<Block> CHERRY_FENCE = BLOCKS.register("cherry_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(CHERRY_PLANKS.get()).forceSolidOn()));
    public static final RegistryObject<Block> CHERRY_FENCE_GATE = BLOCKS.register("cherry_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(CHERRY_PLANKS.get()).forceSolidOn(), MysticBlockTypes.Wood.CHERRY));
    public static final RegistryObject<Block> CHERRY_BUTTON = BLOCKS.register("cherry_button", () -> new ButtonBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), MysticBlockTypes.Sets.CHERRY, 30, true));
    public static final RegistryObject<Block> CHERRY_PRESSURE_PLATE = BLOCKS.register("cherry_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(CHERRY_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY), MysticBlockTypes.Sets.CHERRY));
    public static final RegistryObject<Block> CHERRY_TRAPDOOR = BLOCKS.register("cherry_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava(), MysticBlockTypes.Sets.CHERRY));
    public static final RegistryObject<Block> CHERRY_DOOR = BLOCKS.register("cherry_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(CHERRY_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY), MysticBlockTypes.Sets.CHERRY));
    public static final RegistryObject<Block> CHERRY_SIGN = BLOCKS.register("cherry_sign", () -> new SignBlock.Standing(sign(), MysticBlockTypes.Wood.CHERRY));
    public static final RegistryObject<Block> CHERRY_WALL_SIGN = BLOCKS.register("cherry_wall_sign", () -> new SignBlock.Wall(sign().lootFrom(CHERRY_SIGN), MysticBlockTypes.Wood.CHERRY));
    public static final RegistryObject<Block> CHERRY_HANGING_SIGN = BLOCKS.register("cherry_hanging_sign", () -> new SignBlock.Hanging.Ceiling(sign(), MysticBlockTypes.Wood.CHERRY));
    public static final RegistryObject<Block> CHERRY_WALL_HANGING_SIGN = BLOCKS.register("cherry_wall_hanging_sign", () -> new SignBlock.Hanging.Wall(sign().lootFrom(CHERRY_HANGING_SIGN), MysticBlockTypes.Wood.CHERRY));

    public static final RegistryObject<Block> BUDDING_PEONY_LEAVES = BLOCKS.register("budding_peony_leaves", () -> new FallingLeafBlock(BlockBehaviour.Properties.copy(Blocks.AZALEA_LEAVES)));
    public static final RegistryObject<Block> PEONY_LEAVES = BLOCKS.register("peony_leaves", () -> new FallingLeafBlock(BlockBehaviour.Properties.copy(Blocks.AZALEA_LEAVES)));
    public static final RegistryObject<Block> PEONY_BUSH = BLOCKS.register("peony_bush", () -> new GrowingBushBlock(new GrowingBushBlock.TreeGrower(MysticTreeFeatures.PEONY_BUSH), BlockBehaviour.Properties.copy(Blocks.AZALEA)));

    public static final RegistryObject<Block> POTTED_PEONY_BUSH = BLOCKS.register("potted_peony_bush", () -> pottedPlant(PEONY_BUSH));
    public static final RegistryObject<Block> POTTED_PINK_CHERRY_BLOSSOM_SAPLING = BLOCKS.register("potted_pink_cherry_blossom_sapling", () -> pottedPlant(PINK_CHERRY_BLOSSOM_SAPLING));
    public static final RegistryObject<Block> POTTED_WHITE_CHERRY_BLOSSOM_SAPLING = BLOCKS.register("potted_white_cherry_blossom_sapling", () -> pottedPlant(WHITE_CHERRY_BLOSSOM_SAPLING));

    public static final RegistryObject<Block> JACARANDA_BLOSSOMS = BLOCKS.register("jacaranda_blossoms", () -> new JacarandaLeafBlock(BlockBehaviour.Properties.copy(Blocks.AZALEA_LEAVES)));
    public static final RegistryObject<Block> JACARANDA_LEAVES = BLOCKS.register("jacaranda_leaves", () -> new FallingLeafBlock(14, BlockBehaviour.Properties.copy(Blocks.AZALEA_LEAVES)));
    public static final RegistryObject<Block> JACARANDA_SAPLING = BLOCKS.register("jacaranda_sapling", () -> new GrowingSaplingBlock(new GrowingSaplingBlock.TreeGrower(MysticTreeFeatures.JACARANDA_TREE), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> STRIPPED_JACARANDA_LOG = BLOCKS.register("stripped_jacaranda_log", () -> new RotatedPillarBlock(log(MapColor.COLOR_PURPLE, MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> JACARANDA_LOG = BLOCKS.register("jacaranda_log", () -> new LogBarkBlock(STRIPPED_JACARANDA_LOG.get(), log(MapColor.TERRACOTTA_LIGHT_GRAY, MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> STRIPPED_JACARANDA_WOOD = BLOCKS.register("stripped_jacaranda_wood", () -> new RotatedPillarBlock(log(MapColor.COLOR_PURPLE, MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> JACARANDA_WOOD = BLOCKS.register("jacaranda_wood", () -> new LogBarkBlock(STRIPPED_JACARANDA_WOOD.get(), log(MapColor.TERRACOTTA_LIGHT_GRAY, MapColor.TERRACOTTA_LIGHT_GRAY)));
    public static final RegistryObject<Block> JACARANDA_PLANKS = BLOCKS.register("jacaranda_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> JACARANDA_SLAB = BLOCKS.register("jacaranda_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(JACARANDA_PLANKS.get())));
    public static final RegistryObject<Block> JACARANDA_STAIRS = BLOCKS.register("jacaranda_stairs", () -> new StairBlock(() -> JACARANDA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(JACARANDA_PLANKS.get())));
    public static final RegistryObject<Block> JACARANDA_FENCE = BLOCKS.register("jacaranda_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(JACARANDA_PLANKS.get()).forceSolidOn()));
    public static final RegistryObject<Block> JACARANDA_FENCE_GATE = BLOCKS.register("jacaranda_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(JACARANDA_PLANKS.get()).forceSolidOn(), MysticBlockTypes.Wood.JACARANDA));
    public static final RegistryObject<Block> JACARANDA_BUTTON = BLOCKS.register("jacaranda_button", () -> new ButtonBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), MysticBlockTypes.Sets.JACARANDA, 30, true));
    public static final RegistryObject<Block> JACARANDA_PRESSURE_PLATE = BLOCKS.register("jacaranda_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(JACARANDA_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY), MysticBlockTypes.Sets.JACARANDA));
    public static final RegistryObject<Block> JACARANDA_TRAPDOOR = BLOCKS.register("jacaranda_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava(), MysticBlockTypes.Sets.JACARANDA));
    public static final RegistryObject<Block> JACARANDA_DOOR = BLOCKS.register("jacaranda_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(JACARANDA_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY), MysticBlockTypes.Sets.JACARANDA));
    public static final RegistryObject<Block> JACARANDA_SIGN = BLOCKS.register("jacaranda_sign", () -> new SignBlock.Standing(sign(), MysticBlockTypes.Wood.JACARANDA));
    public static final RegistryObject<Block> JACARANDA_WALL_SIGN = BLOCKS.register("jacaranda_wall_sign", () -> new SignBlock.Wall(sign().lootFrom(JACARANDA_SIGN), MysticBlockTypes.Wood.JACARANDA));
    public static final RegistryObject<Block> JACARANDA_HANGING_SIGN = BLOCKS.register("jacaranda_hanging_sign", () -> new SignBlock.Hanging.Ceiling(sign(), MysticBlockTypes.Wood.JACARANDA));
    public static final RegistryObject<Block> JACARANDA_WALL_HANGING_SIGN = BLOCKS.register("jacaranda_wall_hanging_sign", () -> new SignBlock.Hanging.Wall(sign().lootFrom(JACARANDA_HANGING_SIGN), MysticBlockTypes.Wood.JACARANDA));

    public static final RegistryObject<Block> LAVENDER = BLOCKS.register("lavender", () -> new LavenderFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).offsetType(BlockBehaviour.OffsetType.XZ).noCollission().instabreak().sound(SoundType.GRASS)));

    public static final RegistryObject<Block> POTTED_JACARANDA_SAPLING = BLOCKS.register("potted_jacaranda_sapling", () -> pottedPlant(JACARANDA_SAPLING));
    public static final RegistryObject<Block> POTTED_LAVENDER = BLOCKS.register("potted_lavender", () -> pottedPlant(LAVENDER));

    // lagoon
    //public static final RegistryObject<Block> STRIPPED_SEA_FOAM_LOG = BLOCKS.register("stripped_sea_foam_log", () -> new RotatedPillarBlock(log(MapColor.TERRACOTTA_CYAN, MapColor.COLOR_CYAN)));
    //public static final RegistryObject<Block> SEA_FOAM_LOG = BLOCKS.register("sea_foam_log", () -> new LogBarkBlock(STRIPPED_SEA_FOAM_LOG.get(), log(MapColor.COLOR_CYAN, MapColor.COLOR_CYAN)));
    //public static final RegistryObject<Block> STRIPPED_SEA_FOAM_WOOD = BLOCKS.register("stripped_sea_foam_wood", () -> new RotatedPillarBlock(log(MapColor.TERRACOTTA_CYAN, MapColor.TERRACOTTA_CYAN)));
    //public static final RegistryObject<Block> SEA_FOAM_WOOD = BLOCKS.register("sea_foam_wood", () -> new LogBarkBlock(STRIPPED_SEA_FOAM_WOOD.get(), log(MapColor.COLOR_CYAN, MapColor.COLOR_CYAN)));
    //public static final RegistryObject<Block> SEA_FOAM_PLANKS = BLOCKS.register("sea_foam_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    //public static final RegistryObject<Block> SEA_FOAM_SLAB = BLOCKS.register("sea_foam_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SEA_FOAM_PLANKS.get())));
    //public static final RegistryObject<Block> SEA_FOAM_STAIRS = BLOCKS.register("sea_foam_stairs", () -> new StairBlock(() -> SEA_FOAM_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(SEA_FOAM_PLANKS.get())));
    //public static final RegistryObject<Block> SEA_FOAM_FENCE = BLOCKS.register("sea_foam_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(SEA_FOAM_PLANKS.get()).forceSolidOn()));
    //public static final RegistryObject<Block> SEA_FOAM_FENCE_GATE = BLOCKS.register("sea_foam_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(SEA_FOAM_PLANKS.get()).forceSolidOn(), MysticBlockTypes.Wood.SEA_FOAM));
    //public static final RegistryObject<Block> SEA_FOAM_BUTTON = BLOCKS.register("sea_foam_button", () -> new ButtonBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), MysticBlockTypes.Sets.SEA_FOAM, 30, true));
    //public static final RegistryObject<Block> SEA_FOAM_PRESSURE_PLATE = BLOCKS.register("sea_foam_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(SEA_FOAM_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY), MysticBlockTypes.Sets.SEA_FOAM));
    //public static final RegistryObject<Block> SEA_FOAM_TRAPDOOR = BLOCKS.register("sea_foam_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava(), MysticBlockTypes.Sets.SEA_FOAM));
    //public static final RegistryObject<Block> SEA_FOAM_DOOR = BLOCKS.register("sea_foam_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(SEA_FOAM_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY), MysticBlockTypes.Sets.SEA_FOAM));
    //public static final RegistryObject<Block> SEA_FOAM_SIGN = BLOCKS.register("sea_foam_sign", () -> new SignBlock.Standing(sign(), MysticBlockTypes.Wood.SEA_FOAM));
    //public static final RegistryObject<Block> SEA_FOAM_WALL_SIGN = BLOCKS.register("sea_foam_wall_sign", () -> new SignBlock.Wall(sign().lootFrom(SEA_FOAM_SIGN), MysticBlockTypes.Wood.SEA_FOAM));
    //public static final RegistryObject<Block> SEA_FOAM_HANGING_SIGN = BLOCKS.register("sea_foam_hanging_sign", () -> new SignBlock.Hanging.Ceiling(sign(), MysticBlockTypes.Wood.SEA_FOAM));
    //public static final RegistryObject<Block> SEA_FOAM_WALL_HANGING_SIGN = BLOCKS.register("sea_foam_wall_hanging_sign", () -> new SignBlock.Hanging.Wall(sign().lootFrom(SEA_FOAM_HANGING_SIGN), MysticBlockTypes.Wood.SEA_FOAM));

    //public static final RegistryObject<Block> SHRUB_LEAVES = BLOCKS.register("shrub_leaves", () -> new FallingLeafBlock(14, BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    //public static final RegistryObject<Block> SHRUB = BLOCKS.register("shrub", () -> new FallingLeafBlock(BlockBehaviour.Properties.copy(Blocks.AZALEA)));

    //public static final RegistryObject<Block> SEA_OATS = BLOCKS.register("sea_oats", () -> new TallGrassBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));
    //public static final RegistryObject<Block> WILDFLOWER = BLOCKS.register("wildflower", () -> new Block(BlockBehaviour.Properties.of()));
    //public static final RegistryObject<Block> DESERT_GRASS = BLOCKS.register("desert_grass", () -> new Block(BlockBehaviour.Properties.of()));
    //public static final RegistryObject<Block> TALL_DESERT_GRASS = BLOCKS.register("tall_desert_grass", () -> new Block(BlockBehaviour.Properties.of()));

    //public static final RegistryObject<Block> POTTED_SHRUB = BLOCKS.register("potted_shrub", () -> new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, SHRUB, BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));
    //public static final RegistryObject<Block> POTTED_WILDFLOWER = BLOCKS.register("potted_wildflower", () -> new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, WILDFLOWER, BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));

    private static BlockBehaviour.Properties log(MapColor side, MapColor top) {
        return BlockBehaviour.Properties.of().mapColor((state) -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? side : top).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava();
    }

    private static BlockBehaviour.Properties sign() {
        return BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava();
    }

    private static FlowerPotBlock pottedPlant(Supplier<Block> plant) {
        return new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, plant, BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));
    }

}