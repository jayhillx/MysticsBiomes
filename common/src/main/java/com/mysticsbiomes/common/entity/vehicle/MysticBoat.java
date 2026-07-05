package com.mysticsbiomes.common.entity.vehicle;

import com.mysticsbiomes.core.registry.RegistryObject;
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

import java.util.function.Supplier;

public class MysticBoat extends Boat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(MysticBoat.class, EntityDataSerializers.INT);

    public MysticBoat(EntityType<? extends MysticBoat> entityType, Level level) {
        super(entityType, level);
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
        this.entityData.define(DATA_ID_TYPE, Type.STRAWBERRY.ordinal());
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        tag.putString("model", this.getModel().getName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        if (tag.contains("model", Tag.TAG_STRING)) {
            this.entityData.set(DATA_ID_TYPE, Type.byName(tag.getString("model")).ordinal());
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
            } else if (!this.level().getFluidState(this.blockPosition().below()).is(FluidTags.WATER) && fallDistance < 0.0D) {
                this.fallDistance -= (float)fallDistance;
            }
        }
    }

    @Override
    public double getPassengersRidingOffset() {
        return this.getModel() == Type.SPRING ? 0.25D : -0.1D;
    }

    @Override
    public Item getDropItem() {
        return switch (Type.byId(this.entityData.get(DATA_ID_TYPE))) {
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

    public Type getModel() {
        return Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    public void setModel(Type type) {
        this.entityData.set(DATA_ID_TYPE, type.ordinal());
    }

    public enum Type {
        STRAWBERRY(MysticBlocks.STRAWBERRY_PLANKS, "strawberry"),
        BLACK_CHERRY(MysticBlocks.BLACK_CHERRY_PLANKS, "black_cherry"),
        LAVENDER(MysticBlocks.LAVENDER_PLANKS, "lavender"),
        VANILLA(MysticBlocks.VANILLA_PLANKS, "vanilla"),
        PEACH(MysticBlocks.PEACH_PLANKS, "peach"),
        MAPLE(MysticBlocks.MAPLE_PLANKS, "maple"),
        SPRING(MysticBlocks.SPRING_PLANKS, "spring"),
        SEA_FOAM(MysticBlocks.SEA_FOAM_PLANKS, "sea_foam"),
        TROPICAL(MysticBlocks.TROPICAL_PLANKS, "tropical");

        private final RegistryObject<Block> planks;
        private final String name;

        Type(RegistryObject<Block> block, String name) {
            this.name = name;
            this.planks = block;
        }

        public Block getPlanks() {
            return this.planks.get();
        }

        public String getName() {
            return this.name;
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