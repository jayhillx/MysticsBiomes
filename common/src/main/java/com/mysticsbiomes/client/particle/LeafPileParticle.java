package com.mysticsbiomes.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class LeafPileParticle extends TextureSheetParticle {
    private final double originX;
    private final double originZ;
    private final double swirlPeriod;
    private final float spinAcceleration;
    private float rotSpeed;

    protected LeafPileParticle(ClientLevel level, double x, double y, double z, double xd, double yd, double zd) {
        super(level, x, y, z);
        float size = 3.8F * (this.random.nextBoolean() ? 0.05F : 0.075F);
        this.quadSize = size;
        this.setSize(size, size);
        this.gravity = 0.03F;
        this.lifetime = 60 + this.random.nextInt(20);
        this.originX = x;
        this.originZ = z;

        double angle = this.random.nextDouble() * (Math.PI * 2);
        double burst = 0.01D + this.random.nextDouble() * 0.05D;
        double burstX = Math.cos(angle) * burst;
        double burstZ = Math.sin(angle) * burst;
        this.xd = burstX;
        this.yd = 0.175F + this.random.nextFloat() * 0.05F;
        this.zd = burstZ;

        this.rotSpeed = (this.random.nextFloat() - 0.5F) * 0.2F;
        this.spinAcceleration = (float)Math.toRadians(this.random.nextBoolean() ? -5F : 5F);
        this.swirlPeriod = Math.toRadians(1000.0F + this.random.nextFloat() * 3000.0F);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
            return;
        }

        float t = (float) this.age / (float) this.lifetime;
        double dx = 0, dz = 0;
        double deltaX = this.x - this.originX;
        double deltaZ = this.z - this.originZ;
        double dist = Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);

        double maxDistance = 0.7D;
        if (dist < maxDistance) {
            float windStrength = 0.7F;
            dx += Math.cos(t * this.swirlPeriod) * windStrength * 0.5F;
            dz += Math.sin(t * this.swirlPeriod) * windStrength * 0.5F;

            double factor = (maxDistance - dist) / maxDistance;
            factor = Math.max(0.0, factor);
            this.xd += dx * 0.003D * factor;
            this.zd += dz * 0.003D * factor;
        }

        this.yd *= 0.98D;
        this.yd -= this.gravity * 0.4D;
        if (this.yd < -0.085) this.yd = -0.085D;

        this.oRoll = this.roll;
        this.rotSpeed += this.spinAcceleration / 20F;
        this.roll += this.rotSpeed;

        this.move(this.xd, this.yd, this.zd);
        if (this.onGround) {
            this.roll = 0;
            this.oRoll = 0;
        }
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Provider(SpriteSet set) {
            this.sprite = set;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xd, double yd, double zd) {
            LeafPileParticle particle = new LeafPileParticle(level, x, y, z, xd, yd, zd);
            particle.pickSprite(this.sprite);
            return particle;
        }
    }

}