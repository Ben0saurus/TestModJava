package me.benosaurus.testmodjava.block;

import me.benosaurus.testmodjava.TestModJava;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class ModBlocks {

    public static final Block TEKNO_BLOCK = registerBlock("tekno_block",
            new Block(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(TestModJava.MOD_ID, "tekno_block")))
                    .strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.MUD)
                    .slipperiness(6f)) {

                @Override
                public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
                    if (random.nextInt(1) == 0) {
                        double x = pos.getX() + random.nextDouble();
                        double y = pos.getY() + 1.1;
                        double z = pos.getZ() + random.nextDouble();

                        world.addParticleClient(ParticleTypes.SMOKE, x, y, z, 0.0, 0.05, 0.0);
                    }
                }
            });


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TestModJava.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TestModJava.MOD_ID, name),
                new BlockItem(block, new Item.Settings()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TestModJava.MOD_ID, name)))
                        .useBlockPrefixedTranslationKey()));
    }

    public static void registerModBlocks() {
        TestModJava.LOGGER.info("Registering Mod Blocks for " + TestModJava.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(TEKNO_BLOCK);
        });
    }
}