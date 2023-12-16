package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.block.entity.ButterflyNestBlockEntity;
import com.mysticsbiomes.common.block.entity.ChrysalisBlockEntity;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

public class MysticBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MysticsBiomes.modId);

    public static final RegistryObject<BlockEntityType<ButterflyNestBlockEntity>> BUTTERFLY_NEST = BLOCK_ENTITIES.register("butterfly_nest", () -> BlockEntityType.Builder.of(ButterflyNestBlockEntity::new, MysticBlocks.BUTTERFLY_NEST.get()).build(Util.fetchChoiceType(References.BLOCK_ENTITY, "butterfly_nest")));
    public static final RegistryObject<BlockEntityType<ChrysalisBlockEntity>> CHRYSALIS = BLOCK_ENTITIES.register("chrysalis", () -> BlockEntityType.Builder.of(ChrysalisBlockEntity::new, MysticBlocks.CHRYSALIS.get()).build(Util.fetchChoiceType(References.BLOCK_ENTITY, "chrysalis")));

    public static final RegistryObject<BlockEntityType<SignBlockEntity>> SIGN = BLOCK_ENTITIES.register("sign", () -> BlockEntityType.Builder.of(SignBlockEntity::new, MysticBlocks.STRAWBERRY_SIGN.get(), MysticBlocks.STRAWBERRY_WALL_SIGN.get(), MysticBlocks.CHERRY_SIGN.get(), MysticBlocks.CHERRY_WALL_SIGN.get(), MysticBlocks.JACARANDA_SIGN.get(), MysticBlocks.JACARANDA_WALL_SIGN.get(), MysticBlocks.MAPLE_SIGN.get(), MysticBlocks.MAPLE_WALL_SIGN.get()).build(Objects.requireNonNull(Util.fetchChoiceType(References.BLOCK_ENTITY, "sign"))));
    public static final RegistryObject<BlockEntityType<HangingSignBlockEntity>> HANGING_SIGN = BLOCK_ENTITIES.register("hanging_sign", () -> BlockEntityType.Builder.of(HangingSignBlockEntity::new, MysticBlocks.STRAWBERRY_HANGING_SIGN.get(), MysticBlocks.STRAWBERRY_WALL_HANGING_SIGN.get(), MysticBlocks.CHERRY_HANGING_SIGN.get(), MysticBlocks.CHERRY_WALL_HANGING_SIGN.get(), MysticBlocks.JACARANDA_HANGING_SIGN.get(), MysticBlocks.JACARANDA_WALL_HANGING_SIGN.get(), MysticBlocks.MAPLE_HANGING_SIGN.get(), MysticBlocks.MAPLE_WALL_HANGING_SIGN.get()).build(Objects.requireNonNull(Util.fetchChoiceType(References.BLOCK_ENTITY, "hanging_sign"))));

}