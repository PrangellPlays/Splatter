package dev.prangellplays.splatter.attribute;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;

public class InkskinInkSpeedBoostEntityAttribute {
    public static EntityAttribute INKLING_INK_SPEED_BOOST;

    public static float getStepHeight(float baseStepHeight, LivingEntity entity) {
        return baseStepHeight + (float) entity.getAttributeInstance(INKLING_INK_SPEED_BOOST).getValue();
    }
}