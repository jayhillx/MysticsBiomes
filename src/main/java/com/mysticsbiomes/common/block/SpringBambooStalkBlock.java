package com.mysticsbiomes.common.block;

import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.ToolActions;

import javax.annotation.Nullable;

@SuppressWarnings("deprecation")
public class SpringBambooStalkBlock extends Block implements BonemealableBlock, IPlantable {
    protected static final VoxelShape SMALL_SHAPE = Block.box(5.0, 0.0, 5.0, 11.0, 16.0, 11.0);
    protected static final VoxelShape LARGE_SHAPE = Block.box(3.0, 0.0, 3.0, 13.0, 16.0, 13.0);
    protected static final VoxelShape COLLISION_SHAPE = Block.box(6.5, 0.0, 6.5, 9.5, 16.0, 9.5);
    public static final IntegerProperty AGE = BlockStateProperties.AGE_1;
    public static final EnumProperty<BambooLeaves> LEAVES = BlockStateProperties.BAMBOO_LEAVES;
    public static final IntegerProperty STAGE = BlockStateProperties.STAGE;

    public SpringBambooStalkBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(LEAVES, BambooLeaves.NONE).setValue(STAGE, 0));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE, LEAVES, STAGE);
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        VoxelShape shape = state.getValue(LEAVES) == BambooLeaves.LARGE ? LARGE_SHAPE : SMALL_SHAPE;
        Vec3 vec3 = state.getOffset(getter, pos);
        return shape.move(vec3.x, vec3.y, vec3.z);
    }

    public VoxelShape getCollisionShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(getter, pos);
        return COLLISION_SHAPE.move(vec3.x, vec3.y, vec3.z);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
        if (!fluidState.isEmpty()) {
            return null;
        } else {
            BlockState belowState = context.getLevel().getBlockState(context.getClickedPos().below());
            if (belowState.is(BlockTags.DIRT) || belowState.is(BlockTags.SAND) || belowState.is(MysticBlocks.SPRING_BAMBOO.get()) || belowState.is(MysticBlocks.SPRING_BAMBOO_SAPLING.get())) {
                if (belowState.is(MysticBlocks.SPRING_BAMBOO_SAPLING.get())) {
                    return this.defaultBlockState().setValue(AGE, 0);
                } else if (belowState.is(MysticBlocks.SPRING_BAMBOO.get())) {
                    int i = belowState.getValue(AGE) > 0 ? 1 : 0;
                    return this.defaultBlockState().setValue(AGE, i);
                } else {
                    BlockState aboveState = context.getLevel().getBlockState(context.getClickedPos().above());
                    return aboveState.is(MysticBlocks.SPRING_BAMBOO.get()) ? this.defaultBlockState().setValue(AGE, aboveState.getValue(AGE)) : MysticBlocks.SPRING_BAMBOO_SAPLING.get().defaultBlockState();
                }
            } else {
                return null;
            }
        }
    }

    public BlockState getPlant(BlockGetter world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        return state.getBlock() != this ? this.defaultBlockState() : state;
    }

    public float getDestroyProgress(BlockState state, Player player, BlockGetter getter, BlockPos pos) {
        return player.getMainHandItem().canPerformAction(ToolActions.SWORD_DIG) ? 1.0F : super.getDestroyProgress(state, player, getter, pos);
    }

    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(STAGE) == 0;
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource source) {
        if (!state.canSurvive(level, pos)) {
            level.destroyBlock(pos, true);
        }
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource source) {
        if (state.getValue(STAGE) == 0 && level.isEmptyBlock(pos.above()) && level.getRawBrightness(pos.above(), 0) >= 9) {
            int i = this.getHeightBelowUpToMax(level, pos) + 1;
            if (i < 16 && ForgeHooks.onCropsGrowPre(level, pos, state, source.nextInt(3) == 0)) {
                this.growBamboo(state, level, pos, source, i);
                ForgeHooks.onCropsGrowPost(level, pos, state);
            }
        }
    }

    public boolean propagatesSkylightDown(BlockState state, BlockGetter getter, BlockPos pos) {
        return true;
    }

    public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType type) {
        return false;
    }

    public boolean isCollisionShapeFullBlock(BlockState state, BlockGetter getter, BlockPos pos) {
        return false;
    }

    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        BlockState belowState = reader.getBlockState(pos.below());
        return belowState.is(BlockTags.DIRT) || belowState.is(BlockTags.SAND) || belowState.is(MysticBlocks.SPRING_BAMBOO.get()) || belowState.is(MysticBlocks.SPRING_BAMBOO_SAPLING.get());
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor accessor, BlockPos pos, BlockPos pos2) {
        if (!state.canSurvive(accessor, pos)) {
            accessor.scheduleTick(pos, this, 1);
        }

        if (direction == Direction.UP && state2.is(MysticBlocks.SPRING_BAMBOO.get()) && state2.getValue(AGE) > state.getValue(AGE)) {
            accessor.setBlock(pos, state.cycle(AGE), 2);
        }

        return super.updateShape(state, direction, state2, accessor, pos, pos2);
    }

    public boolean isValidBonemealTarget(LevelReader reader, BlockPos pos, BlockState state, boolean valid) {
        int i = this.getHeightAboveUpToMax(reader, pos);
        int j = this.getHeightBelowUpToMax(reader, pos);
        return i + j + 1 < 16 && reader.getBlockState(pos.above(i)).getValue(STAGE) != 1;
    }

    public boolean isBonemealSuccess(Level level, RandomSource source, BlockPos pos, BlockState state) {
        return true;
    }

    public void performBonemeal(ServerLevel level, RandomSource source, BlockPos pos, BlockState state) {
        int i = this.getHeightAboveUpToMax(level, pos);
        int j = this.getHeightBelowUpToMax(level, pos);
        int k = i + j + 1;
        int l = 1 + source.nextInt(2);

        for (int i1 = 0; i1 < l; ++i1) {
            BlockPos abovePos = pos.above(i);
            BlockState aboveState = level.getBlockState(abovePos);
            if (k >= 16 || aboveState.getValue(STAGE) == 1 || !level.isEmptyBlock(abovePos.above())) {
                return;
            }

            this.growBamboo(aboveState, level, abovePos, source, k);
            ++i;
            ++k;
        }
    }

    protected void growBamboo(BlockState state, Level level, BlockPos pos, RandomSource source, int age) {
        BlockState belowState = level.getBlockState(pos.below());
        BlockPos belowPos = pos.below(2);
        BlockState belowState2 = level.getBlockState(belowPos);
        BambooLeaves leaves = BambooLeaves.NONE;
        if (age >= 1) {
            if (belowState.is(MysticBlocks.SPRING_BAMBOO.get()) && belowState.getValue(LEAVES) != BambooLeaves.NONE) {
                if (belowState.is(MysticBlocks.SPRING_BAMBOO.get()) && belowState.getValue(LEAVES) != BambooLeaves.NONE) {
                    leaves = BambooLeaves.LARGE;
                    if (belowState2.is(MysticBlocks.SPRING_BAMBOO.get())) {
                        level.setBlock(pos.below(), belowState.setValue(LEAVES, BambooLeaves.SMALL), 3);
                        level.setBlock(belowPos, belowState2.setValue(LEAVES, BambooLeaves.NONE), 3);
                    }
                }
            } else {
                leaves = BambooLeaves.SMALL;
            }
        }

        int i = state.getValue(AGE) != 1 && !belowState2.is(MysticBlocks.SPRING_BAMBOO.get()) ? 0 : 1;
        int j = (age < 11 || !(source.nextFloat() < 0.25F)) && age != 15 ? 0 : 1;
        level.setBlock(pos.above(), this.defaultBlockState().setValue(AGE, i).setValue(LEAVES, leaves).setValue(STAGE, j), 3);
    }

    protected int getHeightAboveUpToMax(BlockGetter getter, BlockPos pos) {
        int i;
        for (i = 0; i < 16 && getter.getBlockState(pos.above(i + 1)).is(MysticBlocks.SPRING_BAMBOO.get()); ++i) {}
        return i;
    }

    protected int getHeightBelowUpToMax(BlockGetter getter, BlockPos pos) {
        int i;
        for (i = 0; i < 16 && getter.getBlockState(pos.below(i + 1)).is(MysticBlocks.SPRING_BAMBOO.get()); ++i) {}
        return i;
    }

}