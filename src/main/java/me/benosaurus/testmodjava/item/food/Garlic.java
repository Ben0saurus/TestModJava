package me.benosaurus.testmodjava.item.food;

import me.benosaurus.testmodjava.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;


public class Garlic extends Item {

    public Garlic(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {


        if (!world.isClient() && world instanceof  ServerWorld serverWorld) {

            if (user.getEntity().hasStatusEffect(ModEffects.VAMPIRE)) {
                user.damage(serverWorld, world.getDamageSources().genericKill(), 999999999);
            }

        }

        return super.finishUsing(stack, world, user);

    }

}