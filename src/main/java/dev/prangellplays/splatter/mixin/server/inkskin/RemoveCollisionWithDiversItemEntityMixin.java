package dev.prangellplays.splatter.mixin.server.inkskin;

import dev.prangellplays.splatter.components.inkling.*;
import dev.prangellplays.splatter.components.octoling.*;
import dev.prangellplays.splatter.init.SplatterComponents;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({ItemEntity.class})
public class RemoveCollisionWithDiversItemEntityMixin {
    public RemoveCollisionWithDiversItemEntityMixin() {
    }

    @Inject(
            method = {"onPlayerCollision"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void onPlayerCollision(PlayerEntity player, CallbackInfo ci) {
        if (((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(player)).isDiving() || ((PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(player)).isDiving() || ((PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(player)).isDiving() || ((PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(player)).isDiving() || ((PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(player)).isDiving() || ((PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(player)).isDiving() || ((PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(player)).isDiving() || ((PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(player)).isDiving() || ((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(player)).isDiving() || ((PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(player)).isDiving() || ((PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(player)).isDiving() || ((PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(player)).isDiving() || ((PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(player)).isDiving() || ((PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(player)).isDiving() || ((PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(player)).isDiving() || ((PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(player)).isDiving()) {
            ci.cancel();
        }
    }
}