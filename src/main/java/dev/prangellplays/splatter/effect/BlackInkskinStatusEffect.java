package dev.prangellplays.splatter.effect;

import dev.prangellplays.splatter.components.inkling.PlayerBlueInklingComponent;
import dev.prangellplays.splatter.components.octoling.PlayerBlackOctolingComponent;
import dev.prangellplays.splatter.init.SplatterComponents;
import dev.prangellplays.splatter.init.SplatterParticles;
import dev.prangellplays.splatter.init.SplatterStatusEffects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class BlackInkskinStatusEffect extends StatusEffect {
    public BlackInkskinStatusEffect() {
        super(StatusEffectCategory.BENEFICIAL, 1908001);
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
    }

    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);
        if (entity instanceof PlayerEntity player) {
            if (!player.hasStatusEffect(SplatterStatusEffects.BLACK_INKSKIN)) {
                ((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(player)).resetPlayer();
            }
        }
        ClientWorld clientWorld = (ClientWorld) MinecraftClient.getInstance().player.getWorld();
        for (int i = 0; i < 100; ++i) {
            clientWorld.addParticle(SplatterParticles.BLACK_FALLING_INK, entity.getX() + (double) entity.getWorld().random.nextFloat() - 0.5, entity.getY() + (double) (clientWorld.random.nextFloat() * 1.8F), entity.getZ() + (double) clientWorld.random.nextFloat() - 0.5, (double) ((clientWorld.random.nextFloat() - 0.5F) * 0.6F), (double) ((clientWorld.random.nextFloat() - 0.5F) * 0.6F), (double) ((clientWorld.random.nextFloat() - 0.5F) * 0.6F));
        }
    }
}