package dev.prangellplays.splatter.mixin.client.inkskin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Environment(EnvType.CLIENT)
@Mixin({BipedEntityModel.class})
public interface BipedEntityModelAccessor {
    @Invoker("getHeadParts")
    Iterable<ModelPart> splatter$getHeadParts();

    @Invoker("getBodyParts")
    Iterable<ModelPart> splatter$getBodyParts();
}