package com.mysticsbiomes.common.entity.animal;

import com.mysticsbiomes.init.MysticEntities;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.Mth;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import org.apache.commons.compress.utils.Lists;

import javax.annotation.Nonnull;
import java.util.List;

public class RainbowChicken extends Chicken {
    private static final EntityDataAccessor<String> DATA_TYPE = SynchedEntityData.defineId(RainbowChicken.class, EntityDataSerializers.STRING);

    public RainbowChicken(EntityType<? extends Chicken> type, Level level) {
        super(type, level);
        this.eggTime = this.random.nextInt(6000) + 6000;
        this.entityData.define(DATA_TYPE, Type.PINK.type);
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putString("Type", this.getVariant().getSerializedName());
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setVariant(Type.byType(tag.getString("Type")));
    }

    public Type getVariant() {
        return Type.byType(this.entityData.get(DATA_TYPE));
    }

    public void setVariant(Type type) {
        this.entityData.set(DATA_TYPE, type.type);
    }

    @Override
    public RainbowChicken getBreedOffspring(ServerLevel level, AgeableMob partner) {
        RainbowChicken offspring = MysticEntities.RAINBOW_CHICKEN.get().create(level);

        if (offspring != null) {
            offspring.setVariant(this.getOffspringVariant(this, (RainbowChicken)partner));
        }
        return offspring;
    }

    /**
     * @return what the offspring color will be, either one of the parents color or a combination of both; making a new color.
     */
    private Type getOffspringVariant(RainbowChicken parent1, RainbowChicken parent2) {
        List<Type> colorTypes = Lists.newArrayList();
        colorTypes.add(parent1.getVariant());
        colorTypes.add(parent2.getVariant());

        Type type = this.level().random.nextBoolean() ? colorTypes.get(0) : colorTypes.get(1);
        if (this.level().random.nextInt(3) == 0) {
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
        data = super.finalizeSpawn(accessor, instance, type, data, tag);
        this.setVariant(Type.byId(this.random.nextInt(Type.values().length)));
        return data;
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
        if (!this.level().isClientSide && this.isAlive() && !this.isBaby() && !this.isChickenJockey() && --this.eggTime <= 0) {
            this.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.spawnAtLocation(this.getEggColor());
            this.gameEvent(GameEvent.ENTITY_PLACE);
            this.eggTime = this.random.nextInt(6000) + 6000;
        }
    }

    /** @return egg item based on the chickens' color. */
    public Item getEggColor() {
        return switch (Type.byType(this.entityData.get(DATA_TYPE))) {
            case PINK -> MysticItems.PINK_EGG.get();
            case ORANGE -> MysticItems.ORANGE_EGG.get();
            case YELLOW -> MysticItems.YELLOW_EGG.get();
            case LIME -> MysticItems.LIME_EGG.get();
            case CYAN -> MysticItems.CYAN_EGG.get();
            case PURPLE -> MysticItems.PURPLE_EGG.get();
        };
    }

    public Type getVariantByEggColor(ItemStack stack) {
        if (stack.getItem() == MysticItems.PINK_EGG.get()) return Type.PINK;
        if (stack.getItem() == MysticItems.ORANGE_EGG.get()) return Type.ORANGE;
        if (stack.getItem() == MysticItems.YELLOW_EGG.get()) return Type.YELLOW;
        if (stack.getItem() == MysticItems.LIME_EGG.get()) return Type.LIME;
        if (stack.getItem() == MysticItems.CYAN_EGG.get()) return Type.CYAN;
        if (stack.getItem() == MysticItems.PURPLE_EGG.get()) return Type.PURPLE;
        else return null;
    }

    public enum Type implements StringRepresentable {
        PINK(0, "pink"),     // regeneration
        ORANGE(1, "orange"), // fire resistance
        YELLOW(2, "yellow"), // movement speed
        LIME(3, "lime"),     // luck
        CYAN(4, "cyan"),     // water breathing
        PURPLE(5, "purple"); // night vision

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
    }
    
}