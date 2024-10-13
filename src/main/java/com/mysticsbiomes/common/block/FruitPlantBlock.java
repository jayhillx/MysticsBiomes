package com.mysticsbiomes.common.block;

import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
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

public class FruitPlantBlock extends PlantBlock implements Fertilizable {
    public static final IntProperty AGE = Properties.AGE_4;
    public static final BooleanProperty CUT = BooleanProperty.of("cropped");
    private final Item fruitItem;

    public FruitPlantBlock(Item fruitItem, AbstractBlock.Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, 0).with(CUT, false));
        this.fruitItem = fruitItem;
    }

    @Override
    public ItemStack getPickStack(BlockView getter, BlockPos pos, BlockState state) {
        return new ItemStack(this.fruitItem);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView getter, BlockPos pos, ShapeContext context) {
        int age = state.get(AGE);
        if (age == 0) {
            return Block.createCuboidShape(4.0D, 12.0D, 4.0D, 12.0D, 16.0D, 12.0D);
        } else if (age == 1) {
            return Block.createCuboidShape(4.0D, 10.0D, 4.0D, 12.0D, 16.0D, 12.0D);
        } else if (age == 2) {
            return Block.createCuboidShape(2.0D, 8.0D, 2.0D, 14.0D, 16.0D, 14.0D);
        } else {
            return Block.createCuboidShape(2.0D, 4.0D, 2.0D, 14.0D, 16.0D, 14.0D);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult result) {
        ItemStack stack = player.getStackInHand(hand);
        if (stack.isIn(ConventionalItemTags.SHEARS) && !state.get(CUT)) {
            if (player instanceof ServerPlayerEntity serverPlayer) {
                Criteria.ITEM_USED_ON_BLOCK.trigger(serverPlayer, pos, stack);
            }

            level.setBlockState(pos, state.with(CUT, Boolean.TRUE), 11);
            stack.damage(1, player, (blockState) -> blockState.getStackInHand(hand));
            level.playSound(player, pos, SoundEvents.BLOCK_GROWING_PLANT_CROP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return ActionResult.success(level.isClient);
        }

        int age = state.get(AGE);
        if (age == 4) {
            dropStack(level, pos, new ItemStack(this.fruitItem, 1));
            level.setBlockState(pos, state.with(AGE, 0), 2);
            level.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            return ActionResult.success(level.isClient);
        }
        return super.onUse(state, level, pos, player, hand, result);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        int age = state.get(AGE);
        if (age < 4 && random.nextInt(72) == 0) {
            BlockState blockState = state.with(AGE, age + 1);
            level.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
            level.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(blockState));
        }
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return !state.get(CUT) && state.get(AGE) < 4;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView level, BlockPos pos) {
        return level.getBlockState(pos.up()).isIn(BlockTags.LEAVES);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE).add(CUT);
    }

    @Override
    public boolean isFertilizable(WorldView level, BlockPos pos, BlockState state, boolean valid) {
        return state.get(AGE) < 4;
    }

    @Override
    public boolean canGrow(World level, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld level, Random random, BlockPos pos, BlockState state) {
        int i = Math.min(4, state.get(AGE) + 1);
        level.setBlockState(pos, state.with(AGE, i), Block.NOTIFY_LISTENERS);
    }

}