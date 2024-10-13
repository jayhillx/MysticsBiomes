package com.mysticsbiomes.common.item;

import com.mysticsbiomes.common.entity.MysticBoat;
import com.mysticsbiomes.common.entity.MysticChestBoat;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.List;
import java.util.function.Predicate;

public class MysticBoatItem extends Item {
    private static final Predicate<Entity> RIDERS = EntityPredicates.EXCEPT_SPECTATOR.and(Entity::canHit);
    private final MysticBoat.Type type;
    private final boolean hasChest;

    public MysticBoatItem(boolean hasChest, MysticBoat.Type type, Item.Settings properties) {
        super(properties);
        this.type = type;
        this.hasChest = hasChest;
    }

    @Override
    public TypedActionResult<ItemStack> use(World level, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        HitResult result = raycast(level, player, RaycastContext.FluidHandling.ANY);

        if (result.getType() == HitResult.Type.MISS) {
            return TypedActionResult.pass(stack);
        } else {
            Vec3d rotation = player.getRotationVec(1.0F);
            List<Entity> list = level.getOtherEntities(player, player.getBoundingBox().stretch(rotation.multiply(5.0D)).expand(1.0D), RIDERS);

            if (!list.isEmpty()) {
                Vec3d eyePos = player.getEyePos();

                for (Entity entity : list) {
                    Box box = entity.getBoundingBox().expand(entity.getTargetingMargin());
                    if (box.contains(eyePos)) {
                        return TypedActionResult.pass(stack);
                    }
                }
            }

            if (result.getType() == HitResult.Type.BLOCK) {
                BoatEntity boat;
                if (this.hasChest) {
                    boat = new MysticChestBoat(level, result.getPos().x, result.getPos().y, result.getPos().z);
                    ((MysticChestBoat)boat).setModel(this.type);
                } else {
                    boat = new MysticBoat(level, result.getPos().x, result.getPos().y, result.getPos().z);
                    ((MysticBoat)boat).setModel(this.type);
                }
                boat.setYaw(player.getYaw());

                if (!level.canCollide(boat, boat.getBoundingBox())) {
                    return TypedActionResult.fail(stack);
                } else {
                    if (!level.isClient) {
                        level.spawnEntity(boat);
                        level.emitGameEvent(player, GameEvent.ENTITY_PLACE, result.getPos());
                        if (!player.getAbilities().creativeMode) {
                            stack.decrement(1);
                        }
                    }

                    player.incrementStat(Stats.USED.getOrCreateStat(this));
                    return TypedActionResult.success(stack, level.isClient());
                }
            } else {
                return TypedActionResult.pass(stack);
            }
        }
    }

}