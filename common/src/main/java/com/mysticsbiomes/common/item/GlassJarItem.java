package com.mysticsbiomes.common.item;

import api.mystanica.registry.RegistryEntry;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class GlassJarItem extends MysticBlockItem {

    public GlassJarItem(RegistryEntry<Block> block, Properties properties) {
        super(block, properties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
        ///if (!player.level().isClientSide() && (entity instanceof Butterfly || entity instanceof Caterpillar)) {
        ///    ItemStack item = this.getItemByType(entity).getDefaultInstance();
        ///
        ///    CompoundTag tag = new CompoundTag();
        ///    tag.putString("id", EntityType.getKey(entity.getType()).toString());
        ///    CompoundTag entityTag = new CompoundTag();
        ///    entity.save(entityTag);
        ///    entityTag.remove("Pos");
        ///    tag.put("EntityData", entityTag);
        ///
        ///    item.setTag(tag);
        ///    entity.discard();
        ///
        ///    if (!player.isCreative()) {
        ///        if (stack.getCount() > 1) {
        ///            stack.shrink(1);
        ///            player.addItem(item);
        ///        } else {
        ///            player.setItemInHand(hand, item);
        ///        }
        ///    } else {
        ///        player.addItem(item);
        ///    }
        ///
        ///    player.inventoryMenu.broadcastChanges();
        ///    return InteractionResult.SUCCESS;
        ///}

        return InteractionResult.PASS;
    }

    ///private Item getItemByType(LivingEntity entity) {
    ///    if (entity instanceof Butterfly butterfly) {
    ///        return switch (butterfly.getVariant()) {
    ///            case MONARCH -> MysticItems.MONARCH_BUTTERFLY_IN_JAR.get();
    ///            case MORPHO -> MysticItems.MORPHO_BUTTERFLY_IN_JAR.get();
    ///            case LUNA_MOTH -> MysticItems.LUNA_MOTH_IN_JAR.get();
    ///        };
    ///    } else if (entity instanceof Caterpillar) {
    ///        return MysticItems.CATERPILLAR_IN_JAR.get();
    ///    } else {
    ///        return this;
    ///    }
    ///}

}