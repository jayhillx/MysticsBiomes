package com.mysticsbiomes.common.block;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class MysticCakeBlock extends CakeBlock {

    public MysticCakeBlock(AbstractBlock.Settings properties) {
        super(properties);
    }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult result) {
        ItemStack stack = player.getStackInHand(hand);
        Item item = stack.getItem();
        if (stack.isIn(ItemTags.CANDLES) && state.get(BITES) == 0) {
            Block block = Block.getBlockFromItem(item);
            if (block instanceof CandleBlock) {
                if (!player.isCreative()) {
                    stack.decrement(1);
                }

                level.playSound(null, pos, SoundEvents.BLOCK_CAKE_ADD_CANDLE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                level.setBlockState(pos, MysticCandleCakeBlock.byCandle(block, this));
                level.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                player.incrementStat(Stats.USED.getOrCreateStat(item));
                return ActionResult.SUCCESS;
            }
        }

        if (level.isClient) {
            if (eat(level, pos, state, player).isAccepted()) {
                return ActionResult.SUCCESS;
            }

            if (stack.isEmpty()) {
                return ActionResult.CONSUME;
            }
        }
        return eat(level, pos, state, player);
    }

    protected static ActionResult eat(World level, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!player.canConsume(false)) {
            return ActionResult.PASS;
        } else {
            player.incrementStat(Stats.EAT_CAKE_SLICE);
            player.getHungerManager().add(6, 0.4F);

            int i = state.get(BITES);
            level.emitGameEvent(player, GameEvent.EAT, pos);
            if (i < 6) {
                level.setBlockState(pos, state.with(BITES, i + 1), 3);
            } else {
                level.removeBlock(pos, false);
                level.emitGameEvent(player, GameEvent.BLOCK_DESTROY, pos);
            }
            return ActionResult.SUCCESS;
        }
    }

}