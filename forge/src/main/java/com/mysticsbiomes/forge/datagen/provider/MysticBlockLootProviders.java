package com.mysticsbiomes.forge.datagen.provider;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.block.StrawberryBushBlock;
import com.mysticsbiomes.datagen.MysticBlockFamilies;
import com.mysticsbiomes.datagen.MysticBlockFamily;
import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class MysticBlockLootProviders extends BlockLootSubProvider {

    public MysticBlockLootProviders() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        MysticBlockFamilies.getAllFamilies().forEach(this::generateFor);
        this.dropSelf(MysticBlocks.GRASSY_LUSH_SAND.get());
        this.dropSelf(MysticBlocks.LUSH_SAND.get());

        this.createLeavesAndSaplingDrop(MysticBlocks.STRAWBERRY_BLOSSOMS.get(), MysticBlocks.STRAWBERRY_BLOSSOM_SAPLING.get());

        this.add(MysticBlocks.STRAWBERRY_BUSH.get(), (block) -> this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StrawberryBushBlock.AGE, 5)))
                        .add(LootItem.lootTableItem(MysticItems.STRAWBERRY.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))
        ));

        this.createLeavesAndSaplingDrop(MysticBlocks.LAVENDER_BLOSSOMS.get(), MysticBlocks.LAVENDER_BLOSSOM_SAPLING.get());

        this.createLeavesAndSaplingDrop(MysticBlocks.PINK_CHERRY_BLOSSOMS.get(), MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING.get());
        this.createLeavesAndSaplingDrop(MysticBlocks.WHITE_CHERRY_BLOSSOMS.get(), MysticBlocks.WHITE_CHERRY_BLOSSOM_SAPLING.get());

        this.createLeavesAndSaplingDrop(MysticBlocks.PEACH_LEAVES.get(), MysticBlocks.PEACH_SAPLING.get());

        this.createLeavesAndSaplingDrop(MysticBlocks.MAPLE_LEAVES.get(), MysticBlocks.MAPLE_SAPLING.get());
        this.createLeavesAndSaplingDrop(MysticBlocks.SPICED_MAPLE_LEAVES.get(), MysticBlocks.SPICED_MAPLE_SAPLING.get());
        this.createLeavesAndSaplingDrop(MysticBlocks.ORANGE_MAPLE_LEAVES.get(), MysticBlocks.ORANGE_MAPLE_SAPLING.get());
        this.createLeavesAndSaplingDrop(MysticBlocks.YELLOW_MAPLE_LEAVES.get(), MysticBlocks.YELLOW_MAPLE_SAPLING.get());

        this.createLeavesAndSaplingDrop(MysticBlocks.SEA_SHRUB_LEAVES.get(), MysticBlocks.SEA_SHRUB.get());

        this.createLeavesAndSaplingDrop(MysticBlocks.TROPICAL_LEAVES.get(), MysticBlocks.TROPICAL_SAPLING.get());
        this.createLeavesAndSaplingDrop(MysticBlocks.VANILLA_LEAVES.get(), MysticBlocks.VANILLA_SAPLING.get());

        this.add(MysticBlocks.STRAWBERRY_CAKE.get(), noDrop());
        this.add(MysticBlocks.SWEET_STRAWBERRY_CAKE.get(), noDrop());
        this.add(MysticBlocks.VANILLA_CAKE.get(), noDrop());
        this.add(MysticBlocks.CHOCOLATE_CAKE.get(), noDrop());
        this.add(MysticBlocks.PINK_FROSTED_CAKE.get(), noDrop());
        this.add(MysticBlocks.ORANGE_FROSTED_CAKE.get(), noDrop());
        this.add(MysticBlocks.YELLOW_FROSTED_CAKE.get(), noDrop());
        this.add(MysticBlocks.LIME_FROSTED_CAKE.get(), noDrop());
        this.add(MysticBlocks.CYAN_FROSTED_CAKE.get(), noDrop());
        this.add(MysticBlocks.PURPLE_FROSTED_CAKE.get(), noDrop());
    }

    private void generateFor(MysticBlockFamily family) {
        family.getVariants().forEach((variant, block) -> {
            switch (variant) {
                case SLAB -> this.add(block, this::createSlabItemTable);
                case DOOR -> this.add(block, this::createDoorTable);
                default -> this.dropSelf(block);
            }
        });
    }

    private void createLeavesAndSaplingDrop(Block leavesBlock, Block saplingBlock) {
        this.dropSelf(saplingBlock);
        this.add(leavesBlock, this.createLeavesDrops(leavesBlock, saplingBlock, 0.05F, 0.0625F, 0.083333336F, 0.1F));
    }

    private void createShearsDrop(Block block) {
        this.add(block, createShearsOnlyDrop(block));
    }

    @Override
    public Iterable<Block> getKnownBlocks() {
        return MysticsBiomes.getEntriesFromRegistry(BuiltInRegistries.BLOCK);
    }

}