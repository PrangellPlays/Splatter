package dev.prangellplays.splatter.mixin.client.inkskin;

import dev.prangellplays.splatter.components.inkling.*;
import dev.prangellplays.splatter.components.octoling.*;
import dev.prangellplays.splatter.init.SplatterComponents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.CapeFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin({CapeFeatureRenderer.class})
public class DisableCapeFeatureRendererMixin {
    public DisableCapeFeatureRendererMixin() {
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/network/AbstractClientPlayerEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderCapeBlackInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, AbstractClientPlayerEntity abstractClientPlayerEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(abstractClientPlayerEntity)).isOctoling()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/network/AbstractClientPlayerEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderCapeBlueInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, AbstractClientPlayerEntity abstractClientPlayerEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (((PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(abstractClientPlayerEntity)).isInkling()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/network/AbstractClientPlayerEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderCapeBrownInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, AbstractClientPlayerEntity abstractClientPlayerEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (((PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(abstractClientPlayerEntity)).isOctoling()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/network/AbstractClientPlayerEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderCapeCyanInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, AbstractClientPlayerEntity abstractClientPlayerEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (((PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(abstractClientPlayerEntity)).isInkling()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/network/AbstractClientPlayerEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderCapeGrayInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, AbstractClientPlayerEntity abstractClientPlayerEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (((PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(abstractClientPlayerEntity)).isOctoling()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/network/AbstractClientPlayerEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderCapeGreenInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, AbstractClientPlayerEntity abstractClientPlayerEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (((PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(abstractClientPlayerEntity)).isInkling()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/network/AbstractClientPlayerEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderCapeLightBlueInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, AbstractClientPlayerEntity abstractClientPlayerEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (((PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(abstractClientPlayerEntity)).isOctoling()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/network/AbstractClientPlayerEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderCapeLightGrayInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, AbstractClientPlayerEntity abstractClientPlayerEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (((PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(abstractClientPlayerEntity)).isOctoling()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/network/AbstractClientPlayerEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderCapeLimeInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, AbstractClientPlayerEntity abstractClientPlayerEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(abstractClientPlayerEntity)).isInkling()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/network/AbstractClientPlayerEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderCapeMagentaInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, AbstractClientPlayerEntity abstractClientPlayerEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (((PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(abstractClientPlayerEntity)).isOctoling()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/network/AbstractClientPlayerEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderCapeOrangeInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, AbstractClientPlayerEntity abstractClientPlayerEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (((PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(abstractClientPlayerEntity)).isInkling()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/network/AbstractClientPlayerEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderCapePinkInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, AbstractClientPlayerEntity abstractClientPlayerEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (((PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(abstractClientPlayerEntity)).isInkling()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/network/AbstractClientPlayerEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderCapePurpleInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, AbstractClientPlayerEntity abstractClientPlayerEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (((PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(abstractClientPlayerEntity)).isInkling()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/network/AbstractClientPlayerEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderCapeRedInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, AbstractClientPlayerEntity abstractClientPlayerEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (((PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(abstractClientPlayerEntity)).isOctoling()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/network/AbstractClientPlayerEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderCapeWhiteInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, AbstractClientPlayerEntity abstractClientPlayerEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (((PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(abstractClientPlayerEntity)).isOctoling()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/network/AbstractClientPlayerEntity;FFFFFF)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$renderCapeYellowInkskin(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, AbstractClientPlayerEntity abstractClientPlayerEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (((PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(abstractClientPlayerEntity)).isInkling()) {
            ci.cancel();
        }
    }
}