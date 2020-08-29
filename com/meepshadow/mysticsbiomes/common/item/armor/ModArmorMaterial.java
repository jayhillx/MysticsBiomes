package com.meepshadow.mysticsbiomes.common.item.armor;

import com.meepshadow.mysticsbiomes.core.MysticsBiomes;
import com.meepshadow.mysticsbiomes.init.ModItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmorMaterial implements IArmorMaterial {

    SERENE_CRYSTAL(MysticsBiomes.MOD_ID + ":serene_crystal", 35, new int[] { 4, 8, 10, 4 }, 16,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, () -> { return Ingredient.fromItems(ModItem.SERENE_CRYSTAL.get());
    }),

    SWEET_CRYSTAL(MysticsBiomes.MOD_ID + ":sweet_crystal", 35, new int[] { 4, 8, 10, 4 }, 16,
    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, () -> { return Ingredient.fromItems(ModItem.SWEET_CRYSTAL.get());
    });

    private static final int[] MAX_DAMAGE_ARRAY = new int[] { 11, 16, 15, 13};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Supplier<Ingredient> repairMaterial;

    private ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }
}
