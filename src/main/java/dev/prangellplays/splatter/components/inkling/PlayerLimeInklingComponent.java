package dev.prangellplays.splatter.components.inkling;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.CommonTickingComponent;
import dev.prangellplays.splatter.Splatter;
import dev.prangellplays.splatter.SplatterConfig;
import dev.prangellplays.splatter.init.SplatterComponents;
import dev.prangellplays.splatter.init.SplatterParticles;
import dev.prangellplays.splatter.init.SplatterStatusEffects;
import dev.prangellplays.splatter.packet.EntityAndPosPacket;
import dev.prangellplays.splatter.attribute.StepHeightEntityAttribute;
import dev.prangellplays.splatter.world.LimeInksplosion;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.UUID;

public class PlayerLimeInklingComponent implements AutoSyncedComponent, CommonTickingComponent {
    public static final Identifier INKLING_TEXTURE = Splatter.id("textures/entity/inkling/lime_inkling_base.png");
    private static final EntityAttributeModifier STEP_HEIGHT_MODIFIER;
    public static final int MAX_LAUNCH_TICKS = 100;
    private final PlayerEntity player;
    private Type inklingType;
    private boolean diving;
    private int divingTicks;
    private int outOfInkTimer;
    private int lastDiveX;
    private int lastDiveY;
    private int lastDiveZ;
    private int launchTicks;
    private boolean inkling;

    public PlayerLimeInklingComponent(PlayerEntity player) {
        this.inklingType = Type.DEFAULT;
        this.lastDiveX = 0;
        this.lastDiveY = 0;
        this.lastDiveZ = 0;
        this.launchTicks = 0;
        this.inkling = false;
        this.player = player;
    }

    private void sync() {
        SplatterComponents.LIME_INKLING.sync(this.player);
    }

    public boolean isInkling() {
        return this.inkling;
    }

    private void correctInkling() {
        boolean shouldBeInkling = this.player.hasStatusEffect(SplatterStatusEffects.LIME_INKSKIN);
        if (this.inkling != shouldBeInkling) {
            this.inkling = shouldBeInkling;
            this.sync();
        }

    }

    public Type getInklingType() {
        if (this.inklingType == null || this.player.getGameProfile() != null) {
            Type[] var1 = Type.values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                Type inklingType = var1[var3];
                if (inklingType.uuid != null && inklingType.uuid.equals(this.player.getUuid())) {
                    this.setInklingType(inklingType);
                    return this.inklingType;
                }
            }
        }

        return this.inklingType != null ? this.inklingType : Type.DEFAULT;
    }

    public void setInklingType(Type inklingType) {
        this.inklingType = inklingType;
        this.sync();
    }

    public boolean isDiving() {
        return this.isInkling() && this.diving;
    }

    public void setDiving(boolean diving) {
        this.setOutOfInkTimer(0);
        this.diving = diving;
        this.player.calculateDimensions();
        EntityAttributeInstance stepHeightAttribute = this.player.getAttributeInstance(StepHeightEntityAttribute.STEP_HEIGHT);
        if (diving) {
            if (!stepHeightAttribute.hasModifier(STEP_HEIGHT_MODIFIER)) {
                stepHeightAttribute.addPersistentModifier(STEP_HEIGHT_MODIFIER);
            }
        } else if (stepHeightAttribute.hasModifier(STEP_HEIGHT_MODIFIER)) {
            stepHeightAttribute.removeModifier(STEP_HEIGHT_MODIFIER);
        }

        World var4 = this.player.getWorld();
        if (var4 instanceof ServerWorld serverWorld) {
            Iterator var9 = serverWorld.getPlayers().iterator();

            while(var9.hasNext()) {
                ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)var9.next();
                boolean isSplash = Splatter.isCollidingWithLimeInk(this.player);
                Packet<ClientPlayPacketListener> packet = new EntityAndPosPacket(this.player);
                PacketByteBuf buf = PacketByteBufs.create();
                packet.write(buf);
                ServerPlayNetworking.send(serverPlayerEntity, isSplash ? EntityAndPosPacket.DIVE_SPLASH_ID : EntityAndPosPacket.DIVE_INKSPLOSION_ID, buf);
            }
        }

        this.sync();
    }

    public int getDivingTicks() {
        return this.divingTicks;
    }

    public void setDivingTicks(int divingTicks) {
        this.divingTicks = divingTicks;
        this.sync();
    }

    public int getDivingTicksAnimationLength() {
        return 3;
    }

    public int getOutOfInkTimer() {
        return this.outOfInkTimer;
    }

    public void setOutOfInkTimer(int outOfInkTimer) {
        this.outOfInkTimer = outOfInkTimer;
    }

    public int getLaunchTicks() {
        return this.launchTicks;
    }

    public void setLaunchTicks(int launchTicks) {
        this.launchTicks = launchTicks;
        this.sync();
    }

    public void switchDiveState() {
        if (this.isDiving()) {
            this.rise();
        } else {
            this.dive();
        }

    }

    public void dive() {
        this.setDiving(true);
        this.setDivingTicks(this.getDivingTicksAnimationLength());
    }

    public void rise() {
        this.setDiving(false);
        this.setDivingTicks(this.getDivingTicksAnimationLength());
    }

    public void launch() {
        this.rise();
        this.setLaunchTicks(100);
    }

    public void readFromNbt(NbtCompound nbt) {
        this.diving = nbt.getBoolean("Diving");
        this.divingTicks = nbt.getInt("DivingTicks");
        this.launchTicks = nbt.getInt("LaunchTicks");
        this.inkling = nbt.getBoolean("Inkling");
    }

    public void writeToNbt(NbtCompound nbt) {
        nbt.putBoolean("Diving", this.diving);
        nbt.putInt("DivingTicks", this.divingTicks);
        nbt.putInt("LaunchTicks", this.launchTicks);
        nbt.putBoolean("Inkling", this.inkling);
    }

    public void tick() {
        if (this.divingTicks > 0) {
            --this.divingTicks;
        }

        if (this.launchTicks > 0) {
            --this.launchTicks;
        }

    }

    public void clientTick() {
        this.tick();
        if (this.isInkling()) {
            boolean collidingWithFuneralInk = Splatter.isCollidingWithLimeInk(this.player);
            boolean collidingWithFuneralStrict = Splatter.isCollidingWithLimeInkStrict(this.player);
            if (SplatterConfig.inkParticles) {
                if (this.isDiving()) {
                    if (!collidingWithFuneralInk && this.player.isOnGround()) {
                        this.player.getWorld().addParticle(SplatterParticles.LIME_INK_SPLAT, (double) ((float) this.player.getX()), (double) ((float) this.player.getY() + 0.01F), (double) ((float) this.player.getZ()), 0.0, 0.0, 0.0);
                    }
                } else if (!collidingWithFuneralStrict && !this.player.isTouchingWater() && this.player.isOnGround()) {
                    this.player.getWorld().addParticle(SplatterParticles.LIME_FALLING_INK, this.player.getParticleX(0.3), this.player.getY() + 0.009999999776482582, this.player.getParticleZ(0.3), 0.0, 0.0, 0.0);
                }
            }
        }
    }

    public void serverTick() {
        this.tick();
        this.correctInkling();
        if (this.isInkling()) {
            this.player.getHungerManager().setFoodLevel(20);
            if (this.isDiving()) {
                this.player.setFireTicks(0);
                this.player.getHungerManager().setSaturationLevel(20.0F);
                if (this.isMovingWhileDiving()) {
                    LimeInksplosion inksplosion = new LimeInksplosion(this.player.getWorld(), this.player, this.player.getX(), this.player.getY(), this.player.getZ(), 1.0F);
                    inksplosion.tick();
                    this.lastDiveX = this.player.getBlockX();
                    this.lastDiveY = this.player.getBlockY();
                    this.lastDiveZ = this.player.getBlockZ();
                }

                if (Splatter.isCollidingWithLimeInk(this.player)) {
                    this.setOutOfInkTimer(0);
                    this.player.setOnGround(true);
                } else if (this.outOfInkTimer++ > 20) {
                    this.rise();
                }
            } else {
                this.player.getHungerManager().setSaturationLevel(0.0F);
            }
        }

    }

    private boolean isMovingWhileDiving() {
        return this.isDiving() && (this.lastDiveX != this.player.getBlockX() || this.lastDiveY != this.player.getBlockY() || this.lastDiveZ != this.player.getBlockZ());
    }

    public void resetPlayer() {
        if (this.isDiving()) {
            this.rise();
        } else {
            World var2 = this.player.getWorld();
            if (var2 instanceof ServerWorld) {
                ServerWorld serverWorld = (ServerWorld)var2;
                Iterator var6 = serverWorld.getPlayers().iterator();

                while(var6.hasNext()) {
                    ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)var6.next();
                    Packet<ClientPlayPacketListener> packet = new EntityAndPosPacket(this.player);
                    PacketByteBuf buf = PacketByteBufs.create();
                    packet.write(buf);
                    ServerPlayNetworking.send(serverPlayerEntity, EntityAndPosPacket.REMOVE_INKMORPHOSIS_ID, buf);
                }
            }
        }

    }

    static {
        STEP_HEIGHT_MODIFIER = new EntityAttributeModifier(UUID.fromString("3f1829ef-bd95-4e03-83a2-f568ba3286bd"), "Inkling step height", 3.0, EntityAttributeModifier.Operation.ADDITION);
    }

    public enum Type {
        DEFAULT("default", false, (String)null, "textures/entity/inkling/lime_inkling_crown_base");

        public final String name;
        public final @Nullable UUID uuid;
        public final Identifier crownTexture;
        public final Identifier emissiveCrownTexture;
        public final boolean slim;

        private Type(@Nullable String name, boolean slim, String uuid, String crownTexture) {
            this.name = name;
            this.slim = slim;
            this.uuid = uuid != null ? UUID.fromString(uuid) : null;
            this.crownTexture = Splatter.id(crownTexture + ".png");
            this.emissiveCrownTexture = Splatter.id(crownTexture + "_emissive.png");
        }

        public static @Nullable Type fromString(String name) {
            Type[] var1 = values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                Type type = var1[var3];
                if (type.name.equals(name)) {
                    return type;
                }
            }

            return null;
        }
    }
}