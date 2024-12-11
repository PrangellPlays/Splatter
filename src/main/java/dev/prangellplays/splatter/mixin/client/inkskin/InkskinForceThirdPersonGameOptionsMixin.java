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
    public void splatter$forceThirdPersonForInkskinDiving(CallbackInfoReturnable<Perspective> cir) {
        if (((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving() || ((PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(MinecraftClient.getInstance().player)).isDiving() || ((PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving() || ((PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(MinecraftClient.getInstance().player)).isDiving() || ((PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving() || ((PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(MinecraftClient.getInstance().player)).isDiving() || ((PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving() || ((PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving() || ((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(MinecraftClient.getInstance().player)).isDiving() || ((PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving() || ((PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(MinecraftClient.getInstance().player)).isDiving() || ((PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(MinecraftClient.getInstance().player)).isDiving() || ((PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(MinecraftClient.getInstance().player)).isDiving() || ((PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving() || ((PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving() || ((PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(MinecraftClient.getInstance().player)).isDiving()) {
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