package com.mysticsbiomes.common.entity.animal;

import com.mysticsbiomes.init.MysticEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.level.Level;

/**
 * Temporarily a simple fox.
 *
 * Red Pandas spawn in the Bamboo Blossom Forest, scouting out bamboo,
 * and stealing items from unsuspecting players!
 */
public class RedPanda extends Fox {

    public RedPanda(EntityType<? extends RedPanda> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.FOLLOW_RANGE, 32.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
    }

    @Override
    public RedPanda getBreedOffspring(ServerLevel level, AgeableMob mob) {
        return MysticEntities.RED_PANDA.get().create(level);
    }

}