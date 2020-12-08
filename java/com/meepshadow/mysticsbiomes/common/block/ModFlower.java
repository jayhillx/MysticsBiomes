package com.meepshadow.mysticsbiomes.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.potion.Effect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class ModFlower extends BushBlock {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
    private final Effect stewEffect;
    private final int stewEffectDuration;

    public ModFlower(Effect p_i49984_1_, int effectDuration, Properties p_i49984_3_) {
        super(p_i49984_3_);
        this.stewEffect = p_i49984_1_;
        if (p_i49984_1_.isInstant()) {
            this.stewEffectDuration = effectDuration;
        } else {
            this.stewEffectDuration = effectDuration * 20;
        }

    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Vec3d vec3d = state.getOffset(worldIn, pos);
        return SHAPE.withOffset(vec3d.x, vec3d.y, vec3d.z);
    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public Effect getStewEffect() {
        return this.stewEffect;
    }

    public int getStewEffectDuration() {
        return this.stewEffectDuration;
    }

}
