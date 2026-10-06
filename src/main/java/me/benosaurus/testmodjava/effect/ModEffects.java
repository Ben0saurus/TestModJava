package me.benosaurus.testmodjava.effect;

import me.benosaurus.testmodjava.TestModJava;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> VAMPIRE = registerStatusEffect("vampire", new VampireEffect(StatusEffectCategory.HARMFUL, 0x0B0A07)
            .addAttributeModifier(EntityAttributes.MOVEMENT_SPEED, Identifier.of(TestModJava.MOD_ID, "vampire"), -0.25f,
            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(TestModJava.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        TestModJava.LOGGER.info("Registering Mod Effects for " + TestModJava.MOD_ID);
    }

}
