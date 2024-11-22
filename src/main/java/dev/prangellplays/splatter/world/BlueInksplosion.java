package dev.prangellplays.splatter.world;

import dev.prangellplays.splatter.block.ink.BlueInkBlock;
import dev.prangellplays.splatter.init.SplatterBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BlueInksplosion {
    private final World world;
    private final Entity entity;
    private final Vec3d pos;
    private final double x;
    private final double y;
    private final double z;
    private final float power;

    public BlueInksplosion(World world, @Nullable Entity entity, double x, double y, double z, float power) {
        this.world = world;
        this.entity = entity;
        this.power = power;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pos = new Vec3d(x, y, z);
    }

    public void tick() {
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for(int j = 0; j < 16; ++j) {
            for(int k = 0; k < 16; ++k) {
                for(int l = 0; l < 16; ++l) {
                    if (j == 0 || j == 15 || k == 0 || k == 15 || l == 0 || l == 15) {
                        double d = (double)((float)j / 15.0F * 2.0F - 1.0F);
                        double e = (double)((float)k / 15.0F * 2.0F - 1.0F);
                        double f = (double)((float)l / 15.0F * 2.0F - 1.0F);
                        double g = Math.sqrt(d * d + e * e + f * f);
                        d /= g;
                        e /= g;
                        f /= g;
                        float h = this.power * (0.7F + this.world.random.nextFloat() * 0.6F);
                        double m = this.x;
                        double n = this.y;
                        double o = this.z;

                        for(float p = 0.3F; h > 0.0F; h -= 0.22500001F) {
                            mutable.set(m, n, o);
                            if (!this.world.isInBuildLimit(mutable)) {
                                break;
                            }

                            this.affectPos(mutable);
                            m += d * 0.30000001192092896;
                            n += e * 0.30000001192092896;
                            o += f * 0.30000001192092896;
                        }
                    }
                }
            }
        }

    }

    private void affectPos(BlockPos.Mutable blockPos) {
        double pX = (double)blockPos.getX();
        double pY = (double)blockPos.getY();
        double pZ = (double)blockPos.getZ();
        BlockState blockState = this.world.getBlockState(blockPos);
        Direction[] var9 = Direction.values();
        int var10 = var9.length;

        for(int var11 = 0; var11 < var10; ++var11) {
            Direction direction = var9[var11];
            blockPos.move(direction);
            if (BlueInkBlock.canGrowOn(this.world, direction.getOpposite(), blockPos, blockState) && this.world.raycast(new RaycastContext(Vec3d.ofCenter(blockPos), this.pos, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, this.entity)).getBlockPos().equals(this.entity.getBlockPos())) {
                BlockState blockStateToInk = this.world.getBlockState(blockPos);
                if (BlueInkBlock.canBreak(blockStateToInk)) {
                    this.world.breakBlock(blockPos, true);
                }

                if (blockStateToInk.isOf(SplatterBlocks.BLUE_INK)) {
                    this.world.setBlockState(blockPos, (BlockState)blockStateToInk.with(BlueInkBlock.getProperty(direction.getOpposite()), true));
                } else if (blockStateToInk.isAir()) {
                    this.world.setBlockState(blockPos, (BlockState)SplatterBlocks.BLUE_INK.getDefaultState().with(BlueInkBlock.getProperty(direction.getOpposite()), true));
                }
            }

            blockPos.set(pX, pY, pZ);
        }

    }
}