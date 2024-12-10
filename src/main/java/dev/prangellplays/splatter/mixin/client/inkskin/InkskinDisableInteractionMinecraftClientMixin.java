package dev.prangellplays.splatter.mixin.client.inkskin;

import dev.prangellplays.splatter.components.inkling.*;
import dev.prangellplays.splatter.components.octoling.*;
import dev.prangellplays.splatter.init.SplatterComponents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin({MinecraftClient.class})
public class InkskinDisableInteractionMinecraftClientMixin {
    @Shadow
    public @Nullable ClientPlayerEntity player;

    public InkskinDisableInteractionMinecraftClientMixin() {
    }

    @Inject(
            method = {"doItemUse"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$interactBlockBlackInkskin(CallbackInfo ci) {
        if (((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(this.player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"doItemUse"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$interactBlockBlueInkskin(CallbackInfo ci) {
        if (((PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(this.player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"doItemUse"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$interactBlockBrownInkskin(CallbackInfo ci) {
        if (((PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(this.player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"doItemUse"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$interactBlockCyanInkskin(CallbackInfo ci) {
        if (((PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(this.player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"doItemUse"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$interactBlockGrayInkskin(CallbackInfo ci) {
        if (((PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(this.player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"doItemUse"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$interactBlockGreenInkskin(CallbackInfo ci) {
        if (((PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(this.player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"doItemUse"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$interactBlockLightBlueInkskin(CallbackInfo ci) {
        if (((PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(this.player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"doItemUse"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$interactBlockLightGrayInkskin(CallbackInfo ci) {
        if (((PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(this.player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"doItemUse"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$interactBlockLimeInkskin(CallbackInfo ci) {
        if (((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(this.player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"doItemUse"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$interactBlockMagentaInkskin(CallbackInfo ci) {
        if (((PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(this.player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"doItemUse"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$interactBlockOrangeInkskin(CallbackInfo ci) {
        if (((PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(this.player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"doItemUse"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$interactBlockPinkInkskin(CallbackInfo ci) {
        if (((PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(this.player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"doItemUse"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$interactBlockPurpleInkskin(CallbackInfo ci) {
        if (((PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(this.player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"doItemUse"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$interactBlockRedInkskin(CallbackInfo ci) {
        if (((PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(this.player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"doItemUse"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$interactBlockWhiteInkskin(CallbackInfo ci) {
        if (((PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(this.player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"doItemUse"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$interactBlockYellowInkskin(CallbackInfo ci) {
        if (((PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(this.player)).isDiving()) {
            ci.cancel();
        }
    }
}