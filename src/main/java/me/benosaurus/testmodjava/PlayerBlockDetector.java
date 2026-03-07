package me.benosaurus.testmodjava;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;

public class PlayerBlockDetector{

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                checkPlayerBlock(player);
            }
        });
    }

    private static void checkPlayerBlock(ServerPlayerEntity player) {
        BlockPos playerPos = player.getBlockPos();
        BlockPos blockBelow = playerPos.down();
        Block block = player.getEntityWorld().getBlockState(blockBelow).getBlock();

        if (block == Blocks.GRASS_BLOCK) {
            if (!player.hasStatusEffect(StatusEffects.SPEED)) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 60, 2));
            }
        } else {
            player.removeStatusEffect(StatusEffects.SPEED);
        }

        if (block == Blocks.STONE) {
            if (!player.hasStatusEffect(StatusEffects.BLINDNESS)) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 60));
            }
        } else {
            player.removeStatusEffect(StatusEffects.BLINDNESS);
        }
    }

}
