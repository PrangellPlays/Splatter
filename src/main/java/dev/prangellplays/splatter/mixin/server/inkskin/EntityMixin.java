package dev.prangellplays.splatter.mixin.server.inkskin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.prangellplays.splatter.components.inkling.*;
import dev.prangellplays.splatter.components.octoling.*;
import dev.prangellplays.splatter.init.SplatterComponents;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({Entity.class})
public class EntityMixin {
    public EntityMixin() {
    }

    @Inject(
            method = {"pushAwayFrom"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$pushAwayFromBlackInkskin(Entity entity, CallbackInfo ci) {
        PlayerBlackOctolingComponent thisComponent = (PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.getNullable(this);
        PlayerBlackOctolingComponent entityComponent = (PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.getNullable(entity);
        if (thisComponent != null && thisComponent.isDiving() || entityComponent != null && entityComponent.isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"pushAwayFrom"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$pushAwayFromBlueInkskin(Entity entity, CallbackInfo ci) {
        PlayerBlueInklingComponent thisComponent = (PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.getNullable(this);
        PlayerBlueInklingComponent entityComponent = (PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.getNullable(entity);
        if (thisComponent != null && thisComponent.isDiving() || entityComponent != null && entityComponent.isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"pushAwayFrom"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$pushAwayFromBrownInkskin(Entity entity, CallbackInfo ci) {
        PlayerBrownOctolingComponent thisComponent = (PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.getNullable(this);
        PlayerBrownOctolingComponent entityComponent = (PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.getNullable(entity);
        if (thisComponent != null && thisComponent.isDiving() || entityComponent != null && entityComponent.isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"pushAwayFrom"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$pushAwayFromCyanInkskin(Entity entity, CallbackInfo ci) {
        PlayerCyanInklingComponent thisComponent = (PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.getNullable(this);
        PlayerCyanInklingComponent entityComponent = (PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.getNullable(entity);
        if (thisComponent != null && thisComponent.isDiving() || entityComponent != null && entityComponent.isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"pushAwayFrom"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$pushAwayFromGrayInkskin(Entity entity, CallbackInfo ci) {
        PlayerGrayOctolingComponent thisComponent = (PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.getNullable(this);
        PlayerGrayOctolingComponent entityComponent = (PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.getNullable(entity);
        if (thisComponent != null && thisComponent.isDiving() || entityComponent != null && entityComponent.isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"pushAwayFrom"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$pushAwayFromGreenInkskin(Entity entity, CallbackInfo ci) {
        PlayerGreenInklingComponent thisComponent = (PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.getNullable(this);
        PlayerGreenInklingComponent entityComponent = (PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.getNullable(entity);
        if (thisComponent != null && thisComponent.isDiving() || entityComponent != null && entityComponent.isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"pushAwayFrom"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$pushAwayFromLightBlueInkskin(Entity entity, CallbackInfo ci) {
        PlayerLightBlueOctolingComponent thisComponent = (PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.getNullable(this);
        PlayerLightBlueOctolingComponent entityComponent = (PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.getNullable(entity);
        if (thisComponent != null && thisComponent.isDiving() || entityComponent != null && entityComponent.isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"pushAwayFrom"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$pushAwayFromLightGrayInkskin(Entity entity, CallbackInfo ci) {
        PlayerLightGrayOctolingComponent thisComponent = (PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.getNullable(this);
        PlayerLightGrayOctolingComponent entityComponent = (PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.getNullable(entity);
        if (thisComponent != null && thisComponent.isDiving() || entityComponent != null && entityComponent.isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"pushAwayFrom"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$pushAwayFromLimeInkskin(Entity entity, CallbackInfo ci) {
        PlayerLimeInklingComponent thisComponent = (PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.getNullable(this);
        PlayerLimeInklingComponent entityComponent = (PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.getNullable(entity);
        if (thisComponent != null && thisComponent.isDiving() || entityComponent != null && entityComponent.isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"pushAwayFrom"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$pushAwayFromMagentaInkskin(Entity entity, CallbackInfo ci) {
        PlayerMagentaOctolingComponent thisComponent = (PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.getNullable(this);
        PlayerMagentaOctolingComponent entityComponent = (PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.getNullable(entity);
        if (thisComponent != null && thisComponent.isDiving() || entityComponent != null && entityComponent.isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"pushAwayFrom"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$pushAwayFromOrangeInkskin(Entity entity, CallbackInfo ci) {
        PlayerOrangeInklingComponent thisComponent = (PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.getNullable(this);
        PlayerOrangeInklingComponent entityComponent = (PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.getNullable(entity);
        if (thisComponent != null && thisComponent.isDiving() || entityComponent != null && entityComponent.isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"pushAwayFrom"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$pushAwayFromPinkInkskin(Entity entity, CallbackInfo ci) {
        PlayerPinkInklingComponent thisComponent = (PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.getNullable(this);
        PlayerPinkInklingComponent entityComponent = (PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.getNullable(entity);
        if (thisComponent != null && thisComponent.isDiving() || entityComponent != null && entityComponent.isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"pushAwayFrom"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$pushAwayFromPurpleInkskin(Entity entity, CallbackInfo ci) {
        PlayerPurpleInklingComponent thisComponent = (PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.getNullable(this);
        PlayerPurpleInklingComponent entityComponent = (PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.getNullable(entity);
        if (thisComponent != null && thisComponent.isDiving() || entityComponent != null && entityComponent.isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"pushAwayFrom"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$pushAwayFromRedInkskin(Entity entity, CallbackInfo ci) {
        PlayerRedOctolingComponent thisComponent = (PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.getNullable(this);
        PlayerRedOctolingComponent entityComponent = (PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.getNullable(entity);
        if (thisComponent != null && thisComponent.isDiving() || entityComponent != null && entityComponent.isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"pushAwayFrom"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$pushAwayFromWhiteInkskin(Entity entity, CallbackInfo ci) {
        PlayerWhiteOctolingComponent thisComponent = (PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.getNullable(this);
        PlayerWhiteOctolingComponent entityComponent = (PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.getNullable(entity);
        if (thisComponent != null && thisComponent.isDiving() || entityComponent != null && entityComponent.isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"pushAwayFrom"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$pushAwayFromYellowInkskin(Entity entity, CallbackInfo ci) {
        PlayerYellowInklingComponent thisComponent = (PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.getNullable(this);
        PlayerYellowInklingComponent entityComponent = (PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.getNullable(entity);
        if (thisComponent != null && thisComponent.isDiving() || entityComponent != null && entityComponent.isDiving()) {
            ci.cancel();
        }
    }


    @ModifyReturnValue(
            method = {"bypassesLandingEffects"},
            at = {@At("RETURN")}
    )
    public boolean splatter$bypassesLandingEffectsBlackInkskin(boolean original) {
        PlayerBlackOctolingComponent component = (PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.getNullable(this);
        return component != null && component.isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"bypassesLandingEffects"},
            at = {@At("RETURN")}
    )
    public boolean splatter$bypassesLandingEffectsBlueInkskin(boolean original) {
        PlayerBlueInklingComponent component = (PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.getNullable(this);
        return component != null && component.isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"bypassesLandingEffects"},
            at = {@At("RETURN")}
    )
    public boolean splatter$bypassesLandingEffectsBrownInkskin(boolean original) {
        PlayerBrownOctolingComponent component = (PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.getNullable(this);
        return component != null && component.isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"bypassesLandingEffects"},
            at = {@At("RETURN")}
    )
    public boolean splatter$bypassesLandingEffectsCyanInkskin(boolean original) {
        PlayerCyanInklingComponent component = (PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.getNullable(this);
        return component != null && component.isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"bypassesLandingEffects"},
            at = {@At("RETURN")}
    )
    public boolean splatter$bypassesLandingEffectsGrayInkskin(boolean original) {
        PlayerGrayOctolingComponent component = (PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.getNullable(this);
        return component != null && component.isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"bypassesLandingEffects"},
            at = {@At("RETURN")}
    )
    public boolean splatter$bypassesLandingEffectsGreenInkskin(boolean original) {
        PlayerGreenInklingComponent component = (PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.getNullable(this);
        return component != null && component.isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"bypassesLandingEffects"},
            at = {@At("RETURN")}
    )
    public boolean splatter$bypassesLandingEffectsLightBlueInkskin(boolean original) {
        PlayerLightBlueOctolingComponent component = (PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.getNullable(this);
        return component != null && component.isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"bypassesLandingEffects"},
            at = {@At("RETURN")}
    )
    public boolean splatter$bypassesLandingEffectsLightGrayInkskin(boolean original) {
        PlayerLightGrayOctolingComponent component = (PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.getNullable(this);
        return component != null && component.isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"bypassesLandingEffects"},
            at = {@At("RETURN")}
    )
    public boolean splatter$bypassesLandingEffectsLimeInkskin(boolean original) {
        PlayerLimeInklingComponent component = (PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.getNullable(this);
        return component != null && component.isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"bypassesLandingEffects"},
            at = {@At("RETURN")}
    )
    public boolean splatter$bypassesLandingEffectsMagentaInkskin(boolean original) {
        PlayerMagentaOctolingComponent component = (PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.getNullable(this);
        return component != null && component.isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"bypassesLandingEffects"},
            at = {@At("RETURN")}
    )
    public boolean splatter$bypassesLandingEffectsOrangeInkskin(boolean original) {
        PlayerOrangeInklingComponent component = (PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.getNullable(this);
        return component != null && component.isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"bypassesLandingEffects"},
            at = {@At("RETURN")}
    )
    public boolean splatter$bypassesLandingEffectsPinkInkskin(boolean original) {
        PlayerPinkInklingComponent component = (PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.getNullable(this);
        return component != null && component.isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"bypassesLandingEffects"},
            at = {@At("RETURN")}
    )
    public boolean splatter$bypassesLandingEffectsPurpleInkskin(boolean original) {
        PlayerPurpleInklingComponent component = (PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.getNullable(this);
        return component != null && component.isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"bypassesLandingEffects"},
            at = {@At("RETURN")}
    )
    public boolean splatter$bypassesLandingEffectsRedInkskin(boolean original) {
        PlayerRedOctolingComponent component = (PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.getNullable(this);
        return component != null && component.isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"bypassesLandingEffects"},
            at = {@At("RETURN")}
    )
    public boolean splatter$bypassesLandingEffectsWhiteInkskin(boolean original) {
        PlayerWhiteOctolingComponent component = (PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.getNullable(this);
        return component != null && component.isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"bypassesLandingEffects"},
            at = {@At("RETURN")}
    )
    public boolean splatter$bypassesLandingEffectsYellowInkskin(boolean original) {
        PlayerYellowInklingComponent component = (PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.getNullable(this);
        return component != null && component.isDiving() ? true : original;
    }
}