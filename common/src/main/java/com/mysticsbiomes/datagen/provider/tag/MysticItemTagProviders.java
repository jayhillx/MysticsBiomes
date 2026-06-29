package com.mysticsbiomes.datagen.provider.tag;

import com.mysticsbiomes.datagen.MysticBlockFamilies;
import com.mysticsbiomes.datagen.MysticBlockFamily;
import com.mysticsbiomes.init.MysticItems;
import com.mysticsbiomes.init.MysticTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class MysticItemTagProviders extends ItemTagsProvider {

    public MysticItemTagProviders(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, provider, blockTags);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        MysticBlockFamilies.getAllFamilies().filter(MysticBlockFamily::shouldGenerateModel).forEach(this::generateFor);
        this.copy(MysticTags.Blocks.STRAWBERRY_LOGS, MysticTags.Items.STRAWBERRY_LOGS);
        this.copy(MysticTags.Blocks.BLACK_CHERRY_LOGS, MysticTags.Items.BLACK_CHERRY_LOGS);
        this.copy(MysticTags.Blocks.LAVENDER_LOGS, MysticTags.Items.LAVENDER_LOGS);
        this.copy(MysticTags.Blocks.VANILLA_LOGS, MysticTags.Items.VANILLA_LOGS);
        this.copy(MysticTags.Blocks.PEACH_LOGS, MysticTags.Items.PEACH_LOGS);
        this.copy(MysticTags.Blocks.MAPLE_LOGS, MysticTags.Items.MAPLE_LOGS);
        this.copy(MysticTags.Blocks.SPRING_LOGS, MysticTags.Items.SPRING_LOGS);
        this.copy(MysticTags.Blocks.SEA_FOAM_LOGS, MysticTags.Items.SEA_FOAM_LOGS);
        this.copy(MysticTags.Blocks.TROPICAL_LOGS, MysticTags.Items.TROPICAL_LOGS);
        this.tag(ItemTags.LOGS_THAT_BURN)
                .addTag(MysticTags.Items.STRAWBERRY_LOGS)
                .addTag(MysticTags.Items.BLACK_CHERRY_LOGS)
                .addTag(MysticTags.Items.LAVENDER_LOGS)
                .addTag(MysticTags.Items.VANILLA_LOGS)
                .addTag(MysticTags.Items.PEACH_LOGS)
                .addTag(MysticTags.Items.MAPLE_LOGS)
                .addTag(MysticTags.Items.SPRING_LOGS)
                .addTag(MysticTags.Items.SEA_FOAM_LOGS)
                .addTag(MysticTags.Items.TROPICAL_LOGS);
        this.tag(ItemTags.DIRT)
                .add(MysticItems.GRASSY_LUSH_SAND.get());
        this.tag(ItemTags.LEAVES)
                .add(MysticItems.STRAWBERRY_BLOSSOMS.get())
                .add(MysticItems.LAVENDER_BLOSSOMS.get())
                .add(MysticItems.PINK_CHERRY_BLOSSOMS.get())
                .add(MysticItems.WHITE_CHERRY_BLOSSOMS.get())
                ///.add(MysticItems.PEONY_BUSH_LEAVES.get())
                .add(MysticItems.MAPLE_LEAVES.get())
                .add(MysticItems.SPICED_MAPLE_LEAVES.get())
                .add(MysticItems.ORANGE_MAPLE_LEAVES.get())
                .add(MysticItems.YELLOW_MAPLE_LEAVES.get())
                .add(MysticItems.PEACH_LEAVES.get())
                .add(MysticItems.SEA_SHRUB_LEAVES.get())
                .add(MysticItems.TROPICAL_LEAVES.get())
                .add(MysticItems.VANILLA_LEAVES.get());
                ///.add(MysticItems.HYDRANGEA_BUSH_LEAVES.get());
        this.tag(ItemTags.SAPLINGS)
                .add(MysticItems.STRAWBERRY_BLOSSOM_SAPLING.get())
                .add(MysticItems.LAVENDER_BLOSSOM_SAPLING.get())
                .add(MysticItems.PINK_CHERRY_BLOSSOM_SAPLING.get())
                .add(MysticItems.WHITE_CHERRY_BLOSSOM_SAPLING.get())
                ///.add(MysticItems.PEONY_BUSH.get())
                .add(MysticItems.MAPLE_SAPLING.get())
                .add(MysticItems.SPICED_MAPLE_SAPLING.get())
                .add(MysticItems.ORANGE_MAPLE_SAPLING.get())
                .add(MysticItems.YELLOW_MAPLE_SAPLING.get())
                .add(MysticItems.PEACH_SAPLING.get())
                .add(MysticItems.SEA_SHRUB.get())
                .add(MysticItems.TROPICAL_SAPLING.get())
                .add(MysticItems.VANILLA_SAPLING.get());
                ///.add(MysticItems.HYDRANGEA_BUSH.get());
        this.tag(ItemTags.FLOWERS)
                .add(MysticItems.STRAWBERRY_BLOSSOMS.get())
                .add(MysticItems.LAVENDER_BLOSSOMS.get())
                .add(MysticItems.PINK_CHERRY_BLOSSOMS.get())
                .add(MysticItems.WHITE_CHERRY_BLOSSOMS.get());
                ///.add(MysticItems.PEONY_BUSH_LEAVES.get())
                ///.add(MysticItems.HYDRANGEA_BUSH_LEAVES.get());
        ///this.tag(ItemTags.SMALL_FLOWERS)
        ///        .add(MysticItems.PINK_DAISIES.get())
        ///        .add(MysticItems.PINK_CHERRY_PETALS.get())
        ///        .add(MysticItems.WHITE_CHERRY_PETALS.get())
        ///        .add(MysticItems.ASTER.get())
        ///        .add(MysticItems.LAVENDER.get())
        ///        .add(MysticItems.WILDFLOWER.get())
        ///        .add(MysticItems.SEA_THRIFT.get())
        ///        .add(MysticItems.HIBISCUS.get());
        ///this.tag(ItemTags.TALL_FLOWERS)
        ///        .add(MysticItems.TALL_LAVENDER.get())
        ///        .add(MysticItems.DESERT_LILY.get())
        ///        .add(MysticItems.MILKWEED.get())
        ///        .add(MysticItems.GOLDENROD.get());
    }

    private void generateFor(MysticBlockFamily family) {
        family.getVariants().forEach((variant, block) -> {
            boolean flammable = family.isFlammable();
            switch (variant) {
                case PLANKS -> this.tag(ItemTags.PLANKS).add(block.asItem());
                case STAIRS -> this.tag(flammable ? ItemTags.WOODEN_STAIRS : ItemTags.STAIRS).add(block.asItem());
                case SLAB -> this.tag(flammable ? ItemTags.WOODEN_SLABS : ItemTags.SLABS).add(block.asItem());
                case FENCE -> this.tag(flammable ? ItemTags.WOODEN_FENCES : ItemTags.FENCES).add(block.asItem());
                case FENCE_GATE -> this.tag(ItemTags.FENCE_GATES).add(block.asItem());
                case BUTTON -> this.tag(flammable ? ItemTags.WOODEN_BUTTONS : ItemTags.STONE_BUTTONS).add(block.asItem());
                case PRESSURE_PLATE -> {
                    if (flammable) {
                        this.tag(ItemTags.WOODEN_PRESSURE_PLATES).add(block.asItem());
                    }
                }
                case TRAPDOOR -> this.tag(flammable ? ItemTags.WOODEN_TRAPDOORS : ItemTags.TRAPDOORS).add(block.asItem());
                case DOOR -> this.tag(flammable ? ItemTags.WOODEN_DOORS : ItemTags.DOORS).add(block.asItem());
                case SIGN -> this.tag(ItemTags.SIGNS).add(block.asItem());
                case HANGING_SIGN -> this.tag(ItemTags.HANGING_SIGNS).add(block.asItem());
                case WALL -> this.tag(ItemTags.WALLS).add(block.asItem());
            }
        });
    }

}