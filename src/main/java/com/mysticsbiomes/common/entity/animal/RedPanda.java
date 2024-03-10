package com.mysticsbiomes.common.entity.animal;

import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticEntities;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.InventoryCarrier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RedPanda extends Animal implements InventoryCarrier {
    private static final EntityDataAccessor<Byte> DATA_TRAIT_ID = SynchedEntityData.defineId(RedPanda.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Byte> DATA_HIDDEN_TRAIT_ID = SynchedEntityData.defineId(RedPanda.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Byte> DATA_QUIRK_ID = SynchedEntityData.defineId(RedPanda.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(RedPanda.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Optional<UUID>> DATA_TRUSTED_ID = SynchedEntityData.defineId(RedPanda.class, EntityDataSerializers.OPTIONAL_UUID);
    private final SimpleContainer inventory = new SimpleContainer(1);

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState sleepingAnimationState = new AnimationState();

    public RedPanda(EntityType<? extends RedPanda> type, Level level) {
        super(type, level);
        this.moveControl = new RedPandaMoveControl();
        this.lookControl = new RedPandaLookControl();
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_TRAIT_ID, (byte)0);
        this.entityData.define(DATA_HIDDEN_TRAIT_ID, (byte)0);
        this.entityData.define(DATA_QUIRK_ID, (byte)0);
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
        this.entityData.define(DATA_TRUSTED_ID, Optional.empty());
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 2.0));
        this.goalSelector.addGoal(1, new RedPandaBreedGoal(1.0));
        this.goalSelector.addGoal(1, new RedPanda.ReturnItemGoal());
        this.goalSelector.addGoal(2, new RedPandaBreedGoal(1.0));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.0, Ingredient.of(Blocks.BAMBOO.asItem()), false));
        this.goalSelector.addGoal(4, new AvoidEntityGoal<>(this, Player.class, 6.0F, 1.6, 2.5, (entity) -> {
            boolean flag = EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(entity) && !this.trusts(entity.getUUID()) && entity.isSprinting();
            this.setSprinting(flag);
            return flag;
        }));
        this.goalSelector.addGoal(5, new SleepGoal());
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(8, new FollowParentGoal(this, 1.25));
        this.goalSelector.addGoal(9, new WaterAvoidingRandomStrollGoal(this, 1.0));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.125F).add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.FOLLOW_RANGE, 32.0D).add(Attributes.ATTACK_DAMAGE, 8.0D);
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor accessor, DifficultyInstance instance, MobSpawnType type, @Nullable SpawnGroupData data, @Nullable CompoundTag tag) {
        return super.finalizeSpawn(accessor, instance, type, data, tag);
    }

    @Nullable
    public RedPanda getBreedOffspring(ServerLevel level, AgeableMob mob) {
        RedPanda redPanda = MysticEntities.RED_PANDA.get().create(level);
        if (redPanda != null) {
            redPanda.setTrait(this.random.nextBoolean() ? this.getVariant() : ((RedPanda)mob).getVariant());
        }
        return redPanda;
    }

    protected void onOffspringSpawnedFromEgg(Player player, Mob mob) {
        ((RedPanda)mob).addTrustedPlayer(player.getUUID());
    }

    protected float getStandingEyeHeight(Pose pose, EntityDimensions dimensions) {
        return this.isBaby() ? dimensions.height * 0.85F : 0.4F;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putString("Trait", this.getTrait().getSerializedName());
        tag.putString("HiddenTrait", this.getHiddenTrait().getSerializedName());
        tag.putString("Quirk", this.getQuirk().getSerializedName());
        tag.putBoolean("Sleeping", this.isSleeping());

        if (this.getTrustedPlayer() != null) {
            tag.put("Trusted", NbtUtils.createUUID(this.getTrustedPlayer()));
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setTrait(Trait.byName(tag.getString("Trait")));
        this.setHiddenTrait(Trait.byName(tag.getString("HiddenTrait")));
        this.setQuirk(Quirk.byName(tag.getString("Quirk")));
        this.setSleeping(tag.getBoolean("Sleeping"));

        if (tag.contains("Trusted")) {
            this.addTrustedPlayer(NbtUtils.loadUUID(tag.get("Trusted")));
        }
    }

    @Override
    public SimpleContainer getInventory() {
        return this.inventory;
    }

    public Trait getTrait() {
        return Trait.byId(this.entityData.get(DATA_TRAIT_ID));
    }

    public void setTrait(Trait trait) {
        this.entityData.set(DATA_TRAIT_ID, (byte)trait.getId());
    }

    public Trait getHiddenTrait() {
        return Trait.byId(this.entityData.get(DATA_HIDDEN_TRAIT_ID));
    }

    public void setHiddenTrait(Trait trait) {
        this.entityData.set(DATA_HIDDEN_TRAIT_ID, (byte)trait.getId());
    }

    public Trait getVariant() {
        return Trait.getTraitFromGenes(this.getTrait(), this.getHiddenTrait());
    }

    public boolean isClumsy() {
        return this.getTrait() == Trait.CLUMSY;
    }

    public boolean isGloomy() {
        return this.getTrait() == Trait.GLOOMY;
    }

    public boolean isWeak() {
        return this.getTrait() == Trait.WEAK;
    }

    public boolean isPlayful() {
        return this.getTrait() == Trait.PLAYFUL;
    }

    public boolean isCherry() {
        return this.getTrait() == Trait.CHERRY;
    }

    public Quirk getQuirk() {
        return Quirk.byId(this.entityData.get(DATA_QUIRK_ID));
    }

    public void setQuirk(Quirk trait) {
        this.entityData.set(DATA_QUIRK_ID, (byte)trait.getId());
    }

    public boolean lovesSnow() {
        return this.getQuirk() == Quirk.LOVES_SNOW;
    }

    public boolean isLoyal() {
        return this.getQuirk() == Quirk.LOYAL;
    }

    public boolean isMischievous() {
        return this.getQuirk() == Quirk.MISCHIEVOUS;
    }

    public boolean isCurious() {
        return this.getQuirk() == Quirk.CURIOUS;
    }

    public boolean isClingy() {
        return this.getQuirk() == Quirk.CLINGY;
    }

    ///////////////////////////////////////////////////////////////

    public boolean isSleeping() {
        return this.getFlag(2);
    }

    public void setSleeping(boolean sleeping) {
        this.setFlag(2, sleeping);
    }

    public void wakeUp() {
        this.setSleeping(false);
    }

    private boolean getFlag(int value) {
        return (this.entityData.get(DATA_FLAGS_ID) & value) != 0;
    }

    private void setFlag(int value, boolean b) {
        if (b) {
            this.entityData.set(DATA_FLAGS_ID, (byte)(this.entityData.get(DATA_FLAGS_ID) | value));
        } else {
            this.entityData.set(DATA_FLAGS_ID, (byte)(this.entityData.get(DATA_FLAGS_ID) & ~value));
        }
    }

    ///////////////////////////////////////////////////////////////

    private UUID getTrustedPlayer() {
        return this.entityData.get(DATA_TRUSTED_ID).orElse(null);
    }

    private void addTrustedPlayer(UUID uuid) {
        this.entityData.set(DATA_TRUSTED_ID, Optional.ofNullable(uuid));
    }

    private boolean trusts(UUID uuid) {
        return this.getTrustedPlayer() == uuid;
    }

    ///////////////////////////////////////////////////////////////

    @Override
    public void tick() {
        super.tick();
        if (this.isEffectiveAi()) {
            if (this.isInWater() && this.isSleeping()) {
                this.setSleeping(false);
            }
        }

        if (this.level().isClientSide()) {
            if (this.isSleeping()) {
                this.sleepingAnimationState.start(this.tickCount);
            } else {
                this.idleAnimationState.animateWhen(!this.walkAnimation.isMoving(), this.tickCount);
            }
        }
    }

    @Override
    public void aiStep() {
        if (this.isSleeping() || this.isImmobile()) {
            this.jumping = false;
            this.xxa = 0.0F;
            this.zza = 0.0F;
        }

        super.aiStep();
    }

    ///////////////////////////////////////////////////////////////

    public boolean isFood(ItemStack stack) {
        return stack.is(Items.BAMBOO) || stack.is(MysticItems.SPRING_BAMBOO.get());
    }

    public boolean hurt(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else {
            if (!this.level().isClientSide) {
                this.wakeUp();
            }

            return super.hurt(source, amount);
        }
    }

    ///////////////////////////////////////////////////////////////

    class SleepGoal extends Goal {

        public boolean canUse() {
            return RedPanda.this.level().isNight();
        }

        public boolean canContinueToUse() {
            return !RedPanda.this.isInWater();
        }

        public void start() {
            RedPanda.this.setSleeping(true);
        }

        public void stop() {
            RedPanda.this.wakeUp();
        }
    }

    class ReturnItemGoal extends Goal {

        public boolean canUse() {
            if (RedPanda.this.isLoyal() && RedPanda.this.getTrustedPlayer() != null) {
                return this.canPickUpNearbyItem();
            } else {
                return false;
            }
        }

        public boolean canContinueToUse() {
            return RedPanda.this.hasItemInSlot(EquipmentSlot.MAINHAND) && RedPanda.this.navigation.getPath() != null && !RedPanda.this.navigation.getPath().isDone();
        }

        public void start() {
            Player trustedPlayer = RedPanda.this.level().getPlayerByUUID(RedPanda.this.getTrustedPlayer());
            if (!RedPanda.this.inventory.isEmpty() && trustedPlayer != null) {
                RedPanda.this.navigation.moveTo(RedPanda.this.navigation.createPath(BlockPos.containing(trustedPlayer.position()), 1), 1.0D);
            }
        }

        public void stop() {
            RedPanda.this.dropEquipment();
        }

        public void tick() {
            Player trustedPlayer = RedPanda.this.level().getPlayerByUUID(RedPanda.this.getTrustedPlayer());

            if (this.canPickUpNearbyItem()) {
                RedPanda.this.navigation.moveTo(RedPanda.this.navigation.createPath(BlockPos.containing(trustedPlayer.position()), 1), 1.0D);
            }
        }

        @Nullable
        private ItemEntity getNearbyItem() {
            List<ItemEntity> nearbyItems = RedPanda.this.level().getEntitiesOfClass(ItemEntity.class, RedPanda.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D));
            return !nearbyItems.isEmpty() ? nearbyItems.stream().findFirst().get() : null;
        }

        private boolean canPickUpNearbyItem() {
            if (this.getNearbyItem() != null) {
                return this.getNearbyItem().isAlive() && this.getNearbyItem().getOwner() != null && this.getNearbyItem().getOwner().getUUID() == RedPanda.this.getTrustedPlayer();
            } else {
                return false;
            }
        }
    }

    ///////////////////////////////////////////////////////////////

    class RedPandaBreedGoal extends BreedGoal {

        public RedPandaBreedGoal(double speed) {
            super(RedPanda.this, speed);
        }

        public boolean canUse() {
            return super.canUse() && this.canFindBamboo();
        }

        @Override
        protected void breed() {
            ServerLevel level = (ServerLevel)this.level;
            RedPanda redPanda = (RedPanda)this.animal.getBreedOffspring(level, this.partner);
            BabyEntitySpawnEvent event = new BabyEntitySpawnEvent(this.animal, this.partner, redPanda);
            redPanda = (RedPanda)event.getChild();
            boolean cancelled = MinecraftForge.EVENT_BUS.post(event);
            if (cancelled) {
                this.animal.setAge(6000);
                this.partner.setAge(6000);
                this.animal.resetLove();
                this.partner.resetLove();
            } else {
                if (redPanda != null) {
                    ServerPlayer causePlayer = this.animal.getLoveCause();
                    ServerPlayer causePlayer2 = this.partner.getLoveCause();
                    ServerPlayer player = causePlayer;
                    if (causePlayer != null) {
                        redPanda.addTrustedPlayer(causePlayer.getUUID());
                    } else {
                        player = causePlayer2;
                    }

                    if (causePlayer2 != null && causePlayer != causePlayer2) {
                        redPanda.addTrustedPlayer(causePlayer2.getUUID());
                    }

                    if (player != null) {
                        player.awardStat(Stats.ANIMALS_BRED);
                        CriteriaTriggers.BRED_ANIMALS.trigger(player, this.animal, this.partner, redPanda);
                    }

                    this.animal.setAge(6000);
                    this.partner.setAge(6000);
                    this.animal.resetLove();
                    this.partner.resetLove();
                    redPanda.setAge(-24000);
                    redPanda.moveTo(this.animal.getX(), this.animal.getY(), this.animal.getZ(), 0.0F, 0.0F);
                    level.addFreshEntityWithPassengers(redPanda);
                    this.level.broadcastEntityEvent(this.animal, (byte)18);
                    if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
                        this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), this.animal.getRandom().nextInt(7) + 1));
                    }
                }
            }
        }

        private boolean canFindBamboo() {
            BlockPos pos = RedPanda.this.blockPosition();
            BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 8; ++j) {
                    for (int k = 0; k <= j; k = k > 0 ? -k : 1 - k) {
                        for (int l = k < j && k > -j ? j : 0; l <= j; l = l > 0 ? -l : 1 - l) {
                            mutablePos.setWithOffset(pos, k, i, l);
                            BlockState mutableState = this.level.getBlockState(mutablePos);
                            if (mutableState.is(Blocks.BAMBOO) || mutableState.is(MysticBlocks.SPRING_BAMBOO.get())) {
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

        public RedPandaMoveControl() {
            super(RedPanda.this);
        }

        public void tick() {
            if (!RedPanda.this.isSleeping()) {
                super.tick();
            }
        }
    }

    class RedPandaLookControl extends LookControl {

        public RedPandaLookControl() {
            super(RedPanda.this);
        }

        public void tick() {
            if (!RedPanda.this.isSleeping()) {
                super.tick();
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Main personality trait that defines most of a red pandas actions & behaviors.
     */
    public enum Trait implements StringRepresentable {
        NORMAL(0, "normal", false),
        CLUMSY(1, "clumsy", false),
        GLOOMY(2, "gloomy", false),
        WEAK(3, "weak", true),
        LAZY(4, "lazy", false),
        PLAYFUL(5, "playful", false),
        CHERRY(6, "cherry", true);

        private final int id;
        private final String name;
        private final boolean recessive;

        Trait(int id, String name, boolean recessive) {
            this.id = id;
            this.name = name;
            this.recessive = recessive;
        }

        public String getSerializedName() {
            return this.name;
        }

        public int getId() {
            return this.id;
        }

        public boolean isRecessive() {
            return this.recessive;
        }

        public static Trait byName(String name) {
            return StringRepresentable.fromEnum(Trait::values).byName(name, NORMAL);
        }

        public static Trait byId(int id) {
            return ByIdMap.continuous(Trait::getId, values(), ByIdMap.OutOfBoundsStrategy.ZERO).apply(id);
        }

        public static Trait getTraitFromGenes(Trait trait1, Trait trait2) {
            if (trait1.isRecessive()) {
                return trait1 == trait2 ? trait1 : NORMAL;
            } else {
                return trait1;
            }
        }

        public static Trait getRandom(RandomSource source) {
            int i = source.nextInt(16);
            if (i == 0) {
                return CLUMSY;
            } else if (i == 1) {
                return GLOOMY;
            } else if (i == 2) {
                return WEAK;
            } else if (i == 4) {
                return LAZY;
            } else if (i < 9) {
                return PLAYFUL;
            } else {
                return i < 11 ? CHERRY : NORMAL;
            }
        }
    }

    /**
     * Little additions to go with traits; making each red panda more distinct and unique.
     */
    public enum Quirk implements StringRepresentable {
        NONE(0, "none"),
        LOVES_SNOW(1, "loves_snow"),
        LOYAL(2, "loyal"),
        MISCHIEVOUS(3, "mischievous"),
        CURIOUS(4, "curious"),
        CLINGY(5, "clingy");

        private final int id;
        private final String name;

        Quirk(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getSerializedName() {
            return this.name;
        }

        public int getId() {
            return this.id;
        }

        public static Quirk byName(String name) {
            return StringRepresentable.fromEnum(Quirk::values).byName(name, NONE);
        }

        public static Quirk byId(int id) {
            return ByIdMap.continuous(Quirk::getId, values(), ByIdMap.OutOfBoundsStrategy.ZERO).apply(id);
        }

        public static Quirk getRandom(RandomSource source) {
            int i = source.nextInt(16);
            if (i == 0) {
                return LOVES_SNOW;
            } else if (i == 1) {
                return LOYAL;
            } else if (i == 2) {
                return MISCHIEVOUS;
            } else if (i == 4) {
                return CURIOUS;
            } else if (i == 5) {
                return CLINGY;
            } else {
                return NONE;
            }
        }
    }

}