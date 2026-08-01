package com.mysticsbiomes.common.block.property;

import net.minecraft.util.StringRepresentable;

/**
 * speed tier property based on a plants environmental temperature & light amount.
 */
public enum GrowthSpeedTierProperty implements StringRepresentable {
    TIER_1("tier_1", 350, 0.0F, 0.5F), /// frozen
    TIER_2("tier_2", 300, 0.5F, 0.8F), /// cold
    TIER_3("tier_3", 250, 0.8F, 1.5F), /// temperate
    TIER_4("tier_4", 100, 1.5F, 1.8F), /// warm
    TIER_5("tier_5", 50, 1.8F, 2.0F);  /// hot

    private final String name;
    private final int growthChance;
    private final float minTemperature;
    private final float maxTemperature;

    GrowthSpeedTierProperty(String name, int growthChance, float minTemperature, float maxTemperature) {
        this.name = name;
        this.growthChance = growthChance;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }

    public int growthChance() {
        return this.growthChance;
    }

    public static GrowthSpeedTierProperty fromTemperature(float temperature) {
        for (GrowthSpeedTierProperty tier : values()) {
            if (tier.matches(temperature)) {
                return tier;
            }
        }

        return TIER_5;
    }

    public boolean matches(float temperature) {
        return temperature >= this.minTemperature && temperature < this.maxTemperature;
    }

}