package com.mysticsbiomes.common.item;

import com.mysticsbiomes.init.MysticItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class StrawberryJamItem extends HoneyBottleItem {

    public StrawberryJamItem(Properties properties) {
        super(properties);
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (entity instanceof ServerPlayer player) {
            CriteriaTriggers.CONSUME_ITEM.trigger(player, stack);
            player.awardStat(Stats.ITEM_USED.get(this));
        }

        if (!level.isClientSide) {
            entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
            entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 40));
        }

        if (stack.isEmpty()) {
            return new ItemStack(MysticItems.GLASS_JAR.get());
        } else {
            if (entity instanceof Player player && !((Player)entity).getAbilities().instabuild) {
                ItemStack stack1 = new ItemStack(MysticItems.GLASS_JAR.get());
                if (!player.getInventory().add(stack1)) {
                    player.drop(stack1, false);
                }
            }
            return stack;
        }
    }

}