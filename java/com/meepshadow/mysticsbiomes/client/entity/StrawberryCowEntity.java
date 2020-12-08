package com.meepshadow.mysticsbiomes.client.entity;

import java.util.UUID;

import com.meepshadow.mysticsbiomes.core.registry.ModBlocks;
import com.meepshadow.mysticsbiomes.core.registry.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.Effect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class StrawberryCowEntity extends AnimalEntity {
    private static final DataParameter<String> STRAWBERRY_COW_TYPE = EntityDataManager.createKey(StrawberryCowEntity.class, DataSerializers.STRING);
    private Effect hasStewEffect;
    private int effectDuration;
    private UUID lightningUUID;

    public StrawberryCowEntity(EntityType<? extends StrawberryCowEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.fromItems(Items.WHEAT), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
    }

    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)0.2F);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_COW_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_COW_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_COW_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
    }

    protected float getSoundVolume() {
        return 0.4F;
    }

    public boolean processInteract(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        if (itemstack.getItem() == Items.BUCKET && !player.abilities.isCreativeMode && !this.isChild()) {
            player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
            itemstack.shrink(1);
            if (itemstack.isEmpty()) {
                player.setHeldItem(hand, new ItemStack(ModItems.STRAWBERRY_MILK_BUCKET.get()));
            } else if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.STRAWBERRY_MILK_BUCKET.get()))) {
                player.dropItem(new ItemStack(ModItems.STRAWBERRY_MILK_BUCKET.get()), false);
            }

            return true;
        } else {
            return super.processInteract(player, hand);
        }
    }

    public CowEntity createChild(AgeableEntity ageable) {
        return EntityType.COW.create(this.world);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return this.isChild() ? sizeIn.height * 0.95F : 1.3F;
    }

    public void onStruckByLightning(LightningBoltEntity lightningBolt) {
        UUID uuid = lightningBolt.getUniqueID();
        if (!uuid.equals(this.lightningUUID)) {
            this.setStrawberryCowType(this.getStrawberryCowType() == StrawberryCowEntity.Type.RED ? StrawberryCowEntity.Type.PINK : StrawberryCowEntity.Type.RED);
            this.lightningUUID = uuid;
            this.playSound(SoundEvents.ENTITY_MOOSHROOM_CONVERT, 2.0F, 1.0F);
        }

    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(STRAWBERRY_COW_TYPE, StrawberryCowEntity.Type.RED.name);
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putString("Type", this.getStrawberryCowType().name);
        if (this.hasStewEffect != null) {
            compound.putByte("EffectId", (byte)Effect.getId(this.hasStewEffect));
            compound.putInt("EffectDuration", this.effectDuration);
        }
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setStrawberryCowType(StrawberryCowEntity.Type.getTypeByName(compound.getString("Type")));
        if (compound.contains("EffectId", 1)) {
            this.hasStewEffect = Effect.get(compound.getByte("EffectId"));
        }

        if (compound.contains("EffectDuration", 3)) {
            this.effectDuration = compound.getInt("EffectDuration");
        }

    }

    private void setStrawberryCowType(StrawberryCowEntity.Type typeIn) {
        this.dataManager.set(STRAWBERRY_COW_TYPE, typeIn.name);
    }

    public StrawberryCowEntity.Type getStrawberryCowType() {
        return StrawberryCowEntity.Type.getTypeByName(this.dataManager.get(STRAWBERRY_COW_TYPE));
    }

    private StrawberryCowEntity.Type func_213445_a(StrawberryCowEntity p_213445_1_) {
        StrawberryCowEntity.Type strawberrycowentity$type = this.getStrawberryCowType();
        StrawberryCowEntity.Type strawberrycowentity$type1 = p_213445_1_.getStrawberryCowType();
        StrawberryCowEntity.Type strawberrycowentity$type2;
        if (strawberrycowentity$type == strawberrycowentity$type1 && this.rand.nextInt(1024) == 0) {
            strawberrycowentity$type2 = strawberrycowentity$type == StrawberryCowEntity.Type.PINK ? StrawberryCowEntity.Type.RED : StrawberryCowEntity.Type.PINK;
        } else {
            strawberrycowentity$type2 = this.rand.nextBoolean() ? strawberrycowentity$type : strawberrycowentity$type1;
        }

        return strawberrycowentity$type2;
    }

    public static enum Type {
        RED("red", ModBlocks.STRAWBERRY_FLOWER.get().getDefaultState()),
        PINK("pink", ModBlocks.PINK_DAISY_BUSH.get().getDefaultState());

        private final String name;
        private final BlockState renderState;

        private Type(String nameIn, BlockState renderStateIn) {
            this.name = nameIn;
            this.renderState = renderStateIn;
        }

        @OnlyIn(Dist.CLIENT)
        public BlockState getRenderState() {
            return this.renderState;
        }

        private static StrawberryCowEntity.Type getTypeByName(String nameIn) {
            for(StrawberryCowEntity.Type strawberrycowentity$type : values()) {
                if (strawberrycowentity$type.name.equals(nameIn)) {
                    return strawberrycowentity$type;
                }
            }

            return RED;
        }
    }
}
