package dev.prangellplays.splatter.init;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;
import dev.prangellplays.splatter.Splatter;
import dev.prangellplays.splatter.components.inkling.*;
import dev.prangellplays.splatter.components.octoling.*;

public class SplatterComponents implements EntityComponentInitializer {
    //Inkling
    public static final ComponentKey<PlayerBlueInklingComponent> BLUE_INKLING = ComponentRegistry.getOrCreate(Splatter.id("blue_inkling"), PlayerBlueInklingComponent.class);
    public static final ComponentKey<PlayerCyanInklingComponent> CYAN_INKLING = ComponentRegistry.getOrCreate(Splatter.id("cyan_inkling"), PlayerCyanInklingComponent.class);
    public static final ComponentKey<PlayerGreenInklingComponent> GREEN_INKLING = ComponentRegistry.getOrCreate(Splatter.id("green_inkling"), PlayerGreenInklingComponent.class);
    public static final ComponentKey<PlayerLimeInklingComponent> LIME_INKLING = ComponentRegistry.getOrCreate(Splatter.id("lime_inkling"), PlayerLimeInklingComponent.class);
    public static final ComponentKey<PlayerOrangeInklingComponent> ORANGE_INKLING = ComponentRegistry.getOrCreate(Splatter.id("orange_inkling"), PlayerOrangeInklingComponent.class);
    public static final ComponentKey<PlayerPinkInklingComponent> PINK_INKLING = ComponentRegistry.getOrCreate(Splatter.id("pink_inkling"), PlayerPinkInklingComponent.class);
    public static final ComponentKey<PlayerPurpleInklingComponent> PURPLE_INKLING = ComponentRegistry.getOrCreate(Splatter.id("purple_inkling"), PlayerPurpleInklingComponent.class);
    public static final ComponentKey<PlayerYellowInklingComponent> YELLOW_INKLING = ComponentRegistry.getOrCreate(Splatter.id("yellow_inkling"), PlayerYellowInklingComponent.class);

    //Octoling
    public static final ComponentKey<PlayerBlackOctolingComponent> BLACK_OCTOLING = ComponentRegistry.getOrCreate(Splatter.id("black_octoling"), PlayerBlackOctolingComponent.class);
    public static final ComponentKey<PlayerBrownOctolingComponent> BROWN_OCTOLING = ComponentRegistry.getOrCreate(Splatter.id("brown_octoling"), PlayerBrownOctolingComponent.class);
    public static final ComponentKey<PlayerGrayOctolingComponent> GRAY_OCTOLING = ComponentRegistry.getOrCreate(Splatter.id("gray_octoling"), PlayerGrayOctolingComponent.class);
    public static final ComponentKey<PlayerLightBlueOctolingComponent> LIGHT_BLUE_OCTOLING = ComponentRegistry.getOrCreate(Splatter.id("light_blue_octoling"), PlayerLightBlueOctolingComponent.class);
    public static final ComponentKey<PlayerLightGrayOctolingComponent> LIGHT_GRAY_OCTOLING = ComponentRegistry.getOrCreate(Splatter.id("light_gray_octoling"), PlayerLightGrayOctolingComponent.class);
    public static final ComponentKey<PlayerMagentaOctolingComponent> MAGENTA_OCTOLING = ComponentRegistry.getOrCreate(Splatter.id("magenta_octoling"), PlayerMagentaOctolingComponent.class);
    public static final ComponentKey<PlayerRedOctolingComponent> RED_OCTOLING = ComponentRegistry.getOrCreate(Splatter.id("red_octoling"), PlayerRedOctolingComponent.class);
    public static final ComponentKey<PlayerWhiteOctolingComponent> WHITE_OCTOLING = ComponentRegistry.getOrCreate(Splatter.id("white_octoling"), PlayerWhiteOctolingComponent.class);

    public SplatterComponents() {
    }

    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        //Inkling
        registry.registerForPlayers(BLUE_INKLING, PlayerBlueInklingComponent::new, RespawnCopyStrategy.NEVER_COPY);
        registry.registerForPlayers(CYAN_INKLING, PlayerCyanInklingComponent::new, RespawnCopyStrategy.NEVER_COPY);
        registry.registerForPlayers(GREEN_INKLING, PlayerGreenInklingComponent::new, RespawnCopyStrategy.NEVER_COPY);
        registry.registerForPlayers(LIME_INKLING, PlayerLimeInklingComponent::new, RespawnCopyStrategy.NEVER_COPY);
        registry.registerForPlayers(ORANGE_INKLING, PlayerOrangeInklingComponent::new, RespawnCopyStrategy.NEVER_COPY);
        registry.registerForPlayers(PINK_INKLING, PlayerPinkInklingComponent::new, RespawnCopyStrategy.NEVER_COPY);
        registry.registerForPlayers(PURPLE_INKLING, PlayerPurpleInklingComponent::new, RespawnCopyStrategy.NEVER_COPY);
        registry.registerForPlayers(YELLOW_INKLING, PlayerYellowInklingComponent::new, RespawnCopyStrategy.NEVER_COPY);

        //Octoling
        registry.registerForPlayers(BLACK_OCTOLING, PlayerBlackOctolingComponent::new, RespawnCopyStrategy.NEVER_COPY);
        registry.registerForPlayers(BROWN_OCTOLING, PlayerBrownOctolingComponent::new, RespawnCopyStrategy.NEVER_COPY);
        registry.registerForPlayers(GRAY_OCTOLING, PlayerGrayOctolingComponent::new, RespawnCopyStrategy.NEVER_COPY);
        registry.registerForPlayers(LIGHT_BLUE_OCTOLING, PlayerLightBlueOctolingComponent::new, RespawnCopyStrategy.NEVER_COPY);
        registry.registerForPlayers(LIGHT_GRAY_OCTOLING, PlayerLightGrayOctolingComponent::new, RespawnCopyStrategy.NEVER_COPY);
        registry.registerForPlayers(MAGENTA_OCTOLING, PlayerMagentaOctolingComponent::new, RespawnCopyStrategy.NEVER_COPY);
        registry.registerForPlayers(RED_OCTOLING, PlayerRedOctolingComponent::new, RespawnCopyStrategy.NEVER_COPY);
        registry.registerForPlayers(WHITE_OCTOLING, PlayerWhiteOctolingComponent::new, RespawnCopyStrategy.NEVER_COPY);
    }
}