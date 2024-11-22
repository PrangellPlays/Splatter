package dev.prangellplays.splatter.init;

import dev.prangellplays.splatter.Splatter;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public class SplatterParticles {
    private static final Map<ParticleType<?>, Identifier> PARTICLES = new LinkedHashMap();
    //Inkling
    public static final DefaultParticleType BLUE_INK_SPLAT = (DefaultParticleType)create("blue_ink_splat", FabricParticleTypes.simple(true));
    public static final DefaultParticleType BLUE_FALLING_INK = (DefaultParticleType)create("falling_blue_ink", FabricParticleTypes.simple(true));

    public static final DefaultParticleType CYAN_INK_SPLAT = (DefaultParticleType)create("cyan_ink_splat", FabricParticleTypes.simple(true));
    public static final DefaultParticleType CYAN_FALLING_INK = (DefaultParticleType)create("falling_cyan_ink", FabricParticleTypes.simple(true));

    public static final DefaultParticleType GREEN_INK_SPLAT = (DefaultParticleType)create("green_ink_splat", FabricParticleTypes.simple(true));
    public static final DefaultParticleType GREEN_FALLING_INK = (DefaultParticleType)create("falling_green_ink", FabricParticleTypes.simple(true));

    public static final DefaultParticleType LIME_INK_SPLAT = (DefaultParticleType)create("lime_ink_splat", FabricParticleTypes.simple(true));
    public static final DefaultParticleType LIME_FALLING_INK = (DefaultParticleType)create("falling_lime_ink", FabricParticleTypes.simple(true));

    public static final DefaultParticleType ORANGE_INK_SPLAT = (DefaultParticleType)create("orange_ink_splat", FabricParticleTypes.simple(true));
    public static final DefaultParticleType ORANGE_FALLING_INK = (DefaultParticleType)create("falling_orange_ink", FabricParticleTypes.simple(true));

    public static final DefaultParticleType PINK_INK_SPLAT = (DefaultParticleType)create("pink_ink_splat", FabricParticleTypes.simple(true));
    public static final DefaultParticleType PINK_FALLING_INK = (DefaultParticleType)create("falling_pink_ink", FabricParticleTypes.simple(true));

    public static final DefaultParticleType PURPLE_INK_SPLAT = (DefaultParticleType)create("purple_ink_splat", FabricParticleTypes.simple(true));
    public static final DefaultParticleType PURPLE_FALLING_INK = (DefaultParticleType)create("falling_purple_ink", FabricParticleTypes.simple(true));

    public static final DefaultParticleType YELLOW_INK_SPLAT = (DefaultParticleType)create("yellow_ink_splat", FabricParticleTypes.simple(true));
    public static final DefaultParticleType YELLOW_FALLING_INK = (DefaultParticleType)create("falling_yellow_ink", FabricParticleTypes.simple(true));

    //Octoling
    public static final DefaultParticleType BLACK_INK_SPLAT = (DefaultParticleType)create("black_ink_splat", FabricParticleTypes.simple(true));
    public static final DefaultParticleType BLACK_FALLING_INK = (DefaultParticleType)create("falling_black_ink", FabricParticleTypes.simple(true));

    public static final DefaultParticleType BROWN_INK_SPLAT = (DefaultParticleType)create("brown_ink_splat", FabricParticleTypes.simple(true));
    public static final DefaultParticleType BROWN_FALLING_INK = (DefaultParticleType)create("falling_brown_ink", FabricParticleTypes.simple(true));

    public static final DefaultParticleType GRAY_INK_SPLAT = (DefaultParticleType)create("gray_ink_splat", FabricParticleTypes.simple(true));
    public static final DefaultParticleType GRAY_FALLING_INK = (DefaultParticleType)create("falling_gray_ink", FabricParticleTypes.simple(true));

    public static final DefaultParticleType LIGHT_BLUE_INK_SPLAT = (DefaultParticleType)create("light_blue_ink_splat", FabricParticleTypes.simple(true));
    public static final DefaultParticleType LIGHT_BLUE_FALLING_INK = (DefaultParticleType)create("falling_light_blue_ink", FabricParticleTypes.simple(true));

    public static final DefaultParticleType LIGHT_GRAY_INK_SPLAT = (DefaultParticleType)create("light_gray_ink_splat", FabricParticleTypes.simple(true));
    public static final DefaultParticleType LIGHT_GRAY_FALLING_INK = (DefaultParticleType)create("falling_light_gray_ink", FabricParticleTypes.simple(true));

    public static final DefaultParticleType MAGENTA_INK_SPLAT = (DefaultParticleType)create("magenta_ink_splat", FabricParticleTypes.simple(true));
    public static final DefaultParticleType MAGENTA_FALLING_INK = (DefaultParticleType)create("falling_magenta_ink", FabricParticleTypes.simple(true));

    public static final DefaultParticleType RED_INK_SPLAT = (DefaultParticleType)create("red_ink_splat", FabricParticleTypes.simple(true));
    public static final DefaultParticleType RED_FALLING_INK = (DefaultParticleType)create("falling_red_ink", FabricParticleTypes.simple(true));

    public static final DefaultParticleType WHITE_INK_SPLAT = (DefaultParticleType)create("white_ink_splat", FabricParticleTypes.simple(true));
    public static final DefaultParticleType WHITE_FALLING_INK = (DefaultParticleType)create("falling_white_ink", FabricParticleTypes.simple(true));

    public SplatterParticles() {
    }

    public static void init() {
        PARTICLES.keySet().forEach((particle) -> {
            Registry.register(Registries.PARTICLE_TYPE, (Identifier)PARTICLES.get(particle), particle);
        });
    }

    private static <T extends ParticleType<?>> T create(String name, T particle) {
        PARTICLES.put(particle, Splatter.id(name));
        return particle;
    }
}