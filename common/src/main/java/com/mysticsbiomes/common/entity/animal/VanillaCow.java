package com.mysticsbiomes.common.entity.animal;

import com.mysticsbiomes.init.MysticEntities;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class VanillaCow extends MysticCow {

    public VanillaCow(EntityType<? extends VanillaCow> entity, Level level) {
        super(entity, level);
    }

    @Override
    public VanillaCow getBreedOffspring(ServerLevel level, AgeableMob mob) {
        VanillaCow baby = MysticEntities.VANILLA_COW.get().create(level);
        if (baby != null) {
            baby.setVariant(this.getOffspringType(mob));
        }

        return baby;
    }

    @Override
    public ItemStack getPickResult() {
        return new ItemStack(MysticItems.VANILLA_COW_SPAWN_EGG.get());
    }

    @Override
    public ItemStack milkBucket() {
        return MysticItems.VANILLA_MILK_BUCKET.get().getDefaultInstance();
    }

    @Override
    public Ingredient temptItems() {
        return Ingredient.of(Items.WHEAT);//, MysticItems.VANILLA_BEANS.get());
    }

}