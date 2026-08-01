package com.mysticsbiomes.common.advancement.criteron;

import com.google.gson.JsonObject;
import com.mysticsbiomes.MysticsBiomes;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

public class CraftedItemTrigger extends SimpleCriterionTrigger<CraftedItemTrigger.TriggerInstance> {
    private static final ResourceLocation ID = MysticsBiomes.modLoc("crafted_items");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public TriggerInstance createInstance(JsonObject json, ContextAwarePredicate playerPredicate, DeserializationContext context) {
        Item item = Items.AIR;
        if (json.has("item")) {
            ResourceLocation id = ResourceLocation.tryParse(json.get("item").getAsString());
            item = BuiltInRegistries.ITEM.get(id);
        }

        return new TriggerInstance(playerPredicate, item);
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, (instance) -> instance.matches(player));
    }

    public static class TriggerInstance extends AbstractCriterionTriggerInstance {
        private final Item requiredItem;

        public TriggerInstance(ContextAwarePredicate playerPredicate, Item requiredItem) {
            super(CraftedItemTrigger.ID, playerPredicate);
            this.requiredItem = requiredItem;
        }

        public static TriggerInstance item(ItemLike item) {
            return new TriggerInstance(ContextAwarePredicate.ANY, item.asItem());
        }

        public boolean matches(ServerPlayer player) {
            return player.getStats().getValue(Stats.ITEM_CRAFTED.get(this.requiredItem)) > 0;
        }
    }

}