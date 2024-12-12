package dev.prangellplays.splatter.mixin.server.inkskin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import dev.prangellplays.splatter.Splatter;
import dev.prangellplays.splatter.components.octoling.PlayerBlackOctolingComponent;
import dev.prangellplays.splatter.init.SplatterComponents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({LivingEntity.class})
public abstract class RemoveBlockFallSoundLivingEntityMixin extends Entity {
    public RemoveBlockFallSoundLivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @WrapWithCondition(
            method = {"playBlockFallSound"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"
            )}
    )
    protected boolean splatter$removeFallBlockSoundOnInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(player)).isOctoling() && Splatter.isCollidingWithBlackInk(player)) {
                var10000 = true;
                return !var10000;
            }
        }

        var10000 = false;
        return !var10000;
    }

    @WrapWithCondition(
            method = {"handleFallDamage"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"
            )}
    )
    protected boolean splatter$removeFallHitSoundOnInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(player)).isOctoling() && Splatter.isCollidingWithBlackInk(player)) {
                var10000 = true;
                return !var10000;
            }
        }

        var10000 = false;
        return !var10000;
    }
}