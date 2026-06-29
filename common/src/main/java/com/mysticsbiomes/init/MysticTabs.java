package com.mysticsbiomes.init;

import com.mysticsbiomes.core.registry.RegistryObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

import static com.mysticsbiomes.MysticsBiomes.REGISTRY;

public class MysticTabs {

    public static RegistryObject<CreativeModeTab> TAB;

    public static void registerCreativeTabs() {
        TAB = register("tab", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                .title(Component.translatable("itemGroup.mysticsbiomes"))
                .icon(() -> new ItemStack(MysticItems.STRAWBERRY_PLANKS.get()))
                .displayItems((parameters, output) -> {
                    output.accept(MysticItems.GRASSY_LUSH_SAND.get());
                    output.accept(MysticItems.LUSH_SAND.get());
                    output.accept(MysticItems.LUSH_SANDSTONE.get());
                    output.accept(MysticItems.LUSH_SANDSTONE_STAIRS.get());
                    output.accept(MysticItems.LUSH_SANDSTONE_SLAB.get());
                    output.accept(MysticItems.LUSH_SANDSTONE_WALL.get());
                    output.accept(MysticItems.CHISELED_LUSH_SANDSTONE.get());
                    output.accept(MysticItems.CUT_LUSH_SANDSTONE.get());
                    output.accept(MysticItems.CUT_LUSH_SANDSTONE_SLAB.get());
                    output.accept(MysticItems.SMOOTH_LUSH_SANDSTONE.get());
                    output.accept(MysticItems.SMOOTH_LUSH_SANDSTONE_STAIRS.get());
                    output.accept(MysticItems.SMOOTH_LUSH_SANDSTONE_SLAB.get());

                    output.accept(MysticItems.STRAWBERRY_BLOSSOMS.get());
                    output.accept(MysticItems.STRAWBERRY_BLOSSOM_SAPLING.get());
                    output.accept(MysticItems.STRAWBERRY_LOG.get());
                    output.accept(MysticItems.STRAWBERRY_WOOD.get());
                    output.accept(MysticItems.STRIPPED_STRAWBERRY_LOG.get());
                    output.accept(MysticItems.STRIPPED_STRAWBERRY_WOOD.get());
                    output.accept(MysticItems.STRAWBERRY_PLANKS.get());
                    output.accept(MysticItems.STRAWBERRY_STAIRS.get());
                    output.accept(MysticItems.STRAWBERRY_SLAB.get());
                    output.accept(MysticItems.STRAWBERRY_FENCE.get());
                    output.accept(MysticItems.STRAWBERRY_FENCE_GATE.get());
                    output.accept(MysticItems.STRAWBERRY_BUTTON.get());
                    output.accept(MysticItems.STRAWBERRY_PRESSURE_PLATE.get());
                    output.accept(MysticItems.STRAWBERRY_TRAPDOOR.get());
                    output.accept(MysticItems.STRAWBERRY_DOOR.get());
                    output.accept(MysticItems.STRAWBERRY_SIGN.get());
                    output.accept(MysticItems.STRAWBERRY_HANGING_SIGN.get());
                    output.accept(MysticItems.STRAWBERRY_BOAT.get());
                    output.accept(MysticItems.STRAWBERRY_CHEST_BOAT.get());

                    output.accept(MysticItems.PINK_CHERRY_BLOSSOMS.get());
                    output.accept(MysticItems.PINK_CHERRY_BLOSSOM_SAPLING.get());
                    output.accept(MysticItems.WHITE_CHERRY_BLOSSOMS.get());
                    output.accept(MysticItems.WHITE_CHERRY_BLOSSOM_SAPLING.get());
                    output.accept(MysticItems.BLACK_CHERRY_LOG.get());
                    output.accept(MysticItems.BLACK_CHERRY_WOOD.get());
                    output.accept(MysticItems.STRIPPED_BLACK_CHERRY_LOG.get());
                    output.accept(MysticItems.STRIPPED_BLACK_CHERRY_WOOD.get());
                    output.accept(MysticItems.BLACK_CHERRY_PLANKS.get());
                    output.accept(MysticItems.BLACK_CHERRY_STAIRS.get());
                    output.accept(MysticItems.BLACK_CHERRY_SLAB.get());
                    output.accept(MysticItems.BLACK_CHERRY_FENCE.get());
                    output.accept(MysticItems.BLACK_CHERRY_FENCE_GATE.get());
                    output.accept(MysticItems.BLACK_CHERRY_BUTTON.get());
                    output.accept(MysticItems.BLACK_CHERRY_PRESSURE_PLATE.get());
                    output.accept(MysticItems.BLACK_CHERRY_TRAPDOOR.get());
                    output.accept(MysticItems.BLACK_CHERRY_DOOR.get());
                    output.accept(MysticItems.BLACK_CHERRY_SIGN.get());
                    output.accept(MysticItems.BLACK_CHERRY_HANGING_SIGN.get());
                    output.accept(MysticItems.BLACK_CHERRY_BOAT.get());
                    output.accept(MysticItems.BLACK_CHERRY_CHEST_BOAT.get());

                    output.accept(MysticItems.LAVENDER_BLOSSOMS.get());
                    output.accept(MysticItems.LAVENDER_BLOSSOM_SAPLING.get());
                    output.accept(MysticItems.LAVENDER_LOG.get());
                    output.accept(MysticItems.LAVENDER_WOOD.get());
                    output.accept(MysticItems.STRIPPED_LAVENDER_LOG.get());
                    output.accept(MysticItems.STRIPPED_LAVENDER_WOOD.get());
                    output.accept(MysticItems.LAVENDER_PLANKS.get());
                    output.accept(MysticItems.LAVENDER_STAIRS.get());
                    output.accept(MysticItems.LAVENDER_SLAB.get());
                    output.accept(MysticItems.LAVENDER_FENCE.get());
                    output.accept(MysticItems.LAVENDER_FENCE_GATE.get());
                    output.accept(MysticItems.LAVENDER_BUTTON.get());
                    output.accept(MysticItems.LAVENDER_PRESSURE_PLATE.get());
                    output.accept(MysticItems.LAVENDER_TRAPDOOR.get());
                    output.accept(MysticItems.LAVENDER_DOOR.get());
                    output.accept(MysticItems.LAVENDER_SIGN.get());
                    output.accept(MysticItems.LAVENDER_HANGING_SIGN.get());
                    output.accept(MysticItems.LAVENDER_BOAT.get());
                    output.accept(MysticItems.LAVENDER_CHEST_BOAT.get());

                    output.accept(MysticItems.VANILLA_LEAVES.get());
                    output.accept(MysticItems.VANILLA_SAPLING.get());
                    output.accept(MysticItems.VANILLA_LOG.get());
                    output.accept(MysticItems.VANILLA_WOOD.get());
                    output.accept(MysticItems.STRIPPED_VANILLA_LOG.get());
                    output.accept(MysticItems.STRIPPED_VANILLA_WOOD.get());
                    output.accept(MysticItems.VANILLA_PLANKS.get());
                    output.accept(MysticItems.VANILLA_STAIRS.get());
                    output.accept(MysticItems.VANILLA_SLAB.get());
                    output.accept(MysticItems.VANILLA_FENCE.get());
                    output.accept(MysticItems.VANILLA_FENCE_GATE.get());
                    output.accept(MysticItems.VANILLA_BUTTON.get());
                    output.accept(MysticItems.VANILLA_PRESSURE_PLATE.get());
                    output.accept(MysticItems.VANILLA_TRAPDOOR.get());
                    output.accept(MysticItems.VANILLA_DOOR.get());
                    output.accept(MysticItems.VANILLA_SIGN.get());
                    output.accept(MysticItems.VANILLA_HANGING_SIGN.get());
                    output.accept(MysticItems.VANILLA_BOAT.get());
                    output.accept(MysticItems.VANILLA_CHEST_BOAT.get());

                    output.accept(MysticItems.PEACH_LEAVES.get());
                    output.accept(MysticItems.PEACH_SAPLING.get());
                    output.accept(MysticItems.PEACH_LOG.get());
                    output.accept(MysticItems.PEACH_WOOD.get());
                    output.accept(MysticItems.STRIPPED_PEACH_LOG.get());
                    output.accept(MysticItems.STRIPPED_PEACH_WOOD.get());
                    output.accept(MysticItems.PEACH_PLANKS.get());
                    output.accept(MysticItems.PEACH_STAIRS.get());
                    output.accept(MysticItems.PEACH_SLAB.get());
                    output.accept(MysticItems.PEACH_FENCE.get());
                    output.accept(MysticItems.PEACH_FENCE_GATE.get());
                    output.accept(MysticItems.PEACH_BUTTON.get());
                    output.accept(MysticItems.PEACH_PRESSURE_PLATE.get());
                    output.accept(MysticItems.PEACH_TRAPDOOR.get());
                    output.accept(MysticItems.PEACH_DOOR.get());
                    output.accept(MysticItems.PEACH_SIGN.get());
                    output.accept(MysticItems.PEACH_HANGING_SIGN.get());
                    output.accept(MysticItems.PEACH_BOAT.get());
                    output.accept(MysticItems.PEACH_CHEST_BOAT.get());

                    output.accept(MysticItems.MAPLE_LEAVES.get());
                    output.accept(MysticItems.MAPLE_SAPLING.get());
                    output.accept(MysticItems.ORANGE_MAPLE_LEAVES.get());
                    output.accept(MysticItems.ORANGE_MAPLE_SAPLING.get());
                    output.accept(MysticItems.YELLOW_MAPLE_LEAVES.get());
                    output.accept(MysticItems.YELLOW_MAPLE_SAPLING.get());
                    output.accept(MysticItems.MAPLE_LOG.get());
                    output.accept(MysticItems.MAPLE_WOOD.get());
                    output.accept(MysticItems.WHITE_MAPLE_LOG.get());
                    output.accept(MysticItems.WHITE_MAPLE_WOOD.get());
                    output.accept(MysticItems.STRIPPED_MAPLE_LOG.get());
                    output.accept(MysticItems.STRIPPED_MAPLE_WOOD.get());
                    output.accept(MysticItems.MAPLE_PLANKS.get());
                    output.accept(MysticItems.MAPLE_STAIRS.get());
                    output.accept(MysticItems.MAPLE_SLAB.get());
                    output.accept(MysticItems.MAPLE_FENCE.get());
                    output.accept(MysticItems.MAPLE_FENCE_GATE.get());
                    output.accept(MysticItems.MAPLE_BUTTON.get());
                    output.accept(MysticItems.MAPLE_PRESSURE_PLATE.get());
                    output.accept(MysticItems.MAPLE_TRAPDOOR.get());
                    output.accept(MysticItems.MAPLE_DOOR.get());
                    output.accept(MysticItems.MAPLE_SIGN.get());
                    output.accept(MysticItems.MAPLE_HANGING_SIGN.get());
                    output.accept(MysticItems.MAPLE_BOAT.get());
                    output.accept(MysticItems.MAPLE_CHEST_BOAT.get());

                    output.accept(MysticItems.SPRING_BAMBOO_BLOCK.get());
                    output.accept(MysticItems.STRIPPED_SPRING_BAMBOO_BLOCK.get());
                    output.accept(MysticItems.SPRING_PLANKS.get());
                    output.accept(MysticItems.SPRING_MOSAIC.get());
                    output.accept(MysticItems.SPRING_STAIRS.get());
                    output.accept(MysticItems.SPRING_MOSAIC_STAIRS.get());
                    output.accept(MysticItems.SPRING_SLAB.get());
                    output.accept(MysticItems.SPRING_MOSAIC_SLAB.get());
                    output.accept(MysticItems.SPRING_FENCE.get());
                    output.accept(MysticItems.SPRING_FENCE_GATE.get());
                    output.accept(MysticItems.SPRING_BUTTON.get());
                    output.accept(MysticItems.SPRING_PRESSURE_PLATE.get());
                    output.accept(MysticItems.SPRING_TRAPDOOR.get());
                    output.accept(MysticItems.SPRING_DOOR.get());
                    output.accept(MysticItems.SPRING_SIGN.get());
                    output.accept(MysticItems.SPRING_HANGING_SIGN.get());
                    output.accept(MysticItems.SPRING_RAFT.get());
                    output.accept(MysticItems.SPRING_CHEST_RAFT.get());

                    output.accept(MysticItems.SEA_SHRUB_LEAVES.get());
                    output.accept(MysticItems.SEA_SHRUB.get());
                    output.accept(MysticItems.SEA_FOAM_LOG.get());
                    output.accept(MysticItems.SEA_FOAM_WOOD.get());
                    output.accept(MysticItems.STRIPPED_SEA_FOAM_LOG.get());
                    output.accept(MysticItems.STRIPPED_SEA_FOAM_WOOD.get());
                    output.accept(MysticItems.SEA_FOAM_PLANKS.get());
                    output.accept(MysticItems.SEA_FOAM_STAIRS.get());
                    output.accept(MysticItems.SEA_FOAM_SLAB.get());
                    output.accept(MysticItems.SEA_FOAM_FENCE.get());
                    output.accept(MysticItems.SEA_FOAM_FENCE_GATE.get());
                    output.accept(MysticItems.SEA_FOAM_BUTTON.get());
                    output.accept(MysticItems.SEA_FOAM_PRESSURE_PLATE.get());
                    output.accept(MysticItems.SEA_FOAM_TRAPDOOR.get());
                    output.accept(MysticItems.SEA_FOAM_DOOR.get());
                    output.accept(MysticItems.SEA_FOAM_SIGN.get());
                    output.accept(MysticItems.SEA_FOAM_HANGING_SIGN.get());
                    output.accept(MysticItems.SEA_FOAM_BOAT.get());
                    output.accept(MysticItems.SEA_FOAM_CHEST_BOAT.get());

                    output.accept(MysticItems.TROPICAL_LEAVES.get());
                    output.accept(MysticItems.TROPICAL_SAPLING.get());
                    output.accept(MysticItems.TROPICAL_LOG.get());
                    output.accept(MysticItems.TROPICAL_WOOD.get());
                    output.accept(MysticItems.STRIPPED_TROPICAL_LOG.get());
                    output.accept(MysticItems.STRIPPED_TROPICAL_WOOD.get());
                    output.accept(MysticItems.TROPICAL_PLANKS.get());
                    output.accept(MysticItems.TROPICAL_STAIRS.get());
                    output.accept(MysticItems.TROPICAL_SLAB.get());
                    output.accept(MysticItems.TROPICAL_FENCE.get());
                    output.accept(MysticItems.TROPICAL_FENCE_GATE.get());
                    output.accept(MysticItems.TROPICAL_BUTTON.get());
                    output.accept(MysticItems.TROPICAL_PRESSURE_PLATE.get());
                    output.accept(MysticItems.TROPICAL_TRAPDOOR.get());
                    output.accept(MysticItems.TROPICAL_DOOR.get());
                    output.accept(MysticItems.TROPICAL_SIGN.get());
                    output.accept(MysticItems.TROPICAL_HANGING_SIGN.get());
                    output.accept(MysticItems.TROPICAL_BOAT.get());
                    output.accept(MysticItems.TROPICAL_CHEST_BOAT.get());
                }).build()
        );
    }

    private static RegistryObject<CreativeModeTab> register(String name, Supplier<CreativeModeTab> tab) {
        return REGISTRY.register(BuiltInRegistries.CREATIVE_MODE_TAB, name, tab);
    }

}