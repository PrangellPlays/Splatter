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
    private boolean splatter$removeBlockBreakingForDivingBlackInklings(boolean original) {
        return ((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(this)).isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"isBlockBreakingRestricted"},
            at = {@At("RETURN")}
    )
    private boolean splatter$removeBlockBreakingForDivingBlueInklings(boolean original) {
        return ((PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(this)).isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"isBlockBreakingRestricted"},
            at = {@At("RETURN")}
    )
    private boolean splatter$removeBlockBreakingForDivingBrownInklings(boolean original) {
        return ((PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(this)).isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"isBlockBreakingRestricted"},
            at = {@At("RETURN")}
    )
    private boolean splatter$removeBlockBreakingForDivingCyanInklings(boolean original) {
        return ((PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(this)).isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"isBlockBreakingRestricted"},
            at = {@At("RETURN")}
    )
    private boolean splatter$removeBlockBreakingForDivingGrayInklings(boolean original) {
        return ((PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(this)).isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"isBlockBreakingRestricted"},
            at = {@At("RETURN")}
    )
    private boolean splatter$removeBlockBreakingForDivingGreenInklings(boolean original) {
        return ((PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(this)).isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"isBlockBreakingRestricted"},
            at = {@At("RETURN")}
    )
    private boolean splatter$removeBlockBreakingForDivingLightBlueInklings(boolean original) {
        return ((PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(this)).isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"isBlockBreakingRestricted"},
            at = {@At("RETURN")}
    )
    private boolean splatter$removeBlockBreakingForDivingLightGrayInklings(boolean original) {
        return ((PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(this)).isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"isBlockBreakingRestricted"},
            at = {@At("RETURN")}
    )
    private boolean splatter$removeBlockBreakingForDivingLimeInklings(boolean original) {
        return ((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(this)).isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"isBlockBreakingRestricted"},
            at = {@At("RETURN")}
    )
    private boolean splatter$removeBlockBreakingForDivingMagentaInklings(boolean original) {
        return ((PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(this)).isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"isBlockBreakingRestricted"},
            at = {@At("RETURN")}
    )
    private boolean splatter$removeBlockBreakingForDivingOrangeInklings(boolean original) {
        return ((PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(this)).isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"isBlockBreakingRestricted"},
            at = {@At("RETURN")}
    )
    private boolean splatter$removeBlockBreakingForDivingPinkInklings(boolean original) {
        return ((PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(this)).isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"isBlockBreakingRestricted"},
            at = {@At("RETURN")}
    )
    private boolean splatter$removeBlockBreakingForDivingPurpleInklings(boolean original) {
        return ((PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(this)).isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"isBlockBreakingRestricted"},
            at = {@At("RETURN")}
    )
    private boolean splatter$removeBlockBreakingForDivingRedInklings(boolean original) {
        return ((PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(this)).isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"isBlockBreakingRestricted"},
            at = {@At("RETURN")}
    )
    private boolean splatter$removeBlockBreakingForDivingWhiteInklings(boolean original) {
        return ((PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(this)).isDiving() ? true : original;
    }

    @ModifyReturnValue(
            method = {"isBlockBreakingRestricted"},
            at = {@At("RETURN")}
    )
    private boolean splatter$removeBlockBreakingForDivingYellowInklings(boolean original) {
        return ((PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(this)).isDiving() ? true : original;
    }



    @Inject(
            method = {"isInvulnerableTo"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$disableDivingBlackInkskinDamageButExplosiveAndOutOfWorld(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(this)).isDiving() && !damageSource.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY) && !damageSource.isIn(DamageTypeTags.IS_EXPLOSION)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(
            method = {"isInvulnerableTo"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$disableDivingBlueInkskinDamageButExplosiveAndOutOfWorld(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (((PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(this)).isDiving() && !damageSource.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY) && !damageSource.isIn(DamageTypeTags.IS_EXPLOSION)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(
            method = {"isInvulnerableTo"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$disableDivingBrownInkskinDamageButExplosiveAndOutOfWorld(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (((PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(this)).isDiving() && !damageSource.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY) && !damageSource.isIn(DamageTypeTags.IS_EXPLOSION)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(
            method = {"isInvulnerableTo"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$disableDivingCyanInkskinDamageButExplosiveAndOutOfWorld(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (((PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(this)).isDiving() && !damageSource.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY) && !damageSource.isIn(DamageTypeTags.IS_EXPLOSION)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(
            method = {"isInvulnerableTo"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$disableDivingGrayInkskinDamageButExplosiveAndOutOfWorld(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (((PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(this)).isDiving() && !damageSource.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY) && !damageSource.isIn(DamageTypeTags.IS_EXPLOSION)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(
            method = {"isInvulnerableTo"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$disableDivingGreenInkskinDamageButExplosiveAndOutOfWorld(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (((PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(this)).isDiving() && !damageSource.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY) && !damageSource.isIn(DamageTypeTags.IS_EXPLOSION)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(
            method = {"isInvulnerableTo"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$disableDivingLightBlueInkskinDamageButExplosiveAndOutOfWorld(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (((PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(this)).isDiving() && !damageSource.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY) && !damageSource.isIn(DamageTypeTags.IS_EXPLOSION)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(
            method = {"isInvulnerableTo"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$disableDivingLightGrayInkskinDamageButExplosiveAndOutOfWorld(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (((PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(this)).isDiving() && !damageSource.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY) && !damageSource.isIn(DamageTypeTags.IS_EXPLOSION)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(
            method = {"isInvulnerableTo"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$disableDivingLimeInkskinDamageButExplosiveAndOutOfWorld(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(this)).isDiving() && !damageSource.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY) && !damageSource.isIn(DamageTypeTags.IS_EXPLOSION)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(
            method = {"isInvulnerableTo"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$disableDivingMagentaInkskinDamageButExplosiveAndOutOfWorld(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (((PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(this)).isDiving() && !damageSource.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY) && !damageSource.isIn(DamageTypeTags.IS_EXPLOSION)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(
            method = {"isInvulnerableTo"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$disableDivingOrangeInkskinDamageButExplosiveAndOutOfWorld(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (((PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(this)).isDiving() && !damageSource.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY) && !damageSource.isIn(DamageTypeTags.IS_EXPLOSION)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(
            method = {"isInvulnerableTo"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$disableDivingPinkInkskinDamageButExplosiveAndOutOfWorld(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (((PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(this)).isDiving() && !damageSource.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY) && !damageSource.isIn(DamageTypeTags.IS_EXPLOSION)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(
            method = {"isInvulnerableTo"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$disableDivingPurpleInkskinDamageButExplosiveAndOutOfWorld(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (((PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(this)).isDiving() && !damageSource.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY) && !damageSource.isIn(DamageTypeTags.IS_EXPLOSION)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(
            method = {"isInvulnerableTo"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$disableDivingRedInkskinDamageButExplosiveAndOutOfWorld(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (((PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(this)).isDiving() && !damageSource.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY) && !damageSource.isIn(DamageTypeTags.IS_EXPLOSION)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(
            method = {"isInvulnerableTo"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$disableDivingWhiteInkskinDamageButExplosiveAndOutOfWorld(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (((PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(this)).isDiving() && !damageSource.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY) && !damageSource.isIn(DamageTypeTags.IS_EXPLOSION)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(
            method = {"isInvulnerableTo"},
            at = {@At("RETURN")},
            cancellable = true
    )
    public void splatter$disableDivingYellowInkskinDamageButExplosiveAndOutOfWorld(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (((PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(this)).isDiving() && !damageSource.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY) && !damageSource.isIn(DamageTypeTags.IS_EXPLOSION)) {
            cir.setReturnValue(true);
        }
    }



    @Inject(
            method = {"attack"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$disableAttackForDivingBlackInkskins(Entity target, CallbackInfo ci) {
        if (((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"attack"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$disableAttackForDivingBlueInkskins(Entity target, CallbackInfo ci) {
        if (((PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"attack"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$disableAttackForDivingBrownInkskins(Entity target, CallbackInfo ci) {
        if (((PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"attack"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$disableAttackForDivingCyanInkskins(Entity target, CallbackInfo ci) {
        if (((PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"attack"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$disableAttackForDivingGrayInkskins(Entity target, CallbackInfo ci) {
        if (((PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"attack"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$disableAttackForDivingGreenInkskins(Entity target, CallbackInfo ci) {
        if (((PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"attack"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$disableAttackForDivingLightBlueInkskins(Entity target, CallbackInfo ci) {
        if (((PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"attack"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$disableAttackForDivingLightGrayInkskins(Entity target, CallbackInfo ci) {
        if (((PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"attack"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$disableAttackForDivingLimeInkskins(Entity target, CallbackInfo ci) {
        if (((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"attack"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$disableAttackForDivingMagentaInkskins(Entity target, CallbackInfo ci) {
        if (((PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"attack"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$disableAttackForDivingOrangeInkskins(Entity target, CallbackInfo ci) {
        if (((PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"attack"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$disableAttackForDivingPinkInkskins(Entity target, CallbackInfo ci) {
        if (((PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"attack"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$disableAttackForDivingPurpleInkskins(Entity target, CallbackInfo ci) {
        if (((PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"attack"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$disableAttackForDivingRedInkskins(Entity target, CallbackInfo ci) {
        if (((PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"attack"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$disableAttackForDivingWhiteInkskins(Entity target, CallbackInfo ci) {
        if (((PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }

    @Inject(
            method = {"attack"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$disableAttackForDivingYellowInkskins(Entity target, CallbackInfo ci) {
        if (((PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(this)).isDiving()) {
            ci.cancel();
        }
    }



    @Inject(
            method = {"damage"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$blackInkskinsDiveOnFallDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerBlackOctolingComponent component = (PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(this);
        if (component.isOctoling() && source.isOf(DamageTypes.FALL) && this.getWorld() instanceof ServerWorld) {
            component.dive();
            cir.setReturnValue(false);
        }
    }

    @Inject(
            method = {"damage"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$blueInkskinsDiveOnFallDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerBlueInklingComponent component = (PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(this);
        if (component.isInkling() && source.isOf(DamageTypes.FALL) && this.getWorld() instanceof ServerWorld) {
            component.dive();
            cir.setReturnValue(false);
        }
    }

    @Inject(
            method = {"damage"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$brownInkskinsDiveOnFallDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerBrownOctolingComponent component = (PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(this);
        if (component.isOctoling() && source.isOf(DamageTypes.FALL) && this.getWorld() instanceof ServerWorld) {
            component.dive();
            cir.setReturnValue(false);
        }
    }

    @Inject(
            method = {"damage"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$cyanInkskinsDiveOnFallDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerCyanInklingComponent component = (PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(this);
        if (component.isInkling() && source.isOf(DamageTypes.FALL) && this.getWorld() instanceof ServerWorld) {
            component.dive();
            cir.setReturnValue(false);
        }
    }

    @Inject(
            method = {"damage"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$grayInkskinsDiveOnFallDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerGrayOctolingComponent component = (PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(this);
        if (component.isOctoling() && source.isOf(DamageTypes.FALL) && this.getWorld() instanceof ServerWorld) {
            component.dive();
            cir.setReturnValue(false);
        }
    }

    @Inject(
            method = {"damage"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$greenInkskinsDiveOnFallDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerGreenInklingComponent component = (PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(this);
        if (component.isInkling() && source.isOf(DamageTypes.FALL) && this.getWorld() instanceof ServerWorld) {
            component.dive();
            cir.setReturnValue(false);
        }
    }

    @Inject(
            method = {"damage"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$lightBlueInkskinsDiveOnFallDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerLightBlueOctolingComponent component = (PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(this);
        if (component.isOctoling() && source.isOf(DamageTypes.FALL) && this.getWorld() instanceof ServerWorld) {
            component.dive();
            cir.setReturnValue(false);
        }
    }

    @Inject(
            method = {"damage"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$lightGrayInkskinsDiveOnFallDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerLightGrayOctolingComponent component = (PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(this);
        if (component.isOctoling() && source.isOf(DamageTypes.FALL) && this.getWorld() instanceof ServerWorld) {
            component.dive();
            cir.setReturnValue(false);
        }
    }

    @Inject(
            method = {"damage"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$limeInkskinsDiveOnFallDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerLimeInklingComponent component = (PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(this);
        if (component.isInkling() && source.isOf(DamageTypes.FALL) && this.getWorld() instanceof ServerWorld) {
            component.dive();
            cir.setReturnValue(false);
        }
    }

    @Inject(
            method = {"damage"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$magentaInkskinsDiveOnFallDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerMagentaOctolingComponent component = (PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(this);
        if (component.isOctoling() && source.isOf(DamageTypes.FALL) && this.getWorld() instanceof ServerWorld) {
            component.dive();
            cir.setReturnValue(false);
        }
    }

    @Inject(
            method = {"damage"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$orangeInkskinsDiveOnFallDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerOrangeInklingComponent component = (PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(this);
        if (component.isInkling() && source.isOf(DamageTypes.FALL) && this.getWorld() instanceof ServerWorld) {
            component.dive();
            cir.setReturnValue(false);
        }
    }

    @Inject(
            method = {"damage"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$pinkInkskinsDiveOnFallDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerPinkInklingComponent component = (PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(this);
        if (component.isInkling() && source.isOf(DamageTypes.FALL) && this.getWorld() instanceof ServerWorld) {
            component.dive();
            cir.setReturnValue(false);
        }
    }

    @Inject(
            method = {"damage"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$purpleInkskinsDiveOnFallDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerPurpleInklingComponent component = (PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(this);
        if (component.isInkling() && source.isOf(DamageTypes.FALL) && this.getWorld() instanceof ServerWorld) {
            component.dive();
            cir.setReturnValue(false);
        }
    }

    @Inject(
            method = {"damage"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$redInkskinsDiveOnFallDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerRedOctolingComponent component = (PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(this);
        if (component.isOctoling() && source.isOf(DamageTypes.FALL) && this.getWorld() instanceof ServerWorld) {
            component.dive();
            cir.setReturnValue(false);
        }
    }

    @Inject(
            method = {"damage"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$whiteInkskinsDiveOnFallDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerWhiteOctolingComponent component = (PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(this);
        if (component.isOctoling() && source.isOf(DamageTypes.FALL) && this.getWorld() instanceof ServerWorld) {
            component.dive();
            cir.setReturnValue(false);
        }
    }

    @Inject(
            method = {"damage"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void splatter$yellowInkskinsDiveOnFallDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerYellowInklingComponent component = (PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(this);
        if (component.isInkling() && source.isOf(DamageTypes.FALL) && this.getWorld() instanceof ServerWorld) {
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
    private EntityPose splatter$forceStandingBlackInkskin(EntityPose value) {
        return value != EntityPose.STANDING && ((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(this)).isDiving() ? EntityPose.STANDING : value;
    }

    @ModifyArg(
            method = {"updatePose"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;setPose(Lnet/minecraft/entity/EntityPose;)V"
            )
    )
    private EntityPose splatter$forceStandingBlueInkskin(EntityPose value) {
        return value != EntityPose.STANDING && ((PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(this)).isDiving() ? EntityPose.STANDING : value;
    }

    @ModifyArg(
            method = {"updatePose"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;setPose(Lnet/minecraft/entity/EntityPose;)V"
            )
    )
    private EntityPose splatter$forceStandingBrownInkskin(EntityPose value) {
        return value != EntityPose.STANDING && ((PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(this)).isDiving() ? EntityPose.STANDING : value;
    }

    @ModifyArg(
            method = {"updatePose"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;setPose(Lnet/minecraft/entity/EntityPose;)V"
            )
    )
    private EntityPose splatter$forceStandingCyanInkskin(EntityPose value) {
        return value != EntityPose.STANDING && ((PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(this)).isDiving() ? EntityPose.STANDING : value;
    }

    @ModifyArg(
            method = {"updatePose"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;setPose(Lnet/minecraft/entity/EntityPose;)V"
            )
    )
    private EntityPose splatter$forceStandingGrayInkskin(EntityPose value) {
        return value != EntityPose.STANDING && ((PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(this)).isDiving() ? EntityPose.STANDING : value;
    }

    @ModifyArg(
            method = {"updatePose"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;setPose(Lnet/minecraft/entity/EntityPose;)V"
            )
    )
    private EntityPose splatter$forceStandingGreenInkskin(EntityPose value) {
        return value != EntityPose.STANDING && ((PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(this)).isDiving() ? EntityPose.STANDING : value;
    }

    @ModifyArg(
            method = {"updatePose"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;setPose(Lnet/minecraft/entity/EntityPose;)V"
            )
    )
    private EntityPose splatter$forceStandingLightBlueInkskin(EntityPose value) {
        return value != EntityPose.STANDING && ((PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(this)).isDiving() ? EntityPose.STANDING : value;
    }

    @ModifyArg(
            method = {"updatePose"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;setPose(Lnet/minecraft/entity/EntityPose;)V"
            )
    )
    private EntityPose splatter$forceStandingLightGrayInkskin(EntityPose value) {
        return value != EntityPose.STANDING && ((PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(this)).isDiving() ? EntityPose.STANDING : value;
    }

    @ModifyArg(
            method = {"updatePose"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;setPose(Lnet/minecraft/entity/EntityPose;)V"
            )
    )
    private EntityPose splatter$forceStandingLimeInkskin(EntityPose value) {
        return value != EntityPose.STANDING && ((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(this)).isDiving() ? EntityPose.STANDING : value;
    }

    @ModifyArg(
            method = {"updatePose"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;setPose(Lnet/minecraft/entity/EntityPose;)V"
            )
    )
    private EntityPose splatter$forceStandingMagentaInkskin(EntityPose value) {
        return value != EntityPose.STANDING && ((PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(this)).isDiving() ? EntityPose.STANDING : value;
    }

    @ModifyArg(
            method = {"updatePose"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;setPose(Lnet/minecraft/entity/EntityPose;)V"
            )
    )
    private EntityPose splatter$forceStandingOrangeInkskin(EntityPose value) {
        return value != EntityPose.STANDING && ((PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(this)).isDiving() ? EntityPose.STANDING : value;
    }

    @ModifyArg(
            method = {"updatePose"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;setPose(Lnet/minecraft/entity/EntityPose;)V"
            )
    )
    private EntityPose splatter$forceStandingPinkInkskin(EntityPose value) {
        return value != EntityPose.STANDING && ((PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(this)).isDiving() ? EntityPose.STANDING : value;
    }

    @ModifyArg(
            method = {"updatePose"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;setPose(Lnet/minecraft/entity/EntityPose;)V"
            )
    )
    private EntityPose splatter$forceStandingPurpleInkskin(EntityPose value) {
        return value != EntityPose.STANDING && ((PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(this)).isDiving() ? EntityPose.STANDING : value;
    }

    @ModifyArg(
            method = {"updatePose"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;setPose(Lnet/minecraft/entity/EntityPose;)V"
            )
    )
    private EntityPose splatter$forceStandingRedInkskin(EntityPose value) {
        return value != EntityPose.STANDING && ((PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(this)).isDiving() ? EntityPose.STANDING : value;
    }

    @ModifyArg(
            method = {"updatePose"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;setPose(Lnet/minecraft/entity/EntityPose;)V"
            )
    )
    private EntityPose splatter$forceStandingWhiteInkskin(EntityPose value) {
        return value != EntityPose.STANDING && ((PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(this)).isDiving() ? EntityPose.STANDING : value;
    }

    @ModifyArg(
            method = {"updatePose"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;setPose(Lnet/minecraft/entity/EntityPose;)V"
            )
    )
    private EntityPose splatter$forceStandingYellowInkskin(EntityPose value) {
        return value != EntityPose.STANDING && ((PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(this)).isDiving() ? EntityPose.STANDING : value;
    }
}