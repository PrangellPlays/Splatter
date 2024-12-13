package dev.prangellplays.splatter.init;

import dev.prangellplays.splatter.Splatter;
import dev.prangellplays.splatter.entity.splattershot.SplattershotBlackInkEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public interface SplatterEntities {
    Map<EntityType<? extends Entity>, Identifier> ENTITIES = new LinkedHashMap();
    EntityType<SplattershotBlackInkEntity> SPLATTERSHOT_BLACK_INK = Registry.register(Registries.ENTITY_TYPE, Splatter.id("splattershot_black_ink"), FabricEntityTypeBuilder.<SplattershotBlackInkEntity>create(SpawnGroup.MISC, SplattershotBlackInkEntity::new).dimensions(EntityDimensions.changing(1.0f, 1.0f)).build());

    private static <T extends EntityType<? extends Entity>> T createEntity(String name, T entity) {
        ENTITIES.put(entity, new Identifier("splatter", name));
        return entity;
    }

    static void init() {
        ENTITIES.keySet().forEach((entityType) -> {
            Registry.register(Registries.ENTITY_TYPE, (Identifier) ENTITIES.get(entityType), entityType);
        });
    }
}