package com.mysticsbiomes.init;

import api.mystanica.registry.Registrar;
import com.mojang.datafixers.types.Type;
import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.block.entity.ButterflyNestBlockEntity;
import com.mysticsbiomes.common.block.entity.ChrysalisBlockEntity;
import com.mysticsbiomes.common.block.entity.MysticHangingSignBlockEntity;
import com.mysticsbiomes.common.block.entity.MysticSignBlockEntity;
import api.mystanica.registry.RegistryEntry;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class MysticBlockEntities {
    public static final Registrar<BlockEntityType<?>> BLOCK_ENTITIES = Registrar.create(Registries.BLOCK_ENTITY_TYPE, MysticsBiomes.modId);

    public static final RegistryEntry<BlockEntityType<ButterflyNestBlockEntity>> BUTTERFLY_NEST = register("butterfly_nest", () -> BlockEntityType.Builder.of(ButterflyNestBlockEntity::new, MysticBlocks.BUTTERFLY_NEST.get()));
    public static final RegistryEntry<BlockEntityType<ChrysalisBlockEntity>> CHRYSALIS = register("chrysalis", () -> BlockEntityType.Builder.of(ChrysalisBlockEntity::new, MysticBlocks.CHRYSALIS.get()));

    public static final RegistryEntry<BlockEntityType<MysticSignBlockEntity>> SIGN = register("sign", () -> BlockEntityType.Builder.of(MysticSignBlockEntity::new,
            MysticBlocks.STRAWBERRY_SIGN.get(), MysticBlocks.STRAWBERRY_WALL_SIGN.get(),
            MysticBlocks.BLACK_CHERRY_SIGN.get(), MysticBlocks.BLACK_CHERRY_WALL_SIGN.get(),
            MysticBlocks.LAVENDER_SIGN.get(), MysticBlocks.LAVENDER_WALL_SIGN.get(),
            MysticBlocks.PEACH_SIGN.get(), MysticBlocks.PEACH_WALL_SIGN.get(),
            MysticBlocks.MAPLE_SIGN.get(), MysticBlocks.MAPLE_WALL_SIGN.get(),
            MysticBlocks.SPRING_SIGN.get(), MysticBlocks.SPRING_WALL_SIGN.get(),
            MysticBlocks.SEA_FOAM_SIGN.get(), MysticBlocks.SEA_FOAM_WALL_SIGN.get(),
            MysticBlocks.TROPICAL_SIGN.get(), MysticBlocks.TROPICAL_WALL_SIGN.get(),
            MysticBlocks.VANILLA_SIGN.get(), MysticBlocks.VANILLA_WALL_SIGN.get()
    ));
    public static final RegistryEntry<BlockEntityType<MysticHangingSignBlockEntity>> HANGING_SIGN = register("hanging_sign", () -> BlockEntityType.Builder.of(MysticHangingSignBlockEntity::new,
            MysticBlocks.STRAWBERRY_HANGING_SIGN.get(), MysticBlocks.STRAWBERRY_WALL_HANGING_SIGN.get(),
            MysticBlocks.BLACK_CHERRY_HANGING_SIGN.get(), MysticBlocks.BLACK_CHERRY_WALL_HANGING_SIGN.get(),
            MysticBlocks.LAVENDER_HANGING_SIGN.get(), MysticBlocks.LAVENDER_WALL_HANGING_SIGN.get(),
            MysticBlocks.PEACH_HANGING_SIGN.get(), MysticBlocks.PEACH_WALL_HANGING_SIGN.get(),
            MysticBlocks.MAPLE_HANGING_SIGN.get(), MysticBlocks.MAPLE_WALL_HANGING_SIGN.get(),
            MysticBlocks.SPRING_HANGING_SIGN.get(), MysticBlocks.SPRING_WALL_HANGING_SIGN.get(),
            MysticBlocks.SEA_FOAM_HANGING_SIGN.get(), MysticBlocks.SEA_FOAM_WALL_HANGING_SIGN.get(),
            MysticBlocks.TROPICAL_HANGING_SIGN.get(), MysticBlocks.TROPICAL_WALL_HANGING_SIGN.get(),
            MysticBlocks.VANILLA_HANGING_SIGN.get(), MysticBlocks.VANILLA_WALL_HANGING_SIGN.get()
    ));

    private static <T extends BlockEntity> RegistryEntry<BlockEntityType<T>> register(String name, Supplier<BlockEntityType.Builder<T>> builder) {
        Type<?> type = Util.fetchChoiceType(References.BLOCK_ENTITY, name);
        return BLOCK_ENTITIES.register(name, () -> builder.get().build(type));
    }

    public static void init() {
    }

}