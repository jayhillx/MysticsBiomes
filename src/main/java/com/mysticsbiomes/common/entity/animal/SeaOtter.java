package com.mysticsbiomes.common.entity.animal;

import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.brain.task.LookTargetUtil;
import net.minecraft.entity.ai.control.BodyControl;
import net.minecraft.entity.ai.control.LookControl;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.Util;
import net.minecraft.util.function.ValueLists;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Optional;

public class SeaOtter extends AnimalEntity {
    private static final TrackedData<Byte> DATA_TYPE_ID = DataTracker.registerData(SeaOtter.class, TrackedDataHandlerRegistry.BYTE);
    private static final TrackedData<Boolean> DATA_FLOATING_ID = DataTracker.registerData(SeaOtter.class, TrackedDataHandlerRegistry.BOOLEAN);
    private boolean needsToSurface;
    private int ticksSinceLastSwamAround;
    private int ticksOutOfWater;
    @Nullable
    private BlockPos surfacePos;

    public final AnimationState startSwimmingAnimationState = new AnimationState();
    public final AnimationState floatingAnimationState = new AnimationState();
    public final AnimationState sitDownAnimationState = new AnimationState();
    public final AnimationState sitUpAnimationState = new AnimationState();

    public SeaOtter(EntityType<? extends SeaOtter> type, World level) {
        super(type, level);
        this.setPathfindingPenalty(PathNodeType.WATER, 0.0F);
        this.setStepHeight(1.0F);
        this.moveControl = new SeaOtter.SeaOtterMoveControl(this);
        this.lookControl = new SeaOtter.SeaOtterLookControl(this);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(DATA_TYPE_ID, (byte)0);
        this.dataTracker.startTracking(DATA_FLOATING_ID, false);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new EscapeDangerGoal(this, 2.0D));
        this.goalSelector.add(0, new SeaOtter.SwimToSurfaceGoal(this, 1.0D, 16));
        this.goalSelector.add(0, new SeaOtter.MoveToWaterGoal(this, 1.0D, 16));
        this.goalSelector.add(1, new TemptGoal(this, 1.0D, Ingredient.ofItems(MysticBlocks.MILKWEED), false));
        this.goalSelector.add(3, new SeaOtter.SeaOtterSwimAroundGoal(this, 1.0D, 10));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F, 0.02F, true));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.goalSelector.add(6, new SeaOtter.FloatGoal());
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 16.0F).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.0D);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound tag) {
        super.writeCustomDataToNbt(tag);
        tag.putString("Type", this.getVariant().asString());
        tag.putBoolean("Floating", this.isFloating());
        tag.putBoolean("NeedsToSurface", this.needsToSurface());
        tag.putInt("TicksSinceSwam", this.ticksSinceLastSwamAround);
        tag.putInt("TicksOutOfWater", this.ticksOutOfWater);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound tag) {
        super.readCustomDataFromNbt(tag);
        this.setVariant(Type.byName(tag.getString("Type")));
        this.setFloating(tag.getBoolean("Floating"));
        this.setNeedsToSurface(tag.getBoolean("NeedsToSurface"));
        this.ticksSinceLastSwamAround = tag.getInt("TicksSinceSwam");
        this.ticksOutOfWater = tag.getInt("TicksOutOfWater");
    }

    @Override
    public EntityData initialize(ServerWorldAccess accessor, LocalDifficulty instance, SpawnReason type, EntityData data, NbtCompound tag) {
        Random random = accessor.getRandom();
        this.setVariant(Type.getRandomVariant(random));
        return super.initialize(accessor, instance, type, data, tag);
    }

    @Override
    public SeaOtter createChild(ServerWorld level, PassiveEntity mob) {
        return MysticEntities.SEA_OTTER.create(level);
    }

    @Override
    public EntityGroup getGroup() {
        return EntityGroup.AQUATIC;
    }

    public Type getVariant() {
        return Type.byId(this.dataTracker.get(DATA_TYPE_ID));
    }

    public void setVariant(Type type) {
        this.dataTracker.set(DATA_TYPE_ID, (byte)type.getId());
    }

    @Override
    public int getMaxAir() {
        return 6000;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.isFloating()) {
            this.touchingWater = true;
            this.setAir(this.getMaxAir());
            this.setVelocity(this.getVelocity().multiply(1.0D, 0.0D, 1.0D));
        }

        if (!this.getWorld().isClient) {
            if (this.isFloating()) {
                ++this.ticksSinceLastSwamAround;
            }

            if (!this.isFloating() && !this.isTouchingWater()) {
                ++this.ticksOutOfWater;
            }
        }

        if (this.getWorld().isClient) {
            this.floatingAnimationState.setRunning(this.isFloating(), this.age);
        }
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        if (this.canMoveVoluntarily() && this.isAlive()) {
            if (!this.needsToSurface && (this.isSubmergedInWater() && (!this.wantsToSwim() || this.getAir() < 400))) {
                this.setNeedsToSurface(true);
            }
        }
    }

    @Override
    public void travel(Vec3d vec3) {
        if (this.canMoveVoluntarily() && this.isTouchingWater()) {
            this.updateVelocity(this.getMovementSpeed(), vec3);
            this.move(MovementType.SELF, this.getVelocity());
            this.setVelocity(this.getVelocity().multiply(0.9));
        } else {
            super.travel(vec3);
        }
    }

    @Override
    protected EntityNavigation createNavigation(World level) {
        return new SeaOtter.SeaOtterPathNavigation(this, level);
    }

    @Override
    protected BodyControl createBodyControl() {
        return new SeaOtter.SeaOtterBodyRotationControl(this);
    }

    public boolean isFloating() {
        return this.dataTracker.get(DATA_FLOATING_ID);
    }

    public void setFloating(boolean value) {
        this.dataTracker.set(DATA_FLOATING_ID, value);
    }

    public boolean wantsToSwim() {
        return this.ticksSinceLastSwamAround > 300;
    }

    public void resetTicksSinceLastSwam() {
        this.ticksSinceLastSwamAround = 0;
    }

    public boolean needsToSurface() {
        return this.needsToSurface;
    }

    public void setNeedsToSurface(boolean value) {
        this.needsToSurface = value;
    }

    @Nullable
    public BlockPos getSurfacePos() {
        return this.surfacePos;
    }

    public void setSurfacePos(@Nullable BlockPos pos) {
        this.surfacePos = pos;
    }

    public boolean wantsToGoInWater() {
        return this.ticksOutOfWater > 200;
    }

    class FloatGoal extends Goal {

        public boolean canStart() {
            return !SeaOtter.this.wantsToSwim() && SeaOtter.this.getSurfacePos() != null && SeaOtter.this.getSurfacePos().isWithinDistance(SeaOtter.this.getBlockPos(), 0);
        }

        public void start() {
            SeaOtter.this.setFloating(true);
        }

        public void stop() {
            SeaOtter.this.setFloating(false);
            SeaOtter.this.setSurfacePos(null);
        }
    }

    class SeaOtterSwimAroundGoal extends SwimAroundGoal {
        private int ticksSwimming;

        public SeaOtterSwimAroundGoal(PathAwareEntity mob, double speed, int interval) {
            super(mob, speed, interval);
        }

        public boolean canStart() {
            return !SeaOtter.this.needsToSurface() && SeaOtter.this.wantsToSwim() && super.canStart();
        }

        public boolean shouldContinue() {
            return !SeaOtter.this.needsToSurface() && !(this.ticksSwimming > 200) && super.shouldContinue();
        }

        public void start() {
            super.start();
        }

        public void stop() {
            super.stop();
            if (this.ticksSwimming > 200) {
                this.ticksSwimming = 0;
                SeaOtter.this.setNeedsToSurface(true);
                SeaOtter.this.resetTicksSinceLastSwam();
            }
        }

        protected Vec3d getWanderTarget() {
            return LookTargetUtil.find(this.mob, 10, 4);
        }

        public void tick() {
            this.ignoreChanceOnce();
            ++this.ticksSwimming;
        }
    }

    class SwimToSurfaceGoal extends MoveToTargetPosGoal {

        public SwimToSurfaceGoal(PathAwareEntity mob, double speed, int range) {
            super(mob, speed, range);
        }

        public boolean canStart() {
            return SeaOtter.this.needsToSurface();
        }

        public boolean shouldContinue() {
            return !this.getMoveToTarget().isWithinDistance(SeaOtter.this.getPos(), 1.0D);
        }

        public void stop() {
            SeaOtter.this.setFloating(true);
            SeaOtter.this.setNeedsToSurface(false);
            SeaOtter.this.getNavigation().stop();
        }

        public void tick() {
            if (this.targetPos == BlockPos.ZERO) {
                Optional<BlockPos> optional = this.findAir();

                if (optional.isPresent()) {
                    this.targetPos = optional.get();
                    SeaOtter.this.setSurfacePos(this.targetPos);
                }
            }

            BlockPos pos = this.getMoveToTarget();
            if (!pos.isWithinDistance(SeaOtter.this.getPos(), 1.0D)) {
                SeaOtter.this.navigation.startMovingTo(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, this.speed);
            }
        }

        protected BlockPos getMoveToTarget() {
            return this.targetPos;
        }

        protected boolean isTargetPos(WorldView level, BlockPos pos) {
            return level.getBlockState(pos).isAir() && level.getBlockState(pos.down()).isOf(Blocks.WATER);
        }

        protected Optional<BlockPos> findAir() {
            BlockPos pos = SeaOtter.this.getBlockPos();
            BlockPos.Mutable mutablePos = new BlockPos.Mutable();

            for (int k = this.lowestY; k <= 16.0; k = k > 0 ? -k : 1 - k) {
                for (int l = 0; l < 16.0; ++l) {
                    for (int i1 = 0; i1 <= l; i1 = i1 > 0 ? -i1 : 1 - i1) {
                        for (int j1 = i1 < l && i1 > -l ? l : 0; j1 <= l; j1 = j1 > 0 ? -j1 : 1 - j1) {
                            mutablePos.set(pos, i1, k - 1, j1);

                            if (pos.isWithinDistance(mutablePos, 16.0) && this.isTargetPos(SeaOtter.this.getWorld(), mutablePos)) {
                                this.targetPos = mutablePos;
                                return Optional.of(mutablePos);
                            }
                        }
                    }
                }
            }
            return Optional.empty();
        }
    }

    class MoveToWaterGoal extends MoveToTargetPosGoal {

        public MoveToWaterGoal(PathAwareEntity mob, double speed, int distance) {
            super(mob, speed, distance);
        }

        @Override
        public boolean canStart() {
            if (SeaOtter.this.isTouchingWater() || SeaOtter.this.isFloating()) {
                return false;
            }
            return SeaOtter.this.wantsToGoInWater() && super.canStart();
        }

        @Override
        public double getDesiredDistanceToTarget() {
            return 0.0D;
        }

        @Override
        protected boolean isTargetPos(WorldView level, BlockPos pos) {
            return level.getBlockState(pos).getFluidState().isIn(FluidTags.WATER) && level.getBlockState(pos.down()).getFluidState().isIn(FluidTags.WATER);
        }
    }

    /** modified smooth swimming control with the ability to move on land when needed. */
    private class SeaOtterMoveControl extends MoveControl {

        public SeaOtterMoveControl(MobEntity mob) {
            super(mob);
        }

        @Override
        public void tick() {
            if (SeaOtter.this.isTouchingWater()) {
                SeaOtter.this.setVelocity(SeaOtter.this.getVelocity().add(0.0D, 0.005D, 0.0D));

                if (this.state == MoveControl.State.MOVE_TO && !SeaOtter.this.getNavigation().isIdle()) {
                    double d0 = this.targetX - SeaOtter.this.getX();
                    double d1 = this.targetY - SeaOtter.this.getY();
                    double d2 = this.targetZ - SeaOtter.this.getZ();
                    double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                    if (d3 < (double)2.5000003E-7F) {
                        SeaOtter.this.setForwardSpeed(0.0F);
                    } else {
                        float f = (float)(MathHelper.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
                        SeaOtter.this.setYaw(this.wrapDegrees(SeaOtter.this.getYaw(), f, (float)10));
                        SeaOtter.this.bodyYaw = this.entity.getYaw();
                        SeaOtter.this.headYaw = this.entity.getYaw();

                        float speed = (float)(this.speed * SeaOtter.this.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED));
                        SeaOtter.this.setMovementSpeed(speed * 0.02F);

                        double d4 = Math.sqrt(d0 * d0 + d2 * d2);
                        if (Math.abs(d1) > (double)1.0E-5F || Math.abs(d4) > (double)1.0E-5F) {
                            float f3 = -((float)(MathHelper.atan2(d1, d4) * (double)(180F / (float)Math.PI)));
                            f3 = MathHelper.clamp(MathHelper.wrapDegrees(f3), (float)(-85), (float)85);
                            SeaOtter.this.setPitch(this.wrapDegrees(SeaOtter.this.getPitch(), f3, 5.0F));
                        }

                        float f6 = MathHelper.cos(SeaOtter.this.getPitch() * ((float)Math.PI / 180F));
                        float f4 = MathHelper.sin(SeaOtter.this.getPitch() * ((float)Math.PI / 180F));
                        SeaOtter.this.forwardSpeed = f6 * speed;
                        SeaOtter.this.upwardSpeed = -f4 * speed;
                    }
                } else {
                    SeaOtter.this.setMovementSpeed(0.0F);
                    SeaOtter.this.setSidewaysSpeed(0.0F);
                    SeaOtter.this.setUpwardSpeed(0.0F);
                    SeaOtter.this.setForwardSpeed(0.0F);
                }
            } else {
                this.speed = 0.15F;
                super.tick();
            }
        }
    }

    private class SeaOtterLookControl extends LookControl {

        public SeaOtterLookControl(MobEntity mob) {
            super(mob);
        }

        @Override
        public void tick() {
            if (!SeaOtter.this.isFloating()) {
                if (SeaOtter.this.isTouchingWater()) {
                    if (this.lookAtTimer > 0) {
                        this.lookAtTimer--;
                        this.getTargetYaw().ifPresent(yaw -> this.entity.headYaw = this.changeAngle(this.entity.headYaw, yaw + 20.0F, this.maxYawChange));
                        this.getTargetPitch().ifPresent(pitch -> this.entity.setPitch(this.changeAngle(this.entity.getPitch(), pitch + 10.0F, this.maxPitchChange)));
                    } else {
                        if (this.entity.getNavigation().isIdle()) {
                            this.entity.setPitch(this.changeAngle(this.entity.getPitch(), 0.0F, 5.0F));
                        }

                        this.entity.headYaw = this.changeAngle(this.entity.headYaw, this.entity.bodyYaw, this.maxYawChange);
                    }
                } else {
                    super.tick();
                }
            }
        }
    }

    private class SeaOtterPathNavigation extends SwimNavigation {

        public SeaOtterPathNavigation(MobEntity mob, World level) {
            super(mob, level);
        }

        @Override
        protected PathNodeNavigator createPathNodeNavigator(int range) {
            this.nodeMaker = new AmphibiousPathNodeMaker(true);
            return new PathNodeNavigator(this.nodeMaker, range);
        }

        @Override
        protected boolean isAtValidPosition() {
            return true;
        }

        @Override
        public boolean isValidPosition(BlockPos pos) {
            BlockState belowState = this.world.getBlockState(pos.down());
            if (SeaOtter.this.isTouchingWater()) {
                return !(belowState.isAir() || belowState.getFluidState().isIn(FluidTags.WATER));
            } else {
                return !belowState.isAir();
            }
        }
    }

    private class SeaOtterBodyRotationControl extends BodyControl {

        public SeaOtterBodyRotationControl(MobEntity mob) {
            super(mob);
        }

        public void tick() {
            if (!SeaOtter.this.isFloating()) {
                super.tick();
            }
        }
    }

    public enum Type implements StringIdentifiable {
        BROWN(0, "brown"),
        BEIGE(1, "beige"),
        GRAY(2, "gray");

        final int id;
        final String type;

        Type(int id, String type) {
            this.id = id;
            this.type = type;
        }

        public int getId() {
            return this.id;
        }

        public String asString() {
            return this.type;
        }

        public static Type byId(int id) {
            return ValueLists.createIdToValueFunction(Type::getId, values(), ValueLists.OutOfBoundsHandling.ZERO).apply(id);
        }

        public static Type byName(String name) {
            return StringIdentifiable.createCodec(Type::values).byId(name, BROWN);
        }

        private static Type getRandomVariant(Random random) {
            Type[] types = Arrays.stream(values()).toArray(Type[]::new);
            return Util.getRandom(types, random);
        }
    }

}