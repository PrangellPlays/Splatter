package dev.prangellplays.splatter.item.inktotem;

import dev.prangellplays.splatter.init.SplatterParticles;
import dev.prangellplays.splatter.init.SplatterStatusEffects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.Perspective;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class InkTotemGreenItem extends Item {
    public InkTotemGreenItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!user.hasStatusEffect(SplatterStatusEffects.GREEN_INKSKIN)) {
            user.addStatusEffect(new StatusEffectInstance(SplatterStatusEffects.GREEN_INKSKIN, 24000, 0, false, false));
            MinecraftClient.getInstance().options.setPerspective(Perspective.THIRD_PERSON_FRONT);
            assert MinecraftClient.getInstance().player != null;
            ClientWorld clientWorld = (ClientWorld) MinecraftClient.getInstance().player.getWorld();
            for (int i = 0; i < 100; ++i) {
                clientWorld.addParticle(SplatterParticles.GREEN_FALLING_INK, user.getX() + (double) user.getWorld().random.nextFloat() - 0.5, user.getY() + (double) (clientWorld.random.nextFloat() * 1.8F), user.getZ() + (double) clientWorld.random.nextFloat() - 0.5, (double) ((clientWorld.random.nextFloat() - 0.5F) * 0.6F), (double) ((clientWorld.random.nextFloat() - 0.5F) * 0.6F), (double) ((clientWorld.random.nextFloat() - 0.5F) * 0.6F));
            }
            if (!user.isCreative()) {
                user.getStackInHand(user.getActiveHand()).decrement(1);
            }
            world.playSound(user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_TOTEM_USE, SoundCategory.MASTER, 100.0F, 1.0F, false);
            //MinecraftClient.getInstance().gameRenderer.showFloatingItem(this.asItem().getDefaultStack());
        }
        return super.use(world, user, hand);
    }
}
