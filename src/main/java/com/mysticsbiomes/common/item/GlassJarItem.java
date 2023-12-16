package com.mysticsbiomes.common.item;

import com.mysticsbiomes.common.entity.animal.Butterfly;
import com.mysticsbiomes.common.entity.animal.Caterpillar;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.List;

/**
 * Multifunctional item, used for foods such as strawberry jam, or to store bugs & insects.
 */
public class GlassJarItem extends Item {

    public GlassJarItem(Properties properties) {
        super(properties);
    }

    private int getIdByEntityType(LivingEntity entity) {
        if (entity instanceof Butterfly butterfly) {
            return butterfly.getVariant().getId();
        } else if (entity instanceof Caterpillar) {
            return 7;
        } else if (entity instanceof Bee) {
            return 8;
        } else {
            return 0;
        }
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
        CompoundTag tag = stack.getOrCreateTagElement("CapturedBug");

        if (!tag.contains("EntityData")) {
            if (!player.level().isClientSide) {
                if (entity instanceof Butterfly || entity instanceof Caterpillar || entity instanceof Bee) {
                    CompoundTag entityTag = entity.serializeNBT();

                    tag.put("EntityData", entityTag);
                    tag.putInt("Variant", this.getIdByEntityType(entity));
                    tag.putString("Type", entity.getType().getDescription().getString());
                    if (entity.getCustomName() != null) {
                        tag.putString("Name", entity.getCustomName().getString());
                    }

                    if (player.isCreative()) { // duplicate to add separate item in creative.
                        ItemStack newStack = new ItemStack(this);
                        newStack.getOrCreateTag().put("CapturedBug", tag);
                        player.addItem(newStack);
                    }

                    entity.discard();
                    player.inventoryMenu.broadcastChanges();

                    return InteractionResult.SUCCESS;
                }
            }
            return InteractionResult.FAIL;
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        Level level = context.getLevel();
        ItemStack stack = context.getItemInHand();
        Direction direction = context.getClickedFace();
        BlockPos pos = context.getClickedPos().offset(direction.getStepX(), direction.getStepY(), direction.getStepZ());

        if (stack.getOrCreateTag().contains("CapturedBug") && player != null && player.mayUseItemAt(pos, direction, stack)) {
            if (!player.level().isClientSide) {
                CompoundTag itemTag = stack.getOrCreateTagElement("CapturedBug");
                CompoundTag entityTag = itemTag.getCompound("EntityData");

                Entity entity = EntityType.loadEntityRecursive(entityTag, level, mob -> mob);
                if (entity != null) {
                    entity.setPos(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
                    level.addFreshEntity(entity);
                }

                stack.removeTagKey("CapturedBug");
            }

            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    public Component getName(ItemStack stack) {
        return Component.translatable(this.getDescriptionId(stack)).withStyle(stack.getOrCreateTag().contains("CapturedBug") ? ChatFormatting.AQUA : ChatFormatting.WHITE);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag flag) {
        if (stack.getOrCreateTag().contains("CapturedBug")) {
            CompoundTag tag = stack.getOrCreateTagElement("CapturedBug");

            components.add(Component.literal("Contains " + (!tag.contains("Name") ? tag.getString("Type") : tag.getString("Name") + " [" + tag.getString("Type") + "]")).withStyle(ChatFormatting.GRAY));
        }
    }

}