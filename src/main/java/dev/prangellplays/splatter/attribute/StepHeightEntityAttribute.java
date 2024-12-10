package dev.prangellplays.splatter.attribute;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;

public class StepHeightEntityAttribute {
    public static EntityAttribute STEP_HEIGHT;

    public static float getStepHeight(float baseStepHeight, LivingEntity entity) {
        return baseStepHeight + (float) entity.getAttributeInstance(STEP_HEIGHT).getValue();
    }
}