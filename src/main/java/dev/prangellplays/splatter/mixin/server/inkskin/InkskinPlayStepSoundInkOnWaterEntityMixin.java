package dev.prangellplays.splatter.mixin.server.inkskin;

import dev.prangellplays.splatter.components.octoling.PlayerBlackOctolingComponent;
import dev.prangellplays.splatter.init.SplatterComponents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({Entity.class})
public abstract class InkskinPlayStepSoundInkOnWaterEntityMixin {
    @Shadow
    public World world;

    public InkskinPlayStepSoundInkOnWaterEntityMixin() {
    }

    @Shadow
    public abstract void playSound(SoundEvent var1, float var2, float var3);

    @Shadow @Nullable public abstract LivingEntity getControllingPassenger();

    @Inject(
            method = {"playStepSound"},
            at = {@At("HEAD")}
    )
    protected void splatter$playSoundsForInkskinsOnInkedWater(BlockPos pos, BlockState state, CallbackInfo ci) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(player)).isOctoling() && !state.getFluidState().isEmpty()) {
                BlockState blockState = this.world.getBlockState(pos.up());
                BlockSoundGroup blockSoundGroup = blockState.isIn(BlockTags.INSIDE_STEP_SOUND_BLOCKS) ? blockState.getSoundGroup() : state.getSoundGroup();
                this.playSound(blockSoundGroup.getStepSound(), blockSoundGroup.getVolume() * 0.15F, blockSoundGroup.getPitch());
            }
        }
    }
}