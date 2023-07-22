package com.mysticsbiomes.common.block;

import com.mysticsbiomes.init.MysticItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeHooks;

@SuppressWarnings("deprecation")
public class StrawberryBushBlock extends BushBlock {
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 6);
    private static final VoxelShape SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
    /** Value determined by the biomes' temperature. */
    private boolean hasPerfectBiomeConditions;

    public StrawberryBushBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    public ItemStack getCloneItemStack(BlockGetter getter, BlockPos pos, BlockState state) {
        return new ItemStack(MysticItems.STRAWBERRY.get());
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(AGE) < 6;
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int temperature = (int) level.getBiome(pos).value().getBaseTemperature();

        int speed;
        if (state.getValue(AGE) < 6) {
            this.hasPerfectBiomeConditions = false;

            if (temperature >= 0.7F && level.getRawBrightness(pos.above(), 0) >= 7) {
                if (temperature >= 0.95F) {
                    this.hasPerfectBiomeConditions = true;
                    speed = 128;
                } else {
                    speed = 384;
                }
            } else {
                speed = 896;
            }

            if (ForgeHooks.onCropsGrowPre(level, pos, state, random.nextInt(speed) == 0)) {
                level.setBlock(pos, state.setValue(AGE, state.getValue(AGE) + 1), 2);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(state));
                ForgeHooks.onCropsGrowPost(level, pos, state);
            }
        }
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (state.getValue(AGE) == 6) {

            if (this.hasPerfectBiomeConditions && level.random.nextInt(21) == 0) {
                popResource(level, pos, new ItemStack(MysticItems.SWEET_STRAWBERRY.get(), 1));
            }

            popResource(level, pos, new ItemStack(MysticItems.STRAWBERRY.get(), 2 + level.random.nextInt(2)));
            level.setBlock(pos, state.setValue(AGE, 2), 2);
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return super.use(state, level, pos, player, hand, result);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

}