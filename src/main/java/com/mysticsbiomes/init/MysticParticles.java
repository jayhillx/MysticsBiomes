package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.particle.FallingLeafParticle;
import com.mysticsbiomes.client.particle.LeafPileParticle;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = MysticsBiomes.modId, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MysticParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(Registry.PARTICLE_TYPE_REGISTRY, MysticsBiomes.modId);

    public static final RegistryObject<SimpleParticleType> FALLING_JACARANDA = PARTICLES.register("falling_jacaranda", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> FALLING_MAPLE = PARTICLES.register("maple_leaf", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> FALLING_ORANGE_MAPLE = PARTICLES.register("orange_maple_leaf", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> FALLING_YELLOW_MAPLE = PARTICLES.register("yellow_maple_leaf", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> LEAF_PILE_MAPLE = PARTICLES.register("maple_leaf_pile", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> LEAF_PILE_ORANGE_MAPLE = PARTICLES.register("orange_maple_leaf_pile", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> LEAF_PILE_YELLOW_MAPLE = PARTICLES.register("yellow_maple_leaf_pile", () -> new SimpleParticleType(false));

    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        event.register(FALLING_JACARANDA.get(), FallingLeafParticle.Provider::new);
        event.register(FALLING_MAPLE.get(), FallingLeafParticle.Provider::new);
        event.register(FALLING_ORANGE_MAPLE.get(), FallingLeafParticle.Provider::new);
        event.register(FALLING_YELLOW_MAPLE.get(), FallingLeafParticle.Provider::new);
        event.register(LEAF_PILE_MAPLE.get(), LeafPileParticle.Provider::new);
        event.register(LEAF_PILE_ORANGE_MAPLE.get(), LeafPileParticle.Provider::new);
        event.register(LEAF_PILE_YELLOW_MAPLE.get(), LeafPileParticle.Provider::new);
    }

}