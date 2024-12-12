package dev.prangellplays.splatter.mixin.server.inkskin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.prangellplays.splatter.Splatter;
import dev.prangellplays.splatter.command.SplatterCommand;
import dev.prangellplays.splatter.components.inkling.*;
import dev.prangellplays.splatter.components.octoling.*;
import dev.prangellplays.splatter.init.SplatterComponents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({PlayerEntity.class})
public abstract class InkskinOnInkVelocityMultiplierEntityMixin extends LivingEntity {
    protected InkskinOnInkVelocityMultiplierEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @ModifyReturnValue(
            method = {"getVelocityMultiplier"},
            at = {@At("RETURN")}
    )
    protected float splatter$increaseBlackInkskinSpeedOnInk(float original) {
        PlayerBlackOctolingComponent component = (PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.getNullable(this);
        return component != null && component.isOctoling() && Splatter.isCollidingWithBlackInk(this) ? original * (component.isDiving() ? 1.55F * SplatterCommand.getInkskinDiveSpeed() : 1.0F) : original;
    }

    @ModifyReturnValue(
            method = {"getVelocityMultiplier"},
            at = {@At("RETURN")}
    )
    protected float splatter$increaseBlueInkskinSpeedOnInk(float original) {
        PlayerBlueInklingComponent component = (PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.getNullable(this);
        return component != null && component.isInkling() && Splatter.isCollidingWithBlackInk(this) ? original * (component.isDiving() ? 1.55F * SplatterCommand.getInkskinDiveSpeed() : 1.0F) : original;
    }

    @ModifyReturnValue(
            method = {"getVelocityMultiplier"},
            at = {@At("RETURN")}
    )
    protected float splatter$increaseBrownInkskinSpeedOnInk(float original) {
        PlayerBrownOctolingComponent component = (PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.getNullable(this);
        return component != null && component.isOctoling() && Splatter.isCollidingWithBlackInk(this) ? original * (component.isDiving() ? 1.55F * SplatterCommand.getInkskinDiveSpeed() : 1.0F) : original;
    }

    @ModifyReturnValue(
            method = {"getVelocityMultiplier"},
            at = {@At("RETURN")}
    )
    protected float splatter$increaseCyanInkskinSpeedOnInk(float original) {
        PlayerCyanInklingComponent component = (PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.getNullable(this);
        return component != null && component.isInkling() && Splatter.isCollidingWithBlackInk(this) ? original * (component.isDiving() ? 1.55F * SplatterCommand.getInkskinDiveSpeed() : 1.0F) : original;
    }

    @ModifyReturnValue(
            method = {"getVelocityMultiplier"},
            at = {@At("RETURN")}
    )
    protected float splatter$increaseGrayInkskinSpeedOnInk(float original) {
        PlayerGrayOctolingComponent component = (PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.getNullable(this);
        return component != null && component.isOctoling() && Splatter.isCollidingWithBlackInk(this) ? original * (component.isDiving() ? 1.55F * SplatterCommand.getInkskinDiveSpeed() : 1.0F) : original;
    }

    @ModifyReturnValue(
            method = {"getVelocityMultiplier"},
            at = {@At("RETURN")}
    )
    protected float splatter$increaseGreenInkskinSpeedOnInk(float original) {
        PlayerGreenInklingComponent component = (PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.getNullable(this);
        return component != null && component.isInkling() && Splatter.isCollidingWithBlackInk(this) ? original * (component.isDiving() ? 1.55F * SplatterCommand.getInkskinDiveSpeed() : 1.0F) : original;
    }

    @ModifyReturnValue(
            method = {"getVelocityMultiplier"},
            at = {@At("RETURN")}
    )
    protected float splatter$increaseLightBlueInkskinSpeedOnInk(float original) {
        PlayerLightBlueOctolingComponent component = (PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.getNullable(this);
        return component != null && component.isOctoling() && Splatter.isCollidingWithBlackInk(this) ? original * (component.isDiving() ? 1.55F * SplatterCommand.getInkskinDiveSpeed() : 1.0F) : original;
    }

    @ModifyReturnValue(
            method = {"getVelocityMultiplier"},
            at = {@At("RETURN")}
    )
    protected float splatter$increaseLightGrayInkskinSpeedOnInk(float original) {
        PlayerLightGrayOctolingComponent component = (PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.getNullable(this);
        return component != null && component.isOctoling() && Splatter.isCollidingWithBlackInk(this) ? original * (component.isDiving() ? 1.55F * SplatterCommand.getInkskinDiveSpeed() : 1.0F) : original;
    }

    @ModifyReturnValue(
            method = {"getVelocityMultiplier"},
            at = {@At("RETURN")}
    )
    protected float splatter$increaseLimeInkskinSpeedOnInk(float original) {
        PlayerLimeInklingComponent component = (PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.getNullable(this);
        return component != null && component.isInkling() && Splatter.isCollidingWithBlackInk(this) ? original * (component.isDiving() ? 1.55F * SplatterCommand.getInkskinDiveSpeed() : 1.0F) : original;
    }

    @ModifyReturnValue(
            method = {"getVelocityMultiplier"},
            at = {@At("RETURN")}
    )
    protected float splatter$increaseMagentaInkskinSpeedOnInk(float original) {
        PlayerMagentaOctolingComponent component = (PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.getNullable(this);
        return component != null && component.isOctoling() && Splatter.isCollidingWithBlackInk(this) ? original * (component.isDiving() ? 1.55F * SplatterCommand.getInkskinDiveSpeed() : 1.0F) : original;
    }

    @ModifyReturnValue(
            method = {"getVelocityMultiplier"},
            at = {@At("RETURN")}
    )
    protected float splatter$increaseOrangeInkskinSpeedOnInk(float original) {
        PlayerOrangeInklingComponent component = (PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.getNullable(this);
        return component != null && component.isInkling() && Splatter.isCollidingWithBlackInk(this) ? original * (component.isDiving() ? 1.55F * SplatterCommand.getInkskinDiveSpeed() : 1.0F) : original;
    }

    @ModifyReturnValue(
            method = {"getVelocityMultiplier"},
            at = {@At("RETURN")}
    )
    protected float splatter$increasePinkInkskinSpeedOnInk(float original) {
        PlayerPinkInklingComponent component = (PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.getNullable(this);
        return component != null && component.isInkling() && Splatter.isCollidingWithBlackInk(this) ? original * (component.isDiving() ? 1.55F * SplatterCommand.getInkskinDiveSpeed() : 1.0F) : original;
    }

    @ModifyReturnValue(
            method = {"getVelocityMultiplier"},
            at = {@At("RETURN")}
    )
    protected float splatter$increasePurpleInkskinSpeedOnInk(float original) {
        PlayerPurpleInklingComponent component = (PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.getNullable(this);
        return component != null && component.isInkling() && Splatter.isCollidingWithBlackInk(this) ? original * (component.isDiving() ? 1.55F * SplatterCommand.getInkskinDiveSpeed() : 1.0F) : original;
    }

    @ModifyReturnValue(
            method = {"getVelocityMultiplier"},
            at = {@At("RETURN")}
    )
    protected float splatter$increaseRedInkskinSpeedOnInk(float original) {
        PlayerRedOctolingComponent component = (PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.getNullable(this);
        return component != null && component.isOctoling() && Splatter.isCollidingWithBlackInk(this) ? original * (component.isDiving() ? 1.55F * SplatterCommand.getInkskinDiveSpeed() : 1.0F) : original;
    }

    @ModifyReturnValue(
            method = {"getVelocityMultiplier"},
            at = {@At("RETURN")}
    )
    protected float splatter$increaseWhiteInkskinSpeedOnInk(float original) {
        PlayerWhiteOctolingComponent component = (PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.getNullable(this);
        return component != null && component.isOctoling() && Splatter.isCollidingWithBlackInk(this) ? original * (component.isDiving() ? 1.55F * SplatterCommand.getInkskinDiveSpeed() : 1.0F) : original;
    }

    @ModifyReturnValue(
            method = {"getVelocityMultiplier"},
            at = {@At("RETURN")}
    )
    protected float splatter$increaseYellowInkskinSpeedOnInk(float original) {
        PlayerYellowInklingComponent component = (PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.getNullable(this);
        return component != null && component.isInkling() && Splatter.isCollidingWithBlackInk(this) ? original * (component.isDiving() ? 1.55F * SplatterCommand.getInkskinDiveSpeed() : 1.0F) : original;
    }
}