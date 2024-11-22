package dev.prangellplays.splatter.init;

import dev.prangellplays.splatter.Splatter;
import dev.prangellplays.splatter.block.ink.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

public class SplatterBlocks {
    protected static final Map<Block, Identifier> BLOCKS = new LinkedHashMap();
    public static final Block BLACK_INK;
    public static final Block BLUE_INK;
    public static final Block BROWN_INK;
    public static final Block CYAN_INK;
    public static final Block GRAY_INK;
    public static final Block GREEN_INK;
    public static final Block LIGHT_BLUE_INK;
    public static final Block LIGHT_GRAY_INK;
    public static final Block LIME_INK;
    public static final Block MAGENTA_INK;
    public static final Block ORANGE_INK;
    public static final Block PINK_INK;
    public static final Block PURPLE_INK;
    public static final Block RED_INK;
    public static final Block WHITE_INK;
    public static final Block YELLOW_INK;

    public SplatterBlocks() {
    }

    protected static <T extends Block> T create(String name, T block) {
        BLOCKS.put(block, Splatter.id(name));
        return block;
    }

    protected static <T extends Block> T createWithItem(String name, T block) {
        return createWithItem(name, block, new FabricItemSettings());
    }

    protected static <T extends Block> T createWithItem(String name, T block, FabricItemSettings settings) {
        return createWithItem(name, block, (b) -> {
            return new BlockItem(b, settings);
        });
    }

    protected static <T extends Block> T createWithItem(String name, T block, Function<T, BlockItem> itemGenerator) {
        SplatterItems.create(name, (BlockItem)itemGenerator.apply(block));
        return create(name, block);
    }

    public static void init() {
        BLOCKS.forEach((block, id) -> {
            Registry.register(Registries.BLOCK, id, block);
        });
    }

    static {
        BLACK_INK = createWithItem("black_ink", new BlackInkBlock(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(0.5F).velocityMultiplier(0.8F).sounds(BlockSoundGroup.HONEY)), (FabricItemSettings)(new FabricItemSettings()));
        BLUE_INK = createWithItem("blue_ink", new BlueInkBlock(AbstractBlock.Settings.create().mapColor(MapColor.BLUE).strength(0.5F).velocityMultiplier(0.8F).sounds(BlockSoundGroup.HONEY)), (FabricItemSettings)(new FabricItemSettings()));
        BROWN_INK = createWithItem("brown_ink", new BrownInkBlock(AbstractBlock.Settings.create().mapColor(MapColor.BROWN).strength(0.5F).velocityMultiplier(0.8F).sounds(BlockSoundGroup.HONEY)), (FabricItemSettings)(new FabricItemSettings()));
        CYAN_INK = createWithItem("cyan_ink", new CyanInkBlock(AbstractBlock.Settings.create().mapColor(MapColor.CYAN).strength(0.5F).velocityMultiplier(0.8F).sounds(BlockSoundGroup.HONEY)), (FabricItemSettings)(new FabricItemSettings()));
        GRAY_INK = createWithItem("gray_ink", new GrayInkBlock(AbstractBlock.Settings.create().mapColor(MapColor.GRAY).strength(0.5F).velocityMultiplier(0.8F).sounds(BlockSoundGroup.HONEY)), (FabricItemSettings)(new FabricItemSettings()));
        GREEN_INK = createWithItem("green_ink", new GreenInkBlock(AbstractBlock.Settings.create().mapColor(MapColor.GREEN).strength(0.5F).velocityMultiplier(0.8F).sounds(BlockSoundGroup.HONEY)), (FabricItemSettings)(new FabricItemSettings()));
        LIGHT_BLUE_INK = createWithItem("light_blue_ink", new LightBlueInkBlock(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(0.5F).velocityMultiplier(0.8F).sounds(BlockSoundGroup.HONEY)), (FabricItemSettings)(new FabricItemSettings()));
        LIGHT_GRAY_INK = createWithItem("light_gray_ink", new LightGrayInkBlock(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_GRAY).strength(0.5F).velocityMultiplier(0.8F).sounds(BlockSoundGroup.HONEY)), (FabricItemSettings)(new FabricItemSettings()));
        LIME_INK = createWithItem("lime_ink", new LimeInkBlock(AbstractBlock.Settings.create().mapColor(MapColor.LIME).strength(0.5F).velocityMultiplier(0.8F).sounds(BlockSoundGroup.HONEY)), (FabricItemSettings)(new FabricItemSettings()));
        MAGENTA_INK = createWithItem("magenta_ink", new MagentaInkBlock(AbstractBlock.Settings.create().mapColor(MapColor.MAGENTA).strength(0.5F).velocityMultiplier(0.8F).sounds(BlockSoundGroup.HONEY)), (FabricItemSettings)(new FabricItemSettings()));
        ORANGE_INK = createWithItem("orange_ink", new OrangeInkBlock(AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).strength(0.5F).velocityMultiplier(0.8F).sounds(BlockSoundGroup.HONEY)), (FabricItemSettings)(new FabricItemSettings()));
        PINK_INK = createWithItem("pink_ink", new PinkInkBlock(AbstractBlock.Settings.create().mapColor(MapColor.PINK).strength(0.5F).velocityMultiplier(0.8F).sounds(BlockSoundGroup.HONEY)), (FabricItemSettings)(new FabricItemSettings()));
        PURPLE_INK = createWithItem("purple_ink", new PurpleInkBlock(AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).strength(0.5F).velocityMultiplier(0.8F).sounds(BlockSoundGroup.HONEY)), (FabricItemSettings)(new FabricItemSettings()));
        RED_INK = createWithItem("red_ink", new RedInkBlock(AbstractBlock.Settings.create().mapColor(MapColor.RED).strength(0.5F).velocityMultiplier(0.8F).sounds(BlockSoundGroup.HONEY)), (FabricItemSettings)(new FabricItemSettings()));
        WHITE_INK = createWithItem("white_ink", new WhiteInkBlock(AbstractBlock.Settings.create().mapColor(MapColor.WHITE).strength(0.5F).velocityMultiplier(0.8F).sounds(BlockSoundGroup.HONEY)), (FabricItemSettings)(new FabricItemSettings()));
        YELLOW_INK = createWithItem("yellow_ink", new YellowInkBlock(AbstractBlock.Settings.create().mapColor(MapColor.YELLOW).strength(0.5F).velocityMultiplier(0.8F).sounds(BlockSoundGroup.HONEY)), (FabricItemSettings)(new FabricItemSettings()));
    }
}