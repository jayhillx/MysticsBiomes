package com.mysticsbiomes.common.entity.vehicle;

import com.mysticsbiomes.init.MysticEntities;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;

public class ChestBoat extends net.minecraft.world.entity.vehicle.ChestBoat {

    public ChestBoat(EntityType<? extends ChestBoat> type, Level level) {
        super(type, level);
        this.blocksBuilding = true;
    }

    public ChestBoat(Level level, double x, double y, double z) {
        this(MysticEntities.CHEST_BOAT.get(), level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Nonnull
    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag nbt) {
        nbt.putString("model", getModel().getName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag nbt) {
        if (nbt.contains("model", Tag.TAG_STRING)) {
            this.entityData.set(DATA_ID_TYPE, ChestBoat.Type.byName(nbt.getString("model")).ordinal());
        }
    }

    @Override
    protected void checkFallDamage(double y, boolean onGround, @Nonnull BlockState state, @Nonnull BlockPos pos) {
        this.lastYd = this.getDeltaMovement().y;

        if (!this.isPassenger()) {
            if (onGround) {
                if (this.fallDistance > 3.0F) {
                    if (this.status != Status.ON_LAND) {
                        this.resetFallDistance();
                        return;
                    }

                    this.causeFallDamage(this.fallDistance, 1.0F, this.damageSources().fall());

                    if (!this.level().isClientSide && !this.isRemoved()) {
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
            } else if (!this.level().getFluidState(this.blockPosition().below()).is(FluidTags.WATER) && y < 0.0D) {
                this.fallDistance -= (float)y;
            }
        }
    }

    @Nonnull
    @Override
    public Item getDropItem() {
        return switch (Boat.Type.byId(this.entityData.get(DATA_ID_TYPE))) {
            case STRAWBERRY -> MysticItems.STRAWBERRY_BOAT.get();
            case CHERRY -> MysticItems.CHERRY_BOAT.get();
            case JACARANDA -> MysticItems.JACARANDA_BOAT.get();
        };
    }

    public void setModel(Boat.Type type) {
        this.entityData.set(DATA_ID_TYPE, type.ordinal());
    }

    public Boat.Type getModel() {
        return Boat.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

}