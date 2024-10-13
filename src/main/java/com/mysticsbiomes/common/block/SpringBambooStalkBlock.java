package com.mysticsbiomes.common.block;

import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.block.*;
import net.minecraft.block.enums.BambooLeaves;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class SpringBambooStalkBlock extends Block implements Fertilizable {
    protected static final VoxelShape SMALL_SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 16.0, 11.0);
    protected static final VoxelShape LARGE_SHAPE = Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 16.0, 13.0);
    protected static final VoxelShape COLLISION_SHAPE = Block.createCuboidShape(6.5, 0.0, 6.5, 9.5, 16.0, 9.5);
    public static final IntProperty AGE = Properties.AGE_1;
    public static final EnumProperty<BambooLeaves> LEAVES = Properties.BAMBOO_LEAVES;
    public static final IntProperty STAGE = Properties.STAGE;

    public SpringBambooStalkBlock(AbstractBlock.Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, 0).with(LEAVES, BambooLeaves.NONE).with(STAGE, 0));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE, LEAVES, STAGE);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView getter, BlockPos pos, ShapeContext context) {
        VoxelShape shape = state.get(LEAVES) == BambooLeaves.LARGE ? LARGE_SHAPE : SMALL_SHAPE;
        Vec3d vec3 = state.getModelOffset(getter, pos);
        return shape.offset(vec3.x, vec3.y, vec3.z);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView getter, BlockPos pos, ShapeContext context) {
        Vec3d vec3 = state.getModelOffset(getter, pos);
        return COLLISION_SHAPE.offset(vec3.x, vec3.y, vec3.z);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        FluidState fluidState = context.getWorld().getFluidState(context.getBlockPos());
        if (!fluidState.isEmpty()) {
            return null;
        } else {
            BlockState belowState = context.getWorld().getBlockState(context.getBlockPos().down());
            if (belowState.isIn(BlockTags.DIRT) || belowState.isIn(BlockTags.SAND) || belowState.isOf(MysticBlocks.SPRING_BAMBOO) || belowState.isOf(MysticBlocks.SPRING_BAMBOO_SAPLING)) {
                if (belowState.isOf(MysticBlocks.SPRING_BAMBOO_SAPLING)) {
                    return this.getDefaultState().with(AGE, 0);
                } else if (belowState.isOf(MysticBlocks.SPRING_BAMBOO)) {
                    int i = belowState.get(AGE) > 0 ? 1 : 0;
                    return this.getDefaultState().with(AGE, i);
                } else {
                    BlockState aboveState = context.getWorld().getBlockState(context.getBlockPos().up());
                    return aboveState.isOf(MysticBlocks.SPRING_BAMBOO) ? this.getDefaultState().with(AGE, aboveState.get(AGE)) : MysticBlocks.SPRING_BAMBOO_SAPLING.getDefaultState();
                }
            } else {
                return null;
            }
        }
    }

    @Override
    public float calcBlockBreakingDelta(BlockState state, PlayerEntity player, BlockView world, BlockPos pos) {
        return player.getMainHandStack().getItem() instanceof SwordItem ? 1.0F : super.calcBlockBreakingDelta(state, player, world, pos);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return state.get(STAGE) == 0;
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        if (!state.canPlaceAt(level, pos)) {
            level.breakBlock(pos, true);
        }
    }

    @Override
    public void randomTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        if (state.get(STAGE) == 0) {
            if (random.nextInt(3) == 0 && level.isAir(pos.up()) && level.getBaseLightLevel(pos.up(), 0) >= 9) {
                int i = this.getHeightBelowUpToMax(level, pos) + 1;
                if (i < 16) {
                    this.growBamboo(state, level, pos, random, i);
                }
            }
        }
    }

    @Override
    public boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    @Override
    public boolean isShapeFullCube(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState belowState = world.getBlockState(pos.down());
        return belowState.isIn(BlockTags.DIRT) || belowState.isIn(BlockTags.SAND) || belowState.isOf(MysticBlocks.SPRING_BAMBOO) || belowState.isOf(MysticBlocks.SPRING_BAMBOO_SAPLING);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState state2, WorldAccess world, BlockPos pos, BlockPos pos2) {
        if (!state.canPlaceAt(world, pos)) {
            world.scheduleBlockTick(pos, this, 1);
        }

        if (direction == Direction.UP && state2.isOf(MysticBlocks.SPRING_BAMBOO) && state2.get(AGE) > state.get(AGE)) {
            world.setBlockState(pos, state.cycle(AGE), 2);
        }

        return super.getStateForNeighborUpdate(state, direction, state2, world, pos, pos2);
    }

    @Override
    public boolean isFertilizable(WorldView reader, BlockPos pos, BlockState state, boolean valid) {
        int i = this.getHeightAboveUpToMax(reader, pos);
        int j = this.getHeightBelowUpToMax(reader, pos);
        return i + j + 1 < 16 && reader.getBlockState(pos.up(i)).get(STAGE) != 1;
    }

    @Override
    public boolean canGrow(World level, Random source, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld level, Random source, BlockPos pos, BlockState state) {
        int i = this.getHeightAboveUpToMax(level, pos);
        int j = this.getHeightBelowUpToMax(level, pos);
        int k = i + j + 1;
        int l = 1 + source.nextInt(2);

        for (int i1 = 0; i1 < l; ++i1) {
            BlockPos abovePos = pos.up(i);
            BlockState aboveState = level.getBlockState(abovePos);
            if (k >= 16 || aboveState.get(STAGE) == 1 || !level.isAir(abovePos.up())) {
                return;
            }

            this.growBamboo(aboveState, level, abovePos, source, k);
            ++i;
            ++k;
        }
    }

    protected void growBamboo(BlockState state, World level, BlockPos pos, Random source, int age) {
        BlockState belowState = level.getBlockState(pos.down());
        BlockPos belowPos = pos.down(2);
        BlockState belowState2 = level.getBlockState(belowPos);
        BambooLeaves leaves = BambooLeaves.NONE;
        if (age >= 1) {
            if (belowState.isOf(MysticBlocks.SPRING_BAMBOO) && belowState.get(LEAVES) != BambooLeaves.NONE) {
                if (belowState.isOf(MysticBlocks.SPRING_BAMBOO) && belowState.get(LEAVES) != BambooLeaves.NONE) {
                    leaves = BambooLeaves.LARGE;
                    if (belowState2.isOf(MysticBlocks.SPRING_BAMBOO)) {
                        level.setBlockState(pos.down(), belowState.with(LEAVES, BambooLeaves.SMALL), 3);
                        level.setBlockState(belowPos, belowState2.with(LEAVES, BambooLeaves.NONE), 3);
                    }
                }
            } else {
                leaves = BambooLeaves.SMALL;
            }
        }

        int i = state.get(AGE) != 1 && !belowState2.isOf(MysticBlocks.SPRING_BAMBOO) ? 0 : 1;
        int j = (age < 11 || !(source.nextFloat() < 0.25F)) && age != 15 ? 0 : 1;
        level.setBlockState(pos.up(), this.getDefaultState().with(AGE, i).with(LEAVES, leaves).with(STAGE, j), 3);
    }

    protected int getHeightAboveUpToMax(BlockView getter, BlockPos pos) {
        int i;
        for (i = 0; i < 16 && getter.getBlockState(pos.up(i + 1)).isOf(MysticBlocks.SPRING_BAMBOO); ++i) {}
        return i;
    }

    protected int getHeightBelowUpToMax(BlockView getter, BlockPos pos) {
        int i;
        for (i = 0; i < 16 && getter.getBlockState(pos.down(i + 1)).isOf(MysticBlocks.SPRING_BAMBOO); ++i) {}
        return i;
    }

}