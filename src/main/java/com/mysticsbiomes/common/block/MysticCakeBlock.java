package com.mysticsbiomes.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class MysticCakeBlock extends CakeBlock {

    public MysticCakeBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        ItemStack stack = player.getItemInHand(hand);
        Item item = stack.getItem();
        if (stack.is(ItemTags.CANDLES) && state.getValue(BITES) == 0) {
            Block block = Block.byItem(item);
            if (block instanceof CandleBlock) {
                if (!player.isCreative()) {
                    stack.shrink(1);
                }

                level.playSound(null, pos, SoundEvents.CAKE_ADD_CANDLE, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.setBlockAndUpdate(pos, MysticCandleCakeBlock.byCandle(block, this));
                level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                player.awardStat(Stats.ITEM_USED.get(item));
                return InteractionResult.SUCCESS;
            }
        }

        if (level.isClientSide) {
            if (eat(level, pos, state, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if (stack.isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }
        return eat(level, pos, state, player);
    }

    protected static InteractionResult eat(LevelAccessor level, BlockPos pos, BlockState state, Player player) {
        if (!player.canEat(false)) {
            return InteractionResult.PASS;
        } else {
            player.awardStat(Stats.EAT_CAKE_SLICE);
            player.getFoodData().eat(6, 0.4F);

            int i = state.getValue(BITES);
            level.gameEvent(player, GameEvent.EAT, pos);
            if (i < 6) {
                level.setBlock(pos, state.setValue(BITES, i + 1), 3);
            } else {
                level.removeBlock(pos, false);
                level.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
            }
            return InteractionResult.SUCCESS;
        }
    }

}