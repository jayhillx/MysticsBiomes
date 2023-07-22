package com.mysticsbiomes.common.block.entity;

import com.mysticsbiomes.init.MysticBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class SignBlockEntity extends net.minecraft.world.level.block.entity.SignBlockEntity {

    public SignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return MysticBlockEntities.SIGN.get();
    }

}