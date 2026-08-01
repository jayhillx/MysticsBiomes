package com.mysticsbiomes.common.item;

import api.mystanica.registry.RegistryEntry;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public class MysticSpawnEggItem extends SpawnEggItem {
    public static final List<MysticSpawnEggItem> MOD_EGGS = new ArrayList<>();
    public static final Map<EntityType<? extends Mob>, MysticSpawnEggItem> TYPE_MAP = new IdentityHashMap<>();
    private final RegistryEntry<? extends EntityType<? extends Mob>> entityType;
    private static final DispenseItemBehavior DEFAULT_DISPENSE_BEHAVIOR = (source, stack) -> {
        Direction face = source.getBlockState().getValue(DispenserBlock.FACING);
        EntityType<?> type = ((SpawnEggItem)stack.getItem()).getType(stack.getTag());

        try {
            type.spawn(source.getLevel(), stack, null, source.getPos().relative(face), MobSpawnType.DISPENSER, face != Direction.UP, false);
        } catch (Exception exception) {
            DispenseItemBehavior.LOGGER.error("Error while dispensing spawn egg from dispenser at {}", source.getPos(), exception);
            return ItemStack.EMPTY;
        }

        stack.shrink(1);
        source.getLevel().gameEvent(GameEvent.ENTITY_PLACE, source.getPos(), GameEvent.Context.of(source.getBlockState()));
        return stack;
    };

    public MysticSpawnEggItem(RegistryEntry<? extends EntityType<? extends Mob>> entityType, int backgroundColor, int dotColor, Properties properties) {
        super(null, backgroundColor, dotColor, properties);
        this.entityType = entityType;

        MOD_EGGS.add(this);
    }

    @Override
    public EntityType<?> getType(CompoundTag tag) {
        return this.entityType.get();
    }

    @Override
    public FeatureFlagSet requiredFeatures() {
        return this.entityType.get().requiredFeatures();
    }

    @Nullable
    protected DispenseItemBehavior defaultDispenseBehavior() {
        return DEFAULT_DISPENSE_BEHAVIOR;
    }

    public static void registerDispenserBehavior() {
        MysticSpawnEggItem.MOD_EGGS.forEach((eggItem) -> {
            DispenseItemBehavior behavior = eggItem.defaultDispenseBehavior();
            if (behavior != null) {
                DispenserBlock.registerBehavior(eggItem, behavior);
            }

            MysticSpawnEggItem.TYPE_MAP.put(eggItem.entityType.get(), eggItem);
        });
    }

}