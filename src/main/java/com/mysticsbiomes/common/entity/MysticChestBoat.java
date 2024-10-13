package com.mysticsbiomes.common.entity;

import com.mysticsbiomes.init.MysticEntities;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.entity.vehicle.ChestBoatEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class MysticChestBoat extends ChestBoatEntity {

    public MysticChestBoat(EntityType<? extends ChestBoatEntity> type, World level) {
        super(type, level);
        this.intersectionChecked = true;
    }

    public MysticChestBoat(World level, double x, double y, double z) {
        this(MysticEntities.CHEST_BOAT, level);
        this.setPosition(x, y, z);
        this.prevX = x;
        this.prevY = y;
        this.prevZ = z;
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putString("Type", getModel().getName());
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        if (nbt.contains("Type", NbtElement.STRING_TYPE)) {
            this.dataTracker.set(BOAT_TYPE, MysticBoat.Type.byName(nbt.getString("Type")).ordinal());
        }
    }

    @Override
    protected void fall(double y, boolean onGround, BlockState state, BlockPos pos) {
        this.fallVelocity = this.getVelocity().y;

        if (!this.hasPassengers()) {
            if (onGround) {
                if (this.fallDistance > 3.0F) {
                    if (this.location != BoatEntity.Location.ON_LAND) {
                        this.onLanding();
                        return;
                    }

                    this.handleFallDamage(this.fallDistance, 1.0F, this.getDamageSources().fall());

                    if (!this.getWorld().isClient && !this.isRemoved()) {
                        this.kill();
                        if (this.getWorld().getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
                            for (int i = 0; i < 3; ++i) {
                                this.dropItem(this.getModel().getPlanks());
                            }

                            for (int j = 0; j < 2; ++j) {
                                this.dropItem(Items.STICK);
                            }
                        }
                    }
                }

                this.onLanding();
            } else if (!this.getWorld().getFluidState(this.getBlockPos().down()).isIn(FluidTags.WATER) && y < 0.0D) {
                this.fallDistance -= (float)y;
            }
        }
    }

    @Override
    public Item asItem() {
        return switch (MysticBoat.Type.byId(this.dataTracker.get(BOAT_TYPE))) {
            case STRAWBERRY -> MysticItems.STRAWBERRY_BOAT;
            case CHERRY -> MysticItems.CHERRY_BOAT;
            case PEACH -> MysticItems.PEACH_BOAT;
            case MAPLE -> MysticItems.MAPLE_BOAT;
            case SEA_FOAM -> MysticItems.SEA_FOAM_BOAT;
            case TROPICAL -> MysticItems.TROPICAL_BOAT;
            case JACARANDA -> MysticItems.JACARANDA_BOAT;
        };
    }

    public MysticBoat.Type getModel() {
        return MysticBoat.Type.byId(this.dataTracker.get(BOAT_TYPE));
    }

    public void setModel(MysticBoat.Type type) {
        this.dataTracker.set(BOAT_TYPE, type.ordinal());
    }

}