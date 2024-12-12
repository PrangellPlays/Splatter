package dev.prangellplays.splatter.mixin.server.inkskin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.prangellplays.splatter.components.inkling.*;
import dev.prangellplays.splatter.components.octoling.*;
import dev.prangellplays.splatter.init.SplatterComponents;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({ServerPlayNetworkHandler.class})
public class ServerPlayNetworkHandlerMixin {
    @Shadow
    public ServerPlayerEntity player;

    public ServerPlayNetworkHandlerMixin() {
    }

    @ModifyExpressionValue(
            method = {"onPlayerMove"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecr aft/server/network/ServerPlayerInteractionManager;isCreative()Z"
            )}
    )
    public boolean onPlayerMove(boolean original) {
        return original || ((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(this.player)).isOctoling() || ((PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(this.player)).isInkling() || ((PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(this.player)).isOctoling() || ((PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(this.player)).isInkling() || ((PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(this.player)).isOctoling() || ((PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(this.player)).isInkling() || ((PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(this.player)).isOctoling() || ((PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(this.player)).isOctoling() || ((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(this.player)).isInkling() || ((PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(this.player)).isOctoling() || ((PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(this.player)).isInkling() || ((PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(this.player)).isInkling() || ((PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(this.player)).isInkling() || ((PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(this.player)).isOctoling() || ((PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(this.player)).isOctoling() || ((PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(this.player)).isInkling();
    }
}