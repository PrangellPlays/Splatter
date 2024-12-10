package dev.prangellplays.splatter.mixin.client.inkskin;

import dev.prangellplays.splatter.components.inkling.*;
import dev.prangellplays.splatter.components.octoling.*;
import dev.prangellplays.splatter.init.SplatterComponents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.Perspective;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin({GameOptions.class})
public abstract class InkskinForceThirdPersonGameOptionsMixin {
    @Unique
    private static boolean revertToFirstPersonWhenOut;
    @Shadow
    private Perspective perspective;

    public InkskinForceThirdPersonGameOptionsMixin() {
    }

    @Shadow
    public abstract void setPerspective(Perspective var1);

    @Inject(
            method = {"getPerspective"},
            at = {@At("HEAD")}
    )
    public void splatter$forceThirdPersonForBlackInkskinDiving(CallbackInfoReturnable<Perspective> cir) {
        if (((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            if (this.perspective.isFirstPerson()) {
                revertToFirstPersonWhenOut = true;
                this.setPerspective(Perspective.THIRD_PERSON_BACK);
            }
        } else if (revertToFirstPersonWhenOut) {
            this.setPerspective(Perspective.FIRST_PERSON);
            revertToFirstPersonWhenOut = false;
        }
    }

    @Inject(
            method = {"getPerspective"},
            at = {@At("HEAD")}
    )
    public void splatter$forceThirdPersonForBlueInkskinDiving(CallbackInfoReturnable<Perspective> cir) {
        if (((PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            if (this.perspective.isFirstPerson()) {
                revertToFirstPersonWhenOut = true;
                this.setPerspective(Perspective.THIRD_PERSON_BACK);
            }
        } else if (revertToFirstPersonWhenOut) {
            this.setPerspective(Perspective.FIRST_PERSON);
            revertToFirstPersonWhenOut = false;
        }
    }

    @Inject(
            method = {"getPerspective"},
            at = {@At("HEAD")}
    )
    public void splatter$forceThirdPersonForBrownInkskinDiving(CallbackInfoReturnable<Perspective> cir) {
        if (((PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            if (this.perspective.isFirstPerson()) {
                revertToFirstPersonWhenOut = true;
                this.setPerspective(Perspective.THIRD_PERSON_BACK);
            }
        } else if (revertToFirstPersonWhenOut) {
            this.setPerspective(Perspective.FIRST_PERSON);
            revertToFirstPersonWhenOut = false;
        }
    }

    @Inject(
            method = {"getPerspective"},
            at = {@At("HEAD")}
    )
    public void splatter$forceThirdPersonForCyanInkskinDiving(CallbackInfoReturnable<Perspective> cir) {
        if (((PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            if (this.perspective.isFirstPerson()) {
                revertToFirstPersonWhenOut = true;
                this.setPerspective(Perspective.THIRD_PERSON_BACK);
            }
        } else if (revertToFirstPersonWhenOut) {
            this.setPerspective(Perspective.FIRST_PERSON);
            revertToFirstPersonWhenOut = false;
        }
    }

    @Inject(
            method = {"getPerspective"},
            at = {@At("HEAD")}
    )
    public void splatter$forceThirdPersonForGrayInkskinDiving(CallbackInfoReturnable<Perspective> cir) {
        if (((PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            if (this.perspective.isFirstPerson()) {
                revertToFirstPersonWhenOut = true;
                this.setPerspective(Perspective.THIRD_PERSON_BACK);
            }
        } else if (revertToFirstPersonWhenOut) {
            this.setPerspective(Perspective.FIRST_PERSON);
            revertToFirstPersonWhenOut = false;
        }
    }

    @Inject(
            method = {"getPerspective"},
            at = {@At("HEAD")}
    )
    public void splatter$forceThirdPersonForGreenInkskinDiving(CallbackInfoReturnable<Perspective> cir) {
        if (((PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            if (this.perspective.isFirstPerson()) {
                revertToFirstPersonWhenOut = true;
                this.setPerspective(Perspective.THIRD_PERSON_BACK);
            }
        } else if (revertToFirstPersonWhenOut) {
            this.setPerspective(Perspective.FIRST_PERSON);
            revertToFirstPersonWhenOut = false;
        }
    }

    @Inject(
            method = {"getPerspective"},
            at = {@At("HEAD")}
    )
    public void splatter$forceThirdPersonForLightBlueInkskinDiving(CallbackInfoReturnable<Perspective> cir) {
        if (((PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            if (this.perspective.isFirstPerson()) {
                revertToFirstPersonWhenOut = true;
                this.setPerspective(Perspective.THIRD_PERSON_BACK);
            }
        } else if (revertToFirstPersonWhenOut) {
            this.setPerspective(Perspective.FIRST_PERSON);
            revertToFirstPersonWhenOut = false;
        }
    }

    @Inject(
            method = {"getPerspective"},
            at = {@At("HEAD")}
    )
    public void splatter$forceThirdPersonForLightGrayInkskinDiving(CallbackInfoReturnable<Perspective> cir) {
        if (((PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            if (this.perspective.isFirstPerson()) {
                revertToFirstPersonWhenOut = true;
                this.setPerspective(Perspective.THIRD_PERSON_BACK);
            }
        } else if (revertToFirstPersonWhenOut) {
            this.setPerspective(Perspective.FIRST_PERSON);
            revertToFirstPersonWhenOut = false;
        }
    }

    @Inject(
            method = {"getPerspective"},
            at = {@At("HEAD")}
    )
    public void splatter$forceThirdPersonForLimeInkskinDiving(CallbackInfoReturnable<Perspective> cir) {
        if (((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            if (this.perspective.isFirstPerson()) {
                revertToFirstPersonWhenOut = true;
                this.setPerspective(Perspective.THIRD_PERSON_BACK);
            }
        } else if (revertToFirstPersonWhenOut) {
            this.setPerspective(Perspective.FIRST_PERSON);
            revertToFirstPersonWhenOut = false;
        }
    }

    @Inject(
            method = {"getPerspective"},
            at = {@At("HEAD")}
    )
    public void splatter$forceThirdPersonForMagentaInkskinDiving(CallbackInfoReturnable<Perspective> cir) {
        if (((PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            if (this.perspective.isFirstPerson()) {
                revertToFirstPersonWhenOut = true;
                this.setPerspective(Perspective.THIRD_PERSON_BACK);
            }
        } else if (revertToFirstPersonWhenOut) {
            this.setPerspective(Perspective.FIRST_PERSON);
            revertToFirstPersonWhenOut = false;
        }
    }

    @Inject(
            method = {"getPerspective"},
            at = {@At("HEAD")}
    )
    public void splatter$forceThirdPersonForOrangeInkskinDiving(CallbackInfoReturnable<Perspective> cir) {
        if (((PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            if (this.perspective.isFirstPerson()) {
                revertToFirstPersonWhenOut = true;
                this.setPerspective(Perspective.THIRD_PERSON_BACK);
            }
        } else if (revertToFirstPersonWhenOut) {
            this.setPerspective(Perspective.FIRST_PERSON);
            revertToFirstPersonWhenOut = false;
        }
    }

    @Inject(
            method = {"getPerspective"},
            at = {@At("HEAD")}
    )
    public void splatter$forceThirdPersonForPinkInkskinDiving(CallbackInfoReturnable<Perspective> cir) {
        if (((PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            if (this.perspective.isFirstPerson()) {
                revertToFirstPersonWhenOut = true;
                this.setPerspective(Perspective.THIRD_PERSON_BACK);
            }
        } else if (revertToFirstPersonWhenOut) {
            this.setPerspective(Perspective.FIRST_PERSON);
            revertToFirstPersonWhenOut = false;
        }
    }

    @Inject(
            method = {"getPerspective"},
            at = {@At("HEAD")}
    )
    public void splatter$forceThirdPersonForPurpleInkskinDiving(CallbackInfoReturnable<Perspective> cir) {
        if (((PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            if (this.perspective.isFirstPerson()) {
                revertToFirstPersonWhenOut = true;
                this.setPerspective(Perspective.THIRD_PERSON_BACK);
            }
        } else if (revertToFirstPersonWhenOut) {
            this.setPerspective(Perspective.FIRST_PERSON);
            revertToFirstPersonWhenOut = false;
        }
    }

    @Inject(
            method = {"getPerspective"},
            at = {@At("HEAD")}
    )
    public void splatter$forceThirdPersonForRedInkskinDiving(CallbackInfoReturnable<Perspective> cir) {
        if (((PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            if (this.perspective.isFirstPerson()) {
                revertToFirstPersonWhenOut = true;
                this.setPerspective(Perspective.THIRD_PERSON_BACK);
            }
        } else if (revertToFirstPersonWhenOut) {
            this.setPerspective(Perspective.FIRST_PERSON);
            revertToFirstPersonWhenOut = false;
        }
    }

    @Inject(
            method = {"getPerspective"},
            at = {@At("HEAD")}
    )
    public void splatter$forceThirdPersonForWhiteInkskinDiving(CallbackInfoReturnable<Perspective> cir) {
        if (((PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            if (this.perspective.isFirstPerson()) {
                revertToFirstPersonWhenOut = true;
                this.setPerspective(Perspective.THIRD_PERSON_BACK);
            }
        } else if (revertToFirstPersonWhenOut) {
            this.setPerspective(Perspective.FIRST_PERSON);
            revertToFirstPersonWhenOut = false;
        }
    }

    @Inject(
            method = {"getPerspective"},
            at = {@At("HEAD")}
    )
    public void splatter$forceThirdPersonForYellowInkskinDiving(CallbackInfoReturnable<Perspective> cir) {
        if (((PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            if (this.perspective.isFirstPerson()) {
                revertToFirstPersonWhenOut = true;
                this.setPerspective(Perspective.THIRD_PERSON_BACK);
            }
        } else if (revertToFirstPersonWhenOut) {
            this.setPerspective(Perspective.FIRST_PERSON);
            revertToFirstPersonWhenOut = false;
        }
    }
}