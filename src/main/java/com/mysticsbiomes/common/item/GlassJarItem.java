package com.mysticsbiomes.common.item;

import com.mysticsbiomes.common.entity.animal.Butterfly;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class GlassJarItem extends AliasedBlockItem {

    public GlassJarItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {
        if (!player.getWorld().isClient) {
            if (entity instanceof Butterfly butterfly) {
                ItemStack butterflyJar = ButterflyJarItem.getItemByType(butterfly.getVariant()).getDefaultStack();

                NbtCompound tag = new NbtCompound();
                NbtCompound butterflyTag = butterfly.writeNbt(new NbtCompound());
                butterflyTag.putString("id", butterfly.getSavedEntityId());
                tag.put("EntityData", butterfly.writeNbt(butterflyTag));
                butterflyJar.getOrCreateNbt().put("Butterfly", tag);
                entity.discard();

                if (!player.isCreative()) {
                    if (stack.getCount() > 1) {
                        stack.decrement(1);
                        player.giveItemStack(butterflyJar);
                    } else {
                        player.setStackInHand(hand, butterflyJar);
                    }
                } else {
                    player.giveItemStack(butterflyJar);
                }
                player.currentScreenHandler.sendContentUpdates();
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }

}