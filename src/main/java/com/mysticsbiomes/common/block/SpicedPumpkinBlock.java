package com.mysticsbiomes.common.block;

import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ToolActions;

public class SpicedPumpkinBlock extends PumpkinBlock {

    public SpicedPumpkinBlock(Properties properties) {
        super(properties);
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (player.getItemInHand(hand).canPerformAction(ToolActions.SHEARS_CARVE)) {
            if (!level.isClientSide) {
                Direction direction = result.getDirection().getAxis() == Direction.Axis.Y ? player.getDirection().getOpposite() : result.getDirection();
                
                ItemEntity entity = new ItemEntity(level, pos.getX() + 0.5D + direction.getStepX() * 0.65D, pos.getY() + 0.1D, pos.getZ() + 0.5D + direction.getStepZ() * 0.65D, new ItemStack(MysticItems.SPICED_PUMPKIN_SEEDS.get(), 4));
                entity.setDeltaMovement(0.05D * direction.getStepX() + level.random.nextDouble() * 0.02D, 0.05D, 0.05D * direction.getStepZ() + level.random.nextDouble() * 0.02D);
                level.addFreshEntity(entity);
                level.gameEvent(player, GameEvent.SHEAR, pos);

                level.playSound(null, pos, SoundEvents.PUMPKIN_CARVE, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.setBlock(pos, MysticBlocks.CARVED_SPICED_PUMPKIN.get().defaultBlockState().setValue(CarvedPumpkinBlock.FACING, direction), 11);
                player.awardStat(Stats.ITEM_USED.get(Items.SHEARS));
                player.getItemInHand(hand).hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.use(state, level, pos, player, hand, result);
        }
    }

    public StemBlock getStem() {
        return (StemBlock)MysticBlocks.SPICED_PUMPKIN_STEM.get();
    }

    public AttachedStemBlock getAttachedStem() {
        return (AttachedStemBlock)MysticBlocks.SPICED_PUMPKIN_STEM_ATTACHED.get();
    }
    
}