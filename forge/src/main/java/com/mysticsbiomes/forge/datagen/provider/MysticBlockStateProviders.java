package com.mysticsbiomes.forge.datagen.provider;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.datagen.MysticBlockFamilies;
import com.mysticsbiomes.datagen.MysticBlockFamily;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.common.data.ExistingFileHelper;

public class MysticBlockStateProviders extends MysticBlockModels {

    public MysticBlockStateProviders(PackOutput output, ExistingFileHelper helper) {
        super(output, MysticsBiomes.modId, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        MysticBlockFamilies.getAllFamilies().filter(MysticBlockFamily::shouldGenerateModel).forEach(this::generateFor);
        this.cubeTopBottomBlock(MysticBlocks.GRASSY_LUSH_SAND.get(),
                texture(MysticBlocks.LUSH_SAND.get(), "_grassy_side"),
                texture(MysticBlocks.LUSH_SAND.get()),
                texture(MysticBlocks.LUSH_SAND.get(), "_grassy_top"));
        this.simpleBlock(MysticBlocks.LUSH_SAND.get());
        this.cubeTopBottomBlock(MysticBlocks.LUSH_SANDSTONE.get(),
                texture(MysticBlocks.LUSH_SANDSTONE.get()),
                texture(MysticBlocks.LUSH_SANDSTONE.get(), "_bottom"),
                texture(MysticBlocks.LUSH_SANDSTONE.get(), "_top"));
        this.stairsBlock(MysticBlocks.LUSH_SANDSTONE_STAIRS.get(),
                texture(MysticBlocks.LUSH_SANDSTONE.get()),
                texture(MysticBlocks.LUSH_SANDSTONE.get(), "_bottom"),
                texture(MysticBlocks.LUSH_SANDSTONE.get(), "_top"));
        this.slabBlock(MysticBlocks.LUSH_SANDSTONE_SLAB.get(),
                texture(MysticBlocks.LUSH_SANDSTONE.get()),
                texture(MysticBlocks.LUSH_SANDSTONE.get()),
                texture(MysticBlocks.LUSH_SANDSTONE.get(), "_bottom"),
                texture(MysticBlocks.LUSH_SANDSTONE.get(), "_top"));
        this.wallBlock(MysticBlocks.LUSH_SANDSTONE_WALL.get(),
                texture(MysticBlocks.LUSH_SANDSTONE.get()));
        this.cubeColumBlock(MysticBlocks.CHISELED_LUSH_SANDSTONE.get(),
                texture(MysticBlocks.LUSH_SANDSTONE.get(), "_chiseled"),
                texture(MysticBlocks.LUSH_SANDSTONE.get(), "_top"));
        this.cubeColumBlock(MysticBlocks.CUT_LUSH_SANDSTONE.get(),
                texture(MysticBlocks.LUSH_SANDSTONE.get(), "_cut"),
                texture(MysticBlocks.LUSH_SANDSTONE.get(), "_top"));
        this.slabBlock(MysticBlocks.CUT_LUSH_SANDSTONE_SLAB.get(),
                texture(MysticBlocks.CUT_LUSH_SANDSTONE.get()),
                texture(MysticBlocks.LUSH_SANDSTONE.get(), "_cut"),
                texture(MysticBlocks.LUSH_SANDSTONE.get(), "_top"),
                texture(MysticBlocks.LUSH_SANDSTONE.get(), "_top"));
        this.cubeBlock(MysticBlocks.SMOOTH_LUSH_SANDSTONE.get(),
                texture(MysticBlocks.LUSH_SANDSTONE.get(), "_top"));
        this.stairsBlock(MysticBlocks.SMOOTH_LUSH_SANDSTONE_STAIRS.get(),
                texture(MysticBlocks.LUSH_SANDSTONE.get(), "_top"));
        this.slabBlock(MysticBlocks.SMOOTH_LUSH_SANDSTONE_SLAB.get(),
                texture(MysticBlocks.LUSH_SANDSTONE.get(), "_top"));

        this.floweringLeavesBlock(MysticBlocks.STRAWBERRY_BLOSSOMS.get());
        this.crossBlock(MysticBlocks.STRAWBERRY_BLOSSOM_SAPLING.get());
        ///this.createCrossBlock(MysticBlocks.PINK_DAISIES.get());
        this.strawberryBushBlock(MysticBlocks.WILD_STRAWBERRY_BUSH.get(), texture(MysticBlocks.STRAWBERRY_BUSH.get()), true);
        this.strawberryBushBlock(MysticBlocks.STRAWBERRY_BUSH.get());

        this.floweringLeavesBlock(MysticBlocks.LAVENDER_BLOSSOMS.get());
        this.crossBlock(MysticBlocks.LAVENDER_BLOSSOM_SAPLING.get());
        this.crossBlock(MysticBlocks.LAVENDER.get(), 2);
        this.tallCrossBlock(MysticBlocks.TALL_LAVENDER.get(), texture(MysticBlocks.LAVENDER.get()));
        ///this.createLeavesBlock(MysticBlocks.BUTTERFLY_BUSH_LEAVES.get());
        ///this.createBushBlock(MysticBlocks.BUTTERFLY_BUSH.get());
        this.blockState(MysticBlocks.BUTTERFLY_NEST.get());
        this.directionalBlockState(MysticBlocks.CHRYSALIS.get());
        ///this.createGlassJar(MysticBlocks.GLASS_JAR.get());

        this.leavesBlock(MysticBlocks.PINK_CHERRY_BLOSSOMS.get());
        this.crossBlock(MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING.get());
        this.leavesBlock(MysticBlocks.WHITE_CHERRY_BLOSSOMS.get());
        this.crossBlock(MysticBlocks.WHITE_CHERRY_BLOSSOM_SAPLING.get());
        this.hangingCropBlock(MysticBlocks.CHERRY_PLANT.get());
        this.pieBlock(MysticBlocks.CHERRY_PIE.get());
        this.crossBlock(MysticBlocks.SPRING_BAMBOO_SAPLING.get());
        this.springBambooBlock(MysticBlocks.SPRING_BAMBOO.get());
        this.leavesBlock(MysticBlocks.PEONY_BUSH_LEAVES.get(), 4);
        this.bushBlock(MysticBlocks.PEONY_BUSH.get());

        this.leavesBlock(MysticBlocks.MAPLE_LEAVES.get(), 3);
        this.leafPileBlock(MysticBlocks.MAPLE_LEAF_PILE.get(), MysticBlocks.MAPLE_LEAVES.get(), 3);
        this.leafLitterBlock(MysticBlocks.MAPLE_LEAF_LITTER.get());
        this.crossBlock(MysticBlocks.MAPLE_SAPLING.get());
        this.leavesBlock(MysticBlocks.ORANGE_MAPLE_LEAVES.get(), 3);
        this.leafPileBlock(MysticBlocks.ORANGE_MAPLE_LEAF_PILE.get(), MysticBlocks.ORANGE_MAPLE_LEAVES.get(), 3);
        this.leafLitterBlock(MysticBlocks.ORANGE_MAPLE_LEAF_LITTER.get());
        this.crossBlock(MysticBlocks.ORANGE_MAPLE_SAPLING.get());
        this.leavesBlock(MysticBlocks.YELLOW_MAPLE_LEAVES.get(), 3);
        this.leafPileBlock(MysticBlocks.YELLOW_MAPLE_LEAF_PILE.get(), MysticBlocks.YELLOW_MAPLE_LEAVES.get(), 3);
        this.leafLitterBlock(MysticBlocks.YELLOW_MAPLE_LEAF_LITTER.get());
        this.crossBlock(MysticBlocks.YELLOW_MAPLE_SAPLING.get());
        this.crossBlock(MysticBlocks.ASTER.get(), 3);
        this.tallCrossBlock(MysticBlocks.GOLDENROD.get(), 2);

        this.leavesBlock(MysticBlocks.PEACH_LEAVES.get());
        this.crossBlock(MysticBlocks.PEACH_SAPLING.get());
        this.hangingCropBlock(MysticBlocks.PEACH_PLANT.get());
        this.pieBlock(MysticBlocks.PEACH_PIE.get());
        ////this.createCrossBlock(MysticBlocks.DESERT_SHRUB.get());
        this.crossBlock(MysticBlocks.DESERT_GRASS.get(), 2);
        this.crossBlock(MysticBlocks.TALL_DESERT_GRASS.get(), texture(MysticBlocks.DESERT_GRASS.get()).withSuffix("_tall"));
        this.tallCrossBlock(MysticBlocks.DESERT_LILY.get());
        this.crossBlock(MysticBlocks.WILDFLOWER.get());
        this.saguaroCactusBlock(MysticBlocks.SAGUARO_CACTUS.get());
        this.crossBlock(MysticBlocks.SAGUARO_BLOSSOM.get());

        this.leavesBlock(MysticBlocks.SEA_SHRUB_LEAVES.get());
        this.bushBlock(MysticBlocks.SEA_SHRUB.get());
        this.crossBlock(MysticBlocks.BEACH_GRASS.get(), 2);
        this.crossBlock(MysticBlocks.TALL_BEACH_GRASS.get());
        this.tallCrossBlock(MysticBlocks.SEA_OATS.get(), 2);
        this.crossBlock(MysticBlocks.SEA_THRIFT.get(), 2);
        this.milkweedBlock(MysticBlocks.MILKWEED.get());

        this.leavesBlock(MysticBlocks.TROPICAL_LEAVES.get());
        ///this.createCrossBlock(MysticBlocks.TROPICAL_VINES.get());
        this.crossBlock(MysticBlocks.TROPICAL_SAPLING.get());
        this.leavesBlock(MysticBlocks.VANILLA_LEAVES.get());
        this.crossBlock(MysticBlocks.VANILLA_SAPLING.get());
        this.vanillaOrchidBlock(MysticBlocks.VANILLA_ORCHID.get());
        ///this.createCrossBlock(MysticBlocks.JUNGLE_SHRUB.get());
        ///this.createCrossBlock(MysticBlocks.JUNGLE_GRASS.get());
        ///this.createCrossBlock(MysticBlocks.TALL_JUNGLE_GRASS.get(), texture(MysticBlocks.JUNGLE_GRASS.get()).withSuffix("_tall"));
        this.leavesBlock(MysticBlocks.HYDRANGEA_BUSH_LEAVES.get(), 4);
        this.bushBlock(MysticBlocks.HYDRANGEA_BUSH.get());
        this.crossBlock(MysticBlocks.HIBISCUS.get());

        this.cakeBlock(MysticBlocks.STRAWBERRY_CAKE.get());
        this.cakeBlock(MysticBlocks.SWEET_STRAWBERRY_CAKE.get());
        this.cakeBlock(MysticBlocks.VANILLA_CAKE.get());
        this.cakeBlock(MysticBlocks.CHOCOLATE_CAKE.get());
        this.cakeBlock(MysticBlocks.PINK_FROSTED_CAKE.get());
        this.cakeBlock(MysticBlocks.ORANGE_FROSTED_CAKE.get());
        this.cakeBlock(MysticBlocks.YELLOW_FROSTED_CAKE.get());
        this.cakeBlock(MysticBlocks.LIME_FROSTED_CAKE.get());
        this.cakeBlock(MysticBlocks.CYAN_FROSTED_CAKE.get());
        this.cakeBlock(MysticBlocks.PURPLE_FROSTED_CAKE.get());
        ///this.createCakeBlock(MysticBlocks.RAINBOW_FROSTED_CAKE.get());

        this.pottedPlantBlock(MysticBlocks.POTTED_STRAWBERRY_BLOSSOM_SAPLING.get());
        this.pottedPlantBlock(MysticBlocks.POTTED_STRAWBERRY_BUSH.get());
        ///this.pottedPlantBlock(MysticBlocks.POTTED_PINK_DAISIES.get());
        this.pottedPlantBlock(MysticBlocks.POTTED_LAVENDER_BLOSSOM_SAPLING.get());
        this.pottedPlantBlock(MysticBlocks.POTTED_LAVENDER.get(), texture(MysticBlocks.LAVENDER.get(), "_potted"));
        ///this.pottedPlantBlock(MysticBlocks.POTTED_BUTTERFLY_BUSH.get());
        this.pottedPlantBlock(MysticBlocks.POTTED_PINK_CHERRY_BLOSSOM_SAPLING.get());
        this.pottedPlantBlock(MysticBlocks.POTTED_WHITE_CHERRY_BLOSSOM_SAPLING.get());
        this.blockState(MysticBlocks.POTTED_SPRING_BAMBOO.get());
        this.pottedBushBlock(MysticBlocks.POTTED_PEONY_BUSH.get());
        this.pottedPlantBlock(MysticBlocks.POTTED_MAPLE_SAPLING.get());
        this.pottedPlantBlock(MysticBlocks.POTTED_ORANGE_MAPLE_SAPLING.get());
        this.pottedPlantBlock(MysticBlocks.POTTED_YELLOW_MAPLE_SAPLING.get());
        this.pottedPlantBlock(MysticBlocks.POTTED_ASTER.get());
        this.pottedPlantBlock(MysticBlocks.POTTED_GOLDENROD.get(), texture(MysticBlocks.GOLDENROD.get(), "_potted"));
        this.pottedPlantBlock(MysticBlocks.POTTED_PEACH_SAPLING.get());
        ///this.pottedPlantBlock(MysticBlocks.POTTED_DESERT_SHRUB.get());
        this.pottedPlantBlock(MysticBlocks.POTTED_DESERT_LILY.get(), texture(MysticBlocks.DESERT_LILY.get(), "_potted"));
        this.pottedPlantBlock(MysticBlocks.POTTED_WILDFLOWER.get(), texture(MysticBlocks.WILDFLOWER.get(), "_potted"));
        this.blockState(MysticBlocks.POTTED_SAGUARO_CACTUS.get());
        ///this.blockState(MysticBlocks.POTTED_PRICKLY_CACTUS.get());
        this.pottedBushBlock(MysticBlocks.POTTED_SEA_SHRUB.get());
        this.blockState(MysticBlocks.POTTED_MILKWEED.get());
        this.pottedPlantBlock(MysticBlocks.POTTED_SEA_THRIFT.get(), texture(MysticBlocks.SEA_THRIFT.get(), "_potted"));
        this.pottedPlantBlock(MysticBlocks.POTTED_SEA_OATS.get(), texture(MysticBlocks.SEA_OATS.get(), "_potted"));
        this.pottedPlantBlock(MysticBlocks.POTTED_TROPICAL_SAPLING.get());
        this.pottedPlantBlock(MysticBlocks.POTTED_VANILLA_SAPLING.get());
        ///this.pottedPlantBlock(MysticBlocks.POTTED_JUNGLE_SHRUB.get());
        this.pottedBushBlock(MysticBlocks.POTTED_HYDRANGEA_BUSH.get());
        this.pottedPlantBlock(MysticBlocks.POTTED_HIBISCUS.get());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void generateFor(MysticBlockFamily family) {
        family.getVariants().forEach((variant, block) -> {
            Block base = family.getBaseBlock().get();
            Block source = family.get(variant.source()).get();

            switch (variant) {
                case LOG, SECONDARY_LOG, STRIPPED_LOG -> this.logBlock(block.get());
                case WOOD, SECONDARY_WOOD, STRIPPED_WOOD -> this.woodBlock(block.get(), texture(source));
                case STAIRS -> this.stairsBlock(block.get(), texture(base));
                case SLAB -> this.slabBlock(block.get(), texture(base));
                case FENCE -> this.fenceBlock(block.get(), texture(base));
                case FENCE_GATE -> this.fenceGateBlock(block.get(), texture(base));
                case BUTTON -> this.buttonBlock(block.get(), texture(base));
                case PRESSURE_PLATE -> this.pressurePlateBlock(block.get(), texture(base));
                case TRAPDOOR -> this.trapdoorBlock(block.get());
                case DOOR -> this.doorBlock(block.get());
                case SIGN -> this.signBlock(block.get(), source, texture(base));
                case HANGING_SIGN -> {
                    if (family.get(MysticBlockFamily.Variant.STRIPPED_LOG).get() != null) {
                        this.hangingSignBlock(block.get(), source, texture(family.get(MysticBlockFamily.Variant.STRIPPED_LOG).get()));
                    }
                }
                default -> {
                    if (variant != MysticBlockFamily.Variant.WALL_SIGN
                            && variant != MysticBlockFamily.Variant.WALL_HANGING_SIGN
                            && variant != MysticBlockFamily.Variant.CHISELED
                            && variant != MysticBlockFamily.Variant.CUT) {
                        this.simpleBlock(block.get());
                    }
                }
            }
        });
    }

}