package com.mysticsbiomes.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

import static com.mysticsbiomes.MysticsBiomes.REGISTRY;

public class MysticBlocks {

    public static Supplier<Block> STRAWBERRY_PLANKS;
    
    public static void registerBlocks() {
        STRAWBERRY_PLANKS = register("strawberry_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    }

    private static Supplier<Block> register(String name, Supplier<Block> block) {
        return REGISTRY.register(BuiltInRegistries.BLOCK, name, block);
    }

}