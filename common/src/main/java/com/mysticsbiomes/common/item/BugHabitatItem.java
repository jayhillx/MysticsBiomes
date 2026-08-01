package com.mysticsbiomes.common.item;

import com.mysticsbiomes.common.entity.animal.Butterfly;
import com.mysticsbiomes.common.entity.animal.Caterpillar;
import com.mysticsbiomes.init.MysticEntities;
import com.mysticsbiomes.init.MysticItems;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class BugHabitatItem extends Item {
    private final BugTypes type;

    public BugHabitatItem(BugTypes type) {
        super(new Properties().stacksTo(1));
        this.type = type;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();

        if (player != null && !level.isClientSide() && context.getHand() == InteractionHand.MAIN_HAND) {
            BlockPos placePos = context.getClickedPos().relative(context.getClickedFace());

            CompoundTag tag = stack.getTag();
            if (tag != null) {
                CompoundTag entityTag = tag.getCompound("EntityData");

                ResourceLocation id = ResourceLocation.tryParse(tag.getString("id"));
                Entity entity = BuiltInRegistries.ENTITY_TYPE.get(id).create(level);
                if (entity != null) {
                    entity.load(entityTag);
                    entity.setPos(Vec3.atBottomCenterOf(placePos));
                    level.addFreshEntity(entity);
                }
            } else {
                if (this.type == BugTypes.CATERPILLAR) {
                    Caterpillar caterpillar = new Caterpillar(MysticEntities.CATERPILLAR.get(), level);
                    caterpillar.setPos(Vec3.atBottomCenterOf(placePos));
                    caterpillar.butterflyType = Butterfly.Type.getRandom(level.getRandom());
                    level.addFreshEntity(caterpillar);
                } else {
                    Butterfly butterfly = new Butterfly(MysticEntities.BUTTERFLY.get(), level);
                    butterfly.setPos(Vec3.atBottomCenterOf(placePos));
                    butterfly.setVariantByName(this.type.getSerializedName());
                    level.addFreshEntity(butterfly);
                }
            }

            if (!player.isCreative() || !stack.hasTag()) {
                player.setItemInHand(context.getHand(), new ItemStack(MysticItems.GLASS_JAR.get()));
            }

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    @Override
    public Component getName(ItemStack stack) {
        return Component.translatable("item.mysticsbiomes.bug_habitat." + this.type.getType());
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag flag) {
        components.add(Component.translatable("entity.mysticsbiomes." + this.type.getType() + "." + this.type.name)
                .withStyle(ChatFormatting.GRAY)
                .withStyle(ChatFormatting.ITALIC));
    }
    
    public enum BugTypes implements StringRepresentable {
        MONARCH("monarch"),
        MORPHO("morpho"),
        BLUE("blue"),
        LUNA_MOTH("luna_moth"),
        CATERPILLAR("caterpillar");

        private final String name;

        BugTypes(final String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }

        public String getType() {
            return this == CATERPILLAR ? "caterpillar" : "butterfly";
        }
    }

}