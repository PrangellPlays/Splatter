package dev.prangellplays.splatter.mixin.client.inkskin;

import dev.prangellplays.splatter.components.inkling.*;
import dev.prangellplays.splatter.components.octoling.*;
import dev.prangellplays.splatter.init.SplatterComponents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.input.Input;
import net.minecraft.client.input.KeyboardInput;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin({KeyboardInput.class})
public class ResetSneakInputOnDiveKeyboardInputMixin extends Input {
    @Unique
    private static boolean ticked = false;
    @Shadow
    @Final
    private GameOptions settings;

    public ResetSneakInputOnDiveKeyboardInputMixin() {
    }

    @Inject(
            method = {"tick"},
            at = {@At("TAIL")}
    )
    public void splatter$disableSneakInputForBlackOctolingDive(boolean slowDown, float f, CallbackInfo ci) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(player)).isDiving()) {
            if (this.settings.sneakKey.isPressed()) {
                if (!ticked) {
                    this.sneaking = true;
                    ticked = true;
                } else {
                    this.sneaking = false;
                }
            } else {
                ticked = false;
            }
        }
    }

    @Inject(
            method = {"tick"},
            at = {@At("TAIL")}
    )
    public void splatter$disableSneakInputForBlueInklingDive(boolean slowDown, float f, CallbackInfo ci) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (((PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(player)).isDiving()) {
            if (this.settings.sneakKey.isPressed()) {
                if (!ticked) {
                    this.sneaking = true;
                    ticked = true;
                } else {
                    this.sneaking = false;
                }
            } else {
                ticked = false;
            }
        }
    }

    @Inject(
            method = {"tick"},
            at = {@At("TAIL")}
    )
    public void splatter$disableSneakInputForBrownOctolingDive(boolean slowDown, float f, CallbackInfo ci) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (((PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(player)).isDiving()) {
            if (this.settings.sneakKey.isPressed()) {
                if (!ticked) {
                    this.sneaking = true;
                    ticked = true;
                } else {
                    this.sneaking = false;
                }
            } else {
                ticked = false;
            }
        }
    }

    @Inject(
            method = {"tick"},
            at = {@At("TAIL")}
    )
    public void splatter$disableSneakInputForCyanInklingDive(boolean slowDown, float f, CallbackInfo ci) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (((PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(player)).isDiving()) {
            if (this.settings.sneakKey.isPressed()) {
                if (!ticked) {
                    this.sneaking = true;
                    ticked = true;
                } else {
                    this.sneaking = false;
                }
            } else {
                ticked = false;
            }
        }
    }

    @Inject(
            method = {"tick"},
            at = {@At("TAIL")}
    )
    public void splatter$disableSneakInputForGrayOctolingDive(boolean slowDown, float f, CallbackInfo ci) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (((PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(player)).isDiving()) {
            if (this.settings.sneakKey.isPressed()) {
                if (!ticked) {
                    this.sneaking = true;
                    ticked = true;
                } else {
                    this.sneaking = false;
                }
            } else {
                ticked = false;
            }
        }
    }

    @Inject(
            method = {"tick"},
            at = {@At("TAIL")}
    )
    public void splatter$disableSneakInputForGreenInklingDive(boolean slowDown, float f, CallbackInfo ci) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (((PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(player)).isDiving()) {
            if (this.settings.sneakKey.isPressed()) {
                if (!ticked) {
                    this.sneaking = true;
                    ticked = true;
                } else {
                    this.sneaking = false;
                }
            } else {
                ticked = false;
            }
        }
    }

    @Inject(
            method = {"tick"},
            at = {@At("TAIL")}
    )
    public void splatter$disableSneakInputForLightBlueOctolingDive(boolean slowDown, float f, CallbackInfo ci) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (((PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(player)).isDiving()) {
            if (this.settings.sneakKey.isPressed()) {
                if (!ticked) {
                    this.sneaking = true;
                    ticked = true;
                } else {
                    this.sneaking = false;
                }
            } else {
                ticked = false;
            }
        }
    }

    @Inject(
            method = {"tick"},
            at = {@At("TAIL")}
    )
    public void splatter$disableSneakInputForLightGrayOctolingDive(boolean slowDown, float f, CallbackInfo ci) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (((PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(player)).isDiving()) {
            if (this.settings.sneakKey.isPressed()) {
                if (!ticked) {
                    this.sneaking = true;
                    ticked = true;
                } else {
                    this.sneaking = false;
                }
            } else {
                ticked = false;
            }
        }
    }

    @Inject(
            method = {"tick"},
            at = {@At("TAIL")}
    )
    public void splatter$disableSneakInputForLimeInklingDive(boolean slowDown, float f, CallbackInfo ci) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(player)).isDiving()) {
            if (this.settings.sneakKey.isPressed()) {
                if (!ticked) {
                    this.sneaking = true;
                    ticked = true;
                } else {
                    this.sneaking = false;
                }
            } else {
                ticked = false;
            }
        }
    }

    @Inject(
            method = {"tick"},
            at = {@At("TAIL")}
    )
    public void splatter$disableSneakInputForMagentaOctolingDive(boolean slowDown, float f, CallbackInfo ci) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (((PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(player)).isDiving()) {
            if (this.settings.sneakKey.isPressed()) {
                if (!ticked) {
                    this.sneaking = true;
                    ticked = true;
                } else {
                    this.sneaking = false;
                }
            } else {
                ticked = false;
            }
        }
    }

    @Inject(
            method = {"tick"},
            at = {@At("TAIL")}
    )
    public void splatter$disableSneakInputForOrangeInklingDive(boolean slowDown, float f, CallbackInfo ci) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (((PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(player)).isDiving()) {
            if (this.settings.sneakKey.isPressed()) {
                if (!ticked) {
                    this.sneaking = true;
                    ticked = true;
                } else {
                    this.sneaking = false;
                }
            } else {
                ticked = false;
            }
        }
    }

    @Inject(
            method = {"tick"},
            at = {@At("TAIL")}
    )
    public void splatter$disableSneakInputForPinkInklingDive(boolean slowDown, float f, CallbackInfo ci) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (((PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(player)).isDiving()) {
            if (this.settings.sneakKey.isPressed()) {
                if (!ticked) {
                    this.sneaking = true;
                    ticked = true;
                } else {
                    this.sneaking = false;
                }
            } else {
                ticked = false;
            }
        }
    }

    @Inject(
            method = {"tick"},
            at = {@At("TAIL")}
    )
    public void splatter$disableSneakInputForPurpleInklingDive(boolean slowDown, float f, CallbackInfo ci) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (((PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(player)).isDiving()) {
            if (this.settings.sneakKey.isPressed()) {
                if (!ticked) {
                    this.sneaking = true;
                    ticked = true;
                } else {
                    this.sneaking = false;
                }
            } else {
                ticked = false;
            }
        }
    }

    @Inject(
            method = {"tick"},
            at = {@At("TAIL")}
    )
    public void splatter$disableSneakInputForRedOctolingDive(boolean slowDown, float f, CallbackInfo ci) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (((PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(player)).isDiving()) {
            if (this.settings.sneakKey.isPressed()) {
                if (!ticked) {
                    this.sneaking = true;
                    ticked = true;
                } else {
                    this.sneaking = false;
                }
            } else {
                ticked = false;
            }
        }
    }

    @Inject(
            method = {"tick"},
            at = {@At("TAIL")}
    )
    public void splatter$disableSneakInputForWhiteOctolingDive(boolean slowDown, float f, CallbackInfo ci) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (((PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(player)).isDiving()) {
            if (this.settings.sneakKey.isPressed()) {
                if (!ticked) {
                    this.sneaking = true;
                    ticked = true;
                } else {
                    this.sneaking = false;
                }
            } else {
                ticked = false;
            }
        }
    }

    @Inject(
            method = {"tick"},
            at = {@At("TAIL")}
    )
    public void splatter$disableSneakInputForYellowInklingDive(boolean slowDown, float f, CallbackInfo ci) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (((PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(player)).isDiving()) {
            if (this.settings.sneakKey.isPressed()) {
                if (!ticked) {
                    this.sneaking = true;
                    ticked = true;
                } else {
                    this.sneaking = false;
                }
            } else {
                ticked = false;
            }
        }
    }
}