package me.benosaurus.testmodjava.effect;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class VampireEffect extends StatusEffect {
    public VampireEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        BlockPos pos = entity.getBlockPos();
        ItemStack head = entity.getEquippedStack(EquipmentSlot.HEAD);

        boolean sunHits = world.isDay() && !world.isRaining() && world.isSkyVisible(pos);
        boolean isWearingHelmet = !head.isEmpty();

        if (sunHits) {
            if (!isWearingHelmet) {
                if (!entity.isOnFire()) {
                    entity.setOnFireFor(8);
                }
            } else {

                if (head.isDamageable()) {
                    if (world.getTime() % 20 == 0) {
                        head.damage(1, world, entity instanceof ServerPlayerEntity player ? player : null, item -> {
                            entity.sendEquipmentBreakStatus(head.getItem(), EquipmentSlot.HEAD);
                        });
                    }
                }
            }
        }

        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
