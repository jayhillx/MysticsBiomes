package com.mysticsbiomes.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class FallingLeavesParticle extends TextureSheetParticle {
    private float rotSpeed;
    private final float particleRandom;
    private final float spinAcceleration;
    private final float windBig;
    private boolean swirl;
    private boolean flowAway;
    private double xaFlowScale;
    private double zaFlowScale;
    private double swirlPeriod;

    protected FallingLeavesParticle(ClientLevel level, double x, double y, double z, SpriteSet sprites, float gravity, float windStrength, boolean swirl, boolean flowAway, float scale, float speed) {
        super(level, x, y, z);
        this.setSprite(sprites.get(this.random.nextInt(12), 12));
        this.rotSpeed = (float)Math.toRadians(this.random.nextBoolean() ? -30.0 : 30.0);
        this.particleRandom = this.random.nextFloat();
        this.spinAcceleration = (float)Math.toRadians(this.random.nextBoolean() ? -5.0 : 5.0);
        this.windBig = windStrength;
        this.swirl = swirl;
        this.flowAway = flowAway;
        this.lifetime = 300;
        this.gravity = gravity * 1.2F * 0.0025F;
        float size = scale * (this.random.nextBoolean() ? 0.05F : 0.075F);
        this.quadSize = size;
        this.setSize(size, size);
        this.friction = 1.0F;
        this.yd = -speed;
        this.xaFlowScale = Math.cos(Math.toRadians(this.particleRandom * 60.0F)) * windStrength;
        this.zaFlowScale = Math.sin(Math.toRadians(this.particleRandom * 60.0F)) * windStrength;
        this.swirlPeriod = Math.toRadians(1000.0F + this.particleRandom * 3000.0F);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.lifetime-- <= 0) {
            this.remove();
        }

        if (!this.removed) {
            float f = (float)(300 - this.lifetime);
            float f1 = Math.min(f / 300.0F, 1.0F);
            double d0 = 0.0;
            double d1 = 0.0;
            if (this.flowAway) {
                d0 += this.xaFlowScale * Math.pow(f1, 1.25);
                d1 += this.zaFlowScale * Math.pow(f1, 1.25);
            }

            if (this.swirl) {
                d0 += (double)f1 * Math.cos((double)f1 * this.swirlPeriod) * (double)this.windBig;
                d1 += (double)f1 * Math.sin((double)f1 * this.swirlPeriod) * (double)this.windBig;
            }

            this.xd += d0 * 0.0025F;
            this.zd += d1 * 0.0025F;
            this.yd = this.yd - (double)this.gravity;
            this.rotSpeed = this.rotSpeed + this.spinAcceleration / 20.0F;
            this.oRoll = this.roll;
            this.roll = this.roll + this.rotSpeed / 20.0F;
            this.move(this.xd, this.yd, this.zd);
            if (this.onGround || this.lifetime < 299 && (this.xd == 0.0 || this.zd == 0.0)) {
                this.remove();
            }

            if (!this.removed) {
                this.xd = this.xd * (double)this.friction;
                this.yd = this.yd * (double)this.friction;
                this.zd = this.zd * (double)this.friction;
            }
        }
    }

    public static class BlossomProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public BlossomProvider(SpriteSet set) {
            this.sprites = set;
        }

        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double vx, double vy, double vz) {
            return new FallingLeavesParticle(level, x, y, z, this.sprites, 0.25F, 2.0F, false, true, 1.0F, 0.0F);
        }
    }

    public static class LeavesProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public LeavesProvider(SpriteSet set) {
            this.sprites = set;
        }

        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double vx, double vy, double vz) {
            return new FallingLeavesParticle(level, x, y, z, this.sprites, 0.07F, 4.0F, true, false, 3.0F, 0.0F);
        }
    }

}