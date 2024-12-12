package dev.prangellplays.splatter.init;

import dev.prangellplays.splatter.Splatter;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SplatterItemGroups {
    public static final ItemGroup ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Splatter.MOD_ID, "splatter_items"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.splatter.splatter_items")).icon(() -> new ItemStack(SplatterBlocks.BLACK_INK)).entries((displayContext, entries) -> {
                entries.add(SplatterBlocks.BLACK_INK);
                entries.add(SplatterBlocks.BLUE_INK);
                entries.add(SplatterBlocks.BROWN_INK);
                entries.add(SplatterBlocks.CYAN_INK);
                entries.add(SplatterBlocks.GRAY_INK);
                entries.add(SplatterBlocks.GREEN_INK);
                entries.add(SplatterBlocks.LIGHT_BLUE_INK);
                entries.add(SplatterBlocks.LIGHT_GRAY_INK);
                entries.add(SplatterBlocks.LIME_INK);
                entries.add(SplatterBlocks.MAGENTA_INK);
                entries.add(SplatterBlocks.ORANGE_INK);
                entries.add(SplatterBlocks.PINK_INK);
                entries.add(SplatterBlocks.PURPLE_INK);
                entries.add(SplatterBlocks.RED_INK);
                entries.add(SplatterBlocks.WHITE_INK);
                entries.add(SplatterBlocks.YELLOW_INK);
                entries.add(SplatterItems.INK_TOTEM_BLACK);
            }).build());

    public static void init() {
    }
}
