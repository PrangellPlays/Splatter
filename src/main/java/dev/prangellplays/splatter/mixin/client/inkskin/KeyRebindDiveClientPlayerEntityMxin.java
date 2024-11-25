package dev.prangellplays.splatter.mixin.client.inkskin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
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
public abstract class KeyRebindDiveClientPlayerEntityMxin {
    @Unique
    private boolean wasPressed = false;
    @Shadow
    @Final
    protected MinecraftClient client;

    @Shadow protected abstract boolean canSprint();

    public KeyRebindDiveClientPlayerEntityMxin() {
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void tickMovement(CallbackInfo ci) {
        boolean isPressed = this.client.options.sneakKey.isPressed();
        ClientPlayerEntity player = this.client.player;
        if (player != null && this.client.currentScreen == null) {
            PlayerBlackOctolingComponent blackComponent = (PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(player);
            if (blackComponent.isOctoling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (blackComponent.isDiving()) {
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

            PlayerBlueInklingComponent blueComponent = (PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(player);
            if (blueComponent.isInkling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (blueComponent.isDiving()) {
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

            PlayerBrownOctolingComponent brownComponent = (PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(player);
            if (brownComponent.isOctoling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (brownComponent.isDiving()) {
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

            PlayerCyanInklingComponent cyanComponent = (PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(player);
            if (cyanComponent.isInkling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (cyanComponent.isDiving()) {
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

            PlayerGrayOctolingComponent grayComponent = (PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(player);
            if (grayComponent.isOctoling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (grayComponent.isDiving()) {
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

            PlayerGreenInklingComponent greenComponent = (PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(player);
            if (greenComponent.isInkling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (greenComponent.isDiving()) {
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

            PlayerLightBlueOctolingComponent lightblueComponent = (PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(player);
            if (lightblueComponent.isOctoling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (lightblueComponent.isDiving()) {
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

            PlayerLightGrayOctolingComponent lightgrayComponent = (PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(player);
            if (lightgrayComponent.isOctoling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (lightgrayComponent.isDiving()) {
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

            PlayerLimeInklingComponent limeComponent = (PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(player);
            if (limeComponent.isInkling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (limeComponent.isDiving()) {
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

            PlayerMagentaOctolingComponent magentaComponent = (PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(player);
            if (magentaComponent.isOctoling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (magentaComponent.isDiving()) {
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

            PlayerOrangeInklingComponent orangeComponent = (PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(player);
            if (orangeComponent.isInkling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (orangeComponent.isDiving()) {
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

            PlayerPinkInklingComponent pinkComponent = (PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(player);
            if (pinkComponent.isInkling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (pinkComponent.isDiving()) {
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

            PlayerPurpleInklingComponent purpleComponent = (PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(player);
            if (purpleComponent.isInkling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (purpleComponent.isDiving()) {
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

            PlayerRedOctolingComponent redComponent = (PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(player);
            if (redComponent.isOctoling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (redComponent.isDiving()) {
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

            PlayerWhiteOctolingComponent whiteComponent = (PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(player);
            if (whiteComponent.isOctoling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (whiteComponent.isDiving()) {
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

            PlayerYellowInklingComponent yellowComponent = (PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(player);
            if (yellowComponent.isInkling() && this.client.player.isOnGround() && !player.isTouchingWater()) {
                if (!this.wasPressed && isPressed && player.getWorld() != null) {
                    player.setSprinting(false);
                    this.client.options.sneakKey.setPressed(false);
                    ClientPlayNetworking.send(Splatter.SERVERBOUND_DIVE_PACKET, PacketByteBufs.create());
                }

                if (yellowComponent.isDiving()) {
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

        this.wasPressed = isPressed;
    }

    /*@ModifyReturnValue(
            method = {"canSprint"},
            at = @At("RETURN")
    )

    private boolean splatter$preventSprinting(boolean original) {
        if (((PlayerInklingComponent) DefileComponents.INKLING.get(this)).isDiving()) {
            return false;
        }
        return original;
    }*/
}