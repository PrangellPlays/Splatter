package dev.prangellplays.splatter.particle.ink;

import dev.prangellplays.splatter.init.SplatterParticles;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.fluid.FluidState;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class LightGrayFallingInkParticle extends SpriteBillboardParticle {
    public LightGrayFallingInkParticle(ClientWorld clientWorld, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        super(clientWorld, x, y, z, velocityX, velocityY, velocityZ);
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;
        this.gravityStrength = 1.0F;
        this.scale *= 0.75F;
        this.maxAge = this.random.nextBetweenExclusive(80, 120);
        this.angle = (float)this.random.nextBetweenExclusive(0, 3) * 1.5707964F;
        this.prevAngle = this.angle;
    }

    public void tick() {
        super.tick();
        if (!this.dead && (this.onGround || this.isInFluid())) {
            this.markDead();
            this.world.addParticle(SplatterParticles.LIGHT_GRAY_INK_SPLAT, (double)((float)this.x), (double)((float)this.y + 0.01F), (double)((float)this.z), 0.0, 0.0, 0.0);
        }
    }

    protected boolean isInFluid() {
        BlockPos pos = new BlockPos((int) this.x, (int) this.y, (int) this.z);
        FluidState fluidState = this.world.getFluidState(pos);
        if (fluidState.isEmpty()) {
            return false;
        } else {
            return this.y < (double)((float)pos.getY() + fluidState.getHeight(this.world, pos));
        }
    }

    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        public @Nullable Particle createParticle(DefaultParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            LightGrayFallingInkParticle particle = new LightGrayFallingInkParticle(world, x, y, z, velocityX, velocityY, velocityZ);
            particle.setSprite(this.spriteProvider);
            return particle;
        }
    }
}