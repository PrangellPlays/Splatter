package dev.prangellplays.splatter.init;

import dev.prangellplays.splatter.Splatter;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;

public class SplatterTags {
    public static final TagKey<Block> INK_REPLACEABLE_PLANTS = createBlock("ink_replaceable_plants");
    public static final TagKey<Block> INK = createBlock("ink");

    public SplatterTags() {
    }

    private static TagKey<Item> createItem(String id) {
        return TagKey.of(Registries.ITEM.getKey(), Splatter.id(id));
    }
    private static TagKey<Block> createBlock(String id) {
        return TagKey.of(Registries.BLOCK.getKey(), Splatter.id(id));
    }
}