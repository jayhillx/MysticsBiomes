package com.mysticsbiomes.common.block;

import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BambooLeaves;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ToolActions;

@SuppressWarnings("deprecation")
public class SpringBambooSaplingBlock extends Block implements BonemealableBlock {
    protected static final VoxelShape SAPLING_SHAPE = Block.box(4.0, 0.0, 4.0, 12.0, 12.0, 12.0);

    public SpringBambooSaplingBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(getter, pos);
        return SAPLING_SHAPE.move(vec3.x, vec3.y, vec3.z);
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource source) {
        if (source.nextInt(3) == 0 && level.isEmptyBlock(pos.above()) && level.getRawBrightness(pos.above(), 0) >= 9) {
            this.growBamboo(level, pos);
        }
    }

    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        BlockState belowState = reader.getBlockState(pos.below());
        return belowState.is(BlockTags.DIRT) || belowState.is(BlockTags.SAND) || belowState.is(MysticBlocks.SPRING_BAMBOO.get()) || belowState.is(MysticBlocks.SPRING_BAMBOO_SAPLING.get());
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor accessor, BlockPos pos, BlockPos pos2) {
        if (!state.canSurvive(accessor, pos)) {
            return Blocks.AIR.defaultBlockState();
        } else {
            if (direction == Direction.UP && state2.is(MysticBlocks.SPRING_BAMBOO.get())) {
                accessor.setBlock(pos, MysticBlocks.SPRING_BAMBOO.get().defaultBlockState(), 2);
            }
            return super.updateShape(state, direction, state2, accessor, pos, pos2);
        }
    }

    public ItemStack getCloneItemStack(BlockGetter getter, BlockPos pos, BlockState state) {
        return new ItemStack(MysticItems.SPRING_BAMBOO.get());
    }

    public boolean isValidBonemealTarget(LevelReader reader, BlockPos pos, BlockState state, boolean p_256316_) {
        return reader.getBlockState(pos.above()).isAir();
    }

    public boolean isBonemealSuccess(Level level, RandomSource source, BlockPos pos, BlockState state) {
        return true;
    }

    public void performBonemeal(ServerLevel level, RandomSource source, BlockPos pos, BlockState state) {
        this.growBamboo(level, pos);
    }

    public float getDestroyProgress(BlockState state, Player player, BlockGetter getter, BlockPos pos) {
        return player.getMainHandItem().canPerformAction(ToolActions.SWORD_DIG) ? 1.0F : super.getDestroyProgress(state, player, getter, pos);
    }

    protected void growBamboo(Level level, BlockPos pos) {
        level.setBlock(pos.above(), MysticBlocks.SPRING_BAMBOO.get().defaultBlockState().setValue(SpringBambooStalkBlock.LEAVES, BambooLeaves.SMALL), 3);
    }

}