package com.mysticsbiomes.common.entity;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;

public class EntityFlagManager {
    private final Entity entity;
    private final EntityDataAccessor<Byte> accessor;

    public EntityFlagManager(Entity entity, EntityDataAccessor<Byte> accessor) {
        this.entity = entity;
        this.accessor = accessor;
    }

    public boolean getFlag(int id) {
        return (this.entityData().get(this.accessor) & id) != 0;
    }

    public void setFlag(int id, boolean value) {
        byte flag = this.entityData().get(this.accessor);
        this.entityData().set(this.accessor, value ? (byte)(flag | id) : (byte)(flag & ~id));
    }

    private SynchedEntityData entityData() {
        return this.entity.getEntityData();
    }

}