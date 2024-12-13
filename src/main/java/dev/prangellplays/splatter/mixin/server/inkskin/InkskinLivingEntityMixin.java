package dev.prangellplays.splatter.mixin.server.inkskin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.prangellplays.splatter.Splatter;
import dev.prangellplays.splatter.command.SplatterCommand;
import dev.prangellplays.splatter.components.inkling.*;
import dev.prangellplays.splatter.components.octoling.*;
import dev.prangellplays.splatter.init.SplatterComponents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin({LivingEntity.class})
public abstract class InkskinLivingEntityMixin extends Entity {
    @Unique
    private static final UUID INKLING_INK_SPEED_BOOST_ID = UUID.fromString("baf54358-8812-471c-9bb9-c04c433ad9ef");

    @Shadow
    public abstract @Nullable EntityAttributeInstance getAttributeInstance(EntityAttribute var1);

    @Shadow
    public abstract boolean isFallFlying();

    public InkskinLivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @WrapWithCondition(
            method = {"fall"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/world/ServerWorld;spawnParticles(Lnet/minecraft/particle/ParticleEffect;DDDIDDDD)I"
            )}
    )
    protected <T extends ParticleEffect> boolean splatter$removeFallingOnBlockParticlesForBlackInkskins(ServerWorld instance, T particle, double x, double y, double z, int count, double deltaX, double deltaY, double deltaZ, double speed) {
        boolean var10000;
        label15: {
            if (this.getControllingPassenger() instanceof PlayerEntity player) {
                if (((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(player)).isOctoling()) {
                    break label15;
                }
            }
            if (!Splatter.isABlackInkFacingDown(this.getWorld(), this.getBlockPos())) {
                var10000 = true;
                return var10000;
            }
        }
        var10000 = false;
        return var10000;
    }

    @WrapWithCondition(
            method = {"fall"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/world/ServerWorld;spawnParticles(Lnet/minecraft/particle/ParticleEffect;DDDIDDDD)I"
            )}
    )
    protected <T extends ParticleEffect> boolean splatter$removeFallingOnBlockParticlesForBlueInkskins(ServerWorld instance, T particle, double x, double y, double z, int count, double deltaX, double deltaY, double deltaZ, double speed) {
        boolean var10000;
        label15: {
            if (this.getControllingPassenger() instanceof PlayerEntity player) {
                if (((PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(player)).isInkling()) {
                    break label15;
                }
            }
            if (!Splatter.isABlueInkFacingDown(this.getWorld(), this.getBlockPos())) {
                var10000 = true;
                return var10000;
            }
        }
        var10000 = false;
        return var10000;
    }

    @WrapWithCondition(
            method = {"fall"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/world/ServerWorld;spawnParticles(Lnet/minecraft/particle/ParticleEffect;DDDIDDDD)I"
            )}
    )
    protected <T extends ParticleEffect> boolean splatter$removeFallingOnBlockParticlesForBrownInkskins(ServerWorld instance, T particle, double x, double y, double z, int count, double deltaX, double deltaY, double deltaZ, double speed) {
        boolean var10000;
        label15: {
            if (this.getControllingPassenger() instanceof PlayerEntity player) {
                if (((PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(player)).isOctoling()) {
                    break label15;
                }
            }
            if (!Splatter.isABrownInkFacingDown(this.getWorld(), this.getBlockPos())) {
                var10000 = true;
                return var10000;
            }
        }
        var10000 = false;
        return var10000;
    }

    @WrapWithCondition(
            method = {"fall"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/world/ServerWorld;spawnParticles(Lnet/minecraft/particle/ParticleEffect;DDDIDDDD)I"
            )}
    )
    protected <T extends ParticleEffect> boolean splatter$removeFallingOnBlockParticlesForCyanInkskins(ServerWorld instance, T particle, double x, double y, double z, int count, double deltaX, double deltaY, double deltaZ, double speed) {
        boolean var10000;
        label15: {
            if (this.getControllingPassenger() instanceof PlayerEntity player) {
                if (((PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(player)).isInkling()) {
                    break label15;
                }
            }
            if (!Splatter.isACyanInkFacingDown(this.getWorld(), this.getBlockPos())) {
                var10000 = true;
                return var10000;
            }
        }
        var10000 = false;
        return var10000;
    }

    @WrapWithCondition(
            method = {"fall"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/world/ServerWorld;spawnParticles(Lnet/minecraft/particle/ParticleEffect;DDDIDDDD)I"
            )}
    )
    protected <T extends ParticleEffect> boolean splatter$removeFallingOnBlockParticlesForGrayInkskins(ServerWorld instance, T particle, double x, double y, double z, int count, double deltaX, double deltaY, double deltaZ, double speed) {
        boolean var10000;
        label15: {
            if (this.getControllingPassenger() instanceof PlayerEntity player) {
                if (((PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(player)).isOctoling()) {
                    break label15;
                }
            }
            if (!Splatter.isAGrayInkFacingDown(this.getWorld(), this.getBlockPos())) {
                var10000 = true;
                return var10000;
            }
        }
        var10000 = false;
        return var10000;
    }

    @WrapWithCondition(
            method = {"fall"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/world/ServerWorld;spawnParticles(Lnet/minecraft/particle/ParticleEffect;DDDIDDDD)I"
            )}
    )
    protected <T extends ParticleEffect> boolean splatter$removeFallingOnBlockParticlesForGreenInkskins(ServerWorld instance, T particle, double x, double y, double z, int count, double deltaX, double deltaY, double deltaZ, double speed) {
        boolean var10000;
        label15: {
            if (this.getControllingPassenger() instanceof PlayerEntity player) {
                if (((PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(player)).isInkling()) {
                    break label15;
                }
            }
            if (!Splatter.isAGreenInkFacingDown(this.getWorld(), this.getBlockPos())) {
                var10000 = true;
                return var10000;
            }
        }
        var10000 = false;
        return var10000;
    }

    @WrapWithCondition(
            method = {"fall"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/world/ServerWorld;spawnParticles(Lnet/minecraft/particle/ParticleEffect;DDDIDDDD)I"
            )}
    )
    protected <T extends ParticleEffect> boolean splatter$removeFallingOnBlockParticlesForLightBlueInkskins(ServerWorld instance, T particle, double x, double y, double z, int count, double deltaX, double deltaY, double deltaZ, double speed) {
        boolean var10000;
        label15: {
            if (this.getControllingPassenger() instanceof PlayerEntity player) {
                if (((PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(player)).isOctoling()) {
                    break label15;
                }
            }
            if (!Splatter.isALightBlueInkFacingDown(this.getWorld(), this.getBlockPos())) {
                var10000 = true;
                return var10000;
            }
        }
        var10000 = false;
        return var10000;
    }

    @WrapWithCondition(
            method = {"fall"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/world/ServerWorld;spawnParticles(Lnet/minecraft/particle/ParticleEffect;DDDIDDDD)I"
            )}
    )
    protected <T extends ParticleEffect> boolean splatter$removeFallingOnBlockParticlesForLightGrayInkskins(ServerWorld instance, T particle, double x, double y, double z, int count, double deltaX, double deltaY, double deltaZ, double speed) {
        boolean var10000;
        label15: {
            if (this.getControllingPassenger() instanceof PlayerEntity player) {
                if (((PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(player)).isOctoling()) {
                    break label15;
                }
            }
            if (!Splatter.isALightGrayInkFacingDown(this.getWorld(), this.getBlockPos())) {
                var10000 = true;
                return var10000;
            }
        }
        var10000 = false;
        return var10000;
    }

    @WrapWithCondition(
            method = {"fall"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/world/ServerWorld;spawnParticles(Lnet/minecraft/particle/ParticleEffect;DDDIDDDD)I"
            )}
    )
    protected <T extends ParticleEffect> boolean splatter$removeFallingOnBlockParticlesForLimeInkskins(ServerWorld instance, T particle, double x, double y, double z, int count, double deltaX, double deltaY, double deltaZ, double speed) {
        boolean var10000;
        label15: {
            if (this.getControllingPassenger() instanceof PlayerEntity player) {
                if (((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(player)).isInkling()) {
                    break label15;
                }
            }
            if (!Splatter.isALimeInkFacingDown(this.getWorld(), this.getBlockPos())) {
                var10000 = true;
                return var10000;
            }
        }
        var10000 = false;
        return var10000;
    }

    @WrapWithCondition(
            method = {"fall"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/world/ServerWorld;spawnParticles(Lnet/minecraft/particle/ParticleEffect;DDDIDDDD)I"
            )}
    )
    protected <T extends ParticleEffect> boolean splatter$removeFallingOnBlockParticlesForMagentaInkskins(ServerWorld instance, T particle, double x, double y, double z, int count, double deltaX, double deltaY, double deltaZ, double speed) {
        boolean var10000;
        label15: {
            if (this.getControllingPassenger() instanceof PlayerEntity player) {
                if (((PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(player)).isOctoling()) {
                    break label15;
                }
            }
            if (!Splatter.isAMagentaInkFacingDown(this.getWorld(), this.getBlockPos())) {
                var10000 = true;
                return var10000;
            }
        }
        var10000 = false;
        return var10000;
    }

    @WrapWithCondition(
            method = {"fall"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/world/ServerWorld;spawnParticles(Lnet/minecraft/particle/ParticleEffect;DDDIDDDD)I"
            )}
    )
    protected <T extends ParticleEffect> boolean splatter$removeFallingOnBlockParticlesForOrangeInkskins(ServerWorld instance, T particle, double x, double y, double z, int count, double deltaX, double deltaY, double deltaZ, double speed) {
        boolean var10000;
        label15: {
            if (this.getControllingPassenger() instanceof PlayerEntity player) {
                if (((PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(player)).isInkling()) {
                    break label15;
                }
            }
            if (!Splatter.isAOrangeInkFacingDown(this.getWorld(), this.getBlockPos())) {
                var10000 = true;
                return var10000;
            }
        }
        var10000 = false;
        return var10000;
    }

    @WrapWithCondition(
            method = {"fall"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/world/ServerWorld;spawnParticles(Lnet/minecraft/particle/ParticleEffect;DDDIDDDD)I"
            )}
    )
    protected <T extends ParticleEffect> boolean splatter$removeFallingOnBlockParticlesForPinkInkskins(ServerWorld instance, T particle, double x, double y, double z, int count, double deltaX, double deltaY, double deltaZ, double speed) {
        boolean var10000;
        label15: {
            if (this.getControllingPassenger() instanceof PlayerEntity player) {
                if (((PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(player)).isInkling()) {
                    break label15;
                }
            }
            if (!Splatter.isAPinkInkFacingDown(this.getWorld(), this.getBlockPos())) {
                var10000 = true;
                return var10000;
            }
        }
        var10000 = false;
        return var10000;
    }

    @WrapWithCondition(
            method = {"fall"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/world/ServerWorld;spawnParticles(Lnet/minecraft/particle/ParticleEffect;DDDIDDDD)I"
            )}
    )
    protected <T extends ParticleEffect> boolean splatter$removeFallingOnBlockParticlesForPurpleInkskins(ServerWorld instance, T particle, double x, double y, double z, int count, double deltaX, double deltaY, double deltaZ, double speed) {
        boolean var10000;
        label15: {
            if (this.getControllingPassenger() instanceof PlayerEntity player) {
                if (((PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(player)).isInkling()) {
                    break label15;
                }
            }
            if (!Splatter.isAPurpleInkFacingDown(this.getWorld(), this.getBlockPos())) {
                var10000 = true;
                return var10000;
            }
        }
        var10000 = false;
        return var10000;
    }

    @WrapWithCondition(
            method = {"fall"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/world/ServerWorld;spawnParticles(Lnet/minecraft/particle/ParticleEffect;DDDIDDDD)I"
            )}
    )
    protected <T extends ParticleEffect> boolean splatter$removeFallingOnBlockParticlesForRedInkskins(ServerWorld instance, T particle, double x, double y, double z, int count, double deltaX, double deltaY, double deltaZ, double speed) {
        boolean var10000;
        label15: {
            if (this.getControllingPassenger() instanceof PlayerEntity player) {
                if (((PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(player)).isOctoling()) {
                    break label15;
                }
            }
            if (!Splatter.isARedInkFacingDown(this.getWorld(), this.getBlockPos())) {
                var10000 = true;
                return var10000;
            }
        }
        var10000 = false;
        return var10000;
    }

    @WrapWithCondition(
            method = {"fall"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/world/ServerWorld;spawnParticles(Lnet/minecraft/particle/ParticleEffect;DDDIDDDD)I"
            )}
    )
    protected <T extends ParticleEffect> boolean splatter$removeFallingOnBlockParticlesForWhiteInkskins(ServerWorld instance, T particle, double x, double y, double z, int count, double deltaX, double deltaY, double deltaZ, double speed) {
        boolean var10000;
        label15: {
            if (this.getControllingPassenger() instanceof PlayerEntity player) {
                if (((PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(player)).isOctoling()) {
                    break label15;
                }
            }
            if (!Splatter.isAWhiteInkFacingDown(this.getWorld(), this.getBlockPos())) {
                var10000 = true;
                return var10000;
            }
        }
        var10000 = false;
        return var10000;
    }

    @WrapWithCondition(
            method = {"fall"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/world/ServerWorld;spawnParticles(Lnet/minecraft/particle/ParticleEffect;DDDIDDDD)I"
            )}
    )
    protected <T extends ParticleEffect> boolean splatter$removeFallingOnBlockParticlesForYellowInkskins(ServerWorld instance, T particle, double x, double y, double z, int count, double deltaX, double deltaY, double deltaZ, double speed) {
        boolean var10000;
        label15: {
            if (this.getControllingPassenger() instanceof PlayerEntity player) {
                if (((PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(player)).isInkling()) {
                    break label15;
                }
            }
            if (!Splatter.isAYellowInkFacingDown(this.getWorld(), this.getBlockPos())) {
                var10000 = true;
                return var10000;
            }
        }
        var10000 = false;
        return var10000;
    }



    @ModifyArg(
            method = {"applyMovementInput"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;updateVelocity(FLnet/minecraft/util/math/Vec3d;)V"
            )
    )
    private float splatter$multiplyMovementSpeedOfLaunchedBlackInkskinsInAir(float value) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerBlackOctolingComponent component = (PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(player);
            if (component.isOctoling() && component.getLaunchTicks() > 0) {
                if (!player.isOnGround()) {
                    return value * 3.0F * SplatterCommand.getInkskinLaunchAirSpeed();
                }
                if (component.getLaunchTicks() < 90) {
                    component.setLaunchTicks(0);
                }
            }
        }
        return value;
    }

    @ModifyArg(
            method = {"applyMovementInput"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;updateVelocity(FLnet/minecraft/util/math/Vec3d;)V"
            )
    )
    private float splatter$multiplyMovementSpeedOfLaunchedBlueInkskinsInAir(float value) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerBlueInklingComponent component = (PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(player);
            if (component.isInkling() && component.getLaunchTicks() > 0) {
                if (!player.isOnGround()) {
                    return value * 3.0F * SplatterCommand.getInkskinLaunchAirSpeed();
                }
                if (component.getLaunchTicks() < 90) {
                    component.setLaunchTicks(0);
                }
            }
        }
        return value;
    }

    @ModifyArg(
            method = {"applyMovementInput"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;updateVelocity(FLnet/minecraft/util/math/Vec3d;)V"
            )
    )
    private float splatter$multiplyMovementSpeedOfLaunchedBrownInkskinsInAir(float value) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerBrownOctolingComponent component = (PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(player);
            if (component.isOctoling() && component.getLaunchTicks() > 0) {
                if (!player.isOnGround()) {
                    return value * 3.0F * SplatterCommand.getInkskinLaunchAirSpeed();
                }
                if (component.getLaunchTicks() < 90) {
                    component.setLaunchTicks(0);
                }
            }
        }
        return value;
    }

    @ModifyArg(
            method = {"applyMovementInput"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;updateVelocity(FLnet/minecraft/util/math/Vec3d;)V"
            )
    )
    private float splatter$multiplyMovementSpeedOfLaunchedCyanInkskinsInAir(float value) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerCyanInklingComponent component = (PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(player);
            if (component.isInkling() && component.getLaunchTicks() > 0) {
                if (!player.isOnGround()) {
                    return value * 3.0F * SplatterCommand.getInkskinLaunchAirSpeed();
                }
                if (component.getLaunchTicks() < 90) {
                    component.setLaunchTicks(0);
                }
            }
        }
        return value;
    }

    @ModifyArg(
            method = {"applyMovementInput"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;updateVelocity(FLnet/minecraft/util/math/Vec3d;)V"
            )
    )
    private float splatter$multiplyMovementSpeedOfLaunchedGrayInkskinsInAir(float value) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerGrayOctolingComponent component = (PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(player);
            if (component.isOctoling() && component.getLaunchTicks() > 0) {
                if (!player.isOnGround()) {
                    return value * 3.0F * SplatterCommand.getInkskinLaunchAirSpeed();
                }
                if (component.getLaunchTicks() < 90) {
                    component.setLaunchTicks(0);
                }
            }
        }
        return value;
    }

    @ModifyArg(
            method = {"applyMovementInput"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;updateVelocity(FLnet/minecraft/util/math/Vec3d;)V"
            )
    )
    private float splatter$multiplyMovementSpeedOfLaunchedGreenInkskinsInAir(float value) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerGreenInklingComponent component = (PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(player);
            if (component.isInkling() && component.getLaunchTicks() > 0) {
                if (!player.isOnGround()) {
                    return value * 3.0F * SplatterCommand.getInkskinLaunchAirSpeed();
                }
                if (component.getLaunchTicks() < 90) {
                    component.setLaunchTicks(0);
                }
            }
        }
        return value;
    }

    @ModifyArg(
            method = {"applyMovementInput"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;updateVelocity(FLnet/minecraft/util/math/Vec3d;)V"
            )
    )
    private float splatter$multiplyMovementSpeedOfLaunchedLightBlueInkskinsInAir(float value) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerLightBlueOctolingComponent component = (PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(player);
            if (component.isOctoling() && component.getLaunchTicks() > 0) {
                if (!player.isOnGround()) {
                    return value * 3.0F * SplatterCommand.getInkskinLaunchAirSpeed();
                }
                if (component.getLaunchTicks() < 90) {
                    component.setLaunchTicks(0);
                }
            }
        }
        return value;
    }

    @ModifyArg(
            method = {"applyMovementInput"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;updateVelocity(FLnet/minecraft/util/math/Vec3d;)V"
            )
    )
    private float splatter$multiplyMovementSpeedOfLaunchedLightGrayInkskinsInAir(float value) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerLightGrayOctolingComponent component = (PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(player);
            if (component.isOctoling() && component.getLaunchTicks() > 0) {
                if (!player.isOnGround()) {
                    return value * 3.0F * SplatterCommand.getInkskinLaunchAirSpeed();
                }
                if (component.getLaunchTicks() < 90) {
                    component.setLaunchTicks(0);
                }
            }
        }
        return value;
    }

    @ModifyArg(
            method = {"applyMovementInput"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;updateVelocity(FLnet/minecraft/util/math/Vec3d;)V"
            )
    )
    private float splatter$multiplyMovementSpeedOfLaunchedLimeInkskinsInAir(float value) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerLimeInklingComponent component = (PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(player);
            if (component.isInkling() && component.getLaunchTicks() > 0) {
                if (!player.isOnGround()) {
                    return value * 3.0F * SplatterCommand.getInkskinLaunchAirSpeed();
                }
                if (component.getLaunchTicks() < 90) {
                    component.setLaunchTicks(0);
                }
            }
        }
        return value;
    }

    @ModifyArg(
            method = {"applyMovementInput"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;updateVelocity(FLnet/minecraft/util/math/Vec3d;)V"
            )
    )
    private float splatter$multiplyMovementSpeedOfLaunchedMagentaInkskinsInAir(float value) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerMagentaOctolingComponent component = (PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(player);
            if (component.isOctoling() && component.getLaunchTicks() > 0) {
                if (!player.isOnGround()) {
                    return value * 3.0F * SplatterCommand.getInkskinLaunchAirSpeed();
                }
                if (component.getLaunchTicks() < 90) {
                    component.setLaunchTicks(0);
                }
            }
        }
        return value;
    }

    @ModifyArg(
            method = {"applyMovementInput"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;updateVelocity(FLnet/minecraft/util/math/Vec3d;)V"
            )
    )
    private float splatter$multiplyMovementSpeedOfLaunchedOrangeInkskinsInAir(float value) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerOrangeInklingComponent component = (PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(player);
            if (component.isInkling() && component.getLaunchTicks() > 0) {
                if (!player.isOnGround()) {
                    return value * 3.0F * SplatterCommand.getInkskinLaunchAirSpeed();
                }
                if (component.getLaunchTicks() < 90) {
                    component.setLaunchTicks(0);
                }
            }
        }
        return value;
    }

    @ModifyArg(
            method = {"applyMovementInput"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;updateVelocity(FLnet/minecraft/util/math/Vec3d;)V"
            )
    )
    private float splatter$multiplyMovementSpeedOfLaunchedPinkInkskinsInAir(float value) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerPinkInklingComponent component = (PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(player);
            if (component.isInkling() && component.getLaunchTicks() > 0) {
                if (!player.isOnGround()) {
                    return value * 3.0F * SplatterCommand.getInkskinLaunchAirSpeed();
                }
                if (component.getLaunchTicks() < 90) {
                    component.setLaunchTicks(0);
                }
            }
        }
        return value;
    }

    @ModifyArg(
            method = {"applyMovementInput"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;updateVelocity(FLnet/minecraft/util/math/Vec3d;)V"
            )
    )
    private float splatter$multiplyMovementSpeedOfLaunchedPurpleInkskinsInAir(float value) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerPurpleInklingComponent component = (PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(player);
            if (component.isInkling() && component.getLaunchTicks() > 0) {
                if (!player.isOnGround()) {
                    return value * 3.0F * SplatterCommand.getInkskinLaunchAirSpeed();
                }
                if (component.getLaunchTicks() < 90) {
                    component.setLaunchTicks(0);
                }
            }
        }
        return value;
    }

    @ModifyArg(
            method = {"applyMovementInput"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;updateVelocity(FLnet/minecraft/util/math/Vec3d;)V"
            )
    )
    private float splatter$multiplyMovementSpeedOfLaunchedRedInkskinsInAir(float value) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerRedOctolingComponent component = (PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(player);
            if (component.isOctoling() && component.getLaunchTicks() > 0) {
                if (!player.isOnGround()) {
                    return value * 3.0F * SplatterCommand.getInkskinLaunchAirSpeed();
                }
                if (component.getLaunchTicks() < 90) {
                    component.setLaunchTicks(0);
                }
            }
        }
        return value;
    }

    @ModifyArg(
            method = {"applyMovementInput"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;updateVelocity(FLnet/minecraft/util/math/Vec3d;)V"
            )
    )
    private float splatter$multiplyMovementSpeedOfLaunchedWhiteInkskinsInAir(float value) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerWhiteOctolingComponent component = (PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(player);
            if (component.isOctoling() && component.getLaunchTicks() > 0) {
                if (!player.isOnGround()) {
                    return value * 3.0F * SplatterCommand.getInkskinLaunchAirSpeed();
                }
                if (component.getLaunchTicks() < 90) {
                    component.setLaunchTicks(0);
                }
            }
        }
        return value;
    }

    @ModifyArg(
            method = {"applyMovementInput"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;updateVelocity(FLnet/minecraft/util/math/Vec3d;)V"
            )
    )
    private float splatter$multiplyMovementSpeedOfLaunchedYellowInkskinsInAir(float value) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            PlayerYellowInklingComponent component = (PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(player);
            if (component.isInkling() && component.getLaunchTicks() > 0) {
                if (!player.isOnGround()) {
                    return value * 3.0F * SplatterCommand.getInkskinLaunchAirSpeed();
                }
                if (component.getLaunchTicks() < 90) {
                    component.setLaunchTicks(0);
                }
            }
        }
        return value;
    }



    @WrapOperation(
            method = {"travel"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/Block;getSlipperiness()F"
            )}
    )
    public float splatter$disableSlipperinessForBlackInkskins(Block instance, Operation<Float> original) {
        PlayerBlackOctolingComponent component = (PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.getNullable(this);
        return component != null && component.isOctoling() ? 0.6F : (Float)original.call(instance);
    }

    @WrapOperation(
            method = {"travel"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/Block;getSlipperiness()F"
            )}
    )
    public float splatter$disableSlipperinessForBlueInkskins(Block instance, Operation<Float> original) {
        PlayerBlueInklingComponent component = (PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.getNullable(this);
        return component != null && component.isInkling() ? 0.6F : (Float)original.call(instance);
    }

    @WrapOperation(
            method = {"travel"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/Block;getSlipperiness()F"
            )}
    )
    public float splatter$disableSlipperinessForBrownInkskins(Block instance, Operation<Float> original) {
        PlayerBrownOctolingComponent component = (PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.getNullable(this);
        return component != null && component.isOctoling() ? 0.6F : (Float)original.call(instance);
    }

    @WrapOperation(
            method = {"travel"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/Block;getSlipperiness()F"
            )}
    )
    public float splatter$disableSlipperinessForCyanInkskins(Block instance, Operation<Float> original) {
        PlayerCyanInklingComponent component = (PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.getNullable(this);
        return component != null && component.isInkling() ? 0.6F : (Float)original.call(instance);
    }

    @WrapOperation(
            method = {"travel"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/Block;getSlipperiness()F"
            )}
    )
    public float splatter$disableSlipperinessForGrayInkskins(Block instance, Operation<Float> original) {
        PlayerGrayOctolingComponent component = (PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.getNullable(this);
        return component != null && component.isOctoling() ? 0.6F : (Float)original.call(instance);
    }

    @WrapOperation(
            method = {"travel"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/Block;getSlipperiness()F"
            )}
    )
    public float splatter$disableSlipperinessForGreenInkskins(Block instance, Operation<Float> original) {
        PlayerGreenInklingComponent component = (PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.getNullable(this);
        return component != null && component.isInkling() ? 0.6F : (Float)original.call(instance);
    }

    @WrapOperation(
            method = {"travel"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/Block;getSlipperiness()F"
            )}
    )
    public float splatter$disableSlipperinessForLightBlueInkskins(Block instance, Operation<Float> original) {
        PlayerLightBlueOctolingComponent component = (PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.getNullable(this);
        return component != null && component.isOctoling() ? 0.6F : (Float)original.call(instance);
    }

    @WrapOperation(
            method = {"travel"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/Block;getSlipperiness()F"
            )}
    )
    public float splatter$disableSlipperinessForLightGrayInkskins(Block instance, Operation<Float> original) {
        PlayerLightGrayOctolingComponent component = (PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.getNullable(this);
        return component != null && component.isOctoling() ? 0.6F : (Float)original.call(instance);
    }

    @WrapOperation(
            method = {"travel"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/Block;getSlipperiness()F"
            )}
    )
    public float splatter$disableSlipperinessForLimeInkskins(Block instance, Operation<Float> original) {
        PlayerLimeInklingComponent component = (PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.getNullable(this);
        return component != null && component.isInkling() ? 0.6F : (Float)original.call(instance);
    }

    @WrapOperation(
            method = {"travel"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/Block;getSlipperiness()F"
            )}
    )
    public float splatter$disableSlipperinessForMagentaInkskins(Block instance, Operation<Float> original) {
        PlayerMagentaOctolingComponent component = (PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.getNullable(this);
        return component != null && component.isOctoling() ? 0.6F : (Float)original.call(instance);
    }

    @WrapOperation(
            method = {"travel"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/Block;getSlipperiness()F"
            )}
    )
    public float splatter$disableSlipperinessForOrangeInkskins(Block instance, Operation<Float> original) {
        PlayerOrangeInklingComponent component = (PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.getNullable(this);
        return component != null && component.isInkling() ? 0.6F : (Float)original.call(instance);
    }

    @WrapOperation(
            method = {"travel"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/Block;getSlipperiness()F"
            )}
    )
    public float splatter$disableSlipperinessForPinkInkskins(Block instance, Operation<Float> original) {
        PlayerPinkInklingComponent component = (PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.getNullable(this);
        return component != null && component.isInkling() ? 0.6F : (Float)original.call(instance);
    }

    @WrapOperation(
            method = {"travel"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/Block;getSlipperiness()F"
            )}
    )
    public float splatter$disableSlipperinessForPurpleInkskins(Block instance, Operation<Float> original) {
        PlayerPurpleInklingComponent component = (PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.getNullable(this);
        return component != null && component.isInkling() ? 0.6F : (Float)original.call(instance);
    }

    @WrapOperation(
            method = {"travel"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/Block;getSlipperiness()F"
            )}
    )
    public float splatter$disableSlipperinessForRedInkskins(Block instance, Operation<Float> original) {
        PlayerRedOctolingComponent component = (PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.getNullable(this);
        return component != null && component.isOctoling() ? 0.6F : (Float)original.call(instance);
    }

    @WrapOperation(
            method = {"travel"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/Block;getSlipperiness()F"
            )}
    )
    public float splatter$disableSlipperinessForWhiteInkskins(Block instance, Operation<Float> original) {
        PlayerWhiteOctolingComponent component = (PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.getNullable(this);
        return component != null && component.isOctoling() ? 0.6F : (Float)original.call(instance);
    }

    @WrapOperation(
            method = {"travel"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/Block;getSlipperiness()F"
            )}
    )
    public float splatter$disableSlipperinessForYellowInkskins(Block instance, Operation<Float> original) {
        PlayerYellowInklingComponent component = (PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.getNullable(this);
        return component != null && component.isInkling() ? 0.6F : (Float)original.call(instance);
    }



    @Inject(
            method = {"applyMovementEffects"},
            at = {@At("TAIL")}
    )
    protected void splatter$applyInkSpeedBoost(BlockPos pos, CallbackInfo ci) {
        if (this.shouldRemoveInkskinsSpeedBoost(this.getLandingBlockState())) {
            this.removeInkskinsSpeedBoost();
        }
        this.addBlackInkskinSpeedBoostIfNeeded();
        this.addBlueInkskinSpeedBoostIfNeeded();
        this.addBrownInkskinSpeedBoostIfNeeded();
        this.addCyanInkskinSpeedBoostIfNeeded();
        this.addGrayInkskinSpeedBoostIfNeeded();
        this.addGreenInkskinSpeedBoostIfNeeded();
        this.addLightBlueInkskinSpeedBoostIfNeeded();
        this.addLightGrayInkskinSpeedBoostIfNeeded();
        this.addLimeInkskinSpeedBoostIfNeeded();
        this.addMagentaInkskinSpeedBoostIfNeeded();
        this.addOrangeInkskinSpeedBoostIfNeeded();
        this.addPinkInkskinSpeedBoostIfNeeded();
        this.addPurpleInkskinSpeedBoostIfNeeded();
        this.addRedInkskinSpeedBoostIfNeeded();
        this.addWhiteInkskinSpeedBoostIfNeeded();
        this.addYellowInkskinSpeedBoostIfNeeded();
    }



    @Unique
    protected boolean shouldRemoveInkskinsSpeedBoost(BlockState landingState) {
        return !landingState.isAir() || this.isFallFlying();
    }



    @Unique
    protected void removeInkskinsSpeedBoost() {
        EntityAttributeInstance entityAttributeInstance = this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
        if (entityAttributeInstance != null && entityAttributeInstance.getModifier(INKLING_INK_SPEED_BOOST_ID) != null) {
            entityAttributeInstance.removeModifier(INKLING_INK_SPEED_BOOST_ID);
        }
    }



    @Unique
    protected void addBlackInkskinSpeedBoostIfNeeded() {
        if (!this.getLandingBlockState().isAir()) {
            PlayerBlackOctolingComponent component = (PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.getNullable(this);
            if (component != null && component.isOctoling() && Splatter.isCollidingWithBlackInk(this)) {
                EntityAttributeInstance entityAttributeInstance = this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                if (entityAttributeInstance == null) {
                    return;
                }
                entityAttributeInstance.addTemporaryModifier(new EntityAttributeModifier(INKLING_INK_SPEED_BOOST_ID, "Inkling ink speed boost", 0.07500000298023224, EntityAttributeModifier.Operation.ADDITION));
            }
        }
    }

    @Unique
    protected void addBlueInkskinSpeedBoostIfNeeded() {
        if (!this.getLandingBlockState().isAir()) {
            PlayerBlueInklingComponent component = (PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.getNullable(this);
            if (component != null && component.isInkling() && Splatter.isCollidingWithBlueInk(this)) {
                EntityAttributeInstance entityAttributeInstance = this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                if (entityAttributeInstance == null) {
                    return;
                }
                entityAttributeInstance.addTemporaryModifier(new EntityAttributeModifier(INKLING_INK_SPEED_BOOST_ID, "Inkling ink speed boost", 0.07500000298023224, EntityAttributeModifier.Operation.ADDITION));
            }
        }
    }

    @Unique
    protected void addBrownInkskinSpeedBoostIfNeeded() {
        if (!this.getLandingBlockState().isAir()) {
            PlayerBrownOctolingComponent component = (PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.getNullable(this);
            if (component != null && component.isOctoling() && Splatter.isCollidingWithBrownInk(this)) {
                EntityAttributeInstance entityAttributeInstance = this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                if (entityAttributeInstance == null) {
                    return;
                }
                entityAttributeInstance.addTemporaryModifier(new EntityAttributeModifier(INKLING_INK_SPEED_BOOST_ID, "Inkling ink speed boost", 0.07500000298023224, EntityAttributeModifier.Operation.ADDITION));
            }
        }
    }

    @Unique
    protected void addCyanInkskinSpeedBoostIfNeeded() {
        if (!this.getLandingBlockState().isAir()) {
            PlayerCyanInklingComponent component = (PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.getNullable(this);
            if (component != null && component.isInkling() && Splatter.isCollidingWithCyanInk(this)) {
                EntityAttributeInstance entityAttributeInstance = this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                if (entityAttributeInstance == null) {
                    return;
                }
                entityAttributeInstance.addTemporaryModifier(new EntityAttributeModifier(INKLING_INK_SPEED_BOOST_ID, "Inkling ink speed boost", 0.07500000298023224, EntityAttributeModifier.Operation.ADDITION));
            }
        }
    }

    @Unique
    protected void addGrayInkskinSpeedBoostIfNeeded() {
        if (!this.getLandingBlockState().isAir()) {
            PlayerGrayOctolingComponent component = (PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.getNullable(this);
            if (component != null && component.isOctoling() && Splatter.isCollidingWithGrayInk(this)) {
                EntityAttributeInstance entityAttributeInstance = this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                if (entityAttributeInstance == null) {
                    return;
                }
                entityAttributeInstance.addTemporaryModifier(new EntityAttributeModifier(INKLING_INK_SPEED_BOOST_ID, "Inkling ink speed boost", 0.07500000298023224, EntityAttributeModifier.Operation.ADDITION));
            }
        }
    }

    @Unique
    protected void addGreenInkskinSpeedBoostIfNeeded() {
        if (!this.getLandingBlockState().isAir()) {
            PlayerGreenInklingComponent component = (PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.getNullable(this);
            if (component != null && component.isInkling() && Splatter.isCollidingWithGreenInk(this)) {
                EntityAttributeInstance entityAttributeInstance = this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                if (entityAttributeInstance == null) {
                    return;
                }
                entityAttributeInstance.addTemporaryModifier(new EntityAttributeModifier(INKLING_INK_SPEED_BOOST_ID, "Inkling ink speed boost", 0.07500000298023224, EntityAttributeModifier.Operation.ADDITION));
            }
        }
    }

    @Unique
    protected void addLightBlueInkskinSpeedBoostIfNeeded() {
        if (!this.getLandingBlockState().isAir()) {
            PlayerLightBlueOctolingComponent component = (PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.getNullable(this);
            if (component != null && component.isOctoling() && Splatter.isCollidingWithLightBlueInk(this)) {
                EntityAttributeInstance entityAttributeInstance = this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                if (entityAttributeInstance == null) {
                    return;
                }
                entityAttributeInstance.addTemporaryModifier(new EntityAttributeModifier(INKLING_INK_SPEED_BOOST_ID, "Inkling ink speed boost", 0.07500000298023224, EntityAttributeModifier.Operation.ADDITION));
            }
        }
    }

    @Unique
    protected void addLightGrayInkskinSpeedBoostIfNeeded() {
        if (!this.getLandingBlockState().isAir()) {
            PlayerLightGrayOctolingComponent component = (PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.getNullable(this);
            if (component != null && component.isOctoling() && Splatter.isCollidingWithLightGrayInk(this)) {
                EntityAttributeInstance entityAttributeInstance = this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                if (entityAttributeInstance == null) {
                    return;
                }
                entityAttributeInstance.addTemporaryModifier(new EntityAttributeModifier(INKLING_INK_SPEED_BOOST_ID, "Inkling ink speed boost", 0.07500000298023224, EntityAttributeModifier.Operation.ADDITION));
            }
        }
    }

    @Unique
    protected void addLimeInkskinSpeedBoostIfNeeded() {
        if (!this.getLandingBlockState().isAir()) {
            PlayerLimeInklingComponent component = (PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.getNullable(this);
            if (component != null && component.isInkling() && Splatter.isCollidingWithLimeInk(this)) {
                EntityAttributeInstance entityAttributeInstance = this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                if (entityAttributeInstance == null) {
                    return;
                }
                entityAttributeInstance.addTemporaryModifier(new EntityAttributeModifier(INKLING_INK_SPEED_BOOST_ID, "Inkling ink speed boost", 0.07500000298023224, EntityAttributeModifier.Operation.ADDITION));
            }
        }
    }

    @Unique
    protected void addMagentaInkskinSpeedBoostIfNeeded() {
        if (!this.getLandingBlockState().isAir()) {
            PlayerMagentaOctolingComponent component = (PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.getNullable(this);
            if (component != null && component.isOctoling() && Splatter.isCollidingWithMagentaInk(this)) {
                EntityAttributeInstance entityAttributeInstance = this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                if (entityAttributeInstance == null) {
                    return;
                }
                entityAttributeInstance.addTemporaryModifier(new EntityAttributeModifier(INKLING_INK_SPEED_BOOST_ID, "Inkling ink speed boost", 0.07500000298023224, EntityAttributeModifier.Operation.ADDITION));
            }
        }
    }

    @Unique
    protected void addOrangeInkskinSpeedBoostIfNeeded() {
        if (!this.getLandingBlockState().isAir()) {
            PlayerOrangeInklingComponent component = (PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.getNullable(this);
            if (component != null && component.isInkling() && Splatter.isCollidingWithOrangeInk(this)) {
                EntityAttributeInstance entityAttributeInstance = this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                if (entityAttributeInstance == null) {
                    return;
                }
                entityAttributeInstance.addTemporaryModifier(new EntityAttributeModifier(INKLING_INK_SPEED_BOOST_ID, "Inkling ink speed boost", 0.07500000298023224, EntityAttributeModifier.Operation.ADDITION));
            }
        }
    }

    @Unique
    protected void addPinkInkskinSpeedBoostIfNeeded() {
        if (!this.getLandingBlockState().isAir()) {
            PlayerPinkInklingComponent component = (PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.getNullable(this);
            if (component != null && component.isInkling() && Splatter.isCollidingWithPinkInk(this)) {
                EntityAttributeInstance entityAttributeInstance = this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                if (entityAttributeInstance == null) {
                    return;
                }
                entityAttributeInstance.addTemporaryModifier(new EntityAttributeModifier(INKLING_INK_SPEED_BOOST_ID, "Inkling ink speed boost", 0.07500000298023224, EntityAttributeModifier.Operation.ADDITION));
            }
        }
    }

    @Unique
    protected void addPurpleInkskinSpeedBoostIfNeeded() {
        if (!this.getLandingBlockState().isAir()) {
            PlayerPurpleInklingComponent component = (PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.getNullable(this);
            if (component != null && component.isInkling() && Splatter.isCollidingWithPurpleInk(this)) {
                EntityAttributeInstance entityAttributeInstance = this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                if (entityAttributeInstance == null) {
                    return;
                }
                entityAttributeInstance.addTemporaryModifier(new EntityAttributeModifier(INKLING_INK_SPEED_BOOST_ID, "Inkling ink speed boost", 0.07500000298023224, EntityAttributeModifier.Operation.ADDITION));
            }
        }
    }

    @Unique
    protected void addRedInkskinSpeedBoostIfNeeded() {
        if (!this.getLandingBlockState().isAir()) {
            PlayerRedOctolingComponent component = (PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.getNullable(this);
            if (component != null && component.isOctoling() && Splatter.isCollidingWithRedInk(this)) {
                EntityAttributeInstance entityAttributeInstance = this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                if (entityAttributeInstance == null) {
                    return;
                }
                entityAttributeInstance.addTemporaryModifier(new EntityAttributeModifier(INKLING_INK_SPEED_BOOST_ID, "Inkling ink speed boost", 0.07500000298023224, EntityAttributeModifier.Operation.ADDITION));
            }
        }
    }

    @Unique
    protected void addWhiteInkskinSpeedBoostIfNeeded() {
        if (!this.getLandingBlockState().isAir()) {
            PlayerWhiteOctolingComponent component = (PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.getNullable(this);
            if (component != null && component.isOctoling() && Splatter.isCollidingWithWhiteInk(this)) {
                EntityAttributeInstance entityAttributeInstance = this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                if (entityAttributeInstance == null) {
                    return;
                }
                entityAttributeInstance.addTemporaryModifier(new EntityAttributeModifier(INKLING_INK_SPEED_BOOST_ID, "Inkling ink speed boost", 0.07500000298023224, EntityAttributeModifier.Operation.ADDITION));
            }
        }
    }

    @Unique
    protected void addYellowInkskinSpeedBoostIfNeeded() {
        if (!this.getLandingBlockState().isAir()) {
            PlayerYellowInklingComponent component = (PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.getNullable(this);
            if (component != null && component.isInkling() && Splatter.isCollidingWithYellowInk(this)) {
                EntityAttributeInstance entityAttributeInstance = this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                if (entityAttributeInstance == null) {
                    return;
                }
                entityAttributeInstance.addTemporaryModifier(new EntityAttributeModifier(INKLING_INK_SPEED_BOOST_ID, "Inkling ink speed boost", 0.07500000298023224, EntityAttributeModifier.Operation.ADDITION));
            }
        }
    }
}