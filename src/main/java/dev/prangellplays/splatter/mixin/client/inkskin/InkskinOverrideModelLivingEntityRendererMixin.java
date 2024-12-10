package dev.prangellplays.splatter.mixin.client.inkskin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import dev.prangellplays.splatter.components.inkling.*;
import dev.prangellplays.splatter.components.octoling.*;
import dev.prangellplays.splatter.init.SplatterComponents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin({LivingEntityRenderer.class})
public abstract class InkskinOverrideModelLivingEntityRendererMixin<T extends LivingEntity, M extends EntityModel<T>> {
    public InkskinOverrideModelLivingEntityRendererMixin() {
    }

    @Shadow
    public abstract M getModel();

    @Shadow
    protected abstract boolean isVisible(T var1);

    @Shadow
    protected abstract @Nullable RenderLayer getRenderLayer(T var1, boolean var2, boolean var3, boolean var4);

    @WrapWithCondition(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;IIFFFF)V"
            )}
    )
    private boolean splatter$overrideBlackInkskinModelRender(M model, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha, T entity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light2) {
        if (entity.isPlayer() && entity instanceof AbstractClientPlayerEntity player) {
            if (((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(player)).isOctoling()) {
                return this.splatter$overrideModelRender(player, matrices, light, overlay, red, green, blue, alpha, yaw, tickDelta, matrixStack, vertexConsumerProvider);
            }
        }
        return true;
    }

    @WrapWithCondition(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;IIFFFF)V"
            )}
    )
    private boolean splatter$overrideBlueInkskinModelRender(M model, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha, T entity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light2) {
        if (entity.isPlayer() && entity instanceof AbstractClientPlayerEntity player) {
            if (((PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(player)).isInkling()) {
                return this.splatter$overrideModelRender(player, matrices, light, overlay, red, green, blue, alpha, yaw, tickDelta, matrixStack, vertexConsumerProvider);
            }
        }
        return true;
    }

    @WrapWithCondition(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;IIFFFF)V"
            )}
    )
    private boolean splatter$overrideBrownInkskinModelRender(M model, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha, T entity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light2) {
        if (entity.isPlayer() && entity instanceof AbstractClientPlayerEntity player) {
            if (((PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(player)).isOctoling()) {
                return this.splatter$overrideModelRender(player, matrices, light, overlay, red, green, blue, alpha, yaw, tickDelta, matrixStack, vertexConsumerProvider);
            }
        }
        return true;
    }

    @WrapWithCondition(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;IIFFFF)V"
            )}
    )
    private boolean splatter$overrideCyanInkskinModelRender(M model, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha, T entity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light2) {
        if (entity.isPlayer() && entity instanceof AbstractClientPlayerEntity player) {
            if (((PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(player)).isInkling()) {
                return this.splatter$overrideModelRender(player, matrices, light, overlay, red, green, blue, alpha, yaw, tickDelta, matrixStack, vertexConsumerProvider);
            }
        }
        return true;
    }

    @WrapWithCondition(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;IIFFFF)V"
            )}
    )
    private boolean splatter$overrideGrayInkskinModelRender(M model, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha, T entity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light2) {
        if (entity.isPlayer() && entity instanceof AbstractClientPlayerEntity player) {
            if (((PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(player)).isOctoling()) {
                return this.splatter$overrideModelRender(player, matrices, light, overlay, red, green, blue, alpha, yaw, tickDelta, matrixStack, vertexConsumerProvider);
            }
        }
        return true;
    }

    @WrapWithCondition(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;IIFFFF)V"
            )}
    )
    private boolean splatter$overrideGreenInkskinModelRender(M model, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha, T entity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light2) {
        if (entity.isPlayer() && entity instanceof AbstractClientPlayerEntity player) {
            if (((PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(player)).isInkling()) {
                return this.splatter$overrideModelRender(player, matrices, light, overlay, red, green, blue, alpha, yaw, tickDelta, matrixStack, vertexConsumerProvider);
            }
        }
        return true;
    }

    @WrapWithCondition(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;IIFFFF)V"
            )}
    )
    private boolean splatter$overrideLightBlueInkskinModelRender(M model, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha, T entity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light2) {
        if (entity.isPlayer() && entity instanceof AbstractClientPlayerEntity player) {
            if (((PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(player)).isOctoling()) {
                return this.splatter$overrideModelRender(player, matrices, light, overlay, red, green, blue, alpha, yaw, tickDelta, matrixStack, vertexConsumerProvider);
            }
        }
        return true;
    }

    @WrapWithCondition(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;IIFFFF)V"
            )}
    )
    private boolean splatter$overrideLightGrayInkskinModelRender(M model, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha, T entity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light2) {
        if (entity.isPlayer() && entity instanceof AbstractClientPlayerEntity player) {
            if (((PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(player)).isOctoling()) {
                return this.splatter$overrideModelRender(player, matrices, light, overlay, red, green, blue, alpha, yaw, tickDelta, matrixStack, vertexConsumerProvider);
            }
        }
        return true;
    }

    @WrapWithCondition(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;IIFFFF)V"
            )}
    )
    private boolean splatter$overrideLimeInkskinModelRender(M model, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha, T entity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light2) {
        if (entity.isPlayer() && entity instanceof AbstractClientPlayerEntity player) {
            if (((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(player)).isInkling()) {
                return this.splatter$overrideModelRender(player, matrices, light, overlay, red, green, blue, alpha, yaw, tickDelta, matrixStack, vertexConsumerProvider);
            }
        }
        return true;
    }

    @WrapWithCondition(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;IIFFFF)V"
            )}
    )
    private boolean splatter$overrideMagentaInkskinModelRender(M model, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha, T entity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light2) {
        if (entity.isPlayer() && entity instanceof AbstractClientPlayerEntity player) {
            if (((PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(player)).isOctoling()) {
                return this.splatter$overrideModelRender(player, matrices, light, overlay, red, green, blue, alpha, yaw, tickDelta, matrixStack, vertexConsumerProvider);
            }
        }
        return true;
    }

    @WrapWithCondition(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;IIFFFF)V"
            )}
    )
    private boolean splatter$overrideOrangeInkskinModelRender(M model, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha, T entity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light2) {
        if (entity.isPlayer() && entity instanceof AbstractClientPlayerEntity player) {
            if (((PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(player)).isInkling()) {
                return this.splatter$overrideModelRender(player, matrices, light, overlay, red, green, blue, alpha, yaw, tickDelta, matrixStack, vertexConsumerProvider);
            }
        }
        return true;
    }

    @WrapWithCondition(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;IIFFFF)V"
            )}
    )
    private boolean splatter$overridePinkInkskinModelRender(M model, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha, T entity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light2) {
        if (entity.isPlayer() && entity instanceof AbstractClientPlayerEntity player) {
            if (((PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(player)).isInkling()) {
                return this.splatter$overrideModelRender(player, matrices, light, overlay, red, green, blue, alpha, yaw, tickDelta, matrixStack, vertexConsumerProvider);
            }
        }
        return true;
    }

    @WrapWithCondition(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;IIFFFF)V"
            )}
    )
    private boolean splatter$overridePurpleInkskinModelRender(M model, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha, T entity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light2) {
        if (entity.isPlayer() && entity instanceof AbstractClientPlayerEntity player) {
            if (((PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(player)).isInkling()) {
                return this.splatter$overrideModelRender(player, matrices, light, overlay, red, green, blue, alpha, yaw, tickDelta, matrixStack, vertexConsumerProvider);
            }
        }
        return true;
    }

    @WrapWithCondition(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;IIFFFF)V"
            )}
    )
    private boolean splatter$overrideRedInkskinModelRender(M model, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha, T entity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light2) {
        if (entity.isPlayer() && entity instanceof AbstractClientPlayerEntity player) {
            if (((PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(player)).isOctoling()) {
                return this.splatter$overrideModelRender(player, matrices, light, overlay, red, green, blue, alpha, yaw, tickDelta, matrixStack, vertexConsumerProvider);
            }
        }
        return true;
    }

    @WrapWithCondition(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;IIFFFF)V"
            )}
    )
    private boolean splatter$overrideWhiteInkskinModelRender(M model, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha, T entity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light2) {
        if (entity.isPlayer() && entity instanceof AbstractClientPlayerEntity player) {
            if (((PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(player)).isOctoling()) {
                return this.splatter$overrideModelRender(player, matrices, light, overlay, red, green, blue, alpha, yaw, tickDelta, matrixStack, vertexConsumerProvider);
            }
        }
        return true;
    }

    @WrapWithCondition(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;IIFFFF)V"
            )}
    )
    private boolean splatter$overrideYellowInkskinModelRender(M model, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha, T entity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light2) {
        if (entity.isPlayer() && entity instanceof AbstractClientPlayerEntity player) {
            if (((PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(player)).isInkling()) {
                return this.splatter$overrideModelRender(player, matrices, light, overlay, red, green, blue, alpha, yaw, tickDelta, matrixStack, vertexConsumerProvider);
            }
        }
        return true;
    }

    @Unique
    protected boolean splatter$overrideModelRender(@Nullable AbstractClientPlayerEntity player, MatrixStack matrices, int light, int overlay, float red, float green, float blue, float alpha, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider) {
        return true;
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$cancelBlackInkskinDiverRender(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerBlackOctolingComponent component = (PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(player);
            if (component.isDiving() && component.getDivingTicks() <= 0) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$cancelBlueInkskinDiverRender(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerBlueInklingComponent component = (PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(player);
            if (component.isDiving() && component.getDivingTicks() <= 0) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$cancelBrownInkskinDiverRender(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerBrownOctolingComponent component = (PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(player);
            if (component.isDiving() && component.getDivingTicks() <= 0) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$cancelCyanInkskinDiverRender(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerCyanInklingComponent component = (PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(player);
            if (component.isDiving() && component.getDivingTicks() <= 0) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$cancelGrayInkskinDiverRender(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerGrayOctolingComponent component = (PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(player);
            if (component.isDiving() && component.getDivingTicks() <= 0) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$cancelGreenInkskinDiverRender(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerGreenInklingComponent component = (PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(player);
            if (component.isDiving() && component.getDivingTicks() <= 0) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$cancelLightBlueInkskinDiverRender(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerLightBlueOctolingComponent component = (PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(player);
            if (component.isDiving() && component.getDivingTicks() <= 0) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$cancelLightGrayInkskinDiverRender(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerLightGrayOctolingComponent component = (PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(player);
            if (component.isDiving() && component.getDivingTicks() <= 0) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$cancelLimeInkskinDiverRender(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerLimeInklingComponent component = (PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(player);
            if (component.isDiving() && component.getDivingTicks() <= 0) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$cancelMagentaInkskinDiverRender(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerMagentaOctolingComponent component = (PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(player);
            if (component.isDiving() && component.getDivingTicks() <= 0) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$cancelOrangeInkskinDiverRender(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerOrangeInklingComponent component = (PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(player);
            if (component.isDiving() && component.getDivingTicks() <= 0) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$cancelPinkInkskinDiverRender(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerPinkInklingComponent component = (PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(player);
            if (component.isDiving() && component.getDivingTicks() <= 0) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$cancelPurpleInkskinDiverRender(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerPurpleInklingComponent component = (PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(player);
            if (component.isDiving() && component.getDivingTicks() <= 0) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$cancelRedInkskinDiverRender(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerRedOctolingComponent component = (PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(player);
            if (component.isDiving() && component.getDivingTicks() <= 0) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$cancelWhiteInkskinDiverRender(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerWhiteOctolingComponent component = (PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(player);
            if (component.isDiving() && component.getDivingTicks() <= 0) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$cancelYellowInkskinDiverRender(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerYellowInklingComponent component = (PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(player);
            if (component.isDiving() && component.getDivingTicks() <= 0) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V"
            )}
    )
    public void splatter$doBlackInkskinDivingAnimation(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerBlackOctolingComponent component = (PlayerBlackOctolingComponent)SplatterComponents.BLACK_OCTOLING.get(player);
            if (component.getDivingTicks() > 0) {
                if (component.isDiving()) {
                    matrixStack.translate(0.0, 2.0 - (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                } else {
                    matrixStack.translate(0.0, (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                }
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V"
            )}
    )
    public void splatter$doBlueInkskinDivingAnimation(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerBlueInklingComponent component = (PlayerBlueInklingComponent)SplatterComponents.BLUE_INKLING.get(player);
            if (component.getDivingTicks() > 0) {
                if (component.isDiving()) {
                    matrixStack.translate(0.0, 2.0 - (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                } else {
                    matrixStack.translate(0.0, (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                }
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V"
            )}
    )
    public void splatter$doBrownInkskinDivingAnimation(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerBrownOctolingComponent component = (PlayerBrownOctolingComponent)SplatterComponents.BROWN_OCTOLING.get(player);
            if (component.getDivingTicks() > 0) {
                if (component.isDiving()) {
                    matrixStack.translate(0.0, 2.0 - (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                } else {
                    matrixStack.translate(0.0, (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                }
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V"
            )}
    )
    public void splatter$doCyanInkskinDivingAnimation(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerCyanInklingComponent component = (PlayerCyanInklingComponent)SplatterComponents.CYAN_INKLING.get(player);
            if (component.getDivingTicks() > 0) {
                if (component.isDiving()) {
                    matrixStack.translate(0.0, 2.0 - (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                } else {
                    matrixStack.translate(0.0, (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                }
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V"
            )}
    )
    public void splatter$doGrayInkskinDivingAnimation(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerGrayOctolingComponent component = (PlayerGrayOctolingComponent)SplatterComponents.GRAY_OCTOLING.get(player);
            if (component.getDivingTicks() > 0) {
                if (component.isDiving()) {
                    matrixStack.translate(0.0, 2.0 - (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                } else {
                    matrixStack.translate(0.0, (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                }
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V"
            )}
    )
    public void splatter$doGreenInkskinDivingAnimation(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerGreenInklingComponent component = (PlayerGreenInklingComponent)SplatterComponents.GREEN_INKLING.get(player);
            if (component.getDivingTicks() > 0) {
                if (component.isDiving()) {
                    matrixStack.translate(0.0, 2.0 - (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                } else {
                    matrixStack.translate(0.0, (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                }
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V"
            )}
    )
    public void splatter$doLightBlueInkskinDivingAnimation(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerLightBlueOctolingComponent component = (PlayerLightBlueOctolingComponent)SplatterComponents.LIGHT_BLUE_OCTOLING.get(player);
            if (component.getDivingTicks() > 0) {
                if (component.isDiving()) {
                    matrixStack.translate(0.0, 2.0 - (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                } else {
                    matrixStack.translate(0.0, (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                }
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V"
            )}
    )
    public void splatter$doLightGrayInkskinDivingAnimation(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerLightGrayOctolingComponent component = (PlayerLightGrayOctolingComponent)SplatterComponents.LIGHT_GRAY_OCTOLING.get(player);
            if (component.getDivingTicks() > 0) {
                if (component.isDiving()) {
                    matrixStack.translate(0.0, 2.0 - (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                } else {
                    matrixStack.translate(0.0, (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                }
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V"
            )}
    )
    public void splatter$doLimeInkskinDivingAnimation(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerLimeInklingComponent component = (PlayerLimeInklingComponent)SplatterComponents.LIME_INKLING.get(player);
            if (component.getDivingTicks() > 0) {
                if (component.isDiving()) {
                    matrixStack.translate(0.0, 2.0 - (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                } else {
                    matrixStack.translate(0.0, (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                }
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V"
            )}
    )
    public void splatter$doMagentaInkskinDivingAnimation(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerMagentaOctolingComponent component = (PlayerMagentaOctolingComponent)SplatterComponents.MAGENTA_OCTOLING.get(player);
            if (component.getDivingTicks() > 0) {
                if (component.isDiving()) {
                    matrixStack.translate(0.0, 2.0 - (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                } else {
                    matrixStack.translate(0.0, (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                }
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V"
            )}
    )
    public void splatter$doOrangeInkskinDivingAnimation(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerOrangeInklingComponent component = (PlayerOrangeInklingComponent)SplatterComponents.ORANGE_INKLING.get(player);
            if (component.getDivingTicks() > 0) {
                if (component.isDiving()) {
                    matrixStack.translate(0.0, 2.0 - (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                } else {
                    matrixStack.translate(0.0, (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                }
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V"
            )}
    )
    public void splatter$doPinkInkskinDivingAnimation(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerPinkInklingComponent component = (PlayerPinkInklingComponent)SplatterComponents.PINK_INKLING.get(player);
            if (component.getDivingTicks() > 0) {
                if (component.isDiving()) {
                    matrixStack.translate(0.0, 2.0 - (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                } else {
                    matrixStack.translate(0.0, (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                }
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V"
            )}
    )
    public void splatter$doPurpleInkskinDivingAnimation(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerPurpleInklingComponent component = (PlayerPurpleInklingComponent)SplatterComponents.PURPLE_INKLING.get(player);
            if (component.getDivingTicks() > 0) {
                if (component.isDiving()) {
                    matrixStack.translate(0.0, 2.0 - (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                } else {
                    matrixStack.translate(0.0, (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                }
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V"
            )}
    )
    public void splatter$doRedInkskinDivingAnimation(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerRedOctolingComponent component = (PlayerRedOctolingComponent)SplatterComponents.RED_OCTOLING.get(player);
            if (component.getDivingTicks() > 0) {
                if (component.isDiving()) {
                    matrixStack.translate(0.0, 2.0 - (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                } else {
                    matrixStack.translate(0.0, (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                }
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V"
            )}
    )
    public void splatter$doWhiteInkskinDivingAnimation(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerWhiteOctolingComponent component = (PlayerWhiteOctolingComponent)SplatterComponents.WHITE_OCTOLING.get(player);
            if (component.getDivingTicks() > 0) {
                if (component.isDiving()) {
                    matrixStack.translate(0.0, 2.0 - (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                } else {
                    matrixStack.translate(0.0, (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                }
            }
        }
    }

    @Inject(
            method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V"
            )}
    )
    public void splatter$doYellowInkskinDivingAnimation(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            PlayerYellowInklingComponent component = (PlayerYellowInklingComponent)SplatterComponents.YELLOW_INKLING.get(player);
            if (component.getDivingTicks() > 0) {
                if (component.isDiving()) {
                    matrixStack.translate(0.0, 2.0 - (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                } else {
                    matrixStack.translate(0.0, (double)((float)component.getDivingTicks() - MinecraftClient.getInstance().getTickDelta()) / (double)component.getDivingTicksAnimationLength() * 2.0, 0.0);
                }
            }
        }
    }
}