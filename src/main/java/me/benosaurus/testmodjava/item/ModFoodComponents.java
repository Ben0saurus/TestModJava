package me.benosaurus.testmodjava.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {

    public static final FoodComponent GARLIC = new FoodComponent.Builder().nutrition(1).alwaysEdible().saturationModifier(0.25f).build();


}
