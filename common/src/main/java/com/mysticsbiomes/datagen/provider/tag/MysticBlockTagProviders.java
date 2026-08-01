package com.mysticsbiomes.datagen.provider.tag;

import com.mysticsbiomes.datagen.MysticBlockFamilies;
import com.mysticsbiomes.datagen.MysticBlockFamily;
import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.VanillaBlockTagsProvider;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class MysticBlockTagProviders extends VanillaBlockTagsProvider {

    public MysticBlockTagProviders(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        MysticBlockFamilies.getAllFamilies().forEach(this::generateFor);
        this.tag(MysticTags.Blocks.STRAWBERRY_LOGS).add(
                MysticBlocks.STRAWBERRY_LOG.get(),
                MysticBlocks.STRAWBERRY_WOOD.get(),
                MysticBlocks.STRIPPED_STRAWBERRY_LOG.get(),
                MysticBlocks.STRIPPED_STRAWBERRY_WOOD.get()
        );
        this.tag(MysticTags.Blocks.BLACK_CHERRY_LOGS).add(
                MysticBlocks.BLACK_CHERRY_LOG.get(),
                MysticBlocks.BLACK_CHERRY_WOOD.get(),
                MysticBlocks.STRIPPED_BLACK_CHERRY_LOG.get(),
                MysticBlocks.STRIPPED_BLACK_CHERRY_WOOD.get()
        );
        this.tag(MysticTags.Blocks.LAVENDER_LOGS).add(
                MysticBlocks.LAVENDER_LOG.get(),
                MysticBlocks.LAVENDER_WOOD.get(),
                MysticBlocks.STRIPPED_LAVENDER_LOG.get(),
                MysticBlocks.STRIPPED_LAVENDER_WOOD.get()
        );
        this.tag(MysticTags.Blocks.VANILLA_LOGS).add(
                MysticBlocks.VANILLA_LOG.get(),
                MysticBlocks.VANILLA_WOOD.get(),
                MysticBlocks.STRIPPED_VANILLA_LOG.get(),
                MysticBlocks.STRIPPED_VANILLA_WOOD.get()
        );
        this.tag(MysticTags.Blocks.PEACH_LOGS).add(
                MysticBlocks.PEACH_LOG.get(),
                MysticBlocks.PEACH_WOOD.get(),
                MysticBlocks.STRIPPED_PEACH_LOG.get(),
                MysticBlocks.STRIPPED_PEACH_WOOD.get()
        );
        this.tag(MysticTags.Blocks.MAPLE_LOGS).add(
                MysticBlocks.MAPLE_LOG.get(),
                MysticBlocks.MAPLE_WOOD.get(),
                MysticBlocks.WHITE_MAPLE_LOG.get(),
                MysticBlocks.WHITE_MAPLE_WOOD.get(),
                MysticBlocks.STRIPPED_MAPLE_LOG.get(),
                MysticBlocks.STRIPPED_MAPLE_WOOD.get()
        );
        this.tag(MysticTags.Blocks.SPRING_LOGS).add(
                MysticBlocks.SPRING_BAMBOO_BLOCK.get(),
                MysticBlocks.STRIPPED_SPRING_BAMBOO_BLOCK.get()
        );
        this.tag(MysticTags.Blocks.SEA_FOAM_LOGS).add(
                MysticBlocks.SEA_FOAM_LOG.get(),
                MysticBlocks.SEA_FOAM_WOOD.get(),
                MysticBlocks.STRIPPED_SEA_FOAM_LOG.get(),
                MysticBlocks.STRIPPED_SEA_FOAM_WOOD.get()
        );
        this.tag(MysticTags.Blocks.TROPICAL_LOGS).add(
                MysticBlocks.TROPICAL_LOG.get(),
                MysticBlocks.TROPICAL_WOOD.get(),
                MysticBlocks.STRIPPED_TROPICAL_LOG.get(),
                MysticBlocks.STRIPPED_TROPICAL_WOOD.get()
        );
        this.tag(BlockTags.JUNGLE_LOGS)
                .add(MysticBlocks.TROPICAL_LOG.get())
                .add(MysticBlocks.TROPICAL_WOOD.get());
        this.tag(BlockTags.LOGS_THAT_BURN)
                .addTag(MysticTags.Blocks.STRAWBERRY_LOGS)
                .addTag(MysticTags.Blocks.BLACK_CHERRY_LOGS)
                .addTag(MysticTags.Blocks.LAVENDER_LOGS)
                .addTag(MysticTags.Blocks.VANILLA_LOGS)
                .addTag(MysticTags.Blocks.PEACH_LOGS)
                .addTag(MysticTags.Blocks.MAPLE_LOGS)
                .addTag(MysticTags.Blocks.SPRING_LOGS)
                .addTag(MysticTags.Blocks.SEA_FOAM_LOGS)
                .addTag(MysticTags.Blocks.TROPICAL_LOGS);
        this.tag(BlockTags.DIRT)
                .add(MysticBlocks.GRASSY_LUSH_SAND.get());
        this.tag(BlockTags.SAND)
                .add(MysticBlocks.LUSH_SAND.get());
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(MysticBlocks.GRASSY_LUSH_SAND.get())
                .add(MysticBlocks.LUSH_SAND.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(MysticBlocks.LUSH_SANDSTONE.get())
                .add(MysticBlocks.LUSH_SANDSTONE_STAIRS.get())
                .add(MysticBlocks.LUSH_SANDSTONE_SLAB.get())
                .add(MysticBlocks.LUSH_SANDSTONE_WALL.get())
                .add(MysticBlocks.CHISELED_LUSH_SANDSTONE.get())
                .add(MysticBlocks.CUT_LUSH_SANDSTONE.get())
                .add(MysticBlocks.CUT_LUSH_SANDSTONE_SLAB.get())
                .add(MysticBlocks.SMOOTH_LUSH_SANDSTONE.get())
                .add(MysticBlocks.SMOOTH_LUSH_SANDSTONE_STAIRS.get())
                .add(MysticBlocks.SMOOTH_LUSH_SANDSTONE_SLAB.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(MysticBlocks.SPRING_MOSAIC.get())
                .add(MysticBlocks.SPRING_MOSAIC_STAIRS.get())
                .add(MysticBlocks.SPRING_MOSAIC_SLAB.get());
        this.tag(BlockTags.LEAVES)
                .add(MysticBlocks.STRAWBERRY_BLOSSOMS.get())
                .add(MysticBlocks.LAVENDER_BLOSSOMS.get())
                ///.add(MysticBlocks.BUTTERFLY_BUSH_LEAVES.get())
                .add(MysticBlocks.PINK_CHERRY_BLOSSOMS.get())
                .add(MysticBlocks.WHITE_CHERRY_BLOSSOMS.get())
                .add(MysticBlocks.PEONY_BUSH_LEAVES.get())
                .add(MysticBlocks.MAPLE_LEAVES.get())
                .add(MysticBlocks.ORANGE_MAPLE_LEAVES.get())
                .add(MysticBlocks.YELLOW_MAPLE_LEAVES.get())
                .add(MysticBlocks.PEACH_LEAVES.get())
                .add(MysticBlocks.SEA_SHRUB_LEAVES.get())
                .add(MysticBlocks.TROPICAL_LEAVES.get())
                .add(MysticBlocks.VANILLA_LEAVES.get())
                .add(MysticBlocks.HYDRANGEA_BUSH_LEAVES.get());
        this.tag(BlockTags.SAPLINGS)
                .add(MysticBlocks.STRAWBERRY_BLOSSOM_SAPLING.get())
                .add(MysticBlocks.LAVENDER_BLOSSOM_SAPLING.get())
                .add(MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING.get())
                .add(MysticBlocks.WHITE_CHERRY_BLOSSOM_SAPLING.get())
                .add(MysticBlocks.PEONY_BUSH.get())
                .add(MysticBlocks.MAPLE_SAPLING.get())
                .add(MysticBlocks.ORANGE_MAPLE_SAPLING.get())
                .add(MysticBlocks.YELLOW_MAPLE_SAPLING.get())
                .add(MysticBlocks.PEACH_SAPLING.get())
                .add(MysticBlocks.SEA_SHRUB.get())
                .add(MysticBlocks.TROPICAL_SAPLING.get())
                .add(MysticBlocks.VANILLA_SAPLING.get())
                .add(MysticBlocks.HYDRANGEA_BUSH.get());
        this.tag(BlockTags.FLOWERS)
                .add(MysticBlocks.STRAWBERRY_BLOSSOMS.get())
                .add(MysticBlocks.LAVENDER_BLOSSOMS.get())
                .add(MysticBlocks.PINK_CHERRY_BLOSSOMS.get())
                .add(MysticBlocks.WHITE_CHERRY_BLOSSOMS.get())
                .add(MysticBlocks.PEONY_BUSH_LEAVES.get())
                .add(MysticBlocks.HYDRANGEA_BUSH_LEAVES.get());
        this.tag(BlockTags.SMALL_FLOWERS)
                ///.add(MysticBlocks.PINK_DAISIES.get())
                ///.add(MysticBlocks.PINK_CHERRY_PETALS.get())
                ///.add(MysticBlocks.WHITE_CHERRY_PETALS.get())
                .add(MysticBlocks.ASTER.get())
                .add(MysticBlocks.LAVENDER.get())
                .add(MysticBlocks.WILDFLOWER.get())
                .add(MysticBlocks.SAGUARO_BLOSSOM.get())
                ///.add(MysticBlocks.PRICKLY_BLOSSOM.get())
                .add(MysticBlocks.SEA_THRIFT.get())
                .add(MysticBlocks.HIBISCUS.get());
        this.tag(BlockTags.TALL_FLOWERS)
                .add(MysticBlocks.TALL_LAVENDER.get())
                .add(MysticBlocks.DESERT_LILY.get())
                .add(MysticBlocks.MILKWEED.get())
                .add(MysticBlocks.GOLDENROD.get());
        this.tag(BlockTags.CROPS)
                .add(MysticBlocks.STRAWBERRY_BUSH.get())
                .add(MysticBlocks.CHERRY_PLANT.get())
                .add(MysticBlocks.PEACH_PLANT.get())
                ///.add(MysticBlocks.PRICKLY_PEAR.get())
                .add(MysticBlocks.VANILLA_ORCHID.get());
        this.tag(BlockTags.BEE_GROWABLES)
                .add(MysticBlocks.WILD_STRAWBERRY_BUSH.get())
                .add(MysticBlocks.STRAWBERRY_BUSH.get())
                .add(MysticBlocks.CHERRY_PLANT.get())
                .add(MysticBlocks.PEACH_PLANT.get())
                ///.add(MysticBlocks.PRICKLY_PEAR.get())
                .add(MysticBlocks.VANILLA_ORCHID.get());
    }

    private void generateFor(MysticBlockFamily family) {
        family.getVariants().forEach((variant, block) -> {
            boolean flammable = family.isFlammable();
            switch (variant) {
                case PLANKS -> this.tag(BlockTags.PLANKS).add(block.get());
                case STAIRS -> this.tag(flammable ? BlockTags.WOODEN_STAIRS : BlockTags.STAIRS).add(block.get());
                case SLAB -> this.tag(flammable ? BlockTags.WOODEN_SLABS : BlockTags.SLABS).add(block.get());
                case FENCE -> this.tag(flammable ? BlockTags.WOODEN_FENCES : BlockTags.FENCES).add(block.get());
                case FENCE_GATE -> this.tag(BlockTags.FENCE_GATES).add(block.get());
                case BUTTON -> this.tag(flammable ? BlockTags.WOODEN_BUTTONS : BlockTags.STONE_BUTTONS).add(block.get());
                case PRESSURE_PLATE -> this.tag(flammable ? BlockTags.WOODEN_PRESSURE_PLATES : BlockTags.STONE_PRESSURE_PLATES).add(block.get());
                case TRAPDOOR -> this.tag(flammable ? BlockTags.WOODEN_TRAPDOORS : BlockTags.TRAPDOORS).add(block.get());
                case DOOR -> this.tag(flammable ? BlockTags.WOODEN_DOORS : BlockTags.DOORS).add(block.get());
                case SIGN -> this.tag(BlockTags.STANDING_SIGNS).add(block.get());
                case WALL_SIGN -> this.tag(BlockTags.WALL_SIGNS).add(block.get());
                case HANGING_SIGN -> this.tag(BlockTags.CEILING_HANGING_SIGNS).add(block.get());
                case WALL_HANGING_SIGN -> this.tag(BlockTags.WALL_HANGING_SIGNS).add(block.get());
                case WALL -> this.tag(BlockTags.WALLS).add(block.get());
            }
        });
    }

}