package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.particle.AcornParticle;
import com.mysticsbiomes.client.particle.FallingLeafParticle;
import com.mysticsbiomes.client.particle.LeafPileParticle;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class MysticParticles {

    public static final DefaultParticleType JACARANDA_BLOSSOM = registerParticle("jacaranda_blossom");
    public static final DefaultParticleType PINK_CHERRY_BLOSSOM = registerParticle("pink_cherry_blossom");
    public static final DefaultParticleType WHITE_CHERRY_BLOSSOM = registerParticle("white_cherry_blossom");
    public static final DefaultParticleType MAPLE_LEAF = registerParticle("maple_leaf");
    public static final DefaultParticleType MAPLE_LEAF_PILE = registerParticle("maple_leaf_pile");
    public static final DefaultParticleType ORANGE_MAPLE_LEAF = registerParticle("orange_maple_leaf");
    public static final DefaultParticleType ORANGE_MAPLE_LEAF_PILE = registerParticle("orange_maple_leaf_pile");
    public static final DefaultParticleType YELLOW_MAPLE_LEAF = registerParticle("yellow_maple_leaf");
    public static final DefaultParticleType YELLOW_MAPLE_LEAF_PILE = registerParticle("yellow_maple_leaf_pile");
    public static final DefaultParticleType ACORN = registerParticle("acorn");

    private static DefaultParticleType registerParticle(String name) {
        return Registry.register(Registries.PARTICLE_TYPE, name, new Default(false));
    }
    
    public static void registerParticles() {
        ParticleFactoryRegistry.getInstance().register(JACARANDA_BLOSSOM, FallingLeafParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(PINK_CHERRY_BLOSSOM, FallingLeafParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(WHITE_CHERRY_BLOSSOM, FallingLeafParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(MAPLE_LEAF, FallingLeafParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(MAPLE_LEAF_PILE, LeafPileParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(ORANGE_MAPLE_LEAF, FallingLeafParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(ORANGE_MAPLE_LEAF_PILE, LeafPileParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(YELLOW_MAPLE_LEAF, FallingLeafParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(YELLOW_MAPLE_LEAF_PILE, LeafPileParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(ACORN, AcornParticle.Provider::new);
        MysticsBiomes.LOGGER.info("mystic's biomes ~ registering particles");
    }

    public static class Default extends DefaultParticleType {

        public Default(boolean alwaysShow) {
            super(alwaysShow);
        }
    }

}