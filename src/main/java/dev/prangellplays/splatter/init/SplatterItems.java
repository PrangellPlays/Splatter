package dev.prangellplays.splatter.init;

import dev.prangellplays.splatter.Splatter;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public class SplatterItems {
    protected static final Map<Item, Identifier> ITEMS = new LinkedHashMap();

    public SplatterItems() {
    }

    protected static <T extends Item> T create(String name, T item) {
        ITEMS.put(item, Splatter.id(name));
        return item;
    }

    public static void init() {
        ITEMS.forEach((item, id) -> {
            Registry.register(Registries.ITEM, id, item);
        });
    }

    static {

    }
}