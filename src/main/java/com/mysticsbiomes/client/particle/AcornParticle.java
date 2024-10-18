package com.mysticsbiomes.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

@Environment(EnvType.CLIENT)
public class AcornParticle extends SpriteBillboardParticle {

    public AcornParticle(ClientWorld level, double x, double y, double z, SpriteProvider spriteProvider) {
        super(level, x, y, z);
        this.scale *= 1.25F;
        this.maxAge = 200;
        this.gravityStrength = 0.06F;
        this.setSpriteForAge(spriteProvider);
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

            this.move(this.velocityX * 0.99, this.velocityY, this.velocityZ * 0.99);
            this.velocityX *= 0.99;
            this.velocityZ *= 0.99;
            float maxAcceleration = 0.3F;
            float acceleration = (float) this.age / (float) this.maxAge * maxAcceleration;
            this.velocityY -= acceleration;
            this.move(this.velocityX, 0, this.velocityZ);
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

        public Particle createParticle(DefaultParticleType type, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            return new AcornParticle(world, x, y, z, this.sprite);
        }
    }

}