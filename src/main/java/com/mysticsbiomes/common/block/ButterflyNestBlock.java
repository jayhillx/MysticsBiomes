package com.mysticsbiomes.common.block;

import com.mysticsbiomes.common.block.entity.ButterflyNestBlockEntity;
import com.mysticsbiomes.init.MysticBlockEntities;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.entity.vehicle.TntMinecartEntity;
import net.minecraft.item.*;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;

import java.util.List;

public class ButterflyNestBlock extends BlockWithEntity {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final IntProperty NECTAR_LEVEL = IntProperty.of("nectar_level", 0, 5);

    public ButterflyNestBlock(AbstractBlock.Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(NECTAR_LEVEL, 0).with(FACING, Direction.NORTH));
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ButterflyNestBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World level, BlockState state, BlockEntityType<T> type) {
        return level.isClient() ? null : checkType(type, MysticBlockEntities.BUTTERFLY_NEST, ButterflyNestBlockEntity::serverTick);
    }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult result) {
        ItemStack stack = player.getStackInHand(hand);

        int i = state.get(NECTAR_LEVEL);
        boolean flag = false;
        if (i >= 12) {
            Item item = stack.getItem();

            if (stack.isOf(MysticItems.GLASS_JAR)) {
                stack.decrement(1);

                level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                if (stack.isEmpty()) {
                    player.setStackInHand(hand, new ItemStack(Items.HONEY_BOTTLE));
                } else if (!player.getInventory().insertStack(new ItemStack(Items.HONEY_BOTTLE))) {
                    player.dropItem(new ItemStack(Items.HONEY_BOTTLE), false);
                }

                flag = true;
                level.emitGameEvent(player, GameEvent.FLUID_PICKUP, pos);
            }

            if (!level.isClient() && flag) {
                player.incrementStat(Stats.USED.getOrCreateStat(item));
            }
        }

        if (flag) {
            this.resetNectarLevel(level, state, pos);
            return ActionResult.success(level.isClient);
        } else {
            return super.onUse(state, level, pos, player, hand, result);
        }
    }

    public void resetNectarLevel(World level, BlockState state, BlockPos pos) {
        level.setBlockState(pos, state.with(NECTAR_LEVEL, 0), 3);
    }

    @Override
    public void onBreak(World level, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!level.isClient && player.isCreative() && level.getGameRules().getBoolean(GameRules.DO_TILE_DROPS)) {
            BlockEntity blockEntity = level.getBlockEntity(pos);

            if (blockEntity instanceof ButterflyNestBlockEntity entity) {
                ItemStack stack = new ItemStack(this);
                int i = state.get(NECTAR_LEVEL);
                boolean flag = !entity.isEmpty();
                if (flag || i > 0) {
                    NbtCompound tag = new NbtCompound();
                    tag.put("Butterflies", entity.writeButterflies());
                    BlockItem.setBlockEntityNbt(stack, MysticBlockEntities.BUTTERFLY_NEST, tag);
                }

                NbtCompound tag = new NbtCompound();
                tag.putInt("nectar_level", i);
                stack.setSubNbt("BlockStateTag", tag);
                ItemEntity itemEntity = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), stack);
                itemEntity.setToDefaultPickupDelay();
                level.spawnEntity(itemEntity);
            }
        }
        super.onBreak(level, pos, state, player);
    }

    @Override
    public List<ItemStack> getDroppedStacks(BlockState state, LootContextParameterSet.Builder builder) {
        Entity entity = builder.getOptional(LootContextParameters.THIS_ENTITY);
        if (entity instanceof TntEntity || entity instanceof CreeperEntity || entity instanceof WitherSkullEntity || entity instanceof WitherEntity || entity instanceof TntMinecartEntity) {
            BlockEntity blockEntity = builder.getOptional(LootContextParameters.BLOCK_ENTITY);

            if (blockEntity instanceof ButterflyNestBlockEntity nest) {
                nest.emptyAllLivingFromNest(null, state, ButterflyNestBlockEntity.ReleaseStatus.EMERGENCY);
            }
        }
        return super.getDroppedStacks(state, builder);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (world.getBlockState(pos).getBlock() instanceof FireBlock) {
            BlockEntity blockEntity = world.getBlockEntity(pos);

            if (blockEntity instanceof ButterflyNestBlockEntity nest) {
                nest.emptyAllLivingFromNest(null, state, ButterflyNestBlockEntity.ReleaseStatus.EMERGENCY);
            }
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(FACING, context.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NECTAR_LEVEL, FACING);
    }

}