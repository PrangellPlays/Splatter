package dev.prangellplays.splatter.mixin.client.inkskin;

import dev.prangellplays.splatter.components.inkling.*;
import dev.prangellplays.splatter.components.octoling.*;
import dev.prangellplays.splatter.init.SplatterComponents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin({ArmorFeatureRenderer.class})
public class NoArmorOnInkskinArmorFeatureRendererMixin<T extends LivingEntity> {
    public NoArmorOnInkskinArmorFeatureRendererMixin() {
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/LivingEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderBlackInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            if (((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(player)).isOctoling()) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/LivingEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderBlueInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            if (((PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(player)).isInkling()) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/LivingEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderBrownInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            if (((PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(player)).isOctoling()) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/LivingEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderCyanInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            if (((PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(player)).isInkling()) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/LivingEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderGrayInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            if (((PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(player)).isOctoling()) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/LivingEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderGreenInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            if (((PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(player)).isInkling()) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/LivingEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderLightBlueInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            if (((PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(player)).isOctoling()) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/LivingEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderLightGrayInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            if (((PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(player)).isOctoling()) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/LivingEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderLimeInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            if (((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(player)).isInkling()) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/LivingEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderMagentaInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            if (((PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(player)).isOctoling()) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/LivingEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderOrangeInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            if (((PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(player)).isInkling()) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/LivingEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderPinkInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            if (((PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(player)).isInkling()) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/LivingEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderPurpleInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            if (((PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(player)).isInkling()) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/LivingEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderRedInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            if (((PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(player)).isOctoling()) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/LivingEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderWhiteInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            if (((PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(player)).isOctoling()) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/LivingEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderYellowInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            if (((PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(player)).isInkling()) {
                ci.cancel();
            }
        }
    }
}