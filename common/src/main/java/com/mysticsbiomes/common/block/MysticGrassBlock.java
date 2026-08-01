package com.mysticsbiomes.common.block;

import api.mystanica.registry.RegistryEntry;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class MysticGrassBlock extends TallGrassBlock {
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 9.0D, 14.0D);
    @Nullable
    private final RegistryEntry<Block> tallBlock;

    public MysticGrassBlock(RegistryEntry<Block> tallBlock, Properties properties) {
        super(properties);
        this.tallBlock = tallBlock;
    }

    public MysticGrassBlock(Properties properties) {
        this(null, properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.getOffset(level, pos);
        return SHAPE.move(offset.x, offset.y, offset.z);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        if (this == MysticBlocks.DESERT_GRASS.get() || this == MysticBlocks.BEACH_GRASS.get()) {
            return state.is(BlockTags.SAND);
        }

        return super.mayPlaceOn(state, level, pos);
    }

    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return this.tallBlock != null;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        if (this.tallBlock != null) {
            if (this.tallBlock.get().defaultBlockState().canSurvive(level, pos) && level.isEmptyBlock(pos.above())) {
                level.setBlock(pos, this.tallBlock.get().defaultBlockState(), 2);
            }
        }
    }

}