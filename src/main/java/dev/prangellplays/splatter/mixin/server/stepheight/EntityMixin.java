package dev.prangellplays.splatter.mixin.server.stepheight;

import dev.prangellplays.splatter.attribute.StepHeightEntityAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Inject(method = "getStepHeight", at = @At(value = "TAIL"), cancellable = true)
    public void getStepHeight(CallbackInfoReturnable<Float> cir) {
        if((Object)this instanceof LivingEntity) {
            float baseStepHeight = cir.getReturnValue();
            cir.setReturnValue(StepHeightEntityAttribute.getStepHeight(baseStepHeight, (LivingEntity) (Object)this));
        }
    }
}