package com.mysticsbiomes.forge.datagen.provider;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.advancement.criteron.CraftedItemTrigger;
import com.mysticsbiomes.init.MysticBiomes;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class MysticAdvancementsProvider implements ForgeAdvancementProvider.AdvancementGenerator {

    @Override
    public void generate(HolderLookup.Provider provider, Consumer<Advancement> consumer, ExistingFileHelper fileHelper) {
        Advancement root = this.advancement(
                consumer,
                null,
                "root",
                MysticItems.LOGO.get(),
                MysticsBiomes.modLoc("textures/block/stripped_tropical_log.png"),
                FrameType.TASK,
                true,
                false,
                false,
                builder -> builder
                        .addCriterion("strawberry_fields", biome(MysticBiomes.STRAWBERRY_FIELDS))
                        .addCriterion("lavender_meadow", biome(MysticBiomes.LAVENDER_MEADOW))
                        .addCriterion("bamboo_blossom_forest", biome(MysticBiomes.BAMBOO_BLOSSOM_FOREST))
                        .addCriterion("autumnal_grove", biome(MysticBiomes.AUTUMNAL_GROVE))
                        .addCriterion("lush_oasis", biome(MysticBiomes.LUSH_OASIS))
                        .addCriterion("lagoon", biome(MysticBiomes.LAGOON))
                        .addCriterion("tropics", biome(MysticBiomes.TROPICS)));

        Advancement obtainSweetStrawberry = this.obtainItemAdvancement(consumer, root, MysticItems.SWEET_STRAWBERRY.get(), FrameType.CHALLENGE);
        this.advancement(consumer, obtainSweetStrawberry, "craft_sweet_strawberry_cake", MysticItems.SWEET_STRAWBERRY_CAKE.get(), FrameType.CHALLENGE, builder -> builder
                .addCriterion("has_sweet_strawberry_cake", cake(MysticItems.SWEET_STRAWBERRY_CAKE.get()))
        );
        this.obtainItemAdvancement(consumer, root, MysticItems.CHERRIES.get(), FrameType.TASK);
        this.obtainItemAdvancement(consumer, root, MysticItems.PEACH.get(), FrameType.TASK);

        Advancement craftRainbowCakes = this.advancement(consumer, root, "craft_frosted_cakes", MysticItems.FROSTED_CAKES.get(), FrameType.TASK, builder -> builder
                .addCriterion("pink_frosted_cake", cake(MysticItems.PINK_FROSTED_CAKE.get()))
                .addCriterion("orange_frosted_cake", cake(MysticItems.ORANGE_FROSTED_CAKE.get()))
                .addCriterion("yellow_frosted_cake", cake(MysticItems.YELLOW_FROSTED_CAKE.get()))
                .addCriterion("lime_frosted_cake", cake(MysticItems.LIME_FROSTED_CAKE.get()))
                .addCriterion("cyan_frosted_cake", cake(MysticItems.CYAN_FROSTED_CAKE.get()))
                .addCriterion("purple_frosted_cake", cake(MysticItems.PURPLE_FROSTED_CAKE.get()))
        );
        this.advancement(consumer, craftRainbowCakes, "craft_neapolitan_cakes", MysticItems.NEAPOLITAN_CAKES.get(), FrameType.TASK, builder -> builder
                .addCriterion("strawberry_cake", cake(MysticItems.STRAWBERRY_CAKE.get()))
                .addCriterion("vanilla_cake", cake(MysticItems.VANILLA_CAKE.get()))
                .addCriterion("chocolate_cake", cake(MysticItems.CHOCOLATE_CAKE.get()))
        );
    }

    private static PlayerTrigger.TriggerInstance biome(ResourceKey<Biome> biome) {
        return PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.location().setBiome(biome).build());
    }

    private static CraftedItemTrigger.TriggerInstance cake(Item item) {
        return CraftedItemTrigger.TriggerInstance.item(item);
    }

    private Advancement obtainItemAdvancement(Consumer<Advancement> saver, Advancement parent, Item obtainItem, FrameType frameType) {
        String name = BuiltInRegistries.ITEM.getKey(obtainItem).getPath();
        return this.advancement(
                saver,
                parent,
                "obtain_" + name,
                obtainItem,
                null,
                frameType,
                true,
                true,
                false,
                builder -> builder
                        .addCriterion("has_" + name, InventoryChangeTrigger.TriggerInstance.hasItems(obtainItem)));
    }

    private Advancement advancement(Consumer<Advancement> saver,
                                    Advancement parent,
                                    String name,
                                    Item displayItem,
                                    FrameType frameType,
                                    Consumer<Advancement.Builder> config) {
        return this.advancement(saver, parent, name, displayItem, null, frameType, true, true, false, config);
    }

    private Advancement advancement(Consumer<Advancement> saver,
                                    Advancement parent,
                                    String name,
                                    Item displayItem,
                                    FrameType frameType,
                                    boolean showToast,
                                    boolean announceChat,
                                    boolean hidden,
                                    Consumer<Advancement.Builder> config) {
        return this.advancement(saver, parent, name, displayItem, null, frameType, showToast, announceChat, hidden, config);
    }

    private Advancement advancement(Consumer<Advancement> saver,
                                    @Nullable Advancement parent,
                                    String name,
                                    Item displayItem,
                                    @Nullable ResourceLocation background,
                                    FrameType frameType,
                                    boolean showToast,
                                    boolean announceChat,
                                    boolean hidden,
                                    Consumer<Advancement.Builder> config) {
        Advancement.Builder builder = Advancement.Builder.advancement().display(
                displayItem,
                Component.translatable("advancements." + MysticsBiomes.modId + "." + name + ".title"),
                Component.translatable("advancements." + MysticsBiomes.modId + "." + name + ".description"),
                background,
                frameType,
                showToast,
                announceChat,
                hidden
        );

        if (parent != null) {
            builder.parent(parent);
        }

        config.accept(builder);

        Advancement advancement = builder.build(MysticsBiomes.modLoc(MysticsBiomes.modId + "/" + name));
        saver.accept(advancement);
        return advancement;
    }

}