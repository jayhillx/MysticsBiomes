package com.mysticsbiomes.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FallingLeafParticle extends TextureSheetParticle {
    private final float rotSpeed;

    protected FallingLeafParticle(ClientLevel level, double x, double y, double z) {
        super(level, x, y, z);
        this.quadSize *= 1.0F;
        this.lifetime = 80;
        this.rotSpeed = ((float) Math.random() - 0.2F) * 0.1F;
        this.roll = (float) Math.random() * ((float) Math.PI * 2F);
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.oRoll = this.roll;
            this.roll += (float)Math.PI * this.rotSpeed * 2.0F;
            if (this.onGround) {
                this.oRoll = this.roll = 0.0F;
            }
            this.move(this.xd, this.yd, this.zd);
            this.yd -= 0.001F;
            this.yd = Math.max(this.yd, -0.14F);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Provider(SpriteSet set) {
            this.sprite = set;
        }

        public Particle createParticle(SimpleParticleType option, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            FallingLeafParticle particle = new FallingLeafParticle(level, x, y, z);
            particle.pickSprite(this.sprite);
            return particle;
        }
    }

}