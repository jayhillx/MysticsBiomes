package com.mysticsbiomes.common.entity.animal;

import com.mysticsbiomes.init.MysticEntities;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
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
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

public class StrawberryCow extends AnimalEntity {
    private static final TrackedData<String> DATA_TYPE_ID = DataTracker.registerData(StrawberryCow.class, TrackedDataHandlerRegistry.STRING);
    
    public StrawberryCow(EntityType<? extends StrawberryCow> entity, World level) {
        super(entity, level);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(DATA_TYPE_ID, Type.PINK.type);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 2.0D));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.0D));
        this.goalSelector.add(3, new TemptGoal(this, 1.25D, Ingredient.ofItems(Items.WHEAT, MysticItems.STRAWBERRY, MysticItems.SWEET_STRAWBERRY), false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.25D));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2D);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound tag) {
        super.writeCustomDataToNbt(tag);
        tag.putString("Type", this.getVariant().asString());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound tag) {
        super.readCustomDataFromNbt(tag);
        this.setVariant(Type.byType(tag.getString("Type")));
    }

    @Override
    public EntityData initialize(ServerWorldAccess accessor, LocalDifficulty instance, SpawnReason type, EntityData data, NbtCompound tag) {
        if (this.random.nextInt(3) == 0) {
            this.setVariant(Type.WHITE);
        } else {
            this.setVariant(Type.PINK);
        }
        return super.initialize(accessor, instance, type, data, tag);
    }

    @Override
    public StrawberryCow createChild(ServerWorld level, PassiveEntity mob) {
        StrawberryCow strawberryCow = MysticEntities.STRAWBERRY_COW.create(level);
        if (strawberryCow != null) {
            strawberryCow.setVariant(this.random.nextBoolean() ? this.getVariant() : ((StrawberryCow)mob).getVariant());
        }
        return strawberryCow;
    }

    public Type getVariant() {
        return Type.byType(this.dataTracker.get(DATA_TYPE_ID));
    }
    
    public void setVariant(Type type) {
        this.dataTracker.set(DATA_TYPE_ID, type.type);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_COW_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_COW_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_COW_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }

    @Override
    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return this.isBaby() ? dimensions.height * 0.95F : 1.3F;
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (stack.isOf(Items.BUCKET) && !this.isBaby()) {
            player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);

            ItemStack stack1 = ItemUsage.exchangeStack(stack, player, MysticItems.STRAWBERRY_MILK_BUCKET.getDefaultStack());
            player.setStackInHand(hand, stack1);
            return ActionResult.success(this.getWorld().isClient);
        } else {
            return super.interactMob(player, hand);
        }
    }
    
    public enum Type implements StringIdentifiable {
        PINK("pink"),
        WHITE("white");

        public static final StringIdentifiable.Codec<Type> CODEC = StringIdentifiable.createCodec(Type::values);
        final String type;

        Type(String type) {
            this.type = type;
        }

        public String asString() {
            return this.type;
        }

        static Type byType(String type) {
            return CODEC.byId(type, PINK);
        }
    }
    
}