package dev.prangellplays.splatter.effect;

import dev.prangellplays.splatter.components.inkling.PlayerBlueInklingComponent;
import dev.prangellplays.splatter.components.inkling.PlayerLimeInklingComponent;
import dev.prangellplays.splatter.init.SplatterComponents;
import dev.prangellplays.splatter.init.SplatterStatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class LimeInkskinStatusEffect extends StatusEffect {
    public LimeInkskinStatusEffect() {
        super(StatusEffectCategory.BENEFICIAL, 8439583);
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
            if (!player.hasStatusEffect(SplatterStatusEffects.LIME_INKSKIN)) {
                ((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(player)).resetPlayer();
            }
        }

    }
}