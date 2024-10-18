package com.mysticsbiomes.common.block;

import com.mysticsbiomes.init.MysticItems;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;

public class StrawberryBushBlock extends PlantBlock implements Fertilizable {
    public static final IntProperty AGE = IntProperty.of("age", 0, 6);
    public static final BooleanProperty CUT = BooleanProperty.of("cropped");
    public static final BooleanProperty CONDITION = BooleanProperty.of("perfect_condition");
    public static final BooleanProperty MODIFIED = BooleanProperty.of("modified");
    private static final VoxelShape SEEDLING_SHAPE = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 5.0D, 13.0D);
    private static final VoxelShape FLOWERING_SHAPE = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 9.0D, 13.0D);
    private static final VoxelShape MATURE_SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 11.0D, 14.0D);

    public StrawberryBushBlock(AbstractBlock.Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, 0).with(CUT, false).with(CONDITION, false).with(MODIFIED, false));
    }

    @Override
    public ItemStack getPickStack(BlockView getter, BlockPos pos, BlockState state) {
        return new ItemStack(MysticItems.STRAWBERRY);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView getter, BlockPos pos, ShapeContext context) {
        if (state.get(AGE) < 3) {
            return SEEDLING_SHAPE;
        } else {
            return state.get(AGE) < 5 ? FLOWERING_SHAPE : MATURE_SHAPE;
        }
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return state.get(AGE) < 6 && !state.get(CUT);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        if (state.get(AGE) < 6) {
            float speed = this.calculateGrowthSpeed(level, pos);

            if (speed <= 142 && !state.get(MODIFIED)) {
                level.setBlockState(pos, state.with(CONDITION, Boolean.TRUE), 11);
            }

            if (!(speed <= 0)) {
                if (random.nextInt((int) speed) == 0) {
                    level.setBlockState(pos, state.with(AGE, state.get(AGE) + 1), 2);
                    level.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(state));
                }
            }
        }
    }

    /**
     * Calculates the growth speed of the plant based on environmental factors.
     *
     * @return the tick chance the plant will grow.
     */
    private float calculateGrowthSpeed(World level, BlockPos pos) {
        float temperature = level.getBiome(pos).value().getTemperature();
        float brightness = level.getLightLevel(pos.up(), 0);
        float speed = 142;

        if (temperature < 0.95F && brightness >= 7) {
            speed = speed / temperature;
        } else if (temperature <= 0) {
            speed = 0;
        }

        BlockState belowState = level.getBlockState(pos.down());
        boolean fertile = belowState.canPlaceAt(level, pos.down()) && belowState.isOf(Blocks.FARMLAND) && belowState.get(FarmlandBlock.MOISTURE) > 0;;
        speed = fertile ? speed * 0.65F : speed;
        return Math.max(speed, 0);
    }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult result) {
        ItemStack stack = player.getStackInHand(hand);

        if (stack.isIn(ConventionalItemTags.SHEARS) && !state.get(CUT)) {
            if (player instanceof ServerPlayerEntity serverPlayer) {
                Criteria.ITEM_USED_ON_BLOCK.trigger(serverPlayer, pos, stack);
            }

            level.setBlockState(pos, state.with(CUT, Boolean.TRUE), 11);
            stack.damage(1, player, (blockState) -> blockState.sendToolBreakStatus(hand));
            level.playSound(player, pos, SoundEvents.BLOCK_GROWING_PLANT_CROP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return ActionResult.success(level.isClient);
        }

        if (state.get(AGE) == 6) {
            if (state.get(CONDITION) && level.random.nextInt(64) == 0) {
                dropStack(level, pos, new ItemStack(MysticItems.SWEET_STRAWBERRY, 1));
            }

            dropStack(level, pos, new ItemStack(MysticItems.STRAWBERRY, 1 + level.random.nextInt(3)));
            level.setBlockState(pos, state.with(AGE, 2), 2);
            level.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            return ActionResult.success(level.isClient);
        }
        return super.onUse(state, level, pos, player, hand, result);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE).add(CUT).add(CONDITION).add(MODIFIED);
    }

    @Override
    public boolean isFertilizable(WorldView level, BlockPos pos, BlockState state, boolean valid) {
        return state.get(AGE) < 6;
    }

    @Override
    public boolean canGrow(World level, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld level, Random random, BlockPos pos, BlockState state) {
        int i = Math.min(6, state.get(AGE) + 1);
        level.setBlockState(pos, state.with(AGE, i).with(MODIFIED, Boolean.TRUE), 6);
    }

}