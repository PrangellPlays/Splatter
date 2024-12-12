package dev.prangellplays.splatter.components.inkling;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.CommonTickingComponent;
import dev.prangellplays.splatter.Splatter;
import dev.prangellplays.splatter.SplatterConfig;
import dev.prangellplays.splatter.command.SplatterCommand;
import dev.prangellplays.splatter.init.SplatterComponents;
import dev.prangellplays.splatter.init.SplatterParticles;
import dev.prangellplays.splatter.init.SplatterStatusEffects;
import dev.prangellplays.splatter.packet.EntityAndPosPacket;
import dev.prangellplays.splatter.attribute.StepHeightEntityAttribute;
import dev.prangellplays.splatter.world.BlueInksplosion;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.EntityPose;
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
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.UUID;

public class PlayerBlueInklingComponent implements AutoSyncedComponent, CommonTickingComponent {
    public static final Identifier INKSKIN_TEXTURE = Splatter.id("textures/entity/inkskin/blue_inkling_base.png");
    private static final EntityAttributeModifier STEP_HEIGHT_MODIFIER;
    public static final int MAX_LAUNCH_TICKS = 100;
    private final PlayerEntity player;
    private boolean diving;
    private int divingTicks;
    private int outOfInkTimer;
    private int lastDiveX = 0;
    private int lastDiveY = 0;
    private int lastDiveZ = 0;
    private int launchTicks = 0;
    private boolean inkling = false;

    public PlayerBlueInklingComponent(PlayerEntity player) {
        this.player = player;
    }

    private void sync() {
        SplatterComponents.BLUE_INKLING.sync(this.player);
    }

    public boolean isInkling() {
        return this.inkling;
    }

    private void correctInkling() {
        boolean shouldBeInkling = this.player.hasStatusEffect(SplatterStatusEffects.BLUE_INKSKIN);
        if (this.inkling != shouldBeInkling) {
            this.inkling = shouldBeInkling;
            this.sync();
        }

    }

    public boolean isDiving() {
        return this.isInkling() && this.diving;
    }

    public void setDiving(boolean diving) {
        if (diving) {
            this.player.setPos(this.player.getX(), (double)Math.round(this.player.getY()) + 0.1, this.player.getZ());
        }

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
                boolean isSplash = Splatter.isCollidingWithBlueInk(this.player);
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
        this.player.setPose(EntityPose.CROUCHING);
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
            boolean collidingWithBlueInk = Splatter.isCollidingWithBlueInk(this.player);
            if (this.isDiving()) {
                if (!collidingWithBlueInk && this.player.isOnGround()) {
                    this.player.getWorld().addParticle(SplatterParticles.BLUE_INK_SPLAT, this.player.getParticleX(0.3), this.player.getY() + 0.009999999776482582, this.player.getParticleZ(0.3), (double)((this.player.getWorld().random.nextFloat() - 0.5F) * 0.3F), (double)(this.player.getWorld().random.nextFloat() * 0.3F), (double)((this.player.getWorld().random.nextFloat() - 0.5F) * 0.3F));
                }
            } else if (!collidingWithBlueInk && !this.player.isTouchingWater() && this.player.isOnGround()) {
                this.player.getWorld().addParticle(SplatterParticles.BLUE_FALLING_INK, this.player.getParticleX(0.3), this.player.getY() + 0.009999999776482582, this.player.getParticleZ(0.3), 0.0, 0.0, 0.0);
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
                if ((double)(this.player.getSteppingPos().getY() + 1) > this.player.getY() && this.player.getBlockStateAtPos().getCameraCollisionShape(this.player.getWorld(), this.player.getBlockPos(), ShapeContext.of(this.player)).equals(VoxelShapes.fullCube())) {
                    this.player.teleport(this.player.getX(), this.player.getY() + 0.10000000149011612, this.player.getZ());
                }

                this.player.getHungerManager().setSaturationLevel(20.0F);
                if (this.isMovingWhileDiving()) {
                    BlueInksplosion inksplosion = new BlueInksplosion(this.player.getWorld(), this.player, this.player.getX(), this.player.getY(), this.player.getZ(), SplatterCommand.getInkSpreadPower());
                    inksplosion.tick();
                    this.lastDiveX = this.player.getBlockX();
                    this.lastDiveY = this.player.getBlockY();
                    this.lastDiveZ = this.player.getBlockZ();
                }

                if (Splatter.isCollidingWithBlueInk(this.player)) {
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
                    ServerPlayNetworking.send(serverPlayerEntity, EntityAndPosPacket.REMOVE_INKSKIN_ID, buf);
                }
            }
        }

    }

    static {
        STEP_HEIGHT_MODIFIER = new EntityAttributeModifier(UUID.fromString("3f1829ef-bd95-4e03-83a2-f568ba3286bd"), "Inkskin step height", 3.0, EntityAttributeModifier.Operation.ADDITION);
    }
}