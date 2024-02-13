package com.mysticsbiomes.common.block.entity;

import com.google.common.collect.Lists;
import com.mysticsbiomes.common.block.ButterflyNestBlock;
import com.mysticsbiomes.common.animal.Butterfly;
import com.mysticsbiomes.init.MysticBlockEntities;
import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ButterflyNestBlockEntity extends BlockEntity {
    private static final List<String> IGNORED_TAGS = Arrays.asList("Air", "ArmorDropChances", "ArmorItems", "Brain", "CanPickUpLoot", "DeathTime", "FallDistance", "FallFlying", "Fire", "HandDropChances", "HandItems", "HurtByTimestamp", "HurtTime", "LeftHanded", "Motion", "NoGravity", "OnGround", "PortalCooldown", "Pos", "Rotation", "Passengers", "Leash");
    private final List<ButterflyData> stored = Lists.newArrayList();

    public ButterflyNestBlockEntity(BlockPos pos, BlockState state) {
        super(MysticBlockEntities.BUTTERFLY_NEST.get(), pos, state);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("Butterflies", this.writeButterflies());
    }

    public ListTag writeButterflies() {
        ListTag list = new ListTag();

        for (ButterflyData data : this.stored) {
            CompoundTag tag = data.entityData.copy();
            tag.remove("UUID");
            CompoundTag tag1 = new CompoundTag();
            tag1.put("EntityData", tag);
            tag1.putInt("TicksInNest", data.ticksInNest);
            tag1.putInt("MinOccupationTicks", data.minOccupationTicks);
            list.add(tag1);
        }
        return list;
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.stored.clear();

        ListTag list = tag.getList("Butterflies", 10);

        for (int i = 0; i < list.size(); ++i) {
            CompoundTag tag1 = list.getCompound(i);
            ButterflyData data = new ButterflyData(tag1.getCompound("EntityData"), tag1.getInt("TicksInNest"), tag1.getInt("MinOccupationTicks"));
            this.stored.add(data);
        }
    }

    static void removeIgnoredTags(CompoundTag tag) {
        for (String s : IGNORED_TAGS) {
            tag.remove(s);
        }
    }

    public boolean isEmpty() {
        return this.stored.isEmpty();
    }

    public boolean isFull() {
        return this.stored.size() == 3;
    }

    public boolean isFireNearby() {
        if (this.level != null) {
            for (BlockPos pos : BlockPos.betweenClosed(this.worldPosition.offset(-1, -1, -1), this.worldPosition.offset(1, 1, 1))) {
                if (this.level.getBlockState(pos).getBlock() instanceof FireBlock) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addOccupant(Entity entity, boolean hasNectar) {
        this.addOccupantWithPresetTicks(entity, hasNectar, 0);
    }

    public void addOccupantWithPresetTicks(Entity entity, boolean hasNectar, int ticksInNest) {
        if (this.stored.size() < 3) {
            entity.stopRiding();
            entity.ejectPassengers();

            CompoundTag tag = new CompoundTag();
            entity.save(tag);
            this.storeButterfly(tag, ticksInNest, hasNectar);

            if (this.level != null) {
                BlockPos pos = this.getBlockPos();
                this.level.playSound(null, pos.getX(), pos.getY(), pos.getZ(), MysticSounds.BUTTERFLY_NEST_ENTER.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
                this.level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(entity, this.getBlockState()));
            }
            entity.discard();
            super.setChanged();
        }
    }

    public void storeButterfly(CompoundTag tag, int ticksInNest, boolean hasNectar) {
        this.stored.add(new ButterflyData(tag, ticksInNest, hasNectar ? 2400 : 600));
    }

    public void emptyAllLivingFromNest(@Nullable Player player, BlockState state, ReleaseStatus status) {
        List<Entity> list = this.releaseAllOccupants(state, status);
        if (player != null) {
            for (Entity entity : list) {
                if (entity instanceof Butterfly butterfly) {
                    if (player.position().distanceToSqr(entity.position()) <= 16.0D) {
                        butterfly.setStayOutOfNestCountdown(400);
                    }
                }
            }
        }
    }

    private List<Entity> releaseAllOccupants(BlockState state, ReleaseStatus status) {
        List<Entity> list = Lists.newArrayList();
        if (this.level != null) {
            this.stored.removeIf((data) -> releaseOccupant(this.level, this.worldPosition, state, data, list, status));
        }

        if (!list.isEmpty()) {
            super.setChanged();
        }
        return list;
    }

    private static void setReleaseData(int i, Butterfly butterfly) {
        int age = butterfly.getAge();
        if (age < 0) {
            butterfly.setAge(Math.min(0, age + i));
        } else if (age > 0) {
            butterfly.setAge(Math.max(0, age - i));
        }
        butterfly.setInLoveTime(Math.max(0, butterfly.getInLoveTime() - i));
    }

    private static boolean releaseOccupant(Level level, BlockPos pos, BlockState state, ButterflyData data, @Nullable List<Entity> occupants, ReleaseStatus status) {
        if ((level.isNight() || level.isRaining()) && status != ReleaseStatus.EMERGENCY) {
            return false;
        } else {
            CompoundTag tag = data.entityData.copy();
            removeIgnoredTags(tag);
            tag.put("NestPos", NbtUtils.writeBlockPos(pos));
            tag.putBoolean("NoGravity", true);

            Direction direction = state.getValue(ButterflyNestBlock.FACING);
            BlockPos relativePos = pos.relative(direction);

            boolean flag = !level.getBlockState(relativePos).getCollisionShape(level, relativePos).isEmpty();
            if (flag && status != ReleaseStatus.EMERGENCY) {
                return false;
            } else {
                Entity entity = EntityType.loadEntityRecursive(tag, level, (e) -> e);

                if (entity != null) {
                    if (entity instanceof Butterfly butterfly) {
                        float f = entity.getBbWidth();
                        double d3 = flag ? 0.0D : 0.55D + (double)(f / 2.0F);
                        double d0 = (double)pos.getX() + 0.5D + d3 * (double)direction.getStepX();
                        double d1 = (double)pos.getY() + 0.5D - (double)(entity.getBbHeight() / 2.0F);
                        double d2 = (double)pos.getZ() + 0.5D + d3 * (double)direction.getStepZ();

                        butterfly.setStayOutOfNestCountdown(400);
                        butterfly.setInNest(false);

                        if (status == ReleaseStatus.NECTAR_DELIVERED) {
                            butterfly.dropOffNectar();

                            if (state.is(MysticBlocks.BUTTERFLY_NEST.get())) {
                                int i = state.getValue(ButterflyNestBlock.NECTAR_LEVEL);
                                if (i < 12) {
                                    level.setBlockAndUpdate(pos, state.setValue(ButterflyNestBlock.NECTAR_LEVEL, i + butterfly.getNectarPoints()));
                                }
                            }
                        }

                        if (status == ReleaseStatus.SLEEPING) {
                            butterfly.setSleeping(false);
                            butterfly.setTicksSinceLastSlept(0);
                        }

                        setReleaseData(data.ticksInNest, butterfly);
                        if (occupants != null) {
                            occupants.add(butterfly);
                        }

                        entity.moveTo(d0, d1, d2, entity.getYRot(), entity.getXRot());
                    }

                    level.playSound(null, pos, MysticSounds.BUTTERFLY_NEST_EXIT.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(entity, level.getBlockState(pos)));
                    return level.addFreshEntity(entity);
                } else {
                    return false;
                }
            }
        }
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, ButterflyNestBlockEntity entity) {
        tickOccupants(level, pos, state, entity.stored);

        for (ButterflyData data : entity.stored) {
            if (!entity.stored.isEmpty()) {
                if (level.getRandom().nextDouble() < 0.075D) {
                    if (data.entityData.getBoolean("IsBreeding")) {
                        if (level instanceof ServerLevel serverLevel) {
                            serverLevel.sendParticles(ParticleTypes.HEART, Mth.lerp(level.random.nextDouble(), pos.getX() - (double)0.4F, pos.getX() + (double)0.4F) + 0.5F, pos.above().getY(), Mth.lerp(level.random.nextDouble(), pos.getZ() - (double)0.4F, pos.getZ() + (double)0.4F) + 0.5F, 0, 0, 0.0D, 0.0D, 0.0D);
                        }
                    }
                }
            }
        }
    }

    private static void tickOccupants(Level level, BlockPos pos, BlockState state, List<ButterflyData> list) {
        boolean flag = false;

        ButterflyData data;
        for (Iterator<ButterflyData> iterator = list.iterator(); iterator.hasNext(); ++data.ticksInNest) {
            data = iterator.next();

            if (data.ticksInNest > data.minOccupationTicks) {
                ReleaseStatus releaseStatus;

                if (data.entityData.getInt("NectarPoints") > 0) {
                    releaseStatus = ReleaseStatus.NECTAR_DELIVERED;
                } else if (data.entityData.getBoolean("IsSleeping")) {
                    releaseStatus = ReleaseStatus.SLEEPING;
                } else {
                    releaseStatus = ReleaseStatus.RELEASED;
                }

                if (releaseOccupant(level, pos, state, data, null, releaseStatus)) {
                    flag = true;
                    iterator.remove();
                }
            }
        }

        if (flag) {
            setChanged(level, pos, state);
        }
    }

    static class ButterflyData {
        final CompoundTag entityData;
        int ticksInNest;
        final int minOccupationTicks;

        ButterflyData(CompoundTag tag, int ticksInNest, int minTicks) {
            ButterflyNestBlockEntity.removeIgnoredTags(tag);
            this.entityData = tag;
            this.ticksInNest = ticksInNest;
            this.minOccupationTicks = minTicks;
        }
    }

    public enum ReleaseStatus {
        NECTAR_DELIVERED,
        SLEEPING,
        RELEASED,
        EMERGENCY
    }

}