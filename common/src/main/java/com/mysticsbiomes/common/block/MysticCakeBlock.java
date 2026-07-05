package com.mysticsbiomes.common.block;

import com.google.common.collect.ImmutableList;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
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
import net.minecraft.world.phys.AABB;
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
    private static final VoxelShape[] CAKE_SHAPES = {Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.box(3.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.box(5.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.box(7.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.box(9.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.box(11.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.box(13.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D)};
    private static final BiFunction<Direction, Integer, VoxelShape> SHAPE_BY_PROPERTIES = Util.memoize((direction, bites) -> {
        VoxelShape shape = CAKE_SHAPES[bites];

        if (direction == Direction.NORTH) {
            return shape;
        }

        VoxelShape rotated = Shapes.empty();
        for (AABB box : shape.toAabbs()) {
            AABB rotatedBox = switch (direction) {
                case EAST -> new AABB(1 - box.maxZ, box.minY, box.minX, 1 - box.minZ, box.maxY, box.maxX);
                case SOUTH -> new AABB(1 - box.maxX, box.minY, 1 - box.maxZ, 1 - box.minX, box.maxY, 1 - box.minZ);
                case WEST -> new AABB(box.minZ, box.minY, 1 - box.maxX, box.maxZ, box.maxY, 1 - box.minX);
                default -> box;
            };

            rotated = Shapes.or(rotated, Shapes.create(rotatedBox));
        }

        return rotated.optimize();
    });

    public MysticCakeBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(BITES, 0).setValue(FACING, Direction.NORTH).setValue(CANDLE, Candle.NONE).setValue(LIT, false));
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        List<ItemStack> drops = new ArrayList<>();
        drops.add(new ItemStack(this));

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
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }

        if (state.getValue(CANDLE) != Candle.NONE) {
            if (!state.getValue(LIT) && (stack.is(Items.FLINT_AND_STEEL) || stack.is(Items.FIRE_CHARGE)) && candleHit(hitResult)) {
                level.setBlock(pos, state.setValue(LIT, true), 3);
                level.playSound(null, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, level.random.nextFloat() * 0.4F + 0.8F);
                return InteractionResult.sidedSuccess(level.isClientSide);
            }

            if (state.getValue(LIT) && stack.isEmpty() && candleHit(hitResult)) {
                extinguish(player, state, level, pos);
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }

        return eat(level, pos, state, player);
    }

    private static boolean candleHit(BlockHitResult hitResult) {
        return hitResult.getLocation().y - (double)hitResult.getBlockPos().getY() > 0.5D;
    }

    private static InteractionResult eat(LevelAccessor level, BlockPos pos, BlockState state, Player player) {
        if (!player.canEat(false)) {
            return InteractionResult.PASS;
        } else {
            player.awardStat(Stats.EAT_CAKE_SLICE);
            player.getFoodData().eat(6, 0.4F);

            int bites = state.getValue(BITES);
            level.gameEvent(player, GameEvent.EAT, pos);

            BlockState newState = state.setValue(BITES, bites + 1);
            if (bites == 0 && state.getValue(CANDLE) != Candle.NONE) {
                popResource((Level) level, pos, new ItemStack(state.getValue(CANDLE).getCandle()));
                newState = newState.setValue(CANDLE, Candle.NONE).setValue(LIT, false);
            }

            if (bites < 6) {
                level.setBlock(pos, newState, 3);
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
    public void onProjectileHit(Level level, BlockState state, BlockHitResult result, Projectile projectile) {
        if (!level.isClientSide && projectile.isOnFire() && this.canBeLit(state)) {
            setLit(level, state, result.getBlockPos(), true);
        }
    }

    private static boolean canLight(BlockState state) {
        return state.is(BlockTags.CANDLE_CAKES, (baseState) -> baseState.hasProperty(LIT) && !state.getValue(LIT));
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
    public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType type) {
        return false;
    }

    @Override
    protected Iterable<Vec3> getParticleOffsets(BlockState state) {
        return ImmutableList.of(new Vec3(0.5D, 1.0D, 0.5D));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
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