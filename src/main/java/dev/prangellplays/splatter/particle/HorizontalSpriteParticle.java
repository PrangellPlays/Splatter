package dev.prangellplays.splatter.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import java.util.function.Consumer;

@Environment(EnvType.CLIENT)
public abstract class HorizontalSpriteParticle extends SpriteBillboardParticle {
    public HorizontalSpriteParticle(ClientWorld clientWorld, double x, double y, double z) {
        super(clientWorld, x, y, z);
    }

    public HorizontalSpriteParticle(ClientWorld clientWorld, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        super(clientWorld, x, y, z, velocityX, velocityY, velocityZ);
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
            quaternion.add(RotationAxis.POSITIVE_Y.rotationDegrees(angle));
            quaternion.add(RotationAxis.POSITIVE_X.rotationDegrees(-1.5707964F));
        });
        this.buildGeometry(vertexConsumer, camera, tickDelta, (quaternion) -> {
            quaternion.add(RotationAxis.POSITIVE_Y.rotationDegrees(-3.1415927F + angle));
            quaternion.add(RotationAxis.POSITIVE_X.rotationDegrees(1.5707964F));
        });
    }

    private void buildGeometry(VertexConsumer vertexConsumer, Camera camera, float tickDelta, Consumer<Quaternionf> rotator) {
        Vec3d vec3d = camera.getPos();
        float lerpedX = (float)(MathHelper.lerp((double)tickDelta, this.prevPosX, this.x) - vec3d.getX());
        float lerpedY = (float)(MathHelper.lerp((double)tickDelta, this.prevPosY, this.y) - vec3d.getY());
        float lerpedZ = (float)(MathHelper.lerp((double)tickDelta, this.prevPosZ, this.z) - vec3d.getZ());
        Quaternionf quaternion2;
        if (this.angle == 0.0F) {
            quaternion2 = camera.getRotation();
        } else {
            quaternion2 = new Quaternionf(camera.getRotation());
            float i = MathHelper.lerp(tickDelta, this.prevAngle, this.angle);
            quaternion2.rotateZ(i);
        }

        Vector3f vec3f = new Vector3f(-1.0F, -1.0F, 0.0F);
        vec3f.rotate(quaternion2);
        Vector3f[] Vec3fs = new Vector3f[]{new Vector3f(-1.0F, -1.0F, 0.0F), new Vector3f(-1.0F, 1.0F, 0.0F), new Vector3f(1.0F, 1.0F, 0.0F), new Vector3f(1.0F, -1.0F, 0.0F)};
        float j = this.getSize(tickDelta);

        for (int k = 0; k < 4; ++k) {
            Vector3f Vec3f2 = Vec3fs[k];
            Vec3f2.rotate(new Quaternionf().rotateXYZ((float) Math.toRadians(90f), 0f, 0f));
            Vec3f2.mul(j);
            Vec3f2.add(lerpedX, lerpedY, lerpedZ);
        }

        Vector3f[] vec3fs = new Vector3f[]{new Vector3f(-1.0F, -1.0F, 0.0F), new Vector3f(-1.0F, 1.0F, 0.0F), new Vector3f(1.0F, 1.0F, 0.0F), new Vector3f(1.0F, -1.0F, 0.0F)};
        this.getSize(tickDelta);

        int brightness;
        for(brightness = 0; brightness < 4; ++brightness) {
            Vector3f vec3f1 = vec3fs[brightness];
            vec3f.mul(0.25F);
            vec3f.add(lerpedX, lerpedY, lerpedZ);
        }

        brightness = this.getBrightness(tickDelta);
        this.vertex(vertexConsumer, vec3fs[0], this.getMaxU(), this.getMaxV(), brightness);
        this.vertex(vertexConsumer, vec3fs[1], this.getMaxU(), this.getMinV(), brightness);
        this.vertex(vertexConsumer, vec3fs[2], this.getMinU(), this.getMinV(), brightness);
        this.vertex(vertexConsumer, vec3fs[3], this.getMinU(), this.getMaxV(), brightness);
    }

    private void vertex(VertexConsumer vertexConsumer, Vector3f pos, float u, float v, int light) {
        vertexConsumer.vertex((double)pos.x(), (double)pos.y(), (double)pos.z()).texture(u, v).color(this.red, this.green, this.blue, this.alpha).light(light).next();
    }
}