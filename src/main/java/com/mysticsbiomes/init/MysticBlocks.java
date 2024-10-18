package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.block.*;
import com.mysticsbiomes.common.block.grower.MysticTreeGrower;
import com.mysticsbiomes.common.block.state.MysticBlockSetTypes;
import com.mysticsbiomes.common.block.state.MysticWoodTypes;
import com.mysticsbiomes.common.world.feature.MysticTreeFeatures;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

import static com.mysticsbiomes.common.block.BlockTemplate.*;

public class MysticBlocks {

    /** strawberry fields */
    public static final Block STRAWBERRY_BLOSSOMS = registerBlock("strawberry_blossoms", new MysticLeavesBlock(BlockSoundGroup.AZALEA_LEAVES));
    public static final Block STRAWBERRY_SAPLING = registerBlock("strawberry_sapling", new MysticSaplingBlock(new MysticTreeGrower(MysticTreeFeatures.STRAWBERRY_TREE), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    public static final Block STRIPPED_STRAWBERRY_LOG = registerBlock("stripped_strawberry_log", rotatedPillar(MapColor.PINK));
    public static final Block STRAWBERRY_LOG = registerBlock("strawberry_log", log(MapColor.TERRACOTTA_PINK, MapColor.PINK));
    public static final Block STRIPPED_STRAWBERRY_WOOD = registerBlock("stripped_strawberry_wood", rotatedPillar(MapColor.PINK));
    public static final Block STRAWBERRY_WOOD = registerBlock("strawberry_wood", log(MapColor.TERRACOTTA_PINK, MapColor.TERRACOTTA_PINK));
    public static final Block STRAWBERRY_PLANKS = registerBlock("strawberry_planks", planks(MapColor.PINK));
    public static final Block STRAWBERRY_STAIRS = registerBlock("strawberry_stairs", stairs(STRAWBERRY_PLANKS));
    public static final Block STRAWBERRY_SLAB = registerBlock("strawberry_slab", slab(STRAWBERRY_PLANKS));
    public static final Block STRAWBERRY_FENCE = registerBlock("strawberry_fence", fence(STRAWBERRY_PLANKS));
    public static final Block STRAWBERRY_FENCE_GATE = registerBlock("strawberry_fence_gate", fenceGate(STRAWBERRY_PLANKS, MysticWoodTypes.STRAWBERRY));
    public static final Block STRAWBERRY_BUTTON = registerBlock("strawberry_button", button(MysticBlockSetTypes.STRAWBERRY));
    public static final Block STRAWBERRY_PRESSURE_PLATE = registerBlock("strawberry_pressure_plate", pressurePlate(STRAWBERRY_PLANKS, MysticBlockSetTypes.STRAWBERRY));
    public static final Block STRAWBERRY_TRAPDOOR = registerBlock("strawberry_trapdoor", trapdoor(STRAWBERRY_PLANKS, MysticBlockSetTypes.STRAWBERRY));
    public static final Block STRAWBERRY_DOOR = registerBlock("strawberry_door", door(STRAWBERRY_PLANKS, MysticBlockSetTypes.STRAWBERRY));
    public static final Block STRAWBERRY_SIGN = registerBlock("strawberry_sign", sign(STRAWBERRY_PLANKS, MysticWoodTypes.STRAWBERRY));
    public static final Block STRAWBERRY_WALL_SIGN = registerBlock("strawberry_wall_sign", wallSign(STRAWBERRY_SIGN, MysticWoodTypes.STRAWBERRY));
    public static final Block STRAWBERRY_HANGING_SIGN = registerBlock("strawberry_hanging_sign", hangingSign(STRAWBERRY_PLANKS, MysticWoodTypes.STRAWBERRY));
    public static final Block STRAWBERRY_WALL_HANGING_SIGN = registerBlock("strawberry_wall_hanging_sign", wallHangingSign(STRAWBERRY_HANGING_SIGN, MysticWoodTypes.STRAWBERRY));

    public static final Block STRAWBERRY_BUSH = registerBlock("strawberry_bush", new StrawberryBushBlock(AbstractBlock.Settings.create().mapColor(MapColor.GREEN).ticksRandomly().noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH).pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block POTTED_STRAWBERRY_SAPLING = registerBlock("potted_strawberry_sapling", Blocks.createFlowerPotBlock(STRAWBERRY_SAPLING));

    /** bamboo blossom forest */
    public static final Block PINK_CHERRY_BLOSSOMS = registerBlock("pink_cherry_blossoms", new BlossomLeavesBlock(() -> MysticParticles.PINK_CHERRY_BLOSSOM, BlockSoundGroup.CHERRY_LEAVES));
    public static final Block PINK_CHERRY_BLOSSOM_SAPLING = registerBlock("pink_cherry_blossom_sapling", new MysticSaplingBlock(new MysticTreeGrower(MysticTreeFeatures.PINK_CHERRY_TREE), AbstractBlock.Settings.copy(Blocks.CHERRY_SAPLING)));
    public static final Block WHITE_CHERRY_BLOSSOMS = registerBlock("white_cherry_blossoms", new BlossomLeavesBlock(() -> MysticParticles.WHITE_CHERRY_BLOSSOM, BlockSoundGroup.CHERRY_LEAVES));
    public static final Block WHITE_CHERRY_BLOSSOM_SAPLING = registerBlock("white_cherry_blossom_sapling", new MysticSaplingBlock(new MysticTreeGrower(MysticTreeFeatures.WHITE_CHERRY_TREE), AbstractBlock.Settings.copy(Blocks.CHERRY_SAPLING)));

    public static final Block STRIPPED_CHERRY_LOG = registerBlock("stripped_cherry_log", rotatedPillar(MapColor.MAGENTA));
    public static final Block CHERRY_LOG = registerBlock("cherry_log", log(MapColor.TERRACOTTA_BROWN, MapColor.MAGENTA));
    public static final Block STRIPPED_CHERRY_WOOD = registerBlock("stripped_cherry_wood", rotatedPillar(MapColor.MAGENTA));
    public static final Block CHERRY_WOOD = registerBlock("cherry_wood", log(MapColor.TERRACOTTA_BROWN, MapColor.TERRACOTTA_BROWN));
    public static final Block CHERRY_PLANKS = registerBlock("cherry_planks", planks(MapColor.MAGENTA));
    public static final Block CHERRY_STAIRS = registerBlock("cherry_stairs", stairs(CHERRY_PLANKS));
    public static final Block CHERRY_SLAB = registerBlock("cherry_slab", slab(CHERRY_PLANKS));
    public static final Block CHERRY_FENCE = registerBlock("cherry_fence", fence(CHERRY_PLANKS));
    public static final Block CHERRY_FENCE_GATE = registerBlock("cherry_fence_gate", fenceGate(CHERRY_PLANKS, MysticWoodTypes.CHERRY));
    public static final Block CHERRY_BUTTON = registerBlock("cherry_button", button(MysticBlockSetTypes.CHERRY));
    public static final Block CHERRY_PRESSURE_PLATE = registerBlock("cherry_pressure_plate", pressurePlate(CHERRY_PLANKS, MysticBlockSetTypes.CHERRY));
    public static final Block CHERRY_TRAPDOOR = registerBlock("cherry_trapdoor", trapdoor(CHERRY_PLANKS, MysticBlockSetTypes.CHERRY));
    public static final Block CHERRY_DOOR = registerBlock("cherry_door", door(CHERRY_PLANKS, MysticBlockSetTypes.CHERRY));
    public static final Block CHERRY_SIGN = registerBlock("cherry_sign", sign(CHERRY_PLANKS, MysticWoodTypes.CHERRY));
    public static final Block CHERRY_WALL_SIGN = registerBlock("cherry_wall_sign", wallSign(CHERRY_SIGN, MysticWoodTypes.CHERRY));
    public static final Block CHERRY_HANGING_SIGN = registerBlock("cherry_hanging_sign", hangingSign(CHERRY_PLANKS, MysticWoodTypes.CHERRY));
    public static final Block CHERRY_WALL_HANGING_SIGN = registerBlock("cherry_wall_hanging_sign", wallHangingSign(CHERRY_HANGING_SIGN, MysticWoodTypes.CHERRY));

    public static final Block CHERRY_PLANT = registerBlock("cherry_plant", new FruitPlantBlock(() -> MysticItems.CHERRIES, AbstractBlock.Settings.create().mapColor(MapColor.GREEN).ticksRandomly().noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block CHERRY_PIE = registerBlock("cherry_pie", new PieBlock(AbstractBlock.Settings.create().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block BUDDING_PEONY_LEAVES = registerBlock("budding_peony_leaves", new MysticLeavesBlock(BlockSoundGroup.GRASS));
    public static final Block PEONY_LEAVES = registerBlock("peony_leaves", new MysticLeavesBlock(BlockSoundGroup.GRASS));
    public static final Block PEONY_BUSH = registerBlock("peony_bush", new MysticBushBlock(new MysticTreeGrower(MysticTreeFeatures.PEONY_BUSH), AbstractBlock.Settings.copy(Blocks.AZALEA)));

    public static final Block SPRING_BAMBOO = registerBlock("spring_bamboo", new SpringBambooStalkBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_GREEN).solid().ticksRandomly().breakInstantly().strength(1.0F).sounds(BlockSoundGroup.BAMBOO).nonOpaque().dynamicBounds().offset(AbstractBlock.OffsetType.XZ).burnable().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block SPRING_BAMBOO_SAPLING = registerBlock("spring_bamboo_sapling", new SpringBambooSaplingBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_GREEN).solid().ticksRandomly().breakInstantly().noCollision().strength(1.0F).sounds(BlockSoundGroup.BAMBOO_SAPLING).offset(AbstractBlock.OffsetType.XZ).burnable().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block BUNDLED_SPRING_BAMBOO = registerBlock("bundled_spring_bamboo", new PillarBlock(AbstractBlock.Settings.copy(Blocks.BAMBOO_BLOCK)));

    public static final Block POTTED_PINK_CHERRY_BLOSSOM_SAPLING = registerBlock("potted_pink_cherry_blossom_sapling", Blocks.createFlowerPotBlock(PINK_CHERRY_BLOSSOM_SAPLING));
    public static final Block POTTED_WHITE_CHERRY_BLOSSOM_SAPLING = registerBlock("potted_white_cherry_blossom_sapling", Blocks.createFlowerPotBlock(WHITE_CHERRY_BLOSSOM_SAPLING));
    public static final Block POTTED_PEONY_BUSH = registerBlock("potted_peony_bush", Blocks.createFlowerPotBlock(PEONY_BUSH));
    public static final Block POTTED_SPRING_BAMBOO = registerBlock("potted_spring_bamboo", Blocks.createFlowerPotBlock(SPRING_BAMBOO));

    /** lush oasis */
    public static final Block LUSH_SAND = registerBlock("lush_sand", new SandBlock(14729120, AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).instrument(Instrument.SNARE).strength(0.5F).sounds(BlockSoundGroup.SAND)));
    public static final Block GRASSY_LUSH_SAND = registerBlock("grassy_lush_sand", new GrassySandBlock(AbstractBlock.Settings.copy(LUSH_SAND)));
    public static final Block LUSH_SANDSTONE = registerBlock("lush_sandstone", new Block(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).instrument(Instrument.BASEDRUM).requiresTool().strength(0.8F)));
    public static final Block LUSH_SANDSTONE_STAIRS = registerBlock("lush_sandstone_stairs", new StairsBlock(LUSH_SANDSTONE.getDefaultState(), AbstractBlock.Settings.copy(LUSH_SANDSTONE)));
    public static final Block LUSH_SANDSTONE_SLAB = registerBlock("lush_sandstone_slab", new SlabBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).requiresTool().strength(2.0F, 6.0F)));
    public static final Block LUSH_SANDSTONE_WALL = registerBlock("lush_sandstone_wall", new WallBlock(AbstractBlock.Settings.copy(LUSH_SANDSTONE).solid()));
    public static final Block CHISELED_LUSH_SANDSTONE = registerBlock("chiseled_lush_sandstone", new Block(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).instrument(Instrument.BASEDRUM).requiresTool().strength(0.8F)));
    public static final Block CUT_LUSH_SANDSTONE = registerBlock("cut_lush_sandstone", new Block(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).instrument(Instrument.BASEDRUM).requiresTool().strength(0.8F)));
    public static final Block CUT_LUSH_SANDSTONE_SLAB = registerBlock("cut_lush_sandstone_slab", new SlabBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).instrument(Instrument.BASEDRUM).requiresTool().strength(2.0F, 6.0F)));
    public static final Block SMOOTH_LUSH_SANDSTONE = registerBlock("smooth_lush_sandstone", new Block(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).instrument(Instrument.BASEDRUM).requiresTool().strength(2.0F, 6.0F)));
    public static final Block SMOOTH_LUSH_SANDSTONE_STAIRS = registerBlock("smooth_lush_sandstone_stairs", new StairsBlock(SMOOTH_LUSH_SANDSTONE.getDefaultState(), AbstractBlock.Settings.copy(SMOOTH_LUSH_SANDSTONE)));
    public static final Block SMOOTH_LUSH_SANDSTONE_SLAB = registerBlock("smooth_lush_sandstone_slab", new SlabBlock(AbstractBlock.Settings.copy(SMOOTH_LUSH_SANDSTONE)));

    public static final Block PEACH_LEAVES = registerBlock("peach_leaves", new MysticLeavesBlock(BlockSoundGroup.GRASS));
    public static final Block PEACH_SAPLING = registerBlock("peach_sapling", new MysticSaplingBlock(new MysticTreeGrower(MysticTreeFeatures.PEACH_TREE), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    public static final Block STRIPPED_PEACH_LOG = registerBlock("stripped_peach_log", rotatedPillar(MapColor.PALE_YELLOW));
    public static final Block PEACH_LOG = registerBlock("peach_log", log(MapColor.TERRACOTTA_BROWN, MapColor.PALE_YELLOW));
    public static final Block STRIPPED_PEACH_WOOD = registerBlock("stripped_peach_wood", rotatedPillar(MapColor.PALE_YELLOW));
    public static final Block PEACH_WOOD = registerBlock("peach_wood", log(MapColor.TERRACOTTA_BROWN, MapColor.TERRACOTTA_BROWN));
    public static final Block PEACH_PLANKS = registerBlock("peach_planks", planks(MapColor.PALE_YELLOW));
    public static final Block PEACH_STAIRS = registerBlock("peach_stairs", stairs(PEACH_PLANKS));
    public static final Block PEACH_SLAB = registerBlock("peach_slab", slab(PEACH_PLANKS));
    public static final Block PEACH_FENCE = registerBlock("peach_fence", fence(PEACH_PLANKS));
    public static final Block PEACH_FENCE_GATE = registerBlock("peach_fence_gate", fenceGate(PEACH_PLANKS, MysticWoodTypes.PEACH));
    public static final Block PEACH_BUTTON = registerBlock("peach_button", button(MysticBlockSetTypes.PEACH));
    public static final Block PEACH_PRESSURE_PLATE = registerBlock("peach_pressure_plate", pressurePlate(PEACH_PLANKS, MysticBlockSetTypes.PEACH));
    public static final Block PEACH_TRAPDOOR = registerBlock("peach_trapdoor", trapdoor(PEACH_PLANKS, MysticBlockSetTypes.PEACH));
    public static final Block PEACH_DOOR = registerBlock("peach_door", door(PEACH_PLANKS, MysticBlockSetTypes.PEACH));
    public static final Block PEACH_SIGN = registerBlock("peach_sign", sign(PEACH_PLANKS, MysticWoodTypes.PEACH));
    public static final Block PEACH_WALL_SIGN = registerBlock("peach_wall_sign", wallSign(PEACH_SIGN, MysticWoodTypes.PEACH));
    public static final Block PEACH_HANGING_SIGN = registerBlock("peach_hanging_sign", hangingSign(PEACH_PLANKS, MysticWoodTypes.PEACH));
    public static final Block PEACH_WALL_HANGING_SIGN = registerBlock("peach_wall_hanging_sign", wallHangingSign(PEACH_HANGING_SIGN, MysticWoodTypes.PEACH));

    public static final Block PEACH_PLANT = registerBlock("peach_plant", new FruitPlantBlock(() -> MysticItems.PEACH, AbstractBlock.Settings.create().mapColor(MapColor.GREEN).ticksRandomly().noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block PEACH_PIE = registerBlock("peach_pie", new PieBlock(AbstractBlock.Settings.create().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block SAGUARO_CACTUS = registerBlock("saguaro_cactus", new SaguaroCactusBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_GREEN).ticksRandomly().strength(0.4F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block SAGUARO_BLOSSOM = registerBlock("saguaro_blossom", new SaguaroBlossomBlock(AbstractBlock.Settings.create().mapColor(MapColor.PINK).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)));
    public static final Block DESERT_GRASS = registerBlock("desert_grass", new MysticGrassBlock(AbstractBlock.Settings.create().mapColor(MapColor.DIRT_BROWN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XYZ).burnable().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILDFLOWER = registerBlock("wildflower", new WildflowerBlock(AbstractBlock.Settings.create().mapColor(MapColor.MAGENTA).offset(AbstractBlock.OffsetType.XZ).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)));

    public static final Block POTTED_PEACH_SAPLING = registerBlock("potted_peach_sapling", Blocks.createFlowerPotBlock(PEACH_SAPLING));
    public static final Block POTTED_WILDFLOWER = registerBlock("potted_wildflower", Blocks.createFlowerPotBlock(WILDFLOWER));

    /** autumnal grove */
    public static final Block MAPLE_LEAVES = registerBlock("maple_leaves", new MapleLeavesBlock(BlockSoundGroup.GRASS));
    public static final Block MAPLE_LEAF_PILE = registerBlock("maple_leaf_pile", new MapleLeafPileBlock(MysticParticles.MAPLE_LEAF_PILE, MapColor.GREEN));
    public static final Block MAPLE_SAPLING = registerBlock("maple_sapling", new MysticSaplingBlock(new MysticTreeGrower(MysticTreeFeatures.MAPLE_TREE), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));
    public static final Block ORANGE_MAPLE_LEAVES = registerBlock("orange_maple_leaves", new MapleLeavesBlock(BlockSoundGroup.GRASS));
    public static final Block ORANGE_MAPLE_LEAF_PILE = registerBlock("orange_maple_leaf_pile", new MapleLeafPileBlock(MysticParticles.ORANGE_MAPLE_LEAF_PILE, MapColor.ORANGE));
    public static final Block ORANGE_MAPLE_SAPLING = registerBlock("orange_maple_sapling", new MysticSaplingBlock(new MysticTreeGrower(MysticTreeFeatures.ORANGE_MAPLE_TREE), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));
    public static final Block YELLOW_MAPLE_LEAVES = registerBlock("yellow_maple_leaves", new MapleLeavesBlock(BlockSoundGroup.GRASS));
    public static final Block YELLOW_MAPLE_LEAF_PILE = registerBlock("yellow_maple_leaf_pile", new MapleLeafPileBlock(MysticParticles.YELLOW_MAPLE_LEAF_PILE, MapColor.YELLOW));
    public static final Block YELLOW_MAPLE_SAPLING = registerBlock("yellow_maple_sapling", new MysticSaplingBlock(new MysticTreeGrower(MysticTreeFeatures.YELLOW_MAPLE_TREE), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    public static final Block STRIPPED_MAPLE_LOG = registerBlock("stripped_maple_log", rotatedPillar(MapColor.ORANGE));
    public static final Block MAPLE_LOG = registerBlock("maple_log", log(MapColor.TERRACOTTA_BROWN, MapColor.ORANGE));
    public static final Block WHITE_MAPLE_LOG = registerBlock("white_maple_log", log(MapColor.TERRACOTTA_WHITE, MapColor.ORANGE));
    public static final Block STRIPPED_MAPLE_WOOD = registerBlock("stripped_maple_wood", rotatedPillar(MapColor.ORANGE));
    public static final Block MAPLE_WOOD = registerBlock("maple_wood", log(MapColor.TERRACOTTA_BROWN, MapColor.TERRACOTTA_BROWN));
    public static final Block WHITE_MAPLE_WOOD = registerBlock("white_maple_wood", log(MapColor.TERRACOTTA_WHITE, MapColor.TERRACOTTA_WHITE));
    public static final Block MAPLE_PLANKS = registerBlock("maple_planks", planks(MapColor.ORANGE));
    public static final Block MAPLE_STAIRS = registerBlock("maple_stairs", stairs(MAPLE_PLANKS));
    public static final Block MAPLE_SLAB = registerBlock("maple_slab", slab(MAPLE_PLANKS));
    public static final Block MAPLE_FENCE = registerBlock("maple_fence", fence(MAPLE_PLANKS));
    public static final Block MAPLE_FENCE_GATE = registerBlock("maple_fence_gate", fenceGate(MAPLE_PLANKS, MysticWoodTypes.MAPLE));
    public static final Block MAPLE_BUTTON = registerBlock("maple_button", button(MysticBlockSetTypes.MAPLE));
    public static final Block MAPLE_PRESSURE_PLATE = registerBlock("maple_pressure_plate", pressurePlate(MAPLE_PLANKS, MysticBlockSetTypes.MAPLE));
    public static final Block MAPLE_TRAPDOOR = registerBlock("maple_trapdoor", trapdoor(MAPLE_PLANKS, MysticBlockSetTypes.MAPLE));
    public static final Block MAPLE_DOOR = registerBlock("maple_door", door(MAPLE_PLANKS, MysticBlockSetTypes.MAPLE));
    public static final Block MAPLE_SIGN = registerBlock("maple_sign", sign(MAPLE_PLANKS, MysticWoodTypes.MAPLE));
    public static final Block MAPLE_WALL_SIGN = registerBlock("maple_wall_sign", wallSign(MAPLE_SIGN, MysticWoodTypes.MAPLE));
    public static final Block MAPLE_HANGING_SIGN = registerBlock("maple_hanging_sign", hangingSign(MAPLE_PLANKS, MysticWoodTypes.MAPLE));
    public static final Block MAPLE_WALL_HANGING_SIGN = registerBlock("maple_wall_hanging_sign", wallHangingSign(MAPLE_HANGING_SIGN, MysticWoodTypes.MAPLE));

    public static final Block POTTED_MAPLE_SAPLING = registerBlock("potted_maple_sapling", Blocks.createFlowerPotBlock(MAPLE_SAPLING));
    public static final Block POTTED_ORANGE_MAPLE_SAPLING = registerBlock("potted_orange_maple_sapling", Blocks.createFlowerPotBlock(ORANGE_MAPLE_SAPLING));
    public static final Block POTTED_YELLOW_MAPLE_SAPLING = registerBlock("potted_yellow_maple_sapling", Blocks.createFlowerPotBlock(YELLOW_MAPLE_SAPLING));

    /** lagoon */
    public static final Block SEA_SHRUB_LEAVES = registerBlock("sea_shrub_leaves", new MysticLeavesBlock(BlockSoundGroup.GRASS));
    public static final Block SEA_SHRUB = registerBlock("sea_shrub", new MysticBushBlock(new MysticTreeGrower(MysticTreeFeatures.SEA_SHRUB), AbstractBlock.Settings.copy(Blocks.AZALEA)));

    public static final Block STRIPPED_SEA_FOAM_LOG = registerBlock("stripped_sea_foam_log", rotatedPillar(MapColor.CYAN));
    public static final Block SEA_FOAM_LOG = registerBlock("sea_foam_log", log(MapColor.TERRACOTTA_BROWN, MapColor.CYAN));
    public static final Block STRIPPED_SEA_FOAM_WOOD = registerBlock("stripped_sea_foam_wood", rotatedPillar(MapColor.CYAN));
    public static final Block SEA_FOAM_WOOD = registerBlock("sea_foam_wood", log(MapColor.TERRACOTTA_BROWN, MapColor.TERRACOTTA_BROWN));
    public static final Block SEA_FOAM_PLANKS = registerBlock("sea_foam_planks", planks(MapColor.CYAN));
    public static final Block SEA_FOAM_STAIRS = registerBlock("sea_foam_stairs", stairs(SEA_FOAM_PLANKS));
    public static final Block SEA_FOAM_SLAB = registerBlock("sea_foam_slab", slab(SEA_FOAM_PLANKS));
    public static final Block SEA_FOAM_FENCE = registerBlock("sea_foam_fence", fence(SEA_FOAM_PLANKS));
    public static final Block SEA_FOAM_FENCE_GATE = registerBlock("sea_foam_fence_gate", fenceGate(SEA_FOAM_PLANKS, MysticWoodTypes.SEA_FOAM));
    public static final Block SEA_FOAM_BUTTON = registerBlock("sea_foam_button", button(MysticBlockSetTypes.SEA_FOAM));
    public static final Block SEA_FOAM_PRESSURE_PLATE = registerBlock("sea_foam_pressure_plate", pressurePlate(SEA_FOAM_PLANKS, MysticBlockSetTypes.SEA_FOAM));
    public static final Block SEA_FOAM_TRAPDOOR = registerBlock("sea_foam_trapdoor", trapdoor(SEA_FOAM_PLANKS, MysticBlockSetTypes.SEA_FOAM));
    public static final Block SEA_FOAM_DOOR = registerBlock("sea_foam_door", door(SEA_FOAM_PLANKS, MysticBlockSetTypes.SEA_FOAM));
    public static final Block SEA_FOAM_SIGN = registerBlock("sea_foam_sign", sign(SEA_FOAM_PLANKS, MysticWoodTypes.SEA_FOAM));
    public static final Block SEA_FOAM_WALL_SIGN = registerBlock("sea_foam_wall_sign", wallSign(SEA_FOAM_SIGN, MysticWoodTypes.SEA_FOAM));
    public static final Block SEA_FOAM_HANGING_SIGN = registerBlock("sea_foam_hanging_sign", hangingSign(SEA_FOAM_PLANKS, MysticWoodTypes.SEA_FOAM));
    public static final Block SEA_FOAM_WALL_HANGING_SIGN = registerBlock("sea_foam_wall_hanging_sign", wallHangingSign(SEA_FOAM_HANGING_SIGN, MysticWoodTypes.SEA_FOAM));

    public static final Block SEA_OATS = registerBlock("sea_oats", new SeaOatsBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).offset(AbstractBlock.OffsetType.XZ).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)));
    public static final Block MILKWEED = registerBlock("milkweed", new MilkweedFlowerBlock(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_PINK).offset(AbstractBlock.OffsetType.XZ).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)));

    public static final Block POTTED_SEA_SHRUB = registerBlock("potted_sea_shrub", Blocks.createFlowerPotBlock(SEA_SHRUB));

    /** topics */
    public static final Block TROPICAL_LEAVES = registerBlock("tropical_leaves", new MysticLeavesBlock(BlockSoundGroup.GRASS));
    public static final Block TROPICAL_SAPLING = registerBlock("tropical_sapling", new MysticSaplingBlock(new MysticTreeGrower(MysticTreeFeatures.TROPICAL_TREE), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    public static final Block STRIPPED_TROPICAL_LOG = registerBlock("stripped_tropical_log", rotatedPillar(MapColor.BLUE));
    public static final Block TROPICAL_LOG = registerBlock("tropical_log", log(MapColor.TERRACOTTA_BROWN, MapColor.BLUE));
    public static final Block STRIPPED_TROPICAL_WOOD = registerBlock("stripped_tropical_wood", rotatedPillar(MapColor.BLUE));
    public static final Block TROPICAL_WOOD = registerBlock("tropical_wood", log(MapColor.TERRACOTTA_BROWN, MapColor.TERRACOTTA_BROWN));
    public static final Block TROPICAL_PLANKS = registerBlock("tropical_planks", planks(MapColor.BLUE));
    public static final Block TROPICAL_STAIRS = registerBlock("tropical_stairs", stairs(TROPICAL_PLANKS));
    public static final Block TROPICAL_SLAB = registerBlock("tropical_slab", slab(TROPICAL_PLANKS));
    public static final Block TROPICAL_FENCE = registerBlock("tropical_fence", fence(TROPICAL_PLANKS));
    public static final Block TROPICAL_FENCE_GATE = registerBlock("tropical_fence_gate", fenceGate(TROPICAL_PLANKS, MysticWoodTypes.TROPICAL));
    public static final Block TROPICAL_BUTTON = registerBlock("tropical_button", button(MysticBlockSetTypes.TROPICAL));
    public static final Block TROPICAL_PRESSURE_PLATE = registerBlock("tropical_pressure_plate", pressurePlate(TROPICAL_PLANKS, MysticBlockSetTypes.TROPICAL));
    public static final Block TROPICAL_TRAPDOOR = registerBlock("tropical_trapdoor", trapdoor(TROPICAL_PLANKS, MysticBlockSetTypes.TROPICAL));
    public static final Block TROPICAL_DOOR = registerBlock("tropical_door", door(TROPICAL_PLANKS, MysticBlockSetTypes.TROPICAL));
    public static final Block TROPICAL_SIGN = registerBlock("tropical_sign", sign(TROPICAL_PLANKS, MysticWoodTypes.TROPICAL));
    public static final Block TROPICAL_WALL_SIGN = registerBlock("tropical_wall_sign", wallSign(TROPICAL_SIGN, MysticWoodTypes.TROPICAL));
    public static final Block TROPICAL_HANGING_SIGN = registerBlock("tropical_hanging_sign", hangingSign(TROPICAL_PLANKS, MysticWoodTypes.TROPICAL));
    public static final Block TROPICAL_WALL_HANGING_SIGN = registerBlock("tropical_wall_hanging_sign", wallHangingSign(TROPICAL_HANGING_SIGN, MysticWoodTypes.TROPICAL));

    public static final Block HYDRANGEA_LEAVES = registerBlock("hydrangea_leaves", new MysticLeavesBlock(BlockSoundGroup.GRASS));
    public static final Block HYDRANGEA_BUSH = registerBlock("hydrangea_bush", new MysticBushBlock(new MysticTreeGrower(MysticTreeFeatures.HYDRANGEA_BUSH), AbstractBlock.Settings.copy(Blocks.AZALEA)));

    public static final Block VANILLA_ORCHID = registerBlock("vanilla_orchid", new VanillaOrchidBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).ticksRandomly().noCollision().sounds(BlockSoundGroup.CAVE_VINES).pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block POTTED_TROPICAL_SAPLING = registerBlock("potted_tropical_sapling", Blocks.createFlowerPotBlock(TROPICAL_SAPLING));
    public static final Block POTTED_HYDRANGEA_BUSH = registerBlock("potted_hydrangea_bush", Blocks.createFlowerPotBlock(HYDRANGEA_BUSH));

    /** lavender meadow */
    public static final Block JACARANDA_BLOSSOMS = registerBlock("jacaranda_blossoms", new BlossomLeavesBlock(() -> MysticParticles.JACARANDA_BLOSSOM, BlockSoundGroup.AZALEA_LEAVES));
    public static final Block JACARANDA_LEAVES = registerBlock("jacaranda_leaves", new MysticLeavesBlock(BlockSoundGroup.AZALEA_LEAVES));
    public static final Block JACARANDA_SAPLING = registerBlock("jacaranda_sapling", new MysticSaplingBlock(new MysticTreeGrower(MysticTreeFeatures.JACARANDA_TREE), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    public static final Block STRIPPED_JACARANDA_LOG = registerBlock("stripped_jacaranda_log", rotatedPillar(MapColor.PALE_PURPLE));
    public static final Block JACARANDA_LOG = registerBlock("jacaranda_log", log(MapColor.TERRACOTTA_PURPLE, MapColor.PALE_PURPLE));
    public static final Block STRIPPED_JACARANDA_WOOD = registerBlock("stripped_jacaranda_wood", rotatedPillar(MapColor.PALE_PURPLE));
    public static final Block JACARANDA_WOOD = registerBlock("jacaranda_wood", log(MapColor.TERRACOTTA_PURPLE, MapColor.TERRACOTTA_PURPLE));
    public static final Block JACARANDA_PLANKS = registerBlock("jacaranda_planks", planks(MapColor.PALE_PURPLE));
    public static final Block JACARANDA_STAIRS = registerBlock("jacaranda_stairs", stairs(JACARANDA_PLANKS));
    public static final Block JACARANDA_SLAB = registerBlock("jacaranda_slab", slab(JACARANDA_PLANKS));
    public static final Block JACARANDA_FENCE = registerBlock("jacaranda_fence", fence(JACARANDA_PLANKS));
    public static final Block JACARANDA_FENCE_GATE = registerBlock("jacaranda_fence_gate", fenceGate(JACARANDA_PLANKS, MysticWoodTypes.JACARANDA));
    public static final Block JACARANDA_BUTTON = registerBlock("jacaranda_button", button(MysticBlockSetTypes.JACARANDA));
    public static final Block JACARANDA_PRESSURE_PLATE = registerBlock("jacaranda_pressure_plate", pressurePlate(JACARANDA_PLANKS, MysticBlockSetTypes.JACARANDA));
    public static final Block JACARANDA_TRAPDOOR = registerBlock("jacaranda_trapdoor", trapdoor(JACARANDA_PLANKS, MysticBlockSetTypes.JACARANDA));
    public static final Block JACARANDA_DOOR = registerBlock("jacaranda_door", door(JACARANDA_PLANKS, MysticBlockSetTypes.JACARANDA));
    public static final Block JACARANDA_SIGN = registerBlock("jacaranda_sign", sign(JACARANDA_PLANKS, MysticWoodTypes.JACARANDA));
    public static final Block JACARANDA_WALL_SIGN = registerBlock("jacaranda_wall_sign", wallSign(JACARANDA_SIGN, MysticWoodTypes.JACARANDA));
    public static final Block JACARANDA_HANGING_SIGN = registerBlock("jacaranda_hanging_sign", hangingSign(JACARANDA_PLANKS, MysticWoodTypes.JACARANDA));
    public static final Block JACARANDA_WALL_HANGING_SIGN = registerBlock("jacaranda_wall_hanging_sign", wallHangingSign(JACARANDA_HANGING_SIGN, MysticWoodTypes.JACARANDA));

    public static final Block LAVENDER = registerBlock("lavender", new LavenderFlowerBlock(AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).offset(AbstractBlock.OffsetType.XZ).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)));

    public static final Block BUTTERFLY_NEST = registerBlock("butterfly_nest", new ButterflyNestBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_GREEN).strength(0.5F).sounds(BlockSoundGroup.FLOWERING_AZALEA).nonOpaque().burnable()));
    public static final Block GLASS_JAR = registerBlock("glass_jar", new GlassJarBlock(AbstractBlock.Settings.copy(Blocks.GLASS)));

    public static final Block POTTED_JACARANDA_SAPLING = registerBlock("potted_jacaranda_sapling", Blocks.createFlowerPotBlock(JACARANDA_SAPLING));
    public static final Block POTTED_LAVENDER = registerBlock("potted_lavender", Blocks.createFlowerPotBlock(LAVENDER));

    /** shared features, cakes, & misc. */
    public static final Block STRAWBERRY_CAKE = registerBlock("strawberry_cake", new MysticCakeBlock(AbstractBlock.Settings.create().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block STRAWBERRY_CANDLE_CAKE = registerBlock("strawberry_candle_cake",  new MysticCandleCakeBlock(STRAWBERRY_CAKE, Blocks.CANDLE));
    public static final Block STRAWBERRY_CANDLE_CAKE_WHITE = registerBlock("strawberry_candle_cake_white", new MysticCandleCakeBlock(STRAWBERRY_CAKE, Blocks.WHITE_CANDLE));
    public static final Block STRAWBERRY_CANDLE_CAKE_ORANGE = registerBlock("strawberry_candle_cake_orange", new MysticCandleCakeBlock(STRAWBERRY_CAKE, Blocks.ORANGE_CANDLE));
    public static final Block STRAWBERRY_CANDLE_CAKE_MAGENTA = registerBlock("strawberry_candle_cake_magenta", new MysticCandleCakeBlock(STRAWBERRY_CAKE, Blocks.MAGENTA_CANDLE));
    public static final Block STRAWBERRY_CANDLE_CAKE_LIGHT_BLUE = registerBlock("strawberry_candle_cake_light_blue", new MysticCandleCakeBlock(STRAWBERRY_CAKE, Blocks.LIGHT_BLUE_CANDLE));
    public static final Block STRAWBERRY_CANDLE_CAKE_YELLOW = registerBlock("strawberry_candle_cake_yellow", new MysticCandleCakeBlock(STRAWBERRY_CAKE, Blocks.YELLOW_CANDLE));
    public static final Block STRAWBERRY_CANDLE_CAKE_LIME = registerBlock("strawberry_candle_cake_lime", new MysticCandleCakeBlock(STRAWBERRY_CAKE, Blocks.LIME_CANDLE));
    public static final Block STRAWBERRY_CANDLE_CAKE_PINK = registerBlock("strawberry_candle_cake_pink", new MysticCandleCakeBlock(STRAWBERRY_CAKE, Blocks.PINK_CANDLE));
    public static final Block STRAWBERRY_CANDLE_CAKE_GRAY = registerBlock("strawberry_candle_cake_gray", new MysticCandleCakeBlock(STRAWBERRY_CAKE, Blocks.GRAY_CANDLE));
    public static final Block STRAWBERRY_CANDLE_CAKE_LIGHT_GRAY = registerBlock("strawberry_candle_cake_light_gray", new MysticCandleCakeBlock(STRAWBERRY_CAKE, Blocks.LIGHT_GRAY_CANDLE));
    public static final Block STRAWBERRY_CANDLE_CAKE_CYAN = registerBlock("strawberry_candle_cake_cyan", new MysticCandleCakeBlock(STRAWBERRY_CAKE, Blocks.CYAN_CANDLE));
    public static final Block STRAWBERRY_CANDLE_CAKE_PURPLE = registerBlock("strawberry_candle_cake_purple", new MysticCandleCakeBlock(STRAWBERRY_CAKE, Blocks.PURPLE_CANDLE));
    public static final Block STRAWBERRY_CANDLE_CAKE_BLUE = registerBlock("strawberry_candle_cake_blue", new MysticCandleCakeBlock(STRAWBERRY_CAKE, Blocks.BLUE_CANDLE));
    public static final Block STRAWBERRY_CANDLE_CAKE_BROWN = registerBlock("strawberry_candle_cake_brown", new MysticCandleCakeBlock(STRAWBERRY_CAKE, Blocks.BROWN_CANDLE));
    public static final Block STRAWBERRY_CANDLE_CAKE_GREEN = registerBlock("strawberry_candle_cake_green", new MysticCandleCakeBlock(STRAWBERRY_CAKE, Blocks.GREEN_CANDLE));
    public static final Block STRAWBERRY_CANDLE_CAKE_RED = registerBlock("strawberry_candle_cake_red", new MysticCandleCakeBlock(STRAWBERRY_CAKE, Blocks.RED_CANDLE));
    public static final Block STRAWBERRY_CANDLE_CAKE_BLACK = registerBlock("strawberry_candle_cake_black", new MysticCandleCakeBlock(STRAWBERRY_CAKE, Blocks.BLACK_CANDLE));

    public static final Block VANILLA_CAKE = registerBlock("vanilla_cake", new MysticCakeBlock(AbstractBlock.Settings.create().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block VANILLA_CANDLE_CAKE = registerBlock("vanilla_candle_cake",  new MysticCandleCakeBlock(VANILLA_CAKE, Blocks.CANDLE));
    public static final Block VANILLA_CANDLE_CAKE_WHITE = registerBlock("vanilla_candle_cake_white", new MysticCandleCakeBlock(VANILLA_CAKE, Blocks.WHITE_CANDLE));
    public static final Block VANILLA_CANDLE_CAKE_ORANGE = registerBlock("vanilla_candle_cake_orange", new MysticCandleCakeBlock(VANILLA_CAKE, Blocks.ORANGE_CANDLE));
    public static final Block VANILLA_CANDLE_CAKE_MAGENTA = registerBlock("vanilla_candle_cake_magenta", new MysticCandleCakeBlock(VANILLA_CAKE, Blocks.MAGENTA_CANDLE));
    public static final Block VANILLA_CANDLE_CAKE_LIGHT_BLUE = registerBlock("vanilla_candle_cake_light_blue", new MysticCandleCakeBlock(VANILLA_CAKE, Blocks.LIGHT_BLUE_CANDLE));
    public static final Block VANILLA_CANDLE_CAKE_YELLOW = registerBlock("vanilla_candle_cake_yellow", new MysticCandleCakeBlock(VANILLA_CAKE, Blocks.YELLOW_CANDLE));
    public static final Block VANILLA_CANDLE_CAKE_LIME = registerBlock("vanilla_candle_cake_lime", new MysticCandleCakeBlock(VANILLA_CAKE, Blocks.LIME_CANDLE));
    public static final Block VANILLA_CANDLE_CAKE_PINK = registerBlock("vanilla_candle_cake_pink", new MysticCandleCakeBlock(VANILLA_CAKE, Blocks.PINK_CANDLE));
    public static final Block VANILLA_CANDLE_CAKE_GRAY = registerBlock("vanilla_candle_cake_gray", new MysticCandleCakeBlock(VANILLA_CAKE, Blocks.GRAY_CANDLE));
    public static final Block VANILLA_CANDLE_CAKE_LIGHT_GRAY = registerBlock("vanilla_candle_cake_light_gray", new MysticCandleCakeBlock(VANILLA_CAKE, Blocks.LIGHT_GRAY_CANDLE));
    public static final Block VANILLA_CANDLE_CAKE_CYAN = registerBlock("vanilla_candle_cake_cyan", new MysticCandleCakeBlock(VANILLA_CAKE, Blocks.CYAN_CANDLE));
    public static final Block VANILLA_CANDLE_CAKE_PURPLE = registerBlock("vanilla_candle_cake_purple", new MysticCandleCakeBlock(VANILLA_CAKE, Blocks.PURPLE_CANDLE));
    public static final Block VANILLA_CANDLE_CAKE_BLUE = registerBlock("vanilla_candle_cake_blue", new MysticCandleCakeBlock(VANILLA_CAKE, Blocks.BLUE_CANDLE));
    public static final Block VANILLA_CANDLE_CAKE_BROWN = registerBlock("vanilla_candle_cake_brown", new MysticCandleCakeBlock(VANILLA_CAKE, Blocks.BROWN_CANDLE));
    public static final Block VANILLA_CANDLE_CAKE_GREEN = registerBlock("vanilla_candle_cake_green", new MysticCandleCakeBlock(VANILLA_CAKE, Blocks.GREEN_CANDLE));
    public static final Block VANILLA_CANDLE_CAKE_RED = registerBlock("vanilla_candle_cake_red", new MysticCandleCakeBlock(VANILLA_CAKE, Blocks.RED_CANDLE));
    public static final Block VANILLA_CANDLE_CAKE_BLACK = registerBlock("vanilla_candle_cake_black", new MysticCandleCakeBlock(VANILLA_CAKE, Blocks.BLACK_CANDLE));

    public static final Block CHOCOLATE_CAKE = registerBlock("chocolate_cake", new MysticCakeBlock(AbstractBlock.Settings.create().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block CHOCOLATE_CANDLE_CAKE = registerBlock("chocolate_candle_cake",  new MysticCandleCakeBlock(CHOCOLATE_CAKE, Blocks.CANDLE));
    public static final Block CHOCOLATE_CANDLE_CAKE_WHITE = registerBlock("chocolate_candle_cake_white", new MysticCandleCakeBlock(CHOCOLATE_CAKE, Blocks.WHITE_CANDLE));
    public static final Block CHOCOLATE_CANDLE_CAKE_ORANGE = registerBlock("chocolate_candle_cake_orange", new MysticCandleCakeBlock(CHOCOLATE_CAKE, Blocks.ORANGE_CANDLE));
    public static final Block CHOCOLATE_CANDLE_CAKE_MAGENTA = registerBlock("chocolate_candle_cake_magenta", new MysticCandleCakeBlock(CHOCOLATE_CAKE, Blocks.MAGENTA_CANDLE));
    public static final Block CHOCOLATE_CANDLE_CAKE_LIGHT_BLUE = registerBlock("chocolate_candle_cake_light_blue", new MysticCandleCakeBlock(CHOCOLATE_CAKE, Blocks.LIGHT_BLUE_CANDLE));
    public static final Block CHOCOLATE_CANDLE_CAKE_YELLOW = registerBlock("chocolate_candle_cake_yellow", new MysticCandleCakeBlock(CHOCOLATE_CAKE, Blocks.YELLOW_CANDLE));
    public static final Block CHOCOLATE_CANDLE_CAKE_LIME = registerBlock("chocolate_candle_cake_lime", new MysticCandleCakeBlock(CHOCOLATE_CAKE, Blocks.LIME_CANDLE));
    public static final Block CHOCOLATE_CANDLE_CAKE_PINK = registerBlock("chocolate_candle_cake_pink", new MysticCandleCakeBlock(CHOCOLATE_CAKE, Blocks.PINK_CANDLE));
    public static final Block CHOCOLATE_CANDLE_CAKE_GRAY = registerBlock("chocolate_candle_cake_gray", new MysticCandleCakeBlock(CHOCOLATE_CAKE, Blocks.GRAY_CANDLE));
    public static final Block CHOCOLATE_CANDLE_CAKE_LIGHT_GRAY = registerBlock("chocolate_candle_cake_light_gray", new MysticCandleCakeBlock(CHOCOLATE_CAKE, Blocks.LIGHT_GRAY_CANDLE));
    public static final Block CHOCOLATE_CANDLE_CAKE_CYAN = registerBlock("chocolate_candle_cake_cyan", new MysticCandleCakeBlock(CHOCOLATE_CAKE, Blocks.CYAN_CANDLE));
    public static final Block CHOCOLATE_CANDLE_CAKE_PURPLE = registerBlock("chocolate_candle_cake_purple", new MysticCandleCakeBlock(CHOCOLATE_CAKE, Blocks.PURPLE_CANDLE));
    public static final Block CHOCOLATE_CANDLE_CAKE_BLUE = registerBlock("chocolate_candle_cake_blue", new MysticCandleCakeBlock(CHOCOLATE_CAKE, Blocks.BLUE_CANDLE));
    public static final Block CHOCOLATE_CANDLE_CAKE_BROWN = registerBlock("chocolate_candle_cake_brown", new MysticCandleCakeBlock(CHOCOLATE_CAKE, Blocks.BROWN_CANDLE));
    public static final Block CHOCOLATE_CANDLE_CAKE_GREEN = registerBlock("chocolate_candle_cake_green", new MysticCandleCakeBlock(CHOCOLATE_CAKE, Blocks.GREEN_CANDLE));
    public static final Block CHOCOLATE_CANDLE_CAKE_RED = registerBlock("chocolate_candle_cake_red", new MysticCandleCakeBlock(CHOCOLATE_CAKE, Blocks.RED_CANDLE));
    public static final Block CHOCOLATE_CANDLE_CAKE_BLACK = registerBlock("chocolate_candle_cake_black", new MysticCandleCakeBlock(CHOCOLATE_CAKE, Blocks.BLACK_CANDLE));

    public static final Block PINK_FROSTED_CAKE = registerBlock("pink_frosted_cake", new MysticCakeBlock(AbstractBlock.Settings.create().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block PINK_FROSTED_CANDLE_CAKE = registerBlock("pink_frosted_candle_cake",  new MysticCandleCakeBlock(PINK_FROSTED_CAKE, Blocks.CANDLE));
    public static final Block PINK_FROSTED_CANDLE_CAKE_WHITE = registerBlock("pink_frosted_candle_cake_white", new MysticCandleCakeBlock(PINK_FROSTED_CAKE, Blocks.WHITE_CANDLE));
    public static final Block PINK_FROSTED_CANDLE_CAKE_ORANGE = registerBlock("pink_frosted_candle_cake_orange", new MysticCandleCakeBlock(PINK_FROSTED_CAKE, Blocks.ORANGE_CANDLE));
    public static final Block PINK_FROSTED_CANDLE_CAKE_MAGENTA = registerBlock("pink_frosted_candle_cake_magenta", new MysticCandleCakeBlock(PINK_FROSTED_CAKE, Blocks.MAGENTA_CANDLE));
    public static final Block PINK_FROSTED_CANDLE_CAKE_LIGHT_BLUE = registerBlock("pink_frosted_candle_cake_light_blue", new MysticCandleCakeBlock(PINK_FROSTED_CAKE, Blocks.LIGHT_BLUE_CANDLE));
    public static final Block PINK_FROSTED_CANDLE_CAKE_YELLOW = registerBlock("pink_frosted_candle_cake_yellow", new MysticCandleCakeBlock(PINK_FROSTED_CAKE, Blocks.YELLOW_CANDLE));
    public static final Block PINK_FROSTED_CANDLE_CAKE_LIME = registerBlock("pink_frosted_candle_cake_lime", new MysticCandleCakeBlock(PINK_FROSTED_CAKE, Blocks.LIME_CANDLE));
    public static final Block PINK_FROSTED_CANDLE_CAKE_PINK = registerBlock("pink_frosted_candle_cake_pink", new MysticCandleCakeBlock(PINK_FROSTED_CAKE, Blocks.PINK_CANDLE));
    public static final Block PINK_FROSTED_CANDLE_CAKE_GRAY = registerBlock("pink_frosted_candle_cake_gray", new MysticCandleCakeBlock(PINK_FROSTED_CAKE, Blocks.GRAY_CANDLE));
    public static final Block PINK_FROSTED_CANDLE_CAKE_LIGHT_GRAY = registerBlock("pink_frosted_candle_cake_light_gray", new MysticCandleCakeBlock(PINK_FROSTED_CAKE, Blocks.LIGHT_GRAY_CANDLE));
    public static final Block PINK_FROSTED_CANDLE_CAKE_CYAN = registerBlock("pink_frosted_candle_cake_cyan", new MysticCandleCakeBlock(PINK_FROSTED_CAKE, Blocks.CYAN_CANDLE));
    public static final Block PINK_FROSTED_CANDLE_CAKE_PURPLE = registerBlock("pink_frosted_candle_cake_purple", new MysticCandleCakeBlock(PINK_FROSTED_CAKE, Blocks.PURPLE_CANDLE));
    public static final Block PINK_FROSTED_CANDLE_CAKE_BLUE = registerBlock("pink_frosted_candle_cake_blue", new MysticCandleCakeBlock(PINK_FROSTED_CAKE, Blocks.BLUE_CANDLE));
    public static final Block PINK_FROSTED_CANDLE_CAKE_BROWN = registerBlock("pink_frosted_candle_cake_brown", new MysticCandleCakeBlock(PINK_FROSTED_CAKE, Blocks.BROWN_CANDLE));
    public static final Block PINK_FROSTED_CANDLE_CAKE_GREEN = registerBlock("pink_frosted_candle_cake_green", new MysticCandleCakeBlock(PINK_FROSTED_CAKE, Blocks.GREEN_CANDLE));
    public static final Block PINK_FROSTED_CANDLE_CAKE_RED = registerBlock("pink_frosted_candle_cake_red", new MysticCandleCakeBlock(PINK_FROSTED_CAKE, Blocks.RED_CANDLE));
    public static final Block PINK_FROSTED_CANDLE_CAKE_BLACK = registerBlock("pink_frosted_candle_cake_black", new MysticCandleCakeBlock(PINK_FROSTED_CAKE, Blocks.BLACK_CANDLE));

    public static final Block ORANGE_FROSTED_CAKE = registerBlock("orange_frosted_cake", new MysticCakeBlock(AbstractBlock.Settings.create().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ORANGE_FROSTED_CANDLE_CAKE = registerBlock("orange_frosted_candle_cake",  new MysticCandleCakeBlock(ORANGE_FROSTED_CAKE, Blocks.CANDLE));
    public static final Block ORANGE_FROSTED_CANDLE_CAKE_WHITE = registerBlock("orange_frosted_candle_cake_white", new MysticCandleCakeBlock(ORANGE_FROSTED_CAKE, Blocks.WHITE_CANDLE));
    public static final Block ORANGE_FROSTED_CANDLE_CAKE_ORANGE = registerBlock("orange_frosted_candle_cake_orange", new MysticCandleCakeBlock(ORANGE_FROSTED_CAKE, Blocks.ORANGE_CANDLE));
    public static final Block ORANGE_FROSTED_CANDLE_CAKE_MAGENTA = registerBlock("orange_frosted_candle_cake_magenta", new MysticCandleCakeBlock(ORANGE_FROSTED_CAKE, Blocks.MAGENTA_CANDLE));
    public static final Block ORANGE_FROSTED_CANDLE_CAKE_LIGHT_BLUE = registerBlock("orange_frosted_candle_cake_light_blue", new MysticCandleCakeBlock(ORANGE_FROSTED_CAKE, Blocks.LIGHT_BLUE_CANDLE));
    public static final Block ORANGE_FROSTED_CANDLE_CAKE_YELLOW = registerBlock("orange_frosted_candle_cake_yellow", new MysticCandleCakeBlock(ORANGE_FROSTED_CAKE, Blocks.YELLOW_CANDLE));
    public static final Block ORANGE_FROSTED_CANDLE_CAKE_LIME = registerBlock("orange_frosted_candle_cake_lime", new MysticCandleCakeBlock(ORANGE_FROSTED_CAKE, Blocks.LIME_CANDLE));
    public static final Block ORANGE_FROSTED_CANDLE_CAKE_PINK = registerBlock("orange_frosted_candle_cake_pink", new MysticCandleCakeBlock(ORANGE_FROSTED_CAKE, Blocks.PINK_CANDLE));
    public static final Block ORANGE_FROSTED_CANDLE_CAKE_GRAY = registerBlock("orange_frosted_candle_cake_gray", new MysticCandleCakeBlock(ORANGE_FROSTED_CAKE, Blocks.GRAY_CANDLE));
    public static final Block ORANGE_FROSTED_CANDLE_CAKE_LIGHT_GRAY = registerBlock("orange_frosted_candle_cake_light_gray", new MysticCandleCakeBlock(ORANGE_FROSTED_CAKE, Blocks.LIGHT_GRAY_CANDLE));
    public static final Block ORANGE_FROSTED_CANDLE_CAKE_CYAN = registerBlock("orange_frosted_candle_cake_cyan", new MysticCandleCakeBlock(ORANGE_FROSTED_CAKE, Blocks.CYAN_CANDLE));
    public static final Block ORANGE_FROSTED_CANDLE_CAKE_PURPLE = registerBlock("orange_frosted_candle_cake_purple", new MysticCandleCakeBlock(ORANGE_FROSTED_CAKE, Blocks.PURPLE_CANDLE));
    public static final Block ORANGE_FROSTED_CANDLE_CAKE_BLUE = registerBlock("orange_frosted_candle_cake_blue", new MysticCandleCakeBlock(ORANGE_FROSTED_CAKE, Blocks.BLUE_CANDLE));
    public static final Block ORANGE_FROSTED_CANDLE_CAKE_BROWN = registerBlock("orange_frosted_candle_cake_brown", new MysticCandleCakeBlock(ORANGE_FROSTED_CAKE, Blocks.BROWN_CANDLE));
    public static final Block ORANGE_FROSTED_CANDLE_CAKE_GREEN = registerBlock("orange_frosted_candle_cake_green", new MysticCandleCakeBlock(ORANGE_FROSTED_CAKE, Blocks.GREEN_CANDLE));
    public static final Block ORANGE_FROSTED_CANDLE_CAKE_RED = registerBlock("orange_frosted_candle_cake_red", new MysticCandleCakeBlock(ORANGE_FROSTED_CAKE, Blocks.RED_CANDLE));
    public static final Block ORANGE_FROSTED_CANDLE_CAKE_BLACK = registerBlock("orange_frosted_candle_cake_black", new MysticCandleCakeBlock(ORANGE_FROSTED_CAKE, Blocks.BLACK_CANDLE));

    public static final Block YELLOW_FROSTED_CAKE = registerBlock("yellow_frosted_cake", new MysticCakeBlock(AbstractBlock.Settings.create().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block YELLOW_FROSTED_CANDLE_CAKE = registerBlock("yellow_frosted_candle_cake",  new MysticCandleCakeBlock(YELLOW_FROSTED_CAKE, Blocks.CANDLE));
    public static final Block YELLOW_FROSTED_CANDLE_CAKE_WHITE = registerBlock("yellow_frosted_candle_cake_white", new MysticCandleCakeBlock(YELLOW_FROSTED_CAKE, Blocks.WHITE_CANDLE));
    public static final Block YELLOW_FROSTED_CANDLE_CAKE_ORANGE = registerBlock("yellow_frosted_candle_cake_orange", new MysticCandleCakeBlock(YELLOW_FROSTED_CAKE, Blocks.ORANGE_CANDLE));
    public static final Block YELLOW_FROSTED_CANDLE_CAKE_MAGENTA = registerBlock("yellow_frosted_candle_cake_magenta", new MysticCandleCakeBlock(YELLOW_FROSTED_CAKE, Blocks.MAGENTA_CANDLE));
    public static final Block YELLOW_FROSTED_CANDLE_CAKE_LIGHT_BLUE = registerBlock("yellow_frosted_candle_cake_light_blue", new MysticCandleCakeBlock(YELLOW_FROSTED_CAKE, Blocks.LIGHT_BLUE_CANDLE));
    public static final Block YELLOW_FROSTED_CANDLE_CAKE_YELLOW = registerBlock("yellow_frosted_candle_cake_yellow", new MysticCandleCakeBlock(YELLOW_FROSTED_CAKE, Blocks.YELLOW_CANDLE));
    public static final Block YELLOW_FROSTED_CANDLE_CAKE_LIME = registerBlock("yellow_frosted_candle_cake_lime", new MysticCandleCakeBlock(YELLOW_FROSTED_CAKE, Blocks.LIME_CANDLE));
    public static final Block YELLOW_FROSTED_CANDLE_CAKE_PINK = registerBlock("yellow_frosted_candle_cake_pink", new MysticCandleCakeBlock(YELLOW_FROSTED_CAKE, Blocks.PINK_CANDLE));
    public static final Block YELLOW_FROSTED_CANDLE_CAKE_GRAY = registerBlock("yellow_frosted_candle_cake_gray", new MysticCandleCakeBlock(YELLOW_FROSTED_CAKE, Blocks.GRAY_CANDLE));
    public static final Block YELLOW_FROSTED_CANDLE_CAKE_LIGHT_GRAY = registerBlock("yellow_frosted_candle_cake_light_gray", new MysticCandleCakeBlock(YELLOW_FROSTED_CAKE, Blocks.LIGHT_GRAY_CANDLE));
    public static final Block YELLOW_FROSTED_CANDLE_CAKE_CYAN = registerBlock("yellow_frosted_candle_cake_cyan", new MysticCandleCakeBlock(YELLOW_FROSTED_CAKE, Blocks.CYAN_CANDLE));
    public static final Block YELLOW_FROSTED_CANDLE_CAKE_PURPLE = registerBlock("yellow_frosted_candle_cake_purple", new MysticCandleCakeBlock(YELLOW_FROSTED_CAKE, Blocks.PURPLE_CANDLE));
    public static final Block YELLOW_FROSTED_CANDLE_CAKE_BLUE = registerBlock("yellow_frosted_candle_cake_blue", new MysticCandleCakeBlock(YELLOW_FROSTED_CAKE, Blocks.BLUE_CANDLE));
    public static final Block YELLOW_FROSTED_CANDLE_CAKE_BROWN = registerBlock("yellow_frosted_candle_cake_brown", new MysticCandleCakeBlock(YELLOW_FROSTED_CAKE, Blocks.BROWN_CANDLE));
    public static final Block YELLOW_FROSTED_CANDLE_CAKE_GREEN = registerBlock("yellow_frosted_candle_cake_green", new MysticCandleCakeBlock(YELLOW_FROSTED_CAKE, Blocks.GREEN_CANDLE));
    public static final Block YELLOW_FROSTED_CANDLE_CAKE_RED = registerBlock("yellow_frosted_candle_cake_red", new MysticCandleCakeBlock(YELLOW_FROSTED_CAKE, Blocks.RED_CANDLE));
    public static final Block YELLOW_FROSTED_CANDLE_CAKE_BLACK = registerBlock("yellow_frosted_candle_cake_black", new MysticCandleCakeBlock(YELLOW_FROSTED_CAKE, Blocks.BLACK_CANDLE));

    public static final Block LIME_FROSTED_CAKE = registerBlock("lime_frosted_cake", new MysticCakeBlock(AbstractBlock.Settings.create().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block LIME_FROSTED_CANDLE_CAKE = registerBlock("lime_frosted_candle_cake",  new MysticCandleCakeBlock(LIME_FROSTED_CAKE, Blocks.CANDLE));
    public static final Block LIME_FROSTED_CANDLE_CAKE_WHITE = registerBlock("lime_frosted_candle_cake_white", new MysticCandleCakeBlock(LIME_FROSTED_CAKE, Blocks.WHITE_CANDLE));
    public static final Block LIME_FROSTED_CANDLE_CAKE_ORANGE = registerBlock("lime_frosted_candle_cake_orange", new MysticCandleCakeBlock(LIME_FROSTED_CAKE, Blocks.ORANGE_CANDLE));
    public static final Block LIME_FROSTED_CANDLE_CAKE_MAGENTA = registerBlock("lime_frosted_candle_cake_magenta", new MysticCandleCakeBlock(LIME_FROSTED_CAKE, Blocks.MAGENTA_CANDLE));
    public static final Block LIME_FROSTED_CANDLE_CAKE_LIGHT_BLUE = registerBlock("lime_frosted_candle_cake_light_blue", new MysticCandleCakeBlock(LIME_FROSTED_CAKE, Blocks.LIGHT_BLUE_CANDLE));
    public static final Block LIME_FROSTED_CANDLE_CAKE_YELLOW = registerBlock("lime_frosted_candle_cake_yellow", new MysticCandleCakeBlock(LIME_FROSTED_CAKE, Blocks.YELLOW_CANDLE));
    public static final Block LIME_FROSTED_CANDLE_CAKE_LIME = registerBlock("lime_frosted_candle_cake_lime", new MysticCandleCakeBlock(LIME_FROSTED_CAKE, Blocks.LIME_CANDLE));
    public static final Block LIME_FROSTED_CANDLE_CAKE_PINK = registerBlock("lime_frosted_candle_cake_pink", new MysticCandleCakeBlock(LIME_FROSTED_CAKE, Blocks.PINK_CANDLE));
    public static final Block LIME_FROSTED_CANDLE_CAKE_GRAY = registerBlock("lime_frosted_candle_cake_gray", new MysticCandleCakeBlock(LIME_FROSTED_CAKE, Blocks.GRAY_CANDLE));
    public static final Block LIME_FROSTED_CANDLE_CAKE_LIGHT_GRAY = registerBlock("lime_frosted_candle_cake_light_gray", new MysticCandleCakeBlock(LIME_FROSTED_CAKE, Blocks.LIGHT_GRAY_CANDLE));
    public static final Block LIME_FROSTED_CANDLE_CAKE_CYAN = registerBlock("lime_frosted_candle_cake_cyan", new MysticCandleCakeBlock(LIME_FROSTED_CAKE, Blocks.CYAN_CANDLE));
    public static final Block LIME_FROSTED_CANDLE_CAKE_PURPLE = registerBlock("lime_frosted_candle_cake_purple", new MysticCandleCakeBlock(LIME_FROSTED_CAKE, Blocks.PURPLE_CANDLE));
    public static final Block LIME_FROSTED_CANDLE_CAKE_BLUE = registerBlock("lime_frosted_candle_cake_blue", new MysticCandleCakeBlock(LIME_FROSTED_CAKE, Blocks.BLUE_CANDLE));
    public static final Block LIME_FROSTED_CANDLE_CAKE_BROWN = registerBlock("lime_frosted_candle_cake_brown", new MysticCandleCakeBlock(LIME_FROSTED_CAKE, Blocks.BROWN_CANDLE));
    public static final Block LIME_FROSTED_CANDLE_CAKE_GREEN = registerBlock("lime_frosted_candle_cake_green", new MysticCandleCakeBlock(LIME_FROSTED_CAKE, Blocks.GREEN_CANDLE));
    public static final Block LIME_FROSTED_CANDLE_CAKE_RED = registerBlock("lime_frosted_candle_cake_red", new MysticCandleCakeBlock(LIME_FROSTED_CAKE, Blocks.RED_CANDLE));
    public static final Block LIME_FROSTED_CANDLE_CAKE_BLACK = registerBlock("lime_frosted_candle_cake_black", new MysticCandleCakeBlock(LIME_FROSTED_CAKE, Blocks.BLACK_CANDLE));

    public static final Block CYAN_FROSTED_CAKE = registerBlock("cyan_frosted_cake", new MysticCakeBlock(AbstractBlock.Settings.create().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block CYAN_FROSTED_CANDLE_CAKE = registerBlock("cyan_frosted_candle_cake",  new MysticCandleCakeBlock(CYAN_FROSTED_CAKE, Blocks.CANDLE));
    public static final Block CYAN_FROSTED_CANDLE_CAKE_WHITE = registerBlock("cyan_frosted_candle_cake_white", new MysticCandleCakeBlock(CYAN_FROSTED_CAKE, Blocks.WHITE_CANDLE));
    public static final Block CYAN_FROSTED_CANDLE_CAKE_ORANGE = registerBlock("cyan_frosted_candle_cake_orange", new MysticCandleCakeBlock(CYAN_FROSTED_CAKE, Blocks.ORANGE_CANDLE));
    public static final Block CYAN_FROSTED_CANDLE_CAKE_MAGENTA = registerBlock("cyan_frosted_candle_cake_magenta", new MysticCandleCakeBlock(CYAN_FROSTED_CAKE, Blocks.MAGENTA_CANDLE));
    public static final Block CYAN_FROSTED_CANDLE_CAKE_LIGHT_BLUE = registerBlock("cyan_frosted_candle_cake_light_blue", new MysticCandleCakeBlock(CYAN_FROSTED_CAKE, Blocks.LIGHT_BLUE_CANDLE));
    public static final Block CYAN_FROSTED_CANDLE_CAKE_YELLOW = registerBlock("cyan_frosted_candle_cake_yellow", new MysticCandleCakeBlock(CYAN_FROSTED_CAKE, Blocks.YELLOW_CANDLE));
    public static final Block CYAN_FROSTED_CANDLE_CAKE_LIME = registerBlock("cyan_frosted_candle_cake_lime", new MysticCandleCakeBlock(CYAN_FROSTED_CAKE, Blocks.LIME_CANDLE));
    public static final Block CYAN_FROSTED_CANDLE_CAKE_PINK = registerBlock("cyan_frosted_candle_cake_pink", new MysticCandleCakeBlock(CYAN_FROSTED_CAKE, Blocks.PINK_CANDLE));
    public static final Block CYAN_FROSTED_CANDLE_CAKE_GRAY = registerBlock("cyan_frosted_candle_cake_gray", new MysticCandleCakeBlock(CYAN_FROSTED_CAKE, Blocks.GRAY_CANDLE));
    public static final Block CYAN_FROSTED_CANDLE_CAKE_LIGHT_GRAY = registerBlock("cyan_frosted_candle_cake_light_gray", new MysticCandleCakeBlock(CYAN_FROSTED_CAKE, Blocks.LIGHT_GRAY_CANDLE));
    public static final Block CYAN_FROSTED_CANDLE_CAKE_CYAN = registerBlock("cyan_frosted_candle_cake_cyan", new MysticCandleCakeBlock(CYAN_FROSTED_CAKE, Blocks.CYAN_CANDLE));
    public static final Block CYAN_FROSTED_CANDLE_CAKE_PURPLE = registerBlock("cyan_frosted_candle_cake_purple", new MysticCandleCakeBlock(CYAN_FROSTED_CAKE, Blocks.PURPLE_CANDLE));
    public static final Block CYAN_FROSTED_CANDLE_CAKE_BLUE = registerBlock("cyan_frosted_candle_cake_blue", new MysticCandleCakeBlock(CYAN_FROSTED_CAKE, Blocks.BLUE_CANDLE));
    public static final Block CYAN_FROSTED_CANDLE_CAKE_BROWN = registerBlock("cyan_frosted_candle_cake_brown", new MysticCandleCakeBlock(CYAN_FROSTED_CAKE, Blocks.BROWN_CANDLE));
    public static final Block CYAN_FROSTED_CANDLE_CAKE_GREEN = registerBlock("cyan_frosted_candle_cake_green", new MysticCandleCakeBlock(CYAN_FROSTED_CAKE, Blocks.GREEN_CANDLE));
    public static final Block CYAN_FROSTED_CANDLE_CAKE_RED = registerBlock("cyan_frosted_candle_cake_red", new MysticCandleCakeBlock(CYAN_FROSTED_CAKE, Blocks.RED_CANDLE));
    public static final Block CYAN_FROSTED_CANDLE_CAKE_BLACK = registerBlock("cyan_frosted_candle_cake_black", new MysticCandleCakeBlock(CYAN_FROSTED_CAKE, Blocks.BLACK_CANDLE));

    public static final Block PURPLE_FROSTED_CAKE = registerBlock("purple_frosted_cake", new MysticCakeBlock(AbstractBlock.Settings.create().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block PURPLE_FROSTED_CANDLE_CAKE = registerBlock("purple_frosted_candle_cake",  new MysticCandleCakeBlock(PURPLE_FROSTED_CAKE, Blocks.CANDLE));
    public static final Block PURPLE_FROSTED_CANDLE_CAKE_WHITE = registerBlock("purple_frosted_candle_cake_white", new MysticCandleCakeBlock(PURPLE_FROSTED_CAKE, Blocks.WHITE_CANDLE));
    public static final Block PURPLE_FROSTED_CANDLE_CAKE_ORANGE = registerBlock("purple_frosted_candle_cake_orange", new MysticCandleCakeBlock(PURPLE_FROSTED_CAKE, Blocks.ORANGE_CANDLE));
    public static final Block PURPLE_FROSTED_CANDLE_CAKE_MAGENTA = registerBlock("purple_frosted_candle_cake_magenta", new MysticCandleCakeBlock(PURPLE_FROSTED_CAKE, Blocks.MAGENTA_CANDLE));
    public static final Block PURPLE_FROSTED_CANDLE_CAKE_LIGHT_BLUE = registerBlock("purple_frosted_candle_cake_light_blue", new MysticCandleCakeBlock(PURPLE_FROSTED_CAKE, Blocks.LIGHT_BLUE_CANDLE));
    public static final Block PURPLE_FROSTED_CANDLE_CAKE_YELLOW = registerBlock("purple_frosted_candle_cake_yellow", new MysticCandleCakeBlock(PURPLE_FROSTED_CAKE, Blocks.YELLOW_CANDLE));
    public static final Block PURPLE_FROSTED_CANDLE_CAKE_LIME = registerBlock("purple_frosted_candle_cake_lime", new MysticCandleCakeBlock(PURPLE_FROSTED_CAKE, Blocks.LIME_CANDLE));
    public static final Block PURPLE_FROSTED_CANDLE_CAKE_PINK = registerBlock("purple_frosted_candle_cake_pink", new MysticCandleCakeBlock(PURPLE_FROSTED_CAKE, Blocks.PINK_CANDLE));
    public static final Block PURPLE_FROSTED_CANDLE_CAKE_GRAY = registerBlock("purple_frosted_candle_cake_gray", new MysticCandleCakeBlock(PURPLE_FROSTED_CAKE, Blocks.GRAY_CANDLE));
    public static final Block PURPLE_FROSTED_CANDLE_CAKE_LIGHT_GRAY = registerBlock("purple_frosted_candle_cake_light_gray", new MysticCandleCakeBlock(PURPLE_FROSTED_CAKE, Blocks.LIGHT_GRAY_CANDLE));
    public static final Block PURPLE_FROSTED_CANDLE_CAKE_CYAN = registerBlock("purple_frosted_candle_cake_cyan", new MysticCandleCakeBlock(PURPLE_FROSTED_CAKE, Blocks.CYAN_CANDLE));
    public static final Block PURPLE_FROSTED_CANDLE_CAKE_PURPLE = registerBlock("purple_frosted_candle_cake_purple", new MysticCandleCakeBlock(PURPLE_FROSTED_CAKE, Blocks.PURPLE_CANDLE));
    public static final Block PURPLE_FROSTED_CANDLE_CAKE_BLUE = registerBlock("purple_frosted_candle_cake_blue", new MysticCandleCakeBlock(PURPLE_FROSTED_CAKE, Blocks.BLUE_CANDLE));
    public static final Block PURPLE_FROSTED_CANDLE_CAKE_BROWN = registerBlock("purple_frosted_candle_cake_brown", new MysticCandleCakeBlock(PURPLE_FROSTED_CAKE, Blocks.BROWN_CANDLE));
    public static final Block PURPLE_FROSTED_CANDLE_CAKE_GREEN = registerBlock("purple_frosted_candle_cake_green", new MysticCandleCakeBlock(PURPLE_FROSTED_CAKE, Blocks.GREEN_CANDLE));
    public static final Block PURPLE_FROSTED_CANDLE_CAKE_RED = registerBlock("purple_frosted_candle_cake_red", new MysticCandleCakeBlock(PURPLE_FROSTED_CAKE, Blocks.RED_CANDLE));
    public static final Block PURPLE_FROSTED_CANDLE_CAKE_BLACK = registerBlock("purple_frosted_candle_cake_black", new MysticCandleCakeBlock(PURPLE_FROSTED_CAKE, Blocks.BLACK_CANDLE));

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, MysticsBiomes.modLoc(name), block);
    }

    public static void registerBlocks() {
        MysticsBiomes.LOGGER.info("mystic's biomes ~ registering blocks");
    }

}