package dev.prangellplays.splatter.mixin.client.inkskin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.mojang.authlib.GameProfile;
import dev.prangellplays.splatter.Splatter;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin({ClientPlayerEntity.class})
public abstract class PreventSprintingClientPlayerEntityMixin extends AbstractClientPlayerEntity {
    public PreventSprintingClientPlayerEntityMixin(ClientWorld world, GameProfile profile) {
        super(world, profile);
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$disableSprintingOnBlackInk(CallbackInfo ci) {
        if (Splatter.isCollidingWithBlackInk(this)) {
            this.setSprinting(false);
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$disableSprintingOnBlueInk(CallbackInfo ci) {
        if (Splatter.isCollidingWithBlueInk(this)) {
            this.setSprinting(false);
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$disableSprintingOnBrownInk(CallbackInfo ci) {
        if (Splatter.isCollidingWithBrownInk(this)) {
            this.setSprinting(false);
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$disableSprintingOnCyanInk(CallbackInfo ci) {
        if (Splatter.isCollidingWithCyanInk(this)) {
            this.setSprinting(false);
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$disableSprintingOnGrayInk(CallbackInfo ci) {
        if (Splatter.isCollidingWithGrayInk(this)) {
            this.setSprinting(false);
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$disableSprintingOnGreenInk(CallbackInfo ci) {
        if (Splatter.isCollidingWithGreenInk(this)) {
            this.setSprinting(false);
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$disableSprintingOnLightBlueInk(CallbackInfo ci) {
        if (Splatter.isCollidingWithLightBlueInk(this)) {
            this.setSprinting(false);
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$disableSprintingOnLightGrayInk(CallbackInfo ci) {
        if (Splatter.isCollidingWithLightGrayInk(this)) {
            this.setSprinting(false);
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$disableSprintingOnLimeInk(CallbackInfo ci) {
        if (Splatter.isCollidingWithLimeInk(this)) {
            this.setSprinting(false);
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$disableSprintingOnMagentaInk(CallbackInfo ci) {
        if (Splatter.isCollidingWithMagentaInk(this)) {
            this.setSprinting(false);
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$disableSprintingOnOrangeInk(CallbackInfo ci) {
        if (Splatter.isCollidingWithOrangeInk(this)) {
            this.setSprinting(false);
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$disableSprintingOnPinkInk(CallbackInfo ci) {
        if (Splatter.isCollidingWithPinkInk(this)) {
            this.setSprinting(false);
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$disableSprintingOnPurpleInk(CallbackInfo ci) {
        if (Splatter.isCollidingWithPurpleInk(this)) {
            this.setSprinting(false);
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$disableSprintingOnRedInk(CallbackInfo ci) {
        if (Splatter.isCollidingWithRedInk(this)) {
            this.setSprinting(false);
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$disableSprintingOnWhiteInk(CallbackInfo ci) {
        if (Splatter.isCollidingWithWhiteInk(this)) {
            this.setSprinting(false);
        }
    }

    @Inject(
            method = {"tickMovement"},
            at = {@At("HEAD")}
    )
    public void splatter$disableSprintingOnYellowInk(CallbackInfo ci) {
        if (Splatter.isCollidingWithYellowInk(this)) {
            this.setSprinting(false);
        }
    }

    @ModifyReturnValue(
            method = {"canSprint"},
            at = {@At("RETURN")}
    )
    private boolean splatter$preventSprintingOnBlackInk(boolean original) {
        return original && !Splatter.isCollidingWithBlackInk(this);
    }

    @ModifyReturnValue(
            method = {"canSprint"},
            at = {@At("RETURN")}
    )
    private boolean splatter$preventSprintingOnBlueInk(boolean original) {
        return original && !Splatter.isCollidingWithBlueInk(this);
    }

    @ModifyReturnValue(
            method = {"canSprint"},
            at = {@At("RETURN")}
    )
    private boolean splatter$preventSprintingOnBrownInk(boolean original) {
        return original && !Splatter.isCollidingWithBrownInk(this);
    }

    @ModifyReturnValue(
            method = {"canSprint"},
            at = {@At("RETURN")}
    )
    private boolean splatter$preventSprintingOnCyanInk(boolean original) {
        return original && !Splatter.isCollidingWithCyanInk(this);
    }

    @ModifyReturnValue(
            method = {"canSprint"},
            at = {@At("RETURN")}
    )
    private boolean splatter$preventSprintingOnGrayInk(boolean original) {
        return original && !Splatter.isCollidingWithGrayInk(this);
    }

    @ModifyReturnValue(
            method = {"canSprint"},
            at = {@At("RETURN")}
    )
    private boolean splatter$preventSprintingOnGreenInk(boolean original) {
        return original && !Splatter.isCollidingWithGreenInk(this);
    }

    @ModifyReturnValue(
            method = {"canSprint"},
            at = {@At("RETURN")}
    )
    private boolean splatter$preventSprintingOnLightBlueInk(boolean original) {
        return original && !Splatter.isCollidingWithLightBlueInk(this);
    }

    @ModifyReturnValue(
            method = {"canSprint"},
            at = {@At("RETURN")}
    )
    private boolean splatter$preventSprintingOnLightGrayInk(boolean original) {
        return original && !Splatter.isCollidingWithLightGrayInk(this);
    }

    @ModifyReturnValue(
            method = {"canSprint"},
            at = {@At("RETURN")}
    )
    private boolean splatter$preventSprintingOnLimeInk(boolean original) {
        return original && !Splatter.isCollidingWithLimeInk(this);
    }

    @ModifyReturnValue(
            method = {"canSprint"},
            at = {@At("RETURN")}
    )
    private boolean splatter$preventSprintingOnMagentaInk(boolean original) {
        return original && !Splatter.isCollidingWithMagentaInk(this);
    }

    @ModifyReturnValue(
            method = {"canSprint"},
            at = {@At("RETURN")}
    )
    private boolean splatter$preventSprintingOnOrangeInk(boolean original) {
        return original && !Splatter.isCollidingWithOrangeInk(this);
    }

    @ModifyReturnValue(
            method = {"canSprint"},
            at = {@At("RETURN")}
    )
    private boolean splatter$preventSprintingOnPinkInk(boolean original) {
        return original && !Splatter.isCollidingWithPinkInk(this);
    }

    @ModifyReturnValue(
            method = {"canSprint"},
            at = {@At("RETURN")}
    )
    private boolean splatter$preventSprintingOnPurpleInk(boolean original) {
        return original && !Splatter.isCollidingWithPurpleInk(this);
    }

    @ModifyReturnValue(
            method = {"canSprint"},
            at = {@At("RETURN")}
    )
    private boolean splatter$preventSprintingOnRedInk(boolean original) {
        return original && !Splatter.isCollidingWithRedInk(this);
    }

    @ModifyReturnValue(
            method = {"canSprint"},
            at = {@At("RETURN")}
    )
    private boolean splatter$preventSprintingOnWhiteInk(boolean original) {
        return original && !Splatter.isCollidingWithWhiteInk(this);
    }

    @ModifyReturnValue(
            method = {"canSprint"},
            at = {@At("RETURN")}
    )
    private boolean splatter$preventSprintingOnYellowInk(boolean original) {
        return original && !Splatter.isCollidingWithYellowInk(this);
    }
}
