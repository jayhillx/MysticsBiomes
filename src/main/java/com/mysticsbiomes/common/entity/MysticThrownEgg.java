package com.mysticsbiomes.common.entity;

import com.mysticsbiomes.common.entity.animal.RainbowChicken;
import com.mysticsbiomes.init.MysticEntities;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class MysticThrownEgg extends ThrowableItemProjectile {

    public MysticThrownEgg(EntityType<? extends MysticThrownEgg> type, Level level) {
        super(type, level);
    }

    public MysticThrownEgg(Level level, LivingEntity entity) {
        super(MysticEntities.RAINBOW_EGG.get(), entity, level);
    }

    public void handleEntityEvent(byte b) {
        if (b == 3) {
            for (int i = 0; i < 8; ++i) {
                this.level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5) * 0.08, ((double)this.random.nextFloat() - 0.5) * 0.08, ((double)this.random.nextFloat() - 0.5) * 0.08);
            }
        }
    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        result.getEntity().hurt(this.damageSources().thrown(this, this.getOwner()), 0.0F);
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide) {
            if (this.random.nextInt(8) == 0) {
                int i = 1;
                if (this.random.nextInt(32) == 0) {
                    i = 4;
                }

                for (int j = 0; j < i; ++j) {
                    RainbowChicken chicken = MysticEntities.RAINBOW_CHICKEN.get().create(this.level());
                    if (chicken != null) {
                        chicken.setVariant(chicken.getVariantByEggColor(this.getItem()));
                        chicken.setAge(-24000);
                        chicken.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                        this.level().addFreshEntity(chicken);
                    }
                }
            }
            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
    }

    @Override
    protected Item getDefaultItem() {
        return MysticItems.PINK_EGG.get();
    }

}