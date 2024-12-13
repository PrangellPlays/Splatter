package dev.prangellplays.splatter.entity.splattershot;

import dev.prangellplays.splatter.block.ink.BlackInkBlock;
import dev.prangellplays.splatter.init.SplatterBlocks;
import dev.prangellplays.splatter.init.SplatterEntities;
import dev.prangellplays.splatter.init.SplatterParticles;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

@SuppressWarnings("all")
public class SplattershotBlackInkEntity extends ThrownEntity {
    public static final int RADIUS = 1;

    public SplattershotBlackInkEntity(EntityType<? extends SplattershotBlackInkEntity> entityType, World world) {
        super(entityType, world);
    }

    public SplattershotBlackInkEntity(World world, LivingEntity owner) {
        super(SplatterEntities.SPLATTERSHOT_BLACK_INK, owner.getX(), owner.getEyeY() - (double) 0.9f, owner.getZ(), world);
        this.setOwner(owner);
    }

    public SplattershotBlackInkEntity(World world, double x, double y, double z) {
        super(SplatterEntities.SPLATTERSHOT_BLACK_INK, x, y, z, world);
    }

    @Override
    protected void initDataTracker() {
    }

    @Override
    public boolean hasNoGravity() {
        return false;
    }

    @Override
    public boolean collidesWith(Entity other) {
        return false;
    }

    @Override
    public boolean isFireImmune() {
        return true;
    }

    @Override
    public void tick() {
        super.tick();

        this.setVelocity(this.getVelocity().multiply(0.9, 0.9, 0.9));

        if (this.isTouchingWaterOrRain() || this.isInsideWall() /*|| (this.age > 20 && this.getVelocity().getX() <= 0.1f && this.getVelocity().getY() <= 0.1f && this.getVelocity().getZ() <= 0.1f)*/) {
            this.discard();
        }

        for (int i = 0; i < Math.sqrt(this.getVelocity().getX() * this.getVelocity().getX() + this.getVelocity().getY() * this.getVelocity().getY() + this.getVelocity().getZ() * this.getVelocity().getZ()) * 5; i++) {
            getWorld().addParticle(SplatterParticles.BLACK_FALLING_INK, this.getX() + random.nextGaussian() / 5f, this.getY() + .5 + random.nextGaussian() / 5f, this.getZ() + random.nextGaussian() / 5f, 0, 0, 0);
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
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
                        float h = 1 * (0.7F + this.getWorld().random.nextFloat() * 0.6F);
                        double m = this.getX();
                        double n = this.getY();
                        double o = this.getZ();

                        for(float p = 0.3F; h > 0.0F; h -= 0.22500001F) {
                            mutable.set(m, n, o);
                            if (!this.getWorld().isInBuildLimit(mutable)) {
                                break;
                            }

                            this.affectPos(mutable);
                            m += d * 0.30000001192092896 * 3;
                            n += e * 0.30000001192092896 * 3;
                            o += f * 0.30000001192092896 * 3;
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
        BlockState blockState = this.getWorld().getBlockState(blockPos);
        Direction[] var9 = Direction.values();
        int var10 = var9.length;

        for(int var11 = 0; var11 < var10; ++var11) {
            Direction direction = var9[var11];
            blockPos.move(direction);
            if (BlackInkBlock.canGrowOn(this.getWorld(), direction.getOpposite(), blockPos, blockState) && this.getWorld().raycast(new RaycastContext(Vec3d.ofCenter(blockPos), this.getPos(), RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, this)).getBlockPos().equals(this.getBlockPos())) {
                BlockState blockStateToInk = this.getWorld().getBlockState(blockPos);
                if (BlackInkBlock.canBreak(blockStateToInk)) {
                    this.getWorld().breakBlock(blockPos, true);
                }

                if (blockStateToInk.isOf(SplatterBlocks.BLACK_INK)) {
                    this.getWorld().setBlockState(blockPos, (BlockState)blockStateToInk.with(BlackInkBlock.getProperty(direction.getOpposite()), true));
                } else if (blockStateToInk.isAir()) {
                    this.getWorld().setBlockState(blockPos, (BlockState)SplatterBlocks.BLACK_INK.getDefaultState().with(BlackInkBlock.getProperty(direction.getOpposite()), true));
                }
            }

            blockPos.set(pX, pY, pZ);
        }

    }

    @Override
    public void pushAwayFrom(Entity entity) {
    }

    @Override
    public boolean isPushable() {
        return false;
    }
}