package com.jayhill.mysticsbiomes.client;

import com.jayhill.mysticsbiomes.init.MysticBlocks;
import com.jayhill.mysticsbiomes.init.MysticEntities;
import com.jayhill.mysticsbiomes.init.MysticItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.UUID;

@SuppressWarnings("all")
public class StrawberryCowEntity extends CowEntity {
    public static final DataParameter<String> STRAWBERRY_COW_TYPE = EntityDataManager.createKey(StrawberryCowEntity.class, DataSerializers.STRING);
    /** Stores the UUID of the most recent lightning bolt to strike. */
    private UUID lightningUUID;

    public StrawberryCowEntity(EntityType<? extends StrawberryCowEntity> type, World world) {
        super(type, world);
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(STRAWBERRY_COW_TYPE, Type.PINK.name);
    }

    /** Used to obtain milk from the entity. */
    @Nonnull
    public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (itemstack.getItem() == Items.BUCKET && !isChild()) {
            ItemStack item = DrinkHelper.fill(itemstack, player, MysticItems.STRAWBERRY_MILK_BUCKET.get().getDefaultInstance());
            player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
            player.setHeldItem(hand, item);

            return ActionResultType.func_233537_a_(world.isRemote);
        } else {
            return super.func_230254_b_(player, hand);
        }
    }

    public StrawberryCowEntity func_241840_a(ServerWorld world, AgeableEntity entity) {
        StrawberryCowEntity strawberryCowEntity = MysticEntities.STRAWBERRY_COW.get().create(world);
        this.setStrawberryCowType(strawberryCowType((StrawberryCowEntity)entity));

        return strawberryCowEntity;
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 10.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.2F);
    }

    public void func_241841_a(ServerWorld world, LightningBoltEntity entity) {
        UUID uuid = entity.getUniqueID();
        
        if (!uuid.equals(lightningUUID)) {
            setStrawberryCowType(this.getStrawberryCowType() == Type.PINK ? Type.WHITE : Type.PINK);
            this.lightningUUID = uuid;
            playSound(SoundEvents.ENTITY_MOOSHROOM_CONVERT, 2.0F, 1.0F);
        }
    }

    private void setStrawberryCowType(Type type) {
        dataManager.set(STRAWBERRY_COW_TYPE, type.name);
    }

    public Type getStrawberryCowType() {
        return Type.getTypeByName(dataManager.get(STRAWBERRY_COW_TYPE));
    }

    private Type strawberryCowType(StrawberryCowEntity entity) {
        Type strawberryCow = this.getStrawberryCowType();
        Type strawberryCowRegular = entity.getStrawberryCowType();
        Type strawberryCowSweet;

        if (strawberryCow == strawberryCowRegular && rand.nextInt(1024) == 0) {
            strawberryCowSweet = strawberryCow == Type.WHITE ? Type.PINK : Type.WHITE;
        } else {
            strawberryCowSweet = rand.nextBoolean() ? strawberryCow : strawberryCowRegular;
        }
        return strawberryCowSweet;
    }

    public enum Type {
        PINK("pink", MysticBlocks.STRAWBERRY_BUSH.get().getDefaultState()),
        WHITE("white", MysticBlocks.STRAWBERRY_BUSH.get().getStateById(3));

        private final String name;
        private final BlockState renderState;

        Type (String nameIn, BlockState renderStateIn) {
            name = nameIn;
            renderState = renderStateIn;
        }

        /** Renders the blockstate on top of the cows. */
        @OnlyIn(Dist.CLIENT)
        public BlockState getRenderState() {
            return renderState;
        }

        private static Type getTypeByName(String nameIn) {
            for (Type strawberryCow : values()) {

                if (strawberryCow.name.equals(nameIn)) {
                    return strawberryCow;
                }
            }
            return PINK;
        }
    }
    
}