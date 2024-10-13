package com.mysticsbiomes.common.entity;

import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticEntities;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class MysticBoat extends BoatEntity {

    public MysticBoat(EntityType<? extends BoatEntity> type, World level) {
        super(type, level);
        this.intersectionChecked = true;
    }

    public MysticBoat(World level, double x, double y, double z) {
        this(MysticEntities.BOAT, level);
        this.setPosition(x, y, z);
        this.prevX = x;
        this.prevY = y;
        this.prevZ = z;
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(BOAT_TYPE, Type.STRAWBERRY.ordinal());
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putString("Type", getModel().getName());
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        if (nbt.contains("Type", NbtElement.STRING_TYPE)) {
            this.dataTracker.set(BOAT_TYPE, Type.byName(nbt.getString("Type")).ordinal());
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
        return switch (Type.byId(this.dataTracker.get(BOAT_TYPE))) {
            case STRAWBERRY -> MysticItems.STRAWBERRY_BOAT;
            case CHERRY -> MysticItems.CHERRY_BOAT;
            case PEACH -> MysticItems.PEACH_BOAT;
            case MAPLE -> MysticItems.MAPLE_BOAT;
            case SEA_FOAM -> MysticItems.SEA_FOAM_BOAT;
            case TROPICAL -> MysticItems.TROPICAL_BOAT;
            case JACARANDA -> MysticItems.JACARANDA_BOAT;
        };
    }

    public Type getModel() {
        return Type.byId(this.dataTracker.get(BOAT_TYPE));
    }

    public void setModel(Type type) {
        this.dataTracker.set(BOAT_TYPE, type.ordinal());
    }

    public enum Type {
        STRAWBERRY(MysticBlocks.STRAWBERRY_PLANKS, "strawberry"),
        CHERRY(MysticBlocks.CHERRY_PLANKS, "cherry"),
        PEACH(MysticBlocks.PEACH_PLANKS, "peach"),
        MAPLE(MysticBlocks.MAPLE_PLANKS, "maple"),
        SEA_FOAM(MysticBlocks.SEA_FOAM_PLANKS, "sea_foam"),
        TROPICAL(MysticBlocks.TROPICAL_PLANKS, "tropical"),
        JACARANDA(MysticBlocks.JACARANDA_PLANKS, "jacaranda");

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