package com.mysticsbiomes.common.block;

import com.mysticsbiomes.common.block.entity.HangingSignBlockEntity;
import com.mysticsbiomes.common.block.entity.SignBlockEntity;
import com.mysticsbiomes.init.MysticBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

import javax.annotation.Nonnull;

public class SignBlock {

    public static class Standing extends StandingSignBlock {
        public Standing(Properties properties, WoodType type) {
            super(properties, type);
        }

        @Override
        public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
            return new SignBlockEntity(pos, state);
        }
    }

    public static class Wall extends WallSignBlock {
        public Wall(Properties properties, WoodType type) {
            super(properties, type);
        }

        @Override
        public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
            return new SignBlockEntity(pos, state);
        }
    }

    public static class Hanging {
        public static class Ceiling extends CeilingHangingSignBlock {
            public Ceiling(Properties properties, WoodType woodType) {
                super(properties, woodType);
            }

            @Override
            public BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state) {
                return new HangingSignBlockEntity(pos, state);
            }

            @Override
            public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@Nonnull Level level, @Nonnull BlockState state, @Nonnull BlockEntityType<T> type) {
                return createTickerHelper(type, MysticBlockEntities.HANGING_SIGN.get(), net.minecraft.world.level.block.entity.SignBlockEntity::tick);
            }
        }

        public static class Wall extends WallHangingSignBlock {
            public Wall(Properties properties, WoodType woodType) {
                super(properties, woodType);
            }

            @Override
            public BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state) {
                return new HangingSignBlockEntity(pos, state);
            }

            @Override
            public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@Nonnull Level level, @Nonnull BlockState state, @Nonnull BlockEntityType<T> type) {
                return createTickerHelper(type, MysticBlockEntities.HANGING_SIGN.get(), net.minecraft.world.level.block.entity.SignBlockEntity::tick);
            }
        }
    }

}