package dev.prangellplays.splatter;

import dev.prangellplays.splatter.client.renderer.InvisibleThrownEntityRenderer;
import dev.prangellplays.splatter.client.ui.BlackInkBarsRenderer;
import dev.prangellplays.splatter.components.inkling.*;
import dev.prangellplays.splatter.components.octoling.*;
import dev.prangellplays.splatter.init.SplatterBlocks;
import dev.prangellplays.splatter.init.SplatterComponents;
import dev.prangellplays.splatter.init.SplatterEntities;
import dev.prangellplays.splatter.init.SplatterParticles;
import dev.prangellplays.splatter.packet.EntityAndPosPacket;
import dev.prangellplays.splatter.particle.ink.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.Entity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;

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

        EntityRendererRegistry.register(SplatterEntities.SPLATTERSHOT_BLACK_INK, InvisibleThrownEntityRenderer::new);

        HudRenderCallback.EVENT.register(new BlackInkBarsRenderer());

        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.DIVE_INKSPLOSION_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    if (entity != null) {
                        PlayerBlackOctolingComponent component = (PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(entity);
                        component.setDiving(component.isOctoling());
                        entity.calculateDimensions();
                        client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                        for(int i = 0; i < 500; ++i) {
                            client.world.addParticle(SplatterParticles.BLACK_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F));
                        }
                    }
                });
            }
        });
        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.REMOVE_INKSKIN_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    PlayerBlackOctolingComponent component = (PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(entity);
                    component.setDiving(false);
                    entity.calculateDimensions();
                    client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                    for(int i = 0; i < 500; ++i) {
                        client.world.addParticle(SplatterParticles.BLACK_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F));
                    }
                });
            }
        });

        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.DIVE_INKSPLOSION_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    if (entity != null) {
                        PlayerBlueInklingComponent component = (PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(entity);
                        component.setDiving(component.isInkling());
                        entity.calculateDimensions();
                        client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                        for(int i = 0; i < 500; ++i) {
                            client.world.addParticle(SplatterParticles.BLUE_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F));
                        }
                    }
                });
            }
        });
        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.REMOVE_INKSKIN_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    PlayerBlueInklingComponent component = (PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(entity);
                    component.setDiving(false);
                    entity.calculateDimensions();
                    client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                    for(int i = 0; i < 500; ++i) {
                        client.world.addParticle(SplatterParticles.BLUE_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F));
                    }
                });
            }
        });

        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.DIVE_INKSPLOSION_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    if (entity != null) {
                        PlayerBrownOctolingComponent component = (PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(entity);
                        component.setDiving(component.isOctoling());
                        entity.calculateDimensions();
                        client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                        for(int i = 0; i < 500; ++i) {
                            client.world.addParticle(SplatterParticles.BROWN_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F));
                        }
                    }
                });
            }
        });
        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.REMOVE_INKSKIN_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    PlayerBrownOctolingComponent component = (PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(entity);
                    component.setDiving(false);
                    entity.calculateDimensions();
                    client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                    for(int i = 0; i < 500; ++i) {
                        client.world.addParticle(SplatterParticles.BROWN_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F));
                    }
                });
            }
        });

        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.DIVE_INKSPLOSION_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    if (entity != null) {
                        PlayerCyanInklingComponent component = (PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(entity);
                        component.setDiving(component.isInkling());
                        entity.calculateDimensions();
                        client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                        for(int i = 0; i < 500; ++i) {
                            client.world.addParticle(SplatterParticles.CYAN_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F));
                        }
                    }
                });
            }
        });
        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.REMOVE_INKSKIN_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    PlayerCyanInklingComponent component = (PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(entity);
                    component.setDiving(false);
                    entity.calculateDimensions();
                    client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                    for(int i = 0; i < 500; ++i) {
                        client.world.addParticle(SplatterParticles.CYAN_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F));
                    }
                });
            }
        });

        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.DIVE_INKSPLOSION_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    if (entity != null) {
                        PlayerGrayOctolingComponent component = (PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(entity);
                        component.setDiving(component.isOctoling());
                        entity.calculateDimensions();
                        client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                        for(int i = 0; i < 500; ++i) {
                            client.world.addParticle(SplatterParticles.GRAY_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F));
                        }
                    }
                });
            }
        });
        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.REMOVE_INKSKIN_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    PlayerGrayOctolingComponent component = (PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(entity);
                    component.setDiving(false);
                    entity.calculateDimensions();
                    client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                    for(int i = 0; i < 500; ++i) {
                        client.world.addParticle(SplatterParticles.GRAY_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F));
                    }
                });
            }
        });

        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.DIVE_INKSPLOSION_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    if (entity != null) {
                        PlayerGreenInklingComponent component = (PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(entity);
                        component.setDiving(component.isInkling());
                        entity.calculateDimensions();
                        client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                        for(int i = 0; i < 500; ++i) {
                            client.world.addParticle(SplatterParticles.GREEN_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F));
                        }
                    }
                });
            }
        });
        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.REMOVE_INKSKIN_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    PlayerGreenInklingComponent component = (PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(entity);
                    component.setDiving(false);
                    entity.calculateDimensions();
                    client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                    for(int i = 0; i < 500; ++i) {
                        client.world.addParticle(SplatterParticles.GREEN_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F));
                    }
                });
            }
        });

        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.DIVE_INKSPLOSION_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    if (entity != null) {
                        PlayerLightBlueOctolingComponent component = (PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(entity);
                        component.setDiving(component.isOctoling());
                        entity.calculateDimensions();
                        client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                        for(int i = 0; i < 500; ++i) {
                            client.world.addParticle(SplatterParticles.LIGHT_BLUE_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F));
                        }
                    }
                });
            }
        });
        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.REMOVE_INKSKIN_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    PlayerLightBlueOctolingComponent component = (PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(entity);
                    component.setDiving(false);
                    entity.calculateDimensions();
                    client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                    for(int i = 0; i < 500; ++i) {
                        client.world.addParticle(SplatterParticles.LIGHT_BLUE_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F));
                    }
                });
            }
        });

        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.DIVE_INKSPLOSION_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    if (entity != null) {
                        PlayerLightGrayOctolingComponent component = (PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(entity);
                        component.setDiving(component.isOctoling());
                        entity.calculateDimensions();
                        client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                        for(int i = 0; i < 500; ++i) {
                            client.world.addParticle(SplatterParticles.LIGHT_GRAY_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F));
                        }
                    }
                });
            }
        });
        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.REMOVE_INKSKIN_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    PlayerLightGrayOctolingComponent component = (PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(entity);
                    component.setDiving(false);
                    entity.calculateDimensions();
                    client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                    for(int i = 0; i < 500; ++i) {
                        client.world.addParticle(SplatterParticles.LIGHT_GRAY_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F));
                    }
                });
            }
        });

        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.DIVE_INKSPLOSION_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    if (entity != null) {
                        PlayerLimeInklingComponent component = (PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(entity);
                        component.setDiving(component.isInkling());
                        entity.calculateDimensions();
                        client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                        for(int i = 0; i < 500; ++i) {
                            client.world.addParticle(SplatterParticles.LIME_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F));
                        }
                    }
                });
            }
        });
        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.REMOVE_INKSKIN_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    PlayerLimeInklingComponent component = (PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(entity);
                    component.setDiving(false);
                    entity.calculateDimensions();
                    client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                    for(int i = 0; i < 500; ++i) {
                        client.world.addParticle(SplatterParticles.LIME_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F));
                    }
                });
            }
        });

        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.DIVE_INKSPLOSION_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    if (entity != null) {
                        PlayerMagentaOctolingComponent component = (PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(entity);
                        component.setDiving(component.isOctoling());
                        entity.calculateDimensions();
                        client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                        for(int i = 0; i < 500; ++i) {
                            client.world.addParticle(SplatterParticles.MAGENTA_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F));
                        }
                    }
                });
            }
        });
        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.REMOVE_INKSKIN_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    PlayerMagentaOctolingComponent component = (PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(entity);
                    component.setDiving(false);
                    entity.calculateDimensions();
                    client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                    for(int i = 0; i < 500; ++i) {
                        client.world.addParticle(SplatterParticles.MAGENTA_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F));
                    }
                });
            }
        });

        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.DIVE_INKSPLOSION_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    if (entity != null) {
                        PlayerOrangeInklingComponent component = (PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(entity);
                        component.setDiving(component.isInkling());
                        entity.calculateDimensions();
                        client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                        for(int i = 0; i < 500; ++i) {
                            client.world.addParticle(SplatterParticles.ORANGE_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F));
                        }
                    }
                });
            }
        });
        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.REMOVE_INKSKIN_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    PlayerOrangeInklingComponent component = (PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(entity);
                    component.setDiving(false);
                    entity.calculateDimensions();
                    client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                    for(int i = 0; i < 500; ++i) {
                        client.world.addParticle(SplatterParticles.ORANGE_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F));
                    }
                });
            }
        });

        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.DIVE_INKSPLOSION_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    if (entity != null) {
                        PlayerPinkInklingComponent component = (PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(entity);
                        component.setDiving(component.isInkling());
                        entity.calculateDimensions();
                        client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                        for(int i = 0; i < 500; ++i) {
                            client.world.addParticle(SplatterParticles.PINK_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F));
                        }
                    }
                });
            }
        });
        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.REMOVE_INKSKIN_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    PlayerPinkInklingComponent component = (PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(entity);
                    component.setDiving(false);
                    entity.calculateDimensions();
                    client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                    for(int i = 0; i < 500; ++i) {
                        client.world.addParticle(SplatterParticles.PINK_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F));
                    }
                });
            }
        });

        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.DIVE_INKSPLOSION_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    if (entity != null) {
                        PlayerPurpleInklingComponent component = (PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(entity);
                        component.setDiving(component.isInkling());
                        entity.calculateDimensions();
                        client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                        for(int i = 0; i < 500; ++i) {
                            client.world.addParticle(SplatterParticles.PURPLE_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F));
                        }
                    }
                });
            }
        });
        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.REMOVE_INKSKIN_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    PlayerPurpleInklingComponent component = (PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(entity);
                    component.setDiving(false);
                    entity.calculateDimensions();
                    client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                    for(int i = 0; i < 500; ++i) {
                        client.world.addParticle(SplatterParticles.PURPLE_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F));
                    }
                });
            }
        });

        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.DIVE_INKSPLOSION_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    if (entity != null) {
                        PlayerRedOctolingComponent component = (PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(entity);
                        component.setDiving(component.isOctoling());
                        entity.calculateDimensions();
                        client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                        for(int i = 0; i < 500; ++i) {
                            client.world.addParticle(SplatterParticles.RED_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F));
                        }
                    }
                });
            }
        });
        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.REMOVE_INKSKIN_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    PlayerRedOctolingComponent component = (PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(entity);
                    component.setDiving(false);
                    entity.calculateDimensions();
                    client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                    for(int i = 0; i < 500; ++i) {
                        client.world.addParticle(SplatterParticles.RED_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F));
                    }
                });
            }
        });

        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.DIVE_INKSPLOSION_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    if (entity != null) {
                        PlayerWhiteOctolingComponent component = (PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(entity);
                        component.setDiving(component.isOctoling());
                        entity.calculateDimensions();
                        client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                        for(int i = 0; i < 500; ++i) {
                            client.world.addParticle(SplatterParticles.WHITE_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F));
                        }
                    }
                });
            }
        });
        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.REMOVE_INKSKIN_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    PlayerWhiteOctolingComponent component = (PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(entity);
                    component.setDiving(false);
                    entity.calculateDimensions();
                    client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                    for(int i = 0; i < 500; ++i) {
                        client.world.addParticle(SplatterParticles.WHITE_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F));
                    }
                });
            }
        });

        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.DIVE_INKSPLOSION_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    if (entity != null) {
                        PlayerYellowInklingComponent component = (PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(entity);
                        component.setDiving(component.isInkling());
                        entity.calculateDimensions();
                        client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                        for(int i = 0; i < 500; ++i) {
                            client.world.addParticle(SplatterParticles.YELLOW_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F), (double)((client.world.random.nextFloat() - 0.5F) * 0.6F));
                        }
                    }
                });
            }
        });
        ClientPlayNetworking.registerGlobalReceiver(EntityAndPosPacket.REMOVE_INKSKIN_ID, (client, handler, buf, responseSender) -> {
            EntityAndPosPacket packet = new EntityAndPosPacket(buf);
            Entity entity = packet.getEntity(client.world);
            Vec3d entityPos = packet.getPos();
            if (entity != null) {
                client.execute(() -> {
                    PlayerYellowInklingComponent component = (PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(entity);
                    component.setDiving(false);
                    entity.calculateDimensions();
                    client.world.playSound(entityPos.getX(), entityPos.getY(), entityPos.getZ(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.PLAYERS, 1.0F, (float)(1.0 + entity.getWorld().getRandom().nextGaussian() / 20.0), false);
                    for(int i = 0; i < 500; ++i) {
                        client.world.addParticle(SplatterParticles.YELLOW_FALLING_INK, entityPos.getX() + (double)client.world.random.nextFloat() - 0.5, entityPos.getY() + (double)(client.world.random.nextFloat() * 1.8F), entityPos.getZ() + (double)client.world.random.nextFloat() - 0.5, (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F), (double)((client.world.random.nextFloat() - 0.5F) * 0.2F));
                    }
                });
            }
        });
    }

    static {
        launchStrength = 0.0F;
    }
}
