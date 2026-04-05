package me.benosaurus.testmodjava.block;

import me.benosaurus.testmodjava.TestModJava;
import me.benosaurus.testmodjava.block.blockEntities.CounterBlockEntity;
import me.benosaurus.testmodjava.block.blockEntities.SnitchingBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    public static BlockEntityType<CounterBlockEntity> COUNTER_BLOCK_ENTITY;
    public static BlockEntityType<SnitchingBlockEntity> SNITCHING_BLOCK_ENTITY;
    public static BlockEntityType<SnitchingBlockEntity> XP_BANK_BLOCK_ENTITY;

    public static void registerBlockEntities() {
        COUNTER_BLOCK_ENTITY = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                Identifier.of(TestModJava.MOD_ID, "counter_block_entity"),
                FabricBlockEntityTypeBuilder.create(CounterBlockEntity::new, ModBlocks.COUNTER_BLOCK).build()
        );

        SNITCHING_BLOCK_ENTITY = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                Identifier.of(TestModJava.MOD_ID, "snitching_block_entity"),
                FabricBlockEntityTypeBuilder.create(SnitchingBlockEntity::new, ModBlocks.SNITCHING_BLOCK).build()
        );

        XP_BANK_BLOCK_ENTITY = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                Identifier.of(TestModJava.MOD_ID, "xp_bank_block_entity"),
                FabricBlockEntityTypeBuilder.create(SnitchingBlockEntity::new, ModBlocks.XP_BANK_BLOCK).build()
        );
    }
}