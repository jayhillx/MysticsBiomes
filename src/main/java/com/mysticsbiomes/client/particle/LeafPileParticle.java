package com.mysticsbiomes.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

@Environment(EnvType.CLIENT)
public class LeafPileParticle extends RainSplashParticle {
    private final float rotSpeed;

    public LeafPileParticle(ClientWorld level, double x, double y, double z, double xd, double yd, double zd, SpriteProvider spriteProvider) {
        super(level, x, y, z);
        this.setBoundingBoxSpacing(0.7F, 0.7F);
        this.setSpriteForAge(spriteProvider);
        this.gravityStrength = 0.025F;
        this.maxAge = 90;
        this.rotSpeed = ((float) Math.random() - 0.5F) * 0.1F;
        if (yd == 0.0D && (xd != 0.0D || zd != 0.0D)) {
            this.velocityX = xd;
            this.velocityY = 0.1D;
            this.velocityZ = zd;
        }
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.age++ >= this.maxAge) {
            this.markDead();
        } else {
            this.prevAngle = this.angle;
            this.angle += (float)Math.PI * this.rotSpeed * 2.0F;
            if (this.onGround) {
                this.prevAngle = this.angle = 0.0F;
            }
        }
    }

    @Environment(EnvType.CLIENT)
    public static class Provider implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprite;

        public Provider(SpriteProvider spriteProvider) {
            this.sprite = spriteProvider;
        }

        public Particle createParticle(DefaultParticleType type, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            return new LeafPileParticle(world, x, y, z, velocityX, velocityY, velocityZ, this.sprite);
        }
    }

}