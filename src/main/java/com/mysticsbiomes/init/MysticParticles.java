package com.mysticsbiomes.init;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.client.particle.FallingLeafParticle;
import com.mysticsbiomes.client.particle.LeafPileParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = MysticsBiomes.modId, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MysticParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(Registries.PARTICLE_TYPE, MysticsBiomes.modId);

    public static final RegistryObject<SimpleParticleType> FALLING_JACARANDA = PARTICLES.register("falling_jacaranda", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> FALLING_MAPLE = PARTICLES.register("maple_leaf", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> FALLING_ORANGE_MAPLE = PARTICLES.register("orange_maple_leaf", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> FALLING_YELLOW_MAPLE = PARTICLES.register("yellow_maple_leaf", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> LEAF_PILE_MAPLE = PARTICLES.register("maple_leaf_pile", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> LEAF_PILE_ORANGE_MAPLE = PARTICLES.register("orange_maple_leaf_pile", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> LEAF_PILE_YELLOW_MAPLE = PARTICLES.register("yellow_maple_leaf_pile", () -> new SimpleParticleType(false));

    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        ParticleEngine engine = Minecraft.getInstance().particleEngine;

        engine.register(FALLING_JACARANDA.get(), FallingLeafParticle.Provider::new);
        engine.register(FALLING_MAPLE.get(), FallingLeafParticle.Provider::new);
        engine.register(FALLING_ORANGE_MAPLE.get(), FallingLeafParticle.Provider::new);
        engine.register(FALLING_YELLOW_MAPLE.get(), FallingLeafParticle.Provider::new);
        engine.register(LEAF_PILE_MAPLE.get(), LeafPileParticle.Provider::new);
        engine.register(LEAF_PILE_ORANGE_MAPLE.get(), LeafPileParticle.Provider::new);
        engine.register(LEAF_PILE_YELLOW_MAPLE.get(), LeafPileParticle.Provider::new);
    }

}