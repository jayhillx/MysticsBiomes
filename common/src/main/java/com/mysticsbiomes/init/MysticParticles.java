package com.mysticsbiomes.init;

import api.mystanica.registry.Registrar;
import com.mysticsbiomes.MysticsBiomes;
import api.mystanica.registry.RegistryEntry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;

public class MysticParticles {
    public static final Registrar<ParticleType<?>> PARTICLE_TYPES = Registrar.create(Registries.PARTICLE_TYPE, MysticsBiomes.modId);

    public static final RegistryEntry<SimpleParticleType> PINK_CHERRY_PETAL = register("pink_cherry_petal");
    public static final RegistryEntry<SimpleParticleType> WHITE_CHERRY_PETAL = register("white_cherry_petal");
    public static final RegistryEntry<SimpleParticleType> MAPLE_LEAF = register("maple_leaf");
    public static final RegistryEntry<SimpleParticleType> MAPLE_LEAF_PILE = register("maple_leaf_pile");
    public static final RegistryEntry<SimpleParticleType> ORANGE_MAPLE_LEAF = register("orange_maple_leaf");
    public static final RegistryEntry<SimpleParticleType> ORANGE_MAPLE_LEAF_PILE = register("orange_maple_leaf_pile");
    public static final RegistryEntry<SimpleParticleType> YELLOW_MAPLE_LEAF = register("yellow_maple_leaf");
    public static final RegistryEntry<SimpleParticleType> YELLOW_MAPLE_LEAF_PILE = register("yellow_maple_leaf_pile");
    public static final RegistryEntry<SimpleParticleType> ACORN = register("acorn");

    private static RegistryEntry<SimpleParticleType> register(String name) {
        return PARTICLE_TYPES.register(name, () -> new SimpleParticleType(false));
    }

    public static void init() {
    }
    
}