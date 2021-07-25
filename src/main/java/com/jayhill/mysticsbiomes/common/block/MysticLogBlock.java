package com.jayhill.mysticsbiomes.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import java.util.function.Supplier;

@SuppressWarnings("all")
public class MysticLogBlock extends RotatedPillarBlock {
    public final Supplier<Block> block;

    public MysticLogBlock(Supplier<Block> strippedWood, Properties properties) {
        super(properties);
        this.block = strippedWood;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
        /** Sets new blockstate using AxeItem. */
        if (player.getHeldItem(hand).getItem() instanceof AxeItem) {
            world.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.setBlockState(pos, this.block.get().getDefaultState().with(AXIS, state.get(AXIS)));

            return ActionResultType.SUCCESS;
        }
        return ActionResultType.PASS;
    }

}