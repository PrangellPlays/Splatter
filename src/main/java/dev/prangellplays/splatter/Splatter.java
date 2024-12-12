package dev.prangellplays.splatter;

import dev.prangellplays.splatter.block.ink.*;
import dev.prangellplays.splatter.command.SplatterCommand;
import dev.prangellplays.splatter.components.inkling.*;
import dev.prangellplays.splatter.components.octoling.*;
import dev.prangellplays.splatter.init.*;
import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Splatter implements ModInitializer {
	public static final String MOD_ID = "splatter";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final Identifier SERVERBOUND_DIVE_PACKET = id("inkskin_dive");
	public static final Identifier SERVERBOUND_LAUNCH_PACKET = id("inkskin_launch");

	//Black Ink
	public static boolean isCollidingWithBlackInk(Entity entity) {
		return entity.getWorld().getBlockState(entity.getSteppingPos().up()).isOf(SplatterBlocks.BLACK_INK) || entity.getSteppingBlockState().isOf(SplatterBlocks.BLACK_INK);
	}

	public static boolean isABlackInkFacingDown(World world, BlockPos pos) {
		return isABlackInkFacingDown(world.getBlockState(pos));
	}

	public static boolean isABlackInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.BLACK_INK) && (Boolean)blockState.get(BlackInkBlock.getProperty(Direction.DOWN));
	}

	//Blue Ink
	public static boolean isCollidingWithBlueInk(Entity entity) {
		return entity.getWorld().getBlockState(entity.getSteppingPos().up()).isOf(SplatterBlocks.BLUE_INK) || entity.getSteppingBlockState().isOf(SplatterBlocks.BLUE_INK);
	}

	public static boolean isABlueInkFacingDown(World world, BlockPos pos) {
		return isABlueInkFacingDown(world.getBlockState(pos));
	}

	public static boolean isABlueInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.BLUE_INK) && (Boolean)blockState.get(BlueInkBlock.getProperty(Direction.DOWN));
	}

	//Brown Ink
	public static boolean isCollidingWithBrownInk(Entity entity) {
		return entity.getWorld().getBlockState(entity.getSteppingPos().up()).isOf(SplatterBlocks.BROWN_INK) || entity.getSteppingBlockState().isOf(SplatterBlocks.BROWN_INK);
	}

	public static boolean isABrownInkFacingDown(World world, BlockPos pos) {
		return isABrownInkFacingDown(world.getBlockState(pos));
	}

	public static boolean isABrownInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.BROWN_INK) && (Boolean)blockState.get(BrownInkBlock.getProperty(Direction.DOWN));
	}

	//Cyan Ink
	public static boolean isCollidingWithCyanInk(Entity entity) {
		return entity.getWorld().getBlockState(entity.getSteppingPos().up()).isOf(SplatterBlocks.CYAN_INK) || entity.getSteppingBlockState().isOf(SplatterBlocks.CYAN_INK);
	}

	public static boolean isACyanInkFacingDown(World world, BlockPos pos) {
		return isACyanInkFacingDown(world.getBlockState(pos));
	}

	public static boolean isACyanInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.CYAN_INK) && (Boolean)blockState.get(CyanInkBlock.getProperty(Direction.DOWN));
	}

	//Gray Ink
	public static boolean isCollidingWithGrayInk(Entity entity) {
		return entity.getWorld().getBlockState(entity.getSteppingPos().up()).isOf(SplatterBlocks.GRAY_INK) || entity.getSteppingBlockState().isOf(SplatterBlocks.GRAY_INK);
	}

	public static boolean isAGrayInkFacingDown(World world, BlockPos pos) {
		return isAGrayInkFacingDown(world.getBlockState(pos));
	}

	public static boolean isAGrayInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.GRAY_INK) && (Boolean)blockState.get(GrayInkBlock.getProperty(Direction.DOWN));
	}

	//Green Ink
	public static boolean isCollidingWithGreenInk(Entity entity) {
		return entity.getWorld().getBlockState(entity.getSteppingPos().up()).isOf(SplatterBlocks.GREEN_INK) || entity.getSteppingBlockState().isOf(SplatterBlocks.GREEN_INK);
	}

	public static boolean isAGreenInkFacingDown(World world, BlockPos pos) {
		return isAGreenInkFacingDown(world.getBlockState(pos));
	}

	public static boolean isAGreenInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.GREEN_INK) && (Boolean)blockState.get(GreenInkBlock.getProperty(Direction.DOWN));
	}

	//Light Blue Ink
	public static boolean isCollidingWithLightBlueInk(Entity entity) {
		return entity.getWorld().getBlockState(entity.getSteppingPos().up()).isOf(SplatterBlocks.LIGHT_BLUE_INK) || entity.getSteppingBlockState().isOf(SplatterBlocks.LIGHT_BLUE_INK);
	}

	public static boolean isALightBlueInkFacingDown(World world, BlockPos pos) {
		return isALightBlueInkFacingDown(world.getBlockState(pos));
	}

	public static boolean isALightBlueInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.LIGHT_BLUE_INK) && (Boolean)blockState.get(LightBlueInkBlock.getProperty(Direction.DOWN));
	}

	//Light Gray Ink
	public static boolean isCollidingWithLightGrayInk(Entity entity) {
		return entity.getWorld().getBlockState(entity.getSteppingPos().up()).isOf(SplatterBlocks.LIGHT_GRAY_INK) || entity.getSteppingBlockState().isOf(SplatterBlocks.LIGHT_GRAY_INK);
	}

	public static boolean isALightGrayInkFacingDown(World world, BlockPos pos) {
		return isALightGrayInkFacingDown(world.getBlockState(pos));
	}

	public static boolean isALightGrayInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.LIGHT_GRAY_INK) && (Boolean)blockState.get(LightGrayInkBlock.getProperty(Direction.DOWN));
	}

	//Lime Ink
	public static boolean isCollidingWithLimeInk(Entity entity) {
		return entity.getWorld().getBlockState(entity.getSteppingPos().up()).isOf(SplatterBlocks.LIME_INK) || entity.getSteppingBlockState().isOf(SplatterBlocks.LIME_INK);
	}

	public static boolean isALimeInkFacingDown(World world, BlockPos pos) {
		return isALimeInkFacingDown(world.getBlockState(pos));
	}

	public static boolean isALimeInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.LIME_INK) && (Boolean)blockState.get(LimeInkBlock.getProperty(Direction.DOWN));
	}

	//Magenta Ink
	public static boolean isCollidingWithMagentaInk(Entity entity) {
		return entity.getWorld().getBlockState(entity.getSteppingPos().up()).isOf(SplatterBlocks.MAGENTA_INK) || entity.getSteppingBlockState().isOf(SplatterBlocks.MAGENTA_INK);
	}

	public static boolean isAMagentaInkFacingDown(World world, BlockPos pos) {
		return isAMagentaInkFacingDown(world.getBlockState(pos));
	}

	public static boolean isAMagentaInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.MAGENTA_INK) && (Boolean)blockState.get(MagentaInkBlock.getProperty(Direction.DOWN));
	}

	//Orange Ink
	public static boolean isCollidingWithOrangeInk(Entity entity) {
		return entity.getWorld().getBlockState(entity.getSteppingPos().up()).isOf(SplatterBlocks.ORANGE_INK) || entity.getSteppingBlockState().isOf(SplatterBlocks.ORANGE_INK);
	}

	public static boolean isAOrangeInkFacingDown(World world, BlockPos pos) {
		return isAOrangeInkFacingDown(world.getBlockState(pos));
	}

	public static boolean isAOrangeInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.ORANGE_INK) && (Boolean)blockState.get(OrangeInkBlock.getProperty(Direction.DOWN));
	}

	//Pink Ink
	public static boolean isCollidingWithPinkInk(Entity entity) {
		return entity.getWorld().getBlockState(entity.getSteppingPos().up()).isOf(SplatterBlocks.PINK_INK) || entity.getSteppingBlockState().isOf(SplatterBlocks.PINK_INK);
	}

	public static boolean isAPinkInkFacingDown(World world, BlockPos pos) {
		return isAPinkInkFacingDown(world.getBlockState(pos));
	}

	public static boolean isAPinkInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.PINK_INK) && (Boolean)blockState.get(PinkInkBlock.getProperty(Direction.DOWN));
	}

	//Purple Ink
	public static boolean isCollidingWithPurpleInk(Entity entity) {
		return entity.getWorld().getBlockState(entity.getSteppingPos().up()).isOf(SplatterBlocks.PURPLE_INK) || entity.getSteppingBlockState().isOf(SplatterBlocks.PURPLE_INK);
	}

	public static boolean isAPurpleInkFacingDown(World world, BlockPos pos) {
		return isAPurpleInkFacingDown(world.getBlockState(pos));
	}

	public static boolean isAPurpleInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.PURPLE_INK) && (Boolean)blockState.get(PurpleInkBlock.getProperty(Direction.DOWN));
	}

	//Red Ink
	public static boolean isCollidingWithRedInk(Entity entity) {
		return entity.getWorld().getBlockState(entity.getSteppingPos().up()).isOf(SplatterBlocks.RED_INK) || entity.getSteppingBlockState().isOf(SplatterBlocks.RED_INK);
	}

	public static boolean isARedInkFacingDown(World world, BlockPos pos) {
		return isARedInkFacingDown(world.getBlockState(pos));
	}

	public static boolean isARedInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.RED_INK) && (Boolean)blockState.get(RedInkBlock.getProperty(Direction.DOWN));
	}

	//White Ink
	public static boolean isCollidingWithWhiteInk(Entity entity) {
		return entity.getWorld().getBlockState(entity.getSteppingPos().up()).isOf(SplatterBlocks.WHITE_INK) || entity.getSteppingBlockState().isOf(SplatterBlocks.WHITE_INK);
	}

	public static boolean isAWhiteInkFacingDown(World world, BlockPos pos) {
		return isAWhiteInkFacingDown(world.getBlockState(pos));
	}

	public static boolean isAWhiteInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.WHITE_INK) && (Boolean)blockState.get(WhiteInkBlock.getProperty(Direction.DOWN));
	}

	//Yellow Ink
	public static boolean isCollidingWithYellowInk(Entity entity) {
		return entity.getWorld().getBlockState(entity.getSteppingPos().up()).isOf(SplatterBlocks.YELLOW_INK) || entity.getSteppingBlockState().isOf(SplatterBlocks.YELLOW_INK);
	}

	public static boolean isAYellowInkFacingDown(World world, BlockPos pos) {
		return isAYellowInkFacingDown(world.getBlockState(pos));
	}

	public static boolean isAYellowInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.YELLOW_INK) && (Boolean)blockState.get(YellowInkBlock.getProperty(Direction.DOWN));
	}

	@Override
	public void onInitialize() {
		MidnightConfig.init(MOD_ID, SplatterConfig.class);
		SplatterBlocks.init();
		SplatterItems.init();
		SplatterItemGroups.init();
		SplatterStatusEffects.init();
		SplatterParticles.init();
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			SplatterCommand.register(dispatcher);
		});

		ServerPlayNetworking.registerGlobalReceiver(SERVERBOUND_DIVE_PACKET, (server, player, handler, buf, responseSender) -> {
			server.execute(() -> {
				PlayerBlackOctolingComponent blackComponent = (PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(player);
				if (blackComponent.isOctoling()) {
					blackComponent.switchDiveState();
				}

				PlayerBlueInklingComponent blueComponent = (PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(player);
				if (blueComponent.isInkling()) {
					blueComponent.switchDiveState();
				}

				PlayerBrownOctolingComponent BrownComponent = (PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(player);
				if (BrownComponent.isOctoling()) {
					BrownComponent.switchDiveState();
				}

				PlayerCyanInklingComponent cyanComponent = (PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(player);
				if (cyanComponent.isInkling()) {
					cyanComponent.switchDiveState();
				}

				PlayerGrayOctolingComponent grayComponent = (PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(player);
				if (grayComponent.isOctoling()) {
					grayComponent.switchDiveState();
				}

				PlayerGreenInklingComponent greenComponent = (PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(player);
				if (greenComponent.isInkling()) {
					greenComponent.switchDiveState();
				}

				PlayerLightBlueOctolingComponent lightblueComponent = (PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(player);
				if (lightblueComponent.isOctoling()) {
					lightblueComponent.switchDiveState();
				}

				PlayerLightGrayOctolingComponent lightgrayComponent = (PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(player);
				if (lightgrayComponent.isOctoling()) {
					lightgrayComponent.switchDiveState();
				}

				PlayerLimeInklingComponent limeComponent = (PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(player);
				if (limeComponent.isInkling()) {
					limeComponent.switchDiveState();
				}

				PlayerMagentaOctolingComponent magentaComponent = (PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(player);
				if (magentaComponent.isOctoling()) {
					magentaComponent.switchDiveState();
				}

				PlayerOrangeInklingComponent orangeComponent = (PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(player);
				if (orangeComponent.isInkling()) {
					orangeComponent.switchDiveState();
				}

				PlayerPinkInklingComponent pinkComponent = (PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(player);
				if (pinkComponent.isInkling()) {
					pinkComponent.switchDiveState();
				}

				PlayerPurpleInklingComponent purpleComponent = (PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(player);
				if (purpleComponent.isInkling()) {
					purpleComponent.switchDiveState();
				}

				PlayerRedOctolingComponent redComponent = (PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(player);
				if (redComponent.isOctoling()) {
					redComponent.switchDiveState();
				}

				PlayerWhiteOctolingComponent whiteComponent = (PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(player);
				if (whiteComponent.isOctoling()) {
					whiteComponent.switchDiveState();
				}

				PlayerYellowInklingComponent yellowComponent = (PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(player);
				if (yellowComponent.isInkling()) {
					yellowComponent.switchDiveState();
				}
			});
		});
		ServerPlayNetworking.registerGlobalReceiver(SERVERBOUND_LAUNCH_PACKET, (server, player, handler, buf, responseSender) -> {
			float yvel = buf.readFloat();
			server.execute(() -> {
				PlayerBlackOctolingComponent blackComponent = (PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(player);
				if (blackComponent.isOctoling()) {
					blackComponent.launch();
					player.setVelocity(0.0, (double)(yvel * SplatterCommand.getInkskinLaunchStrength()), 0.0);
					player.velocityDirty = true;
					player.velocityModified = true;
				}

				PlayerBlueInklingComponent blueComponent = (PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(player);
				if (blueComponent.isInkling()) {
					blueComponent.launch();
					player.setVelocity(0.0, (double)(yvel * SplatterCommand.getInkskinLaunchStrength()), 0.0);
					player.velocityDirty = true;
					player.velocityModified = true;
				}

				PlayerBrownOctolingComponent BrownComponent = (PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(player);
				if (BrownComponent.isOctoling()) {
					BrownComponent.launch();
					player.setVelocity(0.0, (double)(yvel * SplatterCommand.getInkskinLaunchStrength()), 0.0);
					player.velocityDirty = true;
					player.velocityModified = true;
				}

				PlayerCyanInklingComponent cyanComponent = (PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(player);
				if (cyanComponent.isInkling()) {
					cyanComponent.launch();
					player.setVelocity(0.0, (double)(yvel * SplatterCommand.getInkskinLaunchStrength()), 0.0);
					player.velocityDirty = true;
					player.velocityModified = true;
				}

				PlayerGrayOctolingComponent grayComponent = (PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(player);
				if (grayComponent.isOctoling()) {
					grayComponent.launch();
					player.setVelocity(0.0, (double)(yvel * SplatterCommand.getInkskinLaunchStrength()), 0.0);
					player.velocityDirty = true;
					player.velocityModified = true;
				}

				PlayerGreenInklingComponent greenComponent = (PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(player);
				if (greenComponent.isInkling()) {
					greenComponent.launch();
					player.setVelocity(0.0, (double)(yvel * SplatterCommand.getInkskinLaunchStrength()), 0.0);
					player.velocityDirty = true;
					player.velocityModified = true;
				}

				PlayerLightBlueOctolingComponent lightblueComponent = (PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(player);
				if (lightblueComponent.isOctoling()) {
					lightblueComponent.launch();
					player.setVelocity(0.0, (double)(yvel * SplatterCommand.getInkskinLaunchStrength()), 0.0);
					player.velocityDirty = true;
					player.velocityModified = true;
				}

				PlayerLightGrayOctolingComponent lightgrayComponent = (PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(player);
				if (lightgrayComponent.isOctoling()) {
					lightgrayComponent.launch();
					player.setVelocity(0.0, (double)(yvel * SplatterCommand.getInkskinLaunchStrength()), 0.0);
					player.velocityDirty = true;
					player.velocityModified = true;
				}

				PlayerLimeInklingComponent limeComponent = (PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(player);
				if (limeComponent.isInkling()) {
					limeComponent.launch();
					player.setVelocity(0.0, (double)(yvel * SplatterCommand.getInkskinLaunchStrength()), 0.0);
					player.velocityDirty = true;
					player.velocityModified = true;
				}

				PlayerMagentaOctolingComponent magentaComponent = (PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(player);
				if (magentaComponent.isOctoling()) {
					magentaComponent.launch();
					player.setVelocity(0.0, (double)(yvel * SplatterCommand.getInkskinLaunchStrength()), 0.0);
					player.velocityDirty = true;
					player.velocityModified = true;
				}

				PlayerOrangeInklingComponent orangeComponent = (PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(player);
				if (orangeComponent.isInkling()) {
					orangeComponent.launch();
					player.setVelocity(0.0, (double)(yvel * SplatterCommand.getInkskinLaunchStrength()), 0.0);
					player.velocityDirty = true;
					player.velocityModified = true;
				}

				PlayerPinkInklingComponent pinkComponent = (PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(player);
				if (pinkComponent.isInkling()) {
					pinkComponent.launch();
					player.setVelocity(0.0, (double)(yvel * SplatterCommand.getInkskinLaunchStrength()), 0.0);
					player.velocityDirty = true;
					player.velocityModified = true;
				}

				PlayerPurpleInklingComponent purpleComponent = (PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(player);
				if (purpleComponent.isInkling()) {
					purpleComponent.launch();
					player.setVelocity(0.0, (double)(yvel * SplatterCommand.getInkskinLaunchStrength()), 0.0);
					player.velocityDirty = true;
					player.velocityModified = true;
				}

				PlayerRedOctolingComponent redComponent = (PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(player);
				if (redComponent.isOctoling()) {
					redComponent.launch();
					player.setVelocity(0.0, (double)(yvel * SplatterCommand.getInkskinLaunchStrength()), 0.0);
					player.velocityDirty = true;
					player.velocityModified = true;
				}

				PlayerWhiteOctolingComponent whiteComponent = (PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(player);
				if (whiteComponent.isOctoling()) {
					whiteComponent.launch();
					player.setVelocity(0.0, (double)(yvel * SplatterCommand.getInkskinLaunchStrength()), 0.0);
					player.velocityDirty = true;
					player.velocityModified = true;
				}

				PlayerYellowInklingComponent yellowComponent = (PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(player);
				if (yellowComponent.isInkling()) {
					yellowComponent.launch();
					player.setVelocity(0.0, (double)(yvel * SplatterCommand.getInkskinLaunchStrength()), 0.0);
					player.velocityDirty = true;
					player.velocityModified = true;
				}
			});
		});
	}

	public static Identifier id(String name) {
		return new Identifier(MOD_ID, name);
	}
}