package com.mysticsbiomes.common.block;

import com.mysticsbiomes.common.block.entity.MysticHangingSignBlockEntity;
import com.mysticsbiomes.common.block.entity.MysticSignBlockEntity;
import com.mysticsbiomes.init.MysticBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class MysticWallHangingSignBlock extends WallHangingSignBlock {

    public MysticWallHangingSignBlock(WoodType woodType, Properties properties) {
        super(properties, woodType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MysticHangingSignBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, MysticBlockEntities.HANGING_SIGN.get(), MysticSignBlockEntity::tick);
    }

}