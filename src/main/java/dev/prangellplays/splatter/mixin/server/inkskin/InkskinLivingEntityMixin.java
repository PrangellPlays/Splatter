package dev.prangellplays.splatter.mixin.server.inkskin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.prangellplays.splatter.Splatter;
import dev.prangellplays.splatter.command.SplatterCommand;
import dev.prangellplays.splatter.components.octoling.PlayerBlackOctolingComponent;
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



    @Inject(
            method = {"applyMovementEffects"},
            at = {@At("TAIL")}
    )
    protected void splatter$applyInkSpeedBoost(BlockPos pos, CallbackInfo ci) {
        if (this.shouldRemoveInkskinsSpeedBoost(this.getLandingBlockState())) {
            this.removeInkskinsSpeedBoost();
        }
        this.addBlackInkskinSpeedBoostIfNeeded();
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


}