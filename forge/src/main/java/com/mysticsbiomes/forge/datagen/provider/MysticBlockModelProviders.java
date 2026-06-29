package com.mysticsbiomes.forge.datagen.provider;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.datagen.MysticBlockFamilies;
import com.mysticsbiomes.datagen.MysticBlockFamily;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

public class MysticBlockModelProviders extends BlockStateProvider {

    public MysticBlockModelProviders(PackOutput output, ExistingFileHelper helper) {
        super(output, MysticsBiomes.modId, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        MysticBlockFamilies.getAllFamilies().filter(MysticBlockFamily::shouldGenerateModel).forEach(this::generateFor);
        this.createLeavesBlock(MysticBlocks.STRAWBERRY_BLOSSOMS.get());
        this.createCrossBlock(MysticBlocks.STRAWBERRY_BLOSSOM_SAPLING.get());
        this.createLeavesBlock(MysticBlocks.LAVENDER_BLOSSOMS.get());
        this.createCrossBlock(MysticBlocks.LAVENDER_BLOSSOM_SAPLING.get());
        ///this.createLeavesBlock(MysticBlocks.BUTTERFLY_BUSH_LEAVES.get());
        ///this.createBushBlock(MysticBlocks.BUTTERFLY_BUSH.get());
        this.createLeavesBlock(MysticBlocks.PINK_CHERRY_BLOSSOMS.get());
        this.createCrossBlock(MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING.get());
        this.createLeavesBlock(MysticBlocks.WHITE_CHERRY_BLOSSOMS.get());
        this.createCrossBlock(MysticBlocks.WHITE_CHERRY_BLOSSOM_SAPLING.get());
        ///this.createLeavesBlock(MysticBlocks.PEONY_BUSH_LEAVES.get());
        ///this.createBushBlock(MysticBlocks.PEONY_BUSH.get());
        this.createLeavesBlock(MysticBlocks.MAPLE_LEAVES.get());
        this.createCrossBlock(MysticBlocks.MAPLE_SAPLING.get());
        this.createLeavesBlock(MysticBlocks.SPICED_MAPLE_LEAVES.get());
        this.createCrossBlock(MysticBlocks.SPICED_MAPLE_SAPLING.get());
        this.createLeavesBlock(MysticBlocks.ORANGE_MAPLE_LEAVES.get());
        this.createCrossBlock(MysticBlocks.ORANGE_MAPLE_SAPLING.get());
        this.createLeavesBlock(MysticBlocks.YELLOW_MAPLE_LEAVES.get());
        this.createCrossBlock(MysticBlocks.YELLOW_MAPLE_SAPLING.get());
        this.createLeavesBlock(MysticBlocks.PEACH_LEAVES.get());
        this.createCrossBlock(MysticBlocks.PEACH_SAPLING.get());
        ///this.createShrubBlock(MysticBlocks.DESERT_SHRUB.get());
        this.createLeavesBlock(MysticBlocks.SEA_SHRUB_LEAVES.get());
        this.createCrossBlock(MysticBlocks.SEA_SHRUB.get());
        this.createLeavesBlock(MysticBlocks.TROPICAL_LEAVES.get());
        this.createCrossBlock(MysticBlocks.TROPICAL_SAPLING.get());
        this.createLeavesBlock(MysticBlocks.VANILLA_LEAVES.get());
        this.createCrossBlock(MysticBlocks.VANILLA_SAPLING.get());
        ///this.createLeavesBlock(MysticBlocks.HYDRANGEA_BUSH_LEAVES.get());
        ///this.createBushBlock(MysticBlocks.HYDRANGEA_BUSH.get());
    }

    private void generateFor(MysticBlockFamily family) {
        family.getVariants().forEach((variant, block) -> {
            Block base = family.getBaseBlock().get();
            Block source = family.get(variant.source()).get();

            switch (variant) {
                case LOG, SECONDARY_LOG, STRIPPED_LOG -> this.logBlock((RotatedPillarBlock)block);
                case WOOD, SECONDARY_WOOD, STRIPPED_WOOD -> this.axisBlock((RotatedPillarBlock)block, texture(source), texture(source));
                case STAIRS -> this.stairsBlock((StairBlock)block, texture(base));
                case SLAB -> this.slabBlock((SlabBlock)block, texture(base), texture(base));
                case FENCE -> this.fenceBlock((FenceBlock)block, texture(base));
                case FENCE_GATE -> this.fenceGateBlock((FenceGateBlock)block, texture(base));
                case BUTTON -> this.buttonBlock((ButtonBlock)block, texture(base));
                case PRESSURE_PLATE -> this.pressurePlateBlock((PressurePlateBlock)block, texture(base));
                case TRAPDOOR -> this.trapdoorBlockWithRenderType((TrapDoorBlock)block, texture(block), true, mcLoc("cutout"));
                case DOOR -> this.doorBlockWithRenderType((DoorBlock)block, texture(block, "_bottom"), texture(block, "_top"), mcLoc("cutout"));
                case SIGN -> this.signBlock((StandingSignBlock)block, (WallSignBlock)source, texture(base));
                case WALL -> this.wallBlock((WallBlock)block, texture(base));
                case FULL -> this.simpleBlock(block);
                default -> {
                    if (variant != MysticBlockFamily.Variant.WALL_SIGN && variant != MysticBlockFamily.Variant.WALL_HANGING_SIGN) {
                        this.simpleBlock(block);
                    }
                }
            }
        });
    }

    private void createCrossBlock(Block block) {
        this.simpleBlock(block, this.crossModelBuilder(texture(block)));
    }

    private BlockModelBuilder crossModelBuilder(ResourceLocation texture) {
        return this.models()
                .cross(texture.getPath(), texture)
                .renderType("cutout");
    }

    private void createLeavesBlock(Block block) {
        this.simpleBlock(block, this.leavesModel(texture(block)));
    }

    private ConfiguredModel leavesModel(ResourceLocation texture) {
        return new ConfiguredModel(this.models()
                .leaves(texture.getPath(), texture)
                .renderType("cutout_mipped"));
    }

    private static ResourceLocation tintTexture(Block block) {
        return MysticsBiomes.modLoc("block/tint/" + name(block, "_tint"));
    }

    private static ResourceLocation texture(Block block) {
        return MysticsBiomes.modLoc("block/" + name(block));
    }

    private static ResourceLocation texture(Block block, String suffix) {
        return MysticsBiomes.modLoc("block/" + name(block, suffix));
    }

    private static String name(Block block) {
        return key(block).getPath();
    }

    private static String name(Block block, String suffix) {
        return key(block).withSuffix(suffix).getPath();
    }

    private static ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

}