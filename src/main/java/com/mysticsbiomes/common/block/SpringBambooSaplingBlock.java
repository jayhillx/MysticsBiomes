package com.mysticsbiomes.common.block;

import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.block.*;
import net.minecraft.block.enums.BambooLeaves;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class SpringBambooSaplingBlock extends Block implements Fertilizable {
    protected static final VoxelShape SAPLING_SHAPE = Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 12.0, 12.0);

    public SpringBambooSaplingBlock(AbstractBlock.Settings properties) {
        super(properties);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView getter, BlockPos pos, ShapeContext context) {
        Vec3d vec3 = state.getModelOffset(getter, pos);
        return SAPLING_SHAPE.offset(vec3.x, vec3.y, vec3.z);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        if (random.nextInt(3) == 0 && level.isAir(pos.up()) && level.getLightLevel(pos.up(), 0) >= 9) {
            this.growBamboo(level, pos);
        }
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView reader, BlockPos pos) {
        BlockState belowState = reader.getBlockState(pos.down());
        return belowState.isIn(BlockTags.DIRT) || belowState.isIn(BlockTags.SAND) || belowState.isOf(MysticBlocks.SPRING_BAMBOO) || belowState.isOf(MysticBlocks.SPRING_BAMBOO_SAPLING);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState state2, WorldAccess accessor, BlockPos pos, BlockPos pos2) {
        if (!state.canPlaceAt(accessor, pos)) {
            return Blocks.AIR.getDefaultState();
        } else {
            if (direction == Direction.UP && state2.isOf(MysticBlocks.SPRING_BAMBOO)) {
                accessor.setBlockState(pos, MysticBlocks.SPRING_BAMBOO.getDefaultState(), 2);
            }
            return super.getStateForNeighborUpdate(state, direction, state2, accessor, pos, pos2);
        }
    }

    @Override
    public ItemStack getPickStack(BlockView getter, BlockPos pos, BlockState state) {
        return new ItemStack(MysticBlocks.SPRING_BAMBOO);
    }

    @Override
    public boolean isFertilizable(WorldView reader, BlockPos pos, BlockState state, boolean value) {
        return reader.getBlockState(pos.up()).isAir();
    }

    @Override
    public boolean canGrow(World level, Random source, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld level, Random source, BlockPos pos, BlockState state) {
        this.growBamboo(level, pos);
    }

    @Override
    public float calcBlockBreakingDelta(BlockState state, PlayerEntity player, BlockView getter, BlockPos pos) {
        return player.getMainHandStack().getItem() instanceof SwordItem ? 1.0F : super.calcBlockBreakingDelta(state, player, getter, pos);
    }

    protected void growBamboo(World level, BlockPos pos) {
        level.setBlockState(pos.up(), MysticBlocks.SPRING_BAMBOO.getDefaultState().with(SpringBambooStalkBlock.LEAVES, BambooLeaves.SMALL), 3);
    }

}