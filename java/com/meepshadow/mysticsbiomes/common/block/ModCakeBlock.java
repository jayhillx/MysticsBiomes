package com.meepshadow.mysticsbiomes.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

public class ModCakeBlock extends Block {
    public static final IntegerProperty BITES = BlockStateProperties.BITES_0_6;
    public static final VoxelShape[] SHAPES = new VoxelShape[]{Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.makeCuboidShape(3.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.makeCuboidShape(5.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.makeCuboidShape(7.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.makeCuboidShape(9.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.makeCuboidShape(11.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.makeCuboidShape(13.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D)};

    public ModCakeBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(BITES, 0));
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPES[state.get(BITES)];
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (worldIn.isRemote) {
            ItemStack itemstack = player.getHeldItem(handIn);
            if (this.func_226911_a_(worldIn, pos, state, player) == ActionResultType.SUCCESS) {
                return ActionResultType.SUCCESS;
            }

            if (itemstack.isEmpty()) {
                return ActionResultType.CONSUME;
            }
        }

        return this.func_226911_a_(worldIn, pos, state, player);
    }

    private ActionResultType func_226911_a_(IWorld p_226911_1_, BlockPos p_226911_2_, BlockState p_226911_3_, PlayerEntity p_226911_4_) {
        if (!p_226911_4_.canEat(false)) {
            return ActionResultType.PASS;
        } else {
            p_226911_4_.addStat(Stats.EAT_CAKE_SLICE);
            p_226911_4_.getFoodStats().addStats(2, 0.1F);
            int i = p_226911_3_.get(BITES);
            if (i < 6) {
                p_226911_1_.setBlockState(p_226911_2_, p_226911_3_.with(BITES, i + 1), 3);
            } else {
                p_226911_1_.removeBlock(p_226911_2_, false);
            }

            return ActionResultType.SUCCESS;
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    @ParametersAreNonnullByDefault
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.DOWN && !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.down()).getMaterial().isSolid();
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BITES);
    }

    @SuppressWarnings("deprecation")
    @Override
    public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos) {
        return (7 - blockState.get(BITES)) * 2;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean hasComparatorInputOverride(BlockState state) {
        return true;
    }

    @SuppressWarnings("deprecation")
    @Override
    @ParametersAreNonnullByDefault
    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return false;
    }
}