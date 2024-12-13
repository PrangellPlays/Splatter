package dev.prangellplays.splatter.init;

import dev.prangellplays.splatter.Splatter;
import dev.prangellplays.splatter.item.InkSpongeItem;
import dev.prangellplays.splatter.item.inktotem.*;
import dev.prangellplays.splatter.item.splattershot.SplattershotBlackItem;
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
    public static final Item INK_TOTEM_BLUE;
    public static final Item INK_TOTEM_BROWN;
    public static final Item INK_TOTEM_CYAN;
    public static final Item INK_TOTEM_GRAY;
    public static final Item INK_TOTEM_GREEN;
    public static final Item INK_TOTEM_LIGHT_BLUE;
    public static final Item INK_TOTEM_LIGHT_GRAY;
    public static final Item INK_TOTEM_LIME;
    public static final Item INK_TOTEM_MAGENTA;
    public static final Item INK_TOTEM_ORANGE;
    public static final Item INK_TOTEM_PINK;
    public static final Item INK_TOTEM_PURPLE;
    public static final Item INK_TOTEM_RED;
    public static final Item INK_TOTEM_WHITE;
    public static final Item INK_TOTEM_YELLOW;

    public static final Item SPLATTERSHOT_BLACK;

    public static final Item INK_SPONGE;

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
        INK_TOTEM_BLUE = create("ink_totem_blue", (Item) (new InkTotemBlueItem(new FabricItemSettings().maxCount(1))));
        INK_TOTEM_BROWN = create("ink_totem_brown", (Item) (new InkTotemBrownItem(new FabricItemSettings().maxCount(1))));
        INK_TOTEM_CYAN = create("ink_totem_cyan", (Item) (new InkTotemCyanItem(new FabricItemSettings().maxCount(1))));
        INK_TOTEM_GRAY = create("ink_totem_gray", (Item) (new InkTotemGrayItem(new FabricItemSettings().maxCount(1))));
        INK_TOTEM_GREEN = create("ink_totem_green", (Item) (new InkTotemGreenItem(new FabricItemSettings().maxCount(1))));
        INK_TOTEM_LIGHT_BLUE = create("ink_totem_light_blue", (Item) (new InkTotemLightBlueItem(new FabricItemSettings().maxCount(1))));
        INK_TOTEM_LIGHT_GRAY = create("ink_totem_light_gray", (Item) (new InkTotemLightGrayItem(new FabricItemSettings().maxCount(1))));
        INK_TOTEM_LIME = create("ink_totem_lime", (Item) (new InkTotemLimeItem(new FabricItemSettings().maxCount(1))));
        INK_TOTEM_MAGENTA = create("ink_totem_magenta", (Item) (new InkTotemMagentaItem(new FabricItemSettings().maxCount(1))));
        INK_TOTEM_ORANGE = create("ink_totem_orange", (Item) (new InkTotemOrangeItem(new FabricItemSettings().maxCount(1))));
        INK_TOTEM_PINK = create("ink_totem_pink", (Item) (new InkTotemPinkItem(new FabricItemSettings().maxCount(1))));
        INK_TOTEM_PURPLE = create("ink_totem_purple", (Item) (new InkTotemPurpleItem(new FabricItemSettings().maxCount(1))));
        INK_TOTEM_RED = create("ink_totem_red", (Item) (new InkTotemRedItem(new FabricItemSettings().maxCount(1))));
        INK_TOTEM_WHITE = create("ink_totem_white", (Item) (new InkTotemWhiteItem(new FabricItemSettings().maxCount(1))));
        INK_TOTEM_YELLOW = create("ink_totem_yellow", (Item) (new InkTotemYellowItem(new FabricItemSettings().maxCount(1))));

        SPLATTERSHOT_BLACK = create("splattershot_black",(Item) (new SplattershotBlackItem(new FabricItemSettings().maxCount(1).fireproof())));

        INK_SPONGE = create("ink_sponge",(Item) (new InkSpongeItem(new FabricItemSettings().maxCount(1))));
    }
}