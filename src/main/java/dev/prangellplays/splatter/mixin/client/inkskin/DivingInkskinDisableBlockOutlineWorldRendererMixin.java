package dev.prangellplays.splatter.mixin.client.inkskin;

import dev.prangellplays.splatter.components.inkling.*;
import dev.prangellplays.splatter.components.octoling.*;
import dev.prangellplays.splatter.init.SplatterComponents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin({WorldRenderer.class})
public class DivingInkskinDisableBlockOutlineWorldRendererMixin {
    public DivingInkskinDisableBlockOutlineWorldRendererMixin() {
    }

    @Inject(
            method = {"drawBlockOutline"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$drawBlockOutlineBlackInkskin(MatrixStack matrices, VertexConsumer vertexConsumer, Entity entity, double cameraX, double cameraY, double cameraZ, BlockPos pos, BlockState state, CallbackInfo ci) {
        if (((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"drawBlockOutline"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$drawBlockOutlineBlueInkskin(MatrixStack matrices, VertexConsumer vertexConsumer, Entity entity, double cameraX, double cameraY, double cameraZ, BlockPos pos, BlockState state, CallbackInfo ci) {
        if (((PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"drawBlockOutline"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$drawBlockOutlineBrownInkskin(MatrixStack matrices, VertexConsumer vertexConsumer, Entity entity, double cameraX, double cameraY, double cameraZ, BlockPos pos, BlockState state, CallbackInfo ci) {
        if (((PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"drawBlockOutline"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$drawBlockOutlineCyanInkskin(MatrixStack matrices, VertexConsumer vertexConsumer, Entity entity, double cameraX, double cameraY, double cameraZ, BlockPos pos, BlockState state, CallbackInfo ci) {
        if (((PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"drawBlockOutline"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$drawBlockOutlineGrayInkskin(MatrixStack matrices, VertexConsumer vertexConsumer, Entity entity, double cameraX, double cameraY, double cameraZ, BlockPos pos, BlockState state, CallbackInfo ci) {
        if (((PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"drawBlockOutline"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$drawBlockOutlineGreenInkskin(MatrixStack matrices, VertexConsumer vertexConsumer, Entity entity, double cameraX, double cameraY, double cameraZ, BlockPos pos, BlockState state, CallbackInfo ci) {
        if (((PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"drawBlockOutline"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$drawBlockOutlineLightBlueInkskin(MatrixStack matrices, VertexConsumer vertexConsumer, Entity entity, double cameraX, double cameraY, double cameraZ, BlockPos pos, BlockState state, CallbackInfo ci) {
        if (((PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"drawBlockOutline"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$drawBlockOutlineLightGrayInkskin(MatrixStack matrices, VertexConsumer vertexConsumer, Entity entity, double cameraX, double cameraY, double cameraZ, BlockPos pos, BlockState state, CallbackInfo ci) {
        if (((PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"drawBlockOutline"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$drawBlockOutlineLimeInkskin(MatrixStack matrices, VertexConsumer vertexConsumer, Entity entity, double cameraX, double cameraY, double cameraZ, BlockPos pos, BlockState state, CallbackInfo ci) {
        if (((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"drawBlockOutline"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$drawBlockOutlineMagentaInkskin(MatrixStack matrices, VertexConsumer vertexConsumer, Entity entity, double cameraX, double cameraY, double cameraZ, BlockPos pos, BlockState state, CallbackInfo ci) {
        if (((PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"drawBlockOutline"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$drawBlockOutlineOrangeInkskin(MatrixStack matrices, VertexConsumer vertexConsumer, Entity entity, double cameraX, double cameraY, double cameraZ, BlockPos pos, BlockState state, CallbackInfo ci) {
        if (((PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"drawBlockOutline"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$drawBlockOutlinePinkInkskin(MatrixStack matrices, VertexConsumer vertexConsumer, Entity entity, double cameraX, double cameraY, double cameraZ, BlockPos pos, BlockState state, CallbackInfo ci) {
        if (((PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"drawBlockOutline"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$drawBlockOutlinePurpleInkskin(MatrixStack matrices, VertexConsumer vertexConsumer, Entity entity, double cameraX, double cameraY, double cameraZ, BlockPos pos, BlockState state, CallbackInfo ci) {
        if (((PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"drawBlockOutline"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$drawBlockOutlineRedInkskin(MatrixStack matrices, VertexConsumer vertexConsumer, Entity entity, double cameraX, double cameraY, double cameraZ, BlockPos pos, BlockState state, CallbackInfo ci) {
        if (((PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"drawBlockOutline"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$drawBlockOutlineWhiteInkskin(MatrixStack matrices, VertexConsumer vertexConsumer, Entity entity, double cameraX, double cameraY, double cameraZ, BlockPos pos, BlockState state, CallbackInfo ci) {
        if (((PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"drawBlockOutline"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void splatter$drawBlockOutlineYellowInkskin(MatrixStack matrices, VertexConsumer vertexConsumer, Entity entity, double cameraX, double cameraY, double cameraZ, BlockPos pos, BlockState state, CallbackInfo ci) {
        if (((PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(MinecraftClient.getInstance().player)).isDiving()) {
            ci.cancel();
        }
    }
}