package com.mysticsbiomes.data.provider;

import com.mysticsbiomes.common.block.MysticCandleCakeBlock;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MysticLootTablesProvider extends BlockLootSubProvider {

    public MysticLootTablesProvider() {
        super(Stream.of(Items.AIR).map(ItemLike::asItem).collect(Collectors.toSet()), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        MysticCandleCakeBlock.getMysticCandleCakes().forEach((block -> this.add(block, createCandleCakeDrops(((MysticCandleCakeBlock)block).getCandle()))));
    }

    @Override
    public Iterable<Block> getKnownBlocks() {
        return MysticCandleCakeBlock.getMysticCandleCakes();
    }

}