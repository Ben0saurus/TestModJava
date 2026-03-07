package me.benosaurus.testmodjava;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;

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

        addBlockEffect(player, block, Blocks.GRASS_BLOCK, StatusEffects.SPEED, 2);
        addBlockEffect(player, block, Blocks.STONE, StatusEffects.BLINDNESS, 0);
        addBlockEffect(player, block, Blocks.SLIME_BLOCK, StatusEffects.GLOWING, 0);
    }

    private static void addBlockEffect(ServerPlayerEntity player, Block block, Block targetBlock,
                                       RegistryEntry<StatusEffect> statusEffect, int amplifier) {
        if (block == targetBlock) {
            if (!player.hasStatusEffect(statusEffect)) {
                player.addStatusEffect(new StatusEffectInstance(statusEffect, 60, amplifier));
            }
        } else {
            player.removeStatusEffect(statusEffect);
        }
    }

}
