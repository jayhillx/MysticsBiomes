package com.mysticsbiomes.common.block.entity;

import com.mysticsbiomes.init.MysticBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.util.math.BlockPos;

public class MysticSignBlockEntity extends SignBlockEntity {

    public MysticSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return MysticBlockEntities.SIGN;
    }

}