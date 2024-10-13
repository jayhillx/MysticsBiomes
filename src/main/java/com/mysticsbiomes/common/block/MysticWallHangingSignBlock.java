package com.mysticsbiomes.common.block;

import com.mysticsbiomes.common.block.entity.MysticHangingSignBlockEntity;
import com.mysticsbiomes.init.MysticBlockEntities;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallHangingSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MysticWallHangingSignBlock extends WallHangingSignBlock {

    public MysticWallHangingSignBlock(AbstractBlock.Settings properties, WoodType woodType) {
        super(properties, woodType);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MysticHangingSignBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World level, BlockState state, BlockEntityType<T> type) {
        return checkType(type, MysticBlockEntities.HANGING_SIGN, SignBlockEntity::tick);
    }

}