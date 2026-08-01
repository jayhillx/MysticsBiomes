package com.mysticsbiomes.mixin.client;

import com.mysticsbiomes.MysticsBiomes;
import net.minecraft.client.gui.screens.inventory.AbstractSignEditScreen;
import net.minecraft.client.gui.screens.inventory.HangingSignEditScreen;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HangingSignEditScreen.class)
public abstract class HangingSignEditScreenMixin extends AbstractSignEditScreen {
    @Shadow
    @Final
    @Mutable
    private ResourceLocation texture;

    private HangingSignEditScreenMixin(SignBlockEntity entity, boolean front, boolean filtered) {
        super(entity, front, filtered);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void mystanicaInit(SignBlockEntity entity, boolean front, boolean filtered, CallbackInfo ci) {
        ResourceLocation setId = new ResourceLocation(this.woodType.setType().name());

        if (setId.getNamespace().equals(MysticsBiomes.modId)) {
            this.texture = MysticsBiomes.modLoc("textures/gui/hanging_signs/" + this.woodType.name() + ".png");
        }
    }

}