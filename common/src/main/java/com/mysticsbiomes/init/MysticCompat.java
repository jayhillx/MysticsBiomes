package com.mysticsbiomes.init;

import com.mysticsbiomes.common.block.util.BlockUtils;
import com.mysticsbiomes.datagen.MysticBlockFamilies;
import com.mysticsbiomes.datagen.MysticBlockFamily;
import net.minecraft.world.level.block.Block;

public class MysticCompat {

    public static void registerFlammables() {
        MysticBlockFamilies.getAllFamilies().forEach(MysticCompat::flammableWood);
        flammableLeaves(MysticBlocks.STRAWBERRY_BLOSSOMS.get());
        flammableLeaves(MysticBlocks.LAVENDER_BLOSSOMS.get());
        flammableLeaves(MysticBlocks.PINK_CHERRY_BLOSSOMS.get());
        flammableLeaves(MysticBlocks.WHITE_CHERRY_BLOSSOMS.get());
        flammableLeaves(MysticBlocks.PEACH_LEAVES.get());
        flammableLeaves(MysticBlocks.MAPLE_LEAVES.get());
        flammableLeaves(MysticBlocks.ORANGE_MAPLE_LEAVES.get());
        flammableLeaves(MysticBlocks.YELLOW_MAPLE_LEAVES.get());
        flammableLeaves(MysticBlocks.SEA_SHRUB_LEAVES.get());
        flammablePlants(MysticBlocks.SEA_SHRUB.get());
        flammableLeaves(MysticBlocks.TROPICAL_LEAVES.get());
        flammableLeaves(MysticBlocks.VANILLA_LEAVES.get());
    }

    private static void flammableWood(MysticBlockFamily family) {
        if (family.isFlammable()) {
            family.getVariants().forEach((variant, block) -> {
                switch (variant) {
                    case LOG, SECONDARY_LOG, STRIPPED_LOG, WOOD, SECONDARY_WOOD, STRIPPED_WOOD -> BlockUtils.flammable(block, 5, 5);
                    case PLANKS, STAIRS, SLAB, FENCE, FENCE_GATE, BUTTON, PRESSURE_PLATE, TRAPDOOR, DOOR, SIGN -> BlockUtils.flammable(block, 5, 20);
                }
            });
        }
    }

    private static void flammableLeaves(Block block) {
        BlockUtils.flammable(block, 30, 60);
    }

    private static void flammablePlants(Block block) {
        BlockUtils.flammable(block, 60, 100);
    }

    public static void registerCompostables() {
        BlockUtils.compostable(MysticItems.STRAWBERRY_BLOSSOMS.get(), 0.65F);
        BlockUtils.compostable(MysticItems.STRAWBERRY_BLOSSOM_SAPLING.get(), 0.3F);
        BlockUtils.compostable(MysticItems.LAVENDER_BLOSSOMS.get(), 0.65F);
        BlockUtils.compostable(MysticItems.LAVENDER_BLOSSOM_SAPLING.get(), 0.3F);
        BlockUtils.compostable(MysticItems.PINK_CHERRY_BLOSSOMS.get(), 0.65F);
        BlockUtils.compostable(MysticItems.PINK_CHERRY_BLOSSOM_SAPLING.get(), 0.3F);
        BlockUtils.compostable(MysticItems.WHITE_CHERRY_BLOSSOMS.get(), 0.65F);
        BlockUtils.compostable(MysticItems.WHITE_CHERRY_BLOSSOM_SAPLING.get(), 0.3F);
        BlockUtils.compostable(MysticItems.PEACH_LEAVES.get(), 0.3F);
        BlockUtils.compostable(MysticItems.PEACH_SAPLING.get(), 0.3F);
        BlockUtils.compostable(MysticItems.MAPLE_LEAVES.get(), 0.3F);
        BlockUtils.compostable(MysticItems.MAPLE_SAPLING.get(), 0.3F);
        BlockUtils.compostable(MysticItems.SPICED_MAPLE_LEAVES.get(), 0.3F);
        BlockUtils.compostable(MysticItems.SPICED_MAPLE_SAPLING.get(), 0.3F);
        BlockUtils.compostable(MysticItems.ORANGE_MAPLE_LEAVES.get(), 0.3F);
        BlockUtils.compostable(MysticItems.ORANGE_MAPLE_SAPLING.get(), 0.3F);
        BlockUtils.compostable(MysticItems.YELLOW_MAPLE_LEAVES.get(), 0.3F);
        BlockUtils.compostable(MysticItems.YELLOW_MAPLE_SAPLING.get(), 0.3F);
        BlockUtils.compostable(MysticItems.SEA_SHRUB_LEAVES.get(), 0.3F);
        BlockUtils.compostable(MysticItems.SEA_SHRUB.get(), 0.3F);
        BlockUtils.compostable(MysticItems.TROPICAL_LEAVES.get(), 0.3F);
        BlockUtils.compostable(MysticItems.TROPICAL_SAPLING.get(), 0.3F);
        BlockUtils.compostable(MysticItems.VANILLA_LEAVES.get(), 0.3F);
    }

    public static void registerStrippables() {
        BlockUtils.strippable(MysticBlocks.STRAWBERRY_LOG.get(), MysticBlocks.STRIPPED_STRAWBERRY_LOG.get());
        BlockUtils.strippable(MysticBlocks.STRAWBERRY_WOOD.get(), MysticBlocks.STRIPPED_STRAWBERRY_WOOD.get());
        BlockUtils.strippable(MysticBlocks.BLACK_CHERRY_LOG.get(), MysticBlocks.STRIPPED_BLACK_CHERRY_LOG.get());
        BlockUtils.strippable(MysticBlocks.BLACK_CHERRY_WOOD.get(), MysticBlocks.STRIPPED_BLACK_CHERRY_WOOD.get());
        BlockUtils.strippable(MysticBlocks.LAVENDER_LOG.get(), MysticBlocks.STRIPPED_LAVENDER_LOG.get());
        BlockUtils.strippable(MysticBlocks.LAVENDER_WOOD.get(), MysticBlocks.STRIPPED_LAVENDER_WOOD.get());
        BlockUtils.strippable(MysticBlocks.VANILLA_LOG.get(), MysticBlocks.STRIPPED_VANILLA_LOG.get());
        BlockUtils.strippable(MysticBlocks.VANILLA_WOOD.get(), MysticBlocks.STRIPPED_VANILLA_WOOD.get());
        BlockUtils.strippable(MysticBlocks.PEACH_LOG.get(), MysticBlocks.STRIPPED_PEACH_LOG.get());
        BlockUtils.strippable(MysticBlocks.PEACH_WOOD.get(), MysticBlocks.STRIPPED_PEACH_WOOD.get());
        BlockUtils.strippable(MysticBlocks.MAPLE_LOG.get(), MysticBlocks.STRIPPED_MAPLE_LOG.get());
        BlockUtils.strippable(MysticBlocks.MAPLE_WOOD.get(), MysticBlocks.STRIPPED_MAPLE_WOOD.get());
        BlockUtils.strippable(MysticBlocks.WHITE_MAPLE_LOG.get(), MysticBlocks.STRIPPED_MAPLE_LOG.get());
        BlockUtils.strippable(MysticBlocks.WHITE_MAPLE_WOOD.get(), MysticBlocks.STRIPPED_MAPLE_WOOD.get());
        BlockUtils.strippable(MysticBlocks.SPRING_BAMBOO_BLOCK.get(), MysticBlocks.STRIPPED_SPRING_BAMBOO_BLOCK.get());
        BlockUtils.strippable(MysticBlocks.SEA_FOAM_LOG.get(), MysticBlocks.STRIPPED_SEA_FOAM_LOG.get());
        BlockUtils.strippable(MysticBlocks.SEA_FOAM_WOOD.get(), MysticBlocks.STRIPPED_SEA_FOAM_WOOD.get());
        BlockUtils.strippable(MysticBlocks.TROPICAL_LOG.get(), MysticBlocks.STRIPPED_TROPICAL_LOG.get());
        BlockUtils.strippable(MysticBlocks.TROPICAL_WOOD.get(), MysticBlocks.STRIPPED_TROPICAL_WOOD.get());
    }

}