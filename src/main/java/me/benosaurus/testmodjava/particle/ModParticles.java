package me.benosaurus.testmodjava.particle;

import me.benosaurus.testmodjava.TestModJava;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {

    public static final SimpleParticleType TEST_PARTICLE =
            registerParticle("test_particle", FabricParticleTypes.simple());


    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(TestModJava.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        TestModJava.LOGGER.info("Registering Particles for " + TestModJava.MOD_ID);
    }

}
