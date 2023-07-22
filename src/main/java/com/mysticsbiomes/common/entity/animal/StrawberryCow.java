package com.mysticsbiomes.common.entity.animal;

import com.mysticsbiomes.init.MysticEntities;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class StrawberryCow extends Animal {
    private static final EntityDataAccessor<String> DATA_TYPE = SynchedEntityData.defineId(StrawberryCow.class, EntityDataSerializers.STRING);
    private boolean sweetOffspring;

    public StrawberryCow(EntityType<? extends StrawberryCow> entity, Level level) {
        super(entity, level);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.of(Items.WHEAT, MysticItems.STRAWBERRY.get(), MysticItems.SWEET_STRAWBERRY.get()), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_TYPE, Type.NORMAL.type);
    }

    public void setVariant(Type type) {
        this.entityData.set(DATA_TYPE, type.type);
    }

    public Type getVariant() {
        return Type.byType(this.entityData.get(DATA_TYPE));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);

        if (this.getVariant() != null) {
            tag.putString("Type", this.getVariant().getSerializedName());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);

        if (tag.contains("Type")) {
            this.setVariant(Type.byType(tag.getString("Type")));
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.2F);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.COW_AMBIENT;
    }

    protected SoundEvent getHurtSound(@Nonnull DamageSource source) {
        return SoundEvents.COW_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.COW_DEATH;
    }

    protected void playStepSound(@Nonnull BlockPos pos, @Nonnull BlockState state) {
        this.playSound(SoundEvents.COW_STEP, 0.15F, 1.0F);
    }

    protected float getSoundVolume() {
        return 0.4F;
    }

    public boolean isFood(ItemStack stack) {
        return stack.is(Items.WHEAT) || stack.is(MysticItems.STRAWBERRY.get()) || stack.is(MysticItems.SWEET_STRAWBERRY.get());
    }

    public void tick() {
        super.tick();

        if (this.getVariant() == Type.SWEET) {
            List<Entity> list = this.level().getEntities(this, new AABB(this.getX(), this.getY(), this.getZ(), this.getX() + 2.0D, this.getY() + 2.0D, this.getZ() + 2.0D), Entity::isAlive);

            if (!list.isEmpty()) {
                for (Entity e : list) {
                    if (e instanceof LivingEntity entity) {
                        entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 260, 0, true, true));
                    }
                }
            }
        }
    }

    @Nonnull
    public InteractionResult mobInteract(Player player, @Nonnull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (stack.is(MysticItems.SWEET_STRAWBERRY.get())) {
            this.sweetOffspring = true;
        }

        if (stack.is(Items.BUCKET) && !this.isBaby()) {
            player.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);

            ItemStack stack1 = ItemUtils.createFilledResult(stack, player, MysticItems.STRAWBERRY_MILK_BUCKET.get().getDefaultInstance());
            player.setItemInHand(hand, stack1);
            return InteractionResult.sidedSuccess(this.level().isClientSide);
        } else {
            return super.mobInteract(player, hand);
        }
    }

    @Nullable
    public StrawberryCow getBreedOffspring(@Nonnull ServerLevel level, @Nonnull AgeableMob mob) {
        StrawberryCow cow = MysticEntities.STRAWBERRY_COW.get().create(level);

        if (cow != null) {
            cow.setVariant(this.getOffspringType((StrawberryCow)mob));
        }
        return cow;
    }

    private Type getOffspringType(StrawberryCow cow) {
        Type thisVariant = this.getVariant();
        Type variant = cow.getVariant();
        Type type;
        if (this.sweetOffspring) {
            type = Type.SWEET;
        } else if (thisVariant == variant && this.random.nextInt(1024) == 0) {
            type = thisVariant == Type.SWEET ? Type.NORMAL : Type.SWEET;
        } else {
            type = this.random.nextBoolean() ? thisVariant : variant;
        }
        return type;
    }

    protected float getStandingEyeHeight(@Nonnull Pose pose, @Nonnull EntityDimensions dimensions) {
        return this.isBaby() ? dimensions.height * 0.95F : 1.3F;
    }

    public enum Type implements StringRepresentable {
        NORMAL("normal"),
        SWEET("sweet");

        public static final StringRepresentable.EnumCodec<Type> CODEC = StringRepresentable.fromEnum(Type::values);
        final String type;

        Type(String type) {
            this.type = type;
        }

        @Nonnull
        public String getSerializedName() {
            return this.type;
        }

        static Type byType(String type) {
            return CODEC.byName(type, NORMAL);
        }
    }

}