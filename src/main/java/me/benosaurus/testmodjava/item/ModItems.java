package me.benosaurus.testmodjava.item;

import me.benosaurus.testmodjava.TestModJava;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item CUCUMBER = registerItem("cucumber",new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TestModJava.MOD_ID,"cucumber")))));
    public static final Item TEKNO = registerItem("tekno",new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TestModJava.MOD_ID,"tekno")))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TestModJava.MOD_ID, name), item);
    }


    public static void registerModItems() {
        TestModJava.LOGGER.info("Registering Mod Items for " + TestModJava.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(CUCUMBER);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(TEKNO);
        });
    }

}
