package dev.prangellplays.splatter.client.ui;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.prangellplays.splatter.Splatter;
import dev.prangellplays.splatter.components.octoling.PlayerBlackOctolingComponent;
import dev.prangellplays.splatter.init.SplatterComponents;
import dev.prangellplays.splatter.init.SplatterItems;
import dev.prangellplays.splatter.mixin.client.InGameHudAccessor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class BlackInkBarsRenderer implements HudRenderCallback {
    public static final int BAR_LENGTH = 83;
    private static final Identifier TEXTURE = Splatter.id("textures/gui/bars.png");

    public BlackInkBarsRenderer() {
    }

    public void onHudRender(DrawContext drawContext, float tickDelta) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null) {
            PlayerBlackOctolingComponent component = (PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(player);
            InGameHud inGameHud = MinecraftClient.getInstance().inGameHud;
            int scaledHeight = ((InGameHudAccessor)inGameHud).getScaledHeight();
            int scaledWidth = ((InGameHudAccessor)inGameHud).getScaledWidth();

            if (component.isOctoling() && player.getStackInHand(player.getActiveHand()).isOf(SplatterItems.SPLATTERSHOT_BLACK)) {
                this.drawBar(drawContext, 0, 38, scaledHeight - 18 - 80, component.getInkBarLength(83));
            }
        }
    }

    private void drawBar(DrawContext drawContext, int offset, int x, int y, int length) {
        MatrixStack stack = drawContext.getMatrices();
        stack.push();
        stack.translate((float)x, (float)y, 0.0F);
        int o = offset * 32;
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        boolean isLow = length <= 18;
        int iconOffset = isLow ? 12 : 0;
        int barVerticalOffset = isLow ? 96 : 0;
        stack.push();
        stack.translate(-3.5, 75.0, 0.0);
        RenderSystem.enableBlend();
        drawContext.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        drawContext.drawTexture(TEXTURE, 0, 0, (float)(o + 16), (float)iconOffset, 16, 12, 96, 192);
        stack.pop();
        stack.translate(0.0F, -12.0F, 0.0F);
        drawContext.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        drawContext.drawTexture(TEXTURE, 0, 0, (float)(isLow ? 96 : o), (float)barVerticalOffset, 9, 83, 96, 192);
        stack.translate(0.0, (double)(83 - length), 0.0);
        drawContext.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        drawContext.drawTexture(TEXTURE, 0, 0, (float)(isLow ? 104 : o + 8), (float)(83 - length + barVerticalOffset), 7, length, 96, 192);
        drawContext.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        stack.pop();
    }
}
