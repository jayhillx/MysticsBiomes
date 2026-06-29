package com.mysticsbiomes.init;

import com.mojang.datafixers.types.Type;
import com.mysticsbiomes.common.block.entity.MysticHangingSignBlockEntity;
import com.mysticsbiomes.common.block.entity.MysticSignBlockEntity;
import com.mysticsbiomes.core.registry.RegistryObject;
import net.minecraft.Util;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

import static com.mysticsbiomes.MysticsBiomes.REGISTRY;

public class MysticBlockEntities {

    public static RegistryObject<BlockEntityType<MysticSignBlockEntity>> SIGN;
    public static RegistryObject<BlockEntityType<MysticHangingSignBlockEntity>> HANGING_SIGN;

    public static void registerBlockEntities() {
        SIGN = register("sign", () -> BlockEntityType.Builder.of(MysticSignBlockEntity::new,
                MysticBlocks.STRAWBERRY_SIGN.get(), MysticBlocks.STRAWBERRY_WALL_SIGN.get()
                ///MysticBlocks.BLACK_CHERRY_SIGN.get(), MysticBlocks.BLACK_CHERRY_WALL_SIGN.get(),
                ///MysticBlocks.LAVENDER_SIGN.get(), MysticBlocks.LAVENDER_WALL_SIGN.get(),
                ///MysticBlocks.PEACH_SIGN.get(), MysticBlocks.PEACH_WALL_SIGN.get(),
                ///MysticBlocks.MAPLE_SIGN.get(), MysticBlocks.MAPLE_WALL_SIGN.get(),
                ///MysticBlocks.SPRING_SIGN.get(), MysticBlocks.SPRING_WALL_SIGN.get(),
                ///MysticBlocks.SEA_FOAM_SIGN.get(), MysticBlocks.SEA_FOAM_WALL_SIGN.get(),
                ///MysticBlocks.TROPICAL_SIGN.get(), MysticBlocks.TROPICAL_WALL_SIGN.get(),
                ///MysticBlocks.VANILLA_SIGN.get(), MysticBlocks.VANILLA_WALL_SIGN.get()
        ));
        HANGING_SIGN = register("hanging_sign", () -> BlockEntityType.Builder.of(MysticHangingSignBlockEntity::new,
                MysticBlocks.STRAWBERRY_HANGING_SIGN.get(), MysticBlocks.STRAWBERRY_WALL_HANGING_SIGN.get()
                ///MysticBlocks.BLACK_CHERRY_HANGING_SIGN.get(), MysticBlocks.BLACK_CHERRY_WALL_HANGING_SIGN.get(),
                ///MysticBlocks.LAVENDER_HANGING_SIGN.get(), MysticBlocks.LAVENDER_WALL_HANGING_SIGN.get(),
                ///MysticBlocks.PEACH_HANGING_SIGN.get(), MysticBlocks.PEACH_WALL_HANGING_SIGN.get(),
                ///MysticBlocks.MAPLE_HANGING_SIGN.get(), MysticBlocks.MAPLE_WALL_HANGING_SIGN.get(),
                ///MysticBlocks.SPRING_HANGING_SIGN.get(), MysticBlocks.SPRING_WALL_HANGING_SIGN.get(),
                ///MysticBlocks.SEA_FOAM_HANGING_SIGN.get(), MysticBlocks.SEA_FOAM_WALL_HANGING_SIGN.get(),
                ///MysticBlocks.TROPICAL_HANGING_SIGN.get(), MysticBlocks.TROPICAL_WALL_HANGING_SIGN.get(),
                ///MysticBlocks.VANILLA_HANGING_SIGN.get(), MysticBlocks.VANILLA_WALL_HANGING_SIGN.get()
        ));
    }

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String name, Supplier<BlockEntityType.Builder<T>> builder) {
        Type<?> type = Util.fetchChoiceType(References.BLOCK_ENTITY, name);
        return REGISTRY.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, name, () -> builder.get().build(type));
    }

}