package com.jayhill.mysticsbiomes.init;

import com.jayhill.mysticsbiomes.MysticsBiomes;
import com.jayhill.mysticsbiomes.common.block.MysticLogBlock;
import com.jayhill.mysticsbiomes.common.block.StrawberryBushBlock;
import com.jayhill.mysticsbiomes.common.world.gen.trees.*;
import net.minecraft.block.*;
import net.minecraft.block.AbstractBlock.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MysticBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MysticsBiomes.MOD_ID);

    /** Strawberry Fields */
    public static final RegistryObject<Block> STRAWBERRY_BLOSSOM_LEAVES = BLOCKS.register("strawberry_blossom_leaves", () -> new LeavesBlock(Properties.from(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> STRAWBERRY_BLOSSOM_SAPLING = BLOCKS.register("strawberry_blossom_sapling", () -> new SaplingBlock(new StrawberryBlossomTree(), Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> SWEET_BLOSSOM_LEAVES = BLOCKS.register("sweet_blossom_leaves", () -> new LeavesBlock(Properties.from(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> SWEET_BLOSSOM_SAPLING = BLOCKS.register("sweet_blossom_sapling", () -> new SaplingBlock(new SweetBlossomTree(), Properties.from(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> STRAWBERRY_BUSH = BLOCKS.register("strawberry_bush", () -> new StrawberryBushBlock(Properties.from(Blocks.SWEET_BERRY_BUSH)));

    public static final RegistryObject<Block> STRAWBERRY_PLANKS = BLOCKS.register("strawberry_planks", () -> new Block(Properties.create(Material.WOOD, MaterialColor.PINK).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRAWBERRY_STAIRS = BLOCKS.register("strawberry_stairs", () -> new StairsBlock(STRAWBERRY_PLANKS.get().getDefaultState(), Properties.from(STRAWBERRY_PLANKS.get())));
    public static final RegistryObject<Block> STRAWBERRY_SLAB = BLOCKS.register("strawberry_slab", () -> new SlabBlock(Properties.from(STRAWBERRY_PLANKS.get())));
    public static final RegistryObject<Block> STRAWBERRY_FENCE = BLOCKS.register("strawberry_fence", () -> new FenceBlock(Properties.from(STRAWBERRY_PLANKS.get())));
    public static final RegistryObject<Block> STRAWBERRY_FENCE_GATE = BLOCKS.register("strawberry_fence_gate", () -> new FenceGateBlock(Properties.from(STRAWBERRY_PLANKS.get())));
    public static final RegistryObject<Block> STRAWBERRY_DOOR = BLOCKS.register("strawberry_door", () -> new DoorBlock(Properties.from(STRAWBERRY_PLANKS.get()).notSolid()));
    public static final RegistryObject<Block> STRAWBERRY_TRAPDOOR = BLOCKS.register("strawberry_trapdoor", () -> new TrapDoorBlock(Properties.from(STRAWBERRY_PLANKS.get()).notSolid()));
    public static final RegistryObject<Block> STRIPPED_STRAWBERRY_LOG = BLOCKS.register("stripped_strawberry_log", () -> new RotatedPillarBlock(Properties.from(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_STRAWBERRY_WOOD = BLOCKS.register("stripped_strawberry_wood", () -> new RotatedPillarBlock(Properties.from(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> STRAWBERRY_LOG = BLOCKS.register("strawberry_log", () -> new MysticLogBlock(STRIPPED_STRAWBERRY_LOG, Properties.from(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRAWBERRY_WOOD = BLOCKS.register("strawberry_wood", () -> new MysticLogBlock(STRIPPED_STRAWBERRY_WOOD, Properties.from(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> STRAWBERRY_CAKE = BLOCKS.register("strawberry_cake", () -> new CakeBlock(Properties.from(Blocks.CAKE)));
    
    public static final RegistryObject<Block> POTTED_STRAWBERRY_BLOSSOM_SAPLING = BLOCKS.register("potted_strawberry_blossom_sapling", () -> new FlowerPotBlock(STRAWBERRY_BLOSSOM_SAPLING.get(), Properties.from(Blocks.POTTED_OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_SWEET_BLOSSOM_SAPLING = BLOCKS.register("potted_sweet_blossom_sapling", () -> new FlowerPotBlock(SWEET_BLOSSOM_SAPLING.get(), Properties.from(Blocks.POTTED_OAK_SAPLING)));

}