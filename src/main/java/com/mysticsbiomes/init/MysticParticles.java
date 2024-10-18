package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.particle.AcornParticle;
import com.mysticsbiomes.client.particle.FallingLeafParticle;
import com.mysticsbiomes.client.particle.LeafPileParticle;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class MysticParticles {

    public static final DefaultParticleType JACARANDA_BLOSSOM = FabricParticleTypes.simple();
    public static final DefaultParticleType PINK_CHERRY_BLOSSOM = FabricParticleTypes.simple();
    public static final DefaultParticleType WHITE_CHERRY_BLOSSOM = FabricParticleTypes.simple();
    public static final DefaultParticleType MAPLE_LEAF = FabricParticleTypes.simple();
    public static final DefaultParticleType MAPLE_LEAF_PILE = FabricParticleTypes.simple();
    public static final DefaultParticleType ORANGE_MAPLE_LEAF = FabricParticleTypes.simple();
    public static final DefaultParticleType ORANGE_MAPLE_LEAF_PILE = FabricParticleTypes.simple();
    public static final DefaultParticleType YELLOW_MAPLE_LEAF = FabricParticleTypes.simple();
    public static final DefaultParticleType YELLOW_MAPLE_LEAF_PILE = FabricParticleTypes.simple();
    public static final DefaultParticleType ACORN = FabricParticleTypes.simple();

    public static void registerParticles() {
        registerParticle("jacaranda_blossom", JACARANDA_BLOSSOM);
        registerParticle("pink_cherry_blossom", PINK_CHERRY_BLOSSOM);
        registerParticle("white_cherry_blossom", WHITE_CHERRY_BLOSSOM);
        registerParticle("maple_leaf", MAPLE_LEAF);
        registerParticle("maple_leaf_pile", MAPLE_LEAF_PILE);
        registerParticle("orange_maple_leaf", ORANGE_MAPLE_LEAF);
        registerParticle("orange_maple_leaf_pile", ORANGE_MAPLE_LEAF_PILE);
        registerParticle("yellow_maple_leaf", YELLOW_MAPLE_LEAF);
        registerParticle("yellow_maple_leaf_pile", YELLOW_MAPLE_LEAF_PILE);
        registerParticle("acorn", ACORN);
    }

    private static void registerParticle(String name, DefaultParticleType particle) {
        Registry.register(Registries.PARTICLE_TYPE, MysticsBiomes.modLoc(name), particle);
    }
    
    public static void registerParticleFactory() {
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
    }

}