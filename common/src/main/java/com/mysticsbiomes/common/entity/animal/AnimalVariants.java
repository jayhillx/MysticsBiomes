package com.mysticsbiomes.common.entity.animal;

import net.minecraft.util.StringRepresentable;

public enum AnimalVariants implements StringRepresentable {
    STANDARD("standard"),
    VARIANT("variant");

    public final String type;

    AnimalVariants(String type) {
        this.type = type;
    }

    @Override
    public String getSerializedName() {
        return this.type;
    }

    static AnimalVariants byType(String type) {
        return StringRepresentable.fromEnum(AnimalVariants::values).byName(type, STANDARD);
    }

}