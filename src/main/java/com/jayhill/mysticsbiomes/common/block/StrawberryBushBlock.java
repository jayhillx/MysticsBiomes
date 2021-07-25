package com.jayhill.mysticsbiomes.common.block;

import com.jayhill.mysticsbiomes.init.MysticItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeHooks;

import java.util.Random;

/**
 * Strawberry Bush
 *
 * Stages: Sprout, Seedling, Bush, Flowering, Fruits, Mature.
 *
 * Strawberries grown in hot biomes grow faster,
 * and can grow sweet strawberries.
 * When strawberries are grown in cold biomes, they grow extremely
 * slow, but can produce a frosted strawberry.
 */
@SuppressWarnings("all")
public class StrawberryBushBlock extends BushBlock implements IGrowable {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_5;
    private static final VoxelShape SPROUT_SHAPE = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
    private static final VoxelShape GROWING_SHAPE = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
    private static final VoxelShape MATURE_SHAPE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public StrawberryBushBlock(Properties properties) {
        super(properties);
        this.setDefaultState(stateContainer.getBaseState().with(AGE, 0));
    }

    public ItemStack getItem(IBlockReader world, BlockPos pos, BlockState state) {
        return new ItemStack(MysticItems.STRAWBERRIES.get());
    }

    /** Sets the plants voxel for each growth stage. */
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        if (state.get(AGE) == 0) {
            return SPROUT_SHAPE;
        } else if (state.get(AGE) >= 1 && state.get(AGE) <= 3) {
            return GROWING_SHAPE;
        } else {
            return state.get(AGE) < 5 ? MATURE_SHAPE : super.getShape(state, worldIn, pos, context);
        }
    }

    public boolean ticksRandomly(BlockState state) {
        return state.get(AGE) < 5;
    }

    /** Performs a random tick on a block. */
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int age = state.get(AGE);

        if (age < 5 && world.getLightSubtracted(pos.up(), 0) >= 4) {

            world.setBlockState(pos, state.with(AGE, age + 1));
            ForgeHooks.onCropsGrowPost(world, pos, state);

            if (world.getBiome(pos).getTemperature(pos) >= 0.0F) {
                ForgeHooks.onCropsGrowPre(world, pos, state,random.nextInt(0) == 0);
            } else if (world.getBiome(pos).getTemperature(pos) >= 1.0F) {
                ForgeHooks.onCropsGrowPre(world, pos, state,random.nextInt(32) == 0);
            } else {
                ForgeHooks.onCropsGrowPre(world, pos, state,random.nextInt(64) == 0);
            }
        }
    }

    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
        int age = state.get(AGE);
        boolean mature = age == 5;

        /** If plant is in fruits and mature stage. */
        if (age >= 4) {
            int count = 1 + world.rand.nextInt(2);
            int temp = world.rand.nextInt(2);

            spawnAsEntity(world, pos, new ItemStack(MysticItems.STRAWBERRIES.get(), count + (mature ? 1 : 0)));
            world.playSound(null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + world.rand.nextFloat() * 0.4F);
            world.setBlockState(pos, state.with(AGE, 3), 2);

            if (world.getBiome(pos).getTemperature(pos) >= 1.0F) {
                spawnAsEntity(world, pos, new ItemStack(MysticItems.SWEET_STRAWBERRIES.get(), temp + (mature ? 1 : 0)));
            }

            return ActionResultType.func_233537_a_(world.isRemote);
        } else {
            return super.onBlockActivated(state, world, pos, player, hand, result);
        }
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    /** Whether this IGrowable can grow. */
    public boolean canGrow(IBlockReader world, BlockPos pos, BlockState state, boolean isClient) {
        return state.get(AGE) < 5;
    }

    public boolean canUseBonemeal(World world, Random rand, BlockPos pos, BlockState state) {
        return false;
    }

    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        int age = Math.min(5, state.get(AGE) + 1);
        worldIn.setBlockState(pos, state.with(AGE, age), 2);
    }

}