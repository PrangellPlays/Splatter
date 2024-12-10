package dev.prangellplays.splatter.mixin.client.inkskin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import dev.prangellplays.splatter.Splatter;
import dev.prangellplays.splatter.SplatterClient;
import dev.prangellplays.splatter.components.octoling.PlayerBlackOctolingComponent;
import dev.prangellplays.splatter.init.SplatterComponents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin({InGameHud.class})
public abstract class RenderLaunchBarInGameHudMixin {
    @Unique
    private static final Identifier GUI_SPLATTER_TEXTURE = Splatter.id("textures/gui/icons.png");
    @Shadow
    @Final
    private MinecraftClient client;
    @Shadow
    private int scaledHeight;
    @Shadow
    private int scaledWidth;

    public RenderLaunchBarInGameHudMixin() {
    }

    @Inject(
            method = {"render"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/network/ClientPlayerInteractionManager;hasExperienceBar()Z"
            )}
    )
    public void splatter$renderBlackInkskin(DrawContext context, float tickDelta, CallbackInfo ci) {
        if (((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(this.client.player)).isOctoling() && SplatterClient.launchStrength > 0.0F) {
            int x = this.scaledWidth / 2 - 91;
            this.client.getProfiler().push("jumpBar");
            int j = (int)(SplatterClient.launchStrength / 2.0F * 183.0F);
            int k = this.scaledHeight - 32 + 3;
            context.drawTexture(GUI_SPLATTER_TEXTURE, x, k, 0, 0, 182, 5);
            if (j > 0) {
                context.drawTexture(GUI_SPLATTER_TEXTURE, x, k, 0, 5, j, 5);
            }

            this.client.getProfiler().pop();
        }
    }

    @WrapWithCondition(
            method = {"render"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud;renderExperienceBar(Lnet/minecraft/client/gui/DrawContext;I)V"
            )}
    )
    public boolean splatter$renderBlackInkskin(InGameHud instance, DrawContext context, int x) {
        return !((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(this.client.player)).isOctoling() || !(SplatterClient.launchStrength > 0.0F);
    }
}