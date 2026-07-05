package com.mysticsbiomes.common.block;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class LeafyBlossomsBlock extends LeavesBlock {
    public static final BooleanProperty LEAFY = BooleanProperty.create("leafy");
    public static final BooleanProperty SNIPPED = BooleanProperty.create("snipped");

    public LeafyBlossomsBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(LEAFY, false).setValue(SNIPPED, false));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState updatedState = super.getStateForPlacement(context);

        BlockState aboveState = context.getLevel().getBlockState(context.getClickedPos().above());
        BlockState belowState = context.getLevel().getBlockState(context.getClickedPos().below());

        return updatedState.setValue(LEAFY, (aboveState.is(this) && !belowState.is(this)) || (belowState.is(this) && belowState.getValue(SNIPPED)));
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos pos, BlockPos facingPos) {
        BlockState updatedState = super.updateShape(state, facing, facingState, level, pos, facingPos);

        BlockState aboveState = level.getBlockState(pos.above());
        BlockState belowState = level.getBlockState(pos.below());

        return updatedState.setValue(LEAFY, (aboveState.is(this) && !belowState.is(this)) || (belowState.is(this) && belowState.getValue(SNIPPED)));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        ItemStack stack = player.getItemInHand(hand);

        if (!state.getValue(SNIPPED) || (level.getBlockState(pos.above()).is(this) || (level.getBlockState(pos.below()).is(this) && level.getBlockState(pos.below()).getValue(SNIPPED)))) {
            if (stack.is(Items.SHEARS)) {
                stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));

                if (player instanceof ServerPlayer serverPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, pos, stack);
                }

                level.setBlock(pos, state.setValue(SNIPPED, true), 1 | 2);
                level.playSound(player, pos, SoundEvents.GROWING_PLANT_CROP, SoundSource.BLOCKS, 1.0F, 1.0F);
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(LEAFY, SNIPPED);
    }

}