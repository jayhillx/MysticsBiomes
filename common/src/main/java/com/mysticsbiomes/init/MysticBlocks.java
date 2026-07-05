package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.block.BlockTemplate;
import com.mysticsbiomes.common.block.LeafyBlossomsBlock;
import com.mysticsbiomes.common.block.StrawberryBushBlock;
import com.mysticsbiomes.common.block.grower.MysticTreeGrowers;
import com.mysticsbiomes.common.block.state.MysticBlockSetTypes;
import com.mysticsbiomes.common.block.state.MysticWoodTypes;
import com.mysticsbiomes.core.registry.DeferredRegister;
import com.mysticsbiomes.core.registry.RegistryObject;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import static com.mysticsbiomes.MysticsBiomes.REGISTRY_FACTORY;
import static com.mysticsbiomes.common.block.BlockTemplate.*;

public class MysticBlocks {
    public static final DeferredRegister<Block> BLOCKS = REGISTRY_FACTORY.create(Registries.BLOCK, MysticsBiomes.modId);

    public static void init() {
    }

    public static final RegistryObject<Block> STRAWBERRY_BLOSSOMS = BLOCKS.register("strawberry_blossoms", () -> new LeafyBlossomsBlock(leafProperties(SoundType.AZALEA_LEAVES)));
    public static final RegistryObject<Block> STRAWBERRY_BLOSSOM_SAPLING = BLOCKS.register("strawberry_blossom_sapling", () -> sapling(new MysticTreeGrowers(TreeFeatures.OAK)));///TreeFeatures.OAK)));
    public static final RegistryObject<Block> STRAWBERRY_LOG = BLOCKS.register("strawberry_log", () -> log(MapColor.COLOR_PINK, MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> STRIPPED_STRAWBERRY_LOG = BLOCKS.register("stripped_strawberry_log", () -> log(MapColor.COLOR_PINK));
    public static final RegistryObject<Block> STRAWBERRY_WOOD = BLOCKS.register("strawberry_wood", () -> log(MapColor.COLOR_PINK, MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> STRIPPED_STRAWBERRY_WOOD = BLOCKS.register("stripped_strawberry_wood", () -> log(MapColor.COLOR_PINK));
    public static final RegistryObject<Block> STRAWBERRY_PLANKS = BLOCKS.register("strawberry_planks", () -> planks(MapColor.COLOR_PINK));
    public static final RegistryObject<Block> STRAWBERRY_STAIRS = BLOCKS.register("strawberry_stairs", () -> stairs(STRAWBERRY_PLANKS.get()));
    public static final RegistryObject<Block> STRAWBERRY_SLAB = BLOCKS.register("strawberry_slab", () -> slab(STRAWBERRY_PLANKS.get()));
    public static final RegistryObject<Block> STRAWBERRY_FENCE = BLOCKS.register("strawberry_fence", () -> fence(STRAWBERRY_PLANKS.get()));
    public static final RegistryObject<Block> STRAWBERRY_FENCE_GATE = BLOCKS.register("strawberry_fence_gate", () -> fenceGate(STRAWBERRY_PLANKS.get(), MysticWoodTypes.STRAWBERRY));
    public static final RegistryObject<Block> STRAWBERRY_BUTTON = BLOCKS.register("strawberry_button", () -> button(MysticBlockSetTypes.STRAWBERRY));
    public static final RegistryObject<Block> STRAWBERRY_PRESSURE_PLATE = BLOCKS.register("strawberry_pressure_plate", () -> pressurePlate(STRAWBERRY_PLANKS.get(), MysticBlockSetTypes.STRAWBERRY));
    public static final RegistryObject<Block> STRAWBERRY_TRAPDOOR = BLOCKS.register("strawberry_trapdoor", () -> trapdoor(STRAWBERRY_PLANKS.get(), MysticBlockSetTypes.STRAWBERRY));
    public static final RegistryObject<Block> STRAWBERRY_DOOR = BLOCKS.register("strawberry_door", () -> door(STRAWBERRY_PLANKS.get(), MysticBlockSetTypes.STRAWBERRY));
    public static final RegistryObject<Block> STRAWBERRY_SIGN = BLOCKS.register("strawberry_sign", () -> sign(STRAWBERRY_PLANKS.get(), MysticWoodTypes.STRAWBERRY));
    public static final RegistryObject<Block> STRAWBERRY_WALL_SIGN = BLOCKS.register("strawberry_wall_sign", () -> wallSign(STRAWBERRY_SIGN.get(), MysticWoodTypes.STRAWBERRY));
    public static final RegistryObject<Block> STRAWBERRY_HANGING_SIGN = BLOCKS.register("strawberry_hanging_sign", () -> hangingSign(STRAWBERRY_PLANKS.get(), MysticWoodTypes.STRAWBERRY));
    public static final RegistryObject<Block> STRAWBERRY_WALL_HANGING_SIGN = BLOCKS.register("strawberry_wall_hanging_sign", () -> wallHangingSign(STRAWBERRY_HANGING_SIGN.get(), MysticWoodTypes.STRAWBERRY));

    ///public static final RegistryObject<Block> PINK_DAISIES;
    public static final RegistryObject<Block> STRAWBERRY_BUSH = BLOCKS.register("strawberry_bush", () -> new StrawberryBushBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).offsetType(BlockBehaviour.OffsetType.XZ).randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> STRAWBERRY_CAKE = BLOCKS.register("strawberry_cake", BlockTemplate::cake);
    public static final RegistryObject<Block> SWEET_STRAWBERRY_CAKE = BLOCKS.register("sweet_strawberry_cake", BlockTemplate::cake);

    /// lavender meadow
    public static final RegistryObject<Block> LAVENDER_BLOSSOMS = BLOCKS.register("lavender_blossoms", () -> new LeafyBlossomsBlock(leafProperties(SoundType.AZALEA_LEAVES)));
    public static final RegistryObject<Block> LAVENDER_BLOSSOM_SAPLING = BLOCKS.register("lavender_blossom_sapling", () -> sapling(new MysticTreeGrowers(TreeFeatures.OAK)));///MysticTreeFeatures.LAVENDER_TREE)))
    public static final RegistryObject<Block> LAVENDER_LOG = BLOCKS.register("lavender_log", () -> log(MapColor.COLOR_PURPLE, MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> STRIPPED_LAVENDER_LOG = BLOCKS.register("stripped_lavender_log", () -> log(MapColor.COLOR_PURPLE));
    public static final RegistryObject<Block> LAVENDER_WOOD = BLOCKS.register("lavender_wood", () -> log(MapColor.COLOR_PURPLE, MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> STRIPPED_LAVENDER_WOOD = BLOCKS.register("stripped_lavender_wood", () -> log(MapColor.COLOR_PURPLE));
    public static final RegistryObject<Block> LAVENDER_PLANKS = BLOCKS.register("lavender_planks", () -> planks(MapColor.COLOR_PURPLE));
    public static final RegistryObject<Block> LAVENDER_STAIRS = BLOCKS.register("lavender_stairs", () -> stairs(LAVENDER_PLANKS.get()));
    public static final RegistryObject<Block> LAVENDER_SLAB = BLOCKS.register("lavender_slab", () -> slab(LAVENDER_PLANKS.get()));
    public static final RegistryObject<Block> LAVENDER_FENCE = BLOCKS.register("lavender_fence", () -> fence(LAVENDER_PLANKS.get()));
    public static final RegistryObject<Block> LAVENDER_FENCE_GATE = BLOCKS.register("lavender_fence_gate", () -> fenceGate(LAVENDER_PLANKS.get(), MysticWoodTypes.LAVENDER));
    public static final RegistryObject<Block> LAVENDER_BUTTON = BLOCKS.register("lavender_button", () -> button(MysticBlockSetTypes.LAVENDER));
    public static final RegistryObject<Block> LAVENDER_PRESSURE_PLATE = BLOCKS.register("lavender_pressure_plate", () -> pressurePlate(LAVENDER_PLANKS.get(), MysticBlockSetTypes.LAVENDER));
    public static final RegistryObject<Block> LAVENDER_TRAPDOOR = BLOCKS.register("lavender_trapdoor", () -> trapdoor(LAVENDER_PLANKS.get(), MysticBlockSetTypes.LAVENDER));
    public static final RegistryObject<Block> LAVENDER_DOOR = BLOCKS.register("lavender_door", () -> door(LAVENDER_PLANKS.get(), MysticBlockSetTypes.LAVENDER));
    public static final RegistryObject<Block> LAVENDER_SIGN = BLOCKS.register("lavender_sign", () -> sign(LAVENDER_PLANKS.get(), MysticWoodTypes.LAVENDER));
    public static final RegistryObject<Block> LAVENDER_WALL_SIGN = BLOCKS.register("lavender_wall_sign", () -> wallSign(LAVENDER_SIGN.get(), MysticWoodTypes.LAVENDER));
    public static final RegistryObject<Block> LAVENDER_HANGING_SIGN = BLOCKS.register("lavender_hanging_sign", () -> hangingSign(LAVENDER_PLANKS.get(), MysticWoodTypes.LAVENDER));
    public static final RegistryObject<Block> LAVENDER_WALL_HANGING_SIGN = BLOCKS.register("lavender_wall_hanging_sign", () -> wallHangingSign(LAVENDER_HANGING_SIGN.get(), MysticWoodTypes.LAVENDER));

    ///public static final RegistryObject<Block> LAVENDER;
    ///public static final RegistryObject<Block> TALL_LAVENDER;
    ///public static final RegistryObject<Block> BUNDLED_LAVENDER_BUDS;
    ///public static final RegistryObject<Block> BUTTERFLY_BUSH_LEAVES;
    ///public static final RegistryObject<Block> BUTTERFLY_BUSH;
    ///public static final RegistryObject<Block> BUTTERFLY_NEST;
    ///public static final RegistryObject<Block> CHRYSALIS;

    /// bamboo blossom forest
    public static final RegistryObject<Block> PINK_CHERRY_BLOSSOMS = BLOCKS.register("pink_cherry_blossoms", () -> new LeavesBlock(leafProperties(SoundType.CHERRY_LEAVES)));
    ///public static final RegistryObject<Block> PINK_CHERRY_PETALS;
    public static final RegistryObject<Block> PINK_CHERRY_BLOSSOM_SAPLING = BLOCKS.register("pink_cherry_blossom_sapling", () -> sapling(new MysticTreeGrowers(TreeFeatures.OAK)));///MysticTreeFeatures.PINK_CHERRY_TREE), SoundType.CHERRY_SAPLING));
    public static final RegistryObject<Block> WHITE_CHERRY_BLOSSOMS = BLOCKS.register("white_cherry_blossoms", () -> new LeavesBlock(leafProperties(SoundType.CHERRY_LEAVES)));
    ///public static final RegistryObject<Block> WHITE_CHERRY_PETALS;
    public static final RegistryObject<Block> WHITE_CHERRY_BLOSSOM_SAPLING = BLOCKS.register("white_cherry_blossom_sapling", () -> sapling(new MysticTreeGrowers(TreeFeatures.OAK)));///MysticTreeFeatures.WHITE_CHERRY_TREE), SoundType.CHERRY_SAPLING));
    public static final RegistryObject<Block> BLACK_CHERRY_LOG = BLOCKS.register("black_cherry_log", () -> log(MapColor.COLOR_MAGENTA, MapColor.TERRACOTTA_MAGENTA, SoundType.CHERRY_WOOD));
    public static final RegistryObject<Block> STRIPPED_BLACK_CHERRY_LOG = BLOCKS.register("stripped_black_cherry_log", () -> log(MapColor.COLOR_MAGENTA, SoundType.CHERRY_WOOD));
    public static final RegistryObject<Block> BLACK_CHERRY_WOOD = BLOCKS.register("black_cherry_wood", () -> log(MapColor.TERRACOTTA_MAGENTA, SoundType.CHERRY_WOOD));
    public static final RegistryObject<Block> STRIPPED_BLACK_CHERRY_WOOD = BLOCKS.register("stripped_black_cherry_wood", () -> log(MapColor.COLOR_MAGENTA, SoundType.CHERRY_WOOD));
    public static final RegistryObject<Block> BLACK_CHERRY_PLANKS = BLOCKS.register("black_cherry_planks", () -> planks(MapColor.COLOR_MAGENTA, SoundType.CHERRY_WOOD));
    public static final RegistryObject<Block> BLACK_CHERRY_STAIRS = BLOCKS.register("black_cherry_stairs", () -> stairs(BLACK_CHERRY_PLANKS.get()));
    public static final RegistryObject<Block> BLACK_CHERRY_SLAB = BLOCKS.register("black_cherry_slab", () -> slab(BLACK_CHERRY_PLANKS.get()));
    public static final RegistryObject<Block> BLACK_CHERRY_FENCE = BLOCKS.register("black_cherry_fence", () -> fence(BLACK_CHERRY_PLANKS.get()));
    public static final RegistryObject<Block> BLACK_CHERRY_FENCE_GATE = BLOCKS.register("black_cherry_fence_gate", () -> fenceGate(BLACK_CHERRY_PLANKS.get(), MysticWoodTypes.BLACK_CHERRY));
    public static final RegistryObject<Block> BLACK_CHERRY_BUTTON = BLOCKS.register("black_cherry_button", () -> button(MysticBlockSetTypes.BLACK_CHERRY));
    public static final RegistryObject<Block> BLACK_CHERRY_PRESSURE_PLATE = BLOCKS.register("black_cherry_pressure_plate", () -> pressurePlate(BLACK_CHERRY_PLANKS.get(), MysticBlockSetTypes.BLACK_CHERRY));
    public static final RegistryObject<Block> BLACK_CHERRY_TRAPDOOR = BLOCKS.register("black_cherry_trapdoor", () -> trapdoor(BLACK_CHERRY_PLANKS.get(), MysticBlockSetTypes.BLACK_CHERRY));
    public static final RegistryObject<Block> BLACK_CHERRY_DOOR = BLOCKS.register("black_cherry_door", () -> door(BLACK_CHERRY_PLANKS.get(), MysticBlockSetTypes.BLACK_CHERRY));
    public static final RegistryObject<Block> BLACK_CHERRY_SIGN = BLOCKS.register("black_cherry_sign", () -> sign(BLACK_CHERRY_PLANKS.get(), MysticWoodTypes.BLACK_CHERRY));
    public static final RegistryObject<Block> BLACK_CHERRY_WALL_SIGN = BLOCKS.register("black_cherry_wall_sign", () -> wallSign(BLACK_CHERRY_SIGN.get(), MysticWoodTypes.BLACK_CHERRY));
    public static final RegistryObject<Block> BLACK_CHERRY_HANGING_SIGN = BLOCKS.register("black_cherry_hanging_sign", () -> hangingSign(BLACK_CHERRY_PLANKS.get(), MysticWoodTypes.BLACK_CHERRY));
    public static final RegistryObject<Block> BLACK_CHERRY_WALL_HANGING_SIGN = BLOCKS.register("black_cherry_wall_hanging_sign", () -> wallHangingSign(BLACK_CHERRY_HANGING_SIGN.get(), MysticWoodTypes.BLACK_CHERRY));

    ///public static final RegistryObject<Block> SPRING_BAMBOO_SAPLING = BLOCKS.register("spring_bamboo_sapling", () -> new SpringBambooSaplingBlock(bambooProperties(SoundType.BAMBOO_SAPLING)));
    ///public static final RegistryObject<Block> SPRING_BAMBOO = BLOCKS.register("spring_bamboo", () -> new SpringBambooStalkBlock(bambooProperties(SoundType.BAMBOO)));
    public static final RegistryObject<Block> SPRING_BAMBOO_BLOCK = BLOCKS.register("spring_bamboo_block", () -> log(MapColor.COLOR_LIGHT_GREEN, MapColor.COLOR_GREEN, SoundType.BAMBOO_WOOD));
    public static final RegistryObject<Block> STRIPPED_SPRING_BAMBOO_BLOCK = BLOCKS.register("stripped_spring_bamboo_block", () -> log(MapColor.COLOR_LIGHT_GREEN, SoundType.BAMBOO_WOOD));
    public static final RegistryObject<Block> SPRING_PLANKS = BLOCKS.register("spring_planks", () -> planks(MapColor.COLOR_LIGHT_GREEN, SoundType.BAMBOO_WOOD));
    public static final RegistryObject<Block> SPRING_MOSAIC = BLOCKS.register("spring_mosaic", () -> planks(MapColor.COLOR_LIGHT_GREEN));
    public static final RegistryObject<Block> SPRING_STAIRS = BLOCKS.register("spring_stairs", () -> stairs(SPRING_PLANKS.get()));
    public static final RegistryObject<Block> SPRING_MOSAIC_STAIRS = BLOCKS.register("spring_mosaic_stairs", () -> stairs(SPRING_PLANKS.get()));
    public static final RegistryObject<Block> SPRING_SLAB = BLOCKS.register("spring_slab", () -> slab(SPRING_PLANKS.get()));
    public static final RegistryObject<Block> SPRING_MOSAIC_SLAB = BLOCKS.register("spring_mosaic_slab", () -> slab(SPRING_PLANKS.get()));
    public static final RegistryObject<Block> SPRING_FENCE = BLOCKS.register("spring_fence", () -> fence(SPRING_PLANKS.get()));
    public static final RegistryObject<Block> SPRING_FENCE_GATE = BLOCKS.register("spring_fence_gate", () -> fenceGate(SPRING_PLANKS.get(), MysticWoodTypes.SPRING));
    public static final RegistryObject<Block> SPRING_BUTTON = BLOCKS.register("spring_button", () -> button(MysticBlockSetTypes.SPRING));
    public static final RegistryObject<Block> SPRING_PRESSURE_PLATE = BLOCKS.register("spring_pressure_plate", () -> pressurePlate(SPRING_PLANKS.get(), MysticBlockSetTypes.SPRING));
    public static final RegistryObject<Block> SPRING_TRAPDOOR = BLOCKS.register("spring_trapdoor", () -> trapdoor(SPRING_PLANKS.get(), MysticBlockSetTypes.SPRING));
    public static final RegistryObject<Block> SPRING_DOOR = BLOCKS.register("spring_door", () -> door(SPRING_PLANKS.get(), MysticBlockSetTypes.SPRING));
    public static final RegistryObject<Block> SPRING_SIGN = BLOCKS.register("spring_sign", () -> sign(SPRING_PLANKS.get(), MysticWoodTypes.SPRING));
    public static final RegistryObject<Block> SPRING_WALL_SIGN = BLOCKS.register("spring_wall_sign", () -> wallSign(SPRING_SIGN.get(), MysticWoodTypes.SPRING));
    public static final RegistryObject<Block> SPRING_HANGING_SIGN = BLOCKS.register("spring_hanging_sign", () -> hangingSign(SPRING_PLANKS.get(), MysticWoodTypes.SPRING));
    public static final RegistryObject<Block> SPRING_WALL_HANGING_SIGN = BLOCKS.register("spring_wall_hanging_sign", () -> wallHangingSign(SPRING_HANGING_SIGN.get(), MysticWoodTypes.SPRING));

    ///public static final RegistryObject<Block> CHERRY_PLANT;
    ///public static final RegistryObject<Block> CHERRY_PIE;
    ///public static final RegistryObject<Block> PEONY_BUSH_LEAVES;
    ///public static final RegistryObject<Block> PEONY_BUSH;

    /// autumnal grove
    public static final RegistryObject<Block> MAPLE_LEAVES = BLOCKS.register("maple_leaves", () -> new LeavesBlock(leafProperties(SoundType.AZALEA_LEAVES)));
    ///public static final RegistryObject<Block> MAPLE_LEAF_PILE = BLOCKS.register("maple_leaf_pile", () -> leafLitter(MapColor.GRASS));
    ///public static final RegistryObject<Block> MAPLE_LEAF_LITTER = BLOCKS.register("maple_leaf_litter", () -> leafLitter(MapColor.GRASS));
    public static final RegistryObject<Block> MAPLE_SAPLING = BLOCKS.register("maple_sapling", () -> sapling(new MysticTreeGrowers(TreeFeatures.OAK)));///MysticTreeFeatures.MAPLE_TREE)));
    public static final RegistryObject<Block> SPICED_MAPLE_LEAVES = BLOCKS.register("spiced_maple_leaves", () -> new LeavesBlock(leafProperties(SoundType.AZALEA_LEAVES)));
    ///public static final RegistryObject<Block> SPICED_MAPLE_LEAF_PILE = BLOCKS.register("spiced_maple_leaf_pile", () -> leafLitter(MapColor.TERRACOTTA_ORANGE));
    ///public static final RegistryObject<Block> SPICED_MAPLE_LEAF_LITTER = BLOCKS.register("spiced_maple_leaf_litter", () -> leafLitter(MapColor.TERRACOTTA_ORANGE));
    public static final RegistryObject<Block> SPICED_MAPLE_SAPLING = BLOCKS.register("spiced_maple_sapling", () -> sapling(new MysticTreeGrowers(TreeFeatures.OAK)));///MysticTreeFeatures.ORANGE_MAPLE_TREE)));
    public static final RegistryObject<Block> ORANGE_MAPLE_LEAVES = BLOCKS.register("orange_maple_leaves", () -> new LeavesBlock(leafProperties(SoundType.AZALEA_LEAVES)));
    ///public static final RegistryObject<Block> ORANGE_MAPLE_LEAF_PILE = BLOCKS.register("orange_maple_leaf_pile", () -> leafLitter(MapColor.TERRACOTTA_ORANGE));
    ///public static final RegistryObject<Block> ORANGE_MAPLE_LEAF_LITTER = BLOCKS.register("orange_maple_leaf_litter", () -> leafLitter(MapColor.TERRACOTTA_ORANGE));
    public static final RegistryObject<Block> ORANGE_MAPLE_SAPLING = BLOCKS.register("orange_maple_sapling", () -> sapling(new MysticTreeGrowers(TreeFeatures.OAK)));///MysticTreeFeatures.ORANGE_MAPLE_TREE)));
    public static final RegistryObject<Block> YELLOW_MAPLE_LEAVES = BLOCKS.register("yellow_maple_leaves", () -> new LeavesBlock(leafProperties(SoundType.AZALEA_LEAVES)));
    ///public static final RegistryObject<Block> YELLOW_MAPLE_LEAF_PILE = BLOCKS.register("yellow_maple_leaf_pile", () -> leafLitter(MapColor.TERRACOTTA_YELLOW));
    ///public static final RegistryObject<Block> YELLOW_MAPLE_LEAF_LITTER = BLOCKS.register("yellow_maple_leaf_litter", () -> leafLitter(MapColor.TERRACOTTA_YELLOW));
    public static final RegistryObject<Block> YELLOW_MAPLE_SAPLING = BLOCKS.register("yellow_maple_sapling", () -> sapling(new MysticTreeGrowers(TreeFeatures.OAK)));///MysticTreeFeatures.YELLOW_MAPLE_TREE)));
    public static final RegistryObject<Block> MAPLE_LOG = BLOCKS.register("maple_log", () -> log(MapColor.COLOR_ORANGE, MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> WHITE_MAPLE_LOG = BLOCKS.register("white_maple_log", () -> log(MapColor.COLOR_ORANGE, MapColor.TERRACOTTA_WHITE));
    public static final RegistryObject<Block> STRIPPED_MAPLE_LOG = BLOCKS.register("stripped_maple_log", () -> log(MapColor.COLOR_ORANGE));
    public static final RegistryObject<Block> MAPLE_WOOD = BLOCKS.register("maple_wood", () -> log(MapColor.COLOR_ORANGE, MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> WHITE_MAPLE_WOOD = BLOCKS.register("white_maple_wood", () -> log(MapColor.TERRACOTTA_WHITE, MapColor.TERRACOTTA_WHITE));
    public static final RegistryObject<Block> STRIPPED_MAPLE_WOOD = BLOCKS.register("stripped_maple_wood", () -> log(MapColor.COLOR_ORANGE));
    public static final RegistryObject<Block> MAPLE_PLANKS = BLOCKS.register("maple_planks", () -> planks(MapColor.COLOR_ORANGE));
    public static final RegistryObject<Block> MAPLE_STAIRS = BLOCKS.register("maple_stairs", () -> stairs(MAPLE_PLANKS.get()));
    public static final RegistryObject<Block> MAPLE_SLAB = BLOCKS.register("maple_slab", () -> slab(MAPLE_PLANKS.get()));
    public static final RegistryObject<Block> MAPLE_FENCE = BLOCKS.register("maple_fence", () -> fence(MAPLE_PLANKS.get()));
    public static final RegistryObject<Block> MAPLE_FENCE_GATE = BLOCKS.register("maple_fence_gate", () -> fenceGate(MAPLE_PLANKS.get(), MysticWoodTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_BUTTON = BLOCKS.register("maple_button", () -> button(MysticBlockSetTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_PRESSURE_PLATE = BLOCKS.register("maple_pressure_plate", () -> pressurePlate(MAPLE_PLANKS.get(), MysticBlockSetTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_TRAPDOOR = BLOCKS.register("maple_trapdoor", () -> trapdoor(MAPLE_PLANKS.get(), MysticBlockSetTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_DOOR = BLOCKS.register("maple_door", () -> door(MAPLE_PLANKS.get(), MysticBlockSetTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_SIGN = BLOCKS.register("maple_sign", () -> sign(MAPLE_PLANKS.get(), MysticWoodTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_WALL_SIGN = BLOCKS.register("maple_wall_sign", () -> wallSign(MAPLE_SIGN.get(), MysticWoodTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_HANGING_SIGN = BLOCKS.register("maple_hanging_sign", () -> hangingSign(MAPLE_PLANKS.get(), MysticWoodTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_WALL_HANGING_SIGN = BLOCKS.register("maple_wall_hanging_sign", () -> wallHangingSign(MAPLE_HANGING_SIGN.get(), MysticWoodTypes.MAPLE));

    ///public static final RegistryObject<Block> MAPLE_PANCAKES;
    ///public static final RegistryObject<Block> ASTER;
    ///public static final RegistryObject<Block> GOLDENROD;

    /// lush oasis
    public static final RegistryObject<Block> LUSH_SAND = BLOCKS.register("lush_sand", () -> new SandBlock(000000, BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> GRASSY_LUSH_SAND = BLOCKS.register("grassy_lush_sand", () -> new SandBlock(000000, copy(LUSH_SAND.get())));
    public static final RegistryObject<Block> LUSH_SANDSTONE = BLOCKS.register("lush_sandstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8F)));
    public static final RegistryObject<Block> LUSH_SANDSTONE_STAIRS = BLOCKS.register("lush_sandstone_stairs", () -> stairs(LUSH_SANDSTONE.get()));
    public static final RegistryObject<Block> LUSH_SANDSTONE_SLAB = BLOCKS.register("lush_sandstone_slab", () -> slab(LUSH_SANDSTONE.get()));
    public static final RegistryObject<Block> LUSH_SANDSTONE_WALL = BLOCKS.register("lush_sandstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(LUSH_SANDSTONE.get()).forceSolidOn()));
    public static final RegistryObject<Block> CHISELED_LUSH_SANDSTONE = BLOCKS.register("chiseled_lush_sandstone", () -> new Block(copy(LUSH_SANDSTONE.get())));
    public static final RegistryObject<Block> CUT_LUSH_SANDSTONE = BLOCKS.register("cut_lush_sandstone", () -> new Block(copy(LUSH_SANDSTONE.get())));
    public static final RegistryObject<Block> CUT_LUSH_SANDSTONE_SLAB = BLOCKS.register("cut_lush_sandstone_slab", () -> new SlabBlock(copy(LUSH_SANDSTONE.get()).strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> SMOOTH_LUSH_SANDSTONE = BLOCKS.register("smooth_lush_sandstone", () -> new Block(copy(LUSH_SANDSTONE.get()).strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> SMOOTH_LUSH_SANDSTONE_STAIRS = BLOCKS.register("smooth_lush_sandstone_stairs", () -> stairs(SMOOTH_LUSH_SANDSTONE.get()));
    public static final RegistryObject<Block> SMOOTH_LUSH_SANDSTONE_SLAB = BLOCKS.register("smooth_lush_sandstone_slab", () -> slab(SMOOTH_LUSH_SANDSTONE.get()));

    public static final RegistryObject<Block> PEACH_LEAVES = BLOCKS.register("peach_leaves", () -> leaves(SoundType.AZALEA_LEAVES));
    public static final RegistryObject<Block> PEACH_SAPLING = BLOCKS.register("peach_sapling", () -> sapling(new MysticTreeGrowers(TreeFeatures.OAK)));///MysticTreeFeatures.PEACH_TREE)));
    public static final RegistryObject<Block> PEACH_LOG = BLOCKS.register("peach_log", () -> log(MapColor.SAND, MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> STRIPPED_PEACH_LOG = BLOCKS.register("stripped_peach_log", () -> log(MapColor.SAND));
    public static final RegistryObject<Block> PEACH_WOOD = BLOCKS.register("peach_wood", () -> log(MapColor.SAND, MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> STRIPPED_PEACH_WOOD = BLOCKS.register("stripped_peach_wood", () -> log(MapColor.SAND));
    public static final RegistryObject<Block> PEACH_PLANKS = BLOCKS.register("peach_planks", () -> planks(MapColor.SAND));
    public static final RegistryObject<Block> PEACH_STAIRS = BLOCKS.register("peach_stairs", () -> stairs(PEACH_PLANKS.get()));
    public static final RegistryObject<Block> PEACH_SLAB = BLOCKS.register("peach_slab", () -> slab(PEACH_PLANKS.get()));
    public static final RegistryObject<Block> PEACH_FENCE = BLOCKS.register("peach_fence", () -> fence(PEACH_PLANKS.get()));
    public static final RegistryObject<Block> PEACH_FENCE_GATE = BLOCKS.register("peach_fence_gate", () -> fenceGate(PEACH_PLANKS.get(), MysticWoodTypes.PEACH));
    public static final RegistryObject<Block> PEACH_BUTTON = BLOCKS.register("peach_button", () -> button(MysticBlockSetTypes.PEACH));
    public static final RegistryObject<Block> PEACH_PRESSURE_PLATE = BLOCKS.register("peach_pressure_plate", () -> pressurePlate(PEACH_PLANKS.get(), MysticBlockSetTypes.PEACH));
    public static final RegistryObject<Block> PEACH_TRAPDOOR = BLOCKS.register("peach_trapdoor", () -> trapdoor(PEACH_PLANKS.get(), MysticBlockSetTypes.PEACH));
    public static final RegistryObject<Block> PEACH_DOOR = BLOCKS.register("peach_door", () -> door(PEACH_PLANKS.get(), MysticBlockSetTypes.PEACH));
    public static final RegistryObject<Block> PEACH_SIGN = BLOCKS.register("peach_sign", () -> sign(PEACH_PLANKS.get(), MysticWoodTypes.PEACH));
    public static final RegistryObject<Block> PEACH_WALL_SIGN = BLOCKS.register("peach_wall_sign", () -> wallSign(PEACH_SIGN.get(), MysticWoodTypes.PEACH));
    public static final RegistryObject<Block> PEACH_HANGING_SIGN = BLOCKS.register("peach_hanging_sign", () -> hangingSign(PEACH_PLANKS.get(), MysticWoodTypes.PEACH));
    public static final RegistryObject<Block> PEACH_WALL_HANGING_SIGN = BLOCKS.register("peach_wall_hanging_sign", () -> wallHangingSign(PEACH_HANGING_SIGN.get(), MysticWoodTypes.PEACH));

    ///public static final RegistryObject<Block> PEACH_PLANT;
    ///public static final RegistryObject<Block> PEACH_PIE;
    ///public static final RegistryObject<Block> DESERT_SHRUB;
    ///public static final RegistryObject<Block> DESERT_GRASS;
    ///public static final RegistryObject<Block> TALL_DESERT_GRASS;
    ///public static final RegistryObject<Block> DESERT_LILY;
    ///public static final RegistryObject<Block> WILDFLOWER;
    ///public static final RegistryObject<Block> SAGUARO_CACTUS;
    ///public static final RegistryObject<Block> SAGUARO_BLOSSOM;
    ///public static final RegistryObject<Block> PRICKLY_CACTUS;
    ///public static final RegistryObject<Block> PRICKLY_BLOSSOM;
    ///public static final RegistryObject<Block> PRICKLY_PEAR;

    /// lagoon
    public static final RegistryObject<Block> SEA_SHRUB_LEAVES = BLOCKS.register("sea_shrub_leaves", () -> leaves(SoundType.GRASS));
    public static final RegistryObject<Block> SEA_SHRUB = BLOCKS.register("sea_shrub", () -> shrub(new MysticTreeGrowers(TreeFeatures.OAK)));///MysticTreeFeatures.SEA_SHRUB)));
    public static final RegistryObject<Block> SEA_FOAM_LOG = BLOCKS.register("sea_foam_log", () -> log(MapColor.COLOR_CYAN, MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> STRIPPED_SEA_FOAM_LOG = BLOCKS.register("stripped_sea_foam_log", () -> log(MapColor.COLOR_CYAN));
    public static final RegistryObject<Block> SEA_FOAM_WOOD = BLOCKS.register("sea_foam_wood", () -> log(MapColor.COLOR_CYAN, MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> STRIPPED_SEA_FOAM_WOOD = BLOCKS.register("stripped_sea_foam_wood", () -> log(MapColor.COLOR_CYAN));
    public static final RegistryObject<Block> SEA_FOAM_PLANKS = BLOCKS.register("sea_foam_planks", () -> planks(MapColor.COLOR_CYAN));
    public static final RegistryObject<Block> SEA_FOAM_STAIRS = BLOCKS.register("sea_foam_stairs", () -> stairs(SEA_FOAM_PLANKS.get()));
    public static final RegistryObject<Block> SEA_FOAM_SLAB = BLOCKS.register("sea_foam_slab", () -> slab(SEA_FOAM_PLANKS.get()));
    public static final RegistryObject<Block> SEA_FOAM_FENCE = BLOCKS.register("sea_foam_fence", () -> fence(SEA_FOAM_PLANKS.get()));
    public static final RegistryObject<Block> SEA_FOAM_FENCE_GATE = BLOCKS.register("sea_foam_fence_gate", () -> fenceGate(SEA_FOAM_PLANKS.get(), MysticWoodTypes.SEA_FOAM));
    public static final RegistryObject<Block> SEA_FOAM_BUTTON = BLOCKS.register("sea_foam_button", () -> button(MysticBlockSetTypes.SEA_FOAM));
    public static final RegistryObject<Block> SEA_FOAM_PRESSURE_PLATE = BLOCKS.register("sea_foam_pressure_plate", () -> pressurePlate(SEA_FOAM_PLANKS.get(), MysticBlockSetTypes.SEA_FOAM));
    public static final RegistryObject<Block> SEA_FOAM_TRAPDOOR = BLOCKS.register("sea_foam_trapdoor", () -> trapdoor(SEA_FOAM_PLANKS.get(), MysticBlockSetTypes.SEA_FOAM));
    public static final RegistryObject<Block> SEA_FOAM_DOOR = BLOCKS.register("sea_foam_door", () -> door(SEA_FOAM_PLANKS.get(), MysticBlockSetTypes.SEA_FOAM));
    public static final RegistryObject<Block> SEA_FOAM_SIGN = BLOCKS.register("sea_foam_sign", () -> sign(SEA_FOAM_PLANKS.get(), MysticWoodTypes.SEA_FOAM));
    public static final RegistryObject<Block> SEA_FOAM_WALL_SIGN = BLOCKS.register("sea_foam_wall_sign", () -> wallSign(SEA_FOAM_SIGN.get(), MysticWoodTypes.SEA_FOAM));
    public static final RegistryObject<Block> SEA_FOAM_HANGING_SIGN = BLOCKS.register("sea_foam_hanging_sign", () -> hangingSign(SEA_FOAM_PLANKS.get(), MysticWoodTypes.SEA_FOAM));
    public static final RegistryObject<Block> SEA_FOAM_WALL_HANGING_SIGN = BLOCKS.register("sea_foam_wall_hanging_sign", () -> wallHangingSign(SEA_FOAM_HANGING_SIGN.get(), MysticWoodTypes.SEA_FOAM));

    ///public static final RegistryObject<Block> BEACH_GRASS;
    ///public static final RegistryObject<Block> TALL_BEACH_GRASS;
    ///public static final RegistryObject<Block> MILKWEED;
    ///public static final RegistryObject<Block> SEA_THRIFT;
    ///public static final RegistryObject<Block> SEA_OATS;
    ///public static final RegistryObject<Block> SEA_FOAM;

    /// tropics
    public static final RegistryObject<Block> TROPICAL_LEAVES = BLOCKS.register("tropical_leaves", () -> leaves(SoundType.GRASS));
    public static final RegistryObject<Block> TROPICAL_SAPLING = BLOCKS.register("tropical_sapling", () -> sapling(new MysticTreeGrowers(TreeFeatures.OAK)));///new MysticMegaTreeGrowers(MysticTreeFeatures.TROPICAL_TREE, MysticTreeFeatures.LARGE_TROPICAL_TREE)));
    public static final RegistryObject<Block> TROPICAL_LOG = BLOCKS.register("tropical_log", () -> log(MapColor.COLOR_BLUE, MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> STRIPPED_TROPICAL_LOG = BLOCKS.register("stripped_tropical_log", () -> log(MapColor.COLOR_BLUE));
    public static final RegistryObject<Block> TROPICAL_WOOD = BLOCKS.register("tropical_wood", () -> log(MapColor.COLOR_BLUE, MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> STRIPPED_TROPICAL_WOOD = BLOCKS.register("stripped_tropical_wood", () -> log(MapColor.COLOR_BLUE));
    public static final RegistryObject<Block> TROPICAL_PLANKS = BLOCKS.register("tropical_planks", () -> planks(MapColor.COLOR_BLUE));
    public static final RegistryObject<Block> TROPICAL_STAIRS = BLOCKS.register("tropical_stairs", () -> stairs(TROPICAL_PLANKS.get()));
    public static final RegistryObject<Block> TROPICAL_SLAB = BLOCKS.register("tropical_slab", () -> slab(TROPICAL_PLANKS.get()));
    public static final RegistryObject<Block> TROPICAL_FENCE = BLOCKS.register("tropical_fence", () -> fence(TROPICAL_PLANKS.get()));
    public static final RegistryObject<Block> TROPICAL_FENCE_GATE = BLOCKS.register("tropical_fence_gate", () -> fenceGate(TROPICAL_PLANKS.get(), MysticWoodTypes.TROPICAL));
    public static final RegistryObject<Block> TROPICAL_BUTTON = BLOCKS.register("tropical_button", () -> button(MysticBlockSetTypes.TROPICAL));
    public static final RegistryObject<Block> TROPICAL_PRESSURE_PLATE = BLOCKS.register("tropical_pressure_plate", () -> pressurePlate(TROPICAL_PLANKS.get(), MysticBlockSetTypes.TROPICAL));
    public static final RegistryObject<Block> TROPICAL_TRAPDOOR = BLOCKS.register("tropical_trapdoor", () -> trapdoor(TROPICAL_PLANKS.get(), MysticBlockSetTypes.TROPICAL));
    public static final RegistryObject<Block> TROPICAL_DOOR = BLOCKS.register("tropical_door", () -> door(TROPICAL_PLANKS.get(), MysticBlockSetTypes.TROPICAL));
    public static final RegistryObject<Block> TROPICAL_SIGN = BLOCKS.register("tropical_sign", () -> sign(TROPICAL_PLANKS.get(), MysticWoodTypes.TROPICAL));
    public static final RegistryObject<Block> TROPICAL_WALL_SIGN = BLOCKS.register("tropical_wall_sign", () -> wallSign(TROPICAL_SIGN.get(), MysticWoodTypes.TROPICAL));
    public static final RegistryObject<Block> TROPICAL_HANGING_SIGN = BLOCKS.register("tropical_hanging_sign", () -> hangingSign(TROPICAL_PLANKS.get(), MysticWoodTypes.TROPICAL));
    public static final RegistryObject<Block> TROPICAL_WALL_HANGING_SIGN = BLOCKS.register("tropical_wall_hanging_sign", () -> wallHangingSign(TROPICAL_HANGING_SIGN.get(), MysticWoodTypes.TROPICAL));

    public static final RegistryObject<Block> VANILLA_LEAVES = BLOCKS.register("vanilla_leaves", () -> leaves(SoundType.GRASS));
    public static final RegistryObject<Block> VANILLA_SAPLING = BLOCKS.register("vanilla_sapling", () -> sapling(new MysticTreeGrowers(TreeFeatures.OAK)));///MysticTreeFeatures.VANILLA_TREE)));
    public static final RegistryObject<Block> VANILLA_LOG = BLOCKS.register("vanilla_log", () -> log(MapColor.TERRACOTTA_WHITE, MapColor.TERRACOTTA_WHITE));
    public static final RegistryObject<Block> STRIPPED_VANILLA_LOG = BLOCKS.register("stripped_vanilla_log", () -> log(MapColor.TERRACOTTA_WHITE));
    public static final RegistryObject<Block> VANILLA_WOOD = BLOCKS.register("vanilla_wood", () -> log(MapColor.TERRACOTTA_WHITE, MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> STRIPPED_VANILLA_WOOD = BLOCKS.register("stripped_vanilla_wood", () -> log(MapColor.TERRACOTTA_WHITE));
    public static final RegistryObject<Block> VANILLA_PLANKS = BLOCKS.register("vanilla_planks", () -> planks(MapColor.TERRACOTTA_WHITE));
    public static final RegistryObject<Block> VANILLA_STAIRS = BLOCKS.register("vanilla_stairs", () -> stairs(VANILLA_PLANKS.get()));
    public static final RegistryObject<Block> VANILLA_SLAB = BLOCKS.register("vanilla_slab", () -> slab(VANILLA_PLANKS.get()));
    public static final RegistryObject<Block> VANILLA_FENCE = BLOCKS.register("vanilla_fence", () -> fence(VANILLA_PLANKS.get()));
    public static final RegistryObject<Block> VANILLA_FENCE_GATE = BLOCKS.register("vanilla_fence_gate", () -> fenceGate(VANILLA_PLANKS.get(), MysticWoodTypes.VANILLA));
    public static final RegistryObject<Block> VANILLA_BUTTON = BLOCKS.register("vanilla_button", () -> button(MysticBlockSetTypes.VANILLA));
    public static final RegistryObject<Block> VANILLA_PRESSURE_PLATE = BLOCKS.register("vanilla_pressure_plate", () -> pressurePlate(VANILLA_PLANKS.get(), MysticBlockSetTypes.VANILLA));
    public static final RegistryObject<Block> VANILLA_TRAPDOOR = BLOCKS.register("vanilla_trapdoor", () -> trapdoor(VANILLA_PLANKS.get(), MysticBlockSetTypes.VANILLA));
    public static final RegistryObject<Block> VANILLA_DOOR = BLOCKS.register("vanilla_door", () -> door(VANILLA_PLANKS.get(), MysticBlockSetTypes.VANILLA));
    public static final RegistryObject<Block> VANILLA_SIGN = BLOCKS.register("vanilla_sign", () -> sign(VANILLA_PLANKS.get(), MysticWoodTypes.VANILLA));
    public static final RegistryObject<Block> VANILLA_WALL_SIGN = BLOCKS.register("vanilla_wall_sign", () -> wallSign(VANILLA_SIGN.get(), MysticWoodTypes.VANILLA));
    public static final RegistryObject<Block> VANILLA_HANGING_SIGN = BLOCKS.register("vanilla_hanging_sign", () -> hangingSign(VANILLA_PLANKS.get(), MysticWoodTypes.VANILLA));
    public static final RegistryObject<Block> VANILLA_WALL_HANGING_SIGN = BLOCKS.register("vanilla_wall_hanging_sign", () -> wallHangingSign(VANILLA_HANGING_SIGN.get(), MysticWoodTypes.VANILLA));

    ///public static final RegistryObject<Block> TROPICAL_VINES;
    ///public static final RegistryObject<Block> JUNGLE_SHRUB;
    ///public static final RegistryObject<Block> JUNGLE_GRASS;
    ///public static final RegistryObject<Block> TALL_JUNGLE_GRASS;
    ///public static final RegistryObject<Block> BANANA_LEAF_PLANT;
    ///public static final RegistryObject<Block> HYDRANGEA_BUSH_LEAVES;
    ///public static final RegistryObject<Block> HYDRANGEA_BUSH;
    ///public static final RegistryObject<Block> HIBISCUS;
    ///public static final RegistryObject<Block> VANILLA_ORCHID;
    public static final RegistryObject<Block> VANILLA_CAKE = BLOCKS.register("vanilla_cake", BlockTemplate::cake);
    public static final RegistryObject<Block> CHOCOLATE_CAKE = BLOCKS.register("chocolate_cake", BlockTemplate::cake);

    /// frosted cakes
    public static final RegistryObject<Block> PINK_FROSTED_CAKE = BLOCKS.register("pink_frosted_cake", BlockTemplate::cake);
    public static final RegistryObject<Block> ORANGE_FROSTED_CAKE = BLOCKS.register("orange_frosted_cake", BlockTemplate::cake);
    public static final RegistryObject<Block> YELLOW_FROSTED_CAKE = BLOCKS.register("yellow_frosted_cake", BlockTemplate::cake);
    public static final RegistryObject<Block> LIME_FROSTED_CAKE = BLOCKS.register("lime_frosted_cake", BlockTemplate::cake);
    public static final RegistryObject<Block> CYAN_FROSTED_CAKE = BLOCKS.register("cyan_frosted_cake", BlockTemplate::cake);
    public static final RegistryObject<Block> PURPLE_FROSTED_CAKE = BLOCKS.register("purple_frosted_cake", BlockTemplate::cake);
    ///public static final RegistryObject<Block> RAINBOW_FROSTED_CAKE;

    ///public static final RegistryObject<Block> POTTED_STRAWBERRY_SAPLING = BLOCKS.register("potted_strawberry_sapling", () -> potted(POTTED_STRAWBERRY_SAPLING.get()));
    ///public static final RegistryObject<Block> POTTED_STRAWBERRY_BUSH = BLOCKS.register("potted_strawberry_bush", () -> potted(POTTED_STRAWBERRY_BUSH.get()));
    ///public static final RegistryObject<Block> POTTED_PINK_DAISIES = BLOCKS.register("potted_pink_daisies", () -> potted(POTTED_PINK_DAISIES.get()));
    ///public static final RegistryObject<Block> POTTED_LAVENDER_SAPLING = BLOCKS.register("potted_lavender_sapling", () -> potted(POTTED_LAVENDER_SAPLING.get()));
    ///public static final RegistryObject<Block> POTTED_LAVENDER = BLOCKS.register("potted_lavender", () -> potted(POTTED_LAVENDER.get()));
    ///public static final RegistryObject<Block> POTTED_BUTTERFLY_BUSH = BLOCKS.register("potted_butterfly_bush", () -> potted(POTTED_BUTTERFLY_BUSH.get()));
    ///public static final RegistryObject<Block> POTTED_PINK_CHERRY_BLOSSOM_SAPLING = BLOCKS.register("potted_pink_cherry_blossom_sapling", () -> potted(POTTED_PINK_CHERRY_BLOSSOM_SAPLING.get()));
    ///public static final RegistryObject<Block> POTTED_WHITE_CHERRY_BLOSSOM_SAPLING = BLOCKS.register("potted_white_cherry_blossom_sapling", () -> potted(POTTED_WHITE_CHERRY_BLOSSOM_SAPLING.get()));
    ///public static final RegistryObject<Block> POTTED_SPRING_BAMBOO = BLOCKS.register("potted_spring_bamboo", () -> potted(POTTED_SPRING_BAMBOO.get()));
    ///public static final RegistryObject<Block> POTTED_STRIPPED_SPRING_BAMBOO = BLOCKS.register("potted_stripped_spring_bamboo", () -> potted(POTTED_STRIPPED_SPRING_BAMBOO.get()));
    ///public static final RegistryObject<Block> POTTED_PEONY_BUSH = BLOCKS.register("potted_peony_bush", () -> potted(POTTED_PEONY_BUSH.get()));
    ///public static final RegistryObject<Block> POTTED_MAPLE_SAPLING = BLOCKS.register("potted_maple_sapling", () -> potted(POTTED_MAPLE_SAPLING.get()));
    ///public static final RegistryObject<Block> POTTED_SPICED_MAPLE_SAPLING = BLOCKS.register("potted_spiced_maple_sapling", () -> potted(POTTED_SPICED_MAPLE_SAPLING.get()));
    ///public static final RegistryObject<Block> POTTED_ORANGE_MAPLE_SAPLING = BLOCKS.register("potted_orange_maple_sapling", () -> potted(POTTED_ORANGE_MAPLE_SAPLING.get()));
    ///public static final RegistryObject<Block> POTTED_YELLOW_MAPLE_SAPLING = BLOCKS.register("potted_yellow_maple_sapling", () -> potted(POTTED_YELLOW_MAPLE_SAPLING.get()));
    ///public static final RegistryObject<Block> POTTED_ASTER = BLOCKS.register("potted_aster", () -> potted(POTTED_ASTER.get()));
    ///public static final RegistryObject<Block> POTTED_GOLDENROD = BLOCKS.register("potted_goldenrod", () -> potted(POTTED_GOLDENROD.get()));
    ///public static final RegistryObject<Block> POTTED_PEACH_SAPLING = BLOCKS.register("potted_peach_sapling", () -> potted(POTTED_PEACH_SAPLING.get()));
    ///public static final RegistryObject<Block> POTTED_DESERT_SHRUB = BLOCKS.register("potted_desert_shrub", () -> potted(POTTED_DESERT_SHRUB.get()));
    ///public static final RegistryObject<Block> POTTED_DESERT_LILY = BLOCKS.register("potted_desert_lily", () -> potted(POTTED_DESERT_LILY.get()));
    ///public static final RegistryObject<Block> POTTED_WILDFLOWER = BLOCKS.register("potted_wildflower", () -> potted(POTTED_WILDFLOWER.get()));
    ///public static final RegistryObject<Block> POTTED_SAGUARO_CACTUS = BLOCKS.register("potted_saguaro_cactus", () -> potted(POTTED_SAGUARO_CACTUS.get()));
    ///public static final RegistryObject<Block> POTTED_PRICKLY_CACTUS = BLOCKS.register("potted_prickly_cactus", () -> potted(POTTED_PRICKLY_CACTUS.get()));
    ///public static final RegistryObject<Block> POTTED_SEA_SHRUB = BLOCKS.register("potted_sea_shrub", () -> potted(POTTED_SEA_SHRUB.get()));
    ///public static final RegistryObject<Block> POTTED_MILKWEED = BLOCKS.register("potted_milkweed", () -> potted(POTTED_MILKWEED.get()));
    ///public static final RegistryObject<Block> POTTED_SEA_THRIFT = BLOCKS.register("potted_sea_thrift", () -> potted(POTTED_SEA_THRIFT.get()));
    ///public static final RegistryObject<Block> POTTED_SEA_OATS = BLOCKS.register("potted_sea_oats", () -> potted(POTTED_SEA_OATS.get()));
    ///public static final RegistryObject<Block> POTTED_TROPICAL_SAPLING = BLOCKS.register("potted_tropical_sapling", () -> potted(POTTED_TROPICAL_SAPLING.get()));
    ///public static final RegistryObject<Block> POTTED_VANILLA_SAPLING = BLOCKS.register("potted_vanilla_sapling", () -> potted(POTTED_VANILLA_SAPLING.get()));
    ///public static final RegistryObject<Block> POTTED_JUNGLE_SHRUB = BLOCKS.register("potted_jungle_shrub", () -> potted(POTTED_JUNGLE_SHRUB.get()));
    ///public static final RegistryObject<Block> POTTED_HYDRANGEA_BUSH = BLOCKS.register("potted_hydrangea_bush", () -> potted(POTTED_HYDRANGEA_BUSH.get()));
    ///public static final RegistryObject<Block> POTTED_HIBISCUS = BLOCKS.register("potted_hibiscus", () -> potted(POTTED_HIBISCUS.get()));

}