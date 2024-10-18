package com.mysticsbiomes.common.block.entity;

import com.mysticsbiomes.common.block.ButterflyNestBlock;
import com.mysticsbiomes.common.entity.animal.Butterfly;
import com.mysticsbiomes.init.MysticBlockEntities;
import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticSounds;
import net.minecraft.block.BlockState;
import net.minecraft.block.FireBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.nbt.NbtList;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;
import org.joml.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ButterflyNestBlockEntity extends BlockEntity {
    private static final List<String> IGNORED_TAGS = Arrays.asList("Air", "ArmorDropChances", "ArmorItems", "Brain", "CanPickUpLoot", "DeathTime", "FallDistance", "FallFlying", "Fire", "HandDropChances", "HandItems", "HurtByTimestamp", "HurtTime", "LeftHanded", "Motion", "NoGravity", "OnGround", "PortalCooldown", "Pos", "Rotation", "CannotEnterHiveTicks", "TicksSincePollination", "CropsGrownSincePollination", "HivePos", "Passengers", "Leash", "UUID");
    private final List<ButterflyData> stored = new ArrayList<>();

    public ButterflyNestBlockEntity(BlockPos pos, BlockState state) {
        super(MysticBlockEntities.BUTTERFLY_NEST, pos, state);
    }

    @Override
    protected void writeNbt(NbtCompound tag) {
        super.writeNbt(tag);
        tag.put("Butterflies", this.writeButterflies());
    }

    public NbtList writeButterflies() {
        NbtList list = new NbtList();

        for (ButterflyData data : this.stored) {
            NbtCompound tag = data.dataTracker.copy();
            tag.remove("UUID");
            NbtCompound tag1 = new NbtCompound();
            tag1.put("EntityData", tag);
            tag1.putInt("TicksInNest", data.ticksInNest);
            tag1.putInt("MinOccupationTicks", data.minOccupationTicks);
            list.add(tag1);
        }
        return list;
    }

    @Override
    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);
        this.stored.clear();

        NbtList list = tag.getList("Butterflies", 10);

        for (int i = 0; i < list.size(); ++i) {
            NbtCompound tag1 = list.getCompound(i);
            ButterflyData data = new ButterflyData(tag1.getCompound("EntityData"), tag1.getInt("TicksInNest"), tag1.getInt("MinOccupationTicks"));
            this.stored.add(data);
        }
    }

    static void removeIgnoredTags(NbtCompound tag) {
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
        if (this.world != null) {
            for (BlockPos pos : BlockPos.iterate(this.pos.add(-1, -1, -1), this.pos.add(1, 1, 1))) {
                if (this.world.getBlockState(pos).getBlock() instanceof FireBlock) {
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
            entity.removeAllPassengers();

            NbtCompound tag = new NbtCompound();
            entity.saveNbt(tag);
            this.storeButterfly(tag, ticksInNest, hasNectar);

            if (this.world != null) {
                BlockPos pos = this.getPos();
                this.world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), MysticSounds.BUTTERFLY_NEST_ENTER, SoundCategory.BLOCKS, 1.0F, 1.0F);
                this.world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(entity, this.getCachedState()));
            }
            entity.discard();
            super.markDirty();
        }
    }

    public void storeButterfly(NbtCompound tag, int ticksInNest, boolean hasNectar) {
        this.stored.add(new ButterflyData(tag, ticksInNest, hasNectar ? 2400 : 600));
    }

    public void emptyAllLivingFromNest(@Nullable PlayerEntity player, BlockState state, ReleaseStatus status) {
        List<Entity> list = this.releaseAllOccupants(state, status);
        if (player != null) {
            for (Entity entity : list) {
                if (entity instanceof Butterfly butterfly) {
                    if (player.getBlockPos().getSquaredDistance(entity.getPos()) <= 16.0D) {
                        butterfly.setStayOutOfNestCountdown(400);
                    }
                }
            }
        }
    }

    private List<Entity> releaseAllOccupants(BlockState state, ReleaseStatus status) {
        List<Entity> list = new ArrayList<>();
        if (this.world != null) {
            this.stored.removeIf((data) -> releaseOccupant(this.world, this.pos, state, data, list, status));
        }

        if (!list.isEmpty()) {
            super.markDirty();
        }
        return list;
    }

    private static boolean releaseOccupant(World level, BlockPos pos, BlockState state, ButterflyData data, @Nullable List<Entity> occupants, ReleaseStatus status) {
        if ((level.isNight() || level.isRaining()) && status != ReleaseStatus.EMERGENCY) {
            return false;
        } else {
            NbtCompound tag = data.dataTracker.copy();
            removeIgnoredTags(tag);
            tag.put("NestPos", NbtHelper.fromBlockPos(pos));
            tag.putBoolean("NoGravity", true);

            Direction direction = state.get(ButterflyNestBlock.FACING);
            BlockPos relativePos = pos.offset(direction);

            boolean flag = !level.getBlockState(relativePos).getCollisionShape(level, relativePos).isEmpty();
            if (flag && status != ReleaseStatus.EMERGENCY) {
                return false;
            } else {
                Entity entity = EntityType.loadEntityWithPassengers(tag, level, (e) -> e);
                if (entity != null) {
                    if (entity instanceof Butterfly butterfly) {
                        float f = entity.getWidth();
                        double d3 = flag ? 0.0D : 0.55D + (double)(f / 2.0F);
                        double d0 = (double)pos.getX() + 0.5D + d3 * (double)direction.getOffsetX();
                        double d1 = (double)pos.getY() + 0.5D - (double)(entity.getHeight() / 2.0F);
                        double d2 = (double)pos.getZ() + 0.5D + d3 * (double)direction.getOffsetZ();

                        butterfly.setStayOutOfNestCountdown(400);
                        butterfly.setInNest(false);

                        if (status == ReleaseStatus.NECTAR_DELIVERED) {
                            butterfly.dropOffNectar();

                            if (state.isOf(MysticBlocks.BUTTERFLY_NEST)) {
                                int i = state.get(ButterflyNestBlock.NECTAR_LEVEL);
                                if (i < 12) {
                                    level.setBlockState(pos, state.with(ButterflyNestBlock.NECTAR_LEVEL, i + butterfly.getNectarPoints()));
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

                        entity.refreshPositionAndAngles(d0, d1, d2, entity.getYaw(), entity.getPitch());
                    }

                    level.playSound(null, pos, MysticSounds.BUTTERFLY_NEST_EXIT, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    level.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(entity, level.getBlockState(pos)));
                    return level.spawnEntity(entity);
                } else {
                    return false;
                }
            }
        }
    }

    private static void setReleaseData(int i, Butterfly butterfly) {
        int age = butterfly.getBreedingAge();
        if (age < 0) {
            butterfly.setBreedingAge(Math.min(0, age + i));
        } else if (age > 0) {
            butterfly.setBreedingAge(Math.max(0, age - i));
        }
        butterfly.setLoveTicks(Math.max(0, butterfly.getLoveTicks() - i));
    }

    public static void serverTick(World level, BlockPos pos, BlockState state, ButterflyNestBlockEntity entity) {
        tickOccupants(level, pos, state, entity.stored);

        for (ButterflyData data : entity.stored) {
            if (!entity.stored.isEmpty()) {
                if (level.getRandom().nextDouble() < 0.075D) {
                    if (data.dataTracker.getBoolean("IsBreeding")) {
                        if (level instanceof ServerWorld serverLevel) {
                            serverLevel.spawnParticles(ParticleTypes.HEART, Math.lerp(level.random.nextDouble(), pos.getX() - (double)0.4F, pos.getX() + (double)0.4F) + 0.5F, pos.up().getY(), Math.lerp(level.random.nextDouble(), pos.getZ() - (double)0.4F, pos.getZ() + (double)0.4F) + 0.5F, 0, 0, 0.0D, 0.0D, 0.0D);
                        }
                    }
                }
            }
        }
    }

    private static void tickOccupants(World level, BlockPos pos, BlockState state, List<ButterflyData> list) {
        boolean flag = false;

        ButterflyData data;
        for (Iterator<ButterflyData> iterator = list.iterator(); iterator.hasNext(); ++data.ticksInNest) {
            data = iterator.next();

            if (data.ticksInNest > data.minOccupationTicks) {
                ReleaseStatus releaseStatus;

                if (data.dataTracker.getInt("NectarPoints") > 0) {
                    releaseStatus = ReleaseStatus.NECTAR_DELIVERED;
                } else if (data.dataTracker.getBoolean("IsSleeping")) {
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
            markDirty(level, pos, state);
        }
    }

    static class ButterflyData {
        final NbtCompound dataTracker;
        int ticksInNest;
        final int minOccupationTicks;

        ButterflyData(NbtCompound tag, int ticksInNest, int minTicks) {
            ButterflyNestBlockEntity.removeIgnoredTags(tag);
            this.dataTracker = tag;
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