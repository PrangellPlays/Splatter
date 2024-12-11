package dev.prangellplays.splatter.mixin.server.stepheight;

import dev.prangellplays.splatter.attribute.InkskinInkSpeedBoostEntityAttribute;
import dev.prangellplays.splatter.attribute.StepHeightEntityAttribute;
import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(EntityAttributes.class)
public abstract class EntityAttributesMixin {
    @Shadow
    private static EntityAttribute register(String id, EntityAttribute attribute) {
        throw new UnsupportedOperationException();
    }

    static {
        StepHeightEntityAttribute.STEP_HEIGHT = register("splatter:stepheight", new ClampedEntityAttribute("generic.splatter.step-height", 0.0F, -1024.0F, 1024.0F).setTracked(true));
        InkskinInkSpeedBoostEntityAttribute.INKLING_INK_SPEED_BOOST = register("splatter:inkskin_ink_speed_boost", new ClampedEntityAttribute("generic.splatter.inkskin-ink-speed-boost", 0.0F, 0.0F, 1F).setTracked(true));
    }
}