package dev.prangellplays.splatter.mixin.server.inkskin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.prangellplays.splatter.components.inkling.*;
import dev.prangellplays.splatter.components.octoling.*;
import dev.prangellplays.splatter.init.SplatterComponents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({MobEntity.class})
public class DisableMobTargetingInkskinDiversMobEntityMixin {
    @Shadow
    private @Nullable LivingEntity target;

    public DisableMobTargetingInkskinDiversMobEntityMixin() {
    }

    @Inject(
            method = {"setTarget"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$disableSetTargetForDivingInkskins(LivingEntity target, CallbackInfo ci) {
        if (target instanceof PlayerEntity player) {
            if (((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(player)).isDiving() || ((PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(player)).isDiving() || ((PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(player)).isDiving() || ((PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(player)).isDiving() || ((PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(player)).isDiving() || ((PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(player)).isDiving() || ((PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(player)).isDiving() || ((PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(player)).isDiving() || ((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(player)).isDiving() || ((PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(player)).isDiving() || ((PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(player)).isDiving() || ((PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(player)).isDiving() || ((PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(player)).isDiving() || ((PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(player)).isDiving() || ((PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(player)).isDiving() || ((PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(player)).isDiving()) {
                ci.cancel();
            }
        }

    }

    @ModifyReturnValue(
            method = {"getTarget"},
            at = {@At("RETURN")}
    )
    public LivingEntity splatter$resetTargetIfDivingInkskins(LivingEntity original) {
        LivingEntity var3 = this.target;
        if (var3 instanceof PlayerEntity player) {
            if (((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(player)).isDiving() || ((PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(player)).isDiving() || ((PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(player)).isDiving() || ((PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(player)).isDiving() || ((PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(player)).isDiving() || ((PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(player)).isDiving() || ((PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(player)).isDiving() || ((PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(player)).isDiving() || ((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(player)).isDiving() || ((PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(player)).isDiving() || ((PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(player)).isDiving() || ((PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(player)).isDiving() || ((PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(player)).isDiving() || ((PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(player)).isDiving() || ((PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(player)).isDiving() || ((PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(player)).isDiving()) {
                return null;
            }
        }

        return original;
    }
}