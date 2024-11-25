package dev.prangellplays.splatter;

import dev.prangellplays.splatter.init.SplatterBlocks;
import dev.prangellplays.splatter.init.SplatterParticles;
import dev.prangellplays.splatter.particle.ink.*;
import ladysnake.satin.api.managed.ShaderEffectManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.render.RenderLayer;

public class SplatterClient implements ClientModInitializer {
    public static final float MAX_LAUNCH_STRENGTH = 2.0F;
    public static float launchStrength;

    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(SplatterParticles.BLACK_FALLING_INK, BlackFallingInkParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SplatterParticles.BLACK_INK_SPLAT, BlackInkSplatParticle.Factory::new);

        ParticleFactoryRegistry.getInstance().register(SplatterParticles.BLUE_FALLING_INK, BlueFallingInkParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SplatterParticles.BLUE_INK_SPLAT, BlueInkSplatParticle.Factory::new);

        ParticleFactoryRegistry.getInstance().register(SplatterParticles.BROWN_FALLING_INK, BrownFallingInkParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SplatterParticles.BROWN_INK_SPLAT, BrownInkSplatParticle.Factory::new);

        ParticleFactoryRegistry.getInstance().register(SplatterParticles.CYAN_FALLING_INK, CyanFallingInkParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SplatterParticles.CYAN_INK_SPLAT, CyanInkSplatParticle.Factory::new);

        ParticleFactoryRegistry.getInstance().register(SplatterParticles.GRAY_FALLING_INK, GrayFallingInkParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SplatterParticles.GRAY_INK_SPLAT, GrayInkSplatParticle.Factory::new);

        ParticleFactoryRegistry.getInstance().register(SplatterParticles.GREEN_FALLING_INK, GreenFallingInkParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SplatterParticles.GREEN_INK_SPLAT, GreenInkSplatParticle.Factory::new);

        ParticleFactoryRegistry.getInstance().register(SplatterParticles.LIGHT_BLUE_FALLING_INK, LightBlueFallingInkParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SplatterParticles.LIGHT_BLUE_INK_SPLAT, LightBlueInkSplatParticle.Factory::new);

        ParticleFactoryRegistry.getInstance().register(SplatterParticles.LIGHT_GRAY_FALLING_INK, LightGrayFallingInkParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SplatterParticles.LIGHT_GRAY_INK_SPLAT, LightGrayInkSplatParticle.Factory::new);

        ParticleFactoryRegistry.getInstance().register(SplatterParticles.LIME_FALLING_INK, LimeFallingInkParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SplatterParticles.LIME_INK_SPLAT, LimeInkSplatParticle.Factory::new);

        ParticleFactoryRegistry.getInstance().register(SplatterParticles.MAGENTA_FALLING_INK, MagentaFallingInkParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SplatterParticles.MAGENTA_INK_SPLAT, MagentaInkSplatParticle.Factory::new);

        ParticleFactoryRegistry.getInstance().register(SplatterParticles.ORANGE_FALLING_INK, OrangeFallingInkParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SplatterParticles.ORANGE_INK_SPLAT, OrangeInkSplatParticle.Factory::new);

        ParticleFactoryRegistry.getInstance().register(SplatterParticles.PINK_FALLING_INK, PinkFallingInkParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SplatterParticles.PINK_INK_SPLAT, PinkInkSplatParticle.Factory::new);

        ParticleFactoryRegistry.getInstance().register(SplatterParticles.PURPLE_FALLING_INK, PurpleFallingInkParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SplatterParticles.PURPLE_INK_SPLAT, PurpleInkSplatParticle.Factory::new);

        ParticleFactoryRegistry.getInstance().register(SplatterParticles.RED_FALLING_INK, RedFallingInkParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SplatterParticles.RED_INK_SPLAT, RedInkSplatParticle.Factory::new);

        ParticleFactoryRegistry.getInstance().register(SplatterParticles.WHITE_FALLING_INK, WhiteFallingInkParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SplatterParticles.WHITE_INK_SPLAT, WhiteInkSplatParticle.Factory::new);

        ParticleFactoryRegistry.getInstance().register(SplatterParticles.YELLOW_FALLING_INK, YellowFallingInkParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SplatterParticles.YELLOW_INK_SPLAT, YellowInkSplatParticle.Factory::new);

        BlockRenderLayerMap.INSTANCE.putBlock(SplatterBlocks.BLACK_INK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SplatterBlocks.BLUE_INK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SplatterBlocks.BROWN_INK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SplatterBlocks.CYAN_INK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SplatterBlocks.GRAY_INK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SplatterBlocks.GREEN_INK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SplatterBlocks.LIGHT_BLUE_INK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SplatterBlocks.LIGHT_GRAY_INK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SplatterBlocks.LIME_INK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SplatterBlocks.MAGENTA_INK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SplatterBlocks.ORANGE_INK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SplatterBlocks.PINK_INK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SplatterBlocks.PURPLE_INK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SplatterBlocks.RED_INK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SplatterBlocks.WHITE_INK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SplatterBlocks.YELLOW_INK, RenderLayer.getCutout());
    }

    static {
        launchStrength = 0.0F;
    }
}
