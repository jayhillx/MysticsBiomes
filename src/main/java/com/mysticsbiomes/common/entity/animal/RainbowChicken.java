package com.mysticsbiomes.common.entity.animal;

import com.mysticsbiomes.init.MysticEntities;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
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
import net.minecraft.world.event.GameEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RainbowChicken extends AnimalEntity {
    private static final TrackedData<Integer> DATA_TYPE_ID = DataTracker.registerData(RainbowChicken.class, TrackedDataHandlerRegistry.INTEGER);
    private static final Ingredient FOOD_ITEMS = Ingredient.ofItems(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS, Items.TORCHFLOWER_SEEDS, Items.PITCHER_POD);
    public float flap;
    public float flapSpeed;
    public float oFlapSpeed;
    public float oFlap;
    public float flapping = 1.0F;
    private float nextFlap = 1.0F;
    public int eggTime;

    public RainbowChicken(EntityType<? extends RainbowChicken> type, World level) {
        super(type, level);
        this.eggTime = this.random.nextInt(6000) + 6000;
        this.setPathfindingPenalty(PathNodeType.WATER, 0.0F);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(DATA_TYPE_ID, 0);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.4));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.0));
        this.goalSelector.add(3, new TemptGoal(this, 1.0, FOOD_ITEMS, false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.1));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 4.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound tag) {
        super.writeCustomDataToNbt(tag);
        tag.putString("Type", this.getVariant().asString());
        tag.putInt("TypeId", this.getVariant().getId());

        tag.putInt("EggLayTime", this.eggTime);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound tag) {
        super.readCustomDataFromNbt(tag);
        this.setVariant(Type.byType(tag.getString("Type")));
        this.setVariant(Type.byId(tag.getInt("TypeId")));

        if (tag.contains("EggLayTime")) {
            this.eggTime = tag.getInt("EggLayTime");
        }
    }

    public Type getVariant() {
        return Type.byId(this.dataTracker.get(DATA_TYPE_ID));
    }

    public void setVariant(Type type) {
        this.dataTracker.set(DATA_TYPE_ID, type.getId());
    }

    @Override
    public RainbowChicken createChild(ServerWorld level, PassiveEntity partner) {
        RainbowChicken baby = MysticEntities.RAINBOW_CHICKEN.create(level);
        if (baby != null) {
            baby.setVariant(this.getOffspringVariant(this, (RainbowChicken)partner));
        }
        return baby;
    }

    /**
     * @return what the offsprings color will be, either one of the parents or a combination of both; secondary colors.
     */
    private Type getOffspringVariant(AnimalEntity parent1, AnimalEntity parent2) {
        final List<Type> colorTypes = new ArrayList<>(); // list of the two colors of breeding chickens.
        colorTypes.add(((RainbowChicken)parent1).getVariant());
        colorTypes.add(((RainbowChicken)parent2).getVariant());

        Type type = this.getWorld().random.nextBoolean() ? colorTypes.get(0) : colorTypes.get(1);
        if (this.getWorld().random.nextInt(6) == 0) {
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
    public EntityData initialize(ServerWorldAccess accessor, LocalDifficulty instance, SpawnReason type, EntityData data, NbtCompound tag) {
        this.setVariant(Type.getRandomVariant(accessor.getRandom()));
        return super.initialize(accessor, instance, type, data, tag);
    }

    @Override
    public Text getName() {
        return Text.translatable("entity.mysticsbiomes.rainbow_chicken." + this.getVariant().type);
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        this.oFlap = this.flap;
        this.oFlapSpeed = this.flapSpeed;
        this.flapSpeed += (this.isOnGround() ? -1.0F : 4.0F) * 0.3F;
        this.flapSpeed = MathHelper.clamp(this.flapSpeed, 0.0F, 1.0F);
        if (!this.isOnGround() && this.flapping < 1.0F) {
            this.flapping = 1.0F;
        }

        this.flapping *= 0.9F;
        Vec3d vec3 = this.getVelocity();
        if (!this.isOnGround() && vec3.y < 0.0) {
            this.setVelocity(vec3.multiply(1.0, 0.6, 1.0));
        }

        this.flap += this.flapping * 2.0F;
        if (!this.getWorld().isClient && this.isAlive() && !this.isBaby() && --this.eggTime <= 0) {
            this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(this.getEggColorByVariant());
            this.emitGameEvent(GameEvent.ENTITY_PLACE);
            this.eggTime = this.random.nextInt(6000) + 6000;
        }
    }

    /**
     * @return egg item based on the chickens' color.
     */
    private Item getEggColorByVariant() {
        return switch (Type.byId(this.dataTracker.get(DATA_TYPE_ID))) {
            case PINK -> MysticItems.PINK_EGG;
            case ORANGE -> MysticItems.ORANGE_EGG;
            case YELLOW -> MysticItems.YELLOW_EGG;
            case LIME -> MysticItems.LIME_EGG;
            case CYAN -> MysticItems.CYAN_EGG;
            case PURPLE -> MysticItems.PURPLE_EGG;
        };
    }

    /**
     * Used to determine the color of the chicken hatched from each colored egg.
     */
    public Type getVariantByEggColor(ItemStack stack) {
        if (stack.getItem() == MysticItems.PINK_EGG) return Type.PINK;
        if (stack.getItem() == MysticItems.ORANGE_EGG) return Type.ORANGE;
        if (stack.getItem() == MysticItems.YELLOW_EGG) return Type.YELLOW;
        if (stack.getItem() == MysticItems.LIME_EGG) return Type.LIME;
        if (stack.getItem() == MysticItems.CYAN_EGG) return Type.CYAN;
        if (stack.getItem() == MysticItems.PURPLE_EGG) return Type.PURPLE;
        else return null;
    }

    @Override
    protected boolean isFlappingWings() {
        return this.speed > this.nextFlap;
    }

    @Override
    protected void addFlapEffects() {
        this.nextFlap = this.speed + this.flapSpeed / 2.0F;
    }

    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return this.isBaby() ? dimensions.height * 0.85F : dimensions.height * 0.92F;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_CHICKEN_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_CHICKEN_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CHICKEN_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);
    }

    public enum Type implements StringIdentifiable {
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

        public String asString() {
            return this.type;
        }

        public static Type byId(int id) {
            return ValueLists.createIdToValueFunction(Type::getId, values(), ValueLists.OutOfBoundsHandling.ZERO).apply(id);
        }

        public static Type byType(String type) {
            return StringIdentifiable.createCodec(Type::values).byId(type, PINK);
        }

        private static Type getRandomVariant(Random random) {
            Type[] types = Arrays.stream(values()).toArray(Type[]::new);
            return Util.getRandom(types, random);
        }
    }
    
}