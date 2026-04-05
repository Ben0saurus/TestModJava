package me.benosaurus.testmodjava.block;

import me.benosaurus.testmodjava.TestModJava;
import me.benosaurus.testmodjava.block.blocks.*;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block TEKNO_BLOCK = registerBlock(TeknoBlock.NAME, new TeknoBlock());
    public static final Block SPAWNER_BLOCK = registerBlock(SpawnerBlock.NAME, new SpawnerBlock());
    public static final Block COUNTER_BLOCK = registerBlock(CounterBlock.NAME, new CounterBlock());
    public static final Block XP_BANK_BLOCK = registerBlock(XPBankBlock.NAME, new XPBankBlock());
    public static final Block SNITCHING_BLOCK = registerSnitchingBlock();

    private static Block registerBlock(String name, Block block) {
        Identifier id = Identifier.of(TestModJava.MOD_ID, name);

        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id);
        BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey).useBlockPrefixedTranslationKey());
        Registry.register(Registries.ITEM, id, blockItem);

        return Registry.register(Registries.BLOCK, id, block);
    }

    private static Block registerSnitchingBlock() {
        String name = SnitchingBlock.NAME;
        Identifier id = Identifier.of(TestModJava.MOD_ID, name);

        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, id);
        AbstractBlock.Settings settings = AbstractBlock.Settings.create().strength(1.0f).registryKey(blockKey);
        Block block = new SnitchingBlock(settings);

        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id);
        BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey).useBlockPrefixedTranslationKey());
        Registry.register(Registries.ITEM, id, blockItem);

        return Registry.register(Registries.BLOCK, id, block);
    }

    public static void registerModBlocks() {
        TestModJava.LOGGER.info("Registering Mod Blocks for " + TestModJava.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(TEKNO_BLOCK);
            entries.add(COUNTER_BLOCK);
            entries.add(SNITCHING_BLOCK);
            entries.add(SPAWNER_BLOCK);
        });
    }
}