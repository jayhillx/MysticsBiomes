package com.mysticsbiomes.common.entity.animal;

import com.google.common.collect.Maps;
import com.mysticsbiomes.common.block.entity.ButterflyNestBlockEntity;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.AboveGroundTargeting;
import net.minecraft.entity.ai.NoPenaltySolidTargeting;
import net.minecraft.entity.ai.NoWaterTargeting;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.control.LookControl;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.PointOfInterestTypeTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.poi.PointOfInterest;
import net.minecraft.world.poi.PointOfInterestStorage;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Butterflies are friendly ambient anthropoids, useful for growing flowers.
 */
public class Butterfly extends AnimalEntity implements Flutterer {
    private static final TrackedData<Integer> DATA_TYPE_ID = DataTracker.registerData(Butterfly.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Byte> DATA_FLAGS_ID = DataTracker.registerData(Butterfly.class, TrackedDataHandlerRegistry.BYTE);
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

    public Butterfly(EntityType<? extends Butterfly> type, World level) {
        super(type, level);
        this.moveControl = new FlightMoveControl(this, 20, true);
        this.lookControl = new Butterfly.ButterflyLookControl();
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(DATA_TYPE_ID, 0);
        this.dataTracker.startTracking(DATA_FLAGS_ID, (byte) 0);
    }

    @Override
    protected void initGoals() {
        this.spreadFlowersGoal = new SpreadFlowersGoal();
        this.goalSelector.add(0, this.spreadFlowersGoal);
        this.goalSelector.add(1, new TemptGoal(this, 1.25D, Ingredient.fromTag(ItemTags.FLOWERS), false));
        this.pollinateGoal = new PollinateGoal();
        this.goalSelector.add(2, this.pollinateGoal);
        this.goalSelector.add(3, new EnterNestGoal());
        this.goalSelector.add(4, new GoToNestGoal());
        this.goalSelector.add(5, new LocateNestGoal());
        this.goalSelector.add(6, new WanderGoal());
        this.goalSelector.add(7, new SwimGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0D).add(EntityAttributes.GENERIC_FLYING_SPEED, 0.6F).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3F).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 6.0D);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound tag) {
        super.writeCustomDataToNbt(tag);
        tag.putString("Type", this.getVariant().asString());
        tag.putInt("TypeId", this.getVariant().getId());

        tag.putBoolean("HasVisibleNectar", this.hasVisibleNectar());
        tag.putBoolean("IsSleeping", this.isSleeping());
        tag.putBoolean("IsInNest", this.isInNest());
        tag.putInt("NectarPoints", this.nectarPoints);
        tag.putInt("TicksSincePollinated", this.ticksSincePollinated);
        tag.putInt("TicksSinceLastSlept", this.ticksSinceLastSlept);
        tag.putInt("CannotEnterNestTicks", this.stayOutOfNestCountdown);

        if (this.nestPos != null) {
            tag.put("NestPos", NbtHelper.fromBlockPos(this.nestPos));
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound tag) {
        super.readCustomDataFromNbt(tag);
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
            this.nestPos = NbtHelper.toBlockPos(tag.getCompound("NestPos"));
        }
    }

    @Override
    public Butterfly createChild(ServerWorld level, PassiveEntity mob) {
        return null;
    }

    @Override
    public EntityGroup getGroup() {
        return EntityGroup.ARTHROPOD;
    }

    public Type getVariant() {
        return Type.byId(this.dataTracker.get(DATA_TYPE_ID));
    }

    public void setVariant(Type type) {
        this.dataTracker.set(DATA_TYPE_ID, type.getId());
    }

    private boolean getFlag() {
        return (this.dataTracker.get(DATA_FLAGS_ID) & 8) != 0;
    }

    private void setFlag(boolean value) {
        if (value) {
            this.dataTracker.set(DATA_FLAGS_ID, (byte)(this.dataTracker.get(DATA_FLAGS_ID) | 8));
        } else {
            this.dataTracker.set(DATA_FLAGS_ID, (byte)(this.dataTracker.get(DATA_FLAGS_ID) & ~8));
        }
    }

    @Override
    public EntityData initialize(ServerWorldAccess accessor, LocalDifficulty instance, SpawnReason type, EntityData data, NbtCompound tag) {
        data = super.initialize(accessor, instance, type, data, tag);
        this.setVariant(Type.byId(random.nextInt(6)));
        return data;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            this.flyingAnimationState.setRunning(this.isInAir(), this.age);
        }

        if (this.getWorld() instanceof ServerWorld world) {
            if (this.random.nextFloat() < 0.05F) {
                if (this.hasNectar()) {
                    world.spawnParticles(ParticleTypes.FALLING_NECTAR, MathHelper.lerp(this.getWorld().random.nextDouble(), this.getX() - (double)0.3F, this.getX() + (double)0.3F), this.getBodyY(0.5D), MathHelper.lerp(this.getWorld().random.nextDouble(), this.getZ() - (double)0.3F, this.getZ() + (double)0.3F), 0, 0, 0.0D, 0.0D, 0.0D);
                }

                if (this.spreadFlowersGoal != null && this.spreadFlowersGoal.isPlantingFlower()) {
                    for (int i = 0; i < 5; ++i) {
                        double d0 = this.random.nextGaussian() * 0.02D;
                        double d1 = this.random.nextGaussian() * 0.02D;
                        double d2 = this.random.nextGaussian() * 0.02D;
                        world.spawnParticles(ParticleTypes.HAPPY_VILLAGER, this.getParticleX(1.0D), this.getY() - 0.5D, this.getParticleZ(1.0D), 0, (float)this.getWorld().getRandom().nextInt(4) / 24.0F, d0, d1, d2);
                    }
                }
            }
        }
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        if (!this.getWorld().isClient) {
            if (this.stayOutOfNestCountdown > 0) {
                --this.stayOutOfNestCountdown;
            }

            if (this.ticksBeforeLocatingNewNest > 0) {
                --this.ticksBeforeLocatingNewNest;
            }

            if (this.age % 20 == 0 && !this.isNestValid()) {
                this.nestPos = null;
            }
        }
    }

    @Override
    protected void mobTick() {
        super.mobTick();
        if (!this.isSleeping()) {
            ++this.ticksSinceLastSlept;
        }

        if (this.hasNest()) {
            ++this.ticksSincePollinated;
        }
    }

    protected void angryParticle() {
        double d = Butterfly.this.random.nextGaussian() * 0.02D;
        ((ServerWorld)Butterfly.this.getWorld()).spawnParticles(ParticleTypes.ANGRY_VILLAGER, Butterfly.this.getParticleX(1.0D), Butterfly.this.getRandomBodyY() - 0.25D, Butterfly.this.getParticleZ(1.0D), 0, (float)Butterfly.this.getWorld().getRandom().nextInt(4) / 24.0F, d, d, d);
    }

    @Override
    protected EntityNavigation createNavigation(World level) {
        BirdNavigation navigation = new BirdNavigation(this, level) {
            @Override
            public boolean shouldRecalculatePath(BlockPos pos) {
                return !this.world.getBlockState(pos.down()).isAir();
            }

            @Override
            public void tick() {
                if (!Butterfly.this.isBusy()) {
                    super.tick();
                }
            }
        };
        navigation.setCanPathThroughDoors(false);
        navigation.setCanSwim(false);
        navigation.setCanEnterOpenDoors(true);
        return navigation;
    }

    @Override
    protected void fall(double heightDifference, boolean onGround, BlockState state, BlockPos pos) {
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
    }

    @Override
    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return dimensions.height * 0.5F;
    }

    ///public float getWalkTargetValue(BlockPos pos, WorldView reader) {
    ///    return reader.getBlockState(pos).isAir() ? 5.0F : 0.0F;
    ///}

    @Override
    public float getPositionTargetRange() {
        return super.getPositionTargetRange();
    }

    @Override
    public boolean isInAir() {
        return !this.isOnGround();
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
            BlockEntity blockEntity = this.getWorld().getBlockEntity(this.nestPos);
            return blockEntity instanceof ButterflyNestBlockEntity;
        }
    }

    private boolean isNestNearFire() {
        if (this.nestPos == null) {
            return false;
        } else {
            BlockEntity blockEntity = this.getWorld().getBlockEntity(this.nestPos);
            return blockEntity instanceof ButterflyNestBlockEntity && ((ButterflyNestBlockEntity)blockEntity).isFireNearby();
        }
    }

    private boolean doesNestHaveSpace(BlockPos pos) {
        BlockEntity blockEntity = this.getWorld().getBlockEntity(pos);

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
            boolean flag = this.getWorld().isRaining() || this.getWorld().isNight() || this.isTired() || this.hasNectar();
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
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (player.getStackInHand(hand).isIn(ItemTags.SMALL_FLOWERS)) {

            if (!this.getWorld().isClient) {
                if (this.canPollinate()) {
                    this.givenFlower = Block.getBlockFromItem(player.getStackInHand(hand).getItem());

                    for (int i = 0; i < 5; ++i) {
                        ((ServerWorld)this.getWorld()).spawnParticles(ParticleTypes.HAPPY_VILLAGER, this.getParticleX(1.0D), this.getY() - 0.5D, this.getParticleZ(1.0D), 0, (float) this.getWorld().getRandom().nextInt(4) / 24.0F, this.random.nextGaussian() * 0.02D, this.random.nextGaussian() * 0.02D, this.random.nextGaussian() * 0.02D);
                    }
                    return ActionResult.CONSUME;
                } else {
                    this.angryParticle();
                    return ActionResult.FAIL;
                }
            }
            return ActionResult.PASS;
        } else {
            return this.hasNest() ? super.interactMob(player, hand) : ActionResult.PASS;
        }
    }

    private void pathfindRandomlyTowards(BlockPos pos) {
        Vec3d vec3 = Vec3d.ofBottomCenter(pos);
        int i = 0;
        BlockPos pos1 = this.getBlockPos();
        int j = (int)vec3.y - pos1.getY();
        if (j > 2) {
            i = 4;
        } else if (j < -2) {
            i = -4;
        }

        int k = 6;
        int l = 8;
        int i1 = pos1.getManhattanDistance(pos);
        if (i1 < 15) {
            k = i1 / 2;
            l = i1 / 2;
        }

        Vec3d vec31 = NoWaterTargeting.find(this, k, l, i, vec3, (float)Math.PI / 10F);
        if (vec31 != null) {
            this.navigation.setRangeMultiplier(0.5F);
            this.navigation.startMovingTo(vec31.x, vec31.y, vec31.z, 1.0D);
        }
    }

    private boolean pathfindDirectlyTowards(BlockPos pos, double speedModifier) {
        Butterfly.this.navigation.setRangeMultiplier(10.0F);
        Butterfly.this.navigation.startMovingTo(pos.getX(), pos.getY(), pos.getZ(), speedModifier);
        return Butterfly.this.navigation.getCurrentPath() != null && Butterfly.this.navigation.getCurrentPath().reachesTarget();
    }

    private boolean isCloserThan(BlockPos pos, int distance) {
        return pos.isWithinDistance(this.getBlockPos(), distance);
    }

    private boolean isTooFarAway(BlockPos pos) {
        return !this.isCloserThan(pos, 32);
    }

    private boolean hasReachedTarget(BlockPos pos) {
        if (this.isCloserThan(pos, 2)) {
            return true;
        } else {
            Path path = this.navigation.getCurrentPath();
            return path != null && path.getTarget().equals(pos) && path.reachesTarget() && path.isFinished();
        }
    }

    private void setPollinatingPos(BlockPos pos) {
        Vec3d hoverPos;

        Vec3d vec3 = Vec3d.ofBottomCenter(pos).add(0.0D, 0.6F, 0.0D);
        if (vec3.distanceTo(this.getPos()) > 1.0D) {
            hoverPos = vec3;
            this.getMoveControl().moveTo(hoverPos.x, hoverPos.y, hoverPos.z, 0.35F);
        } else {
            hoverPos = vec3;

            boolean flag = this.getPos().distanceTo(hoverPos) <= 0.1D;
            boolean flag1 = true;
            if (flag) {
                boolean flag2 = this.random.nextInt(25) == 0;
                if (flag2) {
                    float offset = (this.random.nextFloat() * 2.0F - 1.0F) * 0.33333334F;

                    hoverPos = new Vec3d(vec3.x + (double) offset, vec3.y, vec3.z + (double) offset);
                    this.navigation.stop();
                } else {
                    flag1 = false;
                }

                this.getLookControl().lookAt(vec3.x, vec3.y, vec3.z);
            }

            if (flag1) {
                this.getMoveControl().moveTo(hoverPos.x, hoverPos.y, hoverPos.z, 0.35F);
            }
        }
    }

    /**
     * Sets the butterflies home/nest position by scoping out an available one nearby.
     */
    class LocateNestGoal extends Goal {

        public boolean canStart() {
            return Butterfly.this.ticksBeforeLocatingNewNest == 0 && Butterfly.this.nestPos == null && Butterfly.this.wantsToEnterNest();
        }

        public boolean shouldContinue() {
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
            BlockPos pos = Butterfly.this.getBlockPos();
            PointOfInterestStorage poiManager = ((ServerWorld)Butterfly.this.getWorld()).getPointOfInterestStorage();

            Stream<PointOfInterest> stream = poiManager.getInCircle(poi -> poi.isIn(PointOfInterestTypeTags.BEE_HOME), pos, 20, PointOfInterestStorage.OccupationStatus.ANY);
            return stream.map(PointOfInterest::getPos).filter(Butterfly.this::doesNestHaveSpace).sorted(Comparator.comparingDouble(blockPos2 -> blockPos2.getSquaredDistance(pos))).collect(Collectors.toList());
        }
    }

    class GoToNestGoal extends Goal {
        @Nullable
        private Path lastPath;

        GoToNestGoal() {
            this.setControls(EnumSet.of(Goal.Control.MOVE));
        }

        public boolean canStart() {
            return Butterfly.this.nestPos != null && Butterfly.this.wantsToEnterNest() && !Butterfly.this.hasReachedTarget(Butterfly.this.nestPos) && Butterfly.this.getWorld().getBlockState(Butterfly.this.nestPos).isOf(MysticBlocks.BUTTERFLY_NEST);
        }

        public boolean shouldContinue() {
            return this.canStart();
        }

        public void stop() {
            Butterfly.this.navigation.stop();
            Butterfly.this.navigation.resetRangeMultiplier();
        }

        public void tick() {
            if (Butterfly.this.nestPos != null) {

                if (!Butterfly.this.navigation.isFollowingPath()) {
                    if (!Butterfly.this.isCloserThan(Butterfly.this.nestPos, 16)) {
                        Butterfly.this.pathfindRandomlyTowards(Butterfly.this.nestPos);
                    } else {
                        boolean flag = Butterfly.this.pathfindDirectlyTowards(Butterfly.this.nestPos, 1.0D);

                        if (flag) {
                            if (this.lastPath != null && Butterfly.this.navigation.getCurrentPath() != null && !Butterfly.this.navigation.getCurrentPath().equalsPath(this.lastPath)) {
                                this.lastPath = Butterfly.this.navigation.getCurrentPath();
                            }
                        }
                    }
                }
            }
        }
    }

    class EnterNestGoal extends Goal {

        public boolean canStart() {
            if (Butterfly.this.nestPos != null && Butterfly.this.wantsToEnterNest() && Butterfly.this.nestPos.isWithinDistance(Butterfly.this.getPos(), 2.0D)) {
                BlockEntity blockEntity = Butterfly.this.getWorld().getBlockEntity(Butterfly.this.nestPos);

                if (blockEntity instanceof ButterflyNestBlockEntity entity) {
                    return !entity.isFull();
                }
            }
            return false;
        }

        public boolean shouldContinue() {
            return false;
        }

        public void start() {
            if (Butterfly.this.getWorld().isNight() || Butterfly.this.isTired()) {
                Butterfly.this.setSleeping(true);
            }

            Butterfly.this.setInNest(true);

            if (Butterfly.this.nestPos != null) {
                BlockEntity blockEntity = Butterfly.this.getWorld().getBlockEntity(Butterfly.this.nestPos);

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
            if (state.isIn(BlockTags.FLOWERS)) {
                if (state.isOf(Blocks.SUNFLOWER)) {
                    return state.get(TallPlantBlock.HALF) == DoubleBlockHalf.UPPER;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        };

        PollinateGoal() {
            this.setControls(EnumSet.of(Goal.Control.MOVE));
        }

        public boolean canStart() {
            if (!Butterfly.this.hasNest()) {
                return false;
            } else if (Butterfly.this.isTired()) {
                return false;
            } else if (Butterfly.this.getWorld().isRaining()) {
                return false;
            } else {
                if (Butterfly.this.canPollinate()) {
                    return Butterfly.this.wasGivenFlower() || Butterfly.this.wantsToPollinate();
                } else {
                    return false;
                }
            }
        }

        public boolean shouldContinue() {
            if (Butterfly.this.getWorld().isRaining()) {
                return false;
            } else {
                return this.flowerPos != null && this.pollinatingTicks < 600;
            }
        }

        public void start() {
            this.pollinatingTicks = 0;

            Optional<BlockPos> optional = this.findNearbyFlower();
            optional.ifPresent(pos -> this.flowerPos = pos);
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
            return Butterfly.this.givenFlower != null ? this.findNearestBlock((block) -> block.isOf(Butterfly.this.givenFlower), 16.0D) : this.findNearestBlock(this.VALID_POLLINATION_BLOCKS, 8.0D);
        }

        private Optional<BlockPos> findNearestBlock(Predicate<BlockState> predicate, double distance) {
            BlockPos pos = Butterfly.this.getBlockPos();
            BlockPos.Mutable mutablePos = new BlockPos.Mutable();

            for (int i = 0; (double)i <= distance; i = i > 0 ? -i : 1 - i) {
                for (int j = 0; (double)j < distance; ++j) {
                    for (int k = 0; k <= j; k = k > 0 ? -k : 1 - k) {
                        for (int l = k < j && k > -j ? j : 0; l <= j; l = l > 0 ? -l : 1 - l) {
                            mutablePos.set(pos, k, i - 1, l);

                            if (pos.isWithinDistance(mutablePos, distance) && predicate.test(Butterfly.this.getWorld().getBlockState(mutablePos))) {
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
            this.setControls(EnumSet.of(Goal.Control.MOVE));
        }

        public boolean canStart() {
            return Butterfly.this.hasNectar() && Butterfly.this.pollinateGoal.willSpreadFlowersAfter;
        }

        public boolean shouldContinue() {
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
                if (!Butterfly.this.getWorld().isClient) {
                    if (this.emptyPos != null) {
                        if (Butterfly.this.givenFlower != null) {
                            BlockState flowerState = Butterfly.this.givenFlower.getDefaultState();

                            if (Butterfly.this.getWorld().isAir(this.emptyPos) && flowerState.canPlaceAt(Butterfly.this.getWorld(), this.emptyPos)) {
                                Butterfly.this.getWorld().setBlockState(this.emptyPos, flowerState);
                                Butterfly.this.getWorld().emitGameEvent(GameEvent.BLOCK_PLACE, this.emptyPos, GameEvent.Emitter.of(Butterfly.this, flowerState));
                                Butterfly.this.getWorld().playSound(null, this.emptyPos, SoundEvents.BLOCK_GRASS_PLACE, SoundCategory.BLOCKS, 0.7F, 0.9F + Butterfly.this.random.nextFloat() * 0.2F);
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

        public boolean shouldRunEveryTick() {
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
                if (ticks > this.getTickCount(600)) {
                    this.fail();
                }
            }
        }

        /** @return a random empty space near the original flower pos a butterfly can plant a flower at. */
        private BlockPos findRandomEmptyPos() {
            Map<Integer, BlockPos> map = Maps.newHashMap();

            BlockPos flowerPos = Butterfly.this.pollinateGoal.flowerPos;
            BlockPos currentPos = flowerPos != null ? flowerPos : Butterfly.this.getBlockPos();

            for (int i = 0; i <= 14; i++) {
                BlockPos pos;
                int x = MathHelper.floor(currentPos.getX() + (random.nextBoolean() ? random.nextInt(3) : -random.nextInt(3)));
                int y = MathHelper.floor(currentPos.getY() + (random.nextBoolean() ? random.nextInt(3) : -random.nextInt(3)));
                int z = MathHelper.floor(currentPos.getZ() + (random.nextBoolean() ? random.nextInt(3) : -random.nextInt(3)));
                pos = new BlockPos(x, y, z);

                if (Butterfly.this.getWorld().getBlockState(pos).isAir() && Butterfly.this.getWorld().getBlockState(pos.down()).isOf(Blocks.GRASS_BLOCK)) {
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
            this.setControls(EnumSet.of(Goal.Control.MOVE));
        }

        public boolean canStart() {
            return Butterfly.this.navigation.isIdle();
        }

        public boolean shouldContinue() {
            return Butterfly.this.navigation.isFollowingPath();
        }

        public void start() {
            Vec3d vec3 = this.findPos();
            if (vec3 != null) {
                vec3 = new Vec3d(vec3.x, this.findFurthestBlockBelow(BlockPos.ofFloored(vec3)) + 2, vec3.z);

                Butterfly.this.navigation.startMovingAlong(Butterfly.this.navigation.findPathTo(BlockPos.ofFloored(vec3), 1), 1.0D);
            }
        }

        private int findFurthestBlockBelow(BlockPos pos) {
            BlockPos.Mutable mutablePos = new BlockPos.Mutable(pos.getX(), pos.getY(), pos.getZ());

            while (mutablePos.getY() > 0) {
                mutablePos.move(0, -1, 0);

                if (!Butterfly.this.getWorld().isAir(mutablePos) && (!Butterfly.this.getWorld().getBlockState(mutablePos).isAir() || Butterfly.this.getWorld().getBlockState(mutablePos).isReplaceable())) {
                    return mutablePos.getY();
                }
            }
            return pos.getY();
        }

        @Nullable
        private Vec3d findPos() {
            Vec3d vec3;
            if (Butterfly.this.isNestValid() && Butterfly.this.nestPos != null && !Butterfly.this.isCloserThan(Butterfly.this.nestPos, 22)) {
                Vec3d vec31 = Vec3d.ofCenter(Butterfly.this.nestPos);
                vec3 = vec31.subtract(Butterfly.this.getPos()).normalize();
            } else {
                vec3 = Butterfly.this.getRotationVec(0.0F);
            }

            Vec3d vec32 = AboveGroundTargeting.find(Butterfly.this, 8, 7, vec3.x, vec3.z, ((float)Math.PI / 2F), 3, 1);
            return vec32 != null ? vec32 : NoPenaltySolidTargeting.find(Butterfly.this, 8, 4, -2, vec3.x, vec3.z, ((float)Math.PI / 2F));
        }
    }

    class ButterflyLookControl extends LookControl {

        ButterflyLookControl() {
            super(Butterfly.this);
        }

        @Override
        protected boolean shouldStayHorizontal() {
            return !Butterfly.this.pollinateGoal.isPollinating() || !Butterfly.this.spreadFlowersGoal.isPlantingFlower();
        }
    }

    public enum Type implements StringIdentifiable {
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

        public String asString() {
            return this.name;
        }

        public static Type byId(int id) {
            return ValueLists.createIdToValueFunction(Type::getId, values(), ValueLists.OutOfBoundsHandling.ZERO).apply(id);
        }

        public static Type byName(String name) {
            return StringIdentifiable.createCodec(Type::values).byId(name, TANGERINE);
        }
    }

}