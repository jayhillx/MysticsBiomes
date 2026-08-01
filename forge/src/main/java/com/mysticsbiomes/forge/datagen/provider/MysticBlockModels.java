package com.mysticsbiomes.forge.datagen.provider;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.block.*;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BambooLeaves;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Function;
import java.util.stream.Stream;

public abstract class MysticBlockModels extends BlockStateProvider {

    public MysticBlockModels(PackOutput output, String modId, ExistingFileHelper helper) {
        super(output, modId, helper);
    }

    protected ModelFile.ExistingModelFile existingModel(ResourceLocation texture) {
        return this.models().getExistingFile(ResourceLocation.parse(texture.toString()));
    }

    /**
     * only create the blockstate of the provided block. using this for blocks that have already created model files.
     */
    protected void blockState(Block block) {
        this.getVariantBuilder(block)
                .partialState()
                .modelForState().modelFile(this.existingModel(texture(block))).addModel();
    }

    protected void directionalBlockState(Block block) {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            this.getVariantBuilder(block)
                    .partialState().with(HorizontalDirectionalBlock.FACING, direction)
                    .modelForState().modelFile(this.existingModel(texture(block))).addModel();
        }
    }

    protected void cubeBlock(Block block, ResourceLocation texture) {
        this.simpleBlock(block, this.models()
                .cubeAll(name(block), texture));
    }

    protected void cubeTopBottomBlock(Block block, ResourceLocation side, ResourceLocation bottom, ResourceLocation top) {
        this.simpleBlock(block, this.models()
                .cubeBottomTop(name(block), side, bottom, top));
    }

    protected void cubeColumBlock(Block block, ResourceLocation side, ResourceLocation end) {
        this.simpleBlock(block, this.models()
                .cubeColumn(name(block), side, end));
    }

    protected void logBlock(Block block) {
        this.axisBlock((RotatedPillarBlock) block, texture(block), texture(block, "_top"));
    }

    protected void woodBlock(Block block, ResourceLocation texture) {
        this.axisBlock((RotatedPillarBlock) block, texture, texture);
    }

    protected void stairsBlock(Block block, ResourceLocation texture) {
        this.stairsBlock((StairBlock) block, texture);
    }

    protected void stairsBlock(Block block, ResourceLocation side, ResourceLocation bottom, ResourceLocation top) {
        this.stairsBlock((StairBlock) block, side, bottom, top);
    }

    protected void slabBlock(Block block, ResourceLocation texture) {
        this.slabBlock((SlabBlock) block, texture, texture);
    }

    protected void slabBlock(Block block, ResourceLocation doubleSlab, ResourceLocation side, ResourceLocation bottom, ResourceLocation top) {
        this.slabBlock((SlabBlock) block, doubleSlab, side, bottom, top);
    }

    protected void fenceBlock(Block block, ResourceLocation texture) {
        this.fenceBlock((FenceBlock) block, texture);
    }

    protected void fenceGateBlock(Block block, ResourceLocation texture) {
        this.fenceGateBlock((FenceGateBlock) block, texture);
    }

    protected void buttonBlock(Block block, ResourceLocation texture) {
        this.buttonBlock((ButtonBlock) block, texture);
    }

    protected void pressurePlateBlock(Block block, ResourceLocation texture) {
        this.pressurePlateBlock((PressurePlateBlock) block, texture);
    }

    protected void trapdoorBlock(Block block) {
        this.trapdoorBlockWithRenderType((TrapDoorBlock) block, texture(block), true, mcLoc("cutout"));
    }

    protected void doorBlock(Block block) {
        this.doorBlockWithRenderType((DoorBlock) block, texture(block, "_bottom"), texture(block, "_top"), mcLoc("cutout"));
    }

    protected void signBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile model = this.models().sign(name(signBlock), texture);
        this.signBlock((StandingSignBlock) signBlock, (WallSignBlock) wallSignBlock, model);
    }

    protected void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile model = this.models().sign(name(signBlock), texture);
        this.simpleBlock(signBlock, model);
        this.simpleBlock(wallSignBlock, model);
    }

    protected void wallBlock(Block block, ResourceLocation texture) {
        this.wallBlock((WallBlock) block, texture);
    }

    protected void pottedPlantBlock(Block block) {
        this.simpleBlock(block, this.pottedPlantModel(texture(block)));
    }

    protected void pottedPlantBlock(Block block, ResourceLocation texture) {
        this.simpleBlock(block, this.pottedPlantModel(texture));
    }

    protected void pottedBushBlock(Block block) {
        this.simpleBlock(block, this.pottedBushModel(texture(block)));
    }

    protected void crossBlock(Block block) {
        this.crossBlock(block, texture(block), 1);
    }

    protected void crossBlock(Block block, int variantCount) {
        this.crossBlock(block, texture(block), variantCount);
    }

    protected void crossBlock(Block block, ResourceLocation texture) {
        this.crossBlock(block, texture, 1);
    }

    protected void crossBlock(Block block, ResourceLocation texture, int variantCount) {
        for (int i = 0; i < variantCount; i++) {
            ModelFile crossModel = this.crossModel(texture.withSuffix(variantSuffix(i)));

            this.getVariantBuilder(block)
                    .partialState()
                    .addModels(new ConfiguredModel(crossModel));
        }
    }

    protected void tallCrossBlock(Block block) {
        this.tallCrossBlock(block, texture(block), 1);
    }

    protected void tallCrossBlock(Block block, int variantCount) {
        this.tallCrossBlock(block, texture(block), variantCount);
    }

    protected void tallCrossBlock(Block block, ResourceLocation texture) {
        this.tallCrossBlock(block, texture, 1);
    }

    protected void tallCrossBlock(Block block, ResourceLocation texture, int variantCount) {
        for (int variant = 0; variant < variantCount; variant++) {
            ModelFile lowerModel = this.crossModel(texture.withSuffix("_bottom" + variantSuffix(variant)));
            ModelFile upperModel = this.crossModel(texture.withSuffix("_top" + variantSuffix(variant)));

            this.getVariantBuilder(block)
                    .partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER)
                    .addModels(createModelList(lowerModel))
                    .partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER)
                    .addModels(createModelList(upperModel));
        }
    }

    protected void bushBlock(Block block) {
        this.simpleBlock(block, this.bushModel(block));
    }

    protected void leavesBlock(Block block) {
        this.simpleBlock(block, this.leavesModel(texture(block)));
    }

    protected void leavesBlock(Block block, int variantCount) {
        for (int variant = 0; variant < variantCount; variant++) {
            BlockModelBuilder leavesModel = this.leavesModel(texture(block, variantSuffix(variant)));

            this.getVariantBuilder(block)
                    .partialState()
                    .addModels(ConfiguredModel.builder().modelFile(leavesModel).weight(2).buildLast());
        }
    }

    protected void floweringLeavesBlock(Block block) {
        for (int variant = 0; variant < 1; variant++) { /// by default bushy leaves will have 2 variants.
            BlockModelBuilder leavesModel = this.leavesModel(texture(block, variantSuffix(variant)));

            this.getVariantBuilder(block)
                    .partialState().with(LeafyBlossomsBlock.LEAFY, true).with(LeafyBlossomsBlock.SNIPPED, true)
                    .addModels(new ConfiguredModel(leavesModel))
                    .partialState().with(LeafyBlossomsBlock.LEAFY, false).with(LeafyBlossomsBlock.SNIPPED, false)
                    .addModels(new ConfiguredModel(leavesModel))
                    .partialState().with(LeafyBlossomsBlock.LEAFY, true).with(LeafyBlossomsBlock.SNIPPED, false)
                    .addModels(createModelList(this.bushyLeafyBlossomsModel(texture(block), variant)))
                    .partialState().with(LeafyBlossomsBlock.LEAFY, false).with(LeafyBlossomsBlock.SNIPPED, true)
                    .addModels(createModelList(this.bushyLeavesModel(texture(block, "_leaves"), variant)));
        }
    }

    protected void leafPileBlock(Block block, Block leavesBlock, int variantCount) {
        for (int variant = 0; variant < variantCount; variant++) {
            for (int layers = 1; layers <= 8; layers++) {
                ModelFile fullLeafModel = this.existingModel(texture(leavesBlock));
                ModelFile leafPileModel = this.leafPileModel(block, texture(leavesBlock), layers * 2, variant);
                ModelFile model = layers == 8 ? fullLeafModel : leafPileModel;

                this.getVariantBuilder(block)
                        .partialState().with(MapleLeafPileBlock.LAYERS, layers)
                        .addModels(ConfiguredModel.builder().modelFile(model).weight(2).buildLast());
            }
        }
    }

    protected void leafLitterBlock(Block block) {
        this.createMultipartPlantBlock(block, (amount) -> this.leafLitterModel(block, amount));
    }

    private void createMultipartPlantBlock(Block block, Function<Integer, BlockModelBuilder> modelFactory) {
        ModelFile[] models = {modelFactory.apply(1), modelFactory.apply(2), modelFactory.apply(3), modelFactory.apply(4)};
        Integer[][] amounts = {{1, 2, 3, 4}, {2, 3, 4}, {3, 4}, {4}};

        for (int modelIndex = 0; modelIndex < models.length; modelIndex++) {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                this.getMultipartBuilder(block).part()
                        .modelFile(models[modelIndex])
                        .rotationY(facingRotation(direction))
                        .addModel()
                        .condition(BlockStateProperties.FLOWER_AMOUNT, amounts[modelIndex])
                        .condition(BlockStateProperties.HORIZONTAL_FACING, direction)
                        .end();
            }
        }
    }

    protected void springBambooBlock(Block block) {
        MultiPartBlockStateBuilder builder = this.getMultipartBuilder(block);

        for (int age = 0; age <= 2; age++) {
            if (age > 0) {
                builder.part()
                        .modelFile(this.existingModel(texture(block, "_age" + age)))
                        .nextModel()
                        .modelFile(this.existingModel(texture(block, "_age" + age + "_variant")))
                        .addModel()
                        .condition(SpringBambooStalkBlock.AGE, age);
            } else {
                builder.part()
                        .modelFile(this.existingModel(texture(block, "_age" + age)))
                        .addModel()
                        .condition(SpringBambooStalkBlock.AGE, age);
            }
        }

        for (BambooLeaves leaves : BambooLeaves.values()) {
            if (leaves == BambooLeaves.NONE) continue;

            builder.part()
                    .modelFile(existingModel(texture(block, "_leaves_" + leaves.getSerializedName())))
                    .addModel()
                    .condition(SpringBambooStalkBlock.LEAVES, leaves);
        }
    }

    protected void saguaroCactusBlock(Block block) {
        MultiPartBlockStateBuilder builder = this.getMultipartBuilder(block);

        builder.part()
                .modelFile(this.existingModel(texture(block)))
                .addModel()
                .condition(SaguaroCactusBlock.SHAPE, SaguaroCactusBlock.Shape.TRUNK);

        for (SaguaroCactusBlock.Shape shape : SaguaroCactusBlock.Shape.values()) {
            if (shape == SaguaroCactusBlock.Shape.TRUNK) continue;

            for (Direction direction : Direction.Plane.HORIZONTAL) {
                builder.part()
                        .modelFile(this.existingModel(texture(block, "_branch_" + shape.getSerializedName())))
                        .rotationY(facingRotation(direction))
                        .addModel()
                        .condition(SaguaroCactusBlock.SHAPE, shape)
                        .condition(SaguaroCactusBlock.FACING, direction);
            }
        }
    }

    protected void strawberryBushBlock(Block block) {
        this.strawberryBushBlock(block, texture(block), false);
    }

    protected void strawberryBushBlock(Block block, ResourceLocation texture, boolean wild) {
        this.getVariantBuilder(block).forAllStatesExcept((state) -> {
            int age = state.getValue(WildStrawberryBushBlock.AGE);
            ModelFile normalModel = this.strawberryBushModel(texture(block), name(block), texture, age);
            ModelFile sweetModel = this.strawberryBushModel(texture(block, "sweet_"), name(block), texture(block, "sweet_"), age);

            if (wild) {
                return ConfiguredModel.builder().modelFile(normalModel).build();
            } else {
                return ConfiguredModel.builder().modelFile(state.getValue(StrawberryBushBlock.SWEET) ? sweetModel : normalModel).build();
            }
        }, WildStrawberryBushBlock.CUT, WildStrawberryBushBlock.SPEED, StrawberryBushBlock.CONDITION, StrawberryBushBlock.MODIFIED);
    }

    protected void hangingCropBlock(Block block) {
        for (int age = 0; age <= 4; age++) {
            ModelFile crossModel = this.crossModel(texture(block).withSuffix("_stage" + age));

            this.getVariantBuilder(block)
                    .partialState().with(FruitPlantBlock.AGE, age)
                    .modelForState().modelFile(crossModel).addModel();
        }
    }

    protected void vanillaOrchidBlock(Block block) {
        for (VanillaOrchidBlock.Shape shape : VanillaOrchidBlock.Shape.values()) {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                for (int age = 0; age <= 2; age++) {
                    String suffix = shape == VanillaOrchidBlock.Shape.BASE ? "" : "_" + shape.getSerializedName();

                    this.getVariantBuilder(block)
                            .partialState()
                            .with(VanillaOrchidBlock.AGE, age)
                            .with(VanillaOrchidBlock.SHAPE, shape)
                            .with(HorizontalDirectionalBlock.FACING, direction)
                            .modelForState()
                            .modelFile(existingModel(texture(block, suffix + "_stage" + age)))
                            .rotationY(facingRotation(direction))
                            .addModel();
                }
            }
        }
    }

    protected void cakeBlock(Block block) {
        MultiPartBlockStateBuilder builder = this.getMultipartBuilder(block);

        for (Direction direction : Direction.Plane.HORIZONTAL) {
            for (int bites = 0; bites <= 6; bites++) {
                builder.part()
                        .modelFile(this.cakeModel(block, bites))
                        .rotationY(facingRotation(direction))
                        .addModel()
                        .condition(MysticCakeBlock.FACING, direction)
                        .condition(MysticCakeBlock.BITES, bites)
                        .end();
            }
        }

        for (MysticCakeBlock.Candle candle : MysticCakeBlock.Candle.values()) {
            if (candle == MysticCakeBlock.Candle.NONE) continue;

            for (boolean lit : new boolean[]{true, false}) {
                builder.part()
                        .modelFile(this.candleModel(block, candle, lit))
                        .addModel()
                        .condition(MysticCakeBlock.CANDLE, candle)
                        .condition(MysticCakeBlock.LIT, lit)
                        .end();
            }
        }
    }

    protected void pieBlock(Block block) {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            for (int bites = 0; bites <= 3; bites++) {
                this.getVariantBuilder(block)
                        .partialState()
                        .with(PieBlock.FACING, direction)
                        .with(PieBlock.BITES, bites)
                        .modelForState()
                        .modelFile(this.pieModel(block, bites))
                        .rotationY(facingRotation(direction))
                        .addModel();
            }
        }
    }

    protected void milkweedBlock(Block block) {
        MultiPartBlockStateBuilder builder = this.getMultipartBuilder(block);

        ///for (int variant = 0; variant < 1; variant++) {
        ///}
        builder.part()
                .modelFile(this.milkweedModel(texture(block, "_bottom")))/// + variantSuffix(variant))))
                .addModel()
                .condition(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER);
        builder.part()
                .modelFile(this.milkweedModel(texture(block, "_top")))/// + variantSuffix(variant))))
                .addModel()
                .condition(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER);

        for (int amount = 1; amount <= 4; amount++) {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                builder.part()
                        .modelFile(this.existingModel(texture(block, "_flower" + amount)))
                        .rotationY(facingRotation(direction))
                        .addModel()
                        .condition(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER)
                        .condition(MilkweedFlowerBlock.AMOUNT, amount)
                        .condition(MilkweedFlowerBlock.FACING, direction);
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    protected BlockModelBuilder crossModel(ResourceLocation texture) {
        return this.models()
                .cross(texture.getPath(), texture)
                .renderType("cutout");
    }

    protected BlockModelBuilder leafPileModel(Block block, ResourceLocation texture, int amount, int variantCount) {
        return this.models().withExistingParent(name(block) + amount + variantSuffix(variantCount), modLoc("block/template_leaf_pile" + amount))
                .texture("texture", texture + variantSuffix(variantCount))
                .renderType("cutout_mipped");
    }

    protected BlockModelBuilder leafLitterModel(Block block, int amount) {
        return this.models().withExistingParent(name(block) + amount, modLoc("block/template_leaf_litter" + amount))
                .texture("texture", texture(block))
                .renderType("cutout");
    }

    protected BlockModelBuilder leavesModel(ResourceLocation texture) {
        return this.models().leaves(texture.getPath(), texture);
    }

    protected BlockModelBuilder bushyLeavesModel(ResourceLocation texture, int variantCount) {
        return this.models().withExistingParent(texture.getPath() + variantSuffix(variantCount), modLoc("block/template_bushy_leaves" + variantSuffix(variantCount)))
                .texture("all", texture)
                .texture("bushy", texture.withSuffix("_bushy"))
                .renderType("cutout_mipped");
    }

    protected BlockModelBuilder bushyLeafyBlossomsModel(ResourceLocation texture, int variantCount) {
        return this.models().withExistingParent(texture.withSuffix("_leafy").getPath() + variantSuffix(variantCount), modLoc("block/template_bushy_leaves_top_bottom" + variantSuffix(variantCount)))
                .texture("top", texture)
                .texture("side", texture.withSuffix("_leafy"))
                .texture("bottom", texture.withSuffix("_leaves"))
                .texture("bushy", texture.withSuffix("_leafy_bushy"))
                .renderType("cutout_mipped");
    }

    protected BlockModelBuilder bushModel(Block block) {
        return this.models().withExistingParent(name(block), modLoc("block/template_bush"))
                .texture("top", texture(block, "_top"))
                .texture("side", texture(block, "_side"))
                .texture("plant", texture(block, "_plant"))
                .renderType("cutout");
    }

    protected BlockModelBuilder strawberryBushModel(ResourceLocation name, String parent, ResourceLocation texture, int stage) {
        String suffix = "_stage" + stage;
        return this.models().withExistingParent(name + suffix, modLoc("block/template_" + parent + suffix))
                .texture("cross", texture + suffix)
                .texture("layer", texture + "_layer")
                .renderType("cutout_mipped");
    }

    protected BlockModelBuilder cakeModel(Block block, int bites) {
        String suffix = bites > 0 ? "_slice" + bites : "";
        return this.models().withExistingParent(name(block, suffix), modLoc("block/template_cake" + suffix))
                .texture("top", texture(block, "_top"))
                .texture("side", texture(block, "_side"))
                .texture("inside", texture(block, "_inner"))
                .texture("bottom", texture(block, "_bottom"))
                .texture("particle", texture(block, "_side"));
    }

    protected BlockModelBuilder candleModel(Block block, MysticCakeBlock.Candle candle, boolean lit) {
        String suffix = lit ? "_lit" : "";
        return this.models().withExistingParent(name(block, "_" + candle.getSerializedName() + suffix), modLoc("block/template_candle_on_cake"))
                .texture("candle", mcLoc("block/" + candle.getSerializedName() + suffix));
    }

    protected BlockModelBuilder pieModel(Block block, int bites) {
        String suffix = bites > 0 ? "_slice" + bites : "";
        return this.models().withExistingParent(name(block, suffix), modLoc("block/template_pie" + suffix))
                .texture("top", texture(block, "_top"))
                .texture("side", texture(block, "_side"))
                .texture("inside", texture(block, "_inner"))
                .texture("bottom", texture(block, "_bottom"))
                .texture("particle", texture(block, "_side"))
                .renderType("cutout");
    }

    protected BlockModelBuilder pottedPlantModel(ResourceLocation texture) {
        String name = texture.getPath().replace("potted_", "");
        return this.models().withExistingParent(texture.getPath(), mcLoc("block/flower_pot_cross"))
                .texture("plant", name)
                .renderType("cutout");
    }

    protected BlockModelBuilder pottedBushModel(ResourceLocation texture) {
        String name = texture.getPath().replace("potted_", "");
        return this.models().withExistingParent(texture.getPath(), mcLoc("block/template_potted_azalea_bush"))
                .texture("top", name + "_top_potted")
                .texture("side", name + "_side_potted")
                .texture("plant", name + "_plant_potted")
                .renderType("cutout");
    }

    protected BlockModelBuilder milkweedModel(ResourceLocation texture) {
        return this.models().withExistingParent(texture.getPath(), modLoc("block/template_milkweed"))
                .texture("plant", texture)
                .texture("plant_leaf", texture.withSuffix("_leaf"))
                .renderType("cutout");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    protected static ConfiguredModel[] createModelList(ModelFile models) {
        return Stream.of(models).map(ConfiguredModel::new).toArray(ConfiguredModel[]::new);
    }

    protected static String variantSuffix(int i) {
        return switch (i) {
            case 0 -> "";
            case 1 -> "_variant";
            default -> "_variant" + i;
        };
    }

    protected static int facingRotation(Direction direction) {
        return switch (direction) {
            case EAST  -> 90;
            case SOUTH -> 180;
            case WEST  -> 270;
            default -> 0;
        };
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    protected static ResourceLocation texture(Block block) {
        return MysticsBiomes.modLoc("block/" + name(block));
    }

    protected static ResourceLocation texture(Block block, String affix) {
        return MysticsBiomes.modLoc("block/" + name(block, affix));
    }

    protected static String name(Block block) {
        return key(block).getPath();
    }

    protected static String name(Block block, String affix) {
        ResourceLocation key = key(block);

        if (affix.isEmpty()) {
            return key.getPath();
        }

        if (affix.startsWith("_")) {
            return key.withSuffix(affix).getPath();
        }

        if (affix.endsWith("_")) {
            return key.withPrefix(affix).getPath();
        }

        throw new IllegalArgumentException("name for " + key + " '" + affix + "' is missing '_', and cannot determine as a suffix or prefix.");
    }

    protected static ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

}