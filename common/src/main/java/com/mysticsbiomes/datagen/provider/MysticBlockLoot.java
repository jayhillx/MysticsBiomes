package com.mysticsbiomes.datagen.provider;

import com.mysticsbiomes.datagen.MysticBlockFamilies;
import com.mysticsbiomes.datagen.MysticBlockFamily;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class MysticBlockLoot extends BlockLootSubProvider {

    public MysticBlockLoot() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        MysticBlockFamilies.getAllFamilies().forEach(this::generateFor);
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

    private void createLeavesAndSaplings(Block leaves, Block sapling) {
        this.dropSelf(sapling);
        this.add(leaves, this.createLeavesDrops(leaves, sapling, 0.05F, 0.0625F, 0.083333336F, 0.1F));
    }

    private void createShearsDrop(Block block) {
        this.add(block, createShearsOnlyDrop(block));
    }

}