package me.benosaurus.testmodjava.entity;

import me.benosaurus.testmodjava.TestModJava;
import me.benosaurus.testmodjava.entity.custom.JulyEntity;
import me.benosaurus.testmodjava.entity.custom.OllieEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<JulyEntity> JULY = Registry.register(
            Registries.ENTITY_TYPE,
            RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of(TestModJava.MOD_ID, "july")),
            EntityType.Builder.create(JulyEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.6f, 1.8f)
                    .build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of(TestModJava.MOD_ID, "july")))
    );
    public static final EntityType<OllieEntity> OLLIE = Registry.register(
            Registries.ENTITY_TYPE,
            RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of(TestModJava.MOD_ID, "ollie")),
            EntityType.Builder.create(OllieEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.6f, 1.8f)
                    .build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of(TestModJava.MOD_ID, "ollie")))
    );

    public static void registerModEntities() {
        TestModJava.LOGGER.info("Registering Mod Entities for " + TestModJava.MOD_ID);
    }

}
