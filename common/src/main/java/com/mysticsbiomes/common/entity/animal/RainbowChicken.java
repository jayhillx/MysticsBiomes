package com.mysticsbiomes.common.entity.animal;

import com.mysticsbiomes.common.entity.ai.FoodHelper;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;

import java.util.Arrays;
import java.util.List;

public class RainbowChicken extends Animal {
    private static final EntityDataAccessor<String> DATA_COLOR_ID = SynchedEntityData.defineId(RainbowChicken.class, EntityDataSerializers.STRING);
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState fallingAnimationState = new AnimationState();
    public int eggTime = this.random.nextInt(6000) + 6000;

    public RainbowChicken(EntityType<? extends RainbowChicken> entity, Level level) {
        super(entity, level);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0F).add(Attributes.MOVEMENT_SPEED, 0.6F);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 0.6F));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0F));
        this.goalSelector.addGoal(3, new TemptGoal(this, 0.3F, this.food().asIngredient(), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 0.4F));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.2F));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_COLOR_ID, Color.PINK.getSerializedName());
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putString("Color", this.getColor().getSerializedName());
        tag.putInt("ColorId", this.getColor().getId());
        tag.putInt("EggLayTime", this.eggTime);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setColor(Color.byName(tag.getString("Color")));
        this.setColor(Color.byId(tag.getInt("ColorId")));
        this.eggTime = tag.getInt("EggLayTime");
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance instance, MobSpawnType type, SpawnGroupData data, CompoundTag tag) {
        this.setColor(Color.getRandomVariant(level.getRandom()));
        return super.finalizeSpawn(level, instance, type, data, tag);
    }

    @Override
    public RainbowChicken getBreedOffspring(ServerLevel level, AgeableMob mob) {
        RainbowChicken baby = MysticEntities.RAINBOW_CHICKEN.get().create(level);
        if (baby != null) {
            baby.setColor(this.getOffspringColor(this, (RainbowChicken)mob));
        }

        return baby;
    }

    /** @return the offsprings color, either one of the parents or a combination of both; secondary colors. */
    private Color getOffspringColor(RainbowChicken parent1, RainbowChicken parent2) {
        final List<Color> colors = List.of(parent1.getColor(), parent2.getColor());

        Color color = this.random.nextBoolean() ? colors.get(0) : colors.get(colors.size() - 1);
        if (this.random.nextInt(6) == 0) {
            if (colors.contains(Color.PINK) && colors.contains(Color.YELLOW)) {
                color = Color.ORANGE;
            } else if (colors.contains(Color.YELLOW) && colors.contains(Color.CYAN)) {
                color = Color.LIME;
            } else if (colors.contains(Color.CYAN) && colors.contains(Color.PINK)) {
                color = Color.PURPLE;
            }
        }

        return color;
    }

    public Color getColor() {
        return Color.byName(this.entityData.get(DATA_COLOR_ID));
    }

    public void setColor(Color color) {
        this.entityData.set(DATA_COLOR_ID, color.getSerializedName());
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            if (!this.isNoAi()) {
                this.idleAnimationState.animateWhen(!this.walkAnimation.isMoving(), this.tickCount);
                this.fallingAnimationState.animateWhen(!this.onGround(), this.tickCount);
            }
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();

        Vec3 vec3 = this.getDeltaMovement();
        if (!this.onGround() && vec3.y < 0.0) {
            this.setDeltaMovement(vec3.multiply(1.0, 0.6, 1.0));
        }

        if (!this.level().isClientSide() && this.isAlive() && !this.isBaby() && --this.eggTime <= 0) {
            this.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.spawnAtLocation(this.getEggByColor());
            this.gameEvent(GameEvent.ENTITY_PLACE);
            this.eggTime = this.random.nextInt(6000) + 6000;
        }
    }

    /** @return egg item based on the chickens' color. */
    private Item getEggByColor() {
        return switch (Color.byName(this.entityData.get(DATA_COLOR_ID))) {
            case PINK -> MysticItems.PINK_EGG.get();
            case ORANGE -> MysticItems.ORANGE_EGG.get();
            case YELLOW -> MysticItems.YELLOW_EGG.get();
            case LIME -> MysticItems.LIME_EGG.get();
            case CYAN -> MysticItems.CYAN_EGG.get();
            case PURPLE -> MysticItems.PURPLE_EGG.get();
        };
    }

    /** @return the color of the chicken hatched from each colored egg. */
    public Color getColorByEgg(ItemStack stack) {
        if (stack.getItem() == MysticItems.PINK_EGG.get()) return Color.PINK;
        if (stack.getItem() == MysticItems.ORANGE_EGG.get()) return Color.ORANGE;
        if (stack.getItem() == MysticItems.YELLOW_EGG.get()) return Color.YELLOW;
        if (stack.getItem() == MysticItems.LIME_EGG.get()) return Color.LIME;
        if (stack.getItem() == MysticItems.CYAN_EGG.get()) return Color.CYAN;
        if (stack.getItem() == MysticItems.PURPLE_EGG.get()) return Color.PURPLE;
        else return null;
    }

    @Override
    protected float getStandingEyeHeight(Pose pose, EntityDimensions dimensions) {
        return this.isBaby() ? 0.2975F : super.getStandingEyeHeight(pose, dimensions);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.CHICKEN_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.CHICKEN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.CHICKEN_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.CHICKEN_STEP, 0.15F, 1.0F);
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return this.food().test(stack);
    }

    private FoodHelper food() {
        return new FoodHelper().items(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS, Items.TORCHFLOWER_SEEDS, Items.PITCHER_POD);
    }

    @Override
    public Component getName() {
        return Component.translatable("entity.mysticsbiomes.rainbow_chicken." + this.getColor().getSerializedName());
    }

    @Override
    public ItemStack getPickResult() {
        return new ItemStack(MysticItems.RAINBOW_CHICKEN_SPAWN_EGG.get());
    }

    public enum Color implements StringRepresentable {
        PINK(0, "pink"),
        ORANGE(1, "orange"),
        YELLOW(2, "yellow"),
        LIME(3, "lime"),
        CYAN(4, "cyan"),
        PURPLE(5, "purple");
        ///RAINBOW(6, "rainbow");

        private final int id;
        private final String color;

        Color(int id, String color) {
            this.id = id;
            this.color = color;
        }

        public int getId() {
            return this.id;
        }

        @Override
        public String getSerializedName() {
            return this.color;
        }

        public static Color byId(int id) {
            return ByIdMap.continuous(Color::getId, values(), ByIdMap.OutOfBoundsStrategy.ZERO).apply(id);
        }

        public static Color byName(String name) {
            return StringRepresentable.fromEnum(Color::values).byName(name, PINK);
        }

        private static Color getRandomVariant(RandomSource random) {
            Color[] colors = Arrays.stream(values()).toArray(Color[]::new);
            return Util.getRandom(colors, random);
        }
    }

}