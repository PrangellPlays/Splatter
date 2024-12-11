package dev.prangellplays.splatter.mixin.server.inkskin;

import dev.prangellplays.splatter.components.inkling.*;
import dev.prangellplays.splatter.components.octoling.*;
import dev.prangellplays.splatter.init.SplatterComponents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({Entity.class})
public abstract class AdjustDivingInkskinEyeHeightEntityMixin {
    @Shadow @Nullable public abstract MinecraftServer getServer();

    @Shadow @Nullable public abstract LivingEntity getControllingPassenger();

    public AdjustDivingInkskinEyeHeightEntityMixin() {
    }

    @Inject(
            method = {"getStandingEyeHeight"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingBlackInkskinEyeHeight(CallbackInfoReturnable<Float> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerBlackOctolingComponent component = (PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(0.5F);
            }
        }
    }

    @Inject(
            method = {"getStandingEyeHeight"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingBlueInkskinEyeHeight(CallbackInfoReturnable<Float> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerBlueInklingComponent component = (PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(0.5F);
            }
        }
    }

    @Inject(
            method = {"getStandingEyeHeight"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingBrownInkskinEyeHeight(CallbackInfoReturnable<Float> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerBrownOctolingComponent component = (PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(0.5F);
            }
        }
    }

    @Inject(
            method = {"getStandingEyeHeight"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingCyanInkskinEyeHeight(CallbackInfoReturnable<Float> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerCyanInklingComponent component = (PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(0.5F);
            }
        }
    }

    @Inject(
            method = {"getStandingEyeHeight"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingGrayInkskinEyeHeight(CallbackInfoReturnable<Float> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerGrayOctolingComponent component = (PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(0.5F);
            }
        }
    }

    @Inject(
            method = {"getStandingEyeHeight"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingGreenInkskinEyeHeight(CallbackInfoReturnable<Float> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerGreenInklingComponent component = (PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(0.5F);
            }
        }
    }

    @Inject(
            method = {"getStandingEyeHeight"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingLightBlueInkskinEyeHeight(CallbackInfoReturnable<Float> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerLightBlueOctolingComponent component = (PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(0.5F);
            }
        }
    }

    @Inject(
            method = {"getStandingEyeHeight"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingLightGrayInkskinEyeHeight(CallbackInfoReturnable<Float> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerLightGrayOctolingComponent component = (PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(0.5F);
            }
        }
    }

    @Inject(
            method = {"getStandingEyeHeight"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingLimeInkskinEyeHeight(CallbackInfoReturnable<Float> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerLimeInklingComponent component = (PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(0.5F);
            }
        }
    }

    @Inject(
            method = {"getStandingEyeHeight"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingMagentaInkskinEyeHeight(CallbackInfoReturnable<Float> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerMagentaOctolingComponent component = (PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(0.5F);
            }
        }
    }

    @Inject(
            method = {"getStandingEyeHeight"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingOrangeInkskinEyeHeight(CallbackInfoReturnable<Float> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerOrangeInklingComponent component = (PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(0.5F);
            }
        }
    }

    @Inject(
            method = {"getStandingEyeHeight"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingPinkInkskinEyeHeight(CallbackInfoReturnable<Float> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerPinkInklingComponent component = (PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(0.5F);
            }
        }
    }

    @Inject(
            method = {"getStandingEyeHeight"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingPurpleInkskinEyeHeight(CallbackInfoReturnable<Float> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerPurpleInklingComponent component = (PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(0.5F);
            }
        }
    }

    @Inject(
            method = {"getStandingEyeHeight"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingRedInkskinEyeHeight(CallbackInfoReturnable<Float> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerRedOctolingComponent component = (PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(0.5F);
            }
        }
    }

    @Inject(
            method = {"getStandingEyeHeight"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingWhiteInkskinEyeHeight(CallbackInfoReturnable<Float> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerWhiteOctolingComponent component = (PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(0.5F);
            }
        }
    }

    @Inject(
            method = {"getStandingEyeHeight"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingYellowInkskinEyeHeight(CallbackInfoReturnable<Float> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerYellowInklingComponent component = (PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(0.5F);
            }
        }
    }


    @Inject(
            method = {"getEyeY"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingBlackInkskinEyeY(CallbackInfoReturnable<Double> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerBlackOctolingComponent component = (PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(player.getY() + 0.5);
            }
        }
    }

    @Inject(
            method = {"getEyeY"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingBlueInkskinEyeY(CallbackInfoReturnable<Double> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerBlueInklingComponent component = (PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(player.getY() + 0.5);
            }
        }
    }

    @Inject(
            method = {"getEyeY"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingBrownInkskinEyeY(CallbackInfoReturnable<Double> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerBrownOctolingComponent component = (PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(player.getY() + 0.5);
            }
        }
    }

    @Inject(
            method = {"getEyeY"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingCyanInkskinEyeY(CallbackInfoReturnable<Double> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerCyanInklingComponent component = (PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(player.getY() + 0.5);
            }
        }
    }

    @Inject(
            method = {"getEyeY"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingGrayInkskinEyeY(CallbackInfoReturnable<Double> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerGrayOctolingComponent component = (PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(player.getY() + 0.5);
            }
        }
    }

    @Inject(
            method = {"getEyeY"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingGreenInkskinEyeY(CallbackInfoReturnable<Double> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerGreenInklingComponent component = (PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(player.getY() + 0.5);
            }
        }
    }

    @Inject(
            method = {"getEyeY"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingLightBlueInkskinEyeY(CallbackInfoReturnable<Double> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerLightBlueOctolingComponent component = (PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(player.getY() + 0.5);
            }
        }
    }

    @Inject(
            method = {"getEyeY"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingLightGrayInkskinEyeY(CallbackInfoReturnable<Double> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerLightGrayOctolingComponent component = (PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(player.getY() + 0.5);
            }
        }
    }

    @Inject(
            method = {"getEyeY"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingLimeInkskinEyeY(CallbackInfoReturnable<Double> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerLimeInklingComponent component = (PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(player.getY() + 0.5);
            }
        }
    }

    @Inject(
            method = {"getEyeY"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingMagentaInkskinEyeY(CallbackInfoReturnable<Double> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerMagentaOctolingComponent component = (PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(player.getY() + 0.5);
            }
        }
    }

    @Inject(
            method = {"getEyeY"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingOrangeInkskinEyeY(CallbackInfoReturnable<Double> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerOrangeInklingComponent component = (PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(player.getY() + 0.5);
            }
        }
    }

    @Inject(
            method = {"getEyeY"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingPinkInkskinEyeY(CallbackInfoReturnable<Double> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerPinkInklingComponent component = (PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(player.getY() + 0.5);
            }
        }
    }

    @Inject(
            method = {"getEyeY"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingPurpleInkskinEyeY(CallbackInfoReturnable<Double> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerPurpleInklingComponent component = (PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(player.getY() + 0.5);
            }
        }
    }

    @Inject(
            method = {"getEyeY"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingRedInkskinEyeY(CallbackInfoReturnable<Double> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerRedOctolingComponent component = (PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(player.getY() + 0.5);
            }
        }
    }

    @Inject(
            method = {"getEyeY"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingWhiteInkskinEyeY(CallbackInfoReturnable<Double> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerWhiteOctolingComponent component = (PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(player.getY() + 0.5);
            }
        }
    }

    @Inject(
            method = {"getEyeY"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$adjustDivingYellowInkskinEyeY(CallbackInfoReturnable<Double> cir) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerYellowInklingComponent component = (PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(player);
            if (component.isDiving()) {
                cir.setReturnValue(player.getY() + 0.5);
            }
        }
    }
}