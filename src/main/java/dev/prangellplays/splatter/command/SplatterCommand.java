package dev.prangellplays.splatter.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class SplatterCommand {
    private static float INK_SPREAD_POWER = 1.0F;
    private static float INKSKIN_LAUNCH_STRENGTH = 1.0F;
    private static float INKSKIN_LAUNCH_AIR_SPEED = 1.0F;
    private static float INKSKIN_DIVE_SPEED = 1.0F;

    public SplatterCommand() {
    }

    public static float getInkSpreadPower() {
        return INK_SPREAD_POWER;
    }

    public static float getInkskinLaunchStrength() {
        return INKSKIN_LAUNCH_STRENGTH;
    }

    public static float getInkskinLaunchAirSpeed() {
        return INKSKIN_LAUNCH_AIR_SPEED;
    }

    public static float getInkskinDiveSpeed() {
        return INKSKIN_DIVE_SPEED;
    }

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)CommandManager.literal("splatter").requires((source) -> {
            return source.hasPermissionLevel(2);
        })).then(CommandManager.literal("inkSpreadPower").then(CommandManager.argument("power", FloatArgumentType.floatArg(0.0F, 1000000.0F)).executes((context) -> {
            return setInkSpreadPower((ServerCommandSource)context.getSource(), FloatArgumentType.getFloat(context, "power"));
        })))).then(CommandManager.literal("inkskinLaunchStrength").then(CommandManager.argument("strength", FloatArgumentType.floatArg(0.0F, 1000000.0F)).executes((context) -> {
            return setInklingLaunchStrength((ServerCommandSource)context.getSource(), FloatArgumentType.getFloat(context, "strength"));
        })))).then(CommandManager.literal("inkskinLaunchAirSpeed").then(CommandManager.argument("speed", FloatArgumentType.floatArg(0.0F, 1000000.0F)).executes((context) -> {
            return setInklingLaunchAirSpeed((ServerCommandSource)context.getSource(), FloatArgumentType.getFloat(context, "speed"));
        })))).then(CommandManager.literal("inkskinDiveSpeed").then(CommandManager.argument("speed", FloatArgumentType.floatArg(0.0F, 1000000.0F)).executes((context) -> {
            return setInklinkDiveSpeed((ServerCommandSource)context.getSource(), FloatArgumentType.getFloat(context, "speed"));
        }))));
    }

    private static int setInkSpreadPower(ServerCommandSource source, float power) {
        INK_SPREAD_POWER = power;
        return 1;
    }

    public static int setInklingLaunchStrength(ServerCommandSource source, float strength) {
        INKSKIN_LAUNCH_STRENGTH = strength;
        return 1;
    }

    public static int setInklingLaunchAirSpeed(ServerCommandSource source, float strength) {
        INKSKIN_LAUNCH_AIR_SPEED = strength;
        return 1;
    }

    private static int setInklinkDiveSpeed(ServerCommandSource source, float speed) {
        INKSKIN_DIVE_SPEED = speed;
        return 1;
    }
}
