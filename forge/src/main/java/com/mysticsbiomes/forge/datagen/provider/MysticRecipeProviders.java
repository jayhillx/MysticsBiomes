package com.mysticsbiomes.forge.datagen.provider;

import com.google.common.collect.ImmutableMap;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.core.registry.RegistryObject;
import com.mysticsbiomes.datagen.MysticBlockFamilies;
import com.mysticsbiomes.datagen.MysticBlockFamily;
import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticItems;
import com.mysticsbiomes.init.MysticTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class MysticRecipeProviders extends RecipeProvider {
    private static final Map<MysticBlockFamily.Variant, BiFunction<ItemLike, ItemLike, RecipeBuilder>> SHAPE_BUILDERS = ImmutableMap.<MysticBlockFamily.Variant, BiFunction<ItemLike, ItemLike, RecipeBuilder>>builder()
            .put(MysticBlockFamily.Variant.STAIRS, (item, ingredient) -> stairBuilder(item, Ingredient.of(ingredient)))
            .put(MysticBlockFamily.Variant.SLAB, (item, ingredient) -> slabBuilder(RecipeCategory.BUILDING_BLOCKS, item, Ingredient.of(ingredient)))
            .put(MysticBlockFamily.Variant.FENCE, (item, ingredient) -> fenceBuilder(item, Ingredient.of(ingredient)))
            .put(MysticBlockFamily.Variant.FENCE_GATE, (item, ingredient) -> fenceGateBuilder(item, Ingredient.of(ingredient)))
            .put(MysticBlockFamily.Variant.BUTTON, (item, ingredient) -> buttonBuilder(item, Ingredient.of(ingredient)))
            .put(MysticBlockFamily.Variant.PRESSURE_PLATE, (item, ingredient) -> pressurePlateBuilder(RecipeCategory.REDSTONE, item, Ingredient.of(ingredient)))
            .put(MysticBlockFamily.Variant.TRAPDOOR, (item, ingredient) -> trapdoorBuilder(item, Ingredient.of(ingredient)))
            .put(MysticBlockFamily.Variant.DOOR, (item, ingredient) -> doorBuilder(item, Ingredient.of(ingredient)))
            .put(MysticBlockFamily.Variant.SIGN, (item, ingredient) -> signBuilder(item, Ingredient.of(ingredient)))
            .put(MysticBlockFamily.Variant.WALL, (item, ingredient) -> wallBuilder(RecipeCategory.DECORATIONS, item, Ingredient.of(ingredient)))
            .put(MysticBlockFamily.Variant.CHISELED, (item, ingredient) -> chiseledBuilder(RecipeCategory.BUILDING_BLOCKS, item, Ingredient.of(ingredient)))
            .put(MysticBlockFamily.Variant.CUT, (item, ingredient) -> cutBuilder(RecipeCategory.BUILDING_BLOCKS, item, Ingredient.of(ingredient)))
            .build();

    public MysticRecipeProviders(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(@Nonnull Consumer<FinishedRecipe> output) {
        MysticBlockFamilies.getAllFamilies().filter(MysticBlockFamily::shouldGenerateRecipe).forEach(family -> generateFor(output, family));
        planksFromLogs(output, MysticBlocks.STRAWBERRY_PLANKS.get(), MysticTags.Items.STRAWBERRY_LOGS);
        planksFromLogs(output, MysticBlocks.BLACK_CHERRY_PLANKS.get(), MysticTags.Items.BLACK_CHERRY_LOGS);
        planksFromLogs(output, MysticBlocks.LAVENDER_PLANKS.get(), MysticTags.Items.LAVENDER_LOGS);
        planksFromLogs(output, MysticBlocks.VANILLA_PLANKS.get(), MysticTags.Items.VANILLA_LOGS);
        planksFromLogs(output, MysticBlocks.PEACH_PLANKS.get(), MysticTags.Items.PEACH_LOGS);
        planksFromLogs(output, MysticBlocks.MAPLE_PLANKS.get(), MysticTags.Items.MAPLE_LOGS);
        planksFromLogs(output, MysticBlocks.SPRING_PLANKS.get(), MysticTags.Items.SPRING_LOGS);
        planksFromLogs(output, MysticBlocks.SEA_FOAM_PLANKS.get(), MysticTags.Items.SEA_FOAM_LOGS);
        planksFromLogs(output, MysticBlocks.TROPICAL_PLANKS.get(), MysticTags.Items.TROPICAL_LOGS);

        woodenBoat(output, MysticItems.STRAWBERRY_BOAT.get(), MysticBlocks.STRAWBERRY_PLANKS.get());
        woodenBoat(output, MysticItems.BLACK_CHERRY_BOAT.get(), MysticBlocks.BLACK_CHERRY_PLANKS.get());
        woodenBoat(output, MysticItems.LAVENDER_BOAT.get(), MysticBlocks.LAVENDER_PLANKS.get());
        woodenBoat(output, MysticItems.VANILLA_BOAT.get(), MysticBlocks.VANILLA_PLANKS.get());
        woodenBoat(output, MysticItems.PEACH_BOAT.get(), MysticBlocks.PEACH_PLANKS.get());
        woodenBoat(output, MysticItems.MAPLE_BOAT.get(), MysticBlocks.MAPLE_PLANKS.get());
        woodenBoat(output, MysticItems.SPRING_RAFT.get(), MysticBlocks.SPRING_PLANKS.get());
        woodenBoat(output, MysticItems.SEA_FOAM_BOAT.get(), MysticBlocks.SEA_FOAM_PLANKS.get());
        woodenBoat(output, MysticItems.TROPICAL_BOAT.get(), MysticBlocks.TROPICAL_PLANKS.get());

        chestBoat(output, MysticItems.STRAWBERRY_CHEST_BOAT.get(), MysticItems.STRAWBERRY_BOAT.get());
        chestBoat(output, MysticItems.BLACK_CHERRY_CHEST_BOAT.get(), MysticItems.BLACK_CHERRY_BOAT.get());
        chestBoat(output, MysticItems.LAVENDER_CHEST_BOAT.get(), MysticItems.LAVENDER_BOAT.get());
        chestBoat(output, MysticItems.VANILLA_CHEST_BOAT.get(), MysticItems.VANILLA_BOAT.get());
        chestBoat(output, MysticItems.PEACH_CHEST_BOAT.get(), MysticItems.PEACH_BOAT.get());
        chestBoat(output, MysticItems.MAPLE_CHEST_BOAT.get(), MysticItems.MAPLE_BOAT.get());
        chestBoat(output, MysticItems.SPRING_CHEST_RAFT.get(), MysticItems.SPRING_RAFT.get());
        chestBoat(output, MysticItems.SEA_FOAM_CHEST_BOAT.get(), MysticItems.SEA_FOAM_BOAT.get());
        chestBoat(output, MysticItems.TROPICAL_CHEST_BOAT.get(), MysticItems.TROPICAL_BOAT.get());
    }
    
    private static void generateFor(Consumer<FinishedRecipe> output, MysticBlockFamily family) {
        if (family != null) {
            family.getVariants().forEach((variant, block) -> {
                ItemLike baseBlock = getBaseBlock(family, variant);
                ItemLike source = family.get(variant.source()).get();
                if (source != null) {
                    switch (variant) {
                        case WOOD, SECONDARY_WOOD, STRIPPED_WOOD -> woodFromLogs(output, block, source);
                        case HANGING_SIGN -> hangingSign(output, block, source);
                    }
                }

                BiFunction<ItemLike, ItemLike, RecipeBuilder> function = SHAPE_BUILDERS.get(variant);
                if (function != null) {
                    RecipeBuilder builder = function.apply(block, baseBlock);
                    family.getRecipeGroupPrefix().ifPresent(group -> {
                        if (variant != MysticBlockFamily.Variant.CUT) {
                            builder.group(group + "_" + variant.getRecipeGroup());
                        }
                    });
                    builder.unlockedBy(family.getRecipeUnlockedBy().orElseGet(() -> getHasName(baseBlock)), has(baseBlock));
                    builder.save(output);
                }
            });
        }
    }

    private static Block getBaseBlock(MysticBlockFamily family, MysticBlockFamily.Variant variant) {
        if (variant == MysticBlockFamily.Variant.CHISELED) {
            if (!family.getVariants().containsKey(MysticBlockFamily.Variant.SLAB)) {
                throw new IllegalStateException("Slab is not defined for the family.");
            } else {
                return family.get(MysticBlockFamily.Variant.SLAB).get();
            }
        } else {
            return family.getBaseBlock().get();
        }
    }

    protected static void planksFromLogs(Consumer<FinishedRecipe> output, Block block, TagKey<Item> tag) {
        planksFromLogs(output, block, tag, 4);
    }

    protected static void stonecutterResultFromBase(Consumer<FinishedRecipe> recipeOutput, RecipeCategory category, ItemLike result, ItemLike material) {
        stonecutterResultFromBase(recipeOutput, category, result, material, 1);
    }

    protected static void stonecutterResultFromBase(Consumer<FinishedRecipe> output, RecipeCategory category, ItemLike result, ItemLike material, int resultCount) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(material), category, result, resultCount)
                .unlockedBy(getHasName(material), has(material))
                .save(output, MysticsBiomes.modLoc(getConversionRecipeName(result, material) + "_stonecutting"));
    }

    protected static void dyeFromFlowers(Consumer<FinishedRecipe> output, ItemLike resultItem, ItemLike inputItem) {
        dyeFromFlowers(output, resultItem, inputItem, 1);
    }

    protected static void dyeFromFlowers(Consumer<FinishedRecipe> output, ItemLike resultItem, ItemLike inputItem, int amount) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, resultItem, amount)
                .requires(inputItem)
                .group(getItemName(resultItem))
                .unlockedBy(getHasName(inputItem), has(inputItem))
                .save(output, MysticsBiomes.modLoc(getConversionRecipeName(resultItem, inputItem)));
    }
    
}