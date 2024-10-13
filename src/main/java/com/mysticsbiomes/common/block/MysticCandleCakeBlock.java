package com.mysticsbiomes.common.block;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MysticCandleCakeBlock extends AbstractCandleBlock {
    protected static final VoxelShape CAKE_SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D);
    protected static final VoxelShape CANDLE_SHAPE = Block.createCuboidShape(7.0D, 8.0D, 7.0D, 9.0D, 14.0D, 9.0D);
    protected static final VoxelShape SHAPE = VoxelShapes.union(CAKE_SHAPE, CANDLE_SHAPE);
    protected final Block cake;
    protected final Block candle;
    protected static Map<Pair<Block, MysticCakeBlock>, MysticCandleCakeBlock> BY_CANDLE = new HashMap<>();

    public MysticCandleCakeBlock(Block cake, Block candle) {
        super(Settings.copy(cake).luminance((state) -> state.get(Properties.LIT) ? 3 : 0));
        this.setDefaultState(this.stateManager.getDefaultState().with(LIT, Boolean.FALSE));
        this.cake = cake;
        this.candle = candle;
        BY_CANDLE.put(Pair.of(candle, (MysticCakeBlock)cake), this);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView getter, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public ItemStack getPickStack(BlockView getter, BlockPos pos, BlockState state) {
        return new ItemStack(this.cake);
    }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult result) {
        ItemStack stack = player.getStackInHand(hand);

        if (!stack.isOf(Items.FLINT_AND_STEEL) && !stack.isOf(Items.FIRE_CHARGE)) {
            if (result.getPos().y - (double)result.getBlockPos().getY() > 0.5D && player.getStackInHand(hand).isEmpty() && state.get(LIT)) {
                extinguish(player, state, level, pos);
                return ActionResult.success(level.isClient);
            } else {
                ActionResult interaction = MysticCakeBlock.eat(level, pos, this.cake.getDefaultState(), player);
                if (interaction.isAccepted()) {
                    dropStack(level, pos, stack);
                }
                return interaction;
            }
        } else {
            return ActionResult.PASS;
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState state1, WorldAccess level, BlockPos pos, BlockPos pos1) {
        return direction == Direction.DOWN && !state.canPlaceAt(level, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, state1, level, pos, pos1);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isSolid();
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return CakeBlock.DEFAULT_COMPARATOR_OUTPUT;
    }

    public static BlockState byCandle(Block candle, MysticCakeBlock cake) {
        return BY_CANDLE.get(Pair.of(candle, cake)).getDefaultState();
    }

    @Override
    protected Iterable<Vec3d> getParticleOffsets(BlockState state) {
        return ImmutableList.of(new Vec3d(0.5D, 1.0D, 0.5D));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    /** @return sorts through forge registries for cakes. */
    public static List<Block> getMysticCandleCakes() {
        return Registries.BLOCK.stream().filter(block -> block instanceof MysticCandleCakeBlock).collect(Collectors.toList());
    }

    public Block getCake() {
        return this.cake;
    }

    public Block getCandle() {
        return this.candle;
    }

}