package com.mysticsbiomes.common.entity.animal;

import com.mysticsbiomes.common.block.entity.ButterflyNestBlockEntity;
import com.mysticsbiomes.common.entity.EntityFlagManager;
import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticItems;
import com.mysticsbiomes.init.MysticPoiTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
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
import net.minecraft.util.RandomSource;
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
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
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
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Butterfly extends Animal implements FlyingAnimal {
    private static final EntityDataAccessor<String> DATA_TYPE_ID = SynchedEntityData.defineId(Butterfly.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(Butterfly.class, EntityDataSerializers.BYTE);
    public final EntityFlagManager flagManager = new EntityFlagManager(this, Butterfly.DATA_FLAGS_ID);
    public final AnimationState flyingAnimationState = new AnimationState();
    public final AnimationState pollinatingAnimationState = new AnimationState();
    private int ticksBeforeLocatingNest;
    private int ticksBeforeCanEnterNest;
    private int ticksSincePollinated;
    private int ticksSincePlantedFlower;
    private int nectarPoints;
    @Nullable
    private BlockPos nestPos;
    @Nullable
    private BlockPos flowerPos;
    @Nullable
    private Block givenFlower;
    @Nullable
    private UUID partnerUuid;

    public Butterfly(EntityType<? extends Butterfly> entity, Level level) {
        super(entity, level);
        this.moveControl = new FlyingMoveControl(this, 20, true);
        this.lookControl = new ButterflyLookControl(this);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER_BORDER, 16.0F);
        this.setPathfindingMalus(BlockPathTypes.COCOA, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.FENCE, -1.0F);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.FLYING_SPEED, 0.6F).add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.FOLLOW_RANGE, 28.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BreedingGoal(this));
        this.goalSelector.addGoal(2, new PlantFlowerGoal(this));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.of(ItemTags.FLOWERS), false));
        this.goalSelector.addGoal(4, new PollinateGoal(this));
        this.goalSelector.addGoal(5, new EnterNestGoal(this));
        this.goalSelector.addGoal(6, new GoToNestGoal(this));
        this.goalSelector.addGoal(7, new LocateNestGoal(this));
        this.goalSelector.addGoal(8, new WanderGoal(this));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_TYPE_ID, Type.MONARCH.getSerializedName());
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putString("Type", this.getVariant().getSerializedName());
        tag.putBoolean("Sleeping", this.isSleeping());
        tag.putBoolean("Breeding", this.isBreeding());
        tag.putBoolean("Pollinating", this.isPollinating());
        tag.putBoolean("PlantingFlower", this.isPlantingFlower());
        tag.putBoolean("HasNectar", this.hasNectar());
        tag.putInt("NectarPoints", this.nectarPoints);
        tag.putInt("TicksBeforeLocatingNest", this.ticksBeforeLocatingNest);
        tag.putInt("TicksBeforeCanEnterNest", this.ticksBeforeCanEnterNest);
        tag.putInt("TicksSincePollinated", this.ticksSincePollinated);
        tag.putInt("TicksSincePlantedFlower", this.ticksSincePlantedFlower);

        if (this.nestPos != null) {
            tag.put("NestPos", NbtUtils.writeBlockPos(this.nestPos));
        }

        if (this.flowerPos != null) {
            tag.put("FlowerPos", NbtUtils.writeBlockPos(this.flowerPos));
        }

        if (this.givenFlower != null) {
            tag.put("GivenFlower", NbtUtils.writeBlockState(this.givenFlower.defaultBlockState()));
        }

        if (this.partnerUuid != null) {
            tag.putUUID("PartnerId", this.partnerUuid);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setVariant(Type.byName(tag.getString("Type")));
        this.setSleeping(tag.getBoolean("Sleeping"));
        this.setBreeding(tag.getBoolean("Breeding"));
        this.setPollinating(tag.getBoolean("Pollinating"));
        this.setPlantingFlower(tag.getBoolean("PlantingFlower"));
        this.setHasNectar(tag.getBoolean("HasNectar"));
        this.nectarPoints = tag.getInt("NectarPoints");
        this.ticksBeforeLocatingNest = tag.getInt("TicksBeforeLocatingNest");
        this.ticksBeforeCanEnterNest = tag.getInt("TicksBeforeCanEnterNest");
        this.ticksSincePollinated = tag.getInt("TicksSincePollinated");
        this.ticksSincePlantedFlower = tag.getInt("TicksSincePlantedFlower");

        this.nestPos = null;
        if (tag.contains("NestPos")) {
            this.nestPos = NbtUtils.readBlockPos(tag.getCompound("NestPos"));
        }

        this.flowerPos = null;
        if (tag.contains("FlowerPos")) {
            this.flowerPos = NbtUtils.readBlockPos(tag.getCompound("FlowerPos"));
        }

        this.givenFlower = null;
        if (tag.contains("GivenFlower")) {
            this.givenFlower = NbtUtils.readBlockState(this.level().holderLookup(Registries.BLOCK), tag.getCompound("GivenFlower")).getBlock();
        }

        this.partnerUuid = null;
        if (tag.contains("PartnerId")) {
            this.partnerUuid = tag.getUUID("PartnerId");
        }
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
        return null;
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor accessor, DifficultyInstance instance, MobSpawnType type, @Nullable SpawnGroupData data, CompoundTag tag) {
        this.setVariant(Type.byId(this.random.nextInt(3)));
        return super.finalizeSpawn(accessor, instance, type, data, tag);
    }

    public Type getVariant() {
        return Type.byName(this.entityData.get(DATA_TYPE_ID));
    }

    public void setVariant(Type type) {
        this.entityData.set(DATA_TYPE_ID, type.getSerializedName());
    }

    public void setVariantByName(String name) {
        this.entityData.set(DATA_TYPE_ID, name);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.flyingAnimationState.animateWhen(this.isFlying() && !this.isPollinating(), this.tickCount);
            this.pollinatingAnimationState.animateWhen(this.isPollinating(), this.tickCount);
        }

        if (!this.level().isClientSide()) {
            if (this.isPollinating() && this.flowerPos != null && !this.isCloserThan(this.flowerPos, 0.5D)) {
                this.setPollinating(false);
            }
        }

        if (this.level() instanceof ServerLevel serverLevel) {
            if (this.random.nextFloat() < 0.05F) {
                if (this.hasNectar()) {
                    serverLevel.sendParticles(ParticleTypes.FALLING_NECTAR, Mth.lerp(this.level().random.nextDouble(), this.getX() - (double)0.3F, this.getX() + (double)0.3F), this.getY(0.5D), Mth.lerp(this.level().random.nextDouble(), this.getZ() - (double)0.3F, this.getZ() + (double)0.3F), 0, 0, 0.0D, 0.0D, 0.0D);
                }

                if (this.isPlantingFlower()) {
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

    @Override
    public void aiStep() {
        super.aiStep();

        if (!this.level().isClientSide()) {
            if (this.ticksBeforeLocatingNest > 0) {
                --this.ticksBeforeLocatingNest;
            }

            if (this.ticksBeforeCanEnterNest > 0) {
                --this.ticksBeforeCanEnterNest;
            }

            if (this.tickCount % 20 == 0 && !this.isNestValid()) {
                this.nestPos = null;
            }

            if (this.tickCount % 20 == 0 && this.flowerPos != null && !this.isFlowerValid(this.flowerPos)) {
                this.flowerPos = null;
            }
        }
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();

        if (this.hasNest()) {
            if (!this.isPollinating()) {
                ++this.ticksSincePollinated;
            }
        }

        if (!this.isPlantingFlower()) {
            ++this.ticksSincePlantedFlower;
        }
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (this.hasNest()) {
            if (stack.is(ItemTags.SMALL_FLOWERS)) {
                if (this.canPollinate()) {
                    if (this.givenFlower == null) {
                        this.givenFlower = Block.byItem(stack.getItem());
                        this.usePlayerItem(player, hand, stack);
                        this.addParticle(ParticleTypes.HAPPY_VILLAGER, 5);
                        return InteractionResult.CONSUME;
                    }
                } else {
                    this.addParticle(ParticleTypes.ANGRY_VILLAGER);
                }
            } else if (this.isFood(stack) && this.canFallInLove()) {
                this.usePlayerItem(player, hand, stack);
                this.setInLove(player);
                return InteractionResult.CONSUME;
            }
        }

        return InteractionResult.PASS;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(MysticItems.MILKWEED.get());
    }

    protected void addParticle(SimpleParticleType particle, int amount) {
        for (int i = 0; i < amount; i++) {
            this.addParticle(particle);
        }
    }

    protected void addParticle(SimpleParticleType particle) {
        double x = this.random.nextGaussian() * 0.02D;
        double y = this.random.nextGaussian() * 0.02D;
        double z = this.random.nextGaussian() * 0.02D;
        ((ServerLevel)this.level()).sendParticles(particle, this.getRandomX(1.0D), this.getRandomY() - 0.25D, this.getRandomZ(1.0D), 0, (float)this.level().getRandom().nextInt(4) / 24.0F, x, y, z);
    }

    @Nullable
    public BlockPos getNestPos() {
        return this.nestPos;
    }

    public void setNestPos(@Nullable BlockPos nestPos) {
        this.nestPos = nestPos;
    }

    public boolean hasNest() {
        return this.getNestPos() != null;
    }

    public boolean wantsToEnterNest() {
        if (this.isBreeding()) {
            return true;
        } else if (this.canEnterNest()) {
            boolean flag = this.level().isRainingAt(this.blockPosition()) || this.level().isNight() || this.hasNectar() || (this.hasNectar() && this.wasGivenFlower());
            return flag && !this.isNestNearFire();
        } else {
            return false;
        }
    }

    public boolean canEnterNest() {
        return this.ticksBeforeCanEnterNest <= 0;
    }

    public void setTicksBeforeCanEnterNest(int ticks) {
        this.ticksBeforeCanEnterNest = ticks;
    }

    public boolean isNestValid() {
        if (this.nestPos == null) {
            return false;
        } else if (this.isTooFarAway(this.nestPos)) {
            return false;
        } else {
            BlockEntity entity = this.level().getBlockEntity(this.nestPos);
            return entity instanceof ButterflyNestBlockEntity;
        }
    }

    public boolean isNestNearFire() {
        if (this.nestPos == null) {
            return false;
        } else {
            BlockEntity entity = this.level().getBlockEntity(this.nestPos);
            if (entity instanceof ButterflyNestBlockEntity nest) {
                return nest.isFireNearby();
            } else {
                return false;
            }
        }
    }

    public boolean doesNestHaveSpace(BlockPos pos) {
        BlockEntity entity = this.level().getBlockEntity(pos);
        if (entity instanceof ButterflyNestBlockEntity nest) {
            return !nest.isFull();
        } else {
            return false;
        }
    }

    public boolean isSleeping() {
        return this.flagManager.getFlag(1 << 1);
    }

    public void setSleeping(boolean value) {
        this.flagManager.setFlag(1 << 1, value);
    }

    public boolean isBreeding() {
        return this.flagManager.getFlag(1 << 2);
    }

    public void setBreeding(boolean value) {
        this.flagManager.setFlag(1 << 2, value);
    }

    public void resetPartner() {
        this.partnerUuid = null;
    }

    @Nullable
    public Block getGivenFlower() {
        return this.givenFlower;
    }

    public boolean wasGivenFlower() {
        return this.givenFlower != null;
    }

    public BlockState getFlowerState() {
        return Objects.requireNonNull(this.getGivenFlower()).defaultBlockState();
    }

    public boolean isPollinating() {
        return this.flagManager.getFlag(1 << 3);
    }

    public void setPollinating(boolean value) {
        this.flagManager.setFlag(1 << 3, value);
    }

    public boolean wantsToPollinate() {
        return this.canEnterNest() && !this.hasNectar();
    }

    public boolean canPollinate() {
        return this.ticksSincePollinated >= 2400; /// 2 minutes
    }

    public void resetTicksSincePollinated() {
        this.ticksSincePollinated = 0;
    }

    public boolean isPlantingFlower() {
        return this.flagManager.getFlag(1 << 4);
    }

    public void setPlantingFlower(boolean value) {
        this.flagManager.setFlag(1 << 4, value);
    }

    public boolean wantsToPlantFlower() {
        return this.wasGivenFlower() && this.hasEnoughNectarPoints();
    }

    public boolean canPlantFlower() {
        return this.ticksSincePlantedFlower >= 2400;
    }

    public void resetTicksSincePlantedFlower() {
        this.ticksSincePlantedFlower = 0;
    }

    public boolean isFlowerValid(BlockPos pos) {
        return this.level().isLoaded(pos) && this.level().getBlockState(pos).is(BlockTags.FLOWERS);
    }

    public boolean isBusy() {
        return this.isPollinating() || this.isPlantingFlower();
    }

    public boolean hasNectar() {
        return this.flagManager.getFlag(1 << 5);
    }

    public void setHasNectar(boolean value) {
        this.flagManager.setFlag(1 << 5, value);
    }

    public int getNectarPoints() {
        return this.nectarPoints;
    }

    public boolean hasEnoughNectarPoints() {
        return this.nectarPoints > 0;
    }

    public void dropOffNectar() {
        this.nectarPoints = 0;
        this.setHasNectar(false);
        this.resetTicksSincePollinated();
    }

    @Override
    protected PathNavigation createNavigation(Level level) {
        FlyingPathNavigation navigation = new FlyingPathNavigation(this, level) {
            @Override
            public boolean isStableDestination(BlockPos pos) {
                return !this.level.getBlockState(pos.below()).isAir();
            }

            @Override
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

    @Override
    protected void checkFallDamage(double amount, boolean immune, BlockState state, BlockPos pos) {
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader level) {
        return level.getBlockState(pos).isAir() ? 10.0F : 0.0F;
    }

    @Override
    public boolean isFlying() {
        return !this.onGround();
    }

    private Optional<BlockPos> findNearestBlock(BiPredicate<BlockPos, BlockState> predicate, double distance) {
        BlockPos pos = this.blockPosition();
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        for (int i = 0; (double)i < distance; i++) {
            for (int yOffset = 0; (double)yOffset <= distance; yOffset = yOffset > 0 ? -yOffset : 1 - yOffset) {
                for (int xOffset = 0; xOffset <= i; xOffset = xOffset > 0 ? -xOffset : 1 - xOffset) {
                    for (int zOffset = xOffset < i && xOffset > -i ? i : 0; zOffset <= i; zOffset = zOffset > 0 ? -zOffset : 1 - zOffset) {
                        mutablePos.setWithOffset(pos, xOffset, yOffset - 1, zOffset);

                        if (this.isCloserThan(mutablePos, distance) && predicate.test(mutablePos, this.level().getBlockState(mutablePos))) {
                            return Optional.of(mutablePos);
                        }
                    }
                }
            }
        }
        return Optional.empty();
    }

    private void pathfindRandomlyTowards(BlockPos pos) {
        Vec3 bottomPos = Vec3.atBottomCenterOf(pos);
        int i = 0;
        BlockPos blockPos = this.blockPosition();
        int j = (int)bottomPos.y - blockPos.getY();
        if (j > 2) {
            i = 4;
        } else if (j < -2) {
            i = -4;
        }

        int horizontal = 6;
        int vertical = 8;
        int distance = blockPos.distManhattan(pos);
        if (distance < 15) {
            horizontal = distance / 2;
            vertical = distance / 2;
        }

        Vec3 towardsPos = AirRandomPos.getPosTowards(this, horizontal, vertical, i, bottomPos, (float)Math.PI / 10F);
        if (towardsPos != null) {
            this.navigation.setMaxVisitedNodesMultiplier(0.5F);
            this.navigation.moveTo(towardsPos.x, towardsPos.y, towardsPos.z, 1.0D);
        }
    }

    private boolean pathfindDirectlyTowards(BlockPos pos, double speed) {
        this.navigation.setMaxVisitedNodesMultiplier(10.0F);
        this.navigation.moveTo(pos.getX(), pos.getY(), pos.getZ(), speed);
        return this.navigation.getPath() != null && this.navigation.getPath().canReach();
    }

    private boolean hasReachedTarget(BlockPos pos) {
        if (this.isCloserThan(pos, 2.0D)) {
            return true;
        } else {
            Path path = this.navigation.getPath();
            return path != null && path.getTarget().equals(pos) && path.canReach() && path.isDone();
        }
    }

    private boolean isTooFarAway(BlockPos pos) {
        return !this.isCloserThan(pos, 32.0D);
    }

    private boolean isCloserThan(BlockPos pos, double distance) {
        return pos.closerThan(this.blockPosition(), distance);
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
                    this.getNavigation().stop();
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

    public static class LocateNestGoal extends Goal {
        private final Butterfly butterfly;

        public LocateNestGoal(Butterfly mob) {
            this.butterfly = mob;
        }
        
        @Override
        public boolean canUse() {
            return this.butterfly.ticksBeforeLocatingNest == 0 && this.butterfly.nestPos == null && this.butterfly.wantsToEnterNest();
        }

        @Override
        public boolean canContinueToUse() {
            return false;
        }

        @Override
        public void start() {
            this.butterfly.ticksBeforeLocatingNest = 200;

            List<BlockPos> list = this.findNearbyNestsWithSpace();
            if (!list.isEmpty()) {
                for (BlockPos pos : list) {
                    this.butterfly.setNestPos(pos);
                    return;
                }

                this.butterfly.setNestPos(list.get(0));
            }
        }
        
        private List<BlockPos> findNearbyNestsWithSpace() {
            BlockPos pos = this.butterfly.blockPosition();
            PoiManager poiManager = ((ServerLevel)this.butterfly.level()).getPoiManager();
            Stream<PoiRecord> poiStream = poiManager.getInRange((holder) -> holder.is(MysticPoiTypes.BUTTERFLY_NEST.getId()), pos, 20, PoiManager.Occupancy.ANY);
            return poiStream.map(PoiRecord::getPos).filter(this.butterfly::doesNestHaveSpace).sorted(Comparator.comparingDouble((pos1) -> pos1.distSqr(pos))).collect(Collectors.toList());
        }
    }

    public static class GoToNestGoal extends Goal {
        private final Butterfly butterfly;
        @Nullable
        private Path lastPath;

        public GoToNestGoal(Butterfly mob) {
            this.butterfly = mob;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            if (this.butterfly.hasNectar() && this.butterfly.wasGivenFlower() && !this.butterfly.level().isRainingAt(this.butterfly.blockPosition())) {
                return false;
            }

            return this.butterfly.nestPos != null && this.butterfly.wantsToEnterNest() && !this.butterfly.hasReachedTarget(this.butterfly.nestPos)  && this.butterfly.level().getBlockState(this.butterfly.nestPos).is(MysticBlocks.BUTTERFLY_NEST.get());
        }

        @Override
        public void stop() {
            this.butterfly.getNavigation().resetMaxVisitedNodesMultiplier();
            this.butterfly.getNavigation().stop();
        }

        @Override
        public void tick() {
            if (this.butterfly.nestPos != null && !this.butterfly.getNavigation().isInProgress()) {
                if (this.butterfly.isCloserThan(this.butterfly.nestPos, 16)) {
                    boolean flag = this.butterfly.pathfindDirectlyTowards(this.butterfly.nestPos, 1.0D);

                    if (flag) {
                        Path path = this.butterfly.getNavigation().getPath();
                        if (this.lastPath != null && path != null && !path.sameAs(this.lastPath)) {
                            this.lastPath = path;
                        }
                    }
                } else {
                    this.butterfly.pathfindRandomlyTowards(this.butterfly.nestPos);
                }
            }
        }
    }

    public static class EnterNestGoal extends Goal {
        private final Butterfly butterfly;

        public EnterNestGoal(Butterfly mob) {
            this.butterfly = mob;
        }

        @Override
        public boolean canUse() {
            if (this.butterfly.nestPos != null && this.butterfly.wantsToEnterNest() && this.butterfly.nestPos.closerToCenterThan(this.butterfly.position(), 2.0D)) {
                BlockEntity entity = this.butterfly.level().getBlockEntity(this.butterfly.nestPos);

                if (entity instanceof ButterflyNestBlockEntity nest) {
                    return !nest.isFull();
                }
            }

            return false;
        }

        @Override
        public boolean canContinueToUse() {
            return false;
        }

        @Override
        public void start() {
            if (this.butterfly.level().isNight()) {
                this.butterfly.setSleeping(true);
            }

            if (this.butterfly.nestPos != null) {
                BlockEntity entity = this.butterfly.level().getBlockEntity(this.butterfly.nestPos);

                if (entity instanceof ButterflyNestBlockEntity nest) {
                    nest.addOccupant(this.butterfly);
                }
            }
        }
    }

    public static class PollinateGoal extends Goal {
        private final Butterfly butterfly;
        private int pollinatingTicks;

        public PollinateGoal(Butterfly mob) {
            this.butterfly = mob;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            if (!this.butterfly.hasNest()) {
                return false;
            } else if (this.butterfly.isBreeding()) {
                return false;
            } else if (this.butterfly.level().isRainingAt(this.butterfly.blockPosition())) {
                return false;
            } else {
                if (this.butterfly.canPollinate()) {
                    if (this.butterfly.wasGivenFlower() || (this.butterfly.wantsToPollinate() && this.butterfly.random.nextInt() < 0.25D)) {
                        Optional<BlockPos> optional = this.findUnoccupiedFlower();
                        if (optional.isPresent()) {
                            this.butterfly.flowerPos = optional.get();
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        @Override
        public boolean canContinueToUse() {
            if (this.butterfly.flowerPos == null) {
                return false;
            } else if (this.butterfly.level().isRainingAt(this.butterfly.blockPosition())) {
                return false;
            } else {
                return !this.hasPollinatedLongEnough();
            }
        }

        @Override
        public void start() {
            this.pollinatingTicks = 0;
        }

        @Override
        public void stop() {
            this.butterfly.setPollinating(false);
            if (this.hasPollinatedLongEnough()) {
                this.butterfly.nectarPoints += 3;
                this.butterfly.setHasNectar(true);
            } else {
                this.butterfly.addParticle(ParticleTypes.ANGRY_VILLAGER);
            }

            /// process stops like normal when the butterfly was not given a flower, but continues if they were.
            if (!this.butterfly.wasGivenFlower()) {
                this.butterfly.flowerPos = null;
                this.butterfly.navigation.stop();
                this.butterfly.ticksSincePollinated = 0;
            }
        }

        @Override
        public void tick() {
            if (this.butterfly.flowerPos != null) {
                if (this.butterfly.hasReachedTarget(this.butterfly.flowerPos)) {
                    ++this.pollinatingTicks;

                    /// pollinating set to true only when they are at the flowers position.
                    this.butterfly.setPollinating(true);
                    this.butterfly.setPollinatingPos(this.butterfly.flowerPos);
                } else {
                    this.butterfly.pathfindDirectlyTowards(this.butterfly.flowerPos, 1.0D);
                }
            }
        }

        private boolean hasPollinatedLongEnough() {
            return this.pollinatingTicks > 400;
        }

        private Optional<BlockPos> findUnoccupiedFlower() {
            Optional<BlockPos> optional = this.findNearbyFlower();
            if (optional.isPresent()) {
                boolean flag = !this.butterfly.level().getEntitiesOfClass(Butterfly.class, this.butterfly.getBoundingBox().inflate(8.0), (nearbyButterfly) -> nearbyButterfly != this.butterfly && nearbyButterfly.isPollinating() && optional.get().equals(nearbyButterfly.flowerPos)).isEmpty();
                return flag ? Optional.empty() : optional;
            }

            return Optional.empty();
        }

        private Optional<BlockPos> findNearbyFlower() {
            boolean flag = this.butterfly.givenFlower == null;
            return this.butterfly.findNearestBlock((pos, state) -> {
                if (flag) {
                    if (state.is(BlockTags.FLOWERS)) {
                        if (state.is(Blocks.SUNFLOWER)) {
                            return state.getValue(DoublePlantBlock.HALF) == DoubleBlockHalf.UPPER;
                        } else {
                            return true;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return state.is(this.butterfly.givenFlower);
                }
            }, flag ? 8.0D : 16.0D);
        }
    }

    public static class PlantFlowerGoal extends Goal {
        private final Butterfly butterfly;
        private final Level level;
        @Nullable
        private BlockPos plantedPos;
        private int ticksPlantingFlower;

        public PlantFlowerGoal(Butterfly mob) {
            this.butterfly = mob;
            this.level = mob.level();
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            if (this.butterfly.level().isRainingAt(this.butterfly.blockPosition())) {
                return false;
            }
            return this.butterfly.canPlantFlower() && this.butterfly.wantsToPlantFlower() && !this.butterfly.isPlantingFlower();
        }

        @Override
        public boolean canContinueToUse() {
            if (this.butterfly.flowerPos == null) {
                return false;
            } else if (this.butterfly.level().isRainingAt(this.butterfly.blockPosition())) {
                return false;
            } else {
                return this.butterfly.hasEnoughNectarPoints() && !this.hasPlantedLongEnough();
            }
        }

        @Override
        public void start() {
            Optional<BlockPos> optional = this.findRandomNearbyPos((pos, state) -> {
                BlockState belowState = this.level.getBlockState(pos.below());
                return state.isAir() || state.canBeReplaced();
            }, 2.0D);

            if (optional.isPresent()) {
                this.plantedPos = optional.get();
                this.ticksPlantingFlower = 0;
            }
        }

        @Override
        public void stop() {
            this.butterfly.setPlantingFlower(false);

            if (!this.butterfly.hasEnoughNectarPoints()) {
                this.plantedPos = null;
                this.butterfly.flowerPos = null;
                this.butterfly.givenFlower = null;
                this.butterfly.setHasNectar(false);
                this.butterfly.setPlantingFlower(false);
                this.butterfly.resetTicksSincePlantedFlower();
                this.butterfly.getNavigation().stop();
            }
        }

        @Override
        public void tick() {
            if (this.plantedPos != null) {
                if (this.butterfly.isCloserThan(this.plantedPos, 1.0D)) {
                    this.butterfly.setPollinatingPos(this.plantedPos);
                    this.butterfly.setPlantingFlower(true);
                    this.ticksPlantingFlower++;
                } else {
                    this.butterfly.pathfindDirectlyTowards(this.plantedPos, 0.4D);
                }

                if (this.hasPlantedLongEnough()) {
                    if (this.butterfly.hasEnoughNectarPoints()) {
                        if (this.plantedPos != null) {
                            if (this.butterfly.givenFlower != null) {
                                if (!this.level.isClientSide()) {
                                    this.level.setBlockAndUpdate(this.plantedPos, this.butterfly.getFlowerState());
                                    this.level.gameEvent(GameEvent.BLOCK_PLACE, this.plantedPos, GameEvent.Context.of(this.butterfly, this.butterfly.getFlowerState()));
                                    this.level.playSound(null, this.plantedPos, SoundEvents.GRASS_PLACE, SoundSource.BLOCKS, 0.7F, 0.9F + this.butterfly.random.nextFloat() * 0.2F);

                                    this.butterfly.nectarPoints -= 1;
                                    this.plantedPos = null;
                                }
                            }
                        }
                    }
                }
            }
        }

        private boolean hasPlantedLongEnough() {
            return this.ticksPlantingFlower > 600; /// 30 seconds.
        }

        /// @return a random empty space near the original flower pos a butterfly can plant a flower at.
        private Optional<BlockPos> findRandomNearbyPos(BiPredicate<BlockPos, BlockState> predicate, double distance) {
            List<BlockPos> list = new ArrayList<>();

            BlockPos initialPos = this.butterfly.flowerPos != null ? this.butterfly.flowerPos : this.butterfly.blockPosition();
            for (int dx = (int)-distance; dx <= distance; dx++) {
                for (int dy = (int)-distance; dy <= distance; dy++) {
                    for (int dz = (int)-distance; dz <= distance; dz++) {
                        BlockPos pos = initialPos.offset(dx, dy, dz);

                        if (predicate.test(pos, this.butterfly.level().getBlockState(pos))) {
                            list.add(pos);
                        }
                    }
                }
            }

            if (!list.isEmpty()) {
                return Optional.of(list.get(this.butterfly.random.nextInt(list.size())));
            } else {
                return Optional.empty();
            }
        }
    }

    public static class BreedingGoal extends Goal {
        private static final TargetingConditions PARTNER_TARGETING = TargetingConditions.forNonCombat().range(8.0).ignoreLineOfSight();
        private final Butterfly butterfly;
        @Nullable
        protected Animal partner;

        public BreedingGoal(Butterfly mob) {
            this.butterfly = mob;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            if (!this.butterfly.hasNest()) {
                return false;
            } else if (!this.butterfly.isInLove()) {
                return false;
            } else {
                this.partner = this.getFreePartner();
                return this.partner != null;
            }
        }

        @Override
        public boolean canContinueToUse() {
            return this.partner != null && this.partner.isAlive() && this.partner.isInLove();
        }

        @Override
        public void start() {
            if (this.partner != null) {
                this.butterfly.partnerUuid = this.partner.getUUID();
                this.butterfly.setBreeding(true);
            }
        }

        @Override
        public void stop() {
            this.partner = null;
        }

        @Override
        public void tick() {
            if (this.butterfly.isBreeding() && this.butterfly.nestPos != null && this.partner != null) {
                if (!this.butterfly.hasReachedTarget(this.butterfly.nestPos)) {
                    this.butterfly.pathfindDirectlyTowards(this.butterfly.nestPos, 1.0D);
                }
            }
        }

        @Nullable
        private Butterfly getFreePartner() {
            List<? extends Butterfly> list = this.butterfly.level().getNearbyEntities(Butterfly.class, PARTNER_TARGETING, this.butterfly, this.butterfly.getBoundingBox().inflate(8.0));
            double distance = Double.MAX_VALUE;
            Butterfly partner = null;

            for (Butterfly nearby : list) {
                if (nearby != this.butterfly) {
                    if (this.butterfly.canMate(nearby) && this.butterfly.distanceToSqr(nearby) < distance) {
                        partner = nearby;
                        distance = this.butterfly.distanceToSqr(nearby);
                    }
                }
            }

            return partner;
        }
    }

    public static class WanderGoal extends Goal {
        private final Butterfly butterfly;

        public WanderGoal(Butterfly mob) {
            this.butterfly = mob;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            return this.butterfly.getNavigation().isDone();
        }

        @Override
        public boolean canContinueToUse() {
            return this.butterfly.getNavigation().isInProgress();
        }

        @Override
        public void start() {
            Vec3 pos = this.findPos();
            if (pos != null) {
                this.butterfly.getNavigation().moveTo(this.butterfly.getNavigation().createPath(BlockPos.containing(pos), 1), 1.0D);
            }
        }

        @Nullable
        private Vec3 findPos() {
            Vec3 pos;
            if (this.butterfly.isNestValid() && this.butterfly.nestPos != null && !this.butterfly.isCloserThan(this.butterfly.nestPos, 22)) {
                Vec3 nestPos = Vec3.atCenterOf(this.butterfly.nestPos);
                pos = nestPos.subtract(this.butterfly.position()).normalize();
            } else {
                pos = this.butterfly.getViewVector(0.0F);
            }

            Vec3 randomPos = HoverRandomPos.getPos(this.butterfly, 8, 7, pos.x, pos.z, ((float)Math.PI / 2F), 3, 1);
            return randomPos != null ? randomPos : AirAndWaterRandomPos.getPos(this.butterfly, 8, 4, -2, pos.x, pos.z, ((float)Math.PI / 2F));
        }
    }

    private static class ButterflyLookControl extends LookControl {
        private final Butterfly butterfly;

        ButterflyLookControl(Butterfly mob) {
            super(mob);
            this.butterfly = mob;
        }

        @Override
        protected boolean resetXRotOnTick() {
            return !this.butterfly.isPollinating() || !this.butterfly.isPlantingFlower();
        }
    }

    public enum Type implements StringRepresentable {
        MONARCH(0, "monarch"),
        MORPHO(1, "morpho"),
        LUNA_MOTH(2, "luna_moth");

        private final int id;
        private final String name;

        Type(final int id, final String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return this.id;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }

        public static Type byId(int id) {
            return ByIdMap.continuous(Type::getId, values(), ByIdMap.OutOfBoundsStrategy.ZERO).apply(id);
        }

        public static Type byName(String name) {
            return StringRepresentable.fromEnum(Type::values).byName(name, Type.MONARCH);
        }

        public static Type getRandom(RandomSource random) {
            return byId(random.nextInt(values().length));
        }
    }

}