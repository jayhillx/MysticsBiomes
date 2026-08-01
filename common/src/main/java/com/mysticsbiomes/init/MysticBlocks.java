package com.mysticsbiomes.init;

import api.mystanica.registry.Registrar;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.block.*;
import com.mysticsbiomes.common.block.grower.MysticTreeGrowers;
import com.mysticsbiomes.common.block.state.MysticBlockSetTypes;
import com.mysticsbiomes.common.block.state.MysticWoodTypes;
import com.mysticsbiomes.common.worldgen.feature.MysticTreeFeatures;
import api.mystanica.registry.RegistryEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import static com.mysticsbiomes.common.block.BlockTemplate.*;

public class MysticBlocks {
    public static final Registrar<Block> BLOCKS = Registrar.create(Registries.BLOCK, MysticsBiomes.modId);

    /// strawberry fields
    public static final RegistryEntry<Block> STRAWBERRY_BLOSSOMS = BLOCKS.register("strawberry_blossoms", () -> new LeafyBlossomsBlock(leafProperties(SoundType.AZALEA_LEAVES)));
    public static final RegistryEntry<Block> STRAWBERRY_BLOSSOM_SAPLING = BLOCKS.register("strawberry_blossom_sapling", () -> sapling(new MysticTreeGrowers(TreeFeatures.OAK)));
    public static final RegistryEntry<Block> STRAWBERRY_LOG = BLOCKS.register("strawberry_log", () -> log(MapColor.COLOR_PINK, MapColor.COLOR_BROWN));
    public static final RegistryEntry<Block> STRIPPED_STRAWBERRY_LOG = BLOCKS.register("stripped_strawberry_log", () -> log(MapColor.COLOR_PINK));
    public static final RegistryEntry<Block> STRAWBERRY_WOOD = BLOCKS.register("strawberry_wood", () -> log(MapColor.COLOR_PINK, MapColor.COLOR_BROWN));
    public static final RegistryEntry<Block> STRIPPED_STRAWBERRY_WOOD = BLOCKS.register("stripped_strawberry_wood", () -> log(MapColor.COLOR_PINK));
    public static final RegistryEntry<Block> STRAWBERRY_PLANKS = BLOCKS.register("strawberry_planks", () -> planks(MapColor.COLOR_PINK));
    public static final RegistryEntry<Block> STRAWBERRY_STAIRS = BLOCKS.register("strawberry_stairs", () -> stairs(STRAWBERRY_PLANKS));
    public static final RegistryEntry<Block> STRAWBERRY_SLAB = BLOCKS.register("strawberry_slab", () -> slab(STRAWBERRY_PLANKS));
    public static final RegistryEntry<Block> STRAWBERRY_FENCE = BLOCKS.register("strawberry_fence", () -> woodenFence(STRAWBERRY_PLANKS));
    public static final RegistryEntry<Block> STRAWBERRY_FENCE_GATE = BLOCKS.register("strawberry_fence_gate", () -> woodenFenceGate(STRAWBERRY_PLANKS, MysticWoodTypes.STRAWBERRY));
    public static final RegistryEntry<Block> STRAWBERRY_BUTTON = BLOCKS.register("strawberry_button", () -> woodenButton(MysticBlockSetTypes.STRAWBERRY));
    public static final RegistryEntry<Block> STRAWBERRY_PRESSURE_PLATE = BLOCKS.register("strawberry_pressure_plate", () -> woodenPressurePlate(STRAWBERRY_PLANKS, MysticBlockSetTypes.STRAWBERRY));
    public static final RegistryEntry<Block> STRAWBERRY_TRAPDOOR = BLOCKS.register("strawberry_trapdoor", () -> woodenTrapdoor(STRAWBERRY_PLANKS, MysticBlockSetTypes.STRAWBERRY));
    public static final RegistryEntry<Block> STRAWBERRY_DOOR = BLOCKS.register("strawberry_door", () -> woodenDoor(STRAWBERRY_PLANKS, MysticBlockSetTypes.STRAWBERRY));
    public static final RegistryEntry<Block> STRAWBERRY_SIGN = BLOCKS.register("strawberry_sign", () -> sign(STRAWBERRY_PLANKS, MysticWoodTypes.STRAWBERRY));
    public static final RegistryEntry<Block> STRAWBERRY_WALL_SIGN = BLOCKS.register("strawberry_wall_sign", () -> wallSign(STRAWBERRY_SIGN, MysticWoodTypes.STRAWBERRY));
    public static final RegistryEntry<Block> STRAWBERRY_HANGING_SIGN = BLOCKS.register("strawberry_hanging_sign", () -> hangingSign(STRAWBERRY_PLANKS, MysticWoodTypes.STRAWBERRY));
    public static final RegistryEntry<Block> STRAWBERRY_WALL_HANGING_SIGN = BLOCKS.register("strawberry_wall_hanging_sign", () -> wallHangingSign(STRAWBERRY_HANGING_SIGN, MysticWoodTypes.STRAWBERRY));

    /// lavender meadow
    public static final RegistryEntry<Block> LAVENDER_BLOSSOMS = BLOCKS.register("lavender_blossoms", () -> new LeafyBlossomsBlock(leafProperties(SoundType.AZALEA_LEAVES)));
    public static final RegistryEntry<Block> LAVENDER_BLOSSOM_SAPLING = BLOCKS.register("lavender_blossom_sapling", () -> sapling(new MysticTreeGrowers(MysticTreeFeatures.LAVENDER_TREE)));
    public static final RegistryEntry<Block> LAVENDER_LOG = BLOCKS.register("lavender_log", () -> log(MapColor.COLOR_PURPLE, MapColor.COLOR_BROWN));
    public static final RegistryEntry<Block> STRIPPED_LAVENDER_LOG = BLOCKS.register("stripped_lavender_log", () -> log(MapColor.COLOR_PURPLE));
    public static final RegistryEntry<Block> LAVENDER_WOOD = BLOCKS.register("lavender_wood", () -> log(MapColor.COLOR_PURPLE, MapColor.COLOR_BROWN));
    public static final RegistryEntry<Block> STRIPPED_LAVENDER_WOOD = BLOCKS.register("stripped_lavender_wood", () -> log(MapColor.COLOR_PURPLE));
    public static final RegistryEntry<Block> LAVENDER_PLANKS = BLOCKS.register("lavender_planks", () -> planks(MapColor.COLOR_PURPLE));
    public static final RegistryEntry<Block> LAVENDER_STAIRS = BLOCKS.register("lavender_stairs", () -> stairs(LAVENDER_PLANKS));
    public static final RegistryEntry<Block> LAVENDER_SLAB = BLOCKS.register("lavender_slab", () -> slab(LAVENDER_PLANKS));
    public static final RegistryEntry<Block> LAVENDER_FENCE = BLOCKS.register("lavender_fence", () -> woodenFence(LAVENDER_PLANKS));
    public static final RegistryEntry<Block> LAVENDER_FENCE_GATE = BLOCKS.register("lavender_fence_gate", () -> woodenFenceGate(LAVENDER_PLANKS, MysticWoodTypes.LAVENDER));
    public static final RegistryEntry<Block> LAVENDER_BUTTON = BLOCKS.register("lavender_button", () -> woodenButton(MysticBlockSetTypes.LAVENDER));
    public static final RegistryEntry<Block> LAVENDER_PRESSURE_PLATE = BLOCKS.register("lavender_pressure_plate", () -> woodenPressurePlate(LAVENDER_PLANKS, MysticBlockSetTypes.LAVENDER));
    public static final RegistryEntry<Block> LAVENDER_TRAPDOOR = BLOCKS.register("lavender_trapdoor", () -> woodenTrapdoor(LAVENDER_PLANKS, MysticBlockSetTypes.LAVENDER));
    public static final RegistryEntry<Block> LAVENDER_DOOR = BLOCKS.register("lavender_door", () -> woodenDoor(LAVENDER_PLANKS, MysticBlockSetTypes.LAVENDER));
    public static final RegistryEntry<Block> LAVENDER_SIGN = BLOCKS.register("lavender_sign", () -> sign(LAVENDER_PLANKS, MysticWoodTypes.LAVENDER));
    public static final RegistryEntry<Block> LAVENDER_WALL_SIGN = BLOCKS.register("lavender_wall_sign", () -> wallSign(LAVENDER_SIGN, MysticWoodTypes.LAVENDER));
    public static final RegistryEntry<Block> LAVENDER_HANGING_SIGN = BLOCKS.register("lavender_hanging_sign", () -> hangingSign(LAVENDER_PLANKS, MysticWoodTypes.LAVENDER));
    public static final RegistryEntry<Block> LAVENDER_WALL_HANGING_SIGN = BLOCKS.register("lavender_wall_hanging_sign", () -> wallHangingSign(LAVENDER_HANGING_SIGN, MysticWoodTypes.LAVENDER));

    /// bamboo blossom forest
    public static final RegistryEntry<Block> PINK_CHERRY_BLOSSOMS = BLOCKS.register("pink_cherry_blossoms", () -> new LeavesBlock(leafProperties(SoundType.CHERRY_LEAVES)));
    ///public static final RegistryEntry<Block> PINK_CHERRY_PETALS;
    public static final RegistryEntry<Block> PINK_CHERRY_BLOSSOM_SAPLING = BLOCKS.register("pink_cherry_blossom_sapling", () -> sapling(new MysticTreeGrowers(MysticTreeFeatures.PINK_CHERRY_TREE), SoundType.CHERRY_SAPLING));
    public static final RegistryEntry<Block> WHITE_CHERRY_BLOSSOMS = BLOCKS.register("white_cherry_blossoms", () -> new LeavesBlock(leafProperties(SoundType.CHERRY_LEAVES)));
    ///public static final RegistryEntry<Block> WHITE_CHERRY_PETALS;
    public static final RegistryEntry<Block> WHITE_CHERRY_BLOSSOM_SAPLING = BLOCKS.register("white_cherry_blossom_sapling", () -> sapling(new MysticTreeGrowers(MysticTreeFeatures.WHITE_CHERRY_TREE), SoundType.CHERRY_SAPLING));
    public static final RegistryEntry<Block> BLACK_CHERRY_LOG = BLOCKS.register("black_cherry_log", () -> log(MapColor.COLOR_MAGENTA, MapColor.TERRACOTTA_MAGENTA, SoundType.CHERRY_WOOD));
    public static final RegistryEntry<Block> STRIPPED_BLACK_CHERRY_LOG = BLOCKS.register("stripped_black_cherry_log", () -> log(MapColor.COLOR_MAGENTA, SoundType.CHERRY_WOOD));
    public static final RegistryEntry<Block> BLACK_CHERRY_WOOD = BLOCKS.register("black_cherry_wood", () -> log(MapColor.TERRACOTTA_MAGENTA, SoundType.CHERRY_WOOD));
    public static final RegistryEntry<Block> STRIPPED_BLACK_CHERRY_WOOD = BLOCKS.register("stripped_black_cherry_wood", () -> log(MapColor.COLOR_MAGENTA, SoundType.CHERRY_WOOD));
    public static final RegistryEntry<Block> BLACK_CHERRY_PLANKS = BLOCKS.register("black_cherry_planks", () -> planks(MapColor.COLOR_MAGENTA, SoundType.CHERRY_WOOD));
    public static final RegistryEntry<Block> BLACK_CHERRY_STAIRS = BLOCKS.register("black_cherry_stairs", () -> stairs(BLACK_CHERRY_PLANKS));
    public static final RegistryEntry<Block> BLACK_CHERRY_SLAB = BLOCKS.register("black_cherry_slab", () -> slab(BLACK_CHERRY_PLANKS));
    public static final RegistryEntry<Block> BLACK_CHERRY_FENCE = BLOCKS.register("black_cherry_fence", () -> woodenFence(BLACK_CHERRY_PLANKS));
    public static final RegistryEntry<Block> BLACK_CHERRY_FENCE_GATE = BLOCKS.register("black_cherry_fence_gate", () -> woodenFenceGate(BLACK_CHERRY_PLANKS, MysticWoodTypes.BLACK_CHERRY));
    public static final RegistryEntry<Block> BLACK_CHERRY_BUTTON = BLOCKS.register("black_cherry_button", () -> woodenButton(MysticBlockSetTypes.BLACK_CHERRY));
    public static final RegistryEntry<Block> BLACK_CHERRY_PRESSURE_PLATE = BLOCKS.register("black_cherry_pressure_plate", () -> woodenPressurePlate(BLACK_CHERRY_PLANKS, MysticBlockSetTypes.BLACK_CHERRY));
    public static final RegistryEntry<Block> BLACK_CHERRY_TRAPDOOR = BLOCKS.register("black_cherry_trapdoor", () -> woodenTrapdoor(BLACK_CHERRY_PLANKS, MysticBlockSetTypes.BLACK_CHERRY));
    public static final RegistryEntry<Block> BLACK_CHERRY_DOOR = BLOCKS.register("black_cherry_door", () -> woodenDoor(BLACK_CHERRY_PLANKS, MysticBlockSetTypes.BLACK_CHERRY));
    public static final RegistryEntry<Block> BLACK_CHERRY_SIGN = BLOCKS.register("black_cherry_sign", () -> sign(BLACK_CHERRY_PLANKS, MysticWoodTypes.BLACK_CHERRY));
    public static final RegistryEntry<Block> BLACK_CHERRY_WALL_SIGN = BLOCKS.register("black_cherry_wall_sign", () -> wallSign(BLACK_CHERRY_SIGN, MysticWoodTypes.BLACK_CHERRY));
    public static final RegistryEntry<Block> BLACK_CHERRY_HANGING_SIGN = BLOCKS.register("black_cherry_hanging_sign", () -> hangingSign(BLACK_CHERRY_PLANKS, MysticWoodTypes.BLACK_CHERRY));
    public static final RegistryEntry<Block> BLACK_CHERRY_WALL_HANGING_SIGN = BLOCKS.register("black_cherry_wall_hanging_sign", () -> wallHangingSign(BLACK_CHERRY_HANGING_SIGN, MysticWoodTypes.BLACK_CHERRY));

    public static final RegistryEntry<Block> SPRING_BAMBOO_SAPLING = BLOCKS.register("spring_bamboo_sapling", () -> new SpringBambooSaplingBlock(bambooProperties(SoundType.BAMBOO_SAPLING)));
    public static final RegistryEntry<Block> SPRING_BAMBOO = BLOCKS.register("spring_bamboo", () -> new SpringBambooStalkBlock(bambooProperties(SoundType.BAMBOO)));
    public static final RegistryEntry<Block> SPRING_BAMBOO_BLOCK = BLOCKS.register("spring_bamboo_block", () -> log(MapColor.COLOR_LIGHT_GREEN, MapColor.COLOR_GREEN, SoundType.BAMBOO_WOOD));
    public static final RegistryEntry<Block> STRIPPED_SPRING_BAMBOO_BLOCK = BLOCKS.register("stripped_spring_bamboo_block", () -> log(MapColor.COLOR_LIGHT_GREEN, SoundType.BAMBOO_WOOD));
    public static final RegistryEntry<Block> SPRING_PLANKS = BLOCKS.register("spring_planks", () -> planks(MapColor.COLOR_LIGHT_GREEN, SoundType.BAMBOO_WOOD));
    public static final RegistryEntry<Block> SPRING_MOSAIC = BLOCKS.register("spring_mosaic", () -> planks(MapColor.COLOR_LIGHT_GREEN));
    public static final RegistryEntry<Block> SPRING_STAIRS = BLOCKS.register("spring_stairs", () -> stairs(SPRING_PLANKS));
    public static final RegistryEntry<Block> SPRING_MOSAIC_STAIRS = BLOCKS.register("spring_mosaic_stairs", () -> stairs(SPRING_PLANKS));
    public static final RegistryEntry<Block> SPRING_SLAB = BLOCKS.register("spring_slab", () -> slab(SPRING_PLANKS));
    public static final RegistryEntry<Block> SPRING_MOSAIC_SLAB = BLOCKS.register("spring_mosaic_slab", () -> slab(SPRING_PLANKS));
    public static final RegistryEntry<Block> SPRING_FENCE = BLOCKS.register("spring_fence", () -> woodenFence(SPRING_PLANKS));
    public static final RegistryEntry<Block> SPRING_FENCE_GATE = BLOCKS.register("spring_fence_gate", () -> woodenFenceGate(SPRING_PLANKS, MysticWoodTypes.SPRING));
    public static final RegistryEntry<Block> SPRING_BUTTON = BLOCKS.register("spring_button", () -> woodenButton(MysticBlockSetTypes.SPRING));
    public static final RegistryEntry<Block> SPRING_PRESSURE_PLATE = BLOCKS.register("spring_pressure_plate", () -> woodenPressurePlate(SPRING_PLANKS, MysticBlockSetTypes.SPRING));
    public static final RegistryEntry<Block> SPRING_TRAPDOOR = BLOCKS.register("spring_trapdoor", () -> woodenTrapdoor(SPRING_PLANKS, MysticBlockSetTypes.SPRING));
    public static final RegistryEntry<Block> SPRING_DOOR = BLOCKS.register("spring_door", () -> woodenDoor(SPRING_PLANKS, MysticBlockSetTypes.SPRING));
    public static final RegistryEntry<Block> SPRING_SIGN = BLOCKS.register("spring_sign", () -> sign(SPRING_PLANKS, MysticWoodTypes.SPRING));
    public static final RegistryEntry<Block> SPRING_WALL_SIGN = BLOCKS.register("spring_wall_sign", () -> wallSign(SPRING_SIGN, MysticWoodTypes.SPRING));
    public static final RegistryEntry<Block> SPRING_HANGING_SIGN = BLOCKS.register("spring_hanging_sign", () -> hangingSign(SPRING_PLANKS, MysticWoodTypes.SPRING));
    public static final RegistryEntry<Block> SPRING_WALL_HANGING_SIGN = BLOCKS.register("spring_wall_hanging_sign", () -> wallHangingSign(SPRING_HANGING_SIGN, MysticWoodTypes.SPRING));

    /// autumnal grove
    public static final RegistryEntry<Block> MAPLE_LEAVES = BLOCKS.register("maple_leaves", () -> new MapleLeavesBlock(MysticParticles.MAPLE_LEAF, leafProperties(SoundType.AZALEA_LEAVES)));
    public static final RegistryEntry<Block> MAPLE_LEAF_PILE = BLOCKS.register("maple_leaf_pile", () -> leafPile(MysticParticles.MAPLE_LEAF_PILE, MapColor.GRASS));
    public static final RegistryEntry<Block> MAPLE_LEAF_LITTER = BLOCKS.register("maple_leaf_litter", () -> leafLitter(MapColor.GRASS));
    public static final RegistryEntry<Block> MAPLE_SAPLING = BLOCKS.register("maple_sapling", () -> sapling(new MysticTreeGrowers(MysticTreeFeatures.MAPLE_TREE)));
    public static final RegistryEntry<Block> ORANGE_MAPLE_LEAVES = BLOCKS.register("orange_maple_leaves", () -> new MapleLeavesBlock(MysticParticles.ORANGE_MAPLE_LEAF, leafProperties(SoundType.AZALEA_LEAVES)));
    public static final RegistryEntry<Block> ORANGE_MAPLE_LEAF_PILE = BLOCKS.register("orange_maple_leaf_pile", () -> leafPile(MysticParticles.ORANGE_MAPLE_LEAF_PILE, MapColor.TERRACOTTA_ORANGE));
    public static final RegistryEntry<Block> ORANGE_MAPLE_LEAF_LITTER = BLOCKS.register("orange_maple_leaf_litter", () -> leafLitter(MapColor.TERRACOTTA_ORANGE));
    public static final RegistryEntry<Block> ORANGE_MAPLE_SAPLING = BLOCKS.register("orange_maple_sapling", () -> sapling(new MysticTreeGrowers(MysticTreeFeatures.ORANGE_MAPLE_TREE)));
    public static final RegistryEntry<Block> YELLOW_MAPLE_LEAVES = BLOCKS.register("yellow_maple_leaves", () -> new MapleLeavesBlock(MysticParticles.YELLOW_MAPLE_LEAF, leafProperties(SoundType.AZALEA_LEAVES)));
    public static final RegistryEntry<Block> YELLOW_MAPLE_LEAF_PILE = BLOCKS.register("yellow_maple_leaf_pile", () -> leafPile(MysticParticles.YELLOW_MAPLE_LEAF_PILE, MapColor.TERRACOTTA_YELLOW));
    public static final RegistryEntry<Block> YELLOW_MAPLE_LEAF_LITTER = BLOCKS.register("yellow_maple_leaf_litter", () -> leafLitter(MapColor.TERRACOTTA_YELLOW));
    public static final RegistryEntry<Block> YELLOW_MAPLE_SAPLING = BLOCKS.register("yellow_maple_sapling", () -> sapling(new MysticTreeGrowers(MysticTreeFeatures.YELLOW_MAPLE_TREE)));
    public static final RegistryEntry<Block> MAPLE_LOG = BLOCKS.register("maple_log", () -> log(MapColor.COLOR_ORANGE, MapColor.COLOR_BROWN));
    public static final RegistryEntry<Block> WHITE_MAPLE_LOG = BLOCKS.register("white_maple_log", () -> log(MapColor.COLOR_ORANGE, MapColor.TERRACOTTA_WHITE));
    public static final RegistryEntry<Block> STRIPPED_MAPLE_LOG = BLOCKS.register("stripped_maple_log", () -> log(MapColor.COLOR_ORANGE));
    public static final RegistryEntry<Block> MAPLE_WOOD = BLOCKS.register("maple_wood", () -> log(MapColor.COLOR_ORANGE, MapColor.COLOR_BROWN));
    public static final RegistryEntry<Block> WHITE_MAPLE_WOOD = BLOCKS.register("white_maple_wood", () -> log(MapColor.TERRACOTTA_WHITE, MapColor.TERRACOTTA_WHITE));
    public static final RegistryEntry<Block> STRIPPED_MAPLE_WOOD = BLOCKS.register("stripped_maple_wood", () -> log(MapColor.COLOR_ORANGE));
    public static final RegistryEntry<Block> MAPLE_PLANKS = BLOCKS.register("maple_planks", () -> planks(MapColor.COLOR_ORANGE));
    public static final RegistryEntry<Block> MAPLE_STAIRS = BLOCKS.register("maple_stairs", () -> stairs(MAPLE_PLANKS));
    public static final RegistryEntry<Block> MAPLE_SLAB = BLOCKS.register("maple_slab", () -> slab(MAPLE_PLANKS));
    public static final RegistryEntry<Block> MAPLE_FENCE = BLOCKS.register("maple_fence", () -> woodenFence(MAPLE_PLANKS));
    public static final RegistryEntry<Block> MAPLE_FENCE_GATE = BLOCKS.register("maple_fence_gate", () -> woodenFenceGate(MAPLE_PLANKS, MysticWoodTypes.MAPLE));
    public static final RegistryEntry<Block> MAPLE_BUTTON = BLOCKS.register("maple_button", () -> woodenButton(MysticBlockSetTypes.MAPLE));
    public static final RegistryEntry<Block> MAPLE_PRESSURE_PLATE = BLOCKS.register("maple_pressure_plate", () -> woodenPressurePlate(MAPLE_PLANKS, MysticBlockSetTypes.MAPLE));
    public static final RegistryEntry<Block> MAPLE_TRAPDOOR = BLOCKS.register("maple_trapdoor", () -> woodenTrapdoor(MAPLE_PLANKS, MysticBlockSetTypes.MAPLE));
    public static final RegistryEntry<Block> MAPLE_DOOR = BLOCKS.register("maple_door", () -> woodenDoor(MAPLE_PLANKS, MysticBlockSetTypes.MAPLE));
    public static final RegistryEntry<Block> MAPLE_SIGN = BLOCKS.register("maple_sign", () -> sign(MAPLE_PLANKS, MysticWoodTypes.MAPLE));
    public static final RegistryEntry<Block> MAPLE_WALL_SIGN = BLOCKS.register("maple_wall_sign", () -> wallSign(MAPLE_SIGN, MysticWoodTypes.MAPLE));
    public static final RegistryEntry<Block> MAPLE_HANGING_SIGN = BLOCKS.register("maple_hanging_sign", () -> hangingSign(MAPLE_PLANKS, MysticWoodTypes.MAPLE));
    public static final RegistryEntry<Block> MAPLE_WALL_HANGING_SIGN = BLOCKS.register("maple_wall_hanging_sign", () -> wallHangingSign(MAPLE_HANGING_SIGN, MysticWoodTypes.MAPLE));
    
    /// lush oasis
    public static final RegistryEntry<Block> GRASSY_LUSH_SAND = BLOCKS.register("grassy_lush_sand", () -> new GrassyLushSandBlock(sandProperties(MapColor.SAND)));
    public static final RegistryEntry<Block> LUSH_SAND = BLOCKS.register("lush_sand", () -> new LushSandBlock(sandProperties(MapColor.SAND)));
    public static final RegistryEntry<Block> LUSH_SANDSTONE = BLOCKS.register("lush_sandstone", () -> new Block(sandstoneProperties(MapColor.SAND)));
    public static final RegistryEntry<Block> LUSH_SANDSTONE_STAIRS = BLOCKS.register("lush_sandstone_stairs", () -> stairs(LUSH_SANDSTONE));
    public static final RegistryEntry<Block> LUSH_SANDSTONE_SLAB = BLOCKS.register("lush_sandstone_slab", () -> slab(LUSH_SANDSTONE));
    public static final RegistryEntry<Block> LUSH_SANDSTONE_WALL = BLOCKS.register("lush_sandstone_wall", () -> wall(LUSH_SANDSTONE));
    public static final RegistryEntry<Block> CHISELED_LUSH_SANDSTONE = BLOCKS.register("chiseled_lush_sandstone", () -> new Block(copy(LUSH_SANDSTONE)));
    public static final RegistryEntry<Block> CUT_LUSH_SANDSTONE = BLOCKS.register("cut_lush_sandstone", () -> new Block(copy(LUSH_SANDSTONE)));
    public static final RegistryEntry<Block> CUT_LUSH_SANDSTONE_SLAB = BLOCKS.register("cut_lush_sandstone_slab", () -> new SlabBlock(copy(LUSH_SANDSTONE).strength(2.0F, 6.0F)));
    public static final RegistryEntry<Block> SMOOTH_LUSH_SANDSTONE = BLOCKS.register("smooth_lush_sandstone", () -> new Block(copy(LUSH_SANDSTONE).strength(2.0F, 6.0F)));
    public static final RegistryEntry<Block> SMOOTH_LUSH_SANDSTONE_STAIRS = BLOCKS.register("smooth_lush_sandstone_stairs", () -> stairs(SMOOTH_LUSH_SANDSTONE));
    public static final RegistryEntry<Block> SMOOTH_LUSH_SANDSTONE_SLAB = BLOCKS.register("smooth_lush_sandstone_slab", () -> slab(SMOOTH_LUSH_SANDSTONE));

    public static final RegistryEntry<Block> PEACH_LEAVES = BLOCKS.register("peach_leaves", () -> leaves(SoundType.AZALEA_LEAVES));
    public static final RegistryEntry<Block> PEACH_SAPLING = BLOCKS.register("peach_sapling", () -> sapling(new MysticTreeGrowers(MysticTreeFeatures.PEACH_TREE)));
    public static final RegistryEntry<Block> PEACH_LOG = BLOCKS.register("peach_log", () -> log(MapColor.SAND, MapColor.COLOR_BROWN));
    public static final RegistryEntry<Block> STRIPPED_PEACH_LOG = BLOCKS.register("stripped_peach_log", () -> log(MapColor.SAND));
    public static final RegistryEntry<Block> PEACH_WOOD = BLOCKS.register("peach_wood", () -> log(MapColor.SAND, MapColor.COLOR_BROWN));
    public static final RegistryEntry<Block> STRIPPED_PEACH_WOOD = BLOCKS.register("stripped_peach_wood", () -> log(MapColor.SAND));
    public static final RegistryEntry<Block> PEACH_PLANKS = BLOCKS.register("peach_planks", () -> planks(MapColor.SAND));
    public static final RegistryEntry<Block> PEACH_STAIRS = BLOCKS.register("peach_stairs", () -> stairs(PEACH_PLANKS));
    public static final RegistryEntry<Block> PEACH_SLAB = BLOCKS.register("peach_slab", () -> slab(PEACH_PLANKS));
    public static final RegistryEntry<Block> PEACH_FENCE = BLOCKS.register("peach_fence", () -> woodenFence(PEACH_PLANKS));
    public static final RegistryEntry<Block> PEACH_FENCE_GATE = BLOCKS.register("peach_fence_gate", () -> woodenFenceGate(PEACH_PLANKS, MysticWoodTypes.PEACH));
    public static final RegistryEntry<Block> PEACH_BUTTON = BLOCKS.register("peach_button", () -> woodenButton(MysticBlockSetTypes.PEACH));
    public static final RegistryEntry<Block> PEACH_PRESSURE_PLATE = BLOCKS.register("peach_pressure_plate", () -> woodenPressurePlate(PEACH_PLANKS, MysticBlockSetTypes.PEACH));
    public static final RegistryEntry<Block> PEACH_TRAPDOOR = BLOCKS.register("peach_trapdoor", () -> woodenTrapdoor(PEACH_PLANKS, MysticBlockSetTypes.PEACH));
    public static final RegistryEntry<Block> PEACH_DOOR = BLOCKS.register("peach_door", () -> woodenDoor(PEACH_PLANKS, MysticBlockSetTypes.PEACH));
    public static final RegistryEntry<Block> PEACH_SIGN = BLOCKS.register("peach_sign", () -> sign(PEACH_PLANKS, MysticWoodTypes.PEACH));
    public static final RegistryEntry<Block> PEACH_WALL_SIGN = BLOCKS.register("peach_wall_sign", () -> wallSign(PEACH_SIGN, MysticWoodTypes.PEACH));
    public static final RegistryEntry<Block> PEACH_HANGING_SIGN = BLOCKS.register("peach_hanging_sign", () -> hangingSign(PEACH_PLANKS, MysticWoodTypes.PEACH));
    public static final RegistryEntry<Block> PEACH_WALL_HANGING_SIGN = BLOCKS.register("peach_wall_hanging_sign", () -> wallHangingSign(PEACH_HANGING_SIGN, MysticWoodTypes.PEACH));

    /// lagoon
    public static final RegistryEntry<Block> SEA_SHRUB_LEAVES = BLOCKS.register("sea_shrub_leaves", () -> leaves(SoundType.GRASS));
    public static final RegistryEntry<Block> SEA_SHRUB = BLOCKS.register("sea_shrub", () -> shrub(new MysticTreeGrowers(MysticTreeFeatures.SEA_SHRUB)));
    public static final RegistryEntry<Block> SEA_FOAM_LOG = BLOCKS.register("sea_foam_log", () -> log(MapColor.COLOR_CYAN, MapColor.COLOR_BROWN));
    public static final RegistryEntry<Block> STRIPPED_SEA_FOAM_LOG = BLOCKS.register("stripped_sea_foam_log", () -> log(MapColor.COLOR_CYAN));
    public static final RegistryEntry<Block> SEA_FOAM_WOOD = BLOCKS.register("sea_foam_wood", () -> log(MapColor.COLOR_CYAN, MapColor.COLOR_BROWN));
    public static final RegistryEntry<Block> STRIPPED_SEA_FOAM_WOOD = BLOCKS.register("stripped_sea_foam_wood", () -> log(MapColor.COLOR_CYAN));
    public static final RegistryEntry<Block> SEA_FOAM_PLANKS = BLOCKS.register("sea_foam_planks", () -> planks(MapColor.COLOR_CYAN));
    public static final RegistryEntry<Block> SEA_FOAM_STAIRS = BLOCKS.register("sea_foam_stairs", () -> stairs(SEA_FOAM_PLANKS));
    public static final RegistryEntry<Block> SEA_FOAM_SLAB = BLOCKS.register("sea_foam_slab", () -> slab(SEA_FOAM_PLANKS));
    public static final RegistryEntry<Block> SEA_FOAM_FENCE = BLOCKS.register("sea_foam_fence", () -> woodenFence(SEA_FOAM_PLANKS));
    public static final RegistryEntry<Block> SEA_FOAM_FENCE_GATE = BLOCKS.register("sea_foam_fence_gate", () -> woodenFenceGate(SEA_FOAM_PLANKS, MysticWoodTypes.SEA_FOAM));
    public static final RegistryEntry<Block> SEA_FOAM_BUTTON = BLOCKS.register("sea_foam_button", () -> woodenButton(MysticBlockSetTypes.SEA_FOAM));
    public static final RegistryEntry<Block> SEA_FOAM_PRESSURE_PLATE = BLOCKS.register("sea_foam_pressure_plate", () -> woodenPressurePlate(SEA_FOAM_PLANKS, MysticBlockSetTypes.SEA_FOAM));
    public static final RegistryEntry<Block> SEA_FOAM_TRAPDOOR = BLOCKS.register("sea_foam_trapdoor", () -> woodenTrapdoor(SEA_FOAM_PLANKS, MysticBlockSetTypes.SEA_FOAM));
    public static final RegistryEntry<Block> SEA_FOAM_DOOR = BLOCKS.register("sea_foam_door", () -> woodenDoor(SEA_FOAM_PLANKS, MysticBlockSetTypes.SEA_FOAM));
    public static final RegistryEntry<Block> SEA_FOAM_SIGN = BLOCKS.register("sea_foam_sign", () -> sign(SEA_FOAM_PLANKS, MysticWoodTypes.SEA_FOAM));
    public static final RegistryEntry<Block> SEA_FOAM_WALL_SIGN = BLOCKS.register("sea_foam_wall_sign", () -> wallSign(SEA_FOAM_SIGN, MysticWoodTypes.SEA_FOAM));
    public static final RegistryEntry<Block> SEA_FOAM_HANGING_SIGN = BLOCKS.register("sea_foam_hanging_sign", () -> hangingSign(SEA_FOAM_PLANKS, MysticWoodTypes.SEA_FOAM));
    public static final RegistryEntry<Block> SEA_FOAM_WALL_HANGING_SIGN = BLOCKS.register("sea_foam_wall_hanging_sign", () -> wallHangingSign(SEA_FOAM_HANGING_SIGN, MysticWoodTypes.SEA_FOAM));

    /// tropics
    public static final RegistryEntry<Block> TROPICAL_LEAVES = BLOCKS.register("tropical_leaves", () -> leaves(SoundType.GRASS));
    public static final RegistryEntry<Block> TROPICAL_SAPLING = BLOCKS.register("tropical_sapling", () -> sapling(new MysticTreeGrowers(MysticTreeFeatures.TROPICAL_TREE)));
    public static final RegistryEntry<Block> TROPICAL_LOG = BLOCKS.register("tropical_log", () -> log(MapColor.COLOR_BLUE, MapColor.COLOR_BROWN));
    public static final RegistryEntry<Block> STRIPPED_TROPICAL_LOG = BLOCKS.register("stripped_tropical_log", () -> log(MapColor.COLOR_BLUE));
    public static final RegistryEntry<Block> TROPICAL_WOOD = BLOCKS.register("tropical_wood", () -> log(MapColor.COLOR_BLUE, MapColor.COLOR_BROWN));
    public static final RegistryEntry<Block> STRIPPED_TROPICAL_WOOD = BLOCKS.register("stripped_tropical_wood", () -> log(MapColor.COLOR_BLUE));
    public static final RegistryEntry<Block> TROPICAL_PLANKS = BLOCKS.register("tropical_planks", () -> planks(MapColor.COLOR_BLUE));
    public static final RegistryEntry<Block> TROPICAL_STAIRS = BLOCKS.register("tropical_stairs", () -> stairs(TROPICAL_PLANKS));
    public static final RegistryEntry<Block> TROPICAL_SLAB = BLOCKS.register("tropical_slab", () -> slab(TROPICAL_PLANKS));
    public static final RegistryEntry<Block> TROPICAL_FENCE = BLOCKS.register("tropical_fence", () -> woodenFence(TROPICAL_PLANKS));
    public static final RegistryEntry<Block> TROPICAL_FENCE_GATE = BLOCKS.register("tropical_fence_gate", () -> woodenFenceGate(TROPICAL_PLANKS, MysticWoodTypes.TROPICAL));
    public static final RegistryEntry<Block> TROPICAL_BUTTON = BLOCKS.register("tropical_button", () -> woodenButton(MysticBlockSetTypes.TROPICAL));
    public static final RegistryEntry<Block> TROPICAL_PRESSURE_PLATE = BLOCKS.register("tropical_pressure_plate", () -> woodenPressurePlate(TROPICAL_PLANKS, MysticBlockSetTypes.TROPICAL));
    public static final RegistryEntry<Block> TROPICAL_TRAPDOOR = BLOCKS.register("tropical_trapdoor", () -> woodenTrapdoor(TROPICAL_PLANKS, MysticBlockSetTypes.TROPICAL));
    public static final RegistryEntry<Block> TROPICAL_DOOR = BLOCKS.register("tropical_door", () -> woodenDoor(TROPICAL_PLANKS, MysticBlockSetTypes.TROPICAL));
    public static final RegistryEntry<Block> TROPICAL_SIGN = BLOCKS.register("tropical_sign", () -> sign(TROPICAL_PLANKS, MysticWoodTypes.TROPICAL));
    public static final RegistryEntry<Block> TROPICAL_WALL_SIGN = BLOCKS.register("tropical_wall_sign", () -> wallSign(TROPICAL_SIGN, MysticWoodTypes.TROPICAL));
    public static final RegistryEntry<Block> TROPICAL_HANGING_SIGN = BLOCKS.register("tropical_hanging_sign", () -> hangingSign(TROPICAL_PLANKS, MysticWoodTypes.TROPICAL));
    public static final RegistryEntry<Block> TROPICAL_WALL_HANGING_SIGN = BLOCKS.register("tropical_wall_hanging_sign", () -> wallHangingSign(TROPICAL_HANGING_SIGN, MysticWoodTypes.TROPICAL));

    public static final RegistryEntry<Block> VANILLA_LEAVES = BLOCKS.register("vanilla_leaves", () -> leaves(SoundType.GRASS));
    public static final RegistryEntry<Block> VANILLA_SAPLING = BLOCKS.register("vanilla_sapling", () -> sapling(new MysticTreeGrowers(MysticTreeFeatures.VANILLA_TREE)));
    public static final RegistryEntry<Block> VANILLA_LOG = BLOCKS.register("vanilla_log", () -> log(MapColor.TERRACOTTA_WHITE, MapColor.TERRACOTTA_WHITE));
    public static final RegistryEntry<Block> STRIPPED_VANILLA_LOG = BLOCKS.register("stripped_vanilla_log", () -> log(MapColor.TERRACOTTA_WHITE));
    public static final RegistryEntry<Block> VANILLA_WOOD = BLOCKS.register("vanilla_wood", () -> log(MapColor.TERRACOTTA_WHITE, MapColor.COLOR_BROWN));
    public static final RegistryEntry<Block> STRIPPED_VANILLA_WOOD = BLOCKS.register("stripped_vanilla_wood", () -> log(MapColor.TERRACOTTA_WHITE));
    public static final RegistryEntry<Block> VANILLA_PLANKS = BLOCKS.register("vanilla_planks", () -> planks(MapColor.TERRACOTTA_WHITE));
    public static final RegistryEntry<Block> VANILLA_STAIRS = BLOCKS.register("vanilla_stairs", () -> stairs(VANILLA_PLANKS));
    public static final RegistryEntry<Block> VANILLA_SLAB = BLOCKS.register("vanilla_slab", () -> slab(VANILLA_PLANKS));
    public static final RegistryEntry<Block> VANILLA_FENCE = BLOCKS.register("vanilla_fence", () -> woodenFence(VANILLA_PLANKS));
    public static final RegistryEntry<Block> VANILLA_FENCE_GATE = BLOCKS.register("vanilla_fence_gate", () -> woodenFenceGate(VANILLA_PLANKS, MysticWoodTypes.VANILLA));
    public static final RegistryEntry<Block> VANILLA_BUTTON = BLOCKS.register("vanilla_button", () -> woodenButton(MysticBlockSetTypes.VANILLA));
    public static final RegistryEntry<Block> VANILLA_PRESSURE_PLATE = BLOCKS.register("vanilla_pressure_plate", () -> woodenPressurePlate(VANILLA_PLANKS, MysticBlockSetTypes.VANILLA));
    public static final RegistryEntry<Block> VANILLA_TRAPDOOR = BLOCKS.register("vanilla_trapdoor", () -> woodenTrapdoor(VANILLA_PLANKS, MysticBlockSetTypes.VANILLA));
    public static final RegistryEntry<Block> VANILLA_DOOR = BLOCKS.register("vanilla_door", () -> woodenDoor(VANILLA_PLANKS, MysticBlockSetTypes.VANILLA));
    public static final RegistryEntry<Block> VANILLA_SIGN = BLOCKS.register("vanilla_sign", () -> sign(VANILLA_PLANKS, MysticWoodTypes.VANILLA));
    public static final RegistryEntry<Block> VANILLA_WALL_SIGN = BLOCKS.register("vanilla_wall_sign", () -> wallSign(VANILLA_SIGN, MysticWoodTypes.VANILLA));
    public static final RegistryEntry<Block> VANILLA_HANGING_SIGN = BLOCKS.register("vanilla_hanging_sign", () -> hangingSign(VANILLA_PLANKS, MysticWoodTypes.VANILLA));
    public static final RegistryEntry<Block> VANILLA_WALL_HANGING_SIGN = BLOCKS.register("vanilla_wall_hanging_sign", () -> wallHangingSign(VANILLA_HANGING_SIGN, MysticWoodTypes.VANILLA));

    /** TODO */
    ///public static final RegistryEntry<Block> PINK_DAISIES;
    public static final RegistryEntry<Block> WILD_STRAWBERRY_BUSH = BLOCKS.register("wild_strawberry_bush", () -> new WildStrawberryBushBlock(strawberryBushProperties().offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryEntry<Block> STRAWBERRY_BUSH = BLOCKS.register("strawberry_bush", () -> new StrawberryBushBlock(strawberryBushProperties()));
    public static final RegistryEntry<Block> STRAWBERRY_CAKE = BLOCKS.register("strawberry_cake", () -> new MysticCakeBlock(9, 1.0F, cakeProperties()));
    public static final RegistryEntry<Block> SWEET_STRAWBERRY_CAKE = BLOCKS.register("sweet_strawberry_cake", () -> new MysticCakeBlock(9, 1.0F, cakeProperties()));

    public static final RegistryEntry<Block> LAVENDER = BLOCKS.register("lavender", () -> new LavenderFlowerBlock(() -> MobEffects.NIGHT_VISION, 5, flowerProperties(MapColor.COLOR_PURPLE)));
    public static final RegistryEntry<Block> TALL_LAVENDER = BLOCKS.register("tall_lavender", () -> new MysticTallFlowerBlock(flowerProperties(MapColor.COLOR_PURPLE)));
    ///public static final RegistryEntry<Block> BUNDLED_LAVENDER_BUDS = BLOCKS.register("bundled_lavender_buds", () -> new Block(leafProperties(SoundType.AZALEA_LEAVES)));
    ///public static final RegistryEntry<Block> BUTTERFLY_BUSH_LEAVES = BLOCKS.register("butterfly_bush_leaves", () -> leaves(SoundType.AZALEA_LEAVES));
    ///public static final RegistryEntry<Block> BUTTERFLY_BUSH = BLOCKS.register("butterfly_bush", () -> bush(new MysticTreeGrowers(MysticTreeFeatures.BUTTERFLY_BUSH)));
    public static final RegistryEntry<Block> BUTTERFLY_NEST = BLOCKS.register("butterfly_nest", () -> new ButterflyNestBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.5F).sound(SoundType.FLOWERING_AZALEA).noOcclusion().ignitedByLava()));
    public static final RegistryEntry<Block> CHRYSALIS = BLOCKS.register("chrysalis", () -> new ChrysalisBlock(copy(Blocks.WHITE_WOOL)));
    public static final RegistryEntry<Block> GLASS_JAR = BLOCKS.register("glass_jar", () -> new GlassJarBlock(copy(Blocks.GLASS)));

    public static final RegistryEntry<Block> PEONY_BUSH_LEAVES = BLOCKS.register("peony_bush_leaves", () -> leaves(SoundType.AZALEA_LEAVES));
    public static final RegistryEntry<Block> PEONY_BUSH = BLOCKS.register("peony_bush", () -> bush(new MysticTreeGrowers(MysticTreeFeatures.PEONY_BUSH)));
    public static final RegistryEntry<Block> CHERRY_PLANT = BLOCKS.register("cherry_plant", () -> new FruitPlantBlock(MysticItems.CHERRIES, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().noCollission().sound(SoundType.CAVE_VINES).pushReaction(PushReaction.DESTROY)));
    public static final RegistryEntry<Block> CHERRY_PIE = BLOCKS.register("cherry_pie", () -> new PieBlock(cakeProperties()));

    ///public static final RegistryEntry<Block> MAPLE_PANCAKES;

    public static final RegistryEntry<Block> ASTER = BLOCKS.register("aster", () -> new MysticFlowerBlock(() -> MobEffects.NIGHT_VISION, 5, flowerProperties(MapColor.COLOR_PURPLE)));
    public static final RegistryEntry<Block> GOLDENROD = BLOCKS.register("goldenrod", () -> new MysticTallFlowerBlock(flowerProperties(MapColor.COLOR_YELLOW)));

    public static final RegistryEntry<Block> PEACH_PLANT = BLOCKS.register("peach_plant", () -> new FruitPlantBlock(MysticItems.PEACH, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().noCollission().sound(SoundType.CAVE_VINES).pushReaction(PushReaction.DESTROY)));
    public static final RegistryEntry<Block> PEACH_PIE = BLOCKS.register("peach_pie", () -> new PieBlock(cakeProperties()));
    ///public static final RegistryEntry<Block> DESERT_SHRUB;
    public static final RegistryEntry<Block> DESERT_GRASS = BLOCKS.register("desert_grass", () -> new MysticGrassBlock(MysticBlocks.TALL_DESERT_GRASS, grassProperties()));
    public static final RegistryEntry<Block> TALL_DESERT_GRASS = BLOCKS.register("tall_desert_grass", () -> new MysticTallGrassBlock(grassProperties()));
    public static final RegistryEntry<Block> DESERT_LILY = BLOCKS.register("desert_lily", () -> new MysticTallFlowerBlock(flowerProperties(MapColor.TERRACOTTA_WHITE)));
    public static final RegistryEntry<Block> WILDFLOWER = BLOCKS.register("wildflower", () -> new MysticFlowerBlock(() -> MobEffects.NIGHT_VISION, 5, flowerProperties(MapColor.COLOR_MAGENTA)));
    public static final RegistryEntry<Block> SAGUARO_CACTUS = BLOCKS.register("saguaro_cactus", () -> new SaguaroCactusBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().strength(0.4F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final RegistryEntry<Block> SAGUARO_BLOSSOM = BLOCKS.register("saguaro_blossom", () -> new SaguaroBlossomBlock(() -> MobEffects.NIGHT_VISION, 5, flowerProperties(MapColor.TERRACOTTA_WHITE, false)));
    ///public static final RegistryEntry<Block> PRICKLY_CACTUS;
    ///public static final RegistryEntry<Block> PRICKLY_BLOSSOM;
    ///public static final RegistryEntry<Block> PRICKLY_PEAR;

    public static final RegistryEntry<Block> BEACH_GRASS = BLOCKS.register("beach_grass", () -> new MysticGrassBlock(MysticBlocks.TALL_BEACH_GRASS, grassProperties()));
    public static final RegistryEntry<Block> TALL_BEACH_GRASS = BLOCKS.register("tall_beach_grass", () -> new MysticTallGrassBlock(grassProperties()));
    public static final RegistryEntry<Block> MILKWEED = BLOCKS.register("milkweed", () -> new MilkweedFlowerBlock(flowerProperties(MapColor.COLOR_PINK)));
    public static final RegistryEntry<Block> SEA_THRIFT = BLOCKS.register("sea_thrift", () -> new MysticFlowerBlock(() -> MobEffects.WATER_BREATHING, 5, flowerProperties(MapColor.COLOR_PINK)));
    public static final RegistryEntry<Block> SEA_OATS = BLOCKS.register("sea_oats", () -> new MysticTallFlowerBlock(grassProperties()));
    ///public static final RegistryEntry<Block> SEA_FOAM;

    ///public static final RegistryEntry<Block> TROPICAL_VINES;
    ///public static final RegistryEntry<Block> JUNGLE_SHRUB;
    ///public static final RegistryEntry<Block> JUNGLE_GRASS;
    ///public static final RegistryEntry<Block> TALL_JUNGLE_GRASS;
    ///public static final RegistryEntry<Block> BANANA_LEAF_PLANT;
    public static final RegistryEntry<Block> HYDRANGEA_BUSH_LEAVES = BLOCKS.register("hydrangea_bush_leaves", () -> leaves(SoundType.AZALEA_LEAVES));
    public static final RegistryEntry<Block> HYDRANGEA_BUSH = BLOCKS.register("hydrangea_bush", () -> bush(new MysticTreeGrowers(MysticTreeFeatures.HYDRANGEA_BUSH)));
    public static final RegistryEntry<Block> HIBISCUS = BLOCKS.register("hibiscus", () -> new MysticFlowerBlock(() -> MobEffects.WATER_BREATHING, 5, flowerProperties(MapColor.COLOR_ORANGE)));
    public static final RegistryEntry<Block> VANILLA_ORCHID = BLOCKS.register("vanilla_orchid", () -> new VanillaOrchidBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().noCollission().sound(SoundType.CAVE_VINES).pushReaction(PushReaction.DESTROY)));
    public static final RegistryEntry<Block> VANILLA_CAKE = BLOCKS.register("vanilla_cake", () -> new MysticCakeBlock(9, 1.0F, cakeProperties()));
    public static final RegistryEntry<Block> CHOCOLATE_CAKE = BLOCKS.register("chocolate_cake", () -> new MysticCakeBlock(9, 1.0F, cakeProperties()));

    public static final RegistryEntry<Block> PINK_FROSTED_CAKE = BLOCKS.register("pink_frosted_cake", () -> new MysticCakeBlock(cakeProperties()));
    public static final RegistryEntry<Block> ORANGE_FROSTED_CAKE = BLOCKS.register("orange_frosted_cake", () -> new MysticCakeBlock(cakeProperties()));
    public static final RegistryEntry<Block> YELLOW_FROSTED_CAKE = BLOCKS.register("yellow_frosted_cake", () -> new MysticCakeBlock(cakeProperties()));
    public static final RegistryEntry<Block> LIME_FROSTED_CAKE = BLOCKS.register("lime_frosted_cake", () -> new MysticCakeBlock(cakeProperties()));
    public static final RegistryEntry<Block> CYAN_FROSTED_CAKE = BLOCKS.register("cyan_frosted_cake", () -> new MysticCakeBlock(cakeProperties()));
    public static final RegistryEntry<Block> PURPLE_FROSTED_CAKE = BLOCKS.register("purple_frosted_cake", () -> new MysticCakeBlock(cakeProperties()));
    ///public static final RegistryEntry<Block> RAINBOW_FROSTED_CAKE = BLOCKS.register("rainbow_frosted_cake", () -> new MysticCakeBlock(cakeProperties()));

    public static final RegistryEntry<Block> POTTED_STRAWBERRY_BLOSSOM_SAPLING = BLOCKS.register("potted_strawberry_blossom_sapling", () -> potted(STRAWBERRY_BLOSSOM_SAPLING));
    public static final RegistryEntry<Block> POTTED_STRAWBERRY_BUSH = BLOCKS.register("potted_strawberry_bush", () -> potted(STRAWBERRY_BUSH));
    ///public static final RegistryEntry<Block> POTTED_PINK_DAISIES = BLOCKS.register("potted_pink_daisies", () -> potted(PINK_DAISIES));
    public static final RegistryEntry<Block> POTTED_LAVENDER_BLOSSOM_SAPLING = BLOCKS.register("potted_lavender_blossom_sapling", () -> potted(LAVENDER_BLOSSOM_SAPLING));
    public static final RegistryEntry<Block> POTTED_LAVENDER = BLOCKS.register("potted_lavender", () -> potted(LAVENDER));
    ///public static final RegistryEntry<Block> POTTED_BUTTERFLY_BUSH = BLOCKS.register("potted_butterfly_bush", () -> potted(BUTTERFLY_BUSH));
    public static final RegistryEntry<Block> POTTED_PINK_CHERRY_BLOSSOM_SAPLING = BLOCKS.register("potted_pink_cherry_blossom_sapling", () -> potted(PINK_CHERRY_BLOSSOM_SAPLING));
    public static final RegistryEntry<Block> POTTED_WHITE_CHERRY_BLOSSOM_SAPLING = BLOCKS.register("potted_white_cherry_blossom_sapling", () -> potted(WHITE_CHERRY_BLOSSOM_SAPLING));
    public static final RegistryEntry<Block> POTTED_SPRING_BAMBOO = BLOCKS.register("potted_spring_bamboo", () -> potted(SPRING_BAMBOO));
    public static final RegistryEntry<Block> POTTED_PEONY_BUSH = BLOCKS.register("potted_peony_bush", () -> potted(PEONY_BUSH));
    public static final RegistryEntry<Block> POTTED_MAPLE_SAPLING = BLOCKS.register("potted_maple_sapling", () -> potted(MAPLE_SAPLING));
    public static final RegistryEntry<Block> POTTED_ORANGE_MAPLE_SAPLING = BLOCKS.register("potted_orange_maple_sapling", () -> potted(ORANGE_MAPLE_SAPLING));
    public static final RegistryEntry<Block> POTTED_YELLOW_MAPLE_SAPLING = BLOCKS.register("potted_yellow_maple_sapling", () -> potted(YELLOW_MAPLE_SAPLING));
    public static final RegistryEntry<Block> POTTED_ASTER = BLOCKS.register("potted_aster", () -> potted(ASTER));
    public static final RegistryEntry<Block> POTTED_GOLDENROD = BLOCKS.register("potted_goldenrod", () -> potted(GOLDENROD));
    public static final RegistryEntry<Block> POTTED_PEACH_SAPLING = BLOCKS.register("potted_peach_sapling", () -> potted(PEACH_SAPLING));
    ///public static final RegistryEntry<Block> POTTED_DESERT_SHRUB = BLOCKS.register("potted_desert_shrub", () -> potted(DESERT_SHRUB));
    public static final RegistryEntry<Block> POTTED_DESERT_LILY = BLOCKS.register("potted_desert_lily", () -> potted(DESERT_LILY));
    public static final RegistryEntry<Block> POTTED_WILDFLOWER = BLOCKS.register("potted_wildflower", () -> potted(WILDFLOWER));
    public static final RegistryEntry<Block> POTTED_SAGUARO_CACTUS = BLOCKS.register("potted_saguaro_cactus", () -> potted(SAGUARO_CACTUS));
    ///public static final RegistryEntry<Block> POTTED_PRICKLY_CACTUS = BLOCKS.register("potted_prickly_cactus", () -> potted(PRICKLY_CACTUS));
    public static final RegistryEntry<Block> POTTED_SEA_SHRUB = BLOCKS.register("potted_sea_shrub", () -> potted(SEA_SHRUB));
    public static final RegistryEntry<Block> POTTED_MILKWEED = BLOCKS.register("potted_milkweed", () -> potted(MILKWEED));
    public static final RegistryEntry<Block> POTTED_SEA_THRIFT = BLOCKS.register("potted_sea_thrift", () -> potted(SEA_THRIFT));
    public static final RegistryEntry<Block> POTTED_SEA_OATS = BLOCKS.register("potted_sea_oats", () -> potted(SEA_OATS));
    public static final RegistryEntry<Block> POTTED_TROPICAL_SAPLING = BLOCKS.register("potted_tropical_sapling", () -> potted(TROPICAL_SAPLING));
    public static final RegistryEntry<Block> POTTED_VANILLA_SAPLING = BLOCKS.register("potted_vanilla_sapling", () -> potted(VANILLA_SAPLING));
    ///public static final RegistryEntry<Block> POTTED_JUNGLE_SHRUB = BLOCKS.register("potted_jungle_shrub", () -> potted(JUNGLE_SHRUB));
    public static final RegistryEntry<Block> POTTED_HYDRANGEA_BUSH = BLOCKS.register("potted_hydrangea_bush", () -> potted(HYDRANGEA_BUSH));
    public static final RegistryEntry<Block> POTTED_HIBISCUS = BLOCKS.register("potted_hibiscus", () -> potted(HIBISCUS));

    public static void init() {
    }

}