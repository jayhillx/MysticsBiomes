package com.mysticsbiomes.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

@Environment(EnvType.CLIENT)
public class FallingLeafParticle extends SpriteBillboardParticle {
    private final float rotSpeed;

    protected FallingLeafParticle(ClientWorld level, double x, double y, double z) {
        super(level, x, y, z);
        this.scale *= 1.25F;
        this.maxAge = 170;
        this.rotSpeed = (float) (Math.random() - 0.2) * 0.1F;
        this.angle = (float) (Math.random() * (Math.PI * 2));
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        if (this.age++ < this.maxAge && !(this.alpha <= 0.0F)) {
            if (this.age >= this.maxAge - 20 && this.alpha > 0.01F) {
                this.alpha -= 0.2F;
            }

            this.prevAngle = this.angle;
            this.angle += (float) Math.PI * this.rotSpeed * 0.5F;
            if (this.onGround) {
                this.prevAngle = this.angle = 0.0F;
            }

            this.move(this.velocityX, this.velocityY * 0.8, this.velocityZ);
            this.velocityY -= 0.0008F;
            this.velocityY = Math.max(this.velocityY, -0.06F);
        } else {
            this.markDead();
        }
    }

    @Environment(EnvType.CLIENT)
    public static class Provider implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprite;

        public Provider(SpriteProvider spriteProvider) {
            this.sprite = spriteProvider;
        }

        @Override
        public Particle createParticle(DefaultParticleType type, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            FallingLeafParticle particle = new FallingLeafParticle(world, x, y, z);
            particle.setSprite(this.sprite);
            return particle;
        }
    }

}