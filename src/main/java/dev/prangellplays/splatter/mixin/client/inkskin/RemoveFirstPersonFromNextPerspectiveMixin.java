package dev.prangellplays.splatter.mixin.client.inkskin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.prangellplays.splatter.components.inkling.*;
import dev.prangellplays.splatter.components.octoling.*;
import dev.prangellplays.splatter.init.SplatterComponents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.Perspective;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Environment(EnvType.CLIENT)
@Mixin({Perspective.class})
public class RemoveFirstPersonFromNextPerspectiveMixin {
    public RemoveFirstPersonFromNextPerspectiveMixin() {
    }

    @ModifyReturnValue(
            method = {"next"},
            at = {@At("RETURN")}
    )
    public Perspective splatter$nextPerspectiveBlackInkskin(Perspective original) {
        if (((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            return MinecraftClient.getInstance().options.getPerspective() == Perspective.THIRD_PERSON_BACK ? Perspective.THIRD_PERSON_FRONT : Perspective.THIRD_PERSON_BACK;
        } else {
            return original;
        }
    }

    @ModifyReturnValue(
            method = {"next"},
            at = {@At("RETURN")}
    )
    public Perspective splatter$nextPerspectiveBlueInkskin(Perspective original) {
        if (((PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            return MinecraftClient.getInstance().options.getPerspective() == Perspective.THIRD_PERSON_BACK ? Perspective.THIRD_PERSON_FRONT : Perspective.THIRD_PERSON_BACK;
        } else {
            return original;
        }
    }

    @ModifyReturnValue(
            method = {"next"},
            at = {@At("RETURN")}
    )
    public Perspective splatter$nextPerspectiveBrownInkskin(Perspective original) {
        if (((PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            return MinecraftClient.getInstance().options.getPerspective() == Perspective.THIRD_PERSON_BACK ? Perspective.THIRD_PERSON_FRONT : Perspective.THIRD_PERSON_BACK;
        } else {
            return original;
        }
    }

    @ModifyReturnValue(
            method = {"next"},
            at = {@At("RETURN")}
    )
    public Perspective splatter$nextPerspectiveCyanInkskin(Perspective original) {
        if (((PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            return MinecraftClient.getInstance().options.getPerspective() == Perspective.THIRD_PERSON_BACK ? Perspective.THIRD_PERSON_FRONT : Perspective.THIRD_PERSON_BACK;
        } else {
            return original;
        }
    }

    @ModifyReturnValue(
            method = {"next"},
            at = {@At("RETURN")}
    )
    public Perspective splatter$nextPerspectiveGrayInkskin(Perspective original) {
        if (((PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            return MinecraftClient.getInstance().options.getPerspective() == Perspective.THIRD_PERSON_BACK ? Perspective.THIRD_PERSON_FRONT : Perspective.THIRD_PERSON_BACK;
        } else {
            return original;
        }
    }

    @ModifyReturnValue(
            method = {"next"},
            at = {@At("RETURN")}
    )
    public Perspective splatter$nextPerspectiveGreenInkskin(Perspective original) {
        if (((PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            return MinecraftClient.getInstance().options.getPerspective() == Perspective.THIRD_PERSON_BACK ? Perspective.THIRD_PERSON_FRONT : Perspective.THIRD_PERSON_BACK;
        } else {
            return original;
        }
    }

    @ModifyReturnValue(
            method = {"next"},
            at = {@At("RETURN")}
    )
    public Perspective splatter$nextPerspectiveLightBlueInkskin(Perspective original) {
        if (((PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            return MinecraftClient.getInstance().options.getPerspective() == Perspective.THIRD_PERSON_BACK ? Perspective.THIRD_PERSON_FRONT : Perspective.THIRD_PERSON_BACK;
        } else {
            return original;
        }
    }

    @ModifyReturnValue(
            method = {"next"},
            at = {@At("RETURN")}
    )
    public Perspective splatter$nextPerspectiveLightGrayInkskin(Perspective original) {
        if (((PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            return MinecraftClient.getInstance().options.getPerspective() == Perspective.THIRD_PERSON_BACK ? Perspective.THIRD_PERSON_FRONT : Perspective.THIRD_PERSON_BACK;
        } else {
            return original;
        }
    }

    @ModifyReturnValue(
            method = {"next"},
            at = {@At("RETURN")}
    )
    public Perspective splatter$nextPerspectiveLimeInkskin(Perspective original) {
        if (((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            return MinecraftClient.getInstance().options.getPerspective() == Perspective.THIRD_PERSON_BACK ? Perspective.THIRD_PERSON_FRONT : Perspective.THIRD_PERSON_BACK;
        } else {
            return original;
        }
    }

    @ModifyReturnValue(
            method = {"next"},
            at = {@At("RETURN")}
    )
    public Perspective splatter$nextPerspectiveMagentaInkskin(Perspective original) {
        if (((PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            return MinecraftClient.getInstance().options.getPerspective() == Perspective.THIRD_PERSON_BACK ? Perspective.THIRD_PERSON_FRONT : Perspective.THIRD_PERSON_BACK;
        } else {
            return original;
        }
    }

    @ModifyReturnValue(
            method = {"next"},
            at = {@At("RETURN")}
    )
    public Perspective splatter$nextPerspectiveOrangeInkskin(Perspective original) {
        if (((PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            return MinecraftClient.getInstance().options.getPerspective() == Perspective.THIRD_PERSON_BACK ? Perspective.THIRD_PERSON_FRONT : Perspective.THIRD_PERSON_BACK;
        } else {
            return original;
        }
    }

    @ModifyReturnValue(
            method = {"next"},
            at = {@At("RETURN")}
    )
    public Perspective splatter$nextPerspectivePinkInkskin(Perspective original) {
        if (((PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            return MinecraftClient.getInstance().options.getPerspective() == Perspective.THIRD_PERSON_BACK ? Perspective.THIRD_PERSON_FRONT : Perspective.THIRD_PERSON_BACK;
        } else {
            return original;
        }
    }

    @ModifyReturnValue(
            method = {"next"},
            at = {@At("RETURN")}
    )
    public Perspective splatter$nextPerspectivePurpleInkskin(Perspective original) {
        if (((PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            return MinecraftClient.getInstance().options.getPerspective() == Perspective.THIRD_PERSON_BACK ? Perspective.THIRD_PERSON_FRONT : Perspective.THIRD_PERSON_BACK;
        } else {
            return original;
        }
    }

    @ModifyReturnValue(
            method = {"next"},
            at = {@At("RETURN")}
    )
    public Perspective splatter$nextPerspectiveRedInkskin(Perspective original) {
        if (((PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            return MinecraftClient.getInstance().options.getPerspective() == Perspective.THIRD_PERSON_BACK ? Perspective.THIRD_PERSON_FRONT : Perspective.THIRD_PERSON_BACK;
        } else {
            return original;
        }
    }

    @ModifyReturnValue(
            method = {"next"},
            at = {@At("RETURN")}
    )
    public Perspective splatter$nextPerspectiveWhiteInkskin(Perspective original) {
        if (((PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            return MinecraftClient.getInstance().options.getPerspective() == Perspective.THIRD_PERSON_BACK ? Perspective.THIRD_PERSON_FRONT : Perspective.THIRD_PERSON_BACK;
        } else {
            return original;
        }
    }

    @ModifyReturnValue(
            method = {"next"},
            at = {@At("RETURN")}
    )
    public Perspective splatter$nextPerspectiveYellowInkskin(Perspective original) {
        if (((PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            return MinecraftClient.getInstance().options.getPerspective() == Perspective.THIRD_PERSON_BACK ? Perspective.THIRD_PERSON_FRONT : Perspective.THIRD_PERSON_BACK;
        } else {
            return original;
        }
    }
}