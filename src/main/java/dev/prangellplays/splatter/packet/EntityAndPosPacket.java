package dev.prangellplays.splatter.packet;

import dev.prangellplays.splatter.Splatter;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class EntityAndPosPacket implements Packet<ClientPlayPacketListener> {
    public static final Identifier DIVE_SPLASH_ID = Splatter.id("inkling_dive_splash");
    public static final Identifier DIVE_INKSPLOSION_ID = Splatter.id("inkling_dive_inksplosion");
    public static final Identifier REMOVE_INKMORPHOSIS_ID = Splatter.id("remove_inkmorphosis");
    private final int id;
    private final double x;
    private final double y;
    private final double z;

    public EntityAndPosPacket(Entity entity) {
        this.id = entity.getId();
        this.x = entity.getX();
        this.y = entity.getY();
        this.z = entity.getZ();
    }

    public EntityAndPosPacket(PacketByteBuf buf) {
        this.id = buf.readInt();
        this.x = buf.readDouble();
        this.y = buf.readDouble();
        this.z = buf.readDouble();
    }

    public void write(PacketByteBuf buf) {
        buf.writeInt(this.id);
        buf.writeDouble(this.x);
        buf.writeDouble(this.y);
        buf.writeDouble(this.z);
    }

    public void apply(ClientPlayPacketListener clientPlayPacketListener) {
    }

    public @Nullable Entity getEntity(World world) {
        return world.getEntityById(this.id);
    }

    public Vec3d getPos() {
        return new Vec3d(this.x, this.y, this.z);
    }
}