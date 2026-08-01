package com.mysticsbiomes.common.block.entity;

import com.mysticsbiomes.common.block.ChrysalisBlock;
import com.mysticsbiomes.common.entity.animal.Butterfly;
import com.mysticsbiomes.init.MysticBlockEntities;
import com.mysticsbiomes.init.MysticEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.Arrays;
import java.util.List;

public class ChrysalisBlockEntity extends BlockEntity {
    private static final List<String> IGNORED_TAGS = Arrays.asList("Air", "ArmorDropChances", "ArmorItems", "Brain", "CanPickUpLoot", "DeathTime", "FallDistance", "FallFlying", "Fire", "HandDropChances", "HandItems", "HurtByTimestamp", "HurtTime", "LeftHanded", "Motion", "NoGravity", "OnGround", "PortalCooldown", "Pos", "Rotation", "Passengers", "Leash");
    private Inhabitant inhabitant;

    public ChrysalisBlockEntity(BlockPos pos, BlockState state) {
        super(MysticBlockEntities.CHRYSALIS.get(), pos, state);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        if (this.inhabitant != null) {
            CompoundTag tag1 = new CompoundTag();
            tag1.put("EntityData", this.inhabitant.entityData.copy());
            tag1.putInt("TicksInChrysalis", this.inhabitant.ticksInChrysalis);
            tag.put("Inhabitant", tag1);
        }
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        if (tag.contains("Inhabitant")) {
            CompoundTag tag1 = tag.getCompound("Inhabitant");
            this.inhabitant = new Inhabitant(tag1.getCompound("EntityData"), tag1.getInt("TicksInChrysalis"));
        }
    }

    public void addInhabitant(Entity entity) {
        CompoundTag tag = new CompoundTag();
        entity.save(tag);
        this.inhabitant = new Inhabitant(tag, 0);
        entity.discard();
        if (this.level != null) {
            this.level.blockEntityChanged(this.worldPosition);
        }
    }

    /** in {@link ChrysalisBlock#getTicker(Level, BlockState, BlockEntityType)} */
    public static void serverTick(Level level, BlockPos pos, BlockState state, ChrysalisBlockEntity chrysalis) {
        Inhabitant inhabitant = chrysalis.inhabitant;
        if (inhabitant != null) {
            if (inhabitant.ticksInChrysalis++ > 24000) { /// 1 in game day
                releaseInhabitant(level, pos, inhabitant);
                setChanged(level, pos, state);
            }
        }
    }

    private static void releaseInhabitant(Level level, BlockPos pos, Inhabitant inhabitant) {
        CompoundTag tag = inhabitant.entityData.copy();

        Entity entity = EntityType.loadEntityRecursive(tag, level, (e) -> {
            Butterfly butterfly = MysticEntities.BUTTERFLY.get().create(level);
            if (butterfly != null) {
                butterfly.load(tag);
            }
            return butterfly;
        });

        if (entity != null) {
            entity.moveTo(pos.getX(), pos.getY(), pos.getZ(), entity.getYRot(), entity.getXRot());
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(entity, level.getBlockState(pos)));
            level.addFreshEntity(entity);
            level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
        }
    }

    static class Inhabitant {
        private final CompoundTag entityData;
        private int ticksInChrysalis;

        Inhabitant(CompoundTag tag, int ticksInChrysalis) {
            IGNORED_TAGS.forEach(tag::remove);
            this.entityData = tag;
            this.ticksInChrysalis = ticksInChrysalis;
        }
    }

}