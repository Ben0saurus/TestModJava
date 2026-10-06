package me.benosaurus.testmodjava.potion;

import me.benosaurus.testmodjava.TestModJava;
import me.benosaurus.testmodjava.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {

    public static final RegistryEntry<Potion> VAMPIRE_POTION = registerPotion("vampire_potion",
            new Potion("vampire", new StatusEffectInstance(ModEffects.VAMPIRE, StatusEffectInstance.INFINITE, 0)));


    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(TestModJava.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        TestModJava.LOGGER.info("Registering Potions for " + TestModJava.MOD_ID);
    }

}
