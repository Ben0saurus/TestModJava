package me.benosaurus.testmodjava.block.blocks;

import me.benosaurus.testmodjava.TestModJava;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class TeknoBlock extends Block {

    public static final String NAME = "tekno_block";

    public TeknoBlock() {
        super(AbstractBlock.Settings.create()
                .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(TestModJava.MOD_ID, NAME)))
                .strength(2f)
                .requiresTool()
                .sounds(BlockSoundGroup.MUD)
                .slipperiness(1.1f));
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double x = pos.getX() + random.nextDouble();
        double y = pos.getY() + 1.1;
        double z = pos.getZ() + random.nextDouble();
        world.addParticleClient(ParticleTypes.SMOKE, x, y, z, 0.0, 0.05, 0.0);
    }
}