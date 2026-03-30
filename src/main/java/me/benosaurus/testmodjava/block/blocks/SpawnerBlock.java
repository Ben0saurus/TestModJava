package me.benosaurus.testmodjava.block.blocks;

import me.benosaurus.testmodjava.TestModJava;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.passive.SalmonEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class SpawnerBlock extends Block {

    public static final String NAME = "spawner_block";

    public SpawnerBlock() {
        super(AbstractBlock.Settings.create()
                .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(TestModJava.MOD_ID, NAME)))
                .strength(2f)
                .requiresTool()
                .sounds(BlockSoundGroup.MUD)
                .slipperiness(1.1f));
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        world.scheduleBlockTick(pos, this, 1);
    }


    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {


        EnderDragonEntity enderDragon = new EnderDragonEntity(EntityType.ENDER_DRAGON, world);

        int coordX = random.nextInt(5) + 1;
        int coordY = random.nextInt(5) + 1;
        int coordZ = random.nextInt(5) + 1;

        enderDragon.refreshPositionAndAngles(
                pos.getX() + coordX,
                pos.getY() + coordY,
                pos.getZ() + coordZ,
                0, 0
        );

        world.spawnEntity(enderDragon);

        if (world.getServer() != null) {
            world.getServer().getPlayerManager().broadcast(
                    Text.literal("An " + enderDragon.getName().getString() + " has been spawned at " + enderDragon.getBlockPos().toShortString()),
                    false
            );
        }
        
        world.scheduleBlockTick(pos, this, 50);
    }
}

