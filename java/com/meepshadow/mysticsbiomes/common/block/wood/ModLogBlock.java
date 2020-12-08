package com.meepshadow.mysticsbiomes.common.block.wood;

import java.util.function.Supplier;
import com.meepshadow.mysticsbiomes.common.util.BlockUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class ModLogBlock extends LogBlock {
    private final Supplier<Block> block;

    public ModLogBlock(Supplier<Block> strippedBlock, MaterialColor verticalColor, Properties properties) {
        super(verticalColor, properties);
        this.block = strippedBlock;
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
        if(player.getHeldItem(hand).getItem() instanceof AxeItem) {
            world.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.setBlockState(pos, BlockUtils.transferAllBlockStates(state, this.block.get().getDefaultState()));
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.PASS;
    }

}
