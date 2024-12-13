package dev.prangellplays.splatter.item.splattershot;

import dev.prangellplays.splatter.entity.splattershot.SplattershotBlackInkEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SplattershotBlackItem extends Item {
    public SplattershotBlackItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.playSound(SoundEvents.ITEM_BOTTLE_EMPTY, 1.0f, (float)(0.5 + user.getRandom().nextGaussian() / 5.0));
        if (!world.isClient) {
            SplattershotBlackInkEntity splattershotBlackInkEntity = new SplattershotBlackInkEntity(world, user);
            splattershotBlackInkEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
            world.spawnEntity(splattershotBlackInkEntity);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }
        return super.use(world, user, hand);
    }
}
