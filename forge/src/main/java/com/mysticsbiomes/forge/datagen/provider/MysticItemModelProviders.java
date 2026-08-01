package com.mysticsbiomes.forge.datagen.provider;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.datagen.MysticBlockFamilies;
import com.mysticsbiomes.datagen.MysticBlockFamily;
import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class MysticItemModelProviders extends ItemModelProvider {

    public MysticItemModelProviders(PackOutput output, ExistingFileHelper helper) {
        super(output, MysticsBiomes.modId, helper);
    }

    @Override
    protected void registerModels() {
        MysticBlockFamilies.getAllFamilies().forEach(this::generateFor);
        this.fromParent(MysticBlocks.GRASSY_LUSH_SAND.get());
        this.fromParent(MysticBlocks.LUSH_SAND.get());

        this.fromParent(MysticBlocks.STRAWBERRY_BLOSSOMS.get());
        this.generatedBlockItem(MysticBlocks.STRAWBERRY_BLOSSOM_SAPLING.get());
        ///this.generatedBlockItem(MysticBlocks.PINK_DAISIES.get());
        this.generatedItem(MysticItems.STRAWBERRY.get());
        this.generatedItem(MysticItems.SWEET_STRAWBERRY.get());
        this.generatedItem(MysticItems.STRAWBERRY_CAKE.get());
        this.generatedItem(MysticItems.SWEET_STRAWBERRY_CAKE.get());
        this.generatedItem(MysticItems.STRAWBERRY_MILK_BUCKET.get());

        this.fromParent(MysticBlocks.LAVENDER_BLOSSOMS.get());
        this.generatedBlockItem(MysticBlocks.LAVENDER_BLOSSOM_SAPLING.get());
        this.generatedBlockItem(MysticBlocks.LAVENDER.get());
        this.generatedBlockItem(MysticBlocks.TALL_LAVENDER.get(), blockTexture(MysticBlocks.LAVENDER.get(), "_top"));
        ///this.generatedItem(MysticItems.LAVENDER_BUDS.get());
        ///this.fromParent(MysticBlocks.BUNDLED_LAVENDER_BUDS.get());
        ///this.fromParent(MysticBlocks.BUTTERFLY_BUSH_LEAVES.get());
        ///this.fromParent(MysticBlocks.BUTTERFLY_BUSH.get());
        this.fromParent(MysticBlocks.BUTTERFLY_NEST.get());
        this.fromParent(MysticBlocks.CHRYSALIS.get(), "_inventory");
        this.generatedItem(MysticItems.GLASS_JAR.get());
        this.generatedItem(MysticItems.MONARCH_BUTTERFLY_IN_JAR.get());
        this.generatedItem(MysticItems.MORPHO_BUTTERFLY_IN_JAR.get());
        this.generatedItem(MysticItems.BLUE_BUTTERFLY_IN_JAR.get());
        this.generatedItem(MysticItems.LUNA_MOTH_IN_JAR.get());
        this.generatedItem(MysticItems.CATERPILLAR_IN_JAR.get());

        this.fromParent(MysticBlocks.PINK_CHERRY_BLOSSOMS.get());
        ///this.generatedItem(MysticItems.PINK_CHERRY_PETALS.get());
        this.generatedBlockItem(MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING.get());
        this.fromParent(MysticBlocks.WHITE_CHERRY_BLOSSOMS.get());
        ///this.generatedItem(MysticItems.WHITE_CHERRY_PETALS.get());
        this.generatedBlockItem(MysticBlocks.WHITE_CHERRY_BLOSSOM_SAPLING.get());
        this.generatedItem(MysticItems.CHERRIES.get());
        this.generatedItem(MysticItems.CHERRY_PIE.get());
        this.generatedItem(MysticItems.SPRING_BAMBOO.get());
        this.fromParent(MysticBlocks.PEONY_BUSH_LEAVES.get());
        this.fromParent(MysticBlocks.PEONY_BUSH.get());

        this.fromParent(MysticBlocks.MAPLE_LEAVES.get());
        this.fromParent(MysticBlocks.MAPLE_LEAF_PILE.get(), "2");
        this.generatedBlockItem(MysticBlocks.MAPLE_LEAF_LITTER.get());
        this.generatedBlockItem(MysticBlocks.MAPLE_SAPLING.get());
        this.fromParent(MysticBlocks.ORANGE_MAPLE_LEAVES.get());
        this.fromParent(MysticBlocks.ORANGE_MAPLE_LEAF_PILE.get(), "2");
        this.generatedBlockItem(MysticBlocks.ORANGE_MAPLE_LEAF_LITTER.get());
        this.generatedBlockItem(MysticBlocks.ORANGE_MAPLE_SAPLING.get());
        this.fromParent(MysticBlocks.YELLOW_MAPLE_LEAVES.get());
        this.fromParent(MysticBlocks.YELLOW_MAPLE_LEAF_PILE.get(), "2");
        this.generatedBlockItem(MysticBlocks.YELLOW_MAPLE_LEAF_LITTER.get());
        this.generatedBlockItem(MysticBlocks.YELLOW_MAPLE_SAPLING.get());
        this.generatedBlockItem(MysticBlocks.ASTER.get());
        this.generatedBlockItem(MysticBlocks.GOLDENROD.get(), "_top");

        this.fromParent(MysticBlocks.PEACH_LEAVES.get());
        this.generatedBlockItem(MysticBlocks.PEACH_SAPLING.get());
        this.generatedItem(MysticItems.PEACH.get());
        this.generatedBlockItem(MysticBlocks.PEACH_PIE.get());
        ///this.generatedBlockItem(MysticBlocks.DESERT_SHRUB.get());
        this.generatedBlockItem(MysticBlocks.DESERT_GRASS.get());
        this.generatedBlockItem(MysticBlocks.TALL_DESERT_GRASS.get(), blockTexture(MysticBlocks.DESERT_GRASS.get(), "_tall"));
        this.generatedBlockItem(MysticBlocks.DESERT_LILY.get());
        this.generatedBlockItem(MysticBlocks.WILDFLOWER.get());
        this.fromParent(MysticBlocks.SAGUARO_CACTUS.get());
        this.generatedBlockItem(MysticBlocks.SAGUARO_BLOSSOM.get());
        ///this.fromParent(MysticBlocks.PRICKLY_CACTUS.get());
        ///this.generatedBlockItem(MysticBlocks.PRICKLY_BLOSSOM.get());
        ///this.generatedBlockItem(MysticBlocks.PRICKLY_PEAR.get());

        this.fromParent(MysticBlocks.SEA_SHRUB_LEAVES.get());
        this.fromParent(MysticBlocks.SEA_SHRUB.get());
        this.generatedBlockItem(MysticBlocks.BEACH_GRASS.get());
        this.generatedBlockItem(MysticBlocks.TALL_BEACH_GRASS.get(), blockTexture(MysticBlocks.BEACH_GRASS.get(), "_tall"));
        this.generatedBlockItem(MysticBlocks.SEA_OATS.get(), "_top");
        this.generatedBlockItem(MysticBlocks.SEA_THRIFT.get());
        this.generatedBlockItem(MysticBlocks.MILKWEED.get());

        this.fromParent(MysticBlocks.TROPICAL_LEAVES.get());
        ///this.generatedBlockItem(MysticBlocks.TROPICAL_VINES.get());
        this.generatedBlockItem(MysticBlocks.TROPICAL_SAPLING.get());
        this.fromParent(MysticBlocks.VANILLA_LEAVES.get());
        this.generatedBlockItem(MysticBlocks.VANILLA_SAPLING.get());
        ///this.generatedBlockItem(MysticBlocks.JUNGLE_SHRUB.get());
        ///this.generatedBlockItem(MysticBlocks.JUNGLE_GRASS.get());
        ///this.generatedBlockItem(MysticBlocks.TALL_JUNGLE_GRASS.get(), blockTexture(MysticBlocks.JUNGLE_GRASS.get(), "_tall"));
        this.fromParent(MysticBlocks.HYDRANGEA_BUSH_LEAVES.get());
        this.fromParent(MysticBlocks.HYDRANGEA_BUSH.get());
        this.generatedBlockItem(MysticBlocks.HIBISCUS.get());
        this.generatedItem(MysticItems.VANILLA_BEANS.get());
        this.generatedItem(MysticItems.VANILLA_MILK_BUCKET.get());
        this.generatedItem(MysticItems.CHOCOLATE_MILK_BUCKET.get());
        this.generatedItem(MysticItems.VANILLA_CAKE.get());
        this.generatedItem(MysticItems.CHOCOLATE_CAKE.get());

        this.generatedItem(MysticItems.STRAWBERRY_BOAT.get());
        this.generatedItem(MysticItems.STRAWBERRY_CHEST_BOAT.get());
        this.generatedItem(MysticItems.BLACK_CHERRY_BOAT.get());
        this.generatedItem(MysticItems.BLACK_CHERRY_CHEST_BOAT.get());
        this.generatedItem(MysticItems.LAVENDER_BOAT.get());
        this.generatedItem(MysticItems.LAVENDER_CHEST_BOAT.get());
        this.generatedItem(MysticItems.VANILLA_BOAT.get());
        this.generatedItem(MysticItems.VANILLA_CHEST_BOAT.get());
        this.generatedItem(MysticItems.PEACH_BOAT.get());
        this.generatedItem(MysticItems.PEACH_CHEST_BOAT.get());
        this.generatedItem(MysticItems.MAPLE_BOAT.get());
        this.generatedItem(MysticItems.MAPLE_CHEST_BOAT.get());
        this.generatedItem(MysticItems.SPRING_RAFT.get());
        this.generatedItem(MysticItems.SPRING_CHEST_RAFT.get());
        this.generatedItem(MysticItems.SEA_FOAM_BOAT.get());
        this.generatedItem(MysticItems.SEA_FOAM_CHEST_BOAT.get());
        this.generatedItem(MysticItems.TROPICAL_BOAT.get());
        this.generatedItem(MysticItems.TROPICAL_CHEST_BOAT.get());

        this.generatedItem(MysticItems.PINK_FROSTED_CAKE.get());
        this.generatedItem(MysticItems.ORANGE_FROSTED_CAKE.get());
        this.generatedItem(MysticItems.YELLOW_FROSTED_CAKE.get());
        this.generatedItem(MysticItems.LIME_FROSTED_CAKE.get());
        this.generatedItem(MysticItems.CYAN_FROSTED_CAKE.get());
        this.generatedItem(MysticItems.PURPLE_FROSTED_CAKE.get());
        ///this.generatedItem(MysticItems.RAINBOW_FROSTED_CAKE.get());
        this.generatedItem(MysticItems.PINK_EGG.get());
        this.generatedItem(MysticItems.ORANGE_EGG.get());
        this.generatedItem(MysticItems.YELLOW_EGG.get());
        this.generatedItem(MysticItems.LIME_EGG.get());
        this.generatedItem(MysticItems.CYAN_EGG.get());
        this.generatedItem(MysticItems.PURPLE_EGG.get());
        ///this.generatedItem(MysticItems.RAINBOW_EGG.get());

        this.spawnEggItem(MysticItems.STRAWBERRY_COW_SPAWN_EGG.get());
        this.spawnEggItem(MysticItems.VANILLA_COW_SPAWN_EGG.get());
        this.spawnEggItem(MysticItems.CHOCOLATE_COW_SPAWN_EGG.get());
        this.spawnEggItem(MysticItems.RAINBOW_CHICKEN_SPAWN_EGG.get());
        this.spawnEggItem(MysticItems.RED_PANDA_SPAWN_EGG.get());
        this.spawnEggItem(MysticItems.SEA_OTTER_SPAWN_EGG.get());
        this.spawnEggItem(MysticItems.BUTTERFLY_SPAWN_EGG.get());
        this.spawnEggItem(MysticItems.CATERPILLAR_SPAWN_EGG.get());

        this.generatedItem(MysticItems.LOGO.get());
        this.generatedItem(MysticItems.FROSTED_CAKES.get());
        this.generatedItem(MysticItems.NEAPOLITAN_CAKES.get());
    }

    private void generateFor(MysticBlockFamily family) {
        family.getVariants().forEach((variant, block) -> {
            switch (variant) {
                case FENCE -> this.fenceInventory(key(block.get()).getPath(), blockTexture(family.getBaseBlock().get()));
                case BUTTON -> this.buttonInventory(key(block.get()).getPath(), blockTexture(family.getBaseBlock().get()));
                case TRAPDOOR -> this.withExistingParent(key(block.get()).getPath(), blockTexture(block.get(), "_bottom"));
                case DOOR, SIGN, HANGING_SIGN -> this.basicItem(block.get().asItem());
                case WALL -> this.wallInventory(key(block.get()).getPath(), blockTexture(family.getBaseBlock().get()));
                default -> this.fromParent(block.get());
            }
        });
    }

    private void spawnEggItem(Item item) {
        this.withExistingParent(key(item).getPath(), mcLoc("item/template_spawn_egg"));
    }

    private void fromParent(Block block) {
        this.withExistingParent(key(block).getPath(), blockTexture(block));
    }

    private void fromParent(Block block, String suffix) {
        this.withExistingParent(key(block).getPath(), blockTexture(block, suffix));
    }

    private void generatedBlockItem(Block block) {
        this.generatedBlockItem(block, blockTexture(block));
    }

    private void generatedBlockItem(Block block, String suffix) {
        this.generatedBlockItem(block, blockTexture(block, suffix));
    }

    /**
     * @param block --- the block item being generated.
     * @param texture - the texture the block item is using.
     */
    private void generatedBlockItem(Block block, ResourceLocation texture) {
        this.generatedItem(block.asItem(), texture);
    }

    private void generatedItem(Item item) {
        this.generatedItem(item, itemTexture(item));
    }

    private void generatedItem(Item item, ResourceLocation texture) {
        this.generatedItem(key(item), texture);
    }

    private void generatedItem(ResourceLocation item, ResourceLocation texture) {
        this.getBuilder(item.getPath())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", texture);
    }

    private static ResourceLocation blockTexture(Block block) {
        return MysticsBiomes.modLoc("block/" + key(block).getPath());
    }

    private static ResourceLocation blockTexture(Block block, String suffix) {
        return MysticsBiomes.modLoc("block/" + key(block).withSuffix(suffix).getPath());
    }

    private static ResourceLocation itemTexture(Item item) {
        return MysticsBiomes.modLoc("item/" + key(item).getPath());
    }

    private static ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    private static ResourceLocation key(Item item) {
        return BuiltInRegistries.ITEM.getKey(item);
    }

}