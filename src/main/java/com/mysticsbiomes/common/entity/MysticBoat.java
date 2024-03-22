package com.mysticsbiomes.common.entity;

import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticEntities;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;

public class MysticBoat extends Boat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(MysticBoat.class, EntityDataSerializers.INT);

    public MysticBoat(EntityType<? extends Boat> type, Level level) {
        super(type, level);
        this.blocksBuilding = true;
    }

    public MysticBoat(Level level, double x, double y, double z) {
        this(MysticEntities.BOAT.get(), level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE, MysticBoat.Type.STRAWBERRY.ordinal());
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag nbt) {
        nbt.putString("model", getModel().getName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag nbt) {
        if (nbt.contains("model", Tag.TAG_STRING)) {
            this.entityData.set(DATA_ID_TYPE, MysticBoat.Type.byName(nbt.getString("model")).ordinal());
        }
    }

    @Override
    protected void checkFallDamage(double y, boolean onGround, @Nonnull BlockState state, @Nonnull BlockPos pos) {
        this.lastYd = this.getDeltaMovement().y;

        if (!this.isPassenger()) {
            if (onGround) {
                if (this.fallDistance > 3.0F) {
                    if (this.status != Boat.Status.ON_LAND) {
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

    @Override
    public Item getDropItem() {
        return switch (MysticBoat.Type.byId(this.entityData.get(DATA_ID_TYPE))) {
            case STRAWBERRY -> MysticItems.STRAWBERRY_BOAT.get();
            case CHERRY -> MysticItems.CHERRY_BOAT.get();
            case CITRUS -> MysticItems.CITRUS_BOAT.get();
            case JACARANDA -> MysticItems.JACARANDA_BOAT.get();
            case MAPLE -> MysticItems.MAPLE_BOAT.get();
        };
    }

    public MysticBoat.Type getModel() {
        return MysticBoat.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    public void setModel(MysticBoat.Type type) {
        this.entityData.set(DATA_ID_TYPE, type.ordinal());
    }

    public enum Type {
        STRAWBERRY(MysticBlocks.STRAWBERRY_PLANKS.get(), "strawberry"),
        CHERRY(MysticBlocks.CHERRY_PLANKS.get(), "cherry"),
        CITRUS(MysticBlocks.CITRUS_PLANKS.get(), "citrus"),
        JACARANDA(MysticBlocks.JACARANDA_PLANKS.get(), "jacaranda"),
        MAPLE(MysticBlocks.MAPLE_PLANKS.get(), "maple");

        private final String name;
        private final Block planks;

        Type(Block block, String name) {
            this.name = name;
            this.planks = block;
        }

        public String getName() {
            return this.name;
        }

        public Block getPlanks() {
            return this.planks;
        }

        public String toString() {
            return this.name;
        }

        public static Type byId(int id) {
            Type[] types = values();

            if (id < 0 || id >= types.length) {
                id = 0;
            }
            return types[id];
        }

        public static Type byName(String name) {
            Type[] types = values();

            for (Type type : types) {
                if (type.getName().equals(name)) {
                    return type;
                }
            }
            return types[0];
        }
    }

}