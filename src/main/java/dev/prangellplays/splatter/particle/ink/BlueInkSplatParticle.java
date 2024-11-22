package dev.prangellplays.splatter.particle.ink;

import dev.prangellplays.splatter.Splatter;
import dev.prangellplays.splatter.particle.HorizontalSpriteParticle;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class BlueInkSplatParticle extends HorizontalSpriteParticle {
    public BlueInkSplatParticle(ClientWorld clientWorld, double x, double y, double z) {
        super(clientWorld, x, y, z, 0.0, 0.0, 0.0);
        this.maxAge = this.random.nextBetweenExclusive(100, 200);
        this.angle = (float)this.random.nextBetweenExclusive(0, 3) * 1.5707964F;
        this.scale = 0.25F;
        this.setVelocity(0.0, 0.0, 0.0);
    }

    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        if (this.age++ >= this.maxAge) {
            if ((this.alpha -= 0.01F) <= 0.0F) {
                this.markDead();
            }
        } else {
            this.velocityY -= 0.04 * (double)this.gravityStrength;
            this.move(this.velocityX, this.velocityY, this.velocityZ);
            if (this.ascending && this.y == this.prevPosY) {
                this.velocityX *= 1.1;
                this.velocityZ *= 1.1;
            }

            this.velocityX *= (double)this.velocityMultiplier;
            this.velocityY *= (double)this.velocityMultiplier;
            this.velocityZ *= (double)this.velocityMultiplier;
            if (this.onGround) {
                this.velocityX *= 0.699999988079071;
                this.velocityZ *= 0.699999988079071;
            }
        }

        BlockState state = this.world.getBlockState(new BlockPos((int) this.x, (int) (this.y - 1.0), (int) this.z));
        if (FallingBlock.canFallThrough(state) || Splatter.isABlueInkFacingDown(state)) {
            this.markDead();
        }

    }

    public void buildGeometry(VertexConsumer vertexConsumer, Camera camera, float tickDelta) {
        super.buildGeometry(vertexConsumer, camera, tickDelta);
    }

    public float getSize(float tickDelta) {
        return super.getSize(tickDelta) * MathHelper.clamp(12.0F * this.getAgeProgress(tickDelta), 0.0F, 1.0F);
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
            BlueInkSplatParticle particle = new BlueInkSplatParticle(world, x, y, z);
            particle.setSprite(this.spriteProvider);
            return particle;
        }
    }
}