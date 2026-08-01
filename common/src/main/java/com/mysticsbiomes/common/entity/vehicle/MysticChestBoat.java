package com.mysticsbiomes.common.entity.vehicle;

import com.mysticsbiomes.init.MysticEntities;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class MysticChestBoat extends ChestBoat {

    public MysticChestBoat(EntityType<? extends MysticChestBoat> entityType, Level level) {
        super(entityType, level);
        this.blocksBuilding = true;
    }

    public MysticChestBoat(Level level, double x, double y, double z) {
        this(MysticEntities.CHEST_BOAT.get(), level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(MysticBoat.DATA_ID_TYPE, MysticBoat.Type.STRAWBERRY.ordinal());
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        tag.putString("Type", this.getModel().getName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        if (tag.contains("Type", Tag.TAG_STRING)) {
            this.setModel(MysticBoat.Type.byName(tag.getString("Type")));
        }
    }

    @Override
    protected void checkFallDamage(double fallDistance, boolean onGround, BlockState state, BlockPos pos) {
        this.lastYd = this.getDeltaMovement().y;

        if (!this.isPassenger()) {
            if (onGround) {
                if (this.fallDistance > 3.0F) {
                    if (this.status != Status.ON_LAND) {
                        this.resetFallDistance();
                        return;
                    }

                    this.causeFallDamage(this.fallDistance, 1.0F, this.damageSources().fall());

                    if (!this.level().isClientSide() && !this.isRemoved()) {
                        this.kill();
                        if (this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                            for (int i = 0; i < 3; ++i) {
                                this.spawnAtLocation(this.getModel().getPlanks());
                            }

                            for (int j = 0; j < 2; ++j) {
                                this.spawnAtLocation(Items.STICK);
                            }
                        }
                    }
                }

                this.resetFallDistance();
            } else if (!this.level().getFluidState(this.blockPosition().below()).is(FluidTags.WATER) && fallDistance < 0.0D) {
                this.fallDistance -= (float)fallDistance;
            }
        }
    }

    @Override
    public double getPassengersRidingOffset() {
        return this.getModel() == MysticBoat.Type.SPRING ? 0.25D : -0.1D;
    }

    @Override
    public Item getDropItem() {
        return switch (MysticBoat.Type.byId(this.entityData.get(MysticBoat.DATA_ID_TYPE))) {
            case STRAWBERRY -> MysticItems.STRAWBERRY_BOAT.get();
            case BLACK_CHERRY -> MysticItems.BLACK_CHERRY_BOAT.get();
            case LAVENDER -> MysticItems.LAVENDER_BOAT.get();
            case VANILLA -> MysticItems.VANILLA_BOAT.get();
            case PEACH -> MysticItems.PEACH_BOAT.get();
            case MAPLE -> MysticItems.MAPLE_BOAT.get();
            case SPRING -> MysticItems.SPRING_RAFT.get();
            case SEA_FOAM -> MysticItems.SEA_FOAM_BOAT.get();
            case TROPICAL -> MysticItems.TROPICAL_BOAT.get();
        };
    }

    public MysticBoat.Type getModel() {
        return MysticBoat.Type.byId(this.entityData.get(MysticBoat.DATA_ID_TYPE));
    }

    public void setModel(MysticBoat.Type type) {
        this.entityData.set(MysticBoat.DATA_ID_TYPE, type.ordinal());
    }

}