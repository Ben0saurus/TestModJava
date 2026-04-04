package me.benosaurus.testmodjava.datagen;

import me.benosaurus.testmodjava.block.ModBlocks;
import me.benosaurus.testmodjava.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
            blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TEKNO_BLOCK);
            blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPAWNER_BLOCK);
            blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SNITCHING_BLOCK);
            blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COUNTER_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
            itemModelGenerator.register(ModItems.CUCUMBER, Models.GENERATED);
            itemModelGenerator.register(ModItems.DISC, Models.GENERATED);
            itemModelGenerator.register(ModItems.TEKNO, Models.GENERATED);
            itemModelGenerator.register(ModItems.ICE_STAFF, Models.GENERATED);
            itemModelGenerator.register(ModItems.BOOST_ITEM, Models.GENERATED);
    }
}
