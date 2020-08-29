package com.meepshadow.mysticsbiomes.init;

import com.meepshadow.mysticsbiomes.core.MysticsBiomes;
import com.meepshadow.mysticsbiomes.common.block.*;
import com.meepshadow.mysticsbiomes.common.block.ModSapling;
import com.meepshadow.mysticsbiomes.common.block.ModTrapDoor;
import com.meepshadow.mysticsbiomes.common.block.bushes.StrawberryBushBlock;
import com.meepshadow.mysticsbiomes.common.block.bushes.SweetStrawberryBushBlock;
import com.meepshadow.mysticsbiomes.common.util.library.BlockProperties;
import com.meepshadow.mysticsbiomes.common.world.features.trees.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlock {

    @SuppressWarnings("deprecation")
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MysticsBiomes.MOD_ID);

    //Blocks
    public static final RegistryObject<Block> FLOWERING_MOSSY_COBBLESTONE = BLOCKS.register("flowering_mossy_cobblestone", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 6.0F)));

    //Woods
    public static final RegistryObject<Block> STRAWBERRY_BLOSSOMS = BLOCKS.register("strawberry_blossoms", () -> new LeavesBlock(Block.Properties.create(Material.LEAVES, MaterialColor.PINK).hardnessAndResistance(0.2F).sound(SoundType.PLANT).notSolid()));
    public static final RegistryObject<Block> SWEET_BLOSSOMS = BLOCKS.register("sweet_blossoms", () -> new LeavesBlock(Block.Properties.create(Material.LEAVES, MaterialColor.PINK).hardnessAndResistance(0.2F).sound(SoundType.PLANT).notSolid()));
    public static final RegistryObject<Block> WISP_BLOSSOMS = BLOCKS.register("wisp_blossoms", () -> new LeavesBlock(Block.Properties.create(Material.LEAVES, MaterialColor.PURPLE).hardnessAndResistance(0.2F).sound(SoundType.PLANT).notSolid()));
    public static final RegistryObject<Block> LAVENDER_BLOSSOMS = BLOCKS.register("lavender_blossoms", () -> new LeavesBlock(Block.Properties.create(Material.LEAVES, MaterialColor.PURPLE).hardnessAndResistance(0.2F).sound(SoundType.PLANT).notSolid()));
    public static final RegistryObject<Block> FROSTED_LEAVES = BLOCKS.register("frosted_leaves", () -> new LeavesBlock(Block.Properties.create(Material.LEAVES, MaterialColor.LIGHT_BLUE).hardnessAndResistance(0.2F).sound(SoundType.PLANT).notSolid()));
    public static final RegistryObject<Block> TROPICAL_LEAVES = BLOCKS.register("tropical_leaves", () -> new LeavesBlock(Block.Properties.create(Material.LEAVES, MaterialColor.BLUE).hardnessAndResistance(0.2F).sound(SoundType.PLANT).notSolid()));
    public static final RegistryObject<Block> SEAFOAM_LEAVES = BLOCKS.register("seafoam_leaves", () -> new LeavesBlock(Block.Properties.create(Material.LEAVES, MaterialColor.CYAN).hardnessAndResistance(0.2F).sound(SoundType.PLANT).notSolid()));
    public static final RegistryObject<Block> EVERGREEN_LEAVES = BLOCKS.register("evergreen_leaves", () -> new LeavesBlock(Block.Properties.create(Material.LEAVES, MaterialColor.LIME).hardnessAndResistance(0.2F).sound(SoundType.PLANT).notSolid()));
    public static final RegistryObject<Block> DANDELION_LEAVES = BLOCKS.register("dandelion_leaves", () -> new LeavesBlock(Block.Properties.create(Material.LEAVES, MaterialColor.YELLOW).hardnessAndResistance(0.2F).sound(SoundType.PLANT).notSolid()));

    public static final RegistryObject<Block> STRIPPED_STRAWBERRY_LOG = BLOCKS.register("stripped_strawberry_log", () -> new ModStrippedLog(BlockProperties.STRAWBERRRY_LOG(true)));
    public static final RegistryObject<Block> STRAWBERRRY_LOG = BLOCKS.register("strawberrry_log", () -> new ModLogBlock(STRIPPED_STRAWBERRY_LOG, MaterialColor.PINK, BlockProperties.STRAWBERRRY_LOG(false)));
    public static final RegistryObject<Block> STRAWBERRY_PLANKS = BLOCKS.register("strawberry_planks", ModPlanks::new);
    public static final RegistryObject<Block> STRAWBERRY_STAIRS = BLOCKS.register("strawberry_stairs", () -> new StairsBlock(() -> ModBlock.STRAWBERRY_PLANKS.get().getDefaultState(), Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> STRAWBERRY_SLAB = BLOCKS.register("strawberry_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRAWBERRY_FENCE = BLOCKS.register("strawberry_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.PINK).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRAWBERRY_FENCE_GATE = BLOCKS.register("strawberry_fence_gate", () -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.PINK).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRAWBERRY_DOOR = BLOCKS.register("strawberry_door", (() -> new ModDoorBlock(Block.Properties.from(Blocks.OAK_DOOR))));
    public static final RegistryObject<Block> STRAWBERRY_TRAPDOOR = BLOCKS.register("strawberry_trapdoor", () -> new ModTrapDoor(Block.Properties.create(Material.WOOD, MaterialColor.PINK).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));

    public static final RegistryObject<Block> STRIPPED_SWEET_LOG = BLOCKS.register("stripped_sweet_log", () -> new ModStrippedLog(BlockProperties.SWEET_LOG(true)));
    public static final RegistryObject<Block> SWEET_LOG = BLOCKS.register("sweet_log", () -> new ModLogBlock(STRIPPED_SWEET_LOG, MaterialColor.PINK, BlockProperties.SWEET_LOG(false)));
    public static final RegistryObject<Block> SWEET_PLANKS = BLOCKS.register("sweet_planks", ModPlanks::new);
    public static final RegistryObject<Block> SWEET_STAIRS = BLOCKS.register("sweet_stairs", () -> new StairsBlock(() -> ModBlock.SWEET_PLANKS.get().getDefaultState(), Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> SWEET_SLAB = BLOCKS.register("sweet_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SWEET_FENCE = BLOCKS.register("sweet_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.PINK).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SWEET_FENCE_GATE = BLOCKS.register("sweet_fence_gate", () -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.PINK).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SWEET_DOOR = BLOCKS.register("sweet_door", (() -> new ModDoorBlock(Block.Properties.from(Blocks.OAK_DOOR))));
    public static final RegistryObject<Block> SWEET_TRAPDOOR = BLOCKS.register("sweet_trapdoor", () -> new ModTrapDoor(Block.Properties.create(Material.WOOD, MaterialColor.PINK).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));

    public static final RegistryObject<Block> STRIPPED_WISP_LOG = BLOCKS.register("stripped_wisp_log", () -> new ModStrippedLog(BlockProperties.MYSTIC_LOG(true)));
    public static final RegistryObject<Block> WISP_LOG = BLOCKS.register("wisp_log", () -> new ModLogBlock(STRIPPED_WISP_LOG, MaterialColor.PURPLE, BlockProperties.WISP_LOG(false)));
    public static final RegistryObject<Block> WISP_PLANKS = BLOCKS.register("wisp_planks", ModPlanks::new);
    public static final RegistryObject<Block> WISP_STAIRS = BLOCKS.register("wisp_stairs", () -> new StairsBlock(() -> ModBlock.WISP_PLANKS.get().getDefaultState(), Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> WISP_SLAB = BLOCKS.register("wisp_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.PURPLE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> WISP_FENCE = BLOCKS.register("wisp_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.PURPLE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> WISP_FENCE_GATE = BLOCKS.register("wisp_fence_gate", () -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.PURPLE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> WISP_DOOR = BLOCKS.register("wisp_door", (() -> new ModDoorBlock(Block.Properties.from(Blocks.OAK_DOOR))));
    public static final RegistryObject<Block> WISP_TRAPDOOR = BLOCKS.register("wisp_trapdoor", () -> new ModTrapDoor(Block.Properties.create(Material.WOOD, MaterialColor.PURPLE).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));

    public static final RegistryObject<Block> STRIPPED_LAVENDER_LOG = BLOCKS.register("stripped_lavender_log", () -> new ModStrippedLog(BlockProperties.LAVENDER_LOG(true)));
    public static final RegistryObject<Block> LAVENDER_LOG = BLOCKS.register("lavender_log", () -> new ModLogBlock(STRIPPED_LAVENDER_LOG, MaterialColor.PURPLE, BlockProperties.LAVENDER_LOG(false)));
    public static final RegistryObject<Block> LAVENDER_PLANKS = BLOCKS.register("lavender_planks", ModPlanks::new);
    public static final RegistryObject<Block> LAVENDER_STAIRS = BLOCKS.register("lavender_stairs", () -> new StairsBlock(() -> ModBlock.LAVENDER_PLANKS.get().getDefaultState(), Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> LAVENDER_SLAB = BLOCKS.register("lavender_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LAVENDER_FENCE = BLOCKS.register("lavender_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.PURPLE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LAVENDER_FENCE_GATE = BLOCKS.register("lavender_fence_gate", () -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.PURPLE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LAVENDER_DOOR = BLOCKS.register("lavender_door", (() -> new ModDoorBlock(Block.Properties.from(Blocks.OAK_DOOR))));
    public static final RegistryObject<Block> LAVENDER_TRAPDOOR = BLOCKS.register("lavender_trapdoor", () -> new ModTrapDoor(Block.Properties.create(Material.WOOD, MaterialColor.PURPLE).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));

    public static final RegistryObject<Block> STRIPPED_FROSTED_LOG = BLOCKS.register("stripped_frosted_log", () -> new ModStrippedLog(BlockProperties.FROSTED_LOG(true)));
    public static final RegistryObject<Block> FROSTED_LOG = BLOCKS.register("frosted_log", () -> new ModLogBlock(STRIPPED_FROSTED_LOG, MaterialColor.LIGHT_BLUE, BlockProperties.FROSTED_LOG(false)));
    public static final RegistryObject<Block> FROSTED_PLANKS = BLOCKS.register("frosted_planks", ModPlanks::new);
    public static final RegistryObject<Block> FROSTED_STAIRS = BLOCKS.register("frosted_stairs", () -> new StairsBlock(() -> ModBlock.FROSTED_PLANKS.get().getDefaultState(), Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> FROSTED_SLAB = BLOCKS.register("frosted_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.LIGHT_BLUE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> FROSTED_FENCE = BLOCKS.register("frosted_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.LIGHT_BLUE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> FROSTED_FENCE_GATE = BLOCKS.register("frosted_fence_gate", () -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.LIGHT_BLUE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> FROSTED_DOOR = BLOCKS.register("frosted_door", (() -> new ModDoorBlock(Block.Properties.from(Blocks.OAK_DOOR))));
    public static final RegistryObject<Block> FROSTED_TRAPDOOR = BLOCKS.register("frosted_trapdoor", () -> new ModTrapDoor(Block.Properties.create(Material.WOOD, MaterialColor.LIGHT_BLUE).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));

    public static final RegistryObject<Block> STRIPPED_TROPICAL_LOG = BLOCKS.register("stripped_tropical_log", () -> new ModStrippedLog(BlockProperties.TROPICAL_LOG(true)));
    public static final RegistryObject<Block> TROPICAL_LOG = BLOCKS.register("tropical_log", () -> new ModLogBlock(STRIPPED_TROPICAL_LOG, MaterialColor.BLUE, BlockProperties.TROPICAL_LOG(false)));
    public static final RegistryObject<Block> TROPICAL_PLANKS = BLOCKS.register("tropical_planks", ModPlanks::new);
    public static final RegistryObject<Block> TROPICAL_STAIRS = BLOCKS.register("tropical_stairs", () -> new StairsBlock(() -> ModBlock.TROPICAL_PLANKS.get().getDefaultState(), Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> TROPICAL_SLAB = BLOCKS.register("tropical_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> TROPICAL_FENCE = BLOCKS.register("tropical_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLUE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> TROPICAL_FENCE_GATE = BLOCKS.register("tropical_fence_gate", () -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLUE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> TROPICAL_DOOR = BLOCKS.register("tropical_door", (() -> new ModDoorBlock(Block.Properties.from(Blocks.OAK_DOOR))));
    public static final RegistryObject<Block> TROPICAL_TRAPDOOR = BLOCKS.register("tropical_trapdoor", () -> new ModTrapDoor(Block.Properties.create(Material.WOOD, MaterialColor.BLUE).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));

    public static final RegistryObject<Block> STRIPPED_SEAFOAM_LOG = BLOCKS.register("stripped_seafoam_log", () -> new ModStrippedLog(BlockProperties.SEAFOAM_LOG(true)));
    public static final RegistryObject<Block> SEAFOAM_LOG = BLOCKS.register("seafoam_log", () -> new ModLogBlock(STRIPPED_SEAFOAM_LOG, MaterialColor.CYAN, BlockProperties.SEAFOAM_LOG(false)));
    public static final RegistryObject<Block> SEAFOAM_PLANKS = BLOCKS.register("seafoam_planks", ModPlanks::new);
    public static final RegistryObject<Block> SEAFOAM_STAIRS = BLOCKS.register("seafoam_stairs", () -> new StairsBlock(() -> ModBlock.SEAFOAM_PLANKS.get().getDefaultState(), Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> SEAFOAM_SLAB = BLOCKS.register("seafoam_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.CYAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SEAFOAM_FENCE = BLOCKS.register("seafoam_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.CYAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SEAFOAM_FENCE_GATE = BLOCKS.register("seafoam_fence_gate", () -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.CYAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SEAFOAM_DOOR = BLOCKS.register("seafoam_door", (() -> new ModDoorBlock(Block.Properties.from(Blocks.OAK_DOOR))));
    public static final RegistryObject<Block> SEAFOAM_TRAPDOOR = BLOCKS.register("seafoam_trapdoor", () -> new ModTrapDoor(Block.Properties.create(Material.WOOD, MaterialColor.CYAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));

    public static final RegistryObject<Block> STRIPPED_EVERGREEN_LOG = BLOCKS.register("stripped_evergreen_log", () -> new ModStrippedLog(BlockProperties.EVERGREEN_LOG(true)));
    public static final RegistryObject<Block> EVERGREEN_LOG = BLOCKS.register("evergreen_log", () -> new ModLogBlock(STRIPPED_EVERGREEN_LOG, MaterialColor.LIME, BlockProperties.EVERGREEN_LOG(false)));
    public static final RegistryObject<Block> EVERGREEN_PLANKS = BLOCKS.register("evergreen_planks", ModPlanks::new);
    public static final RegistryObject<Block> EVERGREEN_STAIRS = BLOCKS.register("evergreen_stairs", () -> new StairsBlock(() -> ModBlock.EVERGREEN_PLANKS.get().getDefaultState(), Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> EVERGREEN_SLAB = BLOCKS.register("evergreen_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.LIME).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> EVERGREEN_FENCE = BLOCKS.register("evergreen_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.LIME).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> EVERGREEN_FENCE_GATE = BLOCKS.register("evergreen_fence_gate", () -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.LIME).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> EVERGREEN_DOOR = BLOCKS.register("evergreen_door", (() -> new ModDoorBlock(Block.Properties.from(Blocks.OAK_DOOR))));
    public static final RegistryObject<Block> EVERGREEN_TRAPDOOR = BLOCKS.register("evergreen_trapdoor", () -> new ModTrapDoor(Block.Properties.create(Material.WOOD, MaterialColor.LIME).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));

    public static final RegistryObject<Block> STRIPPED_DANDELION_LOG = BLOCKS.register("stripped_dandelion_log", () -> new ModStrippedLog(BlockProperties.DANDELION_LOG(true)));
    public static final RegistryObject<Block> DANDELION_LOG = BLOCKS.register("dandelion_log", () -> new ModLogBlock(STRIPPED_DANDELION_LOG, MaterialColor.YELLOW, BlockProperties.DANDELION_LOG(false)));
    public static final RegistryObject<Block> DANDELION_PLANKS = BLOCKS.register("dandelion_planks", ModPlanks::new);
    public static final RegistryObject<Block> DANDELION_STAIRS = BLOCKS.register("dandelion_stairs", () -> new StairsBlock(() -> ModBlock.DANDELION_PLANKS.get().getDefaultState(), Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> DANDELION_SLAB = BLOCKS.register("dandelion_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.YELLOW).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DANDELION_FENCE = BLOCKS.register("dandelion_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.YELLOW).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DANDELION_FENCE_GATE = BLOCKS.register("dandelion_fence_gate", () -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.YELLOW).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DANDELION_DOOR = BLOCKS.register("dandelion_door", (() -> new ModDoorBlock(Block.Properties.from(Blocks.OAK_DOOR))));
    public static final RegistryObject<Block> DANDELION_TRAPDOOR = BLOCKS.register("dandelion_trapdoor", () -> new ModTrapDoor(Block.Properties.create(Material.WOOD, MaterialColor.YELLOW).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));

    //Flowers
    public static final RegistryObject<Block> LAVENDER = BLOCKS.register("lavender", () -> new ModFlower(Effects.HEALTH_BOOST, 9, Block.Properties.create(Material.PLANTS, MaterialColor.PURPLE).doesNotBlockMovement().hardnessAndResistance(0F).sound(SoundType.PLANT)));
    public static final RegistryObject<Block> PASSION_ROSE = BLOCKS.register("passion_rose", () -> new FlowerBlock(Effects.REGENERATION, 9, Block.Properties.create(Material.PLANTS, MaterialColor.LIGHT_BLUE).doesNotBlockMovement().hardnessAndResistance(0F).sound(SoundType.PLANT)));

    //Plants
    public static final RegistryObject<Block> SWEET_STRAWBERRY_BUSH = BLOCKS.register("sweet_strawberry_bush", () -> new SweetStrawberryBushBlock(Block.Properties.create(Material.PLANTS).tickRandomly().doesNotBlockMovement().sound(SoundType.SWEET_BERRY_BUSH)));
    public static final RegistryObject<Block> STRAWBERRY_BUSH = BLOCKS.register("strawberry_bush", () -> new StrawberryBushBlock(Block.Properties.create(Material.PLANTS).tickRandomly().doesNotBlockMovement().sound(SoundType.SWEET_BERRY_BUSH)));
    public static final RegistryObject<Block> FLOWERING_VINES = BLOCKS.register("flowering_vines", () -> new VineBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.2F).sound(SoundType.PLANT)));

    //Saplings
    public static final RegistryObject<Block> STRAWBERRY_BLOSSOM_SAPLING = BLOCKS.register("strawberry_blossom_sapling", () -> new ModSapling(StrawberryBlossomTree::new, Block.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> SWEET_BLOSSOM_SAPLING = BLOCKS.register("sweet_blossom_sapling", () -> new ModSapling(SweetBlossomTree::new, Block.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> WISP_BLOSSOM_SAPLING = BLOCKS.register("wisp_blossom_sapling", () -> new ModSapling(WispBlossomTree::new, Block.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> LAVENDER_BLOSSOM_SAPLING = BLOCKS.register("lavender_blossom_sapling", () -> new ModSapling(LavenderTree::new, Block.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> FROSTED_SAPLING = BLOCKS.register("frosted_sapling", () -> new ModSapling(EvergreenTree::new, Block.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> SEAFOAM_SAPLING = BLOCKS.register("seafoam_sapling", () -> new ModSapling(SeaFoamTree::new, Block.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> TROPICAL_SAPLING = BLOCKS.register("tropical_sapling", () -> new ModSapling(TropicalTree::new, Block.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> EVERGREEN_SAPLING = BLOCKS.register("evergreen_sapling", () -> new ModSapling(EvergreenTree::new, Block.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> DANDELION_SAPLING = BLOCKS.register("dandelion_sapling", () -> new ModSapling(DandelionTree::new, Block.Properties.from(Blocks.OAK_SAPLING)));

    //Ores
    public static final RegistryObject<Block> SERENE_CRYSTAL_ORE = BLOCKS.register("serene_crystal_ore", () -> new ModOre(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestLevel(3).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> SWEET_CRYSTAL_ORE = BLOCKS.register("sweet_crystal_ore", () -> new ModOre(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestLevel(3).harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<Block> SERENE_CRYSTAL_BLOCK = BLOCKS.register("serene_crystal_block", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.PURPLE).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(3)));
    public static final RegistryObject<Block> SWEET_CRYSTAL_BLOCK = BLOCKS.register("sweet_crystal_block", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.PURPLE).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(3)));

}
