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
        MysticBlockFamilies.getAllFamilies().filter(MysticBlockFamily::shouldGenerateModel).forEach(this::generateFor);
        this.fromParent(MysticBlocks.GRASSY_LUSH_SAND.get());
        ///this.generatedBlockItem(MysticBlocks.LUSH_GRASS.get());
        ///this.generatedBlockItem(MysticBlocks.TALL_LUSH_GRASS.get(), "top");
        this.fromParent(MysticBlocks.LUSH_SAND.get());

        this.fromParent(MysticBlocks.STRAWBERRY_BLOSSOMS.get());
        this.generatedBlockItem(MysticBlocks.STRAWBERRY_BLOSSOM_SAPLING.get());
        this.fromParent(MysticBlocks.LAVENDER_BLOSSOMS.get());
        this.generatedBlockItem(MysticBlocks.LAVENDER_BLOSSOM_SAPLING.get());
        ///this.fromParent(MysticBlocks.BUTTERFLY_BUSH_LEAVES.get());
        ///this.fromParent(MysticBlocks.BUTTERFLY_BUSH.get());
        this.fromParent(MysticBlocks.PINK_CHERRY_BLOSSOMS.get());
        this.generatedBlockItem(MysticBlocks.PINK_CHERRY_BLOSSOM_SAPLING.get());
        this.fromParent(MysticBlocks.WHITE_CHERRY_BLOSSOMS.get());
        this.generatedBlockItem(MysticBlocks.WHITE_CHERRY_BLOSSOM_SAPLING.get());
        ///this.fromParent(MysticBlocks.PEONY_BUSH_LEAVES.get());
        ///this.fromParent(MysticBlocks.PEONY_BUSH.get());
        this.fromParent(MysticBlocks.MAPLE_LEAVES.get());
        this.generatedBlockItem(MysticBlocks.MAPLE_SAPLING.get());
        this.fromParent(MysticBlocks.SPICED_MAPLE_LEAVES.get());
        this.generatedBlockItem(MysticBlocks.SPICED_MAPLE_SAPLING.get());
        this.fromParent(MysticBlocks.ORANGE_MAPLE_LEAVES.get());
        this.generatedBlockItem(MysticBlocks.ORANGE_MAPLE_SAPLING.get());
        this.fromParent(MysticBlocks.YELLOW_MAPLE_LEAVES.get());
        this.generatedBlockItem(MysticBlocks.YELLOW_MAPLE_SAPLING.get());
        this.fromParent(MysticBlocks.PEACH_LEAVES.get());
        this.generatedBlockItem(MysticBlocks.PEACH_SAPLING.get());
        ///this.generatedBlockItem(MysticBlocks.DESERT_SHRUB.get());
        this.fromParent(MysticBlocks.SEA_SHRUB_LEAVES.get());
        this.generatedBlockItem(MysticBlocks.SEA_SHRUB.get());
        this.fromParent(MysticBlocks.TROPICAL_LEAVES.get());
        this.generatedBlockItem(MysticBlocks.TROPICAL_SAPLING.get());
        this.fromParent(MysticBlocks.VANILLA_LEAVES.get());
        this.generatedBlockItem(MysticBlocks.VANILLA_SAPLING.get());
        ///this.fromParent(MysticBlocks.HYDRANGEA_BUSH_LEAVES.get());
        ///this.fromParent(MysticBlocks.HYDRANGEA_BUSH.get());

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

        this.generatedItem(MysticItems.STRAWBERRY_CAKE.get());
        this.generatedItem(MysticItems.SWEET_STRAWBERRY_CAKE.get());
        this.generatedItem(MysticItems.VANILLA_CAKE.get());
        this.generatedItem(MysticItems.CHOCOLATE_CAKE.get());
        this.generatedItem(MysticItems.PINK_FROSTED_CAKE.get());
        this.generatedItem(MysticItems.ORANGE_FROSTED_CAKE.get());
        this.generatedItem(MysticItems.YELLOW_FROSTED_CAKE.get());
        this.generatedItem(MysticItems.LIME_FROSTED_CAKE.get());
        this.generatedItem(MysticItems.CYAN_FROSTED_CAKE.get());
        this.generatedItem(MysticItems.PURPLE_FROSTED_CAKE.get());

        ///this.spawnEggItem(MysticItems.STRAWBERRY_COW_SPAWN_EGG.get());
        ///this.spawnEggItem(MysticItems.VANILLA_COW_SPAWN_EGG.get());
        ///this.spawnEggItem(MysticItems.CHOCOLATE_COW_SPAWN_EGG.get());
        ///this.spawnEggItem(MysticItems.RAINBOW_CHICKEN_SPAWN_EGG.get());
        ///this.spawnEggItem(MysticItems.RED_PANDA_SPAWN_EGG.get());
        ///this.spawnEggItem(MysticItems.SEA_OTTER_SPAWN_EGG.get());
        ///this.spawnEggItem(MysticItems.BUTTERFLY_SPAWN_EGG.get());
        ///this.spawnEggItem(MysticItems.CATERPILLAR_SPAWN_EGG.get());
    }

    private void generateFor(MysticBlockFamily family) {
        family.getVariants().forEach((variant, block) -> {
            switch (variant) {
                case FENCE -> this.fenceInventory(key(block).getPath(), blockTexture(family.getBaseBlock().get()));
                case BUTTON -> this.buttonInventory(key(block).getPath(), blockTexture(family.getBaseBlock().get()));
                case TRAPDOOR -> this.withExistingParent(key(block).getPath(), blockTexture(block, "_bottom"));
                case DOOR, SIGN, HANGING_SIGN -> this.basicItem(block.asItem());
                case WALL -> this.wallInventory(key(block).getPath(), blockTexture(family.getBaseBlock().get()));
                default -> this.fromParent(block);
            }
        });
    }

    private void spawnEggItem(Item item) {
        this.withExistingParent(key(item).getPath(), mcLoc("item/template_spawn_egg"));
    }

    private void fromParent(Block block) {
        this.withExistingParent(key(block).getPath(), blockTexture(block));
    }

    private void generatedBlockItem(Block block) {
        this.generatedItem(block.asItem(), blockTexture(block));
    }

    private void generatedBlockItem(Block block, String suffix) {
        this.generatedItem(block.asItem(), blockTexture(block, suffix));
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