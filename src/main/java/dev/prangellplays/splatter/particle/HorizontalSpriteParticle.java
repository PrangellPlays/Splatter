package dev.prangellplays.splatter.particle;

import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import java.util.function.Consumer;

public abstract class HorizontalSpriteParticle extends SpriteBillboardParticle {
    public boolean emissive = false;

    public HorizontalSpriteParticle(ClientWorld clientWorld, double x, double y, double z) {
        super(clientWorld, x, y, z);
    }

    public HorizontalSpriteParticle(ClientWorld clientWorld, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        super(clientWorld, x, y, z, velocityX, velocityY, velocityZ);
    }

    public HorizontalSpriteParticle(ClientWorld clientWorld, double x, double y, double z, double velocityX, double velocityY, double velocityZ, boolean emissive) {
        super(clientWorld, x, y, z, velocityX, velocityY, velocityZ);
        this.emissive = emissive;
    }

    public final float getAgeProgress(float tickDelta) {
        return ((float)this.age + tickDelta) / (float)this.maxAge;
    }

    public float getAngle() {
        return this.angle;
    }

    public void buildGeometry(VertexConsumer vertexConsumer, Camera camera, float tickDelta) {
        float angle = this.getAngle();
        this.buildGeometry(vertexConsumer, camera, tickDelta, (quaternion) -> {
            quaternion.rotateY(angle);
            quaternion.rotateX(-1.5707964F);
        });
        this.buildGeometry(vertexConsumer, camera, tickDelta, (quaternion) -> {
            quaternion.rotateY(-3.1415927F + angle);
            quaternion.rotateX(1.5707964F);
        });
    }

    private void buildGeometry(VertexConsumer vertexConsumer, Camera camera, float tickDelta, Consumer<Quaternionf> rotator) {
        Vec3d vec3d = camera.getPos();
        float lerpedX = (float)(MathHelper.lerp((double)tickDelta, this.prevPosX, this.x) - vec3d.getX());
        float lerpedY = (float)(MathHelper.lerp((double)tickDelta, this.prevPosY, this.y) - vec3d.getY());
        float lerpedZ = (float)(MathHelper.lerp((double)tickDelta, this.prevPosZ, this.z) - vec3d.getZ());
        Quaternionf quaternion = new Quaternionf();
        rotator.accept(quaternion);
        Vector3f[] vec3fs = new Vector3f[]{new Vector3f(-1.0F, -1.0F, 0.0F), new Vector3f(-1.0F, 1.0F, 0.0F), new Vector3f(1.0F, 1.0F, 0.0F), new Vector3f(1.0F, -1.0F, 0.0F)};
        this.getSize(tickDelta);

        int brightness;
        for(brightness = 0; brightness < 4; ++brightness) {
            Vector3f vec3f = vec3fs[brightness];
            vec3f.rotate(quaternion);
            vec3f.mul(0.25F);
            vec3f.add(lerpedX, lerpedY, lerpedZ);
        }

        brightness = this.emissive ? 240 : this.getBrightness(tickDelta);
        this.vertex(vertexConsumer, vec3fs[0], this.getMaxU(), this.getMaxV(), brightness);
        this.vertex(vertexConsumer, vec3fs[1], this.getMaxU(), this.getMinV(), brightness);
        this.vertex(vertexConsumer, vec3fs[2], this.getMinU(), this.getMinV(), brightness);
        this.vertex(vertexConsumer, vec3fs[3], this.getMinU(), this.getMaxV(), brightness);
    }

    private void vertex(VertexConsumer vertexConsumer, Vector3f pos, float u, float v, int light) {
        vertexConsumer.vertex((double)pos.x(), (double)pos.y(), (double)pos.z()).texture(u, v).color(this.red, this.green, this.blue, this.alpha).light(light).next();
    }
}