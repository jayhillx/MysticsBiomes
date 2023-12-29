package com.mysticsbiomes.common.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")
public class MysticCandleCakeBlock extends AbstractCandleBlock {
    protected static final VoxelShape CAKE_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D);
    protected static final VoxelShape CANDLE_SHAPE = Block.box(7.0D, 8.0D, 7.0D, 9.0D, 14.0D, 9.0D);
    protected static final VoxelShape SHAPE = Shapes.or(CAKE_SHAPE, CANDLE_SHAPE);
    protected final Block cake;
    protected final Block candle;
    protected static Map<Pair<Block, MysticCakeBlock>, MysticCandleCakeBlock> BY_CANDLE = Maps.newHashMap();

    public MysticCandleCakeBlock(Supplier<Block> cake, Block candle) {
        super(Properties.copy(cake.get()).lightLevel((state) -> state.getValue(BlockStateProperties.LIT) ? 3 : 0));
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, Boolean.FALSE));
        this.cake = cake.get();
        this.candle = candle;
        BY_CANDLE.put(Pair.of(candle, (MysticCakeBlock)cake.get()), this);
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    public ItemStack getCloneItemStack(BlockGetter getter, BlockPos pos, BlockState state) {
        return new ItemStack(this.cake);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        ItemStack stack = player.getItemInHand(hand);

        if (!stack.is(Items.FLINT_AND_STEEL) && !stack.is(Items.FIRE_CHARGE)) {
            if (result.getLocation().y - (double)result.getBlockPos().getY() > 0.5D && player.getItemInHand(hand).isEmpty() && state.getValue(LIT)) {
                extinguish(player, state, level, pos);
                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                InteractionResult interaction = MysticCakeBlock.eat(level, pos, this.cake.defaultBlockState(), player);
                if (interaction.consumesAction()) {
                    dropResources(state, level, pos);
                }
                return interaction;
            }
        } else {
            return InteractionResult.PASS;
        }
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState state1, LevelAccessor level, BlockPos pos, BlockPos pos1) {
        return direction == Direction.DOWN && !state.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, state1, level, pos, pos1);
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.below()).isSolid();
    }

    public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType type) {
        return false;
    }

    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        return CakeBlock.FULL_CAKE_SIGNAL;
    }

    public static BlockState byCandle(Block candle, MysticCakeBlock cake) {
        return BY_CANDLE.get(Pair.of(candle, cake)).defaultBlockState();
    }

    protected Iterable<Vec3> getParticleOffsets(BlockState state) {
        return ImmutableList.of(new Vec3(0.5D, 1.0D, 0.5D));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    /** @return sorts through forge registries for cakes. */
    public static List<Block> getMysticCandleCakes() {
        return ForgeRegistries.BLOCKS.getValues().stream().filter(block -> block instanceof MysticCandleCakeBlock).collect(Collectors.toList());
    }

    public Block getCake() {
        return this.cake;
    }

    public Block getCandle() {
        return this.candle;
    }

}