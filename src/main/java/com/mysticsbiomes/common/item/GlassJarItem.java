package com.mysticsbiomes.common.item;

import com.mysticsbiomes.common.entity.animal.Butterfly;
import com.mysticsbiomes.init.MysticEntities;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class GlassJarItem extends Item {
    private final Butterfly.Type type;

    public GlassJarItem(Butterfly.Type type, Properties properties) {
        super(properties);
        this.type = type;
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
        if (this.type == null) {
            if (!player.level().isClientSide) {
                if (entity instanceof Butterfly butterfly) {
                    ItemStack butterflyJar = this.getItemByType(butterfly.getVariant()).getDefaultInstance();

                    CompoundTag tag = new CompoundTag();
                    tag.put("EntityData", butterfly.serializeNBT());
                    butterflyJar.getOrCreateTag().put("Butterfly", tag);
                    entity.discard();

                    if (!player.isCreative()) {
                        if (stack.getCount() > 1) {
                            stack.shrink(1);
                            player.addItem(butterflyJar);
                        } else {
                            player.setItemInHand(hand, butterflyJar);
                        }
                    } else {
                        player.addItem(butterflyJar);
                    }
                    player.inventoryMenu.broadcastChanges();
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        Level level = context.getLevel();
        ItemStack stack = context.getItemInHand();
        BlockPos pos = context.getClickedPos().offset(context.getClickedFace().getStepX(), context.getClickedFace().getStepY(), context.getClickedFace().getStepZ());

        if (stack.getItem() == this.getItemByType(this.type) && !level.isClientSide) {
            if (player != null) {
                Vec3 vec3 = new Vec3(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D);

                if (stack.getTag() != null) { // loads from already caught butterfly.
                    CompoundTag tag = stack.getTag().getCompound("Butterfly").getCompound("EntityData");

                    Entity entity = EntityType.loadEntityRecursive(tag, level, mob -> mob);
                    if (entity != null) {
                        entity.setPos(vec3);
                        level.addFreshEntity(entity);
                    }
                } else { // loaded from a fresh butterfly jar item; like a spawn egg.
                    Butterfly butterfly = new Butterfly(MysticEntities.BUTTERFLY.get(), level);
                    butterfly.setPos(vec3);
                    butterfly.setVariant(this.type);
                    level.addFreshEntity(butterfly);
                }

                if (!player.isCreative()) {
                    player.setItemInHand(context.getHand(), new ItemStack(MysticItems.GLASS_JAR.get()));
                }
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public Component getName(ItemStack stack) {
        return this.type != null ?  Component.translatable("item.mysticsbiomes.butterfly_jar").withStyle(ChatFormatting.AQUA): super.getName(stack);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag flag) {
        if (this.type != null) {
            components.add(Component.translatable("entity.mysticsbiomes.butterfly.type." + type.getSerializedName()).withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
        }
    }

    public Item getItemByType(Butterfly.Type type) {
        if (type == Butterfly.Type.APRICOT) return MysticItems.ORANGE_BUTTERFLY_JAR.get();
        if (type == Butterfly.Type.JELLY) return MysticItems.BLUE_BUTTERFLY_JAR.get();
        if (type == Butterfly.Type.JULY) return MysticItems.CYAN_BUTTERFLY_JAR.get();
        else return null;
    }

}