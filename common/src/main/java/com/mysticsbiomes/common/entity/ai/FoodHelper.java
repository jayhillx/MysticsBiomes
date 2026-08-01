package com.mysticsbiomes.common.entity.ai;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * helper to be able to cleanly reuse the same items for food and an ingredient.
 */
public final class FoodHelper {
    private final List<TagKey<Item>> tags = new ArrayList<>();
    private final List<ItemLike> items = new ArrayList<>();

    @SafeVarargs
    public final FoodHelper tags(TagKey<Item>... tags) {
        this.tags.addAll(Arrays.asList(tags));
        return this;
    }

    public FoodHelper items(ItemLike... items) {
        this.items.addAll(Arrays.asList(items));
        return this;
    }

    public boolean test(ItemStack stack) {
        for (TagKey<Item> tag : this.tags) {
            if (stack.is(tag)) {
                return true;
            }
        }

        for (ItemLike item : this.items) {
            if (stack.is(item.asItem())) {
                return true;
            }
        }

        return false;
    }

    public Ingredient asIngredient() {
        List<ItemLike> all = new ArrayList<>(this.items);

        for (TagKey<Item> tag : this.tags) {
            BuiltInRegistries.ITEM.getTagOrEmpty(tag).forEach(holder -> all.add(holder.value()));
        }

        return Ingredient.of(all.toArray(ItemLike[]::new));
    }

}