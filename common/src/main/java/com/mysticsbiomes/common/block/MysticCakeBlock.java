package com.mysticsbiomes.common.block;

import com.google.common.collect.ImmutableList;
import com.mysticsbiomes.common.block.util.VoxelShapeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class MysticCakeBlock extends AbstractCandleBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty BITES = BlockStateProperties.BITES;
    public static final EnumProperty<Candle> CANDLE = EnumProperty.create("candle", Candle.class);
    private static final VoxelShape CANDLE_SHAPE = Block.box(7.0D, 8.0D, 7.0D, 9.0D, 14.0D, 9.0D);
    private static final VoxelShape[] CAKE_SHAPES = {
            Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D),
            Block.box(3.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D),
            Block.box(5.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D),
            Block.box(7.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D),
            Block.box(9.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D),
            Block.box(11.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D),
            Block.box(13.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D)
    };
    private static final BiFunction<Direction, Integer, VoxelShape> SHAPE_BY_PROPERTIES = VoxelShapeUtils.createShapeRotator(CAKE_SHAPES);
    private final int foodLevel;
    private final float saturationLevel;

    public MysticCakeBlock(int foodLevel, float saturationLevel, Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(BITES, 0).setValue(FACING, Direction.NORTH).setValue(CANDLE, Candle.NONE).setValue(LIT, false));
        this.foodLevel = foodLevel;
        this.saturationLevel = saturationLevel;
    }

    public MysticCakeBlock(Properties properties) {
        this(6, 0.4F, properties);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        List<ItemStack> drops = new ArrayList<>();
        if (state.getValue(BITES) == 0) {
            drops.add(new ItemStack(this));
        }

        if (state.getValue(CANDLE) != Candle.NONE) {
            drops.add(new ItemStack(state.getValue(CANDLE).getCandle()));
        }

        return drops;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack stack = player.getItemInHand(hand);

        if (state.getValue(BITES) == 0 && state.getValue(CANDLE) == Candle.NONE && stack.is(ItemTags.CANDLES)) {
            Block block = Block.byItem(stack.getItem());
            if (block instanceof CandleBlock) {
                if (!player.isCreative()) {
                    stack.shrink(1);
                }

                level.playSound(null, pos, SoundEvents.CAKE_ADD_CANDLE, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.setBlockAndUpdate(pos, state.setValue(CANDLE, Candle.fromBlock(block)).setValue(LIT, false));
                level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
                return InteractionResult.sidedSuccess(level.isClientSide());
            }
        }

        if (state.getValue(CANDLE) != Candle.NONE) {
            if (!state.getValue(LIT) && (stack.is(Items.FLINT_AND_STEEL) || stack.is(Items.FIRE_CHARGE)) && candleHit(hitResult)) {
                level.setBlock(pos, state.setValue(LIT, true), 3);
                level.playSound(null, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, level.random.nextFloat() * 0.4F + 0.8F);
                return InteractionResult.sidedSuccess(level.isClientSide());
            }

            if (state.getValue(LIT) && stack.isEmpty() && candleHit(hitResult)) {
                extinguish(player, state, level, pos);
                return InteractionResult.sidedSuccess(level.isClientSide());
            }
        }

        return eat(level, pos, state, player);
    }

    private static boolean candleHit(BlockHitResult hitResult) {
        return hitResult.getLocation().y - (double)hitResult.getBlockPos().getY() > 0.5D;
    }

    private InteractionResult eat(LevelAccessor level, BlockPos pos, BlockState state, Player player) {
        if (!player.canEat(false)) {
            return InteractionResult.PASS;
        } else {
            int bites = state.getValue(BITES);
            if (bites == 0 && state.getValue(CANDLE) != Candle.NONE) {
                popResource((Level) level, pos, new ItemStack(state.getValue(CANDLE).getCandle()));
                state = state.setValue(CANDLE, Candle.NONE).setValue(LIT, false);
            }

            if (bites < 6) {
                /// adjust the food & saturation levels depending on the cake type; neapolitan or frosted.
                player.getFoodData().eat(this.foodLevel, this.saturationLevel);
                player.awardStat(Stats.EAT_CAKE_SLICE);

                level.setBlock(pos, state.setValue(BITES, bites + 1), 3);
                level.gameEvent(player, GameEvent.EAT, pos);
            } else {
                level.removeBlock(pos, false);
                level.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
            }

            return InteractionResult.SUCCESS;
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        VoxelShape shape = SHAPE_BY_PROPERTIES.apply(state.getValue(FACING), state.getValue(BITES));

        if (state.getValue(BITES) == 0 && state.getValue(CANDLE) != Candle.NONE) {
            shape = Shapes.or(shape, CANDLE_SHAPE);
        }

        return shape;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(BITES, 0);
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public void onProjectileHit(Level level, BlockState state, BlockHitResult hitResult, Projectile projectile) {
        if (!level.isClientSide() && projectile.isOnFire() && this.canBeLit(state)) {
            setLit(level, state, hitResult.getBlockPos(), true);
        }
    }

    private static void setLit(LevelAccessor level, BlockState state, BlockPos pos, boolean lit) {
        level.setBlock(pos, state.setValue(LIT, lit), 11);
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        return CakeBlock.FULL_CAKE_SIGNAL;
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }

    @Override
    protected Iterable<Vec3> getParticleOffsets(BlockState state) {
        return ImmutableList.of(new Vec3(0.5D, 1.0D, 0.5D));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, BITES, CANDLE, LIT);
    }

    public enum Candle implements StringRepresentable {
        NONE("none", Blocks.AIR),
        CANDLE("candle", Blocks.CANDLE),
        WHITE("white_candle", Blocks.WHITE_CANDLE),
        ORANGE("orange_candle", Blocks.ORANGE_CANDLE),
        MAGENTA("magenta_candle", Blocks.MAGENTA_CANDLE),
        LIGHT_BLUE("light_blue_candle", Blocks.LIGHT_BLUE_CANDLE),
        YELLOW("yellow_candle", Blocks.YELLOW_CANDLE),
        LIME("lime_candle", Blocks.LIME_CANDLE),
        PINK("pink_candle", Blocks.PINK_CANDLE),
        GRAY("gray_candle", Blocks.GRAY_CANDLE),
        LIGHT_GRAY("light_gray_candle", Blocks.LIGHT_GRAY_CANDLE),
        CYAN("cyan_candle", Blocks.CYAN_CANDLE),
        PURPLE("purple_candle", Blocks.PURPLE_CANDLE),
        BLUE("blue_candle", Blocks.BLUE_CANDLE),
        BROWN("brown_candle", Blocks.BROWN_CANDLE),
        GREEN("green_candle", Blocks.GREEN_CANDLE),
        RED("red_candle", Blocks.RED_CANDLE),
        BLACK("black_candle", Blocks.BLACK_CANDLE);

        private final String name;
        private final Block candle;

        Candle(String name, Block candle) {
            this.name = name;
            this.candle = candle;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }

        public Block getCandle() {
            return this.candle;
        }

        public static Candle fromBlock(Block block) {
            for (Candle candle : values()) {
                if (candle.candle == block) {
                    return candle;
                }
            }

            return NONE;
        }
    }

}