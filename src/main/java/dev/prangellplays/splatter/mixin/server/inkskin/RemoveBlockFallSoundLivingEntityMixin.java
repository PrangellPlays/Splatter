package dev.prangellplays.splatter.mixin.server.inkskin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import dev.prangellplays.splatter.Splatter;
import dev.prangellplays.splatter.components.inkling.*;
import dev.prangellplays.splatter.components.octoling.*;
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
    protected boolean splatter$removeFallBlockSoundOnBlackInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
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
            method = {"playBlockFallSound"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"
            )}
    )
    protected boolean splatter$removeFallBlockSoundOnBlueInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(player)).isInkling() && Splatter.isCollidingWithBlueInk(player)) {
                var10000 = true;
                return !var10000;
            }
        }
        var10000 = false;
        return !var10000;
    }

    @WrapWithCondition(
            method = {"playBlockFallSound"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"
            )}
    )
    protected boolean splatter$removeFallBlockSoundOnBrownInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(player)).isOctoling() && Splatter.isCollidingWithBrownInk(player)) {
                var10000 = true;
                return !var10000;
            }
        }
        var10000 = false;
        return !var10000;
    }

    @WrapWithCondition(
            method = {"playBlockFallSound"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"
            )}
    )
    protected boolean splatter$removeFallBlockSoundOnCyanInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(player)).isInkling() && Splatter.isCollidingWithCyanInk(player)) {
                var10000 = true;
                return !var10000;
            }
        }
        var10000 = false;
        return !var10000;
    }

    @WrapWithCondition(
            method = {"playBlockFallSound"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"
            )}
    )
    protected boolean splatter$removeFallBlockSoundOnGrayInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(player)).isOctoling() && Splatter.isCollidingWithGrayInk(player)) {
                var10000 = true;
                return !var10000;
            }
        }
        var10000 = false;
        return !var10000;
    }

    @WrapWithCondition(
            method = {"playBlockFallSound"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"
            )}
    )
    protected boolean splatter$removeFallBlockSoundOnGreenInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(player)).isInkling() && Splatter.isCollidingWithGreenInk(player)) {
                var10000 = true;
                return !var10000;
            }
        }
        var10000 = false;
        return !var10000;
    }

    @WrapWithCondition(
            method = {"playBlockFallSound"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"
            )}
    )
    protected boolean splatter$removeFallBlockSoundOnLightBlueInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(player)).isOctoling() && Splatter.isCollidingWithLightBlueInk(player)) {
                var10000 = true;
                return !var10000;
            }
        }
        var10000 = false;
        return !var10000;
    }

    @WrapWithCondition(
            method = {"playBlockFallSound"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"
            )}
    )
    protected boolean splatter$removeFallBlockSoundOnLightGrayInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(player)).isOctoling() && Splatter.isCollidingWithLightGrayInk(player)) {
                var10000 = true;
                return !var10000;
            }
        }
        var10000 = false;
        return !var10000;
    }

    @WrapWithCondition(
            method = {"playBlockFallSound"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"
            )}
    )
    protected boolean splatter$removeFallBlockSoundOnLimeInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(player)).isInkling() && Splatter.isCollidingWithLimeInk(player)) {
                var10000 = true;
                return !var10000;
            }
        }
        var10000 = false;
        return !var10000;
    }

    @WrapWithCondition(
            method = {"playBlockFallSound"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"
            )}
    )
    protected boolean splatter$removeFallBlockSoundOnMagentaInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(player)).isOctoling() && Splatter.isCollidingWithMagentaInk(player)) {
                var10000 = true;
                return !var10000;
            }
        }
        var10000 = false;
        return !var10000;
    }

    @WrapWithCondition(
            method = {"playBlockFallSound"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"
            )}
    )
    protected boolean splatter$removeFallBlockSoundOnOrangeInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(player)).isInkling() && Splatter.isCollidingWithOrangeInk(player)) {
                var10000 = true;
                return !var10000;
            }
        }
        var10000 = false;
        return !var10000;
    }

    @WrapWithCondition(
            method = {"playBlockFallSound"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"
            )}
    )
    protected boolean splatter$removeFallBlockSoundOnPinkInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(player)).isInkling() && Splatter.isCollidingWithPinkInk(player)) {
                var10000 = true;
                return !var10000;
            }
        }
        var10000 = false;
        return !var10000;
    }

    @WrapWithCondition(
            method = {"playBlockFallSound"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"
            )}
    )
    protected boolean splatter$removeFallBlockSoundOnPurpleInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(player)).isInkling() && Splatter.isCollidingWithPurpleInk(player)) {
                var10000 = true;
                return !var10000;
            }
        }
        var10000 = false;
        return !var10000;
    }

    @WrapWithCondition(
            method = {"playBlockFallSound"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"
            )}
    )
    protected boolean splatter$removeFallBlockSoundOnRedInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(player)).isOctoling() && Splatter.isCollidingWithRedInk(player)) {
                var10000 = true;
                return !var10000;
            }
        }
        var10000 = false;
        return !var10000;
    }

    @WrapWithCondition(
            method = {"playBlockFallSound"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"
            )}
    )
    protected boolean splatter$removeFallBlockSoundOnWhiteInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(player)).isOctoling() && Splatter.isCollidingWithWhiteInk(player)) {
                var10000 = true;
                return !var10000;
            }
        }
        var10000 = false;
        return !var10000;
    }

    @WrapWithCondition(
            method = {"playBlockFallSound"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"
            )}
    )
    protected boolean splatter$removeFallBlockSoundOnYellowInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(player)).isInkling() && Splatter.isCollidingWithYellowInk(player)) {
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
    protected boolean splatter$removeFallHitSoundOnBlackInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
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
    protected boolean splatter$removeFallHitSoundOnBlueInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(player)).isInkling() && Splatter.isCollidingWithBlueInk(player)) {
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
    protected boolean splatter$removeFallHitSoundOnBrownInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(player)).isOctoling() && Splatter.isCollidingWithBrownInk(player)) {
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
    protected boolean splatter$removeFallHitSoundOnCyanInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(player)).isInkling() && Splatter.isCollidingWithCyanInk(player)) {
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
    protected boolean splatter$removeFallHitSoundOnGrayInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(player)).isOctoling() && Splatter.isCollidingWithGrayInk(player)) {
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
    protected boolean splatter$removeFallHitSoundOnGreenInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(player)).isInkling() && Splatter.isCollidingWithGreenInk(player)) {
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
    protected boolean splatter$removeFallHitSoundOnLightBlueInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(player)).isOctoling() && Splatter.isCollidingWithLightBlueInk(player)) {
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
    protected boolean splatter$removeFallHitSoundOnLightGrayInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(player)).isOctoling() && Splatter.isCollidingWithLightGrayInk(player)) {
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
    protected boolean splatter$removeFallHitSoundOnLimeInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(player)).isInkling() && Splatter.isCollidingWithLimeInk(player)) {
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
    protected boolean splatter$removeFallHitSoundOnMagentaInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(player)).isOctoling() && Splatter.isCollidingWithMagentaInk(player)) {
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
    protected boolean splatter$removeFallHitSoundOnOrangeInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(player)).isInkling() && Splatter.isCollidingWithOrangeInk(player)) {
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
    protected boolean splatter$removeFallHitSoundOnPinkInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(player)).isInkling() && Splatter.isCollidingWithPinkInk(player)) {
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
    protected boolean splatter$removeFallHitSoundOnPurpleInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(player)).isInkling() && Splatter.isCollidingWithPurpleInk(player)) {
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
    protected boolean splatter$removeFallHitSoundOnRedInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(player)).isOctoling() && Splatter.isCollidingWithRedInk(player)) {
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
    protected boolean splatter$removeFallHitSoundOnWhiteInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(player)).isOctoling() && Splatter.isCollidingWithWhiteInk(player)) {
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
    protected boolean splatter$removeFallHitSoundOnYellowInkskinDive(LivingEntity instance, SoundEvent event, float volume, float pitch) {
        boolean var10000;
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(player)).isInkling() && Splatter.isCollidingWithYellowInk(player)) {
                var10000 = true;
                return !var10000;
            }
        }

        var10000 = false;
        return !var10000;
    }
}