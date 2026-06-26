package com.mysticsbiomes.datagen.provider.tag;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.VanillaBlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class MysticBlockTags extends VanillaBlockTagsProvider {
    public static final TagKey<Block> STRAWBERRY_LOGS = create("strawberry_logs");
    ///public static final TagKey<Block> BLACK_CHERRY_LOGS = create("black_cherry_logs");
    ///public static final TagKey<Block> LAVENDER_LOGS = create("lavender_logs");
    ///public static final TagKey<Block> VANILLA_LOGS = create("vanilla_logs");
    ///public static final TagKey<Block> PEACH_LOGS = create("peach_logs");
    ///public static final TagKey<Block> MAPLE_LOGS = create("maple_logs");
    ///public static final TagKey<Block> SPRING_LOGS = create("spring_logs");
    ///public static final TagKey<Block> SEA_FOAM_LOGS = create("sea_foam_logs");
    ///public static final TagKey<Block> TROPICAL_LOGS = create("tropical_logs");
    
    public MysticBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        ///MysticBlockFamilies.getAllFamilies().filter(MysticBlockFamily::shouldGenerateModel).forEach(this::generateFor);
        this.tag(STRAWBERRY_LOGS).add(
                MysticBlocks.STRAWBERRY_LOG.get(),
                MysticBlocks.STRAWBERRY_WOOD.get(),
                MysticBlocks.STRIPPED_STRAWBERRY_LOG.get(),
                MysticBlocks.STRIPPED_STRAWBERRY_WOOD.get()
        );
        ///this.tag(BLACK_CHERRY_LOGS).add(
        ///        MysticBlocks.BLACK_CHERRY_LOG.get(),
        ///        MysticBlocks.BLACK_CHERRY_WOOD.get(),
        ///        MysticBlocks.STRIPPED_BLACK_CHERRY_LOG.get(),
        ///        MysticBlocks.STRIPPED_BLACK_CHERRY_WOOD.get()
        ///);
        ///this.tag(LAVENDER_LOGS).add(
        ///        MysticBlocks.LAVENDER_LOG.get(),
        ///        MysticBlocks.LAVENDER_WOOD.get(),
        ///        MysticBlocks.STRIPPED_LAVENDER_LOG.get(),
        ///        MysticBlocks.STRIPPED_LAVENDER_WOOD.get()
        ///);
        ///this.tag(VANILLA_LOGS).add(
        ///        MysticBlocks.VANILLA_LOG.get(),
        ///        MysticBlocks.VANILLA_WOOD.get(),
        ///        MysticBlocks.STRIPPED_VANILLA_LOG.get(),
        ///        MysticBlocks.STRIPPED_VANILLA_WOOD.get()
        ///);
        ///this.tag(PEACH_LOGS).add(
        ///        MysticBlocks.PEACH_LOG.get(),
        ///        MysticBlocks.PEACH_WOOD.get(),
        ///        MysticBlocks.STRIPPED_PEACH_LOG.get(),
        ///        MysticBlocks.STRIPPED_PEACH_WOOD.get()
        ///);
        ///this.tag(SPRING_LOGS).add(
        ///        MysticBlocks.SPRING_LOG.get(),
        ///        MysticBlocks.SPRING_WOOD.get(),
        ///        MysticBlocks.STRIPPED_SPRING_LOG.get(),
        ///        MysticBlocks.STRIPPED_SPRING_WOOD.get()
        ///);
        ///this.tag(SEA_FOAM_LOGS).add(
        ///        MysticBlocks.SEA_FOAM_LOG.get(),
        ///        MysticBlocks.SEA_FOAM_WOOD.get(),
        ///        MysticBlocks.STRIPPED_SEA_FOAM_LOG.get(),
        ///        MysticBlocks.STRIPPED_SEA_FOAM_WOOD.get()
        ///);
        ///this.tag(MAPLE_LOGS).add(
        ///        MysticBlocks.MAPLE_LOG.get(),
        ///        MysticBlocks.MAPLE_WOOD.get(),
        ///        MysticBlocks.WHITE_MAPLE_LOG.get(),
        ///        MysticBlocks.WHITE_MAPLE_WOOD.get(),
        ///        MysticBlocks.STRIPPED_MAPLE_LOG.get(),
        ///        MysticBlocks.STRIPPED_MAPLE_WOOD.get()
        ///);
        ///this.tag(TROPICAL_LOGS).add(
        ///        MysticBlocks.TROPICAL_LOG.get(),
        ///        MysticBlocks.TROPICAL_WOOD.get(),
        ///        MysticBlocks.STRIPPED_TROPICAL_LOG.get(),
        ///        MysticBlocks.STRIPPED_TROPICAL_WOOD.get()
        ///);
        this.tag(BlockTags.LOGS_THAT_BURN)
                .addTag(STRAWBERRY_LOGS);
                ///.addTag(BLACK_CHERRY_LOGS)
                ///.addTag(LAVENDER_LOGS)
                ///.addTag(VANILLA_LOGS)
                ///.addTag(PEACH_LOGS)
                ///.addTag(MAPLE_LOGS)
                ///.addTag(SPRING_LOGS)
                ///.addTag(SEA_FOAM_LOGS)
                ///.addTag(TROPICAL_LOGS);
    }

    ///private void generateFor(MysticBlockFamily family) {
    ///    family.getVariants().forEach((variant, block) -> {
    ///        boolean flag = family.isFlammable();
    ///        switch (variant) {
    ///            case PLANKS -> this.tag(BlockTags.PLANKS).add(block);
    ///            case STAIRS -> this.tag(flag ? BlockTags.WOODEN_STAIRS : BlockTags.STAIRS).add(block);
    ///            case SLAB -> this.tag(flag ? BlockTags.WOODEN_SLABS : BlockTags.SLABS).add(block);
    ///            case FENCE -> this.tag(flag ? BlockTags.WOODEN_FENCES : BlockTags.FENCES).add(block);
    ///            case FENCE_GATE -> this.tag(BlockTags.FENCE_GATES).add(block);
    ///            case BUTTON -> this.tag(flag ? BlockTags.WOODEN_BUTTONS : BlockTags.STONE_BUTTONS).add(block);
    ///            case PRESSURE_PLATE -> this.tag(flag ? BlockTags.WOODEN_PRESSURE_PLATES : BlockTags.STONE_PRESSURE_PLATES).add(block);
    ///            case TRAPDOOR -> this.tag(flag ? BlockTags.WOODEN_TRAPDOORS : BlockTags.TRAPDOORS).add(block);
    ///            case DOOR -> this.tag(flag ? BlockTags.WOODEN_DOORS : BlockTags.DOORS).add(block);
    ///            case SIGN -> this.tag(BlockTags.STANDING_SIGNS).add(block);
    ///            case WALL_SIGN -> this.tag(BlockTags.WALL_SIGNS).add(block);
    ///            case HANGING_SIGN -> this.tag(BlockTags.CEILING_HANGING_SIGNS).add(block);
    ///            case WALL_HANGING_SIGN -> this.tag(BlockTags.WALL_HANGING_SIGNS).add(block);
    ///            case WALL -> this.tag(BlockTags.WALLS).add(block);
    ///        }
    ///    });
    ///}

    private static TagKey<Block> create(String name) {
        return TagKey.create(Registries.BLOCK, MysticsBiomes.modLoc(name));
    }
    
}