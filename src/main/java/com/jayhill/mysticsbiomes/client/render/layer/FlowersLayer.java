package com.jayhill.mysticsbiomes.client.render.layer;

import com.jayhill.mysticsbiomes.client.StrawberryCowEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.CowModel;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@SuppressWarnings("all")
@OnlyIn(Dist.CLIENT)
public class FlowersLayer<T extends StrawberryCowEntity> extends LayerRenderer<T, CowModel<T>> {
    public FlowersLayer(IEntityRenderer<T, CowModel<T>> renderer) {
        super(renderer);
    }

    public void render(MatrixStack stack, IRenderTypeBuffer buffer, int light, T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!entity.isChild() && !entity.isInvisible()) {
            BlockRendererDispatcher blockrendererdispatcher = Minecraft.getInstance().getBlockRendererDispatcher();
            BlockState blockstate = entity.getStrawberryCowType().getRenderState();
            
            int i = LivingRenderer.getPackedOverlay(entity, 0.0F);

            stack.push();
            stack.translate(0.2F, -0.35F, 0.5D);
            stack.rotate(Vector3f.YP.rotationDegrees(-48.0F));
            stack.scale(-1.0F, -1.0F, 1.0F);
            stack.translate(-0.5D, -0.5D, -0.5D);
            blockrendererdispatcher.renderBlock(blockstate, stack, buffer, light, i);
            stack.pop();
            stack.push();
            stack.translate(0.2F, -0.35F, 0.5D);
            stack.rotate(Vector3f.YP.rotationDegrees(42.0F));
            stack.translate(0.1F, 0.0D, -0.6F);
            stack.rotate(Vector3f.YP.rotationDegrees(-48.0F));
            stack.scale(-1.0F, -1.0F, 1.0F);
            stack.translate(-0.5D, -0.5D, -0.5D);
            blockrendererdispatcher.renderBlock(blockstate, stack, buffer, light, i);
            stack.pop();
            stack.push();
            
            this.getEntityModel().getHead().translateRotate(stack);
            stack.translate(0.0D, -0.7F, -0.2F);
            stack.rotate(Vector3f.YP.rotationDegrees(-78.0F));
            stack.scale(-1.0F, -1.0F, 1.0F);
            stack.translate(-0.5D, -0.5D, -0.5D);
            blockrendererdispatcher.renderBlock(blockstate, stack, buffer, light, i);
            stack.pop();
        }
    }
    
}