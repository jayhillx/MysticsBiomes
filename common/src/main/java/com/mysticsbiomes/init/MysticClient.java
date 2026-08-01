package com.mysticsbiomes.init;

import api.mystanica.registration.client.*;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.entity.model.ButterflyModel;
import com.mysticsbiomes.client.entity.model.CaterpillarModel;
import com.mysticsbiomes.client.entity.model.MysticCowModel;
import com.mysticsbiomes.client.entity.model.RainbowChickenModel;
import com.mysticsbiomes.client.entity.model.layer.ModelLayerProvider;
import com.mysticsbiomes.client.entity.model.layer.MysticModelLayers;
import com.mysticsbiomes.client.entity.renderer.*;
import com.mysticsbiomes.client.particle.AcornParticle;
import com.mysticsbiomes.client.particle.FallingLeavesParticle;
import com.mysticsbiomes.client.particle.LeafPileParticle;
import com.mysticsbiomes.common.block.state.MysticWoodTypes;
import com.mysticsbiomes.common.entity.vehicle.MysticBoat;
import com.mysticsbiomes.common.item.MysticSpawnEggItem;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ChestRaftModel;
import net.minecraft.client.model.RaftModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.function.BiConsumer;

/**
 * place for far too many client-side registrations to share between loaders.
 * <p>
 * each entry is registered into a given platform and its way things are registered.
 */
public class MysticClient {

    public static void registerRenderLayers() {
        BlockEntityRenderers.register(MysticBlockEntities.SIGN.get(), SignRenderer::new);
        BlockEntityRenderers.register(MysticBlockEntities.HANGING_SIGN.get(), HangingSignRenderer::new);
    }
    
    public static void registerWoodTypes() {
        addWoodType(MysticWoodTypes.STRAWBERRY);
        addWoodType(MysticWoodTypes.BLACK_CHERRY);
        addWoodType(MysticWoodTypes.LAVENDER);
        addWoodType(MysticWoodTypes.VANILLA);
        addWoodType(MysticWoodTypes.PEACH);
        addWoodType(MysticWoodTypes.MAPLE);
        addWoodType(MysticWoodTypes.SPRING);
        addWoodType(MysticWoodTypes.SEA_FOAM);
        addWoodType(MysticWoodTypes.TROPICAL);
    }

    private static void addWoodType(WoodType woodType) {
        Sheets.SIGN_MATERIALS.put(woodType, createSignMaterial(woodType));
        Sheets.HANGING_SIGN_MATERIALS.put(woodType, createHangingSignMaterial(woodType));
    }

    private static Material createSignMaterial(WoodType woodType) {
        return new Material(Sheets.SIGN_SHEET, MysticsBiomes.modLoc("entity/signs/" + woodType.name()));
    }

    private static Material createHangingSignMaterial(WoodType woodType) {
        return new Material(Sheets.SIGN_SHEET, MysticsBiomes.modLoc("entity/signs/hanging/" + woodType.name()));
    }

    public static void registerEntityModels(BiConsumer<ModelLayerLocation, ModelLayerProvider> registry) {
        registry.accept(MysticModelLayers.STRAWBERRY_COW, MysticCowModel::createBodyLayer);
        registry.accept(MysticModelLayers.VANILLA_COW, MysticCowModel::createBodyLayer);
        registry.accept(MysticModelLayers.CHOCOLATE_COW, MysticCowModel::createBodyLayer);
        registry.accept(MysticModelLayers.RAINBOW_CHICKEN, RainbowChickenModel::createBodyLayer);
        ///registry.accept(MysticModelLayers.RED_PANDA, RedPandaModel::createBodyLayer);
        ///registry.accept(MysticModelLayers.SEA_OTTER, SeaOtterModel::createBodyLayer);
        registry.accept(MysticModelLayers.BUTTERFLY, ButterflyModel::createBodyLayer);
        registry.accept(MysticModelLayers.CATERPILLAR, CaterpillarModel::createBodyLayer);

        for (MysticBoat.Type type : MysticBoat.Type.values()) {
            boolean raft = type == MysticBoat.Type.SPRING;
            registry.accept(MysticBoatRenderer.createBoatModelName(type), raft ? RaftModel::createBodyModel : BoatModel::createBodyModel);
            registry.accept(MysticBoatRenderer.createChestBoatModelName(type), raft ? ChestRaftModel::createBodyModel : ChestBoatModel::createBodyModel);
        }
    }

    public static void registerEntityRenderers(EntityRendererRegistry registry) {
        registry.accept(MysticEntities.STRAWBERRY_COW.get(), StrawberryCowRenderer::new);
        registry.accept(MysticEntities.VANILLA_COW.get(), VanillaCowRenderer::new);
        registry.accept(MysticEntities.CHOCOLATE_COW.get(), ChocolateCowRenderer::new);
        registry.accept(MysticEntities.RAINBOW_CHICKEN.get(), RainbowChickenRenderer::new);
        registry.accept(MysticEntities.RAINBOW_EGG.get(), ThrownItemRenderer::new);
        ///registry.register(MysticEntities.RED_PANDA.get(), RedPandaRenderer::new);
        ///registry.register(MysticEntities.SEA_OTTER.get(), SeaOtterRenderer::new);
        registry.accept(MysticEntities.BUTTERFLY.get(), ButterflyRenderer::new);
        registry.accept(MysticEntities.CATERPILLAR.get(), CaterpillarRenderer::new);
        registry.accept(MysticEntities.BOAT.get(), context -> new MysticBoatRenderer(context, false));
        registry.accept(MysticEntities.CHEST_BOAT.get(), context -> new MysticBoatRenderer(context, true));
    }

    public static void registerBlockRenderLayers(BlockRenderLayerRegistry registry) {
        registry.accept(MysticBlocks.STRAWBERRY_BLOSSOMS.get(), RenderType.cutoutMipped());
        registry.accept(MysticBlocks.STRAWBERRY_BLOSSOM_SAPLING.get(), RenderType.cutout());
        registry.accept(MysticBlocks.STRAWBERRY_DOOR.get(), RenderType.cutout());
        registry.accept(MysticBlocks.STRAWBERRY_TRAPDOOR.get(), RenderType.cutout());
        ///registry.accept(MysticBlocks.PINK_DAISIES.get(), RenderType.cutout());
        registry.accept(MysticBlocks.WILD_STRAWBERRY_BUSH.get(), RenderType.cutout());
        registry.accept(MysticBlocks.STRAWBERRY_BUSH.get(), RenderType.cutout());
        registry.accept(MysticBlocks.LAVENDER_BLOSSOMS.get(), RenderType.cutoutMipped());
        registry.accept(MysticBlocks.LAVENDER_BLOSSOM_SAPLING.get(), RenderType.cutout());
        registry.accept(MysticBlocks.LAVENDER_DOOR.get(), RenderType.cutout());
        registry.accept(MysticBlocks.LAVENDER_TRAPDOOR.get(), RenderType.cutout());
        registry.accept(MysticBlocks.LAVENDER.get(), RenderType.cutout());
        registry.accept(MysticBlocks.TALL_LAVENDER.get(), RenderType.cutout());
        ///registry.accept(MysticBlocks.BUTTERFLY_BUSH_LEAVES.get(), RenderType.cutoutMipped());
        ///registry.accept(MysticBlocks.BUTTERFLY_BUSH.get(), RenderType.cutoutMipped());
        registry.accept(MysticBlocks.BUTTERFLY_NEST.get(), RenderType.cutout());
        registry.accept(MysticBlocks.CHRYSALIS.get(), RenderType.cutout());
        registry.accept(MysticBlocks.PINK_CHERRY_BLOSSOMS.get(), RenderType.cutoutMipped());
        ///registry.accept(MysticBlocks.PINK_CHERRY_PETALS.get(), RenderType.cutoutMipped());
        registry.accept(MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING.get(), RenderType.cutout());
        registry.accept(MysticBlocks.WHITE_CHERRY_BLOSSOMS.get(), RenderType.cutoutMipped());
        ///registry.accept(MysticBlocks.WHITE_CHERRY_PETALS.get(), RenderType.cutoutMipped());
        registry.accept(MysticBlocks.WHITE_CHERRY_BLOSSOM_SAPLING.get(), RenderType.cutout());
        registry.accept(MysticBlocks.BLACK_CHERRY_DOOR.get(), RenderType.cutout());
        registry.accept(MysticBlocks.BLACK_CHERRY_TRAPDOOR.get(), RenderType.cutout());
        registry.accept(MysticBlocks.CHERRY_PLANT.get(), RenderType.cutout());
        registry.accept(MysticBlocks.CHERRY_PIE.get(), RenderType.cutout());
        registry.accept(MysticBlocks.PEONY_BUSH_LEAVES.get(), RenderType.cutoutMipped());
        registry.accept(MysticBlocks.PEONY_BUSH.get(), RenderType.cutout());
        registry.accept(MysticBlocks.SPRING_BAMBOO.get(), RenderType.cutout());
        registry.accept(MysticBlocks.SPRING_DOOR.get(), RenderType.cutout());
        registry.accept(MysticBlocks.SPRING_TRAPDOOR.get(), RenderType.cutout());
        registry.accept(MysticBlocks.MAPLE_LEAVES.get(), RenderType.cutoutMipped());
        registry.accept(MysticBlocks.MAPLE_LEAF_PILE.get(), RenderType.cutoutMipped());
        registry.accept(MysticBlocks.MAPLE_LEAF_LITTER.get(), RenderType.cutoutMipped());
        registry.accept(MysticBlocks.MAPLE_SAPLING.get(), RenderType.cutout());
        registry.accept(MysticBlocks.ORANGE_MAPLE_LEAVES.get(), RenderType.cutoutMipped());
        registry.accept(MysticBlocks.ORANGE_MAPLE_LEAF_PILE.get(), RenderType.cutoutMipped());
        registry.accept(MysticBlocks.ORANGE_MAPLE_LEAF_LITTER.get(), RenderType.cutout());
        registry.accept(MysticBlocks.ORANGE_MAPLE_SAPLING.get(), RenderType.cutout());
        registry.accept(MysticBlocks.YELLOW_MAPLE_LEAVES.get(), RenderType.cutoutMipped());
        registry.accept(MysticBlocks.YELLOW_MAPLE_LEAF_PILE.get(), RenderType.cutoutMipped());
        registry.accept(MysticBlocks.YELLOW_MAPLE_LEAF_LITTER.get(), RenderType.cutout());
        registry.accept(MysticBlocks.YELLOW_MAPLE_SAPLING.get(), RenderType.cutout());
        registry.accept(MysticBlocks.MAPLE_DOOR.get(), RenderType.cutout());
        registry.accept(MysticBlocks.MAPLE_TRAPDOOR.get(), RenderType.cutout());
        registry.accept(MysticBlocks.ASTER.get(), RenderType.cutout());
        registry.accept(MysticBlocks.GOLDENROD.get(), RenderType.cutout());
        registry.accept(MysticBlocks.PEACH_LEAVES.get(), RenderType.cutoutMipped());
        registry.accept(MysticBlocks.PEACH_SAPLING.get(), RenderType.cutout());
        registry.accept(MysticBlocks.PEACH_DOOR.get(), RenderType.cutout());
        registry.accept(MysticBlocks.PEACH_TRAPDOOR.get(), RenderType.cutout());
        registry.accept(MysticBlocks.PEACH_PLANT.get(), RenderType.cutout());
        registry.accept(MysticBlocks.PEACH_PIE.get(), RenderType.cutout());
        ///registry.accept(MysticBlocks.DESERT_SHRUB.get(), RenderType.cutout());
        registry.accept(MysticBlocks.DESERT_GRASS.get(), RenderType.cutout());
        registry.accept(MysticBlocks.TALL_DESERT_GRASS.get(), RenderType.cutout());
        registry.accept(MysticBlocks.DESERT_LILY.get(), RenderType.cutout());
        registry.accept(MysticBlocks.WILDFLOWER.get(), RenderType.cutout());
        registry.accept(MysticBlocks.SAGUARO_CACTUS.get(), RenderType.cutout());
        registry.accept(MysticBlocks.SAGUARO_BLOSSOM.get(), RenderType.cutout());
        ///registry.accept(MysticBlocks.PRICKLY_CACTUS.get(), RenderType.cutout());
        ///registry.accept(MysticBlocks.PRICKLY_BLOSSOM.get(), RenderType.cutout());
        registry.accept(MysticBlocks.SEA_SHRUB_LEAVES.get(), RenderType.cutoutMipped());
        registry.accept(MysticBlocks.SEA_SHRUB.get(), RenderType.cutout());
        registry.accept(MysticBlocks.SEA_FOAM_DOOR.get(), RenderType.cutout());
        registry.accept(MysticBlocks.SEA_FOAM_TRAPDOOR.get(), RenderType.cutout());
        registry.accept(MysticBlocks.BEACH_GRASS.get(), RenderType.cutout());
        registry.accept(MysticBlocks.TALL_BEACH_GRASS.get(), RenderType.cutout());
        registry.accept(MysticBlocks.SEA_OATS.get(), RenderType.cutout());
        registry.accept(MysticBlocks.SEA_THRIFT.get(), RenderType.cutout());
        registry.accept(MysticBlocks.MILKWEED.get(), RenderType.cutout());
        registry.accept(MysticBlocks.TROPICAL_LEAVES.get(), RenderType.cutoutMipped());
        ///registry.accept(MysticBlocks.TROPICAL_VINES.get(), RenderType.cutout());
        registry.accept(MysticBlocks.TROPICAL_SAPLING.get(), RenderType.cutout());
        registry.accept(MysticBlocks.TROPICAL_DOOR.get(), RenderType.cutout());
        registry.accept(MysticBlocks.TROPICAL_TRAPDOOR.get(), RenderType.cutout());
        registry.accept(MysticBlocks.VANILLA_LEAVES.get(), RenderType.cutoutMipped());
        registry.accept(MysticBlocks.VANILLA_SAPLING.get(), RenderType.cutout());
        registry.accept(MysticBlocks.VANILLA_DOOR.get(), RenderType.cutout());
        registry.accept(MysticBlocks.VANILLA_TRAPDOOR.get(), RenderType.cutout());
        registry.accept(MysticBlocks.VANILLA_ORCHID.get(), RenderType.cutout());
        ///registry.accept(MysticBlocks.JUNGLE_SHRUB.get(), RenderType.cutout());
        ///registry.accept(MysticBlocks.JUNGLE_GRASS.get(), RenderType.cutout());
        ///registry.accept(MysticBlocks.TALL_JUNGLE_GRASS.get(), RenderType.cutout());
        ///registry.accept(MysticBlocks.BANANA_LEAF_PLANT.get(), RenderType.cutout());
        registry.accept(MysticBlocks.HYDRANGEA_BUSH_LEAVES.get(), RenderType.cutoutMipped());
        registry.accept(MysticBlocks.HYDRANGEA_BUSH.get(), RenderType.cutout());
        registry.accept(MysticBlocks.HIBISCUS.get(), RenderType.cutout());
        registry.accept(MysticBlocks.POTTED_STRAWBERRY_BLOSSOM_SAPLING.get(), RenderType.cutout());
        registry.accept(MysticBlocks.POTTED_STRAWBERRY_BUSH.get(), RenderType.cutout());
        ///registry.accept(MysticBlocks.POTTED_PINK_DAISIES.get(), RenderType.cutout());
        registry.accept(MysticBlocks.POTTED_LAVENDER_BLOSSOM_SAPLING.get(), RenderType.cutout());
        registry.accept(MysticBlocks.POTTED_LAVENDER.get(), RenderType.cutout());
        ///registry.accept(MysticBlocks.POTTED_BUTTERFLY_BUSH.get(), RenderType.cutout());
        registry.accept(MysticBlocks.POTTED_PINK_CHERRY_BLOSSOM_SAPLING.get(), RenderType.cutout());
        registry.accept(MysticBlocks.POTTED_WHITE_CHERRY_BLOSSOM_SAPLING.get(), RenderType.cutout());
        registry.accept(MysticBlocks.POTTED_SPRING_BAMBOO.get(), RenderType.cutout());
        registry.accept(MysticBlocks.POTTED_PEONY_BUSH.get(), RenderType.cutout());
        registry.accept(MysticBlocks.POTTED_MAPLE_SAPLING.get(), RenderType.cutout());
        registry.accept(MysticBlocks.POTTED_ORANGE_MAPLE_SAPLING.get(), RenderType.cutout());
        registry.accept(MysticBlocks.POTTED_YELLOW_MAPLE_SAPLING.get(), RenderType.cutout());
        registry.accept(MysticBlocks.POTTED_ASTER.get(), RenderType.cutout());
        registry.accept(MysticBlocks.POTTED_GOLDENROD.get(), RenderType.cutout());
        registry.accept(MysticBlocks.POTTED_PEACH_SAPLING.get(), RenderType.cutout());
        ///registry.accept(MysticBlocks.POTTED_DESERT_SHRUB.get(), RenderType.cutout());
        registry.accept(MysticBlocks.POTTED_DESERT_LILY.get(), RenderType.cutout());
        registry.accept(MysticBlocks.POTTED_WILDFLOWER.get(), RenderType.cutout());
        registry.accept(MysticBlocks.POTTED_SAGUARO_CACTUS.get(), RenderType.cutout());
        ///registry.accept(MysticBlocks.POTTED_PRICKLY_CACTUS.get(), RenderType.cutout());
        registry.accept(MysticBlocks.POTTED_SEA_SHRUB.get(), RenderType.cutout());
        registry.accept(MysticBlocks.POTTED_SEA_OATS.get(), RenderType.cutout());
        registry.accept(MysticBlocks.POTTED_TROPICAL_SAPLING.get(), RenderType.cutout());
        registry.accept(MysticBlocks.POTTED_VANILLA_SAPLING.get(), RenderType.cutout());
        ///registry.accept(MysticBlocks.POTTED_JUNGLE_SHRUB.get(), RenderType.cutout());
        registry.accept(MysticBlocks.POTTED_HYDRANGEA_BUSH.get(), RenderType.cutout());
        registry.accept(MysticBlocks.POTTED_HIBISCUS.get(), RenderType.cutout());
        registry.accept(MysticBlocks.GLASS_JAR.get(), RenderType.translucent());
        /// terrariums
    }

    public static void registerBlockColors(BlockColorRegistry registry) {
        ///registry.accept((state, level, pos, tintIndex) ->
        ///        tintIndex == 1
        ///                ? BiomeColors.getAverageFoliageColor(level, pos)
        ///                : -1,
        ///        MysticBlocks.STRAWBERRY_BLOSSOMS.get(),
        ///        MysticBlocks.LAVENDER_BLOSSOMS.get()
        ///);
    }

    public static void registerItemColors(ItemColorRegistry registry) {
        registry.accept((stack, tint) -> ((MysticSpawnEggItem) stack.getItem()).getColor(tint), MysticSpawnEggItem.MOD_EGGS.toArray(ItemLike[]::new));
    }

    public static void registerParticleTypes(ParticleTypeRegistry registry) {
        registry.accept(MysticParticles.PINK_CHERRY_PETAL.get(), FallingLeavesParticle.BlossomProvider::new);
        registry.accept(MysticParticles.WHITE_CHERRY_PETAL.get(), FallingLeavesParticle.BlossomProvider::new);
        registry.accept(MysticParticles.MAPLE_LEAF.get(), FallingLeavesParticle.LeavesProvider::new);
        registry.accept(MysticParticles.MAPLE_LEAF_PILE.get(), LeafPileParticle.Provider::new);
        registry.accept(MysticParticles.ORANGE_MAPLE_LEAF.get(), FallingLeavesParticle.LeavesProvider::new);
        registry.accept(MysticParticles.ORANGE_MAPLE_LEAF_PILE.get(), LeafPileParticle.Provider::new);
        registry.accept(MysticParticles.YELLOW_MAPLE_LEAF.get(), FallingLeavesParticle.LeavesProvider::new);
        registry.accept(MysticParticles.YELLOW_MAPLE_LEAF_PILE.get(), LeafPileParticle.Provider::new);
        registry.accept(MysticParticles.ACORN.get(), AcornParticle.Provider::new);
    }

}