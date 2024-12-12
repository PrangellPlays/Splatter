package dev.prangellplays.splatter.mixin.server.inkskin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.prangellplays.splatter.components.inkling.*;
import dev.prangellplays.splatter.components.octoling.*;
import dev.prangellplays.splatter.init.SplatterComponents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({PlayerEntity.class})
public abstract class InkskinDivePlayerEntityMixin extends LivingEntity {
    protected InkskinDivePlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(
            method = {"jump"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void defile$preventJump(CallbackInfo ci) {
        if (((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(this)).isDiving() || ((PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(this)).isDiving() || ((PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(this)).isDiving() || ((PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(this)).isDiving() || ((PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(this)).isDiving() || ((PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(this)).isDiving() || ((PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(this)).isDiving() || ((PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(this)).isDiving() || ((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(this)).isDiving() || ((PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(this)).isDiving() || ((PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(this)).isDiving() || ((PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(this)).isDiving() || ((PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(this)).isDiving() || ((PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(this)).isDiving() || ((PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(this)).isDiving() || ((PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$moveToLowestBlockInTheAirBlackInkskin(CallbackInfo ci) {
        PlayerBlackOctolingComponent component = (PlayerBlackOctolingComponent)SplatterComponents.BLACK_OCTOLING.get(this);
        if (component.isDiving() && !this.isSpectator() && !this.isOnGround()) {
            boolean foundBlock = false;

            for(int i = -1; i >= -5; --i) {
                BlockPos downPos = this.getBlockPos().add(0, i, 0);
                if (!this.getWorld().getBlockState(downPos).getCollisionShape(this.getWorld(), downPos).isEmpty()) {
                    foundBlock = true;
                    break;
                }
            }

            if (foundBlock) {
                this.addVelocity(0.0, -50.0, 0.0);
            } else {
                component.rise();
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$moveToLowestBlockInTheAirBlueInkskin(CallbackInfo ci) {
        PlayerBlueInklingComponent component = (PlayerBlueInklingComponent)SplatterComponents.BLUE_INKLING.get(this);
        if (component.isDiving() && !this.isSpectator() && !this.isOnGround()) {
            boolean foundBlock = false;

            for(int i = -1; i >= -5; --i) {
                BlockPos downPos = this.getBlockPos().add(0, i, 0);
                if (!this.getWorld().getBlockState(downPos).getCollisionShape(this.getWorld(), downPos).isEmpty()) {
                    foundBlock = true;
                    break;
                }
            }

            if (foundBlock) {
                this.addVelocity(0.0, -50.0, 0.0);
            } else {
                component.rise();
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$moveToLowestBlockInTheAirBrownInkskin(CallbackInfo ci) {
        PlayerBrownOctolingComponent component = (PlayerBrownOctolingComponent)SplatterComponents.BROWN_OCTOLING.get(this);
        if (component.isDiving() && !this.isSpectator() && !this.isOnGround()) {
            boolean foundBlock = false;

            for(int i = -1; i >= -5; --i) {
                BlockPos downPos = this.getBlockPos().add(0, i, 0);
                if (!this.getWorld().getBlockState(downPos).getCollisionShape(this.getWorld(), downPos).isEmpty()) {
                    foundBlock = true;
                    break;
                }
            }

            if (foundBlock) {
                this.addVelocity(0.0, -50.0, 0.0);
            } else {
                component.rise();
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$moveToLowestBlockInTheAirCyanInkskin(CallbackInfo ci) {
        PlayerCyanInklingComponent component = (PlayerCyanInklingComponent)SplatterComponents.CYAN_INKLING.get(this);
        if (component.isDiving() && !this.isSpectator() && !this.isOnGround()) {
            boolean foundBlock = false;

            for(int i = -1; i >= -5; --i) {
                BlockPos downPos = this.getBlockPos().add(0, i, 0);
                if (!this.getWorld().getBlockState(downPos).getCollisionShape(this.getWorld(), downPos).isEmpty()) {
                    foundBlock = true;
                    break;
                }
            }

            if (foundBlock) {
                this.addVelocity(0.0, -50.0, 0.0);
            } else {
                component.rise();
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$moveToLowestBlockInTheAirGrayInkskin(CallbackInfo ci) {
        PlayerGrayOctolingComponent component = (PlayerGrayOctolingComponent)SplatterComponents.GRAY_OCTOLING.get(this);
        if (component.isDiving() && !this.isSpectator() && !this.isOnGround()) {
            boolean foundBlock = false;

            for(int i = -1; i >= -5; --i) {
                BlockPos downPos = this.getBlockPos().add(0, i, 0);
                if (!this.getWorld().getBlockState(downPos).getCollisionShape(this.getWorld(), downPos).isEmpty()) {
                    foundBlock = true;
                    break;
                }
            }

            if (foundBlock) {
                this.addVelocity(0.0, -50.0, 0.0);
            } else {
                component.rise();
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$moveToLowestBlockInTheAirGreenInkskin(CallbackInfo ci) {
        PlayerGreenInklingComponent component = (PlayerGreenInklingComponent)SplatterComponents.GREEN_INKLING.get(this);
        if (component.isDiving() && !this.isSpectator() && !this.isOnGround()) {
            boolean foundBlock = false;

            for(int i = -1; i >= -5; --i) {
                BlockPos downPos = this.getBlockPos().add(0, i, 0);
                if (!this.getWorld().getBlockState(downPos).getCollisionShape(this.getWorld(), downPos).isEmpty()) {
                    foundBlock = true;
                    break;
                }
            }

            if (foundBlock) {
                this.addVelocity(0.0, -50.0, 0.0);
            } else {
                component.rise();
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$moveToLowestBlockInTheAirLightBlueInkskin(CallbackInfo ci) {
        PlayerLightBlueOctolingComponent component = (PlayerLightBlueOctolingComponent)SplatterComponents.LIGHT_BLUE_OCTOLING.get(this);
        if (component.isDiving() && !this.isSpectator() && !this.isOnGround()) {
            boolean foundBlock = false;

            for(int i = -1; i >= -5; --i) {
                BlockPos downPos = this.getBlockPos().add(0, i, 0);
                if (!this.getWorld().getBlockState(downPos).getCollisionShape(this.getWorld(), downPos).isEmpty()) {
                    foundBlock = true;
                    break;
                }
            }

            if (foundBlock) {
                this.addVelocity(0.0, -50.0, 0.0);
            } else {
                component.rise();
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$moveToLowestBlockInTheAirLightGrayInkskin(CallbackInfo ci) {
        PlayerLightGrayOctolingComponent component = (PlayerLightGrayOctolingComponent)SplatterComponents.LIGHT_GRAY_OCTOLING.get(this);
        if (component.isDiving() && !this.isSpectator() && !this.isOnGround()) {
            boolean foundBlock = false;

            for(int i = -1; i >= -5; --i) {
                BlockPos downPos = this.getBlockPos().add(0, i, 0);
                if (!this.getWorld().getBlockState(downPos).getCollisionShape(this.getWorld(), downPos).isEmpty()) {
                    foundBlock = true;
                    break;
                }
            }

            if (foundBlock) {
                this.addVelocity(0.0, -50.0, 0.0);
            } else {
                component.rise();
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$moveToLowestBlockInTheAirLimeInkskin(CallbackInfo ci) {
        PlayerLimeInklingComponent component = (PlayerLimeInklingComponent)SplatterComponents.LIME_INKLING.get(this);
        if (component.isDiving() && !this.isSpectator() && !this.isOnGround()) {
            boolean foundBlock = false;

            for(int i = -1; i >= -5; --i) {
                BlockPos downPos = this.getBlockPos().add(0, i, 0);
                if (!this.getWorld().getBlockState(downPos).getCollisionShape(this.getWorld(), downPos).isEmpty()) {
                    foundBlock = true;
                    break;
                }
            }

            if (foundBlock) {
                this.addVelocity(0.0, -50.0, 0.0);
            } else {
                component.rise();
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$moveToLowestBlockInTheAirMagentaInkskin(CallbackInfo ci) {
        PlayerMagentaOctolingComponent component = (PlayerMagentaOctolingComponent)SplatterComponents.MAGENTA_OCTOLING.get(this);
        if (component.isDiving() && !this.isSpectator() && !this.isOnGround()) {
            boolean foundBlock = false;

            for(int i = -1; i >= -5; --i) {
                BlockPos downPos = this.getBlockPos().add(0, i, 0);
                if (!this.getWorld().getBlockState(downPos).getCollisionShape(this.getWorld(), downPos).isEmpty()) {
                    foundBlock = true;
                    break;
                }
            }

            if (foundBlock) {
                this.addVelocity(0.0, -50.0, 0.0);
            } else {
                component.rise();
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$moveToLowestBlockInTheAirOrangeInkskin(CallbackInfo ci) {
        PlayerOrangeInklingComponent component = (PlayerOrangeInklingComponent)SplatterComponents.ORANGE_INKLING.get(this);
        if (component.isDiving() && !this.isSpectator() && !this.isOnGround()) {
            boolean foundBlock = false;

            for(int i = -1; i >= -5; --i) {
                BlockPos downPos = this.getBlockPos().add(0, i, 0);
                if (!this.getWorld().getBlockState(downPos).getCollisionShape(this.getWorld(), downPos).isEmpty()) {
                    foundBlock = true;
                    break;
                }
            }

            if (foundBlock) {
                this.addVelocity(0.0, -50.0, 0.0);
            } else {
                component.rise();
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$moveToLowestBlockInTheAirPinkInkskin(CallbackInfo ci) {
        PlayerPinkInklingComponent component = (PlayerPinkInklingComponent)SplatterComponents.PINK_INKLING.get(this);
        if (component.isDiving() && !this.isSpectator() && !this.isOnGround()) {
            boolean foundBlock = false;

            for(int i = -1; i >= -5; --i) {
                BlockPos downPos = this.getBlockPos().add(0, i, 0);
                if (!this.getWorld().getBlockState(downPos).getCollisionShape(this.getWorld(), downPos).isEmpty()) {
                    foundBlock = true;
                    break;
                }
            }

            if (foundBlock) {
                this.addVelocity(0.0, -50.0, 0.0);
            } else {
                component.rise();
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$moveToLowestBlockInTheAirPurpleInkskin(CallbackInfo ci) {
        PlayerPurpleInklingComponent component = (PlayerPurpleInklingComponent)SplatterComponents.PURPLE_INKLING.get(this);
        if (component.isDiving() && !this.isSpectator() && !this.isOnGround()) {
            boolean foundBlock = false;

            for(int i = -1; i >= -5; --i) {
                BlockPos downPos = this.getBlockPos().add(0, i, 0);
                if (!this.getWorld().getBlockState(downPos).getCollisionShape(this.getWorld(), downPos).isEmpty()) {
                    foundBlock = true;
                    break;
                }
            }

            if (foundBlock) {
                this.addVelocity(0.0, -50.0, 0.0);
            } else {
                component.rise();
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$moveToLowestBlockInTheAirRedInkskin(CallbackInfo ci) {
        PlayerRedOctolingComponent component = (PlayerRedOctolingComponent)SplatterComponents.RED_OCTOLING.get(this);
        if (component.isDiving() && !this.isSpectator() && !this.isOnGround()) {
            boolean foundBlock = false;

            for(int i = -1; i >= -5; --i) {
                BlockPos downPos = this.getBlockPos().add(0, i, 0);
                if (!this.getWorld().getBlockState(downPos).getCollisionShape(this.getWorld(), downPos).isEmpty()) {
                    foundBlock = true;
                    break;
                }
            }

            if (foundBlock) {
                this.addVelocity(0.0, -50.0, 0.0);
            } else {
                component.rise();
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$moveToLowestBlockInTheAirWhiteInkskin(CallbackInfo ci) {
        PlayerWhiteOctolingComponent component = (PlayerWhiteOctolingComponent)SplatterComponents.WHITE_OCTOLING.get(this);
        if (component.isDiving() && !this.isSpectator() && !this.isOnGround()) {
            boolean foundBlock = false;

            for(int i = -1; i >= -5; --i) {
                BlockPos downPos = this.getBlockPos().add(0, i, 0);
                if (!this.getWorld().getBlockState(downPos).getCollisionShape(this.getWorld(), downPos).isEmpty()) {
                    foundBlock = true;
                    break;
                }
            }

            if (foundBlock) {
                this.addVelocity(0.0, -50.0, 0.0);
            } else {
                component.rise();
            }
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$moveToLowestBlockInTheAirYellowInkskin(CallbackInfo ci) {
        PlayerYellowInklingComponent component = (PlayerYellowInklingComponent)SplatterComponents.YELLOW_INKLING.get(this);
        if (component.isDiving() && !this.isSpectator() && !this.isOnGround()) {
            boolean foundBlock = false;

            for(int i = -1; i >= -5; --i) {
                BlockPos downPos = this.getBlockPos().add(0, i, 0);
                if (!this.getWorld().getBlockState(downPos).getCollisionShape(this.getWorld(), downPos).isEmpty()) {
                    foundBlock = true;
                    break;
                }
            }

            if (foundBlock) {
                this.addVelocity(0.0, -50.0, 0.0);
            } else {
                component.rise();
            }
        }
    }

    @ModifyReturnValue(
            method = {"isBlockBreakingRestricted"},
            at = {@At("RETURN")}
    )
    private boolean splatter$removeBlockBreakingForDivingInklings(boolean original) {
        return ((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(this)).isDiving() ? true : original;
    }

    @Inject(
            method = {"isInvulnerableTo"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$disableDivingInkskinDamageButExplosiveAndOutOfWorld(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(this)).isDiving() && !damageSource.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY) && !damageSource.isIn(DamageTypeTags.IS_EXPLOSION)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(
            method = {"attack"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$disableAttackForDivingInkskins(Entity target, CallbackInfo ci) {
        if (((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"damage"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$inkskinsDiveOnFallDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerBlackOctolingComponent component = (PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(this);
        if (component.isOctoling() && source.isOf(DamageTypes.FALL) && this.getWorld() instanceof ServerWorld) {
            component.dive();
            cir.setReturnValue(false);
        }
    }

    @ModifyArg(
            method = {"updatePose"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;setPose(Lnet/minecraft/entity/EntityPose;)V"
            )
    )
    private EntityPose splatter$forceStanding(EntityPose value) {
        return value != EntityPose.STANDING && ((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(this)).isDiving() ? EntityPose.STANDING : value;
    }
}