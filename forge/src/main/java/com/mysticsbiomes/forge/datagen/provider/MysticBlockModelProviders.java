package com.mysticsbiomes.forge.datagen.provider;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.block.LeafyBlossomsBlock;
import com.mysticsbiomes.common.block.MysticCakeBlock;
import com.mysticsbiomes.common.block.StrawberryBushBlock;
import com.mysticsbiomes.datagen.MysticBlockFamilies;
import com.mysticsbiomes.datagen.MysticBlockFamily;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.List;

public class MysticBlockModelProviders extends BlockStateProvider {

    public MysticBlockModelProviders(PackOutput output, ExistingFileHelper helper) {
        super(output, MysticsBiomes.modId, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        MysticBlockFamilies.getAllFamilies().filter(MysticBlockFamily::shouldGenerateModel).forEach(this::generateFor);
        this.createFloweringLeavesBlock(MysticBlocks.STRAWBERRY_BLOSSOMS.get());
        this.createCrossBlock(MysticBlocks.STRAWBERRY_BLOSSOM_SAPLING.get());

        this.createStrawberryBushBlock(MysticBlocks.STRAWBERRY_BUSH.get());

        this.createFloweringLeavesBlock(MysticBlocks.LAVENDER_BLOSSOMS.get());
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

        this.createCakeBlock(MysticBlocks.STRAWBERRY_CAKE.get());
        this.createCakeBlock(MysticBlocks.SWEET_STRAWBERRY_CAKE.get());
        this.createCakeBlock(MysticBlocks.VANILLA_CAKE.get());
        this.createCakeBlock(MysticBlocks.CHOCOLATE_CAKE.get());
        this.createCakeBlock(MysticBlocks.PINK_FROSTED_CAKE.get());
        this.createCakeBlock(MysticBlocks.ORANGE_FROSTED_CAKE.get());
        this.createCakeBlock(MysticBlocks.YELLOW_FROSTED_CAKE.get());
        this.createCakeBlock(MysticBlocks.LIME_FROSTED_CAKE.get());
        this.createCakeBlock(MysticBlocks.CYAN_FROSTED_CAKE.get());
        this.createCakeBlock(MysticBlocks.PURPLE_FROSTED_CAKE.get());
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void createCrossBlock(Block block) {
        this.simpleBlock(block, this.crossModelBuilder(texture(block)));
    }

    private void createLeavesBlock(Block block) {
        this.simpleBlock(block, this.leavesModelBuilder(texture(block)));
    }

    private void createFloweringLeavesBlock(Block block) {
        ModelFile[] leafyModels = new ModelFile[1];
        ModelFile[] leavesModels = new ModelFile[1];

        for (int i = 0; i < 1; i++) {
            leafyModels[i] = this.bushyLeafyBlossomsBuilder(texture(block), i);
            leavesModels[i] = this.bushyLeavesBuilder(swapBlossomsLeaves(texture(block)), i);
        }

        this.getVariantBuilder(block)
                .partialState().with(LeafyBlossomsBlock.LEAFY, true).with(LeafyBlossomsBlock.SNIPPED, true).addModels(new ConfiguredModel(this.leavesModelBuilder(texture(block))))
                .partialState().with(LeafyBlossomsBlock.LEAFY, false).with(LeafyBlossomsBlock.SNIPPED, false).addModels(new ConfiguredModel(this.leavesModelBuilder(texture(block))))
                .partialState().with(LeafyBlossomsBlock.LEAFY, true).with(LeafyBlossomsBlock.SNIPPED, false).addModels(modelFromList(List.of(leafyModels)))
                .partialState().with(LeafyBlossomsBlock.LEAFY, false).with(LeafyBlossomsBlock.SNIPPED, true).addModels(modelFromList(List.of(leavesModels)));
    }

    private void createCakeBlock(Block block) {
        MultiPartBlockStateBuilder builder = this.getMultipartBuilder(block);

        for (Direction direction : Direction.Plane.HORIZONTAL) {
            for (int bites = 0; bites <= 6; bites++) {
                builder.part()
                        .modelFile(this.cakeModelBuilder(block, bites))
                        .rotationY(facingRotation(direction))
                        .addModel()
                        .condition(MysticCakeBlock.FACING, direction)
                        .condition(MysticCakeBlock.BITES, bites);
            }

            for (MysticCakeBlock.Candle candle : MysticCakeBlock.Candle.values()) {
                if (candle == MysticCakeBlock.Candle.NONE) {
                    continue;
                }

                for (boolean lit : new boolean[]{true, false}) {
                    builder.part()
                            .modelFile(this.candleModelBuilder(block, candle, lit))
                            .rotationY(facingRotation(direction))
                            .addModel()
                            .condition(MysticCakeBlock.CANDLE, candle)
                            .condition(BlockStateProperties.LIT, lit);
                }
            }
        }
    }

    private void createStrawberryBushBlock(Block block) {
        ModelFile[] normalModels = new ModelFile[6];
        ModelFile[] sweetModels = new ModelFile[6];

        for (int i = 0; i < 6; i++) {
            normalModels[i] = this.strawberryBushModelBuilder(texture(block), i);
            sweetModels[i] = this.strawberryBushModelBuilder(texture(key(block).withPrefix("sweet_").getPath()), i);
        }

        this.getVariantBuilder(block)
                .partialState().with(StrawberryBushBlock.SWEET, false).addModels(modelFromList(List.of(normalModels)))
                .partialState().with(StrawberryBushBlock.SWEET, true).addModels(modelFromList(List.of(sweetModels)));
    }

    private BlockModelBuilder strawberryBushModelBuilder(ResourceLocation texture, int stage) {
        String suffix = "_stage" + stage;
        return this.models()
                .withExistingParent(texture.getPath() + suffix, modLoc("block/template_strawberry_bush" + suffix))
                .texture("cross", texture + suffix)
                .texture("layer", texture + "_layer")
                .renderType("cutout_mipped");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private BlockModelBuilder crossModelBuilder(ResourceLocation texture) {
        return this.models()
                .cross(texture.getPath(), texture)
                .renderType("cutout");
    }

    private BlockModelBuilder leavesModelBuilder(ResourceLocation texture) {
        return this.models()
                .leaves(texture.getPath(), texture)
                .renderType("cutout_mipped");
    }

    private BlockModelBuilder bushyLeavesBuilder(ResourceLocation texture, int variantCount) {
        return this.models()
                .withExistingParent(texture.getPath() + variantSuffix(variantCount), modLoc("block/template_bushy_leaves" + variantSuffix(variantCount)))
                .texture("all", texture)
                .texture("bushy", texture.withSuffix("_bushy"))
                .renderType("cutout_mipped");
    }

    private BlockModelBuilder bushyLeafyBlossomsBuilder(ResourceLocation texture, int variantCount) {
        return this.models()
                .withExistingParent(texture.withSuffix("_leafy").getPath() + variantSuffix(variantCount), modLoc("block/template_bushy_leaves_top_bottom" + variantSuffix(variantCount)))
                .texture("top", texture)
                .texture("side", texture.withSuffix("_leafy"))
                .texture("bottom", swapBlossomsLeaves(texture))
                .texture("bushy", texture.withSuffix("_leafy_bushy"))
                .renderType("cutout_mipped");
    }

    private static ResourceLocation swapBlossomsLeaves(ResourceLocation texture) {
        String path = texture.getPath();
        if (path.endsWith("_blossoms")) {
            return texture.withPath(path.substring(0, path.length() - "_blossoms".length()) + "_leaves");
        }

        if (path.endsWith("_leaves")) {
            return texture.withPath(path.substring(0, path.length() - "_leaves".length()) + "_blossoms");
        }

        return texture;
    }

    private BlockModelBuilder cakeModelBuilder(Block block, int bites) {
        String suffix = bites > 0 ? "_slice" + bites : "";

        return this.models()
                .withExistingParent(name(block, suffix), modLoc("block/template_cake" + suffix))
                .texture("top", texture(block, "_top"))
                .texture("side", texture(block, "_side"))
                .texture("inside", texture(block, "_inner"))
                .texture("bottom", texture(block, "_bottom"))
                .texture("particle", texture(block, "_side"));
    }

    private BlockModelBuilder candleModelBuilder(Block block, MysticCakeBlock.Candle candle, boolean lit) {
        String suffix = lit ? "_lit" : "";

        return this.models()
                .withExistingParent(name(block, "_" + candle.getSerializedName() + suffix), modLoc("block/template_candle_on_cake"))
                .texture("candle", mcLoc("block/" + candle.getSerializedName() + suffix));
    }

    private static ConfiguredModel[] modelFromList(List<ModelFile> models) {
        return models.stream().map(ConfiguredModel::new).toArray(ConfiguredModel[]::new);
    }

    private static String variantSuffix(int i) {
        return switch (i) {
            case 0 -> "";
            case 1 -> "_variant";
            default -> "_variant" + i;
        };
    }

    private static int facingRotation(Direction direction) {
        return switch (direction) {
            case EAST  -> 90;
            case SOUTH -> 180;
            case WEST  -> 270;
            default -> 0;
        };
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static ResourceLocation tintTexture(Block block) {
        return MysticsBiomes.modLoc("block/tint/" + name(block, "_tint"));
    }

    private static ResourceLocation texture(Block block) {
        return MysticsBiomes.modLoc("block/" + name(block));
    }

    private static ResourceLocation texture(Block block, String suffix) {
        return MysticsBiomes.modLoc("block/" + name(block, suffix));
    }

    private static ResourceLocation texture(String path) {
        return MysticsBiomes.modLoc("block/" + path);
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