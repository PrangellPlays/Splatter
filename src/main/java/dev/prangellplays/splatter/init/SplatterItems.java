package dev.prangellplays.splatter.init;

import dev.prangellplays.splatter.Splatter;
import dev.prangellplays.splatter.item.inktotem.InkTotemBlackItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public class SplatterItems {
    protected static final Map<Item, Identifier> ITEMS = new LinkedHashMap();
    public static final Item INK_TOTEM_BLACK;

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
        INK_TOTEM_BLACK = create("ink_totem_black", (Item) (new InkTotemBlackItem(new FabricItemSettings().maxCount(1))));
    }
}