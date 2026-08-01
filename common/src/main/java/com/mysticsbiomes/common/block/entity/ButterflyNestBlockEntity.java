package com.mysticsbiomes.common.block.entity;

import com.mysticsbiomes.common.block.ButterflyNestBlock;
import com.mysticsbiomes.common.entity.animal.Butterfly;
import com.mysticsbiomes.common.entity.animal.Caterpillar;
import com.mysticsbiomes.init.MysticBlockEntities;
import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticEntities;
import com.mysticsbiomes.init.MysticSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.*;

public class ButterflyNestBlockEntity extends BlockEntity {
    private static final List<String> IGNORED_TAGS = Arrays.asList("Air", "ArmorDropChances", "ArmorItems", "Brain", "CanPickUpLoot", "DeathTime", "FallDistance", "FallFlying", "Fire", "HandDropChances", "HandItems", "HurtByTimestamp", "HurtTime", "LeftHanded", "Motion", "NoGravity", "OnGround", "PortalCooldown", "Pos", "Rotation", "Passengers", "Leash");
    private final List<ButterflyData> stored = new ArrayList<>();

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
            CompoundTag tag = new CompoundTag();
            tag.put("EntityData", data.occupant.entityData.copy());
            tag.putInt("TicksInNest", data.occupant.ticksInNest);
            tag.putInt("MinOccupationTicks", data.occupant.minTicksInNest);
            list.add(tag);
        }
        return list;
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.stored.clear();
        if (tag.contains("Butterflies")) {
            ListTag list = tag.getList("Butterflies", 10);
            for (int i = 0; i < list.size(); ++i) {
                CompoundTag tag1 = list.getCompound(i);
                ButterflyData data = new ButterflyData(tag1.getCompound("EntityData"), tag1.getInt("TicksInNest"), tag1.getInt("MinOccupationTicks"));
                this.stored.add(data);
            }
        }
    }

    /** @param entity that is stored when it enters a nest, in {@link Butterfly.EnterNestGoal} */
    public void addOccupant(Entity entity) {
        if (this.stored.size() < 3) {
            entity.stopRiding();
            entity.ejectPassengers();
            this.storeButterfly(Occupant.of(entity));

            if (this.level != null) {
                BlockPos pos = this.getBlockPos();
                this.level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(entity, this.getBlockState()));
                this.level.playSound(null, pos.getX(), pos.getY(), pos.getZ(), MysticSounds.BUTTERFLY_NEST_ENTER.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
                super.setChanged();
            }
            entity.discard();
        }
    }

    public void storeButterfly(Occupant occupant) {
        this.stored.add(new ButterflyData(occupant));
    }

    public void emptyAllLivingFromNest(BlockState state, ReleaseStatus status) {
        List<Entity> list = this.releaseAllOccupants(state, status);

        for (Entity entity : list) {
            if (entity instanceof Butterfly butterfly) {
                butterfly.setTicksBeforeCanEnterNest(400);
            }
        }
    }

    private List<Entity> releaseAllOccupants(BlockState state, ReleaseStatus status) {
        List<Entity> list = new ArrayList<>();
        if (this.level != null) {
            this.stored.removeIf((data) -> releaseOccupant(this.level, this.worldPosition, state, data.toOccupant(), list, status));
        }

        if (!list.isEmpty()) {
            super.setChanged();
        }
        return list;
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

    public boolean isFull() {
        return this.stored.size() == 3;
    }

    public boolean isEmpty() {
        return this.stored.isEmpty();
    }

    public static int getNectarLevel(BlockState state) {
        return state.getValue(ButterflyNestBlock.NECTAR_LEVEL);
    }

    /** in {@link ButterflyNestBlock#getTicker(Level, BlockState, BlockEntityType)} */
    public static void serverTick(Level level, BlockPos pos, BlockState state, ButterflyNestBlockEntity nest) {
        tickOccupants(level, pos, state, nest.stored);

        if (!nest.stored.isEmpty()) {
            if (level.getRandom().nextDouble() < 0.005D) {
                double d0 = pos.getX() + 0.5D;
                double d1 = pos.getY();
                double d2 = pos.getZ() + 0.5D;
                level.playSound(null, d0, d1, d2, SoundEvents.AZALEA_LEAVES_STEP, SoundSource.BLOCKS, 1.0F, 1.0F);
            }

            for (ButterflyData data : nest.stored) {
                if (data.isBreeding() && containsBothPartners(data, nest.stored)) {
                    if (level.getRandom().nextDouble() < 0.075D) {
                        if (level.getBlockState(pos.above()).isAir()) {
                            ((ServerLevel)level).sendParticles(ParticleTypes.HEART, Mth.lerp(level.random.nextDouble(), pos.getX() - (double)0.4F, pos.getX() + (double)0.4F) + 0.5F, pos.above().getY(), Mth.lerp(level.random.nextDouble(), pos.getZ() - (double)0.4F, pos.getZ() + (double)0.4F) + 0.5F, 0, 0, 0.0D, 0.0D, 0.0D);
                        }
                    }
                }
            }
        }
    }

    private static void tickOccupants(Level level, BlockPos pos, BlockState state, List<ButterflyData> list) {
        boolean changed = false;

        Iterator<ButterflyData> iterator = list.iterator();
        while (iterator.hasNext()) {
            ButterflyData data = iterator.next();
            if (data.tick()) {
                ReleaseStatus releaseStatus;
                if (data.hasNectar()) {
                    releaseStatus = ReleaseStatus.NECTAR_DELIVERED;
                } else if (data.isSleeping()) {
                    releaseStatus = ReleaseStatus.SLEEPING;
                } else if (data.isBreeding() && containsBothPartners(data, list)) {
                    releaseStatus = ReleaseStatus.BREEDING;
                } else {
                    releaseStatus = ReleaseStatus.RELEASED;
                }

                if (releaseOccupant(level, pos, state, data.toOccupant(), null, releaseStatus)) {
                    changed = true;
                    iterator.remove();
                }
            }
        }

        if (changed) {
            level.blockEntityChanged(pos);
        }
    }

    private static boolean containsBothPartners(ButterflyData data, List<ButterflyData> stored) {
        CompoundTag tag = data.occupant.entityData.copy();
        if (!data.isBreeding() && !tag.hasUUID("PartnerId")) {
            return false;
        }

        for (ButterflyData other : stored) {
            UUID otherId = other.occupant.entityData.copy().getUUID("UUID");
            if (tag.getUUID("PartnerId").equals(otherId)) {
                return true;
            }
        }
        return false;
    }

    private static boolean releaseOccupant(Level level, BlockPos pos, BlockState state, Occupant occupant, List<Entity> list, ReleaseStatus status) {
        Direction direction = state.getValue(ButterflyNestBlock.FACING);
        BlockPos relativePos = pos.relative(direction);

        if ((level.isNight() || level.isRainingAt(relativePos.above())) && status != ReleaseStatus.EMERGENCY) {
            return false;
        } else {
            boolean flag = !level.getBlockState(relativePos).getCollisionShape(level, relativePos).isEmpty();
            if (flag && status != ReleaseStatus.EMERGENCY) {
                return false;
            } else {
                Entity entity = occupant.createEntity(level, pos);
                if (entity != null) {
                    if (entity instanceof Butterfly butterfly) {
                        double offset = flag ? 0.0D : 0.55D + (double)(entity.getBbWidth() / 2.0F);
                        double dx = pos.getX() + 0.5D + offset * (double)direction.getStepX();
                        double dy = pos.getY() + 0.5D - (double)(entity.getBbHeight() / 2.0F);
                        double dz = pos.getZ() + 0.5D + offset * (double)direction.getStepZ();

                        if (status == ReleaseStatus.NECTAR_DELIVERED) {
                            if (state.is(MysticBlocks.BUTTERFLY_NEST.get()) && state.hasProperty(ButterflyNestBlock.NECTAR_LEVEL)) {
                                int i = getNectarLevel(state);
                                if (i < 12) {
                                    int j = butterfly.getNectarPoints();
                                    while (i + j > 12) {
                                        j--;
                                    }
                                    level.setBlockAndUpdate(pos, state.setValue(ButterflyNestBlock.NECTAR_LEVEL, i + j));
                                }
                            }

                            butterfly.dropOffNectar();
                        } else if (status == ReleaseStatus.BREEDING) {
                            Caterpillar caterpillar = MysticEntities.CATERPILLAR.get().create(level);

                            if (caterpillar != null) {
                                caterpillar.butterflyType = butterfly.getVariant();
                                caterpillar.setPersistenceRequired();
                                caterpillar.moveTo(dx, pos.getY(), dz, butterfly.getYRot(), butterfly.getXRot());
                                level.addFreshEntity(caterpillar);

                                butterfly.finalizeSpawnChildFromBreeding((ServerLevel)level, butterfly, butterfly);
                            }
                        }

                        if (list != null) {
                            list.add(butterfly);
                        }

                        butterfly.setSleeping(false);
                        butterfly.setBreeding(false);
                        butterfly.resetPartner();
                        butterfly.resetTicksSincePollinated();
                        entity.moveTo(dx, dy, dz, entity.getYRot(), entity.getXRot());
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

    static class ButterflyData {
        private final Occupant occupant;
        private int ticksInNest;

        ButterflyData(CompoundTag entityData, int ticksInNest, int minTicks) {
            this(new Occupant(entityData, ticksInNest, minTicks));
        }

        ButterflyData(Occupant occupant) {
            this.occupant = occupant;
            this.ticksInNest = occupant.ticksInNest();
        }

        public boolean tick() {
            return this.ticksInNest++ > this.occupant.minTicksInNest;
        }

        public Occupant toOccupant() {
            return new Occupant(this.occupant.entityData, this.ticksInNest, this.occupant.minTicksInNest);
        }

        public boolean hasNectar() {
            return this.occupant.entityData.copy().getBoolean("HasNectar");
        }

        public boolean isSleeping() {
            return this.occupant.entityData.copy().getBoolean("Sleeping");
        }

        public boolean isBreeding() {
            return this.occupant.entityData.copy().getBoolean("Breeding");
        }
    }

    public enum ReleaseStatus {
        NECTAR_DELIVERED,
        SLEEPING,
        BREEDING,
        RELEASED,
        EMERGENCY
    }

    public record Occupant(CompoundTag entityData, int ticksInNest, int minTicksInNest) {

        public static Occupant of(Entity entity) {
            CompoundTag tag = new CompoundTag();
            entity.save(tag);
            ButterflyNestBlockEntity.IGNORED_TAGS.forEach(tag::remove);
            boolean hasNectar = tag.getBoolean("HasNectar");
            boolean breeding = tag.getBoolean("Breeding");
            return new Occupant(tag, 0, breeding ? 200 : (hasNectar ? 2400 : 600));
        }

        public static Occupant create(int ticksInNest, RandomSource random) {
            CompoundTag tag = new CompoundTag();
            tag.putString("id", BuiltInRegistries.ENTITY_TYPE.getKey(MysticEntities.BUTTERFLY.get()).toString());
            tag.putString("Type", Butterfly.Type.getRandom(random).getSerializedName());
            return new Occupant(tag, ticksInNest, 600);
        }

        public Entity createEntity(Level level, BlockPos pos) {
            CompoundTag tag = this.entityData.copy();
            ButterflyNestBlockEntity.IGNORED_TAGS.forEach(tag::remove);
            Entity entity = EntityType.loadEntityRecursive(tag, level, e -> e);
            if (entity != null) {
                entity.setNoGravity(true);
                if (entity instanceof Butterfly butterfly) {
                    butterfly.setNestPos(pos);
                    setButterflyReleaseData(this.ticksInNest, butterfly);
                }
                return entity;
            } else {
                return null;
            }
        }

        private static void setButterflyReleaseData(int ticksInNest, Butterfly butterfly) {
            int age = butterfly.getAge();
            if (age < 0) {
                butterfly.setAge(Math.min(0, age + ticksInNest));
            } else if (age > 0) {
                butterfly.setAge(Math.max(0, age - ticksInNest));
            }
            butterfly.setInLoveTime(Math.max(0, butterfly.getInLoveTime() - ticksInNest));
        }
    }

}