package dev.prangellplays.splatter;

import dev.prangellplays.splatter.init.SplatterParticles;
import dev.prangellplays.splatter.particle.ink.BlackFallingInkParticle;
import dev.prangellplays.splatter.particle.ink.BlackInkSplatParticle;
import dev.prangellplays.splatter.particle.ink.BlueFallingInkParticle;
import dev.prangellplays.splatter.particle.ink.BlueInkSplatParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;

public class SplatterClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(SplatterParticles.BLACK_FALLING_INK, BlackFallingInkParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SplatterParticles.BLACK_INK_SPLAT, BlackInkSplatParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SplatterParticles.BLUE_FALLING_INK, BlueFallingInkParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SplatterParticles.BLUE_INK_SPLAT, BlueInkSplatParticle.Factory::new);
    }
}
