package com.mysticsbiomes.common.entity.animal;

import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticEntities;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.LookControl;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.GameRules;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

public class RedPanda extends AnimalEntity {
    private static final TrackedData<Byte> DATA_TRAIT_ID = DataTracker.registerData(RedPanda.class, TrackedDataHandlerRegistry.BYTE);
    private static final TrackedData<Byte> DATA_HIDDEN_TRAIT_ID = DataTracker.registerData(RedPanda.class, TrackedDataHandlerRegistry.BYTE);
    private static final TrackedData<Byte> DATA_FLAGS_ID = DataTracker.registerData(RedPanda.class, TrackedDataHandlerRegistry.BYTE);
    private static final TrackedData<Optional<UUID>> DATA_TRUSTED_ID = DataTracker.registerData(RedPanda.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);
    private static final Predicate<ItemEntity> ALLOWED_ITEMS = (item) -> {
        ItemStack stack = item.getStack();
        return (stack.isOf(Items.BAMBOO) || stack.isOf(MysticBlocks.SPRING_BAMBOO.asItem()) || stack.isOf(MysticItems.CHERRIES)) && !item.cannotPickup() && item.isAlive();
    };
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState sleepingAnimationState = new AnimationState();
    public final AnimationState eatAnimationState = new AnimationState();

    public RedPanda(EntityType<? extends RedPanda> type, World level) {
        super(type, level);
        this.moveControl = new RedPanda.RedPandaMoveControl(this);
        this.lookControl = new RedPanda.RedPandaLookControl(this);
        if (!this.isBaby()) {
            this.setCanPickUpLoot(true);
        }
    }
    
    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(DATA_TRAIT_ID, (byte)0);
        this.dataTracker.startTracking(DATA_HIDDEN_TRAIT_ID, (byte)0);
        this.dataTracker.startTracking(DATA_FLAGS_ID, (byte)0);
        this.dataTracker.startTracking(DATA_TRUSTED_ID, Optional.empty());
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(0, new RedPanda.RedPandaEscapeDangerGoal(this, 2.0D));
        this.goalSelector.add(1, new RedPanda.SleepGoal());
        this.goalSelector.add(1, new RedPanda.EatBambooGoal());
        this.goalSelector.add(2, new RedPanda.RedPandaAnimalMateGoal(1.0D));
        this.goalSelector.add(3, new TemptGoal(this, 1.0D, Ingredient.ofItems(Blocks.BAMBOO.asItem(), MysticBlocks.SPRING_BAMBOO.asItem()), false));
        this.goalSelector.add(4, new FleeEntityGoal<>(this, PlayerEntity.class, 6.0F, 1.6, 2.5, (entity) -> {
            boolean flag = EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(entity) && !this.trusts(entity.getUuid()) && entity.isSprinting();
            this.setSprinting(flag);
            return flag;
        }));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.goalSelector.add(7, new FollowParentGoal(this, 1.25D));
        this.goalSelector.add(8, new WanderAroundFarGoal(this, 1.0D));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.125F).add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0D).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20.0D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0D);
    }

    @Override
    public RedPanda createChild(ServerWorld level, PassiveEntity mob) {
        RedPanda redPanda = MysticEntities.RED_PANDA.create(level);
        if (redPanda != null) {
            if (mob instanceof RedPanda parent) {
                redPanda.setTraitFromParents(this, parent);
            }
        }
        return redPanda;
    }

    @Override
    public EntityData initialize(ServerWorldAccess accessor, LocalDifficulty instance, SpawnReason type, EntityData data, NbtCompound tag) {
        Random random = accessor.getRandom();
        this.setMainTrait(Trait.getRandom(random));
        this.setHiddenTrait(Trait.getRandom(random));
        if (random.nextInt(6) == 0) {
            this.setStackInHand(Hand.MAIN_HAND, new ItemStack(MysticItems.CHERRIES));
        }
        return super.initialize(accessor, instance, type, data, tag);
    }

    @Override
    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return this.isBaby() ? dimensions.height * 0.85F : 0.4F;
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound tag) {
        super.writeCustomDataToNbt(tag);
        tag.putString("MainTrait", this.getMainTrait().asString());
        tag.putString("HiddenTrait", this.getHiddenTrait().asString());
        tag.putBoolean("Sleeping", this.isSleeping());

        if (this.getTrustedPlayer() != null) {
            tag.put("Trusted", NbtHelper.fromUuid(this.getTrustedPlayer()));
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound tag) {
        super.readCustomDataFromNbt(tag);
        this.setMainTrait(Trait.byName(tag.getString("MainTrait")));
        this.setHiddenTrait(Trait.byName(tag.getString("HiddenTrait")));
        this.setSleeping(tag.getBoolean("Sleeping"));

        if (tag.contains("Trusted")) {
            this.addTrustedPlayer(NbtHelper.toUuid(tag.get("Trusted")));
        }
    }

    public Trait getMainTrait() {
        return Trait.byId(this.dataTracker.get(DATA_TRAIT_ID));
    }

    public void setMainTrait(Trait trait) {
        this.dataTracker.set(DATA_TRAIT_ID, (byte)trait.getId());
    }

    public Trait getHiddenTrait() {
        return Trait.byId(this.dataTracker.get(DATA_HIDDEN_TRAIT_ID));
    }

    public void setHiddenTrait(Trait trait) {
        this.dataTracker.set(DATA_HIDDEN_TRAIT_ID, (byte)trait.getId());
    }

    public void setTraitFromParents(RedPanda parent, RedPanda parent2) {
        if (parent2 == null) {
            if (this.random.nextBoolean()) {
                this.setMainTrait(parent.getOneOfTraitsRandomly());
                this.setHiddenTrait(Trait.getRandom(this.random));
            } else {
                this.setMainTrait(Trait.getRandom(this.random));
                this.setHiddenTrait(parent.getOneOfTraitsRandomly());
            }
        } else if (this.random.nextBoolean()) {
            this.setMainTrait(parent.getOneOfTraitsRandomly());
            this.setHiddenTrait(parent2.getOneOfTraitsRandomly());
        } else {
            this.setMainTrait(parent2.getOneOfTraitsRandomly());
            this.setHiddenTrait(parent.getOneOfTraitsRandomly());
        }

        if (this.random.nextInt(16) == 0) {
            this.setHiddenTrait(Trait.getRandom(this.random));
        }

        if (this.random.nextInt(16) == 0) {
            this.setHiddenTrait(Trait.getRandom(this.random));
        }
    }

    private Trait getOneOfTraitsRandomly() {
        return this.random.nextBoolean() ? this.getMainTrait() : this.getHiddenTrait();
    }

    public Trait getVariant() {
        return Trait.getMainTraitFromGenes(this.getMainTrait(), this.getHiddenTrait());
    }

    @Override
    public boolean isSleeping() {
        return this.getFlag(2);
    }

    public void setSleeping(boolean sleeping) {
        this.setFlag(2, sleeping);
    }

    public void wakeUp() {
        this.setSleeping(false);
    }

    public boolean isEating() {
        return this.getFlag(8);
    }

    public void setEating(boolean eating) {
        this.setFlag(8, eating);
    }

    public boolean getFlag(int value) {
        return (this.dataTracker.get(DATA_FLAGS_ID) & value) != 0;
    }

    public void setFlag(int value, boolean b) {
        if (b) {
            this.dataTracker.set(DATA_FLAGS_ID, (byte)(this.dataTracker.get(DATA_FLAGS_ID) | value));
        } else {
            this.dataTracker.set(DATA_FLAGS_ID, (byte)(this.dataTracker.get(DATA_FLAGS_ID) & ~value));
        }
    }

    private UUID getTrustedPlayer() {
        return this.dataTracker.get(DATA_TRUSTED_ID).orElse(null);
    }

    private void addTrustedPlayer(UUID uuid) {
        this.dataTracker.set(DATA_TRUSTED_ID, Optional.ofNullable(uuid));
    }

    private boolean trusts(UUID uuid) {
        return this.getTrustedPlayer() == uuid;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.canMoveVoluntarily()) {
            if (this.isSubmergedInWater() && this.isSleeping()) {
                this.setSleeping(false);
            }
        }

        if (this.getWorld().isClient()) {
            this.idleAnimationState.setRunning(!this.limbAnimator.isLimbMoving() && !this.isSleeping(), this.age);
            this.sleepingAnimationState.setRunning(!this.limbAnimator.isLimbMoving() && this.isSleeping(), this.age);
            this.eatAnimationState.setRunning(this.isEating(), this.age);

            if (this.isEating()) {
                if (this.age % 20 == 0) {
                    for (int i = 0; i < 3; ++i) {
                        Vec3d vec3 = new Vec3d(((double)RedPanda.this.random.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, ((double)RedPanda.this.random.nextFloat() - 0.5D) * 0.1D);
                        RedPanda.this.getWorld().addParticle(new ItemStackParticleEffect(ParticleTypes.ITEM, RedPanda.this.getMainHandStack()), RedPanda.this.getX(), RedPanda.this.getEyeY() + 0.25F, RedPanda.this.getZ(), vec3.x, vec3.y + 0.05D, vec3.z);
                    }
                }
            }
        }
    }

    @Override
    public void tickMovement() {
        if (this.isSleeping() || this.isImmobile()) {
            this.jumping = false;
        }

        super.tickMovement();
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else {
            if (!this.getWorld().isClient) {
                this.wakeUp();
                this.setEating(false);
            }

            return super.damage(source, amount);
        }
    }

    public boolean isFood(ItemStack stack) {
        return stack.isOf(Items.BAMBOO) || stack.isOf(MysticBlocks.SPRING_BAMBOO.asItem());
    }

    @Override
    public boolean canEquip(ItemStack stack) {
        EquipmentSlot equipmentSlot = MobEntity.getPreferredEquipmentSlot(stack);
        return this.getEquippedStack(equipmentSlot).isEmpty() && equipmentSlot == EquipmentSlot.MAINHAND && super.canEquip(stack);
    }

    @Override
    protected void loot(ItemEntity entity) {
        ItemStack stack = entity.getStack();
        if ((this.getMainHandStack().isEmpty() || !this.getMainHandStack().isOf(MysticBlocks.SPRING_BAMBOO.asItem())) && ALLOWED_ITEMS.test(entity)) {
            this.triggerItemPickedUpByEntityCriteria(entity);

            this.spitOutItem(this.getEquippedStack(EquipmentSlot.MAINHAND));
            this.equipStack(EquipmentSlot.MAINHAND, stack.split(1));
            this.updateDropChances(EquipmentSlot.MAINHAND);
            this.sendPickup(entity, 1);
            entity.discard();
        }
    }

    private void spitOutItem(ItemStack stack) {
        if (!stack.isEmpty() && !this.getWorld().isClient) {
            ItemEntity entity = new ItemEntity(this.getWorld(), this.getX() + this.getRotationVector().x, this.getY() + 1.0D, this.getZ() + this.getRotationVector().z, stack);
            entity.setPickupDelay(40);
            entity.setThrower(this.getUuid());
            this.playSound(SoundEvents.ENTITY_FOX_SPIT, 1.0F, 1.0F);
            this.getWorld().spawnEntity(entity);
        }
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        if (this.isFood(stack)) {
            if (this.isBaby()) {
                this.eat(player, hand, stack);
                this.growUp((int)((float)(-this.getBreedingAge() / 20) * 0.1F), true);
            } else if (!this.getWorld().isClient && this.getBreedingAge() == 0 && this.canEat()) {
                this.eat(player, hand, stack);
                this.lovePlayer(player);
            } else {
                if (this.getWorld().isClient || this.isTouchingWater()) {
                    return ActionResult.PASS;
                }

                this.setForwardSpeed(0.0F);
                this.getNavigation().stop();
                this.setEating(true);
                ItemStack mainHandStack = this.getMainHandStack();
                if (!mainHandStack.isEmpty() && !player.getAbilities().creativeMode) {
                    this.dropStack(mainHandStack);
                }

                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(stack.getItem(), 1));
                this.eat(player, hand, stack);
            }
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.PASS;
        }
    }

    class SleepGoal extends Goal {

        public boolean canStart() {
            return RedPanda.this.getWorld().isNight() && !RedPanda.this.isSubmergedInWater();
        }

        public boolean shouldContinue() {
            return this.canStart();
        }

        public void start() {
            RedPanda.this.setSleeping(true);
        }

        public void stop() {
            RedPanda.this.wakeUp();
        }
    }

    class EatBambooGoal extends Goal {
        private int ticksEating;

        public boolean canStart() {
            return RedPanda.this.isFood(RedPanda.this.getMainHandStack()) && !RedPanda.this.isSleeping() && !RedPanda.this.isSubmergedInWater() && RedPanda.this.random.nextInt(80) == 0;
        }

        public boolean shouldContinue() {
            return this.ticksEating < 100;
        }

        public void start() {
            this.ticksEating = 0;
            RedPanda.this.setEating(true);
            RedPanda.this.navigation.stop();
        }

        public void stop() {
            RedPanda.this.setEating(false);
            RedPanda.this.getMainHandStack().decrement(1);
        }

        public void tick() {
            ++this.ticksEating;
        }
    }

    class RedPandaEscapeDangerGoal extends EscapeDangerGoal {

        public RedPandaEscapeDangerGoal(PathAwareEntity mob, double speed) {
            super(mob, speed);
        }

        @Override
        public void stop() {
            super.stop();

            if (RedPanda.this.getWorld().isNight() && !RedPanda.this.isSubmergedInWater()) {
                RedPanda.this.setSleeping(true);
            }
        }
    }

    class RedPandaAnimalMateGoal extends AnimalMateGoal {

        public RedPandaAnimalMateGoal(double speed) {
            super(RedPanda.this, speed);
        }

        public boolean canStart() {
            return super.canStart() && this.canFindBamboo();
        }

        @Override
        protected void breed() {
            ServerWorld level = (ServerWorld)this.world;
            RedPanda redPanda = (RedPanda)this.animal.createChild(level, this.mate);
            if (this.mate != null) {
                if (redPanda != null) {
                    ServerPlayerEntity causePlayer = this.animal.getLovingPlayer();
                    ServerPlayerEntity causePlayer2 = this.mate.getLovingPlayer();
                    ServerPlayerEntity player = causePlayer;
                    if (causePlayer != null) {
                        redPanda.addTrustedPlayer(causePlayer.getUuid());
                    } else {
                        player = causePlayer2;
                    }

                    if (causePlayer2 != null && causePlayer != causePlayer2) {
                        redPanda.addTrustedPlayer(causePlayer2.getUuid());
                    }

                    if (player != null) {
                        player.incrementStat(Stats.ANIMALS_BRED);
                        Criteria.BRED_ANIMALS.trigger(player, this.animal, this.mate, redPanda);
                    }

                    this.animal.setBreedingAge(6000);
                    this.mate.setBreedingAge(6000);
                    this.animal.resetLoveTicks();
                    this.mate.resetLoveTicks();
                    redPanda.setBreedingAge(-24000);
                    redPanda.refreshPositionAndAngles(this.animal.getX(), this.animal.getY(), this.animal.getZ(), 0.0F, 0.0F);
                    level.spawnEntityAndPassengers(redPanda);
                    this.world.sendEntityStatus(this.animal, EntityStatuses.ADD_BREEDING_PARTICLES);
                    if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
                        this.world.spawnEntity(new ExperienceOrbEntity(this.world, this.animal.getX(), this.animal.getY(), this.animal.getZ(), this.animal.getRandom().nextInt(7) + 1));
                    }
                }
            }
        }

        private boolean canFindBamboo() {
            BlockPos pos = RedPanda.this.getBlockPos();
            BlockPos.Mutable mutablePos = new BlockPos.Mutable();

            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 8; ++j) {
                    for (int k = 0; k <= j; k = k > 0 ? -k : 1 - k) {
                        for (int l = k < j && k > -j ? j : 0; l <= j; l = l > 0 ? -l : 1 - l) {
                            mutablePos.set(pos, k, i, l);
                            BlockState mutableState = this.world.getBlockState(mutablePos);
                            if (mutableState.isOf(Blocks.BAMBOO) || mutableState.isOf(MysticBlocks.SPRING_BAMBOO)) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
    }

    class RedPandaMoveControl extends MoveControl {

        public RedPandaMoveControl(MobEntity mob) {
            super(mob);
        }

        @Override
        public void tick() {
            if (!RedPanda.this.isSleeping() && !RedPanda.this.isEating()) {
                super.tick();
            }
        }
    }

    class RedPandaLookControl extends LookControl {

        public RedPandaLookControl(MobEntity mob) {
            super(mob);
        }

        @Override
        public void tick() {
            if (!RedPanda.this.isSleeping() && !RedPanda.this.isEating()) {
                super.tick();
            }
        }
    }

    public enum Trait implements StringIdentifiable {
        NORMAL(0, "normal", false),
        CLUMSY(1, "clumsy", false),
        WEAK(2, "weak", true),
        LAZY(3, "lazy", false),
        PLAYFUL(4, "playful", false),
        MISCHIEVOUS(5, "mischievous", false),
        CHERRY(6, "cherry", true);

        private final int id;
        private final String name;
        private final boolean recessive;

        Trait(int id, String name, boolean recessive) {
            this.id = id;
            this.name = name;
            this.recessive = recessive;
        }

        public String asString() {
            return this.name;
        }

        public int getId() {
            return this.id;
        }

        public boolean isRecessive() {
            return this.recessive;
        }

        public static Trait byName(String name) {
            return StringIdentifiable.createCodec(Trait::values).byId(name, NORMAL);
        }

        public static Trait byId(int id) {
            return ValueLists.createIdToValueFunction(Trait::getId, values(), ValueLists.OutOfBoundsHandling.ZERO).apply(id);
        }

        public static Trait getMainTraitFromGenes(Trait trait1, Trait trait2) {
            if (trait1.isRecessive()) {
                return trait1 == trait2 ? trait1 : NORMAL;
            } else {
                return trait1;
            }
        }

        public static Trait getRandom(Random source) {
            int i = source.nextInt(8);
            if (i == 0) {
                return CLUMSY;
            } else if (i == 1) {
                return WEAK;
            } else if (i == 2) {
                return LAZY;
            } else if (i == 4) {
                return PLAYFUL;
            } else if (i == 5) {
                return MISCHIEVOUS;
            } else {
                return i == 6 ? CHERRY : NORMAL;
            }
        }
    }

}