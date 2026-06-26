package com.mysticsbiomes.datagen.provider.tag;

import com.mysticsbiomes.MysticsBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class MysticItemTags extends ItemTagsProvider {
    public static final TagKey<Item> STRAWBERRY_LOGS = create("strawberry_logs");
    ///public static final TagKey<Item> BLACK_CHERRY_LOGS = create("black_cherry_logs");
    ///public static final TagKey<Item> LAVENDER_LOGS = create("lavender_logs");
    ///public static final TagKey<Item> VANILLA_LOGS = create("vanilla_logs");
    ///public static final TagKey<Item> PEACH_LOGS = create("peach_logs");
    ///public static final TagKey<Item> MAPLE_LOGS = create("maple_logs");
    ///public static final TagKey<Item> SPRING_LOGS = create("spring_logs");
    ///public static final TagKey<Item> SEA_FOAM_LOGS = create("sea_foam_logs");
    ///public static final TagKey<Item> TROPICAL_LOGS = create("tropical_logs");

    public MysticItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, provider, blockTags);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        ///DreamBlockFamilies.getAllFamilies().filter(DreamBlockFamily::shouldGenerateModel).forEach(this::generateFor);
        this.copy(MysticBlockTags.STRAWBERRY_LOGS, MysticItemTags.STRAWBERRY_LOGS);
        ///this.copy(MysticBlockTags.BLACK_CHERRY_LOGS, MysticItemTags.BLACK_CHERRY_LOGS);
        ///this.copy(MysticBlockTags.LAVENDER_LOGS, MysticItemTags.LAVENDER_LOGS);
        ///this.copy(MysticBlockTags.VANILLA_LOGS, MysticItemTags.VANILLA_LOGS);
        ///this.copy(MysticBlockTags.PEACH_LOGS, MysticItemTags.PEACH_LOGS);
        ///this.copy(MysticBlockTags.MAPLE_LOGS, MysticItemTags.MAPLE_LOGS);
        ///this.copy(MysticBlockTags.SPRING_LOGS, MysticItemTags.SPRING_LOGS);
        ///this.copy(MysticBlockTags.SEA_FOAM_LOGS, MysticItemTags.SEA_FOAM_LOGS);
        ///this.copy(MysticBlockTags.TROPICAL_LOGS, MysticItemTags.TROPICAL_LOGS);

        this.tag(ItemTags.LOGS_THAT_BURN)
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
    
    ///private void generateFor(DreamBlockFamily family) {
    ///    family.getVariants().forEach((variant, block) -> {
    ///        boolean flag = family.isFlammable();
    ///        switch (variant) {
    ///            case PLANKS -> this.tag(ItemTags.PLANKS).add(block.asItem());
    ///            case STAIRS -> this.tag(flag ? ItemTags.WOODEN_STAIRS : ItemTags.STAIRS).add(block.asItem());
    ///            case SLAB -> this.tag(flag ? ItemTags.WOODEN_SLABS : ItemTags.SLABS).add(block.asItem());
    ///            case FENCE -> this.tag(flag ? ItemTags.WOODEN_FENCES : ItemTags.FENCES).add(block.asItem());
    ///            case FENCE_GATE -> this.tag(ItemTags.FENCE_GATES).add(block.asItem());
    ///            case BUTTON -> this.tag(flag ? ItemTags.WOODEN_BUTTONS : ItemTags.STONE_BUTTONS).add(block.asItem());
    ///            case PRESSURE_PLATE -> {
    ///                if (flag) {
    ///                    this.tag(ItemTags.WOODEN_PRESSURE_PLATES).add(block.asItem());
    ///                }
    ///            }
    ///            case TRAPDOOR -> this.tag(flag ? ItemTags.WOODEN_TRAPDOORS : ItemTags.TRAPDOORS).add(block.asItem());
    ///            case DOOR -> this.tag(flag ? ItemTags.WOODEN_DOORS : ItemTags.DOORS).add(block.asItem());
    ///            case SIGN -> this.tag(ItemTags.SIGNS).add(block.asItem());
    ///            case HANGING_SIGN -> this.tag(ItemTags.HANGING_SIGNS).add(block.asItem());
    ///            case WALL -> this.tag(ItemTags.WALLS).add(block.asItem());
    ///        }
    ///    });
    ///}

    private static TagKey<Item> create(String name) {
        return TagKey.create(Registries.ITEM, MysticsBiomes.modLoc(name));
    }
    
}