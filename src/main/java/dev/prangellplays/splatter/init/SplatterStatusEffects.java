package dev.prangellplays.splatter.init;

import dev.prangellplays.splatter.Splatter;
import dev.prangellplays.splatter.effect.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public class SplatterStatusEffects {
    private static final Map<StatusEffect, Identifier> EFFECTS = new LinkedHashMap();
    //Inkling
    public static final StatusEffect BLUE_INKSKIN = create("blue_inkskin", new BlueInkskinStatusEffect());
    public static final StatusEffect CYAN_INKSKIN = create("cyan_inkskin", new CyanInkskinStatusEffect());
    public static final StatusEffect GREEN_INKSKIN = create("green_inkskin", new GreenInkskinStatusEffect());
    public static final StatusEffect LIME_INKSKIN = create("lime_inkskin", new LimeInkskinStatusEffect());
    public static final StatusEffect ORANGE_INKSKIN = create("orange_inkskin", new OrangeInkskinStatusEffect());
    public static final StatusEffect PINK_INKSKIN = create("pink_inkskin", new PinkInkskinStatusEffect());
    public static final StatusEffect PURPLE_INKSKIN = create("purple_inkskin", new PurpleInkskinStatusEffect());
    public static final StatusEffect YELLOW_INKSKIN = create("yellow_inkskin", new YellowInkskinStatusEffect());

    //Octoling
    public static final StatusEffect BLACK_INKSKIN = create("black_inkskin", new BlackInkskinStatusEffect());
    public static final StatusEffect BROWN_INKSKIN = create("brown_inkskin", new BrownInkskinStatusEffect());
    public static final StatusEffect GRAY_INKSKIN = create("gray_inkskin", new GrayInkskinStatusEffect());
    public static final StatusEffect LIGHT_BLUE_INKSKIN = create("light_blue_inkskin", new LightBlueInkskinStatusEffect());
    public static final StatusEffect LIGHT_GRAY_INKSKIN = create("light_gray_inkskin", new LightGrayInkskinStatusEffect());
    public static final StatusEffect MAGENTA_INKSKIN = create("magenta_inkskin", new MagentaInkskinStatusEffect());
    public static final StatusEffect RED_INKSKIN = create("red_inkskin", new RedInkskinStatusEffect());
    public static final StatusEffect WHITE_INKSKIN = create("white_inkskin", new WhiteInkskinStatusEffect());

    public SplatterStatusEffects() {
    }

    public static void init() {
        EFFECTS.keySet().forEach((effect) -> {
            Registry.register(Registries.STATUS_EFFECT, (Identifier)EFFECTS.get(effect), effect);
        });
    }

    private static <T extends StatusEffect> T create(String name, T effect) {
        EFFECTS.put(effect, Splatter.id(name));
        return effect;
    }
}