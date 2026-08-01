package com.mysticsbiomes.common.block;

import com.mysticsbiomes.init.MysticItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * when placed on a moisturized farmland block with perfect condition, it will have a 25% chance to grow with the sweet value.
 * at that point it will have a 50% chance to produce a sweet strawberry.
 */
public class StrawberryBushBlock extends WildStrawberryBushBlock {
    public static final BooleanProperty CONDITION = BooleanProperty.create("perfect_condition");
    public static final BooleanProperty MODIFIED = BooleanProperty.create("modified");
    public static final BooleanProperty SWEET = BooleanProperty.create("sweet");

    public StrawberryBushBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState()
                .setValue(CONDITION, false)
                .setValue(MODIFIED, false)
                .setValue(SWEET, false)
        );
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = this.defaultBlockState();

        /// set if the plant is under perfect condition if the biomes temperature is 0.8 or higher.
        /// if it is perfect then it can produce a sweet strawberry.
        float temperature = level.getBiome(pos).value().getBaseTemperature();
        if (temperature >= 0.8F) {
            state = state.setValue(CONDITION, true);
        }

        return state.setValue(SPEED, this.getGrowthTier(level, pos));
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(AGE) < 5;
    }

    @Override
    protected void onGrow(BlockState state, ServerLevel level, BlockPos pos, RandomSource random, float growthSpeed) {
        int age = state.getValue(AGE);
        if (age < 5) {
            if (random.nextFloat() < growthSpeed) {
                /// 25% chance to set be sweet if the crop is growing from age 0, has a perfect condition.
                if (!state.getValue(MODIFIED)) {
                    if (random.nextFloat() <= 0.25F && age == 0 && state.getValue(CONDITION) && !state.getValue(SWEET)) {
                        state = state.setValue(SWEET, true);
                    }
                }

                state = state.setValue(AGE, age + 1);
            }

            level.setBlock(pos, state, 2 | 11);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(state));
        }
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState belowState = level.getBlockState(pos.below());
        return this.isOnFarmland(belowState);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return this.getShape(state).move(0.0F, 0.0F, 0.0F);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (state.getValue(AGE) == 5) {
            /// 50% chance to drop a sweet strawberry when on soil, has perfect condition, and is sweet.
            if (level.random.nextFloat() <= 0.5F) {
                if (this.isOnFarmland(level.getBlockState(pos.below())) && !state.getValue(MODIFIED) && state.getValue(CONDITION) && state.getValue(SWEET)) {
                    popResource(level, pos, new ItemStack(MysticItems.SWEET_STRAWBERRY.get(), 1));
                }
            }

            popResource(level, pos, new ItemStack(MysticItems.STRAWBERRY.get(), 1 + level.random.nextInt(3)));
            level.setBlock(pos, state.setValue(AGE, 2), 2);
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return InteractionResult.PASS;
    }

    private boolean isOnFarmland(BlockState state) {
        return state.is(Blocks.FARMLAND) || state.getBlock() instanceof FarmBlock;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(CONDITION, MODIFIED, SWEET);
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        int age = Math.min(5, state.getValue(AGE) + 1);
        /// set the plant to modified, preventing the plant from naturally producing a sweet strawberry.
        level.setBlock(pos, state.setValue(AGE, age).setValue(MODIFIED, true), 5);
    }

}