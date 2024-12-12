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
        if (((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(this)).isDiving() || ((PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(this)).isDiving() || ((PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(this)).isDiving() || ((PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(this)).isDiving() || ((PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(this)).isDiving() || ((PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(this)).isDiving() || ((PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(this)).isDiving() || ((PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(this)).isDiving() || ((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(this)).isDiving() || ((PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(this)).isDiving() || ((PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(this)).isDiving() || ((PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(this)).isDiving() || ((PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(this)).isDiving() || ((PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(this)).isDiving() || ((PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(this)).isDiving() || ((PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }
}