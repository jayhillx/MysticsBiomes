package com.mysticsbiomes.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class AcornParticle extends TextureSheetParticle {

    protected AcornParticle(ClientLevel level, double x, double y, double z) {
        super(level, x, y, z);
        this.quadSize *= 1.25F;
        this.lifetime = 200;
        this.gravity = 0.06F;
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
        if (this.age++ < this.lifetime && !(this.alpha <= 0.0F)) {
            if (this.age >= this.lifetime - 20 && this.alpha > 0.01F) {
                this.alpha -= 0.2F;
            }
            this.move(this.xd * 0.99, this.yd, this.zd * 0.99);
            this.xd *= 0.99;
            this.zd *= 0.99;
            float maxAcceleration = 0.3F;
            float acceleration = (float) this.age / (float) this.lifetime * maxAcceleration;
            this.yd -= acceleration;
            this.move(this.xd, 0, this.zd);
        } else {
            this.remove();
        }
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Provider(SpriteSet set) {
            this.sprite = set;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            AcornParticle particle = new AcornParticle(level, x, y, z);
            particle.pickSprite(this.sprite);
            return particle;
        }
    }

}