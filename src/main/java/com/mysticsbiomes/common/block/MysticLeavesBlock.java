package com.mysticsbiomes.common.block;

import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.OptionalInt;

public class MysticLeavesBlock extends Block {
    public static final IntegerProperty DISTANCE = IntegerProperty.create("distance", 1, 16);
    public static final BooleanProperty PERSISTENT = BlockStateProperties.PERSISTENT;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private String type;

    public MysticLeavesBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(DISTANCE, 16).setValue(PERSISTENT, false));
    }

    public MysticLeavesBlock(String particleType, Properties properties) {
        this(properties);
        this.type = particleType;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (level.isRainingAt(pos.above())) {
            if (random.nextInt(15) == 1) {
                BlockPos blockpos = pos.below();
                BlockState blockstate = level.getBlockState(blockpos);
                if (!blockstate.canOcclude() || !blockstate.isFaceSturdy(level, blockpos, Direction.UP)) {
                    ParticleUtils.spawnParticleBelow(level, pos, random, ParticleTypes.DRIPPING_WATER);
                }
            }
        }

        if (this.type != null) {
            if (random.nextInt(48) == 0) {
                if (level.isEmptyBlock(pos.below())) {
                    double d0 = random.nextGaussian() * 0.02D;
                    double d1 = random.nextGaussian() * 0.02D;
                    double d2 = random.nextGaussian() * 0.02D;

                    double d3 = (float)pos.getX() + random.nextFloat();
                    double d4 = (double)pos.getY() - 0.05D;
                    double d6 = (float)pos.getZ() + random.nextFloat();

                    switch (this.type) {
                        case "cherry" -> level.addParticle(ParticleTypes.CHERRY_LEAVES, d3, d4, d6, d0, d1, d2);
                        case "jacaranda" -> level.addParticle(MysticParticles.FALLING_JACARANDA.get(), d3, d4, d6, d0, d1, d2);
                        case "normal" -> level.addParticle(MysticParticles.FALLING_MAPLE.get(), d3, d4, d6, d0, d1, d2);
                        case "orange" -> level.addParticle(MysticParticles.FALLING_ORANGE_MAPLE.get(), d3, d4, d6, d0, d1, d2);
                        case "yellow" -> level.addParticle(MysticParticles.FALLING_YELLOW_MAPLE.get(), d3, d4, d6, d0, d1, d2);
                    }
                }
            }

            if (random.nextInt(2000) == 0) {
                Block block = switch (this.type) {
                    case "normal" -> MysticBlocks.MAPLE_LEAF_PILE.get();
                    case "orange" -> MysticBlocks.ORANGE_MAPLE_LEAF_PILE.get();
                    case "yellow" -> MysticBlocks.YELLOW_MAPLE_LEAF_PILE.get();
                    default -> null;
                };

                if (block != null) {
                    for (int i = 0; i <= 7; ++i) {
                        BlockPos belowPos = new BlockPos(pos.getX(), pos.getY() - i, pos.getZ());
                        BlockState belowState = level.getBlockState(belowPos.below());

                        if (level.getBlockState(belowPos).isAir() && !belowState.isAir() && !belowState.canBeReplaced() && !belowState.is(BlockTags.LEAVES) && belowState.canSurvive(level, belowPos)) {
                            level.setBlockAndUpdate(belowPos, block.defaultBlockState());
                        }
                    }
                }
            }
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource source) {
        level.setBlock(pos, updateDistance(state, level, pos), 3);
    }

    private static BlockState updateDistance(BlockState state, LevelAccessor accessor, BlockPos pos) {
        int i = 16;
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        for (Direction direction : Direction.values()) {
            mutablePos.setWithOffset(pos, direction);
            i = Math.min(i, getDistanceAt(accessor.getBlockState(mutablePos)) + 1);
            if (i == 1) {
                break;
            }
        }

        return state.setValue(DISTANCE, i);
    }

    private static int getDistanceAt(BlockState state) {
        return getOptionalDistanceAt(state).orElse(16);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (this.isRandomlyTicking(state)) {
            dropResources(state, level, pos);
            level.removeBlock(pos, false);
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(DISTANCE) == 16 && !state.getValue(PERSISTENT);
    }

    public VoxelShape getBlockSupportShape(BlockState state, BlockGetter getter, BlockPos pos) {
        return Shapes.empty();
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor accessor, BlockPos pos, BlockPos pos2) {
        if (state.getValue(WATERLOGGED)) {
            accessor.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(accessor));
        }

        int i = getDistanceAt(state2) + 1;
        if (i != 1 || state.getValue(DISTANCE) != i) {
            accessor.scheduleTick(pos, this, 1);
        }

        return state;
    }

    public static OptionalInt getOptionalDistanceAt(BlockState state) {
        if (state.is(BlockTags.LOGS)) {
            return OptionalInt.of(0);
        } else {
            return state.hasProperty(DISTANCE) ? OptionalInt.of(state.getValue(DISTANCE)) : OptionalInt.empty();
        }
    }

    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
        BlockState blockState = this.defaultBlockState().setValue(PERSISTENT, Boolean.TRUE).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
        return updateDistance(blockState, context.getLevel(), context.getClickedPos());
    }

    public int getLightBlock(BlockState state, BlockGetter getter, BlockPos pos) {
        return 1;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DISTANCE, PERSISTENT, WATERLOGGED);
    }

}