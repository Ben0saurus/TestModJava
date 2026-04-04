package me.benosaurus.testmodjava.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public class BoostItem extends Item {

    public int cooldownTicks = 40;


    public BoostItem(Settings settings) {
        super(settings);
    }


    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {

        ItemStack stack = user.getStackInHand(hand);
        BlockPos pos = user.getBlockPos();

        if (user.getItemCooldownManager().isCoolingDown(stack)) {
            return ActionResult.FAIL;
        }

        Vec3d direction = user.getRotationVector();
        user.addVelocity(direction.getX() * 2, direction.getY() * 2, direction.getZ() * 2);
        user.velocityDirty = true;

        world.playSound(user, pos, SoundEvents.ENTITY_BREEZE_JUMP, SoundCategory.PLAYERS);

        user.getItemCooldownManager().set(Registries.ITEM.getId(this), cooldownTicks);

        return ActionResult.SUCCESS;
    }

}