package com.meepshadow.mysticsbiomes.common.block;

import com.meepshadow.mysticsbiomes.init.ModBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class ModOre extends Block {
    public ModOre(Block.Properties properties) {
        super(properties);
    }

    protected int getExperience(Random rand) {
        if (this == ModBlock.SERENE_CRYSTAL_ORE.get()) {
            return MathHelper.nextInt(rand, 4, 8);
        } else {
            return this == ModBlock.SWEET_CRYSTAL_ORE.get() ? MathHelper.nextInt(rand, 4, 8) : 0;
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void spawnAdditionalDrops(BlockState state, World worldIn, BlockPos pos, ItemStack stack) {
        super.spawnAdditionalDrops(state, worldIn, pos, stack);
    }

    @Override
    public int getExpDrop(BlockState state, net.minecraft.world.IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? this.getExperience(RANDOM) : 0;
    }
}