package me.benosaurus.testmodjava.item;

import me.benosaurus.testmodjava.TestModJava;
import me.benosaurus.testmodjava.item.custom.BoostItem;
import me.benosaurus.testmodjava.item.custom.IceStaff;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static FoodComponent tekno = new FoodComponent(2, 0.3f, true);

    public static final Item ICE_STAFF = registerItem("ice_staff", new IceStaff(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TestModJava.MOD_ID,"ice_staff")))));
    public static final Item BOOST_ITEM = registerItem("boost_item", new BoostItem(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TestModJava.MOD_ID,"boost_item")))));

    public static final Item CUCUMBER = registerItem("cucumber",new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TestModJava.MOD_ID,"cucumber")))));
    public static final Item DISC = registerItem("disc",new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TestModJava.MOD_ID,"disc")))));
    public static final Item TEKNO = registerItem("tekno",new Item(new Item.Settings().food(tekno)
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
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(DISC);
        });

        //FUEL
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(CUCUMBER, 200);
        });
    }


}
