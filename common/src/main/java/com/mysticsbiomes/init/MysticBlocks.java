package com.mysticsbiomes.init;

import com.mysticsbiomes.common.block.grower.MysticTreeGrowers;
import com.mysticsbiomes.common.block.state.MysticBlockSetTypes;
import com.mysticsbiomes.common.block.state.MysticWoodTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Supplier;

import static com.mysticsbiomes.MysticsBiomes.REGISTRY;
import static com.mysticsbiomes.common.block.BlockTemplate.*;

public class MysticBlocks {

    public static Supplier<Block> STRAWBERRY_BLOSSOMS;
    public static Supplier<Block> STRAWBERRY_BLOSSOM_SAPLING;
    public static Supplier<Block> STRAWBERRY_LOG;
    public static Supplier<Block> STRIPPED_STRAWBERRY_LOG;
    public static Supplier<Block> STRAWBERRY_WOOD;
    public static Supplier<Block> STRIPPED_STRAWBERRY_WOOD;
    public static Supplier<Block> STRAWBERRY_PLANKS;
    public static Supplier<Block> STRAWBERRY_STAIRS;
    public static Supplier<Block> STRAWBERRY_SLAB;
    public static Supplier<Block> STRAWBERRY_FENCE;
    public static Supplier<Block> STRAWBERRY_FENCE_GATE;
    public static Supplier<Block> STRAWBERRY_BUTTON;
    public static Supplier<Block> STRAWBERRY_PRESSURE_PLATE;
    public static Supplier<Block> STRAWBERRY_TRAPDOOR;
    public static Supplier<Block> STRAWBERRY_DOOR;
    public static Supplier<Block> STRAWBERRY_SIGN;
    public static Supplier<Block> STRAWBERRY_WALL_SIGN;
    public static Supplier<Block> STRAWBERRY_HANGING_SIGN;
    public static Supplier<Block> STRAWBERRY_WALL_HANGING_SIGN;

    public static void registerBlocks() {
        STRAWBERRY_BLOSSOMS = register("strawberry_blossoms", () -> new LeavesBlock(leafProperties(SoundType.AZALEA_LEAVES)));
        STRAWBERRY_BLOSSOM_SAPLING = register("strawberry_blossom_sapling", () -> sapling(new MysticTreeGrowers(TreeFeatures.OAK)));
        STRAWBERRY_LOG = register("strawberry_log", () -> log(MapColor.COLOR_PINK, MapColor.COLOR_BROWN));
        STRIPPED_STRAWBERRY_LOG = register("stripped_strawberry_log", () -> log(MapColor.COLOR_PINK));
        STRAWBERRY_WOOD = register("strawberry_wood", () -> log(MapColor.COLOR_PINK, MapColor.COLOR_BROWN));
        STRIPPED_STRAWBERRY_WOOD = register("stripped_strawberry_wood", () -> log(MapColor.COLOR_PINK));
        STRAWBERRY_PLANKS = register("strawberry_planks", () -> planks(MapColor.COLOR_PINK));
        STRAWBERRY_STAIRS = register("strawberry_stairs", () -> stairs(STRAWBERRY_PLANKS.get()));
        STRAWBERRY_SLAB = register("strawberry_slab", () -> slab(STRAWBERRY_PLANKS.get()));
        STRAWBERRY_FENCE = register("strawberry_fence", () -> fence(STRAWBERRY_PLANKS.get()));
        STRAWBERRY_FENCE_GATE = register("strawberry_fence_gate", () -> fenceGate(STRAWBERRY_PLANKS.get(), MysticWoodTypes.STRAWBERRY));
        STRAWBERRY_BUTTON = register("strawberry_button", () -> button(MysticBlockSetTypes.STRAWBERRY));
        STRAWBERRY_PRESSURE_PLATE = register("strawberry_pressure_plate", () -> pressurePlate(STRAWBERRY_PLANKS.get(), MysticBlockSetTypes.STRAWBERRY));
        STRAWBERRY_TRAPDOOR = register("strawberry_trapdoor", () -> trapdoor(STRAWBERRY_PLANKS.get(), MysticBlockSetTypes.STRAWBERRY));
        STRAWBERRY_DOOR = register("strawberry_door", () -> door(STRAWBERRY_PLANKS.get(), MysticBlockSetTypes.STRAWBERRY));
        STRAWBERRY_SIGN = register("strawberry_sign", () -> sign(STRAWBERRY_PLANKS.get(), MysticWoodTypes.STRAWBERRY));
        STRAWBERRY_WALL_SIGN = register("strawberry_wall_sign", () -> wallSign(STRAWBERRY_SIGN.get(), MysticWoodTypes.STRAWBERRY));
        STRAWBERRY_HANGING_SIGN = register("strawberry_hanging_sign", () -> hangingSign(STRAWBERRY_PLANKS.get(), MysticWoodTypes.STRAWBERRY));
        STRAWBERRY_WALL_HANGING_SIGN = register("strawberry_wall_hanging_sign", () -> wallHangingSign(STRAWBERRY_HANGING_SIGN.get(), MysticWoodTypes.STRAWBERRY));
    }

    private static Supplier<Block> register(String name, Supplier<Block> block) {
        return REGISTRY.register(BuiltInRegistries.BLOCK, name, block);
    }

}