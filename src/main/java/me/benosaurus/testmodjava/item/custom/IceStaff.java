package me.benosaurus.testmodjava.item.custom;

import me.benosaurus.testmodjava.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class IceStaff extends Item {
    private static final Map<UUID, Boolean> playerStates = new HashMap<>();
    private static boolean tickRegistered = false;

    public IceStaff(Settings settings) {
        super(settings);
        registerTickEvent();
    }

    private static void registerTickEvent() {
        if (tickRegistered) return;
        tickRegistered = true;

        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                boolean holdingItem = player.getMainHandStack().getItem() == ModItems.ICE_STAFF
                        || player.getOffHandStack().getItem() == ModItems.ICE_STAFF;

                if (holdingItem && isEnabledFor(player)) {
                    doIceEffect(player);
                }
            }
        });
    }

    private static void doIceEffect(ServerPlayerEntity player) {
        BlockPos playerPos = player.getBlockPos();
        int radius = 3;

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                BlockPos targetPos = playerPos.add(x, -1, z);
                
                if (!player.getEntityWorld().getBlockState(targetPos).isAir()) {
                    player.getEntityWorld().setBlockState(targetPos, Blocks.ICE.getDefaultState());
                }
            }
        }
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient()) return ActionResult.SUCCESS;  // Skip client!

        UUID playerId = user.getUuid();
        boolean isEnabled = playerStates.getOrDefault(playerId, false);
        isEnabled = !isEnabled;
        playerStates.put(playerId, isEnabled);

        user.sendMessage(Text.literal("Ice mode enabled: " + isEnabled), true);
        System.out.println("Ice mode enabled: " + isEnabled);

        return ActionResult.SUCCESS;
    }

    public static boolean isEnabledFor(PlayerEntity player) {
        return playerStates.getOrDefault(player.getUuid(), false);
    }
}