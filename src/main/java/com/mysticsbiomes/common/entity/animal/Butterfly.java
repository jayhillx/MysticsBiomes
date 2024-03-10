package com.mysticsbiomes.common.entity.animal;

import com.google.common.collect.Maps;
import com.mysticsbiomes.common.block.entity.ButterflyNestBlockEntity;
import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticPoiTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.Mth;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.AirAndWaterRandomPos;
import net.minecraft.world.entity.ai.util.AirRandomPos;
import net.minecraft.world.entity.ai.util.HoverRandomPos;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Butterflies are friendly ambient anthropoids, useful for growing flowers.
 */
public class Butterfly extends Animal implements FlyingAnimal {
    private static final EntityDataAccessor<Integer> DATA_TYPE_ID = SynchedEntityData.defineId(Butterfly.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(Butterfly.class, EntityDataSerializers.BYTE);
    private boolean sleeping;
    private boolean isInNest;
    private int ticksSinceLastSlept;
    private int stayOutOfNestCountdown;
    private int ticksBeforeLocatingNewNest;
    private int ticksSincePollinated;
    private int nectarPoints;
    @Nullable
    private BlockPos nestPos;
    @Nullable
    private Block givenFlower;
    PollinateGoal pollinateGoal;
    SpreadFlowersGoal spreadFlowersGoal;
    public AnimationState flyingAnimationState = new AnimationState();

    public Butterfly(EntityType<? extends Butterfly> type, Level level) {
        super(type, level);
        this.moveControl = new FlyingMoveControl(this, 20, true);
        this.lookControl = new ButterflyLookControl();
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_TYPE_ID, 0);
        this.entityData.define(DATA_FLAGS_ID, (byte) 0);
    }

    protected void registerGoals() {
        this.spreadFlowersGoal = new SpreadFlowersGoal();
        this.goalSelector.addGoal(0, this.spreadFlowersGoal);
        this.goalSelector.addGoal(1, new TemptGoal(this, 1.25D, Ingredient.of(ItemTags.FLOWERS), false));
        this.pollinateGoal = new PollinateGoal();
        this.goalSelector.addGoal(2, this.pollinateGoal);
        this.goalSelector.addGoal(3, new EnterNestGoal());
        this.goalSelector.addGoal(4, new GoToNestGoal());
        this.goalSelector.addGoal(5, new LocateNestGoal());
        this.goalSelector.addGoal(6, new WanderGoal());
        this.goalSelector.addGoal(7, new FloatGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.FLYING_SPEED, 0.6F).add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.FOLLOW_RANGE, 28.0D);
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putString("Type", this.getVariant().getSerializedName());
        tag.putInt("TypeId", this.getVariant().getId());

        tag.putBoolean("HasVisibleNectar", this.hasVisibleNectar());
        tag.putBoolean("IsSleeping", this.isSleeping());
        tag.putBoolean("IsInNest", this.isInNest());
        tag.putInt("NectarPoints", this.nectarPoints);
        tag.putInt("TicksSincePollinated", this.ticksSincePollinated);
        tag.putInt("TicksSinceLastSlept", this.ticksSinceLastSlept);
        tag.putInt("CannotEnterNestTicks", this.stayOutOfNestCountdown);

        if (this.nestPos != null) {
            tag.put("NestPos", NbtUtils.writeBlockPos(this.nestPos));
        }
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setVariant(Type.byName(tag.getString("Type")));
        this.setVariant(Type.byId(tag.getInt("TypeId")));

        this.setHasVisibleNectar(tag.getBoolean("HasVisibleNectar"));
        this.sleeping = tag.getBoolean("IsSleeping");
        this.isInNest = tag.getBoolean("IsInNest");
        this.nectarPoints = tag.getInt("NectarPoints");
        this.ticksSincePollinated = tag.getInt("TicksSincePollinated");
        this.ticksSinceLastSlept = tag.getInt("TicksSinceLastSlept");
        this.stayOutOfNestCountdown = tag.getInt("CannotEnterNestTicks");

        this.nestPos = null;
        if (tag.contains("NestPos")) {
            this.nestPos = NbtUtils.readBlockPos(tag.getCompound("NestPos"));
        }
    }

    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
        return null;
    }

    public MobType getMobType() {
        return MobType.ARTHROPOD;
    }

    public Type getVariant() {
        return Type.byId(this.entityData.get(DATA_TYPE_ID));
    }

    public void setVariant(Type type) {
        this.entityData.set(DATA_TYPE_ID, type.getId());
    }

    private boolean getFlag() {
        return (this.entityData.get(DATA_FLAGS_ID) & 8) != 0;
    }

    private void setFlag(boolean value) {
        if (value) {
            this.entityData.set(DATA_FLAGS_ID, (byte)(this.entityData.get(DATA_FLAGS_ID) | 8));
        } else {
            this.entityData.set(DATA_FLAGS_ID, (byte)(this.entityData.get(DATA_FLAGS_ID) & ~8));
        }
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor accessor, DifficultyInstance instance, MobSpawnType type, @Nullable SpawnGroupData data, @Nullable CompoundTag tag) {
        data = super.finalizeSpawn(accessor, instance, type, data, tag);
        this.setVariant(Type.byId(random.nextInt(3)));
        return data;
    }

    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.flyingAnimationState.animateWhen(this.isFlying(), this.tickCount);
        }

        if (this.level() instanceof ServerLevel serverLevel) {
            if (this.random.nextFloat() < 0.05F) {
                if (this.hasNectar()) {
                    serverLevel.sendParticles(ParticleTypes.FALLING_NECTAR, Mth.lerp(this.level().random.nextDouble(), this.getX() - (double)0.3F, this.getX() + (double)0.3F), this.getY(0.5D), Mth.lerp(this.level().random.nextDouble(), this.getZ() - (double)0.3F, this.getZ() + (double)0.3F), 0, 0, 0.0D, 0.0D, 0.0D);
                }

                if (this.spreadFlowersGoal != null && this.spreadFlowersGoal.isPlantingFlower()) {
                    for (int i = 0; i < 5; ++i) {
                        double d0 = this.random.nextGaussian() * 0.02D;
                        double d1 = this.random.nextGaussian() * 0.02D;
                        double d2 = this.random.nextGaussian() * 0.02D;
                        serverLevel.sendParticles(ParticleTypes.HAPPY_VILLAGER, this.getRandomX(1.0D), this.getRandomY() - 0.5D, this.getRandomZ(1.0D), 0, (float)this.level().getRandom().nextInt(4) / 24.0F, d0, d1, d2);
                    }
                }
            }
        }
    }

    public void aiStep() {
        super.aiStep();
        if (!this.level().isClientSide) {
            if (this.stayOutOfNestCountdown > 0) {
                --this.stayOutOfNestCountdown;
            }

            if (this.ticksBeforeLocatingNewNest > 0) {
                --this.ticksBeforeLocatingNewNest;
            }

            if (this.tickCount % 20 == 0 && !this.isNestValid()) {
                this.nestPos = null;
            }
        }
    }

    protected void customServerAiStep() {
        super.customServerAiStep();
        if (!this.isSleeping()) {
            ++this.ticksSinceLastSlept;
        }

        if (this.hasNest()) {
            ++this.ticksSincePollinated;
        }
    }

    protected void angryParticle() {
        double d = Butterfly.this.random.nextGaussian() * 0.02D;
        ((ServerLevel)Butterfly.this.level()).sendParticles(ParticleTypes.ANGRY_VILLAGER, Butterfly.this.getRandomX(1.0D), Butterfly.this.getRandomY() - 0.25D, Butterfly.this.getRandomZ(1.0D), 0, (float)Butterfly.this.level().getRandom().nextInt(4) / 24.0F, d, d, d);
    }

    protected PathNavigation createNavigation(Level level) {
        FlyingPathNavigation navigation = new FlyingPathNavigation(this, level) {
            public boolean isStableDestination(BlockPos p_27947_) {
                return !this.level.getBlockState(p_27947_.below()).isAir();
            }

            public void tick() {
                if (!Butterfly.this.isBusy()) {
                    super.tick();
                }
            }
        };
        navigation.setCanOpenDoors(false);
        navigation.setCanFloat(false);
        navigation.setCanPassDoors(true);
        return navigation;
    }

    protected void checkFallDamage(double distance, boolean b, BlockState state, BlockPos pos) {
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
    }

    protected float getStandingEyeHeight(Pose pose, EntityDimensions dimensions) {
        return dimensions.height * 0.5F;
    }

    public float getWalkTargetValue(BlockPos pos, LevelReader reader) {
        return reader.getBlockState(pos).isAir() ? 5.0F : 0.0F;
    }

    public boolean isFlying() {
        return !this.onGround();
    }

    public boolean hasNest() {
        return this.nestPos != null;
    }

    private boolean isInNest() {
        return this.isInNest;
    }

    public void setInNest(boolean isInNest) {
        this.isInNest = isInNest;
    }

    private boolean isNestValid() {
        if (this.nestPos == null) {
            return false;
        } else if (this.isTooFarAway(this.nestPos)) {
            return false;
        } else {
            BlockEntity blockEntity = this.level().getBlockEntity(this.nestPos);
            return blockEntity instanceof ButterflyNestBlockEntity;
        }
    }

    private boolean isNestNearFire() {
        if (this.nestPos == null) {
            return false;
        } else {
            BlockEntity blockEntity = this.level().getBlockEntity(this.nestPos);
            return blockEntity instanceof ButterflyNestBlockEntity && ((ButterflyNestBlockEntity)blockEntity).isFireNearby();
        }
    }

    private boolean doesNestHaveSpace(BlockPos pos) {
        BlockEntity blockEntity = this.level().getBlockEntity(pos);

        if (blockEntity instanceof ButterflyNestBlockEntity entity) {
            return !entity.isFull();
        } else {
            return false;
        }
    }

    private boolean canEnterNest() {
        return this.stayOutOfNestCountdown <= 0;
    }

    private boolean wantsToEnterNest() {
        if (this.isBusy()) {
            return false;
        } else if (this.canEnterNest()) {
            boolean flag = this.level().isRaining() || this.level().isNight() || this.isTired() || this.hasNectar();
            return flag && !this.isNestNearFire();
        } else {
            return false;
        }
    }

    public void setStayOutOfNestCountdown(int ticks) {
        this.stayOutOfNestCountdown = ticks;
    }

    public boolean isSleeping() {
        return this.sleeping;
    }

    public void setSleeping(boolean sleeping) {
        this.sleeping = sleeping;
    }

    public boolean isTired() {
        return this.ticksSinceLastSlept > 18000;
    }

    public void setTicksSinceLastSlept(int ticks) {
        this.ticksSinceLastSlept = ticks;
    }

    private boolean isBusy() {
        return this.pollinateGoal.isPollinating() || this.spreadFlowersGoal.isPlantingFlower();
    }

    public boolean wasGivenFlower() {
        return this.givenFlower != null;
    }

    public boolean hasNectar() {
        return this.nectarPoints > 0;
    }

    public int getNectarPoints() {
        return this.nectarPoints;
    }

    public boolean hasVisibleNectar() {
        return this.getFlag();
    }

    public void setHasVisibleNectar(boolean hasNectar) {
        this.setFlag(hasNectar);
    }

    public void dropOffNectar() {
        this.nectarPoints = 0;
        this.setHasVisibleNectar(false);
        this.resetTicksSincePollinated();
    }

    public void resetTicksSincePollinated() {
        this.ticksSincePollinated = 0;
    }

    /** @return determines if the butterfly can pollinate in the first place. */
    public boolean canPollinate() {
        return this.ticksSincePollinated >= 2400;
    }

    /**
     * Determines if a butterfly wants to pollinate a flower on their own.
     */
    private boolean wantsToPollinate() {
        return this.canPollinate() && this.canEnterNest() && !this.hasNectar() && this.random.nextInt(64) == 0;
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (player.getItemInHand(hand).is(ItemTags.SMALL_FLOWERS)) {

            if (!this.level().isClientSide) {
                if (this.canPollinate()) {
                    this.givenFlower = Block.byItem(player.getItemInHand(hand).getItem());

                    for (int i = 0; i < 5; ++i) {
                        ((ServerLevel)this.level()).sendParticles(ParticleTypes.HAPPY_VILLAGER, this.getRandomX(1.0D), this.getRandomY() - 0.5D, this.getRandomZ(1.0D), 0, (float) this.level().getRandom().nextInt(4) / 24.0F, this.random.nextGaussian() * 0.02D, this.random.nextGaussian() * 0.02D, this.random.nextGaussian() * 0.02D);
                    }
                    return InteractionResult.CONSUME;
                } else {
                    this.angryParticle();
                    return InteractionResult.FAIL;
                }
            }
            return InteractionResult.PASS;
        } else {
            return this.hasNest() ? super.mobInteract(player, hand) : InteractionResult.PASS;
        }
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(ItemTags.TALL_FLOWERS);
    }

    private void pathfindRandomlyTowards(BlockPos pos) {
        Vec3 vec3 = Vec3.atBottomCenterOf(pos);
        int i = 0;
        BlockPos pos1 = this.blockPosition();
        int j = (int)vec3.y - pos1.getY();
        if (j > 2) {
            i = 4;
        } else if (j < -2) {
            i = -4;
        }

        int k = 6;
        int l = 8;
        int i1 = pos1.distManhattan(pos);
        if (i1 < 15) {
            k = i1 / 2;
            l = i1 / 2;
        }

        Vec3 vec31 = AirRandomPos.getPosTowards(this, k, l, i, vec3, (float)Math.PI / 10F);
        if (vec31 != null) {
            this.navigation.setMaxVisitedNodesMultiplier(0.5F);
            this.navigation.moveTo(vec31.x, vec31.y, vec31.z, 1.0D);
        }
    }

    private boolean pathfindDirectlyTowards(BlockPos pos, double speedModifier) {
        Butterfly.this.navigation.setMaxVisitedNodesMultiplier(10.0F);
        Butterfly.this.navigation.moveTo(pos.getX(), pos.getY(), pos.getZ(), speedModifier);
        return Butterfly.this.navigation.getPath() != null && Butterfly.this.navigation.getPath().canReach();
    }

    private boolean isCloserThan(BlockPos pos, int distance) {
        return pos.closerThan(this.blockPosition(), distance);
    }

    private boolean isTooFarAway(BlockPos pos) {
        return !this.isCloserThan(pos, 32);
    }

    private boolean hasReachedTarget(BlockPos pos) {
        if (this.isCloserThan(pos, 2)) {
            return true;
        } else {
            Path path = this.navigation.getPath();
            return path != null && path.getTarget().equals(pos) && path.canReach() && path.isDone();
        }
    }

    private void setPollinatingPos(BlockPos pos) {
        Vec3 hoverPos;

        Vec3 vec3 = Vec3.atBottomCenterOf(pos).add(0.0D, 0.6F, 0.0D);
        if (vec3.distanceTo(this.position()) > 1.0D) {
            hoverPos = vec3;
            this.getMoveControl().setWantedPosition(hoverPos.x(), hoverPos.y(), hoverPos.z(), 0.35F);
        } else {
            hoverPos = vec3;

            boolean flag = this.position().distanceTo(hoverPos) <= 0.1D;
            boolean flag1 = true;
            if (flag) {
                boolean flag2 = this.random.nextInt(25) == 0;
                if (flag2) {
                    float offset = (this.random.nextFloat() * 2.0F - 1.0F) * 0.33333334F;

                    hoverPos = new Vec3(vec3.x() + (double) offset, vec3.y(), vec3.z() + (double) offset);
                    this.navigation.stop();
                } else {
                    flag1 = false;
                }

                this.getLookControl().setLookAt(vec3.x(), vec3.y(), vec3.z());
            }

            if (flag1) {
                this.getMoveControl().setWantedPosition(hoverPos.x(), hoverPos.y(), hoverPos.z(), 0.35F);
            }
        }
    }

    /**
     * Sets the butterflies home/nest position by scoping out an available one nearby.
     */
    class LocateNestGoal extends Goal {

        public boolean canUse() {
            return Butterfly.this.ticksBeforeLocatingNewNest == 0 && Butterfly.this.nestPos == null && Butterfly.this.wantsToEnterNest();
        }

        public boolean canContinueToUse() {
            return false;
        }

        public void start() {
            Butterfly.this.ticksBeforeLocatingNewNest = 200;

            List<BlockPos> list = this.findNearbyNestsWithSpace();
            if (!list.isEmpty()) {
                for (BlockPos pos : list) {
                    Butterfly.this.nestPos = pos;
                    return;
                }
                Butterfly.this.nestPos = list.get(0);
            }
        }

        private List<BlockPos> findNearbyNestsWithSpace() {
            BlockPos pos = Butterfly.this.blockPosition();
            PoiManager poiManager = ((ServerLevel)Butterfly.this.level()).getPoiManager();

            Stream<PoiRecord> stream = poiManager.getInRange((holder) -> holder.is(MysticPoiTypes.BUTTERFLY_NEST.getId()), pos, 20, PoiManager.Occupancy.ANY);
            return stream.map(PoiRecord::getPos).filter(Butterfly.this::doesNestHaveSpace).sorted(Comparator.comparingDouble((pos1) -> pos1.distSqr(pos))).collect(Collectors.toList());
        }
    }

    class GoToNestGoal extends Goal {
        @Nullable
        private Path lastPath;

        GoToNestGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse() {
            return Butterfly.this.nestPos != null && Butterfly.this.wantsToEnterNest() && !Butterfly.this.hasReachedTarget(Butterfly.this.nestPos) && Butterfly.this.level().getBlockState(Butterfly.this.nestPos).is(MysticBlocks.BUTTERFLY_NEST.get());
        }

        public boolean canContinueToUse() {
            return this.canUse();
        }

        public void stop() {
            Butterfly.this.navigation.stop();
            Butterfly.this.navigation.resetMaxVisitedNodesMultiplier();
        }

        public void tick() {
            if (Butterfly.this.nestPos != null) {

                if (!Butterfly.this.navigation.isInProgress()) {
                    if (!Butterfly.this.isCloserThan(Butterfly.this.nestPos, 16)) {
                        Butterfly.this.pathfindRandomlyTowards(Butterfly.this.nestPos);
                    } else {
                        boolean flag = Butterfly.this.pathfindDirectlyTowards(Butterfly.this.nestPos, 1.0D);

                        if (flag) {
                            if (this.lastPath != null && Butterfly.this.navigation.getPath() != null && !Butterfly.this.navigation.getPath().sameAs(this.lastPath)) {
                                this.lastPath = Butterfly.this.navigation.getPath();
                            }
                        }
                    }
                }
            }
        }
    }

    class EnterNestGoal extends Goal {

        public boolean canUse() {
            if (Butterfly.this.nestPos != null && Butterfly.this.wantsToEnterNest() && Butterfly.this.nestPos.closerToCenterThan(Butterfly.this.position(), 2.0D)) {
                BlockEntity blockEntity = Butterfly.this.level().getBlockEntity(Butterfly.this.nestPos);

                if (blockEntity instanceof ButterflyNestBlockEntity entity) {
                    return !entity.isFull();
                }
            }
            return false;
        }

        public boolean canContinueToUse() {
            return false;
        }

        public void start() {
            if (Butterfly.this.level().isNight() || Butterfly.this.isTired()) {
                Butterfly.this.setSleeping(true);
            }

            Butterfly.this.setInNest(true);

            if (Butterfly.this.nestPos != null) {
                BlockEntity blockEntity = Butterfly.this.level().getBlockEntity(Butterfly.this.nestPos);

                if (blockEntity instanceof ButterflyNestBlockEntity entity) {
                    entity.addOccupant(Butterfly.this, Butterfly.this.hasNectar());
                }
            }
        }
    }

    /**
     * Either pollinates a random flower or locates and pollinates the same flower a player gave them.
     */
    class PollinateGoal extends Goal {
        private int pollinatingTicks;
        private boolean pollinating;
        private boolean willSpreadFlowersAfter;
        @Nullable
        private BlockPos flowerPos;
        private final Predicate<BlockState> VALID_POLLINATION_BLOCKS = (state) -> {
            if (state.is(BlockTags.FLOWERS)) {
                if (state.is(Blocks.SUNFLOWER)) {
                    return state.getValue(DoublePlantBlock.HALF) == DoubleBlockHalf.UPPER;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        };

        PollinateGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse() {
            if (!Butterfly.this.hasNest()) {
                return false;
            } else if (Butterfly.this.isTired()) {
                return false;
            } else if (Butterfly.this.level().isRaining()) {
                return false;
            } else {
                if (Butterfly.this.canPollinate()) {
                    return Butterfly.this.wasGivenFlower() || Butterfly.this.wantsToPollinate();
                } else {
                    return false;
                }
            }
        }

        public boolean canContinueToUse() {
            if (Butterfly.this.level().isRaining()) {
                return false;
            } else {
                return this.flowerPos != null && this.pollinatingTicks < 600;
            }
        }

        public void start() {
            this.pollinatingTicks = 0;

            Optional<BlockPos> optional = this.findNearbyFlower();
            if (optional.isPresent()) {
                this.flowerPos = optional.get();
            }
        }
        
        public void stop() {
            this.pollinating = false;

            if (this.pollinatingTicks >= 600) {
                Butterfly.this.nectarPoints += 3;
                Butterfly.this.setHasVisibleNectar(true);
            } else {
                Butterfly.this.angryParticle();
            }

            // Process stops like normal when the butterfly was not given a flower, but continues if they were.
            if (!Butterfly.this.wasGivenFlower()) {
                this.flowerPos = null;
                Butterfly.this.navigation.stop();
                Butterfly.this.ticksSincePollinated = 0;
            } else {
                this.willSpreadFlowersAfter = true;
            }
        }

        public void tick() {
            Optional<BlockPos> optional = this.findNearbyFlower();
            if (optional.isEmpty()) {
                this.flowerPos = null;
                Butterfly.this.ticksSincePollinated = 2200;
            }

            if (this.flowerPos != null) {
                if (!Butterfly.this.hasReachedTarget(this.flowerPos)) {
                    Butterfly.this.pathfindDirectlyTowards(this.flowerPos, 1.0D);
                } else {
                    // pollinating set to true only when they are at the flowers position.
                    this.pollinating = true;

                    ++this.pollinatingTicks;
                    Butterfly.this.setPollinatingPos(this.flowerPos);
                }
            }
        }

        private Optional<BlockPos> findNearbyFlower() {
            return Butterfly.this.givenFlower != null ? this.findNearestBlock((block) -> block.is(Butterfly.this.givenFlower), 16.0D) : this.findNearestBlock(this.VALID_POLLINATION_BLOCKS, 8.0D);
        }

        private Optional<BlockPos> findNearestBlock(Predicate<BlockState> predicate, double distance) {
            BlockPos pos = Butterfly.this.blockPosition();
            BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

            for (int i = 0; (double)i <= distance; i = i > 0 ? -i : 1 - i) {
                for (int j = 0; (double)j < distance; ++j) {
                    for (int k = 0; k <= j; k = k > 0 ? -k : 1 - k) {
                        for (int l = k < j && k > -j ? j : 0; l <= j; l = l > 0 ? -l : 1 - l) {
                            mutablePos.setWithOffset(pos, k, i - 1, l);

                            if (pos.closerThan(mutablePos, distance) && predicate.test(Butterfly.this.level().getBlockState(mutablePos))) {
                                return Optional.of(mutablePos);
                            }
                        }
                    }
                }
            }
            return Optional.empty();
        }

        public boolean isPollinating() {
            return this.pollinating;
        }
    }

    /**
     * Main feature; plant 3 flowers for every 1 flower they collect nectar from.
     */
    class SpreadFlowersGoal extends Goal {
        private int successfulTicks;
        private boolean plantingFlower;
        @Nullable
        private BlockPos emptyPos;

        SpreadFlowersGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse() {
            return Butterfly.this.hasNectar() && Butterfly.this.pollinateGoal.willSpreadFlowersAfter;
        }

        public boolean canContinueToUse() {
            return Butterfly.this.hasNectar() && Butterfly.this.wasGivenFlower() && this.successfulTicks < 1200;
        }

        public void start() {
            this.successfulTicks = 0;
            this.emptyPos = this.findRandomEmptyPos();
        }

        /**
         * Continue this goal until it uses up all its accumulated nectar, is unable to find an empty spot, or was harmed.
         */
        public void stop() {
            this.plantingFlower = false;

            if (Butterfly.this.hasNectar()) {
                if (!Butterfly.this.level().isClientSide) {
                    if (this.emptyPos != null) {
                        if (Butterfly.this.givenFlower != null) {
                            BlockState flowerState = Butterfly.this.givenFlower.defaultBlockState();

                            if (Butterfly.this.level().isEmptyBlock(this.emptyPos) && flowerState.canSurvive(Butterfly.this.level(), this.emptyPos)) {
                                Butterfly.this.level().setBlockAndUpdate(this.emptyPos, flowerState);
                                Butterfly.this.level().gameEvent(GameEvent.BLOCK_PLACE, this.emptyPos, GameEvent.Context.of(Butterfly.this, flowerState));
                                Butterfly.this.level().playSound(null, this.emptyPos, SoundEvents.GRASS_PLACE, SoundSource.BLOCKS, 0.7F, 0.9F + Butterfly.this.random.nextFloat() * 0.2F);
                            }

                            Butterfly.this.nectarPoints -= 1;
                            this.emptyPos = null;
                        }
                    } else {
                        Butterfly.this.angryParticle();
                    }
                }
            }

            if (Butterfly.this.nectarPoints == 0) {
                Butterfly.this.setHasVisibleNectar(false);
            }

            // Stops process when nectar is gone, or when @fail() is executed.
            if (Butterfly.this.nectarPoints == 0 || Butterfly.this.givenFlower == null) {
                Butterfly.this.givenFlower = null;
                Butterfly.this.pollinateGoal.flowerPos = null;
                Butterfly.this.pollinateGoal.willSpreadFlowersAfter = false;

                Butterfly.this.ticksSincePollinated = 0;
                Butterfly.this.navigation.stop();
            }
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            int ticks = 0;
            if (this.emptyPos != null) {
                if (!Butterfly.this.hasReachedTarget(this.emptyPos)) {
                    Butterfly.this.pathfindDirectlyTowards(this.emptyPos, 0.4D);
                } else {
                    this.plantingFlower = true;

                    ++this.successfulTicks;
                    Butterfly.this.setPollinatingPos(this.emptyPos);
                }
            } else {
                this.emptyPos = this.findRandomEmptyPos();

                ++ticks;
                if (ticks > this.adjustedTickDelay(600)) {
                    this.fail();
                }
            }
        }

        /** @return a random empty space near the original flower pos a butterfly can plant a flower at. */
        private BlockPos findRandomEmptyPos() {
            Map<Integer, BlockPos> map = Maps.newHashMap();

            BlockPos flowerPos = Butterfly.this.pollinateGoal.flowerPos;
            BlockPos currentPos = flowerPos != null ? flowerPos : Butterfly.this.blockPosition();

            for (int i = 0; i <= 14; i++) {
                BlockPos pos;
                int x = Mth.floor(currentPos.getX() + (random.nextBoolean() ? random.nextInt(3) : -random.nextInt(3)));
                int y = Mth.floor(currentPos.getY() + (random.nextBoolean() ? random.nextInt(3) : -random.nextInt(3)));
                int z = Mth.floor(currentPos.getZ() + (random.nextBoolean() ? random.nextInt(3) : -random.nextInt(3)));
                pos = new BlockPos(x, y, z);

                if (Butterfly.this.level().getBlockState(pos).isAir() && Butterfly.this.level().getBlockState(pos.below()).is(Blocks.GRASS_BLOCK)) {
                    map.put(i, pos);
                }
            }
            return map.get(0);
        }

        /**
         * Resets the given flower when they cannot find an empty pos within 600 ticks.
         */
        private void fail() {
            Butterfly.this.givenFlower = null;
        }

        public boolean isPlantingFlower() {
            return this.plantingFlower;
        }
    }

    class WanderGoal extends Goal {

        WanderGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse() {
            return Butterfly.this.navigation.isDone();
        }

        public boolean canContinueToUse() {
            return Butterfly.this.navigation.isInProgress();
        }

        public void start() {
            Vec3 vec3 = this.findPos();
            if (vec3 != null) {
                vec3 = new Vec3(vec3.x, this.findFurthestBlockBelow(BlockPos.containing(vec3)) + 2, vec3.z);

                Butterfly.this.navigation.moveTo(Butterfly.this.navigation.createPath(BlockPos.containing(vec3), 1), 1.0D);
            }
        }

        private int findFurthestBlockBelow(BlockPos pos) {
            BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos(pos.getX(), pos.getY(), pos.getZ());

            while (mutablePos.getY() > 0) {
                mutablePos.move(0, -1, 0);

                if (!Butterfly.this.level().isEmptyBlock(mutablePos) && (!Butterfly.this.level().getBlockState(mutablePos).isAir() || Butterfly.this.level().getBlockState(mutablePos).canBeReplaced())) {
                    return mutablePos.getY();
                }
            }
            return pos.getY();
        }

        @Nullable
        private Vec3 findPos() {
            Vec3 vec3;
            if (Butterfly.this.isNestValid() && Butterfly.this.nestPos != null && !Butterfly.this.isCloserThan(Butterfly.this.nestPos, 22)) {
                Vec3 vec31 = Vec3.atCenterOf(Butterfly.this.nestPos);
                vec3 = vec31.subtract(Butterfly.this.position()).normalize();
            } else {
                vec3 = Butterfly.this.getViewVector(0.0F);
            }

            Vec3 vec32 = HoverRandomPos.getPos(Butterfly.this, 8, 7, vec3.x, vec3.z, ((float)Math.PI / 2F), 3, 1);
            return vec32 != null ? vec32 : AirAndWaterRandomPos.getPos(Butterfly.this, 8, 4, -2, vec3.x, vec3.z, ((float)Math.PI / 2F));
        }
    }

    class ButterflyLookControl extends LookControl {

        ButterflyLookControl() {
            super(Butterfly.this);
        }

        protected boolean resetXRotOnTick() {
            return !Butterfly.this.pollinateGoal.isPollinating() || !Butterfly.this.spreadFlowersGoal.isPlantingFlower();
        }
    }

    public enum Type implements StringRepresentable {
        TANGERINE(0, "tangerine"),
        JELLY(1, "jelly"),
        JULY(2, "july"),
        CANDY(3, "candy"),
        VALENTINE(4, "valentine"),
        MYSTIC(5, "mystic");

        private final int id;
        private final String name;

        Type(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return this.id;
        }

        public String getSerializedName() {
            return this.name;
        }

        public static Type byId(int id) {
            return ByIdMap.continuous(Type::getId, values(), ByIdMap.OutOfBoundsStrategy.ZERO).apply(id);
        }

        public static Type byName(String name) {
            return StringRepresentable.fromEnum(Type::values).byName(name, TANGERINE);
        }
    }

}