package me.benosaurus.testmodjava.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.random.Random;
import org.jspecify.annotations.Nullable;

public class TestParticle extends AnimatedParticle {
    public TestParticle(ClientWorld world, double x, double y, double z, SpriteProvider spriteProvider, float upwardsAcceleration) {
        super(world, x, y, z, spriteProvider, upwardsAcceleration);

        this.velocityMultiplier = 1f;
        this.maxAge = 80;

        this.red = 1f;
        this.green = 1f;
        this.blue = 1f;
    }


    @Override
    public BillboardParticle.RenderType getRenderType() {
        return BillboardParticle.RenderType.PARTICLE_ATLAS_TRANSLUCENT;
    }


    public static class Factory implements ParticleFactory<SimpleParticleType> {

        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public @Nullable Particle createParticle(SimpleParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, Random random) {

            TestParticle particle = new TestParticle(world, x, y, z, this.spriteProvider, 0f);
            particle.setVelocity(velocityX, velocityY, velocityZ);

            return particle;
        }
    }
}
