package dev.prangellplays.splatter.mixin.client.inkskin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.prangellplays.splatter.components.inkling.*;
import dev.prangellplays.splatter.components.octoling.*;
import dev.prangellplays.splatter.init.SplatterComponents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Environment(EnvType.CLIENT)
@Mixin({InGameHud.class})
public abstract class InkskinDisableHungerBarInGameHudMixin {
    public InkskinDisableHungerBarInGameHudMixin() {
    }

    @Shadow
    protected abstract PlayerEntity getCameraPlayer();

    @ModifyExpressionValue(
            method = {"renderStatusBars"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud;getHeartCount(Lnet/minecraft/entity/LivingEntity;)I"
            )}
    )
    private int splatter$disableBlackInkskinStatusBar(int original) {
        PlayerEntity playerEntity = this.getCameraPlayer();
        return ((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(playerEntity)).isOctoling() ? -1 : original;
    }

    @ModifyExpressionValue(
            method = {"renderStatusBars"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud;getHeartCount(Lnet/minecraft/entity/LivingEntity;)I"
            )}
    )
    private int splatter$disableBlueInkskinStatusBar(int original) {
        PlayerEntity playerEntity = this.getCameraPlayer();
        return ((PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(playerEntity)).isInkling() ? -1 : original;
    }

    @ModifyExpressionValue(
            method = {"renderStatusBars"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud;getHeartCount(Lnet/minecraft/entity/LivingEntity;)I"
            )}
    )
    private int splatter$disableBrownInkskinStatusBar(int original) {
        PlayerEntity playerEntity = this.getCameraPlayer();
        return ((PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(playerEntity)).isOctoling() ? -1 : original;
    }

    @ModifyExpressionValue(
            method = {"renderStatusBars"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud;getHeartCount(Lnet/minecraft/entity/LivingEntity;)I"
            )}
    )
    private int splatter$disableCyanInkskinStatusBar(int original) {
        PlayerEntity playerEntity = this.getCameraPlayer();
        return ((PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(playerEntity)).isInkling() ? -1 : original;
    }

    @ModifyExpressionValue(
            method = {"renderStatusBars"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud;getHeartCount(Lnet/minecraft/entity/LivingEntity;)I"
            )}
    )
    private int splatter$disableGrayInkskinStatusBar(int original) {
        PlayerEntity playerEntity = this.getCameraPlayer();
        return ((PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(playerEntity)).isOctoling() ? -1 : original;
    }

    @ModifyExpressionValue(
            method = {"renderStatusBars"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud;getHeartCount(Lnet/minecraft/entity/LivingEntity;)I"
            )}
    )
    private int splatter$disableGreenInkskinStatusBar(int original) {
        PlayerEntity playerEntity = this.getCameraPlayer();
        return ((PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(playerEntity)).isInkling() ? -1 : original;
    }

    @ModifyExpressionValue(
            method = {"renderStatusBars"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud;getHeartCount(Lnet/minecraft/entity/LivingEntity;)I"
            )}
    )
    private int splatter$disableLightBlueInkskinStatusBar(int original) {
        PlayerEntity playerEntity = this.getCameraPlayer();
        return ((PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(playerEntity)).isOctoling() ? -1 : original;
    }

    @ModifyExpressionValue(
            method = {"renderStatusBars"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud;getHeartCount(Lnet/minecraft/entity/LivingEntity;)I"
            )}
    )
    private int splatter$disableLightGrayInkskinStatusBar(int original) {
        PlayerEntity playerEntity = this.getCameraPlayer();
        return ((PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(playerEntity)).isOctoling() ? -1 : original;
    }

    @ModifyExpressionValue(
            method = {"renderStatusBars"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud;getHeartCount(Lnet/minecraft/entity/LivingEntity;)I"
            )}
    )
    private int splatter$disableLimeInkskinStatusBar(int original) {
        PlayerEntity playerEntity = this.getCameraPlayer();
        return ((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(playerEntity)).isInkling() ? -1 : original;
    }

    @ModifyExpressionValue(
            method = {"renderStatusBars"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud;getHeartCount(Lnet/minecraft/entity/LivingEntity;)I"
            )}
    )
    private int splatter$disableMagentaInkskinStatusBar(int original) {
        PlayerEntity playerEntity = this.getCameraPlayer();
        return ((PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(playerEntity)).isOctoling() ? -1 : original;
    }

    @ModifyExpressionValue(
            method = {"renderStatusBars"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud;getHeartCount(Lnet/minecraft/entity/LivingEntity;)I"
            )}
    )
    private int splatter$disableOrangeInkskinStatusBar(int original) {
        PlayerEntity playerEntity = this.getCameraPlayer();
        return ((PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(playerEntity)).isInkling() ? -1 : original;
    }

    @ModifyExpressionValue(
            method = {"renderStatusBars"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud;getHeartCount(Lnet/minecraft/entity/LivingEntity;)I"
            )}
    )
    private int splatter$disablePinkInkskinStatusBar(int original) {
        PlayerEntity playerEntity = this.getCameraPlayer();
        return ((PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(playerEntity)).isInkling() ? -1 : original;
    }

    @ModifyExpressionValue(
            method = {"renderStatusBars"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud;getHeartCount(Lnet/minecraft/entity/LivingEntity;)I"
            )}
    )
    private int splatter$disablePurpleInkskinStatusBar(int original) {
        PlayerEntity playerEntity = this.getCameraPlayer();
        return ((PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(playerEntity)).isInkling() ? -1 : original;
    }

    @ModifyExpressionValue(
            method = {"renderStatusBars"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud;getHeartCount(Lnet/minecraft/entity/LivingEntity;)I"
            )}
    )
    private int splatter$disableRedInkskinStatusBar(int original) {
        PlayerEntity playerEntity = this.getCameraPlayer();
        return ((PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(playerEntity)).isOctoling() ? -1 : original;
    }

    @ModifyExpressionValue(
            method = {"renderStatusBars"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud;getHeartCount(Lnet/minecraft/entity/LivingEntity;)I"
            )}
    )
    private int splatter$disableWhiteInkskinStatusBar(int original) {
        PlayerEntity playerEntity = this.getCameraPlayer();
        return ((PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(playerEntity)).isOctoling() ? -1 : original;
    }

    @ModifyExpressionValue(
            method = {"renderStatusBars"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud;getHeartCount(Lnet/minecraft/entity/LivingEntity;)I"
            )}
    )
    private int splatter$disableYellowInkskinStatusBar(int original) {
        PlayerEntity playerEntity = this.getCameraPlayer();
        return ((PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(playerEntity)).isInkling() ? -1 : original;
    }
}