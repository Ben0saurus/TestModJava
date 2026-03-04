package me.benosaurus.testmodjava.item;

import me.benosaurus.testmodjava.TestModJava;
import me.benosaurus.testmodjava.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static ItemGroup TEST_MOD_JAVA_ITEMS_GROUP   = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TestModJava.MOD_ID, "testmodjava_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.CUCUMBER))
                    .displayName(Text.translatable("itemgroup.testmodjava.testmodjava_items"))
                    .entries((displayContext, entries) ->  {

                        entries.add(ModItems.DISC);
                        entries.add(ModItems.CUCUMBER);
                        entries.add(ModItems.TEKNO);

                    }).build());

    public static ItemGroup TEST_MOD_JAVA_BLOCKS_GROUP   = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TestModJava.MOD_ID, "testmodjava_blocks"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.TEKNO_BLOCK))
                    .displayName(Text.translatable("itemgroup.testmodjava.testmodjava_blocks"))
                    .entries((displayContext, entries) ->  {

                        entries.add(ModBlocks.TEKNO_BLOCK);

                    }).build());


    public static void registerItemGroups() {
        TestModJava.LOGGER.info("Registering item groups for " + TestModJava.MOD_ID);
    }

}