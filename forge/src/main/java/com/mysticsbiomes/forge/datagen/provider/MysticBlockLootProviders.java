package com.mysticsbiomes.forge.datagen.provider;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.block.FruitPlantBlock;
import com.mysticsbiomes.common.block.MapleLeafPileBlock;
import com.mysticsbiomes.common.block.StrawberryBushBlock;
import com.mysticsbiomes.common.block.VanillaOrchidBlock;
import com.mysticsbiomes.datagen.MysticBlockFamilies;
import com.mysticsbiomes.datagen.MysticBlockFamily;
import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class MysticBlockLootProviders extends BlockLootSubProvider {

    public MysticBlockLootProviders() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        MysticBlockFamilies.getAllFamilies().forEach(this::generateFor);
        this.add(MysticBlocks.GRASSY_LUSH_SAND.get(), (block) -> {
            return this.createSingleItemTableWithSilkTouch(block, MysticBlocks.LUSH_SAND.get());
        });
        this.dropSelf(MysticBlocks.LUSH_SAND.get());

        this.createLeavesAndSaplingDrop(MysticBlocks.STRAWBERRY_BLOSSOMS.get(), MysticBlocks.STRAWBERRY_BLOSSOM_SAPLING.get());
        ///this.dropSelf(MysticBlocks.PINK_DAISIES.get());
        StatePropertiesPredicate.Builder strawberryBuilder = StatePropertiesPredicate.Builder.properties().hasProperty(StrawberryBushBlock.AGE, 5);
        this.createFruitCropDrop(MysticBlocks.WILD_STRAWBERRY_BUSH.get(), MysticItems.STRAWBERRY.get(), strawberryBuilder, UniformGenerator.between(1, 3));
        this.createFruitCropDrop(MysticBlocks.STRAWBERRY_BUSH.get(), MysticItems.STRAWBERRY.get(), strawberryBuilder, UniformGenerator.between(1, 3));
        this.add(MysticBlocks.STRAWBERRY_CAKE.get(), noDrop());
        this.add(MysticBlocks.SWEET_STRAWBERRY_CAKE.get(), noDrop());

        this.createLeavesAndSaplingDrop(MysticBlocks.LAVENDER_BLOSSOMS.get(), MysticBlocks.LAVENDER_BLOSSOM_SAPLING.get());
        ///this.createLeavesAndSaplingDrop(MysticBlocks.BUTTERFLY_BUSH_LEAVES.get(), MysticBlocks.BUTTERFLY_BUSH.get());
        this.dropWhenSilkTouch(MysticBlocks.BUTTERFLY_NEST.get());
        this.dropWhenSilkTouch(MysticBlocks.CHRYSALIS.get());
        this.dropSelf(MysticBlocks.LAVENDER.get());
        this.createDoublePlantDrop(MysticBlocks.TALL_LAVENDER.get());
        this.dropSelf(MysticBlocks.GLASS_JAR.get());

        this.createLeavesAndSaplingDrop(MysticBlocks.PINK_CHERRY_BLOSSOMS.get(), MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING.get(), MysticItems.CHERRIES.get());
        this.createLeavesAndSaplingDrop(MysticBlocks.WHITE_CHERRY_BLOSSOMS.get(), MysticBlocks.WHITE_CHERRY_BLOSSOM_SAPLING.get(), MysticItems.CHERRIES.get());
        this.createLeavesAndSaplingDrop(MysticBlocks.PEONY_BUSH_LEAVES.get(), MysticBlocks.PEONY_BUSH.get());
        StatePropertiesPredicate.Builder fruitPlantBuilder = StatePropertiesPredicate.Builder.properties().hasProperty(FruitPlantBlock.AGE, 4);
        this.createFruitCropDrop(MysticBlocks.CHERRY_PLANT.get(), MysticItems.CHERRIES.get(), fruitPlantBuilder, ConstantValue.exactly(1));
        this.add(MysticBlocks.CHERRY_PIE.get(), noDrop());
        this.dropSelf(MysticBlocks.SPRING_BAMBOO_SAPLING.get());
        this.dropSelf(MysticBlocks.SPRING_BAMBOO.get());

        this.createLeavesAndSaplingDrop(MysticBlocks.PEACH_LEAVES.get(), MysticBlocks.PEACH_SAPLING.get(), MysticItems.PEACH.get());
        this.createFruitCropDrop(MysticBlocks.PEACH_PLANT.get(), MysticItems.PEACH.get(), fruitPlantBuilder, ConstantValue.exactly(1));
        this.add(MysticBlocks.PEACH_PIE.get(), noDrop());
        this.dropWhenSilkTouch(MysticBlocks.DESERT_GRASS.get());
        this.dropWhenSilkTouch(MysticBlocks.TALL_DESERT_GRASS.get());
        this.createDoublePlantDrop(MysticBlocks.DESERT_LILY.get());
        this.dropSelf(MysticBlocks.WILDFLOWER.get());
        this.dropSelf(MysticBlocks.SAGUARO_CACTUS.get());
        this.dropSelf(MysticBlocks.SAGUARO_BLOSSOM.get());

        this.createLeavesAndSaplingDrop(MysticBlocks.MAPLE_LEAVES.get(), MysticBlocks.MAPLE_SAPLING.get());
        this.createLeafPileDrop(MysticBlocks.MAPLE_LEAF_PILE.get(), MysticBlocks.MAPLE_LEAVES.get());
        this.add(MysticBlocks.MAPLE_LEAF_LITTER.get(), this::createPetalsDrops);
        this.createLeavesAndSaplingDrop(MysticBlocks.ORANGE_MAPLE_LEAVES.get(), MysticBlocks.ORANGE_MAPLE_SAPLING.get());
        this.createLeafPileDrop(MysticBlocks.ORANGE_MAPLE_LEAF_PILE.get(), MysticBlocks.ORANGE_MAPLE_LEAVES.get());
        this.add(MysticBlocks.ORANGE_MAPLE_LEAF_LITTER.get(), this::createPetalsDrops);
        this.createLeavesAndSaplingDrop(MysticBlocks.YELLOW_MAPLE_LEAVES.get(), MysticBlocks.YELLOW_MAPLE_SAPLING.get());
        this.createLeafPileDrop(MysticBlocks.YELLOW_MAPLE_LEAF_PILE.get(), MysticBlocks.YELLOW_MAPLE_LEAVES.get());
        this.add(MysticBlocks.YELLOW_MAPLE_LEAF_LITTER.get(), this::createPetalsDrops);
        this.dropSelf(MysticBlocks.ASTER.get());
        this.createDoublePlantDrop(MysticBlocks.GOLDENROD.get());

        this.createLeavesAndSaplingDrop(MysticBlocks.SEA_SHRUB_LEAVES.get(), MysticBlocks.SEA_SHRUB.get());
        this.dropWhenSilkTouch(MysticBlocks.BEACH_GRASS.get());
        this.dropWhenSilkTouch(MysticBlocks.TALL_BEACH_GRASS.get());
        this.createDoublePlantDrop(MysticBlocks.MILKWEED.get());
        this.dropSelf(MysticBlocks.SEA_THRIFT.get());
        this.createDoublePlantDrop(MysticBlocks.SEA_OATS.get());

        this.createLeavesAndSaplingDrop(MysticBlocks.TROPICAL_LEAVES.get(), MysticBlocks.TROPICAL_SAPLING.get());
        this.createLeavesAndSaplingDrop(MysticBlocks.VANILLA_LEAVES.get(), MysticBlocks.VANILLA_SAPLING.get());
        this.createLeavesAndSaplingDrop(MysticBlocks.HYDRANGEA_BUSH_LEAVES.get(), MysticBlocks.HYDRANGEA_BUSH.get());
        this.dropSelf(MysticBlocks.HIBISCUS.get());
        this.add(MysticBlocks.VANILLA_ORCHID.get(), (block) -> this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(VanillaOrchidBlock.AGE, 2)))
                        .add(LootItem.lootTableItem(MysticItems.VANILLA_BEANS.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))
        ));
        this.add(MysticBlocks.VANILLA_CAKE.get(), noDrop());
        this.add(MysticBlocks.CHOCOLATE_CAKE.get(), noDrop());

        this.add(MysticBlocks.PINK_FROSTED_CAKE.get(), noDrop());
        this.add(MysticBlocks.ORANGE_FROSTED_CAKE.get(), noDrop());
        this.add(MysticBlocks.YELLOW_FROSTED_CAKE.get(), noDrop());
        this.add(MysticBlocks.LIME_FROSTED_CAKE.get(), noDrop());
        this.add(MysticBlocks.CYAN_FROSTED_CAKE.get(), noDrop());
        this.add(MysticBlocks.PURPLE_FROSTED_CAKE.get(), noDrop());
        ///this.add(MysticBlocks.RAINBOW_FROSTED_CAKE.get(), noDrop());

        this.dropPottedContents(MysticBlocks.POTTED_STRAWBERRY_BLOSSOM_SAPLING.get());
        this.dropPottedContents(MysticBlocks.POTTED_STRAWBERRY_BUSH.get());
        ///this.dropPottedContents(MysticBlocks.POTTED_PINK_DAISIES.get());
        this.dropPottedContents(MysticBlocks.POTTED_LAVENDER_BLOSSOM_SAPLING.get());
        this.dropPottedContents(MysticBlocks.POTTED_LAVENDER.get());
        ///this.dropPottedContents(MysticBlocks.POTTED_BUTTERFLY_BUSH.get());
        this.dropPottedContents(MysticBlocks.POTTED_PINK_CHERRY_BLOSSOM_SAPLING.get());
        this.dropPottedContents(MysticBlocks.POTTED_WHITE_CHERRY_BLOSSOM_SAPLING.get());
        this.dropPottedContents(MysticBlocks.POTTED_SPRING_BAMBOO.get());
        this.dropPottedContents(MysticBlocks.POTTED_PEONY_BUSH.get());
        this.dropPottedContents(MysticBlocks.POTTED_MAPLE_SAPLING.get());
        this.dropPottedContents(MysticBlocks.POTTED_ORANGE_MAPLE_SAPLING.get());
        this.dropPottedContents(MysticBlocks.POTTED_YELLOW_MAPLE_SAPLING.get());
        this.dropPottedContents(MysticBlocks.POTTED_ASTER.get());
        this.dropPottedContents(MysticBlocks.POTTED_GOLDENROD.get());
        this.dropPottedContents(MysticBlocks.POTTED_PEACH_SAPLING.get());
        ///this.dropPottedContents(MysticBlocks.POTTED_DESERT_SHRUB.get());
        this.dropPottedContents(MysticBlocks.POTTED_DESERT_LILY.get());
        this.dropPottedContents(MysticBlocks.POTTED_WILDFLOWER.get());
        this.dropPottedContents(MysticBlocks.POTTED_SAGUARO_CACTUS.get());
        ///this.dropPottedContents(MysticBlocks.POTTED_PRICKLY_CACTUS.get());
        this.dropPottedContents(MysticBlocks.POTTED_SEA_SHRUB.get());
        this.dropPottedContents(MysticBlocks.POTTED_MILKWEED.get());
        this.dropPottedContents(MysticBlocks.POTTED_SEA_THRIFT.get());
        this.dropPottedContents(MysticBlocks.POTTED_SEA_OATS.get());
        this.dropPottedContents(MysticBlocks.POTTED_TROPICAL_SAPLING.get());
        this.dropPottedContents(MysticBlocks.POTTED_VANILLA_SAPLING.get());
        ///this.dropPottedContents(MysticBlocks.POTTED_JUNGLE_SHRUB.get());
        this.dropPottedContents(MysticBlocks.POTTED_HYDRANGEA_BUSH.get());
        this.dropPottedContents(MysticBlocks.POTTED_HIBISCUS.get());
    }

    private void generateFor(MysticBlockFamily family) {
        family.getVariants().forEach((variant, block) -> {
            switch (variant) {
                case SLAB -> this.add(block.get(), this::createSlabItemTable);
                case DOOR -> this.add(block.get(), this::createDoorTable);
                default -> this.dropSelf(block.get());
            }
        });
    }

    private void createLeavesAndSaplingDrop(Block leavesBlock, Block saplingBlock) {
        this.dropSelf(saplingBlock);
        this.add(leavesBlock, this.createLeavesDrops(leavesBlock, saplingBlock, 0.05F, 0.0625F, 0.083333336F, 0.1F));
    }

    private void createLeavesAndSaplingDrop(Block leavesBlock, Block saplingBlock, Item fruitItem) {
        this.dropSelf(saplingBlock);
        this.add(leavesBlock, this.createLeavesDrops(leavesBlock, saplingBlock, 0.05F, 0.0625F, 0.083333336F, 0.1F)
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(HAS_SHEARS.or(HAS_SILK_TOUCH).invert())
                        .add(this.applyExplosionCondition(leavesBlock, LootItem.lootTableItem(fruitItem))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F)))));
    }

    private void createDoublePlantDrop(Block block) {
        this.add(block, this.createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
    }

    private void createLeafPileDrop(Block block, Block leavesBlock) {
        this.add(block, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(AlternativesEntry.alternatives(MapleLeafPileBlock.LAYERS.getPossibleValues(), (layers) -> {
                            return layers == 8
                                    ? LootItem.lootTableItem(leavesBlock)
                                    : LootItem.lootTableItem(block)
                                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(layers)))
                                    .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MapleLeafPileBlock.LAYERS, layers)));
                        }).when(HAS_SHEARS.or(HAS_SILK_TOUCH))))
        );
    }

    private void createFruitCropDrop(Block block, Item item, StatePropertiesPredicate.Builder properties, NumberProvider count) {
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(properties))
                        .add(LootItem.lootTableItem(item))
                        .apply(SetItemCountFunction.setCount(count))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))
        ));
    }

    @Override
    public Iterable<Block> getKnownBlocks() {
        return MysticsBiomes.getEntriesFromRegistry(BuiltInRegistries.BLOCK);
    }

}