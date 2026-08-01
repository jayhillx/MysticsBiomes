package com.mysticsbiomes.init;

import com.mysticsbiomes.common.advancement.criteron.CraftedItemTrigger;
import net.minecraft.advancements.CriteriaTriggers;

public class MysticCriteriaTriggers {

    public static final CraftedItemTrigger CRAFTED_ITEMS = new CraftedItemTrigger();
    ///public static final MischievousThiefTrigger MISCHIEVOUS_THIEF = new MischievousThiefTrigger();

    public static void registerCriteriaTriggers() {
        CriteriaTriggers.register(CRAFTED_ITEMS);
        ///CriteriaTriggers.register(MISCHIEVOUS_THIEF);
    }

}