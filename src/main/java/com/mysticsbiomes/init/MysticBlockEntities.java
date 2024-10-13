package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.common.block.entity.ButterflyNestBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.HangingSignBlockEntity;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Util;

import java.util.Objects;

public class MysticBlockEntities {

    public static final BlockEntityType<ButterflyNestBlockEntity> BUTTERFLY_NEST = Registry.register(Registries.BLOCK_ENTITY_TYPE, MysticsBiomes.modLoc("butterfly_nest"), BlockEntityType.Builder.create(ButterflyNestBlockEntity::new, MysticBlocks.BUTTERFLY_NEST).build(Util.getChoiceType(TypeReferences.BLOCK_ENTITY, "butterfly_nest")));

    public static final BlockEntityType<SignBlockEntity> SIGN = Registry.register(Registries.BLOCK_ENTITY_TYPE, MysticsBiomes.modLoc("sign"), BlockEntityType.Builder.create(SignBlockEntity::new, MysticBlocks.STRAWBERRY_SIGN, MysticBlocks.STRAWBERRY_WALL_SIGN, MysticBlocks.CHERRY_SIGN, MysticBlocks.CHERRY_WALL_SIGN, MysticBlocks.PEACH_SIGN, MysticBlocks.PEACH_WALL_SIGN, MysticBlocks.MAPLE_SIGN, MysticBlocks.MAPLE_WALL_SIGN, MysticBlocks.SEA_FOAM_SIGN, MysticBlocks.SEA_FOAM_WALL_SIGN, MysticBlocks.TROPICAL_SIGN, MysticBlocks.TROPICAL_WALL_SIGN, MysticBlocks.JACARANDA_SIGN, MysticBlocks.JACARANDA_WALL_SIGN).build(Objects.requireNonNull(Util.getChoiceType(TypeReferences.BLOCK_ENTITY, "sign"))));
    public static final BlockEntityType<HangingSignBlockEntity> HANGING_SIGN = Registry.register(Registries.BLOCK_ENTITY_TYPE, MysticsBiomes.modLoc("hanging_sign"), BlockEntityType.Builder.create(HangingSignBlockEntity::new, MysticBlocks.STRAWBERRY_HANGING_SIGN, MysticBlocks.STRAWBERRY_WALL_HANGING_SIGN, MysticBlocks.CHERRY_HANGING_SIGN, MysticBlocks.CHERRY_WALL_HANGING_SIGN, MysticBlocks.PEACH_HANGING_SIGN, MysticBlocks.PEACH_WALL_HANGING_SIGN, MysticBlocks.MAPLE_HANGING_SIGN, MysticBlocks.MAPLE_WALL_HANGING_SIGN, MysticBlocks.SEA_FOAM_HANGING_SIGN, MysticBlocks.SEA_FOAM_WALL_HANGING_SIGN, MysticBlocks.TROPICAL_HANGING_SIGN, MysticBlocks.TROPICAL_WALL_HANGING_SIGN, MysticBlocks.JACARANDA_HANGING_SIGN, MysticBlocks.JACARANDA_WALL_HANGING_SIGN).build(Objects.requireNonNull(Util.getChoiceType(TypeReferences.BLOCK_ENTITY, "hanging_sign"))));

    public static void registerBlockEntities() {
        MysticsBiomes.LOGGER.info("mystic's biomes ~ registering block entities");
    }

}