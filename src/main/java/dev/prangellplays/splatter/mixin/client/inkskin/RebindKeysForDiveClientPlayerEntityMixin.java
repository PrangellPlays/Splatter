package dev.prangellplays.splatter.mixin.client.inkskin;

import dev.prangellplays.splatter.Splatter;
import dev.prangellplays.splatter.SplatterClient;
import dev.prangellplays.splatter.components.inkling.*;
import dev.prangellplays.splatter.components.octoling.*;
import dev.prangellplays.splatter.init.SplatterComponents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.PacketByteBuf;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin({ClientPlayerEntity.class})
public class RebindKeysForDiveClientPlayerEntityMixin {
    @Unique
    private boolean wasPressed = false;
    @Shadow
    @Final
    protected MinecraftClient client;

    public RebindKeysForDiveClientPlayerEntityMixin() {
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$tickBlackInkskinMovement(CallbackInfo ci) {
        boolean isPressed = this.client.options.sneakKey.isPressed();
        ClientPlayerEntity player = this.client.player;
        if (player != null && this.client.currentScreen == null) {
            PlayerBlackOctolingComponent component = (PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(player);
            if (component.isOctoling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (component.isDiving()) {
                    if (this.client.options.jumpKey.isPressed()) {
                        if (SplatterClient.launchStrength < 2.0F) {
                            SplatterClient.launchStrength += 0.1F;
                        }
                    } else if (SplatterClient.launchStrength > 0.0F && player.getWorld() != null) {
                        this.client.options.jumpKey.setPressed(false);
                        PacketByteBuf packet = PacketByteBufs.create();
                        packet.writeFloat(SplatterClient.launchStrength);
                        ClientPlayNetworking.send(Splatter.SERVERBOUND_LAUNCH_PACKET, packet);
                        SplatterClient.launchStrength = 0.0F;
                    }
                }
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$tickBlueInkskinMovement(CallbackInfo ci) {
        boolean isPressed = this.client.options.sneakKey.isPressed();
        ClientPlayerEntity player = this.client.player;
        if (player != null && this.client.currentScreen == null) {
            PlayerBlueInklingComponent component = (PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(player);
            if (component.isInkling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (component.isDiving()) {
                    if (this.client.options.jumpKey.isPressed()) {
                        if (SplatterClient.launchStrength < 2.0F) {
                            SplatterClient.launchStrength += 0.1F;
                        }
                    } else if (SplatterClient.launchStrength > 0.0F && player.getWorld() != null) {
                        this.client.options.jumpKey.setPressed(false);
                        PacketByteBuf packet = PacketByteBufs.create();
                        packet.writeFloat(SplatterClient.launchStrength);
                        ClientPlayNetworking.send(Splatter.SERVERBOUND_LAUNCH_PACKET, packet);
                        SplatterClient.launchStrength = 0.0F;
                    }
                }
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$tickBrownInkskinMovement(CallbackInfo ci) {
        boolean isPressed = this.client.options.sneakKey.isPressed();
        ClientPlayerEntity player = this.client.player;
        if (player != null && this.client.currentScreen == null) {
            PlayerBrownOctolingComponent component = (PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(player);
            if (component.isOctoling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (component.isDiving()) {
                    if (this.client.options.jumpKey.isPressed()) {
                        if (SplatterClient.launchStrength < 2.0F) {
                            SplatterClient.launchStrength += 0.1F;
                        }
                    } else if (SplatterClient.launchStrength > 0.0F && player.getWorld() != null) {
                        this.client.options.jumpKey.setPressed(false);
                        PacketByteBuf packet = PacketByteBufs.create();
                        packet.writeFloat(SplatterClient.launchStrength);
                        ClientPlayNetworking.send(Splatter.SERVERBOUND_LAUNCH_PACKET, packet);
                        SplatterClient.launchStrength = 0.0F;
                    }
                }
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$tickCyanInkskinMovement(CallbackInfo ci) {
        boolean isPressed = this.client.options.sneakKey.isPressed();
        ClientPlayerEntity player = this.client.player;
        if (player != null && this.client.currentScreen == null) {
            PlayerCyanInklingComponent component = (PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(player);
            if (component.isInkling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (component.isDiving()) {
                    if (this.client.options.jumpKey.isPressed()) {
                        if (SplatterClient.launchStrength < 2.0F) {
                            SplatterClient.launchStrength += 0.1F;
                        }
                    } else if (SplatterClient.launchStrength > 0.0F && player.getWorld() != null) {
                        this.client.options.jumpKey.setPressed(false);
                        PacketByteBuf packet = PacketByteBufs.create();
                        packet.writeFloat(SplatterClient.launchStrength);
                        ClientPlayNetworking.send(Splatter.SERVERBOUND_LAUNCH_PACKET, packet);
                        SplatterClient.launchStrength = 0.0F;
                    }
                }
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$tickGrayInkskinMovement(CallbackInfo ci) {
        boolean isPressed = this.client.options.sneakKey.isPressed();
        ClientPlayerEntity player = this.client.player;
        if (player != null && this.client.currentScreen == null) {
            PlayerGrayOctolingComponent component = (PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(player);
            if (component.isOctoling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (component.isDiving()) {
                    if (this.client.options.jumpKey.isPressed()) {
                        if (SplatterClient.launchStrength < 2.0F) {
                            SplatterClient.launchStrength += 0.1F;
                        }
                    } else if (SplatterClient.launchStrength > 0.0F && player.getWorld() != null) {
                        this.client.options.jumpKey.setPressed(false);
                        PacketByteBuf packet = PacketByteBufs.create();
                        packet.writeFloat(SplatterClient.launchStrength);
                        ClientPlayNetworking.send(Splatter.SERVERBOUND_LAUNCH_PACKET, packet);
                        SplatterClient.launchStrength = 0.0F;
                    }
                }
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$tickGreenInkskinMovement(CallbackInfo ci) {
        boolean isPressed = this.client.options.sneakKey.isPressed();
        ClientPlayerEntity player = this.client.player;
        if (player != null && this.client.currentScreen == null) {
            PlayerGreenInklingComponent component = (PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(player);
            if (component.isInkling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (component.isDiving()) {
                    if (this.client.options.jumpKey.isPressed()) {
                        if (SplatterClient.launchStrength < 2.0F) {
                            SplatterClient.launchStrength += 0.1F;
                        }
                    } else if (SplatterClient.launchStrength > 0.0F && player.getWorld() != null) {
                        this.client.options.jumpKey.setPressed(false);
                        PacketByteBuf packet = PacketByteBufs.create();
                        packet.writeFloat(SplatterClient.launchStrength);
                        ClientPlayNetworking.send(Splatter.SERVERBOUND_LAUNCH_PACKET, packet);
                        SplatterClient.launchStrength = 0.0F;
                    }
                }
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$tickLightBlueInkskinMovement(CallbackInfo ci) {
        boolean isPressed = this.client.options.sneakKey.isPressed();
        ClientPlayerEntity player = this.client.player;
        if (player != null && this.client.currentScreen == null) {
            PlayerLightBlueOctolingComponent component = (PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(player);
            if (component.isOctoling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (component.isDiving()) {
                    if (this.client.options.jumpKey.isPressed()) {
                        if (SplatterClient.launchStrength < 2.0F) {
                            SplatterClient.launchStrength += 0.1F;
                        }
                    } else if (SplatterClient.launchStrength > 0.0F && player.getWorld() != null) {
                        this.client.options.jumpKey.setPressed(false);
                        PacketByteBuf packet = PacketByteBufs.create();
                        packet.writeFloat(SplatterClient.launchStrength);
                        ClientPlayNetworking.send(Splatter.SERVERBOUND_LAUNCH_PACKET, packet);
                        SplatterClient.launchStrength = 0.0F;
                    }
                }
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$tickLightGrayInkskinMovement(CallbackInfo ci) {
        boolean isPressed = this.client.options.sneakKey.isPressed();
        ClientPlayerEntity player = this.client.player;
        if (player != null && this.client.currentScreen == null) {
            PlayerLightGrayOctolingComponent component = (PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(player);
            if (component.isOctoling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (component.isDiving()) {
                    if (this.client.options.jumpKey.isPressed()) {
                        if (SplatterClient.launchStrength < 2.0F) {
                            SplatterClient.launchStrength += 0.1F;
                        }
                    } else if (SplatterClient.launchStrength > 0.0F && player.getWorld() != null) {
                        this.client.options.jumpKey.setPressed(false);
                        PacketByteBuf packet = PacketByteBufs.create();
                        packet.writeFloat(SplatterClient.launchStrength);
                        ClientPlayNetworking.send(Splatter.SERVERBOUND_LAUNCH_PACKET, packet);
                        SplatterClient.launchStrength = 0.0F;
                    }
                }
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$tickLimeInkskinMovement(CallbackInfo ci) {
        boolean isPressed = this.client.options.sneakKey.isPressed();
        ClientPlayerEntity player = this.client.player;
        if (player != null && this.client.currentScreen == null) {
            PlayerLimeInklingComponent component = (PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(player);
            if (component.isInkling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (component.isDiving()) {
                    if (this.client.options.jumpKey.isPressed()) {
                        if (SplatterClient.launchStrength < 2.0F) {
                            SplatterClient.launchStrength += 0.1F;
                        }
                    } else if (SplatterClient.launchStrength > 0.0F && player.getWorld() != null) {
                        this.client.options.jumpKey.setPressed(false);
                        PacketByteBuf packet = PacketByteBufs.create();
                        packet.writeFloat(SplatterClient.launchStrength);
                        ClientPlayNetworking.send(Splatter.SERVERBOUND_LAUNCH_PACKET, packet);
                        SplatterClient.launchStrength = 0.0F;
                    }
                }
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$tickMagentaInkskinMovement(CallbackInfo ci) {
        boolean isPressed = this.client.options.sneakKey.isPressed();
        ClientPlayerEntity player = this.client.player;
        if (player != null && this.client.currentScreen == null) {
            PlayerMagentaOctolingComponent component = (PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(player);
            if (component.isOctoling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (component.isDiving()) {
                    if (this.client.options.jumpKey.isPressed()) {
                        if (SplatterClient.launchStrength < 2.0F) {
                            SplatterClient.launchStrength += 0.1F;
                        }
                    } else if (SplatterClient.launchStrength > 0.0F && player.getWorld() != null) {
                        this.client.options.jumpKey.setPressed(false);
                        PacketByteBuf packet = PacketByteBufs.create();
                        packet.writeFloat(SplatterClient.launchStrength);
                        ClientPlayNetworking.send(Splatter.SERVERBOUND_LAUNCH_PACKET, packet);
                        SplatterClient.launchStrength = 0.0F;
                    }
                }
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$tickOrangeInkskinMovement(CallbackInfo ci) {
        boolean isPressed = this.client.options.sneakKey.isPressed();
        ClientPlayerEntity player = this.client.player;
        if (player != null && this.client.currentScreen == null) {
            PlayerOrangeInklingComponent component = (PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(player);
            if (component.isInkling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (component.isDiving()) {
                    if (this.client.options.jumpKey.isPressed()) {
                        if (SplatterClient.launchStrength < 2.0F) {
                            SplatterClient.launchStrength += 0.1F;
                        }
                    } else if (SplatterClient.launchStrength > 0.0F && player.getWorld() != null) {
                        this.client.options.jumpKey.setPressed(false);
                        PacketByteBuf packet = PacketByteBufs.create();
                        packet.writeFloat(SplatterClient.launchStrength);
                        ClientPlayNetworking.send(Splatter.SERVERBOUND_LAUNCH_PACKET, packet);
                        SplatterClient.launchStrength = 0.0F;
                    }
                }
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$tickPinkInkskinMovement(CallbackInfo ci) {
        boolean isPressed = this.client.options.sneakKey.isPressed();
        ClientPlayerEntity player = this.client.player;
        if (player != null && this.client.currentScreen == null) {
            PlayerPinkInklingComponent component = (PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(player);
            if (component.isInkling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (component.isDiving()) {
                    if (this.client.options.jumpKey.isPressed()) {
                        if (SplatterClient.launchStrength < 2.0F) {
                            SplatterClient.launchStrength += 0.1F;
                        }
                    } else if (SplatterClient.launchStrength > 0.0F && player.getWorld() != null) {
                        this.client.options.jumpKey.setPressed(false);
                        PacketByteBuf packet = PacketByteBufs.create();
                        packet.writeFloat(SplatterClient.launchStrength);
                        ClientPlayNetworking.send(Splatter.SERVERBOUND_LAUNCH_PACKET, packet);
                        SplatterClient.launchStrength = 0.0F;
                    }
                }
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$tickPurpleInkskinMovement(CallbackInfo ci) {
        boolean isPressed = this.client.options.sneakKey.isPressed();
        ClientPlayerEntity player = this.client.player;
        if (player != null && this.client.currentScreen == null) {
            PlayerPurpleInklingComponent component = (PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(player);
            if (component.isInkling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (component.isDiving()) {
                    if (this.client.options.jumpKey.isPressed()) {
                        if (SplatterClient.launchStrength < 2.0F) {
                            SplatterClient.launchStrength += 0.1F;
                        }
                    } else if (SplatterClient.launchStrength > 0.0F && player.getWorld() != null) {
                        this.client.options.jumpKey.setPressed(false);
                        PacketByteBuf packet = PacketByteBufs.create();
                        packet.writeFloat(SplatterClient.launchStrength);
                        ClientPlayNetworking.send(Splatter.SERVERBOUND_LAUNCH_PACKET, packet);
                        SplatterClient.launchStrength = 0.0F;
                    }
                }
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$tickRedInkskinMovement(CallbackInfo ci) {
        boolean isPressed = this.client.options.sneakKey.isPressed();
        ClientPlayerEntity player = this.client.player;
        if (player != null && this.client.currentScreen == null) {
            PlayerRedOctolingComponent component = (PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(player);
            if (component.isOctoling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (component.isDiving()) {
                    if (this.client.options.jumpKey.isPressed()) {
                        if (SplatterClient.launchStrength < 2.0F) {
                            SplatterClient.launchStrength += 0.1F;
                        }
                    } else if (SplatterClient.launchStrength > 0.0F && player.getWorld() != null) {
                        this.client.options.jumpKey.setPressed(false);
                        PacketByteBuf packet = PacketByteBufs.create();
                        packet.writeFloat(SplatterClient.launchStrength);
                        ClientPlayNetworking.send(Splatter.SERVERBOUND_LAUNCH_PACKET, packet);
                        SplatterClient.launchStrength = 0.0F;
                    }
                }
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$tickWhiteInkskinMovement(CallbackInfo ci) {
        boolean isPressed = this.client.options.sneakKey.isPressed();
        ClientPlayerEntity player = this.client.player;
        if (player != null && this.client.currentScreen == null) {
            PlayerWhiteOctolingComponent component = (PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(player);
            if (component.isOctoling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (component.isDiving()) {
                    if (this.client.options.jumpKey.isPressed()) {
                        if (SplatterClient.launchStrength < 2.0F) {
                            SplatterClient.launchStrength += 0.1F;
                        }
                    } else if (SplatterClient.launchStrength > 0.0F && player.getWorld() != null) {
                        this.client.options.jumpKey.setPressed(false);
                        PacketByteBuf packet = PacketByteBufs.create();
                        packet.writeFloat(SplatterClient.launchStrength);
                        ClientPlayNetworking.send(Splatter.SERVERBOUND_LAUNCH_PACKET, packet);
                        SplatterClient.launchStrength = 0.0F;
                    }
                }
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$tickYellowInkskinMovement(CallbackInfo ci) {
        boolean isPressed = this.client.options.sneakKey.isPressed();
        ClientPlayerEntity player = this.client.player;
        if (player != null && this.client.currentScreen == null) {
            PlayerYellowInklingComponent component = (PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(player);
            if (component.isInkling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (component.isDiving()) {
                    if (this.client.options.jumpKey.isPressed()) {
                        if (SplatterClient.launchStrength < 2.0F) {
                            SplatterClient.launchStrength += 0.1F;
                        }
                    } else if (SplatterClient.launchStrength > 0.0F && player.getWorld() != null) {
                        this.client.options.jumpKey.setPressed(false);
                        PacketByteBuf packet = PacketByteBufs.create();
                        packet.writeFloat(SplatterClient.launchStrength);
                        ClientPlayNetworking.send(Splatter.SERVERBOUND_LAUNCH_PACKET, packet);
                        SplatterClient.launchStrength = 0.0F;
                    }
                }
            }
        }
    }

    @Inject(
            method = {"sendSprintingPacket"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$preventBlackInkskinSprinting(CallbackInfo ci) {
        if (!((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"sendSprintingPacket"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$preventBlueInkskinSprinting(CallbackInfo ci) {
        if (!((PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"sendSprintingPacket"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$preventBrownInkskinSprinting(CallbackInfo ci) {
        if (!((PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"sendSprintingPacket"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$preventCyanInkskinSprinting(CallbackInfo ci) {
        if (!((PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"sendSprintingPacket"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$preventGrayInkskinSprinting(CallbackInfo ci) {
        if (!((PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"sendSprintingPacket"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$preventGreenInkskinSprinting(CallbackInfo ci) {
        if (!((PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"sendSprintingPacket"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$preventLightBlueInkskinSprinting(CallbackInfo ci) {
        if (!((PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"sendSprintingPacket"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$preventLightGrayInkskinSprinting(CallbackInfo ci) {
        if (!((PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"sendSprintingPacket"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$preventLimeInkskinSprinting(CallbackInfo ci) {
        if (!((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"sendSprintingPacket"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$preventMagentaInkskinSprinting(CallbackInfo ci) {
        if (!((PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"sendSprintingPacket"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$preventOrangeInkskinSprinting(CallbackInfo ci) {
        if (!((PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"sendSprintingPacket"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$preventPinkInkskinSprinting(CallbackInfo ci) {
        if (!((PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"sendSprintingPacket"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$preventPurpleInkskinSprinting(CallbackInfo ci) {
        if (!((PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"sendSprintingPacket"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$preventRedInkskinSprinting(CallbackInfo ci) {
        if (!((PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"sendSprintingPacket"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$preventWhiteInkskinSprinting(CallbackInfo ci) {
        if (!((PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"sendSprintingPacket"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$preventYellowInkskinSprinting(CallbackInfo ci) {
        if (!((PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }
}