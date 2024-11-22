package dev.prangellplays.splatter;

import dev.prangellplays.splatter.block.ink.*;
import dev.prangellplays.splatter.init.*;
import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ModInitializer;

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

	public static boolean isCollidingWithBlueInkStrict(Entity entity) {
		BlockState bs = entity.getBlockStateAtPos();
		return bs.isOf(SplatterBlocks.BLUE_INK) && (Boolean)bs.get(BlueInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05;
	}
	public static boolean isCollidingWithCyanInkStrict(Entity entity) {
		BlockState bs = entity.getBlockStateAtPos();
		return bs.isOf(SplatterBlocks.CYAN_INK) && (Boolean)bs.get(CyanInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05;
	}
	public static boolean isCollidingWithGreenInkStrict(Entity entity) {
		BlockState bs = entity.getBlockStateAtPos();
		return bs.isOf(SplatterBlocks.GREEN_INK) && (Boolean)bs.get(GreenInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05;
	}
	public static boolean isCollidingWithLimeInkStrict(Entity entity) {
		BlockState bs = entity.getBlockStateAtPos();
		return bs.isOf(SplatterBlocks.LIME_INK) && (Boolean)bs.get(LimeInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05;
	}
	public static boolean isCollidingWithOrangeInkStrict(Entity entity) {
		BlockState bs = entity.getBlockStateAtPos();
		return bs.isOf(SplatterBlocks.ORANGE_INK) && (Boolean)bs.get(OrangeInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05;
	}
	public static boolean isCollidingWithPinkInkStrict(Entity entity) {
		BlockState bs = entity.getBlockStateAtPos();
		return bs.isOf(SplatterBlocks.PINK_INK) && (Boolean)bs.get(PinkInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05;
	}
	public static boolean isCollidingWithPurpleInkStrict(Entity entity) {
		BlockState bs = entity.getBlockStateAtPos();
		return bs.isOf(SplatterBlocks.PURPLE_INK) && (Boolean)bs.get(PurpleInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05;
	}
	public static boolean isCollidingWithYellowInkStrict(Entity entity) {
		BlockState bs = entity.getBlockStateAtPos();
		return bs.isOf(SplatterBlocks.YELLOW_INK) && (Boolean)bs.get(YellowInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05;
	}
	public static boolean isCollidingWithBlackInkStrict(Entity entity) {
		BlockState bs = entity.getBlockStateAtPos();
		return bs.isOf(SplatterBlocks.BLACK_INK) && (Boolean)bs.get(BlackInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05;
	}
	public static boolean isCollidingWithBrownInkStrict(Entity entity) {
		BlockState bs = entity.getBlockStateAtPos();
		return bs.isOf(SplatterBlocks.BROWN_INK) && (Boolean)bs.get(BrownInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05;
	}
	public static boolean isCollidingWithGrayInkStrict(Entity entity) {
		BlockState bs = entity.getBlockStateAtPos();
		return bs.isOf(SplatterBlocks.GRAY_INK) && (Boolean)bs.get(GrayInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05;
	}
	public static boolean isCollidingWithLightBlueInkStrict(Entity entity) {
		BlockState bs = entity.getBlockStateAtPos();
		return bs.isOf(SplatterBlocks.LIGHT_BLUE_INK) && (Boolean)bs.get(LightBlueInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05;
	}
	public static boolean isCollidingWithLightGrayInkStrict(Entity entity) {
		BlockState bs = entity.getBlockStateAtPos();
		return bs.isOf(SplatterBlocks.LIGHT_GRAY_INK) && (Boolean)bs.get(LightGrayInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05;
	}
	public static boolean isCollidingWithMagentaInkStrict(Entity entity) {
		BlockState bs = entity.getBlockStateAtPos();
		return bs.isOf(SplatterBlocks.MAGENTA_INK) && (Boolean)bs.get(MagentaInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05;
	}
	public static boolean isCollidingWithRedInkStrict(Entity entity) {
		BlockState bs = entity.getBlockStateAtPos();
		return bs.isOf(SplatterBlocks.RED_INK) && (Boolean)bs.get(RedInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05;
	}
	public static boolean isCollidingWithWhiteInkStrict(Entity entity) {
		BlockState bs = entity.getBlockStateAtPos();
		return bs.isOf(SplatterBlocks.WHITE_INK) && (Boolean)bs.get(WhiteInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05;
	}

	public static boolean isCollidingWithBlueInk(Entity entity) {
		if (isCollidingWithBlueInkStrict(entity)) {
			return true;
		} else {
			BlockPos.Mutable mutable = entity.getBlockPos().mutableCopy();

			for(int x = entity.getBlockX() - 1; x <= entity.getBlockX() + 1; ++x) {
				for(int z = entity.getBlockZ() - 1; z <= entity.getBlockZ() + 1; ++z) {
					if (x != entity.getBlockX() || z != entity.getBlockY()) {
						mutable.setX(x);
						mutable.setZ(z);
						BlockState bs = entity.getWorld().getBlockState(mutable);
						if (bs.isOf(SplatterBlocks.BLUE_INK) && (Boolean)bs.get(BlueInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05) {
							return true;
						}
					}
				}
			}

			return false;
		}
	}
	public static boolean isCollidingWithCyanInk(Entity entity) {
		if (isCollidingWithCyanInkStrict(entity)) {
			return true;
		} else {
			BlockPos.Mutable mutable = entity.getBlockPos().mutableCopy();

			for(int x = entity.getBlockX() - 1; x <= entity.getBlockX() + 1; ++x) {
				for(int z = entity.getBlockZ() - 1; z <= entity.getBlockZ() + 1; ++z) {
					if (x != entity.getBlockX() || z != entity.getBlockY()) {
						mutable.setX(x);
						mutable.setZ(z);
						BlockState bs = entity.getWorld().getBlockState(mutable);
						if (bs.isOf(SplatterBlocks.CYAN_INK) && (Boolean)bs.get(CyanInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05) {
							return true;
						}
					}
				}
			}

			return false;
		}
	}
	public static boolean isCollidingWithGreenInk(Entity entity) {
		if (isCollidingWithGreenInkStrict(entity)) {
			return true;
		} else {
			BlockPos.Mutable mutable = entity.getBlockPos().mutableCopy();

			for(int x = entity.getBlockX() - 1; x <= entity.getBlockX() + 1; ++x) {
				for(int z = entity.getBlockZ() - 1; z <= entity.getBlockZ() + 1; ++z) {
					if (x != entity.getBlockX() || z != entity.getBlockY()) {
						mutable.setX(x);
						mutable.setZ(z);
						BlockState bs = entity.getWorld().getBlockState(mutable);
						if (bs.isOf(SplatterBlocks.GREEN_INK) && (Boolean)bs.get(GreenInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05) {
							return true;
						}
					}
				}
			}

			return false;
		}
	}
	public static boolean isCollidingWithLimeInk(Entity entity) {
		if (isCollidingWithLimeInkStrict(entity)) {
			return true;
		} else {
			BlockPos.Mutable mutable = entity.getBlockPos().mutableCopy();

			for(int x = entity.getBlockX() - 1; x <= entity.getBlockX() + 1; ++x) {
				for(int z = entity.getBlockZ() - 1; z <= entity.getBlockZ() + 1; ++z) {
					if (x != entity.getBlockX() || z != entity.getBlockY()) {
						mutable.setX(x);
						mutable.setZ(z);
						BlockState bs = entity.getWorld().getBlockState(mutable);
						if (bs.isOf(SplatterBlocks.LIME_INK) && (Boolean)bs.get(LimeInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05) {
							return true;
						}
					}
				}
			}

			return false;
		}
	}
	public static boolean isCollidingWithOrangeInk(Entity entity) {
		if (isCollidingWithOrangeInkStrict(entity)) {
			return true;
		} else {
			BlockPos.Mutable mutable = entity.getBlockPos().mutableCopy();

			for(int x = entity.getBlockX() - 1; x <= entity.getBlockX() + 1; ++x) {
				for(int z = entity.getBlockZ() - 1; z <= entity.getBlockZ() + 1; ++z) {
					if (x != entity.getBlockX() || z != entity.getBlockY()) {
						mutable.setX(x);
						mutable.setZ(z);
						BlockState bs = entity.getWorld().getBlockState(mutable);
						if (bs.isOf(SplatterBlocks.ORANGE_INK) && (Boolean)bs.get(OrangeInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05) {
							return true;
						}
					}
				}
			}

			return false;
		}
	}
	public static boolean isCollidingWithPinkInk(Entity entity) {
		if (isCollidingWithPinkInkStrict(entity)) {
			return true;
		} else {
			BlockPos.Mutable mutable = entity.getBlockPos().mutableCopy();

			for(int x = entity.getBlockX() - 1; x <= entity.getBlockX() + 1; ++x) {
				for(int z = entity.getBlockZ() - 1; z <= entity.getBlockZ() + 1; ++z) {
					if (x != entity.getBlockX() || z != entity.getBlockY()) {
						mutable.setX(x);
						mutable.setZ(z);
						BlockState bs = entity.getWorld().getBlockState(mutable);
						if (bs.isOf(SplatterBlocks.PINK_INK) && (Boolean)bs.get(PinkInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05) {
							return true;
						}
					}
				}
			}

			return false;
		}
	}
	public static boolean isCollidingWithPurpleInk(Entity entity) {
		if (isCollidingWithPurpleInkStrict(entity)) {
			return true;
		} else {
			BlockPos.Mutable mutable = entity.getBlockPos().mutableCopy();

			for(int x = entity.getBlockX() - 1; x <= entity.getBlockX() + 1; ++x) {
				for(int z = entity.getBlockZ() - 1; z <= entity.getBlockZ() + 1; ++z) {
					if (x != entity.getBlockX() || z != entity.getBlockY()) {
						mutable.setX(x);
						mutable.setZ(z);
						BlockState bs = entity.getWorld().getBlockState(mutable);
						if (bs.isOf(SplatterBlocks.PURPLE_INK) && (Boolean)bs.get(PurpleInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05) {
							return true;
						}
					}
				}
			}

			return false;
		}
	}
	public static boolean isCollidingWithYellowInk(Entity entity) {
		if (isCollidingWithYellowInkStrict(entity)) {
			return true;
		} else {
			BlockPos.Mutable mutable = entity.getBlockPos().mutableCopy();

			for(int x = entity.getBlockX() - 1; x <= entity.getBlockX() + 1; ++x) {
				for(int z = entity.getBlockZ() - 1; z <= entity.getBlockZ() + 1; ++z) {
					if (x != entity.getBlockX() || z != entity.getBlockY()) {
						mutable.setX(x);
						mutable.setZ(z);
						BlockState bs = entity.getWorld().getBlockState(mutable);
						if (bs.isOf(SplatterBlocks.YELLOW_INK) && (Boolean)bs.get(YellowInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05) {
							return true;
						}
					}
				}
			}

			return false;
		}
	}
	public static boolean isCollidingWithBlackInk(Entity entity) {
		if (isCollidingWithBlackInkStrict(entity)) {
			return true;
		} else {
			BlockPos.Mutable mutable = entity.getBlockPos().mutableCopy();

			for(int x = entity.getBlockX() - 1; x <= entity.getBlockX() + 1; ++x) {
				for(int z = entity.getBlockZ() - 1; z <= entity.getBlockZ() + 1; ++z) {
					if (x != entity.getBlockX() || z != entity.getBlockY()) {
						mutable.setX(x);
						mutable.setZ(z);
						BlockState bs = entity.getWorld().getBlockState(mutable);
						if (bs.isOf(SplatterBlocks.BLACK_INK) && (Boolean)bs.get(BlackInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05) {
							return true;
						}
					}
				}
			}

			return false;
		}
	}
	public static boolean isCollidingWithBrownInk(Entity entity) {
		if (isCollidingWithBrownInkStrict(entity)) {
			return true;
		} else {
			BlockPos.Mutable mutable = entity.getBlockPos().mutableCopy();

			for(int x = entity.getBlockX() - 1; x <= entity.getBlockX() + 1; ++x) {
				for(int z = entity.getBlockZ() - 1; z <= entity.getBlockZ() + 1; ++z) {
					if (x != entity.getBlockX() || z != entity.getBlockY()) {
						mutable.setX(x);
						mutable.setZ(z);
						BlockState bs = entity.getWorld().getBlockState(mutable);
						if (bs.isOf(SplatterBlocks.BROWN_INK) && (Boolean)bs.get(BrownInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05) {
							return true;
						}
					}
				}
			}

			return false;
		}
	}
	public static boolean isCollidingWithGrayInk(Entity entity) {
		if (isCollidingWithGrayInkStrict(entity)) {
			return true;
		} else {
			BlockPos.Mutable mutable = entity.getBlockPos().mutableCopy();

			for(int x = entity.getBlockX() - 1; x <= entity.getBlockX() + 1; ++x) {
				for(int z = entity.getBlockZ() - 1; z <= entity.getBlockZ() + 1; ++z) {
					if (x != entity.getBlockX() || z != entity.getBlockY()) {
						mutable.setX(x);
						mutable.setZ(z);
						BlockState bs = entity.getWorld().getBlockState(mutable);
						if (bs.isOf(SplatterBlocks.GRAY_INK) && (Boolean)bs.get(GrayInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05) {
							return true;
						}
					}
				}
			}

			return false;
		}
	}
	public static boolean isCollidingWithLightBlueInk(Entity entity) {
		if (isCollidingWithLightBlueInkStrict(entity)) {
			return true;
		} else {
			BlockPos.Mutable mutable = entity.getBlockPos().mutableCopy();

			for(int x = entity.getBlockX() - 1; x <= entity.getBlockX() + 1; ++x) {
				for(int z = entity.getBlockZ() - 1; z <= entity.getBlockZ() + 1; ++z) {
					if (x != entity.getBlockX() || z != entity.getBlockY()) {
						mutable.setX(x);
						mutable.setZ(z);
						BlockState bs = entity.getWorld().getBlockState(mutable);
						if (bs.isOf(SplatterBlocks.LIGHT_BLUE_INK) && (Boolean)bs.get(LightBlueInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05) {
							return true;
						}
					}
				}
			}

			return false;
		}
	}
	public static boolean isCollidingWithLightGrayInk(Entity entity) {
		if (isCollidingWithLightGrayInkStrict(entity)) {
			return true;
		} else {
			BlockPos.Mutable mutable = entity.getBlockPos().mutableCopy();

			for(int x = entity.getBlockX() - 1; x <= entity.getBlockX() + 1; ++x) {
				for(int z = entity.getBlockZ() - 1; z <= entity.getBlockZ() + 1; ++z) {
					if (x != entity.getBlockX() || z != entity.getBlockY()) {
						mutable.setX(x);
						mutable.setZ(z);
						BlockState bs = entity.getWorld().getBlockState(mutable);
						if (bs.isOf(SplatterBlocks.LIGHT_GRAY_INK) && (Boolean)bs.get(LightGrayInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05) {
							return true;
						}
					}
				}
			}

			return false;
		}
	}
	public static boolean isCollidingWithMagentaInk(Entity entity) {
		if (isCollidingWithMagentaInkStrict(entity)) {
			return true;
		} else {
			BlockPos.Mutable mutable = entity.getBlockPos().mutableCopy();

			for(int x = entity.getBlockX() - 1; x <= entity.getBlockX() + 1; ++x) {
				for(int z = entity.getBlockZ() - 1; z <= entity.getBlockZ() + 1; ++z) {
					if (x != entity.getBlockX() || z != entity.getBlockY()) {
						mutable.setX(x);
						mutable.setZ(z);
						BlockState bs = entity.getWorld().getBlockState(mutable);
						if (bs.isOf(SplatterBlocks.MAGENTA_INK) && (Boolean)bs.get(MagentaInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05) {
							return true;
						}
					}
				}
			}

			return false;
		}
	}
	public static boolean isCollidingWithRedInk(Entity entity) {
		if (isCollidingWithRedInkStrict(entity)) {
			return true;
		} else {
			BlockPos.Mutable mutable = entity.getBlockPos().mutableCopy();

			for(int x = entity.getBlockX() - 1; x <= entity.getBlockX() + 1; ++x) {
				for(int z = entity.getBlockZ() - 1; z <= entity.getBlockZ() + 1; ++z) {
					if (x != entity.getBlockX() || z != entity.getBlockY()) {
						mutable.setX(x);
						mutable.setZ(z);
						BlockState bs = entity.getWorld().getBlockState(mutable);
						if (bs.isOf(SplatterBlocks.RED_INK) && (Boolean)bs.get(RedInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05) {
							return true;
						}
					}
				}
			}

			return false;
		}
	}
	public static boolean isCollidingWithWhiteInk(Entity entity) {
		if (isCollidingWithWhiteInkStrict(entity)) {
			return true;
		} else {
			BlockPos.Mutable mutable = entity.getBlockPos().mutableCopy();

			for(int x = entity.getBlockX() - 1; x <= entity.getBlockX() + 1; ++x) {
				for(int z = entity.getBlockZ() - 1; z <= entity.getBlockZ() + 1; ++z) {
					if (x != entity.getBlockX() || z != entity.getBlockY()) {
						mutable.setX(x);
						mutable.setZ(z);
						BlockState bs = entity.getWorld().getBlockState(mutable);
						if (bs.isOf(SplatterBlocks.WHITE_INK) && (Boolean)bs.get(WhiteInkBlock.getProperty(Direction.DOWN)) && entity.getY() < (double)entity.getBlockY() + 0.05) {
							return true;
						}
					}
				}
			}

			return false;
		}
	}

	public static boolean isABlueInkFacingDown(World world, BlockPos pos) {
		return isABlueInkFacingDown(world.getBlockState(pos));
	}
	public static boolean isACyanInkFacingDown(World world, BlockPos pos) {
		return isACyanInkFacingDown(world.getBlockState(pos));
	}
	public static boolean isAGreenInkFacingDown(World world, BlockPos pos) {
		return isAGreenInkFacingDown(world.getBlockState(pos));
	}
	public static boolean isALimeInkFacingDown(World world, BlockPos pos) {
		return isALimeInkFacingDown(world.getBlockState(pos));
	}
	public static boolean isAnOrangeInkFacingDown(World world, BlockPos pos) {
		return isAnOrangeInkFacingDown(world.getBlockState(pos));
	}
	public static boolean isAPinkInkFacingDown(World world, BlockPos pos) {
		return isAPinkInkFacingDown(world.getBlockState(pos));
	}
	public static boolean isAPurpleInkFacingDown(World world, BlockPos pos) {
		return isAPurpleInkFacingDown(world.getBlockState(pos));
	}
	public static boolean isAYellowInkFacingDown(World world, BlockPos pos) {
		return isAYellowInkFacingDown(world.getBlockState(pos));
	}
	public static boolean isABlackInkFacingDown(World world, BlockPos pos) {
		return isABlackInkFacingDown(world.getBlockState(pos));
	}
	public static boolean isABrownInkFacingDown(World world, BlockPos pos) {
		return isABrownInkFacingDown(world.getBlockState(pos));
	}
	public static boolean isAGrayInkFacingDown(World world, BlockPos pos) {
		return isAGrayInkFacingDown(world.getBlockState(pos));
	}
	public static boolean isALightBlueInkFacingDown(World world, BlockPos pos) {
		return isALightBlueInkFacingDown(world.getBlockState(pos));
	}
	public static boolean isALightGrayInkFacingDown(World world, BlockPos pos) {
		return isALightGrayInkFacingDown(world.getBlockState(pos));
	}
	public static boolean isAMagentaInkFacingDown(World world, BlockPos pos) {
		return isAMagentaInkFacingDown(world.getBlockState(pos));
	}
	public static boolean isARedInkFacingDown(World world, BlockPos pos) {
		return isARedInkFacingDown(world.getBlockState(pos));
	}
	public static boolean isAWhiteInkFacingDown(World world, BlockPos pos) {
		return isAWhiteInkFacingDown(world.getBlockState(pos));
	}

	public static boolean isABlueInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.BLUE_INK) && (Boolean)blockState.get(BlueInkBlock.getProperty(Direction.DOWN));
	}
	public static boolean isACyanInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.CYAN_INK) && (Boolean)blockState.get(CyanInkBlock.getProperty(Direction.DOWN));
	}
	public static boolean isAGreenInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.GREEN_INK) && (Boolean)blockState.get(GreenInkBlock.getProperty(Direction.DOWN));
	}
	public static boolean isALimeInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.LIME_INK) && (Boolean)blockState.get(LimeInkBlock.getProperty(Direction.DOWN));
	}
	public static boolean isAnOrangeInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.ORANGE_INK) && (Boolean)blockState.get(OrangeInkBlock.getProperty(Direction.DOWN));
	}
	public static boolean isAPinkInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.PINK_INK) && (Boolean)blockState.get(PinkInkBlock.getProperty(Direction.DOWN));
	}
	public static boolean isAPurpleInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.PURPLE_INK) && (Boolean)blockState.get(PurpleInkBlock.getProperty(Direction.DOWN));
	}
	public static boolean isAYellowInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.YELLOW_INK) && (Boolean)blockState.get(YellowInkBlock.getProperty(Direction.DOWN));
	}
	public static boolean isABlackInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.BLACK_INK) && (Boolean)blockState.get(BlackInkBlock.getProperty(Direction.DOWN));
	}
	public static boolean isABrownInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.BROWN_INK) && (Boolean)blockState.get(BrownInkBlock.getProperty(Direction.DOWN));
	}
	public static boolean isAGrayInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.GRAY_INK) && (Boolean)blockState.get(GrayInkBlock.getProperty(Direction.DOWN));
	}
	public static boolean isALightBlueInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.LIGHT_BLUE_INK) && (Boolean)blockState.get(LightBlueInkBlock.getProperty(Direction.DOWN));
	}
	public static boolean isALightGrayInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.LIGHT_GRAY_INK) && (Boolean)blockState.get(LightGrayInkBlock.getProperty(Direction.DOWN));
	}
	public static boolean isAMagentaInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.MAGENTA_INK) && (Boolean)blockState.get(MagentaInkBlock.getProperty(Direction.DOWN));
	}
	public static boolean isARedInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.RED_INK) && (Boolean)blockState.get(RedInkBlock.getProperty(Direction.DOWN));
	}
	public static boolean isAWhiteInkFacingDown(BlockState blockState) {
		return blockState.isOf(SplatterBlocks.WHITE_INK) && (Boolean)blockState.get(WhiteInkBlock.getProperty(Direction.DOWN));
	}

	@Override
	public void onInitialize() {
		MidnightConfig.init(MOD_ID, SplatterConfig.class);
		SplatterBlocks.init();
		SplatterItems.init();
		SplatterItemGroups.init();
		SplatterStatusEffects.init();
		SplatterParticles.init();
	}

	public static Identifier id(String name) {
		return new Identifier(MOD_ID, name);
	}
}