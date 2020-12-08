package com.meepshadow.mysticsbiomes.core.registry;

import com.meepshadow.mysticsbiomes.common.block.*;
import com.meepshadow.mysticsbiomes.common.block.wood.*;
import com.meepshadow.mysticsbiomes.common.world.trees.*;
import com.meepshadow.mysticsbiomes.core.MysticsBiomes;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MysticsBiomes.MOD_ID);

    //Ethereal
    public static final RegistryObject<Block> ETHEREAL_LEAVES = BLOCKS.register("ethereal_leaves", () -> new LeavesBlock(BlockProperties.ETHEREAL_LEAVES(MaterialColor.CYAN).notSolid()));
    public static final RegistryObject<Block> ETHEREAL_LEAF_CARPET = BLOCKS.register("ethereal_leaf_carpet", () -> new LeafCarpetBlock(BlockProperties.ETHEREAL_LEAVES(MaterialColor.CYAN).notSolid()));
    public static final RegistryObject<Block> STRIPPED_ETHEREAL_LOG = BLOCKS.register("stripped_ethereal_log", () -> new ModStrippedLog(BlockProperties.ETHEREAL_LOG(true)));
    public static final RegistryObject<Block> ETHEREAL_LOG = BLOCKS.register("ethereal_log", () -> new ModLogBlock(STRIPPED_ETHEREAL_LOG, MaterialColor.CYAN, BlockProperties.ETHEREAL_LOG(false)));
    public static final RegistryObject<Block> STRIPPED_ETHEREAL_WOOD = BLOCKS.register("stripped_ethereal_wood", () -> new StrippedWoodBlock(BlockProperties.ETHEREAL_WOOD(true)));
    public static final RegistryObject<Block> ETHEREAL_WOOD = BLOCKS.register("ethereal_wood", () -> new WoodBlock(STRIPPED_ETHEREAL_WOOD, BlockProperties.ETHEREAL_WOOD(false)));
    public static final RegistryObject<Block> ETHEREAL_PLANKS = BLOCKS.register("ethereal_planks", ModPlanks::new);
    public static final RegistryObject<Block> VERTICAL_ETHEREAL_PLANKS = BLOCKS.register("vertical_ethereal_planks", ModVerticalPlanks::new);
    public static final RegistryObject<Block> ETHEREAL_STAIRS = BLOCKS.register("ethereal_stairs", () -> new StairsBlock(() -> ModBlocks.ETHEREAL_PLANKS.get().getDefaultState(), Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> ETHEREAL_SLAB = BLOCKS.register("ethereal_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.CYAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ETHEREAL_FENCE = BLOCKS.register("ethereal_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.CYAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ETHEREAL_FENCE_GATE = BLOCKS.register("ethereal_fence_gate", () -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.CYAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ETHEREAL_DOOR = BLOCKS.register("ethereal_door", (() -> new ModDoorBlock(Block.Properties.from(Blocks.OAK_DOOR))));
    public static final RegistryObject<Block> ETHEREAL_TRAPDOOR = BLOCKS.register("ethereal_trapdoor", () -> new ModTrapDoor(Block.Properties.create(Material.WOOD, MaterialColor.CYAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> ETHEREAL_VERTICAL_SLAB = BLOCKS.register("ethereal_vertical_slab", () -> new VerticalSlabBlock(BlockProperties.ETHEREAL_PLANKS));

    //Lavender
    public static final RegistryObject<Block> LAVENDER_BLOSSOM_LEAVES = BLOCKS.register("lavender_blossom_leaves", () -> new LeavesBlock(BlockProperties.LAVENDER_BLOSSOM_LEAVES(MaterialColor.PURPLE).notSolid()));
    public static final RegistryObject<Block> LAVENDER_BLOSSOM_LEAF_CARPET = BLOCKS.register("lavender_blossom_leaf_carpet", () -> new LeafCarpetBlock(BlockProperties.LAVENDER_BLOSSOM_LEAVES(MaterialColor.PURPLE).notSolid()));
    public static final RegistryObject<Block> STRIPPED_LAVENDER_LOG = BLOCKS.register("stripped_lavender_log", () -> new ModStrippedLog(BlockProperties.LAVENDER_LOG(true)));
    public static final RegistryObject<Block> LAVENDER_LOG = BLOCKS.register("lavender_log", () -> new ModLogBlock(STRIPPED_LAVENDER_LOG, MaterialColor.PURPLE, BlockProperties.LAVENDER_LOG(false)));
    public static final RegistryObject<Block> STRIPPED_LAVENDER_WOOD = BLOCKS.register("stripped_lavender_wood", () -> new StrippedWoodBlock(BlockProperties.LAVENDER_WOOD(true)));
    public static final RegistryObject<Block> LAVENDER_WOOD = BLOCKS.register("lavender_wood", () -> new WoodBlock(STRIPPED_LAVENDER_WOOD, BlockProperties.LAVENDER_WOOD(false)));
    public static final RegistryObject<Block> LAVENDER_PLANKS = BLOCKS.register("lavender_planks", ModPlanks::new);
    public static final RegistryObject<Block> VERTICAL_LAVENDER_PLANKS = BLOCKS.register("vertical_lavender_planks", ModVerticalPlanks::new);
    public static final RegistryObject<Block> LAVENDER_STAIRS = BLOCKS.register("lavender_stairs", () -> new StairsBlock(() -> ModBlocks.LAVENDER_PLANKS.get().getDefaultState(), Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> LAVENDER_SLAB = BLOCKS.register("lavender_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.PURPLE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LAVENDER_FENCE = BLOCKS.register("lavender_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.PURPLE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LAVENDER_FENCE_GATE = BLOCKS.register("lavender_fence_gate", () -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.PURPLE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LAVENDER_DOOR = BLOCKS.register("lavender_door", (() -> new ModDoorBlock(Block.Properties.from(Blocks.OAK_DOOR))));
    public static final RegistryObject<Block> LAVENDER_TRAPDOOR = BLOCKS.register("lavender_trapdoor", () -> new ModTrapDoor(Block.Properties.create(Material.WOOD, MaterialColor.PURPLE).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> LAVENDER_VERTICAL_SLAB = BLOCKS.register("lavender_vertical_slab", () -> new VerticalSlabBlock(BlockProperties.LAVENDER_PLANKS));

    //Strawberry
    public static final RegistryObject<Block> STRAWBERRY_BLOSSOM_LEAVES = BLOCKS.register("strawberry_blossom_leaves", () -> new LeavesBlock(BlockProperties.STRAWBERRY_BLOSSOM_LEAVES(MaterialColor.PINK).notSolid()));
    public static final RegistryObject<Block> SWEET_BLOSSOM_LEAVES = BLOCKS.register("sweet_blossom_leaves", () -> new LeavesBlock(BlockProperties.SWEET_BLOSSOM_LEAVES(MaterialColor.PINK).notSolid()));
    public static final RegistryObject<Block> STRAWBERRY_BLOSSOM_LEAF_CARPET = BLOCKS.register("strawberry_blossom_leaf_carpet", () -> new LeafCarpetBlock(BlockProperties.STRAWBERRY_BLOSSOM_LEAVES(MaterialColor.PINK).notSolid()));
    public static final RegistryObject<Block> SWEET_BLOSSOM_LEAF_CARPET = BLOCKS.register("sweet_blossom_leaf_carpet", () -> new LeafCarpetBlock(BlockProperties.SWEET_BLOSSOM_LEAVES(MaterialColor.PINK).notSolid()));
    public static final RegistryObject<Block> STRIPPED_STRAWBERRY_LOG = BLOCKS.register("stripped_strawberry_log", () -> new ModStrippedLog(BlockProperties.STRAWBERRRY_LOG(true)));
    public static final RegistryObject<Block> STRAWBERRRY_LOG = BLOCKS.register("strawberrry_log", () -> new ModLogBlock(STRIPPED_STRAWBERRY_LOG, MaterialColor.PINK, BlockProperties.STRAWBERRRY_LOG(false)));
    public static final RegistryObject<Block> STRIPPED_STRAWBERRY_WOOD = BLOCKS.register("stripped_strawberry_wood", () -> new StrippedWoodBlock(BlockProperties.STRAWBERRY_WOOD(true)));
    public static final RegistryObject<Block> STRAWBERRY_WOOD = BLOCKS.register("strawberry_wood", () -> new WoodBlock(STRIPPED_STRAWBERRY_WOOD, BlockProperties.STRAWBERRY_WOOD(false)));
    public static final RegistryObject<Block> STRAWBERRY_PLANKS = BLOCKS.register("strawberry_planks", ModPlanks::new);
    public static final RegistryObject<Block> VERTICAL_STRAWBERRY_PLANKS = BLOCKS.register("vertical_strawberry_planks", ModVerticalPlanks::new);
    public static final RegistryObject<Block> STRAWBERRY_STAIRS = BLOCKS.register("strawberry_stairs", () -> new StairsBlock(() -> ModBlocks.STRAWBERRY_PLANKS.get().getDefaultState(), Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> STRAWBERRY_SLAB = BLOCKS.register("strawberry_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRAWBERRY_FENCE = BLOCKS.register("strawberry_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.PINK).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRAWBERRY_FENCE_GATE = BLOCKS.register("strawberry_fence_gate", () -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.PINK).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRAWBERRY_DOOR = BLOCKS.register("strawberry_door", (() -> new ModDoorBlock(Block.Properties.from(Blocks.OAK_DOOR))));
    public static final RegistryObject<Block> STRAWBERRY_TRAPDOOR = BLOCKS.register("strawberry_trapdoor", () -> new ModTrapDoor(Block.Properties.create(Material.WOOD, MaterialColor.PINK).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> STRAWBERRY_VERTICAL_SLAB = BLOCKS.register("strawberry_vertical_slab", () -> new VerticalSlabBlock(BlockProperties.STRAWBERRY_PLANKS));

    public static final RegistryObject<Block> ORB_MUSHROOM_BLOCK = BLOCKS.register("orb_mushroom_block", () -> new HugeMushroomBlock(Block.Properties.create(Material.WOOD, MaterialColor.MAGENTA).hardnessAndResistance(0.2F).sound(SoundType.WOOD)));

    //Plants
    public static final RegistryObject<Block> STRAWBERRY_BUSH = BLOCKS.register("strawberry_bush", () -> new StrawberryBushBlock(Block.Properties.create(Material.PLANTS).tickRandomly().doesNotBlockMovement().sound(SoundType.SWEET_BERRY_BUSH)));
    public static final RegistryObject<Block> STRAWBERRY_FLOWER = BLOCKS.register("strawberry_flower", () -> new ModFlower(Effects.INSTANT_HEALTH, 4, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)));
    public static final RegistryObject<Block> LAVENDER = BLOCKS.register("lavender", () -> new ModFlower(Effects.REGENERATION, 4, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)));
    public static final RegistryObject<Block> WHITE_DAISY_BUSH = BLOCKS.register("white_daisy_bush", () -> new ModFlower(Effects.INVISIBILITY, 16, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)));
    public static final RegistryObject<Block> PINK_DAISY_BUSH = BLOCKS.register("pink_daisy_bush", () -> new ModFlower(Effects.SLOW_FALLING, 8, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)));
    public static final RegistryObject<Block> STRAWBERRY_CAKE = BLOCKS.register("strawberry_cake", () -> new ModCakeBlock(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH)));
    public static final RegistryObject<Block> ORB_MUSHROOM = BLOCKS.register("orb_mushroom", () -> new OrbMushroomBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT).lightValue(5)));

    //Saplings
    public static final RegistryObject<Block> ETHEREAL_SAPLING = BLOCKS.register("ethereal_sapling", () -> new ModSapling(EtherealTree::new, Block.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> LAVENDER_BLOSSOM_SAPLING = BLOCKS.register("lavender_blossom_sapling", () -> new ModSapling(LavenderBlossomTree::new, Block.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> SWEET_BLOSSOM_SAPLING = BLOCKS.register("sweet_blossom_sapling", () -> new ModSapling(SweetBlossomTree::new, Block.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> STRAWBERRY_BLOSSOM_SAPLING = BLOCKS.register("strawberry_blossom_sapling", () -> new ModSapling(StrawberryBlossomTree::new, Block.Properties.from(Blocks.OAK_SAPLING)));

    //Potted
    public static final RegistryObject<Block> POTTED_ETHEREAL_SAPLING = BLOCKS.register("potted_ethereal_sapling", () -> new ModFlowerPotBlock(ETHEREAL_SAPLING.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));
    public static final RegistryObject<Block> POTTED_LAVENDER_BLOSSOM_SAPLING = BLOCKS.register("potted_lavender_blossom_sapling", () -> new ModFlowerPotBlock(LAVENDER_BLOSSOM_SAPLING.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));
    public static final RegistryObject<Block> POTTED_SWEET_BLOSSOM_SAPLING = BLOCKS.register("potted_sweet_blossom_sapling", () -> new ModFlowerPotBlock(SWEET_BLOSSOM_SAPLING.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));
    public static final RegistryObject<Block> POTTED_STRAWBERRY_BLOSSOM_SAPLING = BLOCKS.register("potted_strawberry_blossom_sapling", () -> new ModFlowerPotBlock(STRAWBERRY_BLOSSOM_SAPLING.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));

    public static final RegistryObject<Block> POTTED_STRAWBERRY_BUSH = BLOCKS.register("potted_strawberry_bush", () -> new ModFlowerPotBlock(STRAWBERRY_BUSH.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));
    public static final RegistryObject<Block> POTTED_LAVENDER = BLOCKS.register("potted_lavender", () -> new ModFlowerPotBlock(LAVENDER.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));
    public static final RegistryObject<Block> POTTED_WHITE_DAISY_BUSH = BLOCKS.register("potted_white_daisy_bush", () -> new ModFlowerPotBlock(WHITE_DAISY_BUSH.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));
    public static final RegistryObject<Block> POTTED_PINK_DAISY_BUSH = BLOCKS.register("potted_pink_daisy_bush", () -> new ModFlowerPotBlock(PINK_DAISY_BUSH.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));
    public static final RegistryObject<Block> POTTED_ORB_MUSHROOM = BLOCKS.register("potted_orb_mushroom", () -> new ModFlowerPotBlock(ORB_MUSHROOM.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid().lightValue(5)));

}
