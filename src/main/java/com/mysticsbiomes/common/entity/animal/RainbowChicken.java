package com.mysticsbiomes.common.entity.animal;

import com.mysticsbiomes.init.MysticEntities;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RainbowChicken extends Animal {
    private static final EntityDataAccessor<Integer> DATA_TYPE_ID = SynchedEntityData.defineId(RainbowChicken.class, EntityDataSerializers.INT);
    private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS, Items.TORCHFLOWER_SEEDS, Items.PITCHER_POD);
    public float flap;
    public float flapSpeed;
    public float oFlapSpeed;
    public float oFlap;
    public float flapping = 1.0F;
    private float nextFlap = 1.0F;
    public int eggTime;

    public RainbowChicken(EntityType<? extends RainbowChicken> type, Level level) {
        super(type, level);
        this.eggTime = this.random.nextInt(6000) + 6000;
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_TYPE_ID, 0);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.4));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.0, FOOD_ITEMS, false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0).add(Attributes.MOVEMENT_SPEED, 0.25);
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putString("Type", this.getVariant().getSerializedName());
        tag.putInt("TypeId", this.getVariant().getId());

        tag.putInt("EggLayTime", this.eggTime);
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setVariant(Type.byType(tag.getString("Type")));
        this.setVariant(Type.byId(tag.getInt("TypeId")));

        if (tag.contains("EggLayTime")) {
            this.eggTime = tag.getInt("EggLayTime");
        }
    }

    public Type getVariant() {
        return Type.byId(this.entityData.get(DATA_TYPE_ID));
    }

    public void setVariant(Type type) {
        this.entityData.set(DATA_TYPE_ID, type.getId());
    }

    @Override
    public RainbowChicken getBreedOffspring(ServerLevel level, AgeableMob partner) {
        RainbowChicken baby = MysticEntities.RAINBOW_CHICKEN.get().create(level);
        baby.setVariant(this.getOffspringVariant(this, (Animal)partner));
        return baby;
    }

    /**
     * @return what the offsprings color will be, either one of the parents or a combination of both; secondary colors.
     */
    private Type getOffspringVariant(Animal parent1, Animal parent2) {
        final List<Type> colorTypes = new ArrayList<>(); // list of the two colors of breeding chickens.
        colorTypes.add(((RainbowChicken)parent1).getVariant());
        colorTypes.add(((RainbowChicken)parent2).getVariant());

        Type type = this.level().random.nextBoolean() ? colorTypes.get(0) : colorTypes.get(1);
        if (this.level().random.nextInt(6) == 0) {
            if (colorTypes.contains(Type.PINK) && colorTypes.contains(Type.YELLOW)) {
                type = Type.ORANGE;
            } else if (colorTypes.contains(Type.YELLOW) && colorTypes.contains(Type.CYAN)) {
                type = Type.LIME;
            } else if (colorTypes.contains(Type.CYAN) && colorTypes.contains(Type.PINK)) {
                type = Type.PURPLE;
            }
        }
        return type;
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor accessor, DifficultyInstance instance, MobSpawnType type, SpawnGroupData data, CompoundTag tag) {
        this.setVariant(Type.getRandomVariant(accessor.getRandom()));
        return super.finalizeSpawn(accessor, instance, type, data, tag);
    }

    @Override
    public Component getName() {
        return Component.translatable("entity.mysticsbiomes.rainbow_chicken." + this.getVariant().type);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.oFlap = this.flap;
        this.oFlapSpeed = this.flapSpeed;
        this.flapSpeed += (this.onGround() ? -1.0F : 4.0F) * 0.3F;
        this.flapSpeed = Mth.clamp(this.flapSpeed, 0.0F, 1.0F);
        if (!this.onGround() && this.flapping < 1.0F) {
            this.flapping = 1.0F;
        }

        this.flapping *= 0.9F;
        Vec3 vec3 = this.getDeltaMovement();
        if (!this.onGround() && vec3.y < 0.0) {
            this.setDeltaMovement(vec3.multiply(1.0, 0.6, 1.0));
        }

        this.flap += this.flapping * 2.0F;
        if (!this.level().isClientSide && this.isAlive() && !this.isBaby() && --this.eggTime <= 0) {
            this.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.spawnAtLocation(this.getEggColorByVariant());
            this.gameEvent(GameEvent.ENTITY_PLACE);
            this.eggTime = this.random.nextInt(6000) + 6000;
        }
    }

    /**
     * @return egg item based on the chickens' color.
     */
    private Item getEggColorByVariant() {
        return switch (Type.byId(this.entityData.get(DATA_TYPE_ID))) {
            case PINK -> MysticItems.PINK_EGG.get();
            case ORANGE -> MysticItems.ORANGE_EGG.get();
            case YELLOW -> MysticItems.YELLOW_EGG.get();
            case LIME -> MysticItems.LIME_EGG.get();
            case CYAN -> MysticItems.CYAN_EGG.get();
            case PURPLE -> MysticItems.PURPLE_EGG.get();
        };
    }

    /**
     * Used to determine the color of the chicken hatched from each colored egg.
     */
    public Type getVariantByEggColor(ItemStack stack) {
        if (stack.getItem() == MysticItems.PINK_EGG.get()) return Type.PINK;
        if (stack.getItem() == MysticItems.ORANGE_EGG.get()) return Type.ORANGE;
        if (stack.getItem() == MysticItems.YELLOW_EGG.get()) return Type.YELLOW;
        if (stack.getItem() == MysticItems.LIME_EGG.get()) return Type.LIME;
        if (stack.getItem() == MysticItems.CYAN_EGG.get()) return Type.CYAN;
        if (stack.getItem() == MysticItems.PURPLE_EGG.get()) return Type.PURPLE;
        else return null;
    }

    public boolean isFood(ItemStack stack) {
        return FOOD_ITEMS.test(stack);
    }

    protected boolean isFlapping() {
        return this.flyDist > this.nextFlap;
    }

    protected void onFlap() {
        this.nextFlap = this.flyDist + this.flapSpeed / 2.0F;
    }

    protected float getStandingEyeHeight(Pose pose, EntityDimensions dimensions) {
        return this.isBaby() ? dimensions.height * 0.85F : dimensions.height * 0.92F;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.CHICKEN_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.CHICKEN_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.CHICKEN_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.CHICKEN_STEP, 0.15F, 1.0F);
    }

    public enum Type implements StringRepresentable {
        PINK(0, "pink"),
        ORANGE(1, "orange"),
        YELLOW(2, "yellow"),
        LIME(3, "lime"),
        CYAN(4, "cyan"),
        PURPLE(5, "purple");

        final int id;
        final String type;

        Type(int id, String type) {
            this.id = id;
            this.type = type;
        }

        public int getId() {
            return this.id;
        }

        @Nonnull
        public String getSerializedName() {
            return this.type;
        }

        public static Type byId(int id) {
            return ByIdMap.continuous(Type::getId, values(), ByIdMap.OutOfBoundsStrategy.ZERO).apply(id);
        }

        public static Type byType(String type) {
            return StringRepresentable.fromEnum(Type::values).byName(type, PINK);
        }

        private static Type getRandomVariant(RandomSource random) {
            Type[] types = Arrays.stream(values()).toArray(Type[]::new);
            return Util.getRandom(types, random);
        }
    }
    
}