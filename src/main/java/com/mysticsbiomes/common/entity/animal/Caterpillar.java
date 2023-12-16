package com.mysticsbiomes.common.entity.animal;

import com.mysticsbiomes.common.block.entity.ChrysalisBlockEntity;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

/**
 * Caterpillars are...cute...fuzzy bugs that grow into beautiful butterflies!
 * Similar mechanics to tadpoles.
 */
public class Caterpillar extends Animal {
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(Caterpillar.class, EntityDataSerializers.BYTE);
    private static final int ticksTillAgeUp = Math.abs(-24000);
    private int age;
    @Nullable
    private UUID befriendedPlayer;

    public final AnimationState verticalState = new AnimationState();

    public Caterpillar(EntityType<? extends Caterpillar> type, Level level) {
        super(type, level);
        this.moveControl = new MoveControl(this);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new Caterpillar.CreateChrysalisGoal());
        this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 0.3D));
    }

    protected PathNavigation createNavigation(Level level) {
        return new WallClimberNavigation(this, level);
    }

    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
        return null;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Age", this.age);

        if (this.befriendedPlayer != null) {
            tag.putUUID("BefriendedPlayer", this.befriendedPlayer);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setAge(tag.getInt("Age"));

        this.befriendedPlayer = null;
        if (tag.contains("BefriendedPlayer")) {
            this.befriendedPlayer = tag.getUUID("BefriendedPlayer");
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide) {
            this.setClimbing(this.horizontalCollision);
        }

        if (this.level().isClientSide) {
            this.verticalState.animateWhen(this.onClimbable(), this.tickCount);
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (!this.level().isClientSide) {
            this.setAge(++this.age + 1);
        }
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int amount) {
        this.age = amount;
    }

    private boolean isReadyToAgeUp() {
        return this.age > ticksTillAgeUp;
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!player.level().isClientSide) {
            if (stack.is(ItemTags.SMALL_FLOWERS) && this.befriendedPlayer == null) {
                this.befriendedPlayer = player.getUUID();

                ((ServerLevel)player.level()).sendParticles(ParticleTypes.HEART, this.getRandomX(0.3D), this.getY() + 0.15D, this.getRandomZ(0.3D), 0, (float)this.level().getRandom().nextInt(4) / 24.0F, this.random.nextGaussian() * 0.02D, this.random.nextGaussian() * 0.02D, this.random.nextGaussian() * 0.02D);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public boolean onClimbable() {
        return this.isClimbing();
    }

    public boolean isClimbing() {
        return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
    }

    public void setClimbing(boolean climbing) {
        byte b0 = this.entityData.get(DATA_FLAGS_ID);
        b0 = climbing ? (byte)(b0 | 1) : (byte)(b0 & -2);
        this.entityData.set(DATA_FLAGS_ID, b0);
    }

    public boolean shouldDropExperience() {
        return false;
    }

    protected void jumpFromGround() {
    }

    protected void checkFallDamage(double distance, boolean b, BlockState state, BlockPos pos) {
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
    }

    /**
     * Finds, goes to, and creates a chrysalis.json at a valid found pos when the caterpillar is ready to age up.
     */
    class CreateChrysalisGoal extends Goal {
        private int ticks;
        @Nullable
        private BlockPos validPos;

        CreateChrysalisGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        public boolean canUse() {
            return Caterpillar.this.isReadyToAgeUp();
        }

        public boolean canContinueToUse() {
            return !this.hasBeenAtPosLongEnough();
        }

        public void start() {
            Optional<BlockPos> optional = this.findNearestBlock((block) -> block.is(BlockTags.LOGS));
            if (optional.isPresent()) {
                this.validPos = optional.get();
            }
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            if (this.validPos != null) {
                Vec3 vec3 = new Vec3(this.validPos.getCenter().x(), this.validPos.getCenter().y(), this.validPos.getCenter().z());

                if (vec3.distanceToSqr(Caterpillar.this.position()) > 0.5D) {
                    Caterpillar.this.navigation.moveTo(vec3.x(), vec3.y() + 0.5D, vec3.z(), 0.3F);
                } else {
                    ++this.ticks;
                    Caterpillar.this.navigation.stop();
                    Caterpillar.this.setDeltaMovement(0, 0, 0);
                }

                if (this.hasBeenAtPosLongEnough()) {
                    Caterpillar.this.level().setBlockAndUpdate(Caterpillar.this.blockPosition(), MysticBlocks.CHRYSALIS.get().defaultBlockState());

                    if (Caterpillar.this.level().getBlockEntity(Caterpillar.this.blockPosition()) instanceof ChrysalisBlockEntity entity) {
                        entity.addInhabitant(Caterpillar.this);
                    }
                }
            }
        }

        private Optional<BlockPos> findNearestBlock(Predicate<BlockState> predicate) {
            BlockPos pos = Caterpillar.this.blockPosition();
            BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

            for (int i = 0; (double)i <= 8.0D; i = i > 0 ? -i : 1 - i) {
                for (int j = 0; (double)j < 8.0D; ++j) {
                    for (int k = 0; k <= j; k = k > 0 ? -k : 1 - k) {
                        for (int l = k < j && k > -j ? j : 0; l <= j; l = l > 0 ? -l : 1 - l) {
                            mutablePos.setWithOffset(pos, k, i - 1, l);

                            if (pos.closerThan(mutablePos, 8.0D) && predicate.test(Caterpillar.this.level().getBlockState(mutablePos))) {
                                return Optional.of(mutablePos);
                            }
                        }
                    }
                }
            }
            return Optional.empty();
        }

        private boolean hasBeenAtPosLongEnough() {
            return this.ticks > this.adjustedTickDelay(6000);
        }
    }

}