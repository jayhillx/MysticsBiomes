package com.mysticsbiomes.common.entity.animal;

import com.mysticsbiomes.init.MysticEntities;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
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

public class StrawberryCow extends Animal {

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

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.2F);
    }

    @Override
    public StrawberryCow getBreedOffspring(ServerLevel level, AgeableMob mob) {
        return MysticEntities.STRAWBERRY_COW.get().create(level);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.COW_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.COW_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.COW_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.COW_STEP, 0.15F, 1.0F);
    }

    protected float getSoundVolume() {
        return 0.4F;
    }

    protected float getStandingEyeHeight(Pose pose, EntityDimensions dimensions) {
        return this.isBaby() ? dimensions.height * 0.95F : 1.3F;
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (stack.is(Items.BUCKET) && !this.isBaby()) {
            player.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);

            ItemStack stack1 = ItemUtils.createFilledResult(stack, player, MysticItems.STRAWBERRY_MILK_BUCKET.get().getDefaultInstance());
            player.setItemInHand(hand, stack1);
            return InteractionResult.sidedSuccess(this.level().isClientSide);
        } else {
            return super.mobInteract(player, hand);
        }
    }

    public boolean isFood(ItemStack stack) {
        return stack.is(Items.WHEAT) || stack.is(MysticItems.STRAWBERRY.get()) || stack.is(MysticItems.SWEET_STRAWBERRY.get());
    }
    
}