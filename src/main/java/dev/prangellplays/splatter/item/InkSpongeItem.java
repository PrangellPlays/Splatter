package dev.prangellplays.splatter.item;

import dev.prangellplays.splatter.init.SplatterTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

import java.util.Iterator;
import java.util.List;

public class InkSpongeItem extends Item {
    public InkSpongeItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getWorld().getBlockState(context.getBlockPos()).isIn(SplatterTags.INK)) {
            int power = 3;
            List<BlockPos> offsets = BlockPos.stream(-power, -power, -power, power, power, power).map(BlockPos::toImmutable).toList();
            Iterator var4 = offsets.iterator();

            while(var4.hasNext()) {
                BlockPos offset = (BlockPos)var4.next();
                double distance = (double)power + context.getWorld().getRandom().nextDouble() * 1.0;
                if (offset.getSquaredDistance(0.0, 0.0, 0.0) <= distance * distance) {
                    BlockPos targetPos = context.getBlockPos().add(offset);
                    if (context.getWorld().getBlockState(targetPos).isIn(SplatterTags.INK)) {
                        context.getWorld().breakBlock(targetPos, false);
                    }
                }
            }
        }
        return super.useOnBlock(context);
    }
}
