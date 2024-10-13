package com.mysticsbiomes.common.item;

import com.mysticsbiomes.common.entity.animal.Butterfly;
import com.mysticsbiomes.init.MysticEntities;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class ButterflyJarItem extends Item {
    private final Butterfly.Type type;

    public ButterflyJarItem(Butterfly.Type type) {
        super(new Item.Settings().maxCount(1));
        this.type = type;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {
        if (this.type == null) {
            if (!player.getWorld().isClient) {
                if (entity instanceof Butterfly butterfly) {
                    ItemStack butterflyJar = this.getItemByType(butterfly.getVariant()).getDefaultStack();

                    NbtCompound tag = new NbtCompound();
                    tag.put("EntityData", butterfly.writeNbt(new NbtCompound()));
                    butterflyJar.getOrCreateNbt().put("Butterfly", tag);
                    entity.discard();

                    if (!player.isCreative()) {
                        if (stack.getCount() > 1) {
                            stack.decrement(1);
                            player.getInventory().insertStack(butterflyJar);
                        } else {
                            player.setStackInHand(hand, butterflyJar);
                        }
                    } else {
                        player.getInventory().insertStack(butterflyJar);
                    }
                    player.getInventory().markDirty();
                    return ActionResult.SUCCESS;
                }
            }
        }
        return ActionResult.PASS;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        World level = context.getWorld();
        ItemStack stack = context.getStack();
        BlockPos pos = context.getBlockPos().offset(context.getSide());

        if (this.type != null) {
            if (stack.getItem() == this.getItemByType(this.type) && !level.isClient) {
                if (player != null) {
                    Vec3d vec3 = new Vec3d(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D);

                    if (stack.getNbt() != null) { // loads from already caught butterfly.
                        NbtCompound tag = stack.getNbt().getCompound("Butterfly").getCompound("EntityData");

                        Entity entity = EntityType.loadEntityWithPassengers(tag, level, mob -> mob);
                        if (entity != null) {
                            entity.setPos(vec3.x, vec3.y, vec3.z);
                            level.spawnEntity(entity);
                        }
                    } else { // loaded from a fresh butterfly jar item; like a spawn egg.
                        Butterfly butterfly = new Butterfly(MysticEntities.BUTTERFLY, level);
                        butterfly.setPos(vec3.x, vec3.y, vec3.z);
                        butterfly.setVariant(this.type);
                        level.spawnEntity(butterfly);
                    }

                    if (!player.isCreative()) {
                        player.setStackInHand(context.getHand(), new ItemStack(MysticItems.GLASS_JAR));
                    }
                    return ActionResult.SUCCESS;
                }
            }
        }
        return super.useOnBlock(context);
    }

    @Override
    public Text getName(ItemStack stack) {
        return this.type != null ?  Text.translatable("item.mysticsbiomes.butterfly_jar").formatted(Formatting.AQUA): super.getName(stack);
    }

    @Override
    public void appendTooltip(ItemStack stack, World level, List<Text> components, TooltipContext flag) {
        if (this.type != null) {
            components.add(Text.translatable("entity.mysticsbiomes.butterfly.type." + this.type.asString()).formatted(Formatting.GRAY, Formatting.ITALIC));
        }
    }

    public Item getItemByType(Butterfly.Type type) {
        if (type == Butterfly.Type.TANGERINE) return MysticItems.ORANGE_BUTTERFLY_IN_JAR;
        if (type == Butterfly.Type.JELLY) return MysticItems.BLUE_BUTTERFLY_IN_JAR;
        if (type == Butterfly.Type.JULY) return MysticItems.CYAN_BUTTERFLY_IN_JAR;
        if (type == Butterfly.Type.CANDY) return MysticItems.LILAC_BUTTERFLY_IN_JAR;
        if (type == Butterfly.Type.VALENTINE) return MysticItems.PINK_BUTTERFLY_IN_JAR;
        if (type == Butterfly.Type.MYSTIC) return MysticItems.PURPLE_BUTTERFLY_IN_JAR;
        else return null;
    }

}