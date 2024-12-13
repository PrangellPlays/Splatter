package dev.prangellplays.splatter.mixin.server.inkskin;

import dev.prangellplays.splatter.components.inkling.*;
import dev.prangellplays.splatter.components.octoling.*;
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
    protected void splatter$playSoundsForBlackInkskinsOnInkedWater(BlockPos pos, BlockState state, CallbackInfo ci) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerBlackOctolingComponent) SplatterComponents.BLACK_OCTOLING.get(player)).isOctoling() && !state.getFluidState().isEmpty()) {
                BlockState blockState = this.world.getBlockState(pos.up());
                BlockSoundGroup blockSoundGroup = blockState.isIn(BlockTags.INSIDE_STEP_SOUND_BLOCKS) ? blockState.getSoundGroup() : state.getSoundGroup();
                this.playSound(blockSoundGroup.getStepSound(), blockSoundGroup.getVolume() * 0.15F, blockSoundGroup.getPitch());
            }
        }
    }

    @Inject(
            method = {"playStepSound"},
            at = {@At("HEAD")}
    )
    protected void splatter$playSoundsForBlueInkskinsOnInkedWater(BlockPos pos, BlockState state, CallbackInfo ci) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerBlueInklingComponent) SplatterComponents.BLUE_INKLING.get(player)).isInkling() && !state.getFluidState().isEmpty()) {
                BlockState blockState = this.world.getBlockState(pos.up());
                BlockSoundGroup blockSoundGroup = blockState.isIn(BlockTags.INSIDE_STEP_SOUND_BLOCKS) ? blockState.getSoundGroup() : state.getSoundGroup();
                this.playSound(blockSoundGroup.getStepSound(), blockSoundGroup.getVolume() * 0.15F, blockSoundGroup.getPitch());
            }
        }
    }

    @Inject(
            method = {"playStepSound"},
            at = {@At("HEAD")}
    )
    protected void splatter$playSoundsForBrownInkskinsOnInkedWater(BlockPos pos, BlockState state, CallbackInfo ci) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerBrownOctolingComponent) SplatterComponents.BROWN_OCTOLING.get(player)).isOctoling() && !state.getFluidState().isEmpty()) {
                BlockState blockState = this.world.getBlockState(pos.up());
                BlockSoundGroup blockSoundGroup = blockState.isIn(BlockTags.INSIDE_STEP_SOUND_BLOCKS) ? blockState.getSoundGroup() : state.getSoundGroup();
                this.playSound(blockSoundGroup.getStepSound(), blockSoundGroup.getVolume() * 0.15F, blockSoundGroup.getPitch());
            }
        }
    }

    @Inject(
            method = {"playStepSound"},
            at = {@At("HEAD")}
    )
    protected void splatter$playSoundsForCyanInkskinsOnInkedWater(BlockPos pos, BlockState state, CallbackInfo ci) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerCyanInklingComponent) SplatterComponents.CYAN_INKLING.get(player)).isInkling() && !state.getFluidState().isEmpty()) {
                BlockState blockState = this.world.getBlockState(pos.up());
                BlockSoundGroup blockSoundGroup = blockState.isIn(BlockTags.INSIDE_STEP_SOUND_BLOCKS) ? blockState.getSoundGroup() : state.getSoundGroup();
                this.playSound(blockSoundGroup.getStepSound(), blockSoundGroup.getVolume() * 0.15F, blockSoundGroup.getPitch());
            }
        }
    }

    @Inject(
            method = {"playStepSound"},
            at = {@At("HEAD")}
    )
    protected void splatter$playSoundsForGrayInkskinsOnInkedWater(BlockPos pos, BlockState state, CallbackInfo ci) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerGrayOctolingComponent) SplatterComponents.GRAY_OCTOLING.get(player)).isOctoling() && !state.getFluidState().isEmpty()) {
                BlockState blockState = this.world.getBlockState(pos.up());
                BlockSoundGroup blockSoundGroup = blockState.isIn(BlockTags.INSIDE_STEP_SOUND_BLOCKS) ? blockState.getSoundGroup() : state.getSoundGroup();
                this.playSound(blockSoundGroup.getStepSound(), blockSoundGroup.getVolume() * 0.15F, blockSoundGroup.getPitch());
            }
        }
    }

    @Inject(
            method = {"playStepSound"},
            at = {@At("HEAD")}
    )
    protected void splatter$playSoundsForGreenInkskinsOnInkedWater(BlockPos pos, BlockState state, CallbackInfo ci) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerGreenInklingComponent) SplatterComponents.GREEN_INKLING.get(player)).isInkling() && !state.getFluidState().isEmpty()) {
                BlockState blockState = this.world.getBlockState(pos.up());
                BlockSoundGroup blockSoundGroup = blockState.isIn(BlockTags.INSIDE_STEP_SOUND_BLOCKS) ? blockState.getSoundGroup() : state.getSoundGroup();
                this.playSound(blockSoundGroup.getStepSound(), blockSoundGroup.getVolume() * 0.15F, blockSoundGroup.getPitch());
            }
        }
    }

    @Inject(
            method = {"playStepSound"},
            at = {@At("HEAD")}
    )
    protected void splatter$playSoundsForLightBlueInkskinsOnInkedWater(BlockPos pos, BlockState state, CallbackInfo ci) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerLightBlueOctolingComponent) SplatterComponents.LIGHT_BLUE_OCTOLING.get(player)).isOctoling() && !state.getFluidState().isEmpty()) {
                BlockState blockState = this.world.getBlockState(pos.up());
                BlockSoundGroup blockSoundGroup = blockState.isIn(BlockTags.INSIDE_STEP_SOUND_BLOCKS) ? blockState.getSoundGroup() : state.getSoundGroup();
                this.playSound(blockSoundGroup.getStepSound(), blockSoundGroup.getVolume() * 0.15F, blockSoundGroup.getPitch());
            }
        }
    }

    @Inject(
            method = {"playStepSound"},
            at = {@At("HEAD")}
    )
    protected void splatter$playSoundsForLightGrayInkskinsOnInkedWater(BlockPos pos, BlockState state, CallbackInfo ci) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerLightGrayOctolingComponent) SplatterComponents.LIGHT_GRAY_OCTOLING.get(player)).isOctoling() && !state.getFluidState().isEmpty()) {
                BlockState blockState = this.world.getBlockState(pos.up());
                BlockSoundGroup blockSoundGroup = blockState.isIn(BlockTags.INSIDE_STEP_SOUND_BLOCKS) ? blockState.getSoundGroup() : state.getSoundGroup();
                this.playSound(blockSoundGroup.getStepSound(), blockSoundGroup.getVolume() * 0.15F, blockSoundGroup.getPitch());
            }
        }
    }

    @Inject(
            method = {"playStepSound"},
            at = {@At("HEAD")}
    )
    protected void splatter$playSoundsForLimeInkskinsOnInkedWater(BlockPos pos, BlockState state, CallbackInfo ci) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerLimeInklingComponent) SplatterComponents.LIME_INKLING.get(player)).isInkling() && !state.getFluidState().isEmpty()) {
                BlockState blockState = this.world.getBlockState(pos.up());
                BlockSoundGroup blockSoundGroup = blockState.isIn(BlockTags.INSIDE_STEP_SOUND_BLOCKS) ? blockState.getSoundGroup() : state.getSoundGroup();
                this.playSound(blockSoundGroup.getStepSound(), blockSoundGroup.getVolume() * 0.15F, blockSoundGroup.getPitch());
            }
        }
    }

    @Inject(
            method = {"playStepSound"},
            at = {@At("HEAD")}
    )
    protected void splatter$playSoundsForMagentaInkskinsOnInkedWater(BlockPos pos, BlockState state, CallbackInfo ci) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerMagentaOctolingComponent) SplatterComponents.MAGENTA_OCTOLING.get(player)).isOctoling() && !state.getFluidState().isEmpty()) {
                BlockState blockState = this.world.getBlockState(pos.up());
                BlockSoundGroup blockSoundGroup = blockState.isIn(BlockTags.INSIDE_STEP_SOUND_BLOCKS) ? blockState.getSoundGroup() : state.getSoundGroup();
                this.playSound(blockSoundGroup.getStepSound(), blockSoundGroup.getVolume() * 0.15F, blockSoundGroup.getPitch());
            }
        }
    }

    @Inject(
            method = {"playStepSound"},
            at = {@At("HEAD")}
    )
    protected void splatter$playSoundsForOrangeInkskinsOnInkedWater(BlockPos pos, BlockState state, CallbackInfo ci) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerOrangeInklingComponent) SplatterComponents.ORANGE_INKLING.get(player)).isInkling() && !state.getFluidState().isEmpty()) {
                BlockState blockState = this.world.getBlockState(pos.up());
                BlockSoundGroup blockSoundGroup = blockState.isIn(BlockTags.INSIDE_STEP_SOUND_BLOCKS) ? blockState.getSoundGroup() : state.getSoundGroup();
                this.playSound(blockSoundGroup.getStepSound(), blockSoundGroup.getVolume() * 0.15F, blockSoundGroup.getPitch());
            }
        }
    }

    @Inject(
            method = {"playStepSound"},
            at = {@At("HEAD")}
    )
    protected void splatter$playSoundsForPinkInkskinsOnInkedWater(BlockPos pos, BlockState state, CallbackInfo ci) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerPinkInklingComponent) SplatterComponents.PINK_INKLING.get(player)).isInkling() && !state.getFluidState().isEmpty()) {
                BlockState blockState = this.world.getBlockState(pos.up());
                BlockSoundGroup blockSoundGroup = blockState.isIn(BlockTags.INSIDE_STEP_SOUND_BLOCKS) ? blockState.getSoundGroup() : state.getSoundGroup();
                this.playSound(blockSoundGroup.getStepSound(), blockSoundGroup.getVolume() * 0.15F, blockSoundGroup.getPitch());
            }
        }
    }

    @Inject(
            method = {"playStepSound"},
            at = {@At("HEAD")}
    )
    protected void splatter$playSoundsForPurpleInkskinsOnInkedWater(BlockPos pos, BlockState state, CallbackInfo ci) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerPurpleInklingComponent) SplatterComponents.PURPLE_INKLING.get(player)).isInkling() && !state.getFluidState().isEmpty()) {
                BlockState blockState = this.world.getBlockState(pos.up());
                BlockSoundGroup blockSoundGroup = blockState.isIn(BlockTags.INSIDE_STEP_SOUND_BLOCKS) ? blockState.getSoundGroup() : state.getSoundGroup();
                this.playSound(blockSoundGroup.getStepSound(), blockSoundGroup.getVolume() * 0.15F, blockSoundGroup.getPitch());
            }
        }
    }

    @Inject(
            method = {"playStepSound"},
            at = {@At("HEAD")}
    )
    protected void splatter$playSoundsForRedInkskinsOnInkedWater(BlockPos pos, BlockState state, CallbackInfo ci) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerRedOctolingComponent) SplatterComponents.RED_OCTOLING.get(player)).isOctoling() && !state.getFluidState().isEmpty()) {
                BlockState blockState = this.world.getBlockState(pos.up());
                BlockSoundGroup blockSoundGroup = blockState.isIn(BlockTags.INSIDE_STEP_SOUND_BLOCKS) ? blockState.getSoundGroup() : state.getSoundGroup();
                this.playSound(blockSoundGroup.getStepSound(), blockSoundGroup.getVolume() * 0.15F, blockSoundGroup.getPitch());
            }
        }
    }

    @Inject(
            method = {"playStepSound"},
            at = {@At("HEAD")}
    )
    protected void splatter$playSoundsForWhiteInkskinsOnInkedWater(BlockPos pos, BlockState state, CallbackInfo ci) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerWhiteOctolingComponent) SplatterComponents.WHITE_OCTOLING.get(player)).isOctoling() && !state.getFluidState().isEmpty()) {
                BlockState blockState = this.world.getBlockState(pos.up());
                BlockSoundGroup blockSoundGroup = blockState.isIn(BlockTags.INSIDE_STEP_SOUND_BLOCKS) ? blockState.getSoundGroup() : state.getSoundGroup();
                this.playSound(blockSoundGroup.getStepSound(), blockSoundGroup.getVolume() * 0.15F, blockSoundGroup.getPitch());
            }
        }
    }

    @Inject(
            method = {"playStepSound"},
            at = {@At("HEAD")}
    )
    protected void splatter$playSoundsForYellowInkskinsOnInkedWater(BlockPos pos, BlockState state, CallbackInfo ci) {
        if (this.getControllingPassenger() instanceof PlayerEntity player) {
            if (((PlayerYellowInklingComponent) SplatterComponents.YELLOW_INKLING.get(player)).isInkling() && !state.getFluidState().isEmpty()) {
                BlockState blockState = this.world.getBlockState(pos.up());
                BlockSoundGroup blockSoundGroup = blockState.isIn(BlockTags.INSIDE_STEP_SOUND_BLOCKS) ? blockState.getSoundGroup() : state.getSoundGroup();
                this.playSound(blockSoundGroup.getStepSound(), blockSoundGroup.getVolume() * 0.15F, blockSoundGroup.getPitch());
            }
        }
    }
}