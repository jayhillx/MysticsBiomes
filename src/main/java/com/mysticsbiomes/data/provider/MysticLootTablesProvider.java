package com.mysticsbiomes.data.provider;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.mysticsbiomes.common.block.MysticCandleCakeBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MysticLootTablesProvider extends LootTableProvider {
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> tables = ImmutableList.of(Pair.of(MysticBlockLoot::new, LootContextParamSets.BLOCK));

    public MysticLootTablesProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return tables;
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext context) {
    }

    private static class MysticBlockLoot extends BlockLoot {

        @Override
        public void addTables() {
            MysticCandleCakeBlock.getMysticCandleCakes().forEach((block -> this.add(block, createCandleCakeDrops(((MysticCandleCakeBlock)block).getCandle()))));
        }

        @Override
        public Iterable<Block> getKnownBlocks() {
            return MysticCandleCakeBlock.getMysticCandleCakes();
        }
    }

}