package com.mysticsbiomes.common.entity.animal;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.level.Level;

/**
 * Temporarily a simple fox.
 *
 * Red Pandas spawn in the Bamboo Blossom Forest, scouting out bamboo,
 * and stealing items from unsuspecting players!
 */
public class RedPanda extends Fox {

    public RedPanda(EntityType<? extends Fox> type, Level level) {
        super(type, level);
    }

}